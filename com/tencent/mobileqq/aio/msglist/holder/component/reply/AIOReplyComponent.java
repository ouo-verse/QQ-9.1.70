package com.tencent.mobileqq.aio.msglist.holder.component.reply;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.msg.w;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.ReplyUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.h;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ak;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.n;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.emotion.utils.s;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyAbsElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyAbsFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyAbsPicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008c\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u008d\u0001B\u0013\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\u001e\u0010,\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020+2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J\u0016\u00100\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0016H\u0002J\u0016\u00101\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0016H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\u0010\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020\u000e2\u0006\u00108\u001a\u000207H\u0002J$\u0010>\u001a\u001e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\f0;j\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\f`=H\u0002J\b\u0010?\u001a\u00020\u000eH\u0002J\u0018\u0010@\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0002J\u0018\u0010A\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0002J \u0010D\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u0010C\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020\u000eH\u0002J\u0018\u0010F\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010H\u001a\u00020G2\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010J\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020IH\u0002J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010L\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0014\u0010M\u001a\u0004\u0018\u00010\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010\u001c2\u0006\u0010N\u001a\u00020<H\u0002J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020GH\u0002J \u0010R\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u0010C\u001a\u00020BH\u0002J\u0018\u0010S\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u000207H\u0002J$\u0010U\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\n\b\u0002\u0010T\u001a\u0004\u0018\u00010<H\u0002J(\u0010[\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020B2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020<2\u0006\u0010Z\u001a\u00020YH\u0002J\u0018\u0010_\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u001aH\u0002J\u0010\u0010b\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020`H\u0002J\u001c\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070c2\u0006\u0010W\u001a\u00020VH\u0002J\b\u0010f\u001a\u00020eH\u0002J\u0010\u0010h\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020\u001aH\u0002R\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010rR\u001b\u0010{\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001c\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010x\u001a\u0004\b~\u0010\u007fR\u001f\u0010\u0084\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u001b\u0010x\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent;", "Lcom/tencent/mobileqq/aio/msg/u;", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponentVM;", "P2", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "r2", "e1", "importance", "l1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "h1", "", ExifInterface.LATITUDE_SOUTH, "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "i2", "color", "m2", "Landroid/content/res/ColorStateList;", NodeProps.COLORS, ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "j1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/msg/o;", "j3", "i3", "Lcom/tencent/mobileqq/aio/msg/o$b;", "msgItemList", "L2", "f3", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/h;", "info", "z3", "y3", "g3", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "replyElement", ICustomDataEditor.STRING_ARRAY_PARAM_3, "Z2", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "W2", ICustomDataEditor.NUMBER_PARAM_3, "b3", "l3", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "replyMsgRecord", "A3", "C3", "v3", "", "Y2", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "w3", "p3", "x3", "V2", "arkMsgIcon", "Q2", "msgDownQQText", "o3", "u3", Constants.BASE_IN_APP_NAME, "replyNickFromProfile", "E3", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "mediaElement", "path", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "picSize", ICustomDataEditor.STRING_PARAM_3, "", "loadImageMsgId", "success", "k3", "Landroid/widget/ImageView;", "imageView", "N2", "Lkotlin/Pair;", "U2", "Lcom/tencent/qqnt/aio/menu/ui/c;", "X2", "isMosaic", "r3", "Lw71/b;", "L", "Lw71/b;", "mRootBinding", "Lw71/m;", "M", "Lw71/m;", "mSourceContentBinding", "N", "I", "maxTextWidth", "P", "maxPicWidth", "Landroidx/lifecycle/LifecycleCoroutineScope;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "S2", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", BdhLogUtil.LogTag.Tag_Req, "R2", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "T2", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mContentWithForeground", "T", "Z", "isInited", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "U", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOReplyComponent extends BaseMixContentComponent<u> {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int V;
    private static final int W;
    private static final int X;
    private static final int Y;
    private static final int Z;

    /* renamed from: L, reason: from kotlin metadata */
    private w71.b mRootBinding;

    /* renamed from: M, reason: from kotlin metadata */
    private m mSourceContentBinding;

    /* renamed from: N, reason: from kotlin metadata */
    private int maxTextWidth;

    /* renamed from: P, reason: from kotlin metadata */
    private int maxPicWidth;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleScope;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isInited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponent$a;", "", "", "ACCESSIBILITY_ACTION_TAP", "I", "", "TAG", "Ljava/lang/String;", "mDP1", "mDP13", "mDP2", "mDP37", "mDP4", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponent$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "a", "Landroid/text/Spannable;", "text", "", "Landroid/text/style/ClickableSpan;", "b", "(Landroid/text/Spannable;)[Landroid/text/style/ClickableSpan;", "", "action", "Landroid/os/Bundle;", "args", "", "performAccessibilityAction", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Spannable f191821a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOReplyComponent f191822b;

        b(Spannable spannable, AIOReplyComponent aIOReplyComponent) {
            this.f191821a = spannable;
            this.f191822b = aIOReplyComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) spannable, (Object) aIOReplyComponent);
            }
        }

        public final void a(@NotNull AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            ClickableSpan[] b16 = b(this.f191821a);
            int length = b16.length;
            for (int i3 = 0; i3 < length; i3++) {
                String substring = this.f191821a.toString().substring(this.f191821a.getSpanStart(b16[i3]), this.f191821a.getSpanEnd(b16[i3]));
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(33554432 + i3 + 1, this.f191822b.getContext().getResources().getString(R.string.f230496za, substring)));
            }
        }

        @NotNull
        public final ClickableSpan[] b(@NotNull Spannable text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ClickableSpan[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) text);
            }
            Intrinsics.checkNotNullParameter(text, "text");
            Object[] spans = text.getSpans(0, text.length(), ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(\n         \u2026                        )");
            return (ClickableSpan[]) spans;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (Build.VERSION.SDK_INT >= 24 && info != null) {
                info.setImportantForAccessibility(true);
                a(info);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(@Nullable View host, int action, @Nullable Bundle args) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, host, Integer.valueOf(action), args)).booleanValue();
            }
            if (action > 33554432) {
                int i3 = (action - 33554432) - 1;
                ClickableSpan[] b16 = b(this.f191821a);
                if (i3 >= 0 && i3 < b16.length) {
                    ClickableSpan clickableSpan = b16[i3];
                    Intrinsics.checkNotNull(host);
                    clickableSpan.onClick(host);
                    return true;
                }
            }
            return super.performAccessibilityAction(host, action, args);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        INSTANCE = new Companion(null);
        V = ViewUtils.dip2px(1.0f);
        W = ViewUtils.dip2px(2.0f);
        X = ViewUtils.dip2px(4.0f);
        Y = ViewUtils.dip2px(37.0f);
        Z = ViewUtils.dip2px(13.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOReplyComponent(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LifecycleCoroutineScope>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$lifecycleScope$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LifecycleCoroutineScope invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LifecycleCoroutineScope) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Object obj = this.$context;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    return LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) obj);
                }
            });
            this.lifecycleScope = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AIOReplyLinearLayout>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$contentView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOReplyComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIOReplyLinearLayout invoke() {
                    w71.b bVar;
                    m mVar;
                    m mVar2;
                    m mVar3;
                    m mVar4;
                    m mVar5;
                    int i3;
                    m mVar6;
                    int i16;
                    w71.b bVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIOReplyLinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LayoutInflater from = LayoutInflater.from(this.$context);
                    AIOReplyComponent aIOReplyComponent = this.this$0;
                    w71.b bVar3 = null;
                    w71.b g16 = w71.b.g(from, null, false);
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
                    aIOReplyComponent.mRootBinding = g16;
                    AIOReplyComponent aIOReplyComponent2 = this.this$0;
                    bVar = aIOReplyComponent2.mRootBinding;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                        bVar = null;
                    }
                    m mVar7 = bVar.f444773b;
                    Intrinsics.checkNotNullExpressionValue(mVar7, "mRootBinding.replyRoot");
                    aIOReplyComponent2.mSourceContentBinding = mVar7;
                    mVar = this.this$0.mSourceContentBinding;
                    if (mVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar = null;
                    }
                    ImmersiveUtils.setAlpha(mVar.f444854k, 0.9f);
                    mVar2 = this.this$0.mSourceContentBinding;
                    if (mVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar2 = null;
                    }
                    ImmersiveUtils.setAlpha(mVar2.f444856m, 0.9f);
                    mVar3 = this.this$0.mSourceContentBinding;
                    if (mVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar3 = null;
                    }
                    ImmersiveUtils.setAlpha(mVar3.f444855l, 0.9f);
                    mVar4 = this.this$0.mSourceContentBinding;
                    if (mVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar4 = null;
                    }
                    ImmersiveUtils.setAlpha(mVar4.f444851h, 0.9f);
                    mVar5 = this.this$0.mSourceContentBinding;
                    if (mVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar5 = null;
                    }
                    AIOMsgTextView aIOMsgTextView = mVar5.f444855l;
                    aIOMsgTextView.setMaxLines(2);
                    aIOMsgTextView.setEllipsize(TextUtils.TruncateAt.END);
                    aIOMsgTextView.setIncludeFontPadding(false);
                    i3 = AIOReplyComponent.W;
                    aIOMsgTextView.setLineSpacing(i3, 1.0f);
                    mVar6 = this.this$0.mSourceContentBinding;
                    if (mVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                        mVar6 = null;
                    }
                    TextView textView = mVar6.f444851h;
                    textView.setMaxLines(2);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    i16 = AIOReplyComponent.W;
                    textView.setLineSpacing(i16, 1.0f);
                    bVar2 = this.this$0.mRootBinding;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                    } else {
                        bVar3 = bVar2;
                    }
                    return bVar3.getRoot();
                }
            });
            this.contentView = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$mContentWithForeground$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOReplyComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ConstraintLayout invoke() {
                    SelectableLinearLayout R2;
                    View Y1;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ConstraintLayout constraintLayout = new ConstraintLayout(this.$context);
                    AIOReplyComponent aIOReplyComponent = this.this$0;
                    constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    R2 = aIOReplyComponent.R2();
                    constraintLayout.addView(R2);
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                    layoutParams.startToStart = 0;
                    layoutParams.endToEnd = 0;
                    layoutParams.topToTop = 0;
                    layoutParams.bottomToBottom = 0;
                    layoutParams.leftToLeft = 0;
                    layoutParams.rightToRight = 0;
                    layoutParams.matchConstraintPercentWidth = 1.0f;
                    layoutParams.matchConstraintPercentHeight = 1.0f;
                    Y1 = aIOReplyComponent.Y1();
                    constraintLayout.addView(Y1, layoutParams);
                    return constraintLayout;
                }
            });
            this.mContentWithForeground = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A3(u msgItem, ReplyElement replyElement, final MsgRecord replyMsgRecord) {
        u3(msgItem, replyElement, replyMsgRecord);
        C3();
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444853j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOReplyComponent.B3(AIOReplyComponent.this, replyMsgRecord, view);
            }
        });
        long j3 = msgItem.getMsgRecord().peerUin;
        long j16 = replyMsgRecord.peerUin;
        if (j3 != 0 && j16 != 0 && j3 != j16) {
            m mVar3 = this.mSourceContentBinding;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar3 = null;
            }
            mVar3.f444850g.setVisibility(8);
            m mVar4 = this.mSourceContentBinding;
            if (mVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar4 = null;
            }
            mVar4.f444847d.setVisibility(0);
            m mVar5 = this.mSourceContentBinding;
            if (mVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            } else {
                mVar2 = mVar5;
            }
            mVar2.f444847d.setText(getMContext().getString(R.string.iyz));
            return;
        }
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar6 = null;
        }
        mVar6.f444847d.setVisibility(8);
        m mVar7 = this.mSourceContentBinding;
        if (mVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar7;
        }
        mVar2.f444850g.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ u B2(AIOReplyComponent aIOReplyComponent) {
        return (u) aIOReplyComponent.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B3(AIOReplyComponent this$0, MsgRecord replyMsgRecord, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyMsgRecord, "$replyMsgRecord");
        QLog.d("AIOReplyComponent", 1, "mSourceContentBinding.reply click");
        u uVar = (u) this$0.q1();
        m mVar = this$0.mSourceContentBinding;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        RelativeLayout relativeLayout = mVar.f444853j;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mSourceContentBinding.reply");
        this$0.sendIntent(new d.an(replyMsgRecord, uVar, relativeLayout));
        HashMap<String, Object> W2 = this$0.W2();
        W2.put("operating_area", "1");
        com.tencent.mobileqq.aio.utils.b.l("em_bas_reference_message", W2);
        this$0.C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C3() {
        String obj;
        u uVar = (u) q1();
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        TextPaint paint = mVar.f444856m.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "mSourceContentBinding.sourceTime.paint");
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        float F2 = uVar.F2(paint, mVar3.f444856m.getText().toString()) + Y;
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        int i3 = (int) F2;
        mVar4.f444856m.setMinWidth(i3);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        mVar5.f444854k.setMaxWidth(this.maxTextWidth - i3);
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar6 = null;
        }
        AIOMsgTextView aIOMsgTextView = mVar6.f444855l;
        m mVar7 = this.mSourceContentBinding;
        if (mVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar7 = null;
        }
        aIOMsgTextView.setTextSize(0, mVar7.f444851h.getTextSize());
        m mVar8 = this.mSourceContentBinding;
        if (mVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar8 = null;
        }
        if (mVar8.f444854k.getText() instanceof String) {
            m mVar9 = this.mSourceContentBinding;
            if (mVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar9 = null;
            }
            CharSequence text = mVar9.f444854k.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type kotlin.String");
            obj = (String) text;
        } else {
            m mVar10 = this.mSourceContentBinding;
            if (mVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar10 = null;
            }
            QLog.w("AIOReplyComponent", 1, "[updateViewAttr] source name is not string type,content=" + ((Object) mVar10.f444854k.getText()));
            m mVar11 = this.mSourceContentBinding;
            if (mVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar11 = null;
            }
            obj = mVar11.f444854k.getText().toString();
        }
        CharSequence qQTextPurePlainText = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQTextPurePlainText(obj, 16);
        m mVar12 = this.mSourceContentBinding;
        if (mVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar12 = null;
        }
        String a16 = com.tencent.mobileqq.aio.reply.b.a(mVar12.f444854k, qQTextPurePlainText.toString(), this.maxTextWidth - i3);
        Intrinsics.checkNotNullExpressionValue(a16, "adjustEllipsizeEndText(m\u2026idth - timeWidth.toInt())");
        m mVar13 = this.mSourceContentBinding;
        if (mVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar13;
        }
        mVar2.f444854k.setText(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D3(u msgItem, ReplyElement replyElement) {
        String str;
        if (TextUtils.isEmpty(replyElement.anonymousNickName)) {
            str = "";
        } else {
            str = replyElement.anonymousNickName;
        }
        if (TextUtils.isEmpty(str)) {
            String str2 = replyElement.senderUidStr;
            Intrinsics.checkNotNullExpressionValue(str2, "replyElement.senderUidStr");
            h.a aVar = new h.a(str2, null, 2, null);
            sendIntent(aVar);
            str = aVar.a();
        }
        E3(msgItem, replyElement, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E3(u msgItem, ReplyElement replyElement, String replyNickFromProfile) {
        String obj = en.f(BaseApplication.context, 3, replyElement.replyMsgTime.longValue() * 1000, true, true).toString();
        if (QLog.isColorLevel()) {
            QLog.d("AIOReplyComponent", 2, "useReplyElement msgId=" + ((u) q1()).getMsgId() + " replyMsgTime=" + obj + ", replyNick=" + com.tencent.qqnt.aio.utils.b.c(replyNickFromProfile));
        }
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444856m.setText(obj);
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444854k.setText(replyNickFromProfile);
        C3();
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        mVar4.f444856m.setVisibility(0);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar5;
        }
        mVar2.f444854k.setVisibility(0);
        if (msgItem.M0()) {
            w3(msgItem);
        } else if (msgItem.G2()) {
            p3(msgItem);
        } else {
            v3(msgItem, replyElement);
        }
    }

    private final void L2(List<o.b> msgItemList) {
        boolean z16;
        boolean z17;
        if (R2().getChildCount() > 1) {
            R2().removeViews(1, R2().getChildCount() - 1);
        }
        int size = msgItemList.size();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            o.b bVar = msgItemList.get(i17);
            if (i17 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i17 == msgItemList.size() - 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (bVar.b() != null) {
                N1((o) q1(), bVar.b(), R2(), i3, z16, z17, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOReplyComponent.M2(AIOReplyComponent.this);
                    }
                });
                i3++;
            } else if (bVar.c() != null) {
                R1(q1(), R2(), i16, z16, z17, true);
                i16++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(AIOReplyComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, Object> W2 = this$0.W2();
        W2.put("operating_area", "3");
        com.tencent.mobileqq.aio.utils.b.l("em_bas_reference_message", W2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N2(ImageView imageView) {
        int coerceAtMost;
        MsgElement d16;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        boolean z16 = true;
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_reply_adjust_width_9030_120811059", true) && (d16 = ((u) q1()).C2().d()) != null) {
            Pair<Integer, Integer> U2 = U2(d16);
            if (U2.getFirst().intValue() != -2 && U2.getSecond().intValue() != -2) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams == null || U2.getFirst().intValue() != layoutParams.width) {
                    z16 = false;
                }
                if (z16 && U2.getSecond().intValue() == layoutParams.height) {
                    return;
                }
            }
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(PicUtil.f191410a.s(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), imageView.getLayoutParams().height), this.maxPicWidth);
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOReplyComponent", 4, "[adjustViewWidth]: originWidth is " + imageView.getLayoutParams().width + ", originHeight is " + imageView.getLayoutParams().height + ", drawableWidth is " + drawable.getIntrinsicWidth() + ", drawableHeight is " + drawable.getIntrinsicHeight() + " adjustWidth is " + coerceAtMost);
        }
        if (coerceAtMost != imageView.getLayoutParams().width) {
            imageView.getLayoutParams().width = coerceAtMost;
            imageView.setLayoutParams(imageView.getLayoutParams());
        }
    }

    private final Drawable Q2(String arkMsgIcon) {
        if (TextUtils.isEmpty(arkMsgIcon)) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.htr);
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            int i3 = Z;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i3;
            obtain.mUseAutoScaleParams = false;
            drawable = URLDrawable.getDrawable(arkMsgIcon, obtain);
        } catch (Exception e16) {
            QLog.e("AIOReplyComponent", 1, "handle getArkMsgIcon error! " + e16.getMessage());
        }
        if (drawable != null) {
            int i16 = Z;
            drawable.setBounds(0, 0, i16, i16);
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectableLinearLayout R2() {
        Object value = this.contentView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentView>(...)");
        return (SelectableLinearLayout) value;
    }

    private final LifecycleCoroutineScope S2() {
        return (LifecycleCoroutineScope) this.lifecycleScope.getValue();
    }

    private final ConstraintLayout T2() {
        return (ConstraintLayout) this.mContentWithForeground.getValue();
    }

    private final Pair<Integer, Integer> U2(MsgElement mediaElement) {
        int j3;
        PicElement picElement = mediaElement.picElement;
        if (picElement != null) {
            return PicUtil.f191410a.p(picElement.picWidth, picElement.picHeight, com.tencent.mobileqq.aio.msglist.holder.base.util.f.e(picElement), true);
        }
        VideoElement videoElement = mediaElement.videoElement;
        if (videoElement != null) {
            return PicUtil.f191410a.p(videoElement.thumbWidth, videoElement.thumbHeight, false, true);
        }
        FileElement fileElement = mediaElement.fileElement;
        if (fileElement != null && ((j3 = c81.a.j(fileElement)) == 0 || j3 == 2)) {
            PicUtil picUtil = PicUtil.f191410a;
            Integer picWidth = fileElement.picWidth;
            Intrinsics.checkNotNullExpressionValue(picWidth, "picWidth");
            int intValue = picWidth.intValue();
            Integer picHeight = fileElement.picHeight;
            Intrinsics.checkNotNullExpressionValue(picHeight, "picHeight");
            return picUtil.p(intValue, picHeight.intValue(), false, true);
        }
        QLog.d("AIOReplyComponent", 1, "[getMediaThumbSize] invalid thumb, elemType:" + mediaElement.elementType);
        return new Pair<>(-2, -2);
    }

    private final Drawable V2(u msgItem) {
        boolean z16;
        Drawable drawable;
        Drawable c16;
        if (msgItem == null) {
            return null;
        }
        MsgRecord D2 = msgItem.D2();
        boolean z17 = true;
        if (D2 != null && D2.msgType == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            MsgRecord D22 = msgItem.D2();
            if (D22 == null || !al.c(D22)) {
                z17 = false;
            }
            if (!z17) {
                if (!msgItem.I2() || (c16 = msgItem.C2().c()) == null) {
                    return null;
                }
                c16.mutate();
                int i3 = Z;
                c16.setBounds(0, 0, i3, i3);
                return c16;
            }
        }
        if (!msgItem.isSelf() && !QQTheme.isNowThemeIsNight()) {
            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.qui_message_record, getContext().getTheme());
        } else {
            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.qui_message_record_white, getContext().getTheme());
        }
        if (drawable != null) {
            int i16 = Z;
            drawable.setBounds(0, 0, i16, i16);
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, Object> W2() {
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("message_referenced_type", String.valueOf(((u) q1()).getMsgRecord().msgType));
        MsgRecord D2 = ((u) q1()).D2();
        if (D2 == null || (str = Integer.valueOf(D2.msgType).toString()) == null) {
            str = "";
        }
        hashMap.put("message_reply_type", str);
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    private final com.tencent.qqnt.aio.menu.ui.c X2() {
        com.tencent.qqnt.aio.menu.ui.c cVar = new com.tencent.qqnt.aio.menu.ui.c();
        com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(getMContext(), q1());
        dVar.l(R2());
        cVar.a(dVar);
        cVar.a(new k(getMContext(), q1(), this, R2()));
        i iVar = new i(getMContext(), q1());
        iVar.i(R2());
        cVar.a(iVar);
        cVar.a(new ak(getContext(), q1(), this));
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            cVar.a(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), R2()));
        }
        return cVar;
    }

    private final CharSequence Y2(ReplyElement replyElement) {
        String str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<ReplyAbsElement> arrayList = replyElement.sourceMsgTextElems;
        Intrinsics.checkNotNullExpressionValue(arrayList, "replyElement.sourceMsgTextElems");
        for (ReplyAbsElement replyAbsElement : arrayList) {
            int i3 = replyAbsElement.replyAbsElemType;
            if (i3 == 1) {
                spannableStringBuilder.append((CharSequence) replyAbsElement.textElemContent);
            } else if (i3 == 2) {
                QRouteApi api = QRoute.api(IEmojiSpanService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                ReplyAbsFaceElement replyAbsFaceElement = replyAbsElement.faceElem;
                spannableStringBuilder.append(IEmojiSpanService.a.a((IEmojiSpanService) api, replyAbsFaceElement.faceType, replyAbsFaceElement.faceIndex, 0, true, 0, 16, null));
            } else if (i3 == 3) {
                ReplyAbsPicElement picElem = replyAbsElement.getPicElem();
                if (picElem != null) {
                    str = picElem.picText;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.getPicElem()?.picText ?: \"\"");
                }
                spannableStringBuilder.append((CharSequence) str);
            }
        }
        return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), spannableStringBuilder, 13, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null);
    }

    private final void Z2(ReplyElement replyElement) {
        Long l3 = replyElement.replayMsgSeq;
        Intrinsics.checkNotNullExpressionValue(l3, "replyElement.replayMsgSeq");
        long longValue = l3.longValue();
        Long l16 = replyElement.replyMsgClientSeq;
        Intrinsics.checkNotNullExpressionValue(l16, "replyElement.replyMsgClientSeq");
        long longValue2 = l16.longValue();
        Long l17 = replyElement.replyMsgTime;
        Intrinsics.checkNotNullExpressionValue(l17, "replyElement.replyMsgTime");
        sendIntent(new h.c(longValue, longValue2, l17.longValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a3(ReplyElement replyElement) {
        Long l3;
        Long l16;
        if (!((u) q1()).M0() && !((u) q1()).G2()) {
            if (replyElement.replayMsgId == 0 && (l3 = replyElement.replayMsgSeq) != null && l3.longValue() == 0) {
                Long l17 = replyElement.replyMsgTime;
                if (l17 != null && l17.longValue() == 0 && (l16 = replyElement.replyMsgClientSeq) != null && l16.longValue() == 0) {
                    handleUIState(AIOMsgItemUIState.ReplayNavigationFail.f190561d);
                    return;
                }
                Long l18 = replyElement.replyMsgClientSeq;
                Intrinsics.checkNotNullExpressionValue(l18, "replyElement.replyMsgClientSeq");
                long longValue = l18.longValue();
                Long l19 = replyElement.replyMsgTime;
                Intrinsics.checkNotNullExpressionValue(l19, "replyElement.replyMsgTime");
                sendIntent(new h.d(longValue, l19.longValue(), new MsgSimpleInfo(((u) q1()).getMsgId(), ((u) q1()).getMsgSeq(), ((u) q1()).getMsgRecord().msgTime)));
                return;
            }
            Long l26 = replyElement.replayMsgSeq;
            Intrinsics.checkNotNullExpressionValue(l26, "replyElement.replayMsgSeq");
            sendIntent(new h.b(l26.longValue(), replyElement.replayMsgId, new MsgSimpleInfo(((u) q1()).getMsgId(), ((u) q1()).getMsgSeq(), ((u) q1()).getMsgRecord().msgTime)));
            return;
        }
        handleUIState(AIOMsgItemUIState.ReplayNavigationFail.f190561d);
    }

    private final void b3(final u msgItem, final ReplyElement replyElement) {
        Contact contact = new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, "");
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444855l.setVisibility(8);
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar3;
        }
        mVar2.f444851h.setVisibility(8);
        if (msgItem.D2() != null) {
            String simpleUinForPrint = StringUtil.getSimpleUinForPrint(String.valueOf(msgItem.getMsgRecord().peerUin));
            MsgRecord D2 = msgItem.D2();
            Intrinsics.checkNotNull(D2);
            String simpleUinForPrint2 = StringUtil.getSimpleUinForPrint(String.valueOf(D2.peerUin));
            if (QLog.isColorLevel()) {
                QLog.d("AIOReplyComponent", 2, "handleSourceMsgRecord msgId=" + msgItem.getMsgId() + " msgSeq=" + msgItem.getMsgSeq() + " replyMsgSeq=" + replyElement.replayMsgSeq + " peerUin=" + simpleUinForPrint + " replyPeerUin=" + simpleUinForPrint2);
            }
            MsgRecord D22 = msgItem.D2();
            Intrinsics.checkNotNull(D22);
            A3(msgItem, replyElement, D22);
            return;
        }
        D3(msgItem, replyElement);
        Long l3 = replyElement.replayMsgSeq;
        if (l3 != null && l3.longValue() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOReplyComponent", 2, "handleSourceMsgRecord msgId=" + msgItem.getMsgId() + " msgSeq=" + msgItem.getMsgSeq() + " replyMsgSeq=0");
            }
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Long l16 = replyElement.replyMsgClientSeq;
            Intrinsics.checkNotNullExpressionValue(l16, "replyElement.replyMsgClientSeq");
            long longValue = l16.longValue();
            Long l17 = replyElement.replyMsgTime;
            Intrinsics.checkNotNullExpressionValue(l17, "replyElement.replyMsgTime");
            iMsgService.getMsgByClientSeqAndTime(contact, longValue, l17.longValue(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    AIOReplyComponent.c3(u.this, this, replyElement, i3, str, arrayList);
                }
            });
            return;
        }
        if (msgItem.s0() != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOReplyComponent", 2, "[getSourceOfReplyMsgV2]: rootMsgId= " + msgItem.q0() + ", msgId= " + msgItem.getMsgId());
            }
            ((IMsgService) QRoute.api(IMsgService.class)).getSourceOfReplyMsgV2(new Contact(msgItem.p0(), msgItem.r0(), ""), msgItem.q0(), msgItem.getMsgId(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    AIOReplyComponent.d3(u.this, this, replyElement, i3, str, arrayList);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOReplyComponent", 2, "[getSourceOfReplyMsg]: msgId= " + msgItem.getMsgId() + ", replyMsgSeq= " + replyElement.replayMsgSeq);
        }
        IMsgService iMsgService2 = (IMsgService) QRoute.api(IMsgService.class);
        long msgId = msgItem.getMsgId();
        Long l18 = replyElement.replayMsgSeq;
        Intrinsics.checkNotNullExpressionValue(l18, "replyElement.replayMsgSeq");
        iMsgService2.getSourceOfReplyMsg(contact, msgId, l18.longValue(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                AIOReplyComponent.e3(u.this, this, replyElement, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[EDGE_INSN: B:15:0x004e->B:16:0x004e BREAK  A[LOOP:0: B:2:0x001c->B:19:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[LOOP:0: B:2:0x001c->B:19:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c3(u msgItem, AIOReplyComponent this$0, ReplyElement replyElement, int i3, String str, ArrayList msgList) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        Iterator it = msgList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                MsgRecord msgRecord = (MsgRecord) obj;
                long j3 = msgRecord.msgTime;
                Long l3 = replyElement.replyMsgTime;
                if (l3 != null && j3 == l3.longValue()) {
                    long j16 = msgRecord.clientSeq;
                    Long l16 = replyElement.replyMsgClientSeq;
                    if (l16 != null && j16 == l16.longValue()) {
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                obj = null;
                break;
            }
        }
        msgItem.Q2((MsgRecord) obj);
        this$0.l3(msgItem, replyElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(u msgItem, AIOReplyComponent this$0, ReplyElement replyElement, int i3, String str, ArrayList msgList) {
        Object firstOrNull;
        Long l3;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        MsgRecord msgRecord = (MsgRecord) firstOrNull;
        if (QLog.isColorLevel()) {
            if (msgRecord != null) {
                l3 = Long.valueOf(msgRecord.msgId);
            } else {
                l3 = null;
            }
            QLog.i("AIOReplyComponent", 2, "[getSourceOfReplyMsgV2]: sourceMsgRecord msgId= " + l3);
        }
        msgItem.Q2(msgRecord);
        this$0.l3(msgItem, replyElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(u msgItem, AIOReplyComponent this$0, ReplyElement replyElement, int i3, String str, ArrayList msgList) {
        Long l3;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        Iterator it = msgList.iterator();
        while (true) {
            l3 = null;
            if (it.hasNext()) {
                obj = it.next();
                long j3 = ((MsgRecord) obj).msgSeq;
                Long l16 = replyElement.replayMsgSeq;
                if (l16 != null && j3 == l16.longValue()) {
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
        MsgRecord msgRecord = (MsgRecord) obj;
        if (QLog.isColorLevel()) {
            if (msgRecord != null) {
                l3 = Long.valueOf(msgRecord.msgId);
            }
            QLog.i("AIOReplyComponent", 2, "[getSourceOfReplyMsg]: sourceMsgRecord msgId= " + l3);
        }
        msgItem.Q2(msgRecord);
        this$0.l3(msgItem, replyElement);
    }

    private final void f3(List<o.b> msgItemList) {
        if (c2().isEmpty() && a2().isEmpty()) {
            Iterator<o.b> it = msgItemList.iterator();
            while (it.hasNext()) {
                if (it.next().e()) {
                    V1();
                } else {
                    W1();
                }
            }
        }
    }

    private final void g3() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        ImageView imageView = mVar.f444850g;
        imageView.setContentDescription(getMContext().getString(R.string.t0t));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOReplyComponent.h3(AIOReplyComponent.this, view);
            }
        });
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar3;
        }
        TextView textView = mVar2.f444847d;
        ImmersiveUtils.setAlpha(textView, 0.5f);
        textView.setTextSize(1, 13.0f);
        textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
        aVar.g(R2(), this);
        aVar.f(R2(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    public static final void h3(AIOReplyComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AIOReplyComponent", 1, "replayLocateClick");
        ReplyElement c16 = com.tencent.mobileqq.aio.reply.c.c(this$0.q1());
        if (c16 != null) {
            QLog.d("AIOReplyComponent", 1, "replayLocateClick isRevokedReplyMsg :  " + ((u) this$0.q1()).M0() + ": replayMsgId is " + c16.replayMsgId + ", replayMsgSeq is " + c16.replayMsgSeq + ", replayMsgTime is " + c16.replyMsgTime + ", clientSeq is " + c16.replyMsgClientSeq);
            if (com.tencent.mobileqq.aio.utils.d.b0(this$0.q1())) {
                this$0.Z2(c16);
            } else {
                this$0.a3(c16);
            }
        }
        HashMap<String, Object> W2 = this$0.W2();
        W2.put("operating_area", "2");
        com.tencent.mobileqq.aio.utils.b.l("em_bas_reference_message", W2);
        this$0.C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i3() {
        Drawable drawable;
        Integer num;
        ColorStateList colorStateList;
        if (!QLog.isColorLevel()) {
            return;
        }
        AIOBubbleSkinInfo x06 = ((u) q1()).x0();
        if (x06 == null) {
            QLog.w("AIOReplyComponent", 1, "[logMsgBubbleInfo] bubble info not exists, msgId=" + ((u) q1()).getMsgId());
            return;
        }
        if (QLog.isDevelopLevel()) {
            long msgId = ((u) q1()).getMsgId();
            int hashCode = R2().hashCode();
            AIOBubbleSkinInfo.BackgroundImageInfo a16 = x06.a();
            Integer num2 = null;
            if (a16 != null) {
                drawable = a16.a();
            } else {
                drawable = null;
            }
            AIOBubbleSkinInfo.c e16 = x06.e();
            if (e16 != null) {
                num = e16.a();
            } else {
                num = null;
            }
            AIOBubbleSkinInfo.c e17 = x06.e();
            if (e17 != null) {
                colorStateList = e17.b();
            } else {
                colorStateList = null;
            }
            HashMap<Integer, Drawable> n26 = ((u) q1()).n2();
            if (n26 != null) {
                num2 = Integer.valueOf(n26.size());
            }
            QLog.i("AIOReplyComponent", 4, "[logMsgBubbleInfo] msgId=" + msgId + " content=" + hashCode + " background=" + drawable + " textColor=" + num + " textColors=" + colorStateList + " fontDrawableSize=" + num2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean j3(o msgItem, List<Object> payloads) {
        ReplyElement c16;
        com.tencent.mobileqq.aio.msglist.holder.skin.a t06;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.REPLY_MSG_REVOKED_PAYLOAD) != null) {
                    w3(msgItem);
                    QLog.d("AIOReplyComponent", 1, "REPLY_MSG_REVOKED_PAYLOAD msgId=" + ((u) q1()).getMsgId() + " msgSeq=" + ((u) q1()).getMsgSeq() + " revoked!");
                }
                if (map.get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                    p2(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.SHOOT_BUBBLE_PAYLOAD) != null && (t06 = ((u) q1()).t0()) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOReplyComponent", 4, "[handleShotBubblePayload]: msgId is " + ((u) q1()).getMsgId() + ", qqtext is " + ((Object) ((u) q1()).E2()));
                    }
                    d2().f(t06);
                    t06.c(false);
                }
                if (map.get(AIOMsgItemPayloadType.VAS_FONT_PAYLOAD) != null) {
                    p2(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.MEDIA_PATH_PAYLOAD) != null && (c16 = com.tencent.mobileqq.aio.reply.c.c(msgItem)) != null) {
                    Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ReplyMsgItem");
                    b3((u) msgItem, c16);
                }
                if (map.get(AIOMsgItemPayloadType.LOAD_AVATAR_PENDANT_PAYLOAD) != null) {
                    d2().e();
                }
                if (map.get(AIOMsgItemPayloadType.SHOT_MOSAIC) != null) {
                    r3(msgItem.L0());
                }
                if (map.get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null) {
                    p2(msgItem);
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k3(long loadImageMsgId, boolean success) {
        QLog.d("AIOReplyComponent", 1, "onLoadImage loadImageMsgId=" + loadImageMsgId + ", msgId=" + ((u) q1()).getMsgId());
        if (loadImageMsgId == ((u) q1()).getMsgId() && success) {
            m mVar = this.mSourceContentBinding;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar = null;
            }
            RoundBubbleImageView roundBubbleImageView = mVar.f444858o;
            Intrinsics.checkNotNullExpressionValue(roundBubbleImageView, "mSourceContentBinding.thumbnailReplySource");
            N2(roundBubbleImageView);
        }
    }

    private final void l3(u msgItem, ReplyElement replyElement) {
        Long l3;
        long msgId = msgItem.getMsgId();
        MsgRecord D2 = msgItem.D2();
        if (D2 != null) {
            l3 = Long.valueOf(D2.msgId);
        } else {
            l3 = null;
        }
        QLog.d("AIOReplyComponent", 1, "parseReplyMsgRecord, msgId=" + msgId + ", replyMsgId=" + l3);
        BuildersKt__Builders_commonKt.launch$default(S2(), Dispatchers.getMain(), null, new AIOReplyComponent$parseReplyMsgRecord$1(this, msgItem, replyElement, null), 2, null);
    }

    private final void n3() {
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444855l.setVisibility(8);
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444851h.setVisibility(8);
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        mVar4.f444848e.setVisibility(8);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        mVar5.f444849f.setVisibility(8);
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar6 = null;
        }
        mVar6.f444858o.setVisibility(8);
        m mVar7 = this.mSourceContentBinding;
        if (mVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar7 = null;
        }
        mVar7.f444850g.setVisibility(8);
        m mVar8 = this.mSourceContentBinding;
        if (mVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar8 = null;
        }
        mVar8.f444847d.setVisibility(8);
        m mVar9 = this.mSourceContentBinding;
        if (mVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar9 = null;
        }
        mVar9.f444854k.setVisibility(8);
        m mVar10 = this.mSourceContentBinding;
        if (mVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar10;
        }
        mVar2.f444856m.setVisibility(8);
    }

    private final void o3(CharSequence msgDownQQText) {
        if (!TextUtils.isEmpty(msgDownQQText)) {
            m mVar = this.mSourceContentBinding;
            m mVar2 = null;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar = null;
            }
            mVar.f444851h.setText(msgDownQQText);
            m mVar3 = this.mSourceContentBinding;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            } else {
                mVar2 = mVar3;
            }
            mVar2.f444851h.setVisibility(0);
        }
    }

    private final void p3(u msgItem) {
        if (msgItem.G2()) {
            m mVar = this.mSourceContentBinding;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar = null;
            }
            mVar.f444855l.setText(getMContext().getString(R.string.f221136a0));
            mVar.f444855l.setVisibility(0);
            mVar.f444849f.setVisibility(8);
        }
    }

    private final void r3(boolean isMosaic) {
        m mVar = null;
        if (isMosaic) {
            m mVar2 = this.mSourceContentBinding;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            } else {
                mVar = mVar2;
            }
            mVar.f444854k.setMosaicEffect(new com.tencent.mobileqq.qqui.widget.b(10));
            return;
        }
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444854k.setMosaicEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s3(final MsgRecord replyMsgRecord, final MsgElement mediaElement, String path, PicSize picSize) {
        int coerceAtLeast;
        int coerceAtLeast2;
        m mVar = this.mSourceContentBinding;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        final RoundBubbleImageView roundBubbleImageView = mVar.f444858o;
        Pair<Integer, Integer> U2 = U2(mediaElement);
        int intValue = U2.component1().intValue();
        int intValue2 = U2.component2().intValue();
        roundBubbleImageView.getLayoutParams().width = intValue;
        roundBubbleImageView.getLayoutParams().height = intValue2;
        QLog.d("AIOReplyComponent", 1, "[setReplyPicThumb] msgId=" + ((u) q1()).getMsgId() + " replyMsgId=" + replyMsgRecord.msgId + " size=" + intValue + "," + intValue2 + " path=" + path);
        final WeakReference weakReference = new WeakReference(this);
        final long msgId = ((u) q1()).getMsgId();
        AIOPicDownloader aIOPicDownloader = AIOPicDownloader.f190570a;
        Intrinsics.checkNotNullExpressionValue(roundBubbleImageView, "this");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(roundBubbleImageView.getLayoutParams().width, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(roundBubbleImageView.getLayoutParams().height, 0);
        aIOPicDownloader.u(roundBubbleImageView, path, coerceAtLeast, coerceAtLeast2, PicUtil.f191410a.g(roundBubbleImageView.getLayoutParams().width, roundBubbleImageView.getLayoutParams().height), picSize, mediaElement, (w) q1(), new Function2<Boolean, PicContentViewUtil.FailReason, Unit>(weakReference, msgId) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$setReplyPicThumb$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $loadImageMsgId;
            final /* synthetic */ WeakReference<AIOReplyComponent> $weakSelf;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$weakSelf = weakReference;
                this.$loadImageMsgId = msgId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, weakReference, Long.valueOf(msgId));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, PicContentViewUtil.FailReason failReason) {
                invoke(bool.booleanValue(), failReason);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull PicContentViewUtil.FailReason failReason) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), failReason);
                    return;
                }
                Intrinsics.checkNotNullParameter(failReason, "<anonymous parameter 1>");
                QLog.d("AIOReplyComponent", 1, "setReplyPicThumb loadImageView success=" + z16);
                AIOReplyComponent aIOReplyComponent = this.$weakSelf.get();
                if (aIOReplyComponent == null) {
                    return;
                }
                aIOReplyComponent.k3(this.$loadImageMsgId, z16);
            }
        });
        roundBubbleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOReplyComponent.t3(AIOReplyComponent.this, replyMsgRecord, mediaElement, roundBubbleImageView, view);
            }
        });
        roundBubbleImageView.setRadiusDP(4.0f);
        roundBubbleImageView.setVisibility(0);
        roundBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundBubbleImageView.setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(false));
        roundBubbleImageView.setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(false));
        m mVar2 = this.mSourceContentBinding;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar2 = null;
        }
        mVar2.f444849f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t3(AIOReplyComponent this$0, MsgRecord replyMsgRecord, MsgElement mediaElement, RoundBubbleImageView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyMsgRecord, "$replyMsgRecord");
        Intrinsics.checkNotNullParameter(mediaElement, "$mediaElement");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QLog.d("AIOReplyComponent", 1, "setReplyPicThumb onClick");
        AIOMsgItem aIOMsgItem = new AIOMsgItem(replyMsgRecord);
        long q06 = ((u) this$0.q1()).q0();
        int i3 = aIOMsgItem.getMsgRecord().chatType;
        int i16 = aIOMsgItem.getMsgRecord().sendType;
        String str = aIOMsgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        long j3 = aIOMsgItem.getMsgRecord().peerUin;
        long j16 = ((u) this$0.q1()).getMsgRecord().msgId;
        int i17 = ((u) this$0.q1()).getMsgRecord().chatType;
        int i18 = ((u) this$0.q1()).getMsgRecord().sendType;
        String str2 = ((u) this$0.q1()).getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "mCurrentMsgItem.msgRecord.peerUid");
        aIOMsgItem.L1(new MsgRecordParams(q06, i3, i16, str, j3, new MsgRecordParams(j16, i17, i18, str2, ((u) this$0.q1()).getMsgRecord().peerUin, null, 32, null)));
        aIOMsgItem.M1(((u) this$0.q1()).m0());
        this$0.sendIntent(new d.am(aIOMsgItem, mediaElement, this_apply, 0L));
        this$0.C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u3(u msgItem, ReplyElement replyElement, MsgRecord replyMsgRecord) {
        String str;
        String str2;
        Spannable spannable;
        Integer num;
        CharSequence a16 = al.a(replyMsgRecord);
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444856m.setText(msgItem.C2().i());
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444854k.setText(((Object) a16) + " ");
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        mVar4.f444856m.setVisibility(0);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        mVar5.f444854k.setVisibility(0);
        if (msgItem.M0()) {
            w3(msgItem);
            return;
        }
        if (msgItem.G2()) {
            p3(msgItem);
            return;
        }
        v3(msgItem, replyElement);
        String str3 = "";
        if (msgItem.C2().d() == null) {
            str = "";
        } else {
            MsgElement d16 = msgItem.C2().d();
            if (d16 != null) {
                num = Integer.valueOf(d16.elementType);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 5) {
                m mVar6 = this.mSourceContentBinding;
                if (mVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                    mVar6 = null;
                }
                mVar6.f444848e.setImageResource(R.drawable.htx);
                m mVar7 = this.mSourceContentBinding;
                if (mVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                    mVar7 = null;
                }
                mVar7.f444848e.setVisibility(0);
                str = HardCodeUtil.qqStr(R.string.ypf).toString();
            } else {
                if (num != null && num.intValue() == 3) {
                    MsgElement d17 = msgItem.C2().d();
                    Intrinsics.checkNotNull(d17);
                    FileElement fileElement = d17.fileElement;
                    Intrinsics.checkNotNullExpressionValue(fileElement, "msgItem.replyMsgInfo.mediaMsgElement!!.fileElement");
                    if (c81.a.j(fileElement) == 2) {
                        m mVar8 = this.mSourceContentBinding;
                        if (mVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                            mVar8 = null;
                        }
                        mVar8.f444848e.setImageResource(R.drawable.htx);
                        m mVar9 = this.mSourceContentBinding;
                        if (mVar9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                            mVar9 = null;
                        }
                        mVar9.f444848e.setVisibility(0);
                        str = HardCodeUtil.qqStr(R.string.ypf).toString();
                    }
                }
                str = "";
            }
            MsgRecord D2 = msgItem.D2();
            Intrinsics.checkNotNull(D2);
            MsgElement d18 = msgItem.C2().d();
            Intrinsics.checkNotNull(d18);
            s3(D2, d18, msgItem.C2().e(), msgItem.C2().g());
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.yp6).toString();
            }
        }
        o3(msgItem.z2());
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            m mVar10 = this.mSourceContentBinding;
            if (mVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar10 = null;
            }
            mVar10.f444855l.setImportantForAccessibility(2);
            if (TextUtils.isEmpty(msgItem.E2())) {
                str2 = "";
            } else {
                str2 = s.b(msgItem.E2().toString());
            }
            if (!TextUtils.isEmpty(msgItem.z2())) {
                str3 = s.b(msgItem.z2().toString());
            }
            m mVar11 = this.mSourceContentBinding;
            if (mVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar11 = null;
            }
            RelativeLayout relativeLayout = mVar11.f444853j;
            m mVar12 = this.mSourceContentBinding;
            if (mVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar12 = null;
            }
            CharSequence text = mVar12.f444854k.getText();
            m mVar13 = this.mSourceContentBinding;
            if (mVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar13 = null;
            }
            CharSequence text2 = mVar13.f444856m.getText();
            relativeLayout.setContentDescription(((Object) text) + ((Object) text2) + HardCodeUtil.qqStr(R.string.ype) + str2 + str + str3);
            CharSequence E2 = msgItem.E2();
            if (E2 instanceof Spannable) {
                spannable = (Spannable) E2;
            } else {
                spannable = null;
            }
            if (spannable != null) {
                m mVar14 = this.mSourceContentBinding;
                if (mVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                } else {
                    mVar2 = mVar14;
                }
                mVar2.f444853j.setAccessibilityDelegate(new b(spannable, this));
            }
        }
    }

    private final void v3(u msgItem, ReplyElement replyElement) {
        boolean z16;
        CharSequence E2 = msgItem.E2();
        MsgRecord D2 = msgItem.D2();
        if (D2 != null) {
            z16 = al.c(D2);
        } else {
            z16 = false;
        }
        m mVar = null;
        if (z16) {
            MsgRecord D22 = msgItem.D2();
            Intrinsics.checkNotNull(D22);
            E2 = com.tencent.mobileqq.aio.reply.c.e(D22, false, null, 4, null);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOReplyComponent", 4, "setUpSourceContent sourceText=" + ((Object) AIOUtil.f194084a.o(E2)));
        }
        if (TextUtils.isEmpty(E2) && msgItem.C2().d() == null) {
            E2 = Y2(replyElement);
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOReplyComponent", 4, "getSummarySourceText sourceText=" + ((Object) AIOUtil.f194084a.o(E2)));
            }
        }
        if (!TextUtils.isEmpty(E2)) {
            m mVar2 = this.mSourceContentBinding;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar2 = null;
            }
            mVar2.f444855l.setText(E2);
            m mVar3 = this.mSourceContentBinding;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            } else {
                mVar = mVar3;
            }
            mVar.f444855l.setVisibility(0);
            x3(msgItem);
        }
    }

    private final void w3(AIOMsgItem msgItem) {
        if (msgItem.M0()) {
            m mVar = this.mSourceContentBinding;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar = null;
            }
            mVar.f444855l.setText(getMContext().getString(R.string.f221126_z));
            mVar.f444855l.setVisibility(0);
            mVar.f444849f.setVisibility(8);
        }
    }

    private final void x3(u msgItem) {
        Drawable drawable;
        Drawable Q2 = Q2(msgItem.C2().a());
        Drawable V2 = V2(msgItem);
        m mVar = null;
        if (Q2 == null && V2 == null) {
            m mVar2 = this.mSourceContentBinding;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar2 = null;
            }
            mVar2.f444855l.setCompoundDrawablePadding(0);
            m mVar3 = this.mSourceContentBinding;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar3 = null;
            }
            mVar3.f444855l.setCompoundDrawables(null, null, null, null);
        } else {
            m mVar4 = this.mSourceContentBinding;
            if (mVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar4 = null;
            }
            mVar4.f444855l.setCompoundDrawablePadding(X);
            m mVar5 = this.mSourceContentBinding;
            if (mVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar5 = null;
            }
            AIOMsgTextView aIOMsgTextView = mVar5.f444855l;
            if (V2 == null) {
                drawable = Q2;
            } else {
                drawable = V2;
            }
            aIOMsgTextView.setCompoundDrawables(drawable, null, null, null);
        }
        if (!msgItem.I2() && Q2 == null && V2 == null) {
            m mVar6 = this.mSourceContentBinding;
            if (mVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar6 = null;
            }
            mVar6.f444855l.setMaxLines(2);
            m mVar7 = this.mSourceContentBinding;
            if (mVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            } else {
                mVar = mVar7;
            }
            mVar.f444855l.setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        m mVar8 = this.mSourceContentBinding;
        if (mVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar8 = null;
        }
        mVar8.f444855l.setMaxLines(1);
        m mVar9 = this.mSourceContentBinding;
        if (mVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar = mVar9;
        }
        mVar.f444855l.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }

    private final void y3(com.tencent.mobileqq.aio.msglist.holder.skin.padding.h info) {
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        int paddingLeft = mVar.f444853j.getPaddingLeft();
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        int b16 = a.C7329a.f192417a.b() - ((((paddingLeft + mVar3.f444853j.getPaddingRight()) + info.k()) + info.l()) + (V * 2));
        this.maxTextWidth = b16;
        this.maxPicWidth = b16;
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        AIOMsgTextView aIOMsgTextView = mVar4.f444855l;
        int maxWidth = aIOMsgTextView.getMaxWidth();
        int i3 = this.maxTextWidth;
        if (maxWidth != i3) {
            aIOMsgTextView.setMaxWidth(i3);
        }
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        TextView textView = mVar5.f444851h;
        int maxWidth2 = textView.getMaxWidth();
        int i16 = this.maxTextWidth;
        if (maxWidth2 != i16) {
            textView.setMaxWidth(i16);
        }
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar6;
        }
        RoundBubbleImageView roundBubbleImageView = mVar2.f444858o;
        Intrinsics.checkNotNullExpressionValue(roundBubbleImageView, "mSourceContentBinding.thumbnailReplySource");
        N2(roundBubbleImageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z3(com.tencent.mobileqq.aio.msglist.holder.skin.padding.h info) {
        int i3;
        int i16;
        m mVar;
        int i17;
        int i18;
        int i19;
        int i26;
        int o16;
        int i27;
        int o17;
        int i28;
        int i29;
        int i36;
        int i37;
        ViewGroup.LayoutParams layoutParams;
        int i38;
        int i39;
        ViewGroup.LayoutParams layoutParams2;
        int i46;
        int i47;
        ViewGroup.LayoutParams layoutParams3;
        int i48;
        int i49;
        ViewGroup.LayoutParams layoutParams4;
        int i56;
        int i57;
        int i58;
        List<o.b> o26 = ((u) q1()).o2();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = o26.iterator();
        while (true) {
            i3 = 1;
            i16 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            o.b bVar = (o.b) next;
            if (bVar.b() == null && bVar.c() == null) {
                i3 = 0;
            }
            if (i3 != 0) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        int i59 = 0;
        int i65 = 0;
        int i66 = 0;
        while (i59 < size) {
            o.b bVar2 = (o.b) arrayList.get(i59);
            if (i59 == 0) {
                i17 = i3;
            } else {
                i17 = i16;
            }
            if (i59 == arrayList.size() - i3) {
                i18 = i3;
            } else {
                i18 = i16;
            }
            if (bVar2.b() != null) {
                if (i65 >= a2().size()) {
                    Object[] objArr = new Object[2];
                    objArr[i16] = "[updateReplyContentLayout] picViewIndex IndexOutOfBoundsException.";
                    objArr[i3] = "picViewIndex=" + i65 + ", picViewSize=" + a2().size();
                    QLog.e("AIOReplyComponent", i3, objArr);
                    i19 = size;
                    i26 = i3;
                } else {
                    RoundBubbleImageView roundBubbleImageView = a2().get(i65);
                    if (i17 != 0) {
                        o17 = info.e();
                    } else {
                        o17 = info.o();
                    }
                    if (i18 != 0) {
                        i28 = info.b();
                    } else {
                        i28 = i16;
                    }
                    int c16 = info.c();
                    int d16 = info.d();
                    ViewGroup.LayoutParams layoutParams5 = roundBubbleImageView.getLayoutParams();
                    if (!(layoutParams5 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams5 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams5;
                    if (marginLayoutParams != null) {
                        i29 = marginLayoutParams.leftMargin;
                    } else {
                        i29 = i16;
                    }
                    if (i29 == c16) {
                        ViewGroup.LayoutParams layoutParams6 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams6 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams6 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams6;
                        if (marginLayoutParams2 != null) {
                            i56 = marginLayoutParams2.rightMargin;
                        } else {
                            i56 = i16;
                        }
                        if (i56 == d16) {
                            ViewGroup.LayoutParams layoutParams7 = roundBubbleImageView.getLayoutParams();
                            if (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams7 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams7;
                            if (marginLayoutParams3 != null) {
                                i57 = marginLayoutParams3.topMargin;
                            } else {
                                i57 = i16;
                            }
                            if (i57 == o17) {
                                ViewGroup.LayoutParams layoutParams8 = roundBubbleImageView.getLayoutParams();
                                if (!(layoutParams8 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams8 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams8;
                                if (marginLayoutParams4 != null) {
                                    i58 = marginLayoutParams4.bottomMargin;
                                } else {
                                    i58 = i16;
                                }
                                if (i58 == i28) {
                                    i19 = size;
                                    Unit unit = Unit.INSTANCE;
                                    i65++;
                                    i16 = 0;
                                    i26 = 1;
                                }
                            }
                        }
                    }
                    ViewGroup.LayoutParams layoutParams9 = roundBubbleImageView.getLayoutParams();
                    if (!(layoutParams9 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams9 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams9;
                    if (marginLayoutParams5 != null) {
                        MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, c16);
                        i19 = size;
                        layoutParams = marginLayoutParams5;
                    } else {
                        ViewGroup.LayoutParams layoutParams10 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams10 != null) {
                            i36 = layoutParams10.width;
                        } else {
                            i36 = i16;
                        }
                        ViewGroup.LayoutParams layoutParams11 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams11 != null) {
                            i37 = layoutParams11.height;
                            i19 = size;
                        } else {
                            i19 = size;
                            i37 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams12 = new ViewGroup.LayoutParams(i36, i37);
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = layoutParams12;
                        ArrayList arrayList2 = new ArrayList(i3);
                        arrayList2.add(objArr2[0].getClass());
                        Object[] array = arrayList2.toArray(new Class[0]);
                        if (array != null) {
                            Class[] clsArr = (Class[]) array;
                            Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            it5.setAccessible(true);
                            Object newInstance = it5.newInstance(Arrays.copyOf(objArr2, 1));
                            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, c16);
                            layoutParams = (ViewGroup.LayoutParams) newInstance;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    roundBubbleImageView.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams13 = roundBubbleImageView.getLayoutParams();
                    if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams13 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams13;
                    if (marginLayoutParams6 != null) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams6, d16);
                        layoutParams2 = marginLayoutParams6;
                    } else {
                        ViewGroup.LayoutParams layoutParams14 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams14 != null) {
                            i38 = layoutParams14.width;
                        } else {
                            i38 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams15 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams15 != null) {
                            i39 = layoutParams15.height;
                        } else {
                            i39 = 0;
                        }
                        Object[] objArr3 = {new ViewGroup.LayoutParams(i38, i39)};
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(objArr3[0].getClass());
                        Object[] array2 = arrayList3.toArray(new Class[0]);
                        if (array2 != null) {
                            Class[] clsArr2 = (Class[]) array2;
                            Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                            Intrinsics.checkNotNullExpressionValue(it6, "it");
                            it6.setAccessible(true);
                            Object newInstance2 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, d16);
                            layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    roundBubbleImageView.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams16 = roundBubbleImageView.getLayoutParams();
                    if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams16 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams16;
                    if (marginLayoutParams7 != null) {
                        marginLayoutParams7.topMargin = o17;
                        layoutParams3 = marginLayoutParams7;
                    } else {
                        ViewGroup.LayoutParams layoutParams17 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams17 != null) {
                            i46 = layoutParams17.width;
                        } else {
                            i46 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams18 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams18 != null) {
                            i47 = layoutParams18.height;
                        } else {
                            i47 = 0;
                        }
                        Object[] objArr4 = {new ViewGroup.LayoutParams(i46, i47)};
                        ArrayList arrayList4 = new ArrayList(1);
                        arrayList4.add(objArr4[0].getClass());
                        Object[] array3 = arrayList4.toArray(new Class[0]);
                        if (array3 != null) {
                            Class[] clsArr3 = (Class[]) array3;
                            Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                            Intrinsics.checkNotNullExpressionValue(it7, "it");
                            it7.setAccessible(true);
                            Object newInstance3 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance3).topMargin = o17;
                            layoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    roundBubbleImageView.setLayoutParams(layoutParams3);
                    ViewGroup.LayoutParams layoutParams19 = roundBubbleImageView.getLayoutParams();
                    if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams19 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams19;
                    if (marginLayoutParams8 != null) {
                        marginLayoutParams8.bottomMargin = i28;
                        layoutParams4 = marginLayoutParams8;
                    } else {
                        ViewGroup.LayoutParams layoutParams20 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams20 != null) {
                            i48 = layoutParams20.width;
                        } else {
                            i48 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams21 = roundBubbleImageView.getLayoutParams();
                        if (layoutParams21 != null) {
                            i49 = layoutParams21.height;
                        } else {
                            i49 = 0;
                        }
                        Object[] objArr5 = {new ViewGroup.LayoutParams(i48, i49)};
                        ArrayList arrayList5 = new ArrayList(1);
                        arrayList5.add(objArr5[0].getClass());
                        Object[] array4 = arrayList5.toArray(new Class[0]);
                        if (array4 != null) {
                            Class[] clsArr4 = (Class[]) array4;
                            Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                            Intrinsics.checkNotNullExpressionValue(it8, "it");
                            it8.setAccessible(true);
                            Object newInstance4 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance4).bottomMargin = i28;
                            layoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    roundBubbleImageView.setLayoutParams(layoutParams4);
                    Unit unit2 = Unit.INSTANCE;
                    i65++;
                    i16 = 0;
                    i26 = 1;
                }
            } else {
                i19 = size;
                if (bVar2.c() != null) {
                    if (i66 >= c2().size()) {
                        i16 = 0;
                        i26 = 1;
                        QLog.e("AIOReplyComponent", 1, "[updateReplyContentLayout] textViewIndex IndexOutOfBoundsException.", "textViewIndex=" + i66 + ", textViewSize=" + c2().size());
                    } else {
                        i16 = 0;
                        i26 = 1;
                        com.tencent.fastertextview.wrapper.a aVar = c2().get(i66);
                        if (i17 != 0) {
                            o16 = info.e();
                        } else {
                            o16 = info.o();
                        }
                        if (i18 != 0) {
                            i27 = info.b();
                        } else {
                            i27 = 0;
                        }
                        int c17 = info.c();
                        int d17 = info.d();
                        if (aVar.d() != c17 || aVar.e() != d17 || aVar.f() != o16 || aVar.c() != i27) {
                            aVar.l(c17, o16, d17, i27);
                        }
                        Unit unit3 = Unit.INSTANCE;
                        i66++;
                    }
                }
                i16 = 0;
                i26 = 1;
            }
            i59++;
            i3 = i26;
            size = i19;
        }
        m mVar2 = this.mSourceContentBinding;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        } else {
            mVar = mVar2;
        }
        RelativeLayout relativeLayout = mVar.f444853j;
        if (relativeLayout.getPaddingLeft() != info.n() || relativeLayout.getPaddingRight() != info.n() || relativeLayout.getPaddingTop() != info.n() || relativeLayout.getPaddingBottom() != info.n()) {
            relativeLayout.setPadding(info.n(), info.n(), info.n(), info.n());
        }
        Unit unit4 = Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: P2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AIOReplyComponentVM createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOReplyComponentVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AIOReplyComponentVM();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return R2().q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!j3((o) msgItem, payloads)) {
            return;
        }
        if (x1()) {
            QLog.d("AIOReplyComponent", 1, "[bind] same data, msgId=" + msgItem.getMsgId());
            return;
        }
        if (!((u) q1()).H2()) {
            ((u) q1()).P2(true);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_reference_message", W2());
        }
        g3();
        n3();
        List<o.b> o26 = ((u) q1()).o2();
        f3(o26);
        L2(o26);
        m2(-65281);
        i3();
        p2((o) q1());
        h2(new com.tencent.mobileqq.aio.msglist.holder.component.f(q1(), this, getContext(), T2()));
        d2().e();
        ReplyElement c16 = com.tencent.mobileqq.aio.reply.c.c((AIOMsgItem) msgItem);
        if (c16 == null) {
            QLog.d("AIOReplyComponent", 1, "bind replyElement == null");
        } else {
            b3((u) msgItem, c16);
        }
        r3(((u) q1()).L0());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return T2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return X1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        ReplyElement c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMsgItemUIState.ReplayNavigationFail) {
            QQToast.makeText(getMContext(), R.string.etu, 0).show(getMContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (state instanceof ReplyUIState.FetchNickRefresh) {
            if (((u) q1()).D2() == null && (c16 = com.tencent.mobileqq.aio.reply.c.c(q1())) != null) {
                E3((u) q1(), c16, ((ReplyUIState.FetchNickRefresh) state).a());
                return;
            }
            return;
        }
        super.handleUIState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        d.p pVar = new d.p(false, 1, null);
        sendIntent(pVar);
        if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack() && !pVar.a()) {
            R2().u(((u) q1()).isSelf());
            sendIntent(new d.ao(R2(), u1(), X2()));
        } else {
            super.h1();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void i2(@NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, drawable, Integer.valueOf(backgroundMinWidth), Integer.valueOf(backgroundMinHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        SelectableLinearLayout R2 = R2();
        Integer valueOf = Integer.valueOf(backgroundMinWidth);
        int intValue = valueOf.intValue();
        R2();
        if (intValue != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = null;
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        } else {
            R2();
            i3 = 0;
        }
        R2.setMinimumWidth(i3);
        SelectableLinearLayout R22 = R2();
        Integer valueOf2 = Integer.valueOf(backgroundMinHeight);
        int intValue2 = valueOf2.intValue();
        R2();
        if (intValue2 == 0) {
            z17 = false;
        }
        if (z17) {
            num = valueOf2;
        }
        if (num != null) {
            i16 = num.intValue();
        } else {
            R2();
        }
        R22.setMinimumHeight(i16);
        AIOUtil.f194084a.F(R2(), drawable);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (R2().q()) {
            sendIntent(d.f.f192343d);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, importance);
            return;
        }
        View X1 = X1();
        if (X1 != null) {
            X1.setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void m2(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, color);
            return;
        }
        super.m2(color);
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444855l.setTextColor(color);
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444851h.setTextColor(color);
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        mVar4.f444854k.setTextColor(color);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        mVar5.f444856m.setTextColor(color);
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar6;
        }
        mVar2.f444847d.setTextColor(color);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void n2(@NotNull ColorStateList colors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colors);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        super.n2(colors);
        m mVar = this.mSourceContentBinding;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar = null;
        }
        mVar.f444855l.setTextColor(colors);
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.f444851h.setTextColor(colors);
        m mVar4 = this.mSourceContentBinding;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar4 = null;
        }
        mVar4.f444854k.setTextColor(colors);
        m mVar5 = this.mSourceContentBinding;
        if (mVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar5 = null;
        }
        mVar5.f444856m.setTextColor(colors);
        m mVar6 = this.mSourceContentBinding;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
        } else {
            mVar2 = mVar6;
        }
        mVar2.f444847d.setTextColor(colors);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDestroy();
        if (w1()) {
            ((u) q1()).P2(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void r2(@NotNull AIOBubbleSkinInfo bubbleSkin) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.h hVar;
        Integer a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bubbleSkin);
            return;
        }
        Intrinsics.checkNotNullParameter(bubbleSkin, "bubbleSkin");
        super.r2(bubbleSkin);
        AIOBubbleSkinInfo.c e16 = bubbleSkin.e();
        LinearLayout.LayoutParams layoutParams = null;
        if (e16 != null && (a16 = e16.a()) != null) {
            int intValue = a16.intValue();
            m mVar = this.mSourceContentBinding;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar = null;
            }
            Drawable drawable = mVar.f444850g.getDrawable();
            if (drawable == null) {
                drawable = getContext().getResources().getDrawable(R.drawable.hl7);
            }
            Drawable mutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "ivLocateDrawable.mutate()");
            mutate.setColorFilter(new PorterDuffColorFilter(intValue, PorterDuff.Mode.SRC_ATOP));
            m mVar2 = this.mSourceContentBinding;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar2 = null;
            }
            mVar2.f444850g.setImageDrawable(mutate);
        }
        m mVar3 = this.mSourceContentBinding;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
            mVar3 = null;
        }
        mVar3.getRoot().setBackgroundDrawable(com.tencent.mobileqq.aio.reply.b.b(getContext().getResources(), (u) q1()));
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.h) {
            hVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.h) b16;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            m mVar4 = this.mSourceContentBinding;
            if (mVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                mVar4 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = mVar4.getRoot().getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams != null && (layoutParams.leftMargin != hVar.k() || layoutParams.rightMargin != hVar.l() || layoutParams.topMargin != hVar.m() || layoutParams.bottomMargin != hVar.j())) {
                layoutParams.leftMargin = hVar.k();
                layoutParams.rightMargin = hVar.l();
                layoutParams.topMargin = hVar.m();
                layoutParams.bottomMargin = hVar.j();
            }
            z3(hVar);
            y3(hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r7v13, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List listOf;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(getMContext(), q1());
        dVar.l(R2());
        Unit unit = Unit.INSTANCE;
        boolean z17 = false;
        i iVar = new i(getMContext(), q1());
        iVar.i(R2());
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{dVar, new k(getMContext(), q1(), this, null, 8, null), iVar, new af(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this), new ao(getMContext(), q1()), new ag(getMContext(), q1())});
        arrayList.addAll(listOf);
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            arrayList.add(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), R2()));
        }
        arrayList.add(new aj(getMContext(), q1(), this));
        if (((u) q1()).getMsgRecord().chatType == 2 || ((u) q1()).getMsgRecord().chatType == 1) {
            String b16 = com.tencent.mobileqq.aio.utils.m.f194167a.b(q1());
            if (b16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(b16, "0")) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(new n(getMContext(), q1(), this));
            }
        }
        return arrayList;
    }
}
