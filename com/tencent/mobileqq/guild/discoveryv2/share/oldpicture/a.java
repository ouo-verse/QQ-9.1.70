package com.tencent.mobileqq.guild.discoveryv2.share.oldpicture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0006H\u0000\u001a\b\u0010\b\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000H\u0000\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0002\u00a8\u0006\f"}, d2 = {"Lvp1/dk;", "", "heightLimit", "originHeight", "", "c", "Landroid/view/View;", "e", "d", "Landroid/graphics/Bitmap;", "b", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    private static final Bitmap a(View view) {
        Object m476constructorimpl;
        String stackTraceToString;
        try {
            Result.Companion companion = Result.INSTANCE;
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            m476constructorimpl = Result.m476constructorimpl(createBitmap);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            String str = "drawSimpleBitmap error " + m479exceptionOrNullimpl + "\n" + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("View.drawToBitmapOld", 1, (String) it.next(), null);
            }
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (Bitmap) m476constructorimpl;
    }

    @Nullable
    public static final Bitmap b(@NotNull dk dkVar) {
        Integer intOrNull;
        int i3;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(dkVar, "<this>");
        int measuredHeight = dkVar.getRoot().getMeasuredHeight();
        int measuredWidth = dkVar.getRoot().getMeasuredWidth();
        if (measuredWidth > 0 && measuredHeight > 0) {
            Logger.f235387a.d().a("View.drawToBitmapOld", 1, "drawToBitmap rootOriginSize " + measuredHeight + " " + measuredWidth);
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(GuildAISearchConfBean.INSTANCE.a().getAndroidShareImageMaxHeight());
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 30000;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, measuredHeight);
            int i16 = coerceAtMost / 10;
            while (coerceAtMost > 0) {
                Logger logger = Logger.f235387a;
                logger.d().a("View.drawToBitmapOld", 1, "drawToBitmap trying with height: " + coerceAtMost);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    c(dkVar, coerceAtMost, measuredHeight);
                    FrameLayout root = dkVar.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "root");
                    Bitmap a16 = a(root);
                    if (a16 != null && !a16.isRecycled() && a16.getWidth() != 0 && a16.getHeight() != 0) {
                        logger.d().a("View.drawToBitmapOld", 1, "Successfully drew bitmap with height: " + coerceAtMost + " " + a16.getHeight());
                        return a16;
                    }
                    throw new RuntimeException("Invalid Bitmap " + a16);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                    if (m479exceptionOrNullimpl != null) {
                        Logger logger2 = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "Failed with height " + coerceAtMost + MsgSummary.STR_COLON + m479exceptionOrNullimpl;
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().b("View.drawToBitmapOld", 1, (String) it.next(), null);
                        }
                    }
                    coerceAtMost -= i16;
                }
            }
            Logger logger3 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("Failed to draw bitmap after multiple attempts with reduced height");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("View.drawToBitmapOld", 1, (String) it5.next(), null);
            }
            return null;
        }
        Logger logger4 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        String str2 = "Invalid view dimensions: " + measuredWidth + " x " + measuredHeight;
        if (str2 instanceof String) {
            bVar3.a().add(str2);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("View.drawToBitmapOld", 1, (String) it6.next(), null);
        }
        return null;
    }

    public static final void c(@NotNull dk dkVar, int i3, int i16) {
        boolean z16;
        int i17;
        Intrinsics.checkNotNullParameter(dkVar, "<this>");
        View guildShareLlmChatBottomShadow = dkVar.f442928e;
        Intrinsics.checkNotNullExpressionValue(guildShareLlmChatBottomShadow, "guildShareLlmChatBottomShadow");
        boolean z17 = true;
        int i18 = 0;
        if (i3 < i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        guildShareLlmChatBottomShadow.setVisibility(i17);
        LinearLayout guildShareLlmChatBottomShadowTips = dkVar.f442929f;
        Intrinsics.checkNotNullExpressionValue(guildShareLlmChatBottomShadowTips, "guildShareLlmChatBottomShadowTips");
        if (i3 >= i16) {
            z17 = false;
        }
        if (!z17) {
            i18 = 8;
        }
        guildShareLlmChatBottomShadowTips.setVisibility(i18);
        FrameLayout root = dkVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        e(root);
        if (i3 < 0 || dkVar.f442930g.getMeasuredHeight() <= i3) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = dkVar.f442930g.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = i3;
        dkVar.f442930g.setLayoutParams(layoutParams);
        FrameLayout root2 = dkVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "root");
        e(root2);
    }

    public static final int d() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public static final void e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.measure(d(), d());
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
