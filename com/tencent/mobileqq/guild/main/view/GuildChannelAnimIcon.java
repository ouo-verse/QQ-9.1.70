package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.view.a;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.theme.e;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0003K\f\"B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\b\b\u0002\u0010G\u001a\u00020E\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001b\u001a\u00020\u0005H\u0014J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0011J\b\u0010\u001e\u001a\u00020\u0005H\u0014J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R\u0016\u0010.\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/theme/d;", "Landroid/content/Context;", "context", "", "f", "e", "j", "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$a;", "iconInfo", "Lcom/tencent/mobileqq/guild/main/view/a;", "b", "d", "Lcom/tencent/mobileqq/guild/main/view/BackgroundColor;", "backgroundColor", "g", "", "isPlay", "i", "Lcom/tencent/mobileqq/guild/main/view/a$c;", "normalIconIconType", h.F, "Lcom/tencent/mobileqq/guild/theme/a;", "channelAnimIconStyleProvider", "setChannelAnimIconStyleProvider", "k", NodeProps.ON_ATTACHED_TO_WINDOW, "animateEnable", "setAnimateEnable", NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "setIvInactiveIcon", "(Landroid/widget/ImageView;)V", "ivInactiveIcon", "Landroid/view/ViewStub;", "Landroid/view/ViewStub;", "activeContainerStub", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "laActiveHotAnim", "Landroid/widget/FrameLayout;", "flActiveContainer", "laActiveVoiceAnim", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tvActiveTip", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$a;", "D", "Lcom/tencent/mobileqq/guild/main/view/a;", "channelIconType", "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$c;", "E", "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$c;", "lottieDrawable", UserInfo.SEX_FEMALE, "Z", "hasInflated", "G", "H", "Lcom/tencent/mobileqq/guild/theme/a;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelAnimIcon extends FrameLayout implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ChannelAnimIconInfo iconInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a channelIconType;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c lottieDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasInflated;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean animateEnable;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.theme.a channelAnimIconStyleProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView ivInactiveIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewStub activeContainerStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView laActiveHotAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flActiveContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView laActiveVoiceAnim;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvActiveTip;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\t\u0010\u001aR$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R$\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$a;", "", "", "toString", "other", "", "equals", "", "hashCode", "a", "I", "c", "()I", "channelType", "b", "Z", "f", "()Z", "isChannelStatusActive", "<set-?>", "channelSubId", "d", "e", "voiceState", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "channelName", "g", "specifiedInactiveIcon", h.F, "isHotStatusActive", "<init>", "(IZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.view.GuildChannelAnimIcon$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final class ChannelAnimIconInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int channelType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isChannelStatusActive;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int channelSubId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int voiceState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String channelId = "";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String channelName = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean specifiedInactiveIcon;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isHotStatusActive;

        public ChannelAnimIconInfo(int i3, boolean z16) {
            this.channelType = i3;
            this.isChannelStatusActive = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* renamed from: b, reason: from getter */
        public final int getChannelSubId() {
            return this.channelSubId;
        }

        /* renamed from: c, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getSpecifiedInactiveIcon() {
            return this.specifiedInactiveIcon;
        }

        /* renamed from: e, reason: from getter */
        public final int getVoiceState() {
            return this.voiceState;
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(ChannelAnimIconInfo.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.GuildChannelAnimIcon.ChannelAnimIconInfo");
            ChannelAnimIconInfo channelAnimIconInfo = (ChannelAnimIconInfo) other;
            if (this.channelType == channelAnimIconInfo.channelType && this.isChannelStatusActive == channelAnimIconInfo.isChannelStatusActive && this.channelSubId == channelAnimIconInfo.channelSubId && this.voiceState == channelAnimIconInfo.voiceState && this.specifiedInactiveIcon == channelAnimIconInfo.specifiedInactiveIcon && this.isHotStatusActive == channelAnimIconInfo.isHotStatusActive) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsChannelStatusActive() {
            return this.isChannelStatusActive;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsHotStatusActive() {
            return this.isHotStatusActive;
        }

        public int hashCode() {
            return (((((((((this.channelType * 31) + com.tencent.aio.widget.textView.param.a.a(this.isChannelStatusActive)) * 31) + this.channelSubId) * 31) + this.voiceState) * 31) + com.tencent.aio.widget.textView.param.a.a(this.specifiedInactiveIcon)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isHotStatusActive);
        }

        @NotNull
        public String toString() {
            return "ChannelAnimIconInfo(channelType=" + this.channelType + ", isChannelStatusActive=" + this.isChannelStatusActive + ", channelSubId=" + this.channelSubId + ", voiceState=" + this.voiceState + ", channelId='" + this.channelId + "', channelName='" + this.channelName + "', specifiedInactiveIcon=" + this.specifiedInactiveIcon + ", isHotStatusActive=" + this.isHotStatusActive + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$c;", "Lcom/airbnb/lottie/LottieDrawable;", "", NodeProps.VISIBLE, "restart", "setVisible", "", "d", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "name", "e", "Z", "getAnimateEnable", "()Z", "u", "(Z)V", "animateEnable", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends LottieDrawable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String name;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean animateEnable = true;

        public c() {
            setRepeatCount(-1);
        }

        @Override // com.airbnb.lottie.LottieDrawable, android.graphics.drawable.Drawable
        public boolean setVisible(boolean visible, boolean restart) {
            if (!this.animateEnable) {
                return true;
            }
            if (visible && isVisible() && isAnimating() && isLooping()) {
                return true;
            }
            return super.setVisible(visible, restart);
        }

        public final void u(boolean z16) {
            this.animateEnable = z16;
        }

        public final void v(@Nullable String str) {
            this.name = str;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227212a;

        static {
            int[] iArr = new int[BackgroundColor.values().length];
            try {
                iArr[BackgroundColor.ORANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackgroundColor.PURPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackgroundColor.YELLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f227212a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelAnimIcon(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final a b(ChannelAnimIconInfo iconInfo) {
        if (!iconInfo.getIsChannelStatusActive()) {
            return new a.c(iconInfo.getSpecifiedInactiveIcon(), iconInfo.getChannelType(), iconInfo.getChannelSubId());
        }
        int channelType = iconInfo.getChannelType();
        if (channelType != 2) {
            if (channelType != 5) {
                if (channelType != 8) {
                    return new a.c(iconInfo.getSpecifiedInactiveIcon(), iconInfo.getChannelType(), iconInfo.getChannelSubId());
                }
                return new a.C7822a(R.string.f141650h9, R.string.f142230it, BackgroundColor.YELLOW);
            }
            return new a.C7822a(R.string.f141620h6, R.string.f142030i_, BackgroundColor.ORANGE);
        }
        return d(iconInfo);
    }

    private final a d(ChannelAnimIconInfo iconInfo) {
        int voiceState = iconInfo.getVoiceState();
        if (voiceState != 6) {
            if (voiceState != 9) {
                if (voiceState != 17) {
                    if (voiceState != 18) {
                        return new a.C7822a(R.string.f141590h3, R.string.f142210ir, BackgroundColor.PURPLE);
                    }
                    return new a.C7822a(R.string.f141630h7, R.string.f142160im, BackgroundColor.PURPLE);
                }
                return new a.C7822a(R.string.f141640h8, R.string.f142120ii, BackgroundColor.PURPLE);
            }
            return new a.C7822a(R.string.f141630h7, R.string.f142100ig, BackgroundColor.PURPLE);
        }
        return new a.b(R.drawable.guild_channel_voice_icon_screen_share, R.string.f142190ip, BackgroundColor.PURPLE);
    }

    private final void e() {
        ViewStub viewStub = this.activeContainerStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeContainerStub");
            viewStub = null;
        }
        viewStub.inflate();
        View findViewById = findViewById(R.id.wft);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_fl_active_container)");
        this.flActiveContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.wl8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_la_voice_active_anim)");
        this.laActiveVoiceAnim = (LottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R.id.x2s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_tv_active_tip)");
        this.tvActiveTip = (TextView) findViewById3;
        this.hasInflated = true;
        try {
            Field declaredField = LottieAnimationView.class.getDeclaredField("lottieDrawable");
            declaredField.setAccessible(true);
            LottieAnimationView lottieAnimationView = this.laActiveVoiceAnim;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
                lottieAnimationView = null;
            }
            declaredField.set(lottieAnimationView, this.lottieDrawable);
        } catch (NoSuchFieldException unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("get LottieAnimationView lottieDrawable Field Failed");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Rt.GuildChannelAnimIcon", 1, (String) it.next(), null);
            }
        }
    }

    private final void f(Context context) {
        LayoutInflater.from(context).inflate(R.layout.eho, this);
        View findViewById = findViewById(R.id.wkh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_iv_inactive_icon)");
        setIvInactiveIcon((ImageView) findViewById);
        View findViewById2 = findViewById(R.id.vwl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_active_container_stub)");
        this.activeContainerStub = (ViewStub) findViewById2;
        View findViewById3 = findViewById(R.id.wib);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_hot_channel_icon)");
        this.laActiveHotAnim = (LottieAnimationView) findViewById3;
    }

    private final void g(BackgroundColor backgroundColor) {
        int i3 = d.f227212a[backgroundColor.ordinal()];
        TextView textView = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    com.tencent.mobileqq.guild.theme.a aVar = this.channelAnimIconStyleProvider;
                    FrameLayout frameLayout = this.flActiveContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
                        frameLayout = null;
                    }
                    aVar.d(frameLayout, R.drawable.guild_channel_world_anim_icon_bg);
                    com.tencent.mobileqq.guild.theme.a aVar2 = this.channelAnimIconStyleProvider;
                    TextView textView2 = this.tvActiveTip;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
                    } else {
                        textView = textView2;
                    }
                    aVar2.f(textView, R.drawable.guild_channel_world_anim_icon_bg_bottom);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.guild.theme.a aVar3 = this.channelAnimIconStyleProvider;
            FrameLayout frameLayout2 = this.flActiveContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
                frameLayout2 = null;
            }
            aVar3.d(frameLayout2, R.drawable.guild_channel_voice_anim_icon_bg);
            com.tencent.mobileqq.guild.theme.a aVar4 = this.channelAnimIconStyleProvider;
            TextView textView3 = this.tvActiveTip;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
            } else {
                textView = textView3;
            }
            aVar4.f(textView, R.drawable.guild_channel_voice_anim_icon_bg_bottom);
            return;
        }
        com.tencent.mobileqq.guild.theme.a aVar5 = this.channelAnimIconStyleProvider;
        FrameLayout frameLayout3 = this.flActiveContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
            frameLayout3 = null;
        }
        aVar5.d(frameLayout3, R.drawable.guild_channel_video_anim_icon_bg);
        com.tencent.mobileqq.guild.theme.a aVar6 = this.channelAnimIconStyleProvider;
        TextView textView4 = this.tvActiveTip;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
        } else {
            textView = textView4;
        }
        aVar6.f(textView, R.drawable.guild_channel_video_anim_icon_bg_bottom);
    }

    private final void h(a.c normalIconIconType) {
        if (this.hasInflated) {
            i(false);
            FrameLayout frameLayout = this.flActiveContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(4);
        }
        c().setVisibility(0);
        if (!normalIconIconType.getSpecifiedInactiveIcon()) {
            GuildChannelIconUtil.q(c(), normalIconIconType.getChannelType(), normalIconIconType.getChannelSubId(), this.channelAnimIconStyleProvider.getChannelIconStyleProvider());
        }
    }

    private final void i(boolean isPlay) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildChannelAnimIcon", "updateChannelLottieAnim: isPlay=" + isPlay);
        }
        LottieAnimationView lottieAnimationView = null;
        if (isPlay) {
            LottieAnimationView lottieAnimationView2 = this.laActiveVoiceAnim;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setVisibility(0);
            LottieAnimationView lottieAnimationView3 = this.laActiveVoiceAnim;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
            } else {
                lottieAnimationView = lottieAnimationView3;
            }
            lottieAnimationView.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView4 = this.laActiveVoiceAnim;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
        } else {
            lottieAnimationView = lottieAnimationView4;
        }
        lottieAnimationView.cancelAnimation();
    }

    private final void j() {
        LottieAnimationView lottieAnimationView = null;
        if (this.iconInfo.getIsHotStatusActive()) {
            if (GuildThemeManager.f235286a.b()) {
                LottieAnimationView lottieAnimationView2 = this.laActiveHotAnim;
                if (lottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
                    lottieAnimationView2 = null;
                }
                lottieAnimationView2.setAnimation(getContext().getString(R.string.f141600h4));
            } else {
                LottieAnimationView lottieAnimationView3 = this.laActiveHotAnim;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
                    lottieAnimationView3 = null;
                }
                lottieAnimationView3.setAnimation(getContext().getString(R.string.f141610h5));
            }
            LottieAnimationView lottieAnimationView4 = this.laActiveHotAnim;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
                lottieAnimationView4 = null;
            }
            lottieAnimationView4.setVisibility(0);
            if (this.animateEnable) {
                LottieAnimationView lottieAnimationView5 = this.laActiveHotAnim;
                if (lottieAnimationView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
                } else {
                    lottieAnimationView = lottieAnimationView5;
                }
                lottieAnimationView.playAnimation();
                return;
            }
            LottieAnimationView lottieAnimationView6 = this.laActiveHotAnim;
            if (lottieAnimationView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
            } else {
                lottieAnimationView = lottieAnimationView6;
            }
            lottieAnimationView.cancelAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView7 = this.laActiveHotAnim;
        if (lottieAnimationView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
            lottieAnimationView7 = null;
        }
        lottieAnimationView7.cancelAnimation();
        LottieAnimationView lottieAnimationView8 = this.laActiveHotAnim;
        if (lottieAnimationView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laActiveHotAnim");
        } else {
            lottieAnimationView = lottieAnimationView8;
        }
        lottieAnimationView.setVisibility(8);
    }

    @NotNull
    public final ImageView c() {
        ImageView imageView = this.ivInactiveIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivInactiveIcon");
        return null;
    }

    public final void k(@NotNull ChannelAnimIconInfo iconInfo) {
        Intrinsics.checkNotNullParameter(iconInfo, "iconInfo");
        this.iconInfo = iconInfo;
        this.lottieDrawable.v(iconInfo.getChannelName());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Rt.GuildChannelAnimIcon", 2, "[updateView] iconInfo:" + iconInfo);
        }
        a b16 = b(iconInfo);
        this.channelIconType = b16;
        if (b16 instanceof a.c) {
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.ChannelIconType.NormalIcon");
            h((a.c) b16);
        } else {
            LottieAnimationView lottieAnimationView = null;
            if (b16 instanceof a.b) {
                c().setVisibility(4);
                if (!this.hasInflated) {
                    e();
                }
                FrameLayout frameLayout = this.flActiveContainer;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                a aVar = this.channelIconType;
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.ChannelIconType.LottieImage");
                a.b bVar = (a.b) aVar;
                com.tencent.mobileqq.guild.theme.a aVar2 = this.channelAnimIconStyleProvider;
                TextView textView = this.tvActiveTip;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
                    textView = null;
                }
                aVar2.b(textView);
                TextView textView2 = this.tvActiveTip;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
                    textView2 = null;
                }
                textView2.setText(bVar.getTipsResource());
                g(bVar.getBackgroundColor());
                LottieAnimationView lottieAnimationView2 = this.laActiveVoiceAnim;
                if (lottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
                    lottieAnimationView2 = null;
                }
                lottieAnimationView2.cancelAnimation();
                com.tencent.mobileqq.guild.theme.a aVar3 = this.channelAnimIconStyleProvider;
                LottieAnimationView lottieAnimationView3 = this.laActiveVoiceAnim;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
                } else {
                    lottieAnimationView = lottieAnimationView3;
                }
                aVar3.e(lottieAnimationView, bVar.getIconResource());
            } else if (b16 instanceof a.C7822a) {
                c().setVisibility(4);
                if (!this.hasInflated) {
                    e();
                }
                FrameLayout frameLayout2 = this.flActiveContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flActiveContainer");
                    frameLayout2 = null;
                }
                frameLayout2.setVisibility(0);
                a aVar4 = this.channelIconType;
                Intrinsics.checkNotNull(aVar4, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.ChannelIconType.LottieAnimation");
                a.C7822a c7822a = (a.C7822a) aVar4;
                com.tencent.mobileqq.guild.theme.a aVar5 = this.channelAnimIconStyleProvider;
                TextView textView3 = this.tvActiveTip;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
                    textView3 = null;
                }
                aVar5.b(textView3);
                TextView textView4 = this.tvActiveTip;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvActiveTip");
                    textView4 = null;
                }
                textView4.setText(c7822a.getTipsResource());
                g(c7822a.getBackgroundColor());
                com.tencent.mobileqq.guild.theme.a aVar6 = this.channelAnimIconStyleProvider;
                LottieAnimationView lottieAnimationView4 = this.laActiveVoiceAnim;
                if (lottieAnimationView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laActiveVoiceAnim");
                } else {
                    lottieAnimationView = lottieAnimationView4;
                }
                aVar6.c(lottieAnimationView, c7822a.getLottieResource());
                i(this.animateEnable);
            }
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildThemeManager.g(this);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Rt.GuildChannelAnimIcon", 2, "[onAttachedToWindow] iconInfo:" + this.iconInfo);
        }
        k(this.iconInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildThemeManager.j(this);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Rt.GuildChannelAnimIcon", 2, "[onDetachedFromWindow] iconInfo:" + this.iconInfo);
        }
        if (this.hasInflated) {
            i(false);
        }
        j();
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        j();
    }

    public final void setAnimateEnable(boolean animateEnable) {
        this.animateEnable = animateEnable;
        this.lottieDrawable.u(animateEnable);
        if (animateEnable) {
            k(this.iconInfo);
            return;
        }
        if (this.hasInflated) {
            i(false);
        }
        j();
    }

    public final void setChannelAnimIconStyleProvider(@NotNull com.tencent.mobileqq.guild.theme.a channelAnimIconStyleProvider) {
        Intrinsics.checkNotNullParameter(channelAnimIconStyleProvider, "channelAnimIconStyleProvider");
        if (!Intrinsics.areEqual(this.channelAnimIconStyleProvider, channelAnimIconStyleProvider)) {
            this.channelAnimIconStyleProvider = channelAnimIconStyleProvider;
            k(this.iconInfo);
        }
    }

    public final void setIvInactiveIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivInactiveIcon = imageView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelAnimIcon(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelAnimIcon(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChannelAnimIcon(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelAnimIcon(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconInfo = new ChannelAnimIconInfo(1, false);
        this.lottieDrawable = new c();
        this.animateEnable = true;
        this.channelAnimIconStyleProvider = e.f235301b;
        f(context);
    }
}
