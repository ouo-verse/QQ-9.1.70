package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.sticker.WinkPagStickerConfig;
import com.tencent.mobileqq.wink.utils.w;
import com.tencent.mobileqq.wink.utils.x;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import qshadow.ShadowStickerSearch$AdditionalEntry;
import qshadow.ShadowStickerSearch$CircleEditFirstSearchRsp;
import qshadow.ShadowStickerSearch$MaterialInfo;
import qshadow.ShadowStickerSearch$QQExpressionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bV\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0010\t\n\u0002\b\u001a\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0006\u0010\u0002\u001a\u00020\u00012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t\u001a\u0006\u0010\f\u001a\u00020\u0000\u001a,\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010\u001a\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0001\u001a6\u0010\u001e\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b\u001a\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u001a\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\t*\u00020!2\u0006\u0010\"\u001a\u00020\u0001\"\u0014\u0010&\u001a\u00020\u00018\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010(\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'\"(\u0010.\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\"(\u00103\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102\"(\u00106\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b4\u00100\"\u0004\b5\u00102\"(\u00108\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010+\"\u0004\b7\u0010-\"(\u0010;\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-\"(\u0010>\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b<\u00100\"\u0004\b=\u00102\"(\u0010A\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b?\u00100\"\u0004\b@\u00102\"(\u0010D\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u00100\"\u0004\bC\u00102\"(\u0010G\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u00100\"\u0004\bF\u00102\"(\u0010J\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bH\u00100\"\u0004\bI\u00102\"(\u0010M\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u00100\"\u0004\bL\u00102\"(\u0010P\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bN\u00100\"\u0004\bO\u00102\"(\u0010S\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bQ\u00100\"\u0004\bR\u00102\"(\u0010V\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u00100\"\u0004\bU\u00102\"(\u0010Y\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bW\u00100\"\u0004\bX\u00102\"(\u0010\\\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bZ\u0010+\"\u0004\b[\u0010-\"(\u0010_\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b]\u0010+\"\u0004\b^\u0010-\"(\u0010b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b`\u0010+\"\u0004\ba\u0010-\",\u0010e\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bc\u0010+\"\u0004\bd\u0010-\"(\u0010h\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bf\u0010+\"\u0004\bg\u0010-\"(\u0010k\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bi\u0010+\"\u0004\bj\u0010-\"(\u0010n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bl\u0010+\"\u0004\bm\u0010-\"(\u0010q\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bo\u0010+\"\u0004\bp\u0010-\"(\u0010v\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\br\u0010s\"\u0004\bt\u0010u\"(\u0010y\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bw\u0010+\"\u0004\bx\u0010-\",\u0010\u007f\u001a\u0004\u0018\u00010z*\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010z8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~\"+\u0010\u0082\u0001\u001a\u00020\u001b*\u00020\u00002\u0006\u0010)\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u00100\"\u0005\b\u0081\u0001\u00102\"+\u0010\u0085\u0001\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010s\"\u0005\b\u0084\u0001\u0010u\"+\u0010\u0088\u0001\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010s\"\u0005\b\u0087\u0001\u0010u\"+\u0010\u008b\u0001\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010s\"\u0005\b\u008a\u0001\u0010u\"+\u0010\u008e\u0001\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010s\"\u0005\b\u008d\u0001\u0010u\"+\u0010\u0091\u0001\u001a\u00020\u0019*\u00020\u00002\u0006\u0010)\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010s\"\u0005\b\u0090\u0001\u0010u\"/\u0010\u0097\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001\"+\u0010\u009a\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0098\u0001\u0010+\"\u0005\b\u0099\u0001\u0010-\"/\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010+\"\u0005\b\u009c\u0001\u0010-\"/\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010+\"\u0005\b\u009f\u0001\u0010-\"/\u0010\u00a3\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00a1\u0001\u0010\u0094\u0001\"\u0006\b\u00a2\u0001\u0010\u0096\u0001\"/\u0010\u00a6\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00a4\u0001\u0010\u0094\u0001\"\u0006\b\u00a5\u0001\u0010\u0096\u0001\"/\u0010\u00a9\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00a7\u0001\u0010\u0094\u0001\"\u0006\b\u00a8\u0001\u0010\u0096\u0001\"/\u0010\u00ac\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00aa\u0001\u0010\u0094\u0001\"\u0006\b\u00ab\u0001\u0010\u0096\u0001\"/\u0010\u00af\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010\u0094\u0001\"\u0006\b\u00ae\u0001\u0010\u0096\u0001\"/\u0010\u00b2\u0001\u001a\u00030\u0092\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u0092\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00b0\u0001\u0010\u0094\u0001\"\u0006\b\u00b1\u0001\u0010\u0096\u0001\"/\u0010\u00b8\u0001\u001a\u00030\u00b3\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u00b3\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001\"+\u0010\u00bb\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b9\u0001\u0010+\"\u0005\b\u00ba\u0001\u0010-\"/\u0010\u00be\u0001\u001a\u00030\u00b3\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u00b3\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00bc\u0001\u0010\u00b5\u0001\"\u0006\b\u00bd\u0001\u0010\u00b7\u0001\"+\u0010\u00c1\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010)\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00bf\u0001\u0010+\"\u0005\b\u00c0\u0001\u0010-\"/\u0010\u00c4\u0001\u001a\u00030\u00b3\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u00b3\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00c2\u0001\u0010\u00b5\u0001\"\u0006\b\u00c3\u0001\u0010\u00b7\u0001\"/\u0010\u00c7\u0001\u001a\u00030\u00b3\u0001*\u00020\u00002\u0007\u0010)\u001a\u00030\u00b3\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00c5\u0001\u0010\u00b5\u0001\"\u0006\b\u00c6\u0001\u0010\u00b7\u0001\"\u0017\u0010\u00c9\u0001\u001a\u00020\u001b*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00c8\u0001\u00100\"\u001e\u0010\u00cc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001\u00a8\u0006\u00cd\u0001"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "categoryId", "", "K", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkPagStickerConfig;", DownloadInfo.spKey_Config, "V0", "U0", "", "materials", "L", "a0", "Lcom/tencent/videocut/model/StickerModel;", "model", "pagPath", "", "", "extra", "c0", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "b0", "from", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "limitWidth", "", "copyContent", "measurePag", "b", "metaMaterial", "Z", "Lqshadow/ShadowStickerSearch$CircleEditFirstSearchRsp;", "downloadDir", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "a", "Ljava/lang/String;", "defaultTextColorStr", "I", "defaultTextColor", "value", "u", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "z0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "frameStickerId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setFrameSticker", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isFrameSticker", "e", "e0", "applyStroke", "S0", "topFrameStickerPath", tl.h.F, "j0", "bottomFrameStickerPath", "X", "R0", "isTextSticker", "T", "E0", "isNeedSaveBackgound", "U", "J0", "isSubtitleSticker", ExifInterface.LATITUDE_SOUTH, "B0", "isLyricSticker", "V", "K0", "isTemplateTextSticker", BdhLogUtil.LogTag.Tag_Req, "A0", "isFromDraftForLyric", "W", "Q0", "isTextReady", "P", "s0", "isFirstLine", "O", "r0", "isFirstItem", "N", "setEffectSticker", "isEffectSticker", "J", "T0", "type", "k", "m0", "configJsonPath", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v0", MessageForRichState.SIGN_MSG_FONT_ID, "r", "w0", "fontPath", "p", "u0", "fontFamilyForSticker", "t", "y0", "fontStyleForSticker", "o", "t0", "fontFamilyForPagView", ReportConstant.COSTREPORT_PREFIX, "x0", "fontStyleForPagView", "G", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "O0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "textJustification", "l", "n0", "content", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContentWrapper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContentWrapper;", "o0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContentWrapper;)V", "contents", "M", "setBilingual", "isBilingual", UserInfo.SEX_FEMALE, "N0", "textColor", "H", "P0", "textMaxLength", "f", "f0", "backgroundAlpha", "g", "g0", "backgroundColor", "B", "H0", "strokeColor", "", BdhLogUtil.LogTag.Tag_Conn, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "I0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "strokeWidth", "y", "F0", Constants.PAG_FILE_PATH, "getBlurTextPath", "h0", "blurTextPath", "getBlurTexturePath", "i0", "blurTexturePath", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G0", "scale", "d", "d0", "angle", "i", "k0", "centerX", "j", "l0", "centerY", HippyTKDListViewAdapter.X, "D0", "minScale", "w", "C0", "maxScale", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)J", "setPlayEndDuration", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;J)V", "playEndDuration", "c", "setActionType", "actionType", "getCreateTime", "p0", WadlProxyConsts.CREATE_TIME, DomainData.DOMAIN_NAME, "q0", "defaultContent", "D", "L0", "textBorderStickerLeftMargin", "E", "M0", "textBorderStickerRightMargin", "Y", "isWatermarkSticker", "v", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/util/List;", "hotText", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f321749a = "#EFEFEF";

    /* renamed from: b, reason: collision with root package name */
    private static final int f321750b = Color.parseColor(f321749a);

    public static final float A(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "scale", 0.4f);
    }

    public static final void A0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isFromDraftForLyric", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final int B(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "strokeColor");
    }

    public static final void B0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isLyricSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final float C(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "strokeWidth", 1.0f);
    }

    public static final void C0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "maxScale", Float.valueOf(f16));
    }

    public static final long D(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.P(metaMaterial, "textBorderStickerLeftMargin", 0L);
    }

    public static final void D0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "minScale", Float.valueOf(f16));
    }

    public static final long E(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.P(metaMaterial, "textBorderStickerRightMargin", 0L);
    }

    public static final void E0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isNeedSaveBackgound", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final int F(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "textColor");
    }

    public static final void F0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, Constants.PAG_FILE_PATH, value);
    }

    public static final int G(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.M(metaMaterial, "textJustification", 1);
    }

    public static final void G0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "scale", Float.valueOf(f16));
    }

    public static final int H(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        int M = com.tencent.mobileqq.wink.editor.c.M(metaMaterial, "textMaxLength", 120);
        if (M <= 0) {
            return 120;
        }
        return M;
    }

    public static final void H0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "strokeColor", Integer.valueOf(i3));
    }

    @NotNull
    public static final String I(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "topFrameStickerPath");
    }

    public static final void I0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "strokeWidth", Float.valueOf(f16));
    }

    @NotNull
    public static final String J(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "type");
    }

    public static final void J0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isSubtitleSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0031. Please report as an issue. */
    public static final void K(@NotNull MetaMaterial metaMaterial, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, categoryId);
        String m3 = WinkEditorResourceManager.a1().m(metaMaterial);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(this)");
        switch (categoryId.hashCode()) {
            case -1424817098:
                if (categoryId.equals("CATEGORY_LYRIC_STICKER_TEXT_DECOR")) {
                    R0(metaMaterial, true);
                    String T1 = WinkEditorResourceManager.a1().T1(m3);
                    Intrinsics.checkNotNullExpressionValue(T1, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                    m0(metaMaterial, T1);
                    String a26 = WinkEditorResourceManager.a1().a2(m3);
                    Intrinsics.checkNotNullExpressionValue(a26, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                    F0(metaMaterial, a26);
                    G0(metaMaterial, 0.8f);
                    return;
                }
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                String T12 = WinkEditorResourceManager.a1().T1(m3);
                Intrinsics.checkNotNullExpressionValue(T12, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                m0(metaMaterial, T12);
                String a27 = WinkEditorResourceManager.a1().a2(m3);
                Intrinsics.checkNotNullExpressionValue(a27, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                F0(metaMaterial, a27);
                String c26 = WinkEditorResourceManager.a1().c2(m3);
                Intrinsics.checkNotNullExpressionValue(c26, "getInstance().getTopBian\u2026ickerPath(downloadFolder)");
                S0(metaMaterial, c26);
                String C0 = WinkEditorResourceManager.a1().C0(m3);
                Intrinsics.checkNotNullExpressionValue(C0, "getInstance().getBottomB\u2026ickerPath(downloadFolder)");
                j0(metaMaterial, C0);
                G0(metaMaterial, 0.4f);
                return;
            case -921884268:
                if (categoryId.equals("CATEGORY_TEXT_DECOR")) {
                    R0(metaMaterial, true);
                    String T13 = WinkEditorResourceManager.a1().T1(m3);
                    Intrinsics.checkNotNullExpressionValue(T13, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                    m0(metaMaterial, T13);
                    String a28 = WinkEditorResourceManager.a1().a2(m3);
                    Intrinsics.checkNotNullExpressionValue(a28, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                    F0(metaMaterial, a28);
                    G0(metaMaterial, 0.5f);
                    return;
                }
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                String T122 = WinkEditorResourceManager.a1().T1(m3);
                Intrinsics.checkNotNullExpressionValue(T122, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                m0(metaMaterial, T122);
                String a272 = WinkEditorResourceManager.a1().a2(m3);
                Intrinsics.checkNotNullExpressionValue(a272, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                F0(metaMaterial, a272);
                String c262 = WinkEditorResourceManager.a1().c2(m3);
                Intrinsics.checkNotNullExpressionValue(c262, "getInstance().getTopBian\u2026ickerPath(downloadFolder)");
                S0(metaMaterial, c262);
                String C02 = WinkEditorResourceManager.a1().C0(m3);
                Intrinsics.checkNotNullExpressionValue(C02, "getInstance().getBottomB\u2026ickerPath(downloadFolder)");
                j0(metaMaterial, C02);
                G0(metaMaterial, 0.4f);
                return;
            case -907563552:
                if (categoryId.equals("CATEGORY_TEXT_STYLE")) {
                    R0(metaMaterial, true);
                    String U1 = WinkEditorResourceManager.a1().U1();
                    Intrinsics.checkNotNullExpressionValue(U1, "getInstance().textDefaultConfigJsonPath");
                    m0(metaMaterial, U1);
                    String V1 = WinkEditorResourceManager.a1().V1();
                    Intrinsics.checkNotNullExpressionValue(V1, "getInstance().textDefaultPagPath");
                    F0(metaMaterial, V1);
                    String id5 = metaMaterial.f30533id;
                    Intrinsics.checkNotNullExpressionValue(id5, "id");
                    v0(metaMaterial, id5);
                    String string = RFWApplication.getApplication().getResources().getString(R.string.yma);
                    Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026tor_text_default_content)");
                    n0(metaMaterial, string);
                    G0(metaMaterial, 0.8f);
                    return;
                }
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                String T1222 = WinkEditorResourceManager.a1().T1(m3);
                Intrinsics.checkNotNullExpressionValue(T1222, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                m0(metaMaterial, T1222);
                String a2722 = WinkEditorResourceManager.a1().a2(m3);
                Intrinsics.checkNotNullExpressionValue(a2722, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                F0(metaMaterial, a2722);
                String c2622 = WinkEditorResourceManager.a1().c2(m3);
                Intrinsics.checkNotNullExpressionValue(c2622, "getInstance().getTopBian\u2026ickerPath(downloadFolder)");
                S0(metaMaterial, c2622);
                String C022 = WinkEditorResourceManager.a1().C0(m3);
                Intrinsics.checkNotNullExpressionValue(C022, "getInstance().getBottomB\u2026ickerPath(downloadFolder)");
                j0(metaMaterial, C022);
                G0(metaMaterial, 0.4f);
                return;
            case 793913343:
                if (categoryId.equals("CATEGORY_TEXT_PATTERN")) {
                    R0(metaMaterial, true);
                    String T14 = WinkEditorResourceManager.a1().T1(m3);
                    Intrinsics.checkNotNullExpressionValue(T14, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                    m0(metaMaterial, T14);
                    String a29 = WinkEditorResourceManager.a1().a2(m3);
                    Intrinsics.checkNotNullExpressionValue(a29, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                    F0(metaMaterial, a29);
                    String string2 = RFWApplication.getApplication().getResources().getString(R.string.yma);
                    Intrinsics.checkNotNullExpressionValue(string2, "getApplication().resourc\u2026tor_text_default_content)");
                    n0(metaMaterial, string2);
                    G0(metaMaterial, 0.8f);
                    return;
                }
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                String T12222 = WinkEditorResourceManager.a1().T1(m3);
                Intrinsics.checkNotNullExpressionValue(T12222, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                m0(metaMaterial, T12222);
                String a27222 = WinkEditorResourceManager.a1().a2(m3);
                Intrinsics.checkNotNullExpressionValue(a27222, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                F0(metaMaterial, a27222);
                String c26222 = WinkEditorResourceManager.a1().c2(m3);
                Intrinsics.checkNotNullExpressionValue(c26222, "getInstance().getTopBian\u2026ickerPath(downloadFolder)");
                S0(metaMaterial, c26222);
                String C0222 = WinkEditorResourceManager.a1().C0(m3);
                Intrinsics.checkNotNullExpressionValue(C0222, "getInstance().getBottomB\u2026ickerPath(downloadFolder)");
                j0(metaMaterial, C0222);
                G0(metaMaterial, 0.4f);
                return;
            default:
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                String T122222 = WinkEditorResourceManager.a1().T1(m3);
                Intrinsics.checkNotNullExpressionValue(T122222, "getInstance().getTextCon\u2026gJsonPath(downloadFolder)");
                m0(metaMaterial, T122222);
                String a272222 = WinkEditorResourceManager.a1().a2(m3);
                Intrinsics.checkNotNullExpressionValue(a272222, "getInstance().getTextPag\u2026ntentPath(downloadFolder)");
                F0(metaMaterial, a272222);
                String c262222 = WinkEditorResourceManager.a1().c2(m3);
                Intrinsics.checkNotNullExpressionValue(c262222, "getInstance().getTopBian\u2026ickerPath(downloadFolder)");
                S0(metaMaterial, c262222);
                String C02222 = WinkEditorResourceManager.a1().C0(m3);
                Intrinsics.checkNotNullExpressionValue(C02222, "getInstance().getBottomB\u2026ickerPath(downloadFolder)");
                j0(metaMaterial, C02222);
                G0(metaMaterial, 0.4f);
                return;
        }
    }

    public static final void K0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isTemplateTextSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final List<MetaMaterial> L(@NotNull String categoryId, @Nullable List<MetaMaterial> list) {
        List<MetaMaterial> emptyList;
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                K((MetaMaterial) it.next(), categoryId);
            }
        }
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public static final void L0(@NotNull MetaMaterial metaMaterial, long j3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "textBorderStickerLeftMargin", Long.valueOf(j3));
    }

    public static final boolean M(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.Y0(metaMaterial);
    }

    public static final void M0(@NotNull MetaMaterial metaMaterial, long j3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "textBorderStickerRightMargin", Long.valueOf(j3));
    }

    public static final boolean N(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.v0(metaMaterial, "isEffectstSticker", "false"), "true");
    }

    public static final void N0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "textColor", Integer.valueOf(i3));
    }

    public static final boolean O(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "exIsFirstItem") == 1) {
            return true;
        }
        return false;
    }

    public static final void O0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "textJustification", Integer.valueOf(i3));
    }

    public static final boolean P(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "exIsFirstLine") == 1) {
            return true;
        }
        return false;
    }

    public static final void P0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "textMaxLength", Integer.valueOf(i3));
    }

    public static final boolean Q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.v0(metaMaterial, "isFrameSticker", "false"), "true");
    }

    public static final void Q0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isTextReady", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final boolean R(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isFromDraftForLyric") == 1) {
            return true;
        }
        return false;
    }

    public static final void R0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isTextSticker", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final boolean S(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isLyricSticker") == 1) {
            return true;
        }
        return false;
    }

    public static final void S0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "topFrameStickerPath", value);
    }

    public static final boolean T(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isNeedSaveBackgound") == 1) {
            return true;
        }
        return false;
    }

    public static final void T0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "type", value);
    }

    public static final boolean U(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isSubtitleSticker") == 1) {
            return true;
        }
        return false;
    }

    public static final void U0(@NotNull MetaMaterial metaMaterial) {
        boolean z16;
        PAGFont b16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        boolean z17 = false;
        w0(metaMaterial, WinkEditorResourceManager.a1().U0(q(metaMaterial), 0));
        String r16 = r(metaMaterial);
        if (r16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(r16);
            if (!isBlank) {
                z16 = false;
                if (!z16 || (b16 = w.e().b(r(metaMaterial), q(metaMaterial))) == null) {
                }
                String str = b16.fontFamily;
                Intrinsics.checkNotNullExpressionValue(str, "pagFont.fontFamily");
                t0(metaMaterial, str);
                String str2 = b16.fontStyle;
                Intrinsics.checkNotNullExpressionValue(str2, "pagFont.fontStyle");
                x0(metaMaterial, str2);
                if (!Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(metaMaterial), "CATEGORY_TEXT_STYLE")) {
                    if (p(metaMaterial).length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        return;
                    }
                }
                String str3 = b16.fontFamily;
                Intrinsics.checkNotNullExpressionValue(str3, "pagFont.fontFamily");
                u0(metaMaterial, str3);
                String str4 = b16.fontStyle;
                Intrinsics.checkNotNullExpressionValue(str4, "pagFont.fontStyle");
                y0(metaMaterial, str4);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static final boolean V(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isTemplateTextSticker") == 1) {
            return true;
        }
        return false;
    }

    public static final void V0(@NotNull MetaMaterial metaMaterial, @Nullable WinkPagStickerConfig winkPagStickerConfig) {
        String str;
        WinkPagStickerConfig.StyleConfig styleConfig;
        String defaultColor;
        WinkPagStickerConfig.StyleConfig styleConfig2;
        String defaultColor2;
        PAGFile Load;
        WinkPagStickerConfig.FrameConfig frameConfig;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (!W(metaMaterial)) {
            if (winkPagStickerConfig != null && (frameConfig = winkPagStickerConfig.frameConfig) != null) {
                d0(metaMaterial, frameConfig.angle);
                D0(metaMaterial, frameConfig.minScale);
                C0(metaMaterial, frameConfig.maxScale);
            }
            try {
                if (new File(y(metaMaterial)).exists()) {
                    Load = PagViewMonitor.Load(y(metaMaterial));
                } else {
                    Load = PagViewMonitor.Load(WinkEditorResourceManager.a1().V1());
                }
                if (Load.numTexts() > 0) {
                    String str2 = Load.getTextData(0).text;
                    Intrinsics.checkNotNullExpressionValue(str2, "pagFile.getTextData(0).text");
                    n0(metaMaterial, str2);
                    N0(metaMaterial, Load.getTextData(0).fillColor);
                    String str3 = Load.getTextData(0).fontFamily;
                    Intrinsics.checkNotNullExpressionValue(str3, "pagFile.getTextData(0).fontFamily");
                    u0(metaMaterial, str3);
                    String str4 = Load.getTextData(0).fontStyle;
                    Intrinsics.checkNotNullExpressionValue(str4, "pagFile.getTextData(0).fontStyle");
                    y0(metaMaterial, str4);
                }
            } catch (Exception e16) {
                ms.a.d("wink_sticker_TextMetaMaterial", "updateTextByPagConfig", e16);
            }
            U0(metaMaterial);
            if (winkPagStickerConfig != null) {
                str = winkPagStickerConfig.type;
            } else {
                str = null;
            }
            if (str == null) {
                str = "fixed_text";
            }
            T0(metaMaterial, str);
            String J = J(metaMaterial);
            int hashCode = J.hashCode();
            if (hashCode != 3027047) {
                if (hashCode != 1021751938) {
                    if (hashCode == 1289680009 && J.equals("color_text") && winkPagStickerConfig != null && (styleConfig2 = winkPagStickerConfig.styleConfig) != null && (defaultColor2 = styleConfig2.defaultColor) != null) {
                        Intrinsics.checkNotNullExpressionValue(defaultColor2, "defaultColor");
                        g0(metaMaterial, Color.parseColor(defaultColor2));
                    }
                } else if (J.equals("plain_text") && winkPagStickerConfig != null && (styleConfig = winkPagStickerConfig.styleConfig) != null && (defaultColor = styleConfig.defaultColor) != null) {
                    Intrinsics.checkNotNullExpressionValue(defaultColor, "defaultColor");
                    N0(metaMaterial, Color.parseColor(defaultColor));
                }
            } else if (J.equals("blur")) {
                h0(metaMaterial, WinkEditorResourceManager.a1().z0(metaMaterial));
                i0(metaMaterial, WinkEditorResourceManager.a1().A0(metaMaterial));
            }
            Q0(metaMaterial, true);
        }
    }

    public static final boolean W(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isTextReady") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean X(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isTextSticker") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean Y(@NotNull MetaMaterial metaMaterial) {
        boolean startsWith;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        String id5 = metaMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        startsWith = StringsKt__StringsJVMKt.startsWith(id5, "sticker_watermark_", true);
        return startsWith;
    }

    public static final void Z(@NotNull MetaMaterial metaMaterial, int i3) {
        PAGText textData;
        PAGLayer layerAt;
        RectF bounds;
        float f16;
        Intrinsics.checkNotNullParameter(metaMaterial, "metaMaterial");
        PAGFile c16 = x.b().c(y(metaMaterial));
        if (c16 != null && (textData = c16.getTextData(0)) != null) {
            textData.text = l(metaMaterial);
            textData.fillColor = F(metaMaterial);
            textData.justification = G(metaMaterial);
            textData.fontStyle = s(metaMaterial);
            textData.fontFamily = o(metaMaterial);
            textData.backgroundColor = g(metaMaterial);
            textData.backgroundAlpha = f(metaMaterial);
            textData.applyStroke = e(metaMaterial);
            textData.strokeColor = B(metaMaterial);
            textData.strokeWidth = C(metaMaterial);
            c16.replaceText(0, textData);
            if (c16.numChildren() == 1 && (layerAt = c16.getLayerAt(0)) != null && (bounds = layerAt.getBounds()) != null) {
                Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
                ms.a.a("wink_sticker_TextMetaMaterial", "page layer bounds before concat =  " + bounds + " \uff0c content = " + l(metaMaterial) + ", height = " + c16.height());
                Matrix matrix = new Matrix();
                matrix.reset();
                while (layerAt != null) {
                    matrix.postConcat(layerAt.getTotalMatrix());
                    layerAt = layerAt.parent();
                }
                matrix.mapRect(bounds);
                ms.a.a("wink_sticker_TextMetaMaterial", "page layer bounds = " + bounds + " \uff0c content = " + l(metaMaterial) + ", height = " + c16.height());
                float width = ((float) i3) / ((float) c16.width());
                float f17 = 0.0f;
                if (i3 != 0) {
                    f16 = (bounds.height() * (1 - width)) / 2;
                } else {
                    f16 = 0.0f;
                }
                if (i3 != 0) {
                    f17 = (bounds.width() * (1 - width)) / 2;
                }
                Map<String, String> map = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map, "metaMaterial.additionalFields");
                map.put("textBoundsTop", String.valueOf(bounds.top + f16));
                Map<String, String> map2 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map2, "metaMaterial.additionalFields");
                map2.put("textBoundsBottom", String.valueOf(bounds.bottom - f16));
                Map<String, String> map3 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map3, "metaMaterial.additionalFields");
                map3.put("textBoundsLeft", String.valueOf(bounds.left + f17));
                Map<String, String> map4 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map4, "metaMaterial.additionalFields");
                map4.put("textBoundsRight", String.valueOf(bounds.right - f17));
                Map<String, String> map5 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map5, "metaMaterial.additionalFields");
                map5.put("pagViewCenterX", String.valueOf(c16.width() / 2.0f));
                Map<String, String> map6 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map6, "metaMaterial.additionalFields");
                map6.put("pagViewCenterY", String.valueOf(c16.height() / 2.0f));
                Map<String, String> map7 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map7, "metaMaterial.additionalFields");
                map7.put("pagViewWidth", String.valueOf(c16.width()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x025c  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<MetaCategory> a(@NotNull ShadowStickerSearch$CircleEditFirstSearchRsp shadowStickerSearch$CircleEditFirstSearchRsp, @NotNull String downloadDir) {
        int collectionSizeOrDefault;
        boolean endsWith$default;
        String str;
        boolean z16;
        StringBuilder sb5;
        boolean isBlank;
        String substringAfterLast$default;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(shadowStickerSearch$CircleEditFirstSearchRsp, "<this>");
        Intrinsics.checkNotNullParameter(downloadDir, "downloadDir");
        ArrayList arrayList = new ArrayList();
        PBRepeatMessageField<ShadowStickerSearch$MaterialInfo> pBRepeatMessageField = shadowStickerSearch$CircleEditFirstSearchRsp.sticker_materials;
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            MetaCategory metaCategory = new MetaCategory();
            metaCategory.f30532id = "SEARCH_STICKER";
            metaCategory.name = "\u8d34\u7eb8";
            List<ShadowStickerSearch$MaterialInfo> list = shadowStickerSearch$CircleEditFirstSearchRsp.sticker_materials.get();
            Intrinsics.checkNotNullExpressionValue(list, "sticker_materials.get()");
            List<ShadowStickerSearch$MaterialInfo> list2 = list;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (ShadowStickerSearch$MaterialInfo shadowStickerSearch$MaterialInfo : list2) {
                MetaMaterial metaMaterial = new MetaMaterial();
                metaMaterial.f30533id = shadowStickerSearch$MaterialInfo.f429489id.get();
                metaMaterial.sdkInfo = new MetaSdkInfo(0, shadowStickerSearch$MaterialInfo.metaSdkInfo.SdkVersion.get());
                metaMaterial.thumbUrl = shadowStickerSearch$MaterialInfo.thumbURL.get();
                metaMaterial.authorName = shadowStickerSearch$MaterialInfo.authorName.get();
                metaMaterial.thumbWidth = shadowStickerSearch$MaterialInfo.thumbWidth.get();
                metaMaterial.thumbHeight = shadowStickerSearch$MaterialInfo.thumbHeight.get();
                metaMaterial.packageUrl = shadowStickerSearch$MaterialInfo.packageURL.get();
                metaMaterial.showName = shadowStickerSearch$MaterialInfo.displayName.get();
                metaMaterial.packageMd5 = shadowStickerSearch$MaterialInfo.checksumMd5.get();
                List<ShadowStickerSearch$AdditionalEntry> list3 = shadowStickerSearch$MaterialInfo.additionalFields.get();
                Intrinsics.checkNotNullExpressionValue(list3, "it.additionalFields.get()");
                List<ShadowStickerSearch$AdditionalEntry> list4 = list3;
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (ShadowStickerSearch$AdditionalEntry shadowStickerSearch$AdditionalEntry : list4) {
                    Pair pair = TuplesKt.to(shadowStickerSearch$AdditionalEntry.dynamic_key.get(), shadowStickerSearch$AdditionalEntry.dynamic_value.get());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                metaMaterial.additionalFields = new HashMap(linkedHashMap);
                com.tencent.mobileqq.wink.editor.c.I1(metaMaterial, 0);
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "SEARCH_STICKER");
                String Z1 = WinkEditorResourceManager.a1().Z1(metaMaterial);
                Intrinsics.checkNotNullExpressionValue(Z1, "getInstance().getTextPagContentPath(this)");
                F0(metaMaterial, Z1);
                MetaAdditionalPackage metaAdditionalPackage = new MetaAdditionalPackage();
                metaAdditionalPackage.lowPackageUrl = shadowStickerSearch$MaterialInfo.additionalPackage.lowPackageUrl.get();
                metaAdditionalPackage.lowPackageMd5 = shadowStickerSearch$MaterialInfo.additionalPackage.lowPackageMd5.get();
                metaAdditionalPackage.superLowPackageUrl = shadowStickerSearch$MaterialInfo.additionalPackage.superLowPackageUrl.get();
                metaAdditionalPackage.superLowPackageMd5 = shadowStickerSearch$MaterialInfo.additionalPackage.superLowPackageMd5.get();
                metaAdditionalPackage.midPackageUrl = shadowStickerSearch$MaterialInfo.additionalPackage.midPackageUrl.get();
                metaAdditionalPackage.midPackageMd5 = shadowStickerSearch$MaterialInfo.additionalPackage.midPackageMd5.get();
                metaAdditionalPackage.highPackageUrl = shadowStickerSearch$MaterialInfo.additionalPackage.highPackageUrl.get();
                metaAdditionalPackage.highPackageMd5 = shadowStickerSearch$MaterialInfo.additionalPackage.highPackageMd5.get();
                metaMaterial.additionalPackage = metaAdditionalPackage;
                arrayList2.add(metaMaterial);
            }
            metaCategory.materials = new ArrayList<>(arrayList2);
            arrayList.add(metaCategory);
        }
        PBRepeatMessageField<ShadowStickerSearch$QQExpressionInfo> pBRepeatMessageField2 = shadowStickerSearch$CircleEditFirstSearchRsp.express_infos;
        if (pBRepeatMessageField2 != null && !pBRepeatMessageField2.isEmpty()) {
            MetaCategory metaCategory2 = new MetaCategory();
            metaCategory2.f30532id = "SEARCH_EXPRESSION";
            metaCategory2.name = "\u8868\u60c5";
            List<ShadowStickerSearch$QQExpressionInfo> list5 = shadowStickerSearch$CircleEditFirstSearchRsp.express_infos.get();
            Intrinsics.checkNotNullExpressionValue(list5, "express_infos.get()");
            List<ShadowStickerSearch$QQExpressionInfo> list6 = list5;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (ShadowStickerSearch$QQExpressionInfo shadowStickerSearch$QQExpressionInfo : list6) {
                MetaMaterial metaMaterial2 = new MetaMaterial();
                metaMaterial2.f30533id = shadowStickerSearch$QQExpressionInfo.img_md5.get();
                T0(metaMaterial2, "qq_emoticon_sticker");
                String str2 = shadowStickerSearch$QQExpressionInfo.img_down_url.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.img_down_url.get()");
                com.tencent.mobileqq.wink.editor.c.x1(metaMaterial2, str2);
                String str3 = shadowStickerSearch$QQExpressionInfo.thumb_down_url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "it.thumb_down_url.get()");
                com.tencent.mobileqq.wink.editor.c.t1(metaMaterial2, str3);
                String str4 = null;
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(com.tencent.mobileqq.wink.editor.c.y(metaMaterial2), QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                if (endsWith$default) {
                    str = "repeat";
                } else {
                    str = "none";
                }
                com.tencent.mobileqq.wink.editor.c.A1(metaMaterial2, str);
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial2, "SEARCH_EXPRESSION");
                try {
                    String lastPathSegment = Uri.parse(com.tencent.mobileqq.wink.editor.c.J(metaMaterial2)).getLastPathSegment();
                    if (lastPathSegment != null) {
                        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(lastPathSegment, ".", (String) null, 2, (Object) null);
                        str4 = substringAfterLast$default;
                    }
                } catch (Throwable th5) {
                    w53.b.d("wink_sticker_TextMetaMaterial", "convertToMaterials: get extension fail " + com.tencent.mobileqq.wink.editor.c.J(metaMaterial2), th5);
                }
                if (str4 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str4);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            String str5 = metaMaterial2.f30533id;
                            sb5 = new StringBuilder();
                            sb5.append(downloadDir);
                            sb5.append("/");
                            sb5.append(str5);
                        } else {
                            String str6 = metaMaterial2.f30533id;
                            sb5 = new StringBuilder();
                            sb5.append(downloadDir);
                            sb5.append("/");
                            sb5.append(str6);
                            sb5.append(".");
                            sb5.append(str4);
                        }
                        com.tencent.mobileqq.wink.editor.c.v1(metaMaterial2, sb5.toString());
                        metaMaterial2.thumbUrl = shadowStickerSearch$QQExpressionInfo.thumb_down_url.get();
                        arrayList3.add(metaMaterial2);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                com.tencent.mobileqq.wink.editor.c.v1(metaMaterial2, sb5.toString());
                metaMaterial2.thumbUrl = shadowStickerSearch$QQExpressionInfo.thumb_down_url.get();
                arrayList3.add(metaMaterial2);
            }
            metaCategory2.materials = new ArrayList<>(arrayList3);
            arrayList.add(metaCategory2);
        }
        return arrayList;
    }

    @NotNull
    public static final MetaMaterial a0() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "TEXT_DEFAULT_DEFAULT_ID";
        String string = RFWApplication.getApplication().getResources().getString(R.string.ymf);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026e_editor_text_thumb_text)");
        com.tencent.mobileqq.wink.editor.c.J1(metaMaterial, string);
        Q0(metaMaterial, true);
        T0(metaMaterial, "plain_text");
        N0(metaMaterial, f321750b);
        K(metaMaterial, "CATEGORY_TEXT_STYLE");
        return metaMaterial;
    }

    @NotNull
    public static final WinkStickerModel b(@Nullable MetaMaterial metaMaterial, @NotNull WinkStickerModel stickerModel, int i3, boolean z16, boolean z17) {
        String str;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        ArrayList arrayList = new ArrayList();
        MetaMaterial material = stickerModel.getMaterial();
        if (metaMaterial != null && material != null) {
            material.f30533id = metaMaterial.f30533id;
            N0(material, F(metaMaterial));
            e0(material, e(metaMaterial));
            g0(material, g(metaMaterial));
            f0(material, f(metaMaterial));
            H0(material, B(metaMaterial));
            I0(material, C(metaMaterial));
            w0(material, r(metaMaterial));
            v0(material, q(metaMaterial));
            u0(material, p(metaMaterial));
            y0(material, t(metaMaterial));
            t0(material, o(metaMaterial));
            x0(material, s(metaMaterial));
            F0(material, y(metaMaterial));
            O0(material, G(metaMaterial));
            if (z16) {
                n0(material, l(metaMaterial));
            }
            if (z17) {
                Z(material, i3);
            }
            for (TextItem textItem : stickerModel.textItems) {
                com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
                String d16 = dVar.d(F(metaMaterial));
                boolean e16 = e(metaMaterial);
                String d17 = dVar.d(g(metaMaterial));
                int f16 = f(metaMaterial);
                String d18 = dVar.d(B(metaMaterial));
                float C = C(metaMaterial);
                String r16 = r(metaMaterial);
                String p16 = p(metaMaterial);
                if (z16) {
                    str = l(metaMaterial);
                } else {
                    str = textItem.text;
                }
                arrayList.add(TextItem.copy$default(textItem, str, d16, r16, d18, Float.valueOf(C), null, null, null, null, null, null, p16, Boolean.valueOf(e16), null, null, d17, Integer.valueOf(f16), null, null, null, 944096, null));
            }
        }
        return WinkStickerModel.copyAndUpdate$default(stickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, arrayList, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -32769, 1048575, null);
    }

    @NotNull
    public static final MetaMaterial b0(@NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = materialId;
        String string = RFWApplication.getApplication().getResources().getString(R.string.ymf);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().resourc\u2026e_editor_text_thumb_text)");
        com.tencent.mobileqq.wink.editor.c.J1(metaMaterial, string);
        metaMaterial.thumbUrl = "thumbNon";
        Q0(metaMaterial, true);
        return metaMaterial;
    }

    @NotNull
    public static final String c(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "actionType");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(32:1|(2:3|(1:5)(1:61))|62|7|(1:9)(1:60)|(2:11|(23:13|14|(1:16)|(1:18)(1:58)|19|(1:57)|23|(1:56)(1:27)|28|(1:30)(1:55)|31|32|33|(1:53)|37|38|(1:40)|41|(1:43)|44|(1:48)|49|50))|59|14|(0)|(0)(0)|19|(1:21)|57|23|(1:25)|56|28|(0)(0)|31|32|33|(1:35)|53|37|38|(0)|41|(0)|44|(2:46|48)|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        r7 = com.tencent.mobileqq.wink.editor.sticker.m.f321750b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0048, code lost:
    
        if (r2 == null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0084  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MetaMaterial c0(@NotNull StickerModel model, @Nullable String str, @NotNull Map<String, ? extends Object> extra) {
        Object orNull;
        String str2;
        ArrayList arrayList;
        Object obj;
        int i3;
        Object orNull2;
        TextItem textItem;
        Object orNull3;
        TextItem textItem2;
        boolean z16;
        Object orNull4;
        TextItem textItem3;
        float f16;
        String c16;
        Object orNull5;
        TextItem textItem4;
        Integer num;
        Object orNull6;
        TextItem textItem5;
        Boolean bool;
        Object orNull7;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(extra, "extra");
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "TEXT_DEFAULT_DEFAULT_ID";
        com.tencent.mobileqq.wink.editor.c.J1(metaMaterial, com.tencent.videocut.render.extension.f.i(model).getFirst());
        int i16 = 1;
        Q0(metaMaterial, true);
        K0(metaMaterial, true);
        T0(metaMaterial, "plain_text");
        orNull = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        TextItem textItem6 = (TextItem) orNull;
        if (textItem6 != null) {
            if (TextUtils.isEmpty(textItem6.textColor)) {
                str2 = f321749a;
            } else {
                str2 = textItem6.textColor;
            }
        }
        str2 = f321749a;
        N0(metaMaterial, Color.parseColor(str2));
        Object obj2 = extra.get("PAGAsset");
        Integer num2 = null;
        if (obj2 instanceof ArrayList) {
            arrayList = (ArrayList) obj2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            orNull7 = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            Map map = (Map) orNull7;
            if (map != null) {
                obj = map.get("textMaxLength");
                if (obj instanceof Integer) {
                    num2 = (Integer) obj;
                }
                if (num2 == null) {
                    i3 = num2.intValue();
                } else {
                    i3 = 120;
                }
                P0(metaMaterial, i3);
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
                textItem = (TextItem) orNull2;
                String str3 = "";
                if (textItem != null || (r7 = textItem.text) == null) {
                    String str4 = "";
                }
                n0(metaMaterial, str4);
                q0(metaMaterial, l(metaMaterial));
                orNull3 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
                textItem2 = (TextItem) orNull3;
                if (textItem2 == null && (bool = textItem2.applyStroke) != null) {
                    z16 = bool.booleanValue();
                } else {
                    z16 = false;
                }
                e0(metaMaterial, z16);
                orNull4 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
                textItem3 = (TextItem) orNull4;
                if (textItem3 == null) {
                    f16 = textItem3.strokeWidth;
                } else {
                    f16 = 0.0f;
                }
                I0(metaMaterial, f16);
                orNull6 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
                textItem5 = (TextItem) orNull6;
                if (textItem5 != null || (r7 = textItem5.strokeColor) == null) {
                    String str5 = f321749a;
                }
                int i17 = Color.parseColor(str5);
                H0(metaMaterial, i17);
                if (str == null) {
                    str = "";
                }
                F0(metaMaterial, str);
                R0(metaMaterial, true);
                t0(metaMaterial, com.tencent.videocut.render.extension.f.d(model));
                u0(metaMaterial, com.tencent.videocut.render.extension.f.d(model));
                x0(metaMaterial, com.tencent.videocut.render.extension.f.e(model));
                y0(metaMaterial, com.tencent.videocut.render.extension.f.e(model));
                c16 = w.e().c(com.tencent.videocut.render.extension.f.d(model));
                if (c16 != null) {
                    Intrinsics.checkNotNullExpressionValue(c16, "TAVFontManager.getInstan\u2026el.getFontFamily()) ?: \"\"");
                    str3 = c16;
                }
                v0(metaMaterial, str3);
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "CATEGORY_TEXT_STYLE");
                p0(metaMaterial, System.currentTimeMillis());
                orNull5 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
                textItem4 = (TextItem) orNull5;
                if (textItem4 != null && (num = textItem4.justification) != null) {
                    i16 = num.intValue();
                }
                O0(metaMaterial, i16);
                return metaMaterial;
            }
        }
        obj = null;
        if (obj instanceof Integer) {
        }
        if (num2 == null) {
        }
        P0(metaMaterial, i3);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        textItem = (TextItem) orNull2;
        String str32 = "";
        if (textItem != null) {
        }
        String str42 = "";
        n0(metaMaterial, str42);
        q0(metaMaterial, l(metaMaterial));
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        textItem2 = (TextItem) orNull3;
        if (textItem2 == null) {
        }
        z16 = false;
        e0(metaMaterial, z16);
        orNull4 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        textItem3 = (TextItem) orNull4;
        if (textItem3 == null) {
        }
        I0(metaMaterial, f16);
        orNull6 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        textItem5 = (TextItem) orNull6;
        if (textItem5 != null) {
        }
        String str52 = f321749a;
        int i172 = Color.parseColor(str52);
        H0(metaMaterial, i172);
        if (str == null) {
        }
        F0(metaMaterial, str);
        R0(metaMaterial, true);
        t0(metaMaterial, com.tencent.videocut.render.extension.f.d(model));
        u0(metaMaterial, com.tencent.videocut.render.extension.f.d(model));
        x0(metaMaterial, com.tencent.videocut.render.extension.f.e(model));
        y0(metaMaterial, com.tencent.videocut.render.extension.f.e(model));
        c16 = w.e().c(com.tencent.videocut.render.extension.f.d(model));
        if (c16 != null) {
        }
        v0(metaMaterial, str32);
        com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "CATEGORY_TEXT_STYLE");
        p0(metaMaterial, System.currentTimeMillis());
        orNull5 = CollectionsKt___CollectionsKt.getOrNull(model.textItems, 0);
        textItem4 = (TextItem) orNull5;
        if (textItem4 != null) {
            i16 = num.intValue();
        }
        O0(metaMaterial, i16);
        return metaMaterial;
    }

    public static final float d(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "angle", 0.0f);
    }

    public static final void d0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "angle", Float.valueOf(f16));
    }

    public static final boolean e(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "applyStroke") == 1) {
            return true;
        }
        return false;
    }

    public static final void e0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "applyStroke", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final int f(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "backgroundAlpha");
    }

    public static final void f0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "backgroundAlpha", Integer.valueOf(i3));
    }

    public static final int g(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "backgroundColor");
    }

    public static final void g0(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "backgroundColor", Integer.valueOf(i3));
    }

    @NotNull
    public static final String h(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "bottomFrameStickerPath");
    }

    public static final void h0(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "blurTextPath", str);
    }

    public static final float i(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "centerX", 0.0f);
    }

    public static final void i0(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "blurTexturePath", str);
    }

    public static final float j(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "centerY", 0.0f);
    }

    public static final void j0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "bottomFrameStickerPath", value);
    }

    @NotNull
    public static final String k(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "configJsonPath");
    }

    public static final void k0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "centerX", Float.valueOf(f16));
    }

    @NotNull
    public static final String l(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "content");
    }

    public static final void l0(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "centerY", Float.valueOf(f16));
    }

    @Nullable
    public static final MetaMaterialContentWrapper m(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return (MetaMaterialContentWrapper) com.tencent.mobileqq.wink.editor.c.c0(metaMaterial, "contents");
    }

    public static final void m0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "configJsonPath", value);
    }

    @NotNull
    public static final String n(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "defaultContent");
    }

    public static final void n0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "content", value);
    }

    @NotNull
    public static final String o(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontFamilyForPagView");
    }

    public static final void o0(@NotNull MetaMaterial metaMaterial, @Nullable MetaMaterialContentWrapper metaMaterialContentWrapper) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.j1(metaMaterial, "contents", metaMaterialContentWrapper);
    }

    @NotNull
    public static final String p(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontFamilyForSticker");
    }

    public static final void p0(@NotNull MetaMaterial metaMaterial, long j3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, WadlProxyConsts.CREATE_TIME, Long.valueOf(j3));
    }

    @NotNull
    public static final String q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontID");
    }

    public static final void q0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "defaultContent", value);
    }

    @Nullable
    public static final String r(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontPath");
    }

    public static final void r0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "exIsFirstItem", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String s(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontStyleForPagView");
    }

    public static final void s0(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "exIsFirstLine", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String t(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "fontStyleForSticker");
    }

    public static final void t0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontFamilyForPagView", value);
    }

    @NotNull
    public static final String u(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "frameStickerId");
    }

    public static final void u0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontFamilyForSticker", value);
    }

    @NotNull
    public static final List<String> v(@NotNull MetaMaterial metaMaterial) {
        boolean isBlank;
        List<String> split$default;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        String w06 = com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "hot_text");
        isBlank = StringsKt__StringsJVMKt.isBlank(w06);
        if (isBlank) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) w06, new String[]{","}, false, 0, 6, (Object) null);
        return split$default;
    }

    public static final void v0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontID", value);
    }

    public static final float w(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "maxScale", 10.0f);
    }

    public static final void w0(@NotNull MetaMaterial metaMaterial, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontPath", str);
    }

    public static final float x(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "minScale", 0.2f);
    }

    public static final void x0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontStyleForPagView", value);
    }

    @NotNull
    public static final String y(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, Constants.PAG_FILE_PATH);
    }

    public static final void y0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "fontStyleForSticker", value);
    }

    public static final long z(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.P(metaMaterial, "playEndDuration", -1L);
    }

    public static final void z0(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "frameStickerId", value);
    }
}
