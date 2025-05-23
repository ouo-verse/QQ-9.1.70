package com.tencent.mobileqq.vas.font.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.etrump.mixlayout.k;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y03.AIOTextViewInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u001c\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001eH\u0016J!\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u001c\u0010)\u001a\u00020\u00032\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'H\u0016J\b\u0010*\u001a\u00020\tH\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u0014\u00101\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010/R\u0014\u00104\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00109R\u0014\u0010<\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00103R\u0018\u0010>\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/vas/font/drawable/FontAnimDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Ly03/c;", "", "D", "invalidateSelf", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Rect;", "padding", "j", "", "widthMeasureSpec", "heightMeasureSpec", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/font/IFontManager$b;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", HippyTKDListViewAdapter.X, "y", "b", "(II)Ljava/lang/Integer;", "Ly03/a;", "info", "f", "Lkotlin/Function1;", "block", "setLoadedListener", "t", "Lcom/etrump/mixlayout/k;", "d", "Lcom/etrump/mixlayout/k;", "curFontInfo", "I", MessageForRichState.SIGN_MSG_FONT_ID, MessageForRichState.SIGN_MSG_FONT_TYPE, h.F, "Z", "isTroop", "i", "Ljava/lang/String;", "uin", "", "J", "diyTimestamp", BdhLogUtil.LogTag.Tag_Conn, "isSend", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "loaderSucessCallback", "Lcom/tencent/mobileqq/vas/font/drawable/ETDrawable;", "E", "Lcom/tencent/mobileqq/vas/font/drawable/ETDrawable;", "curETDrawable", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "loadCallback", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "fontDrawableInfo", "<init>", "(Lcom/tencent/mobileqq/vas/font/IFontManager$c;)V", "G", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class FontAnimDrawable extends AbsAsyncDrawable implements y03.c {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isSend;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ILoaderSucessCallback loaderSucessCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ETDrawable curETDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<? super y03.c, Unit> loadCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k curFontInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int fontId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int fontType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isTroop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long diyTimestamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/font/drawable/FontAnimDrawable$b", "Lcom/tencent/mobileqq/vas/font/manager/FontInfoManager$b;", "Lcom/etrump/mixlayout/k;", "fontInfo", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements FontInfoManager.b {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.font.manager.FontInfoManager.b
        public void a(@NotNull k fontInfo) {
            Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
            FontAnimDrawable.this.curFontInfo = fontInfo;
            ILoaderSucessCallback iLoaderSucessCallback = FontAnimDrawable.this.loaderSucessCallback;
            if (iLoaderSucessCallback != null) {
                iLoaderSucessCallback.onLoadSucceed();
            }
        }
    }

    public FontAnimDrawable(@NotNull final IFontManager.FontDrawableInfo fontDrawableInfo) {
        Intrinsics.checkNotNullParameter(fontDrawableInfo, "fontDrawableInfo");
        this.fontId = fontDrawableInfo.getFontId();
        this.fontType = fontDrawableInfo.getFontType();
        this.isTroop = fontDrawableInfo.getIsTroop();
        this.uin = fontDrawableInfo.getUin();
        this.diyTimestamp = fontDrawableInfo.getDiyTimestamp();
        this.isSend = fontDrawableInfo.getIsSend();
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.font.drawable.FontAnimDrawable.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        setTargetDrawableBuild(new Function0<ETDrawable>() { // from class: com.tencent.mobileqq.vas.font.drawable.FontAnimDrawable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ETDrawable invoke() {
                k kVar = FontAnimDrawable.this.curFontInfo;
                if (kVar == null) {
                    return null;
                }
                FontAnimDrawable fontAnimDrawable = FontAnimDrawable.this;
                fontAnimDrawable.curETDrawable = new ETDrawable(kVar, fontDrawableInfo);
                Function1 function1 = fontAnimDrawable.loadCallback;
                if (function1 != null) {
                    ETDrawable eTDrawable = fontAnimDrawable.curETDrawable;
                    Intrinsics.checkNotNull(eTDrawable);
                }
                return fontAnimDrawable.curETDrawable;
            }
        });
        D();
        load(false);
    }

    private final void D() {
        FontInfoManager.Companion companion = FontInfoManager.INSTANCE;
        companion.b().m(this.fontId, new b());
        this.curFontInfo = companion.b().w(this.fontId, this.fontType, this.isTroop, this.uin, this.diyTimestamp, this.isSend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Drawable.Callback callback) {
        ((View) callback).requestLayout();
    }

    @Override // y03.c
    @Nullable
    public ArrayList<Rect> a() {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            return eTDrawable.a();
        }
        return null;
    }

    @Override // y03.c
    @Nullable
    public Integer b(int x16, int y16) {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            return eTDrawable.b(x16, y16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getIsLoadSuccess()) {
            callback.onLoadSucceed();
        } else {
            this.loaderSucessCallback = callback;
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        canvas.drawColor(SupportMenu.CATEGORY_MASK);
        canvas.restore();
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable != null) {
            if (getCurrentDrawable() instanceof ETDrawable) {
                Drawable currentDrawable2 = getCurrentDrawable();
                Intrinsics.checkNotNull(currentDrawable2, "null cannot be cast to non-null type com.tencent.mobileqq.vas.font.drawable.ETDrawable");
                ((ETDrawable) currentDrawable2).q(canvas.getWidth(), canvas.getHeight());
            }
            currentDrawable.setBounds(getBounds());
            currentDrawable.draw(canvas);
        }
    }

    @Override // y03.c
    @NotNull
    public IFontManager.DrawableResultInfo e(@NotNull Canvas canvas) {
        IFontManager.DrawableResultInfo drawableResultInfo;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            drawableResultInfo = eTDrawable.e(canvas);
        } else {
            drawableResultInfo = null;
        }
        if (drawableResultInfo != null) {
            return drawableResultInfo;
        }
        return new IFontManager.DrawableResultInfo(false, false, 0);
    }

    @Override // y03.c
    public void f(@NotNull AIOTextViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            eTDrawable.f(info);
        }
    }

    @Override // y03.c
    public void g() {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            eTDrawable.g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        final Drawable.Callback callback = getCallback();
        if (this.curETDrawable != null && (callback instanceof View)) {
            ((View) callback).post(new Runnable() { // from class: com.tencent.mobileqq.vas.font.drawable.d
                @Override // java.lang.Runnable
                public final void run() {
                    FontAnimDrawable.E(callback);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.curFontInfo != null) {
            return true;
        }
        return false;
    }

    @Override // y03.c
    public void j(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            eTDrawable.j(padding);
        }
    }

    @Override // y03.c
    public void m() {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            eTDrawable.m();
        }
    }

    @Override // y03.c
    @NotNull
    public String n() {
        String fontPath = ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getFontPath(this.fontId);
        Intrinsics.checkNotNullExpressionValue(fontPath, "fontBusiness.getFontPath(fontId)");
        return fontPath;
    }

    @Override // y03.c
    public boolean o() {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable == null || !eTDrawable.o()) {
            return false;
        }
        return true;
    }

    @Override // y03.c
    @Nullable
    public int[] q(int widthMeasureSpec, int heightMeasureSpec) {
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            return eTDrawable.q(widthMeasureSpec, heightMeasureSpec);
        }
        return null;
    }

    @Override // y03.c
    public void setLoadedListener(@NotNull Function1<? super y03.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
        ETDrawable eTDrawable = this.curETDrawable;
        if (eTDrawable != null) {
            block.invoke(eTDrawable);
        }
    }

    @Override // y03.c
    public boolean t() {
        return true;
    }
}
