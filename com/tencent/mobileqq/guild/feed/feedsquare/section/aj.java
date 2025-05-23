package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareMediaRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareMediaRoomUpdateEvent;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMaskView;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001fB\u0007\u00a2\u0006\u0004\bc\u0010dJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0003J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0014J*\u0010(\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\t2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0017J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00103\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030100j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000301`2H\u0016R\u0014\u00106\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010=\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010L\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010@R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010@R\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010TR\u0016\u0010W\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010@R\u0016\u0010Y\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010GR\u0016\u0010[\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010GR\u0016\u0010\\\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010GR\u0016\u0010^\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010GR\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/aj;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k;", "mediaRoomItemData", "", "V", "k0", "", "resId", "g0", "i0", "e0", "", "url", "themeType", "Y", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c0", "j0", "X", "", NodeProps.VISIBLE, "log", "W", "m0", "l0", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "position", "", "", "payload", "M", "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "e", "I", "userIconSize", "f", "userIconOutSize", tl.h.F, "userIconMarginEnd", "i", "Z", "currentIsVisible", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "contentTv", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "imgView", "D", "Landroid/view/View;", "statusContainer", "E", "emptyStatusContainer", UserInfo.SEX_FEMALE, "statusTv", "Lcom/airbnb/lottie/LottieAnimationView;", "G", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "H", "roomNameTv", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "memberContainer", "J", "memberNumTv", "K", "memberNumIcon", "L", "logoView", "screenShareTopMask", "N", "screenShareBottomMask", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMaskView;", "P", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMaskView;", "activeShadow", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aj extends GuildFeedSquareFeedBaseSection implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView imgView;

    /* renamed from: D, reason: from kotlin metadata */
    private View statusContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private View emptyStatusContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView statusTv;

    /* renamed from: G, reason: from kotlin metadata */
    private LottieAnimationView lottieView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView roomNameTv;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout memberContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView memberNumTv;

    /* renamed from: K, reason: from kotlin metadata */
    private View memberNumIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private View logoView;

    /* renamed from: M, reason: from kotlin metadata */
    private View screenShareTopMask;

    /* renamed from: N, reason: from kotlin metadata */
    private View screenShareBottomMask;

    /* renamed from: P, reason: from kotlin metadata */
    private GuildHomeActiveChannelMaskView activeShadow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int userIconSize = ViewUtils.dpToPx(34.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int userIconOutSize = ViewUtils.dpToPx(40.0f);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int userIconMarginEnd = ViewUtils.dpToPx(10.0f);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean currentIsVisible;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView contentTv;

    /* JADX WARN: Multi-variable type inference failed */
    private final void V(GuildFeedSquareMediaRoomItemData mediaRoomItemData) {
        String str;
        boolean z16;
        String str2;
        String str3 = null;
        if (mediaRoomItemData != null) {
            str = mediaRoomItemData.getChannelId();
        } else {
            str = null;
        }
        if (mediaRoomItemData != null) {
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !Intrinsics.areEqual(str, "0")) {
                this.mRootView.setVisibility(0);
                TextView textView = this.roomNameTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roomNameTv");
                    textView = null;
                }
                IGProChannelInfo B = ch.B(str);
                if (B != null) {
                    str2 = B.getChannelName();
                } else {
                    str2 = null;
                }
                if (str2 == null || str2.length() == 0) {
                    z17 = true;
                }
                if (true ^ z17) {
                    str3 = str2;
                }
                if (str3 == null) {
                    str3 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b().channelInfo.name;
                }
                textView.setText(str3);
                i0(mediaRoomItemData);
                e0(mediaRoomItemData);
                j0(mediaRoomItemData);
                k0(mediaRoomItemData);
                if (QLog.isDevelopLevel()) {
                    QLog.d(v(), 4, "themeType:" + mediaRoomItemData.getThemeType());
                    return;
                }
                return;
            }
        }
        QLog.e(v(), 1, "onBindData, but audioRsp is invalid, channelId:" + str);
        this.mRootView.setVisibility(8);
    }

    private final void W(boolean visible, String log) {
        l0(visible);
        m0(visible);
        if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
            QLog.d(v(), 4, "changeAnimStatus:" + log + ", visible:" + visible);
        }
    }

    private final String X(int themeType) {
        int i3;
        if (themeType != 2) {
            if (themeType != 4) {
                if (themeType != 6) {
                    if (themeType != 7) {
                        i3 = R.string.f157771nt;
                    } else {
                        i3 = R.string.f157821ny;
                    }
                } else {
                    i3 = R.string.f157811nx;
                }
            } else {
                i3 = R.string.f157801nw;
            }
        } else {
            i3 = R.string.f157791nv;
        }
        String qqStr = HardCodeUtil.qqStr(i3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(resource)");
        return qqStr;
    }

    private final void Y(String url, int themeType) {
        boolean z16;
        if (themeType != 4 && themeType != 6) {
            z16 = false;
        } else {
            z16 = true;
        }
        View view = null;
        if (z16) {
            ImageView imageView = this.imgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
                imageView = null;
            }
            int measuredWidth = imageView.getMeasuredWidth();
            ImageView imageView2 = this.imgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
            } else {
                view = imageView2;
            }
            com.tencent.mobileqq.guild.util.v.f(url, measuredWidth, view.getMeasuredHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.af
                @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
                public final void a(Bitmap bitmap) {
                    aj.Z(aj.this, bitmap);
                }
            });
            return;
        }
        ImageView imageView3 = this.imgView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView3 = null;
        }
        com.tencent.mobileqq.guild.util.v.l(url, imageView3, null, 4, null);
        GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this.activeShadow;
        if (guildHomeActiveChannelMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeShadow");
        } else {
            view = guildHomeActiveChannelMaskView;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(final aj this$0, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bitmap != null) {
            ImageView imageView = this$0.imgView;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
                imageView = null;
            }
            imageView.setImageDrawable(new BitmapDrawable(bitmap));
            ImageView imageView3 = this$0.imgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
            } else {
                imageView2 = imageView3;
            }
            imageView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ag
                @Override // java.lang.Runnable
                public final void run() {
                    aj.a0(aj.this, bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final aj this$0, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ah
            @Override // java.lang.Runnable
            public final void run() {
                aj.b0(aj.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(aj this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0(bitmap);
    }

    @WorkerThread
    private final void c0(Bitmap bitmap) {
        final int e16 = GuildBannerPalette.e(bitmap);
        ImageView imageView = this.imgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView = null;
        }
        imageView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ai
            @Override // java.lang.Runnable
            public final void run() {
                aj.d0(aj.this, e16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(aj this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this$0.activeShadow;
        GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView2 = null;
        if (guildHomeActiveChannelMaskView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeShadow");
            guildHomeActiveChannelMaskView = null;
        }
        guildHomeActiveChannelMaskView.a(i3);
        GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView3 = this$0.activeShadow;
        if (guildHomeActiveChannelMaskView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeShadow");
        } else {
            guildHomeActiveChannelMaskView2 = guildHomeActiveChannelMaskView3;
        }
        guildHomeActiveChannelMaskView2.setVisibility(0);
    }

    private final void e0(GuildFeedSquareMediaRoomItemData mediaRoomItemData) {
        boolean z16;
        View view = null;
        if (mediaRoomItemData.getThemeType() == 7) {
            View view2 = this.screenShareTopMask;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShareTopMask");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.screenShareBottomMask;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShareBottomMask");
                view3 = null;
            }
            view3.setVisibility(0);
        } else {
            View view4 = this.screenShareTopMask;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShareTopMask");
                view4 = null;
            }
            view4.setVisibility(8);
            View view5 = this.screenShareBottomMask;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShareBottomMask");
                view5 = null;
            }
            view5.setVisibility(8);
        }
        String coverUrl = mediaRoomItemData.getCoverUrl();
        if (coverUrl != null && coverUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ImageView imageView = this.imgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
                imageView = null;
            }
            imageView.setImageDrawable(null);
            View view6 = this.logoView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoView");
                view6 = null;
            }
            view6.setVisibility(0);
            GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this.activeShadow;
            if (guildHomeActiveChannelMaskView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeShadow");
            } else {
                view = guildHomeActiveChannelMaskView;
            }
            view.setVisibility(8);
            return;
        }
        Y(coverUrl, mediaRoomItemData.getThemeType());
        View view7 = this.logoView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoView");
        } else {
            view = view7;
        }
        view.setVisibility(8);
    }

    private final void g0(int resId) {
        Context context = this.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        LinearLayout linearLayout = null;
        GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = new GuildHomeActiveChannelMicAvatarView(context, null, 2, null);
        guildHomeActiveChannelMicAvatarView.f(this.userIconSize, this.userIconOutSize);
        guildHomeActiveChannelMicAvatarView.setTag(v());
        guildHomeActiveChannelMicAvatarView.setDefaultImageView(resId);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(this.userIconMarginEnd);
        LinearLayout linearLayout2 = this.memberContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.addView(guildHomeActiveChannelMicAvatarView, layoutParams);
    }

    private final void i0(GuildFeedSquareMediaRoomItemData mediaRoomItemData) {
        String valueOf;
        IGProChannelInfo iGProChannelInfo = null;
        View view = null;
        if (mediaRoomItemData.getChannelMemberCount() == 0) {
            TextView textView = this.memberNumTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberNumTv");
                textView = null;
            }
            textView.setVisibility(8);
            View view2 = this.memberNumIcon;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberNumIcon");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        TextView textView2 = this.memberNumTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberNumTv");
            textView2 = null;
        }
        boolean z16 = false;
        textView2.setVisibility(0);
        View view3 = this.memberNumIcon;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberNumIcon");
            view3 = null;
        }
        view3.setVisibility(0);
        int channelMemberCount = mediaRoomItemData.getChannelMemberCount();
        if (channelMemberCount > 999) {
            valueOf = "999+";
        } else {
            valueOf = String.valueOf(channelMemberCount);
        }
        TextView textView3 = this.memberNumTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberNumTv");
            textView3 = null;
        }
        IGProChannelInfo B = ch.B(mediaRoomItemData.getChannelId());
        if (B != null) {
            if (1 != B.getNoMemberMaxLimited() && B.getChannelMemberMax() > 0) {
                z16 = true;
            }
            if (z16) {
                iGProChannelInfo = B;
            }
            if (iGProChannelInfo != null) {
                String str = valueOf + "/" + iGProChannelInfo.getChannelMemberMax();
                if (str != null) {
                    valueOf = str;
                }
            }
        }
        textView3.setText(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v21, types: [android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j0(GuildFeedSquareMediaRoomItemData mediaRoomItemData) {
        int i3;
        LottieAnimationView lottieAnimationView;
        LottieAnimationView lottieAnimationView2 = null;
        if (mediaRoomItemData.getChannelMemberCount() == 0) {
            LottieAnimationView lottieAnimationView3 = this.lottieView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.cancelAnimation();
            View view = this.statusContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusContainer");
                view = null;
            }
            view.setVisibility(8);
            ?? r85 = this.emptyStatusContainer;
            if (r85 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyStatusContainer");
            } else {
                lottieAnimationView2 = r85;
            }
            lottieAnimationView2.setVisibility(0);
            return;
        }
        View view2 = this.statusContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusContainer");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.emptyStatusContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStatusContainer");
            view3 = null;
        }
        view3.setVisibility(8);
        TextView textView = this.statusTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusTv");
            textView = null;
        }
        textView.setText(X(mediaRoomItemData.getThemeType()));
        if (mediaRoomItemData.getThemeType() == 7) {
            LottieAnimationView lottieAnimationView4 = this.lottieView;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView4 = null;
            }
            lottieAnimationView4.setImageResource(R.drawable.guild_top_screen_icon);
            LottieAnimationView lottieAnimationView5 = this.lottieView;
            if (lottieAnimationView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView5 = null;
            }
            lottieAnimationView5.cancelAnimation();
            LottieAnimationView lottieAnimationView6 = this.lottieView;
            if (lottieAnimationView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView2 = lottieAnimationView6;
            }
            lottieAnimationView2.setTag(-100, Boolean.FALSE);
            return;
        }
        LottieAnimationView lottieAnimationView7 = this.lottieView;
        if (lottieAnimationView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView7 = null;
        }
        lottieAnimationView7.setImageDrawable(null);
        LottieAnimationView lottieAnimationView8 = this.lottieView;
        if (lottieAnimationView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView8 = null;
        }
        lottieAnimationView8.setTag(-100, Boolean.TRUE);
        int themeType = mediaRoomItemData.getThemeType();
        if (themeType != 2) {
            if (themeType != 4) {
                if (themeType != 6) {
                    i3 = R.string.f1487310d;
                }
            } else {
                i3 = R.string.f1487510f;
            }
            lottieAnimationView = this.lottieView;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setAnimation(HardCodeUtil.qqStr(i3));
            if (!this.currentIsVisible) {
                LottieAnimationView lottieAnimationView9 = this.lottieView;
                if (lottieAnimationView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                } else {
                    lottieAnimationView2 = lottieAnimationView9;
                }
                lottieAnimationView2.playAnimation();
                return;
            }
            return;
        }
        i3 = R.string.f1487210c;
        lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
        }
        lottieAnimationView.setAnimation(HardCodeUtil.qqStr(i3));
        if (!this.currentIsVisible) {
        }
    }

    private final void k0(GuildFeedSquareMediaRoomItemData mediaRoomItemData) {
        List<GuildFeedSquareMediaRoomItemData.User> take;
        m0(false);
        LinearLayout linearLayout = this.memberContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        if (mediaRoomItemData.getChannelMemberCount() == 0) {
            g0(R.drawable.guild_audio_empty_avatar);
            return;
        }
        List<GuildFeedSquareMediaRoomItemData.User> g16 = mediaRoomItemData.g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (((GuildFeedSquareMediaRoomItemData.User) obj).getIsMicOpening()) {
                arrayList.add(obj);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, 6);
        for (GuildFeedSquareMediaRoomItemData.User user : take) {
            Context context = this.mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = new GuildHomeActiveChannelMicAvatarView(context, null, 2, null);
            guildHomeActiveChannelMicAvatarView.setTag(v());
            GuildHomeActiveChannelMicAvatarView.AvatarInfo avatarInfo = new GuildHomeActiveChannelMicAvatarView.AvatarInfo(mediaRoomItemData.getGuildId(), user.getTinyId(), user.getAvatarMeta(), user.getIsMicOpening());
            guildHomeActiveChannelMicAvatarView.f(this.userIconSize, this.userIconOutSize);
            guildHomeActiveChannelMicAvatarView.g(avatarInfo);
            if (this.currentIsVisible) {
                guildHomeActiveChannelMicAvatarView.e();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginEnd(this.userIconMarginEnd);
            LinearLayout linearLayout2 = this.memberContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
                linearLayout2 = null;
            }
            linearLayout2.addView(guildHomeActiveChannelMicAvatarView, layoutParams);
        }
        if (take.isEmpty()) {
            g0(R.drawable.guild_audio_user_default);
        }
    }

    private final void l0(boolean visible) {
        LottieAnimationView lottieAnimationView = this.lottieView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView = null;
        }
        if (!Intrinsics.areEqual(lottieAnimationView.getTag(-100), Boolean.TRUE)) {
            return;
        }
        if (visible) {
            LottieAnimationView lottieAnimationView3 = this.lottieView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView2 = lottieAnimationView3;
            }
            lottieAnimationView2.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView4 = this.lottieView;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
        } else {
            lottieAnimationView2 = lottieAnimationView4;
        }
        lottieAnimationView2.cancelAnimation();
    }

    private final void m0(boolean visible) {
        GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView;
        LinearLayout linearLayout = this.memberContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.memberContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
                linearLayout2 = null;
            }
            View childAt = linearLayout2.getChildAt(i3);
            if (childAt instanceof GuildHomeActiveChannelMicAvatarView) {
                guildHomeActiveChannelMicAvatarView = (GuildHomeActiveChannelMicAvatarView) childAt;
            } else {
                guildHomeActiveChannelMicAvatarView = null;
            }
            if (guildHomeActiveChannelMicAvatarView != null) {
                if (visible) {
                    guildHomeActiveChannelMicAvatarView.e();
                } else {
                    guildHomeActiveChannelMicAvatarView.b();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    @SuppressLint({"SetTextI18n"})
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GuildFeedSquareMediaRoomItemData guildFeedSquareMediaRoomItemData;
        if (data != null && (blockData = data.getBlockData()) != null) {
            Object d16 = blockData.d(blockData.m());
            ImageView imageView = null;
            if (d16 instanceof GuildFeedSquareMediaRoomItemData) {
                guildFeedSquareMediaRoomItemData = (GuildFeedSquareMediaRoomItemData) d16;
            } else {
                guildFeedSquareMediaRoomItemData = null;
            }
            V(guildFeedSquareMediaRoomItemData);
            ImageView imageView2 = this.imgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
            } else {
                imageView = imageView2;
            }
            A(imageView, "em_sgrp_voice_single_card");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedSquareMediaRoomUpdateEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.waw};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (!attached) {
            W(false, "onAttachedChanged");
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        W(false, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w_i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d_feed_item_card_content)");
        this.contentTv = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w_k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ild_feed_item_card_image)");
        ImageView imageView = (ImageView) findViewById2;
        this.imgView = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView = null;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView3 = this.imgView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setBackgroundResource(R.drawable.guild_home_active_channel_audio_normal_bg);
        View findViewById3 = containerView.findViewById(R.id.w_u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ed_item_card_status_root)");
        this.statusContainer = findViewById3;
        View findViewById4 = containerView.findViewById(R.id.w_j);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026d_item_card_empty_status)");
        this.emptyStatusContainer = findViewById4;
        View findViewById5 = containerView.findViewById(R.id.w_s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ld_feed_item_card_status)");
        this.statusTv = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.w_n);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_item_card_lottie_status)");
        this.lottieView = (LottieAnimationView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.w_r);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026feed_item_card_room_name)");
        this.roomNameTv = (TextView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.w_o);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026em_card_member_container)");
        this.memberContainer = (LinearLayout) findViewById8;
        View findViewById9 = containerView.findViewById(R.id.w_q);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026eed_item_card_member_num)");
        this.memberNumTv = (TextView) findViewById9;
        View findViewById10 = containerView.findViewById(R.id.w_p);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026ed_item_card_member_icon)");
        this.memberNumIcon = findViewById10;
        View findViewById11 = containerView.findViewById(R.id.w_m);
        findViewById11.setAlpha(0.08f);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026also { it.alpha = 0.08f }");
        this.logoView = findViewById11;
        View findViewById12 = containerView.findViewById(R.id.w_v);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewBy\u2026eed_item_card_top_shadow)");
        this.screenShareTopMask = findViewById12;
        View findViewById13 = containerView.findViewById(R.id.w_h);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "containerView.findViewBy\u2026_item_card_bottom_shadow)");
        this.screenShareBottomMask = findViewById13;
        View findViewById14 = containerView.findViewById(R.id.w_f);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "containerView.findViewBy\u2026ed_item_card_active_mask)");
        this.activeShadow = (GuildHomeActiveChannelMaskView) findViewById14;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar;
        ij1.g blockData;
        if ((event instanceof GuildFeedSquareMediaRoomUpdateEvent) && (hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData) != null && (blockData = hVar.getBlockData()) != null) {
            GuildFeedSquareMediaRoomUpdateEvent guildFeedSquareMediaRoomUpdateEvent = (GuildFeedSquareMediaRoomUpdateEvent) event;
            if (Intrinsics.areEqual(blockData.b().idd, guildFeedSquareMediaRoomUpdateEvent.getFeedId())) {
                V(guildFeedSquareMediaRoomUpdateEvent.getItemData());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        this.currentIsVisible = visible;
        W(visible, "onVisibleChanged");
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareMediaContentSection";
    }
}
