package com.tencent.mobileqq.aio.msglist.holder.component.facebubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.base.tool.a;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001\u0006B\u000f\u0012\u0006\u0010T\u001a\u00020S\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bE\u0010$R$\u0010J\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00168\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010IR\u0018\u0010P\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010IR\u0014\u0010R\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010K\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/PokeEmoItemView;", "Landroid/view/View;", "Ljava/lang/Runnable;", "", "upTime", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "text", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "setTypeFace", TencentLocation.RUN_MODE, "", "isSend", "setIsSend", "Landroid/graphics/drawable/Drawable;", "imgDrawable", "setImageDrawable", "d", "Ljava/lang/String;", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "mText", "e", "I", "getMTranslateOffset", "()I", "setMTranslateOffset", "(I)V", "mTranslateOffset", "f", "getMTextOffset", "setMTextOffset", "mTextOffset", h.F, "getMImgWidth", "setMImgWidth", "mImgWidth", "i", "getMTextWidth", "setMTextWidth", "mTextWidth", "Landroid/graphics/Paint;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "getMPEPaint", "()Landroid/graphics/Paint;", "setMPEPaint", "(Landroid/graphics/Paint;)V", "mPEPaint", BdhLogUtil.LogTag.Tag_Conn, "getMStrokePaint", "setMStrokePaint", "mStrokePaint", "D", "J", "mFirstDrawTextTs", "E", "mAnimTimeinterval", "<set-?>", UserInfo.SEX_FEMALE, "Z", "isHasTypeface", "()Z", "G", "mIsSend", "H", "Landroid/graphics/drawable/Drawable;", "mImgDrawable", "supportMeasure", "isMeasureEnabled", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PokeEmoItemView extends View implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Paint mStrokePaint;

    /* renamed from: D, reason: from kotlin metadata */
    private long mFirstDrawTextTs;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mAnimTimeinterval;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isHasTypeface;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsSend;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Drawable mImgDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean supportMeasure;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mTranslateOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mTextOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mImgWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTextWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mPEPaint;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/PokeEmoItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.PokeEmoItemView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PokeEmoItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mText = "";
        a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
        this.mTextOffset = companion.a(context, 16.0f);
        this.mAnimTimeinterval = 200;
        this.supportMeasure = e();
        this.mImgWidth = companion.a(context, 80.0f);
        this.mTranslateOffset = companion.a(context, 8.0f);
        Paint paint = new Paint();
        this.mPEPaint = paint;
        paint.setAntiAlias(true);
        this.mPEPaint.setColor(Color.parseColor("#FFDC4F"));
        this.mPEPaint.setTextSize(companion.a(context, 24.0f));
        Paint paint2 = new Paint(this.mPEPaint);
        this.mStrokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setColor(Color.parseColor("#418DFF"));
        this.mStrokePaint.setStrokeWidth(companion.a(context, 4.0f));
    }

    private final float a(long upTime) {
        double d16;
        if (this.mFirstDrawTextTs == 0) {
            return 0.0f;
        }
        double d17 = (((upTime - r0) % 400) / 400.0d) * 20.0d;
        if (d17 < 10.0d) {
            d16 = d17 - 5.0d;
        } else {
            double d18 = 10;
            d16 = (d18 - (d17 - d18)) - 5;
        }
        return (float) d16;
    }

    private final boolean e() {
        return ((IAIOConfig) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOConfig.class)).isFeatureSwitchOn("poke_emoticon_view_measure");
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String str = this.mText;
        int i3 = this.mTextWidth;
        Drawable drawable = this.mImgDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int save = canvas.save();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i16 = this.mImgWidth - this.mTextOffset;
        Paint.FontMetricsInt fontMetricsInt = this.mPEPaint.getFontMetricsInt();
        Intrinsics.checkNotNullExpressionValue(fontMetricsInt, "mPEPaint.fontMetricsInt");
        int measuredHeight = (getMeasuredHeight() - fontMetricsInt.descent) - 4;
        canvas.rotate(a(uptimeMillis), (i3 / 2) + i16, (fontMetricsInt.ascent / 2) + measuredHeight);
        float f16 = i16;
        float f17 = measuredHeight;
        canvas.drawText(str, f16, f17, this.mStrokePaint);
        canvas.drawText(str, f16, f17, this.mPEPaint);
        canvas.restoreToCount(save);
        if (this.mFirstDrawTextTs == 0) {
            this.mFirstDrawTextTs = uptimeMillis;
        }
        postDelayed(this, this.mAnimTimeinterval);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.supportMeasure) {
            setMeasuredDimension(this.mImgWidth + (this.mTextWidth - this.mTextOffset) + this.mTranslateOffset, View.MeasureSpec.getSize(heightMeasureSpec));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (getVisibility() == 0) {
            invalidate();
        }
    }

    public final void setImageDrawable(@Nullable Drawable imgDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) imgDrawable);
            return;
        }
        if (imgDrawable != null) {
            int i3 = this.mImgWidth;
            imgDrawable.setBounds(0, 0, i3, i3);
        }
        this.mImgDrawable = imgDrawable;
        requestLayout();
        invalidate();
    }

    public final void setIsSend(boolean isSend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, isSend);
        } else {
            this.mIsSend = isSend;
        }
    }

    public final void setMImgWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mImgWidth = i3;
        }
    }

    public final void setMPEPaint(@NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) paint);
        } else {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.mPEPaint = paint;
        }
    }

    public final void setMStrokePaint(@NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) paint);
        } else {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.mStrokePaint = paint;
        }
    }

    public final void setMText(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mText = str;
        }
    }

    public final void setMTextOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mTextOffset = i3;
        }
    }

    public final void setMTextWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mTextWidth = i3;
        }
    }

    public final void setMTranslateOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mTranslateOffset = i3;
        }
    }

    public final void setText(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        if (!TextUtils.isEmpty(text)) {
            this.mTextWidth = (int) this.mPEPaint.measureText(text);
            invalidate();
        } else {
            this.mTextWidth = 0;
        }
        this.mText = text;
    }

    public final void setTypeFace(@Nullable Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) typeface);
        } else if (!this.isHasTypeface && typeface != null) {
            this.isHasTypeface = true;
            this.mPEPaint.setTypeface(typeface);
            this.mStrokePaint.setTypeface(typeface);
        }
    }
}
