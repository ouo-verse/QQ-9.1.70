package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.common.app.AppInterface;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.widget.CommentEllipsizeLayout;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.eh;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002noB\u0007\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0017\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J&\u0010\"\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0(H\u0002J\b\u0010*\u001a\u00020\bH\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020\bH\u0002J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0(H\u0002R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u0016\u0010G\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010?R\u0016\u0010H\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010CR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010NR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010PR\u0016\u0010R\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010CR\u0016\u0010T\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u00107R\u0016\u0010V\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010CR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010XR\u0016\u0010[\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010?R\u0016\u0010\\\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010?R\u0016\u0010]\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010?R\u0018\u0010_\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010SR\u001b\u0010h\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010f\u001a\u0004\bU\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010j\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/a;", "Ljl1/b;", "Landroid/view/View$OnClickListener;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "N", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "guildId", "tinyId", "T", "M", BdhLogUtil.LogTag.Tag_Req, "B", "D", "status", "U", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "O", BdhLogUtil.LogTag.Tag_Conn, "posterId", "V", "", "byteArray", "W", "P", ExifInterface.LATITUDE_SOUTH, "", UserInfo.SEX_FEMALE, "K", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "commentTextContainer", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "commentContainer", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "f", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "avatarIv", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "nickNameTv", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "svipNamePlate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "picTimeTv", "preferCountTv", "preferIv", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "preferContainer", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "preferLottie", "Landroid/view/View;", "picContainer", "picIv", "I", "centerContentContainer", "J", "sendStatusIv", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/widget/CommentEllipsizeLayout;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/widget/CommentEllipsizeLayout;", "nickNameContainer", "L", "roleTv", "authorLabel", "hotOrTopLabel", "Landroid/graphics/drawable/Drawable;", "transparentDrawable", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "preferClickAnimProcess", "preferStatus", "Lwq0/l;", "Lkotlin/Lazy;", "()Lwq0/l;", "txtView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$b;", "gpServiceObserver", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentItemContentSection extends a<jl1.b> implements View.OnClickListener {
    private static final float V = ViewUtils.dpToPx(6.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView preferCountTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView preferIv;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout preferContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private LottieAnimationView preferLottie;

    /* renamed from: G, reason: from kotlin metadata */
    private View picContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView picIv;

    /* renamed from: I, reason: from kotlin metadata */
    private RelativeLayout centerContentContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView sendStatusIv;

    /* renamed from: K, reason: from kotlin metadata */
    private CommentEllipsizeLayout nickNameContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView roleTv;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView authorLabel;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView hotOrTopLabel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Drawable transparentDrawable;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean preferClickAnimProcess;

    /* renamed from: R, reason: from kotlin metadata */
    private int preferStatus;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final b gpServiceObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout commentTextContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout commentContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarViewWithPendant avatarIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView svipNamePlate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView picTimeTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onGuildMemberClientIdentityUpdate", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "sectionWeak", "section", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<CommentItemContentSection> sectionWeak;

        public b(@NotNull CommentItemContentSection section) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.sectionWeak = new WeakReference<>(section);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildMemberClientIdentityUpdate(@Nullable String guildId, @Nullable String tinyId) {
            CommentItemContentSection commentItemContentSection = this.sectionWeak.get();
            if (commentItemContentSection != null) {
                commentItemContentSection.T(guildId, tinyId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$d", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements View.OnLongClickListener {
        d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@Nullable View v3) {
            EventCollector.getInstance().onViewLongClickedBefore(v3);
            CommentItemContentSection commentItemContentSection = CommentItemContentSection.this;
            boolean z16 = false;
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && ((jl1.b) ((Section) commentItemContentSection).mData).getSendStatus() == 0) {
                vl1.a p16 = commentItemContentSection.p();
                if (p16 != null) {
                    Object mData = ((Section) commentItemContentSection).mData;
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    p16.A6((hl1.g) mData, ((Section) commentItemContentSection).mPosition);
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(v3);
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0096\u0001J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\b\u0010\u001f\u001a\u00020\nH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", "", "g", "i", "j", tl.h.F, "u", "o", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "r", "k", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f220928b = IParseRichTextConfig.INSTANCE.a();

        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f220928b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f220928b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f220928b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f220928b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f220928b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f220928b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f220928b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            rl1.a aVar = (rl1.a) SectionIOCKt.getIocInterface(CommentItemContentSection.this, rl1.a.class);
            if (aVar != null) {
                return aVar.getTraceId();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f220928b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f220928b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f220928b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f220928b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f220928b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f220928b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return this.f220928b.getF221022d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f220928b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Set<Integer> r() {
            Set<Integer> of5;
            of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 2, 5});
            return of5;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return 2;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f220928b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f220928b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f220928b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f220928b.a(t16);
        }
    }

    public CommentItemContentSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<wq0.l>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.CommentItemContentSection$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wq0.l invoke() {
                View view;
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                view = ((Section) CommentItemContentSection.this).mRootView;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                return bVar.b(context);
            }
        });
        this.txtView = lazy;
        this.gpServiceObserver = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        LinearLayout linearLayout;
        Map map;
        GProStComment commentData;
        LinearLayout linearLayout2 = this.preferContainer;
        String str = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            linearLayout = null;
        } else {
            linearLayout = linearLayout2;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        map = MapsKt__MapsKt.toMap(G());
        com.tencent.mobileqq.guild.feed.report.d.d(linearLayout, "em_sgrp_comment_like", clickPolicy, exposurePolicy, endExposurePolicy, map);
        LinearLayout linearLayout3 = this.preferContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            linearLayout3 = null;
        }
        jl1.b bVar = (jl1.b) this.mData;
        if (bVar != null && (commentData = bVar.getCommentData()) != null) {
            str = commentData.idd;
        }
        VideoReport.setElementReuseIdentifier(linearLayout3, str);
    }

    private final void B(jl1.b data) {
        Object firstOrNull;
        View view = this.picContainer;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picContainer");
            view = null;
        }
        view.setVisibility(8);
        ArrayList<GProStImage> arrayList = data.getCommentData().richContents.images;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.commentData.richContents.images");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        GProStImage gProStImage = (GProStImage) firstOrNull;
        if (gProStImage != null) {
            View view2 = this.picContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picContainer");
                view2 = null;
            }
            boolean z16 = false;
            view2.setVisibility(0);
            TextView textView = this.picTimeTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picTimeTv");
                textView = null;
            }
            ol1.b bVar = ol1.b.f423088a;
            String w3 = ax.w(data.getCommentData().createTime * 1000);
            Intrinsics.checkNotNullExpressionValue(w3, "getFeedTimeFormat(data.c\u2026ntData.createTime * 1000)");
            if (data.getSendStatus() == 0) {
                z16 = true;
            }
            View view3 = this.picContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picContainer");
                view3 = null;
            }
            Context context = view3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "picContainer.context");
            textView.setText(bVar.g(w3, z16, context));
            Option obtain = Option.obtain();
            ImageView imageView2 = this.picIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picIv");
                imageView2 = null;
            }
            Option targetView = obtain.setTargetView(imageView2);
            ImageView imageView3 = this.picIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picIv");
                imageView3 = null;
            }
            Context context2 = imageView3.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "picIv.context");
            Option url = targetView.setLoadingDrawable(H(context2)).setUrl(gProStImage.picUrl);
            ImageView imageView4 = this.picIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picIv");
                imageView4 = null;
            }
            Option requestHeight = url.setRequestHeight(imageView4.getHeight());
            ImageView imageView5 = this.picIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picIv");
            } else {
                imageView = imageView5;
            }
            com.tencent.mobileqq.guild.picload.e.a().f(requestHeight.setRequestWidth(imageView.getWidth()).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565), ol1.d.b());
        }
    }

    private final void C(jl1.b data) {
        boolean z16;
        String str;
        TextView textView = this.nickNameTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
            textView = null;
        }
        textView.setText(data.getCommentData().postUser.nick);
        W(ig1.a.d(data.getCommentData().postUser), data.getCommentData().postUser.idd);
        String str2 = data.getCommentData().postUser.manageTag.tagName;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            TextView textView3 = this.roleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleTv");
                textView3 = null;
            }
            textView3.setText(data.getCommentData().postUser.manageTag.tagName);
            textView3.setBackground(ol1.b.f423088a.b(data.getCommentData().postUser.manageTag.color | (-16777216)));
            textView3.setVisibility(0);
        }
        String str3 = data.getCommentData().postUser.idd;
        vl1.a p16 = p();
        if (p16 != null) {
            str = p16.r();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str3, str)) {
            TextView textView4 = this.authorLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorLabel");
                textView4 = null;
            }
            textView4.setText("\u4f5c\u8005");
            ol1.b bVar = ol1.b.f423088a;
            TextView textView5 = this.authorLabel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorLabel");
                textView5 = null;
            }
            Context context = textView5.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "authorLabel.context");
            textView4.setBackground(bVar.c(context));
            textView4.setVisibility(0);
        }
        if (jl1.c.b(data)) {
            TextView textView6 = this.hotOrTopLabel;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.hotOrTopLabel;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
                textView7 = null;
            }
            textView7.setText("\u7f6e\u9876");
            TextView textView8 = this.hotOrTopLabel;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
                textView8 = null;
            }
            TextView textView9 = this.hotOrTopLabel;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
                textView9 = null;
            }
            textView8.setTextColor(textView9.getResources().getColor(R.color.qui_common_text_secondary));
            TextView textView10 = this.hotOrTopLabel;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
                textView10 = null;
            }
            ol1.b bVar2 = ol1.b.f423088a;
            TextView textView11 = this.authorLabel;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorLabel");
            } else {
                textView2 = textView11;
            }
            Context context2 = textView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "authorLabel.context");
            textView10.setBackground(bVar2.c(context2));
        }
    }

    private final void D(jl1.b data) {
        int color;
        TextView textView = this.preferCountTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
            textView = null;
        }
        textView.setText(String.valueOf(data.getCommentData().likeInfo.count));
        if (data.getCommentData().likeInfo.status == 1) {
            TextView textView3 = this.preferCountTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
                textView3 = null;
            }
            color = textView3.getResources().getColor(R.color.qui_common_text_primary);
        } else {
            TextView textView4 = this.preferCountTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
                textView4 = null;
            }
            color = textView4.getResources().getColor(R.color.qui_common_text_secondary_light);
        }
        TextView textView5 = this.preferCountTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
            textView5 = null;
        }
        textView5.setTextColor(color);
        if (data.getCommentData().likeInfo.count <= 0) {
            TextView textView6 = this.preferCountTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
            } else {
                textView2 = textView6;
            }
            textView2.setVisibility(4);
        } else {
            TextView textView7 = this.preferCountTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferCountTv");
            } else {
                textView2 = textView7;
            }
            textView2.setVisibility(0);
        }
        int i3 = data.getCommentData().likeInfo.status;
        this.preferStatus = i3;
        U(i3);
    }

    private final Map<String, Object> F() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_type", (short) 1);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, Object> G() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_type", (short) 1);
        linkedHashMap.put("sgrp_state", Integer.valueOf(((jl1.b) this.mData).getCommentData().likeInfo.status));
        String str = ((jl1.b) this.mData).getCommentData().idd;
        Intrinsics.checkNotNullExpressionValue(str, "mData.commentData.idd");
        linkedHashMap.put("sgrp_target_comment_id", str);
        return linkedHashMap;
    }

    private final Drawable H(Context context) {
        if (this.transparentDrawable == null) {
            this.transparentDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.f162601b70, null);
        }
        return this.transparentDrawable;
    }

    private final wq0.l J() {
        return (wq0.l) this.txtView.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        final String guildId;
        AppInterface appInterface;
        if (this.preferClickAnimProcess) {
            return;
        }
        GProStLike gProStLike = ((jl1.b) this.mData).getCommentData().likeInfo;
        Intrinsics.checkNotNullExpressionValue(gProStLike, "mData.commentData.likeInfo");
        GProStLike a16 = ll1.b.a(gProStLike);
        int i3 = this.preferStatus;
        IRuntimeService iRuntimeService = null;
        if (i3 == 0) {
            ((jl1.b) this.mData).getCommentData().likeInfo.count++;
            ((jl1.b) this.mData).getCommentData().likeInfo.status = 1;
            this.preferClickAnimProcess = true;
            ImageView imageView = this.preferIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferIv");
                imageView = null;
            }
            imageView.setVisibility(4);
            LottieAnimationView lottieAnimationView = this.preferLottie;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(0);
            LottieAnimationView lottieAnimationView2 = this.preferLottie;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.playAnimation();
        } else {
            ((jl1.b) this.mData).getCommentData().likeInfo.count--;
            ((jl1.b) this.mData).getCommentData().likeInfo.status = 0;
        }
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        D((jl1.b) mData);
        vl1.a p16 = p();
        if (p16 != null) {
            int i16 = this.mPosition;
            T mData2 = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData2, "mData");
            p16.G7(i16, (hl1.g) mData2, a16);
        }
        LinearLayout linearLayout = this.preferContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            linearLayout = null;
        }
        Map<String, Object> G = G();
        G.put("sgrp_action_result", Integer.valueOf(i3));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("dt_clck", linearLayout, G);
        vl1.a p17 = p();
        if (p17 != null && (guildId = p17.getGuildId()) != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                iGPSService.setGuildListTop(guildId, 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.b
                    @Override // wh2.eh
                    public final void a(int i17, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                        CommentItemContentSection.L(guildId, i17, str, iGProGuildListSortInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(String this_apply, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Logger.f235387a.d().i("CommentItemContentSection", 1, "setGuildListTop end. with guildId=" + this_apply + " code=" + i3 + " errMsg=" + str);
    }

    private final void M() {
        LottieAnimationView lottieAnimationView = this.preferLottie;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
            lottieAnimationView = null;
        }
        lottieAnimationView.setVisibility(4);
        LottieAnimationView lottieAnimationView3 = this.preferLottie;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.setAnimation("feed/feed_item/list_prefer_clicked_anim.json");
        LottieAnimationView lottieAnimationView4 = this.preferLottie;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
            lottieAnimationView4 = null;
        }
        lottieAnimationView4.setImageAssetsFolder("feed/feed_item/prefer_images/");
        au auVar = au.f223851a;
        LottieAnimationView lottieAnimationView5 = this.preferLottie;
        if (lottieAnimationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
            lottieAnimationView5 = null;
        }
        RelativeLayout relativeLayout = this.commentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
            relativeLayout = null;
        }
        auVar.i(lottieAnimationView5, relativeLayout.getContext().getResources().getColor(R.color.qui_common_text_secondary_light));
        LottieAnimationView lottieAnimationView6 = this.preferLottie;
        if (lottieAnimationView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
        } else {
            lottieAnimationView2 = lottieAnimationView6;
        }
        lottieAnimationView2.addAnimatorListener(new c());
    }

    private final void O() {
        TextView textView = this.roleTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleTv");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.authorLabel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorLabel");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = this.hotOrTopLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotOrTopLabel");
            textView3 = null;
        }
        textView3.setVisibility(8);
        ImageView imageView2 = this.sendStatusIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendStatusIv");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    private final void P(jl1.b data) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        String key = data.getCommentData().idd;
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = data.getCommentData().richContents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.commentData.richContents.contents");
        e eVar = new e();
        vl1.a p16 = p();
        FrameLayout frameLayout = null;
        if (p16 != null) {
            str = p16.getChannelId();
        } else {
            str = null;
        }
        vl1.a p17 = p();
        if (p17 != null) {
            str2 = p17.getGuildId();
        } else {
            str2 = null;
        }
        Pair<? extends SpannableStringBuilder, ? extends MovementMethod> s16 = FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, eVar, str, str2, 1, null);
        boolean z18 = true;
        if (((CharSequence) s16.getFirst()).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<GProStImage> arrayList2 = data.getCommentData().richContents.images;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            s16.getFirst().append((CharSequence) " ");
            String timeStr = ax.w(data.getCommentData().createTime * 1000);
            SpannableStringBuilder first = s16.getFirst();
            ol1.b bVar = ol1.b.f423088a;
            Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
            if (data.getSendStatus() != 0) {
                z18 = false;
            }
            RelativeLayout relativeLayout = this.commentContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
                relativeLayout = null;
            }
            Context context = relativeLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "commentContainer.context");
            first.append(bVar.g(timeStr, z18, context));
            key = ((Object) key) + timeStr + data.getSendStatus();
        }
        if (z16) {
            S(data);
        } else {
            ol1.b bVar2 = ol1.b.f423088a;
            RelativeLayout relativeLayout2 = this.commentContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
                relativeLayout2 = null;
            }
            Context context2 = relativeLayout2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "commentContainer.context");
            bVar2.a(context2, data.getSendStatus(), s16);
        }
        if (!TextUtils.isEmpty(s16.getFirst())) {
            wq0.l J = J();
            SpannableStringBuilder first2 = s16.getFirst();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            J.f(first2, key);
            l.a.a(J(), (com.tencent.aio.widget.textView.view.b) s16.getSecond(), false, 2, null);
            J().getView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentItemContentSection.Q(CommentItemContentSection.this, view);
                }
            });
            J().getView().setOnLongClickListener(new d());
            if (J().getView().getParent() == null) {
                FrameLayout frameLayout2 = this.commentTextContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commentTextContainer");
                    frameLayout2 = null;
                }
                frameLayout2.addView(J().getView());
            }
            l.a.a(J(), (com.tencent.aio.widget.textView.view.b) s16.getSecond(), false, 2, null);
            return;
        }
        FrameLayout frameLayout3 = this.commentTextContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTextContainer");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Q(CommentItemContentSection this$0, View view) {
        GProStComment commentData;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        jl1.b bVar = (jl1.b) this$0.mData;
        if (bVar != null && (commentData = bVar.getCommentData()) != null) {
            if (((jl1.b) this$0.mData).getSendStatus() != 0) {
                vl1.a p16 = this$0.p();
                if (p16 != null) {
                    T mData = this$0.mData;
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    p16.q6((hl1.g) mData, this$0.mPosition);
                }
            } else {
                vl1.a p17 = this$0.p();
                if (p17 != null) {
                    p17.H1(new ReplyCommentArgs(1, commentData, null, Integer.valueOf(this$0.mPosition), false, 16, null));
                }
            }
            VideoReport.reportEvent("dt_clck", this$0.J(), this$0.F());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R() {
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.avatarIv;
        ImageView imageView = null;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            guildUserAvatarViewWithPendant = null;
        }
        guildUserAvatarViewWithPendant.setOnClickListener(this);
        LinearLayout linearLayout = this.preferContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        TextView textView = this.nickNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        ImageView imageView2 = this.picIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picIv");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(this);
    }

    private final void S(jl1.b data) {
        ImageView imageView = this.sendStatusIv;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendStatusIv");
            imageView = null;
        }
        ol1.b bVar = ol1.b.f423088a;
        int sendStatus = data.getSendStatus();
        RelativeLayout relativeLayout2 = this.commentContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "commentContainer.context");
        imageView.setImageDrawable(bVar.e(sendStatus, context));
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void T(String guildId, String tinyId) {
        if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(tinyId)) {
            T t16 = this.mData;
            if (t16 != 0) {
                String str = ((jl1.b) t16).getCommentData().postUser.idd;
                if (!Intrinsics.areEqual(str, tinyId)) {
                    if (QLog.isDebugVersion()) {
                        QLog.d("CommentItemContentSection", 1, "ClientIdentityUpdate: posterId:" + str + " tinyId:" + tinyId);
                        return;
                    }
                    return;
                }
                V(guildId, tinyId, str);
                return;
            }
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("CommentItemContentSection", 1, "ClientIdentityUpdate: " + guildId + " " + tinyId);
        }
    }

    private final void U(int status) {
        ImageView imageView = null;
        if (status != 0) {
            if (status == 1) {
                ImageView imageView2 = this.preferIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferIv");
                    imageView2 = null;
                }
                ImageView imageView3 = this.preferIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferIv");
                } else {
                    imageView = imageView3;
                }
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "preferIv.context");
                imageView2.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_native_comment_item_up_vote_icon_active, Integer.valueOf(R.color.qui_common_feedback_error)));
                return;
            }
            return;
        }
        ImageView imageView4 = this.preferIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferIv");
        } else {
            imageView = imageView4;
        }
        imageView.setImageResource(R.drawable.guild_feed_native_item_up_vote_icon_token_normal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V(String guildId, String tinyId, String posterId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProClientIdentity guildUserClientIdentity;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Object obj = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (guildUserClientIdentity = iGPSService.getGuildUserClientIdentity(guildId, posterId)) != null) {
            ArrayList<GProIdentityWithClientId> defaultIdentitys = com.tencent.guild.aio.util.h.f112401a.F(guildUserClientIdentity).getDefaultIdentitys();
            Intrinsics.checkNotNullExpressionValue(defaultIdentitys, "GuildMsgListUtils.tranIG\u2026   .getDefaultIdentitys()");
            Iterator<T> it = defaultIdentitys.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((GProIdentityWithClientId) next).getIdentitys().identityType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            GProIdentityWithClientId gProIdentityWithClientId = (GProIdentityWithClientId) obj;
            if (gProIdentityWithClientId != null) {
                if (QLog.isDebugVersion()) {
                    QLog.d("CommentItemContentSection", 1, "ClientIdentityUpdate: feedPosterId:" + posterId + " tinyId:" + tinyId);
                }
                T t16 = this.mData;
                if (t16 != 0) {
                    ((jl1.b) t16).getCommentData().postUser.channelUserInfo.clientIdentityBytes = com.tencent.guild.aio.util.h.f112401a.F(guildUserClientIdentity);
                }
                W(gProIdentityWithClientId.getIdentitys().thirdPartyData, posterId);
            }
        }
    }

    private final void W(byte[] byteArray, String posterId) {
        ImageView imageView = this.svipNamePlate;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("svipNamePlate");
            imageView = null;
        }
        imageView.setVisibility(8);
    }

    private final void z(jl1.b data) {
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.avatarIv;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            guildUserAvatarViewWithPendant = null;
        }
        String str = data.getCommentData().postUser.icon.iconUrl;
        Intrinsics.checkNotNullExpressionValue(str, "data.commentData.postUser.icon.iconUrl");
        String str2 = data.getCommentData().postUser.avatarPendant;
        Intrinsics.checkNotNullExpressionValue(str2, "data.commentData.postUser.avatarPendant");
        guildUserAvatarViewWithPendant.setUrl(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull jl1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        O();
        B(data);
        z(data);
        C(data);
        P(data);
        D(data);
        A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w7y};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        Object firstOrNull;
        vl1.a p16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (((jl1.b) this.mData).getSendStatus() == 0) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            boolean z17 = false;
            if ((num != null && num.intValue() == R.id.w86) || (num != null && num.intValue() == R.id.f165481w81)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || (num != null && num.intValue() == R.id.f165482w82)) {
                z17 = true;
            }
            if (z17) {
                vl1.a p17 = p();
                if (p17 != null) {
                    String str = ((jl1.b) this.mData).getCommentData().postUser.idd;
                    Intrinsics.checkNotNullExpressionValue(str, "mData.commentData.postUser.idd");
                    long j3 = ((jl1.b) this.mData).getCommentData().postUser.uin;
                    String str2 = ((jl1.b) this.mData).getCommentData().idd;
                    Intrinsics.checkNotNullExpressionValue(str2, "mData.commentData.idd");
                    p17.U8(v3, str, j3, 1, str2, "", ((jl1.b) this.mData).getCommonInfo().getItemGroupPosition());
                }
            } else if (num != null && num.intValue() == R.id.w89) {
                K();
            } else if (num != null && num.intValue() == R.id.w8f) {
                ArrayList<GProStImage> arrayList = ((jl1.b) this.mData).getCommentData().richContents.images;
                Intrinsics.checkNotNullExpressionValue(arrayList, "mData.commentData.richContents.images");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                GProStImage gProStImage = (GProStImage) firstOrNull;
                if (gProStImage != null && (p16 = p()) != null) {
                    String str3 = ((jl1.b) this.mData).getCommentData().idd;
                    Intrinsics.checkNotNullExpressionValue(str3, "mData.commentData.idd");
                    Context context = v3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "v.context");
                    p16.N6(gProStImage, str3, "", context);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.gpServiceObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165483w83);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026t_item_content_container)");
        this.commentContainer = (RelativeLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w8c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ment_item_text_container)");
        this.commentTextContainer = (FrameLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f165481w81);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026feed_comment_item_avatar)");
        this.avatarIv = (GuildUserAvatarViewWithPendant) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.w86);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026d_comment_item_nick_name)");
        this.nickNameTv = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.w8b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ment_item_svip_nameplate)");
        this.svipNamePlate = (ImageView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.w8_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026omment_item_prefer_count)");
        this.preferCountTv = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.w88);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026feed_comment_item_prefer)");
        this.preferIv = (ImageView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.w_c);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026item_bottom_up_vote_anim)");
        this.preferLottie = (LottieAnimationView) findViewById8;
        View findViewById9 = containerView.findViewById(R.id.w89);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026nt_item_prefer_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById9;
        this.preferContainer = linearLayout;
        IRuntimeService iRuntimeService = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            linearLayout = null;
        }
        yl1.n.f(linearLayout, 16.0f);
        View findViewById10 = containerView.findViewById(R.id.w8f);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026uild_feed_comment_pic_iv)");
        this.picIv = (ImageView) findViewById10;
        View findViewById11 = containerView.findViewById(R.id.w8e);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026d_feed_comment_item_time)");
        this.picTimeTv = (TextView) findViewById11;
        View findViewById12 = containerView.findViewById(R.id.w8n);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewBy\u2026mment_item_pic_container)");
        this.picContainer = findViewById12;
        View findViewById13 = containerView.findViewById(R.id.w87);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "containerView.findViewBy\u2026item_nick_name_container)");
        this.nickNameContainer = (CommentEllipsizeLayout) findViewById13;
        View findViewById14 = containerView.findViewById(R.id.w8a);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "containerView.findViewBy\u2026d_feed_comment_item_role)");
        this.roleTv = (TextView) findViewById14;
        View findViewById15 = containerView.findViewById(R.id.f165480w80);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "containerView.findViewBy\u2026omment_item_author_label)");
        this.authorLabel = (TextView) findViewById15;
        View findViewById16 = containerView.findViewById(R.id.w85);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "containerView.findViewBy\u2026d_comment_item_hot_label)");
        this.hotOrTopLabel = (TextView) findViewById16;
        View findViewById17 = containerView.findViewById(R.id.w7x);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "containerView.findViewBy\u2026d_feed_comment_container)");
        this.centerContentContainer = (RelativeLayout) findViewById17;
        View findViewById18 = containerView.findViewById(R.id.w8g);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "containerView.findViewBy\u2026feed_comment_send_status)");
        this.sendStatusIv = (ImageView) findViewById18;
        R();
        M();
        ImageViewPorterDuffUtils imageViewPorterDuffUtils = ImageViewPorterDuffUtils.f235385a;
        ImageView imageView = this.picIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picIv");
            imageView = null;
        }
        imageViewPorterDuffUtils.c(imageView);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpServiceObserver);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/CommentItemContentSection$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            LottieAnimationView lottieAnimationView = CommentItemContentSection.this.preferLottie;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferLottie");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(4);
            ImageView imageView2 = CommentItemContentSection.this.preferIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferIv");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            CommentItemContentSection.this.preferClickAnimProcess = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
