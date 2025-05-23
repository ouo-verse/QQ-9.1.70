package com.tencent.mobileqq.guild.main.topchannel.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0007\u0018\u0000 m2\u00020\u0001:\u0001\u000bB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\bk\u0010lJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J(\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\t2\b\b\u0001\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\tR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00102R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00102R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0016\u0010J\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010DR\u0016\u0010L\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010DR\u0016\u0010N\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010DR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00102R\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00102R\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u00102R\u0016\u0010Z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00102R\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u00102R\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u00102R\u0018\u0010`\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010QR\u0018\u0010b\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010QR\u0018\u0010d\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010QR\u0018\u0010f\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010QR\u0018\u0010h\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010QR\u0018\u0010j\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010Q\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/widget/ChannelStatusView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "", "g", "a", "left", "top", "right", "bottom", "setPadding", "start", "end", "setPaddingRelative", "height", "setHeight", "color", "setLottieColorFilter", "type", "setType", "f", "e", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", IECSearchBar.METHOD_SET_TEXT, "(Landroid/widget/TextView;)V", "text", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "b", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", QEffectType.LOTTIE_TAG, "Landroid/view/View;", "Landroid/view/View;", "c", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "root", h.F, "I", "getViewType", "()I", "setViewType", "(I)V", "viewType", "i", "lifecycleStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rootPaddingLeft", BdhLogUtil.LogTag.Tag_Conn, "rootPaddingRight", "D", "rootPaddingTop", "E", "rootPaddingBottom", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "lottieAudioRes", "G", "lottieLiveRes", "H", "lottieWorldRes", "lottieKaiHeiRes", "J", "lottieMusicRes", "K", "lottieGameRes", "Landroid/graphics/drawable/Drawable;", "L", "Landroid/graphics/drawable/Drawable;", "screenShareRes", "M", "audioTextColor", "N", "livingTextColor", "P", "worldTextColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "kaiHeiTextColor", BdhLogUtil.LogTag.Tag_Req, "musicTextColor", ExifInterface.LATITUDE_SOUTH, "gameTextColor", "T", "audioBgDrawable", "U", "livingBgDrawable", "V", "worldBgDrawable", "W", "kaiHeiBgDrawable", "a0", "musicBgDrawable", "b0", "gameBgDrawable", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "c0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"CustomViewStyleable"})
/* loaded from: classes14.dex */
public final class ChannelStatusView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int rootPaddingRight;

    /* renamed from: D, reason: from kotlin metadata */
    private int rootPaddingTop;

    /* renamed from: E, reason: from kotlin metadata */
    private int rootPaddingBottom;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String lottieAudioRes;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String lottieLiveRes;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String lottieWorldRes;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String lottieKaiHeiRes;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String lottieMusicRes;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String lottieGameRes;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Drawable screenShareRes;

    /* renamed from: M, reason: from kotlin metadata */
    private int audioTextColor;

    /* renamed from: N, reason: from kotlin metadata */
    private int livingTextColor;

    /* renamed from: P, reason: from kotlin metadata */
    private int worldTextColor;

    /* renamed from: Q, reason: from kotlin metadata */
    private int kaiHeiTextColor;

    /* renamed from: R, reason: from kotlin metadata */
    private int musicTextColor;

    /* renamed from: S, reason: from kotlin metadata */
    private int gameTextColor;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Drawable audioBgDrawable;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Drawable livingBgDrawable;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Drawable worldBgDrawable;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Drawable kaiHeiBgDrawable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable musicBgDrawable;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable gameBgDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LottieAnimationView lottie;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int viewType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lifecycleStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int rootPaddingLeft;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChannelStatusView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        try {
            this.lottie.setAnimation(0);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (e16 instanceof String) {
                bVar.a().add(e16);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Top.ChannelStatusView", 1, (String) it.next(), null);
            }
        }
    }

    private final void g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        boolean z16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, up1.a.f439460d3, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026efStyleAttr, defStyleRes)");
        Drawable drawable = obtainStyledAttributes.getDrawable(up1.a.f439502g3);
        float dimension = obtainStyledAttributes.getDimension(up1.a.f439719x3, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(up1.a.w3, -1.0f);
        int color = obtainStyledAttributes.getColor(up1.a.f439745z3, -1);
        float dimension3 = obtainStyledAttributes.getDimension(up1.a.A3, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(up1.a.j3, -1.0f);
        String string = obtainStyledAttributes.getString(up1.a.f439604o3);
        if (string == null) {
            string = this.lottieAudioRes;
        }
        this.lottieAudioRes = string;
        String string2 = obtainStyledAttributes.getString(up1.a.f439643r3);
        if (string2 == null) {
            string2 = this.lottieLiveRes;
        }
        this.lottieLiveRes = string2;
        String string3 = obtainStyledAttributes.getString(up1.a.f439669t3);
        if (string3 == null) {
            string3 = this.lottieWorldRes;
        }
        this.lottieWorldRes = string3;
        String string4 = obtainStyledAttributes.getString(up1.a.f439630q3);
        if (string4 == null) {
            string4 = this.lottieKaiHeiRes;
        }
        this.lottieKaiHeiRes = string4;
        String string5 = obtainStyledAttributes.getString(up1.a.f439656s3);
        if (string5 == null) {
            string5 = this.lottieMusicRes;
        }
        this.lottieMusicRes = string5;
        String string6 = obtainStyledAttributes.getString(up1.a.f439617p3);
        if (string6 == null) {
            string6 = this.lottieGameRes;
        }
        this.lottieGameRes = string6;
        Drawable drawable2 = obtainStyledAttributes.getDrawable(up1.a.f439732y3);
        if (drawable2 == null) {
            drawable2 = this.screenShareRes;
        }
        this.screenShareRes = drawable2;
        this.audioTextColor = obtainStyledAttributes.getColor(up1.a.f439488f3, -1);
        this.livingTextColor = obtainStyledAttributes.getColor(up1.a.n3, -1);
        this.worldTextColor = obtainStyledAttributes.getColor(up1.a.C3, -1);
        this.kaiHeiTextColor = obtainStyledAttributes.getColor(up1.a.l3, -1);
        this.musicTextColor = obtainStyledAttributes.getColor(up1.a.v3, -1);
        this.gameTextColor = obtainStyledAttributes.getColor(up1.a.i3, -1);
        this.audioBgDrawable = obtainStyledAttributes.getDrawable(up1.a.f439474e3);
        this.livingBgDrawable = obtainStyledAttributes.getDrawable(up1.a.m3);
        this.worldBgDrawable = obtainStyledAttributes.getDrawable(up1.a.B3);
        this.kaiHeiBgDrawable = obtainStyledAttributes.getDrawable(up1.a.k3);
        this.musicBgDrawable = obtainStyledAttributes.getDrawable(up1.a.f439682u3);
        this.gameBgDrawable = obtainStyledAttributes.getDrawable(up1.a.f439516h3);
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            this.root.setBackground(drawable);
        }
        if (dimension >= 0.0f) {
            int i3 = (int) dimension2;
            int i16 = (int) dimension;
            setPadding(i3, i16, i3, i16);
        }
        if (color != -1) {
            this.text.setTextColor(color);
        }
        boolean z17 = true;
        if (dimension3 == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.text.setTextSize(0, dimension3);
        }
        if (dimension4 != -1.0f) {
            z17 = false;
        }
        if (!z17) {
            ViewGroup.LayoutParams layoutParams = this.lottie.getLayoutParams();
            int i17 = (int) dimension4;
            layoutParams.width = i17;
            layoutParams.height = i17;
            this.lottie.setLayoutParams(layoutParams);
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LottieAnimationView getLottie() {
        return this.lottie;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getRoot() {
        return this.root;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final TextView getText() {
        return this.text;
    }

    public final void e() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Top.ChannelStatusView", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.lifecycleStatus = 2;
        if (this.lottie.isAnimating()) {
            this.lottie.cancelAnimation();
        }
    }

    public final void f() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Top.ChannelStatusView", 2, "onResume");
        }
        this.lifecycleStatus = 1;
        setType(this.viewType);
    }

    public final void setHeight(int height) {
        if (height < 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.root.getLayoutParams();
        layoutParams.height = height;
        this.root.setLayoutParams(layoutParams);
    }

    public final void setLottie(@NotNull LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.lottie = lottieAnimationView;
    }

    public final void setLottieColorFilter(@ColorInt int color) {
        SimpleColorFilter simpleColorFilter = new SimpleColorFilter(color);
        this.lottie.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(simpleColorFilter));
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        boolean z16;
        boolean z17 = true;
        if (this.rootPaddingLeft != left) {
            this.rootPaddingLeft = left;
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.rootPaddingRight != right) {
            this.rootPaddingRight = right;
            z16 = true;
        }
        if (this.rootPaddingTop != top) {
            this.rootPaddingTop = top;
            z16 = true;
        }
        if (this.rootPaddingBottom != bottom) {
            this.rootPaddingBottom = bottom;
        } else {
            z17 = z16;
        }
        if (z17) {
            this.root.setPadding(left, top, right, bottom);
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        setPadding(start, top, end, bottom);
    }

    public final void setRoot(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.root = view;
    }

    public final void setText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.text = textView;
    }

    public final void setType(int type) {
        switch (type) {
            case 0:
                this.text.setText(getResources().getText(R.string.f157771nt));
                int i3 = this.audioTextColor;
                if (i3 != -1) {
                    this.text.setTextColor(i3);
                }
                Drawable drawable = this.audioBgDrawable;
                if (drawable != null) {
                    this.root.setBackground(drawable);
                }
                this.lottie.setImageResource(0);
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieAudioRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
            case 1:
                this.text.setText(getResources().getText(R.string.f157821ny));
                int i16 = this.audioTextColor;
                if (i16 != -1) {
                    this.text.setTextColor(i16);
                }
                Drawable drawable2 = this.audioBgDrawable;
                if (drawable2 != null) {
                    this.root.setBackground(drawable2);
                }
                if (this.lottie.isAnimating()) {
                    this.lottie.cancelAnimation();
                    a();
                }
                this.lottie.setImageDrawable(this.screenShareRes);
                break;
            case 2:
                this.text.setText(getResources().getText(R.string.f157781nu));
                this.lottie.cancelAnimation();
                a();
                this.lottie.setImageResource(R.drawable.guild_top_card_channel_icon_feed);
                break;
            case 3:
                this.text.setText(getResources().getText(R.string.f157831nz));
                this.lottie.cancelAnimation();
                a();
                this.lottie.setImageResource(R.drawable.guild_top_card_channel_icon_text);
                break;
            case 4:
                this.lottie.setImageResource(0);
                int i17 = this.livingTextColor;
                if (i17 != -1) {
                    this.text.setTextColor(i17);
                }
                Drawable drawable3 = this.livingBgDrawable;
                if (drawable3 != null) {
                    this.root.setBackground(drawable3);
                }
                this.text.setText(getResources().getText(R.string.f155551ht));
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieLiveRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
            case 5:
                this.text.setText(getResources().getText(R.string.f157841o0));
                int i18 = this.worldTextColor;
                if (i18 != -1) {
                    this.text.setTextColor(i18);
                }
                Drawable drawable4 = this.worldBgDrawable;
                if (drawable4 != null) {
                    this.root.setBackground(drawable4);
                }
                this.lottie.setImageResource(0);
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieWorldRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
            case 6:
                this.text.setText(getResources().getText(R.string.f157791nv));
                int i19 = this.kaiHeiTextColor;
                if (i19 != -1) {
                    this.text.setTextColor(i19);
                }
                Drawable drawable5 = this.kaiHeiBgDrawable;
                if (drawable5 != null) {
                    this.root.setBackground(drawable5);
                }
                this.lottie.setImageResource(0);
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieKaiHeiRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
            case 7:
                this.text.setText(getResources().getText(R.string.f157811nx));
                int i26 = this.gameTextColor;
                if (i26 != -1) {
                    this.text.setTextColor(i26);
                }
                Drawable drawable6 = this.gameBgDrawable;
                if (drawable6 != null) {
                    this.root.setBackground(drawable6);
                }
                this.lottie.setImageResource(0);
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieGameRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
            case 8:
                this.text.setText(getResources().getText(R.string.f157801nw));
                int i27 = this.musicTextColor;
                if (i27 != -1) {
                    this.text.setTextColor(i27);
                }
                Drawable drawable7 = this.musicBgDrawable;
                if (drawable7 != null) {
                    this.root.setBackground(drawable7);
                }
                this.lottie.setImageResource(0);
                if (this.lifecycleStatus == 1) {
                    this.lottie.setAnimation(this.lottieMusicRes);
                    this.lottie.playAnimation();
                    break;
                }
                break;
        }
        this.viewType = type;
    }

    public final void setViewType(int i3) {
        this.viewType = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChannelStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChannelStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChannelStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewType = -1;
        String string = getResources().getString(R.string.f1487310d);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026p_audio_speaker_filename)");
        this.lottieAudioRes = string;
        String string2 = getResources().getString(R.string.f1487410e);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026lottie_top_live_filename)");
        this.lottieLiveRes = string2;
        String string3 = getResources().getString(R.string.f1487610g);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026ottie_top_world_filename)");
        this.lottieWorldRes = string3;
        String string4 = getResources().getString(R.string.f1487210c);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026op_audio_kaihei_filename)");
        this.lottieKaiHeiRes = string4;
        String string5 = getResources().getString(R.string.f1487510f);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st\u2026ottie_top_music_filename)");
        this.lottieMusicRes = string5;
        String string6 = getResources().getString(R.string.f1487210c);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st\u2026op_audio_kaihei_filename)");
        this.lottieGameRes = string6;
        this.screenShareRes = ResourcesCompat.getDrawable(getResources(), R.drawable.guild_top_screen_icon, null);
        this.audioTextColor = -1;
        this.livingTextColor = -1;
        this.worldTextColor = -1;
        this.kaiHeiTextColor = -1;
        this.musicTextColor = -1;
        this.gameTextColor = -1;
        View.inflate(context, R.layout.f_2, this);
        View findViewById = findViewById(R.id.f99775qp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.top_channel_root)");
        this.root = findViewById;
        View findViewById2 = findViewById(R.id.f99785qq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.top_channel_status_tv)");
        this.text = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f99925r4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.top_lottie_animate)");
        this.lottie = (LottieAnimationView) findViewById3;
        g(context, attributeSet, i3, i16);
    }

    public /* synthetic */ ChannelStatusView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}
