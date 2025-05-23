package com.tencent.mobileqq.vas.font;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.rf.e;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\bg\u0018\u0000 \u00172\u00020\u0001:\u0003\u0018\u0019\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/font/IFontManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "fontDrawableInfo", "Landroid/graphics/drawable/Drawable;", "getFontDrawable", "", "isNeedFontDrawable", "", MessageForRichState.SIGN_MSG_FONT_ID, "checkFontFile", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "startDownload", "", "subFontId", "checkMagicFont", "", "msg", "uid", "msgId", "parseMagicFont", "Companion", "a", "b", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IFontManager extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f309093a;
    public static final int FONT_EFFECT_ENLARGE = 2000;
    public static final int FONT_EFFECT_MAGIC = 1;
    public static final int FONT_TYPE_FANGZHENG = 2;
    public static final int FONT_TYPE_FZCOLOR = 3;
    public static final int FONT_TYPE_FZCOLOR_2 = 4;
    public static final int FONT_TYPE_HANYI = 1;
    public static final int MAGIC_FONT_DEFAULT_GROUP_SIZE = 4;
    public static final float MAGIC_FONT_DEFAULT_MAX_SIZE1 = 1.3f;
    public static final float MAGIC_FONT_DEFAULT_MAX_SIZE2 = 0.7f;
    public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE1 = 1.5f;
    public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE2 = 0.7f;
    public static final float MAGIC_FONT_DEFAULT_SIZE1_NUMBER = 0.3f;
    public static final float MAGIC_FONT_DEFAULT_SIZE2_NUMBER = 0.3f;
    public static final int MAX_ENGINE_CACHE_FONT_NUM = 18;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u0003\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010!\u001a\u0004\b\u0017\u0010#\"\u0004\b/\u0010%\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/vas/font/IFontManager$a;", "", "", "b", UserInfo.SEX_FEMALE, h.F, "()F", "setMagicFontSize1Number", "(F)V", "magicFontSize1Number", "c", "i", "setMagicFontSize2Number", "magicFontSize2Number", "d", "e", "setMagicFontNormalSize1", "magicFontNormalSize1", "f", "setMagicFontNormalSize2", "magicFontNormalSize2", "setMagicFontMaxSize1", "magicFontMaxSize1", "g", "setMagicFontMaxSize2", "magicFontMaxSize2", "", "I", "()I", "setMagicFontGroupSize", "(I)V", "magicFontGroupSize", "", "Z", "getSHasChatFont", "()Z", "j", "(Z)V", "sHasChatFont", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setMagicFontConfigInited", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "magicFontConfigInited", "k", "setMagicFontOneWordEnable", "magicFontOneWordEnable", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.IFontManager$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private static volatile boolean sHasChatFont;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f309093a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static float magicFontSize1Number = 0.3f;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static float magicFontSize2Number = 0.3f;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static float magicFontNormalSize1 = 1.5f;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static float magicFontNormalSize2 = 0.7f;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static float magicFontMaxSize1 = 1.3f;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static float magicFontMaxSize2 = 0.7f;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private static int magicFontGroupSize = 4;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static AtomicBoolean magicFontConfigInited = new AtomicBoolean(false);

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private static boolean magicFontOneWordEnable = true;

        Companion() {
        }

        @NotNull
        public final AtomicBoolean a() {
            return magicFontConfigInited;
        }

        public final int b() {
            return magicFontGroupSize;
        }

        public final float c() {
            return magicFontMaxSize1;
        }

        public final float d() {
            return magicFontMaxSize2;
        }

        public final float e() {
            return magicFontNormalSize1;
        }

        public final float f() {
            return magicFontNormalSize2;
        }

        public final boolean g() {
            return magicFontOneWordEnable;
        }

        public final float h() {
            return magicFontSize1Number;
        }

        public final float i() {
            return magicFontSize2Number;
        }

        public final void j(boolean z16) {
            sHasChatFont = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/font/IFontManager$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "drawFont", "b", "hasTextColor", "c", "I", "()I", "textColor", "<init>", "(ZZI)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.IFontManager$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class DrawableResultInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean drawFont;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hasTextColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textColor;

        public DrawableResultInfo(boolean z16, boolean z17, int i3) {
            this.drawFont = z16;
            this.hasTextColor = z17;
            this.textColor = i3;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDrawFont() {
            return this.drawFont;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasTextColor() {
            return this.hasTextColor;
        }

        /* renamed from: c, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawableResultInfo)) {
                return false;
            }
            DrawableResultInfo drawableResultInfo = (DrawableResultInfo) other;
            if (this.drawFont == drawableResultInfo.drawFont && this.hasTextColor == drawableResultInfo.hasTextColor && this.textColor == drawableResultInfo.textColor) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.drawFont;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.hasTextColor;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.textColor;
        }

        @NotNull
        public String toString() {
            return "DrawableResultInfo(drawFont=" + this.drawFont + ", hasTextColor=" + this.hasTextColor + ", textColor=" + this.textColor + ")";
        }
    }

    boolean checkFontFile(int fontId);

    boolean checkMagicFont(long subFontId);

    @Nullable
    Drawable getFontDrawable(@NotNull FontDrawableInfo fontDrawableInfo);

    boolean isNeedFontDrawable(@NotNull FontDrawableInfo fontDrawableInfo);

    @NotNull
    CharSequence parseMagicFont(@NotNull CharSequence msg2, long uid, long msgId);

    void startDownload(int fontId, @NotNull AIOMsgItem msgItem);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020$\u0012\b\b\u0002\u0010-\u001a\u00020$\u00a2\u0006\u0004\bq\u0010rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\n\u0010'R\"\u0010-\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010&\u001a\u0004\b*\u0010'\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010D\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b)\u0010A\"\u0004\bB\u0010CR$\u0010F\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010@\u001a\u0004\b.\u0010A\"\u0004\bE\u0010CR$\u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010@\u001a\u0004\b\u0011\u0010A\"\u0004\bG\u0010CR\"\u0010K\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u001b\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u00101R\"\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0012\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u0010\u0016R\"\u0010U\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bP\u0010R\"\u0004\bS\u0010TR\"\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0012\u001a\u0004\b?\u0010\u0014\"\u0004\bV\u0010\u0016R\"\u0010Y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\bX\u0010\u0016R\"\u0010\\\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\b[\u0010\u0016R\"\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b]\u0010\u0016R\"\u0010d\u001a\u00020_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010`\u001a\u0004\bZ\u0010a\"\u0004\bb\u0010cR\"\u0010l\u001a\u00020e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010o\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\u0012\u001a\u0004\bn\u0010\u0014\"\u0004\bf\u0010\u0016R\"\u0010p\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b%\u0010\u0014\"\u0004\bm\u0010\u0016\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "l", "()Ljava/lang/CharSequence;", HippyTKDListViewAdapter.X, "(Ljava/lang/CharSequence;)V", "msg", "b", "I", "c", "()I", "setFontId", "(I)V", MessageForRichState.SIGN_MSG_FONT_ID, "d", "setFontType", MessageForRichState.SIGN_MSG_FONT_TYPE, "Z", "u", "()Z", "isTroop", "e", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "uin", "", "f", "J", "()J", "diyTimestamp", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "(J)V", "msgId", h.F, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "isSend", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "textSize", "Landroid/graphics/Paint;", "j", "Landroid/graphics/Paint;", DomainData.DOMAIN_NAME, "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "paint", "k", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setMaxEms", "(Ljava/lang/Integer;)V", "maxEms", "setMaxLines", "maxLines", "setETMaxWidth", "eTMaxWidth", "getShouldStartAnimation", "setShouldStartAnimation", "shouldStartAnimation", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "textColor", "Landroid/content/res/ColorStateList;", "p", "Landroid/content/res/ColorStateList;", "()Landroid/content/res/ColorStateList;", "B", "(Landroid/content/res/ColorStateList;)V", "textColorLink", "setMinWidth", NodeProps.MIN_WIDTH, "setMinHeight", NodeProps.MIN_HEIGHT, ReportConstant.COSTREPORT_PREFIX, "setMaxWidth", NodeProps.MAX_WIDTH, "setHighlightBackgroundColor", "highlightBackgroundColor", "", "[I", "()[I", "setViewLocation", "([I)V", "viewLocation", "Landroid/graphics/Rect;", "v", "Landroid/graphics/Rect;", "getPadding", "()Landroid/graphics/Rect;", "setPadding", "(Landroid/graphics/Rect;)V", "padding", "w", "getHighlightColor", "highlightColor", "magicFont", "<init>", "(Ljava/lang/CharSequence;IIZLjava/lang/String;JJ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.IFontManager$c, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class FontDrawableInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private CharSequence msg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int fontId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int fontType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isTroop;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long diyTimestamp;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private long msgId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean isSend;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int textSize;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Paint paint;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer maxEms;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer maxLines;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer eTMaxWidth;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean shouldStartAnimation;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int textColor;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ColorStateList textColorLink;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private int minWidth;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private int minHeight;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private int maxWidth;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private int highlightBackgroundColor;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private int[] viewLocation;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Rect padding;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        private int highlightColor;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        private int magicFont;

        public FontDrawableInfo(@NotNull CharSequence msg2, int i3, int i16, boolean z16, @NotNull String uin, long j3, long j16) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.msg = msg2;
            this.fontId = i3;
            this.fontType = i16;
            this.isTroop = z16;
            this.uin = uin;
            this.diyTimestamp = j3;
            this.msgId = j16;
            this.paint = new Paint();
            this.maxEms = Integer.MAX_VALUE;
            this.maxLines = Integer.MAX_VALUE;
            this.eTMaxWidth = Integer.valueOf(e.CTRL_INDEX);
            this.shouldStartAnimation = true;
            this.textColor = -16777216;
            ColorStateList valueOf = ColorStateList.valueOf(-16777216);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.BLACK)");
            this.textColorLink = valueOf;
            this.minWidth = -1;
            this.minHeight = -1;
            this.maxWidth = e.CTRL_INDEX;
            this.viewLocation = new int[2];
            this.padding = new Rect();
        }

        public final void A(int i3) {
            this.textColor = i3;
        }

        public final void B(@NotNull ColorStateList colorStateList) {
            Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
            this.textColorLink = colorStateList;
        }

        public final void C(int i3) {
            this.textSize = i3;
        }

        /* renamed from: a, reason: from getter */
        public final long getDiyTimestamp() {
            return this.diyTimestamp;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getETMaxWidth() {
            return this.eTMaxWidth;
        }

        /* renamed from: c, reason: from getter */
        public final int getFontId() {
            return this.fontId;
        }

        /* renamed from: d, reason: from getter */
        public final int getFontType() {
            return this.fontType;
        }

        /* renamed from: e, reason: from getter */
        public final int getHighlightBackgroundColor() {
            return this.highlightBackgroundColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FontDrawableInfo)) {
                return false;
            }
            FontDrawableInfo fontDrawableInfo = (FontDrawableInfo) other;
            if (Intrinsics.areEqual(this.msg, fontDrawableInfo.msg) && this.fontId == fontDrawableInfo.fontId && this.fontType == fontDrawableInfo.fontType && this.isTroop == fontDrawableInfo.isTroop && Intrinsics.areEqual(this.uin, fontDrawableInfo.uin) && this.diyTimestamp == fontDrawableInfo.diyTimestamp && this.msgId == fontDrawableInfo.msgId) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getMagicFont() {
            return this.magicFont;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Integer getMaxEms() {
            return this.maxEms;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Integer getMaxLines() {
            return this.maxLines;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.msg.hashCode() * 31) + this.fontId) * 31) + this.fontType) * 31;
            boolean z16 = this.isTroop;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((((hashCode + i3) * 31) + this.uin.hashCode()) * 31) + a.a(this.diyTimestamp)) * 31) + a.a(this.msgId);
        }

        /* renamed from: i, reason: from getter */
        public final int getMaxWidth() {
            return this.maxWidth;
        }

        /* renamed from: j, reason: from getter */
        public final int getMinHeight() {
            return this.minHeight;
        }

        /* renamed from: k, reason: from getter */
        public final int getMinWidth() {
            return this.minWidth;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final CharSequence getMsg() {
            return this.msg;
        }

        /* renamed from: m, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }

        @NotNull
        /* renamed from: n, reason: from getter */
        public final Paint getPaint() {
            return this.paint;
        }

        /* renamed from: o, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ColorStateList getTextColorLink() {
            return this.textColorLink;
        }

        /* renamed from: q, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final int[] getViewLocation() {
            return this.viewLocation;
        }

        /* renamed from: t, reason: from getter */
        public final boolean getIsSend() {
            return this.isSend;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.msg;
            return "FontDrawableInfo(msg=" + ((Object) charSequence) + ", fontId=" + this.fontId + ", fontType=" + this.fontType + ", isTroop=" + this.isTroop + ", uin=" + this.uin + ", diyTimestamp=" + this.diyTimestamp + ", msgId=" + this.msgId + ")";
        }

        /* renamed from: u, reason: from getter */
        public final boolean getIsTroop() {
            return this.isTroop;
        }

        public final void v(int i3) {
            this.highlightColor = i3;
        }

        public final void w(int i3) {
            this.magicFont = i3;
        }

        public final void x(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.msg = charSequence;
        }

        public final void y(long j3) {
            this.msgId = j3;
        }

        public final void z(boolean z16) {
            this.isSend = z16;
        }

        public /* synthetic */ FontDrawableInfo(CharSequence charSequence, int i3, int i16, boolean z16, String str, long j3, long j16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, i3, i16, z16, str, j3, (i17 & 64) != 0 ? System.currentTimeMillis() : j16);
        }
    }
}
