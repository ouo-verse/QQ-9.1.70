package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.widget.TraceUtils;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u000256B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ*\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000eJ\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001eJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0011J\u0018\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010(\u001a\u000201H\u0016J\u0016\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u001eR\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarView", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "getAvatarView", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "setAvatarView", "(Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;)V", "imageHeight", "", "imageWidth", "needShowPendant", "", "pendantPadding", "pendantView", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarPendantView;", "getPendantView", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarPendantView;", "setPendantView", "(Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarPendantView;)V", "initView", "", "parentView", "setAvatarImg", "path", "", "setAvatarMeta", "guildId", "tinyId", "avatarMeta", "avatarPendant", "setAvatarSize", "needSize", "setAvatarTinyId", "setLogTag", "tag", "setNeedListenChange", "needListenChange", "setRoundRect", "radius", "setShowPendantView", "showPendantView", "setTag", "key", "", "setUrl", PhotoCategorySummaryInfo.AVATAR_URL, "pendantUrl", "AvatarDynamicParams", "Companion", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildUserAvatarViewWithPendant extends ConstraintLayout {
    public static final float AVATAR_PERCENT = 0.783f;
    public static final int HAS_PENDANT = 1;
    public static final int NOT_HAS_PENDANT = 0;

    @NotNull
    public static final String TAG = "Guild.user.GuildUserAvatarViewWithPendant";
    public GuildUserAvatarView avatarView;
    private int imageHeight;
    private int imageWidth;
    private boolean needShowPendant;
    private int pendantPadding;
    public GuildUserAvatarPendantView pendantView;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant$AvatarDynamicParams;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "viewRef", "Lmqq/util/WeakReference;", "getDynamicParams", "", "", "", "event", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class AvatarDynamicParams implements IDynamicParams {

        @NotNull
        private final WeakReference<View> viewRef;

        public AvatarDynamicParams(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.viewRef = new WeakReference<>(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            Object obj;
            Map<String, Object> mutableMapOf;
            View view = this.viewRef.get();
            if (view != null) {
                obj = view.getTag(R.id.whs);
            } else {
                obj = null;
            }
            if (obj == null) {
                obj = 0;
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_is_personal_head_box", Integer.valueOf(((Integer) obj).intValue())));
            return mutableMapOf;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildUserAvatarViewWithPendant(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(ConstraintLayout parentView) {
        int i3;
        int i16;
        int i17;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        int i18 = this.imageWidth;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i18;
        int i19 = this.imageHeight;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i19;
        int i26 = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        if (i19 == 0) {
            layoutParams.matchConstraintPercentHeight = 0.783f;
        }
        if (i18 == 0) {
            layoutParams.matchConstraintPercentWidth = 0.783f;
        }
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        setAvatarView(new GuildUserAvatarView(parentView.getContext(), null));
        getAvatarView().setId(R.id.a2o);
        parentView.addView(getAvatarView(), layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        int i27 = this.imageWidth;
        int i28 = -1;
        if (i27 != 0 && (i17 = this.pendantPadding) != 0) {
            i3 = i27 + i17 + i17;
        } else {
            i3 = -1;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i3;
        int i29 = this.imageHeight;
        if (i29 != 0 && (i16 = this.pendantPadding) != 0) {
            i28 = i29 + i16 + i16;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i28;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.validate();
        Context context = parentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        setPendantView(new GuildUserAvatarPendantView(context, null));
        getPendantView().setId(R.id.f235506q);
        GuildUserAvatarPendantView pendantView = getPendantView();
        if (!this.needShowPendant) {
            i26 = 8;
        }
        pendantView.setVisibility(i26);
        addView(getPendantView(), layoutParams2);
    }

    public static /* synthetic */ void setAvatarMeta$default(GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str4 = null;
        }
        guildUserAvatarViewWithPendant.setAvatarMeta(str, str2, str3, str4);
    }

    @NotNull
    public final GuildUserAvatarView getAvatarView() {
        GuildUserAvatarView guildUserAvatarView = this.avatarView;
        if (guildUserAvatarView != null) {
            return guildUserAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        return null;
    }

    @NotNull
    public final GuildUserAvatarPendantView getPendantView() {
        GuildUserAvatarPendantView guildUserAvatarPendantView = this.pendantView;
        if (guildUserAvatarPendantView != null) {
            return guildUserAvatarPendantView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pendantView");
        return null;
    }

    public final void setAvatarImg(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        getAvatarView().setImageBitmap(BitmapFactory.decodeFile(new File(path).getAbsolutePath()));
    }

    public final void setAvatarMeta(@NotNull String guildId, @NotNull String tinyId, @NotNull String avatarMeta, @Nullable String avatarPendant) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        TraceUtils.traceBegin("GuildUserAvatarViewWithPendant_setAvatarMeta");
        getAvatarView().setAvatarMeta(guildId, tinyId, avatarMeta);
        TraceUtils.traceEnd();
        TraceUtils.traceBegin("GuildUserAvatarViewWithPendant_setPendantTinyId");
        getPendantView().setPendantTinyId(tinyId, avatarPendant);
        TraceUtils.traceEnd();
    }

    public final void setAvatarSize(int needSize) {
        getAvatarView().setAvatarSize(needSize);
    }

    public final void setAvatarTinyId(@NotNull String guildId, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        getAvatarView().setAvatarTinyId(guildId, tinyId);
        GuildUserAvatarPendantView.setPendantTinyId$default(getPendantView(), tinyId, null, 2, null);
    }

    public final void setAvatarView(@NotNull GuildUserAvatarView guildUserAvatarView) {
        Intrinsics.checkNotNullParameter(guildUserAvatarView, "<set-?>");
        this.avatarView = guildUserAvatarView;
    }

    public final void setLogTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        getAvatarView().setLogTag(tag);
        getPendantView().setLogTag(tag);
    }

    public final void setNeedListenChange(boolean needListenChange) {
        getAvatarView().setNeedListenChange(needListenChange);
    }

    public final void setPendantView(@NotNull GuildUserAvatarPendantView guildUserAvatarPendantView) {
        Intrinsics.checkNotNullParameter(guildUserAvatarPendantView, "<set-?>");
        this.pendantView = guildUserAvatarPendantView;
    }

    public final void setRoundRect(int radius) {
        getAvatarView().setRoundRect(radius);
    }

    public final void setShowPendantView(boolean showPendantView) {
        int i3;
        this.needShowPendant = showPendantView;
        if (this.pendantView != null) {
            GuildUserAvatarPendantView pendantView = getPendantView();
            if (this.needShowPendant) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            pendantView.setVisibility(i3);
        }
    }

    @Override // android.view.View
    public void setTag(int key, @NotNull Object tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.setTag(key, tag);
        getAvatarView().setTag(key, tag);
        getPendantView().setTag(key, tag);
    }

    public final void setUrl(@NotNull String avatarUrl, @NotNull String pendantUrl) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(pendantUrl, "pendantUrl");
        getAvatarView().setUrl(avatarUrl);
        if (!TextUtils.isEmpty(pendantUrl) && this.needShowPendant) {
            getPendantView().setVisibility(0);
            getPendantView().setUrl(pendantUrl);
        } else {
            getPendantView().setVisibility(8);
        }
    }

    public /* synthetic */ GuildUserAvatarViewWithPendant(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildUserAvatarViewWithPendant(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.needShowPendant = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.C1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026serAvatarViewWithPendant)");
        this.imageWidth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.api.j.E1, 0);
        this.imageHeight = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.api.j.D1, 0);
        this.pendantPadding = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.api.j.F1, 0);
        obtainStyledAttributes.recycle();
        initView(this);
        VideoReport.setElementId(this, "em_sgrp_personal_head");
        VideoReport.setEventDynamicParams(this, new AvatarDynamicParams(getPendantView()));
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
    }
}
