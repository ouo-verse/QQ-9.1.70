package com.tencent.mobileqq.wink.editor.subtitle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$playerListener$2;
import com.tencent.mobileqq.wink.editor.subtitle.l;
import com.tencent.mobileqq.wink.editor.subtitle.n;
import com.tencent.mobileqq.wink.editor.subtitle.p;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleLine;
import com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleLineText;
import com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleResult;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.UiThreadUtil;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.TextItem;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0006\u00d4\u0001\u00db\u0001\u00f1\u0001\u0018\u0000 \u00bd\u00022\u00020\u0001:\u0002\u00be\u0002B\t\u00a2\u0006\u0006\b\u00bb\u0002\u0010\u00bc\u0002J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J$\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001e\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J2\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u001cH\u0002J \u0010!\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010 \u001a\u00020\rH\u0002J\u0018\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J(\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010#\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"H\u0002J\u001a\u0010-\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u00100\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\tH\u0002J\u0018\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0002J\u0014\u00107\u001a\u00020\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\rH\u0002J&\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\r2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010<\u001a\u00020\rH\u0002J\b\u0010>\u001a\u00020\u0004H\u0002J\b\u0010?\u001a\u00020\u0004H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010\u00162\u0006\u0010;\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\u0004H\u0002J\b\u0010C\u001a\u00020\u0004H\u0002J\n\u0010D\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\rH\u0002J\b\u0010G\u001a\u00020\u0004H\u0002JS\u0010Q\u001a\u0004\u0018\u00010%2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u001a0Hj\b\u0012\u0004\u0012\u00020\u001a`I2\b\b\u0002\u0010K\u001a\u00020\r2%\b\u0002\u0010P\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u0004\u0018\u00010LH\u0002J\b\u0010R\u001a\u00020\"H\u0016J\u0016\u0010W\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\u0006\u0010V\u001a\u00020UJ\u0016\u0010X\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\rJ\u0006\u0010Y\u001a\u00020\u0004J7\u0010^\u001a\u00020\u00042\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010Z2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010]\u001a\u0004\u0018\u00010\\\u00a2\u0006\u0004\b^\u0010_J\u0006\u0010`\u001a\u00020\u0004J.\u0010b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010a\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0012J\u0018\u0010g\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\r2\b\b\u0002\u0010f\u001a\u00020\rJ\u0006\u0010h\u001a\u00020\u0004J\u000e\u0010i\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\rJ\u0006\u0010j\u001a\u00020\u0004J\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010l\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\rJ\u001a\u0010n\u001a\u00020\u00042\b\b\u0002\u0010m\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\rJ\u0018\u0010q\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020\rJ\u0012\u0010r\u001a\u00020\u00042\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0012J\u000e\u0010t\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u001aJP\u0010y\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\"2\u0006\u0010v\u001a\u00020\u001628\u0010P\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\"\u00a2\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00040wJ\u0016\u0010{\u001a\u00020\u00042\u0006\u0010z\u001a\u00020'2\u0006\u0010u\u001a\u00020\"J&\u0010\u007f\u001a\u00020\u00042\u0006\u0010z\u001a\u00020'2\u0006\u0010|\u001a\u00020\"2\u0006\u0010}\u001a\u00020\"2\u0006\u0010~\u001a\u00020\"J\u000f\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010z\u001a\u00020'J\u0007\u0010\u0081\u0001\u001a\u00020\u0004J\u0007\u0010\u0082\u0001\u001a\u00020\u0004J\u0007\u0010\u0083\u0001\u001a\u00020\rJ\u0012\u0010\u0085\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0084\u0001\u001a\u00020\rJ\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\u0013\u0010\u0087\u0001\u001a\u00020\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001aJ\u0011\u0010\u008a\u0001\u001a\u00020\u00042\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\rJ<\u0010\u0091\u0001\u001a\u00020\u00042\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00162\b\u0010u\u001a\u0004\u0018\u00010\"2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u0012\b\u0002\u0010\u0090\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u008f\u0001J\u0019\u0010\u0092\u0001\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0006\u0010x\u001a\u00020\"J\u0007\u0010\u0093\u0001\u001a\u00020\u0004J\u0010\u0010\u0095\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020'J\u0007\u0010\u0096\u0001\u001a\u00020\u0004J\u0007\u0010\u0097\u0001\u001a\u00020\u0004J\u0007\u0010\u0098\u0001\u001a\u00020\u0004J\u0007\u0010\u0099\u0001\u001a\u00020\u0004J\t\u0010\u009a\u0001\u001a\u00020\u0004H\u0014R\u0019\u0010\u009d\u0001\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010V\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R!\u0010\u00a7\u0001\u001a\u00030\u00a2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R&\u0010\u00ad\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00aa\u00010\u00a9\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R+\u0010\u00b3\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00aa\u00010\u00a9\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00af\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001R&\u0010\u00b5\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0088\u00010\u00a9\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00ac\u0001R+\u0010\u00b8\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0088\u00010\u00a9\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b6\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b2\u0001R\u001e\u0010\u00ba\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ac\u0001R#\u0010\u00bd\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00bb\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00bc\u0001\u0010\u00b2\u0001R-\u0010\u00c1\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u00bf\u0001\u0012\u0005\u0012\u00030\u00bf\u00010\u00be\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00ac\u0001R2\u0010\u00c4\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u00bf\u0001\u0012\u0005\u0012\u00030\u00bf\u00010\u00be\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00b2\u0001R2\u0010\u00c6\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001a0\u00be\u00010\u00a9\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u00ac\u0001R7\u0010\u00c9\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001a0\u00be\u00010\u00a9\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00b2\u0001R2\u0010\u00cb\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001a0\u00be\u00010\u00a9\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00ac\u0001R7\u0010\u00ce\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001a0\u00be\u00010\u00a9\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00b2\u0001R\u001f\u0010\u00d0\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bf\u00010\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00ac\u0001R$\u0010\u00d3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bf\u00010\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d1\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00d2\u0001\u0010\u00b2\u0001R\u0018\u0010\u00d7\u0001\u001a\u00030\u00d4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001R%\u0010\u00da\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d8\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00d9\u0001\u0010\u00b2\u0001R\u0018\u0010\u00de\u0001\u001a\u00030\u00db\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001R%\u0010\u00e1\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00ae\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00df\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00e0\u0001\u0010\u00b2\u0001R:\u0010\u00e8\u0001\u001a \u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001a0\u00e2\u0001j\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001a`\u00e3\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e4\u0001\u0010\u00e5\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00e7\u0001R\u001f\u0010\u00eb\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001R+\u0010\u00f0\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00ed\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\t0\u00ec\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u0018\u0010\u00f4\u0001\u001a\u00030\u00f1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f2\u0001\u0010\u00f3\u0001R$\u0010\u00f6\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0\u00ec\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u00ef\u0001R\u0019\u0010\u00f8\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f7\u0001\u0010\u00ee\u0001R)\u0010\u00fe\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f9\u0001\u0010\u00ee\u0001\u001a\u0006\b\u00fa\u0001\u0010\u00fb\u0001\"\u0006\b\u00fc\u0001\u0010\u00fd\u0001R\u0019\u0010\u0080\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ff\u0001\u0010\u00ee\u0001R\u0019\u0010\u0082\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u00ee\u0001R\u0019\u0010\u0084\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0002\u0010\u00ee\u0001R\u0019\u0010\u0086\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0002\u0010\u00ee\u0001R\u001a\u0010\u0088\u0002\u001a\u00030\u00bf\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0002\u0010\u00bb\u0001R\u0019\u0010\u008a\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0002\u0010\u00ee\u0001R'\u0010\u008d\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u001a0Hj\b\u0012\u0004\u0012\u00020\u001a`I8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R)\u0010\u0092\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u001a0\u008e\u0002j\t\u0012\u0004\u0012\u00020\u001a`\u008f\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R)\u0010\u0094\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u001a0\u008e\u0002j\t\u0012\u0004\u0012\u00020\u001a`\u008f\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0002\u0010\u0091\u0002R\u001b\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R'\u0010\u0099\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u001a0Hj\b\u0012\u0004\u0012\u00020\u001a`I8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0002\u0010\u008c\u0002R\u001b\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0002\u0010\u009b\u0002R\u0019\u0010\u009e\u0002\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0002\u0010\u00b9\u0001R)\u0010\u00a1\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u009f\u00020Hj\t\u0012\u0005\u0012\u00030\u009f\u0002`I8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a0\u0002\u0010\u008c\u0002R&\u0010[\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0002\u0010\u00a3\u0002R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0002\u0010\u00a5\u0002R\u001a\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0002\u0010\u00a7\u0002R\u001a\u0010\u00ab\u0002\u001a\u00030\u00a8\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0002\u0010\u00aa\u0002R\u0019\u0010\u00ad\u0002\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0002\u0010\u00b9\u0001R\u0019\u0010\u00af\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0002\u0010\u00ee\u0001R\u001b\u0010\u00b2\u0002\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0002\u0010\u00b1\u0002R\u0017\u0010\u00b4\u0002\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00b3\u0002\u0010\u00fb\u0001R\u001b\u0010\u00b7\u0002\u001a\u00020\u0002*\u00020\u00028BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00b5\u0002\u0010\u00b6\u0002R\u0017\u0010\u00ba\u0002\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00b8\u0002\u0010\u00b9\u0002\u00a8\u0006\u00bf\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "originalVolume", "", "b4", "(Ljava/lang/Float;)V", "bgmVolume", "Y3", "", "Lcom/tencent/videocut/model/ResourceModel;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "d3", "other", "c3", "L3", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavcut", "V2", "refreshStickerOnly", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "winkStickerModel", Constants.BASE_IN_APP_NAME, "cut", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "newSubtitles", "", "newStickerMap", "A3", "resourceModels", TPReportKeys.Common.COMMON_ONLINE, "P3", "", "originalPath", "path", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "S3", "", "remainCount", "maxRetryCount", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "x3", "url", "z2", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "result", "v3", "code", "stage", "p3", "q3", "l2", "selectedSubtitle", "r3", "needPlayback", "C3", "open", "subtitle", "needSeek", ICustomDataEditor.NUMBER_PARAM_2, "E2", "q2", "r2", Constants.BASE_IN_PLUGIN_VERSION, "t2", "y2", "O2", "isShown", "N3", Constants.EMULATOR_INFO, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "inputLines", "isAllTranslate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "callBack", "V3", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/f;", "netDataSource", "Lcom/tencent/mobileqq/wink/editor/subtitle/n;", "stickerFactory", "W2", "u3", "onResume", "", "mediaClipVolumes", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "volumeType", "O3", "(Ljava/util/Map;Ljava/lang/Float;Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;)V", "j3", "fromMenuOpen", "e3", "winkTavCutDelegate", "F2", "useBilingual", "updateLiveData", "Z3", "k2", "z3", "R3", "T3", "B2", "needConfirm", "J3", "fromEdit", "clearEditStat", "u2", "w2", "line", "y3", "content", "sticker", "Lkotlin/Function2;", "transition", ICustomDataEditor.NUMBER_PARAM_3, "index", "m3", "origContent", "curContent", "newContent", "k3", "l3", "j2", ICustomDataEditor.STRING_PARAM_2, "I2", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "H3", "M3", "t3", "Lcom/tencent/mobileqq/wink/editor/subtitle/l;", "event", "d4", "b3", "stickerModel", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lkotlin/Function0;", "finish", "c4", "e4", NowProxyConstants.AccountInfoKey.A2, "highlightIndex", "F3", "X3", "U3", "p2", "m2", "onCleared", "i", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/f;", "dataSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/subtitle/n;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/dr;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "D", "Lkotlin/Lazy;", "M2", "()Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Landroidx/lifecycle/MutableLiveData;", "Lt73/a;", "Lcom/tencent/mobileqq/wink/editor/subtitle/p;", "E", "Landroidx/lifecycle/MutableLiveData;", "_translateEvent", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "T2", "()Landroidx/lifecycle/LiveData;", "translateEvent", "G", "_subtitleEvent", "H", "R2", "subtitleLoadEvent", "I", "_playerState", "J", "N2", "playerState", "Lkotlin/Pair;", "", "K", "_playTime", "L", "L2", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "M", "_itemChange", "N", "J2", "itemChange", "P", "_itemInsert", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K2", "itemInsert", BdhLogUtil.LogTag.Tag_Req, "_triggerPlayLiveData", ExifInterface.LATITUDE_SOUTH, "U2", "triggerPlayEvent", "com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$b", "T", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$b;", "_isBilingualLiveData", "U", ICustomDataEditor.STRING_ARRAY_PARAM_3, "isBilingualLiveData", "com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$c", "V", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$c;", "_showBilingualLiveData", "W", "P2", "showBilingualLiveData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "X", "Ljava/util/HashMap;", "getStickerSubtitleMap", "()Ljava/util/HashMap;", "stickerSubtitleMap", "Y", "Ljava/util/List;", "curResources", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "subtitlesMap", "com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$subtitles$1", "a0", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$subtitles$1;", TPReportKeys.VodExKeys.VOD_EX_HAS_SUBTITLE, "b0", "cancelables", "c0", ToastView.ICON_LOADING, "d0", "Y2", "()Z", "setBilingual", "(Z)V", "isBilingual", "e0", "backupSubtitleIsBilingual", "f0", "inEditing", "g0", "isMenuVisible", "h0", "enterEditPlaying", "i0", "enterEditPosition", "j0", "hasLoadingActionInOpen", "k0", "Ljava/util/ArrayList;", "editTempSubtitles", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "l0", "Ljava/util/HashSet;", "editNeedUpdateSticker", "m0", "editNeedRemoveSticker", "n0", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "lastModifySubtitle", "o0", "editBackupSubtitles", "p0", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "backupReferenceSticker", "q0", "enterStickersHashCode", "Ljava/lang/Runnable;", "r0", "runOnResumeTasks", "s0", "Ljava/util/Map;", "t0", "Ljava/lang/Float;", "u0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "Ljava/util/concurrent/atomic/AtomicInteger;", "v0", "Ljava/util/concurrent/atomic/AtomicInteger;", "progress", "w0", "clipCount", "x0", "dragPrePlaying", "y0", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "translateCancelable", "H2", "edited", "S2", "(F)F", "totalProgress", "Q2", "()I", "stickersHashCode", "<init>", "()V", "z0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSubtitleViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private dr tavcut;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<p>> _translateEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<p>> translateEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<l>> _subtitleEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<l>> subtitleLoadEvent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _playerState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> playerState;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Long, Long>> _playTime;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<Long, Long>> playTime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<Pair<Integer, Subtitle>>> _itemChange;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<Pair<Integer, Subtitle>>> itemChange;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<Pair<Integer, Subtitle>>> _itemInsert;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<Pair<Integer, Subtitle>>> itemInsert;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _triggerPlayLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> triggerPlayEvent;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final b _isBilingualLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isBilingualLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final c _showBilingualLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showBilingualLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Subtitle> stickerSubtitleMap;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private List<ResourceModel> curResources;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<SubtitlesMapKey, List<SubtitleLine>> subtitlesMap;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkSubtitleViewModel$subtitles$1 subtitles;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.mobileqq.wink.editor.subtitle.source.a> cancelables;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loading;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isBilingual;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean backupSubtitleIsBilingual;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean inEditing;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isMenuVisible;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean enterEditPlaying;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.subtitle.source.f dataSource;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private long enterEditPosition;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean hasLoadingActionInOpen;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Subtitle> editTempSubtitles;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Subtitle> editNeedUpdateSticker;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private n stickerFactory;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Subtitle> editNeedRemoveSticker;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subtitle lastModifySubtitle;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Subtitle> editBackupSubtitles;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkStickerModel backupReferenceSticker;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private int enterStickersHashCode;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Runnable> runOnResumeTasks;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<Integer, Float> mediaClipVolumes;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float bgmVolume;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicVolumeControlViewModel.VolumeType volumeType;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger progress;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private int clipCount;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private boolean dragPrePlaying;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.subtitle.source.a translateCancelable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$b", "Landroidx/lifecycle/MutableLiveData;", "", "value", "", "d", "(Ljava/lang/Boolean;)V", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends MutableLiveData<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void postValue(@Nullable Boolean value) {
            super.postValue(value);
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void setValue(@Nullable Boolean value) {
            super.setValue(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$c", "Landroidx/lifecycle/MutableLiveData;", "", "value", "", "d", "(Ljava/lang/Boolean;)V", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends MutableLiveData<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void postValue(@Nullable Boolean value) {
            super.postValue(value);
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void setValue(@Nullable Boolean value) {
            super.setValue(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Subtitle) t16).getAbsStartTimeUs()), Long.valueOf(((Subtitle) t17).getAbsStartTimeUs()));
            return compareValues;
        }
    }

    public WinkSubtitleViewModel() {
        Lazy lazy;
        List<ResourceModel> emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSubtitleViewModel$playerListener$2.a>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$playerListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$playerListener$2$a", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements IPlayer.PlayerListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WinkSubtitleViewModel f322142a;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$playerListener$2$a$a, reason: collision with other inner class name */
                /* loaded from: classes21.dex */
                public /* synthetic */ class C9039a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f322143a;

                    static {
                        int[] iArr = new int[IPlayer.PlayerStatus.values().length];
                        try {
                            iArr[IPlayer.PlayerStatus.PLAYING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[IPlayer.PlayerStatus.REPLAY.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[IPlayer.PlayerStatus.PAUSED.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f322143a = iArr;
                    }
                }

                a(WinkSubtitleViewModel winkSubtitleViewModel) {
                    this.f322142a = winkSubtitleViewModel;
                }

                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
                    IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
                }

                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = this.f322142a._playTime;
                    mutableLiveData.postValue(TuplesKt.to(Long.valueOf(currentDurationUs), Long.valueOf(playerDurationUs)));
                }

                @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
                public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
                    int i3;
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
                    if (status == null) {
                        i3 = -1;
                    } else {
                        i3 = C9039a.f322143a[status.ordinal()];
                    }
                    if (i3 == 1 || i3 == 2) {
                        mutableLiveData = this.f322142a._playerState;
                        mutableLiveData.postValue(Boolean.TRUE);
                    } else if (i3 == 3) {
                        mutableLiveData2 = this.f322142a._playerState;
                        mutableLiveData2.postValue(Boolean.FALSE);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(WinkSubtitleViewModel.this);
            }
        });
        this.playerListener = lazy;
        MutableLiveData<t73.a<p>> mutableLiveData = new MutableLiveData<>(new t73.a(p.b.f322217a));
        this._translateEvent = mutableLiveData;
        this.translateEvent = mutableLiveData;
        MutableLiveData<t73.a<l>> mutableLiveData2 = new MutableLiveData<>(new t73.a(l.C9040l.f322213a));
        this._subtitleEvent = mutableLiveData2;
        this.subtitleLoadEvent = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._playerState = mutableLiveData3;
        this.playerState = mutableLiveData3;
        MutableLiveData<Pair<Long, Long>> mutableLiveData4 = new MutableLiveData<>();
        this._playTime = mutableLiveData4;
        this.playTime = mutableLiveData4;
        MutableLiveData<t73.a<Pair<Integer, Subtitle>>> mutableLiveData5 = new MutableLiveData<>();
        this._itemChange = mutableLiveData5;
        this.itemChange = mutableLiveData5;
        MutableLiveData<t73.a<Pair<Integer, Subtitle>>> mutableLiveData6 = new MutableLiveData<>();
        this._itemInsert = mutableLiveData6;
        this.itemInsert = mutableLiveData6;
        MutableLiveData<Long> mutableLiveData7 = new MutableLiveData<>();
        this._triggerPlayLiveData = mutableLiveData7;
        this.triggerPlayEvent = mutableLiveData7;
        b bVar = new b();
        this._isBilingualLiveData = bVar;
        this.isBilingualLiveData = bVar;
        c cVar = new c();
        this._showBilingualLiveData = cVar;
        this.showBilingualLiveData = cVar;
        this.stickerSubtitleMap = new HashMap<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.curResources = emptyList;
        this.subtitlesMap = new ConcurrentHashMap<>();
        this.subtitles = new WinkSubtitleViewModel$subtitles$1(this);
        this.cancelables = new ConcurrentHashMap<>();
        this.backupSubtitleIsBilingual = this.isBilingual;
        this.hasLoadingActionInOpen = true;
        this.editTempSubtitles = new ArrayList<>();
        this.editNeedUpdateSticker = new HashSet<>();
        this.editNeedRemoveSticker = new HashSet<>();
        this.editBackupSubtitles = new ArrayList<>();
        this.runOnResumeTasks = new ArrayList<>();
        this.progress = new AtomicInteger(0);
        this.clipCount = 1;
    }

    private final void A3(dr cut, List<Subtitle> newSubtitles, Map<Subtitle, ? extends WinkStickerModel> newStickerMap) {
        List<? extends WinkStickerModel> list;
        ay.b(this.subtitles, newSubtitles);
        x2(this, null, 1, null);
        list = CollectionsKt___CollectionsKt.toList(newStickerMap.values());
        cut.W(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(WinkSubtitleViewModel this$0) {
        long j3;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.tavcut;
        if (drVar == null) {
            return;
        }
        boolean z16 = true;
        drVar.setLoopPlay(true);
        dr drVar2 = this$0.tavcut;
        if (drVar2 != null) {
            j3 = drVar2.getDurationUs();
        } else {
            j3 = 0;
        }
        drVar.setPlayTimeRange(0L, j3);
        if (!this$0.H2()) {
            o2(this$0, false, null, false, 6, null);
            return;
        }
        ArrayList<Subtitle> arrayList = this$0.editTempSubtitles;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(((Subtitle) it.next()).getLine());
                if (!isBlank) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            t73.b.b(this$0._subtitleEvent, l.a.f322200a);
            return;
        }
        this$0.E2();
        o2(this$0, false, null, false, 6, null);
        this$0.q2();
        this$0.C3(false);
    }

    private final void C3(boolean needPlayback) {
        if (needPlayback) {
            this._triggerPlayLiveData.postValue(0L);
        }
        t73.b.b(this._subtitleEvent, new l.Finished(new ArrayList(this.subtitles)));
    }

    private final WinkStickerModel D2(Subtitle subtitle) {
        Collection<WinkStickerModel> values;
        boolean z16;
        dr drVar = this.tavcut;
        Object obj = null;
        if (drVar == null) {
            return null;
        }
        String line = subtitle.getLine();
        long absStartTimeUs = subtitle.getAbsStartTimeUs();
        Map<String, WinkStickerModel> m3 = drVar.m();
        if (m3 == null || (values = m3.values()) == null) {
            return null;
        }
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            WinkStickerModel winkStickerModel = (WinkStickerModel) next;
            boolean z17 = false;
            if (winkStickerModel.startTime == absStartTimeUs) {
                List<TextItem> list = winkStickerModel.textItems;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (Intrinsics.areEqual(((TextItem) it5.next()).text, line)) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                obj = next;
                break;
            }
        }
        return (WinkStickerModel) obj;
    }

    private final boolean D3(boolean refreshStickerOnly, WinkStickerModel winkStickerModel) {
        n nVar;
        Map<Subtitle, WinkStickerModel> b16;
        List<Subtitle> sortedWith;
        dr drVar = this.tavcut;
        if (drVar == null || this.subtitlesMap.isEmpty()) {
            return false;
        }
        for (Map.Entry<SubtitlesMapKey, List<SubtitleLine>> entry : this.subtitlesMap.entrySet()) {
            SubtitlesMapKey key = entry.getKey();
            List<SubtitleLine> value = entry.getValue();
            w53.b.a(getTAG(), "refresh: " + key);
            for (SubtitleLine subtitleLine : value) {
                w53.b.a(getTAG(), "refresh: " + subtitleLine);
            }
        }
        n nVar2 = null;
        if (refreshStickerOnly) {
            n nVar3 = this.stickerFactory;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
                nVar3 = null;
            }
            n nVar4 = this.stickerFactory;
            if (nVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
            } else {
                nVar2 = nVar4;
            }
            b16 = nVar3.b(nVar2.c(this.subtitlesMap, this.subtitles), drVar, this.isBilingual, winkStickerModel);
        } else {
            a4(this, false, false, 2, null);
            n nVar5 = this.stickerFactory;
            if (nVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
                nVar = null;
            } else {
                nVar = nVar5;
            }
            b16 = n.a.b(nVar, this.subtitlesMap, drVar, this.isBilingual, null, 8, null);
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(b16.keySet(), new d());
        A3(drVar, sortedWith, b16);
        return true;
    }

    private final void E2() {
        boolean isBlank;
        dr drVar;
        ArrayList<SubtitleLineText> lines;
        boolean isBlank2;
        dr drVar2 = this.tavcut;
        if (drVar2 == null) {
            return;
        }
        WinkSubtitleViewModel$subtitles$1 winkSubtitleViewModel$subtitles$1 = this.subtitles;
        ArrayList<Subtitle> arrayList = this.editTempSubtitles;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(((Subtitle) obj).getLine());
            if (!isBlank2) {
                arrayList2.add(obj);
            }
        }
        ay.b(winkSubtitleViewModel$subtitles$1, arrayList2);
        for (Subtitle subtitle : this.subtitles) {
            if (subtitle.getLines() != null) {
                ArrayList<SubtitleLineText> lines2 = subtitle.getLines();
                Intrinsics.checkNotNull(lines2);
                if (lines2.size() > 0 && (lines = subtitle.getLines()) != null) {
                    lines.remove(0);
                }
            }
            ArrayList<SubtitleLineText> lines3 = subtitle.getLines();
            if (lines3 != null) {
                lines3.add(0, new SubtitleLineText(subtitle.getLine()));
            }
        }
        Iterator<Subtitle> it = this.editNeedRemoveSticker.iterator();
        while (it.hasNext()) {
            Subtitle subtitle2 = it.next();
            this.editNeedUpdateSticker.remove(subtitle2);
            Intrinsics.checkNotNullExpressionValue(subtitle2, "subtitle");
            WinkStickerModel D2 = D2(subtitle2);
            if (D2 != null && (drVar = this.tavcut) != null) {
                drVar.e(D2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Subtitle subtitle3 : this.editNeedUpdateSticker) {
            isBlank = StringsKt__StringsJVMKt.isBlank(subtitle3.getLine());
            if (!isBlank) {
                n nVar = this.stickerFactory;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
                    nVar = null;
                }
                WinkStickerModel a16 = n.a.a(nVar, subtitle3, drVar2, null, this.isBilingual, 4, null);
                if (a16 != null) {
                    arrayList3.add(a16);
                }
            }
        }
        dr drVar3 = this.tavcut;
        if (drVar3 != null) {
            drVar3.W(arrayList3);
        }
    }

    static /* synthetic */ boolean E3(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, WinkStickerModel winkStickerModel, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            winkStickerModel = null;
        }
        return winkSubtitleViewModel.D3(z16, winkStickerModel);
    }

    public static /* synthetic */ List G2(WinkSubtitleViewModel winkSubtitleViewModel, dr drVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drVar = null;
        }
        return winkSubtitleViewModel.F2(drVar);
    }

    private final void G3() {
        boolean isBlank;
        dr drVar = this.tavcut;
        if (drVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Subtitle subtitle : this.subtitles) {
            isBlank = StringsKt__StringsJVMKt.isBlank(subtitle.getLine());
            if (!isBlank) {
                n nVar = this.stickerFactory;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
                    nVar = null;
                }
                WinkStickerModel a16 = n.a.a(nVar, subtitle, drVar, null, this.isBilingual, 4, null);
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
        }
        drVar.W(arrayList);
    }

    private final boolean H2() {
        if ((!this.editNeedUpdateSticker.isEmpty()) || (!this.editNeedRemoveSticker.isEmpty())) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void I3(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        winkSubtitleViewModel.H3(z16);
    }

    public static /* synthetic */ void K3(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        winkSubtitleViewModel.J3(z16, z17);
    }

    private final void L3() {
        Object firstOrNull;
        ay.b(this.editBackupSubtitles, this.subtitles);
        this.backupSubtitleIsBilingual = this.isBilingual;
        WinkStickerModel winkStickerModel = null;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) G2(this, null, 1, null));
        WinkStickerModel winkStickerModel2 = (WinkStickerModel) firstOrNull;
        if (winkStickerModel2 != null) {
            winkStickerModel = WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1, 1048575, null);
        }
        this.backupReferenceSticker = winkStickerModel;
        this.enterStickersHashCode = Q2();
    }

    private final IPlayer.PlayerListener M2() {
        return (IPlayer.PlayerListener) this.playerListener.getValue();
    }

    private final void N3(boolean isShown) {
        int i3;
        if (isShown) {
            i3 = 11;
        } else {
            i3 = 12;
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(i3, 101));
    }

    private final Subtitle O2() {
        Object firstOrNull;
        Object lastOrNull;
        boolean z16;
        dr drVar = this.tavcut;
        if (drVar == null) {
            return null;
        }
        long currentPlayUs = drVar.getCurrentPlayUs();
        Iterator<Subtitle> it = this.subtitles.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                Subtitle next = it.next();
                if (next.getAbsStartTimeUs() + next.getDurationUs() >= currentPlayUs) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            w53.b.c(getTAG(), "selectRecentSubtitleToStyle: can not find subtitle by cur time " + currentPlayUs);
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.subtitles);
            return (Subtitle) lastOrNull;
        }
        Subtitle subtitle = this.subtitles.get(i3);
        Intrinsics.checkNotNullExpressionValue(subtitle, "subtitles[indexOfFirstAbove]");
        Subtitle subtitle2 = subtitle;
        if (subtitle2.getAbsStartTimeUs() > currentPlayUs) {
            if (i3 <= 0) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.subtitles);
                return (Subtitle) firstOrNull;
            }
            Subtitle subtitle3 = this.subtitles.get(i3 - 1);
            Intrinsics.checkNotNullExpressionValue(subtitle3, "subtitles[indexOfFirstAbove - 1]");
            Subtitle subtitle4 = subtitle3;
            if (Math.abs(currentPlayUs - (subtitle4.getAbsStartTimeUs() + subtitle4.getDurationUs())) <= Math.abs(currentPlayUs - subtitle2.getAbsStartTimeUs())) {
                return subtitle4;
            }
        }
        return subtitle2;
    }

    private final boolean P3(List<ResourceModel> resourceModels, boolean online) {
        List<SubtitleLine> emptyList;
        boolean z16;
        if (this.tavcut == null) {
            return false;
        }
        if (!online) {
            p3(1000023, "net_check");
            return false;
        }
        a4(this, false, false, 2, null);
        this.loading = true;
        this.subtitles.clear();
        this.subtitlesMap.clear();
        this.curResources = resourceModels;
        this.progress.set(0);
        t73.b.a(this._subtitleEvent, l.C9040l.f322213a);
        t73.b.a(this._subtitleEvent, new l.Loading(this.progress.get(), "started"));
        ArrayList<ResourceModel> arrayList = new ArrayList();
        for (Object obj : resourceModels) {
            if (((ResourceModel) obj).type != MediaType.IMAGE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        for (ResourceModel resourceModel : arrayList) {
            ConcurrentHashMap<SubtitlesMapKey, List<SubtitleLine>> concurrentHashMap = this.subtitlesMap;
            SubtitlesMapKey subtitlesMapKey = new SubtitlesMapKey(resourceModel.path, resourceModel.id);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            concurrentHashMap.put(subtitlesMapKey, emptyList);
        }
        HashSet hashSet = new HashSet();
        ArrayList<ResourceModel> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((ResourceModel) obj2).path)) {
                arrayList2.add(obj2);
            }
        }
        this.clipCount = arrayList2.size();
        for (ResourceModel resourceModel2 : arrayList2) {
            if (this.loading) {
                final String str = resourceModel2.path;
                w53.b.a(getTAG(), "----- begin extract " + str);
                com.tencent.mobileqq.wink.editor.subtitle.source.f fVar = this.dataSource;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    fVar = null;
                }
                com.tencent.mobileqq.wink.editor.subtitle.source.a put = this.cancelables.put(str, fVar.a(str, new Function4<com.tencent.mobileqq.wink.editor.subtitle.source.b, Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$startLoading$1$cancelable$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.wink.editor.subtitle.source.b bVar, Integer num, String str2, String str3) {
                        invoke(bVar, num.intValue(), str2, str3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull com.tencent.mobileqq.wink.editor.subtitle.source.b extractAudio, int i3, @Nullable String str2, @Nullable String str3) {
                        MutableLiveData mutableLiveData;
                        AtomicInteger atomicInteger;
                        float S2;
                        com.tencent.mobileqq.wink.editor.subtitle.source.a S3;
                        MutableLiveData mutableLiveData2;
                        AtomicInteger atomicInteger2;
                        float S22;
                        Intrinsics.checkNotNullParameter(extractAudio, "$this$extractAudio");
                        if (i3 == 2 && Intrinsics.areEqual("Failed to start the muxer", str2)) {
                            mutableLiveData2 = WinkSubtitleViewModel.this._subtitleEvent;
                            atomicInteger2 = WinkSubtitleViewModel.this.progress;
                            S22 = WinkSubtitleViewModel.this.S2(1.0f);
                            t73.b.a(mutableLiveData2, new l.Loading(atomicInteger2.addAndGet((int) S22), XWalkPlugin.EXTRACTED_DIR_NAME));
                            WinkSubtitleViewModel.this.v3(str, new ArrayList(0));
                            return;
                        }
                        if (i3 != 0) {
                            WinkSubtitleViewModel.this.p3(i3, "extract");
                            return;
                        }
                        w53.b.a(WinkSubtitleViewModel.this.getTAG(), "extract over " + str + " " + str3);
                        mutableLiveData = WinkSubtitleViewModel.this._subtitleEvent;
                        atomicInteger = WinkSubtitleViewModel.this.progress;
                        S2 = WinkSubtitleViewModel.this.S2(0.2f);
                        t73.b.a(mutableLiveData, new l.Loading(atomicInteger.addAndGet((int) S2), XWalkPlugin.EXTRACTED_DIR_NAME));
                        WinkSubtitleViewModel winkSubtitleViewModel = WinkSubtitleViewModel.this;
                        String str4 = str;
                        Intrinsics.checkNotNull(str3);
                        S3 = winkSubtitleViewModel.S3(str4, str3);
                        extractAudio.b(S3);
                    }
                }));
                if (put != null) {
                    put.cancel();
                }
                w53.b.a(getTAG(), "----- end extract " + str);
            }
        }
        return true;
    }

    private final int Q2() {
        Map<String, WinkStickerModel> m3;
        dr drVar = this.tavcut;
        if (drVar != null && (m3 = drVar.m()) != null) {
            return m3.hashCode();
        }
        return 0;
    }

    static /* synthetic */ boolean Q3(WinkSubtitleViewModel winkSubtitleViewModel, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return winkSubtitleViewModel.P3(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float S2(float f16) {
        return (100.0f / this.clipCount) * f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized com.tencent.mobileqq.wink.editor.subtitle.source.a S3(final String originalPath, final String path) {
        com.tencent.mobileqq.wink.editor.subtitle.source.a e16;
        w53.b.a(getTAG(), "-- begin submitAudio " + path);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.tencent.mobileqq.wink.editor.subtitle.source.f fVar = this.dataSource;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            fVar = null;
        }
        e16 = fVar.e(path, new Function3<com.tencent.mobileqq.wink.editor.subtitle.source.b, Integer, String, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$submitAudioSync$cancelable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.wink.editor.subtitle.source.b bVar, Integer num, String str) {
                invoke(bVar, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.wink.editor.subtitle.source.b submitAudio, int i3, @Nullable String str) {
                MutableLiveData mutableLiveData;
                AtomicInteger atomicInteger;
                float S2;
                com.tencent.mobileqq.wink.editor.subtitle.source.a x36;
                Intrinsics.checkNotNullParameter(submitAudio, "$this$submitAudio");
                w53.b.a(WinkSubtitleViewModel.this.getTAG(), "countDownLatch countDown");
                countDownLatch.countDown();
                if (i3 != 0) {
                    WinkSubtitleViewModel.this.p3(i3, "submit");
                    return;
                }
                w53.b.a(WinkSubtitleViewModel.this.getTAG(), "submit over " + originalPath + " " + path + " " + str);
                mutableLiveData = WinkSubtitleViewModel.this._subtitleEvent;
                atomicInteger = WinkSubtitleViewModel.this.progress;
                S2 = WinkSubtitleViewModel.this.S2(0.3f);
                t73.b.a(mutableLiveData, new l.Loading(atomicInteger.addAndGet((int) S2), "submitted"));
                WinkSubtitleViewModel winkSubtitleViewModel = WinkSubtitleViewModel.this;
                String str2 = originalPath;
                Intrinsics.checkNotNull(str);
                x36 = winkSubtitleViewModel.x3(20, 20, str2, str);
                submitAudio.b(x36);
            }
        });
        countDownLatch.await();
        w53.b.a(getTAG(), "-- end submitAudio " + path);
        return e16;
    }

    private final List<ResourceModel> V2(dr tavcut) {
        ResourceModel resourceModel;
        List<MediaClip> g06 = tavcut.g0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = g06.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel2 = ((MediaClip) it.next()).resource;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
            } else {
                resourceModel = null;
            }
            if (resourceModel != null) {
                arrayList.add(resourceModel);
            }
        }
        return arrayList;
    }

    private final com.tencent.mobileqq.wink.editor.subtitle.source.a V3(ArrayList<Subtitle> inputLines, boolean isAllTranslate, Function1<? super Boolean, Unit> callBack) {
        boolean isBlank;
        if (isAllTranslate) {
            t73.b.b(this._translateEvent, p.d.f322219a);
        } else {
            t73.b.b(this._translateEvent, p.e.f322220a);
        }
        dr drVar = this.tavcut;
        if (drVar != null) {
            drVar.isPlaying();
        }
        dr drVar2 = this.tavcut;
        if (drVar2 != null) {
            drVar2.pause();
        }
        ArrayList<Subtitle> arrayList = new ArrayList<>();
        for (Subtitle subtitle : inputLines) {
            isBlank = StringsKt__StringsJVMKt.isBlank(subtitle.getLine());
            if (isBlank) {
                subtitle.setTranslate("");
            } else {
                arrayList.add(subtitle);
            }
        }
        m.f322215a.i();
        com.tencent.mobileqq.wink.editor.subtitle.source.f fVar = this.dataSource;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            fVar = null;
        }
        com.tencent.mobileqq.wink.editor.subtitle.source.a b16 = fVar.b(arrayList, new WinkSubtitleViewModel$translateSubtitleLineTextResult$2(this, callBack, isAllTranslate, arrayList));
        this.translateCancelable = b16;
        return b16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ com.tencent.mobileqq.wink.editor.subtitle.source.a W3(WinkSubtitleViewModel winkSubtitleViewModel, ArrayList arrayList, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return winkSubtitleViewModel.V3(arrayList, z16, function1);
    }

    private final void Y3(Float bgmVolume) {
        WinkVideoTavCut winkVideoTavCut;
        if (bgmVolume != null) {
            float floatValue = bgmVolume.floatValue();
            if (MusicVolumeControlViewModel.VolumeType.TEMPLATE == this.volumeType) {
                dr drVar = this.tavcut;
                if (drVar instanceof WinkVideoTavCut) {
                    winkVideoTavCut = (WinkVideoTavCut) drVar;
                } else {
                    winkVideoTavCut = null;
                }
                if (winkVideoTavCut != null) {
                    WinkVideoTavCut.H3(winkVideoTavCut, floatValue, null, 2, null);
                    return;
                }
                return;
            }
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                dr.b.l(drVar2, floatValue, null, 2, null);
            }
        }
    }

    public static /* synthetic */ void a4(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        winkSubtitleViewModel.Z3(z16, z17);
    }

    private final void b4(Float originalVolume) {
        if (originalVolume != null) {
            float floatValue = originalVolume.floatValue();
            dr drVar = this.tavcut;
            if (drVar != null) {
                drVar.o(floatValue);
            }
        }
    }

    private final boolean c3(ResourceModel first, ResourceModel other) {
        if (Intrinsics.areEqual(first.unknownFields(), other.unknownFields()) && Intrinsics.areEqual(first.id, other.id) && Intrinsics.areEqual(first.path, other.path) && first.scaleDuration == other.scaleDuration && first.sourceStart == other.sourceStart && first.sourceDuration == other.sourceDuration && first.selectStart == other.selectStart && first.selectDuration == other.selectDuration && first.type == other.type && Intrinsics.areEqual(first.size, other.size) && Intrinsics.areEqual(first.extras, other.extras) && Intrinsics.areEqual(first.picClipRect, other.picClipRect) && Intrinsics.areEqual(first.reversePath, other.reversePath) && Intrinsics.areEqual(first.normalPath, other.normalPath) && Intrinsics.areEqual(first.isReverseMode, other.isReverseMode)) {
            return true;
        }
        return false;
    }

    private final boolean d3(List<ResourceModel> first, List<ResourceModel> second) {
        if (first.size() != second.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : first) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!c3(second.get(i3), (ResourceModel) obj)) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    public static /* synthetic */ void f3(WinkSubtitleViewModel winkSubtitleViewModel, dr drVar, boolean z16, boolean z17, WinkStickerModel winkStickerModel, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            winkStickerModel = null;
        }
        winkSubtitleViewModel.e3(drVar, z16, z17, winkStickerModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(final WinkSubtitleViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ar
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel.h3(WinkSubtitleViewModel.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(WinkSubtitleViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (E3(this$0, false, null, 3, null)) {
            this$0.q3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(WinkSubtitleViewModel this$0, List resources) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resources, "$resources");
        if (E3(this$0, false, null, 3, null)) {
            this$0.curResources = resources;
            this$0.q3();
        }
    }

    private final void l2() {
        Iterator<Map.Entry<String, com.tencent.mobileqq.wink.editor.subtitle.source.a>> it = this.cancelables.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.wink.editor.subtitle.source.a value = it.next().getValue();
            if (value.getCanceled()) {
                it.remove();
            } else {
                w53.b.c(getTAG(), "cancelLoading do cancel");
                value.cancel();
                it.remove();
            }
        }
        this.loading = false;
        r2();
    }

    private final void n2(boolean open, Subtitle subtitle, boolean needSeek) {
        boolean z16;
        long j3;
        this.inEditing = open;
        if (open) {
            dr drVar = this.tavcut;
            if (drVar != null) {
                z16 = drVar.isPlaying();
            } else {
                z16 = true;
            }
            this.enterEditPlaying = z16;
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                j3 = drVar2.getCurrentPlayUs();
            } else {
                j3 = 0;
            }
            this.enterEditPosition = j3;
            if (subtitle == null && (subtitle = O2()) == null) {
                return;
            }
            t73.b.b(this._subtitleEvent, new l.Edit(open, subtitle));
            return;
        }
        dr drVar3 = this.tavcut;
        if (drVar3 != null) {
            Subtitle subtitle2 = this.lastModifySubtitle;
            if (H2() && subtitle2 != null) {
                if (needSeek) {
                    drVar3.seek(subtitle2.getAbsStartTimeUs());
                }
                if (this.enterEditPlaying) {
                    drVar3.play();
                } else {
                    drVar3.pause();
                }
            } else {
                drVar3.seek(this.enterEditPosition);
                if (this.enterEditPlaying) {
                    drVar3.play();
                } else {
                    drVar3.pause();
                }
            }
        }
        t73.b.b(this._subtitleEvent, new l.Edit(open, null));
    }

    static /* synthetic */ void o2(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, Subtitle subtitle, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            subtitle = null;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        winkSubtitleViewModel.n2(z16, subtitle, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o3(WinkSubtitleViewModel this$0, int i3, Subtitle copy) {
        dr drVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(copy, "$copy");
        this$0.subtitles.set(i3, copy);
        this$0.lastModifySubtitle = copy;
        t73.b.b(this$0._subtitleEvent, new l.Finished(new ArrayList(this$0.subtitles)));
        Subtitle subtitle = this$0.lastModifySubtitle;
        if (subtitle != null && (drVar = this$0.tavcut) != null) {
            Intrinsics.checkNotNull(subtitle);
            drVar.seek(subtitle.getAbsStartTimeUs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3(int code, String stage) {
        w53.b.c(getTAG(), "loading error code: " + code + " in stage:" + stage);
        l2();
        t73.b.a(this._subtitleEvent, new l.Err(code));
    }

    private final void q2() {
        this.editTempSubtitles.clear();
        this.editNeedUpdateSticker.clear();
        this.editNeedRemoveSticker.clear();
        this.lastModifySubtitle = null;
    }

    private final void q3() {
        L3();
        this.cancelables.clear();
        this.loading = false;
        C3(this.hasLoadingActionInOpen);
    }

    private final void r2() {
        List<ResourceModel> emptyList;
        this.subtitlesMap.clear();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.curResources = emptyList;
    }

    private final void r3(Subtitle selectedSubtitle) {
        this.editTempSubtitles.addAll(this.subtitles);
        o2(this, true, selectedSubtitle, false, 4, null);
        dr drVar = this.tavcut;
        if (drVar != null) {
            drVar.setLoopPlay(false);
        }
        dr drVar2 = this.tavcut;
        if (drVar2 != null) {
            drVar2.pause();
        }
    }

    static /* synthetic */ void s3(WinkSubtitleViewModel winkSubtitleViewModel, Subtitle subtitle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            subtitle = null;
        }
        winkSubtitleViewModel.r3(subtitle);
    }

    private final void t2() {
        q2();
        y2();
    }

    public static /* synthetic */ void v2(WinkSubtitleViewModel winkSubtitleViewModel, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        winkSubtitleViewModel.u2(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v3(String path, List<SubtitleLine> result) {
        Set<SubtitlesMapKey> keySet = this.subtitlesMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "subtitlesMap.keys");
        for (SubtitlesMapKey it : keySet) {
            if (Intrinsics.areEqual(it.getPath(), path)) {
                ConcurrentHashMap<SubtitlesMapKey, List<SubtitleLine>> concurrentHashMap = this.subtitlesMap;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                concurrentHashMap.put(it, result);
            }
        }
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.au
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel.w3(WinkSubtitleViewModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(WinkSubtitleViewModel this$0) {
        List emptyList;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection<List<SubtitleLine>> values = this$0.subtitlesMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "subtitlesMap.values");
        Collection<List<SubtitleLine>> collection = values;
        boolean z18 = true;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                if (list != emptyList) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (z17) {
            t73.b.b(this$0._subtitleEvent, new l.Loading(100, "generate"));
            Collection<List<SubtitleLine>> values2 = this$0.subtitlesMap.values();
            Intrinsics.checkNotNullExpressionValue(values2, "subtitlesMap.values");
            Collection<List<SubtitleLine>> collection2 = values2;
            if (!collection2.isEmpty()) {
                Iterator<T> it5 = collection2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    } else if (!((List) it5.next()).isEmpty()) {
                        z18 = false;
                        break;
                    }
                }
            }
            if (z18) {
                this$0.p3(1000022, "refresh");
            } else if (E3(this$0, false, null, 3, null)) {
                this$0.q3();
                this$0._triggerPlayLiveData.postValue(0L);
            } else {
                this$0.p3(1000020, "refresh");
            }
        }
    }

    public static /* synthetic */ void x2(WinkSubtitleViewModel winkSubtitleViewModel, dr drVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drVar = null;
        }
        winkSubtitleViewModel.w2(drVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.subtitle.source.a x3(final int remainCount, final int maxRetryCount, final String originalPath, final String taskId) {
        if (!this.loading) {
            return com.tencent.mobileqq.wink.editor.subtitle.source.g.a();
        }
        if (remainCount == 0) {
            w53.b.a(getTAG(), "query timeout " + originalPath + " " + taskId);
            p3(1000012, "query");
            return com.tencent.mobileqq.wink.editor.subtitle.source.g.a();
        }
        com.tencent.mobileqq.wink.editor.subtitle.source.f fVar = this.dataSource;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            fVar = null;
        }
        return fVar.c(taskId, 500L, new Function3<com.tencent.mobileqq.wink.editor.subtitle.source.b, Integer, String, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$querySubtitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.wink.editor.subtitle.source.b bVar, Integer num, String str) {
                invoke(bVar, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.wink.editor.subtitle.source.b queryResult, int i3, @Nullable String str) {
                MutableLiveData mutableLiveData;
                AtomicInteger atomicInteger;
                float S2;
                com.tencent.mobileqq.wink.editor.subtitle.source.a z26;
                MutableLiveData mutableLiveData2;
                AtomicInteger atomicInteger2;
                float S22;
                com.tencent.mobileqq.wink.editor.subtitle.source.a x36;
                Intrinsics.checkNotNullParameter(queryResult, "$this$queryResult");
                w53.b.a(WinkSubtitleViewModel.this.getTAG(), "query continue: " + originalPath + " " + taskId + " " + remainCount + " " + i3 + " " + str);
                if (i3 == 0) {
                    mutableLiveData = WinkSubtitleViewModel.this._subtitleEvent;
                    atomicInteger = WinkSubtitleViewModel.this.progress;
                    S2 = WinkSubtitleViewModel.this.S2(0.4f);
                    t73.b.a(mutableLiveData, new l.Loading(atomicInteger.addAndGet((int) (S2 * (remainCount / maxRetryCount))), "queryFinished"));
                    z26 = WinkSubtitleViewModel.this.z2(originalPath, str);
                    queryResult.b(z26);
                    return;
                }
                if (i3 != 9001) {
                    WinkSubtitleViewModel.this.p3(i3, "query");
                    return;
                }
                mutableLiveData2 = WinkSubtitleViewModel.this._subtitleEvent;
                atomicInteger2 = WinkSubtitleViewModel.this.progress;
                S22 = WinkSubtitleViewModel.this.S2(0.4f);
                t73.b.a(mutableLiveData2, new l.Loading(atomicInteger2.addAndGet((int) (S22 / maxRetryCount)), "query"));
                x36 = WinkSubtitleViewModel.this.x3(remainCount - 1, maxRetryCount, originalPath, taskId);
                queryResult.b(x36);
            }
        });
    }

    private final void y2() {
        dr drVar;
        t73.b.b(this._subtitleEvent, l.e.f322204a);
        Y3(this.bgmVolume);
        Map<Integer, Float> map = this.mediaClipVolumes;
        if (map != null && (drVar = this.tavcut) != null) {
            drVar.v(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.subtitle.source.a z2(final String originalPath, final String url) {
        com.tencent.mobileqq.wink.editor.subtitle.source.f fVar = this.dataSource;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            fVar = null;
        }
        return fVar.d(url, new Function2<Integer, SubtitleResult, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$downloadSubtitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, SubtitleResult subtitleResult) {
                invoke(num.intValue(), subtitleResult);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable SubtitleResult subtitleResult) {
                MutableLiveData mutableLiveData;
                AtomicInteger atomicInteger;
                float S2;
                List<SubtitleLine> arrayList;
                mutableLiveData = WinkSubtitleViewModel.this._subtitleEvent;
                atomicInteger = WinkSubtitleViewModel.this.progress;
                S2 = WinkSubtitleViewModel.this.S2(0.1f);
                t73.b.a(mutableLiveData, new l.Loading(atomicInteger.addAndGet((int) S2), "downloaded"));
                if (i3 != 0) {
                    WinkSubtitleViewModel.this.p3(i3, "downloaded");
                    return;
                }
                w53.b.a(WinkSubtitleViewModel.this.getTAG(), "downloadSubtitle: " + originalPath + " " + i3 + " " + url + "  " + subtitleResult);
                WinkSubtitleViewModel winkSubtitleViewModel = WinkSubtitleViewModel.this;
                String str = originalPath;
                if (subtitleResult == null || (arrayList = subtitleResult.getItems()) == null) {
                    arrayList = new ArrayList<>(0);
                }
                winkSubtitleViewModel.v3(str, arrayList);
            }
        });
    }

    public final void A2() {
        boolean z16;
        if (!this.inEditing) {
            dr drVar = this.tavcut;
            if (drVar != null) {
                z16 = drVar.isPlaying();
            } else {
                z16 = false;
            }
            this.dragPrePlaying = z16;
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                drVar2.pause();
            }
        }
    }

    public final void B2(boolean open) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.at
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel.C2(WinkSubtitleViewModel.this);
            }
        };
        dr drVar = this.tavcut;
        if (drVar != null) {
            if (!open && !this.isBilingual) {
                runnable.run();
                return;
            }
            if (!open && this.isBilingual) {
                ArrayList<Subtitle> arrayList = new ArrayList<>();
                for (Subtitle subtitle : this.editTempSubtitles) {
                    if (subtitle.getNeedUpdateTranslate()) {
                        arrayList.add(subtitle);
                    }
                }
                t73.b.b(this._subtitleEvent, new l.Edit(false, null));
                if (H2()) {
                    Subtitle subtitle2 = this.lastModifySubtitle;
                    if (subtitle2 != null) {
                        drVar.seek(subtitle2.getAbsStartTimeUs());
                    }
                    V3(arrayList, false, new WinkSubtitleViewModel$edit$1$3(runnable));
                    return;
                }
                runnable.run();
                return;
            }
            s3(this, null, 1, null);
        }
    }

    @NotNull
    public final List<WinkStickerModel> F2(@Nullable dr winkTavCutDelegate) {
        List<WinkStickerModel> emptyList;
        Collection<WinkStickerModel> values;
        List<WinkStickerModel> emptyList2;
        dr drVar = this.tavcut;
        if (drVar != null) {
            winkTavCutDelegate = drVar;
        }
        if (winkTavCutDelegate == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        Map<String, WinkStickerModel> m3 = winkTavCutDelegate.m();
        if (m3 == null || (values = m3.values()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((WinkStickerModel) obj).isSubtitleSticker()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void F3(int highlightIndex) {
        Object orNull;
        dr drVar;
        if (!this.inEditing) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.subtitles, highlightIndex);
            Subtitle subtitle = (Subtitle) orNull;
            if (subtitle == null) {
                return;
            }
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                drVar2.seek(subtitle.getAbsStartTimeUs());
            }
            if (this.dragPrePlaying && (drVar = this.tavcut) != null) {
                drVar.play();
            }
        }
    }

    public final void H3(boolean confirm) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        dr drVar = this.tavcut;
        if (drVar == null) {
            return;
        }
        if (this.hasLoadingActionInOpen) {
            t73.b.b(this._subtitleEvent, l.b.f322201a);
            return;
        }
        if (this.enterStickersHashCode == Q2()) {
            q2();
            y2();
            return;
        }
        if (confirm) {
            t73.b.b(this._subtitleEvent, l.d.f322203a);
            return;
        }
        ArrayList<Subtitle> arrayList = this.editBackupSubtitles;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        Iterator<T> it = arrayList.iterator();
        while (true) {
            n nVar = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Subtitle subtitle = (Subtitle) next;
            n nVar2 = this.stickerFactory;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerFactory");
            } else {
                nVar = nVar2;
            }
            linkedHashMap.put(next, nVar.a(subtitle, drVar, this.backupReferenceSticker, this.backupSubtitleIsBilingual));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it5 = linkedHashMap.entrySet().iterator();
        while (true) {
            boolean z16 = false;
            if (it5.hasNext()) {
                Map.Entry entry = (Map.Entry) it5.next();
                if (((WinkStickerModel) entry.getValue()) != null) {
                    z16 = true;
                }
                if (z16) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            } else {
                A3(drVar, this.editBackupSubtitles, linkedHashMap2);
                a4(this, this.backupSubtitleIsBilingual, false, 2, null);
                q2();
                y2();
                return;
            }
        }
    }

    /* renamed from: I2, reason: from getter */
    public final boolean getInEditing() {
        return this.inEditing;
    }

    @NotNull
    public final LiveData<t73.a<Pair<Integer, Subtitle>>> J2() {
        return this.itemChange;
    }

    public final void J3(boolean needConfirm, boolean needSeek) {
        if (!H2()) {
            dr drVar = this.tavcut;
            if (drVar != null) {
                drVar.setPlayTimeRange(0L, drVar.getDurationUs());
            }
            o2(this, false, null, false, 6, null);
            return;
        }
        if (needConfirm) {
            t73.b.b(this._subtitleEvent, l.c.f322202a);
            return;
        }
        o2(this, false, null, needSeek, 2, null);
        q2();
        C3(false);
    }

    @NotNull
    public final LiveData<t73.a<Pair<Integer, Subtitle>>> K2() {
        return this.itemInsert;
    }

    @NotNull
    public final LiveData<Pair<Long, Long>> L2() {
        return this.playTime;
    }

    public final void M3() {
        boolean z16;
        dr drVar = this.tavcut;
        if (drVar == null) {
            return;
        }
        drVar.pause();
        long currentPlayUs = drVar.getCurrentPlayUs();
        Subtitle O2 = O2();
        if (O2 == null) {
            w53.b.c(getTAG(), "selectRecentSubtitleToStyle: can not find subtitle by cur time " + currentPlayUs + " " + this.subtitles.size());
            return;
        }
        Object obj = null;
        Iterator it = G2(this, null, 1, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((WinkStickerModel) next).startTime == O2.getAbsStartTimeUs()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
        if (winkStickerModel == null) {
            w53.b.c(getTAG(), "selectRecentSubtitleToStyle: can not find sticker by subtitle " + O2);
            return;
        }
        w53.b.f(getTAG(), "selectRecentSubtitleToStyle: subtitle " + O2);
        t73.b.b(this._subtitleEvent, new l.Styling(winkStickerModel));
    }

    @NotNull
    public final LiveData<Boolean> N2() {
        return this.playerState;
    }

    public final void O3(@Nullable Map<Integer, Float> mediaClipVolumes, @Nullable Float bgmVolume, @Nullable MusicVolumeControlViewModel.VolumeType volumeType) {
        this.bgmVolume = bgmVolume;
        this.mediaClipVolumes = mediaClipVolumes;
        this.volumeType = volumeType;
    }

    @NotNull
    public final LiveData<Boolean> P2() {
        return this.showBilingualLiveData;
    }

    @NotNull
    public final LiveData<t73.a<l>> R2() {
        return this.subtitleLoadEvent;
    }

    public final void R3() {
        l2();
        if (this.loading) {
            y2();
        } else {
            v2(this, false, false, 2, null);
        }
    }

    @NotNull
    public final LiveData<t73.a<p>> T2() {
        return this.translateEvent;
    }

    public final void T3() {
        dr drVar = this.tavcut;
        if (drVar != null) {
            if (drVar.isPlaying()) {
                drVar.pause();
            } else {
                drVar.play();
            }
        }
    }

    @NotNull
    public final LiveData<Long> U2() {
        return this.triggerPlayEvent;
    }

    public final void U3() {
        m2();
        dr drVar = this.tavcut;
        boolean z16 = false;
        if (drVar != null && drVar.isPlaying()) {
            z16 = true;
        }
        this.enterEditPlaying = z16;
        W3(this, this.subtitles, true, null, 4, null);
    }

    public final void W2(@NotNull com.tencent.mobileqq.wink.editor.subtitle.source.f netDataSource, @NotNull n stickerFactory) {
        Intrinsics.checkNotNullParameter(netDataSource, "netDataSource");
        Intrinsics.checkNotNullParameter(stickerFactory, "stickerFactory");
        this.dataSource = netDataSource;
        this.stickerFactory = stickerFactory;
    }

    public final void X3() {
        a4(this, true, false, 2, null);
        x2(this, null, 1, null);
        G3();
    }

    /* renamed from: Y2, reason: from getter */
    public final boolean getIsBilingual() {
        return this.isBilingual;
    }

    public final void Z3(boolean useBilingual, boolean updateLiveData) {
        if (useBilingual == this.isBilingual) {
            return;
        }
        if (updateLiveData) {
            this._isBilingualLiveData.postValue(Boolean.valueOf(useBilingual));
        }
        this.isBilingual = useBilingual;
    }

    @NotNull
    public final LiveData<Boolean> a3() {
        return this.isBilingualLiveData;
    }

    public final boolean b3() {
        if (this.subtitles.size() == 1) {
            return true;
        }
        return false;
    }

    public final void c4(@Nullable final WinkStickerModel stickerModel, @Nullable String content, @Nullable final MetaMaterial material, @Nullable final Function0<Unit> finish) {
        if (content != null && stickerModel != null) {
            dr drVar = this.tavcut;
            boolean z16 = false;
            if (drVar != null && drVar.isPlaying()) {
                z16 = true;
            }
            this.enterEditPlaying = z16;
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                drVar2.pause();
            }
            n3(content, stickerModel, new Function2<String, Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel$updateSubtitle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                    invoke(str, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str, boolean z17) {
                    dr drVar3;
                    Size renderSize;
                    Integer num;
                    WinkStickerModel winkStickerModel;
                    if (z17 && str != null) {
                        WinkStickerModel winkStickerModel2 = stickerModel;
                        MetaMaterial metaMaterial = material;
                        WinkSubtitleViewModel winkSubtitleViewModel = this;
                        MetaMaterial material2 = winkStickerModel2.getMaterial();
                        if (material2 != null) {
                            winkSubtitleViewModel.e4(material2, str);
                        }
                        if (metaMaterial != null) {
                            winkSubtitleViewModel.e4(metaMaterial, str);
                        }
                        drVar3 = winkSubtitleViewModel.tavcut;
                        if (drVar3 != null && (num = (renderSize = drVar3.getRenderSize()).width) != null && renderSize.height != null) {
                            if (metaMaterial != null) {
                                Intrinsics.checkNotNull(num);
                                int intValue = num.intValue();
                                Integer num2 = renderSize.height;
                                Intrinsics.checkNotNull(num2);
                                winkStickerModel = com.tencent.mobileqq.wink.editor.sticker.l.v(metaMaterial, drVar3, intValue, num2.intValue(), winkStickerModel2);
                            } else {
                                winkStickerModel = null;
                            }
                            if (winkStickerModel != null) {
                                dr.b.n(drVar3, winkStickerModel, false, 2, null);
                            }
                        }
                    }
                    Function0<Unit> function0 = finish;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    public final void d4(@NotNull l event) {
        Intrinsics.checkNotNullParameter(event, "event");
        t73.b.b(this._subtitleEvent, event);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e3(@NotNull dr tavcut, boolean fromMenuOpen, boolean online, @Nullable WinkStickerModel winkStickerModel) {
        boolean z16;
        int collectionSizeOrDefault;
        List distinct;
        int collectionSizeOrDefault2;
        List distinct2;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(tavcut, "tavcut");
        w53.b.a(getTAG(), "loadSubtitle: fromMenuOpen:" + fromMenuOpen + ", online:" + online + " isMenuVisible " + this.isMenuVisible);
        if (this.isMenuVisible && !fromMenuOpen) {
            return;
        }
        this.tavcut = tavcut;
        final List<ResourceModel> V2 = V2(tavcut);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = V2.iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ResourceModel) next).type != MediaType.IMAGE) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((ResourceModel) it5.next()).path);
        }
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList2);
        List<ResourceModel> list = this.curResources;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (((ResourceModel) obj).type != MediaType.IMAGE) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            arrayList4.add(((ResourceModel) it6.next()).path);
        }
        distinct2 = CollectionsKt___CollectionsKt.distinct(arrayList4);
        List G2 = G2(this, null, 1, null);
        if ((!this.curResources.isEmpty()) && G2.isEmpty() && winkStickerModel == null) {
            this.subtitles.clear();
        }
        if (!fromMenuOpen) {
            if ((!this.curResources.isEmpty()) && !Intrinsics.areEqual(this.curResources, V2)) {
                List list2 = distinct;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it7 = list2.iterator();
                    while (it7.hasNext()) {
                        if (distinct2.contains((String) it7.next())) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (z17 && (!G2(this, null, 1, null).isEmpty())) {
                    if (D3(true, winkStickerModel)) {
                        this.curResources = V2;
                    } else {
                        P3(V2, true);
                        if (!z16) {
                            this.tavcut = null;
                            return;
                        }
                        return;
                    }
                } else {
                    x2(this, null, 1, null);
                }
            }
            z16 = true;
            if (!z16) {
            }
        } else {
            if (distinct.isEmpty()) {
                this.hasLoadingActionInOpen = false;
                p3(1000021, "verify");
                return;
            }
            if (this.curResources.isEmpty()) {
                this.hasLoadingActionInOpen = P3(V2, online);
                return;
            }
            if (d3(this.curResources, V2)) {
                if (this.subtitles.isEmpty()) {
                    this.hasLoadingActionInOpen = true;
                    this.runOnResumeTasks.add(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ap
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkSubtitleViewModel.g3(WinkSubtitleViewModel.this);
                        }
                    });
                    return;
                } else {
                    this.hasLoadingActionInOpen = false;
                    q3();
                    return;
                }
            }
            if (distinct2.containsAll(distinct)) {
                this.hasLoadingActionInOpen = false;
                this.runOnResumeTasks.add(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkSubtitleViewModel.i3(WinkSubtitleViewModel.this, V2);
                    }
                });
            } else {
                this.hasLoadingActionInOpen = Q3(this, V2, false, 2, null);
            }
        }
    }

    public final void e4(@NotNull MetaMaterial material, @NotNull String transition) {
        ArrayList<MetaMaterialContent> arrayList;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(transition, "transition");
        Map<String, Serializable> map = material.additionalObjectFields;
        if (map == null) {
            return;
        }
        MetaMaterialContentWrapper metaMaterialContentWrapper = (MetaMaterialContentWrapper) map.get("contents");
        if (metaMaterialContentWrapper != null) {
            arrayList = metaMaterialContentWrapper.getMetaMaterialContent();
        } else {
            arrayList = null;
        }
        if (arrayList != null && metaMaterialContentWrapper.getMetaMaterialContent().size() >= 2) {
            metaMaterialContentWrapper.getMetaMaterialContent().get(1).setContent(transition);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkSubtitleViewModel";
    }

    public final void j2() {
        if (this.inEditing) {
            K3(this, true, false, 2, null);
        } else {
            I3(this, false, 1, null);
        }
    }

    public final void j3() {
        this.isMenuVisible = false;
        dr drVar = this.tavcut;
        if (drVar != null) {
            drVar.removePlayerListener(M2());
        }
        this.tavcut = null;
        N3(false);
    }

    public final void k2() {
        if (this.loading) {
            t73.b.b(this._subtitleEvent, l.k.f322212a);
        } else {
            r2();
            y2();
        }
    }

    public final void k3(int index, @NotNull String origContent, @NotNull String curContent, @NotNull String newContent) {
        Intrinsics.checkNotNullParameter(origContent, "origContent");
        Intrinsics.checkNotNullParameter(curContent, "curContent");
        Intrinsics.checkNotNullParameter(newContent, "newContent");
        Subtitle subtitle = this.editTempSubtitles.get(index);
        Intrinsics.checkNotNullExpressionValue(subtitle, "editTempSubtitles[index]");
        Subtitle subtitle2 = subtitle;
        long length = (curContent.length() / origContent.length()) * ((float) subtitle2.getDurationUs());
        long durationUs = subtitle2.getDurationUs() - length;
        long startTimeUs = subtitle2.getStartTimeUs() + length;
        String translate = subtitle2.getTranslate();
        Subtitle.Companion companion = Subtitle.INSTANCE;
        Subtitle copy$default = Subtitle.copy$default(subtitle2, curContent, 0L, length, 0L, startTimeUs, translate, companion.a(), true, null, 266, null);
        Subtitle copy$default2 = Subtitle.copy$default(subtitle2, newContent, subtitle2.getAbsStartTimeUs() + length, durationUs, subtitle2.getStartTimeUs() + length, 0L, "", companion.a(), true, null, 272, null);
        this.lastModifySubtitle = copy$default2;
        this.editNeedUpdateSticker.remove(subtitle2);
        this.editNeedRemoveSticker.add(subtitle2);
        this.editNeedUpdateSticker.add(copy$default2);
        this.editNeedUpdateSticker.add(copy$default);
        this.editTempSubtitles.add(index, copy$default);
        t73.b.b(this._itemInsert, TuplesKt.to(Integer.valueOf(index), copy$default));
        int i3 = index + 1;
        this.editTempSubtitles.set(i3, copy$default2);
        t73.b.b(this._itemChange, TuplesKt.to(Integer.valueOf(i3), copy$default2));
    }

    public final void l3(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.subtitles, index);
        t3((Subtitle) orNull);
    }

    public final void m2() {
        com.tencent.mobileqq.wink.editor.subtitle.source.a aVar = this.translateCancelable;
        if (aVar != null) {
            aVar.cancel();
        }
        this.translateCancelable = null;
    }

    public final void m3(int index, @NotNull String content) {
        boolean isBlank;
        Object orNull;
        Object orNull2;
        Intrinsics.checkNotNullParameter(content, "content");
        Subtitle subtitle = this.editTempSubtitles.get(index);
        Intrinsics.checkNotNullExpressionValue(subtitle, "editTempSubtitles[index]");
        Subtitle subtitle2 = subtitle;
        if (Intrinsics.areEqual(subtitle2.getLine(), content)) {
            return;
        }
        Subtitle copy$default = Subtitle.copy$default(subtitle2, content, 0L, 0L, 0L, 0L, null, Subtitle.INSTANCE.a(), true, null, 318, null);
        this.editNeedUpdateSticker.remove(subtitle2);
        this.editNeedRemoveSticker.add(subtitle2);
        this.editNeedUpdateSticker.add(copy$default);
        isBlank = StringsKt__StringsJVMKt.isBlank(content);
        if (isBlank) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.editTempSubtitles, index + 1);
            Subtitle subtitle3 = (Subtitle) orNull;
            if (subtitle3 == null) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.editTempSubtitles, index - 1);
                subtitle3 = (Subtitle) orNull2;
            }
            this.lastModifySubtitle = subtitle3;
        } else {
            this.lastModifySubtitle = copy$default;
        }
        this.editTempSubtitles.set(index, copy$default);
        t73.b.b(this._itemChange, TuplesKt.to(Integer.valueOf(index), copy$default));
    }

    public final void n3(@NotNull String content, @NotNull WinkStickerModel sticker, @NotNull Function2<? super String, ? super Boolean, Unit> callBack) {
        boolean isBlank;
        Object orNull;
        dr drVar;
        Object orNull2;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(sticker, "sticker");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        Subtitle subtitle = null;
        int i3 = 0;
        int i16 = 0;
        for (Subtitle subtitle2 : this.subtitles) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Subtitle subtitle3 = subtitle2;
            if (subtitle3.getAbsStartTimeUs() == sticker.startTime) {
                i16 = i3;
                subtitle = subtitle3;
            }
            i3 = i17;
        }
        if (subtitle == null) {
            callBack.invoke(null, Boolean.FALSE);
            w53.b.c(getTAG(), "cannot find this stickermodel " + sticker.id);
            return;
        }
        if (Intrinsics.areEqual(subtitle.getLine(), content)) {
            callBack.invoke(subtitle.getTranslate(), Boolean.TRUE);
            return;
        }
        final int i18 = i16;
        final Subtitle copy$default = Subtitle.copy$default(subtitle, content, 0L, 0L, 0L, 0L, null, Subtitle.INSTANCE.a(), true, null, 318, null);
        isBlank = StringsKt__StringsJVMKt.isBlank(content);
        if (isBlank) {
            this.subtitles.remove(i18);
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.subtitles, i18);
            Subtitle subtitle4 = (Subtitle) orNull;
            if (subtitle4 == null) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.subtitles, i18 - 1);
                subtitle4 = (Subtitle) orNull2;
            }
            this.lastModifySubtitle = subtitle4;
            callBack.invoke(content, Boolean.TRUE);
            t73.b.b(this._subtitleEvent, new l.Finished(new ArrayList(this.subtitles)));
            Subtitle subtitle5 = this.lastModifySubtitle;
            if (subtitle5 != null && (drVar = this.tavcut) != null) {
                Intrinsics.checkNotNull(subtitle5);
                drVar.seek(subtitle5.getAbsStartTimeUs());
                return;
            }
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.as
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel.o3(WinkSubtitleViewModel.this, i18, copy$default);
            }
        };
        if (this.isBilingual) {
            ArrayList<Subtitle> arrayList = new ArrayList<>();
            arrayList.add(copy$default);
            V3(arrayList, false, new WinkSubtitleViewModel$onItemEditedSingleLine$2(runnable, content, callBack, copy$default));
        } else {
            runnable.run();
            callBack.invoke(null, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.tavcut = null;
    }

    public final void onResume() {
        if (this.loading) {
            dr drVar = this.tavcut;
            if (drVar != null) {
                drVar.pause();
            }
        } else {
            dr drVar2 = this.tavcut;
            if (drVar2 != null) {
                drVar2.play();
            }
        }
        Iterator<Runnable> it = this.runOnResumeTasks.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.runOnResumeTasks.clear();
    }

    public final void p2() {
        m2();
        x2(this, null, 1, null);
        a4(this, false, false, 2, null);
        G3();
    }

    public final void s2() {
        if (this.inEditing) {
            B2(false);
        } else {
            t2();
        }
    }

    public final void t3(@Nullable Subtitle selectedSubtitle) {
        boolean z16;
        if (this.tavcut == null) {
            return;
        }
        if (selectedSubtitle == null) {
            w53.b.c(getTAG(), "selectedSubtitle is null");
            return;
        }
        Object obj = null;
        Iterator it = G2(this, null, 1, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((WinkStickerModel) next).startTime == selectedSubtitle.getAbsStartTimeUs()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
        if (winkStickerModel == null) {
            w53.b.c(getTAG(), "openKeyBorderEdit: can not find sticker by subtitle " + selectedSubtitle);
            return;
        }
        t73.b.b(this._subtitleEvent, new l.KeyBoard(winkStickerModel));
    }

    public final void u2(boolean fromEdit, boolean clearEditStat) {
        int collectionSizeOrDefault;
        List distinct;
        boolean z16;
        if (clearEditStat) {
            o2(this, false, null, false, 6, null);
        }
        w53.b.a(getTAG(), "delete all " + fromEdit);
        a4(this, false, false, 2, null);
        x2(this, null, 1, null);
        this.subtitles.clear();
        if (fromEdit) {
            q2();
        }
        dr drVar = this.tavcut;
        if (drVar != null) {
            List<ResourceModel> V2 = V2(drVar);
            ArrayList<ResourceModel> arrayList = new ArrayList();
            for (Object obj : V2) {
                if (((ResourceModel) obj).type != MediaType.IMAGE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (ResourceModel resourceModel : arrayList) {
                arrayList2.add(new SubtitlesMapKey(resourceModel.path, resourceModel.id));
            }
            distinct = CollectionsKt___CollectionsKt.distinct(arrayList2);
            if (!this.subtitlesMap.keySet().containsAll(distinct)) {
                w53.b.a(getTAG(), "delete all " + fromEdit + " and clear netCache");
                r2();
            } else {
                w53.b.a(getTAG(), "delete all " + fromEdit + " and not clear netCache");
            }
        }
        y2();
    }

    public final void u3(@NotNull dr tavcut, boolean online) {
        Intrinsics.checkNotNullParameter(tavcut, "tavcut");
        this.runOnResumeTasks.clear();
        this.tavcut = tavcut;
        this.inEditing = false;
        this.isMenuVisible = true;
        tavcut.addPlayerListener(M2());
        this._playerState.setValue(Boolean.valueOf(tavcut.isPlaying()));
        this._playTime.setValue(TuplesKt.to(Long.valueOf(tavcut.getCurrentPlayUs()), Long.valueOf(tavcut.getDurationUs())));
        Y3(Float.valueOf(0.0f));
        b4(Float.valueOf(1.0f));
        f3(this, tavcut, false, online, null, 10, null);
        N3(true);
    }

    public final void w2(@Nullable dr winkTavCutDelegate) {
        dr drVar = this.tavcut;
        if (drVar != null) {
            winkTavCutDelegate = drVar;
        }
        if (winkTavCutDelegate == null) {
            return;
        }
        winkTavCutDelegate.T(F2(winkTavCutDelegate));
    }

    public final void y3(@NotNull Subtitle line) {
        dr drVar;
        Intrinsics.checkNotNullParameter(line, "line");
        if (line.getDurationUs() > 0 && (drVar = this.tavcut) != null) {
            if (drVar.isPlaying()) {
                long absStartTimeUs = line.getAbsStartTimeUs();
                long absStartTimeUs2 = line.getAbsStartTimeUs() + line.getDurationUs();
                long currentPlayUs = drVar.getCurrentPlayUs();
                boolean z16 = false;
                if (absStartTimeUs <= currentPlayUs && currentPlayUs < absStartTimeUs2) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
            }
            drVar.seek(line.getAbsStartTimeUs());
            drVar.setPlayTimeRange(line.getAbsStartTimeUs(), line.getDurationUs());
            drVar.play();
        }
    }

    public final void z3(boolean online) {
        dr drVar = this.tavcut;
        if (drVar == null) {
            return;
        }
        l2();
        this.hasLoadingActionInOpen = P3(V2(drVar), online);
    }
}
