package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.animator.CircleWaveView;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVoiceData;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.main.adapterdelegates.LottieAnimationViewEx;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.avatar.meta.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0010H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/bc;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVoiceData;", "Lcom/tencent/guild/aio/util/ex/c;", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "view", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "color", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "y", "", NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mBg", "f", "mBlurBg", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "mAvatarContainerView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "i", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "mAvatarLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAvatarRight", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView;", "mWaveLeft", "D", "mWaveRight", "E", "Landroid/view/View;", "mAvatarLeftBg", UserInfo.SEX_FEMALE, "mAvatarRightBg", "G", "mIconBg", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "voiceTitle", "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", "I", "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", "mIconLottie", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bc extends ar<RecommendVoiceData> implements com.tencent.guild.aio.util.ex.c {
    private static final int K = Color.parseColor("#B7B5FF");
    private static final int L = Color.parseColor("#72AAFF");
    private static final int M = Color.parseColor("#007EB9");
    private static boolean N;
    private static boolean P;
    private static int Q;
    private static boolean R;

    /* renamed from: C, reason: from kotlin metadata */
    private CircleWaveView mWaveLeft;

    /* renamed from: D, reason: from kotlin metadata */
    private CircleWaveView mWaveRight;

    /* renamed from: E, reason: from kotlin metadata */
    private View mAvatarLeftBg;

    /* renamed from: F, reason: from kotlin metadata */
    private View mAvatarRightBg;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mIconBg;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView voiceTitle;

    /* renamed from: I, reason: from kotlin metadata */
    private LottieAnimationViewEx mIconLottie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mBlurBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAvatarContainerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView mAvatarLeft;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView mAvatarRight;

    private final void A(CircleWaveView view) {
        view.setVisibility(0);
        view.setWaveSize(CircleWaveView.WaveSize.SMALL);
        view.setWaveColor(CircleWaveView.WaveColor.WHITE);
        QQProAvatarView qQProAvatarView = this.mAvatarLeft;
        QQProAvatarView qQProAvatarView2 = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLeft");
            qQProAvatarView = null;
        }
        view.setAvatarSize(qQProAvatarView.getLayoutParams().width);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        QQProAvatarView qQProAvatarView3 = this.mAvatarLeft;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLeft");
        } else {
            qQProAvatarView2 = qQProAvatarView3;
        }
        layoutParams.width = qQProAvatarView2.getLayoutParams().width + ((int) cw.d(20));
        view.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(final int color) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.bb
            @Override // java.lang.Runnable
            public final void run() {
                bc.x(bc.this, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(bc this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mBlurBg;
        QQProAvatarView qQProAvatarView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurBg");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this$0.mBlurBg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurBg");
            imageView2 = null;
        }
        imageView2.setBackground(GuildUIUtils.f235378a.k(i3, xy2.b.m(i3, 25), 255));
        if (R) {
            OvalShape ovalShape = new OvalShape();
            QQProAvatarView qQProAvatarView2 = this$0.mAvatarRight;
            if (qQProAvatarView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
                qQProAvatarView2 = null;
            }
            float width = qQProAvatarView2.getWidth();
            QQProAvatarView qQProAvatarView3 = this$0.mAvatarRight;
            if (qQProAvatarView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
                qQProAvatarView3 = null;
            }
            ovalShape.resize(width, qQProAvatarView3.getHeight());
            ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
            shapeDrawable.getPaint().setColor(i3);
            QQProAvatarView qQProAvatarView4 = this$0.mAvatarRight;
            if (qQProAvatarView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
            } else {
                qQProAvatarView = qQProAvatarView4;
            }
            qQProAvatarView.setBackground(shapeDrawable);
        }
    }

    private final void z(String url) {
        if (!TextUtils.isEmpty(url)) {
            d.Companion companion = vg1.d.INSTANCE;
            ImageView imageView = this.mBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBg");
                imageView = null;
            }
            companion.k(url, imageView.getWidth(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        QLog.d("RecommendVoiceSection", 1, "RecommendVoiceSection onClick guildId: " + ((RecommendVoiceData) this.mData).getGuildId() + " channelId: " + ((RecommendVoiceData) this.mData).getChannelId() + " joinSig: " + ((RecommendVoiceData) this.mData).getJoinSig());
        Pair<String, String> b16 = r().b(((RecommendVoiceData) this.mData).getItemType());
        String component1 = b16.component1();
        String component2 = b16.component2();
        String valueOf = String.valueOf(((RecommendVoiceData) this.mData).getGuildId());
        String valueOf2 = String.valueOf(((RecommendVoiceData) this.mData).getChannelId());
        byte[] joinSig = ((RecommendVoiceData) this.mData).getJoinSig();
        Intrinsics.checkNotNullExpressionValue(joinSig, "mData.joinSig");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf, valueOf2, new String(joinSig, Charsets.UTF_8), component1, component2);
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        GuildJumpUtil.n(context, jumpGuildParam);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        CircleWaveView circleWaveView = this.mWaveLeft;
        CircleWaveView circleWaveView2 = null;
        if (circleWaveView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWaveLeft");
            circleWaveView = null;
        }
        circleWaveView.C();
        CircleWaveView circleWaveView3 = this.mWaveRight;
        if (circleWaveView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWaveRight");
        } else {
            circleWaveView2 = circleWaveView3;
        }
        circleWaveView2.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f71363ny);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.recommend_live_bg)");
            this.mBg = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f71383o0);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d.recommend_live_blur_bg)");
            this.mBlurBg = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.wvq);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ild_recommend_right_icon)");
            this.mIconLottie = (LottieAnimationViewEx) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f71583oj);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026d.recommend_voice_avatar)");
            this.mAvatarContainerView = (LinearLayout) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.w6y);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_recommend_voice_avatar1)");
            this.mAvatarLeft = (QQProAvatarView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.f165475w70);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_recommend_voice_avatar2)");
            this.mAvatarRight = (QQProAvatarView) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.f165477w72);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026mmend_voice_wave_avatar1)");
            this.mWaveLeft = (CircleWaveView) findViewById7;
            View findViewById8 = containerView.findViewById(R.id.f165478w73);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026mmend_voice_wave_avatar2)");
            this.mWaveRight = (CircleWaveView) findViewById8;
            View findViewById9 = containerView.findViewById(R.id.w6z);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026commend_voice_avatar1_bg)");
            this.mAvatarLeftBg = findViewById9;
            View findViewById10 = containerView.findViewById(R.id.f165476w71);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026commend_voice_avatar2_bg)");
            this.mAvatarRightBg = findViewById10;
            View findViewById11 = containerView.findViewById(R.id.f71373nz);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026d.recommend_live_bg_icon)");
            this.mIconBg = (ImageView) findViewById11;
            View findViewById12 = containerView.findViewById(R.id.wmc);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewById(R.id.guild_live_desc)");
            this.voiceTitle = (TextView) findViewById12;
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            ViewExtKt.b(rootView, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        CircleWaveView circleWaveView = null;
        if (visible) {
            LottieAnimationViewEx lottieAnimationViewEx = this.mIconLottie;
            if (lottieAnimationViewEx == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                lottieAnimationViewEx = null;
            }
            lottieAnimationViewEx.playAnimation();
            if (N) {
                CircleWaveView circleWaveView2 = this.mWaveLeft;
                if (circleWaveView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWaveLeft");
                    circleWaveView2 = null;
                }
                A(circleWaveView2);
            }
            if (P) {
                CircleWaveView circleWaveView3 = this.mWaveRight;
                if (circleWaveView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWaveRight");
                } else {
                    circleWaveView = circleWaveView3;
                }
                A(circleWaveView);
                return;
            }
            return;
        }
        LottieAnimationViewEx lottieAnimationViewEx2 = this.mIconLottie;
        if (lottieAnimationViewEx2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx2 = null;
        }
        lottieAnimationViewEx2.pauseAnimation();
        if (N) {
            CircleWaveView circleWaveView4 = this.mWaveLeft;
            if (circleWaveView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWaveLeft");
                circleWaveView4 = null;
            }
            circleWaveView4.C();
        }
        if (P) {
            CircleWaveView circleWaveView5 = this.mWaveRight;
            if (circleWaveView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWaveRight");
            } else {
                circleWaveView = circleWaveView5;
            }
            circleWaveView.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull RecommendVoiceData data, int position, @Nullable List<Object> payload) {
        String string;
        LottieAnimationViewEx lottieAnimationViewEx;
        LottieAnimationViewEx lottieAnimationViewEx2;
        LottieAnimationViewEx lottieAnimationViewEx3;
        boolean z16;
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        ArrayList<String> memberAvatarList;
        boolean z17;
        View view;
        Boolean valueOf;
        Object orNull;
        Object orNull2;
        boolean z18;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("RecommendVoiceSection", 1, "RecommendVoiceSection data.voiceTitle: " + data.getVoiceTitle() + " data.themeType: " + data.getThemeType() + " data.memberAvatarList: " + data.getMemberAvatarList());
        if (data.getThemeType() == 7) {
            QLog.d("RecommendVoiceSection", 1, "themeType is SCREEN_SHARE");
            return;
        }
        N = false;
        P = false;
        R = false;
        LinearLayout linearLayout = this.mAvatarContainerView;
        QQProAvatarView qQProAvatarView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarContainerView");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        int themeType = data.getThemeType();
        if (themeType != 2) {
            if (themeType != 4) {
                if (themeType != 6) {
                    string = getRootView().getContext().getString(R.string.f152821af);
                }
            } else {
                string = getRootView().getContext().getString(R.string.f152811ae);
            }
            Intrinsics.checkNotNullExpressionValue(string, "when (data.themeType) {\n\u2026ottie_filename)\n        }");
            lottieAnimationViewEx = this.mIconLottie;
            if (lottieAnimationViewEx == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                lottieAnimationViewEx = null;
            }
            lottieAnimationViewEx.setVisibility(0);
            lottieAnimationViewEx2 = this.mIconLottie;
            if (lottieAnimationViewEx2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                lottieAnimationViewEx2 = null;
            }
            lottieAnimationViewEx2.setAnimation(string);
            lottieAnimationViewEx3 = this.mIconLottie;
            if (lottieAnimationViewEx3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                lottieAnimationViewEx3 = null;
            }
            lottieAnimationViewEx3.playAnimation();
            if (data.getThemeType() != 2) {
                com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                ImageView imageView4 = this.mBg;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBg");
                    imageView3 = null;
                } else {
                    imageView3 = imageView4;
                }
                com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView3, "https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png", 0, 0, false, 28, null);
                w(M);
            } else {
                String cover = data.getCover();
                Intrinsics.checkNotNullExpressionValue(cover, "data.cover");
                if (cover.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    com.tencent.mobileqq.guild.discoveryv2.util.d dVar2 = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                    ImageView imageView5 = this.mBg;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBg");
                        imageView2 = null;
                    } else {
                        imageView2 = imageView5;
                    }
                    com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar2, imageView2, data.getCover(), 0, 0, false, 28, null);
                    String cover2 = data.getCover();
                    Intrinsics.checkNotNullExpressionValue(cover2, "data.cover");
                    z(cover2);
                } else {
                    ImageView imageView6 = this.mBg;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBg");
                        imageView6 = null;
                    }
                    imageView6.setBackground(GuildUIUtils.f235378a.k(K, L, 255));
                    ImageView imageView7 = this.mIconBg;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIconBg");
                        imageView7 = null;
                    }
                    imageView7.setVisibility(0);
                    com.tencent.mobileqq.guild.discoveryv2.util.d dVar3 = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                    ImageView imageView8 = this.mIconBg;
                    if (imageView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIconBg");
                        imageView = null;
                    } else {
                        imageView = imageView8;
                    }
                    com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar3, imageView, "https://downv6.qq.com/innovate/guild_mvp_voice_bg_icon.png", 0, 0, false, 28, null);
                }
            }
            textView = this.voiceTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voiceTitle");
                textView = null;
            }
            textView.setText(data.getVoiceTitle());
            memberAvatarList = data.getMemberAvatarList();
            if (memberAvatarList == null && !memberAvatarList.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            view = this.mAvatarLeftBg;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarLeftBg");
                view = null;
            }
            valueOf = Boolean.valueOf(z17);
            view.setVisibility(4);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view)) == null) {
                view.setVisibility(0);
            }
            N = !z17;
            if (!z17) {
                QQProAvatarView qQProAvatarView2 = this.mAvatarLeft;
                if (qQProAvatarView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarLeft");
                } else {
                    qQProAvatarView = qQProAvatarView2;
                }
                qQProAvatarView.setImageResource(R.drawable.guild_audio_user_default);
                return;
            }
            ArrayList<String> memberAvatarList2 = data.getMemberAvatarList();
            Intrinsics.checkNotNullExpressionValue(memberAvatarList2, "data.memberAvatarList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(memberAvatarList2, 0);
            String str = (String) orNull;
            if (str == null) {
                str = "https://downv6.qq.com/innovate/guild/sfeed/mvp_guild_recommend_avatar_default.png";
            }
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            com.tencent.qqnt.avatar.fetch.c cVar = new com.tencent.qqnt.avatar.fetch.c(new b.a(parse, false, 2, (DefaultConstructorMarker) null).a("KEY_BEAN_KEY_SUFFIX", str).b(), null, BaseImageUtil.getDefaultFaceDrawable(), null, false, null, 58, null);
            QQProAvatarView qQProAvatarView3 = this.mAvatarLeft;
            if (qQProAvatarView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarLeft");
                qQProAvatarView3 = null;
            }
            qQProAvatarView3.z(cVar, true);
            ArrayList<String> memberAvatarList3 = data.getMemberAvatarList();
            Intrinsics.checkNotNullExpressionValue(memberAvatarList3, "data.memberAvatarList");
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(memberAvatarList3, 1);
            CharSequence charSequence = (CharSequence) orNull2;
            if (charSequence != null && charSequence.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                View view2 = this.mAvatarRightBg;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarRightBg");
                    view2 = null;
                }
                view2.setVisibility(4);
                QQProAvatarView qQProAvatarView4 = this.mAvatarRight;
                if (qQProAvatarView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
                } else {
                    qQProAvatarView = qQProAvatarView4;
                }
                qQProAvatarView.setVisibility(4);
                R = true;
                return;
            }
            View view3 = this.mAvatarRightBg;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRightBg");
                view3 = null;
            }
            view3.setVisibility(0);
            QQProAvatarView qQProAvatarView5 = this.mAvatarRight;
            if (qQProAvatarView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
                qQProAvatarView5 = null;
            }
            qQProAvatarView5.setVisibility(0);
            QQProAvatarView qQProAvatarView6 = this.mAvatarRight;
            if (qQProAvatarView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarRight");
            } else {
                qQProAvatarView = qQProAvatarView6;
            }
            qQProAvatarView.B(data.getMemberAvatarList().get(1));
            P = true;
            return;
        }
        string = getRootView().getContext().getString(R.string.f152791ac);
        Intrinsics.checkNotNullExpressionValue(string, "when (data.themeType) {\n\u2026ottie_filename)\n        }");
        lottieAnimationViewEx = this.mIconLottie;
        if (lottieAnimationViewEx == null) {
        }
        lottieAnimationViewEx.setVisibility(0);
        lottieAnimationViewEx2 = this.mIconLottie;
        if (lottieAnimationViewEx2 == null) {
        }
        lottieAnimationViewEx2.setAnimation(string);
        lottieAnimationViewEx3 = this.mIconLottie;
        if (lottieAnimationViewEx3 == null) {
        }
        lottieAnimationViewEx3.playAnimation();
        if (data.getThemeType() != 2) {
        }
        textView = this.voiceTitle;
        if (textView == null) {
        }
        textView.setText(data.getVoiceTitle());
        memberAvatarList = data.getMemberAvatarList();
        if (memberAvatarList == null) {
        }
        z17 = true;
        view = this.mAvatarLeftBg;
        if (view == null) {
        }
        valueOf = Boolean.valueOf(z17);
        view.setVisibility(4);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view)) == null) {
        }
        N = !z17;
        if (!z17) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/bc$b", "Lvg1/d$c;", "", "mainColor", "", "c", "", "url", "Landroid/graphics/Bitmap;", "blurBitmap", "a", NodeProps.SHADOW_COLOR, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements d.c {
        b() {
        }

        @Override // vg1.d.c
        public void a(@NotNull String url, @Nullable Bitmap blurBitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // vg1.d.c
        public void b(int shadowColor) {
            bc.Q = shadowColor;
            bc.this.w(bc.Q);
        }

        @Override // vg1.d.c
        public void c(int mainColor) {
        }
    }
}
