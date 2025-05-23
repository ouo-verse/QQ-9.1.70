package com.tencent.mobileqq.aio.msglist.holder.component.pic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.w;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.aio.utils.ai;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.menu.ac;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.ah;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.j;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.o;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.widget.VideoProgressView;
import com.tencent.qqnt.doutu.DuiButtonImageView;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import defpackage.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001fB\u000f\u0012\u0006\u0010A\u001a\u00020>\u00a2\u0006\u0004\bc\u0010dJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\nH\u0002J\u0018\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0002J\u001e\u00100\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\n2\u0006\u00104\u001a\u00020*H\u0002J\b\u00106\u001a\u00020\nH\u0002J\u001c\u00109\u001a\u00020\n*\u0012\u0012\u0004\u0012\u00020\u001107j\b\u0012\u0004\u0012\u00020\u0011`8H\u0002J$\u0010=\u001a\u001e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b0:j\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b`<H\u0002R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010C\u001a\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/pic/AIOPicContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/PicMsgItem;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/pic/f;", "V1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "e1", "importance", "l1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/RelativeLayout;", "T1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f;", "U1", "d2", "c2", "Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$FailReason;", "failReason", "i2", "j2", "l2", "k2", "", SemanticAttributes.DbSystemValues.H2, "curMsgItem", "m2", "g2", "success", "f2", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "transferInfo", "q2", "Lcom/tencent/mobileqq/aio/msglist/payload/a$ay;", "sendStatusPayload", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "Lcom/tencent/mobileqq/aio/msglist/payload/a$aw;", "payload", ICustomDataEditor.NUMBER_PARAM_2, "info", "e2", "Q1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "S1", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "X1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "W1", "()Landroid/widget/RelativeLayout;", "contentView", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f;", "progressViewController", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "errorInfoContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "errorIconView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "errorPromptTextView", "Lcom/tencent/mobileqq/aio/utils/StopWatch;", "H", "Lcom/tencent/mobileqq/aio/utils/StopWatch;", "stopWatch", "Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "I", "Y1", "()Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "picView", "Lcom/tencent/qqnt/doutu/DuiButtonImageView;", "J", "Lcom/tencent/qqnt/doutu/DuiButtonImageView;", "rightDuiView", "<init>", "(Landroid/content/Context;)V", "K", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPicContentComponent extends BaseContentComponent<PicMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.video.f progressViewController;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LinearLayout errorInfoContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView errorIconView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView errorPromptTextView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final StopWatch stopWatch;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy picView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private DuiButtonImageView rightDuiView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/pic/AIOPicContentComponent$a;", "", "", "BUBBLE_MARGIN", UserInfo.SEX_FEMALE, "BUBBLE_ROUND", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.pic.AIOPicContentComponent$a, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191409a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62738);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PicContentViewUtil.FailReason.values().length];
            try {
                iArr[PicContentViewUtil.FailReason.Expired.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PicContentViewUtil.FailReason.Security.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f191409a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOPicContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.AIOPicContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                T1 = AIOPicContentComponent.this.T1();
                return T1;
            }
        });
        this.contentView = lazy;
        this.stopWatch = new StopWatch("AIOBind.AIOPicContentComponent", QLog.isDevelopLevel());
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RoundBubbleImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.AIOPicContentComponent$picView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundBubbleImageView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RoundBubbleImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOPicContentComponent.this.context;
                RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context2);
                roundBubbleImageView.setId(R.id.sjj);
                roundBubbleImageView.setAdjustViewBounds(true);
                roundBubbleImageView.setRadiusDP(10.0f);
                roundBubbleImageView.setContentDescription(HardCodeUtil.qqStr(R.string.yp6));
                return roundBubbleImageView;
            }
        });
        this.picView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(AIOPicContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(AIOPicContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1();
    }

    private final void Q1() {
        boolean z16;
        if (q1().getMsgRecord().sendStatus != 0 && !com.tencent.mobileqq.aio.utils.d.H(q1()) && !q1().isSelf() && q1().F0() && DuiButtonImageView.f355986m) {
            boolean z17 = true;
            if (this.rightDuiView == null) {
                DuiButtonImageView duiButtonImageView = new DuiButtonImageView(getMContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(50.0f), ViewUtils.dip2px(50.0f));
                layoutParams.addRule(1, R.id.sjj);
                layoutParams.addRule(8, R.id.sjj);
                layoutParams.setMargins(0, 0, 0, -ViewUtils.dip2px(6.5f));
                W1().addView(duiButtonImageView, layoutParams);
                this.rightDuiView = duiButtonImageView;
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOPicContentComponent", 4, "message.hasPlayedDui = ", Boolean.valueOf(q1().G()));
            }
            DuiButtonImageView duiButtonImageView2 = this.rightDuiView;
            if (duiButtonImageView2 != null) {
                duiButtonImageView2.setMsg(q1());
                duiButtonImageView2.m();
                duiButtonImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AIOPicContentComponent.R1(AIOPicContentComponent.this, view);
                    }
                });
                duiButtonImageView2.setVisibility(0);
            }
            if (!z16) {
                DuiButtonImageView duiButtonImageView3 = this.rightDuiView;
                Intrinsics.checkNotNull(duiButtonImageView3);
                if (duiButtonImageView3.getVisibility() == 0) {
                    z17 = false;
                }
            }
            if (z17) {
                com.tencent.mobileqq.aio.utils.b.q("em_bas_battle_chart", X1());
                ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B547", "0X800B547", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        DuiButtonImageView duiButtonImageView4 = this.rightDuiView;
        if (duiButtonImageView4 != null) {
            duiButtonImageView4.setVisibility(8);
            duiButtonImageView4.n();
            duiButtonImageView4.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(AIOPicContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(d.as.f192321d);
        this$0.C1();
        com.tencent.mobileqq.aio.utils.b.l("em_bas_battle_chart", this$0.X1());
        ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B548", "0X800B548", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S1(ArrayList<com.tencent.qqnt.aio.menu.ui.d> arrayList) {
        ArrayList<PicSize> arrayListOf;
        if (!MsgExtKt.d(q1().p2())) {
            return;
        }
        PicMsgItem q16 = q1();
        long j3 = q1().o2().elementId;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(PicSize.PIC_DOWNLOAD_ORI, PicSize.PIC_DOWNLOAD_THUMB);
        Pair<PicSize, String> j26 = q16.j2(j3, arrayListOf);
        if (j26 != null && !TextUtils.isEmpty(j26.getSecond())) {
            QLog.i("AIOPicContentComponent", 1, "considerAddSaveToLocalMenuItem  first:" + j26.getFirst() + " second:" + ((Object) j26.getSecond()));
            arrayList.add(new ah(getMContext(), q1(), new File(j26.getSecond())));
            return;
        }
        QLog.i("AIOPicContentComponent", 1, "getMenuItemList canBeSavedEmo but path is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout T1() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        RoundBubbleImageView Y1 = Y1();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dip2px(8.0f);
        layoutParams.topMargin = ViewUtils.dip2px(8.0f);
        layoutParams.rightMargin = ViewUtils.dip2px(8.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(8.0f);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(Y1, layoutParams);
        return relativeLayout;
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.video.f U1() {
        VideoProgressView videoProgressView = new VideoProgressView(this.context);
        videoProgressView.setCustomSize(1);
        videoProgressView.setShowCorner(false);
        videoProgressView.setRadius(10.0f, true);
        RelativeLayout W1 = W1();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(5, Y1().getId());
        layoutParams.addRule(6, Y1().getId());
        layoutParams.addRule(7, Y1().getId());
        layoutParams.addRule(8, Y1().getId());
        Unit unit = Unit.INSTANCE;
        W1.addView(videoProgressView, layoutParams);
        return new com.tencent.mobileqq.aio.msglist.holder.component.video.f(videoProgressView);
    }

    private final RelativeLayout W1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final HashMap<String, Object> X1() {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        EmojiMall emojiMall = q1().p2().emojiMall;
        if (emojiMall != null) {
            obj = Integer.valueOf(emojiMall.emojiId);
        } else {
            obj = "0";
        }
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, obj);
        return hashMap;
    }

    private final RoundBubbleImageView Y1() {
        return (RoundBubbleImageView) this.picView.getValue();
    }

    private final boolean Z1(com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.PicMsgItem");
        E1((PicMsgItem) msgItem);
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj2 != null) {
                    a2((a.ay) obj2);
                    this.stopWatch.e("handle send status payload");
                }
                Object obj3 = map.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj3 != null) {
                    n2((a.aw) obj3);
                    this.stopWatch.e("handle rich media payload");
                }
                if (map.get(AIOMsgItemPayloadType.DOUTU_STATUS_PAYLOAD) != null) {
                    Q1();
                    this.stopWatch.e("handle dui view");
                }
                if (map.get(AIOMsgItemPayloadType.DOU_TU_PAYLOAD) != null) {
                    Q1();
                }
            }
        }
        return false;
    }

    private final void a2(a.ay sendStatusPayload) {
        QLog.i("AIOPicContentComponent", 1, "[handleSendStatusPayload] msgId=" + q1().getMsgId() + ", status=" + sendStatusPayload.a() + " msgStatus=" + q1().getMsgRecord().sendStatus);
        com.tencent.mobileqq.aio.msglist.holder.component.video.f fVar = this.progressViewController;
        if (fVar != null) {
            int a16 = sendStatusPayload.a();
            if (a16 != 0) {
                if (a16 != 1) {
                    if (a16 != 2 && a16 != 3) {
                        fVar.f();
                        return;
                    } else {
                        fVar.i();
                        return;
                    }
                }
                return;
            }
            fVar.f();
        }
    }

    private final void c2() {
        LinearLayout linearLayout = this.errorInfoContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void d2() {
        if (this.errorInfoContainer != null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        RelativeLayout W1 = W1();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        Unit unit = Unit.INSTANCE;
        W1.addView(linearLayout, layoutParams);
        this.errorInfoContainer = linearLayout;
        ImageView imageView = new ImageView(this.context);
        imageView.setId(R.id.byb);
        LinearLayout linearLayout2 = this.errorInfoContainer;
        Intrinsics.checkNotNull(linearLayout2);
        PicUtil picUtil = PicUtil.f191410a;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(picUtil.k(), picUtil.k());
        layoutParams2.gravity = 17;
        linearLayout2.addView(imageView, layoutParams2);
        this.errorIconView = imageView;
        TextView textView = new TextView(this.context);
        textView.setTextSize(12.0f);
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_tertiary));
        textView.setPadding(p.b(6.0f), 0, p.b(6.0f), 0);
        LinearLayout linearLayout3 = this.errorInfoContainer;
        Intrinsics.checkNotNull(linearLayout3);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = p.b(6.0f);
        layoutParams3.gravity = 17;
        linearLayout3.addView(textView, layoutParams3);
        this.errorPromptTextView = textView;
    }

    private final void e2(FileTransNotifyInfo info) {
        int i3 = info.trasferStatus;
        if (i3 == 5 || i3 == 4 || i3 == 6 || QLog.isColorLevel()) {
            QLog.i("AIOPicContentComponent", 1, "[logTransferStatus], msgId=" + info.msgId + " elemId=" + info.msgElementId + " status=" + info.trasferStatus + " error=" + info.fileErrCode + "-" + info.fileSrvErrCode + " detail=" + info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(boolean success, PicContentViewUtil.FailReason failReason) {
        if (success) {
            c2();
        } else if (failReason != PicContentViewUtil.FailReason.Expired && failReason != PicContentViewUtil.FailReason.Security && failReason != PicContentViewUtil.FailReason.Failed) {
            c2();
        } else {
            i2(failReason);
        }
    }

    private final void g2() {
        Y1().setVisibility(0);
        c2();
    }

    private final boolean h2() {
        TextView textView = this.errorPromptTextView;
        if (textView == null || this.errorIconView == null || textView == null) {
            return false;
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (textView.getMeasuredWidth() == 0 || textView.getMeasuredHeight() == 0) {
            return false;
        }
        int c16 = p.c(6);
        int c17 = p.c(15);
        int measuredWidth = textView.getMeasuredWidth() + c16;
        int measuredHeight = textView.getMeasuredHeight();
        ImageView imageView = this.errorIconView;
        Intrinsics.checkNotNull(imageView);
        int i3 = measuredHeight + imageView.getLayoutParams().height + c17;
        ViewGroup.LayoutParams layoutParams = Y1().getLayoutParams();
        if (layoutParams == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
        if (layoutParams.width < measuredWidth || layoutParams.height < i3) {
            return false;
        }
        return true;
    }

    private final void i2(PicContentViewUtil.FailReason failReason) {
        d2();
        LinearLayout linearLayout = this.errorInfoContainer;
        int i3 = 0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.errorPromptTextView;
        if (textView != null) {
            if (!h2()) {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        int i16 = b.f191409a[failReason.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                k2();
            } else {
                l2();
            }
        } else {
            j2();
        }
        Y1().setImageDrawable(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.j8b));
    }

    private final void j2() {
        ImageView imageView = this.errorIconView;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.qui_aio_expire_icon));
        }
        TextView textView = this.errorPromptTextView;
        if (textView != null) {
            textView.setText(R.string.ysg);
        }
    }

    private final void k2() {
        ImageView imageView = this.errorIconView;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.qui_aio_fail_icon));
        }
        TextView textView = this.errorPromptTextView;
        if (textView != null) {
            textView.setText(R.string.ysh);
        }
    }

    private final void l2() {
        ImageView imageView = this.errorIconView;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.qui_aio_fail_icon));
        }
        TextView textView = this.errorPromptTextView;
        if (textView != null) {
            textView.setText(R.string.ysi);
        }
    }

    private final void m2(PicMsgItem curMsgItem) {
        if (MsgExtKt.u(curMsgItem.p2())) {
            Y1().setBorderImg(null);
        } else if (Y1().m() == null) {
            Y1().setBorderImg(this.context.getDrawable(R.drawable.j7c));
        }
    }

    private final void n2(a.aw payload) {
        e2(payload.a());
        FileTransNotifyInfo a16 = payload.a();
        q1().l2(a16.msgElementId, a16.trasferStatus, a16.filePath, AIOPicDownloader.f190570a.i(q1().p2(), a16.fileDownType, a16.thumbSize));
        if (a16.trasferStatus == 4 && !TextUtils.isEmpty(a16.filePath)) {
            Pair<PicSize, String> j26 = q1().j2(q1().o2().elementId, g.a(q1().p2(), q1().getMsgRecord().isImportMsg));
            if (j26 != null && !MsgExtKt.x(q1().p2())) {
                PicContentViewUtil.f190621a.k(q1(), q1().o2(), Y1(), j26.getSecond(), j26.getFirst(), PicContentViewUtil.LoadingImage.Original, new AIOPicContentComponent$updateRichMediaPayload$1$1$1(this));
            }
        }
        if (a16.trasferStatus == 5) {
            QLog.w("AIOPicContentComponent", 1, "[updateRichMediaPayload] fail, msgId=" + a16.msgId + " elemId=" + a16.msgElementId + "  errMsg=" + a16.fileErrMsg + " errCode=" + a16.fileErrCode + " svrErrCode=" + a16.fileSrvErrCode);
            if (a16.fileSrvErrCode != -447) {
                long j3 = a16.fileErrCode;
                if (j3 != 1004015) {
                    if (j3 == 2006022) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                AIOPicContentComponent.p2(AIOPicContentComponent.this);
                            }
                        });
                    } else if (j3 == 2006045) {
                        QLog.i("AIOPicContentComponent", 1, "Kernel CreateFileDir Fail path: " + a16.filePath + ", msgId: " + a16.msgId);
                        if (!TextUtils.isEmpty(a16.filePath)) {
                            try {
                                File createDirectory = FileUtils.createDirectory(a16.filePath);
                                QLog.i("AIOPicContentComponent", 1, "Test CreateFileDir path: " + a16.filePath + ", msgId: " + a16.msgId + ", exist: " + createDirectory.exists() + ", canRead: " + createDirectory.canRead() + ", canWrite: " + createDirectory.canWrite());
                            } catch (Exception e16) {
                                QLog.i("AIOPicContentComponent", 1, "createDirectory exception: " + e16.getMessage() + ", msgId: " + a16.msgId);
                            }
                        }
                    }
                }
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPicContentComponent.o2(AIOPicContentComponent.this);
                }
            });
        }
        if (q1().R() == 1) {
            q2(payload.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(AIOPicContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.context, 1, R.string.ysf, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(AIOPicContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.context, 1, R.string.iid, 1).show();
    }

    private final void q2(FileTransNotifyInfo transferInfo) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPicContentComponent", 4, "[updateSendingProgress] msgId=" + q1().getMsgId() + " sendStatus=" + q1().R() + " transferStatus=" + transferInfo.trasferStatus);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.video.f fVar = this.progressViewController;
        if (fVar != null) {
            if (q1().R() != 1) {
                fVar.f();
                return;
            }
            int i3 = transferInfo.trasferStatus;
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AIOPicContentComponent", 2, "pic is sending, but transferStatus is error");
                            return;
                        }
                        return;
                    }
                    fVar.j();
                    return;
                }
                fVar.i();
                return;
            }
            fVar.l((int) ((100 * transferInfo.fileProgress) / transferInfo.totalSize));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public f createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        this.stopWatch.i();
        if (!Z1(msgItem, payloads)) {
            if (msgItem instanceof PicMsgItem) {
                PicMsgItem picMsgItem = (PicMsgItem) msgItem;
                if (!ai.k(q1().o2(), picMsgItem.p2())) {
                    PicElement picElement = picMsgItem.o2().picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement, "msgItem.msgElement.picElement");
                    PicContentViewUtil.f190621a.f(Y1(), picMsgItem.o2(), (w) msgItem, g.a(picElement, picMsgItem.getMsgRecord().isImportMsg), this, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIOPicContentComponent.O1(AIOPicContentComponent.this);
                        }
                    });
                }
            }
            this.stopWatch.b("handle payload");
            return;
        }
        this.stopWatch.e("handle payload");
        if (x1()) {
            QLog.i("AIOPicContentComponent", 1, "[bind] same data, msgId=" + msgItem.getMsgId());
            this.stopWatch.b("same data");
            return;
        }
        g2();
        if (o81.a.e(q1()) && this.progressViewController == null) {
            this.progressViewController = U1();
        }
        com.tencent.mobileqq.aio.msglist.holder.component.video.f fVar = this.progressViewController;
        if (fVar != null) {
            fVar.b(q1().r2());
        }
        this.stopWatch.e("create progress bar");
        m2(q1());
        PicContentViewUtil.f190621a.c(Y1(), q1(), q1().o2(), this, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.pic.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOPicContentComponent.P1(AIOPicContentComponent.this);
            }
        }, new AIOPicContentComponent$bind$3(this));
        Y1().requestLayout();
        this.stopWatch.e("apply pic view");
        q2(q1().getFileTransNotifyInfo());
        this.stopWatch.e("update sending progress");
        Q1();
        this.stopWatch.e("bind dui view");
        this.stopWatch.b("bind");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return W1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return Y1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, importance);
        } else {
            Y1().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.video.f fVar = this.progressViewController;
        if (fVar != null) {
            fVar.f();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (q1().getMsgRecord().chatType == 8) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new k(getMContext(), q1(), this, null, 8, null), new i(getMContext(), q1()), new h(getMContext(), q1(), this));
            return mutableListOf;
        }
        ArrayList<com.tencent.qqnt.aio.menu.ui.d> arrayList = new ArrayList<>();
        if (MsgExtKt.u(q1().p2())) {
            arrayList.add(new com.tencent.qqnt.aio.menu.b(getMContext(), q1(), this));
            arrayList.add(new k(getMContext(), q1(), this, null, 8, null));
            arrayList.add(new ac(getMContext(), q1(), this));
            arrayList.add(new af(getMContext(), q1(), this));
            arrayList.add(new h(getMContext(), q1(), this));
            arrayList.add(new u(getMContext(), q1(), this));
            arrayList.add(new ad(getMContext(), q1(), this));
            arrayList.add(new i(getMContext(), q1()));
            S1(arrayList);
            arrayList.add(new ap(getMContext(), q1(), this));
            arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
            arrayList.add(new ao(getMContext(), q1()));
            arrayList.add(new ag(getMContext(), q1()));
            arrayList.add(new o(getMContext(), q1()));
            arrayList.add(new aj(getMContext(), q1(), this));
        } else {
            arrayList.add(new k(getMContext(), q1(), this, null, 8, null));
            arrayList.add(new i(getMContext(), q1()));
            arrayList.add(new com.tencent.qqnt.aio.menu.b(getMContext(), q1(), this));
            arrayList.add(new af(getMContext(), q1(), this));
            arrayList.add(new h(getMContext(), q1(), this));
            arrayList.add(new u(getMContext(), q1(), this));
            arrayList.add(new ad(getMContext(), q1(), this));
            arrayList.add(new ap(getMContext(), q1(), this));
            arrayList.add(new j(getMContext(), q1(), this));
            arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
            arrayList.add(new ao(getMContext(), q1()));
            arrayList.add(new ag(getMContext(), q1()));
            arrayList.add(new aj(getMContext(), q1(), this));
        }
        return arrayList;
    }
}
