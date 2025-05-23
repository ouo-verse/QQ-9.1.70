package com.tencent.mobileqq.guild.message.directmessage.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)B\u001d\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b(\u0010,B%\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b(\u0010/B-\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b(\u00101J\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildDirectMessageDetailNavBar;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "a", "Lcom/tencent/mobileqq/guild/widget/GuildChannelBaseNavBar$a;", "navBarClickListener", "setNavBarClickListener", "", "peerName", "setPeerName", "guildName", "setSrcGuildName", "", "isVisibility", "setSrcGuildNameVisibility", "setDisturbIconVisibility", "setRobotIconVisibility", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mLeftView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mPeerNameText", "f", "mRobotIcon", tl.h.F, "mSrcGuildNameText", "i", "mDisturbIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/GuildChannelBaseNavBar$a;", "mNavBarClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDirectMessageDetailNavBar extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mLeftView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mPeerNameText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mRobotIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mSrcGuildNameText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mDisturbIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildChannelBaseNavBar.a mNavBarClickListener;

    public GuildDirectMessageDetailNavBar(@Nullable Context context) {
        this(context, null, 0, 0);
    }

    public final void a() {
        View.inflate(getContext(), R.layout.ekf, this);
        View findViewById = findViewById(R.id.w1y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_channel_left_back_tv)");
        ImageView imageView = (ImageView) findViewById;
        this.mLeftView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.f235406p);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.peer_name)");
        this.mPeerNameText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.kab);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_robot)");
        this.mRobotIcon = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f87724v5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.src_guild_name)");
        this.mSrcGuildNameText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.uj7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.disturb_icon)");
        this.mDisturbIcon = (ImageView) findViewById5;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        GuildChannelBaseNavBar.a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.w1y && (aVar = this.mNavBarClickListener) != null) {
            aVar.S9(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setDisturbIconVisibility(boolean isVisibility) {
        int i3;
        ImageView imageView = this.mDisturbIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisturbIcon");
            imageView = null;
        }
        if (isVisibility) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setNavBarClickListener(@NotNull GuildChannelBaseNavBar.a navBarClickListener) {
        Intrinsics.checkNotNullParameter(navBarClickListener, "navBarClickListener");
        this.mNavBarClickListener = navBarClickListener;
    }

    public final void setPeerName(@NotNull String peerName) {
        Intrinsics.checkNotNullParameter(peerName, "peerName");
        TextView textView = this.mPeerNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPeerNameText");
            textView = null;
        }
        textView.setText(peerName);
    }

    public final void setRobotIconVisibility(boolean isVisibility) {
        int i3;
        ImageView imageView = this.mRobotIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotIcon");
            imageView = null;
        }
        if (isVisibility) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setSrcGuildName(@NotNull String guildName) {
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        TextView textView = this.mSrcGuildNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSrcGuildNameText");
            textView = null;
        }
        textView.setText(guildName);
    }

    public final void setSrcGuildNameVisibility(boolean isVisibility) {
        int i3;
        TextView textView = this.mSrcGuildNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSrcGuildNameText");
            textView = null;
        }
        if (isVisibility) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public GuildDirectMessageDetailNavBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public GuildDirectMessageDetailNavBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildDirectMessageDetailNavBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        a();
    }
}
