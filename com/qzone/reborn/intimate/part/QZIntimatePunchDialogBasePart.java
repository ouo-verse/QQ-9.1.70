package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceMainFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Button;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.sdk.util.UinConfigManager;
import ij.QZIntimateCheckInInfoBean;
import ij.QZIntimatePicSharePreviewBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pj.h;
import t7.h;

@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\b&\u0018\u0000 \u00de\u00012\u00020\u0001:\u0002\u00df\u0001B\t\u00a2\u0006\u0006\b\u00dc\u0001\u0010\u00dd\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020\u0002H\u0014J\u0012\u0010/\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u0002H&J\b\u00101\u001a\u00020\u0002H\u0004J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0007H\u0014J\b\u00104\u001a\u00020\u0002H\u0014J\u0016\u00105\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0014J\b\u00106\u001a\u00020\u0002H&J\b\u00107\u001a\u00020\u0007H&J\b\u00108\u001a\u00020'H\u0014J\u0018\u0010=\u001a\u00020<2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0004J\b\u0010>\u001a\u00020\u0002H\u0014J\u0010\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?H\u0004J\b\u0010B\u001a\u00020'H\u0014J\u001a\u0010F\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010'H\u0014J\n\u0010G\u001a\u0004\u0018\u00010)H\u0014J\b\u0010H\u001a\u00020\u0007H\u0014J\b\u0010J\u001a\u00020IH&J\b\u0010K\u001a\u000209H\u0004J\u0014\u0010N\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020M0LH\u0004R$\u0010V\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010^\u001a\u00020W8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010n\u001a\u00020g8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010u\u001a\u00020)8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010iR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010zR&\u0010\u0083\u0001\u001a\u00020|8\u0004@\u0004X\u0084.\u00a2\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0087\u0001\u001a\u00020|8\u0004@\u0004X\u0084.\u00a2\u0006\u0017\n\u0005\b\u0084\u0001\u0010~\u001a\u0006\b\u0085\u0001\u0010\u0080\u0001\"\u0006\b\u0086\u0001\u0010\u0082\u0001R\u001a\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008d\u0001\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010pR\u001a\u0010\u008f\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008a\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u008a\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u008a\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u008a\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u008a\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u008a\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u008a\u0001R\u0018\u0010\u009d\u0001\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010pR\u001a\u0010\u00a1\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R*\u0010\u00a7\u0001\u001a\u00030\u009e\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00a2\u0001\u0010\u00a0\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0018\u0010\u00a9\u0001\u001a\u00020x8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010zR&\u0010\u00ad\u0001\u001a\u00020)8\u0004@\u0004X\u0084.\u00a2\u0006\u0015\n\u0005\b\u00aa\u0001\u0010p\u001a\u0005\b\u00ab\u0001\u0010r\"\u0005\b\u00ac\u0001\u0010tR)\u0010\u00b4\u0001\u001a\u00020?8\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001\"\u0006\b\u00b2\u0001\u0010\u00b3\u0001R,\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b5\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001\"\u0006\b\u00ba\u0001\u0010\u00bb\u0001R,\u0010\u00c4\u0001\u001a\u0005\u0018\u00010\u00bd\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00be\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001\"\u0006\b\u00c2\u0001\u0010\u00c3\u0001R+\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001\"\u0006\b\u00c9\u0001\u0010\u00ca\u0001R)\u0010\u00d2\u0001\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001\"\u0006\b\u00d0\u0001\u0010\u00d1\u0001R)\u0010\u00d5\u0001\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00cd\u0001\u0010\u00cd\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00cf\u0001\"\u0006\b\u00d4\u0001\u0010\u00d1\u0001R)\u0010\u00d9\u0001\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00d6\u0001\u0010\u00cd\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00cf\u0001\"\u0006\b\u00d8\u0001\u0010\u00d1\u0001R\u0019\u0010\u00db\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00cd\u0001\u00a8\u0006\u00e0\u0001"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart;", "Lcom/qzone/reborn/base/k;", "", "wa", "Ma", "Lij/b;", "checkInInfoBean", "", "Ca", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "ra", "qa", UinConfigManager.KEY_HB, "lb", "kb", "fb", "mb", "ib", "nb", "ob", "sb", "ub", "vb", "Oa", "qb", "tb", "pb", "eb", "jb", "S9", "bb", "Na", "ta", "ua", "", "Lcom/tencent/mobileqq/component/qrcode/f;", "aa", "rb", "", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "va", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "R9", "initViewModel", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "pa", "cb", "La", "Q9", "Fa", "U9", "", "basicStartColor", "basicEndColor", "Landroid/graphics/drawable/GradientDrawable;", "Z9", "sa", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "codeView", "N9", "ea", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "filePath", "Ha", "la", "Ga", "Lpj/h$b;", "na", "oa", "", "", "O1", "Lnk/at;", "d", "Lnk/at;", "ba", "()Lnk/at;", "Ua", "(Lnk/at;)V", "mainTabViewModel", "Lnk/b;", "e", "Lnk/b;", "V9", "()Lnk/b;", "Pa", "(Lnk/b;)V", "checkInViewModel", "Lnk/p;", "f", "Lnk/p;", "ha", "()Lnk/p;", "Xa", "(Lnk/p;)V", "settingViewModel", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "W9", "()Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "Qa", "(Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;)V", "contentContainer", "i", "Landroid/view/View;", "X9", "()Landroid/view/View;", "Ra", "(Landroid/view/View;)V", "contentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "punchGradientBg", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "punchPicBg", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "D", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Y9", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Ta", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "firstAvatar", "E", "ga", "Wa", "secondAvatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "intimateSpaceTypeText", "G", "punchCheckInDayLayout", "H", "punchDayTextPrefix", "I", "punchDayNum", "J", "punchDayTextSuffix", "K", "punchContentText", "L", "punchContentTextSource", "M", "punchDateText", "N", "punchTips", "P", "punchBtnGroup", "Lcom/tencent/biz/qui/quibutton/QUIButton;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "supplementarySignBtn", BdhLogUtil.LogTag.Tag_Req, "ia", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "Ya", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "shareBtn", ExifInterface.LATITUDE_SOUTH, "closeBtn", "T", LocaleUtils.L_JAPANESE, "Za", "shareLayout", "U", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "da", "()Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "Va", "(Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;)V", "qRCodeView", "Landroid/app/Dialog;", "V", "Landroid/app/Dialog;", "ca", "()Landroid/app/Dialog;", "setPunchDialog", "(Landroid/app/Dialog;)V", "punchDialog", "Lpj/h;", "W", "Lpj/h;", "ma", "()Lpj/h;", "ab", "(Lpj/h;)V", "sharePreviewHelper", "X", "Lij/b;", "T9", "()Lij/b;", "setCheckInBean", "(Lij/b;)V", "checkInBean", "Y", "Z", "Da", "()Z", "setCalendarDataReady", "(Z)V", "isCalendarDataReady", "Ea", "Sa", "isDialogShown", "a0", "Ba", "setCalendarCardDataInvalid", "isCalendarCardDataInvalid", "b0", "hasRetryForCalendarData", "<init>", "()V", "c0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZIntimatePunchDialogBasePart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView punchPicBg;

    /* renamed from: D, reason: from kotlin metadata */
    protected QZoneUserAvatarView firstAvatar;

    /* renamed from: E, reason: from kotlin metadata */
    protected QZoneUserAvatarView secondAvatar;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView intimateSpaceTypeText;

    /* renamed from: G, reason: from kotlin metadata */
    private View punchCheckInDayLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView punchDayTextPrefix;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView punchDayNum;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView punchDayTextSuffix;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView punchContentText;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView punchContentTextSource;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView punchDateText;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView punchTips;

    /* renamed from: P, reason: from kotlin metadata */
    private View punchBtnGroup;

    /* renamed from: Q, reason: from kotlin metadata */
    private QUIButton supplementarySignBtn;

    /* renamed from: R, reason: from kotlin metadata */
    protected QUIButton shareBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: T, reason: from kotlin metadata */
    protected View shareLayout;

    /* renamed from: U, reason: from kotlin metadata */
    protected QUIColorfulQRCodeView qRCodeView;

    /* renamed from: V, reason: from kotlin metadata */
    private Dialog punchDialog;

    /* renamed from: W, reason: from kotlin metadata */
    private pj.h sharePreviewHelper;

    /* renamed from: X, reason: from kotlin metadata */
    private QZIntimateCheckInInfoBean checkInBean;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isCalendarDataReady;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isDialogShown;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isCalendarCardDataInvalid;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean hasRetryForCalendarData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected nk.b checkInViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected nk.p settingViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected RoundCorneredFrameLayout contentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected View contentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout punchGradientBg;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart$b", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.tencent.mobileqq.component.qrcode.a {
        b(List<com.tencent.mobileqq.component.qrcode.f> list) {
            super(list);
        }

        @Override // com.tencent.mobileqq.component.qrcode.a
        public List<Integer> a(int color) {
            int collectionSizeOrDefault;
            List<com.tencent.mobileqq.component.qrcode.f> b16 = b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (com.tencent.mobileqq.component.qrcode.f fVar : b16) {
                vd0.b b17 = vd0.b.b(color);
                arrayList.add(Integer.valueOf(vd0.b.a(b17.d(), b17.c(), b17.e()).i()));
            }
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart$c", "Lt7/h$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "filePath", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements h.a {
        c() {
        }

        @Override // t7.h.a
        public void a(Bitmap bitmap, String filePath) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            QZIntimatePunchDialogBasePart.this.Ha(bitmap, filePath);
            QZIntimatePunchDialogBasePart.this.ab(new pj.h(QZIntimatePunchDialogBasePart.this.getActivity()));
            h.b na5 = QZIntimatePunchDialogBasePart.this.na();
            String spaceId = QZIntimatePunchDialogBasePart.this.V9().getSpaceId();
            QZIntimateCheckInInfoBean checkInBean = QZIntimatePunchDialogBasePart.this.getCheckInBean();
            QZIntimatePicSharePreviewBean qZIntimatePicSharePreviewBean = new QZIntimatePicSharePreviewBean(spaceId, checkInBean != null ? checkInBean.getSpaceType() : 0, bitmap, filePath, 296.0f, 496.0f, QZIntimatePunchDialogBasePart.this.la(), QZIntimatePunchDialogBasePart.this.ea(), QZIntimatePunchDialogBasePart.this.Ga());
            pj.h sharePreviewHelper = QZIntimatePunchDialogBasePart.this.getSharePreviewHelper();
            if (sharePreviewHelper != null) {
                sharePreviewHelper.B(qZIntimatePicSharePreviewBean, na5, QZIntimatePunchDialogBasePart.this.O1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Ca(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (TextUtils.isEmpty(checkInInfoBean.getCalendarContent())) {
            QLog.i("QZIntimatePunchDialogBasePart", 1, "calendar_content is empty");
            return true;
        }
        if (!TextUtils.isEmpty(checkInInfoBean.getCalendarTips())) {
            return false;
        }
        QLog.i("QZIntimatePunchDialogBasePart", 1, "calendar_tips is empty");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(QZIntimatePunchDialogBasePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ta();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(QZIntimatePunchDialogBasePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ua();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QZIntimatePunchDialogBasePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String M9() {
        return com.qzone.reborn.configx.g.f53821a.b().a1() + ("&spaceid=" + V9().getSpaceId()) + "&from=10";
    }

    private final void Ma() {
        VideoReport.setPageId(W9(), "pg_qz_intimate_space_home");
        VideoReport.setPageReportPolicy(W9(), PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(W9(), new fo.a().d("QZIntimatePunchDialogBasePart", O1()));
    }

    private final void Na() {
        String str;
        HashMap hashMap = new HashMap();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean == null || (str = qZIntimateCheckInInfoBean.getCalendarContent()) == null) {
            str = "";
        }
        hashMap.put("literal_text", str);
        QUIButton qUIButton = this.supplementarySignBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            qUIButton = null;
        }
        fo.c.e("em_qz_resign_button", "pg_qz_intimate_space_home", qUIButton, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final QZIntimatePunchDialogBasePart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZIntimatePunchDialogBasePart", 1, "setQRCodeUrl result=" + i3);
        if (i3 != 0) {
            return;
        }
        this$0.ja().setVisibility(0);
        View view = this$0.punchBtnGroup;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchBtnGroup");
            view = null;
        }
        view.setVisibility(8);
        ImageView imageView2 = this$0.closeBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
        this$0.rb();
        this$0.W9().requestLayout();
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.ak
            @Override // java.lang.Runnable
            public final void run() {
                QZIntimatePunchDialogBasePart.P9(QZIntimatePunchDialogBasePart.this);
            }
        }, 100L);
    }

    private final void Oa() {
        String str;
        HashMap hashMap = new HashMap();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean == null || (str = qZIntimateCheckInInfoBean.getCalendarContent()) == null) {
            str = "";
        }
        hashMap.put("literal_text", str);
        QUIButton qUIButton = this.supplementarySignBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            qUIButton = null;
        }
        fo.c.g("em_qz_resign_button", "pg_qz_intimate_space_home", qUIButton, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZIntimatePunchDialogBasePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null && !this$0.getActivity().isDestroyed() && !this$0.getActivity().isFinishing()) {
            t7.h.f435520a.e(this$0.getActivity(), this$0.W9(), 296.0f, 496.0f, new c());
        } else {
            QLog.i("QZIntimatePunchDialogBasePart", 1, "activity is null or finishing");
        }
    }

    private final void S9() {
        String str;
        HashMap hashMap = new HashMap();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean == null || (str = qZIntimateCheckInInfoBean.getCalendarContent()) == null) {
            str = "";
        }
        hashMap.put("literal_text", str);
        fo.c.g("em_qz_punch_day_card", "pg_qz_intimate_space_home", W9(), hashMap);
        fo.c.g(WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, "pg_qz_intimate_space_home", ia(), hashMap);
    }

    private final void bb() {
        String str;
        HashMap hashMap = new HashMap();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean == null || (str = qZIntimateCheckInInfoBean.getCalendarContent()) == null) {
            str = "";
        }
        hashMap.put("literal_text", str);
        fo.c.e(WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, "pg_qz_intimate_space_home", ia(), hashMap);
    }

    private final void eb() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (ArrayUtils.isOutOfArrayIndex(1, qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.i() : null)) {
            return;
        }
        QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
        bVar.f55960b = false;
        QZoneUserAvatarView Y9 = Y9();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
        Intrinsics.checkNotNull(qZIntimateCheckInInfoBean2);
        Y9.setUser(qZIntimateCheckInInfoBean2.i().get(0).longValue(), bVar);
        QZoneUserAvatarView ga5 = ga();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean3 = this.checkInBean;
        Intrinsics.checkNotNull(qZIntimateCheckInInfoBean3);
        ga5.setUser(qZIntimateCheckInInfoBean3.i().get(1).longValue(), bVar);
    }

    private final void fb() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        ImageView imageView = null;
        if (TextUtils.isEmpty(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getCalendarBackgroundUrl() : null)) {
            QLog.i("QZIntimatePunchDialogBasePart", 1, "background url is empty");
            return;
        }
        ImageView imageView2 = this.punchPicBg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        Option obtain = Option.obtain();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
        Option url = obtain.setUrl(qZIntimateCheckInInfoBean2 != null ? qZIntimateCheckInInfoBean2.getCalendarBackgroundUrl() : null);
        ImageView imageView3 = this.punchPicBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
        } else {
            imageView = imageView3;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(url.setTargetView(imageView).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans).setRequestWidth(ef.d.b(296)).setRequestHeight(ef.d.b(com.tencent.luggage.wxa.ig.w.CTRL_INDEX)), new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.part.al
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZIntimatePunchDialogBasePart.gb(QZIntimatePunchDialogBasePart.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout] */
    public static final void gb(QZIntimatePunchDialogBasePart this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = null;
        if (!loadState.isFinishSuccess() && !loadState.isDownloadSuccess()) {
            ImageView imageView2 = this$0.punchPicBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            ?? r56 = this$0.punchGradientBg;
            if (r56 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            } else {
                imageView = r56;
            }
            imageView.setVisibility(0);
            return;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout = this$0.punchGradientBg;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setVisibility(8);
        ImageView imageView3 = this$0.punchPicBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    private final void hb(QZIntimateCheckInInfoBean checkInInfoBean) {
        this.checkInBean = checkInInfoBean;
        lb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [android.view.View] */
    private final void ib() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean != null) {
            long checkInDays = qZIntimateCheckInInfoBean.getCheckInDays();
            TextView textView = null;
            if (checkInDays < 0) {
                ?? r06 = this.punchCheckInDayLayout;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchCheckInDayLayout");
                } else {
                    textView = r06;
                }
                textView.setVisibility(8);
                return;
            }
            View view = this.punchCheckInDayLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchCheckInDayLayout");
                view = null;
            }
            view.setVisibility(0);
            TextView textView2 = this.punchDayNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                textView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (checkInDays == 0) {
                TextView textView3 = this.punchDayTextPrefix;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayTextPrefix");
                    textView3 = null;
                }
                textView3.setText("\u7b49\u5f85\u5bf9\u65b9\u6253\u5361");
                TextView textView4 = this.punchDayNum;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView4 = null;
                }
                textView4.setText("\u6253\u5361\u6210\u529f");
                TextView textView5 = this.punchDayNum;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView5 = null;
                }
                textView5.setTextSize(20.0f);
                layoutParams2.topMargin = ImmersiveUtils.dpToPx(12.0f);
                TextView textView6 = this.punchDayTextSuffix;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayTextSuffix");
                    textView6 = null;
                }
                textView6.setVisibility(8);
            } else {
                TextView textView7 = this.punchDayTextPrefix;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayTextPrefix");
                    textView7 = null;
                }
                textView7.setText("\u4f60\u4eec\u8fde\u7eed\u6253\u5361");
                TextView textView8 = this.punchDayNum;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView8 = null;
                }
                textView8.setText(String.valueOf(checkInDays));
                layoutParams2.topMargin = ImmersiveUtils.dpToPx(2.0f);
                TextView textView9 = this.punchDayNum;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView9 = null;
                }
                textView9.setTextSize(38.0f);
                TextView textView10 = this.punchDayTextSuffix;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayTextSuffix");
                    textView10 = null;
                }
                textView10.setVisibility(0);
            }
            TextView textView11 = this.punchDayNum;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
            } else {
                textView = textView11;
            }
            textView.setLayoutParams(layoutParams2);
        }
    }

    private final void jb() {
        TextView textView = this.punchDateText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchDateText");
            textView = null;
        }
        textView.setText(U9());
    }

    private final void kb() {
        eb();
        fb();
        mb();
        ib();
        nb();
        ob();
        sb();
        ub();
        vb();
        this.isCalendarDataReady = true;
        Q9();
    }

    private final void lb() {
        qb();
        tb();
        pb();
        jb();
        kb();
    }

    private final void mb() {
        TextView textView = this.intimateSpaceTypeText;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intimateSpaceTypeText");
            textView = null;
        }
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (TextUtils.isEmpty(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getSpaceName() : null)) {
            mk.d dVar = mk.d.f416875a;
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
            str = dVar.i(qZIntimateCheckInInfoBean2 != null ? Integer.valueOf(qZIntimateCheckInInfoBean2.getSpaceType()) : null);
        } else {
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean3 = this.checkInBean;
            if (qZIntimateCheckInInfoBean3 != null) {
                str = qZIntimateCheckInInfoBean3.getSpaceName();
            }
        }
        textView.setText(str);
    }

    private final void nb() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (TextUtils.isEmpty(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getCalendarContent() : null)) {
            return;
        }
        TextView textView = this.punchContentText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentText");
            textView = null;
        }
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
        textView.setText(qZIntimateCheckInInfoBean2 != null ? qZIntimateCheckInInfoBean2.getCalendarContent() : null);
    }

    private final void ob() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        TextView textView = null;
        if (TextUtils.isEmpty(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getCalendarContentSource() : null)) {
            TextView textView2 = this.punchContentTextSource;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
            } else {
                textView = textView2;
            }
            textView.setVisibility(4);
            return;
        }
        TextView textView3 = this.punchContentTextSource;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.punchContentTextSource;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
            textView4 = null;
        }
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
        textView4.setText(qZIntimateCheckInInfoBean2 != null ? qZIntimateCheckInInfoBean2.getCalendarContentSource() : null);
    }

    private final void pb() {
        TextView textView = this.punchDayNum;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
            textView = null;
        }
        textView.setTextColor(oa());
    }

    private final void qa() {
        if (this.hasRetryForCalendarData) {
            return;
        }
        QLog.i("QZIntimatePunchDialogBasePart", 1, "retry for calendar card data");
        this.hasRetryForCalendarData = true;
        V9().q2(V9().getSpaceId());
    }

    private final void qb() {
        GradientDrawable Z9 = Z9(ef.a.f396213a.a("#FFFFFF", getActivity().getColor(R.color.qui_common_brand_standard)), oa());
        Z9.setShape(0);
        Z9.setCornerRadius(ef.d.b(8));
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.punchGradientBg;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setBackground(Z9);
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.punchGradientBg;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            roundCorneredFrameLayout2 = null;
        }
        mk.d dVar = mk.d.f416875a;
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        roundCorneredFrameLayout2.setAlpha(dVar.F(qZIntimateCheckInInfoBean != null ? Integer.valueOf(qZIntimateCheckInInfoBean.getSpaceType()) : null) ? 0.5f : 0.15f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(UIStateData<QZIntimateCheckInInfoBean> uiStateData) {
        if (uiStateData.getData() == null) {
            return;
        }
        int state = uiStateData.getState();
        if (state != 2 && state != 3) {
            if (state != 4) {
                return;
            }
            QLog.e("QZIntimatePunchDialogBasePart", 1, "handleCheckInRsp error, recode is " + uiStateData.getRetCode());
            this.isCalendarCardDataInvalid = true;
            La(uiStateData);
            return;
        }
        QZIntimateCheckInInfoBean data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        if (Ca(data)) {
            QLog.e("QZIntimatePunchDialogBasePart", 1, "calendar data is invalid");
            this.isCalendarCardDataInvalid = true;
            La(uiStateData);
        } else {
            this.isCalendarCardDataInvalid = false;
            Ma();
            QZIntimateCheckInInfoBean data2 = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "uiStateData.data");
            hb(data2);
        }
    }

    private final void rb() {
        GradientDrawable Z9 = Z9(ef.a.f396213a.a("#FFFFFF", getActivity().getColor(R.color.qui_common_brand_standard)), oa());
        Z9.setShape(0);
        Z9.setCornerRadius(ef.d.b(0));
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.punchGradientBg;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setBackground(Z9);
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.punchGradientBg;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
            roundCorneredFrameLayout2 = null;
        }
        mk.d dVar = mk.d.f416875a;
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        roundCorneredFrameLayout2.setAlpha(dVar.F(qZIntimateCheckInInfoBean != null ? Integer.valueOf(qZIntimateCheckInInfoBean.getSpaceType()) : null) ? 0.5f : 0.15f);
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        W9().setRadius(ef.d.b(0));
        W9().setBackground(colorDrawable);
    }

    private final void sb() {
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (TextUtils.isEmpty(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getCalendarTips() : null)) {
            return;
        }
        TextView textView = this.punchTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchTips");
            textView = null;
        }
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = this.checkInBean;
        textView.setText(qZIntimateCheckInInfoBean2 != null ? qZIntimateCheckInInfoBean2.getCalendarTips() : null);
    }

    private final void ta() {
        bb();
        N9(da());
    }

    private final void tb() {
        int oa5 = oa();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(oa5);
        gradientDrawable.setCornerRadius(8.0f);
        ia().setBackground(gradientDrawable);
    }

    private final void ua() {
        if (com.qzone.reborn.util.e.b("QZIntimatePunchDialogBasePartHalfScreen", 500L)) {
            return;
        }
        Na();
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        yo.d.d(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getCalendarUrl() : null, getContext(), null);
        Dialog dialog = this.punchDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void ub() {
        GeneralSigninPB$Button shareBtn;
        String str;
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (qZIntimateCheckInInfoBean == null || (shareBtn = qZIntimateCheckInInfoBean.getShareBtn()) == null) {
            return;
        }
        if (TextUtils.isEmpty(shareBtn.text.get())) {
            str = "\u5206\u4eab\u65e5\u7b7e";
        } else {
            str = shareBtn.text.get();
        }
        ia().setText(str);
    }

    private final void vb() {
        QUIButton qUIButton = null;
        if (!Fa()) {
            QUIButton qUIButton2 = this.supplementarySignBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            } else {
                qUIButton = qUIButton2;
            }
            qUIButton.setVisibility(8);
            return;
        }
        Oa();
        QUIButton qUIButton3 = this.supplementarySignBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            qUIButton3 = null;
        }
        qUIButton3.setVisibility(0);
        QUIButton qUIButton4 = this.supplementarySignBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            qUIButton4 = null;
        }
        qUIButton4.setTextColor(oa());
        int color = getContext().getColor(R.color.f158017al3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(8.0f);
        QUIButton qUIButton5 = this.supplementarySignBtn;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
        } else {
            qUIButton = qUIButton5;
        }
        qUIButton.setBackground(gradientDrawable);
    }

    private final void wa() {
        Window window;
        Window window2;
        Window window3;
        ReportDialog reportDialog = new ReportDialog(getContext());
        this.punchDialog = reportDialog;
        reportDialog.setCanceledOnTouchOutside(true);
        Dialog dialog = this.punchDialog;
        if (dialog != null && (window3 = dialog.getWindow()) != null) {
            window3.requestFeature(1);
        }
        Dialog dialog2 = this.punchDialog;
        if (dialog2 != null && (window2 = dialog2.getWindow()) != null) {
            window2.setFlags(1024, 1024);
        }
        Dialog dialog3 = this.punchDialog;
        if (dialog3 == null || (window = dialog3.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Ba, reason: from getter */
    public final boolean getIsCalendarCardDataInvalid() {
        return this.isCalendarCardDataInvalid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Da, reason: from getter */
    public final boolean getIsCalendarDataReady() {
        return this.isCalendarDataReady;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Ea, reason: from getter */
    public final boolean getIsDialogShown() {
        return this.isDialogShown;
    }

    public abstract boolean Fa();

    protected boolean Ga() {
        return false;
    }

    protected void Ha(Bitmap bitmap, String filePath) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    protected void La(UIStateData<QZIntimateCheckInInfoBean> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (Intrinsics.areEqual(uiStateData.getMsg(), "DO_CHECK_IN_FAIL")) {
            qa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N9(QUIColorfulQRCodeView codeView) {
        Intrinsics.checkNotNullParameter(codeView, "codeView");
        X9().setVisibility(4);
        HashMap hashMap = new HashMap();
        hashMap.put(8, new com.tencent.mobileqq.component.qrcode.d(13, 11, 10.0f, 1.0f));
        hashMap.put(9, new com.tencent.mobileqq.component.qrcode.d(14, 12, 10.0f, 1.0f));
        codeView.q();
        codeView.e(false);
        codeView.setIsAdjustDarkLogo(false);
        codeView.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(8, 9, hashMap, ErrorCorrectionLevel.Q));
        codeView.k(-16777216, new b(aa()));
        codeView.g(new com.tencent.mobileqq.component.qrcode.i(R.drawable.f15948m, null, null, 0));
        codeView.f(M9(), new com.tencent.mobileqq.component.qrcode.g() { // from class: com.qzone.reborn.intimate.part.ag
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                QZIntimatePunchDialogBasePart.O9(QZIntimatePunchDialogBasePart.this, i3);
            }
        });
    }

    protected final Map<String, Object> O1() {
        HashMap hashMap = new HashMap();
        if (!(getPartHost() instanceof QZoneIntimateSpaceMainFragment)) {
            return hashMap;
        }
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceMainFragment");
        QZoneIntimateSpaceMainFragment qZoneIntimateSpaceMainFragment = (QZoneIntimateSpaceMainFragment) partHost;
        hashMap.putAll(qZoneIntimateSpaceMainFragment.rh());
        hashMap.putAll(qZoneIntimateSpaceMainFragment.qh());
        return hashMap;
    }

    protected final void Pa(nk.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.checkInViewModel = bVar;
    }

    public abstract void Q9();

    protected final void Qa(RoundCorneredFrameLayout roundCorneredFrameLayout) {
        Intrinsics.checkNotNullParameter(roundCorneredFrameLayout, "<set-?>");
        this.contentContainer = roundCorneredFrameLayout;
    }

    public abstract void R9();

    protected final void Ra(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.contentView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Sa(boolean z16) {
        this.isDialogShown = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T9, reason: from getter */
    public final QZIntimateCheckInInfoBean getCheckInBean() {
        return this.checkInBean;
    }

    protected final void Ta(QZoneUserAvatarView qZoneUserAvatarView) {
        Intrinsics.checkNotNullParameter(qZoneUserAvatarView, "<set-?>");
        this.firstAvatar = qZoneUserAvatarView;
    }

    protected String U9() {
        String format = new SimpleDateFormat("yyyy/MM/dd EEEE", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(currentDate)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ua(nk.at atVar) {
        this.mainTabViewModel = atVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final nk.b V9() {
        nk.b bVar = this.checkInViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
        return null;
    }

    protected final void Va(QUIColorfulQRCodeView qUIColorfulQRCodeView) {
        Intrinsics.checkNotNullParameter(qUIColorfulQRCodeView, "<set-?>");
        this.qRCodeView = qUIColorfulQRCodeView;
    }

    protected final RoundCorneredFrameLayout W9() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.contentContainer;
        if (roundCorneredFrameLayout != null) {
            return roundCorneredFrameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    protected final void Wa(QZoneUserAvatarView qZoneUserAvatarView) {
        Intrinsics.checkNotNullParameter(qZoneUserAvatarView, "<set-?>");
        this.secondAvatar = qZoneUserAvatarView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View X9() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    protected final void Xa(nk.p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<set-?>");
        this.settingViewModel = pVar;
    }

    protected final QZoneUserAvatarView Y9() {
        QZoneUserAvatarView qZoneUserAvatarView = this.firstAvatar;
        if (qZoneUserAvatarView != null) {
            return qZoneUserAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("firstAvatar");
        return null;
    }

    protected final void Ya(QUIButton qUIButton) {
        Intrinsics.checkNotNullParameter(qUIButton, "<set-?>");
        this.shareBtn = qUIButton;
    }

    protected final GradientDrawable Z9(int basicStartColor, int basicEndColor) {
        mk.d dVar = mk.d.f416875a;
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        if (dVar.F(qZIntimateCheckInInfoBean != null ? Integer.valueOf(qZIntimateCheckInInfoBean.getSpaceType()) : null)) {
            ef.a aVar = ef.a.f396213a;
            return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{aVar.a("#FBD9FF", getActivity().getColor(R.color.qui_common_brand_standard)), aVar.a("#D0D9FF", getActivity().getColor(R.color.qui_common_brand_standard)), aVar.a("#E1EBFF", getActivity().getColor(R.color.qui_common_brand_standard)), aVar.a("#FFFFFF", getActivity().getColor(R.color.qui_common_brand_standard))});
        }
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{basicStartColor, basicEndColor});
    }

    protected final void Za(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.shareLayout = view;
    }

    protected final void ab(pj.h hVar) {
        this.sharePreviewHelper = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ba, reason: from getter */
    public final nk.at getMainTabViewModel() {
        return this.mainTabViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ca, reason: from getter */
    public final Dialog getPunchDialog() {
        return this.punchDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cb() {
        Dialog dialog;
        if (this.isDialogShown) {
            QLog.i("QZIntimatePunchDialogBasePart", 1, "dialog has been shown");
            return;
        }
        QLog.i("QZIntimatePunchDialogBasePart", 1, "show dialog");
        this.isDialogShown = true;
        W9().setRadius(ef.d.b(8));
        W9().setVisibility(0);
        W9().setAlpha(1.0f);
        ImageView imageView = this.closeBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView = null;
        }
        imageView.setVisibility(0);
        if (!getActivity().isDestroyed() && !getActivity().isFinishing() && (dialog = this.punchDialog) != null) {
            dialog.show();
        }
        S9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QUIColorfulQRCodeView da() {
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.qRCodeView;
        if (qUIColorfulQRCodeView != null) {
            return qUIColorfulQRCodeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qRCodeView");
        return null;
    }

    protected String ea() {
        return "";
    }

    protected final QZoneUserAvatarView ga() {
        QZoneUserAvatarView qZoneUserAvatarView = this.secondAvatar;
        if (qZoneUserAvatarView != null) {
            return qZoneUserAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secondAvatar");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final nk.p ha() {
        nk.p pVar = this.settingViewModel;
        if (pVar != null) {
            return pVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
        return null;
    }

    protected final QUIButton ia() {
        QUIButton qUIButton = this.shareBtn;
        if (qUIButton != null) {
            return qUIButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
        return null;
    }

    protected final void initViewModel() {
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        ViewModel viewModel = getViewModel(nk.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateC\u2026kInViewModel::class.java)");
        Pa((nk.b) viewModel);
        MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> b26 = V9().b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit> function1 = new Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                if (uIStateData == null) {
                    return;
                }
                QZIntimatePunchDialogBasePart.this.ra(uIStateData);
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimatePunchDialogBasePart.xa(Function1.this, obj);
            }
        });
        ViewModel viewModel2 = getViewModel(nk.p.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZIntimateS\u2026ingViewModel::class.java)");
        Xa((nk.p) viewModel2);
        MutableLiveData<List<QZIntimateSettingItemBean>> P1 = ha().P1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<QZIntimateSettingItemBean>, Unit> function12 = new Function1<List<QZIntimateSettingItemBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<QZIntimateSettingItemBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QZIntimateSettingItemBean> list) {
                Object obj;
                List<QZIntimateSettingItemBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(list, "list");
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (TextUtils.equals("sync_qzone_switch", ((QZIntimateSettingItemBean) obj).getKey())) {
                            break;
                        }
                    }
                }
                QZIntimateSettingItemBean qZIntimateSettingItemBean = (QZIntimateSettingItemBean) obj;
                if (qZIntimateSettingItemBean == null) {
                    return;
                }
                QZIntimatePunchDialogBasePart.this.pa(TextUtils.equals("true", qZIntimateSettingItemBean.getValue()));
            }
        };
        P1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimatePunchDialogBasePart.za(Function1.this, obj);
            }
        });
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.mainTabViewModel = atVar;
        if (atVar == null || (U1 = atVar.U1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function13 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                if (uIStateData.getData() != null && uIStateData.getData().isFromRefreshSpace()) {
                    QZIntimatePunchDialogBasePart.this.V9().q2(QZIntimatePunchDialogBasePart.this.V9().getSpaceId());
                }
            }
        };
        U1.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.intimate.part.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimatePunchDialogBasePart.Aa(Function1.this, obj);
            }
        });
    }

    protected final View ja() {
        View view = this.shareLayout;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        return null;
    }

    protected View la() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ma, reason: from getter */
    public final pj.h getSharePreviewHelper() {
        return this.sharePreviewHelper;
    }

    public abstract h.b na();

    protected final int oa() {
        ef.a aVar = ef.a.f396213a;
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = this.checkInBean;
        return aVar.a(qZIntimateCheckInInfoBean != null ? qZIntimateCheckInInfoBean.getThemeColor() : null, getActivity().getColor(R.color.qui_common_brand_standard));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        wa();
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ckh, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026unch_dialog_layout, null)");
        Ra(inflate);
        View findViewById = X9().findViewById(R.id.f20137k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.content_container)");
        Qa((RoundCorneredFrameLayout) findViewById);
        View findViewById2 = X9().findViewById(R.id.mig);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.punch_gradient_bg)");
        this.punchGradientBg = (RoundCorneredFrameLayout) findViewById2;
        View findViewById3 = X9().findViewById(R.id.mij);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.punch_pic_bg)");
        this.punchPicBg = (ImageView) findViewById3;
        View findViewById4 = X9().findViewById(R.id.nkx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.user_avatar_1)");
        Ta((QZoneUserAvatarView) findViewById4);
        View findViewById5 = X9().findViewById(R.id.nky);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.user_avatar_2)");
        Wa((QZoneUserAvatarView) findViewById5);
        View findViewById6 = X9().findViewById(R.id.kr6);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026intimate_space_type_text)");
        this.intimateSpaceTypeText = (TextView) findViewById6;
        View findViewById7 = X9().findViewById(R.id.mie);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById\u2026h_dialog_day_text_layout)");
        this.punchCheckInDayLayout = findViewById7;
        View findViewById8 = X9().findViewById(R.id.mi_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById\u2026id.punch_day_text_prefix)");
        this.punchDayTextPrefix = (TextView) findViewById8;
        View findViewById9 = X9().findViewById(R.id.mi8);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentView.findViewById(R.id.punch_day_num)");
        this.punchDayNum = (TextView) findViewById9;
        View findViewById10 = X9().findViewById(R.id.mi9);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "contentView.findViewById(R.id.punch_day_suffix)");
        this.punchDayTextSuffix = (TextView) findViewById10;
        View findViewById11 = X9().findViewById(R.id.mih);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "contentView.findViewById(R.id.punch_guide_text)");
        this.punchContentText = (TextView) findViewById11;
        View findViewById12 = X9().findViewById(R.id.mii);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "contentView.findViewById\u2026nch_guide_text_reference)");
        this.punchContentTextSource = (TextView) findViewById12;
        View findViewById13 = X9().findViewById(R.id.mi7);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "contentView.findViewById(R.id.punch_date_text)");
        this.punchDateText = (TextView) findViewById13;
        View findViewById14 = X9().findViewById(R.id.jq7);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "contentView.findViewById(R.id.fortune_guide_text)");
        this.punchTips = (TextView) findViewById14;
        View findViewById15 = X9().findViewById(R.id.mi5);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "contentView.findViewById(R.id.punch_btn_group)");
        this.punchBtnGroup = findViewById15;
        View findViewById16 = X9().findViewById(R.id.nfq);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "contentView.findViewById(R.id.share_btn)");
        Ya((QUIButton) findViewById16);
        View findViewById17 = X9().findViewById(R.id.mi6);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "contentView.findViewById(R.id.punch_close_btn)");
        this.closeBtn = (ImageView) findViewById17;
        View findViewById18 = X9().findViewById(R.id.mlc);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "contentView.findViewById\u2026d.qzm_supplementary_sign)");
        this.supplementarySignBtn = (QUIButton) findViewById18;
        View findViewById19 = X9().findViewById(R.id.mif);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "contentView.findViewById\u2026unch_dialog_share_layout)");
        Za(findViewById19);
        View findViewById20 = X9().findViewById(R.id.mik);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "contentView.findViewById(R.id.punch_qrCode_img)");
        Va((QUIColorfulQRCodeView) findViewById20);
        ia().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimatePunchDialogBasePart.Ia(QZIntimatePunchDialogBasePart.this, view);
            }
        });
        QUIButton qUIButton = this.supplementarySignBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementarySignBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimatePunchDialogBasePart.Ja(QZIntimatePunchDialogBasePart.this, view);
            }
        });
        ImageView imageView = this.closeBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimatePunchDialogBasePart.Ka(QZIntimatePunchDialogBasePart.this, view);
            }
        });
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.punchGradientBg;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchGradientBg");
        } else {
            roundCorneredFrameLayout = roundCorneredFrameLayout2;
        }
        roundCorneredFrameLayout.setRadius(ef.d.b(8));
        W9().setRadius(ef.d.b(8));
        va();
        R9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sa() {
        Dialog dialog = this.punchDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    protected void va() {
        Dialog dialog = this.punchDialog;
        if (dialog != null) {
            dialog.setContentView(X9());
        }
    }

    private final List<com.tencent.mobileqq.component.qrcode.f> aa() {
        List<com.tencent.mobileqq.component.qrcode.f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.component.qrcode.f[]{new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d), new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d), new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d)});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pa(boolean isOpen) {
    }
}
