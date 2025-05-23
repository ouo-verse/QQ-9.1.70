package com.tencent.qqnt.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.chats.biz.miniaio.IMiniAIOAPI;
import com.tencent.qqnt.chats.biz.miniaio.MiniAioActivity;
import com.tencent.qqnt.chats.biz.miniaio.h;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.miniaio.HorizontalMiniaioFragment;
import com.tencent.qqnt.miniaio.api.IMiniaioApi;
import com.tencent.qqnt.miniaio.input.MiniAIOInputEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts.e;
import w71.ac;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0002efB\u0007\u00a2\u0006\u0004\bb\u0010cJ&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0006\u0010\u0014\u001a\u00020\rJ\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J \u0010\"\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0018\u0010%\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0007H\u0002J3\u00105\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001f2!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\r01H\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0002J\b\u0010<\u001a\u00020\rH\u0002J\b\u0010=\u001a\u00020\rH\u0002R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010R\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010SR\u0016\u0010Y\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006g"}, d2 = {"Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/qqnt/miniaio/d;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initWindowStyleAndAnimation", "", "needImmersive", "onStart", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "ai", "", VasReportUtils.BUSINESS_TYPE_EMOTION, "code", "oa", "delete", "e0", "Rh", "Th", "bi", "chatType", "", "peerId", "nick", "ci", "Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment$b;", "callback", "Lh", "Wh", "bundle", "Xh", "Lcom/tencent/mobileqq/aio/utils/a;", "Kh", "Ih", "data", "Uh", "Zh", "Qh", "Ph", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "unit", "Yh", "Lcom/tencent/qqnt/chats/biz/miniaio/a;", "event", "Nh", "Lcom/tencent/qqnt/chats/biz/miniaio/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Vh", "Oh", "di", "Lw71/ac;", BdhLogUtil.LogTag.Tag_Conn, "Lw71/ac;", "mRootBinding", "D", "Landroid/view/ViewGroup;", "mMsgTabContainer", "E", "mChatAIOContainer", UserInfo.SEX_FEMALE, "mEmotionPanelContainer", "Lus/a;", "G", "Lus/a;", "mAIOProvider", "Lcom/tencent/qqnt/miniaio/c;", "H", "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/qqnt/miniaio/c;", "mMiniAIOEmoticonPanel", "I", "Ljava/lang/String;", "mCurPeerId", "J", "mChatType", "K", "mUin", "Lcom/tencent/qqnt/chats/biz/miniaio/b;", "L", "Lcom/tencent/qqnt/chats/biz/miniaio/b;", "mMiniMsgInterfaces", "Lkotlinx/coroutines/Job;", "M", "Lkotlinx/coroutines/Job;", "mChatListEventJob", "<init>", "()V", "N", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HorizontalMiniaioFragment extends QPublicBaseFragment implements com.tencent.qqnt.miniaio.d {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static boolean P;

    /* renamed from: C, reason: from kotlin metadata */
    private ac mRootBinding;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mMsgTabContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup mChatAIOContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewGroup mEmotionPanelContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private us.a mAIOProvider;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMiniAIOEmoticonPanel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String mCurPeerId;

    /* renamed from: J, reason: from kotlin metadata */
    private int mChatType;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String mUin;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.biz.miniaio.b mMiniMsgInterfaces;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Job mChatListEventJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment$a;", "", "", "isMiniAIOForeground", "Z", "a", "()Z", "setMiniAIOForeground", "(Z)V", "", "FRAGMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return HorizontalMiniaioFragment.P;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment$b;", "", "", "uin", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a(@NotNull String uin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/miniaio/HorizontalMiniaioFragment$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            ac acVar = HorizontalMiniaioFragment.this.mRootBinding;
            if (acVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                acVar = null;
            }
            FrameLayout frameLayout = acVar.f444722b;
            if (HorizontalMiniaioFragment.this.mCurPeerId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || e16.getX() <= frameLayout.getX() || e16.getX() >= frameLayout.getX() + frameLayout.getWidth() || e16.getY() <= frameLayout.getY() || e16.getY() >= frameLayout.getY() + frameLayout.getHeight()) {
                HorizontalMiniaioFragment.this.Oh();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/miniaio/HorizontalMiniaioFragment$d", "Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment$b;", "", "uin", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
            }
        }

        @Override // com.tencent.qqnt.miniaio.HorizontalMiniaioFragment.b
        public void a(@NotNull String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            HorizontalMiniaioFragment.this.mUin = uin;
            QLog.d("HorizontalMiniaioFragment", 1, "onEnterAioReport mUin=" + StringUtil.getSimpleUinForPrint(HorizontalMiniaioFragment.this.mUin));
            if (TextUtils.isEmpty(HorizontalMiniaioFragment.this.mUin)) {
                return;
            }
            com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
            ViewGroup viewGroup = HorizontalMiniaioFragment.this.mChatAIOContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
                viewGroup = null;
            }
            bVar.h(viewGroup, HorizontalMiniaioFragment.this.Kh());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/miniaio/HorizontalMiniaioFragment$e", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Bundle, Unit> f359468a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Bundle, Unit> function1) {
            this.f359468a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                this.f359468a.invoke(data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65726);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HorizontalMiniaioFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.miniaio.c>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$mMiniAIOEmoticonPanel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final c invoke() {
                    ViewGroup viewGroup;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IMiniaioApi iMiniaioApi = (IMiniaioApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMiniaioApi.class);
                    viewGroup = HorizontalMiniaioFragment.this.mEmotionPanelContainer;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEmotionPanelContainer");
                        viewGroup = null;
                    }
                    return iMiniaioApi.getEmoticonPanel(viewGroup, HorizontalMiniaioFragment.this);
                }
            });
            this.mMiniAIOEmoticonPanel = lazy;
            this.mCurPeerId = "";
            this.mUin = "";
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(Bundle bundle) {
        this.mCurPeerId = "";
        Xh(bundle);
        us.a aVar = this.mAIOProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
            aVar = null;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        aVar.j(childFragmentManager);
        Qh();
        com.tencent.qqnt.chats.biz.miniaio.b bVar = this.mMiniMsgInterfaces;
        if (bVar != null) {
            bVar.Hb(h.a.f354353a);
        }
    }

    private final com.tencent.qqnt.miniaio.c Jh() {
        return (com.tencent.qqnt.miniaio.c) this.mMiniAIOEmoticonPanel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.utils.a Kh() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("aio_type", Integer.valueOf(this.mChatType));
        hashMap.put("subtype_aio_pg", Integer.valueOf(this.mChatType));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, this.mUin);
        hashMap.put("source_aio_appear", "18");
        hashMap.put("current_mode", ((IAIOReport) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOReport.class)).currentMode());
        hashMap.put("aio_morphology", com.tencent.mobileqq.aio.utils.b.f194119a.b(false, true));
        if (this.mChatType != 2) {
            str = "";
        } else {
            str = this.mUin;
        }
        hashMap.put("group_id", str);
        hashMap.put("slide_num", "");
        return new com.tencent.mobileqq.aio.utils.a().d(1).e(PageUtils.VR_PAGE_NONE).c(hashMap);
    }

    private final void Lh(final String peerId, final b callback) {
        boolean z16;
        HashSet<String> hashSetOf;
        if (this.mChatType == 2) {
            callback.a(peerId);
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IK\u2026va, ProcessConstant.MAIN)");
        ag uixConvertService = ((IKernelService) runtimeService).getUixConvertService();
        Intrinsics.checkNotNull(uixConvertService, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IUixConvertService");
        String valueOf = String.valueOf(uixConvertService.z0(peerId));
        if (valueOf.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || Intrinsics.areEqual(valueOf, "null")) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(peerId);
            uixConvertService.getUin(hashSetOf, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.miniaio.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    HorizontalMiniaioFragment.Mh(HorizontalMiniaioFragment.b.this, peerId, hashMap);
                }
            });
        } else {
            callback.a(valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(b callback, String peerId, HashMap hashMap) {
        Long l3;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        if (hashMap != null) {
            l3 = (Long) hashMap.get(peerId);
        } else {
            l3 = null;
        }
        callback.a(String.valueOf(l3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(com.tencent.qqnt.chats.biz.miniaio.a event) {
        if (event instanceof h.b) {
            Vh(((h.b) event).a());
        } else if (event instanceof h.c) {
            Oh();
        } else if (event instanceof h.d) {
            di();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh() {
        com.tencent.qqnt.chats.biz.miniaio.b bVar = this.mMiniMsgInterfaces;
        if (bVar != null) {
            bVar.Hb(h.a.f354353a);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((IMiniaioApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMiniaioApi.class)).handleHorizontalMiniaioFinish();
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(Bundle data) {
        CharSequence charSequence = data.getCharSequence("key_input_content");
        if (charSequence != null) {
            Jh().a(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        ViewGroup viewGroup = this.mEmotionPanelContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmotionPanelContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
    }

    private final void Rh() {
        final GestureDetector gestureDetector = new GestureDetector(getActivity(), new c());
        ac acVar = this.mRootBinding;
        if (acVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
            acVar = null;
        }
        ConstraintLayout root = acVar.getRoot();
        if (root != null) {
            root.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqnt.miniaio.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Sh;
                    Sh = HorizontalMiniaioFragment.Sh(gestureDetector, view, motionEvent);
                    return Sh;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Sh(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gestureDetector, "$gestureDetector");
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void Th(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setBackgroundColor(Integer.MIN_VALUE);
        window.addFlags(1280);
        window.getDecorView().setSystemUiVisibility(2054);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.setSoftInputMode(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(Bundle data) {
        Boolean bool;
        Boolean bool2;
        Intent intent;
        Intent intent2;
        int i3 = data.getInt("key_chat_type");
        String string = data.getString("key_peerId");
        String string2 = data.getString("key_chat_name");
        if (string2 == null) {
            string2 = "";
        }
        String str = string2;
        long j3 = data.getLong("key_peerUin", 0L);
        if (TextUtils.isEmpty(string)) {
            QLog.e("HorizontalMiniaioFragment", 1, "peerId is empty");
            return;
        }
        if (getActivity() == null) {
            QLog.e("HorizontalMiniaioFragment", 1, "activity is null");
            return;
        }
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            bool = Boolean.valueOf(intent2.getBooleanExtra("key_open_normal_aio_addnewtask", false));
        } else {
            bool = null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bool2 = Boolean.valueOf(intent.getBooleanExtra("key_open_normal_aio_close_mini_aio", false));
        } else {
            bool2 = null;
        }
        Boolean bool3 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool3)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_open_normal_aio_addnewtask", bool.booleanValue());
            bundle = bundle2;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        FragmentActivity activity3 = getActivity();
        Intrinsics.checkNotNull(activity3);
        Intrinsics.checkNotNull(string);
        iAIOStarterApi.navigateToAIO(activity3, i3, string, str, j3, bundle);
        if (Intrinsics.areEqual(bool2, bool3)) {
            QLog.i("HorizontalMiniaioFragment", 1, "jumpToNormalAIO openNormalAioCloseMiniAio = true");
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                activity4.finish();
            }
        }
    }

    private final void Vh(com.tencent.qqnt.chats.biz.miniaio.c item) {
        QLog.d("HorizontalMiniaioFragment", 1, "onClickItem");
        ci(item.b(), item.a(), item.c());
    }

    private final void Wh() {
        Lh(this.mCurPeerId, new d());
    }

    private final void Xh(Bundle bundle) {
        QLog.d("HorizontalMiniaioFragment", 1, "onExitAioReport mUin=" + StringUtil.getSimpleUinForPrint(this.mUin));
        if (TextUtils.isEmpty(this.mUin)) {
            return;
        }
        this.mUin = "";
        com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
        ViewGroup viewGroup = this.mChatAIOContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
            viewGroup = null;
        }
        bVar.d(viewGroup, bundle);
        ViewGroup viewGroup3 = this.mChatAIOContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        bVar.i(viewGroup2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(String code, Function1<? super Bundle, Unit> unit) {
        us.a aVar = this.mAIOProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
            aVar = null;
        }
        aVar.i(code, new e(unit));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
        View view = Jh().getView();
        ViewGroup viewGroup = null;
        if (view.getParent() == null) {
            ViewGroup viewGroup2 = this.mEmotionPanelContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmotionPanelContainer");
                viewGroup2 = null;
            }
            viewGroup2.addView(view);
        }
        ViewGroup viewGroup3 = this.mEmotionPanelContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmotionPanelContainer");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(0);
    }

    private final void bi() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        int intExtra = activity.getIntent().getIntExtra("key_chat_type", 0);
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        String stringExtra = activity2.getIntent().getStringExtra("key_peerId");
        FragmentActivity activity3 = getActivity();
        Intrinsics.checkNotNull(activity3);
        String stringExtra2 = activity3.getIntent().getStringExtra("key_chat_name");
        if (stringExtra != null && stringExtra2 != null) {
            ci(intExtra, stringExtra, stringExtra2);
        }
    }

    private final void ci(int chatType, String peerId, String nick) {
        if (this.mCurPeerId.equals(peerId)) {
            return;
        }
        Qh();
        Xh(new Bundle());
        this.mCurPeerId = peerId;
        this.mChatType = chatType;
        Wh();
        AIOSession aIOSession = new AIOSession(new AIOContact(chatType, peerId, "", nick));
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_shield_item_touch", true);
        bundle.putBoolean("key_is_miniaio", true);
        AIOUtil aIOUtil = AIOUtil.f194084a;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        bundle.putInt("key_msg_head_padding", aIOUtil.m(context, false, true));
        AIOParam.a i3 = new AIOParam.a().i(true);
        String name = MiniaioFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MiniaioFactory::class.java.name");
        AIOParam c16 = i3.e(name).a(bundle).h(aIOSession).c();
        com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewGroup viewGroup = this.mChatAIOContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
            viewGroup = null;
        }
        us.a c17 = bVar.c(c16, childFragmentManager, viewGroup.getId(), null);
        Drawable drawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.skin_panel_background);
        Intrinsics.checkNotNullExpressionValue(drawable, "sMobileQQ.resources.getD\u2026le.skin_panel_background)");
        c17.k(drawable);
        this.mAIOProvider = c17;
        c17.g().b(new e.a() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                }
            }

            @Override // ts.e.a
            public void attachViewTree() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                final HorizontalMiniaioFragment horizontalMiniaioFragment = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment.Yh("click_emoticon_icon", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            HorizontalMiniaioFragment.this.Zh();
                        }
                    }
                });
                final HorizontalMiniaioFragment horizontalMiniaioFragment2 = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment2.Yh("hide_emoticon_panel", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            HorizontalMiniaioFragment.this.Qh();
                        }
                    }
                });
                final HorizontalMiniaioFragment horizontalMiniaioFragment3 = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment3.Yh("input_changed", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$3
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            HorizontalMiniaioFragment.this.Ph(it);
                        }
                    }
                });
                final HorizontalMiniaioFragment horizontalMiniaioFragment4 = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment4.Yh("close_aio", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$4
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            HorizontalMiniaioFragment.this.Ih(it);
                        }
                    }
                });
                final HorizontalMiniaioFragment horizontalMiniaioFragment5 = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment5.Yh("jump_to_normal_aio", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$5
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            HorizontalMiniaioFragment.this.Uh(it);
                        }
                    }
                });
                final HorizontalMiniaioFragment horizontalMiniaioFragment6 = HorizontalMiniaioFragment.this;
                horizontalMiniaioFragment6.Yh("code_hide_external_panel", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.miniaio.HorizontalMiniaioFragment$startAIO$2$attachViewTree$6
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalMiniaioFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                        invoke2(bundle2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bundle it) {
                        us.a aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        aVar = HorizontalMiniaioFragment.this.mAIOProvider;
                        if (aVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
                            aVar = null;
                        }
                        aVar.a(MiniAIOInputEvent.UnselectEmoBtnEvent.f359479d);
                        HorizontalMiniaioFragment.this.Qh();
                    }
                });
            }
        });
        com.tencent.mobileqq.aio.utils.e eVar = com.tencent.mobileqq.aio.utils.e.f194142a;
        ViewGroup viewGroup3 = this.mChatAIOContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        eVar.g(viewGroup2);
    }

    private final void di() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((IMiniaioApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMiniaioApi.class)).toMainMsgList(activity);
        }
    }

    public final void ai() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        com.tencent.qqnt.chats.biz.miniaio.b createMiniMsgFragment = ((IMiniAIOAPI) QRoute.api(IMiniAIOAPI.class)).createMiniMsgFragment();
        ViewGroup viewGroup = null;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HorizontalMiniaioFragment$showMsgList$1$1(createMiniMsgFragment, this, null), 3, null);
        this.mChatListEventJob = launch$default;
        this.mMiniMsgInterfaces = createMiniMsgFragment;
        Intrinsics.checkNotNull(createMiniMsgFragment);
        Fragment fragment = createMiniMsgFragment.getFragment();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "this@HorizontalMiniaioFr\u2026ent.arguments ?: Bundle()");
        arguments.putBoolean("key_is_horizontal", true);
        arguments.putBoolean("key_need_header", false);
        fragment.setArguments(arguments);
        ViewGroup viewGroup2 = this.mMsgTabContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMsgTabContainer");
        } else {
            viewGroup = viewGroup2;
        }
        beginTransaction.add(viewGroup.getId(), fragment, MiniAioActivity.FRAGMENT_TAG);
        beginTransaction.show(fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.qqnt.miniaio.d
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        us.a aVar = this.mAIOProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
            aVar = null;
        }
        aVar.a(InputEditTextMsgIntent.BackspaceInEditText.f189406d);
    }

    @Override // com.tencent.qqnt.miniaio.d
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        us.a aVar = this.mAIOProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
            aVar = null;
        }
        aVar.a(AIOMsgSendEvent.InputSendEvent.f188428d);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && activity.getRequestedOrientation() != 11) {
            activity.setRequestedOrientation(11);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.miniaio.d
    public void oa(int emotionType, int code) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(emotionType), Integer.valueOf(code));
            return;
        }
        us.a aVar = this.mAIOProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
            aVar = null;
        }
        aVar.a(new InputEditTextMsgIntent.AddEmoticonToEditText(emotionType, code));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ac acVar = null;
            if (getActivity() == null) {
                QLog.e("HorizontalMiniaioFragment", 1, "onCreateView activity is null");
                root = null;
            } else {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                Th(activity);
                ac g16 = ac.g(inflater, container, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
                this.mRootBinding = g16;
                if (g16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                    g16 = null;
                }
                FrameLayout frameLayout = g16.f444724d;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mRootBinding.frameMsgTab");
                this.mMsgTabContainer = frameLayout;
                ac acVar2 = this.mRootBinding;
                if (acVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                    acVar2 = null;
                }
                FrameLayout frameLayout2 = acVar2.f444722b;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "mRootBinding.frameChatAio");
                this.mChatAIOContainer = frameLayout2;
                ac acVar3 = this.mRootBinding;
                if (acVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                    acVar3 = null;
                }
                FrameLayout frameLayout3 = acVar3.f444723c;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "mRootBinding.frameEmotionPanel");
                this.mEmotionPanelContainer = frameLayout3;
                Rh();
                bi();
                ai();
                ac acVar4 = this.mRootBinding;
                if (acVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootBinding");
                } else {
                    acVar = acVar4;
                }
                root = acVar.getRoot();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
        ViewGroup viewGroup = this.mChatAIOContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatAIOContainer");
            viewGroup = null;
        }
        bVar.i(viewGroup);
        Job job = this.mChatListEventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onStart();
            P = true;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            P = false;
        }
    }
}
