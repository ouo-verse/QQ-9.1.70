package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.events.QFSMakeRedPacketEvent;
import com.tencent.biz.qqcircle.immersive.redpacket.util.RedPacketConstant$RedPacketState;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.MakeRedPacketResult;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 f2\u00020\u0001:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\u001c\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u001c\u0010+\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u00152\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\"\u00100\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0006\u00101\u001a\u00020\u0002R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00103R*\u0010E\u001a\u00020=2\u0006\u0010>\u001a\u00020=8\u0000@BX\u0080\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR#\u0010P\u001a\n K*\u0004\u0018\u00010J0J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR#\u0010Y\u001a\n K*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010M\u001a\u0004\bW\u0010XR#\u0010\\\u001a\n K*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010M\u001a\u0004\b[\u0010XR#\u0010_\u001a\n K*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010M\u001a\u0004\b^\u0010XR\u0011\u0010c\u001a\u00020`8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewInfoPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "O9", "N9", "Landroid/widget/ImageView;", "iv", "P9", "Landroid/widget/TextView;", "tv", "S9", "la", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult;", "result", "ga", LocaleUtils.L_JAPANESE, "Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "dialog", "ta", "ua", "ha", "", "message", "va", "aa", "ca", "da", "ea", "Ba", "", "startTime", "endTime", "wa", "Aa", "za", "qa", "ba", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "ra", "d", "Landroid/widget/TextView;", "tvFromTemplate", "Lcom/tencent/biz/qqcircle/widgets/RoundImageView;", "e", "Lcom/tencent/biz/qqcircle/widgets/RoundImageView;", "ivAvatar", "f", "tvFromPerson", tl.h.F, "tvConfirm", "Lcom/tencent/biz/qqcircle/immersive/redpacket/util/RedPacketConstant$RedPacketState;", "value", "i", "Lcom/tencent/biz/qqcircle/immersive/redpacket/util/RedPacketConstant$RedPacketState;", "getRedPacketState$qcircle_plugin_module_release", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/util/RedPacketConstant$RedPacketState;", "sa", "(Lcom/tencent/biz/qqcircle/immersive/redpacket/util/RedPacketConstant$RedPacketState;)V", "redPacketState", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "selectStartTime", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Z9", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "viewModel", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "D", "W9", "()Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "loadingDialog", "E", "X9", "()Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "needCheckAlertDialog", UserInfo.SEX_FEMALE, "Y9", "succeedAlertDialog", "G", "V9", "backAlertDialog", "", "ia", "()Z", "isRedPacketOpen", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRedPacketPreviewInfoPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy needCheckAlertDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy succeedAlertDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy backAlertDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvFromTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundImageView ivAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvFromPerson;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvConfirm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile RedPacketConstant$RedPacketState redPacketState = RedPacketConstant$RedPacketState.OPEN;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile long selectStartTime;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89428a;

        static {
            int[] iArr = new int[RedPacketConstant$RedPacketState.values().length];
            try {
                iArr[RedPacketConstant$RedPacketState.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RedPacketConstant$RedPacketState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f89428a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewInfoPart$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f89429d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSRedPacketPreviewInfoPart f89430e;

        c(View view, QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart) {
            this.f89429d = view;
            this.f89430e = qFSRedPacketPreviewInfoPart;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f89429d.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f89430e.Aa();
            return true;
        }
    }

    public QFSRedPacketPreviewInfoPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketPreviewInfoPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h invoke() {
                return (com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h) QFSRedPacketPreviewInfoPart.this.getViewModel(com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new QFSRedPacketPreviewInfoPart$loadingDialog$2(this));
        this.loadingDialog = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new QFSRedPacketPreviewInfoPart$needCheckAlertDialog$2(this));
        this.needCheckAlertDialog = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new QFSRedPacketPreviewInfoPart$succeedAlertDialog$2(this));
        this.succeedAlertDialog = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new QFSRedPacketPreviewInfoPart$backAlertDialog$2(this));
        this.backAlertDialog = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        broadcastMessage("EVENT_START_OPEN_RED_PACKET_ANIM", null);
    }

    private final void Ba() {
        String string;
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "updateConfirmBtnText, redPacketState:" + this.redPacketState);
        TextView textView = this.tvConfirm;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
            textView = null;
        }
        int i3 = b.f89428a[this.redPacketState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                string = getContext().getString(R.string.f194684ck);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            string = getContext().getString(R.string.f194744cq);
        }
        textView.setText(string);
    }

    private final void N9() {
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        bVar.e(ia());
        String str = Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.previewBean.feed.id.get()");
        bVar.d(QCircleDaTongConstant.ElementId.EM_QQ_ADJUST_CLIP_BUTTON, str, ia());
        String str2 = Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "viewModel.previewBean.feed.id.get()");
        bVar.d(QCircleDaTongConstant.ElementId.EM_QQ_USE_COVER_BUTTON, str2, ia());
    }

    private final void O9() {
        com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a.f(ia());
    }

    private final void P9(final ImageView iv5) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ae
            @Override // java.lang.Runnable
            public final void run() {
                QFSRedPacketPreviewInfoPart.Q9(iv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(final ImageView iv5) {
        Intrinsics.checkNotNullParameter(iv5, "$iv");
        final Bitmap avatarBitmap = QCircleCommonUtil.getAvatarBitmap(QCircleCommonUtil.getCurrentAccount());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ai
            @Override // java.lang.Runnable
            public final void run() {
                QFSRedPacketPreviewInfoPart.R9(avatarBitmap, iv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Bitmap bitmap, ImageView iv5) {
        Intrinsics.checkNotNullParameter(iv5, "$iv");
        if (bitmap != null) {
            iv5.setImageBitmap(bitmap);
        }
    }

    private final void S9(final TextView tv5) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.af
            @Override // java.lang.Runnable
            public final void run() {
                QFSRedPacketPreviewInfoPart.T9(tv5, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(final TextView tv5, final QFSRedPacketPreviewInfoPart this$0) {
        int coerceAtMost;
        final String substring;
        Intrinsics.checkNotNullParameter(tv5, "$tv");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String nickName = QCircleCommonUtil.getNickName(QCircleCommonUtil.getCurrentAccount());
        if (nickName == null) {
            nickName = "";
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(nickName.length(), 12);
        if (nickName.length() > coerceAtMost) {
            String substring2 = nickName.substring(0, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            substring = substring2 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        } else {
            substring = nickName.substring(0, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ah
            @Override // java.lang.Runnable
            public final void run() {
                QFSRedPacketPreviewInfoPart.U9(tv5, this$0, substring);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(TextView tv5, QFSRedPacketPreviewInfoPart this$0, String displayName) {
        Intrinsics.checkNotNullParameter(tv5, "$tv");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(displayName, "$displayName");
        tv5.setText(this$0.getContext().getString(R.string.f194694cl, displayName));
    }

    private final QCircleCustomDialog V9() {
        return (QCircleCustomDialog) this.backAlertDialog.getValue();
    }

    private final QCircleLoadingDialog W9() {
        return (QCircleLoadingDialog) this.loadingDialog.getValue();
    }

    private final QCircleCustomDialog X9() {
        return (QCircleCustomDialog) this.needCheckAlertDialog.getValue();
    }

    private final QCircleCustomDialog Y9() {
        return (QCircleCustomDialog) this.succeedAlertDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h Z9() {
        return (com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h) this.viewModel.getValue();
    }

    private final void aa() {
        com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h Z9 = Z9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Z9.W1(context);
    }

    private final void ba() {
        int i3 = b.f89428a[this.redPacketState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                sa(RedPacketConstant$RedPacketState.OPEN);
                Ba();
                qa();
                xa(this, 0, 0, 1, null);
                return;
            }
            return;
        }
        QCircleCustomDialog backAlertDialog = V9();
        Intrinsics.checkNotNullExpressionValue(backAlertDialog, "backAlertDialog");
        ta(backAlertDialog);
    }

    private final void ca() {
        com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h Z9 = Z9();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Z9.T1(activity, this.selectStartTime);
    }

    private final void da() {
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "handleConfirmBtnClick, redPacketState:" + this.redPacketState);
        int i3 = b.f89428a[this.redPacketState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ea();
            }
        } else {
            sa(RedPacketConstant$RedPacketState.CLOSE);
            Ba();
            za();
            xa(this, (int) (this.selectStartTime / 1000), 0, 2, null);
        }
    }

    private final void ea() {
        Z9().U1(this.selectStartTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(MakeRedPacketResult result) {
        Long l3;
        PBInt64Field pBInt64Field;
        FeedCloudDatacard$RedPocketCoverInfo redPacketInfo = result.getRedPacketInfo();
        if (redPacketInfo != null && (pBInt64Field = redPacketInfo.status) != null) {
            l3 = Long.valueOf(pBInt64Field.get());
        } else {
            l3 = null;
        }
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "handleSucceed, fromType:" + result.getFromType() + ", status:" + l3);
        if (l3 != null && 1 == l3.longValue()) {
            if (1 == result.getFromType()) {
                QCircleCustomDialog succeedAlertDialog = Y9();
                Intrinsics.checkNotNullExpressionValue(succeedAlertDialog, "succeedAlertDialog");
                ta(succeedAlertDialog);
                return;
            }
            ja();
            return;
        }
        QCircleCustomDialog needCheckAlertDialog = X9();
        Intrinsics.checkNotNullExpressionValue(needCheckAlertDialog, "needCheckAlertDialog");
        ta(needCheckAlertDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        W9().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja() {
        FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        MakeRedPacketResult value = Z9().O1().getValue();
        if (value != null) {
            feedCloudDatacard$RedPocketCoverInfo = value.getRedPacketInfo();
        } else {
            feedCloudDatacard$RedPocketCoverInfo = null;
        }
        simpleEventBus.dispatchEvent(new QFSMakeRedPacketEvent(feedCloudDatacard$RedPocketCoverInfo));
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void la() {
        LiveData<MakeRedPacketResult> O1 = Z9().O1();
        Fragment hostFragment = getHostFragment();
        final Function1<MakeRedPacketResult, Unit> function1 = new Function1<MakeRedPacketResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketPreviewInfoPart$observeLiveData$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes4.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f89431a;

                static {
                    int[] iArr = new int[MakeRedPacketResult.State.values().length];
                    try {
                        iArr[MakeRedPacketResult.State.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MakeRedPacketResult.State.SUCCEED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MakeRedPacketResult.State.FAILED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f89431a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MakeRedPacketResult makeRedPacketResult) {
                invoke2(makeRedPacketResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MakeRedPacketResult it) {
                int i3 = a.f89431a[it.getState().ordinal()];
                if (i3 == 1) {
                    QFSRedPacketPreviewInfoPart.this.ua();
                    return;
                }
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                    QFSRedPacketPreviewInfoPart.this.ha();
                    QFSRedPacketPreviewInfoPart.this.va(it.getMessage());
                    return;
                }
                QFSRedPacketPreviewInfoPart.this.ha();
                QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = QFSRedPacketPreviewInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSRedPacketPreviewInfoPart.ga(it);
            }
        };
        O1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSRedPacketPreviewInfoPart.ma(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(QFSRedPacketPreviewInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca();
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        String str = this$0.Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.previewBean.feed.id.get()");
        bVar.c(QCircleDaTongConstant.ElementId.EM_QQ_ADJUST_CLIP_BUTTON, str, this$0.ia());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(QFSRedPacketPreviewInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        String str = this$0.Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.previewBean.feed.id.get()");
        bVar.c(QCircleDaTongConstant.ElementId.EM_QQ_USE_COVER_BUTTON, str, this$0.ia());
        this$0.da();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(QFSRedPacketPreviewInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aa();
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        String str = this$0.Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.previewBean.feed.id.get()");
        bVar.c(QCircleDaTongConstant.ElementId.EM_QQ_ADJUST_CLIP_BUTTON, str, this$0.ia());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void qa() {
        broadcastMessage("EVENT_REST_OPEN_RED_PACKET_STATE", null);
    }

    private final void sa(RedPacketConstant$RedPacketState redPacketConstant$RedPacketState) {
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "set value: " + redPacketConstant$RedPacketState);
        O9();
        this.redPacketState = redPacketConstant$RedPacketState;
        N9();
    }

    private final void ta(QCircleCustomDialog dialog) {
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        W9().showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(String message) {
        QCircleToast.p(message, 0, true);
    }

    private final void wa(int startTime, int endTime) {
        broadcastMessage("EVENT_CLIP_VIDEO_DONE", new int[]{startTime, endTime});
    }

    static /* synthetic */ void xa(QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = i3 + 2000;
        }
        qFSRedPacketPreviewInfoPart.wa(i3, i16);
    }

    private final void za() {
        broadcastMessage("EVENT_START_CLOSE_RED_PACKET_ANIM", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "EVENT_BACK_BTN_CLICKED")) {
            QLog.d("QFSRedPacketPreviewInfoPart", 1, "handleBroadcastMessage, redPacketState:" + this.redPacketState);
            ba();
        }
    }

    public final boolean ia() {
        if (this.redPacketState == RedPacketConstant$RedPacketState.OPEN) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        long j3;
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (requestCode == 111 && resultCode == -1) {
            if (data != null) {
                j3 = data.getLongExtra("ACTIVITY_RESULT_CLIP", -1L);
            } else {
                j3 = -1;
            }
            QLog.d("QFSRedPacketPreviewInfoPart", 1, "onActivityResult, startTime:" + j3);
            if (j3 != -1 && j3 != this.selectStartTime) {
                this.selectStartTime = j3;
                xa(this, (int) (j3 / 1000), 0, 2, null);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ((RoundFrameLayout) rootView.findViewById(R.id.v8l)).setRadius(cx.a(12.0f));
        ImageView imageView = (ImageView) rootView.findViewById(R.id.y7z);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a aVar = com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a;
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, imageView, "qvideo_hongbao_close", false, true, 4, null);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, (ImageView) rootView.findViewById(R.id.f165960y80), "qvideo_hongbao_opened_v2", false, true, 4, null);
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.y6m);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, imageView2, "qvideo_hongbao_icon_open_back", false, false, 12, null);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, imageView2, "qvideo_hongbao_icon_open_front", false, false, 12, null);
        View findViewById = rootView.findViewById(R.id.f108086c6);
        TextView textView = (TextView) findViewById;
        textView.setText(rootView.getContext().getString(R.string.f194704cm, com.dataline.util.j.d(QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME)));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R\u2026ext(\"\u5c0f\u4e16\u754c\"))\n            }");
        this.tvFromTemplate = textView;
        View findViewById2 = rootView.findViewById(R.id.f165909du3);
        RoundImageView it = (RoundImageView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        P9(it);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RoundImageV\u2026dAvatar(it)\n            }");
        this.ivAvatar = it;
        View findViewById3 = rootView.findViewById(R.id.f108076c5);
        TextView it5 = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        S9(it5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026ickName(it)\n            }");
        this.tvFromPerson = it5;
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, (ImageView) rootView.findViewById(R.id.y5t), "qvideo_hongbao_amount_v2", false, false, 12, null);
        ((TextView) rootView.findViewById(R.id.f10661697)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSRedPacketPreviewInfoPart.pa(QFSRedPacketPreviewInfoPart.this, view);
            }
        });
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        String str = Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.previewBean.feed.id.get()");
        bVar.d(QCircleDaTongConstant.ElementId.EM_QQ_ADJUST_CLIP_BUTTON, str, ia());
        ((TextView) rootView.findViewById(R.id.f1068169q)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSRedPacketPreviewInfoPart.na(QFSRedPacketPreviewInfoPart.this, view);
            }
        });
        View findViewById4 = rootView.findViewById(R.id.k6q);
        TextView textView2 = (TextView) findViewById4;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSRedPacketPreviewInfoPart.oa(QFSRedPacketPreviewInfoPart.this, view);
            }
        });
        String str2 = Z9().P1().getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "viewModel.previewBean.feed.id.get()");
        bVar.d(QCircleDaTongConstant.ElementId.EM_QQ_USE_COVER_BUTTON, str2, ia());
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R\u2026          )\n            }");
        this.tvConfirm = textView2;
        rootView.getViewTreeObserver().addOnPreDrawListener(new c(rootView, this));
        la();
    }

    public final void ra() {
        QLog.d("QFSRedPacketPreviewInfoPart", 1, "resetSelectStartTime ");
        this.selectStartTime = 0L;
    }
}
