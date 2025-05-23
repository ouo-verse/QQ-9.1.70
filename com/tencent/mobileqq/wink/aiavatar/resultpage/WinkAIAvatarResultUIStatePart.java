package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aiavatar.resultpage.v;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarCropView;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00c6\u00012\u00020\u0001:\u0004\u00c7\u0001\u00c8\u0001B\t\u00a2\u0006\u0006\b\u00c4\u0001\u0010\u00c5\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JA\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0002J\"\u00101\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u0004H\u0002J0\u00107\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u00104\u001a\u00020\u001b2\n\b\u0002\u00106\u001a\u0004\u0018\u000105H\u0002J\u0012\u00108\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010=\u001a\u00020\u00042\u0006\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010@\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0014J\u0012\u0010F\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0014J\u0010\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u001bH\u0014J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020IH\u0016J\b\u0010K\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020LH\u0016J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020NH\u0016J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020PH\u0016J\u0010\u0010S\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u001bH\u0004J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001bH\u0014J\b\u0010U\u001a\u00020\u0004H\u0014J4\u0010W\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u00104\u001a\u00020\u001b2\u0012\b\u0002\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u0016H\u0004J\u0010\u0010X\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u001bH\u0014J\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u001bH\u0004J\u0012\u0010\\\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R$\u0010g\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010bR$\u0010q\u001a\u0004\u0018\u00010j8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR$\u0010{\u001a\u0004\u0018\u00010r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010t\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010tR\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0080\u0001R\u001a\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010}R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0080\u0001R\u001a\u0010\u008f\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010tR\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010_R\u001a\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010}R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0080\u0001R\u001a\u0010\u0097\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0096\u0001\u0010tR\u001a\u0010\u0099\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0098\u0001\u0010tR,\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001a\u0010\u00a3\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a2\u0001\u0010tR\u001a\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a4\u0001\u0010}R\u001a\u0010\u00a7\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u0010tR\u001a\u0010\u00a9\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010tR\u0019\u0010\u00ac\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u001c\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001c\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001R!\u0010\u00ba\u0001\u001a\u00030\u00b5\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R!\u0010\u00be\u0001\u001a\u00030\u00bb\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ab\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00bc\u0001\u0010\u00bd\u0001R!\u0010\u00c3\u0001\u001a\u00030\u00bf\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c0\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001\u00a8\u0006\u00c9\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultUIStatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "pa", "M9", "view", "", "topDp", "bottomDp", "startDp", "endDp", "N9", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "K9", "L9", "oa", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "cropView", "J9", "Da", "", "", "imagePaths", "xa", "za", "", "select", "Aa", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$m;", "uiState", "la", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$j;", "ha", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$e;", "ba", "ca", "enable", "P9", "na", "O9", "U9", "S9", "T9", "Q9", "Landroid/widget/ImageView;", "", "iconResId", "Ha", "I9", "imagePath", "showOrigin", "Landroid/graphics/RectF;", "faceDetectResult", "va", "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "initViewModel", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "btnStatus", "da", "ea", "success", "Y9", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v;", "ma", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$h;", "ga", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$d;", "aa", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/v$k;", "ia", "show", "Fa", "R9", "H9", "faceDetectResults", "Ba", "Z9", "Ga", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "cropContainer", "e", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "getFirstCropView", "()Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "setFirstCropView", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;)V", "firstCropView", "f", "secondCropView", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", tl.h.F, "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "getGenerateBtn", "()Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "setGenerateBtn", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;)V", "generateBtn", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "generateTipText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getGenerateChanceText", "()Landroid/widget/TextView;", "setGenerateChanceText", "(Landroid/widget/TextView;)V", "generateChanceText", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "regenerateContainer", "D", "Landroid/widget/ImageView;", "regenerateBtn", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recommendStyleRecyclerView", UserInfo.SEX_FEMALE, "regenerateBtnText", "G", "downloadBtn", "H", "shareBtn", "I", "shareBtnIcon", "J", "shareBtnText", "K", "redoContainer", "L", "replaceBtn", "M", "replaceBtnIcon", "N", "replaceBtnText", "P", "otherStyleTitle", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getSyncQZoneCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setSyncQZoneCheckBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "syncQZoneCheckBox", BdhLogUtil.LogTag.Tag_Req, "paitongkuanText", ExifInterface.LATITUDE_SOUTH, "otherStyleContainer", "T", "titleText", "U", "moreRecommendStyleText", "V", "Z", "isBubbleShowed", "Lcom/tencent/mobileqq/wink/view/ai;", "W", "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultUIStatePart$b;", "X", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultUIStatePart$b;", "currentImageData", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/ad;", "Y", "Lkotlin/Lazy;", "X9", "()Lcom/tencent/mobileqq/wink/aiavatar/resultpage/ad;", "uiStateViewModel", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "W9", "()Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "resultViewModel", "Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "a0", "V9", "()Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "generateBtnViewModel", "<init>", "()V", "b0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkAIAvatarResultUIStatePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View regenerateContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView regenerateBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recommendStyleRecyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView regenerateBtnText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView downloadBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View shareBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView shareBtnIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView shareBtnText;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LinearLayout redoContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View replaceBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView replaceBtnIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView replaceBtnText;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView otherStyleTitle;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private QUICheckBox syncQZoneCheckBox;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView paitongkuanText;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private View otherStyleContainer;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private TextView titleText;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private TextView moreRecommendStyleText;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isBubbleShowed;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ai loadingDialog;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private ImageData currentImageData;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiStateViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy generateBtnViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout cropContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAvatarCropView firstCropView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAvatarCropView secondCropView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAIAvatarGenerateBtn generateBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView generateTipText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView generateChanceText;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultUIStatePart$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "imageUrl", "Z", "c", "()Z", "isOrigin", "Landroid/graphics/RectF;", "faceDetectResults", "<init>", "(Ljava/util/List;ZLjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ImageData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<String> imageUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOrigin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<RectF> faceDetectResults;

        /* JADX WARN: Multi-variable type inference failed */
        public ImageData(@Nullable List<String> list, boolean z16, @Nullable List<? extends RectF> list2) {
            this.imageUrl = list;
            this.isOrigin = z16;
            this.faceDetectResults = list2;
        }

        @Nullable
        public final List<RectF> a() {
            return this.faceDetectResults;
        }

        @Nullable
        public final List<String> b() {
            return this.imageUrl;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsOrigin() {
            return this.isOrigin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageData)) {
                return false;
            }
            ImageData imageData = (ImageData) other;
            if (Intrinsics.areEqual(this.imageUrl, imageData.imageUrl) && this.isOrigin == imageData.isOrigin && Intrinsics.areEqual(this.faceDetectResults, imageData.faceDetectResults)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            List<String> list = this.imageUrl;
            int i3 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int i16 = hashCode * 31;
            boolean z16 = this.isOrigin;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            List<RectF> list2 = this.faceDetectResults;
            if (list2 != null) {
                i3 = list2.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "ImageData(imageUrl=" + this.imageUrl + ", isOrigin=" + this.isOrigin + ", faceDetectResults=" + this.faceDetectResults + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultUIStatePart$c", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onAnimationStart", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends Animatable2Compat.AnimationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkAvatarCropView f317788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RectF f317789b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Animatable f317790c;

        c(WinkAvatarCropView winkAvatarCropView, RectF rectF, Animatable animatable) {
            this.f317788a = winkAvatarCropView;
            this.f317789b = rectF;
            this.f317790c = animatable;
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationStart(@Nullable Drawable drawable) {
            Bitmap bitmap$default;
            if (drawable != null && (bitmap$default = DrawableKt.toBitmap$default(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), null, 4, null)) != null) {
                WinkAvatarCropView winkAvatarCropView = this.f317788a;
                RectF rectF = this.f317789b;
                Animatable animatable = this.f317790c;
                WinkAvatarCropView.I0(winkAvatarCropView, bitmap$default, rectF, 0.0f, null, 12, null);
                ((r01.c) animatable).unregisterAnimationCallback(this);
            }
        }
    }

    public WinkAIAvatarResultUIStatePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ad>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$uiStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ad invoke() {
                return (ad) WinkAIAvatarResultUIStatePart.this.getViewModel(ad.class);
            }
        });
        this.uiStateViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarResultViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$resultViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarResultViewModel invoke() {
                return (WinkAIAvatarResultViewModel) WinkAIAvatarResultUIStatePart.this.getViewModel(WinkAIAvatarResultViewModel.class);
            }
        });
        this.resultViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarGenerateBtnViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$generateBtnViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarGenerateBtnViewModel invoke() {
                return (WinkAIAvatarGenerateBtnViewModel) WinkAIAvatarResultUIStatePart.this.getViewModel(WinkAIAvatarGenerateBtnViewModel.class);
            }
        });
        this.generateBtnViewModel = lazy3;
    }

    private final void Aa(WinkAvatarCropView cropView, boolean select) {
        if (cropView != null) {
            cropView.setMaskBorderVisible(select);
        }
        if (cropView != null) {
            cropView.setCheckboxState(Boolean.valueOf(select));
        }
        if (cropView != null) {
            cropView.setCornerMaskVisible(select);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Ca(WinkAIAvatarResultUIStatePart winkAIAvatarResultUIStatePart, List list, boolean z16, List list2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                list2 = null;
            }
            winkAIAvatarResultUIStatePart.Ba(list, z16, list2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAvatarImages");
    }

    private final void Da() {
        if (W9().getIsCoupleAvatar() && !this.isBubbleShowed && getContext() != null) {
            this.isBubbleShowed = true;
            try {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.ac
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAIAvatarResultUIStatePart.Ea(WinkAIAvatarResultUIStatePart.this);
                    }
                }, 500L);
            } catch (Throwable th5) {
                w53.b.c("WinkAIAvatarResultUIStatePart", "showBubbleForCouple: " + th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(WinkAIAvatarResultUIStatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIDefaultBubbleTip.r(this$0.getContext()).o0("\u5206\u4eab\u540e\u5bf9\u65b9\u53ef\u4e00\u952e\u66f4\u6362\u8fd9\u5957\u5934\u50cf\u54e6").S(this$0.shareBtn).g0(false).R(2).k0(1).m0(3).s0();
    }

    private final void Ha(ImageView view, int iconResId, boolean enable) {
        int i3;
        int i16;
        if (je0.a.a(getContext())) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        if (enable) {
            i16 = R.color.qui_common_icon_primary;
        } else {
            i16 = R.color.qui_common_icon_tertiary;
        }
        Drawable o16 = ie0.a.f().o(getContext(), iconResId, i16, i3);
        if (view != null) {
            view.setImageDrawable(o16);
        }
    }

    private final void I9() {
        ViewGroup.LayoutParams layoutParams = null;
        if (!o53.h.A(o53.h.f422138a, null, 1, null) && ImmersiveUtils.dpToPx(325.0f) / ImmersiveUtils.getScreenHeight() > 0.45f) {
            if (!W9().getIsCoupleAvatar()) {
                WinkAvatarCropView winkAvatarCropView = this.firstCropView;
                if (winkAvatarCropView != null) {
                    layoutParams = winkAvatarCropView.getLayoutParams();
                }
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    int screenHeight = (int) (ImmersiveUtils.getScreenHeight() * 0.375f);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    ((ViewGroup.LayoutParams) layoutParams2).width = screenHeight;
                    ((ViewGroup.LayoutParams) layoutParams2).height = screenHeight;
                }
                WinkAvatarCropView winkAvatarCropView2 = this.firstCropView;
                if (winkAvatarCropView2 != null) {
                    winkAvatarCropView2.setLayoutParams(layoutParams);
                }
            }
            N9(this.otherStyleContainer, Float.valueOf(56.0f), null, null, null);
        }
    }

    private final void J9(WinkAvatarCropView cropView) {
        ViewGroup.LayoutParams layoutParams;
        if (cropView != null) {
            layoutParams = cropView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity())) {
            if (layoutParams != null) {
                layoutParams.width = hVar.k(getActivity());
            }
            if (layoutParams != null) {
                layoutParams.height = hVar.l(getActivity());
            }
        } else {
            if (layoutParams != null) {
                layoutParams.width = ImmersiveUtils.dpToPx(178.0f);
            }
            if (layoutParams != null) {
                layoutParams.height = ImmersiveUtils.dpToPx(256.0f);
            }
        }
        if (cropView != null) {
            cropView.setAnchorBarWidth(ViewUtils.dpToPx(0.5f));
        }
        if (cropView != null) {
            cropView.setTopBlankViewHeight(ImmersiveUtils.dpToPx(58.0f));
        }
        if (cropView != null) {
            cropView.setUseBigLoadingView(true);
        }
    }

    private final void K9() {
        if (o53.h.f422138a.z(getActivity())) {
            N9(this.otherStyleContainer, Float.valueOf(56.0f), null, null, null);
        } else if (W9().getIsSchemeJump()) {
            N9(this.otherStyleContainer, Float.valueOf(96.0f), null, null, null);
        } else {
            N9(this.otherStyleContainer, Float.valueOf(93.0f), null, null, null);
        }
    }

    private final void L9() {
        if (o53.h.f422138a.z(getActivity())) {
            N9(this.otherStyleContainer, Float.valueOf(56.0f), null, null, null);
        } else if (W9().getIsSchemeJump()) {
            N9(this.otherStyleContainer, Float.valueOf(62.0f), null, null, null);
        } else {
            N9(this.otherStyleContainer, Float.valueOf(58.0f), null, null, null);
        }
    }

    private final void M9() {
        if (W9().getIsSchemeJump()) {
            TextView textView = this.generateTipText;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (W9().getIsCoupleAvatar()) {
                N9(this.generateTipText, Float.valueOf(10.0f), null, null, null);
                N9(this.generateBtn, Float.valueOf(56.0f), null, null, null);
                K9();
            } else {
                N9(this.generateTipText, Float.valueOf(16.0f), null, null, null);
                N9(this.generateBtn, Float.valueOf(76.0f), null, null, null);
                L9();
            }
        } else {
            TextView textView2 = this.generateTipText;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (W9().getIsCoupleAvatar()) {
                N9(this.redoContainer, Float.valueOf(6.0f), null, null, null);
                N9(this.generateBtn, Float.valueOf(65.0f), null, null, null);
                K9();
            } else {
                N9(this.generateBtn, Float.valueOf(66.0f), null, null, null);
                L9();
            }
        }
        if (W9().getIsCoupleAvatar()) {
            N9(this.recommendStyleRecyclerView, null, null, Float.valueOf(5.0f), Float.valueOf(5.0f));
            N9(this.otherStyleTitle, null, null, Float.valueOf(19.0f), null);
            N9(this.moreRecommendStyleText, null, null, null, Float.valueOf(19.0f));
        }
    }

    private final void N9(View view, Float topDp, Float bottomDp, Float startDp, Float endDp) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            if (topDp != null) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = ImmersiveUtils.dpToPx(topDp.floatValue());
            }
            if (bottomDp != null) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).bottomMargin = ImmersiveUtils.dpToPx(bottomDp.floatValue());
            }
            if (startDp != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).setMarginStart(ImmersiveUtils.dpToPx(startDp.floatValue()));
            }
            if (endDp != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).setMarginEnd(ImmersiveUtils.dpToPx(endDp.floatValue()));
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private final void O9(boolean enable) {
        R9(enable);
        Q9(enable);
        U9(enable);
        S9(enable);
        T9(enable);
    }

    private final void P9(boolean enable) {
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.B0(enable);
        }
        WinkAvatarCropView winkAvatarCropView2 = this.secondCropView;
        if (winkAvatarCropView2 != null) {
            winkAvatarCropView2.B0(enable);
        }
    }

    private final void Q9(boolean enable) {
        boolean z16;
        ShadowAIGCStatus$GetStatusReply value = V9().S1().getValue();
        if (value != null && com.tencent.mobileqq.wink.request.a.g(value)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView = this.downloadBtn;
            if (imageView != null) {
                imageView.setEnabled(true);
            }
            Ha(this.downloadBtn, R.drawable.qui_download, false);
            return;
        }
        ImageView imageView2 = this.downloadBtn;
        if (imageView2 != null) {
            imageView2.setEnabled(enable);
        }
        Ha(this.downloadBtn, R.drawable.qui_download, enable);
    }

    private final void S9(boolean enable) {
        ImageView imageView = this.regenerateBtn;
        if (imageView != null) {
            imageView.setEnabled(enable);
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setEnabled(enable);
        }
        Ha(this.regenerateBtn, R.drawable.qui_refresh, enable);
        if (enable) {
            TextView textView = this.regenerateBtnText;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        TextView textView2 = this.regenerateBtnText;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_text_tertiary));
        }
    }

    private final void T9(boolean enable) {
        View view = this.replaceBtn;
        if (view != null) {
            view.setEnabled(enable);
        }
        Ha(this.replaceBtnIcon, R.drawable.qui_image, enable);
        if (enable) {
            TextView textView = this.replaceBtnText;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        TextView textView2 = this.replaceBtnText;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_text_tertiary));
        }
    }

    private final void U9(boolean enable) {
        View view = this.shareBtn;
        if (view != null) {
            view.setEnabled(enable);
        }
        Ha(this.shareBtnIcon, R.drawable.qui_share, enable);
        if (enable) {
            TextView textView = this.shareBtnText;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        TextView textView2 = this.shareBtnText;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_text_tertiary));
        }
    }

    private final WinkAIAvatarResultViewModel W9() {
        Object value = this.resultViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-resultViewModel>(...)");
        return (WinkAIAvatarResultViewModel) value;
    }

    private final void ba(v.FirstGenerating uiState) {
        O9(false);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setVisibility(4);
        }
        TextView textView = this.generateTipText;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.replaceBtn;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view3 = this.shareBtn;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView2 = this.titleText;
        if (textView2 != null) {
            textView2.setText("\u751f\u6210\u5934\u50cf");
        }
        Ba(uiState.d(), true, uiState.c());
        Fa(true);
        P9(false);
    }

    private final void ca() {
        O9(false);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setDisableState("\u751f\u6210\u4e2d");
        }
        Fa(true);
        P9(false);
    }

    private final void ha(v.Init uiState) {
        TextView textView = this.titleText;
        if (textView != null) {
            textView.setText("\u751f\u6210\u5934\u50cf");
        }
        R9(false);
        U9(false);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setText("\u751f\u6210\u4e2d");
        }
        TextView textView2 = this.generateTipText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view2 = this.shareBtn;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.replaceBtn;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView3 = this.titleText;
        if (textView3 != null) {
            textView3.setText("\u751f\u6210\u5934\u50cf");
        }
        Ba(uiState.d(), true, uiState.c());
        P9(false);
        na();
    }

    private final void la(v.SchemeInit uiState) {
        boolean z16;
        String take;
        Ca(this, uiState.c(), false, null, 4, null);
        R9(true);
        U9(true);
        P9(false);
        na();
        TextView textView = this.otherStyleTitle;
        if (textView != null) {
            textView.setText("\u5176\u4ed6\u70ed\u95e8\u63a8\u8350");
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView2 = this.generateChanceText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.generateTipText;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.titleText;
        if (textView4 != null) {
            textView4.setText("AI\u5934\u50cf");
        }
        TextView textView5 = this.moreRecommendStyleText;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        String schemeUserNickName = W9().getSchemeUserNickName();
        if (schemeUserNickName.length() > 6) {
            take = StringsKt___StringsKt.take(schemeUserNickName, 6);
            schemeUserNickName = take + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        View view2 = this.shareBtn;
        if (view2 != null && view2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.C(this.shareBtn, W9().x2());
        }
        com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
        aVar.r(this.moreRecommendStyleText);
        ImageView imageView2 = this.downloadBtn;
        Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type android.view.View");
        aVar.i(imageView2, W9().x2());
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setVisibility(0);
        }
        if (W9().getIsCoupleAvatar()) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
            if (winkAIAvatarGenerateBtn2 != null) {
                winkAIAvatarGenerateBtn2.setText("\u8bbe\u7f6e\u5934\u50cf\u5e76\u4fdd\u5b58");
            }
            TextView textView6 = this.generateTipText;
            if (textView6 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                StyleSpan styleSpan = new StyleSpan(1);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) schemeUserNickName);
                spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.append((CharSequence) "\u5236\u4f5c\u4e86\u60c5\u4fa3\u6b3eAI\u5934\u50cf");
                textView6.setText(new SpannedString(spannableStringBuilder));
            }
            TextView textView7 = this.paitongkuanText;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            aVar.A(this.generateBtn, W9().x2(), Boolean.FALSE);
            return;
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn3 = this.generateBtn;
        if (winkAIAvatarGenerateBtn3 != null) {
            winkAIAvatarGenerateBtn3.setText("\u505a\u540c\u6b3e");
        }
        TextView textView8 = this.generateTipText;
        if (textView8 != null) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            StyleSpan styleSpan2 = new StyleSpan(1);
            int length2 = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) schemeUserNickName);
            spannableStringBuilder2.setSpan(styleSpan2, length2, spannableStringBuilder2.length(), 17);
            spannableStringBuilder2.append((CharSequence) "\u5236\u4f5c\u4e86AI\u5934\u50cf");
            textView8.setText(new SpannedString(spannableStringBuilder2));
        }
        aVar.p(this.generateBtn);
    }

    private final void na() {
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.setMaskBorderVisible(false);
        }
        WinkAvatarCropView winkAvatarCropView2 = this.firstCropView;
        if (winkAvatarCropView2 != null) {
            winkAvatarCropView2.setCornerMaskVisible(false);
        }
        WinkAvatarCropView winkAvatarCropView3 = this.firstCropView;
        if (winkAvatarCropView3 != null) {
            winkAvatarCropView3.setCheckboxState(null);
        }
        WinkAvatarCropView winkAvatarCropView4 = this.firstCropView;
        if (winkAvatarCropView4 != null) {
            winkAvatarCropView4.setAnchorBarVisible(false);
        }
        WinkAvatarCropView winkAvatarCropView5 = this.secondCropView;
        if (winkAvatarCropView5 != null) {
            winkAvatarCropView5.setMaskBorderVisible(false);
        }
        WinkAvatarCropView winkAvatarCropView6 = this.secondCropView;
        if (winkAvatarCropView6 != null) {
            winkAvatarCropView6.setCornerMaskVisible(false);
        }
        WinkAvatarCropView winkAvatarCropView7 = this.secondCropView;
        if (winkAvatarCropView7 != null) {
            winkAvatarCropView7.setCheckboxState(null);
        }
        WinkAvatarCropView winkAvatarCropView8 = this.secondCropView;
        if (winkAvatarCropView8 != null) {
            winkAvatarCropView8.setAnchorBarVisible(false);
        }
    }

    private final void oa() {
        ViewGroup.LayoutParams layoutParams;
        boolean isCoupleAvatar = W9().getIsCoupleAvatar();
        w53.b.f("WinkAIAvatarResultUIStatePart", "initCoupleView: isCouple=" + isCoupleAvatar);
        if (!isCoupleAvatar) {
            return;
        }
        J9(this.firstCropView);
        J9(this.secondCropView);
        LinearLayout linearLayout = this.cropContainer;
        if (linearLayout != null) {
            if (linearLayout != null) {
                layoutParams = linearLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            linearLayout.setLayoutParams(layoutParams);
        }
        WinkAvatarCropView winkAvatarCropView = this.secondCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.setVisibility(0);
        }
    }

    private final void pa(View rootView) {
        ImageView imageView;
        View view;
        ImageView imageView2;
        TextView textView;
        LinearLayout linearLayout;
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn;
        WinkAvatarCropView winkAvatarCropView;
        WinkAvatarCropView winkAvatarCropView2;
        TextView textView2;
        TextView textView3;
        QUICheckBox qUICheckBox;
        ImageView imageView3;
        View view2;
        TextView textView4;
        LinearLayout linearLayout2;
        View view3;
        ImageView imageView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        View view4;
        TextView textView8;
        TextView textView9;
        RecyclerView recyclerView = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.bp5);
        } else {
            imageView = null;
        }
        this.downloadBtn = imageView;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f84224lo);
        } else {
            view = null;
        }
        this.shareBtn = view;
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f84234lp);
        } else {
            imageView2 = null;
        }
        this.shareBtnIcon = imageView2;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f166867ir1);
        } else {
            textView = null;
        }
        this.shareBtnText = textView;
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.f164548a32);
        } else {
            linearLayout = null;
        }
        this.cropContainer = linearLayout;
        if (rootView != null) {
            winkAIAvatarGenerateBtn = (WinkAIAvatarGenerateBtn) rootView.findViewById(R.id.vnj);
        } else {
            winkAIAvatarGenerateBtn = null;
        }
        this.generateBtn = winkAIAvatarGenerateBtn;
        if (rootView != null) {
            winkAvatarCropView = (WinkAvatarCropView) rootView.findViewById(R.id.v6w);
        } else {
            winkAvatarCropView = null;
        }
        this.firstCropView = winkAvatarCropView;
        if (rootView != null) {
            winkAvatarCropView2 = (WinkAvatarCropView) rootView.findViewById(R.id.f81674et);
        } else {
            winkAvatarCropView2 = null;
        }
        this.secondCropView = winkAvatarCropView2;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.vnm);
        } else {
            textView2 = null;
        }
        this.generateTipText = textView2;
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.vnl);
        } else {
            textView3 = null;
        }
        this.generateChanceText = textView3;
        if (rootView != null) {
            qUICheckBox = (QUICheckBox) rootView.findViewById(R.id.f9143556);
        } else {
            qUICheckBox = null;
        }
        this.syncQZoneCheckBox = qUICheckBox;
        if (rootView != null) {
            imageView3 = (ImageView) rootView.findViewById(R.id.f72443qv);
        } else {
            imageView3 = null;
        }
        this.regenerateBtn = imageView3;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f72453qw);
        } else {
            view2 = null;
        }
        this.regenerateContainer = view2;
        if (rootView != null) {
            textView4 = (TextView) rootView.findViewById(R.id.f72483qz);
        } else {
            textView4 = null;
        }
        this.regenerateBtnText = textView4;
        if (rootView != null) {
            linearLayout2 = (LinearLayout) rootView.findViewById(R.id.f72113pz);
        } else {
            linearLayout2 = null;
        }
        this.redoContainer = linearLayout2;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f73053si);
        } else {
            view3 = null;
        }
        this.replaceBtn = view3;
        if (rootView != null) {
            imageView4 = (ImageView) rootView.findViewById(R.id.f73043sh);
        } else {
            imageView4 = null;
        }
        this.replaceBtnIcon = imageView4;
        if (rootView != null) {
            textView5 = (TextView) rootView.findViewById(R.id.f73073sk);
        } else {
            textView5 = null;
        }
        this.replaceBtnText = textView5;
        if (rootView != null) {
            textView6 = (TextView) rootView.findViewById(R.id.f217301t);
        } else {
            textView6 = null;
        }
        this.otherStyleTitle = textView6;
        if (rootView != null) {
            textView7 = (TextView) rootView.findViewById(R.id.f221602z);
        } else {
            textView7 = null;
        }
        this.paitongkuanText = textView7;
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.f217201s);
        } else {
            view4 = null;
        }
        this.otherStyleContainer = view4;
        if (rootView != null) {
            textView8 = (TextView) rootView.findViewById(R.id.sfq);
        } else {
            textView8 = null;
        }
        this.titleText = textView8;
        if (rootView != null) {
            textView9 = (TextView) rootView.findViewById(R.id.zf6);
        } else {
            textView9 = null;
        }
        this.moreRecommendStyleText = textView9;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f71493oa);
        }
        this.recommendStyleRecyclerView = recyclerView;
        H9();
        I9();
        oa();
        M9();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void va(final WinkAvatarCropView cropView, String imagePath, final boolean showOrigin, final RectF faceDetectResult) {
        boolean z16;
        if (cropView != null) {
            if (imagePath != null && imagePath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                final Option option = Option.obtain();
                option.setUrl(imagePath);
                option.setLoadingDrawable(new ColorDrawable(0));
                option.setFailedDrawable(new ColorDrawable(0));
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.ab
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option2) {
                        WinkAIAvatarResultUIStatePart.wa(Option.this, cropView, faceDetectResult, showOrigin, loadState, option2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Option option, WinkAvatarCropView winkAvatarCropView, RectF rectF, boolean z16, LoadState loadState, Option option2) {
        Animatable animatable;
        Bitmap resultBitMap;
        boolean z17 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z17 = true;
        }
        if (z17) {
            if (option != null) {
                animatable = option.getAnimatable();
            } else {
                animatable = null;
            }
            if (animatable instanceof r01.c) {
                r01.c cVar = (r01.c) animatable;
                if (cVar.getFrameCount() > 0) {
                    cVar.registerAnimationCallback(new c(winkAvatarCropView, rectF, animatable));
                    cVar.setLoopCount(1);
                    cVar.c(true);
                    cVar.start();
                    return;
                }
                if (animatable instanceof GifDrawable) {
                    GifDrawable gifDrawable = (GifDrawable) animatable;
                    if (gifDrawable.b() != null) {
                        Bitmap b16 = gifDrawable.b();
                        Intrinsics.checkNotNullExpressionValue(b16, "animatable.currentFrame");
                        WinkAvatarCropView.I0(winkAvatarCropView, b16, rectF, 0.0f, null, 12, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (option2 != null && (resultBitMap = option2.getResultBitMap()) != null) {
                if (z16) {
                    WinkAvatarCropView.I0(winkAvatarCropView, resultBitMap, rectF, 0.0f, null, 12, null);
                } else {
                    WinkAvatarCropView.K0(winkAvatarCropView, resultBitMap, rectF, 0.0f, null, 12, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(List<String> imagePaths) {
        boolean z16;
        List<String> list = imagePaths;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.c("WinkAIAvatarResultUIStatePart", "replaceOriginImages: imagePaths isNullOrEmpty");
        } else {
            Ba(imagePaths, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za() {
        boolean z16;
        if (!W9().getIsCoupleAvatar()) {
            return;
        }
        if (!(X9().O1().getValue() instanceof v.Init) && !(X9().O1().getValue() instanceof v.FirstGenerating)) {
            P9(true);
            v value = X9().O1().getValue();
            if (value != null) {
                z16 = value.getIsFirstAvatarSelected();
            } else {
                z16 = true;
            }
            if (z16) {
                Aa(this.firstCropView, true);
                Aa(this.secondCropView, false);
                return;
            } else {
                Aa(this.firstCropView, false);
                Aa(this.secondCropView, true);
                return;
            }
        }
        Aa(this.firstCropView, false);
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.setCornerMaskVisible(true);
        }
        WinkAvatarCropView winkAvatarCropView2 = this.firstCropView;
        if (winkAvatarCropView2 != null) {
            winkAvatarCropView2.setMaskBorderVisible(false);
        }
        Aa(this.secondCropView, false);
        WinkAvatarCropView winkAvatarCropView3 = this.secondCropView;
        if (winkAvatarCropView3 != null) {
            winkAvatarCropView3.setCornerMaskVisible(true);
        }
        WinkAvatarCropView winkAvatarCropView4 = this.secondCropView;
        if (winkAvatarCropView4 != null) {
            winkAvatarCropView4.setMaskBorderVisible(false);
        }
    }

    protected final void Ba(@Nullable List<String> imagePaths, boolean showOrigin, @Nullable List<? extends RectF> faceDetectResults) {
        boolean z16;
        RectF rectF;
        Object lastOrNull;
        Object firstOrNull;
        List<String> list = imagePaths;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.c("WinkAIAvatarResultUIStatePart", "showAvatarImages error, imagePaths is null");
            return;
        }
        this.currentImageData = new ImageData(imagePaths, showOrigin, faceDetectResults);
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        String str = imagePaths.get(0);
        RectF rectF2 = null;
        if (faceDetectResults != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) faceDetectResults);
            rectF = (RectF) firstOrNull;
        } else {
            rectF = null;
        }
        va(winkAvatarCropView, str, showOrigin, rectF);
        if (W9().getIsCoupleAvatar()) {
            WinkAvatarCropView winkAvatarCropView2 = this.secondCropView;
            String str2 = imagePaths.get(1);
            if (faceDetectResults != null) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) faceDetectResults);
                rectF2 = (RectF) lastOrNull;
            }
            va(winkAvatarCropView2, str2, showOrigin, rectF2);
        }
    }

    protected final void Fa(boolean show) {
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.G0(show);
        }
        WinkAvatarCropView winkAvatarCropView2 = this.secondCropView;
        if (winkAvatarCropView2 != null) {
            winkAvatarCropView2.G0(show);
        }
        if (show) {
            na();
        }
    }

    protected final void Ga(boolean show) {
        try {
            if (show) {
                ai a16 = new ai.b(getContext()).i("\u5934\u50cf\u8bbe\u7f6e\u4e2d").b(true).h(false).a();
                this.loadingDialog = a16;
                if (a16 != null) {
                    a16.setCancelable(false);
                }
                ai aiVar = this.loadingDialog;
                if (aiVar != null) {
                    aiVar.show();
                    return;
                }
                return;
            }
            ai aiVar2 = this.loadingDialog;
            if (aiVar2 != null) {
                aiVar2.dismiss();
            }
        } catch (Throwable th5) {
            w53.b.d("WinkAIAvatarResultUIStatePart", "showLoadingDialog error", th5);
        }
    }

    protected void H9() {
        ViewGroup.LayoutParams layoutParams;
        List<String> b16;
        o53.h hVar = o53.h.f422138a;
        List<String> list = null;
        if (o53.h.A(hVar, null, 1, null) && !W9().getIsCoupleAvatar()) {
            WinkAvatarCropView winkAvatarCropView = this.firstCropView;
            if (winkAvatarCropView != null) {
                layoutParams = winkAvatarCropView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                ((ViewGroup.LayoutParams) layoutParams2).width = hVar.m(getActivity());
                ((ViewGroup.LayoutParams) layoutParams2).height = hVar.m(getActivity());
                WinkAvatarCropView winkAvatarCropView2 = this.firstCropView;
                if (winkAvatarCropView2 != null) {
                    winkAvatarCropView2.setLayoutParams(layoutParams);
                }
            }
            ImageData imageData = this.currentImageData;
            if (imageData != null && (b16 = imageData.b()) != null) {
                if (!b16.isEmpty()) {
                    list = b16;
                }
                if (list != null) {
                    ImageData imageData2 = this.currentImageData;
                    Intrinsics.checkNotNull(imageData2);
                    boolean isOrigin = imageData2.getIsOrigin();
                    ImageData imageData3 = this.currentImageData;
                    Intrinsics.checkNotNull(imageData3);
                    Ba(list, isOrigin, imageData3.a());
                }
            }
            WinkAvatarCropView winkAvatarCropView3 = this.firstCropView;
            if (winkAvatarCropView3 != null) {
                winkAvatarCropView3.A0();
            }
            if (hVar.w(getActivity()) && (X9().O1().getValue() instanceof v.i)) {
                Fa(true);
            }
        }
    }

    protected void R9(boolean enable) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (X9().O1().getValue() instanceof v.Init) {
            ShadowAIGCStatus$GetStatusReply value = V9().S1().getValue();
            if (value != null && com.tencent.mobileqq.wink.request.a.f(value)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
                if (winkAIAvatarGenerateBtn != null) {
                    winkAIAvatarGenerateBtn.setDisableState(com.tencent.mobileqq.wink.request.a.b(value));
                    return;
                }
                return;
            }
            if (value != null && com.tencent.mobileqq.wink.request.a.j(value)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
                if (winkAIAvatarGenerateBtn2 != null) {
                    winkAIAvatarGenerateBtn2.setVipState(com.tencent.mobileqq.wink.request.a.b(value));
                    return;
                }
                return;
            }
            if (value == null || !com.tencent.mobileqq.wink.request.a.h(value)) {
                z18 = false;
            }
            if (z18) {
                WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn3 = this.generateBtn;
                if (winkAIAvatarGenerateBtn3 != null) {
                    winkAIAvatarGenerateBtn3.setEnableState(com.tencent.mobileqq.wink.request.a.b(value));
                    return;
                }
                return;
            }
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn4 = this.generateBtn;
            if (winkAIAvatarGenerateBtn4 != null) {
                winkAIAvatarGenerateBtn4.setEnableState("\u5f00\u59cb\u751f\u6210");
                return;
            }
            return;
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn5 = this.generateBtn;
        if (winkAIAvatarGenerateBtn5 != null) {
            winkAIAvatarGenerateBtn5.setEnabled(enable);
        }
        if (enable) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn6 = this.generateBtn;
            if (winkAIAvatarGenerateBtn6 != null) {
                WinkAIAvatarGenerateBtn.setEnableState$default(winkAIAvatarGenerateBtn6, null, 1, null);
                return;
            }
            return;
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn7 = this.generateBtn;
        if (winkAIAvatarGenerateBtn7 != null) {
            WinkAIAvatarGenerateBtn.setDisableState$default(winkAIAvatarGenerateBtn7, null, 1, null);
        }
    }

    @NotNull
    protected final WinkAIAvatarGenerateBtnViewModel V9() {
        Object value = this.generateBtnViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generateBtnViewModel>(...)");
        return (WinkAIAvatarGenerateBtnViewModel) value;
    }

    @NotNull
    protected final ad X9() {
        Object value = this.uiStateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-uiStateViewModel>(...)");
        return (ad) value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y9(boolean success) {
        if (success) {
            if (W9().getIsCoupleAvatar()) {
                QQToast.makeText(getContext(), 2, "2\u5f20\u56fe\u7247\u5df2\u4fdd\u5b58\u5230\u672c\u5730\u76f8\u518c", 0).show();
                return;
            } else {
                QQToast.makeText(getContext(), 2, "\u56fe\u7247\u5df2\u4fdd\u5b58\u81f3\u76f8\u518c", 0).show();
                return;
            }
        }
        QQToast.makeText(getContext(), 1, "\u56fe\u7247\u5df2\u4fdd\u5b58\u5931\u8d25", 0).show();
    }

    protected void Z9(boolean success) {
        Ga(false);
        if (success) {
            QQToast.makeText(getContext(), 2, "\u8bbe\u7f6e\u6210\u529f\uff0c\u56fe\u7247\u5df2\u4fdd\u5b58\u81f3\u76f8\u518c", 0).show();
        } else {
            QQToast.makeText(getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25", 0).show();
        }
    }

    public void aa(@NotNull v.FirstGenerateFailed uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        winkAIAvatarUtils.F(context, uiState.getErrorMsg());
        R9(true);
        U9(false);
        T9(true);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setText("\u91cd\u65b0\u751f\u6210");
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
        if (winkAIAvatarGenerateBtn2 != null) {
            winkAIAvatarGenerateBtn2.setVisibility(0);
        }
        View view = this.replaceBtn;
        if (view != null) {
            view.setVisibility(0);
        }
        P9(false);
        Fa(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(@Nullable ShadowAIGCStatus$GetStatusReply btnStatus) {
        if (btnStatus == null) {
            return;
        }
        ea(btnStatus);
        if (X9().O1().getValue() instanceof v.Init) {
            R9(!com.tencent.mobileqq.wink.request.a.f(btnStatus));
        }
        if (com.tencent.mobileqq.wink.request.a.g(btnStatus)) {
            Q9(false);
        } else {
            Q9(true);
        }
    }

    protected void ea(@Nullable ShadowAIGCStatus$GetStatusReply btnStatus) {
        if (btnStatus == null) {
            return;
        }
        TextView textView = this.generateChanceText;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.wink.request.a.c(btnStatus));
        }
        if (com.tencent.mobileqq.wink.request.a.j(btnStatus)) {
            if (X9().O1().getValue() instanceof v.Init) {
                TextView textView2 = this.generateChanceText;
                if (textView2 != null) {
                    textView2.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
                    return;
                }
                return;
            }
            TextView textView3 = this.generateChanceText;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#FFCBA05B"));
            }
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable o16 = winkAIAvatarUtils.o(context, 15.0f);
            TextView textView4 = this.generateChanceText;
            if (textView4 != null) {
                textView4.setCompoundDrawablesWithIntrinsicBounds(o16, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.wink.request.a.i(btnStatus)) {
            TextView textView5 = this.generateChanceText;
            if (textView5 != null) {
                textView5.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
            }
            WinkAIAvatarUtils winkAIAvatarUtils2 = WinkAIAvatarUtils.f317678a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Drawable o17 = winkAIAvatarUtils2.o(context2, 14.0f);
            TextView textView6 = this.generateChanceText;
            if (textView6 != null) {
                textView6.setCompoundDrawablesWithIntrinsicBounds(o17, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        TextView textView7 = this.generateChanceText;
        if (textView7 != null) {
            textView7.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        TextView textView8 = this.generateChanceText;
        if (textView8 != null) {
            textView8.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void ga(@NotNull v.GenerateSuccess uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Ca(this, uiState.c(), false, null, 4, null);
        if (!W9().getIsCoupleAvatar()) {
            WinkAvatarCropView winkAvatarCropView = this.firstCropView;
            if (winkAvatarCropView != null) {
                winkAvatarCropView.setCornerMaskVisible(true);
            }
            WinkAvatarCropView winkAvatarCropView2 = this.firstCropView;
            if (winkAvatarCropView2 != null) {
                winkAvatarCropView2.setAnchorBarVisible(true);
            }
            WinkAvatarCropView winkAvatarCropView3 = this.firstCropView;
            if (winkAvatarCropView3 != null) {
                winkAvatarCropView3.setMaskBorderVisible(true);
            }
            WinkAvatarCropView winkAvatarCropView4 = this.firstCropView;
            if (winkAvatarCropView4 != null) {
                winkAvatarCropView4.setCircleBorderWidth(1);
            }
        }
        O9(true);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setVisibility(0);
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
        if (winkAIAvatarGenerateBtn2 != null) {
            winkAIAvatarGenerateBtn2.setText("\u8bbe\u7f6e\u5934\u50cf\u5e76\u4fdd\u5b58");
        }
        TextView textView = this.generateTipText;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        View view2 = this.shareBtn;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.replaceBtn;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        P9(true);
        Da();
        com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
        aVar.v(this.regenerateBtn, W9().x2());
        View view4 = this.shareBtn;
        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type android.view.View");
        aVar.C(view4, W9().x2());
        aVar.A(this.generateBtn, W9().x2(), Boolean.FALSE);
        ImageView imageView2 = this.downloadBtn;
        Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type android.view.View");
        aVar.i(imageView2, W9().x2());
        aVar.x(this.replaceBtn);
    }

    public void ia(@NotNull v.OtherGenerateFailed uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        winkAIAvatarUtils.F(context, uiState.getErrorMsg());
        X9().L1();
    }

    public void initViewModel() {
        LiveData<v> O1 = X9().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<v, Unit> function1 = new Function1<v, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(v it) {
                WinkAIAvatarResultUIStatePart winkAIAvatarResultUIStatePart = WinkAIAvatarResultUIStatePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkAIAvatarResultUIStatePart.ma(it);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultUIStatePart.qa(Function1.this, obj);
            }
        });
        LiveData<Unit> M1 = X9().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                WinkAIAvatarResultUIStatePart.this.za();
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultUIStatePart.ra(Function1.this, obj);
            }
        });
        LiveData<List<String>> N1 = X9().N1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends String>, Unit> function13 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<String> list) {
                WinkAIAvatarResultUIStatePart.this.xa(list);
            }
        };
        N1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultUIStatePart.sa(Function1.this, obj);
            }
        });
        LiveData<ShadowAIGCStatus$GetStatusReply> S1 = V9().S1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<ShadowAIGCStatus$GetStatusReply, Unit> function14 = new Function1<ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke2(shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                WinkAIAvatarResultUIStatePart.this.da(shadowAIGCStatus$GetStatusReply);
            }
        };
        S1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultUIStatePart.ta(Function1.this, obj);
            }
        });
        LiveData<Boolean> q26 = W9().q2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultUIStatePart$initViewModel$5
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
                WinkAIAvatarResultUIStatePart winkAIAvatarResultUIStatePart = WinkAIAvatarResultUIStatePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkAIAvatarResultUIStatePart.Y9(it.booleanValue());
            }
        };
        q26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultUIStatePart.ua(Function1.this, obj);
            }
        });
        V9().X1();
    }

    public void ja() {
        O9(false);
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setText("\u751f\u6210\u4e2d");
        }
        TextView textView = this.generateTipText;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.regenerateContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        View view2 = this.shareBtn;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.replaceBtn;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        P9(false);
        Fa(true);
    }

    public void ma(@NotNull v uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (uiState instanceof v.Init) {
            ha((v.Init) uiState);
            return;
        }
        if (uiState instanceof v.FirstGenerating) {
            ba((v.FirstGenerating) uiState);
            return;
        }
        if (uiState instanceof v.f) {
            ca();
            return;
        }
        if (uiState instanceof v.l) {
            ja();
            return;
        }
        if (uiState instanceof v.GenerateSuccess) {
            ga((v.GenerateSuccess) uiState);
            return;
        }
        if (uiState instanceof v.FirstGenerateFailed) {
            aa((v.FirstGenerateFailed) uiState);
            return;
        }
        if (uiState instanceof v.OtherGenerateFailed) {
            ia((v.OtherGenerateFailed) uiState);
            return;
        }
        if (uiState instanceof v.c) {
            Ga(true);
            return;
        }
        if (uiState instanceof v.b) {
            Z9(true);
            return;
        }
        if (uiState instanceof v.a) {
            Z9(false);
            return;
        }
        if (uiState instanceof v.SchemeInit) {
            la((v.SchemeInit) uiState);
            return;
        }
        w53.b.c("WinkAIAvatarResultUIStatePart", "handleUiStateChanged: " + uiState.getClass().getSimpleName());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int i3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52136 && resultCode == -1) {
            V9().c2();
            com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            if (W9().getIsSchemeJump()) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            aVar.D(i3, 2, W9().x2());
            w53.b.f("WinkAIAvatarResultUIStatePart", "onActivityResult: share succeed!");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersiveUtils.resetDensity();
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        pa(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        WinkAvatarCropView winkAvatarCropView = this.firstCropView;
        if (winkAvatarCropView != null) {
            winkAvatarCropView.release();
        }
        WinkAvatarCropView winkAvatarCropView2 = this.secondCropView;
        if (winkAvatarCropView2 != null) {
            winkAvatarCropView2.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        V9().T1();
    }
}
