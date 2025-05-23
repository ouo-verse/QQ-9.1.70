package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.ApngDrawable;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.vipstatus.IVasAioVipPerceptionProxy;
import com.tencent.mobileqq.vas.vipstatus.IVasConfigProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOPttApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.MenuState;
import com.tencent.qqnt.aio.menu.aa;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ak;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.utils.af;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\n*\b\u00cd\u0001\u00d1\u0001\u00d5\u0001\u00d9\u0001\u0018\u0000 \u00df\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u00e0\u0001\u00e1\u0001B\u0013\u0012\b\u0010\u0086\u0001\u001a\u00030\u0081\u0001\u00a2\u0006\u0006\b\u00dd\u0001\u0010\u00de\u0001J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0017J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010'\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0016\u0010(\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0003J\u0010\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0002J\u0018\u00105\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0014H\u0002J\u0018\u00109\u001a\u00020\n2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0003H\u0002J \u0010:\u001a\u00020\n2\u0006\u00107\u001a\u0002062\u0006\u00104\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0003H\u0002J\u0010\u0010<\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010>\u001a\u00020\n2\u0006\u0010=\u001a\u00020\bH\u0002J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010@\u001a\u00020?H\u0002J\u0012\u0010C\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u0014H\u0002J\u0010\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0014H\u0002J\u0012\u0010F\u001a\u00020\n2\b\b\u0002\u0010D\u001a\u00020\u0014H\u0002J\b\u0010G\u001a\u00020\nH\u0002J\b\u0010H\u001a\u00020\nH\u0002J%\u0010K\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u0001012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0014H\u0002J\b\u0010O\u001a\u00020\u0014H\u0002J\u0010\u0010Q\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u001fH\u0002J\b\u0010R\u001a\u00020\nH\u0002J\b\u0010S\u001a\u00020\nH\u0002J\b\u0010U\u001a\u00020TH\u0002J\b\u0010V\u001a\u00020TH\u0002J\b\u0010W\u001a\u00020\nH\u0002J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020XH\u0002J\b\u0010[\u001a\u00020\nH\u0002J\u0014\u0010]\u001a\u00020\n2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010#H\u0002J\b\u0010^\u001a\u00020\nH\u0002J\u0010\u0010`\u001a\u00020\n2\u0006\u0010_\u001a\u00020\u0014H\u0002J\u0010\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020aH\u0002J\b\u0010d\u001a\u00020\nH\u0002J\b\u0010e\u001a\u00020\nH\u0002J\b\u0010f\u001a\u00020\nH\u0002J\u0012\u0010h\u001a\u00020\n2\b\u0010g\u001a\u0004\u0018\u00010#H\u0002J\b\u0010i\u001a\u00020\u0014H\u0002J\u0010\u0010k\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u001fH\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010I\u001a\u000201H\u0002J\b\u0010m\u001a\u00020\nH\u0002J\u0018\u0010p\u001a\u00020\n2\u0006\u0010n\u001a\u00020\u00142\u0006\u0010o\u001a\u00020\u0014H\u0002J\u0012\u0010q\u001a\u00020\n2\b\u0010g\u001a\u0004\u0018\u00010#H\u0002J\b\u0010r\u001a\u00020\nH\u0002J\u0010\u0010t\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u0014H\u0002J\b\u0010u\u001a\u00020\nH\u0002J\b\u0010v\u001a\u00020\nH\u0002J\b\u0010w\u001a\u00020\nH\u0002J\u001c\u0010z\u001a\u00020\n2\b\u0010y\u001a\u0004\u0018\u00010x2\b\u0010I\u001a\u0004\u0018\u000101H\u0002J \u0010|\u001a\u00020\n2\u0006\u0010y\u001a\u00020x2\u0006\u0010I\u001a\u0002012\u0006\u0010{\u001a\u00020\u001fH\u0002J\u0010\u0010~\u001a\u00020\n2\u0006\u0010}\u001a\u00020\u0014H\u0002J\u0018\u0010\u007f\u001a\u00020\n2\u0006\u0010y\u001a\u00020x2\u0006\u0010I\u001a\u000201H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0003H\u0002R\u001d\u0010\u0086\u0001\u001a\u00030\u0081\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R!\u0010\u008c\u0001\u001a\u00030\u0087\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0094\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009b\u0001\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009a\u0001R\u0019\u0010\u009f\u0001\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009a\u0001R\u0019\u0010\u00a1\u0001\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u009a\u0001R#\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u0089\u0001\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001R#\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a8\u0001\u0010\u0089\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0018\u0010\u00af\u0001\u001a\u00030\u00ac\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0019\u0010\u00b1\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u0097\u0001R!\u0010\u00b5\u0001\u001a\u00030\u00ac\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b2\u0001\u0010\u0089\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001b\u0010\u00b7\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u009a\u0001R\u001b\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00b8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0015\u0010\u00b9\u0001R\u001c\u0010\u00be\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001c\u0010\u00c0\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00bd\u0001R\u0019\u0010\u00c2\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u0097\u0001R\u0019\u0010\u00c4\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u009c\u0001R\u0019\u0010\u00c6\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u0097\u0001R \u0010\u00ca\u0001\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u0089\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00c9\u0001R \u0010\u00cc\u0001\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0089\u0001\u001a\u0006\b\u00cb\u0001\u0010\u00c9\u0001R\u0018\u0010\u00d0\u0001\u001a\u00030\u00cd\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u0018\u0010\u00d4\u0001\u001a\u00030\u00d1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u0018\u0010\u00d8\u0001\u001a\u00030\u00d5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u0018\u0010\u00dc\u0001\u001a\u00030\u00d9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00db\u0001\u00a8\u0006\u00e2\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/PttMsgItem;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Landroid/view/View;", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "h1", "", ExifInterface.LATITUDE_SOUTH, "d", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e1", "", NowProxyConstants.AccountInfoKey.A2, "t2", "u2", "Landroid/graphics/drawable/Drawable;", "bubbleDrawable", "Landroid/graphics/ColorFilter;", "filter", "C3", "K2", ICustomDataEditor.STRING_PARAM_2, "isSelf", "e3", "sendStatus", "w3", NodeProps.VISIBLE, "d3", "R2", "", "path", Constants.EMULATOR_INFO, "adjustWithSpeechToText", "y3", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "pttElement", "duration", "x3", "z3", "J2", "v2", "payload", "A3", "", "msgId", "U2", "needLog", "S2", "isFromClick", "g3", "h3", "N2", "J3", "text", "needShowAnim", "N3", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "success", "M3", "t3", "speed", "v3", "M2", "K3", "Lcom/tencent/qqnt/aio/menu/ui/c;", "H2", "I2", "u3", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "I3", "Y2", "dynamicDrawable", "q2", "H3", "isExpand", "L2", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/g;", "layoutInfo", "p2", "o3", ICustomDataEditor.NUMBER_PARAM_3, "x2", "drawable", "l3", "V2", "progress", Constants.BASE_IN_APP_NAME, "c3", "X2", "isVoiceChange", "hasPrefixDesc", "o2", "E3", "F3", "isSpeechShow", "B3", "Z2", ICustomDataEditor.STRING_ARRAY_PARAM_3, "b3", "Landroid/widget/TextView;", "textView", "p3", "line", "r3", "enable", "f3", ICustomDataEditor.STRING_PARAM_3, "F2", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lw71/k;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "z2", "()Lw71/k;", "binding", "Lw71/l;", "D", "Lw71/l;", "speechToTextBinding", "E", "Ljava/lang/String;", "pttPath", UserInfo.SEX_FEMALE, "currentSpeed", "G", "Z", "interceptLongClick", "H", "Landroid/graphics/drawable/Drawable;", "aioPttPlay", "I", "aioPttPause", "J", "aioPttVoiceChange", "K", "aioPttVoicePrintDefault", "Lmqq/app/AppRuntime;", "L", "y2", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/api/w;", "M", Constants.BASE_IN_PLUGIN_VERSION, "()Lcom/tencent/qqnt/kernel/api/w;", "msgService", "Landroid/os/Handler;", "N", "Landroid/os/Handler;", "handler", "P", "isVasBubble", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, Constants.MMCCID, "()Landroid/os/Handler;", "subHandler", BdhLogUtil.LogTag.Tag_Req, "loadingDrawable", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "loadingView", "Landroid/animation/ValueAnimator;", "T", "Landroid/animation/ValueAnimator;", "mTextTypingAnim", "U", "mTextMultiLineAnim", "V", "isPlayingWhenStartSeek", "W", "lastDurationWidth", "X", "isScaleAnimEnd", "Y", "B2", "()Z", "disableAnimSwitch", "C2", "disableAutoHideTextSwitch", "com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$aioPttAudioPlayerStateListener$1", "a0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$aioPttAudioPlayerStateListener$1;", "aioPttAudioPlayerStateListener", "com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$d", "b0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$d;", "onDragProgressListener", "com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$f", "c0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$f;", "seekProgressListener", "com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$e", "d0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$e;", "onSendAnimStartListener", "<init>", "(Landroid/content/Context;)V", "e0", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPttContentComponent extends BaseContentComponent<PttMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f0, reason: collision with root package name */
    @NotNull
    private static final PorterDuffColorFilter f191719f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final int f191720g0;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f191721h0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: D, reason: from kotlin metadata */
    private w71.l speechToTextBinding;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String pttPath;

    /* renamed from: F, reason: from kotlin metadata */
    private float currentSpeed;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean interceptLongClick;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final Drawable aioPttPlay;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final Drawable aioPttPause;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final Drawable aioPttVoiceChange;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final Drawable aioPttVoicePrintDefault;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgService;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isVasBubble;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy subHandler;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Drawable loadingDrawable;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView loadingView;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mTextTypingAnim;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mTextMultiLineAnim;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isPlayingWhenStartSeek;

    /* renamed from: W, reason: from kotlin metadata */
    private int lastDurationWidth;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isScaleAnimEnd;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy disableAnimSwitch;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy disableAutoHideTextSwitch;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOPttContentComponent$aioPttAudioPlayerStateListener$1 aioPttAudioPlayerStateListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d onDragProgressListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f seekProgressListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e onSendAnimStartListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0014\u0010\u001c\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0011\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$a;", "", "", "completeTipSwitchSubThread$delegate", "Lkotlin/Lazy;", "a", "()Z", "completeTipSwitchSubThread", "", "DISABLE_ANIM_SWITCH_KEY", "Ljava/lang/String;", "DISABLE_AUTO_HIDE_TEXT_SWITCH_KEY", "", "PTT_CONTENT_LEFT_PADDING_LARGE_FONT", UserInfo.SEX_FEMALE, "", "PTT_MENU_START_INDEX", "I", "", "SCALE_ANIM_DURATION", "J", "SEND_ANIM_DURATION", "STATUS_ANIM_DELAY", "STATUS_ANIM_DURATION", "TAG", "TEXT_FIRST_LINE_HEIGHT", "TEXT_MULTI_LINE_ANIM_INTERVAL", "TEXT_SINGLE_LINE_HEIGHT", "TEXT_TYPE_ANIM_INTERVAL", "TRANSLATE_SUCCESS", "VAS_VOICE_PRINT_EXTRA_WIDTH", "VOICE_CHANGE_ICON_WIDTH", "VOICE_RED_PACKET_WIDTH", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return ((Boolean) AIOPttContentComponent.f191721h0.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$b;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer;", "mp", "", "onCompletion", "", "d", UserInfo.SEX_FEMALE, "speed", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent;", "e", "Lmqq/util/WeakReference;", "ref", "aioPttContentComponent", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent;F)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float speed;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AIOPttContentComponent> ref;

        public b(@NotNull AIOPttContentComponent aioPttContentComponent, float f16) {
            Intrinsics.checkNotNullParameter(aioPttContentComponent, "aioPttContentComponent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aioPttContentComponent, Float.valueOf(f16));
            } else {
                this.speed = f16;
                this.ref = new WeakReference<>(aioPttContentComponent);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(@Nullable MediaPlayer mp5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mp5);
                return;
            }
            AIOPttContentComponent aIOPttContentComponent = this.ref.get();
            if (aIOPttContentComponent != null) {
                aIOPttContentComponent.sendIntent(new d.ae(AIOPttContentComponent.Y1(aIOPttContentComponent).getMsgId(), this.speed));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$c", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout$b;", "", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements SelectableLinearLayout.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.SelectableLinearLayout.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("AIOPttContentComponent", 1, "onStartTouch");
                AIOPttContentComponent.this.interceptLongClick = true;
            }
        }

        @Override // com.tencent.qqnt.aio.widget.SelectableLinearLayout.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i("AIOPttContentComponent", 1, "onEndTouch");
                AIOPttContentComponent.this.interceptLongClick = false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/PttAudioWaveView$a;", "", "a", "endDrag", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements PttAudioWaveView.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("AIOPttContentComponent", 1, "onDragOverSlop");
                AIOPttContentComponent.this.interceptLongClick = true;
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.a
        public void endDrag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i("AIOPttContentComponent", 1, "endDrag");
                AIOPttContentComponent.this.interceptLongClick = false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/PttAudioWaveView$b;", "", "onStart", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e implements PttAudioWaveView.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.b
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOPttContentComponent.this.o3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/PttAudioWaveView$c;", "", "progress", "", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/PttAudioWaveView;", "view", "", "c", "b", "", "canSupportSlide", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements PttAudioWaveView.c {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
            }
        }

        private final int d(float progress) {
            float coerceAtLeast;
            AIOPttContentComponent.this.x2();
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(progress, 0.0f);
            int r26 = (int) (coerceAtLeast * AIOPttContentComponent.Y1(AIOPttContentComponent.this).r2());
            AIOPttUtil.f191743a.j(AIOPttContentComponent.Y1(AIOPttContentComponent.this).getMsgId(), r26, AIOPttContentComponent.this.z2().f444826c.j());
            return r26;
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.c
        public void a(@Nullable PttAudioWaveView view, float progress, boolean canSupportSlide) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Float.valueOf(progress), Boolean.valueOf(canSupportSlide));
                return;
            }
            if (AIOPttContentComponent.this.pttPath == null) {
                return;
            }
            if (!canSupportSlide) {
                if (!AIOPttContentComponent.this.isScaleAnimEnd) {
                    d(progress);
                    AIOPttContentComponent.this.z2().f444826c.setProgress(progress);
                    return;
                }
                return;
            }
            int d16 = d(progress);
            if (!AIOPttContentComponent.this.isPlayingWhenStartSeek) {
                return;
            }
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
            String str = AIOPttContentComponent.this.pttPath;
            Intrinsics.checkNotNull(str);
            aIOPttAudioPlayerManager.E(str, d16, AIOPttContentComponent.this.currentSpeed, AIOPttContentComponent.Y1(AIOPttContentComponent.this).getMsgId());
            AIOPttContentComponent.this.isPlayingWhenStartSeek = false;
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.c
        public void b(@Nullable PttAudioWaveView view, float progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AIOPttContentComponent.this.D3(progress);
            } else {
                iPatchRedirector.redirect((short) 3, this, view, Float.valueOf(progress));
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.PttAudioWaveView.c
        public void c(@Nullable PttAudioWaveView view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOPttContentComponent.this.n3();
                AIOPttContentComponent aIOPttContentComponent = AIOPttContentComponent.this;
                AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
                aIOPttContentComponent.isPlayingWhenStartSeek = AIOPttAudioPlayerManager.p(aIOPttAudioPlayerManager, null, 0L, 3, null);
                if (AIOPttContentComponent.this.isPlayingWhenStartSeek) {
                    AIOPttAudioPlayerManager.v(aIOPttAudioPlayerManager, false, 1, null);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$g", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class g implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            AIOPttContentComponent.this.z2().f444831h.setVisibility(8);
            AIOPttContentComponent.this.z2().f444831h.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$h", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f191736d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f191737e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f191738f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f191739h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f191740i;

        h(String str, Ref.IntRef intRef, TextView textView, int i3, int i16) {
            this.f191736d = str;
            this.f191737e = intRef;
            this.f191738f = textView;
            this.f191739h = i3;
            this.f191740i = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, intRef, textView, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Integer num = null;
            if (animation != null) {
                obj = animation.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (animation != null && !TextUtils.isEmpty(this.f191736d) && num != null && this.f191737e.element < num.intValue()) {
                ViewGroup.LayoutParams layoutParams = this.f191738f.getLayoutParams();
                layoutParams.height = (this.f191739h * num.intValue()) / this.f191740i;
                this.f191738f.setLayoutParams(layoutParams);
                this.f191737e.element = num.intValue();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttContentComponent$i", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f191741d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f191742e;

        i(String str, TextView textView) {
            this.f191741d = str;
            this.f191742e = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) textView);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (animation != null && !TextUtils.isEmpty(this.f191741d)) {
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) animatedValue).intValue();
                if (this.f191742e.getText().length() - 1 < intValue) {
                    String obj = this.f191742e.getText().toString();
                    TextView textView = this.f191742e;
                    String str2 = this.f191741d;
                    if (str2 != null) {
                        str = str2.substring(intValue, intValue + 1);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    } else {
                        str = null;
                    }
                    textView.setText(obj + str);
                }
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        INSTANCE = new Companion(null);
        f191719f0 = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
        f191720g0 = ViewUtils.dpToPx(25.0f);
        lazy = LazyKt__LazyJVMKt.lazy(AIOPttContentComponent$Companion$completeTipSwitchSubThread$2.INSTANCE);
        f191721h0 = lazy;
    }

    public AIOPttContentComponent(@NotNull Context context) {
        Lazy lazy;
        Object m476constructorimpl;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w71.k>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent$binding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final w71.k invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (w71.k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                w71.k g16 = w71.k.g(LayoutInflater.from(AIOPttContentComponent.this.getContext()), null, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
                return g16;
            }
        });
        this.binding = lazy;
        this.currentSpeed = 1.0f;
        this.aioPttPlay = af.a(ContextCompat.getDrawable(context, R.drawable.j8l));
        this.aioPttPause = af.a(ContextCompat.getDrawable(context, R.drawable.j8k));
        this.aioPttVoiceChange = af.a(ContextCompat.getDrawable(context, R.drawable.c2s));
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(af.a(ContextCompat.getDrawable(context, R.drawable.j5i)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("AIOPttContentComponent", 1, "aioPttVoicePrintDefault onFailure:" + m479exceptionOrNullimpl.getMessage());
        }
        this.aioPttVoicePrintDefault = (Drawable) (Result.m482isFailureimpl(m476constructorimpl) ? null : m476constructorimpl);
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOPttContentComponent$appRuntime$2.INSTANCE);
        this.appRuntime = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.kernel.api.w>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent$msgService$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.qqnt.kernel.api.w invoke() {
                AppRuntime y26;
                IKernelService iKernelService;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.qqnt.kernel.api.w) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                y26 = AIOPttContentComponent.this.y2();
                if (y26 == null || (iKernelService = (IKernelService) y26.getRuntimeService(IKernelService.class, "")) == null) {
                    return null;
                }
                return iKernelService.getMsgService();
            }
        });
        this.msgService = lazy3;
        this.handler = new Handler(Looper.getMainLooper());
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOPttContentComponent$subHandler$2.INSTANCE);
        this.subHandler = lazy4;
        this.isScaleAnimEnd = true;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIOPttContentComponent$disableAnimSwitch$2.INSTANCE);
        this.disableAnimSwitch = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(AIOPttContentComponent$disableAutoHideTextSwitch$2.INSTANCE);
        this.disableAutoHideTextSwitch = lazy6;
        this.aioPttAudioPlayerStateListener = new AIOPttContentComponent$aioPttAudioPlayerStateListener$1(this);
        this.onDragProgressListener = new d();
        this.seekProgressListener = new f();
        this.onSendAnimStartListener = new e();
    }

    private final void A3(Object payload) {
        if (payload instanceof a.ao) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPttContentComponent", 2, "updateBindUIState  PttTranslatePayload");
            }
            N3(((a.ao) payload).a(), Boolean.TRUE);
            K3();
        }
    }

    private final boolean B2() {
        return ((Boolean) this.disableAnimSwitch.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B3(boolean isSpeechShow) {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2;
        ConstraintLayout.LayoutParams layoutParams3;
        w71.l lVar;
        int i3;
        ViewGroup.LayoutParams layoutParams4;
        RelativeLayout relativeLayout = z2().f444827d;
        w71.l lVar2 = null;
        if (relativeLayout != null) {
            layoutParams = relativeLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        w71.l lVar3 = this.speechToTextBinding;
        if (lVar3 != null) {
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar3 = null;
            }
            FrameLayout root = lVar3.getRoot();
            if (root != null) {
                layoutParams4 = root.getLayoutParams();
            } else {
                layoutParams4 = null;
            }
            if (layoutParams4 instanceof ConstraintLayout.LayoutParams) {
                layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams4;
                int i16 = 0;
                if (!isSpeechShow) {
                    if (com.tencent.mobileqq.aio.utils.m.f194167a.c(q1())) {
                        i3 = ViewUtils.dpToPx(4.0f);
                    } else {
                        i3 = 0;
                    }
                    if (layoutParams3 != null) {
                        layoutParams3.topToBottom = z2().f444827d.getId();
                    }
                    if (layoutParams3 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = i3;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.bottomToBottom = -1;
                    }
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
                    }
                    i16 = ViewUtils.dpToPx(10.0f);
                } else {
                    if (layoutParams3 != null) {
                        layoutParams3.topToBottom = -1;
                    }
                    if (layoutParams3 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = 0;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.bottomToBottom = 0;
                    }
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ViewUtils.dpToPx(10.0f);
                    }
                }
                if (layoutParams2 != null) {
                    z2().f444827d.setLayoutParams(layoutParams2);
                }
                if (layoutParams3 != null) {
                    w71.l lVar4 = this.speechToTextBinding;
                    if (lVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                        lVar4 = null;
                    }
                    lVar4.getRoot().setLayoutParams(layoutParams3);
                }
                lVar = this.speechToTextBinding;
                if (lVar == null) {
                    if (lVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    } else {
                        lVar2 = lVar;
                    }
                    FrameLayout root2 = lVar2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "speechToTextBinding.root");
                    root2.setPadding(root2.getPaddingLeft(), root2.getPaddingTop(), root2.getPaddingRight(), i16);
                    return;
                }
                return;
            }
        }
        layoutParams3 = null;
        int i162 = 0;
        if (!isSpeechShow) {
        }
        if (layoutParams2 != null) {
        }
        if (layoutParams3 != null) {
        }
        lVar = this.speechToTextBinding;
        if (lVar == null) {
        }
    }

    private final boolean C2() {
        return ((Boolean) this.disableAutoHideTextSwitch.getValue()).booleanValue();
    }

    private final void C3(Drawable bubbleDrawable, ColorFilter filter) {
        if (!TokenResUtils.useSimpleBubble() && QQTheme.isNowSimpleUI() && bubbleDrawable != null) {
            bubbleDrawable.setColorFilter(filter);
            bubbleDrawable.invalidateSelf();
        }
    }

    private final com.tencent.qqnt.kernel.api.w D2() {
        return (com.tencent.qqnt.kernel.api.w) this.msgService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D3(float progress) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((int) (progress * q1().r2())) / 1000, 1);
        c3(AIOPttUtil.f191743a.e(coerceAtLeast));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E3(Drawable drawable) {
        if (drawable != null && !Intrinsics.areEqual(drawable, z2().f444830g.getDrawable())) {
            if (B2()) {
                z2().f444830g.setImageDrawable(drawable);
            } else {
                l3(drawable);
            }
        }
    }

    private final int F2() {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        int i3;
        int dimensionPixelSize;
        AIOBubbleSkinInfo x06 = q1().x0();
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.g gVar = null;
        if (x06 != null) {
            aVar = x06.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.g) {
            gVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.g) aVar;
        }
        int i16 = 0;
        if (gVar != null) {
            i3 = gVar.d() + gVar.e();
        } else {
            i3 = 0;
        }
        if (FontSettingManager.isFontSizeLarge()) {
            dimensionPixelSize = ViewUtils.dip2px(3.0f);
        } else {
            dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.bz8);
        }
        if (com.tencent.mobileqq.aio.utils.m.f194167a.c(q1())) {
            i16 = this.context.getResources().getDimensionPixelSize(R.dimen.bz8) + this.context.getResources().getDimensionPixelSize(R.dimen.bz5);
        }
        return i3 + dimensionPixelSize + i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void F3() {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2;
        ConstraintLayout.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        RelativeLayout relativeLayout = z2().f444827d;
        w71.l lVar = null;
        if (relativeLayout != null) {
            layoutParams = relativeLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        w71.l lVar2 = this.speechToTextBinding;
        if (lVar2 != null) {
            if (lVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar2 = null;
            }
            FrameLayout root = lVar2.getRoot();
            if (root != null) {
                layoutParams4 = root.getLayoutParams();
            } else {
                layoutParams4 = null;
            }
            if (layoutParams4 instanceof ConstraintLayout.LayoutParams) {
                layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams4;
                if (!q1().isSelf()) {
                    if (layoutParams2 != null) {
                        layoutParams2.startToStart = -1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.endToEnd = 0;
                    }
                    if (layoutParams3 != null) {
                        layoutParams3.startToStart = -1;
                    }
                    if (layoutParams3 != null) {
                        layoutParams3.endToEnd = z2().f444827d.getId();
                    }
                } else {
                    if (layoutParams2 != null) {
                        layoutParams2.startToStart = 0;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.endToEnd = -1;
                    }
                    if (layoutParams3 != null) {
                        layoutParams3.startToStart = z2().f444827d.getId();
                    }
                    if (layoutParams3 != null) {
                        layoutParams3.endToEnd = -1;
                    }
                }
                if (layoutParams2 != null) {
                    z2().f444827d.setLayoutParams(layoutParams2);
                }
                if (layoutParams3 == null) {
                    w71.l lVar3 = this.speechToTextBinding;
                    if (lVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    } else {
                        lVar = lVar3;
                    }
                    lVar.getRoot().setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
        }
        layoutParams3 = null;
        if (!q1().isSelf()) {
        }
        if (layoutParams2 != null) {
        }
        if (layoutParams3 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler G2() {
        return (Handler) this.subHandler.getValue();
    }

    private final void G3(String path) {
        this.pttPath = path;
        if (!TextUtils.isEmpty(path) && w1()) {
            AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
            long msgId = q1().getMsgId();
            int hashCode = hashCode();
            String str = this.pttPath;
            Intrinsics.checkNotNull(str);
            aIOPttAudioPlayerManager.x(msgId, hashCode, str, this.aioPttAudioPlayerStateListener);
        }
    }

    private final com.tencent.qqnt.aio.menu.ui.c H2() {
        com.tencent.qqnt.aio.menu.ui.c cVar = new com.tencent.qqnt.aio.menu.ui.c();
        com.tencent.qqnt.aio.menu.e eVar = new com.tencent.qqnt.aio.menu.e(this.context, q1());
        w71.l lVar = this.speechToTextBinding;
        w71.l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        SelectableLinearLayout selectableLinearLayout = lVar.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout, "speechToTextBinding.pttSelectableLinearLayout");
        eVar.l(selectableLinearLayout);
        cVar.a(eVar);
        Context context = this.context;
        PttMsgItem q16 = q1();
        w71.l lVar3 = this.speechToTextBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar3 = null;
        }
        cVar.a(new com.tencent.qqnt.aio.menu.l(context, q16, this, lVar3.f444842b));
        com.tencent.qqnt.aio.menu.i iVar = new com.tencent.qqnt.aio.menu.i(this.context, q1());
        w71.l lVar4 = this.speechToTextBinding;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
        } else {
            lVar2 = lVar4;
        }
        SelectableLinearLayout selectableLinearLayout2 = lVar2.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout2, "speechToTextBinding.pttSelectableLinearLayout");
        iVar.i(selectableLinearLayout2);
        cVar.a(iVar);
        cVar.a(new com.tencent.qqnt.aio.menu.x(this.context, q1(), this));
        return cVar;
    }

    private final void H3() {
        String str;
        if (!q1().D2() && !q1().isSelf()) {
            str = HardCodeUtil.qqStr(R.string.yp_);
        } else {
            str = "";
        }
        z2().f444837n.setContentDescription(q1().u2() + HardCodeUtil.qqStr(R.string.yp8) + q1().q2() + HardCodeUtil.qqStr(R.string.yp9) + str);
    }

    private final com.tencent.qqnt.aio.menu.ui.c I2() {
        com.tencent.qqnt.aio.menu.ui.c cVar = new com.tencent.qqnt.aio.menu.ui.c();
        com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(this.context, q1());
        w71.l lVar = this.speechToTextBinding;
        w71.l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        SelectableLinearLayout selectableLinearLayout = lVar.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout, "speechToTextBinding.pttSelectableLinearLayout");
        dVar.l(selectableLinearLayout);
        cVar.a(dVar);
        Context context = this.context;
        PttMsgItem q16 = q1();
        w71.l lVar3 = this.speechToTextBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar3 = null;
        }
        cVar.a(new com.tencent.qqnt.aio.menu.k(context, q16, this, lVar3.f444842b));
        com.tencent.qqnt.aio.menu.i iVar = new com.tencent.qqnt.aio.menu.i(this.context, q1());
        w71.l lVar4 = this.speechToTextBinding;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
        } else {
            lVar2 = lVar4;
        }
        SelectableLinearLayout selectableLinearLayout2 = lVar2.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout2, "speechToTextBinding.pttSelectableLinearLayout");
        iVar.i(selectableLinearLayout2);
        cVar.a(iVar);
        cVar.a(new ak(this.context, q1(), this));
        return cVar;
    }

    private final void I3(AIOBubbleSkinInfo bubbleSkin) {
        boolean z16;
        Drawable drawable;
        c03.a aVar;
        c03.a aVar2;
        ColorStateList colorStateList;
        Drawable a16;
        boolean z17;
        int i3;
        int i16;
        boolean z18 = true;
        if (bubbleSkin.d() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isVasBubble = z16;
        AIOBubbleSkinInfo.BackgroundImageInfo a17 = bubbleSkin.a();
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.g gVar = null;
        if (a17 != null && (a16 = a17.a()) != null) {
            RelativeLayout relativeLayout = z2().f444827d;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.pttContent");
            Integer valueOf = Integer.valueOf(a17.g());
            int intValue = valueOf.intValue();
            Intrinsics.checkNotNullExpressionValue(z2().f444827d, "binding.pttContent");
            if (intValue != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                valueOf = null;
            }
            if (valueOf != null) {
                i3 = valueOf.intValue();
            } else {
                Intrinsics.checkNotNullExpressionValue(z2().f444827d, "binding.pttContent");
                i3 = 0;
            }
            relativeLayout.setMinimumWidth(i3);
            RelativeLayout relativeLayout2 = z2().f444827d;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.pttContent");
            Integer valueOf2 = Integer.valueOf(a17.f());
            int intValue2 = valueOf2.intValue();
            Intrinsics.checkNotNullExpressionValue(z2().f444827d, "binding.pttContent");
            if (intValue2 == 0) {
                z18 = false;
            }
            if (!z18) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                i16 = valueOf2.intValue();
            } else {
                Intrinsics.checkNotNullExpressionValue(z2().f444827d, "binding.pttContent");
                i16 = 0;
            }
            relativeLayout2.setMinimumHeight(i16);
            z2().f444827d.setBackground(a16);
        }
        AIOBubbleSkinInfo.c e16 = bubbleSkin.e();
        if (e16 != null) {
            if (e16.b() != null) {
                colorStateList = e16.b();
            } else if (e16.a() != null) {
                Integer a18 = e16.a();
                Intrinsics.checkNotNull(a18);
                colorStateList = ColorStateList.valueOf(a18.intValue());
            } else {
                colorStateList = null;
            }
            if (colorStateList != null) {
                z2().f444828e.setTextColor(colorStateList);
                z2().f444826c.setProgressColor(colorStateList.getDefaultColor());
                Drawable drawable2 = this.aioPttPlay;
                if (drawable2 != null) {
                    drawable2.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
                }
                Drawable drawable3 = this.aioPttPause;
                if (drawable3 != null) {
                    drawable3.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
                }
                Drawable drawable4 = this.aioPttVoiceChange;
                if (drawable4 != null) {
                    drawable4.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
                }
                z2().f444836m.setImageDrawable(this.aioPttVoiceChange);
                z2().f444838o.setTextColor(colorStateList);
                Drawable drawable5 = this.aioPttVoicePrintDefault;
                if (drawable5 != null) {
                    drawable5.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
                }
                z2().f444839p.setImageDrawable(this.aioPttVoicePrintDefault);
                Drawable drawable6 = this.loadingDrawable;
                if (drawable6 != null) {
                    drawable6.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
                }
                ImageView imageView = this.loadingView;
                if (imageView != null) {
                    imageView.setBackground(this.loadingDrawable);
                }
            }
        }
        RelativeLayout relativeLayout3 = z2().f444827d;
        AIOBubbleSkinInfo.b c16 = bubbleSkin.c();
        if (c16 != null) {
            drawable = c16.a();
        } else {
            drawable = null;
        }
        relativeLayout3.setForeground(drawable);
        AIOBubbleSkinInfo.b f16 = bubbleSkin.f();
        if (f16 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOPttContentComponent", 4, "updateSkinBubbleInfo foreground:" + f16);
            }
            Drawable a19 = f16.a();
            if (a19 != null) {
                z2().f444829f.setImageDrawable(a19);
            }
            Object a26 = f16.a();
            if (a26 instanceof c03.a) {
                aVar2 = (c03.a) a26;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                aVar2.setLoadedListener(new AIOPttContentComponent$updateSkinBubbleInfo$3$2$1(this, aVar2));
            }
        }
        AIOBubbleSkinInfo.b g16 = bubbleSkin.g();
        if (g16 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOPttContentComponent", 4, "updateSkinBubbleInfo voicePrintDrawable:" + g16);
            }
            Drawable a27 = g16.a();
            if (a27 != null) {
                z2().f444826c.setVisibility(8);
                z2().f444833j.setVisibility(8);
                ImageView imageView2 = z2().f444840q;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pttVoicePrintView");
                imageView2.setVisibility(0);
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView2.setImageDrawable(a27);
            }
            Object a28 = g16.a();
            if (a28 instanceof c03.a) {
                aVar = (c03.a) a28;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.setLoadedListener(new AIOPttContentComponent$updateSkinBubbleInfo$4$2$1(this));
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.g) {
            gVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.g) b16;
        }
        if (gVar != null) {
            if (z2().f444827d.getPaddingLeft() != gVar.d()) {
                z2().f444827d.setPadding(gVar.d(), gVar.f(), gVar.e(), gVar.c());
            }
            p2(gVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int J2() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i17;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i18;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        RelativeLayout relativeLayout = z2().f444833j;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.pttPlayStatusLayout");
        ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams5 = null;
        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
        } else {
            marginLayoutParams = null;
        }
        int i19 = 0;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.rightMargin;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            RelativeLayout relativeLayout2 = z2().f444833j;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.pttPlayStatusLayout");
            ViewGroup.LayoutParams layoutParams5 = relativeLayout2.getLayoutParams();
            if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams5;
            } else {
                marginLayoutParams4 = null;
            }
            if (marginLayoutParams4 != null) {
                i16 = marginLayoutParams4.rightMargin;
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.c0_);
                RelativeLayout relativeLayout3 = z2().f444833j;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.pttPlayStatusLayout");
                layoutParams = relativeLayout3.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 == null) {
                    i17 = marginLayoutParams2.leftMargin;
                } else {
                    i17 = 0;
                }
                int i26 = dimensionPixelSize + i17 + i16;
                float measureText = z2().f444828e.getPaint().measureText(z2().f444828e.getText().toString()) + z2().f444828e.getPaddingStart() + z2().f444828e.getPaddingEnd();
                TextView textView = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.pttDuration");
                layoutParams2 = textView.getLayoutParams();
                if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                    marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams3 = null;
                }
                if (marginLayoutParams3 == null) {
                    i18 = marginLayoutParams3.leftMargin;
                } else {
                    i18 = 0;
                }
                float f16 = measureText + i18;
                TextView textView2 = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.pttDuration");
                layoutParams3 = textView2.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams3;
                }
                if (marginLayoutParams5 != null) {
                    i19 = marginLayoutParams5.rightMargin;
                }
                int i27 = (int) (i26 + f16 + i19);
                if (!TextUtils.isEmpty(z2().f444838o.getText())) {
                    i27 += ((int) z2().f444838o.getPaint().measureText(z2().f444838o.getText().toString())) + z2().f444838o.getPaddingStart() + z2().f444838o.getPaddingEnd();
                }
                if (z2().f444834k.getVisibility() != 0) {
                    return i27 + ViewUtils.dip2px(10.0f);
                }
                return i27;
            }
        }
        i16 = 0;
        int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen.c0_);
        RelativeLayout relativeLayout32 = z2().f444833j;
        Intrinsics.checkNotNullExpressionValue(relativeLayout32, "binding.pttPlayStatusLayout");
        layoutParams = relativeLayout32.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
        }
        if (marginLayoutParams2 == null) {
        }
        int i262 = dimensionPixelSize2 + i17 + i16;
        float measureText2 = z2().f444828e.getPaint().measureText(z2().f444828e.getText().toString()) + z2().f444828e.getPaddingStart() + z2().f444828e.getPaddingEnd();
        TextView textView3 = z2().f444828e;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pttDuration");
        layoutParams2 = textView3.getLayoutParams();
        if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
        }
        if (marginLayoutParams3 == null) {
        }
        float f162 = measureText2 + i18;
        TextView textView22 = z2().f444828e;
        Intrinsics.checkNotNullExpressionValue(textView22, "binding.pttDuration");
        layoutParams3 = textView22.getLayoutParams();
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
        }
        if (marginLayoutParams5 != null) {
        }
        int i272 = (int) (i262 + f162 + i19);
        if (!TextUtils.isEmpty(z2().f444838o.getText())) {
        }
        if (z2().f444834k.getVisibility() != 0) {
        }
    }

    private final void J3() {
        ColorStateList colorStateList;
        Drawable a16;
        if (this.speechToTextBinding == null) {
            return;
        }
        int i3 = 0;
        boolean z16 = true;
        AIOBubbleSkinInfo e16 = com.tencent.mobileqq.aio.utils.n.f194168a.e(getMContext(), q1(), false, true);
        AIOBubbleSkinInfo.BackgroundImageInfo a17 = e16.a();
        w71.l lVar = null;
        if (a17 != null && (a16 = a17.a()) != null) {
            w71.l lVar2 = this.speechToTextBinding;
            if (lVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar2 = null;
            }
            FrameLayout root = lVar2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "speechToTextBinding.root");
            Integer valueOf = Integer.valueOf(a17.f());
            int intValue = valueOf.intValue();
            w71.l lVar3 = this.speechToTextBinding;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar3 = null;
            }
            Intrinsics.checkNotNullExpressionValue(lVar3.getRoot(), "speechToTextBinding.root");
            if (intValue == 0) {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                i3 = valueOf.intValue();
            } else {
                w71.l lVar4 = this.speechToTextBinding;
                if (lVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    lVar4 = null;
                }
                Intrinsics.checkNotNullExpressionValue(lVar4.getRoot(), "speechToTextBinding.root");
            }
            root.setMinimumHeight(i3);
            w71.l lVar5 = this.speechToTextBinding;
            if (lVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar5 = null;
            }
            lVar5.f444842b.setBackground(a16);
        }
        AIOBubbleSkinInfo.c e17 = e16.e();
        if (e17 != null) {
            if (e17.b() != null) {
                colorStateList = e17.b();
            } else if (e17.a() != null) {
                Integer a18 = e17.a();
                Intrinsics.checkNotNull(a18);
                colorStateList = ColorStateList.valueOf(a18.intValue());
            } else {
                colorStateList = null;
            }
            if (colorStateList != null) {
                w71.l lVar6 = this.speechToTextBinding;
                if (lVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                } else {
                    lVar = lVar6;
                }
                lVar.f444843c.setTextColor(colorStateList);
            }
        }
    }

    private final boolean K2(List<Object> payloads) {
        AIOBubbleSkinInfo x06;
        a.aw awVar;
        FileTransNotifyInfo a16;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null && !q1().C2() && !q1().K0()) {
                    if (obj2 instanceof a.aw) {
                        awVar = (a.aw) obj2;
                    } else {
                        awVar = null;
                    }
                    if (awVar != null && (a16 = awVar.a()) != null && a16.trasferStatus == 4 && z2().f444828e.getVisibility() != 0) {
                        q1().k2();
                        int q26 = q1().q2();
                        QLog.i("AIOPttContentComponent", 1, "update duration from payload, id:" + q1().getMsgId() + ", duration:" + q26);
                        c3(AIOPttUtil.f191743a.e(q26));
                        z2().f444828e.setVisibility(0);
                        y3(q1(), false);
                    }
                }
                Object obj3 = map.get(AIOMsgItemPayloadType.PTT_PLAY_NEXT_PAYLOAD);
                if (obj3 != null) {
                    if (obj3 instanceof a.an) {
                        this.currentSpeed = ((a.an) obj3).a();
                    }
                    t3();
                }
                Object obj4 = map.get(AIOMsgItemPayloadType.PTT_TRANSLATE_PAYLOAD);
                if (obj4 != null) {
                    A3(obj4);
                }
                if (map.get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                    u3();
                }
                Object obj5 = map.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj5 != null && (obj5 instanceof a.ay)) {
                    a.ay ayVar = (a.ay) obj5;
                    if (ayVar.a() == 2 && S2(true)) {
                        g3(false);
                    }
                    w3(ayVar.a());
                    au.b(Boolean.valueOf(q1().y2()), new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttContentComponent$handlePayloadData$5$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPttContentComponent.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                AIOPttContentComponent aIOPttContentComponent = AIOPttContentComponent.this;
                                aIOPttContentComponent.v2(AIOPttContentComponent.Y1(aIOPttContentComponent));
                            }
                        }
                    });
                }
                Object obj6 = map.get(AIOMsgItemPayloadType.PTT_FAKE_PAYLOAD);
                if (obj6 != null && (obj6 instanceof a.al)) {
                    a.al alVar = (a.al) obj6;
                    QLog.i("AIOPttContentComponent", 1, "handlePayloadData PttFakePayload duration: " + alVar.a() + ", current ptt path: " + q1().t2() + ", current duration: " + q1().q2());
                    x3(alVar.b(), alVar.a());
                    R2(q1());
                }
                Object obj7 = map.get(AIOMsgItemPayloadType.PTT_PATH_PAYLOAD);
                if (obj7 != null && (obj7 instanceof a.am)) {
                    a.am amVar = (a.am) obj7;
                    QLog.i("AIOPttContentComponent", 1, "handlePayloadData PttPathPayload path: " + amVar.a() + ", current ptt path: " + q1().t2());
                    G3(amVar.a());
                }
                if (map.get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null && (x06 = q1().x0()) != null) {
                    I3(x06);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void K3() {
        MsgElement o26 = q1().o2();
        if (o26 != null && !q1().D2()) {
            PttMsgItem q16 = q1();
            Contact contact = new Contact(q16.getMsgRecord().chatType, q16.getMsgRecord().peerUid, q16.getMsgRecord().guildId);
            com.tencent.qqnt.kernel.api.w D2 = D2();
            if (D2 != null) {
                D2.j(contact, q16.getMsgId(), o26.elementId, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.h
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        AIOPttContentComponent.L3(i3, str);
                    }
                });
            }
            q1().K2();
            z2().f444834k.setVisibility(8);
            H3();
        }
    }

    private final void L2(boolean isExpand) {
        if (isExpand) {
            M2();
        } else {
            g3(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(int i3, String str) {
        QLog.i("AIOPttContentComponent", 1, "setPttPlayedState result:" + i3 + ", errMsg:" + str);
    }

    private final void M2() {
        w71.l lVar = this.speechToTextBinding;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        lVar.getRoot().setVisibility(8);
        a3();
        B3(false);
        y3(q1(), false);
        sendIntent(new d.ar(q1().getMsgId(), false));
        q1().p2().d(false);
        q1().H2();
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            z2().f444837n.sendAccessibilityEvent(8);
        }
    }

    private final void M3(boolean success) {
        w71.l lVar = this.speechToTextBinding;
        if (lVar != null && !success) {
            w71.l lVar2 = null;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar = null;
            }
            lVar.f444842b.setVisibility(0);
            w71.l lVar3 = this.speechToTextBinding;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            } else {
                lVar2 = lVar3;
            }
            p3(lVar2.f444843c, this.context.getString(R.string.f229486wk));
        }
    }

    private final void N2() {
        w71.l lVar = this.speechToTextBinding;
        w71.l lVar2 = null;
        if (lVar != null) {
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar = null;
            }
            lVar.getRoot().setVisibility(0);
            B3(true);
            return;
        }
        z2().f444835l.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.i
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                AIOPttContentComponent.P2(AIOPttContentComponent.this, viewStub, view);
            }
        });
        z2().f444835l.inflate();
        w71.l lVar3 = this.speechToTextBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar3 = null;
        }
        int paddingLeft = lVar3.f444842b.getPaddingLeft();
        w71.l lVar4 = this.speechToTextBinding;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar4 = null;
        }
        int paddingRight = paddingLeft + lVar4.f444842b.getPaddingRight();
        w71.l lVar5 = this.speechToTextBinding;
        if (lVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar5 = null;
        }
        lVar5.f444843c.setMaxWidth(a.C7329a.f192417a.b() - paddingRight);
        F3();
        B3(true);
        com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
        w71.l lVar6 = this.speechToTextBinding;
        if (lVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar6 = null;
        }
        SelectableLinearLayout selectableLinearLayout = lVar6.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout, "speechToTextBinding.pttSelectableLinearLayout");
        aVar.g(selectableLinearLayout, this);
        w71.l lVar7 = this.speechToTextBinding;
        if (lVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar7 = null;
        }
        SelectableTextView selectableTextView = lVar7.f444843c;
        w71.l lVar8 = this.speechToTextBinding;
        if (lVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar8 = null;
        }
        SelectableLinearLayout selectableLinearLayout2 = lVar8.f444842b;
        Intrinsics.checkNotNullExpressionValue(selectableLinearLayout2, "speechToTextBinding.pttSelectableLinearLayout");
        selectableTextView.o(selectableLinearLayout2);
        w71.l lVar9 = this.speechToTextBinding;
        if (lVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar9 = null;
        }
        lVar9.f444843c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean Q2;
                Q2 = AIOPttContentComponent.Q2(AIOPttContentComponent.this, view);
                return Q2;
            }
        });
        w71.l lVar10 = this.speechToTextBinding;
        if (lVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
        } else {
            lVar2 = lVar10;
        }
        lVar2.f444842b.setOnTouchViewListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N3(String text, Boolean needShowAnim) {
        boolean z16;
        if (this.speechToTextBinding == null) {
            return;
        }
        boolean z17 = true;
        M3(true);
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            text = this.context.getString(R.string.f229486wk);
        }
        Intrinsics.checkNotNullExpressionValue(text, "if (text.isNullOrEmpty()\u2026t_convert_fail) else text");
        w71.l lVar = this.speechToTextBinding;
        w71.l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        lVar.f444842b.setVisibility(0);
        if (B2() || !Intrinsics.areEqual(needShowAnim, Boolean.TRUE)) {
            z17 = false;
        }
        if (z17) {
            w71.l lVar3 = this.speechToTextBinding;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            } else {
                lVar2 = lVar3;
            }
            p3(lVar2.f444843c, text);
        } else {
            w71.l lVar4 = this.speechToTextBinding;
            if (lVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            } else {
                lVar2 = lVar4;
            }
            lVar2.f444843c.setText(text);
        }
        y3(q1(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(AIOPttContentComponent this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w71.l e16 = w71.l.e(view);
        Intrinsics.checkNotNullExpressionValue(e16, "bind(inflated)");
        this$0.speechToTextBinding = e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q2(AIOPttContentComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w71.l lVar = null;
        d.p pVar = new d.p(false, 1, null);
        this$0.sendIntent(pVar);
        if (pVar.a()) {
            return false;
        }
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            this$0.sendIntent(new d.at(this$0.c1(), this$0.H2()));
        } else {
            w71.l lVar2 = this$0.speechToTextBinding;
            if (lVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar2 = null;
            }
            lVar2.f444842b.u(this$0.q1().isSelf());
            w71.l lVar3 = this$0.speechToTextBinding;
            if (lVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            } else {
                lVar = lVar3;
            }
            SelectableLinearLayout selectableLinearLayout = lVar.f444842b;
            Intrinsics.checkNotNullExpressionValue(selectableLinearLayout, "speechToTextBinding.pttSelectableLinearLayout");
            this$0.sendIntent(new d.ao(selectableLinearLayout, this$0.H2(), this$0.I2()));
        }
        return true;
    }

    private final void R2(PttMsgItem msgItem) {
        int i3;
        ImageView imageView = z2().f444825b;
        int i16 = 0;
        if (msgItem.C2() && msgItem.G2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        LinearLayout linearLayout = z2().f444837n;
        if (msgItem.z2()) {
            i16 = 8;
        } else if (msgItem.C2()) {
            i16 = 4;
        }
        linearLayout.setVisibility(i16);
    }

    private final boolean S2(boolean needLog) {
        boolean z16;
        boolean z17 = false;
        if (!q1().G2() && !q1().v2()) {
            PttElement s26 = q1().s2();
            if (s26 == null) {
                return false;
            }
            if (s26.autoConvertText > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (QLog.isDevelopLevel() || needLog) {
                    QLog.d("AIOPttContentComponent", 1, "isAutoSpeechToText  msgId:" + q1().getMsgId() + "  switchFromMessage:true");
                }
                return true;
            }
            Integer num = s26.translateStatus;
            if (num != null && num.intValue() == 0 && AIOPttUtil.f191743a.h(q1())) {
                if (QLog.isDevelopLevel() || needLog) {
                    QLog.d("AIOPttContentComponent", 1, "isAutoSpeechToText in whitelist peerUin:" + q1().getMsgRecord().peerUin);
                }
                return true;
            }
            Integer num2 = s26.translateStatus;
            if (num2 != null && num2.intValue() == 0 && ((IAIOPttApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPttApi.class)).isAutoChangeText(y2())) {
                z17 = true;
            }
            if (QLog.isDevelopLevel() || needLog) {
                QLog.d("AIOPttContentComponent", 1, "isAutoSpeechToText  msgId:" + q1().getMsgId() + "  switchFromSetting:" + z17);
            }
        }
        return z17;
    }

    static /* synthetic */ boolean T2(AIOPttContentComponent aIOPttContentComponent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return aIOPttContentComponent.S2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U2(long msgId) {
        if (q1().getMsgId() == msgId) {
            return true;
        }
        return false;
    }

    private final boolean V2() {
        if (C2()) {
            return q1().p2().b();
        }
        d.i iVar = new d.i(q1().getMsgId(), null, 2, null);
        sendIntent(iVar);
        return Intrinsics.areEqual(iVar.b(), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(AIOPttContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.q1().x2()) {
            if (this$0.t3()) {
                this$0.sendIntent(new d.af(null, 1, null));
            }
            this$0.sendIntent(d.v.f192363d);
            this$0.C1();
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                iRichMediaBrowserApi.enterPttPreview(peekAppRuntime, this$0.context, this$0.q1().getMsgRecord(), this$0.q1().s2());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X2() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int i17;
        ViewGroup.LayoutParams layoutParams = z2().f444828e.getLayoutParams();
        int i18 = -2;
        layoutParams.width = -2;
        z2().f444828e.setLayoutParams(layoutParams);
        TextView textView = z2().f444828e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pttDuration");
        int dip2px = ViewUtils.dip2px(8.0f);
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            if (layoutParams4 != null) {
                i17 = layoutParams4.height;
            } else {
                i17 = -2;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        if (dip2px != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = dip2px;
            textView.setLayoutParams(marginLayoutParams);
        }
        TextView textView2 = z2().f444828e;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pttDuration");
        int dip2px2 = ViewUtils.dip2px(15.0f);
        ViewGroup.LayoutParams layoutParams5 = textView2.getLayoutParams();
        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams5;
        }
        if (marginLayoutParams2 == null) {
            ViewGroup.LayoutParams layoutParams6 = textView2.getLayoutParams();
            if (layoutParams6 != null) {
                i3 = layoutParams6.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
            if (layoutParams7 != null) {
                i18 = layoutParams7.height;
            }
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i3, i18);
        }
        if (dip2px2 != marginLayoutParams2.rightMargin) {
            marginLayoutParams2.rightMargin = dip2px2;
            textView2.setLayoutParams(marginLayoutParams2);
        }
        this.lastDurationWidth = 0;
    }

    public static final /* synthetic */ PttMsgItem Y1(AIOPttContentComponent aIOPttContentComponent) {
        return aIOPttContentComponent.q1();
    }

    private final void Y2() {
        z2().f444826c.setVisibility(0);
        RelativeLayout relativeLayout = z2().f444833j;
        Boolean valueOf = Boolean.valueOf(!q1().x2());
        relativeLayout.setVisibility(0);
        if (((View) au.a(valueOf, relativeLayout)) == null) {
            relativeLayout.setVisibility(8);
        }
        z2().f444840q.setVisibility(8);
        z2().f444829f.setVisibility(8);
    }

    private final void Z2() {
        w71.l lVar = this.speechToTextBinding;
        if (lVar != null) {
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar = null;
            }
            lVar.f444843c.setText("");
            a3();
        }
    }

    private final void a3() {
        w71.l lVar = this.speechToTextBinding;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        SelectableTextView selectableTextView = lVar.f444843c;
        Intrinsics.checkNotNullExpressionValue(selectableTextView, "speechToTextBinding.pttSelectableTextView");
        ViewGroup.LayoutParams layoutParams = selectableTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        selectableTextView.setLayoutParams(layoutParams);
        ConstraintLayout root = z2().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewGroup.LayoutParams layoutParams2 = root.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -2;
        }
        root.setLayoutParams(layoutParams2);
    }

    private final void b3() {
        z2().f444826c.n();
    }

    private final void c3(String text) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int i17;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i18;
        int i19;
        int i26;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i27;
        int i28;
        int i29;
        ViewGroup.LayoutParams layoutParams = z2().f444828e.getLayoutParams();
        z2().f444828e.setText(text);
        z2().f444828e.measure(0, 0);
        int i36 = this.lastDurationWidth;
        if (i36 <= 0) {
            this.lastDurationWidth = z2().f444828e.getMeasuredWidth();
        } else {
            layoutParams.width = i36;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams4 = null;
        int i37 = -2;
        if (FontSettingManager.isFontSizeLarge()) {
            if (q1().G2()) {
                TextView textView = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.pttDuration");
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams3 = null;
                }
                if (marginLayoutParams3 == null) {
                    ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                    if (layoutParams3 != null) {
                        i28 = layoutParams3.width;
                    } else {
                        i28 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                    if (layoutParams4 != null) {
                        i29 = layoutParams4.height;
                    } else {
                        i29 = -2;
                    }
                    marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i28, i29);
                }
                if (marginLayoutParams3.leftMargin != 0) {
                    marginLayoutParams3.leftMargin = 0;
                    textView.setLayoutParams(marginLayoutParams3);
                }
                TextView textView2 = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.pttDuration");
                int dip2px = ViewUtils.dip2px(5.0f);
                ViewGroup.LayoutParams layoutParams5 = textView2.getLayoutParams();
                if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams5;
                }
                if (marginLayoutParams4 == null) {
                    ViewGroup.LayoutParams layoutParams6 = textView2.getLayoutParams();
                    if (layoutParams6 != null) {
                        i27 = layoutParams6.width;
                    } else {
                        i27 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
                    if (layoutParams7 != null) {
                        i37 = layoutParams7.height;
                    }
                    marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i27, i37);
                }
                if (dip2px != marginLayoutParams4.rightMargin) {
                    marginLayoutParams4.rightMargin = dip2px;
                    textView2.setLayoutParams(marginLayoutParams4);
                }
            } else {
                TextView textView3 = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.pttDuration");
                int dip2px2 = ViewUtils.dip2px(3.0f);
                ViewGroup.LayoutParams layoutParams8 = textView3.getLayoutParams();
                if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams8;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 == null) {
                    ViewGroup.LayoutParams layoutParams9 = textView3.getLayoutParams();
                    if (layoutParams9 != null) {
                        i19 = layoutParams9.width;
                    } else {
                        i19 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams10 = textView3.getLayoutParams();
                    if (layoutParams10 != null) {
                        i26 = layoutParams10.height;
                    } else {
                        i26 = -2;
                    }
                    marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i19, i26);
                }
                if (dip2px2 != marginLayoutParams2.leftMargin) {
                    marginLayoutParams2.leftMargin = dip2px2;
                    textView3.setLayoutParams(marginLayoutParams2);
                }
                TextView textView4 = z2().f444828e;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.pttDuration");
                int dip2px3 = ViewUtils.dip2px(8.0f);
                ViewGroup.LayoutParams layoutParams11 = textView4.getLayoutParams();
                if (layoutParams11 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams11;
                }
                if (marginLayoutParams4 == null) {
                    ViewGroup.LayoutParams layoutParams12 = textView4.getLayoutParams();
                    if (layoutParams12 != null) {
                        i18 = layoutParams12.width;
                    } else {
                        i18 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams13 = textView4.getLayoutParams();
                    if (layoutParams13 != null) {
                        i37 = layoutParams13.height;
                    }
                    marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i18, i37);
                }
                if (dip2px3 != marginLayoutParams4.rightMargin) {
                    marginLayoutParams4.rightMargin = dip2px3;
                    textView4.setLayoutParams(marginLayoutParams4);
                }
            }
        } else {
            TextView textView5 = z2().f444828e;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.pttDuration");
            int dip2px4 = ViewUtils.dip2px(8.0f);
            ViewGroup.LayoutParams layoutParams14 = textView5.getLayoutParams();
            if (layoutParams14 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams14;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams15 = textView5.getLayoutParams();
                if (layoutParams15 != null) {
                    i16 = layoutParams15.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams16 = textView5.getLayoutParams();
                if (layoutParams16 != null) {
                    i17 = layoutParams16.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (dip2px4 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dip2px4;
                textView5.setLayoutParams(marginLayoutParams);
            }
            TextView textView6 = z2().f444828e;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.pttDuration");
            int dip2px5 = ViewUtils.dip2px(15.0f);
            ViewGroup.LayoutParams layoutParams17 = textView6.getLayoutParams();
            if (layoutParams17 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams17;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams18 = textView6.getLayoutParams();
                if (layoutParams18 != null) {
                    i3 = layoutParams18.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams19 = textView6.getLayoutParams();
                if (layoutParams19 != null) {
                    i37 = layoutParams19.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i3, i37);
            }
            if (dip2px5 != marginLayoutParams4.rightMargin) {
                marginLayoutParams4.rightMargin = dip2px5;
                textView6.setLayoutParams(marginLayoutParams4);
            }
        }
        z2().f444828e.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e3, code lost:
    
        if (r0 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d3(boolean visible) {
        Drawable drawable;
        ApngDrawable apngDrawable;
        Unit unit;
        Drawable drawable2;
        ApngDrawable apngDrawable2;
        int i3;
        AIOBubbleSkinInfo.c e16;
        Unit unit2 = null;
        ColorStateList colorStateList = null;
        if (!visible) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Drawable drawable3 = this.loadingDrawable;
                if (drawable3 != null) {
                    drawable = drawable3.getCurrent();
                } else {
                    drawable = null;
                }
                if (drawable instanceof ApngDrawable) {
                    apngDrawable = (ApngDrawable) drawable;
                } else {
                    apngDrawable = null;
                }
                if (apngDrawable != null) {
                    apngDrawable.pause();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            ImageView imageView = this.loadingView;
            if (imageView != null) {
                ab.c(imageView);
            }
            this.loadingView = null;
            this.loadingDrawable = null;
            return;
        }
        if (this.loadingView != null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Drawable drawable4 = this.loadingDrawable;
                if (drawable4 != null) {
                    drawable2 = drawable4.getCurrent();
                } else {
                    drawable2 = null;
                }
                if (drawable2 instanceof ApngDrawable) {
                    apngDrawable2 = (ApngDrawable) drawable2;
                } else {
                    apngDrawable2 = null;
                }
                if (apngDrawable2 != null) {
                    apngDrawable2.resume();
                    unit2 = Unit.INSTANCE;
                }
                Result.m476constructorimpl(unit2);
                return;
            } catch (Throwable th6) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th6));
                return;
            }
        }
        this.loadingView = new ImageView(this.context);
        int dpToPx = ViewUtils.dpToPx(24.0f);
        int dpToPx2 = ViewUtils.dpToPx(14.0f);
        if (q1().x0() != null) {
            i3 = dpToPx2 / 2;
        } else {
            i3 = 0;
        }
        ImageView imageView2 = this.loadingView;
        Intrinsics.checkNotNull(imageView2);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.setMargins(i3, dpToPx2, i3, dpToPx2);
        imageView2.setLayoutParams(layoutParams);
        Drawable a16 = com.tencent.qqnt.aio.utils.d.f352294a.a();
        if (a16 == null) {
            return;
        }
        this.loadingDrawable = a16;
        ImageView imageView3 = this.loadingView;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setBackground(this.loadingDrawable);
        AIOBubbleSkinInfo x06 = q1().x0();
        if (x06 != null && (e16 = x06.e()) != null) {
            ColorStateList b16 = e16.b();
            if (b16 == null) {
                Integer a17 = e16.a();
                if (a17 != null) {
                    colorStateList = ColorStateList.valueOf(a17.intValue());
                }
            } else {
                colorStateList = b16;
            }
        }
        colorStateList = AppCompatResources.getColorStateList(this.context, R.color.skin_chat_buble_mine);
        Drawable drawable5 = this.loadingDrawable;
        Intrinsics.checkNotNull(drawable5);
        drawable5.setColorFilter(new LightingColorFilter(0, colorStateList.getDefaultColor()));
        z2().getRoot().addView(this.loadingView);
    }

    private final void e3(boolean isSelf) {
        int i3;
        int parseColor;
        int i16;
        if (isSelf) {
            i3 = R.color.skin_chat_buble_mine;
        } else {
            i3 = R.color.skin_chat_buble;
        }
        z2().f444828e.setTextColor(AppCompatResources.getColorStateList(this.context, i3));
        if (isSelf) {
            parseColor = AppCompatResources.getColorStateList(this.context, R.color.skin_chat_buble_mine).getDefaultColor();
        } else {
            parseColor = Color.parseColor("#424448");
        }
        z2().f444826c.setProgressColor(parseColor);
        LightingColorFilter lightingColorFilter = new LightingColorFilter(0, parseColor);
        Drawable drawable = this.aioPttPlay;
        if (drawable != null) {
            drawable.setColorFilter(lightingColorFilter);
        }
        Drawable drawable2 = this.aioPttPause;
        if (drawable2 != null) {
            drawable2.setColorFilter(lightingColorFilter);
        }
        Drawable drawable3 = this.aioPttVoiceChange;
        if (drawable3 != null) {
            drawable3.setColorFilter(lightingColorFilter);
        }
        z2().f444836m.setImageDrawable(this.aioPttVoiceChange);
        z2().f444838o.setAlpha(0.8f);
        z2().f444838o.setTextColor(AppCompatResources.getColorStateList(this.context, i3));
        Drawable drawable4 = this.aioPttVoicePrintDefault;
        if (drawable4 != null) {
            drawable4.setColorFilter(lightingColorFilter);
        }
        z2().f444839p.setImageDrawable(this.aioPttVoicePrintDefault);
        if (!q1().isSelf()) {
            i16 = R.drawable.j8j;
        } else {
            i16 = R.drawable.j8i;
        }
        z2().f444832i.setImageDrawable(ContextCompat.getDrawable(this.context, i16));
    }

    private final void f3(boolean enable) {
        ViewGroup viewGroup;
        ViewParent parent = z2().getRoot().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setClipChildren(enable);
        }
        z2().getRoot().setClipChildren(enable);
    }

    private final void g3(boolean isFromClick) {
        h3(isFromClick);
        sendIntent(new d.ar(q1().getMsgId(), true));
        q1().p2().d(true);
        q1().H2();
    }

    private final void h3(boolean isFromClick) {
        PttElement s26;
        MsgElement o26 = q1().o2();
        if (o26 == null || (s26 = q1().s2()) == null) {
            return;
        }
        N2();
        J3();
        Integer num = s26.translateStatus;
        if (num != null && num.intValue() == 2) {
            N3(s26.text, Boolean.valueOf(isFromClick));
            K3();
            return;
        }
        y3(q1(), false);
        w71.l lVar = this.speechToTextBinding;
        w71.l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
            lVar = null;
        }
        lVar.f444843c.setText("");
        w71.l lVar3 = this.speechToTextBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
        } else {
            lVar2 = lVar3;
        }
        lVar2.f444842b.setVisibility(8);
        Integer num2 = s26.translateStatus;
        if (num2 != null && num2.intValue() == 1) {
            return;
        }
        PttMsgItem q16 = q1();
        Contact contact = new Contact(q16.getMsgRecord().chatType, q16.getMsgRecord().peerUid, q16.getMsgRecord().guildId);
        final AIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1 aIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1 = new AIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1(isFromClick, this);
        if (q16.v2()) {
            QLog.i("AIOPttContentComponent", 1, "call translatePtt2TextAiVoice");
            com.tencent.qqnt.kernel.api.w D2 = D2();
            if (D2 != null) {
                D2.translatePtt2TextAiVoice(q16.getMsgId(), contact, o26, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        AIOPttContentComponent.j3(Function2.this, i3, str);
                    }
                });
                return;
            }
            return;
        }
        QLog.i("AIOPttContentComponent", 1, "call translatePtt2Text");
        com.tencent.qqnt.kernel.api.w D22 = D2();
        if (D22 != null) {
            D22.translatePtt2Text(q16.getMsgId(), contact, o26, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOPttContentComponent.k3(Function2.this, i3, str);
                }
            });
        }
    }

    static /* synthetic */ void i3(AIOPttContentComponent aIOPttContentComponent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        aIOPttContentComponent.h3(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(Function2 tmp0, int i3, String str) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k3(Function2 tmp0, int i3, String str) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str);
    }

    private final void l3(Drawable drawable) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        if (drawable == null) {
            return;
        }
        if (Intrinsics.areEqual(drawable, this.aioPttPause)) {
            ofFloat = ObjectAnimator.ofFloat(z2().f444831h, BasicAnimation.KeyPath.ROTATION, 0.0f, 90.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(binding.pttPlayS\u2026nim, \"rotation\", 0f, 90f)");
            ofFloat2 = ObjectAnimator.ofFloat(z2().f444831h, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(binding.pttPlayS\u2026tusAnim, \"alpha\", 1f, 0f)");
            ofFloat3 = ObjectAnimator.ofFloat(z2().f444830g, BasicAnimation.KeyPath.ROTATION, -45.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(binding.pttPlayS\u2026us, \"rotation\", -45f, 0f)");
            ofFloat4 = ObjectAnimator.ofFloat(z2().f444830g, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(binding.pttPlayStatus, \"alpha\", 0f, 1f)");
            z2().f444831h.setImageDrawable(this.aioPttPlay);
        } else {
            ofFloat = ObjectAnimator.ofFloat(z2().f444831h, BasicAnimation.KeyPath.ROTATION, 0.0f, -45.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(binding.pttPlayS\u2026im, \"rotation\", 0f, -45f)");
            ofFloat2 = ObjectAnimator.ofFloat(z2().f444831h, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(binding.pttPlayS\u2026tusAnim, \"alpha\", 1f, 0f)");
            ofFloat3 = ObjectAnimator.ofFloat(z2().f444830g, BasicAnimation.KeyPath.ROTATION, 90.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(binding.pttPlayS\u2026tus, \"rotation\", 90f, 0f)");
            ofFloat4 = ObjectAnimator.ofFloat(z2().f444830g, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(binding.pttPlayStatus, \"alpha\", 0f, 1f)");
            z2().f444831h.setImageDrawable(this.aioPttPause);
        }
        z2().f444831h.setVisibility(0);
        z2().f444830g.setImageDrawable(drawable);
        z2().f444830g.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(100L);
        animatorSet.addListener(new g());
        animatorSet.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        animatorSet2.setDuration(80L);
        animatorSet2.setStartDelay(40L);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n3() {
        w71.l lVar;
        boolean z16 = !TextUtils.isEmpty(z2().f444838o.getText());
        if (com.tencent.mobileqq.aio.utils.d.U(q1()) && !FontSettingManager.isFontSizeLarge() && !B2() && !z16) {
            this.isScaleAnimEnd = false;
            f3(false);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(z2().f444827d, "ScaleX", 1.0f, 1.2f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(z2().f444827d, "ScaleY", 1.0f, 1.2f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(z2().f444834k, "ScaleX", 1.0f, 1.2f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(z2().f444834k, "ScaleY", 1.0f, 1.2f);
            float measuredWidth = z2().f444827d.getMeasuredWidth() * 0.1f;
            if (q1().isSelf()) {
                measuredWidth *= -1;
            }
            float dip2px = ViewUtils.dip2px(4.0f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(z2().f444827d, "translationX", 0.0f, measuredWidth);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(z2().f444834k, "translationX", 0.0f, measuredWidth);
            AnimatorSet animatorSet = new AnimatorSet();
            AnimatorSet.Builder with = animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat3).with(ofFloat4).with(ofFloat6);
            if (V2() && (lVar = this.speechToTextBinding) != null) {
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    lVar = null;
                }
                with.with(ObjectAnimator.ofFloat(lVar.getRoot(), "translationY", 0.0f, dip2px));
            }
            animatorSet.setDuration(100L);
            animatorSet.start();
        }
    }

    private final void o2(boolean isVoiceChange, boolean hasPrefixDesc) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int i17;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i18;
        int i19;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i26;
        int i27;
        int i28;
        int i29;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        int i36;
        int i37;
        ViewGroup.MarginLayoutParams marginLayoutParams5 = null;
        int i38 = -2;
        if (FontSettingManager.isFontSizeLarge()) {
            if (isVoiceChange) {
                LinearLayout linearLayout = z2().f444837n;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pttVoiceLayout");
                linearLayout.setPadding(ViewUtils.dip2px(3.0f), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                RelativeLayout relativeLayout = z2().f444833j;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.pttPlayStatusLayout");
                int dpToPx = ViewUtils.dpToPx(-2.0f);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams4 = null;
                }
                if (marginLayoutParams4 == null) {
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
                    if (layoutParams2 != null) {
                        i36 = layoutParams2.width;
                    } else {
                        i36 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
                    if (layoutParams3 != null) {
                        i37 = layoutParams3.height;
                    } else {
                        i37 = -2;
                    }
                    marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i36, i37);
                }
                if (dpToPx != marginLayoutParams4.rightMargin) {
                    marginLayoutParams4.rightMargin = dpToPx;
                    relativeLayout.setLayoutParams(marginLayoutParams4);
                }
            } else if (hasPrefixDesc) {
                RelativeLayout relativeLayout2 = z2().f444833j;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.pttPlayStatusLayout");
                ViewGroup.LayoutParams layoutParams4 = relativeLayout2.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams4;
                } else {
                    marginLayoutParams3 = null;
                }
                if (marginLayoutParams3 == null) {
                    ViewGroup.LayoutParams layoutParams5 = relativeLayout2.getLayoutParams();
                    if (layoutParams5 != null) {
                        i26 = layoutParams5.width;
                    } else {
                        i26 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams6 = relativeLayout2.getLayoutParams();
                    if (layoutParams6 != null) {
                        i27 = layoutParams6.height;
                    } else {
                        i27 = -2;
                    }
                    marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i26, i27);
                }
                if (marginLayoutParams3.rightMargin != 0) {
                    marginLayoutParams3.rightMargin = 0;
                    relativeLayout2.setLayoutParams(marginLayoutParams3);
                }
                LinearLayout linearLayout2 = z2().f444837n;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pttVoiceLayout");
                linearLayout2.setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bz8), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), linearLayout2.getPaddingBottom());
            }
            if (!com.tencent.mobileqq.aio.utils.m.f194167a.c(q1())) {
                ImageView imageView = z2().f444834k;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.pttUnread");
                ViewGroup.LayoutParams layoutParams7 = imageView.getLayoutParams();
                if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams7;
                }
                if (marginLayoutParams5 == null) {
                    ViewGroup.LayoutParams layoutParams8 = imageView.getLayoutParams();
                    if (layoutParams8 != null) {
                        i29 = layoutParams8.width;
                    } else {
                        i29 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams9 = imageView.getLayoutParams();
                    if (layoutParams9 != null) {
                        i38 = layoutParams9.height;
                    }
                    marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i29, i38);
                }
                if (marginLayoutParams5.leftMargin != 0) {
                    marginLayoutParams5.leftMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams5);
                    return;
                }
                return;
            }
            ImageView imageView2 = z2().f444834k;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pttUnread");
            int dip2px = ViewUtils.dip2px(3.0f);
            ViewGroup.LayoutParams layoutParams10 = imageView2.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams10;
            }
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams11 = imageView2.getLayoutParams();
                if (layoutParams11 != null) {
                    i28 = layoutParams11.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = imageView2.getLayoutParams();
                if (layoutParams12 != null) {
                    i38 = layoutParams12.height;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i28, i38);
            }
            if (dip2px != marginLayoutParams5.leftMargin) {
                marginLayoutParams5.leftMargin = dip2px;
                imageView2.setLayoutParams(marginLayoutParams5);
                return;
            }
            return;
        }
        if (isVoiceChange) {
            RelativeLayout relativeLayout3 = z2().f444833j;
            Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.pttPlayStatusLayout");
            int dpToPx2 = ViewUtils.dpToPx(4.0f);
            ViewGroup.LayoutParams layoutParams13 = relativeLayout3.getLayoutParams();
            if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams13;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams14 = relativeLayout3.getLayoutParams();
                if (layoutParams14 != null) {
                    i18 = layoutParams14.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = relativeLayout3.getLayoutParams();
                if (layoutParams15 != null) {
                    i19 = layoutParams15.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            if (dpToPx2 != marginLayoutParams2.rightMargin) {
                marginLayoutParams2.rightMargin = dpToPx2;
                relativeLayout3.setLayoutParams(marginLayoutParams2);
            }
        } else {
            RelativeLayout relativeLayout4 = z2().f444833j;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.pttPlayStatusLayout");
            int dip2px2 = ViewUtils.dip2px(12.0f);
            ViewGroup.LayoutParams layoutParams16 = relativeLayout4.getLayoutParams();
            if (layoutParams16 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams16;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams17 = relativeLayout4.getLayoutParams();
                if (layoutParams17 != null) {
                    i3 = layoutParams17.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = relativeLayout4.getLayoutParams();
                if (layoutParams18 != null) {
                    i16 = layoutParams18.height;
                } else {
                    i16 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
            }
            if (dip2px2 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = dip2px2;
                relativeLayout4.setLayoutParams(marginLayoutParams);
            }
        }
        ImageView imageView3 = z2().f444834k;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.pttUnread");
        int dip2px3 = ViewUtils.dip2px(3.0f);
        ViewGroup.LayoutParams layoutParams19 = imageView3.getLayoutParams();
        if (layoutParams19 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams19;
        }
        if (marginLayoutParams5 == null) {
            ViewGroup.LayoutParams layoutParams20 = imageView3.getLayoutParams();
            if (layoutParams20 != null) {
                i17 = layoutParams20.width;
            } else {
                i17 = -2;
            }
            ViewGroup.LayoutParams layoutParams21 = imageView3.getLayoutParams();
            if (layoutParams21 != null) {
                i38 = layoutParams21.height;
            }
            marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i17, i38);
        }
        if (dip2px3 != marginLayoutParams5.leftMargin) {
            marginLayoutParams5.leftMargin = dip2px3;
            imageView3.setLayoutParams(marginLayoutParams5);
        }
        LinearLayout linearLayout3 = z2().f444837n;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pttVoiceLayout");
        linearLayout3.setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bz8), linearLayout3.getPaddingTop(), linearLayout3.getPaddingRight(), linearLayout3.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3() {
        if (B2()) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(z2().f444830g, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(z2().f444828e, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(20L);
        animatorSet.start();
    }

    private final void p2(com.tencent.mobileqq.aio.msglist.holder.skin.padding.g layoutInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        ViewGroup.MarginLayoutParams marginLayoutParams5;
        ViewGroup.MarginLayoutParams marginLayoutParams6;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        ViewGroup.LayoutParams layoutParams = z2().f444826c.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = z2().f444838o.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = z2().f444827d.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams7 = null;
        int i47 = -2;
        if (!com.tencent.mobileqq.aio.utils.m.f194167a.c(q1())) {
            RelativeLayout it = z2().f444827d;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ViewGroup.LayoutParams layoutParams4 = it.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
            } else {
                marginLayoutParams4 = null;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams5 = it.getLayoutParams();
                if (layoutParams5 != null) {
                    i39 = layoutParams5.width;
                } else {
                    i39 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = it.getLayoutParams();
                if (layoutParams6 != null) {
                    i46 = layoutParams6.height;
                } else {
                    i46 = -2;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i39, i46);
            }
            if (marginLayoutParams4.bottomMargin != 0) {
                marginLayoutParams4.bottomMargin = 0;
                it.setLayoutParams(marginLayoutParams4);
            }
            ViewGroup.LayoutParams layoutParams7 = it.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams7;
            } else {
                marginLayoutParams5 = null;
            }
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams8 = it.getLayoutParams();
                if (layoutParams8 != null) {
                    i37 = layoutParams8.width;
                } else {
                    i37 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = it.getLayoutParams();
                if (layoutParams9 != null) {
                    i38 = layoutParams9.height;
                } else {
                    i38 = -2;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i37, i38);
            }
            if (marginLayoutParams5.topMargin != 0) {
                marginLayoutParams5.topMargin = 0;
                it.setLayoutParams(marginLayoutParams5);
            }
            ViewGroup.LayoutParams layoutParams10 = it.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams10;
            } else {
                marginLayoutParams6 = null;
            }
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams11 = it.getLayoutParams();
                if (layoutParams11 != null) {
                    i29 = layoutParams11.width;
                } else {
                    i29 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = it.getLayoutParams();
                if (layoutParams12 != null) {
                    i36 = layoutParams12.height;
                } else {
                    i36 = -2;
                }
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i29, i36);
            }
            if (marginLayoutParams6.leftMargin != 0) {
                marginLayoutParams6.leftMargin = 0;
                it.setLayoutParams(marginLayoutParams6);
            }
            ViewGroup.LayoutParams layoutParams13 = it.getLayoutParams();
            if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams13;
            }
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams14 = it.getLayoutParams();
                if (layoutParams14 != null) {
                    i28 = layoutParams14.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = it.getLayoutParams();
                if (layoutParams15 != null) {
                    i47 = layoutParams15.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i28, i47);
            }
            if (marginLayoutParams7.rightMargin != 0) {
                marginLayoutParams7.rightMargin = 0;
                it.setLayoutParams(marginLayoutParams7);
            }
        } else {
            RelativeLayout it5 = z2().f444827d;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.bz_);
            ViewGroup.LayoutParams layoutParams16 = it5.getLayoutParams();
            if (layoutParams16 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams16;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams17 = it5.getLayoutParams();
                if (layoutParams17 != null) {
                    i26 = layoutParams17.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = it5.getLayoutParams();
                if (layoutParams18 != null) {
                    i27 = layoutParams18.height;
                } else {
                    i27 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i26, i27);
            }
            if (dimensionPixelSize != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                it5.setLayoutParams(marginLayoutParams);
            }
            int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen.bzb);
            ViewGroup.LayoutParams layoutParams19 = it5.getLayoutParams();
            if (layoutParams19 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams19;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams20 = it5.getLayoutParams();
                if (layoutParams20 != null) {
                    i18 = layoutParams20.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams21 = it5.getLayoutParams();
                if (layoutParams21 != null) {
                    i19 = layoutParams21.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            if (dimensionPixelSize2 != marginLayoutParams2.topMargin) {
                marginLayoutParams2.topMargin = dimensionPixelSize2;
                it5.setLayoutParams(marginLayoutParams2);
            }
            int dimensionPixelSize3 = this.context.getResources().getDimensionPixelSize(R.dimen.bz8);
            ViewGroup.LayoutParams layoutParams22 = it5.getLayoutParams();
            if (layoutParams22 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams22;
            } else {
                marginLayoutParams3 = null;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams23 = it5.getLayoutParams();
                if (layoutParams23 != null) {
                    i16 = layoutParams23.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams24 = it5.getLayoutParams();
                if (layoutParams24 != null) {
                    i17 = layoutParams24.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (dimensionPixelSize3 != marginLayoutParams3.leftMargin) {
                marginLayoutParams3.leftMargin = dimensionPixelSize3;
                it5.setLayoutParams(marginLayoutParams3);
            }
            int dimensionPixelSize4 = this.context.getResources().getDimensionPixelSize(R.dimen.bz5);
            ViewGroup.LayoutParams layoutParams25 = it5.getLayoutParams();
            if (layoutParams25 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams25;
            }
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams26 = it5.getLayoutParams();
                if (layoutParams26 != null) {
                    i3 = layoutParams26.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams27 = it5.getLayoutParams();
                if (layoutParams27 != null) {
                    i47 = layoutParams27.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i3, i47);
            }
            if (dimensionPixelSize4 != marginLayoutParams7.rightMargin) {
                marginLayoutParams7.rightMargin = dimensionPixelSize4;
                it5.setLayoutParams(marginLayoutParams7);
            }
        }
        layoutParams.height = ViewUtils.dpToPx(layoutInfo.g());
        z2().f444826c.setLayoutParams(layoutParams);
        layoutParams2.height = ViewUtils.dpToPx(layoutInfo.g());
        z2().f444838o.setLayoutParams(layoutParams2);
        layoutParams3.height = ViewUtils.dpToPx(layoutInfo.b());
        z2().f444827d.setLayoutParams(layoutParams3);
    }

    private final void p3(TextView textView, String text) {
        boolean z16;
        if (textView != null && this.speechToTextBinding != null) {
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                textView.setText("");
                return;
            }
            if (B2()) {
                N3(text, Boolean.FALSE);
                return;
            }
            w71.l lVar = this.speechToTextBinding;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                lVar = null;
            }
            int maxWidth = lVar.f444843c.getMaxWidth();
            float measureText = textView.getPaint().measureText(text);
            float f16 = maxWidth;
            if (measureText <= f16) {
                s3(textView, text);
            } else {
                r3(textView, text, measureText / f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(Drawable dynamicDrawable) {
        ImageView imageView = z2().f444840q;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.pttVoicePrintView");
        if (dynamicDrawable == null) {
            dynamicDrawable = imageView.getDrawable();
        }
        if (dynamicDrawable == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (dynamicDrawable.getIntrinsicWidth() > 0) {
            int intrinsicWidth = layoutParams.width - dynamicDrawable.getIntrinsicWidth();
            if (intrinsicWidth > 0) {
                imageView.setPadding(intrinsicWidth / 2, 0, 0, 0);
            } else {
                imageView.setPadding(0, 0, 0, 0);
            }
        }
    }

    static /* synthetic */ void r2(AIOPttContentComponent aIOPttContentComponent, Drawable drawable, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = null;
        }
        aIOPttContentComponent.q2(drawable);
    }

    private final void r3(TextView textView, String text, float line) {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.mTextMultiLineAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator = this.mTextMultiLineAnim) != null) {
            valueAnimator.cancel();
        }
        int ceil = (int) Math.ceil(line);
        textView.setText("");
        int i3 = ceil * 5;
        this.mTextMultiLineAnim = ValueAnimator.ofInt(0, i3);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        textView.setText(text);
        textView.measure(0, 0);
        int measuredHeight = textView.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.height = 1;
        textView.setLayoutParams(layoutParams);
        ValueAnimator valueAnimator3 = this.mTextMultiLineAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new h(text, intRef, textView, measuredHeight, i3));
        }
        ValueAnimator valueAnimator4 = this.mTextMultiLineAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(ceil * 100);
        }
        ValueAnimator valueAnimator5 = this.mTextMultiLineAnim;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void s2(PttMsgItem msgItem) {
        int i3;
        boolean z16;
        float f16;
        AIOBubbleSkinInfo.BackgroundImageInfo a16;
        this.pttPath = msgItem.t2();
        this.currentSpeed = 1.0f;
        this.interceptLongClick = false;
        e3(q1().isSelf());
        z2().f444830g.setImageDrawable(this.aioPttPlay);
        int q26 = msgItem.q2();
        if (q26 <= 0) {
            c3(AIOPttUtil.f191743a.e(0));
            z2().f444828e.setVisibility(4);
        } else {
            c3(AIOPttUtil.f191743a.e(q26));
            z2().f444828e.setVisibility(0);
        }
        H3();
        int paddingLeft = z2().f444827d.getPaddingLeft();
        int paddingRight = z2().f444827d.getPaddingRight();
        int paddingTop = z2().f444827d.getPaddingTop();
        int paddingBottom = z2().f444827d.getPaddingBottom();
        AIOBubbleSkinInfo x06 = msgItem.x0();
        if (x06 != null && (a16 = x06.a()) != null) {
            z2().f444827d.setBackground(a16.a());
        }
        z2().f444827d.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        F3();
        B3(false);
        ImageView imageView = z2().f444834k;
        if (!q1().D2() && !q1().isSelf()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        TextView textView = z2().f444838o;
        textView.setText(q1().u2());
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "it.text");
        if (text.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        textView.setVisibility(0);
        if (((View) au.a(valueOf, textView)) == null) {
            textView.setVisibility(8);
        }
        o2(q1().G2(), z16);
        w71.l lVar = null;
        if (V2()) {
            i3(this, false, 1, null);
        } else if (T2(this, false, 1, null) && MsgExtKt.U(q1().getMsgRecord())) {
            g3(false);
        } else {
            y3(msgItem, false);
            w71.l lVar2 = this.speechToTextBinding;
            if (lVar2 != null) {
                if (lVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                } else {
                    lVar = lVar2;
                }
                lVar.getRoot().setVisibility(8);
                a3();
                B3(false);
            }
        }
        if (q1().G2()) {
            z2().f444836m.setVisibility(0);
        } else {
            z2().f444836m.setVisibility(8);
        }
        PttAudioWaveView pttAudioWaveView = z2().f444826c;
        AIOPttUtil aIOPttUtil = AIOPttUtil.f191743a;
        if (aIOPttUtil.c().a() == q1().getMsgId()) {
            z2().f444826c.setCanSupportSlide(true);
            f16 = aIOPttUtil.c().c();
        } else {
            f16 = 0.0f;
        }
        pttAudioWaveView.setProgressX(f16);
        if (TextUtils.isEmpty(this.pttPath)) {
            return;
        }
        AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
        long msgId = q1().getMsgId();
        int hashCode = hashCode();
        String str = this.pttPath;
        Intrinsics.checkNotNull(str);
        aIOPttAudioPlayerManager.x(msgId, hashCode, str, this.aioPttAudioPlayerStateListener);
    }

    private final void s3(TextView textView, String text) {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.mTextTypingAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator = this.mTextTypingAnim) != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, text.length() - 1);
        this.mTextTypingAnim = ofInt;
        if (ofInt != null) {
            ofInt.addUpdateListener(new i(text, textView));
        }
        ValueAnimator valueAnimator3 = this.mTextTypingAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(text.length() * 14);
        }
        ValueAnimator valueAnimator4 = this.mTextTypingAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator5 = this.mTextTypingAnim;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    private final void t2(PttMsgItem msgItem) {
        int vipPerceptionVoiceS;
        if (T2(this, false, 1, null)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOPttContentComponent", 2, "\u5df2\u7ecf\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57,\u8df3\u8fc7\u68c0\u67e5,msgId:" + msgItem.getMsgId());
                return;
            }
            return;
        }
        PttElement s26 = msgItem.s2();
        if (s26 != null && (vipPerceptionVoiceS = ((IVasConfigProxy) QRoute.api(IVasConfigProxy.class)).getVipPerceptionVoiceS()) > 0 && s26.duration >= vipPerceptionVoiceS) {
            try {
                ((IVasAioVipPerceptionProxy) QRoute.api(IVasAioVipPerceptionProxy.class)).voiceMsg30s(q1());
            } catch (Exception e16) {
                QLog.i("AIOPttContentComponent", 1, "checkVoice30sVipPerception " + e16);
            }
        }
    }

    private final boolean t3() {
        Integer num;
        int i3;
        ArrayList<Byte> arrayList;
        boolean E2 = q1().E2();
        long msgId = q1().getMsgId();
        String str = this.pttPath;
        int q26 = q1().q2();
        PttElement s26 = q1().s2();
        if (s26 != null && (arrayList = s26.waveAmplitudes) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.i("AIOPttContentComponent", 1, "togglePlayAudio msgId:" + msgId + ", pttPath:" + str + ", exists:" + E2 + ", duration:" + q26 + ", wave.size:" + num);
        if (E2) {
            AIOPttUtil aIOPttUtil = AIOPttUtil.f191743a;
            if (aIOPttUtil.c().a() == q1().getMsgId()) {
                i3 = aIOPttUtil.c().b();
            } else {
                aIOPttUtil.i(q1().getMsgId());
                i3 = Integer.MIN_VALUE;
            }
            AIOPttAudioPlayerManager.f191706d.E(q1().t2(), i3, this.currentSpeed, q1().getMsgId());
            z2().f444826c.setCanSupportSlide(true);
            K3();
        } else if (q1().B2()) {
            QQToast.makeText(this.context, 0, R.string.ysw, 0).show();
        } else {
            v2(q1());
            if (!q1().w2() && q1().getFileTransNotifyInfo().trasferStatus == 5) {
                QQToast.makeText(this.context, 0, R.string.ysv, 0).show();
            }
        }
        return E2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(PttMsgItem msgItem) {
        if (T2(this, false, 1, null)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOPttContentComponent", 2, "\u5df2\u7ecf\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57,\u8df3\u8fc7\u68c0\u67e5,msgId:" + msgItem.getMsgId());
                return;
            }
            return;
        }
        try {
            ((IVasAioVipPerceptionProxy) QRoute.api(IVasAioVipPerceptionProxy.class)).longClickVoiceMsg(msgItem);
        } catch (Exception e16) {
            QLog.i("AIOPttContentComponent", 1, "longClickVoiceVipPerception " + e16);
        }
    }

    private final void u3() {
        AIOBubbleSkinInfo x06 = q1().x0();
        boolean z16 = false;
        if (x06 != null && x06.d() == 1) {
            z16 = true;
        }
        this.isVasBubble = z16;
        if (x06 == null || x06.d() == 0) {
            com.tencent.mobileqq.aio.utils.m mVar = com.tencent.mobileqq.aio.utils.m.f194167a;
            String b16 = mVar.b(q1());
            if (!TextUtils.isEmpty(b16)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("AIOPttContentComponent", 4, "[tryGetBubbleInfo]");
                }
                com.tencent.qqnt.aio.refresher.g gVar = new com.tencent.qqnt.aio.refresher.g(q1(), b16, mVar.a(q1()), "", null, 16, null);
                sendIntent(new d.ah(gVar));
                com.tencent.qqnt.aio.refresher.h c16 = gVar.c();
                if (c16 != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOPttContentComponent", 4, "[tryGetBubbleInfo]: resp");
                    }
                    I3(c16.a());
                    return;
                }
                return;
            }
            Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(final PttMsgItem msgItem) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.e
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttContentComponent.w2(PttMsgItem.this);
            }
        }, 64, null, false);
    }

    private final void v3(float speed) {
        int i3;
        float f16 = this.currentSpeed;
        this.currentSpeed = speed;
        boolean z16 = true;
        QLog.i("AIOPttContentComponent", 1, "handleUIState play mode speed:" + speed);
        if (t3()) {
            if (this.currentSpeed != 2.0f) {
                z16 = false;
            }
            if (z16) {
                i3 = R.string.ysy;
            } else {
                i3 = R.string.ysz;
            }
            QQToast.makeText(this.context, i3, 0).show();
            return;
        }
        this.currentSpeed = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(PttMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        msgItem.l2();
    }

    private final void w3(int sendStatus) {
        boolean z16;
        if (q1().K0() && q1().v2()) {
            boolean z17 = true;
            if (sendStatus != 2 && sendStatus != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            LinearLayout linearLayout = z2().f444837n;
            Boolean valueOf = Boolean.valueOf(z16);
            linearLayout.setVisibility(0);
            if (((View) au.a(valueOf, linearLayout)) == null) {
                linearLayout.setVisibility(8);
            }
            d3(!z16);
            if (sendStatus != 0) {
                z17 = false;
            }
            ImageView imageView = z2().f444830g;
            Boolean valueOf2 = Boolean.valueOf(z17);
            imageView.setVisibility(8);
            if (((View) au.a(valueOf2, imageView)) == null) {
                imageView.setVisibility(0);
            }
            TextView textView = z2().f444828e;
            Boolean valueOf3 = Boolean.valueOf(z17);
            textView.setVisibility(8);
            if (((View) au.a(valueOf3, textView)) == null) {
                textView.setVisibility(0);
            }
            PttAudioWaveView pttAudioWaveView = z2().f444826c;
            Boolean valueOf4 = Boolean.valueOf(z17);
            pttAudioWaveView.setVisibility(8);
            if (((View) au.a(valueOf4, pttAudioWaveView)) == null) {
                pttAudioWaveView.setVisibility(0);
            }
            ImageView imageView2 = z2().f444839p;
            Boolean valueOf5 = Boolean.valueOf(z17);
            imageView2.setVisibility(0);
            if (((View) au.a(valueOf5, imageView2)) == null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        d3(false);
        z2().f444839p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2() {
        w71.l lVar;
        boolean z16 = !TextUtils.isEmpty(z2().f444838o.getText());
        if (com.tencent.mobileqq.aio.utils.d.U(q1()) && !FontSettingManager.isFontSizeLarge() && !B2() && !this.isScaleAnimEnd && !z16) {
            this.isScaleAnimEnd = true;
            z2().f444827d.setScaleX(1.0f);
            z2().f444827d.setScaleY(1.0f);
            z2().f444827d.setTranslationX(0.0f);
            if (V2() && (lVar = this.speechToTextBinding) != null) {
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    lVar = null;
                }
                lVar.getRoot().setTranslationY(0.0f);
            }
            z2().f444834k.setScaleX(1.0f);
            z2().f444834k.setScaleY(1.0f);
            z2().f444834k.setTranslationX(0.0f);
            f3(true);
        }
    }

    private final void x3(PttElement pttElement, int duration) {
        boolean z16;
        ArrayList<Byte> arrayList = pttElement.waveAmplitudes;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        AIOPttUtil aIOPttUtil = AIOPttUtil.f191743a;
        QLog.i("AIOPttContentComponent", 1, "updateAudioDurationAndWaveView waveAmplitudes is null or empty: " + z16 + ", duration: " + aIOPttUtil.e(duration));
        this.lastDurationWidth = 0;
        c3(aIOPttUtil.e(duration));
        z2().f444828e.setVisibility(0);
        z3(pttElement, false, duration);
        H3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime y2() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final void y3(PttMsgItem msgItem, boolean adjustWithSpeechToText) {
        if (msgItem.C2()) {
            PttAudioWaveView pttAudioWaveView = z2().f444826c;
            ViewGroup.LayoutParams layoutParams = z2().f444826c.getLayoutParams();
            layoutParams.width = f191720g0;
            pttAudioWaveView.setLayoutParams(layoutParams);
            return;
        }
        PttElement s26 = msgItem.s2();
        if (s26 == null) {
            return;
        }
        z3(s26, adjustWithSpeechToText, msgItem.q2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w71.k z2() {
        return (w71.k) this.binding.getValue();
    }

    private final void z3(PttElement pttElement, boolean adjustWithSpeechToText, int duration) {
        boolean z16;
        int i3;
        ArrayList<Byte> arrayList = pttElement.waveAmplitudes;
        boolean z17 = true;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            int F2 = F2();
            if (adjustWithSpeechToText) {
                w71.l lVar = this.speechToTextBinding;
                if (lVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    lVar = null;
                }
                lVar.getRoot().measure(0, 0);
                w71.l lVar2 = this.speechToTextBinding;
                if (lVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speechToTextBinding");
                    lVar2 = null;
                }
                i3 = lVar2.getRoot().getMeasuredWidth() - F2;
            } else {
                i3 = 0;
            }
            int g16 = AIOPttUtil.f191743a.g(duration, i3, J2(), a.C7329a.f192417a.f(true) - F2, q1().G2());
            ViewGroup.LayoutParams layoutParams = z2().f444826c.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = g16;
            z2().f444826c.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = z2().f444840q.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams2.width = g16 + com.tencent.mobileqq.utils.x.a(16.0f);
            z2().f444840q.setLayoutParams(layoutParams2);
            r2(this, null, 1, null);
            if (B2() || !q1().Q0()) {
                z17 = false;
            }
            z2().f444826c.setAudioData(pttElement.waveAmplitudes, layoutParams.width, z17);
        }
    }

    public final float A2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.currentSpeed;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        QLog.i("AIOPttContentComponent", 1, "interceptLongClick:" + this.interceptLongClick);
        return this.interceptLongClick;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        long msgId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!w1()) {
            msgId = 0;
        } else {
            msgId = q1().getMsgId();
        }
        super.b1(position, msgItem, payloads);
        if (!K2(payloads)) {
            return;
        }
        AIOPttAudioPlayerManager.f191706d.G(msgId, hashCode());
        X2();
        Z2();
        b3();
        s2(q1());
        R2(q1());
        w3(q1().R());
        if (!q1().C2()) {
            v2(q1());
        }
        AIOBubbleSkinInfo x06 = q1().x0();
        if (x06 != null) {
            I3(x06);
        }
        if (!q1().C2()) {
            u3();
            t2(q1());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ConstraintLayout root = z2().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            C3(z2().getRoot().getBackground(), null);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        LinearLayout linearLayout = z2().f444837n;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pttVoiceLayout");
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof MenuState.PttSpeakerPhone) {
            MenuState.PttSpeakerPhone pttSpeakerPhone = (MenuState.PttSpeakerPhone) state;
            QLog.i("AIOPttContentComponent", 1, "handleUIState speaker phone on:" + pttSpeakerPhone.a());
            AIOPttAudioPlayerManager.f191706d.C(pttSpeakerPhone.a());
            t3();
            sendIntent(new d.af(Boolean.valueOf(pttSpeakerPhone.a())));
            return;
        }
        if (state instanceof MenuState.PttPlayMode) {
            v3(((MenuState.PttPlayMode) state).a());
            return;
        }
        if (state instanceof MenuState.SpeechToText) {
            L2(((MenuState.SpeechToText) state).a());
            return;
        }
        if (state instanceof MenuState.PackUp) {
            M2();
            return;
        }
        if (state instanceof AIOMsgItemUIState.StopPlayingAudio) {
            if (!w1()) {
                QLog.i("AIOPttContentComponent", 1, "StopPlayingAudio but not initialized yet");
                return;
            }
            if (((AIOMsgItemUIState.StopPlayingAudio) state).a() == q1().getMsgId()) {
                AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
                if (aIOPttAudioPlayerManager.o(q1().t2(), q1().getMsgId())) {
                    aIOPttAudioPlayerManager.D();
                    QLog.i("AIOPttContentComponent", 1, "StopPlayingAudio, id:" + q1().getMsgId());
                }
            }
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.h1();
        AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
        boolean p16 = AIOPttAudioPlayerManager.p(aIOPttAudioPlayerManager, this.pttPath, 0L, 2, null);
        QLog.i("AIOPttContentComponent", 1, "onLongClick isCurPttPathPlaying:" + p16 + " pttPath:" + this.pttPath);
        E3(this.aioPttPlay);
        if (p16) {
            AIOPttAudioPlayerManager.v(aIOPttAudioPlayerManager, false, 1, null);
        }
        C3(z2().getRoot().getBackground(), f191719f0);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOPttContentComponent.W2(AIOPttContentComponent.this, view);
            }
        };
        z2().f444837n.setOnClickListener(onClickListener);
        z2().f444826c.setOnClickListener(onClickListener);
        z2().f444826c.setSeekListener(this.seekProgressListener);
        z2().f444826c.setOnDragProgressListener(this.onDragProgressListener);
        z2().f444826c.setOnSendAnimStartListener(this.onSendAnimStartListener);
        return super.onCreateView(createViewParams);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @SuppressLint({"MissingSuperCall"})
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (w1()) {
            if (z2().f444826c.j() > 0.0f) {
                AIOPttUtil.f191743a.j(q1().getMsgId(), 0, 0.0f);
            }
            AIOPttAudioPlayerManager.f191706d.G(q1().getMsgId(), hashCode());
        }
        G2().removeCallbacksAndMessages(null);
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new u();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List listOf;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        boolean z18 = true;
        boolean z19 = !com.tencent.mobileqq.qqaudio.audioplayer.c.b(y2());
        ArrayList arrayList = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new com.tencent.qqnt.aio.menu.y(this.context, q1(), this, z19), new com.tencent.qqnt.aio.menu.af(this.context, q1(), this), new com.tencent.qqnt.aio.menu.h(this.context, q1(), this), new com.tencent.qqnt.aio.menu.u(this.context, q1(), this), new ad(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.i(this.context, q1()), new ap(getMContext(), q1(), this), new ag(getMContext(), q1())});
        arrayList.addAll(listOf);
        float f16 = 1.0f;
        if (this.currentSpeed == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = 2.0f;
        }
        if (!q1().G2()) {
            arrayList.add(1, new com.tencent.qqnt.aio.menu.z(this.context, q1(), this, V2()));
            arrayList.add(2, new aa(this.context, q1(), this, f16));
        } else {
            arrayList.add(1, new aa(this.context, q1(), this, f16));
        }
        arrayList.add(new aj(getMContext(), q1(), this));
        if (q1().getMsgRecord().chatType == 2 || q1().getMsgRecord().chatType == 1) {
            String b16 = com.tencent.mobileqq.aio.utils.m.f194167a.b(q1());
            if (b16.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 || Intrinsics.areEqual(b16, "0")) {
                z18 = false;
            }
            if (z18) {
                arrayList.add(new com.tencent.qqnt.aio.menu.n(getMContext(), q1(), this));
            }
        }
        return arrayList;
    }
}
