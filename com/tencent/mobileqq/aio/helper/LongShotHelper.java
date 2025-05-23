package com.tencent.mobileqq.aio.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.LruCache;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.RichMediaMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001h\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00019B\u0019\u0012\u0006\u0010m\u001a\u00020B\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\bn\u0010oJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0003J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001d\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J$\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u001c\u0010)\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\b\u0010*\u001a\u00020\u0005H\u0002J\u001c\u0010-\u001a\u00020\u00052\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0+H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\u001e\u00101\u001a\u00020\u00052\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00172\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0003H\u0016J\b\u00107\u001a\u00020\u001dH\u0016J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020/0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010=R\u0018\u0010Y\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010XR\u0018\u0010_\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010XR\u0018\u0010`\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010XR\u0018\u0010b\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010XR\u001e\u0010g\u001a\u0004\u0018\u00010d8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b6\u0010e\u001a\u0004\b^\u0010fR\u0014\u0010j\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010iR&\u0010l\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020h0k0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/LongShotHelper;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "O", "", "shotMode", "ignoreGuide", "Y", ExifInterface.LATITUDE_SOUTH, "e0", "Landroid/content/Context;", "context", "a0", BdhLogUtil.LogTag.Tag_Req, "isEnabled", "d0", "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "operationCode", UIJsPlugin.EVENT_SHOW_LOADING, "b0", "", "Lcom/tencent/aio/data/msglist/a;", "M", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "J", "", "i", "", "N", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "G", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "success", "", "path", "W", "U", "V", "Landroidx/collection/LruCache;", "bitmapCache", "H", "I", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "P", "T", tl.h.F, "g", "msgIntent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getId", "getTag", "a", "b", "onBackEvent", "f", "Z", "mShotMode", "", "Ljava/util/List;", "mSelectMsgList", "Lcom/tencent/aio/main/businesshelper/b;", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mContext", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "mActivity", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "E", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressDialog", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "mOperationCode", "mIsMosaic", "Landroid/graphics/Bitmap;", "mMergedBitmap", "mTitleBitmap", "mMosaicTitleBitmap", "K", "mInputBarBitmap", "L", "mShortcutBarBitmap", "mBottomBlurBitmap", "Ljava/lang/String;", "mAIOLongShotDir", "mWatermarkBitmap", "Lcom/tencent/mobileqq/aio/longshot/b;", "Lcom/tencent/mobileqq/aio/longshot/b;", "()Lcom/tencent/mobileqq/aio/longshot/b;", "mLongShotProcessor", "com/tencent/mobileqq/aio/helper/LongShotHelper$b", "Lcom/tencent/mobileqq/aio/helper/LongShotHelper$b;", "mAction", "Lkotlin/Pair;", "mMsgList", "helperParam", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LongShotHelper extends com.tencent.mobileqq.aio.helper.LateInitHelper.b implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Handler mUiHandler;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QQProgressDialog mProgressDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IAIOScreenShotApi.OperationCode mOperationCode;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsMosaic;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Bitmap mMergedBitmap;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Bitmap mTitleBitmap;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Bitmap mMosaicTitleBitmap;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Bitmap mInputBarBitmap;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Bitmap mShortcutBarBitmap;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Bitmap mBottomBlurBitmap;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String mAIOLongShotDir;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Bitmap mWatermarkBitmap;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.longshot.b mLongShotProcessor;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMsgList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mShotMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AIOMsgItem> mSelectMsgList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/LongShotHelper$a;", "", "", "KEY_IS_FIRST_USE", "Ljava/lang/String;", "SP_NAME", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.LongShotHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/helper/LongShotHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LongShotHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                LongShotHelper.this.O(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongShotHelper(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
        super(helperParam, msgIntent);
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helperParam, (Object) msgIntent);
            return;
        }
        this.mSelectMsgList = new ArrayList();
        this.mUiHandler = new Handler(Looper.getMainLooper());
        b bVar = new b();
        this.mAction = bVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.AddSelectMsg.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.AddSelectMsgList.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.RemoveSelectMsg.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.RemoveAllSelectMsg.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.SetShotMode.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetShotMode.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetLongShotMsgList.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetMosaicStatus.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.IsMsgSelect.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetSelectMsgSum.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.ShotPreview.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.ShotEdit.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.ShotMosaic.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.ShotComplete.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetRecyclerView.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetTitleBitmap.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetInputBarBitmap.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetShortcutBarBitmap.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetBottomBlurBitmap.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotEvent.LongShotResult.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.GetWatermarkBitmap.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LongShotMsgIntent.CompleteShotAndShare.class)), bVar)});
        this.mMsgList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G(Bitmap bitmap, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LongShotHelper$encodeAndWritePNG$2(bitmap, this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(LruCache<String, Bitmap> bitmapCache) {
        int size = bitmapCache.size();
        for (int i3 = 0; i3 < size; i3++) {
            Bitmap bitmap = bitmapCache.get(String.valueOf(i3));
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        I();
        R();
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new LongShotMsgIntent.OnShotFinish(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        com.tencent.aio.main.businesshelper.b bVar = null;
        Z(this, false, false, 2, null);
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar2 = null;
        }
        bVar2.a().e().h(new LongShotMsgIntent.ShotMosaic(false));
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar = bVar3;
        }
        bVar.a().e().h(new AIOMsgListEvent.LongShotModeChangeEvent("LongShotHelper", false));
        d0(true);
        Bitmap bitmap = this.mMergedBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private final void J(RecyclerView recyclerView) {
        int size = this.mSelectMsgList.size();
        if (size == 0) {
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.af
                @Override // java.lang.Runnable
                public final void run() {
                    LongShotHelper.K(LongShotHelper.this);
                }
            });
            return;
        }
        V();
        recyclerView.addOnChildAttachStateChangeListener(new LongShotHelper$getItemViewList$2(this, new Ref.IntRef(), new LruCache(size), new Ref.IntRef(), size, recyclerView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(LongShotHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0(true);
        this$0.R();
        com.tencent.aio.main.businesshelper.b bVar = this$0.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new LongShotMsgIntent.OnShotFinish(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.longshot.b L() {
        com.tencent.mobileqq.aio.longshot.b aVar;
        if (this.mLongShotProcessor == null) {
            com.tencent.aio.main.businesshelper.b bVar = null;
            if (T()) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar = bVar2;
                }
                aVar = new com.tencent.mobileqq.aio.longshot.d(context, bVar.a());
            } else {
                Context context2 = this.mContext;
                Intrinsics.checkNotNull(context2);
                com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar = bVar3;
                }
                aVar = new com.tencent.mobileqq.aio.longshot.a(context2, bVar.a());
            }
            this.mLongShotProcessor = aVar;
        }
        return this.mLongShotProcessor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem] */
    private final List<com.tencent.aio.data.msglist.a> M() {
        Comparator compareBy;
        int collectionSizeOrDefault;
        ?? cloneNewInstance;
        List<AIOMsgItem> list = this.mSelectMsgList;
        compareBy = ComparisonsKt__ComparisonsKt.compareBy(LongShotHelper$getMsgList$1.INSTANCE, LongShotHelper$getMsgList$2.INSTANCE);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(list, compareBy);
        List<AIOMsgItem> list2 = this.mSelectMsgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (AIOMsgItem aIOMsgItem : list2) {
            aIOMsgItem.w1(this.mIsMosaic);
            aIOMsgItem.S1(true);
            if (aIOMsgItem instanceof ArkMsgItem) {
                cloneNewInstance = aIOMsgItem.cloneNewInstance();
                Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ArkMsgItem");
                ((ArkMsgItem) cloneNewInstance).v2(true);
            } else if (aIOMsgItem instanceof MarkdownMsgItem) {
                AIOMsgItem cloneNewInstance2 = aIOMsgItem.cloneNewInstance();
                Intrinsics.checkNotNull(cloneNewInstance2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem");
                cloneNewInstance = (MarkdownMsgItem) cloneNewInstance2;
                cloneNewInstance.T1(true);
                cloneNewInstance.b(false);
                cloneNewInstance.h(false);
                cloneNewInstance.K2();
            } else {
                cloneNewInstance = aIOMsgItem.cloneNewInstance();
                cloneNewInstance.T1(true);
                if (cloneNewInstance instanceof com.tencent.mobileqq.aio.msg.l) {
                    com.tencent.mobileqq.aio.msg.l lVar = (com.tencent.mobileqq.aio.msg.l) cloneNewInstance;
                    lVar.b(false);
                    lVar.h(false);
                }
            }
            arrayList.add(cloneNewInstance);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N(int i3) {
        if (!this.mSelectMsgList.isEmpty() && i3 < this.mSelectMsgList.size()) {
            AIOMsgItem aIOMsgItem = this.mSelectMsgList.get(i3);
            if (aIOMsgItem instanceof com.tencent.mobileqq.aio.msg.ae) {
                return 20L;
            }
            if (aIOMsgItem instanceof PttMsgItem) {
                return 50L;
            }
            if (aIOMsgItem instanceof PicMsgItem) {
                return 250L;
            }
            if (!(aIOMsgItem instanceof AniStickerMsgItem) && !(aIOMsgItem instanceof RichMediaMsgItem)) {
                if (aIOMsgItem instanceof ArkMsgItem) {
                    return 800L;
                }
                if (aIOMsgItem.getMsgRecord().msgType != 24) {
                    return 200L;
                }
            }
            return 500L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final MsgIntent intent) {
        boolean z16;
        if (intent instanceof LongShotMsgIntent.AddSelectMsg) {
            this.mSelectMsgList.add(((LongShotMsgIntent.AddSelectMsg) intent).a());
            return;
        }
        if (intent instanceof LongShotMsgIntent.AddSelectMsgList) {
            this.mSelectMsgList.addAll(((LongShotMsgIntent.AddSelectMsgList) intent).a());
            return;
        }
        if (intent instanceof LongShotMsgIntent.RemoveSelectMsg) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.mSelectMsgList, (Function1) new Function1<AIOMsgItem, Boolean>() { // from class: com.tencent.mobileqq.aio.helper.LongShotHelper$handleAction$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgIntent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull AIOMsgItem it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getMsgId() == ((LongShotMsgIntent.RemoveSelectMsg) MsgIntent.this).a().getMsgId());
                }
            });
            return;
        }
        if (intent instanceof LongShotMsgIntent.RemoveAllSelectMsg) {
            this.mSelectMsgList.clear();
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetShotMode) {
            ((LongShotMsgIntent.GetShotMode) intent).b(this.mShotMode);
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetLongShotMsgList) {
            ((LongShotMsgIntent.GetLongShotMsgList) intent).b(this.mSelectMsgList);
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetMosaicStatus) {
            ((LongShotMsgIntent.GetMosaicStatus) intent).b(this.mIsMosaic);
            return;
        }
        Object obj = null;
        boolean z17 = false;
        if (intent instanceof LongShotMsgIntent.IsMsgSelect) {
            LongShotMsgIntent.IsMsgSelect isMsgSelect = (LongShotMsgIntent.IsMsgSelect) intent;
            Iterator<T> it = this.mSelectMsgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((AIOMsgItem) next).getMsgId() == isMsgSelect.a().getMsgId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                z17 = true;
            }
            isMsgSelect.c(z17);
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetSelectMsgSum) {
            ((LongShotMsgIntent.GetSelectMsgSum) intent).b(this.mSelectMsgList.size());
            return;
        }
        if (intent instanceof LongShotMsgIntent.SetShotMode) {
            Z(this, ((LongShotMsgIntent.SetShotMode) intent).a(), false, 2, null);
            return;
        }
        if (intent instanceof LongShotMsgIntent.ShotPreview) {
            c0(this, IAIOScreenShotApi.OperationCode.PREVIEW, false, 2, null);
            return;
        }
        if (intent instanceof LongShotMsgIntent.ShotEdit) {
            c0(this, IAIOScreenShotApi.OperationCode.EDIT, false, 2, null);
            return;
        }
        if (intent instanceof LongShotMsgIntent.ShotMosaic) {
            this.mIsMosaic = ((LongShotMsgIntent.ShotMosaic) intent).a();
            return;
        }
        if (intent instanceof LongShotMsgIntent.ShotComplete) {
            c0(this, IAIOScreenShotApi.OperationCode.COMPLETE, false, 2, null);
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetRecyclerView) {
            J(((LongShotMsgIntent.GetRecyclerView) intent).a());
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetTitleBitmap) {
            LongShotMsgIntent.GetTitleBitmap getTitleBitmap = (LongShotMsgIntent.GetTitleBitmap) intent;
            this.mTitleBitmap = getTitleBitmap.a();
            this.mMosaicTitleBitmap = getTitleBitmap.b();
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetInputBarBitmap) {
            this.mInputBarBitmap = ((LongShotMsgIntent.GetInputBarBitmap) intent).a();
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetShortcutBarBitmap) {
            this.mShortcutBarBitmap = ((LongShotMsgIntent.GetShortcutBarBitmap) intent).a();
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetBottomBlurBitmap) {
            this.mBottomBlurBitmap = ((LongShotMsgIntent.GetBottomBlurBitmap) intent).a();
            return;
        }
        if (intent instanceof LongShotEvent.LongShotResult) {
            I();
            return;
        }
        if (intent instanceof LongShotMsgIntent.GetWatermarkBitmap) {
            this.mWatermarkBitmap = ((LongShotMsgIntent.GetWatermarkBitmap) intent).a();
        } else if (intent instanceof LongShotMsgIntent.CompleteShotAndShare) {
            LongShotMsgIntent.CompleteShotAndShare completeShotAndShare = (LongShotMsgIntent.CompleteShotAndShare) intent;
            P(completeShotAndShare.a(), completeShotAndShare.b());
        }
    }

    private final void P(List<? extends AIOMsgItem> msgList, boolean showLoading) {
        Context context = this.mContext;
        if (context == null || !com.tencent.mobileqq.aio.utils.am.f194110a.b(context, new ArrayList(), msgList)) {
            return;
        }
        Y(true, true);
        this.mSelectMsgList.addAll(msgList);
        b0(IAIOScreenShotApi.OperationCode.MULTISELCT_SHARE, showLoading);
    }

    private final void R() {
        try {
            QQProgressDialog qQProgressDialog = this.mProgressDialog;
            if (qQProgressDialog != null) {
                Intrinsics.checkNotNull(qQProgressDialog);
                qQProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
        } catch (Exception e16) {
            QLog.e("LongShotHelper", 1, "progress dialog error: " + e16);
        }
    }

    private final boolean S() {
        SharedPreferences sharedPreferences;
        Context context = this.mContext;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("LongShotHelper_SP", 0);
        } else {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("KEY_IS_FIRST_USE", true);
    }

    private final boolean T() {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "mHelperParam.aioContext.aioParam");
        long a16 = su3.c.a(g16);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(bVar2.a().g().r().c().e()));
    }

    private final void U(String path, Bitmap bitmap) {
        boolean z16;
        boolean isBlank;
        if (path != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(path);
            if (!isBlank) {
                z16 = false;
                if (z16 && this.mActivity != null && bitmap != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LongShotHelper", 2, "onGenerateFile() called with: path = [" + path + "]");
                    }
                    com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
                    com.tencent.aio.main.businesshelper.b bVar2 = null;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                        bVar = null;
                    }
                    AIOParam g16 = bVar.a().g();
                    Intrinsics.checkNotNullExpressionValue(g16, "mHelperParam.aioContext.aioParam");
                    long a16 = su3.c.a(g16);
                    com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                        bVar3 = null;
                    }
                    LifecycleOwner d16 = bVar3.a().d();
                    Intrinsics.checkNotNullExpressionValue(d16, "mHelperParam.aioContext.lifecycleOwner");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new LongShotHelper$onGenerateFile$1(this, a16, path, bitmap, null), 3, null);
                    d0(true);
                    R();
                    com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
                    if (bVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    } else {
                        bVar2 = bVar4;
                    }
                    bVar2.a().e().h(new LongShotMsgIntent.OnShotFinish(true));
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void V() {
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        long maxMemory = runtime.maxMemory() / 1048576;
        QLog.e("LongShotHelper", 1, "printMemoryInfo: maxHeapSizeInMB=" + maxMemory + "MB, usedMemInMB=" + freeMemory + "MB, availHeapSizeInMB=" + (maxMemory - freeMemory) + "MB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final boolean success, final String path, final Bitmap bitmap) {
        if (!this.mShotMode) {
            return;
        }
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ag
            @Override // java.lang.Runnable
            public final void run() {
                LongShotHelper.X(LongShotHelper.this, success, path, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(LongShotHelper this$0, boolean z16, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.mActivity;
        if (activity != null && !activity.isFinishing()) {
            if (z16) {
                this$0.U(str, bitmap);
            } else {
                QQToast.makeText(this$0.mContext, 1, HardCodeUtil.qqStr(R.string.yrp), 0).show();
            }
        }
    }

    private final void Y(boolean shotMode, boolean ignoreGuide) {
        this.mShotMode = shotMode;
        if (!shotMode) {
            this.mSelectMsgList.clear();
        }
        d0(true);
        if (!ignoreGuide && shotMode && S()) {
            e0();
            ((IAIOScreenShotApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOScreenShotApi.class)).showLongShotGuide(T());
        }
    }

    static /* synthetic */ void Z(LongShotHelper longShotHelper, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        longShotHelper.Y(z16, z17);
    }

    private final void a0(Context context) {
        try {
            R();
            QQProgressDialog qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.mProgressDialog = qQProgressDialog;
            Intrinsics.checkNotNull(qQProgressDialog);
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.yry));
            QQProgressDialog qQProgressDialog2 = this.mProgressDialog;
            Intrinsics.checkNotNull(qQProgressDialog2);
            qQProgressDialog2.show();
        } catch (Exception e16) {
            QLog.e("LongShotHelper", 1, "progress dialog error: " + e16);
        }
    }

    private final void b0(IAIOScreenShotApi.OperationCode operationCode, boolean showLoading) {
        Activity activity;
        d0(false);
        this.mOperationCode = operationCode;
        com.tencent.mobileqq.aio.longshot.b L = L();
        if (L != null) {
            L.j(M());
        }
        if (showLoading && (activity = this.mActivity) != null) {
            a0(activity);
        }
    }

    static /* synthetic */ void c0(LongShotHelper longShotHelper, IAIOScreenShotApi.OperationCode operationCode, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        longShotHelper.b0(operationCode, z16);
    }

    private final void d0(boolean isEnabled) {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new LongShotEvent.LongShotBarStatus(isEnabled));
    }

    @SuppressLint({"CommitPrefEdits"})
    private final void e0() {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        Context context = this.mContext;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("LongShotHelper_SP", 0);
        } else {
            sharedPreferences = null;
        }
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && (putBoolean = edit.putBoolean("KEY_IS_FIRST_USE", false)) != null) {
            putBoolean.apply();
        }
    }

    public void Q(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            O(msgIntent);
        }
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void a() {
        Context context;
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("LongShotHelper", 1, OperateCustomButton.OPERATE_CREATE);
        com.tencent.aio.main.businesshelper.b c16 = c();
        this.mHelperParam = c16;
        com.tencent.aio.main.businesshelper.b bVar = null;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            c16 = null;
        }
        Fragment c17 = c16.a().c();
        if (c17 != null) {
            context = c17.getContext();
        } else {
            context = null;
        }
        this.mContext = context;
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar2 = null;
        }
        Fragment c18 = bVar2.a().c();
        if (c18 != null) {
            fragmentActivity = c18.getActivity();
        } else {
            fragmentActivity = null;
        }
        this.mActivity = fragmentActivity;
        if (e() != null) {
            Q(e());
        }
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar3 = null;
            }
            bVar3.a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar = bVar4;
        }
        bVar.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("LongShotHelper", 1, "destroy");
        Iterator<T> it = this.mMsgList.iterator();
        while (true) {
            com.tencent.aio.main.businesshelper.b bVar = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar2;
            }
            bVar.a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar3 = null;
        }
        bVar3.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        Z(this, false, false, 2, null);
        this.mShotMode = false;
        this.mSelectMsgList.clear();
        this.mContext = null;
        this.mActivity = null;
        this.mProgressDialog = null;
        this.mOperationCode = null;
        this.mIsMosaic = false;
        this.mMergedBitmap = null;
        this.mTitleBitmap = null;
        this.mMosaicTitleBitmap = null;
        this.mInputBarBitmap = null;
        this.mShortcutBarBitmap = null;
        this.mBottomBlurBitmap = null;
        this.mAIOLongShotDir = null;
        this.mWatermarkBitmap = null;
        this.mLongShotProcessor = null;
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "LongShotHelper";
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.mShotMode) {
            I();
            return true;
        }
        return false;
    }
}
