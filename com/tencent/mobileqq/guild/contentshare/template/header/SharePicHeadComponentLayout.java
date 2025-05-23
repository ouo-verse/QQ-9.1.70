package com.tencent.mobileqq.guild.contentshare.template.header;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.guild.aio.util.ui.RoundBubbleImageView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.contentshare.AnchorInfo;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.contentshare.template.HeaderComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b#\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/header/SharePicHeadComponentLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", "d", "", "timeInMilliSeconds", "", "c", "Lcom/tencent/mobileqq/guild/contentshare/b;", "anchorInfo", "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Landroid/view/View;", "b", "Lcom/tencent/mobileqq/guild/contentshare/template/HeaderComponent$LayoutType;", "layoutType", "f", "e", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "avatarContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "nickTv", "dateDscTv", h.F, "Lcom/tencent/mobileqq/guild/contentshare/d;", "com/tencent/mobileqq/guild/contentshare/template/header/SharePicHeadComponentLayout$b", "i", "Lcom/tencent/mobileqq/guild/contentshare/template/header/SharePicHeadComponentLayout$b;", "gpsObserver", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SharePicHeadComponentLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout avatarContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nickTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView dateDscTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d shareData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gpsObserver;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/contentshare/template/header/SharePicHeadComponentLayout$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onGuildUserAvatarUrlUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@NotNull String guildId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            d dVar = SharePicHeadComponentLayout.this.shareData;
            if (dVar != null) {
                SharePicHeadComponentLayout sharePicHeadComponentLayout = SharePicHeadComponentLayout.this;
                if (Intrinsics.areEqual(dVar.getChannelInfo().getGuildId(), guildId)) {
                    Iterator<T> it = dVar.a().iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((AnchorInfo) it.next()).getUid(), tinyId)) {
                            sharePicHeadComponentLayout.e(dVar);
                            ((IGPSService) VasUtil.getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this);
                        }
                    }
                }
            }
        }
    }

    public SharePicHeadComponentLayout(@Nullable Context context) {
        super(context);
        this.gpsObserver = new b();
        d(context);
    }

    private final View b(AnchorInfo anchorInfo, d shareData) {
        QLog.i("SharePicHeadComponentLayout", 1, "createAvatar senderUid=" + anchorInfo.getUid());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context);
        roundBubbleImageView.setSpace(c.b(3));
        roundBubbleImageView.setMBorderThickness(c.b(3));
        int b16 = c.b(44);
        roundBubbleImageView.setRadiusDP(22.0f);
        roundBubbleImageView.setLayoutParams(new ViewGroup.LayoutParams(b16, b16));
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByTinyId(shareData.getChannelInfo().getGuildId(), anchorInfo.getUid(), b16, roundBubbleImageView);
        return roundBubbleImageView;
    }

    private final String c(long timeInMilliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilliSeconds);
        return calendar.get(1) + "/" + (calendar.get(2) + 1) + "/" + calendar.get(5);
    }

    private final void d(Context context) {
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.f8u, this);
            this.avatarContainer = (LinearLayout) findViewById(R.id.snq);
            this.nickTv = (TextView) findViewById(R.id.sor);
            this.dateDscTv = (TextView) findViewById(R.id.ucc);
        }
    }

    public final void e(@NotNull d shareData) {
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        this.shareData = shareData;
        List<AnchorInfo> a16 = shareData.a();
        QLog.i("SharePicHeadComponentLayout", 1, "updateAnchorInfo size=" + a16.size());
        LinearLayout linearLayout = this.avatarContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        String str = "";
        for (AnchorInfo anchorInfo : a16) {
            View b16 = b(anchorInfo, shareData);
            LinearLayout linearLayout2 = this.avatarContainer;
            if (linearLayout2 != null) {
                linearLayout2.addView(b16);
            }
            str = ((Object) str) + anchorInfo.getNick();
        }
        TextView textView = this.nickTv;
        if (textView != null) {
            textView.setText(str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (shareData.getData() instanceof GuildMsgItem) {
            Object data = shareData.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            currentTimeMillis = TimeUnit.SECONDS.toMillis(((GuildMsgItem) data).getMsgRecord().msgTime);
        } else if (shareData.getData() instanceof IFeedDetailDataParser) {
            Object data2 = shareData.getData();
            Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.api.IFeedDetailDataParser");
            IFeedDetailDataParser iFeedDetailDataParser = (IFeedDetailDataParser) data2;
            if (iFeedDetailDataParser.getCreateTime() > -1) {
                currentTimeMillis = TimeUnit.SECONDS.toMillis(iFeedDetailDataParser.getCreateTime());
            }
        }
        TextView textView2 = this.dateDscTv;
        if (textView2 != null) {
            textView2.setText(c(currentTimeMillis));
        }
    }

    public final void f(@NotNull HeaderComponent.LayoutType layoutType) {
        Object obj;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(layoutType, "layoutType");
        QLog.i("SharePicHeadComponentLayout", 1, "updateLayout layoutType=" + layoutType);
        View findViewById = findViewById(R.id.f95195eb);
        RelativeLayout.LayoutParams layoutParams = null;
        if (findViewById != null) {
            obj = findViewById.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) obj;
        }
        if (layoutType == HeaderComponent.LayoutType.Horizontal) {
            if (layoutParams != null) {
                LinearLayout linearLayout = this.avatarContainer;
                if (linearLayout != null) {
                    i16 = linearLayout.getId();
                } else {
                    i16 = 0;
                }
                layoutParams.addRule(1, i16);
            }
            if (layoutParams != null) {
                layoutParams.removeRule(3);
            }
            if (layoutParams != null) {
                layoutParams.setMargins(c.b(10), 0, 0, 0);
            }
            TextView textView = this.nickTv;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.dateDscTv;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#B3FFFFFF"));
            }
        } else {
            if (layoutParams != null) {
                LinearLayout linearLayout2 = this.avatarContainer;
                if (linearLayout2 != null) {
                    i3 = linearLayout2.getId();
                } else {
                    i3 = 0;
                }
                layoutParams.addRule(3, i3);
            }
            if (layoutParams != null) {
                layoutParams.removeRule(1);
            }
            if (layoutParams != null) {
                layoutParams.setMargins(0, c.b(10), 0, 0);
            }
            TextView textView3 = this.nickTv;
            if (textView3 != null) {
                textView3.setTextColor(-16777216);
            }
            TextView textView4 = this.dateDscTv;
            if (textView4 != null) {
                textView4.setTextColor(Color.parseColor("#999999"));
            }
        }
        if (findViewById != null) {
            findViewById.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((IGPSService) VasUtil.getAppInterface().getRuntimeService(IGPSService.class, "")).addObserver(this.gpsObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((IGPSService) VasUtil.getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this.gpsObserver);
    }

    public SharePicHeadComponentLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpsObserver = new b();
        d(context);
    }
}
