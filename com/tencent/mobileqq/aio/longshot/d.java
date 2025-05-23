package com.tencent.mobileqq.aio.longshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.core.graphics.drawable.DrawableKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qqnt.robot.api.IRobotSharePreviewApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/d;", "Lcom/tencent/mobileqq/aio/longshot/b;", "", "msgWidth", "centerHeight", "Landroid/graphics/Bitmap;", ReportConstant.COSTREPORT_PREFIX, "preBitmap", "width", "t", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "profile", "", "w", "", "dp", "v", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "j", "msgHeight", "a", "e", UserInfo.SEX_FEMALE, "titleHeight", "f", "bottomHeight", "g", "I", "centerMinHeight", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "i", "Z", "useDarkMask", "Lcom/tencent/mobileqq/aio/longshot/e;", "Lcom/tencent/mobileqq/aio/longshot/e;", "configBean", "Landroid/graphics/drawable/Drawable;", "k", "Landroid/graphics/drawable/Drawable;", "avatarDrawable", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;)V", "l", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d extends com.tencent.mobileqq.aio.longshot.b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f189957m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float titleHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float bottomHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int centerMinHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupRobotProfile robotProfile;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean useDarkMask;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e configBean;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable avatarDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/d$a;", "", "", "qrCodeGenerateFailSwitch", "Z", "a", "()Z", "b", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.longshot.d$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return d.f189957m;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                d.f189957m = z16;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/longshot/d$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IGetGroupRobotProfileCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f189966b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<com.tencent.aio.data.msglist.a> f189967c;

        b(long j3, List<? extends com.tencent.aio.data.msglist.a> list) {
            this.f189966b = j3;
            this.f189967c = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Long.valueOf(j3), list);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
        public void onResult(int result, @NotNull String errMsg, @NotNull GroupRobotProfile robotProfile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, robotProfile);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            d dVar = d.this;
            dVar.useDarkMask = dVar.w(robotProfile);
            QLog.i("RobotLongShotProcessor", 1, "[startLongShot]: fetchResult is " + result + ", errMsg is " + errMsg + ", useDarkMask is " + d.this.useDarkMask);
            d.this.robotProfile = robotProfile;
            d dVar2 = d.this;
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            dVar2.configBean = (e) ((IAIOUniteConfigApi) companion.a(IAIOUniteConfigApi.class)).loadConfig("robot_shot_config");
            d.this.avatarDrawable = ((IRobotSharePreviewApi) companion.a(IRobotSharePreviewApi.class)).getRobotFaceDrawable(String.valueOf(this.f189966b));
            d.this.e().e().h(new AIOMsgListEvent.GetMsgListEvent(this.f189967c));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        super(context, aioContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aioContext);
            return;
        }
        this.titleHeight = v(61.0f);
        this.bottomHeight = v(85.0f);
        this.centerMinHeight = ViewUtils.dpToPx(320.0f);
    }

    private final Bitmap s(int msgWidth, int centerHeight) {
        int parseColor;
        a.C9469a c9469a;
        Drawable a16;
        Bitmap bitmap$default;
        Bitmap d16 = com.tencent.mobileqq.aio.longshot.b.d(this, msgWidth, centerHeight + ((int) this.titleHeight), null, 4, null);
        if (d16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(d16);
        if (this.useDarkMask) {
            parseColor = Color.parseColor("#2F3033");
        } else {
            parseColor = Color.parseColor("#F3F3F7");
        }
        canvas.drawColor(parseColor);
        k k3 = e().e().k(AIOBackgroundMsgIntent.GetBackgroundDrawable.f349764d);
        if (k3 instanceof a.C9469a) {
            c9469a = (a.C9469a) k3;
        } else {
            c9469a = null;
        }
        if (c9469a == null || (a16 = c9469a.a()) == null) {
            return null;
        }
        float intrinsicWidth = msgWidth / a16.getIntrinsicWidth();
        Bitmap bitmap$default2 = DrawableKt.toBitmap$default(a16, (int) (a16.getIntrinsicWidth() * intrinsicWidth), (int) (intrinsicWidth * a16.getIntrinsicHeight()), null, 4, null);
        canvas.drawBitmap(bitmap$default2, 0.0f, 0.0f, (Paint) null);
        if (d16.getHeight() >= bitmap$default2.getHeight()) {
            int v3 = (int) v(160.0f);
            if (this.useDarkMask) {
                Drawable drawable = f().getResources().getDrawable(R.drawable.o0w);
                Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026obot_long_shot_mask_dark)");
                bitmap$default = DrawableKt.toBitmap$default(drawable, msgWidth, v3, null, 4, null);
            } else {
                Drawable drawable2 = f().getResources().getDrawable(R.drawable.o0x);
                Intrinsics.checkNotNullExpressionValue(drawable2, "context.resources.getDra\u2026bot_long_shot_mask_light)");
                bitmap$default = DrawableKt.toBitmap$default(drawable2, msgWidth, v3, null, 4, null);
            }
            bitmap$default.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap$default, 0.0f, bitmap$default2.getHeight() - bitmap$default.getHeight(), (Paint) null);
        }
        return d16;
    }

    private final Bitmap t(Bitmap preBitmap, int width) {
        LinearGradient linearGradient;
        boolean z16;
        String str;
        String str2;
        Bitmap bitmap$default;
        Canvas canvas = new Canvas(preBitmap);
        Paint paint = new Paint();
        if (this.useDarkMask) {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, this.titleHeight, Color.parseColor("#B5000000"), Color.parseColor("#00000000"), Shader.TileMode.REPEAT);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, this.titleHeight, Color.parseColor("#FFF0EEFC"), Color.parseColor("#00DFE4F6"), Shader.TileMode.REPEAT);
        }
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, 0.0f, width, this.titleHeight, paint);
        float v3 = v(12.0f);
        float v16 = v(12.0f);
        float v17 = v(36.0f);
        Drawable drawable = this.avatarDrawable;
        if (drawable != null && (bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null)) != null && bitmap$default.getWidth() > 0 && bitmap$default.getHeight() > 0) {
            Paint paint2 = new Paint(1);
            float min = Math.min(v17 / bitmap$default.getWidth(), v17 / bitmap$default.getHeight());
            float width2 = bitmap$default.getWidth() * min;
            float height = bitmap$default.getHeight() * min;
            float f16 = 2;
            float f17 = ((v17 - width2) / f16) + v16;
            float f18 = ((v17 - height) / f16) + v3;
            canvas.drawBitmap(bitmap$default, (Rect) null, new RectF(f17, f18, width2 + f17, height + f18), paint2);
            v16 = v16 + v17 + v(8.0f);
        }
        c g16 = g();
        if (g16 != null && g16.d()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TextPaint textPaint = new TextPaint();
            if (this.useDarkMask) {
                str = "#F0F0F4";
            } else {
                str = "#1A1C1E";
            }
            textPaint.setColor(Color.parseColor(str));
            textPaint.setTextSize(v(14.0f));
            textPaint.setTypeface(Typeface.create("PingFangSC", 0));
            textPaint.setFakeBoldText(true);
            String g17 = e().g().r().c().g();
            float textSize = v3 + textPaint.getTextSize();
            canvas.drawText(g17, v16, textSize, textPaint);
            if (this.useDarkMask) {
                str2 = "#909094";
            } else {
                str2 = "#4D4D4D";
            }
            textPaint.setColor(Color.parseColor(str2));
            textPaint.setTextSize(v(10.0f));
            textPaint.setFakeBoldText(false);
            canvas.drawText(new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, Locale.getDefault()).format(Calendar.getInstance().getTime()), v16, textSize + v(18.0f), textPaint);
        }
        return preBitmap;
    }

    private final Bitmap u(int width) {
        int parseColor;
        int parseColor2;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        int i3;
        int parseColor3;
        int i16;
        Unit unit;
        boolean z18;
        int parseColor4;
        boolean z19;
        RobotBaseInfo robotBaseInfo;
        String b16;
        Bitmap d16 = com.tencent.mobileqq.aio.longshot.b.d(this, width, (int) this.bottomHeight, null, 4, null);
        if (d16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(d16);
        if (this.useDarkMask) {
            parseColor = Color.parseColor("#2F3033");
        } else {
            parseColor = Color.parseColor("#F3F3F7");
        }
        int i17 = parseColor;
        canvas.drawColor(i17);
        TextPaint textPaint = new TextPaint();
        if (this.useDarkMask) {
            parseColor2 = Color.parseColor("#F0F0F4");
        } else {
            parseColor2 = Color.parseColor("#1A1C1E");
        }
        textPaint.setColor(parseColor2);
        textPaint.setTextSize(v(17.0f));
        textPaint.setTypeface(Typeface.create("PingFangSC", 1));
        textPaint.setAntiAlias(true);
        float v3 = v(21.0f);
        float v16 = v(15.0f);
        float v17 = v(24.0f);
        e eVar = this.configBean;
        String str3 = "";
        if (eVar == null || (str = eVar.a()) == null) {
            str = "";
        }
        e eVar2 = this.configBean;
        if (eVar2 != null && (b16 = eVar2.b()) != null) {
            str3 = b16;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        IRobotSharePreviewApi iRobotSharePreviewApi = (IRobotSharePreviewApi) companion.a(IRobotSharePreviewApi.class);
        AIOParam g16 = e().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String b17 = su3.c.b(g16);
        GroupRobotProfile groupRobotProfile = this.robotProfile;
        if (groupRobotProfile != null && (robotBaseInfo = groupRobotProfile.robotData) != null) {
            str2 = robotBaseInfo.name;
        } else {
            str2 = null;
        }
        Pair<String, String> robotBottomLineText = iRobotSharePreviewApi.getRobotBottomLineText(b17, str2);
        if (TextUtils.isEmpty(str)) {
            str = robotBottomLineText.getFirst();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = robotBottomLineText.getSecond();
        }
        float f16 = width - v16;
        canvas.drawText(str, f16 - textPaint.measureText(str), textPaint.getTextSize() + v3, textPaint);
        canvas.drawText(str3, f16 - textPaint.measureText(str3), v3 + textPaint.getTextSize() + v17, textPaint);
        c g17 = g();
        if (g17 != null && g17.d()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && !f189957m) {
            GroupRobotProfile groupRobotProfile2 = this.robotProfile;
            if (groupRobotProfile2 != null) {
                float v18 = v(54.0f);
                float v19 = v(16.0f);
                float v26 = v(16.0f);
                if (this.useDarkMask) {
                    parseColor4 = Color.parseColor("#FFFFFF");
                } else {
                    parseColor4 = Color.parseColor("#0099ff");
                }
                int i18 = parseColor4;
                IRobotSharePreviewApi iRobotSharePreviewApi2 = (IRobotSharePreviewApi) companion.a(IRobotSharePreviewApi.class);
                String str4 = groupRobotProfile2.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(str4, "it.jumpUrl");
                Bitmap robotQRCodeBitmap = iRobotSharePreviewApi2.getRobotQRCodeBitmap(str4, (int) v18, i18, this.useDarkMask, i17);
                if (robotQRCodeBitmap != null) {
                    canvas.drawBitmap(robotQRCodeBitmap, v19, v26, (Paint) null);
                    i16 = 1;
                    z19 = true;
                } else {
                    i16 = 1;
                    QLog.i("RobotLongShotProcessor", 1, "[drawQRCode]: qrBitmap is null");
                    z19 = false;
                }
                unit = Unit.INSTANCE;
                z18 = z19;
            } else {
                i16 = 1;
                unit = null;
                z18 = false;
            }
            if (unit == null) {
                QLog.i("RobotLongShotProcessor", i16, "[drawQRCode]: robotProfile is null");
            }
            z17 = z18;
        } else {
            z17 = false;
        }
        if (!z17) {
            RectF rectF = new RectF(v(16.0f), v(41.0f), v(158.0f), v(67.0f));
            float v27 = v(37.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(v(0.5f));
            paint.setStyle(Paint.Style.STROKE);
            int i19 = -16777216;
            if (this.useDarkMask) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            paint.setColor(i3);
            canvas.drawRoundRect(rectF, v27, v27, paint);
            textPaint.setTextSize(v(12.0f));
            if (this.useDarkMask) {
                parseColor3 = -1;
            } else {
                parseColor3 = Color.parseColor("#1A1C1E");
            }
            textPaint.setColor(parseColor3);
            canvas.drawText("\u4e0aQQ\uff0c\u641c\u667a\u80fd\u4f53", v(49.0f), v(47.0f) + textPaint.getTextSize(), textPaint);
            int v28 = (int) v(14.0f);
            Drawable drawable = f().getResources().getDrawable(R.drawable.qui_robot);
            Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026ken.R.drawable.qui_robot)");
            Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, v28, v28, null, 4, null);
            Paint paint2 = new Paint();
            if (this.useDarkMask) {
                i19 = -1;
            }
            paint2.setColorFilter(new PorterDuffColorFilter(i19, PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap$default, v(32.0f), v(47.0f), paint2);
        }
        return d16;
    }

    private final float v(float dp5) {
        float fontScale = FontSettingManager.getFontScale();
        if (fontScale > 0.0f) {
            return ViewUtils.dpToPx(dp5) / fontScale;
        }
        return ViewUtils.dpToPx(dp5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(GroupRobotProfile profile) {
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.mobileqq.aio.longshot.b
    @Nullable
    public Bitmap a(int msgWidth, int msgHeight) {
        LruCache<String, Bitmap> lruCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(msgWidth), Integer.valueOf(msgHeight));
        }
        Bitmap s16 = s(msgWidth, Math.max(msgHeight, this.centerMinHeight));
        if (s16 == null) {
            return null;
        }
        t(s16, msgWidth);
        c g16 = g();
        if (g16 != null) {
            lruCache = g16.c();
        } else {
            lruCache = null;
        }
        if (lruCache == null) {
            return null;
        }
        b(lruCache, s16, this.titleHeight);
        Bitmap u16 = u(msgWidth);
        if (u16 == null) {
            return null;
        }
        return h(msgWidth, s16, u16);
    }

    @Override // com.tencent.mobileqq.aio.longshot.b
    public void j(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        AIOParam g16 = e().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        QLog.i("RobotLongShotProcessor", 1, "[startLongShot]: fetchRobotProfile uin= " + a16);
        ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).fetchRobotProfileInfoFromServer(String.valueOf(a16), null, new b(a16, msgList));
    }
}
