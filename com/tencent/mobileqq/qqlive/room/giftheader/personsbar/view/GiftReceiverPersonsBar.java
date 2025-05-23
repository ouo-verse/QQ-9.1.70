package com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view;

import ai4.GiftReceiver;
import ai4.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.now.od.ui.common.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tl.h;

@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001O\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0003^_`B\u0011\b\u0016\u0012\u0006\u0010T\u001a\u00020S\u00a2\u0006\u0004\bU\u0010VB\u001b\b\u0016\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u00a2\u0006\u0004\bU\u0010YB#\b\u0016\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u0012\u0006\u0010[\u001a\u00020Z\u00a2\u0006\u0004\bU\u0010\\J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0014\u0010\u0010\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0014R\u001c\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0018\u00010!R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010*\u001a\u00060%R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0018\u0010>\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010IR$\u0010N\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00058\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bK\u0010C\"\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar;", "Landroid/widget/LinearLayout;", "Lcom/tencent/now/od/ui/gift/a;", "", "t", "", "isForceSelected", "r", "o", "", "roomId", "uid", "t0", "", "Lai4/a;", "list", "setData", "Landroid/view/View;", "getView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/now/od/ui/gift/b;", "callback", "setUserSelectedCallback", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "d", "Lorg/slf4j/Logger;", "logger", "e", "Lai4/a;", "selectedSeat", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder;", "f", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder;", "selectedViewHolder", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$b;", h.F, "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$b;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "personRv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "clickToSelectTargetArea", "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/od/ui/common/widget/RoundImageView;", "giftSelectedUserHead", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "giftSelectedUserName", "E", "presentResultsToChooseArea", UserInfo.SEX_FEMALE, "Lcom/tencent/now/od/ui/gift/b;", "selectedCallback", "G", "Ljava/util/List;", "listData", "H", "Z", "isAniming", "Landroid/animation/AnimatorSet;", "I", "Landroid/animation/AnimatorSet;", "animator", "J", "value", "K", "u", "(Z)V", "showChoseResult", "com/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$c", "L", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$c;", "observer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "PersonViewHolder", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GiftReceiverPersonsBar extends LinearLayout implements com.tencent.now.od.ui.gift.a {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private RoundImageView giftSelectedUserHead;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView giftSelectedUserName;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View presentResultsToChooseArea;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.now.od.ui.gift.b selectedCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private List<GiftReceiver> listData;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isAniming;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet animator;

    /* renamed from: J, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean showChoseResult;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final c observer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Logger logger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftReceiver selectedSeat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PersonViewHolder selectedViewHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView personRv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View clickToSelectTargetArea;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\n \u0010*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "end", "o", "Lai4/a;", "seat", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "receiver", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "personHeadIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "personLabel", "G", "Landroid/view/View;", "headSelectedBg", "H", "nameTv", "I", "Lai4/a;", "curSeat", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class PersonViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView personHeadIv;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView personLabel;

        /* renamed from: G, reason: from kotlin metadata */
        private final View headSelectedBg;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView nameTv;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private GiftReceiver curSeat;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a implements Animator.AnimatorListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GiftReceiverPersonsBar f271604d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f271605e;

            a(GiftReceiverPersonsBar giftReceiverPersonsBar, Function0<Unit> function0) {
                this.f271604d = giftReceiverPersonsBar;
                this.f271605e = function0;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) giftReceiverPersonsBar, (Object) function0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    this.f271604d.isAniming = false;
                    this.f271604d.animator = null;
                    this.f271605e.invoke();
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    this.f271604d.isAniming = false;
                    this.f271604d.animator = null;
                    this.f271605e.invoke();
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder$b", "Landroid/util/Property;", "Landroid/view/View;", "", "object", "a", "(Landroid/view/View;)Ljava/lang/Float;", "animView", "value", "", "b", UserInfo.SEX_FEMALE, "w", h.F, "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends Property<View, Float> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private float w;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private float h;

            b(Class<Float> cls) {
                super(cls, "");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
                }
            }

            @Override // android.util.Property
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(@NotNull View object) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) object);
                }
                Intrinsics.checkNotNullParameter(object, "object");
                return Float.valueOf(object.getRotation());
            }

            public void b(@NotNull View animView, float value) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = true;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, animView, Float.valueOf(value));
                    return;
                }
                Intrinsics.checkNotNullParameter(animView, "animView");
                if (this.w == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    float width = (animView.getWidth() / 5.0f) * 2;
                    this.w = width;
                    animView.setPivotX(width);
                }
                if (this.h != 0.0f) {
                    z17 = false;
                }
                if (z17) {
                    float height = animView.getHeight() * 1.0f;
                    this.h = height;
                    animView.setPivotY(height);
                }
                animView.setRotation(value);
            }

            @Override // android.util.Property
            public /* bridge */ /* synthetic */ void set(View view, Float f16) {
                b(view, f16.floatValue());
            }
        }

        public PersonViewHolder() {
            super(View.inflate(GiftReceiverPersonsBar.this.getContext(), R.layout.fd9, null));
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
                return;
            }
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f2411089);
            this.personHeadIv = imageView;
            this.personLabel = (TextView) this.itemView.findViewById(R.id.f241208_);
            this.headSelectedBg = this.itemView.findViewById(R.id.x7u);
            this.nameTv = (TextView) this.itemView.findViewById(R.id.zlz);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GiftReceiverPersonsBar.PersonViewHolder.m(GiftReceiverPersonsBar.PersonViewHolder.this, r2, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(PersonViewHolder this$0, final GiftReceiverPersonsBar this$1, View view) {
            boolean z16;
            long j3;
            long j16;
            String str;
            String str2;
            String avatar;
            String name;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            GiftReceiver giftReceiver = this$0.curSeat;
            if (giftReceiver != null) {
                long j17 = 0;
                int i3 = 0;
                if (giftReceiver.getUid() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    giftReceiver = null;
                }
                if (giftReceiver != null && !this$1.isAniming) {
                    this$1.selectedSeat = giftReceiver;
                    PersonViewHolder personViewHolder = this$1.selectedViewHolder;
                    this$1.selectedViewHolder = this$0;
                    ai4.c cVar = ai4.c.f26122a;
                    GiftReceiver giftReceiver2 = this$1.selectedSeat;
                    if (giftReceiver2 != null) {
                        j3 = giftReceiver2.getUid();
                    } else {
                        j3 = 0;
                    }
                    cVar.j(j3);
                    com.tencent.now.od.ui.gift.b bVar = this$1.selectedCallback;
                    if (bVar != null) {
                        GiftReceiver giftReceiver3 = this$1.selectedSeat;
                        if (giftReceiver3 != null) {
                            j16 = giftReceiver3.getUid();
                        } else {
                            j16 = 0;
                        }
                        GiftReceiver giftReceiver4 = this$1.selectedSeat;
                        if (giftReceiver4 == null || (name = giftReceiver4.getName()) == null) {
                            str = "";
                        } else {
                            str = name;
                        }
                        GiftReceiver giftReceiver5 = this$1.selectedSeat;
                        if (giftReceiver5 == null || (avatar = giftReceiver5.getAvatar()) == null) {
                            str2 = "";
                        } else {
                            str2 = avatar;
                        }
                        GiftReceiver giftReceiver6 = this$1.selectedSeat;
                        if (giftReceiver6 != null) {
                            i3 = giftReceiver6.getSeatType();
                        }
                        int i16 = i3;
                        GiftReceiver giftReceiver7 = this$1.selectedSeat;
                        if (giftReceiver7 != null) {
                            j17 = giftReceiver7.getStartSeq();
                        }
                        bVar.a(j16, str, str2, i16, j17);
                    }
                    if (personViewHolder != null) {
                        personViewHolder.p();
                    }
                    this$0.p();
                    View headSelectedBg = this$0.headSelectedBg;
                    Intrinsics.checkNotNullExpressionValue(headSelectedBg, "headSelectedBg");
                    this$0.o(headSelectedBg, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar$PersonViewHolder$1$2$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
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
                                return;
                            }
                            GiftReceiverPersonsBar.this.u(true);
                            GiftReceiverPersonsBar.this.q();
                            GiftReceiverPersonsBar.this.t();
                        }
                    });
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(View view, Function0<Unit> end) {
            if (GiftReceiverPersonsBar.this.isAniming) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.95f, 0.85f, 0.95f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.95f, 0.85f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, new b(Float.TYPE), 0.0f, 25.0f, 0.0f, -8.0f, 8.0f, -3.0f, 3.0f, 0.0f);
            GiftReceiverPersonsBar giftReceiverPersonsBar = GiftReceiverPersonsBar.this;
            AnimatorSet animatorSet = new AnimatorSet();
            GiftReceiverPersonsBar giftReceiverPersonsBar2 = GiftReceiverPersonsBar.this;
            animatorSet.setDuration(800L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            animatorSet.addListener(new a(giftReceiverPersonsBar2, end));
            animatorSet.start();
            giftReceiverPersonsBar.animator = animatorSet;
        }

        private final void q(GiftReceiver seat) {
            String avatar;
            if (seat != null && (avatar = seat.getAvatar()) != null) {
                this.personHeadIv.setImageDrawable(URLDrawable.getDrawable(avatar, (URLDrawable.URLDrawableOptions) null));
            }
        }

        private final void r(GiftReceiver seat) {
            boolean z16;
            int i3;
            int i16;
            GiftReceiver giftReceiver = GiftReceiverPersonsBar.this.selectedSeat;
            if (giftReceiver != null && seat.getUid() == giftReceiver.getUid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView = this.personLabel;
            int seatNo = seat.getSeatNo();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(seatNo);
            textView.setText(sb5.toString());
            this.personLabel.setVisibility(0);
            TextView textView2 = this.nameTv;
            String name = seat.getName();
            if (name == null) {
                name = "";
            }
            textView2.setText(name);
            TextView textView3 = this.nameTv;
            if (z16) {
                i3 = GiftReceiverPersonsBar.this.getContext().getResources().getColor(R.color.b7r);
            } else {
                i3 = -1;
            }
            textView3.setTextColor(i3);
            TextView textView4 = this.personLabel;
            if (z16) {
                i16 = R.drawable.lqo;
            } else {
                i16 = R.drawable.lqr;
            }
            textView4.setBackgroundResource(i16);
        }

        public final void n(@NotNull GiftReceiver receiver) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) receiver);
                return;
            }
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            GiftReceiver giftReceiver = GiftReceiverPersonsBar.this.selectedSeat;
            boolean z16 = false;
            if (giftReceiver != null && receiver.getUid() == giftReceiver.getUid()) {
                z16 = true;
            }
            if (z16) {
                GiftReceiverPersonsBar.this.selectedViewHolder = this;
            }
            this.curSeat = receiver;
            q(receiver);
            r(receiver);
        }

        public final void p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            GiftReceiver giftReceiver = this.curSeat;
            if (giftReceiver != null) {
                n(giftReceiver);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$a;", "", "", "SELECTED_LIST_BG_URL", "Ljava/lang/String;", "SELECTED_SHOW_BG_URL", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\t\u001a\u00060\u0007R\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$PersonViewHolder;", "Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar;", "i0", "getItemCount", "holder", "position", "", "onBindViewHolder", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                List list = GiftReceiverPersonsBar.this.listData;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public PersonViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PersonViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new PersonViewHolder();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            GiftReceiver giftReceiver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof PersonViewHolder) {
                List list = GiftReceiverPersonsBar.this.listData;
                if (list != null && (giftReceiver = (GiftReceiver) list.get(position)) != null) {
                    ((PersonViewHolder) holder).n(giftReceiver);
                    return;
                }
                return;
            }
            GiftReceiverPersonsBar.this.logger.error("holder type is invalid! holder:" + holder);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/qqlive/room/giftheader/personsbar/view/GiftReceiverPersonsBar$c", "Lai4/c$a;", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements c.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftReceiverPersonsBar(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.logger = LoggerFactory.getLogger("MultiLinkChatGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GiftReceiverPersonsBar.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new GiftReceiverPersonsBar.b() : (GiftReceiverPersonsBar.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        View.inflate(getContext(), R.layout.fmd, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        this.personRv = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftReceiverPersonsBar.b(GiftReceiverPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(p());
        u(true);
        this.observer = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GiftReceiverPersonsBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean o() {
        GiftReceiver giftReceiver;
        Object obj;
        boolean z16;
        List<GiftReceiver> list = this.listData;
        Integer num = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((GiftReceiver) obj).getSeatType() == 3) {
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
            giftReceiver = (GiftReceiver) obj;
        } else {
            giftReceiver = null;
        }
        if (giftReceiver != null) {
            num = Integer.valueOf(giftReceiver.getSeatType());
        }
        return Intrinsics.areEqual((Object) num, (Object) 3);
    }

    private final b p() {
        return (b) this.adapter.getValue();
    }

    private final void r(boolean isForceSelected) {
        if (!o()) {
            QQToast.makeText(getContext(), "\u5f53\u524d\u6ca1\u6709\u4e3b\u6301\u4eba\uff0c\u4e0d\u80fd\u8d60\u9001\u793c\u7269", 0).show();
            com.tencent.now.od.ui.gift.b bVar = this.selectedCallback;
            if (bVar != null) {
                bVar.closeGiftPanel();
                return;
            }
            return;
        }
        q();
    }

    static /* synthetic */ void s(GiftReceiverPersonsBar giftReceiverPersonsBar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        giftReceiverPersonsBar.r(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        long j16;
        String avatar;
        String name;
        GiftReceiver giftReceiver = this.selectedSeat;
        if (giftReceiver != null) {
            str = giftReceiver.getAvatar();
        } else {
            str = null;
        }
        GiftReceiver giftReceiver2 = this.selectedSeat;
        if (giftReceiver2 != null) {
            str2 = giftReceiver2.getName();
        } else {
            str2 = null;
        }
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            this.giftSelectedUserHead.setVisibility(8);
        } else {
            this.giftSelectedUserHead.setVisibility(0);
            this.giftSelectedUserHead.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null));
        }
        if (TextUtils.isEmpty(str2)) {
            this.giftSelectedUserName.setText("\u9009\u62e9\u9001\u793c\u5bf9\u8c61");
        } else {
            this.giftSelectedUserName.setText(str2);
        }
        com.tencent.now.od.ui.gift.b bVar = this.selectedCallback;
        if (bVar != null) {
            GiftReceiver giftReceiver3 = this.selectedSeat;
            if (giftReceiver3 != null) {
                j3 = giftReceiver3.getUid();
            } else {
                j3 = 0;
            }
            GiftReceiver giftReceiver4 = this.selectedSeat;
            if (giftReceiver4 == null || (name = giftReceiver4.getName()) == null) {
                str3 = "";
            } else {
                str3 = name;
            }
            GiftReceiver giftReceiver5 = this.selectedSeat;
            if (giftReceiver5 == null || (avatar = giftReceiver5.getAvatar()) == null) {
                str4 = "";
            } else {
                str4 = avatar;
            }
            GiftReceiver giftReceiver6 = this.selectedSeat;
            if (giftReceiver6 != null) {
                i3 = giftReceiver6.getSeatType();
            }
            int i16 = i3;
            GiftReceiver giftReceiver7 = this.selectedSeat;
            if (giftReceiver7 != null) {
                j16 = giftReceiver7.getStartSeq();
            } else {
                j16 = 0;
            }
            bVar.a(j3, str3, str4, i16, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean z16) {
        int i3;
        this.showChoseResult = z16;
        RecyclerView recyclerView = this.personRv;
        int i16 = 8;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        recyclerView.setVisibility(i3);
        View view = this.presentResultsToChooseArea;
        if (z16) {
            i16 = 0;
        }
        view.setVisibility(i16);
    }

    @Override // com.tencent.now.od.ui.gift.a
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onAttachedToWindow();
            ai4.c.f26122a.b(this.observer);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ai4.c.f26122a.c(this.observer);
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            p().notifyDataSetChanged();
        }
    }

    public final void setData(@NotNull List<GiftReceiver> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        this.listData = list;
        s(this, false, 1, null);
        t();
    }

    @Override // com.tencent.now.od.ui.gift.a
    public void setUserSelectedCallback(@NotNull com.tencent.now.od.ui.gift.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.selectedCallback = callback;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.now.od.ui.gift.a
    public void t0(long roomId, long uid) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(uid));
            return;
        }
        this.roomId = roomId;
        if (uid != 0) {
            ai4.c cVar = ai4.c.f26122a;
            if (cVar.d() > 0) {
                uid = cVar.d();
            }
            List<GiftReceiver> list = this.listData;
            GiftReceiver giftReceiver = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((GiftReceiver) next).getUid() == uid) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        giftReceiver = next;
                        break;
                    }
                }
                giftReceiver = giftReceiver;
            }
            if (giftReceiver != null) {
                this.selectedSeat = giftReceiver;
                r(false);
                t();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftReceiverPersonsBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.logger = LoggerFactory.getLogger("MultiLinkChatGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GiftReceiverPersonsBar.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new GiftReceiverPersonsBar.b() : (GiftReceiverPersonsBar.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        View.inflate(getContext(), R.layout.fmd, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        this.personRv = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftReceiverPersonsBar.b(GiftReceiverPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(p());
        u(true);
        this.observer = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftReceiverPersonsBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.logger = LoggerFactory.getLogger("MultiLinkChatGiftPersonsBar");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftReceiverPersonsBar.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GiftReceiverPersonsBar.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new GiftReceiverPersonsBar.b() : (GiftReceiverPersonsBar.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.adapter = lazy;
        this.showChoseResult = true;
        View.inflate(getContext(), R.layout.fmd, this);
        View findViewById = findViewById(R.id.f241308a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.personRv)");
        this.personRv = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.txx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clickToSelectTargetArea)");
        this.clickToSelectTargetArea = findViewById2;
        View findViewById3 = findViewById(R.id.vos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giftSelectedUserHead)");
        this.giftSelectedUserHead = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.vot);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftSelectedUserName)");
        this.giftSelectedUserName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f26940ew);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.presentResultsToChoose)");
        this.presentResultsToChooseArea = findViewById5;
        this.clickToSelectTargetArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftReceiverPersonsBar.b(GiftReceiverPersonsBar.this, view);
            }
        });
        this.personRv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.personRv.setAdapter(p());
        u(true);
        this.observer = new c();
    }
}
