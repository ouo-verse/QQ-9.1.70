package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoPagStickerConfig;
import com.tencent.mobileqq.qqvideoedit.utils.j;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\f\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\b2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\b\u001a\u0006\u0010\u000b\u001a\u00020\u0000\u001a\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001\"(\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"(\u0010\u0019\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"(\u0010\u001c\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012\"(\u0010\u001f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012\"(\u0010\"\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018\"(\u0010%\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018\"(\u0010(\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018\"(\u0010)\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018\"(\u0010-\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012\"(\u00100\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012\"(\u00103\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012\",\u00106\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012\"(\u00109\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012\"(\u0010<\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012\"(\u0010?\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012\"(\u0010B\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012\"(\u0010H\u001a\u00020C*\u00020\u00002\u0006\u0010\u000e\u001a\u00020C8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\"(\u0010K\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012\"(\u0010N\u001a\u00020C*\u00020\u00002\u0006\u0010\u000e\u001a\u00020C8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010E\"\u0004\bM\u0010G\"(\u0010Q\u001a\u00020C*\u00020\u00002\u0006\u0010\u000e\u001a\u00020C8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010E\"\u0004\bP\u0010G\"(\u0010T\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bR\u0010\u0010\"\u0004\bS\u0010\u0012\",\u0010W\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bU\u0010\u0010\"\u0004\bV\u0010\u0012\",\u0010Z\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012\"(\u0010`\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_\"(\u0010c\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_\"(\u0010f\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010]\"\u0004\be\u0010_\"(\u0010i\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bg\u0010]\"\u0004\bh\u0010_\"(\u0010l\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bj\u0010]\"\u0004\bk\u0010_\"(\u0010o\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bm\u0010]\"\u0004\bn\u0010_\"(\u0010r\u001a\u00020[*\u00020\u00002\u0006\u0010\u000e\u001a\u00020[8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bp\u0010]\"\u0004\bq\u0010_\"(\u0010x\u001a\u00020s*\u00020\u00002\u0006\u0010\u000e\u001a\u00020s8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w\"(\u0010{\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\by\u0010\u0010\"\u0004\bz\u0010\u0012\"(\u0010~\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b|\u0010\u0016\"\u0004\b}\u0010\u0018\u00a8\u0006\u007f"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "categoryId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoPagStickerConfig;", DownloadInfo.spKey_Config, "k0", "", "materials", "B", "G", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "H", "value", "o", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "Z", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "frameStickerId", "", "D", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setFrameSticker", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isFrameSticker", "y", "i0", "topFrameStickerPath", "d", "M", "bottomFrameStickerPath", UserInfo.SEX_FEMALE, "h0", "isTextSticker", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.LATITUDE_SOUTH, "isFirstTimeEditSticker", "E", "g0", "isTextReady", "isFirstLine", BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "j0", "type", "g", "P", "configJsonPath", "k", "V", MessageForRichState.SIGN_MSG_FONT_ID, "l", "W", "fontPath", "j", "U", "fontFamilyForSticker", DomainData.DOMAIN_NAME, "Y", "fontStyleForSticker", "i", "T", "fontFamilyForPagView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "X", "fontStyleForPagView", "", HippyTKDListViewAdapter.X, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setTextJustification", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "textJustification", tl.h.F, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "content", "w", "f0", "textColor", "c", "J", "backgroundColor", "t", "d0", Constants.PAG_FILE_PATH, "getBlurTextPath", "K", "blurTextPath", "getBlurTexturePath", "L", "blurTexturePath", "", "v", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "e0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "scale", ReportConstant.COSTREPORT_PREFIX, "c0", "originScale", "b", "I", "angle", "e", "N", "centerX", "f", "O", "centerY", "r", "b0", "minScale", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a0", "maxScale", "", "u", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)J", "setPlayEndDuration", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;J)V", "playEndDuration", "a", "setActionType", "actionType", "p", "setHasMoved", "hasMoved", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h {
    public static final void A(@NotNull MetaMaterial metaMaterial, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        com.tencent.mobileqq.qqvideoedit.editor.b.v(metaMaterial, categoryId);
        int hashCode = categoryId.hashCode();
        if (hashCode != -921884268) {
            if (hashCode != -907563552) {
                if (hashCode == 793913343 && categoryId.equals("CATEGORY_TEXT_PATTERN")) {
                    h0(metaMaterial, true);
                    String S = VideoEditorResourceManager.L().S(metaMaterial);
                    Intrinsics.checkNotNullExpressionValue(S, "getInstance().getTextConfigJsonPath(this)");
                    P(metaMaterial, S);
                    String W = VideoEditorResourceManager.L().W(metaMaterial);
                    Intrinsics.checkNotNullExpressionValue(W, "getInstance().getTextPagContentPath(this)");
                    d0(metaMaterial, W);
                    String string = RFWApplication.getApplication().getResources().getString(R.string.yma);
                    Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026tor_text_default_content)");
                    Q(metaMaterial, string);
                    e0(metaMaterial, 0.8f);
                    return;
                }
            } else if (categoryId.equals("CATEGORY_TEXT_STYLE")) {
                h0(metaMaterial, true);
                String T = VideoEditorResourceManager.L().T();
                Intrinsics.checkNotNullExpressionValue(T, "getInstance().textDefaultConfigJsonPath");
                P(metaMaterial, T);
                String U = VideoEditorResourceManager.L().U();
                Intrinsics.checkNotNullExpressionValue(U, "getInstance().textDefaultPagPath");
                d0(metaMaterial, U);
                String id5 = metaMaterial.f30533id;
                Intrinsics.checkNotNullExpressionValue(id5, "id");
                V(metaMaterial, id5);
                String string2 = RFWApplication.getApplication().getResources().getString(R.string.yma);
                Intrinsics.checkNotNullExpressionValue(string2, "getApplication().resourc\u2026tor_text_default_content)");
                Q(metaMaterial, string2);
                e0(metaMaterial, 0.8f);
                return;
            }
        } else if (categoryId.equals("CATEGORY_TEXT_DECOR")) {
            h0(metaMaterial, true);
            String S2 = VideoEditorResourceManager.L().S(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(S2, "getInstance().getTextConfigJsonPath(this)");
            P(metaMaterial, S2);
            String W2 = VideoEditorResourceManager.L().W(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(W2, "getInstance().getTextPagContentPath(this)");
            d0(metaMaterial, W2);
            e0(metaMaterial, 0.5f);
            return;
        }
        com.tencent.mobileqq.qqvideoedit.editor.b.z(metaMaterial, 0);
        String W3 = VideoEditorResourceManager.L().W(metaMaterial);
        Intrinsics.checkNotNullExpressionValue(W3, "getInstance().getTextPagContentPath(this)");
        d0(metaMaterial, W3);
        String X = VideoEditorResourceManager.L().X(metaMaterial);
        Intrinsics.checkNotNullExpressionValue(X, "getInstance().getTopBianKuangStickerPath(this)");
        i0(metaMaterial, X);
        String D = VideoEditorResourceManager.L().D(metaMaterial);
        Intrinsics.checkNotNullExpressionValue(D, "getInstance().getBottomBianKuangStickerPath(this)");
        M(metaMaterial, D);
        e0(metaMaterial, 0.4f);
    }

    @NotNull
    public static final List<MetaMaterial> B(@NotNull String categoryId, @NotNull List<MetaMaterial> materials) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(materials, "materials");
        Iterator<MetaMaterial> it = materials.iterator();
        while (it.hasNext()) {
            A(it.next(), categoryId);
        }
        return materials;
    }

    public static final boolean C(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "isFirstTimeEditSticker") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean D(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return Intrinsics.areEqual(com.tencent.mobileqq.qqvideoedit.editor.b.l(metaMaterial, "isFrameSticker", "false"), "true");
    }

    public static final boolean E(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "isTextReady") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean F(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "isTextSticker") == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final MetaMaterial G() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "TEXT_DEFAULT_DEFAULT_ID";
        String string = RFWApplication.getApplication().getResources().getString(R.string.ymf);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026e_editor_text_thumb_text)");
        com.tencent.mobileqq.qqvideoedit.editor.b.A(metaMaterial, string);
        g0(metaMaterial, true);
        j0(metaMaterial, "plain_text");
        f0(metaMaterial, -1);
        A(metaMaterial, "CATEGORY_TEXT_STYLE");
        return metaMaterial;
    }

    @NotNull
    public static final MetaMaterial H(@NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = materialId;
        String string = RFWApplication.getApplication().getResources().getString(R.string.ymf);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026e_editor_text_thumb_text)");
        com.tencent.mobileqq.qqvideoedit.editor.b.A(metaMaterial, string);
        metaMaterial.thumbUrl = "thumbNon";
        g0(metaMaterial, true);
        return metaMaterial;
    }

    public static final void I(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "angle", Float.valueOf(f16));
    }

    public static final void J(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "backgroundColor", Integer.valueOf(i3));
    }

    public static final void K(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "blurTextPath", str);
    }

    public static final void L(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "blurTexturePath", str);
    }

    public static final void M(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "bottomFrameStickerPath", value);
    }

    public static final void N(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "centerX", Float.valueOf(f16));
    }

    public static final void O(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "centerY", Float.valueOf(f16));
    }

    public static final void P(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "configJsonPath", value);
    }

    public static final void Q(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "content", value);
    }

    public static final void R(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "exIsFirstLine", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void S(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "isFirstTimeEditSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void T(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontFamilyForPagView", value);
    }

    public static final void U(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontFamilyForSticker", value);
    }

    public static final void V(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontID", value);
    }

    public static final void W(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontPath", str);
    }

    public static final void X(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontStyleForPagView", value);
    }

    public static final void Y(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "fontStyleForSticker", value);
    }

    public static final void Z(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "frameStickerId", value);
    }

    @NotNull
    public static final String a(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "actionType");
    }

    public static final void a0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "maxScale", Float.valueOf(f16));
    }

    public static final float b(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "angle", 0.0f);
    }

    public static final void b0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "minScale", Float.valueOf(f16));
    }

    public static final int c(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "backgroundColor");
    }

    public static final void c0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "originScale", Float.valueOf(f16));
    }

    @NotNull
    public static final String d(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "bottomFrameStickerPath");
    }

    public static final void d0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, Constants.PAG_FILE_PATH, value);
    }

    public static final float e(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "centerX", 0.0f);
    }

    public static final void e0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "scale", Float.valueOf(f16));
    }

    public static final float f(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "centerY", 0.0f);
    }

    public static final void f0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "textColor", Integer.valueOf(i3));
    }

    @NotNull
    public static final String g(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "configJsonPath");
    }

    public static final void g0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "isTextReady", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String h(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "content");
    }

    public static final void h0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.qqvideoedit.editor.b.s(metaMaterial, "isTextSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String i(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontFamilyForPagView");
    }

    public static final void i0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "topFrameStickerPath", value);
    }

    @NotNull
    public static final String j(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontFamilyForSticker");
    }

    public static final void j0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.qqvideoedit.editor.b.t(metaMaterial, "type", value);
    }

    @NotNull
    public static final String k(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontID");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e9, code lost:
    
        if (r2 != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void k0(@NotNull MetaMaterial metaMaterial, @Nullable VideoPagStickerConfig videoPagStickerConfig) {
        boolean z16;
        String str;
        int hashCode;
        VideoPagStickerConfig.StyleConfig styleConfig;
        VideoPagStickerConfig.StyleConfig styleConfig2;
        boolean isBlank;
        PAGFile Load;
        VideoPagStickerConfig.FrameConfig frameConfig;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (!E(metaMaterial)) {
            if (videoPagStickerConfig != null && (frameConfig = videoPagStickerConfig.frameConfig) != null) {
                I(metaMaterial, frameConfig.angle);
                b0(metaMaterial, frameConfig.minScale);
                a0(metaMaterial, frameConfig.maxScale);
            }
            boolean z17 = false;
            W(metaMaterial, VideoEditorResourceManager.L().G(k(metaMaterial), 0));
            try {
                if (new File(t(metaMaterial)).exists()) {
                    Load = PagViewMonitor.Load(t(metaMaterial));
                } else {
                    Load = PagViewMonitor.Load(VideoEditorResourceManager.L().U());
                }
                if (Load.numTexts() > 0) {
                    String str2 = Load.getTextData(0).text;
                    Intrinsics.checkNotNullExpressionValue(str2, "pagFile.getTextData(0).text");
                    Q(metaMaterial, str2);
                    f0(metaMaterial, Load.getTextData(0).fillColor);
                    String str3 = Load.getTextData(0).fontFamily;
                    Intrinsics.checkNotNullExpressionValue(str3, "pagFile.getTextData(0).fontFamily");
                    U(metaMaterial, str3);
                    String str4 = Load.getTextData(0).fontStyle;
                    Intrinsics.checkNotNullExpressionValue(str4, "pagFile.getTextData(0).fontStyle");
                    Y(metaMaterial, str4);
                }
            } catch (Exception e16) {
                ms.a.d("TextMetaMaterial", "updateTextByPagConfig", e16);
            }
            String l3 = l(metaMaterial);
            if (l3 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(l3);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        PAGFont b16 = j.c().b(l(metaMaterial));
                        String str5 = b16.fontFamily;
                        Intrinsics.checkNotNullExpressionValue(str5, "pagFont.fontFamily");
                        T(metaMaterial, str5);
                        String str6 = b16.fontStyle;
                        Intrinsics.checkNotNullExpressionValue(str6, "pagFont.fontStyle");
                        X(metaMaterial, str6);
                        if (!Intrinsics.areEqual(com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial), "CATEGORY_TEXT_STYLE")) {
                            if (j(metaMaterial).length() == 0) {
                                z17 = true;
                            }
                        }
                        String str7 = b16.fontFamily;
                        Intrinsics.checkNotNullExpressionValue(str7, "pagFont.fontFamily");
                        U(metaMaterial, str7);
                        String str8 = b16.fontStyle;
                        Intrinsics.checkNotNullExpressionValue(str8, "pagFont.fontStyle");
                        Y(metaMaterial, str8);
                    }
                    if (videoPagStickerConfig == null) {
                        str = videoPagStickerConfig.type;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "fixed_text";
                    }
                    j0(metaMaterial, str);
                    String z18 = z(metaMaterial);
                    hashCode = z18.hashCode();
                    if (hashCode == 3027047) {
                        if (hashCode != 1021751938) {
                            if (hashCode == 1289680009 && z18.equals("color_text") && videoPagStickerConfig != null && (styleConfig2 = videoPagStickerConfig.styleConfig) != null) {
                                J(metaMaterial, Color.parseColor(styleConfig2.defaultColor));
                            }
                        } else if (z18.equals("plain_text") && videoPagStickerConfig != null && (styleConfig = videoPagStickerConfig.styleConfig) != null) {
                            f0(metaMaterial, Color.parseColor(styleConfig.defaultColor));
                        }
                    } else if (z18.equals("blur")) {
                        K(metaMaterial, VideoEditorResourceManager.L().B(metaMaterial));
                        L(metaMaterial, VideoEditorResourceManager.L().C(metaMaterial));
                    }
                    g0(metaMaterial, true);
                }
            }
            z16 = true;
            if (!z16) {
            }
            if (videoPagStickerConfig == null) {
            }
            if (str == null) {
            }
            j0(metaMaterial, str);
            String z182 = z(metaMaterial);
            hashCode = z182.hashCode();
            if (hashCode == 3027047) {
            }
            g0(metaMaterial, true);
        }
    }

    @Nullable
    public static final String l(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontPath");
    }

    @NotNull
    public static final String m(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontStyleForPagView");
    }

    @NotNull
    public static final String n(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "fontStyleForSticker");
    }

    @NotNull
    public static final String o(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "frameStickerId");
    }

    public static final boolean p(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "hasMoved") == 1) {
            return true;
        }
        return false;
    }

    public static final float q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "maxScale", 10.0f);
    }

    public static final float r(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "minScale", 0.2f);
    }

    public static final float s(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "originScale", 0.0f);
    }

    @NotNull
    public static final String t(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, Constants.PAG_FILE_PATH);
    }

    public static final long u(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.i(metaMaterial, "playEndDuration", -1L);
    }

    public static final float v(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.f(metaMaterial, "scale", 0.4f);
    }

    public static final int w(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.h(metaMaterial, "textColor");
    }

    public static final int x(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.g(metaMaterial, "textJustification", 1);
    }

    @NotNull
    public static final String y(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "topFrameStickerPath");
    }

    @NotNull
    public static final String z(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.qqvideoedit.editor.b.m(metaMaterial, "type");
    }
}
