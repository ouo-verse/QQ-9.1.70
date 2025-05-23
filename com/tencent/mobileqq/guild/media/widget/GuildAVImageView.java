package com.tencent.mobileqq.guild.media.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b0\u00101B\u001d\b\u0016\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b0\u00104B%\b\u0016\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\u0006\u00105\u001a\u00020 \u00a2\u0006\u0004\b0\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ.\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ8\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0017\u001a\u00020\u0002H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildAVImageView;", "Lcom/tencent/mobileqq/guild/media/widget/GCircleImageView;", "", "t", "w", "u", "Lmqq/app/AppRuntime;", "r", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "p", "v", "faceDrawable", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "picLoadStateListener", "setImageDrawable", "", "guildId", "tinyId", "setAvatarTinyId", "avatarMeta", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "b0", "Ljava/lang/String;", "TAG", "c0", "d0", "e0", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "", "f0", "I", "mNeedSize", "g0", "mAvatarMeta", "Ljava/util/LinkedHashMap;", "h0", "Ljava/util/LinkedHashMap;", "mAvatarSizeMap", "Lcom/tencent/mobileqq/guild/avatar/e;", "i0", "Lcom/tencent/mobileqq/guild/avatar/e;", "mUrlChangeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAVImageView extends GCircleImageView {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tinyId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildPicStateListener picLoadStateListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int mNeedSize;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAvatarMeta;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedHashMap<Integer, Integer> mAvatarSizeMap;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.avatar.e mUrlChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildAVImageView$a", "Lcom/tencent/mobileqq/guild/avatar/e;", "", "guildId", "id", "", "doOnUrlChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.avatar.e {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.avatar.e
        public void doOnUrlChange(@NotNull String guildId, @NotNull String id5) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(id5, "id");
            if (Intrinsics.areEqual(GuildAVImageView.this.tinyId, id5)) {
                GuildAVImageView.this.v();
                if (QLog.isColorLevel()) {
                    QLog.d(GuildAVImageView.this.TAG, 2, "doOnUrlChange mTinyId:", id5);
                }
            }
        }
    }

    public GuildAVImageView(@Nullable Context context) {
        super(context);
        this.TAG = "GuildWavAvatarImageView";
        this.guildId = "0";
        this.mNeedSize = -1;
        this.mAvatarMeta = "";
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new a();
        t();
    }

    private final void o() {
        GuildUserAvatarRepository.f(this.mUrlChangeListener);
    }

    private final void q() {
        GuildUserAvatarRepository.k(this.mUrlChangeListener);
    }

    private final AppRuntime r() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static /* synthetic */ void setAvatarTinyId$default(GuildAVImageView guildAVImageView, String str, String str2, Drawable drawable, GuildPicStateListener guildPicStateListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = null;
        }
        if ((i3 & 8) != 0) {
            guildPicStateListener = null;
        }
        guildAVImageView.setAvatarTinyId(str, str2, drawable, guildPicStateListener);
    }

    private final void t() {
        this.mAvatarSizeMap.put(40, 4);
        this.mAvatarSizeMap.put(100, 3);
        this.mAvatarSizeMap.put(140, 0);
        this.mAvatarSizeMap.put(640, 1);
        this.mAvatarSizeMap.put(1024, 2);
    }

    @SuppressLint({"WrongConstant"})
    private final void u() {
        IGPSService iGPSService;
        boolean z16;
        String fullGuildUserUserAvatarUrl;
        AppRuntime r16 = r();
        String str = null;
        String str2 = "";
        if (r16 != null) {
            iGPSService = (IGPSService) r16.getRuntimeService(IGPSService.class, "");
        } else {
            iGPSService = null;
        }
        boolean z17 = true;
        if (this.mAvatarMeta.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (iGPSService != null) {
                str = iGPSService.getFullAvatarUrl(new cw(this.tinyId, this.mAvatarMeta), this.mNeedSize);
            }
            if (str != null) {
                str2 = str;
            }
        } else if (iGPSService != null && (fullGuildUserUserAvatarUrl = iGPSService.getFullGuildUserUserAvatarUrl(this.guildId, this.tinyId, this.mNeedSize)) != null) {
            str2 = fullGuildUserUserAvatarUrl;
        }
        if (str2.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            com.tencent.mobileqq.guild.discover.b.INSTANCE.d(this, str2, this.picLoadStateListener);
        }
    }

    private final void w() {
        int intValue;
        int i3 = -1;
        if (getLayoutParams() == null) {
            Integer num = this.mAvatarSizeMap.get(140);
            if (num != null) {
                i3 = num.intValue();
            }
            this.mNeedSize = i3;
            QLog.e(this.TAG, 1, "setAvatarNeedSize getLayoutParams is null");
            return;
        }
        int i16 = getLayoutParams().width;
        Iterator<Integer> it = this.mAvatarSizeMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Integer size = it.next();
            Intrinsics.checkNotNullExpressionValue(size, "size");
            if (i16 < size.intValue()) {
                Integer num2 = this.mAvatarSizeMap.get(size);
                if (num2 == null) {
                    intValue = -1;
                } else {
                    intValue = num2.intValue();
                }
                this.mNeedSize = intValue;
            }
        }
        if (this.mNeedSize == -1) {
            Integer num3 = this.mAvatarSizeMap.get(1024);
            if (num3 != null) {
                i3 = num3.intValue();
            }
            this.mNeedSize = i3;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
        this.guildId = null;
        this.tinyId = null;
    }

    public final void p(@Nullable Drawable defaultDrawable) {
        q();
        setImageDrawable(defaultDrawable);
        this.guildId = null;
        this.tinyId = null;
        this.mAvatarMeta = "";
    }

    public final void setAvatarTinyId(@NotNull String guildId, @NotNull String tinyId, @Nullable Drawable defaultDrawable, @Nullable GuildPicStateListener picLoadStateListener) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        setAvatarTinyId(guildId, tinyId, "", defaultDrawable, picLoadStateListener);
    }

    public final void setImageDrawable(@Nullable Drawable faceDrawable, @Nullable GuildPicStateListener picLoadStateListener) {
        BitmapDrawable bitmapDrawable;
        setImageDrawable(faceDrawable);
        if (faceDrawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) faceDrawable;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable == null) {
            return;
        }
        new Option().setResultBitMap(bitmapDrawable.getBitmap());
        if (picLoadStateListener != null) {
            picLoadStateListener.onStateChange(LoadState.STATE_SUCCESS, new Option());
        }
    }

    public final void v() {
        String str = this.guildId;
        if (str == null) {
            str = "0";
        }
        String str2 = str;
        String str3 = this.tinyId;
        if (str3 == null) {
            str3 = "";
        }
        setAvatarTinyId(str2, str3, this.mAvatarMeta, null, this.picLoadStateListener);
    }

    public static /* synthetic */ void setAvatarTinyId$default(GuildAVImageView guildAVImageView, String str, String str2, String str3, Drawable drawable, GuildPicStateListener guildPicStateListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        guildAVImageView.setAvatarTinyId(str, str2, str3, (i3 & 8) != 0 ? null : drawable, (i3 & 16) != 0 ? null : guildPicStateListener);
    }

    public final void setAvatarTinyId(@NotNull String guildId, @NotNull String tinyId, @NotNull String avatarMeta, @Nullable Drawable defaultDrawable, @Nullable GuildPicStateListener picLoadStateListener) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        this.picLoadStateListener = picLoadStateListener;
        if (TextUtils.isEmpty(tinyId)) {
            QLog.w(this.TAG, 1, "tinyId empty");
            setImageDrawable(BaseImageUtil.getDefaultFaceDrawable(), picLoadStateListener);
            return;
        }
        p(defaultDrawable);
        this.guildId = guildId;
        this.tinyId = tinyId;
        this.mAvatarMeta = avatarMeta;
        o();
        if (this.mNeedSize == -1) {
            w();
        }
        u();
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "loadImage tinyId\uff1a", tinyId, " mNeedSize:", Integer.valueOf(this.mNeedSize), " hashCode:", Integer.valueOf(hashCode()));
        }
    }

    public GuildAVImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "GuildWavAvatarImageView";
        this.guildId = "0";
        this.mNeedSize = -1;
        this.mAvatarMeta = "";
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new a();
        t();
    }

    public GuildAVImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.TAG = "GuildWavAvatarImageView";
        this.guildId = "0";
        this.mNeedSize = -1;
        this.mAvatarMeta = "";
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.mUrlChangeListener = new a();
        t();
    }
}
