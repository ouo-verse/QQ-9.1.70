package com.tencent.mobileqq.aio.msglist.holder.component.tofu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.api.a;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.AIOTofuUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.util.ToFuUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.tofu.IBeancurdFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.TofuActionButton;
import com.tencent.qqnt.richui.api.IRichUIViewDelegateFactoryApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0001A\u0018\u0000 \u0088\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0089\u0001B\u0011\u0012\u0006\u00104\u001a\u00020/\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J.\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J&\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010J\u001a\u0004\u0018\u00010E8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001e\u0010P\u001a\u0004\u0018\u00010K8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001e\u0010U\u001a\u0004\u0018\u00010Q8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b:\u0010R\u001a\u0004\bS\u0010TR\u001e\u0010[\u001a\u0004\u0018\u00010V8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001e\u0010a\u001a\u0004\u0018\u00010\\8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001e\u0010g\u001a\u0004\u0018\u00010b8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001e\u0010m\u001a\u0004\u0018\u00010h8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001e\u0010s\u001a\u0004\u0018\u00010n8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u001e\u0010y\u001a\u0004\u0018\u00010t8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001e\u0010\u007f\u001a\u0004\u0018\u00010z8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R$\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0080\u00018B@\u0002X\u0082\u000e\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/AIOTofuContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ah;", "tofuMsgItem", "", "g2", "N1", "", "statementWidth", "", "bottomMargin", "L1", "f2", "Landroid/widget/LinearLayout;", TtmlNode.TAG_LAYOUT, ICustomDataEditor.STRING_ARRAY_PARAM_2, "msgItem", "", "", "payloads", "", "c2", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "tofuActCntView", ViewStickEventHelper.IS_SHOW, "d2", "Landroid/view/ViewGroup;", "blurView", "Landroid/view/View;", "maskView", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "videoRoundLayout", SemanticAttributes.DbSystemValues.H2, "e2", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "mTofuActCntView", "", "D", "J", "mClickTime", "E", "Landroid/widget/LinearLayout;", "mCntContainer", UserInfo.SEX_FEMALE, "mStatementLayout", "com/tencent/mobileqq/aio/msglist/holder/component/tofu/AIOTofuContentComponent$b", "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/AIOTofuContentComponent$b;", "mClickListener", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/b;", "H", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/b;", "Q1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/b;", "mImageBeancurdView", "Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory$a;", "I", "Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory$a;", "P1", "()Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory$a;", "mDressShowBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/h;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/h;", "V1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/h;", "mSystemNoticeBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/k;", "K", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/k;", "Y1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/k;", "mWithBgTextBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i;", "L", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i;", "W1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i;", "mTextBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/g;", "M", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/g;", "U1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/g;", "mOnlineStatusBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/f;", "N", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/f;", "T1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/f;", "mOnlineStatusBeancurdNormalView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/j;", "P", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/j;", "X1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/j;", "mVideoBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/d;", "R1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/d;", "mMiniCardBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/e;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/e;", "S1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/e;", "mMultiImageBeancurdView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/l;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/l;", "Z1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/l;", "mZPlanAvatarBeancurdView", "<init>", "(Landroid/content/Context;)V", "T", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTofuContentComponent extends BaseContentComponent<ah> {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a mTofuActCntView;

    /* renamed from: D, reason: from kotlin metadata */
    private long mClickTime;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mCntContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mStatementLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mClickListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b mImageBeancurdView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private IBeancurdFactory.a mDressShowBeancurdView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h mSystemNoticeBeancurdView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k mWithBgTextBeancurdView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i mTextBeancurdView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g mOnlineStatusBeancurdView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f mOnlineStatusBeancurdNormalView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j mVideoBeancurdView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d mMiniCardBeancurdView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e mMultiImageBeancurdView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l mZPlanAvatarBeancurdView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/AIOTofuContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.AIOTofuContentComponent$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/AIOTofuContentComponent$b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements a.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTofuContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a.b
        public void a(@NotNull ah message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Intrinsics.checkNotNullParameter(message, "message");
            AIOTofuContentComponent aIOTofuContentComponent = AIOTofuContentComponent.this;
            if (aIOTofuContentComponent.e2(aIOTofuContentComponent.mTofuActCntView)) {
                QLog.i("AIOTofuContentComponent", 1, "tofu show blur view, click invalid");
                return;
            }
            a.C7238a c7238a = a.C7238a.f188177d;
            AIOTofuContentComponent.this.sendIntent(c7238a);
            ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).clickTofu(AIOTofuContentComponent.this.getContext(), c7238a.a(), message);
            HashMap hashMap = new HashMap();
            String m26 = AIOTofuContentComponent.I1(AIOTofuContentComponent.this).m2();
            String str = "";
            if (m26 == null) {
                m26 = "";
            }
            hashMap.put("curd_block_id", m26);
            hashMap.put("curd_block_business_type", String.valueOf(AIOTofuContentComponent.I1(AIOTofuContentComponent.this).n2()));
            hashMap.put("curd_block_style", Integer.valueOf(AIOTofuContentComponent.I1(AIOTofuContentComponent.this).k2()));
            String l26 = AIOTofuContentComponent.I1(AIOTofuContentComponent.this).l2();
            if (l26 != null) {
                str = l26;
            }
            hashMap.put("service_custom_field", str);
            hashMap.put("tofu_block_trigger_type", String.valueOf(AIOTofuContentComponent.I1(AIOTofuContentComponent.this).q2().b()));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_bean_curd_cubes", hashMap);
            if (AIOTofuContentComponent.I1(AIOTofuContentComponent.this).k2() == 6) {
                com.tencent.mobileqq.aio.utils.b.l("em_bas_personal_profile", hashMap);
            }
            AIOTofuContentComponent.this.C1();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOTofuContentComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.mCntContainer = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setVisibility(8);
        linearLayout2.setOrientation(0);
        this.mStatementLayout = linearLayout2;
        this.mClickListener = new b();
    }

    public static final /* synthetic */ ah I1(AIOTofuContentComponent aIOTofuContentComponent) {
        return aIOTofuContentComponent.q1();
    }

    private final void L1(final ah tofuMsgItem, float statementWidth, int bottomMargin) {
        int revertSize2Normal;
        LinearLayout.LayoutParams layoutParams;
        ToFuUtil toFuUtil = ToFuUtil.f192136a;
        if (!toFuUtil.g()) {
            QLog.i("AIOTofuContentComponent", 1, "not expC");
            return;
        }
        List<TofuActionButton> u26 = tofuMsgItem.u2();
        if (u26.isEmpty()) {
            f2();
            QLog.i("AIOTofuContentComponent", 1, "statementList.isEmpty()");
            return;
        }
        ArrayList<LinearLayout> a16 = toFuUtil.a(getMContext(), u26);
        if (a16.isEmpty()) {
            f2();
            QLog.i("AIOTofuContentComponent", 1, "viewList.isEmpty()");
            return;
        }
        if (this.mStatementLayout.getChildCount() != 0 && this.mStatementLayout.getVisibility() == 0) {
            return;
        }
        for (final LinearLayout linearLayout : a16) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIOTofuContentComponent.M1(AIOTofuContentComponent.this, linearLayout, tofuMsgItem, view);
                }
            });
        }
        int size = a16.size();
        LinearLayout linearLayout2 = this.mStatementLayout;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.width = (int) statementWidth;
        linearLayout2.setLayoutParams(layoutParams2);
        this.mStatementLayout.setPadding(0, ViewUtils.dip2px(10.0f) - bottomMargin, 0, 0);
        if (size == 1) {
            this.mStatementLayout.addView(a16.get(0));
        } else {
            if (!FontSettingManager.isFontSizeLarge()) {
                revertSize2Normal = ViewUtils.dpToPx(12.0f);
            } else {
                revertSize2Normal = (int) FontSettingManager.revertSize2Normal(getMContext(), ViewUtils.dpToPx(12.0f));
            }
            float f16 = (statementWidth - (revertSize2Normal * 2)) / 3;
            for (int i3 = 0; i3 < size; i3++) {
                ViewGroup.LayoutParams layoutParams3 = a16.get(i3).getLayoutParams();
                if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams3;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.width = (int) f16;
                    if (i3 < size - 1) {
                        layoutParams.rightMargin = revertSize2Normal;
                    }
                }
                this.mStatementLayout.addView(a16.get(i3));
            }
        }
        this.mStatementLayout.setVisibility(0);
        if (this.mCntContainer.indexOfChild(this.mStatementLayout) == -1 && !Intrinsics.areEqual(this.mStatementLayout.getParent(), this.mCntContainer)) {
            this.mCntContainer.addView(this.mStatementLayout);
        }
        QLog.i("AIOTofuContentComponent", 1, "bindStatementView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(AIOTofuContentComponent this$0, LinearLayout layout, ah tofuMsgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layout, "$layout");
        Intrinsics.checkNotNullParameter(tofuMsgItem, "$tofuMsgItem");
        this$0.a2(layout, tofuMsgItem);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N1(final ah tofuMsgItem) {
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a W1;
        float f16;
        View k3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup viewGroup;
        Integer num;
        QLog.i("AIOTofuContentComponent", 1, "createTofuView");
        int i3 = 0;
        ViewGroup.LayoutParams layoutParams = null;
        try {
            com.tencent.android.androidbypass.richui.viewdata.k s26 = tofuMsgItem.s2();
            if (s26 != null) {
                this.mCntContainer.removeAllViews();
                f2();
                View i16 = com.tencent.android.androidbypass.richui.viewdata.k.i(s26, this.context, ((IRichUIViewDelegateFactoryApi) QRoute.api(IRichUIViewDelegateFactoryApi.class)).getViewFactory(), null, 4, null);
                com.tencent.mobileqq.aio.utils.e eVar = com.tencent.mobileqq.aio.utils.e.f194142a;
                int f17 = (int) (eVar.f() * 0.14f);
                ViewGroup.LayoutParams layoutParams2 = i16.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.leftMargin = f17;
                    marginLayoutParams.rightMargin = f17;
                }
                i16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AIOTofuContentComponent.O1(AIOTofuContentComponent.this, tofuMsgItem, view);
                    }
                });
                this.mCntContainer.addView(i16);
                L1(tofuMsgItem, eVar.f() * 0.72f, 0);
                if (i16 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) i16;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    num = Integer.valueOf(viewGroup.getChildCount());
                } else {
                    num = null;
                }
                QLog.i("AIOTofuContentComponent", 1, "[createTofuView]: use mixUI viewNumber " + num);
                return;
            }
        } catch (Exception e16) {
            QLog.e("AIOTofuContentComponent", 1, "[createTofuView]", e16);
        }
        if (ToFuUtil.f192136a.b()) {
            g2(tofuMsgItem);
        }
        switch (tofuMsgItem.k2()) {
            case 1:
                this.mTofuActCntView = Q1();
                break;
            case 2:
                if (tofuMsgItem.n2() == 1) {
                    W1 = Y1();
                } else {
                    W1 = W1();
                }
                this.mTofuActCntView = W1;
                break;
            case 3:
                this.mTofuActCntView = V1();
                break;
            case 4:
                this.mTofuActCntView = U1();
                break;
            case 5:
                this.mTofuActCntView = X1();
                break;
            case 6:
                this.mTofuActCntView = R1();
                break;
            case 7:
                this.mTofuActCntView = S1();
                break;
            case 8:
                IBeancurdFactory.a P1 = P1();
                Intrinsics.checkNotNull(P1, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.BeancurdView");
                this.mTofuActCntView = (com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a) P1;
                break;
            case 9:
                this.mTofuActCntView = T1();
                break;
            case 10:
                this.mTofuActCntView = Z1();
                break;
            default:
                QLog.d("AIOTofuContentComponent", 1, "createTofuView error:" + tofuMsgItem.k2());
                break;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar = this.mTofuActCntView;
        if (aVar != null) {
            aVar.B(tofuMsgItem);
        }
        d2(this.mTofuActCntView, tofuMsgItem.y2());
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar2 = this.mTofuActCntView;
        if (aVar2 != null) {
            f16 = aVar2.m();
        } else {
            f16 = 0.72f * com.tencent.mobileqq.aio.utils.e.f194142a.f();
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar3 = this.mTofuActCntView;
        if (aVar3 != null && (k3 = aVar3.k()) != null) {
            ViewGroup.LayoutParams layoutParams3 = k3.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams3;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams2 != null) {
                i3 = marginLayoutParams2.bottomMargin;
            }
        }
        L1(tofuMsgItem, f16, i3);
        QLog.i("AIOTofuContentComponent", 1, "[createTofuView]: use normal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(AIOTofuContentComponent this$0, ah tofuMsgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tofuMsgItem, "$tofuMsgItem");
        this$0.mClickListener.a(tofuMsgItem);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final IBeancurdFactory.a P1() {
        if (this.mDressShowBeancurdView == null) {
            IBeancurdFactory.a dressShowBeancurdView = ((IBeancurdFactory) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IBeancurdFactory.class)).getDressShowBeancurdView(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add IBeancurdFactory.IBeancurdView");
            if (dressShowBeancurdView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a) {
                com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar = (com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a) dressShowBeancurdView;
                this.mCntContainer.addView(aVar.c());
                aVar.v(this.mClickListener);
            }
            this.mDressShowBeancurdView = dressShowBeancurdView;
        }
        return this.mDressShowBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b Q1() {
        if (this.mImageBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b bVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add ImageBeancurdView");
            this.mCntContainer.addView(bVar.c());
            bVar.v(this.mClickListener);
            this.mImageBeancurdView = bVar;
        }
        return this.mImageBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d R1() {
        if (this.mMiniCardBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d dVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add MiniCardBeancurdView");
            this.mCntContainer.addView(dVar.c(), -1, -2);
            dVar.v(this.mClickListener);
            this.mMiniCardBeancurdView = dVar;
        }
        return this.mMiniCardBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e S1() {
        if (this.mMultiImageBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e eVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add MultiImageBeancurdView");
            this.mCntContainer.addView(eVar.c());
            eVar.v(this.mClickListener);
            this.mMultiImageBeancurdView = eVar;
        }
        return this.mMultiImageBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f T1() {
        if (this.mOnlineStatusBeancurdNormalView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f fVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add OnlineStatusBeancurdNormalView");
            this.mCntContainer.addView(fVar.c(), -1, -2);
            fVar.v(this.mClickListener);
            this.mOnlineStatusBeancurdNormalView = fVar;
        }
        return this.mOnlineStatusBeancurdNormalView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g U1() {
        if (this.mOnlineStatusBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g gVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add OnlineStatusBeancurdView");
            this.mCntContainer.addView(gVar.c(), -1, -2);
            gVar.v(this.mClickListener);
            this.mOnlineStatusBeancurdView = gVar;
        }
        return this.mOnlineStatusBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h V1() {
        if (this.mSystemNoticeBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h hVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add SystemNoticeBeancurdView");
            this.mCntContainer.addView(hVar.c());
            hVar.v(this.mClickListener);
            this.mSystemNoticeBeancurdView = hVar;
        }
        return this.mSystemNoticeBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i W1() {
        if (this.mTextBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i iVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add TextBeancurdView");
            this.mCntContainer.addView(iVar.c());
            iVar.v(this.mClickListener);
            this.mTextBeancurdView = iVar;
        }
        return this.mTextBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j X1() {
        if (this.mVideoBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j jVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add VideoBeancurdView");
            this.mCntContainer.addView(jVar.c());
            jVar.v(this.mClickListener);
            this.mVideoBeancurdView = jVar;
        }
        return this.mVideoBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k Y1() {
        if (this.mWithBgTextBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k kVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add WithBgTextBeancurdView");
            this.mCntContainer.addView(kVar.c());
            kVar.v(this.mClickListener);
            this.mWithBgTextBeancurdView = kVar;
        }
        return this.mWithBgTextBeancurdView;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l Z1() {
        if (this.mZPlanAvatarBeancurdView == null) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l lVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l(this.context);
            QLog.i("AIOTofuContentComponent", 1, "add ZPlanAvatarBeancurdView");
            this.mCntContainer.addView(lVar.c(), -1, -2);
            lVar.v(this.mClickListener);
            this.mZPlanAvatarBeancurdView = lVar;
        }
        return this.mZPlanAvatarBeancurdView;
    }

    private final void a2(LinearLayout layout, ah tofuMsgItem) {
        TofuActionButton tofuActionButton;
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(getMContext(), 1, getMContext().getString(R.string.f197454k2), 0).show();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mClickTime < 1000) {
            return;
        }
        this.mClickTime = currentTimeMillis;
        Object tag = layout.getTag();
        if (tag instanceof TofuActionButton) {
            tofuActionButton = (TofuActionButton) tag;
        } else {
            tofuActionButton = null;
        }
        if (tofuActionButton != null) {
            HashMap hashMap = new HashMap();
            String m26 = tofuMsgItem.m2();
            String str = "";
            if (m26 == null) {
                m26 = "";
            }
            hashMap.put("curd_block_id", m26);
            hashMap.put("curd_block_business_type", String.valueOf(tofuMsgItem.n2()));
            hashMap.put("curd_block_style", Integer.valueOf(tofuMsgItem.k2()));
            String l26 = tofuMsgItem.l2();
            if (l26 != null) {
                str = l26;
            }
            hashMap.put("service_custom_field", str);
            hashMap.put("tofu_block_trigger_type", String.valueOf(tofuMsgItem.q2().b()));
            String str2 = tofuActionButton.text;
            Intrinsics.checkNotNullExpressionValue(str2, "tofuActionButton.text");
            hashMap.put("nearby_text", str2);
            this.mStatementLayout.setVisibility(8);
            sendIntent(new a.b(tofuMsgItem.getMsgId(), tofuActionButton));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_oiperating_area", hashMap);
            QLog.i("AIOTofuContentComponent", 1, "click statement text " + tofuActionButton.text + " time " + this.mClickTime);
        }
    }

    private final boolean c2(ah msgItem, List<Object> payloads) {
        float f16;
        View k3;
        if (payloads.isEmpty()) {
            return true;
        }
        Iterator<Object> it = payloads.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                return false;
            }
            Object next = it.next();
            if (next instanceof HashMap) {
                Map map = (Map) next;
                Object obj = map.get(AIOMsgItemPayloadType.AUTHENTICATION_PAYLOAD);
                if (obj != null && (obj instanceof a.e)) {
                    d2(this.mTofuActCntView, msgItem.y2());
                }
                if (map.get(AIOMsgItemPayloadType.SCREEN_SIZE_CHANGE) != null) {
                    g2(msgItem);
                    N1(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.TOFU_ACTION_BUTTON_PAYLOAD) != null) {
                    com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar = this.mTofuActCntView;
                    if (aVar != null) {
                        f16 = aVar.m();
                    } else {
                        f16 = com.tencent.mobileqq.aio.utils.e.f194142a.f() * 0.72f;
                    }
                    com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar2 = this.mTofuActCntView;
                    if (aVar2 != null && (k3 = aVar2.k()) != null) {
                        ViewGroup.LayoutParams layoutParams = k3.getLayoutParams();
                        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (marginLayoutParams != null) {
                            i3 = marginLayoutParams.bottomMargin;
                        }
                    }
                    L1(msgItem, f16, i3);
                }
            }
        }
    }

    private final void d2(com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a tofuActCntView, boolean isShow) {
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRevealEnable()) {
            QLog.i("AIOTofuContentComponent", 1, "handleShowBlurView  isRevealEnable close");
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        QLog.i("AIOTofuContentComponent", 1, "handleShowBlurView   | tofuActCntView = " + tofuActCntView + " | sdk_version = " + i3);
        if (tofuActCntView != null && !(tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g) && !(tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d)) {
            ViewGroup viewGroup = (ViewGroup) tofuActCntView.k().findViewById(R.id.t98);
            View findViewById = tofuActCntView.k().findViewById(R.id.v8a);
            RoundFrameLayout roundFrameLayout = (RoundFrameLayout) tofuActCntView.k().findViewById(R.id.ibc);
            if (!isShow) {
                if (i3 >= 31) {
                    if (viewGroup != null) {
                        viewGroup.setRenderEffect(null);
                    }
                    if ((tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j) && roundFrameLayout != null) {
                        roundFrameLayout.setRadius(0);
                    }
                }
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    return;
                }
                return;
            }
            if (findViewById == null) {
                findViewById = View.inflate(this.context, R.layout.hc9, null);
                if (tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j) {
                    if (roundFrameLayout != null) {
                        roundFrameLayout.addView(findViewById);
                    }
                } else if (tofuActCntView.k() instanceof ViewGroup) {
                    View k3 = tofuActCntView.k();
                    Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) k3).addView(findViewById);
                }
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            h2(viewGroup, findViewById, tofuActCntView, roundFrameLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e2(com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a tofuActCntView) {
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRevealEnable()) {
            QLog.i("AIOTofuContentComponent", 1, "handleShowBlurView  isRevealEnable close");
            return false;
        }
        QLog.i("AIOTofuContentComponent", 1, "handleShowBlurView , tofuActCntView = " + tofuActCntView);
        if (tofuActCntView == null) {
            return false;
        }
        View findViewById = tofuActCntView.k().findViewById(R.id.v8a);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private final void f2() {
        this.mStatementLayout.removeAllViews();
        this.mStatementLayout.setVisibility(8);
    }

    private final void g2(ah tofuMsgItem) {
        QLog.i("AIOTofuContentComponent", 1, "resetTofu");
        this.mCntContainer.removeAllViews();
        f2();
        switch (tofuMsgItem.k2()) {
            case 1:
                this.mImageBeancurdView = null;
                return;
            case 2:
                this.mWithBgTextBeancurdView = null;
                this.mTextBeancurdView = null;
                return;
            case 3:
                this.mSystemNoticeBeancurdView = null;
                return;
            case 4:
                this.mOnlineStatusBeancurdView = null;
                return;
            case 5:
                this.mVideoBeancurdView = null;
                return;
            case 6:
                this.mMiniCardBeancurdView = null;
                return;
            case 7:
                this.mMultiImageBeancurdView = null;
                return;
            case 8:
                this.mDressShowBeancurdView = null;
                return;
            case 9:
                this.mOnlineStatusBeancurdNormalView = null;
                return;
            case 10:
                this.mZPlanAvatarBeancurdView = null;
                return;
            default:
                QLog.d("AIOTofuContentComponent", 1, "resetTofu error:" + tofuMsgItem.k2());
                return;
        }
    }

    private final void h2(ViewGroup blurView, View maskView, com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a tofuActCntView, RoundFrameLayout videoRoundLayout) {
        int i3;
        RenderEffect createBlurEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            if (tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j) {
                if (videoRoundLayout != null) {
                    videoRoundLayout.setRadius(ViewUtils.dpToPx(7.0f));
                }
                if (maskView != null) {
                    maskView.setBackground(tofuActCntView.k().getResources().getDrawable(R.drawable.kp_));
                }
            } else if (maskView != null) {
                maskView.setBackground(tofuActCntView.k().getResources().getDrawable(R.drawable.kp9));
            }
            if (blurView != null) {
                createBlurEffect = RenderEffect.createBlurEffect(100.0f, 100.0f, Shader.TileMode.CLAMP);
                blurView.setRenderEffect(createBlurEffect);
                return;
            }
            return;
        }
        if (maskView != null) {
            Resources resources = tofuActCntView.k().getResources();
            if (tofuActCntView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j) {
                i3 = R.drawable.kpb;
            } else {
                i3 = R.drawable.kpa;
            }
            maskView.setBackground(resources.getDrawable(i3));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        try {
            QLog.i("AIOTofuContentComponent", 1, "bind, AIOTofuContentComponent= " + hashCode() + " + msgId " + msgItem.getMsgId());
            super.b1(position, msgItem, payloads);
            if (!c2(q1(), payloads)) {
                return;
            }
            if (!q1().w2()) {
                q1().B2(true);
                HashMap hashMap = new HashMap();
                String m26 = q1().m2();
                String str = "";
                if (m26 == null) {
                    m26 = "";
                }
                hashMap.put("curd_block_id", m26);
                hashMap.put("curd_block_business_type", String.valueOf(q1().n2()));
                hashMap.put("curd_block_style", Integer.valueOf(q1().k2()));
                String l26 = q1().l2();
                if (l26 != null) {
                    str = l26;
                }
                hashMap.put("service_custom_field", str);
                hashMap.put("tofu_block_trigger_type", String.valueOf(q1().q2().b()));
                com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_bean_curd_cubes", hashMap);
                List<TofuActionButton> u26 = q1().u2();
                if (ToFuUtil.f192136a.g() && (!u26.isEmpty())) {
                    Iterator<T> it = u26.iterator();
                    while (it.hasNext()) {
                        String str2 = ((TofuActionButton) it.next()).text;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.text");
                        hashMap.put("nearby_text", str2);
                        com.tencent.mobileqq.aio.utils.b.q("em_bas_oiperating_area", hashMap);
                    }
                }
                if (q1().k2() == 6) {
                    com.tencent.mobileqq.aio.utils.b.q("em_bas_personal_profile", hashMap);
                }
            }
            N1(q1());
            if (q1().x2()) {
                QLog.i("AIOTofuContentComponent", 1, "trigger to authority tofu=" + q1());
                String m27 = q1().m2();
                if (m27 != null) {
                    sendIntent(new a.c(q1().p0(), q1().r0(), q1().getMsgId(), q1().n2(), m27));
                }
            }
        } catch (Exception e16) {
            QLog.i("AIOTofuContentComponent", 1, "bind tofu exception: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mCntContainer;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof AIOTofuUIState.ThemeChange) {
            g2(q1());
            N1(q1());
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

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        Integer num;
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l Z1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ah D1 = D1();
        if (D1 != null) {
            D1.B2(false);
        }
        ah D12 = D1();
        if (D12 != null) {
            num = Integer.valueOf(D12.k2());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 4) {
            com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g U1 = U1();
            if (U1 != null) {
                U1.C();
            }
        } else if (num != null && num.intValue() == 10 && (Z1 = Z1()) != null) {
            Z1.C();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
