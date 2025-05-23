package com.tencent.mobileqq.vas.font.impl;

import android.graphics.drawable.Drawable;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Comm_errKt;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mobileqq.vas.font.drawable.FontAnimDrawable;
import com.tencent.mobileqq.vas.font.drawable.c;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import d13.a;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/font/impl/FontManagerImpl;", "Lcom/tencent/mobileqq/vas/font/IFontManager;", "", "msg", "Landroid/graphics/drawable/Drawable;", "getFontTestDrawable", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "fontDrawableInfo", "getFontDrawable", "", "isNeedFontDrawable", "", MessageForRichState.SIGN_MSG_FONT_ID, "checkFontFile", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "startDownload", "", "subFontId", "checkMagicFont", "uid", "msgId", "parseMagicFont", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class FontManagerImpl implements IFontManager {

    @NotNull
    private static final ArrayList<Integer> FZ_BLACK_LIST;

    @NotNull
    private static final ArrayList<IFontManager.FontDrawableInfo> fontDrawableInfoList;
    private static final boolean isEnable;

    @NotNull
    private static final ArrayList<FontAnimDrawable> list;
    private static int testId;

    static {
        ArrayList<Integer> arrayListOf;
        ArrayList<IFontManager.FontDrawableInfo> arrayList = new ArrayList<>();
        fontDrawableInfoList = arrayList;
        list = new ArrayList<>();
        isEnable = ar.INSTANCE.b("anzaihuang", "2024-05-14", "vas_fz_black_bug_514").isEnable(false);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(10049, Integer.valueOf(Comm_errKt.QZRetCode_QZ_IMS_SPACE_EXCEED_LIMIT));
        FZ_BLACK_LIST = arrayListOf;
        arrayList.add(new IFontManager.FontDrawableInfo("", 20288, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20294, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20296, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20376, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20425, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20429, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20338, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20343, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20359, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 12708, 1, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20079, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", IjkMediaPlayer.FFP_PROP_INT64_IMMEDIATE_RECONNECT, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", ErrorCode.ERROR_FAILED_GET_POST, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20113, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20118, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", 20137, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
        arrayList.add(new IFontManager.FontDrawableInfo("", ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE, 4, false, "", System.currentTimeMillis(), 0L, 64, null));
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    public boolean checkFontFile(int fontId) {
        String replace$default;
        boolean isFileExists = ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).isFileExists(fontId);
        if (!isFileExists) {
            replace$default = StringsKt__StringsJVMKt.replace$default(VasFontReporter.ERROR_DRAW_FILE_EXIST, "{id}", String.valueOf(fontId), false, 4, (Object) null);
            VasFontReporter.INSTANCE.report(replace$default);
        }
        return isFileExists;
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    public boolean checkMagicFont(long subFontId) {
        if (((subFontId >> 24) & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    @Nullable
    public Drawable getFontDrawable(@NotNull IFontManager.FontDrawableInfo fontDrawableInfo) {
        Intrinsics.checkNotNullParameter(fontDrawableInfo, "fontDrawableInfo");
        if (fontDrawableInfo.getFontType() == 2) {
            return new c(fontDrawableInfo);
        }
        if (isEnable && FZ_BLACK_LIST.contains(Integer.valueOf(fontDrawableInfo.getFontId()))) {
            return new c(fontDrawableInfo);
        }
        int fontId = fontDrawableInfo.getFontId();
        FontBusiness fontBusiness = (FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class);
        if (!new File(fontBusiness.getFontPath(fontId)).exists()) {
            fontBusiness.startDownload(fontId);
            return null;
        }
        return new FontAnimDrawable(fontDrawableInfo);
    }

    @Nullable
    public final Drawable getFontTestDrawable(@NotNull CharSequence msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ArrayList<IFontManager.FontDrawableInfo> arrayList = fontDrawableInfoList;
        int i3 = testId;
        testId = i3 + 1;
        IFontManager.FontDrawableInfo fontDrawableInfo = arrayList.get(i3 % arrayList.size());
        Intrinsics.checkNotNullExpressionValue(fontDrawableInfo, "fontDrawableInfoList.get\u2026ontDrawableInfoList.size)");
        IFontManager.FontDrawableInfo fontDrawableInfo2 = fontDrawableInfo;
        fontDrawableInfo2.x(msg2);
        fontDrawableInfo2.y(System.currentTimeMillis());
        return getFontDrawable(fontDrawableInfo2);
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    public boolean isNeedFontDrawable(@NotNull IFontManager.FontDrawableInfo fontDrawableInfo) {
        Intrinsics.checkNotNullParameter(fontDrawableInfo, "fontDrawableInfo");
        int fontType = fontDrawableInfo.getFontType();
        if (fontType == 1 || fontType == 4 || fontType == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    @NotNull
    public CharSequence parseMagicFont(@NotNull CharSequence msg2, long uid, long msgId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return a.INSTANCE.a().g(msg2, uid, msgId);
    }

    @Override // com.tencent.mobileqq.vas.font.IFontManager
    public void startDownload(int fontId, @NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).startDownload(fontId);
    }
}
