package com.tencent.mobileqq.guild.media.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase;
import com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomRaiseHandUseCase;
import com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentBottomBarPresenter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vs1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001FB'\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J&\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010*R\u001c\u00100\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\n -*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010/\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentBottomBar;", "Landroid/widget/LinearLayout;", "", "o", "", "isMicEnable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "toShow", "", "Landroid/animation/Animator;", "i", DomainData.DOMAIN_NAME, "p", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "micStateViewModel", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter;", "d", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentBottomBarPresenter;", "mBottomBtnPresenter", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase;", "e", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase;", "mBottomRaiseHandUseCase", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase;", "f", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase;", "mBottomInputBarUseCase", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mVoiceMic", "D", "mMoreIv", "", "E", "Ljava/lang/String;", "moreIconType", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mAudioQueueTv", "G", "mAudioQueueManageIv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChannelFragmentBottomBar extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView mVoiceMic;

    /* renamed from: D, reason: from kotlin metadata */
    private final ImageView mMoreIv;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String moreIconType;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView mAudioQueueTv;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView mAudioQueueManageIv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MediaChannelFragmentBottomBarPresenter mBottomBtnPresenter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MediaChannelBottomRaiseHandUseCase mBottomRaiseHandUseCase;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MediaChannelBottomInputBarUseCase mBottomInputBarUseCase;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IGProChannelInfo mChannelInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IGProGuildInfo mGuildInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelFragmentBottomBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<Animator> i(boolean toShow) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        if (toShow) {
            ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        } else if (!toShow) {
            ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ofFloat.setDuration(300L);
        measure(0, 0);
        float measuredHeight = getMeasuredHeight();
        if (toShow) {
            ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", measuredHeight, 0.0f);
        } else if (!toShow) {
            ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", 0.0f, measuredHeight);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ofFloat2.setDuration(300L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final GuildMediaChannelFragmentBottomBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.guild.util.o.b(view, 900L)) {
            QLog.d("QGMC.GuildMediaChannelFragmentBottomBar", 1, "click microphone too fast.");
        } else {
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = this$0.mBottomBtnPresenter;
            if (mediaChannelFragmentBottomBarPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                mediaChannelFragmentBottomBarPresenter = null;
            }
            mediaChannelFragmentBottomBarPresenter.F(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$mVoiceMic$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    GuildMediaChannelFragmentBottomBar.this.m(z16);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean isMicEnable) {
        int i3;
        HashMap hashMap = new HashMap();
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo = null;
        }
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        if (isMicEnable) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.mVoiceMic, hashMap);
    }

    private final void n() {
        HashMap hashMap = new HashMap();
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo = null;
        }
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.mRootView.findViewById(R.id.sx7), "em_sgrp_avchannel_handup", hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementParams(this.mVoiceMic, hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAllPolicy(this.mVoiceMic, "em_sgrp_subchannel_microphone");
    }

    private final void o() {
        this.mMoreIv.setImageResource(R.drawable.guild_media_bottom_more_press);
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.media.core.j.b(), null, null, new GuildMediaChannelFragmentBottomBar$setMoreIv$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        HashMap hashMap = new HashMap();
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo = null;
        }
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        hashMap.put("sgrp_button_type", this.moreIconType);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.mMoreIv, "em_sgrp_avchannel_playmodule", hashMap);
    }

    public final void k(@NotNull Fragment fragment, @NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull com.tencent.mobileqq.guild.media.viewmodel.b micStateViewModel) {
        IGProGuildInfo iGProGuildInfo;
        IGProChannelInfo iGProChannelInfo;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(micStateViewModel, "micStateViewModel");
        this.mGuildInfo = guildInfo;
        this.mChannelInfo = channelInfo;
        WeakReference weakReference = new WeakReference(fragment);
        IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
        IGProChannelInfo iGProChannelInfo2 = null;
        if (iGProGuildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
            iGProGuildInfo = null;
        } else {
            iGProGuildInfo = iGProGuildInfo2;
        }
        IGProChannelInfo iGProChannelInfo3 = this.mChannelInfo;
        if (iGProChannelInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo = null;
        } else {
            iGProChannelInfo = iGProChannelInfo3;
        }
        ImageView mVoiceMic = this.mVoiceMic;
        Intrinsics.checkNotNullExpressionValue(mVoiceMic, "mVoiceMic");
        TextView mAudioQueueTv = this.mAudioQueueTv;
        Intrinsics.checkNotNullExpressionValue(mAudioQueueTv, "mAudioQueueTv");
        ImageView mAudioQueueManageIv = this.mAudioQueueManageIv;
        Intrinsics.checkNotNullExpressionValue(mAudioQueueManageIv, "mAudioQueueManageIv");
        MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = new MediaChannelFragmentBottomBarPresenter(weakReference, iGProGuildInfo, iGProChannelInfo, mVoiceMic, mAudioQueueTv, mAudioQueueManageIv, micStateViewModel);
        this.mBottomBtnPresenter = mediaChannelFragmentBottomBarPresenter;
        mediaChannelFragmentBottomBarPresenter.N();
        View view = this.mRootView;
        IGProGuildInfo iGProGuildInfo3 = this.mGuildInfo;
        if (iGProGuildInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
            iGProGuildInfo3 = null;
        }
        IGProChannelInfo iGProChannelInfo4 = this.mChannelInfo;
        if (iGProChannelInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo4 = null;
        }
        this.mBottomRaiseHandUseCase = new MediaChannelBottomRaiseHandUseCase(view, fragment, iGProGuildInfo3, iGProChannelInfo4);
        View view2 = this.mRootView;
        IGProGuildInfo iGProGuildInfo4 = this.mGuildInfo;
        if (iGProGuildInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
            iGProGuildInfo4 = null;
        }
        IGProChannelInfo iGProChannelInfo5 = this.mChannelInfo;
        if (iGProChannelInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
        } else {
            iGProChannelInfo2 = iGProChannelInfo5;
        }
        this.mBottomInputBarUseCase = new MediaChannelBottomInputBarUseCase(view2, fragment, iGProGuildInfo4, iGProChannelInfo2);
        o();
        n();
    }

    public final void l() {
        MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter = this.mBottomBtnPresenter;
        MediaChannelBottomInputBarUseCase mediaChannelBottomInputBarUseCase = null;
        if (mediaChannelFragmentBottomBarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
            mediaChannelFragmentBottomBarPresenter = null;
        }
        mediaChannelFragmentBottomBarPresenter.O();
        MediaChannelBottomRaiseHandUseCase mediaChannelBottomRaiseHandUseCase = this.mBottomRaiseHandUseCase;
        if (mediaChannelBottomRaiseHandUseCase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomRaiseHandUseCase");
            mediaChannelBottomRaiseHandUseCase = null;
        }
        mediaChannelBottomRaiseHandUseCase.p();
        MediaChannelBottomInputBarUseCase mediaChannelBottomInputBarUseCase2 = this.mBottomInputBarUseCase;
        if (mediaChannelBottomInputBarUseCase2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomInputBarUseCase");
        } else {
            mediaChannelBottomInputBarUseCase = mediaChannelBottomInputBarUseCase2;
        }
        mediaChannelBottomInputBarUseCase.A();
    }

    public final void q(boolean toShow) {
        QLog.i("QGMC.GuildMediaChannelFragmentBottomBar", 1, "[showBottomBarAnim] " + toShow);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(i(toShow));
        animatorSet.start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelFragmentBottomBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildMediaChannelFragmentBottomBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelFragmentBottomBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View i16 = ViewPoolEngine.f228744a.i(e.c.f443291a, context);
        addView(i16, new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.f158982ch2)));
        this.mRootView = i16;
        ImageView imageView = (ImageView) i16.findViewById(R.id.sx9);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaChannelFragmentBottomBar.j(GuildMediaChannelFragmentBottomBar.this, view);
            }
        });
        this.mVoiceMic = imageView;
        this.mMoreIv = (ImageView) i16.findViewById(R.id.swz);
        this.moreIconType = QCircleDaTongConstant.ElementParamValue.PLUS;
        TextView mAudioQueueTv$lambda$3 = (TextView) i16.findViewById(R.id.vzm);
        Intrinsics.checkNotNullExpressionValue(mAudioQueueTv$lambda$3, "mAudioQueueTv$lambda$3");
        jt1.b.b(mAudioQueueTv$lambda$3, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$mAudioQueueTv$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter;
                Intrinsics.checkNotNullParameter(it, "it");
                mediaChannelFragmentBottomBarPresenter = GuildMediaChannelFragmentBottomBar.this.mBottomBtnPresenter;
                if (mediaChannelFragmentBottomBarPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                    mediaChannelFragmentBottomBarPresenter = null;
                }
                mediaChannelFragmentBottomBarPresenter.y();
            }
        });
        this.mAudioQueueTv = mAudioQueueTv$lambda$3;
        ImageView mAudioQueueManageIv$lambda$4 = (ImageView) i16.findViewById(R.id.f164508sx1);
        Intrinsics.checkNotNullExpressionValue(mAudioQueueManageIv$lambda$4, "mAudioQueueManageIv$lambda$4");
        jt1.b.b(mAudioQueueManageIv$lambda$4, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$mAudioQueueManageIv$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter;
                Intrinsics.checkNotNullParameter(it, "it");
                mediaChannelFragmentBottomBarPresenter = GuildMediaChannelFragmentBottomBar.this.mBottomBtnPresenter;
                if (mediaChannelFragmentBottomBarPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                    mediaChannelFragmentBottomBarPresenter = null;
                }
                mediaChannelFragmentBottomBarPresenter.D();
            }
        });
        mAudioQueueManageIv$lambda$4.setImageResource(R.drawable.guild_media_audio_queue_manage);
        this.mAudioQueueManageIv = mAudioQueueManageIv$lambda$4;
    }
}
