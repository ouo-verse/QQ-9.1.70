package com.tencent.mobileqq.wink.editor;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.debug.WinkSmoothDebugMenuPart;
import com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart;
import com.tencent.mobileqq.wink.editor.challenge.WinkEditorChallengePart;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingMenuPartV2;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropMenuPart;
import com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicLyricCropPart;
import com.tencent.mobileqq.wink.editor.music.lyric.sticker.WinkEditorLyricStickerMenuPart;
import com.tencent.mobileqq.wink.editor.music.volume.WinkMusicVolumeControlPart;
import com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart;
import com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcMenuPart;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.WinkEditorNewStickerMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorSubtitleTextMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00eb\u00012\u00020\u0001:\u0001\u000bB=\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u0002008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010T\u001a\u00020N8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b:\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020N8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\"\u0010`\u001a\u00020Y8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010g\u001a\u00020a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bU\u0010d\"\u0004\be\u0010fR\"\u0010n\u001a\u00020h8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bi\u0010k\"\u0004\bl\u0010mR\"\u0010u\u001a\u00020o8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\bp\u0010r\"\u0004\bs\u0010tR\"\u0010z\u001a\u00020v8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010w\u001a\u0004\bb\u0010x\"\u0004\b\f\u0010yR$\u0010\u0081\u0001\u001a\u00020{8\u0006@\u0006X\u0086.\u00a2\u0006\u0013\n\u0004\b#\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0089\u0001\u001a\u00030\u0082\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R*\u0010\u0091\u0001\u001a\u00030\u008a\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R)\u0010\u0098\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0005\bG\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u009f\u0001\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b\u001d\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R,\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a0\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u00a1\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001\"\u0006\b\u00a4\u0001\u0010\u00a5\u0001R*\u0010\u00ae\u0001\u001a\u00030\u00a7\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R*\u0010\u00b5\u0001\u001a\u00030\u00af\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R)\u0010\u00bc\u0001\u001a\u00030\u00b6\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\bV\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001\"\u0006\b\u00ba\u0001\u0010\u00bb\u0001R(\u0010\u00c2\u0001\u001a\u00030\u00bd\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0016\n\u0005\bP\u0010\u00be\u0001\u001a\u0005\b8\u0010\u00bf\u0001\"\u0006\b\u00c0\u0001\u0010\u00c1\u0001R)\u0010\u00c8\u0001\u001a\u00030\u00c3\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0006\b\u008d\u0001\u0010\u00c4\u0001\u001a\u0005\bZ\u0010\u00c5\u0001\"\u0006\b\u00c6\u0001\u0010\u00c7\u0001R)\u0010\u00ce\u0001\u001a\u00030\u00c9\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0006\b\u00aa\u0001\u0010\u00ca\u0001\u001a\u0005\b\u001b\u0010\u00cb\u0001\"\u0006\b\u00cc\u0001\u0010\u00cd\u0001R)\u0010\u00d4\u0001\u001a\u00030\u00cf\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0006\b\u00b1\u0001\u0010\u00d0\u0001\u001a\u0005\b!\u0010\u00d1\u0001\"\u0006\b\u00d2\u0001\u0010\u00d3\u0001R)\u0010\u00da\u0001\u001a\u00030\u00d5\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b\\\u0010\u00d6\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00d7\u0001\"\u0006\b\u00d8\u0001\u0010\u00d9\u0001R*\u0010\u00e2\u0001\u001a\u00030\u00db\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001\u001a\u0006\b\u00de\u0001\u0010\u00df\u0001\"\u0006\b\u00e0\u0001\u0010\u00e1\u0001R)\u0010\u00e8\u0001\u001a\u00030\u00e3\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\bA\u0010\u00e4\u0001\u001a\u0006\b\u00dc\u0001\u0010\u00e5\u0001\"\u0006\b\u00e6\u0001\u0010\u00e7\u0001R)\u0010\u00ef\u0001\u001a\u00030\u00e9\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\bI\u0010\u00ea\u0001\u001a\u0006\b\u00eb\u0001\u0010\u00ec\u0001\"\u0006\b\u00ed\u0001\u0010\u00ee\u0001R*\u0010\u00f5\u0001\u001a\u00030\u00f0\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u00b8\u0001\u0010\u00f1\u0001\u001a\u0006\b\u0093\u0001\u0010\u00f2\u0001\"\u0006\b\u00f3\u0001\u0010\u00f4\u0001R,\u0010\u00fb\u0001\u001a\u0005\u0018\u00010\u00f6\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a2\u0001\u0010\u00f7\u0001\u001a\u0006\b\u008b\u0001\u0010\u00f8\u0001\"\u0006\b\u00f9\u0001\u0010\u00fa\u0001R*\u0010\u0081\u0002\u001a\u00030\u00fc\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u00de\u0001\u0010\u00fd\u0001\u001a\u0006\b\u0083\u0001\u0010\u00fe\u0001\"\u0006\b\u00ff\u0001\u0010\u0080\u0002R*\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b}\u0010\u0083\u0002\u001a\u0005\b)\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002\u00a8\u0006\u008a\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/cx;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "Lcom/tencent/mobileqq/wink/editor/d;", "c", "Lc73/a;", ReportConstant.COSTREPORT_PREFIX, "", "P", "a", "Z", "isZShowTemplate", "b", "isOpeningEndingEditMode", "isShowDailyNextBtnPart", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "getOpenEndFinishBtnOnClick", "()Lkotlin/jvm/functions/Function0;", "openEndFinishBtnOnClick", "e", "getOpenEndBackBtnOnClick", "openEndBackBtnOnClick", "f", "Ljava/util/List;", HippyTKDListViewAdapter.X, "()Ljava/util/List;", "parts", "Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "g", "Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "t", "()Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "c0", "(Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;)V", "nextBtnPart", "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2;", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2;", "i", "()Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingMenuPartV2;)V", "clippingMenuPart", "Lcom/tencent/mobileqq/wink/editor/menu/u;", "Lcom/tencent/mobileqq/wink/editor/menu/u;", "k", "()Lcom/tencent/mobileqq/wink/editor/menu/u;", "U", "(Lcom/tencent/mobileqq/wink/editor/menu/u;)V", "dashboardMenuPart", "Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterMenuPart;", "j", "Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterMenuPart;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterMenuPart;", "W", "(Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterMenuPart;)V", "filterMenuPart", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "I", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "p0", "(Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;)V", "textMenuPart", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2;", "l", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2;", "J", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2;", "q0", "(Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2;)V", "textMenuPartV2", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;", "j0", "(Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;)V", "stickerOldMenuPart", DomainData.DOMAIN_NAME, "B", "i0", "stickerMenuPart", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorVideoTemplateMenuPart;", "o", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorVideoTemplateMenuPart;", "G", "()Lcom/tencent/mobileqq/wink/editor/template/WinkEditorVideoTemplateMenuPart;", "n0", "(Lcom/tencent/mobileqq/wink/editor/template/WinkEditorVideoTemplateMenuPart;)V", "templateMenuPart", "Lcom/tencent/mobileqq/wink/editor/template/ae;", "p", "Lcom/tencent/mobileqq/wink/editor/template/ae;", "()Lcom/tencent/mobileqq/wink/editor/template/ae;", "X", "(Lcom/tencent/mobileqq/wink/editor/template/ae;)V", "firstTemplateMenuPart", "Lcom/tencent/mobileqq/wink/editor/music/ab;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/wink/editor/music/ab;", "()Lcom/tencent/mobileqq/wink/editor/music/ab;", "a0", "(Lcom/tencent/mobileqq/wink/editor/music/ab;)V", "musicMenuPart", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;", "r", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;", "()Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;", "b0", "(Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;)V", "musicMenuPartV2", "Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart;", "Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart;", "()Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart;", "(Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkMusicLyricCropPart;)V", "musicLyricPart", "Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart;", "Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart;", "N", "()Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart;", "t0", "(Lcom/tencent/mobileqq/wink/editor/music/volume/WinkMusicVolumeControlPart;)V", "winkMusicVolumeControlPart", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart;", "u", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart;", "h0", "(Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerControlPart;)V", "stickerControlPart", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart;", "v", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart;", "D", "()Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart;", "k0", "(Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart;)V", "stickerTimelinePart", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart;", "w", "Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart;", "()Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart;", "V", "(Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart;)V", "effectTimelinePart", "Lm73/b;", "Lm73/b;", "y", "()Lm73/b;", "f0", "(Lm73/b;)V", "seekbarPart", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart;", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart;", "L", "()Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart;", "setWinkEditorLyricStickerMenuPart", "(Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart;)V", "winkEditorLyricStickerMenuPart", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart;", "E", "()Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart;", "l0", "(Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart;)V", "subtitleMenuPart", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart;", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart;", "m0", "(Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorSubtitleTextMenuPart;)V", "subtitleTextMenuPart", "Lcom/tencent/mobileqq/wink/editor/tts/d;", "Lcom/tencent/mobileqq/wink/editor/tts/d;", "K", "()Lcom/tencent/mobileqq/wink/editor/tts/d;", "r0", "(Lcom/tencent/mobileqq/wink/editor/tts/d;)V", "ttsMenuPart", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart;", "()Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart;", "T", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropMenuPart;)V", "cropMenuPart", "Lcom/tencent/mobileqq/wink/editor/mosaic/h;", "Lcom/tencent/mobileqq/wink/editor/mosaic/h;", "()Lcom/tencent/mobileqq/wink/editor/mosaic/h;", "Y", "(Lcom/tencent/mobileqq/wink/editor/mosaic/h;)V", "mosaicMenuPart", "Lcom/tencent/mobileqq/wink/editor/aielimination/v;", "Lcom/tencent/mobileqq/wink/editor/aielimination/v;", "()Lcom/tencent/mobileqq/wink/editor/aielimination/v;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcom/tencent/mobileqq/wink/editor/aielimination/v;)V", "aiElimination", "Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;", "Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;", "()Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;", BdhLogUtil.LogTag.Tag_Req, "(Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;)V", "aiTemplatePart", "Lcom/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart;", "Lcom/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart;", "()Lcom/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart;", "g0", "(Lcom/tencent/mobileqq/wink/debug/WinkSmoothDebugMenuPart;)V", "smoothDebugMenuPart", "Lcom/tencent/mobileqq/wink/editor/template/w;", "H", "Lcom/tencent/mobileqq/wink/editor/template/w;", "M", "()Lcom/tencent/mobileqq/wink/editor/template/w;", "s0", "(Lcom/tencent/mobileqq/wink/editor/template/w;)V", "winkEditorTemplateTextMenuPart", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;", "()Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;", "o0", "(Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;)V", "templateTextListMenuPart", "Lcom/tencent/mobileqq/wink/editor/template/bh;", "Lcom/tencent/mobileqq/wink/editor/template/bh;", "O", "()Lcom/tencent/mobileqq/wink/editor/template/bh;", "u0", "(Lcom/tencent/mobileqq/wink/editor/template/bh;)V", "winkQzoneRecommendTemplateMenuPart", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateMenuPart;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateMenuPart;", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateMenuPart;", "e0", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateMenuPart;)V", "openingEndingTemplateMenuPart", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart;", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart;", "setOpeningEndingModelPart", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart;)V", "openingEndingModelPart", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;", "d0", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingAigcMenuPart;)V", "openingEndingAigcMenuPart", "Lcom/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart;", "Lcom/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart;", "()Lcom/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart;", "setChallengePart", "(Lcom/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart;)V", "challengePart", "<init>", "(ZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class cx {

    /* renamed from: O, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    public WinkEditorSubtitleTextMenuPart subtitleTextMenuPart;

    /* renamed from: B, reason: from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.tts.d ttsMenuPart;

    /* renamed from: C, reason: from kotlin metadata */
    public WinkEditorCropMenuPart cropMenuPart;

    /* renamed from: D, reason: from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.mosaic.h mosaicMenuPart;

    /* renamed from: E, reason: from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.aielimination.v aiElimination;

    /* renamed from: F, reason: from kotlin metadata */
    public WinkEditorAITemplateMenuPart aiTemplatePart;

    /* renamed from: G, reason: from kotlin metadata */
    public WinkSmoothDebugMenuPart smoothDebugMenuPart;

    /* renamed from: H, reason: from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.template.w winkEditorTemplateTextMenuPart;

    /* renamed from: I, reason: from kotlin metadata */
    public WinkEditorTemplateTextListMenuPart templateTextListMenuPart;

    /* renamed from: J, reason: from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.template.bh winkQzoneRecommendTemplateMenuPart;

    /* renamed from: K, reason: from kotlin metadata */
    public WinkEditorOpeningEndingTemplateMenuPart openingEndingTemplateMenuPart;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WinkEditorOpeningEndingModePart openingEndingModelPart;

    /* renamed from: M, reason: from kotlin metadata */
    public WinkEditorOpeningEndingAigcMenuPart openingEndingAigcMenuPart;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private WinkEditorChallengePart challengePart;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isZShowTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isOpeningEndingEditMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowDailyNextBtnPart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> openEndFinishBtnOnClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> openEndBackBtnOnClick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> parts;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public NextBtnPart nextBtnPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public WinkEditorClippingMenuPartV2 clippingMenuPart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.menu.u dashboardMenuPart;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public WinkEditorFilterMenuPart filterMenuPart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public WinkEditorTextMenuPart textMenuPart;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public WinkEditorTextMenuPartV2 textMenuPartV2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.sticker.sticker.a stickerOldMenuPart;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.sticker.sticker.a stickerMenuPart;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public WinkEditorVideoTemplateMenuPart templateMenuPart;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.template.ae firstTemplateMenuPart;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.wink.editor.music.ab musicMenuPart;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public WinkEditorMusicMenuPartV2 musicMenuPartV2;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public WinkMusicLyricCropPart musicLyricPart;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public WinkMusicVolumeControlPart winkMusicVolumeControlPart;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public WinkEditorStickerControlPart stickerControlPart;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public WinkEditorStickerTimelinePart stickerTimelinePart;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public WinkEditorEffectTimelinePart effectTimelinePart;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public m73.b seekbarPart;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkEditorLyricStickerMenuPart winkEditorLyricStickerMenuPart;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public WinkSubtitleMenuPart subtitleMenuPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/cx$a;", "", "", "d", "c", "f", "e", "", "b", "a", "NOT_Q_VIDEO", "I", "Q_VIDEO_AND_HIT_EXP", "Q_VIDEO_AND_NOT_HIT_EXP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.cx$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean c() {
            return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_fabuqi_yinyuejieruqyinresou");
        }

        private final boolean d() {
            return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_fabuqi_qukushiyongxintuijian");
        }

        public final int a() {
            if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                if (c()) {
                    return 1;
                }
                return 0;
            }
            return 2;
        }

        public final int b() {
            if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                if (d()) {
                    return 1;
                }
                return 0;
            }
            return 2;
        }

        public final boolean e() {
            if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_fabuqi_wenzigongnengjiaohudiedai") && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_fabuqiyinyuemianbandiedai") && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    public cx(boolean z16, boolean z17, boolean z18, @NotNull Function0<Unit> openEndFinishBtnOnClick, @NotNull Function0<Unit> openEndBackBtnOnClick) {
        Intrinsics.checkNotNullParameter(openEndFinishBtnOnClick, "openEndFinishBtnOnClick");
        Intrinsics.checkNotNullParameter(openEndBackBtnOnClick, "openEndBackBtnOnClick");
        this.isZShowTemplate = z16;
        this.isOpeningEndingEditMode = z17;
        this.isShowDailyNextBtnPart = z18;
        this.openEndFinishBtnOnClick = openEndFinishBtnOnClick;
        this.openEndBackBtnOnClick = openEndBackBtnOnClick;
        this.parts = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(cx this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openEndFinishBtnOnClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(cx this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openEndBackBtnOnClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final WinkEditorStickerControlPart A() {
        WinkEditorStickerControlPart winkEditorStickerControlPart = this.stickerControlPart;
        if (winkEditorStickerControlPart != null) {
            return winkEditorStickerControlPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stickerControlPart");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.sticker.sticker.a B() {
        com.tencent.mobileqq.wink.editor.sticker.sticker.a aVar = this.stickerMenuPart;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stickerMenuPart");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.sticker.sticker.a C() {
        com.tencent.mobileqq.wink.editor.sticker.sticker.a aVar = this.stickerOldMenuPart;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stickerOldMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorStickerTimelinePart D() {
        WinkEditorStickerTimelinePart winkEditorStickerTimelinePart = this.stickerTimelinePart;
        if (winkEditorStickerTimelinePart != null) {
            return winkEditorStickerTimelinePart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stickerTimelinePart");
        return null;
    }

    @NotNull
    public final WinkSubtitleMenuPart E() {
        WinkSubtitleMenuPart winkSubtitleMenuPart = this.subtitleMenuPart;
        if (winkSubtitleMenuPart != null) {
            return winkSubtitleMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subtitleMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorSubtitleTextMenuPart F() {
        WinkEditorSubtitleTextMenuPart winkEditorSubtitleTextMenuPart = this.subtitleTextMenuPart;
        if (winkEditorSubtitleTextMenuPart != null) {
            return winkEditorSubtitleTextMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subtitleTextMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorVideoTemplateMenuPart G() {
        WinkEditorVideoTemplateMenuPart winkEditorVideoTemplateMenuPart = this.templateMenuPart;
        if (winkEditorVideoTemplateMenuPart != null) {
            return winkEditorVideoTemplateMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorTemplateTextListMenuPart H() {
        WinkEditorTemplateTextListMenuPart winkEditorTemplateTextListMenuPart = this.templateTextListMenuPart;
        if (winkEditorTemplateTextListMenuPart != null) {
            return winkEditorTemplateTextListMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateTextListMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorTextMenuPart I() {
        WinkEditorTextMenuPart winkEditorTextMenuPart = this.textMenuPart;
        if (winkEditorTextMenuPart != null) {
            return winkEditorTextMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textMenuPart");
        return null;
    }

    @NotNull
    public final WinkEditorTextMenuPartV2 J() {
        WinkEditorTextMenuPartV2 winkEditorTextMenuPartV2 = this.textMenuPartV2;
        if (winkEditorTextMenuPartV2 != null) {
            return winkEditorTextMenuPartV2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textMenuPartV2");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.tts.d K() {
        com.tencent.mobileqq.wink.editor.tts.d dVar = this.ttsMenuPart;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ttsMenuPart");
        return null;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final WinkEditorLyricStickerMenuPart getWinkEditorLyricStickerMenuPart() {
        return this.winkEditorLyricStickerMenuPart;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.template.w M() {
        com.tencent.mobileqq.wink.editor.template.w wVar = this.winkEditorTemplateTextMenuPart;
        if (wVar != null) {
            return wVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateTextMenuPart");
        return null;
    }

    @NotNull
    public final WinkMusicVolumeControlPart N() {
        WinkMusicVolumeControlPart winkMusicVolumeControlPart = this.winkMusicVolumeControlPart;
        if (winkMusicVolumeControlPart != null) {
            return winkMusicVolumeControlPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("winkMusicVolumeControlPart");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.template.bh O() {
        com.tencent.mobileqq.wink.editor.template.bh bhVar = this.winkQzoneRecommendTemplateMenuPart;
        if (bhVar != null) {
            return bhVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("winkQzoneRecommendTemplateMenuPart");
        return null;
    }

    public final boolean P() {
        if (this.nextBtnPart != null) {
            return true;
        }
        return false;
    }

    public final void Q(@NotNull com.tencent.mobileqq.wink.editor.aielimination.v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.aiElimination = vVar;
    }

    public final void R(@NotNull WinkEditorAITemplateMenuPart winkEditorAITemplateMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorAITemplateMenuPart, "<set-?>");
        this.aiTemplatePart = winkEditorAITemplateMenuPart;
    }

    public final void S(@NotNull WinkEditorClippingMenuPartV2 winkEditorClippingMenuPartV2) {
        Intrinsics.checkNotNullParameter(winkEditorClippingMenuPartV2, "<set-?>");
        this.clippingMenuPart = winkEditorClippingMenuPartV2;
    }

    public final void T(@NotNull WinkEditorCropMenuPart winkEditorCropMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorCropMenuPart, "<set-?>");
        this.cropMenuPart = winkEditorCropMenuPart;
    }

    public final void U(@NotNull com.tencent.mobileqq.wink.editor.menu.u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<set-?>");
        this.dashboardMenuPart = uVar;
    }

    public final void V(@NotNull WinkEditorEffectTimelinePart winkEditorEffectTimelinePart) {
        Intrinsics.checkNotNullParameter(winkEditorEffectTimelinePart, "<set-?>");
        this.effectTimelinePart = winkEditorEffectTimelinePart;
    }

    public final void W(@NotNull WinkEditorFilterMenuPart winkEditorFilterMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorFilterMenuPart, "<set-?>");
        this.filterMenuPart = winkEditorFilterMenuPart;
    }

    public final void X(@NotNull com.tencent.mobileqq.wink.editor.template.ae aeVar) {
        Intrinsics.checkNotNullParameter(aeVar, "<set-?>");
        this.firstTemplateMenuPart = aeVar;
    }

    public final void Y(@NotNull com.tencent.mobileqq.wink.editor.mosaic.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.mosaicMenuPart = hVar;
    }

    public final void Z(@NotNull WinkMusicLyricCropPart winkMusicLyricCropPart) {
        Intrinsics.checkNotNullParameter(winkMusicLyricCropPart, "<set-?>");
        this.musicLyricPart = winkMusicLyricCropPart;
    }

    public final void a0(@NotNull com.tencent.mobileqq.wink.editor.music.ab abVar) {
        Intrinsics.checkNotNullParameter(abVar, "<set-?>");
        this.musicMenuPart = abVar;
    }

    public final void b0(@NotNull WinkEditorMusicMenuPartV2 winkEditorMusicMenuPartV2) {
        Intrinsics.checkNotNullParameter(winkEditorMusicMenuPartV2, "<set-?>");
        this.musicMenuPartV2 = winkEditorMusicMenuPartV2;
    }

    @NotNull
    public final List<d> c(@NotNull ViewModelStoreOwner owner) {
        NextBtnPart nextBtnPart;
        com.tencent.mobileqq.wink.editor.menu.u uVar;
        Intrinsics.checkNotNullParameter(owner, "owner");
        long currentTimeMillis = System.currentTimeMillis();
        this.parts.clear();
        if (this.isShowDailyNextBtnPart) {
            nextBtnPart = new DailyNextBtnPart();
        } else {
            nextBtnPart = new NextBtnPart();
        }
        c0(nextBtnPart);
        this.parts.add(t());
        if (com.tencent.mobileqq.wink.editor.menu.v.d()) {
            uVar = new com.tencent.mobileqq.wink.editor.menu.aq();
        } else {
            uVar = new com.tencent.mobileqq.wink.editor.menu.u();
        }
        U(uVar);
        this.parts.add(k());
        W(new WinkEditorFilterMenuPart());
        this.parts.add(m());
        Companion companion = INSTANCE;
        if (companion.e()) {
            q0(new WinkEditorTextMenuPartV2());
            this.parts.add(J());
        } else {
            p0(new WinkEditorTextMenuPart());
            this.parts.add(I());
        }
        i0(new WinkEditorNewStickerMenuPart());
        this.parts.add(B());
        j0(new com.tencent.mobileqq.wink.editor.sticker.sticker.g());
        this.parts.add(C());
        if (companion.f()) {
            b0(new WinkEditorMusicMenuPartV2());
            this.parts.add(r());
            Z(new WinkMusicLyricCropPart(owner));
            this.parts.add(p());
            t0(new WinkMusicVolumeControlPart(owner));
            this.parts.add(N());
        } else {
            a0(new com.tencent.mobileqq.wink.editor.music.ab());
            this.parts.add(q());
        }
        h0(new WinkEditorStickerControlPart());
        this.parts.add(A());
        k0(new WinkEditorStickerTimelinePart(this.isZShowTemplate));
        this.parts.add(D());
        V(new WinkEditorEffectTimelinePart());
        this.parts.add(l());
        n0(new WinkEditorVideoTemplateMenuPart());
        this.parts.add(G());
        X(new com.tencent.mobileqq.wink.editor.template.ae());
        this.parts.add(n());
        T(new WinkEditorCropMenuPart());
        this.parts.add(j());
        if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b()) {
            g0(new WinkSmoothDebugMenuPart());
            this.parts.add(z());
        }
        l0(new WinkSubtitleMenuPart());
        this.parts.add(E());
        m0(new WinkEditorSubtitleTextMenuPart());
        this.parts.add(F());
        r0(new com.tencent.mobileqq.wink.editor.tts.d());
        this.parts.add(K());
        s0(new com.tencent.mobileqq.wink.editor.template.w());
        this.parts.add(M());
        f0(new m73.b());
        this.parts.add(y());
        u0(new com.tencent.mobileqq.wink.editor.template.bh());
        this.parts.add(O());
        WinkEditorLyricStickerMenuPart winkEditorLyricStickerMenuPart = new WinkEditorLyricStickerMenuPart();
        this.winkEditorLyricStickerMenuPart = winkEditorLyricStickerMenuPart;
        List<d> list = this.parts;
        Intrinsics.checkNotNull(winkEditorLyricStickerMenuPart);
        list.add(winkEditorLyricStickerMenuPart);
        Y(new com.tencent.mobileqq.wink.editor.mosaic.h());
        this.parts.add(o());
        Q(new com.tencent.mobileqq.wink.editor.aielimination.v());
        this.parts.add(f());
        e0(new WinkEditorOpeningEndingTemplateMenuPart());
        this.parts.add(w());
        R(new WinkEditorAITemplateMenuPart());
        this.parts.add(g());
        if (this.isOpeningEndingEditMode) {
            WinkEditorOpeningEndingModePart winkEditorOpeningEndingModePart = new WinkEditorOpeningEndingModePart(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.cv
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cx.d(cx.this, view);
                }
            }, new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.cw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cx.e(cx.this, view);
                }
            });
            this.openingEndingModelPart = winkEditorOpeningEndingModePart;
            List<d> list2 = this.parts;
            Intrinsics.checkNotNull(winkEditorOpeningEndingModePart);
            list2.add(winkEditorOpeningEndingModePart);
            d0(new WinkEditorOpeningEndingAigcMenuPart());
            this.parts.add(u());
            this.parts.add(new com.tencent.mobileqq.wink.editor.openingending.ad());
            o0(new com.tencent.mobileqq.wink.editor.openingending.bc());
            this.parts.add(H());
        } else {
            if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                WinkEditorChallengePart winkEditorChallengePart = new WinkEditorChallengePart();
                this.challengePart = winkEditorChallengePart;
                List<d> list3 = this.parts;
                Intrinsics.checkNotNull(winkEditorChallengePart);
                list3.add(winkEditorChallengePart);
            }
            o0(new WinkEditorTemplateTextListMenuPart());
            this.parts.add(H());
            this.parts.add(new WinkEditorTemplateCollClippingMenuPart());
            S(new WinkEditorClippingMenuPartV2());
            this.parts.add(i());
        }
        w53.b.a("WinkEditorPartManager", "assemble cost: " + (System.currentTimeMillis() - currentTimeMillis));
        return this.parts;
    }

    public final void c0(@NotNull NextBtnPart nextBtnPart) {
        Intrinsics.checkNotNullParameter(nextBtnPart, "<set-?>");
        this.nextBtnPart = nextBtnPart;
    }

    public final void d0(@NotNull WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorOpeningEndingAigcMenuPart, "<set-?>");
        this.openingEndingAigcMenuPart = winkEditorOpeningEndingAigcMenuPart;
    }

    public final void e0(@NotNull WinkEditorOpeningEndingTemplateMenuPart winkEditorOpeningEndingTemplateMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorOpeningEndingTemplateMenuPart, "<set-?>");
        this.openingEndingTemplateMenuPart = winkEditorOpeningEndingTemplateMenuPart;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.aielimination.v f() {
        com.tencent.mobileqq.wink.editor.aielimination.v vVar = this.aiElimination;
        if (vVar != null) {
            return vVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aiElimination");
        return null;
    }

    public final void f0(@NotNull m73.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.seekbarPart = bVar;
    }

    @NotNull
    public final WinkEditorAITemplateMenuPart g() {
        WinkEditorAITemplateMenuPart winkEditorAITemplateMenuPart = this.aiTemplatePart;
        if (winkEditorAITemplateMenuPart != null) {
            return winkEditorAITemplateMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aiTemplatePart");
        return null;
    }

    public final void g0(@NotNull WinkSmoothDebugMenuPart winkSmoothDebugMenuPart) {
        Intrinsics.checkNotNullParameter(winkSmoothDebugMenuPart, "<set-?>");
        this.smoothDebugMenuPart = winkSmoothDebugMenuPart;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final WinkEditorChallengePart getChallengePart() {
        return this.challengePart;
    }

    public final void h0(@NotNull WinkEditorStickerControlPart winkEditorStickerControlPart) {
        Intrinsics.checkNotNullParameter(winkEditorStickerControlPart, "<set-?>");
        this.stickerControlPart = winkEditorStickerControlPart;
    }

    @NotNull
    public final WinkEditorClippingMenuPartV2 i() {
        WinkEditorClippingMenuPartV2 winkEditorClippingMenuPartV2 = this.clippingMenuPart;
        if (winkEditorClippingMenuPartV2 != null) {
            return winkEditorClippingMenuPartV2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clippingMenuPart");
        return null;
    }

    public final void i0(@NotNull com.tencent.mobileqq.wink.editor.sticker.sticker.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.stickerMenuPart = aVar;
    }

    @NotNull
    public final WinkEditorCropMenuPart j() {
        WinkEditorCropMenuPart winkEditorCropMenuPart = this.cropMenuPart;
        if (winkEditorCropMenuPart != null) {
            return winkEditorCropMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cropMenuPart");
        return null;
    }

    public final void j0(@NotNull com.tencent.mobileqq.wink.editor.sticker.sticker.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.stickerOldMenuPart = aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.menu.u k() {
        com.tencent.mobileqq.wink.editor.menu.u uVar = this.dashboardMenuPart;
        if (uVar != null) {
            return uVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dashboardMenuPart");
        return null;
    }

    public final void k0(@NotNull WinkEditorStickerTimelinePart winkEditorStickerTimelinePart) {
        Intrinsics.checkNotNullParameter(winkEditorStickerTimelinePart, "<set-?>");
        this.stickerTimelinePart = winkEditorStickerTimelinePart;
    }

    @NotNull
    public final WinkEditorEffectTimelinePart l() {
        WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = this.effectTimelinePart;
        if (winkEditorEffectTimelinePart != null) {
            return winkEditorEffectTimelinePart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("effectTimelinePart");
        return null;
    }

    public final void l0(@NotNull WinkSubtitleMenuPart winkSubtitleMenuPart) {
        Intrinsics.checkNotNullParameter(winkSubtitleMenuPart, "<set-?>");
        this.subtitleMenuPart = winkSubtitleMenuPart;
    }

    @NotNull
    public final WinkEditorFilterMenuPart m() {
        WinkEditorFilterMenuPart winkEditorFilterMenuPart = this.filterMenuPart;
        if (winkEditorFilterMenuPart != null) {
            return winkEditorFilterMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filterMenuPart");
        return null;
    }

    public final void m0(@NotNull WinkEditorSubtitleTextMenuPart winkEditorSubtitleTextMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorSubtitleTextMenuPart, "<set-?>");
        this.subtitleTextMenuPart = winkEditorSubtitleTextMenuPart;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.template.ae n() {
        com.tencent.mobileqq.wink.editor.template.ae aeVar = this.firstTemplateMenuPart;
        if (aeVar != null) {
            return aeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("firstTemplateMenuPart");
        return null;
    }

    public final void n0(@NotNull WinkEditorVideoTemplateMenuPart winkEditorVideoTemplateMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorVideoTemplateMenuPart, "<set-?>");
        this.templateMenuPart = winkEditorVideoTemplateMenuPart;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.mosaic.h o() {
        com.tencent.mobileqq.wink.editor.mosaic.h hVar = this.mosaicMenuPart;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mosaicMenuPart");
        return null;
    }

    public final void o0(@NotNull WinkEditorTemplateTextListMenuPart winkEditorTemplateTextListMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorTemplateTextListMenuPart, "<set-?>");
        this.templateTextListMenuPart = winkEditorTemplateTextListMenuPart;
    }

    @NotNull
    public final WinkMusicLyricCropPart p() {
        WinkMusicLyricCropPart winkMusicLyricCropPart = this.musicLyricPart;
        if (winkMusicLyricCropPart != null) {
            return winkMusicLyricCropPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("musicLyricPart");
        return null;
    }

    public final void p0(@NotNull WinkEditorTextMenuPart winkEditorTextMenuPart) {
        Intrinsics.checkNotNullParameter(winkEditorTextMenuPart, "<set-?>");
        this.textMenuPart = winkEditorTextMenuPart;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.editor.music.ab q() {
        com.tencent.mobileqq.wink.editor.music.ab abVar = this.musicMenuPart;
        if (abVar != null) {
            return abVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("musicMenuPart");
        return null;
    }

    public final void q0(@NotNull WinkEditorTextMenuPartV2 winkEditorTextMenuPartV2) {
        Intrinsics.checkNotNullParameter(winkEditorTextMenuPartV2, "<set-?>");
        this.textMenuPartV2 = winkEditorTextMenuPartV2;
    }

    @NotNull
    public final WinkEditorMusicMenuPartV2 r() {
        WinkEditorMusicMenuPartV2 winkEditorMusicMenuPartV2 = this.musicMenuPartV2;
        if (winkEditorMusicMenuPartV2 != null) {
            return winkEditorMusicMenuPartV2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("musicMenuPartV2");
        return null;
    }

    public final void r0(@NotNull com.tencent.mobileqq.wink.editor.tts.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.ttsMenuPart = dVar;
    }

    @Nullable
    public final c73.a s() {
        if (INSTANCE.f()) {
            if (this.musicMenuPartV2 == null) {
                return null;
            }
            return r();
        }
        if (this.musicMenuPart == null) {
            return null;
        }
        return q();
    }

    public final void s0(@NotNull com.tencent.mobileqq.wink.editor.template.w wVar) {
        Intrinsics.checkNotNullParameter(wVar, "<set-?>");
        this.winkEditorTemplateTextMenuPart = wVar;
    }

    @NotNull
    public final NextBtnPart t() {
        NextBtnPart nextBtnPart = this.nextBtnPart;
        if (nextBtnPart != null) {
            return nextBtnPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nextBtnPart");
        return null;
    }

    public final void t0(@NotNull WinkMusicVolumeControlPart winkMusicVolumeControlPart) {
        Intrinsics.checkNotNullParameter(winkMusicVolumeControlPart, "<set-?>");
        this.winkMusicVolumeControlPart = winkMusicVolumeControlPart;
    }

    @NotNull
    public final WinkEditorOpeningEndingAigcMenuPart u() {
        WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart = this.openingEndingAigcMenuPart;
        if (winkEditorOpeningEndingAigcMenuPart != null) {
            return winkEditorOpeningEndingAigcMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openingEndingAigcMenuPart");
        return null;
    }

    public final void u0(@NotNull com.tencent.mobileqq.wink.editor.template.bh bhVar) {
        Intrinsics.checkNotNullParameter(bhVar, "<set-?>");
        this.winkQzoneRecommendTemplateMenuPart = bhVar;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final WinkEditorOpeningEndingModePart getOpeningEndingModelPart() {
        return this.openingEndingModelPart;
    }

    @NotNull
    public final WinkEditorOpeningEndingTemplateMenuPart w() {
        WinkEditorOpeningEndingTemplateMenuPart winkEditorOpeningEndingTemplateMenuPart = this.openingEndingTemplateMenuPart;
        if (winkEditorOpeningEndingTemplateMenuPart != null) {
            return winkEditorOpeningEndingTemplateMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openingEndingTemplateMenuPart");
        return null;
    }

    @NotNull
    public final List<d> x() {
        return this.parts;
    }

    @NotNull
    public final m73.b y() {
        m73.b bVar = this.seekbarPart;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("seekbarPart");
        return null;
    }

    @NotNull
    public final WinkSmoothDebugMenuPart z() {
        WinkSmoothDebugMenuPart winkSmoothDebugMenuPart = this.smoothDebugMenuPart;
        if (winkSmoothDebugMenuPart != null) {
            return winkSmoothDebugMenuPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("smoothDebugMenuPart");
        return null;
    }
}
