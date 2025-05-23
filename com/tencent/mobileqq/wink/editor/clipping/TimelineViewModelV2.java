package com.tencent.mobileqq.wink.editor.clipping;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import c63.WinkClipOpCalcResult;
import c63.WinkTimelineSeekPlayerTimeData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.DrawData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TagData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.openingending.UpdateOpeningEndingData;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import e63.SelectItem;
import e63.TimelineTimeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.TimeRange;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00a1\u00022\u00020\u0001:\u0004\u00a2\u0002\u00a3\u0002B\t\u00a2\u0006\u0006\b\u009f\u0002\u0010\u00a0\u0002J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J2\u0010\u000b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0003H\u0002J&\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u0010\u001d\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0002J\u001c\u0010'\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070$H\u0002J \u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u0007H\u0014Jr\u0010@\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\b\b\u0002\u00108\u001a\u00020\u00132\b\b\u0002\u00109\u001a\u00020\u00132\b\b\u0002\u0010:\u001a\u00020\u00132\b\b\u0002\u0010;\u001a\u00020\"2\u0018\b\u0002\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020=0<j\u0002`>J\u001e\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020A2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206J\u0006\u0010D\u001a\u00020AJ\u0006\u0010E\u001a\u00020\"J\u0014\u0010H\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u0002J\u0014\u0010J\u001a\u00020\u00072\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J(\u0010M\u001a\u00020\u00072\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010K\u001a\u00020\"2\b\b\u0002\u0010L\u001a\u00020\u0013J.\u0010Q\u001a\u00020\u00072\u0006\u0010O\u001a\u00020N2\b\b\u0002\u0010L\u001a\u00020\u00132\b\b\u0002\u0010K\u001a\u00020\"2\b\b\u0002\u0010P\u001a\u00020\u0013H\u0007J4\u0010R\u001a\u00020\u00072\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010L\u001a\u00020\u00132\b\b\u0002\u0010K\u001a\u00020\"2\b\b\u0002\u0010P\u001a\u00020\u0013H\u0007J\u001c\u0010V\u001a\u00020\u00072\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020T\u0018\u00010SJ\"\u0010Z\u001a\u00020\u00072\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020W0S2\u0006\u0010Y\u001a\u00020\u0013J\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J6\u0010`\u001a\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]2\u0014\b\u0002\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020T0SJ\u0014\u0010a\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\"\u0010b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010c\u001a\u00020\u0007J\u0016\u0010f\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\"2\u0006\u0010e\u001a\u00020\u0013J\u0006\u0010g\u001a\u00020\u001eJ\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020\u00072\u0006\u0010!\u001a\u00020iJ\u001e\u0010n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010k\u001a\u00020\u00132\u0006\u0010m\u001a\u00020lJ\u000e\u0010p\u001a\u00020\u00072\u0006\u0010!\u001a\u00020oJ\u0006\u0010q\u001a\u00020\u0007J\u0006\u0010r\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020\u00132\u0006\u0010s\u001a\u00020WJ\u0016\u0010w\u001a\u00020\u00072\u0006\u0010&\u001a\u00020u2\u0006\u0010v\u001a\u00020\u0013J\u0010\u0010y\u001a\u00020\u00072\b\b\u0002\u0010x\u001a\u00020\u0013J\b\u0010z\u001a\u0004\u0018\u00010\u0003J \u0010|\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010x\u001a\u00020\u0013J+\u0010\u0080\u0001\u001a\u00020\u00072\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020}\u0018\u00010\u00022\b\b\u0002\u0010x\u001a\u00020\u00132\b\b\u0002\u0010\u007f\u001a\u00020WJ!\u0010\u0083\u0001\u001a\u00020\u00072\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0013J\u0010\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010!\u001a\u00030\u0084\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010!\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u0013J\u0016\u0010\u008a\u0001\u001a\u00020\u00072\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0002J\u0012\u0010\u008b\u0001\u001a\u0004\u0018\u00010W\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u008d\u0001\u001a\u0004\u0018\u00010W\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008c\u0001J\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0092\u0001\u001a\u00020\u001e2\u0007\u0010\u0091\u0001\u001a\u00020\"J\u0007\u0010\u0093\u0001\u001a\u00020\u001eJ\u0007\u0010\u0094\u0001\u001a\u00020\"J\u001b\u0010\u0097\u0001\u001a\u00020\"2\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0013J\u0019\u0010\u009a\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00030\u0098\u0001j\t\u0012\u0004\u0012\u00020\u0003`\u0099\u0001J\u0010\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020\"J\u0007\u0010\u009c\u0001\u001a\u00020\u001eJ\u0007\u0010\u009d\u0001\u001a\u00020\"J\u0007\u0010\u009e\u0001\u001a\u00020\"J\u0007\u0010\u009f\u0001\u001a\u00020\u0007J\u0007\u0010\u00a0\u0001\u001a\u00020\u0007J%\u0010\u00a3\u0001\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\"2\t\b\u0002\u0010\u00a1\u0001\u001a\u00020\u00132\t\b\u0002\u0010\u00a2\u0001\u001a\u00020\u0013J\u0007\u0010\u00a4\u0001\u001a\u00020\u0007J\u0007\u0010\u00a5\u0001\u001a\u00020\"J\u0007\u0010\u00a6\u0001\u001a\u00020\"J\u0007\u0010\u00a7\u0001\u001a\u00020\u0013J\u0019\u0010\u00aa\u0001\u001a\u00020\u00072\u0007\u0010\u00a8\u0001\u001a\u00020\"2\u0007\u0010\u00a9\u0001\u001a\u00020\"J\u0011\u0010\u00ad\u0001\u001a\u00020\u00072\b\u0010\u00ac\u0001\u001a\u00030\u00ab\u0001J:\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b4\u00012\u0007\u0010\u00ae\u0001\u001a\u00020\"2\b\u0010\u00b0\u0001\u001a\u00030\u00af\u00012\u0007\u0010\u00b1\u0001\u001a\u00020\u000f2\u0012\b\u0002\u0010\u00b3\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00b2\u0001\u0018\u00010\u0002R\u0019\u0010\u00b8\u0001\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R*\u0010\u00be\u0001\u001a\u00020N2\u0007\u0010\u00b9\u0001\u001a\u00020N8\u0002@BX\u0082\u000e\u00a2\u0006\u0010\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001f\u0010\u00c3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c0\u00010\u00bf\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R$\u0010\u00c9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c0\u00010\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001R$\u0010\u00cb\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00bf\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00c2\u0001R)\u0010\u00ce\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u00c6\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00c8\u0001R+\u0010\u00d1\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u0098\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00d0\u0001R$\u0010\u00d6\u0001\u001a\n\u0012\u0005\u0012\u00030\u00d2\u00010\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d3\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00d4\u0001\u0010\u00d5\u0001R#\u0010\u00d9\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d7\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00d8\u0001\u0010\u00d5\u0001R'\u0010\u00dc\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00da\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00db\u0001\u0010\u00d5\u0001R#\u0010\u00df\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00dd\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00de\u0001\u0010\u00d5\u0001R$\u0010\u00e3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e0\u00010\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e1\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00e2\u0001\u0010\u00d5\u0001R$\u0010\u00e7\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e4\u00010\u00bf\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e5\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00d5\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00da\u0001R)\u0010\u00ee\u0001\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e9\u0001\u0010\u00da\u0001\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001\"\u0006\b\u00ec\u0001\u0010\u00ed\u0001R)\u0010\u00f5\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001\u001a\u0006\b\u00f1\u0001\u0010\u00f2\u0001\"\u0006\b\u00f3\u0001\u0010\u00f4\u0001R)\u0010\u00f9\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f6\u0001\u0010\u00f0\u0001\u001a\u0006\b\u00f7\u0001\u0010\u00f2\u0001\"\u0006\b\u00f8\u0001\u0010\u00f4\u0001R)\u0010\u00ff\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00fa\u0001\u0010\u00d7\u0001\u001a\u0006\b\u00fb\u0001\u0010\u00fc\u0001\"\u0006\b\u00fd\u0001\u0010\u00fe\u0001R\u0019\u0010\u0081\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0002\u0010\u00f0\u0001R)\u0010\u0085\u0002\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0002\u0010\u00da\u0001\u001a\u0006\b\u0083\u0002\u0010\u00eb\u0001\"\u0006\b\u0084\u0002\u0010\u00ed\u0001R\u0019\u0010\u0087\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0002\u0010\u00f0\u0001R)\u0010\u008b\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0002\u0010\u00f0\u0001\u001a\u0006\b\u0089\u0002\u0010\u00f2\u0001\"\u0006\b\u008a\u0002\u0010\u00f4\u0001R\u0018\u0010\u008f\u0002\u001a\u00030\u008c\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R)\u0010\u0093\u0002\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0002\u0010\u00da\u0001\u001a\u0006\b\u0091\u0002\u0010\u00eb\u0001\"\u0006\b\u0092\u0002\u0010\u00ed\u0001R)\u0010\u0096\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f0\u0001\u0010\u00f0\u0001\u001a\u0006\b\u0094\u0002\u0010\u00f2\u0001\"\u0006\b\u0095\u0002\u0010\u00f4\u0001R)\u0010\u009a\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0097\u0002\u0010\u00f0\u0001\u001a\u0006\b\u0098\u0002\u0010\u00f2\u0001\"\u0006\b\u0099\u0002\u0010\u00f4\u0001R)\u0010\u009e\u0002\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0002\u0010\u00f0\u0001\u001a\u0006\b\u009c\u0002\u0010\u00f2\u0001\"\u0006\b\u009d\u0002\u0010\u00f4\u0001\u00a8\u0006\u00a4\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/videocut/model/MediaClip;", "videos", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "list", "", "M3", "Le63/b;", "selectedTimeline", "K3", "mediaClip", "Lorg/light/TimeRange;", DownloaderConstant.KEY_RANGE, "", "selectedId", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "P1", "", "isSelected", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "Q1", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/g;", "tagList", "R1", "S1", "I3", "J3", "", "targetIndex", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/n;", "event", "", "o2", "Lkotlin/Function1;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "action", "O1", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "e3", "getLogTag", "onCleared", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "host", "Landroid/widget/FrameLayout;", "playerView", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "params", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "loopPlay", "isSinglePlayer", "notChangeSize", "initTime", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", BaseConstants.ATTR_KET_EXTRA_MAP, "Q2", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCut", "R2", "C2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModels", Constants.EMULATOR_INFO, "mediaClips", "y3", "targetTimeUs", "needFlushPlayer", "z3", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "forceFlush", ICustomDataEditor.STRING_PARAM_3, "t3", "", "Lcom/tencent/videocut/model/AudioModel;", "audios", "r3", "", "clipVolumes", "changedManually", "L3", "u2", "clips", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "audioMap", "x3", Constants.BASE_IN_APP_NAME, "E3", "F3", "timeUs", "outCalled", ICustomDataEditor.STRING_ARRAY_PARAM_3, "T2", "N2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/m;", "O2", "smartClipEnable", "Landroid/view/View;", "view", "P2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/c;", "H2", "J2", "w3", "speed", "E2", "Lcom/tencent/mobileqq/wink/editor/template/x$b;", "isClearSticker", "H3", "triggerSeek", Constants.MMCCID, "y2", "id", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedias", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "F2", "newClips", "needSeekFront", "I2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/e;", "M2", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/d;", "isHidden", "L2", "newStartTimes", "K2", "f2", "()Ljava/lang/Float;", "i2", "Lcom/tencent/videocut/model/MediaType;", SemanticAttributes.DbSystemValues.H2, "k2", "playerTime", "e2", "d2", "g2", "index", "isStart", "U1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p2", "N1", "X1", "j2", "T1", "d3", "c3", "openInAccurateSeek", "needScroll", "f3", "b3", "b2", "z2", "W2", "startTimeUs", "durationUs", "o3", "Lcom/tencent/mobileqq/wink/editor/openingending/b;", "updateInfo", "C3", "atTimeMs", "Lorg/light/lightAssetKit/components/Size;", "size", "templateDir", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderNodes", "Landroid/graphics/Bitmap;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "i", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCutDelegate", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/videocut/model/MediaModel;", ICustomDataEditor.NUMBER_PARAM_3, "(Lcom/tencent/videocut/model/MediaModel;)V", "mCurrentMediaModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2$b;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_mediaClipNumChangedLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "t2", "()Landroidx/lifecycle/LiveData;", "mediaClipNumChangedLiveData", "E", "_medialCLipOrderChangedLiveData", UserInfo.SEX_FEMALE, "v2", "medialCLipOrderChangedLiveData", "G", "Ljava/util/ArrayList;", "timelineList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/m;", "H", "B2", "()Landroidx/lifecycle/MutableLiveData;", "videoTracksLiveData", "I", NowProxyConstants.AccountInfoKey.A2, "videoSourceDurationLiveData", "J", "x2", "selectedTimelineLiveData", "K", "m2", "currentPlayerTimeLiveData", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "L", "l2", "currentPlayerStatus", "Lc63/b;", "M", "w2", "seekPlayerTimeLiveData", "N", "P", ICustomDataEditor.STRING_PARAM_2, "()J", "setInitDuration", "(J)V", "initDuration", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "q2", "()Z", "l3", "(Z)V", "firstEnter", BdhLogUtil.LogTag.Tag_Req, "r2", "m3", "hasChanged", ExifInterface.LATITUDE_SOUTH, "Z1", "()I", "h3", "(I)V", "counter", "T", "isChangeTrackData", "U", "getCurSeekTimeUs", "i3", "curSeekTimeUs", "V", "isTimelineInUserScroll", "W", "Y2", "p3", "isPlayingForTimeline", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "X", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "renderTimeListener", "Y", "c2", "j3", "curTargetTime", "U2", "k3", "isDraggingSlider", "a0", "V2", "setDraggingSliderForRenderListener", "isDraggingSliderForRenderListener", "b0", "getReadyForSeekDraggingClip", "q3", "readyForSeekDraggingClip", "<init>", "()V", "c0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TimelineViewModelV2 extends BaseViewModel {

    /* renamed from: C */
    @NotNull
    private final MutableLiveData<NumChangedData> _mediaClipNumChangedLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<NumChangedData> mediaClipNumChangedLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MediaClip>> _medialCLipOrderChangedLiveData;

    /* renamed from: F */
    @NotNull
    private final LiveData<List<MediaClip>> medialCLipOrderChangedLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Timeline> timelineList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<VideoTrackData> videoTracksLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> videoSourceDurationLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<SelectItem<?>> selectedTimelineLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> currentPlayerTimeLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<IPlayer.PlayerStatus> currentPlayerStatus;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkTimelineSeekPlayerTimeData> seekPlayerTimeLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private long playerTime;

    /* renamed from: P, reason: from kotlin metadata */
    private volatile long initDuration;

    /* renamed from: Q */
    private boolean firstEnter;

    /* renamed from: R */
    private boolean hasChanged;

    /* renamed from: S */
    private int counter;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isChangeTrackData;

    /* renamed from: U, reason: from kotlin metadata */
    private long curSeekTimeUs;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isTimelineInUserScroll;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isPlayingForTimeline;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final IRenderTimeListener renderTimeListener;

    /* renamed from: Y, reason: from kotlin metadata */
    private volatile long curTargetTime;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isDraggingSlider;

    /* renamed from: a0, reason: from kotlin metadata */
    private boolean isDraggingSliderForRenderListener;

    /* renamed from: b0, reason: from kotlin metadata */
    private boolean readyForSeekDraggingClip;

    /* renamed from: i, reason: from kotlin metadata */
    private dr winkTavCutDelegate;

    /* renamed from: m */
    @NotNull
    private MediaModel mCurrentMediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2$b;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "a", "", "b", "", "toString", "hashCode", "other", "", "equals", "Ljava/util/List;", "getCurrentMediaClips", "()Ljava/util/List;", "currentMediaClips", "I", "getOldClipSize", "()I", "oldClipSize", "c", "getCurrentClipSize", "currentClipSize", "<init>", "(Ljava/util/List;II)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class NumChangedData {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @NotNull
        private final List<MediaClip> currentMediaClips;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int oldClipSize;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final int currentClipSize;

        /* JADX WARN: Multi-variable type inference failed */
        public NumChangedData(@NotNull List<? extends MediaClip> currentMediaClips, int i3, int i16) {
            Intrinsics.checkNotNullParameter(currentMediaClips, "currentMediaClips");
            this.currentMediaClips = currentMediaClips;
            this.oldClipSize = i3;
            this.currentClipSize = i16;
        }

        @NotNull
        public final List<MediaClip> a() {
            return this.currentMediaClips;
        }

        /* renamed from: b, reason: from getter */
        public final int getCurrentClipSize() {
            return this.currentClipSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NumChangedData)) {
                return false;
            }
            NumChangedData numChangedData = (NumChangedData) other;
            if (Intrinsics.areEqual(this.currentMediaClips, numChangedData.currentMediaClips) && this.oldClipSize == numChangedData.oldClipSize && this.currentClipSize == numChangedData.currentClipSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.currentMediaClips.hashCode() * 31) + this.oldClipSize) * 31) + this.currentClipSize;
        }

        @NotNull
        public String toString() {
            return "NumChangedData(currentMediaClips=" + this.currentMediaClips + ", oldClipSize=" + this.oldClipSize + ", currentClipSize=" + this.currentClipSize + ")";
        }
    }

    public TimelineViewModelV2() {
        MutableLiveData<NumChangedData> mutableLiveData = new MutableLiveData<>();
        this._mediaClipNumChangedLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2.NumChangedData>");
        this.mediaClipNumChangedLiveData = mutableLiveData;
        MutableLiveData<List<MediaClip>> mutableLiveData2 = new MutableLiveData<>();
        this._medialCLipOrderChangedLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.videocut.model.MediaClip>>");
        this.medialCLipOrderChangedLiveData = mutableLiveData2;
        this.timelineList = new ArrayList<>();
        this.videoTracksLiveData = new MutableLiveData<>();
        this.videoSourceDurationLiveData = new MutableLiveData<>();
        this.selectedTimelineLiveData = new MutableLiveData<>();
        this.currentPlayerTimeLiveData = new MutableLiveData<>();
        this.currentPlayerStatus = new MutableLiveData<>();
        this.seekPlayerTimeLiveData = new MutableLiveData<>();
        this.firstEnter = true;
        this.isChangeTrackData = true;
        this.isPlayingForTimeline = true;
        this.renderTimeListener = new d();
        this.curTargetTime = -1L;
    }

    public static /* synthetic */ void A3(TimelineViewModelV2 timelineViewModelV2, List list, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        timelineViewModelV2.z3(list, j3, z16);
    }

    private final void I3() {
        ThumbAssetModel thumbAssetModel;
        ArrayList arrayList = new ArrayList();
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                thumbAssetModel = a.c(resourceModel);
            } else {
                thumbAssetModel = null;
            }
            if (thumbAssetModel != null) {
                arrayList2.add(thumbAssetModel);
            }
        }
        arrayList.addAll(arrayList2);
        ThumbnailProviderManager.f319211a.u(arrayList, toString(), this.mCurrentMediaModel.videos);
    }

    private final void J3(List<? extends MediaClip> videos) {
        ThumbAssetModel thumbAssetModel;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = videos.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                thumbAssetModel = a.c(resourceModel);
            } else {
                thumbAssetModel = null;
            }
            if (thumbAssetModel != null) {
                arrayList2.add(thumbAssetModel);
            }
        }
        arrayList.addAll(arrayList2);
        ThumbnailProviderManager.f319211a.u(arrayList, toString(), videos);
    }

    private final void K3(List<? extends MediaClip> videos, SelectItem<?> selectedTimeline, List<Timeline> list) {
        String str;
        List zip;
        int collectionSizeOrDefault;
        boolean z16;
        long j3;
        long j16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((Timeline) obj).getType(), "VideoSource")) {
                arrayList.add(obj);
            }
        }
        if (selectedTimeline == null || (str = selectedTimeline.getId()) == null) {
            str = "";
        }
        List arrayList2 = new ArrayList();
        if (videos.size() == arrayList.size()) {
            zip = CollectionsKt___CollectionsKt.zip(videos, arrayList);
            ArrayList<Pair> arrayList3 = new ArrayList();
            for (Object obj2 : zip) {
                Pair pair = (Pair) obj2;
                if (((MediaClip) pair.getFirst()).resource != null && ((Timeline) pair.getSecond()).getRange() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList3.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            for (Pair pair2 : arrayList3) {
                MediaClip mediaClip = (MediaClip) pair2.component1();
                TimeRange range = ((Timeline) pair2.component2()).getRange();
                Intrinsics.checkNotNull(range);
                arrayList4.add(P1(mediaClip, range, str));
            }
            arrayList2 = arrayList4;
        } else {
            w53.b.c("QQWinkEditViewModel", "updateVideoClip size diff!,videos:" + videos + ",videoSources:" + arrayList);
            ArrayList<MediaClip> arrayList5 = new ArrayList();
            for (Object obj3 : videos) {
                if (((MediaClip) obj3).resource != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList5.add(obj3);
                }
            }
            long j17 = 0;
            for (MediaClip mediaClip2 : arrayList5) {
                List list2 = arrayList2;
                ResourceModel resourceModel = mediaClip2.resource;
                if (resourceModel != null) {
                    j3 = resourceModel.scaleDuration;
                } else {
                    j3 = 0;
                }
                arrayList2 = CollectionsKt___CollectionsKt.plus((Collection<? extends ClipModel>) ((Collection<? extends Object>) list2), P1(mediaClip2, new TimeRange(j17, j3), str));
                ResourceModel resourceModel2 = mediaClip2.resource;
                if (resourceModel2 != null) {
                    j16 = resourceModel2.scaleDuration;
                } else {
                    j16 = 0;
                }
                j17 += j16;
            }
        }
        this.videoTracksLiveData.postValue(new VideoTrackData(arrayList2, null, 2, null));
    }

    private final void M3(List<? extends MediaClip> videos, List<Timeline> list) {
        long j3;
        TimeRange range;
        long j16;
        long j17;
        List<Timeline> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (Intrinsics.areEqual(((Timeline) obj).getType(), "VideoSource")) {
                arrayList.add(obj);
            }
        }
        Object obj2 = null;
        dr drVar = null;
        if (videos.size() != arrayList.size()) {
            dr drVar2 = this.winkTavCutDelegate;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            } else {
                drVar = drVar2;
            }
            j3 = drVar.getDurationUs();
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : list2) {
                if (Intrinsics.areEqual(((Timeline) obj3).getType(), "VideoSource")) {
                    arrayList2.add(obj3);
                }
            }
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                obj2 = it.next();
                if (it.hasNext()) {
                    TimeRange range2 = ((Timeline) obj2).getRange();
                    if (range2 != null) {
                        j16 = range2.duration + range2.startTime;
                    } else {
                        j16 = 0;
                    }
                    do {
                        Object next = it.next();
                        TimeRange range3 = ((Timeline) next).getRange();
                        if (range3 != null) {
                            j17 = range3.duration + range3.startTime;
                        } else {
                            j17 = 0;
                        }
                        if (j16 < j17) {
                            obj2 = next;
                            j16 = j17;
                        }
                    } while (it.hasNext());
                }
            }
            Timeline timeline = (Timeline) obj2;
            if (timeline != null && (range = timeline.getRange()) != null) {
                j3 = range.startTime + range.duration;
            } else {
                j3 = 0;
            }
        }
        if (this.videoSourceDurationLiveData.getValue() == null && this.initDuration == 0) {
            this.initDuration = j3;
        }
        this.videoSourceDurationLiveData.postValue(Long.valueOf(j3));
    }

    private final void O1(Function1<? super LAKRenderModel, Unit> action) {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        drVar.F(new c(action, this));
    }

    private final ClipModel P1(MediaClip mediaClip, TimeRange r29, String selectedId) {
        int i3;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        DrawData Q1 = Q1(Intrinsics.areEqual(resourceModel.id, selectedId), mediaClip);
        String str = resourceModel.id;
        String str2 = resourceModel.path;
        MediaType mediaType = resourceModel.type;
        if (mediaType != null) {
            i3 = mediaType.ordinal();
        } else {
            i3 = 0;
        }
        return new ClipModel(str, i3, str2, new TimeData(r29.startTime, r29.duration, resourceModel.scaleDuration, resourceModel.selectDuration, resourceModel.selectStart, resourceModel.sourceDuration, resourceModel.sourceStart), Q1);
    }

    private final DrawData Q1(boolean isSelected, MediaClip mediaClip) {
        ArrayList arrayList = new ArrayList();
        R1(isSelected, mediaClip, arrayList);
        S1(isSelected, mediaClip, arrayList);
        if (isSelected) {
            return new DrawData(1, true, arrayList);
        }
        return new DrawData(-1, false, arrayList);
    }

    private final void R1(boolean isSelected, MediaClip mediaClip, List<TagData> tagList) {
        String format;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        boolean b16 = a.b(mediaClip.resource);
        if (isSelected && !b16) {
            long j3 = resourceModel.selectDuration;
            long j16 = resourceModel.scaleDuration;
            if (j3 != j16 && j16 != 0) {
                float f16 = ((float) j3) / ((float) j16);
                if ((f16 > 0.74f && f16 < 0.76f) || (f16 < 1.26f && f16 > 1.24f)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    format = String.format("%.2fx", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    format = String.format("%.1fx", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
                String str = format;
                if (!Intrinsics.areEqual("1.0x", str)) {
                    com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
                    tagList.add(new TagData(str, 0, eVar.a(2.0f), R.drawable.f162068ns4, new Rect(0, 0, eVar.a(9.0f), eVar.a(9.0f)), 0, null, false, 0, 0, 0, 2018, null));
                }
            }
        }
    }

    private final void S1(boolean isSelected, MediaClip mediaClip, List<TagData> tagList) {
        ResourceModel resourceModel;
        boolean z16;
        int i3;
        if (isSelected && (resourceModel = mediaClip.resource) != null && resourceModel.type == MediaType.VIDEO) {
            if (resourceModel.volume == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = R.drawable.oqo;
            } else {
                i3 = R.drawable.f162062ns1;
            }
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            tagList.add(new TagData("", R.drawable.f162676m35, 0, i3, new Rect(0, 0, eVar.a(9.0f), eVar.a(9.0f)), 0, null, true, ViewExKt.d(16), ViewExKt.d(16), ViewExKt.d(3), 100, null));
        }
    }

    public static /* synthetic */ void S2(TimelineViewModelV2 timelineViewModelV2, BasePartFragment basePartFragment, FrameLayout frameLayout, dr.WinkTavCutParams winkTavCutParams, IPlayer.PlayerListener playerListener, ISessionListener iSessionListener, boolean z16, boolean z17, boolean z18, long j3, HashMap hashMap, int i3, Object obj) {
        boolean z19;
        boolean z26;
        boolean z27;
        long j16;
        HashMap hashMap2;
        if ((i3 & 32) != 0) {
            z19 = false;
        } else {
            z19 = z16;
        }
        if ((i3 & 64) != 0) {
            z26 = false;
        } else {
            z26 = z17;
        }
        if ((i3 & 128) != 0) {
            z27 = false;
        } else {
            z27 = z18;
        }
        if ((i3 & 256) != 0) {
            j16 = 0;
        } else {
            j16 = j3;
        }
        if ((i3 & 512) != 0) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = hashMap;
        }
        timelineViewModelV2.Q2(basePartFragment, frameLayout, winkTavCutParams, playerListener, iSessionListener, z19, z26, z27, j16, hashMap2);
    }

    public static /* synthetic */ long W1(TimelineViewModelV2 timelineViewModelV2, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        return timelineViewModelV2.U1(i3, z16);
    }

    public final void e3(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        h73.b bVar = h73.b.f404555a;
        Object obj = this.winkTavCutDelegate;
        WinkVideoTavCut winkVideoTavCut = null;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            obj = null;
        }
        if (obj instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) obj;
        }
        HashMap<String, String> a16 = bVar.a(winkVideoTavCut);
        a16.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CLIPPING_FLUENCY_PERFORMANCE);
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FRAME_TIME_COST, String.valueOf(frameTimeCostInMs));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RENDER_NODE_COST, String.valueOf(renderNodeCostInMs));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SEEK_STATUS, String.valueOf(this.isTimelineInUserScroll));
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkClippingSeekFluency(a16);
    }

    public static /* synthetic */ void g3(TimelineViewModelV2 timelineViewModelV2, long j3, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        timelineViewModelV2.f3(j3, z16, z17);
    }

    private final void n3(MediaModel mediaModel) {
        int size = this.mCurrentMediaModel.videos.size();
        int size2 = mediaModel.videos.size();
        this.mCurrentMediaModel = mediaModel;
        if (size != size2) {
            this._mediaClipNumChangedLiveData.postValue(new NumChangedData(mediaModel.videos, size, size2));
        }
    }

    private final long o2(int targetIndex, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n event) {
        long j3;
        if (targetIndex != -1) {
            j3 = U1(targetIndex, event.getIsLeft());
        } else {
            j3 = 0;
        }
        if (!event.getIsLeft()) {
            j3 -= 33333;
        }
        QLog.i("QQWinkEditViewModel", 4, "[handleSliderDragEvent] handleVideoTrackCutEvent new start play time = " + j3);
        return j3;
    }

    public static /* synthetic */ void u3(TimelineViewModelV2 timelineViewModelV2, MediaModel mediaModel, boolean z16, long j3, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        timelineViewModelV2.s3(mediaModel, z18, j16, z17);
    }

    public static /* synthetic */ void v3(TimelineViewModelV2 timelineViewModelV2, List list, boolean z16, long j3, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        timelineViewModelV2.t3(list, z18, j16, z17);
    }

    @NotNull
    public final MutableLiveData<Long> A2() {
        return this.videoSourceDurationLiveData;
    }

    @NotNull
    public final MutableLiveData<VideoTrackData> B2() {
        return this.videoTracksLiveData;
    }

    @NotNull
    public final dr C2() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            return null;
        }
        return drVar;
    }

    public final void C3(@NotNull UpdateOpeningEndingData updateInfo) {
        final long j3;
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        List<MediaClip> b16 = WinkEditorOpeningEndingViewModel.INSTANCE.b(u2(), updateInfo);
        this.hasChanged = true;
        y3(b16);
        if (!updateInfo.getIsOpeningClip() && updateInfo.getMediaClip() != null) {
            j3 = l63.c.c(l63.c.f413893a, b16, b16.size() - 1, false, 4, null);
        } else {
            j3 = 0;
        }
        O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$updateOpeningEndingClips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                invoke2(lAKRenderModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LAKRenderModel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TimelineViewModelV2.g3(TimelineViewModelV2.this, j3, false, false, 6, null);
            }
        });
    }

    public final void D2(@NotNull String id5, int i3, boolean z16) {
        final List<MediaClip> mutableList;
        MediaModel copy;
        String str;
        Intrinsics.checkNotNullParameter(id5, "id");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
        Iterator<MediaClip> it = mutableList.iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                ResourceModel resourceModel = it.next().resource;
                if (resourceModel != null) {
                    str = resourceModel.id;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, id5)) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        Function1<Integer, Boolean> function1 = new Function1<Integer, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleChangeClipsOrder$checkRange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Boolean invoke(int i17) {
                return Boolean.valueOf(i17 >= 0 && i17 < mutableList.size());
            }
        };
        if (function1.invoke(Integer.valueOf(i16)).booleanValue() && function1.invoke(Integer.valueOf(i3)).booleanValue()) {
            mutableList.add(i3, mutableList.remove(i16));
            copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : mutableList, (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
            n3(copy);
            if (z16) {
                final long U1 = U1(i3, true);
                O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleChangeClipsOrder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                        invoke2(lAKRenderModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LAKRenderModel it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        TimelineViewModelV2.g3(TimelineViewModelV2.this, U1, false, false, 6, null);
                        TimelineViewModelV2.this.c3();
                    }
                });
                b3();
            }
            u3(this, this.mCurrentMediaModel, false, 0L, false, 14, null);
            this.hasChanged = true;
            this._medialCLipOrderChangedLiveData.postValue(mutableList);
        }
    }

    public final void D3(@NotNull List<Timeline> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.timelineList.clear();
        this.timelineList.addAll(list);
        M3(this.mCurrentMediaModel.videos, list);
        K3(this.mCurrentMediaModel.videos, this.selectedTimelineLiveData.getValue(), list);
        I3();
    }

    public final boolean E2(float speed) {
        MediaModel copy;
        String str;
        ResourceModel resourceModel;
        for (MediaClip mediaClip : this.mCurrentMediaModel.videos) {
            ResourceModel resourceModel2 = mediaClip.resource;
            String str2 = null;
            if (resourceModel2 != null) {
                str = resourceModel2.id;
            } else {
                str = null;
            }
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str2 = value.getId();
            }
            if (Intrinsics.areEqual(str, str2) && (resourceModel = mediaClip.resource) != null && ((float) resourceModel.selectDuration) / speed < 1000000) {
                return false;
            }
        }
        final WinkClipOpCalcResult i3 = l63.c.f413893a.i(this.mCurrentMediaModel.videos, this.selectedTimelineLiveData.getValue(), speed);
        copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : i3.a(), (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
        O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleChangeVideoRate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                invoke2(lAKRenderModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LAKRenderModel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TimelineViewModelV2.g3(TimelineViewModelV2.this, i3.getTargetTime(), false, false, 6, null);
                TimelineViewModelV2.this.c3();
            }
        });
        b3();
        u3(this, this.mCurrentMediaModel, false, 0L, false, 14, null);
        this.hasChanged = true;
        w53.b.f("QQWinkEditViewModel", "handleChangeVideoRate: mCurrentMediaModel = " + this.mCurrentMediaModel);
        return true;
    }

    public final void E3(@NotNull List<Timeline> list, @NotNull List<? extends MediaClip> videos) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(videos, "videos");
        this.timelineList.clear();
        this.timelineList.addAll(list);
        M3(videos, list);
        K3(videos, this.selectedTimelineLiveData.getValue(), list);
        J3(videos);
    }

    public final void F2(@Nullable List<? extends LocalMediaInfo> localMedias, boolean triggerSeek, float r36) {
        MediaModel copy;
        if (localMedias != null) {
            l63.c cVar = l63.c.f413893a;
            List<MediaClip> list = this.mCurrentMediaModel.videos;
            Long value = this.currentPlayerTimeLiveData.getValue();
            if (value == null) {
                value = 0L;
            }
            Intrinsics.checkNotNullExpressionValue(value, "currentPlayerTimeLiveData.value ?: 0L");
            final WinkClipOpCalcResult a16 = cVar.a(list, localMedias, r36, value.longValue());
            copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : a16.a(), (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
            n3(copy);
            if (triggerSeek) {
                O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleClipAdd$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                        invoke2(lAKRenderModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LAKRenderModel it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TimelineViewModelV2.g3(TimelineViewModelV2.this, a16.getTargetTime(), false, false, 6, null);
                        TimelineViewModelV2.this.c3();
                    }
                });
                b3();
            }
            u3(this, this.mCurrentMediaModel, false, 0L, false, 14, null);
            this.hasChanged = true;
        }
    }

    public final void F3() {
        int e26 = e2(this.playerTime);
        if (e26 < this.mCurrentMediaModel.videos.size() && e26 >= 0) {
            ResourceModel resourceModel = this.mCurrentMediaModel.videos.get(e26).resource;
            if (resourceModel != null) {
                SelectItem<?> selectItem = new SelectItem<>(resourceModel.id, 1, new TimelineTimeRange(resourceModel.selectStart, resourceModel.selectDuration), 1);
                this.selectedTimelineLiveData.setValue(selectItem);
                K3(this.mCurrentMediaModel.videos, selectItem, this.timelineList);
            }
            g3(this, this.playerTime, false, false, 6, null);
            return;
        }
        ms.a.c("QQWinkEditViewModel", "updateSelectItem: index:" + e26 + ", listSize:" + this.mCurrentMediaModel.videos.size());
    }

    public final void G2(boolean z16) {
        MediaModel copy;
        SelectItem<?> value = this.selectedTimelineLiveData.getValue();
        if (value != null) {
            final WinkClipOpCalcResult g16 = l63.c.f413893a.g(this.mCurrentMediaModel.videos, value);
            copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : g16.a(), (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
            n3(copy);
            b3();
            if (z16) {
                O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleDeleteVideoClip$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                        invoke2(lAKRenderModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LAKRenderModel it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TimelineViewModelV2.g3(TimelineViewModelV2.this, g16.getTargetTime(), false, false, 6, null);
                        if (Math.abs(g16.getTargetTime() - TimelineViewModelV2.this.z2()) > 33333) {
                            TimelineViewModelV2.this.c3();
                        }
                    }
                });
            }
            u3(this, this.mCurrentMediaModel, false, g16.getTargetTime(), false, 8, null);
            this.hasChanged = true;
        }
    }

    public final void G3(@NotNull List<? extends WinkStickerModel> stickerModels) {
        Intrinsics.checkNotNullParameter(stickerModels, "stickerModels");
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        ((WinkVideoTavCut) drVar).W(stickerModels);
    }

    public final void H2(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c event) {
        String str;
        Long l3;
        List listOf;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(event, "event");
        dr drVar = this.winkTavCutDelegate;
        ResourceModel resourceModel = null;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        drVar.setAutoPlay(false);
        MediaClip y26 = y2();
        if (y26 == null) {
            return;
        }
        ResourceModel resourceModel2 = y26.resource;
        if (resourceModel2 != null) {
            str = resourceModel2.id;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, event.getData().getUuid())) {
            return;
        }
        TimeData timeData = event.getData().getTimeData();
        final long coerceAtLeast = event.getIsLeft() ? RangesKt___RangesKt.coerceAtLeast(timeData.getSelectStartTimeUs(), 0L) : RangesKt___RangesKt.coerceAtMost(timeData.getSelectStartTimeUs() + timeData.f(), timeData.getSourceDurationUs());
        if (!this.isDraggingSlider && event.getState() == 1) {
            ResourceModel resourceModel3 = y26.resource;
            String str2 = resourceModel3.id;
            if (resourceModel3 != null) {
                l3 = Long.valueOf(resourceModel3.sourceDuration);
            } else {
                l3 = null;
            }
            QLog.i("QQWinkEditViewModel", 4, "[handleSliderDragEvent] start drag = " + str2 + ", sourceDuration = " + l3);
            b3();
            MediaModel mediaModel = this.mCurrentMediaModel;
            ResourceModel resourceModel4 = y26.resource;
            if (resourceModel4 != null) {
                long j3 = resourceModel4.sourceDuration;
                resourceModel = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : Long.valueOf(j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : 0L, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : Long.valueOf(j3), (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(MediaClip.copy$default(y26, resourceModel, null, null, null, null, null, null, 126, null));
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : listOf, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            s3(copy, false, coerceAtLeast, true);
            this.isDraggingSlider = true;
            this.isDraggingSliderForRenderListener = true;
            O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleSliderDragEvent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                    invoke2(lAKRenderModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LAKRenderModel it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!TimelineViewModelV2.this.getIsDraggingSlider()) {
                        TimelineViewModelV2.g3(TimelineViewModelV2.this, coerceAtLeast, false, false, 2, null);
                    }
                    TimelineViewModelV2.this.q3(true);
                }
            });
            return;
        }
        if (event.getState() == 1) {
            b3();
            if (this.readyForSeekDraggingClip) {
                g3(this, coerceAtLeast, false, false, 2, null);
                return;
            }
            return;
        }
        QLog.i("QQWinkEditViewModel", 4, "[handleSliderDragEvent] move end");
        this.isDraggingSliderForRenderListener = false;
        this.readyForSeekDraggingClip = false;
    }

    public final void H3(@NotNull x.UpdateTemplateAction action, boolean isClearSticker) {
        Intrinsics.checkNotNullParameter(action, "action");
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        dr.b.o((WinkVideoTavCut) drVar, action, isClearSticker, false, null, 12, null);
    }

    public final void I2(@NotNull List<? extends MediaClip> newClips, boolean needSeekFront) {
        MediaModel copy;
        AudioModel copy2;
        long j3;
        Intrinsics.checkNotNullParameter(newClips, "newClips");
        Map<String, AudioModel> map = this.mCurrentMediaModel.audios;
        Iterator<T> it = newClips.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        HashMap hashMap = new HashMap();
        Iterator<T> it5 = map.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            Object key = entry.getKey();
            copy2 = r9.copy((r37 & 1) != 0 ? r9.id : null, (r37 & 2) != 0 ? r9.path : null, (r37 & 4) != 0 ? Long.valueOf(r9.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(r9.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(r9.startTimeInTimeline) : null, (r37 & 32) != 0 ? Float.valueOf(r9.volume) : null, (r37 & 64) != 0 ? Float.valueOf(r9.speed) : null, (r37 & 128) != 0 ? r9.volumeEffects : null, (r37 & 256) != 0 ? r9.name : null, (r37 & 512) != 0 ? r9.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(r9.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(r9.selectDuration) : Long.valueOf(j16), (r37 & 4096) != 0 ? Long.valueOf(r9.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(r9.fadeOutDuration) : null, (r37 & 16384) != 0 ? r9.lyricInfo : null, (r37 & 32768) != 0 ? r9.type : null, (r37 & 65536) != 0 ? r9.waveSampleData : null, (r37 & 131072) != 0 ? r9.event : null, (r37 & 262144) != 0 ? ((AudioModel) entry.getValue()).unknownFields() : null);
            hashMap.put(key, copy2);
        }
        copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : newClips, (r39 & 128) != 0 ? r9.audios : hashMap, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
        u3(this, this.mCurrentMediaModel, false, 0L, false, 14, null);
        if (needSeekFront) {
            b3();
            g3(this, 0L, false, false, 6, null);
            c3();
        }
    }

    public final void J2() {
        K3(this.mCurrentMediaModel.videos, null, this.timelineList);
        this.selectedTimelineLiveData.postValue(null);
    }

    public final void K2(@NotNull List<Long> newStartTimes) {
        int collectionSizeOrDefault;
        MediaModel copy;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(newStartTimes, "newStartTimes");
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        if (newStartTimes.size() < list.size()) {
            return;
        }
        List<MediaClip> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) obj;
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : newStartTimes.get(i3), (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
            i3 = i16;
        }
        copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : arrayList, (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
        u3(this, this.mCurrentMediaModel, false, 0L, false, 14, null);
        this.hasChanged = true;
    }

    public final void L2(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d event, boolean isHidden) {
        Intrinsics.checkNotNullParameter(event, "event");
        w53.b.f("QQWinkEditViewModel", "handleUserScrollEnd, event.cancel = " + event.getCancel());
        this.isTimelineInUserScroll = false;
        dr drVar = this.winkTavCutDelegate;
        if (drVar != null) {
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            drVar.stop(this.curSeekTimeUs);
        }
    }

    public final void L3(@NotNull Map<Integer, Float> clipVolumes, boolean changedManually) {
        Intrinsics.checkNotNullParameter(clipVolumes, "clipVolumes");
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        drVar.v(clipVolumes);
        if (changedManually) {
            this.hasChanged = changedManually;
        }
    }

    public final void M2(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.isTimelineInUserScroll = true;
        b3();
    }

    public final void N1(long playerTime) {
        String str;
        int e26 = e2(playerTime);
        if (e26 < this.mCurrentMediaModel.videos.size() && e26 >= 0) {
            ResourceModel resourceModel = this.mCurrentMediaModel.videos.get(e26).resource;
            if (resourceModel != null) {
                SelectItem<?> value = this.selectedTimelineLiveData.getValue();
                if (value != null) {
                    str = value.getId();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(str, resourceModel.id)) {
                    SelectItem<?> selectItem = new SelectItem<>(resourceModel.id, 1, new TimelineTimeRange(resourceModel.selectStart, resourceModel.selectDuration), 1);
                    this.selectedTimelineLiveData.setValue(selectItem);
                    K3(this.mCurrentMediaModel.videos, selectItem, this.timelineList);
                    return;
                }
                return;
            }
            return;
        }
        ms.a.c("QQWinkEditViewModel", "checkSelectClip: index:" + e26 + ", listSize:" + this.mCurrentMediaModel.videos.size());
    }

    public final void N2() {
        MediaModel copy;
        SelectItem<?> value = this.selectedTimelineLiveData.getValue();
        if (value != null) {
            l63.c cVar = l63.c.f413893a;
            List<MediaClip> list = this.mCurrentMediaModel.videos;
            Long value2 = this.currentPlayerTimeLiveData.getValue();
            if (value2 == null) {
                value2 = 0L;
            }
            Intrinsics.checkNotNullExpressionValue(value2, "currentPlayerTimeLiveData.value ?: 0L");
            final WinkClipOpCalcResult h16 = cVar.h(list, value, value2.longValue());
            copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : h16.a(), (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
            n3(copy);
            O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleVideoSegCut$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                    invoke2(lAKRenderModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LAKRenderModel it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    TimelineViewModelV2.this.b3();
                    TimelineViewModelV2.g3(TimelineViewModelV2.this, h16.getTargetTime(), false, false, 6, null);
                }
            });
            u3(this, this.mCurrentMediaModel, false, h16.getTargetTime(), false, 8, null);
            this.hasChanged = true;
        }
    }

    public final void O2(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.m event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b3();
        if (event.getSelectedStatus() == 1) {
            K3(this.mCurrentMediaModel.videos, null, this.timelineList);
            this.selectedTimelineLiveData.postValue(null);
            return;
        }
        TimelineTimeRange timelineTimeRange = new TimelineTimeRange(0L, 0L);
        if (event.getData() != null) {
            timelineTimeRange = new TimelineTimeRange(event.getData().getTimeData().getTimelineStartTimeUs(), event.getData().getTimeData().getTimelineDurationUs());
        }
        SelectItem<?> selectItem = new SelectItem<>(event.getId(), 1, timelineTimeRange, 1);
        K3(this.mCurrentMediaModel.videos, selectItem, this.timelineList);
        this.selectedTimelineLiveData.postValue(selectItem);
        if (b2() >= timelineTimeRange.getStartTime() + timelineTimeRange.getDuration()) {
            g3(this, (timelineTimeRange.getStartTime() + timelineTimeRange.getDuration()) - 33333, false, false, 6, null);
        } else if (b2() <= timelineTimeRange.getStartTime()) {
            g3(this, timelineTimeRange.getStartTime() + 33333, false, false, 6, null);
        }
    }

    public final void P2(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n event, boolean smartClipEnable, @NotNull View view) {
        List mutableList;
        Object obj;
        int indexOf;
        ResourceModel resourceModel;
        long f16;
        long coerceAtLeast;
        double selectStartTimeUs;
        ResourceModel copy;
        MediaModel copy2;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(view, "view");
        ClipModel data = event.getData();
        if (data != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
            Iterator it = mutableList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ResourceModel resourceModel2 = ((MediaClip) next).resource;
                if (resourceModel2 != null) {
                    obj = resourceModel2.id;
                }
                if (Intrinsics.areEqual(obj, data.getUuid())) {
                    obj = next;
                    break;
                }
            }
            MediaClip mediaClip = (MediaClip) obj;
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends MediaClip>) ((List<? extends Object>) mutableList), mediaClip);
            if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                TimeData timeData = data.getTimeData();
                if (smartClipEnable) {
                    f16 = timeData.g();
                } else {
                    f16 = timeData.f();
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f16, 1000000L);
                double g16 = coerceAtLeast * ((data.getTimeData().g() * 1.0d) / f16);
                if (data.getType() == 1) {
                    selectStartTimeUs = 0.0d;
                } else {
                    selectStartTimeUs = data.getTimeData().getSelectStartTimeUs() + (data.getTimeData().g() - g16);
                }
                copy = resourceModel.copy((r35 & 1) != 0 ? resourceModel.id : null, (r35 & 2) != 0 ? resourceModel.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : Long.valueOf(coerceAtLeast), (r35 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : Long.valueOf((long) selectStartTimeUs), (r35 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : Long.valueOf((long) g16), (r35 & 128) != 0 ? resourceModel.type : null, (r35 & 256) != 0 ? resourceModel.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel.volume) : null, (r35 & 1024) != 0 ? resourceModel.extras : null, (r35 & 2048) != 0 ? resourceModel.picClipRect : null, (r35 & 4096) != 0 ? resourceModel.reversePath : null, (r35 & 8192) != 0 ? resourceModel.normalPath : null, (r35 & 16384) != 0 ? resourceModel.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel.unknownFields() : null);
                mutableList.set(indexOf, MediaClip.copy$default(mediaClip, copy, null, null, null, null, null, null, 126, null));
                copy2 = r7.copy((r39 & 1) != 0 ? r7.id : null, (r39 & 2) != 0 ? r7.name : null, (r39 & 4) != 0 ? r7.version : null, (r39 & 8) != 0 ? r7.createTime : null, (r39 & 16) != 0 ? r7.updateTime : null, (r39 & 32) != 0 ? r7.duration : null, (r39 & 64) != 0 ? r7.videos : mutableList, (r39 & 128) != 0 ? r7.audios : null, (r39 & 256) != 0 ? r7.stickers : null, (r39 & 512) != 0 ? r7.backgroundModel : null, (r39 & 1024) != 0 ? r7.filterModels : null, (r39 & 2048) != 0 ? r7.specialEffects : null, (r39 & 4096) != 0 ? r7.transitions : null, (r39 & 8192) != 0 ? r7.templateModel : null, (r39 & 16384) != 0 ? r7.coverInfo : null, (r39 & 32768) != 0 ? r7.exportSetting : null, (r39 & 65536) != 0 ? r7.openHDR : null, (r39 & 131072) != 0 ? r7.hdrModels : null, (r39 & 262144) != 0 ? r7.smoothModels : null, (r39 & 524288) != 0 ? r7.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
                n3(copy2);
                final long o26 = o2(indexOf, event);
                this.curTargetTime = o26;
                O1(new Function1<LAKRenderModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2$handleVideoTrackCutEvent$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LAKRenderModel lAKRenderModel) {
                        invoke2(lAKRenderModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LAKRenderModel lAKRenderModel) {
                        Intrinsics.checkNotNullParameter(lAKRenderModel, "<anonymous parameter 0>");
                        TimelineViewModelV2.this.b3();
                        TimelineViewModelV2.g3(TimelineViewModelV2.this, o26, false, false, 6, null);
                        TimelineViewModelV2.this.k3(false);
                    }
                });
                b3();
                s3(this.mCurrentMediaModel, false, this.curTargetTime, true);
                this.hasChanged = true;
            }
        }
    }

    public final void Q2(@NotNull BasePartFragment host, @Nullable FrameLayout playerView, @NotNull dr.WinkTavCutParams params, @NotNull IPlayer.PlayerListener playerListener, @NotNull ISessionListener renderListener, boolean loopPlay, boolean isSinglePlayer, boolean notChangeSize, long initTime, @NotNull HashMap<String, Object> r252) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        Intrinsics.checkNotNullParameter(renderListener, "renderListener");
        Intrinsics.checkNotNullParameter(r252, "extraMap");
        if (this.winkTavCutDelegate != null) {
            return;
        }
        WinkVideoTavCut winkVideoTavCut = new WinkVideoTavCut(null, 1, 0 == true ? 1 : 0);
        winkVideoTavCut.N2(notChangeSize);
        winkVideoTavCut.V1(playerView, playerView);
        WinkVideoTavCut.P1(winkVideoTavCut, host, params, isSinglePlayer, initTime, r252, null, 32, null);
        n3(winkVideoTavCut.V());
        winkVideoTavCut.addPlayerListener(playerListener);
        winkVideoTavCut.F(renderListener);
        winkVideoTavCut.setLoopPlay(loopPlay);
        winkVideoTavCut.Q2(this.renderTimeListener);
        this.winkTavCutDelegate = winkVideoTavCut;
    }

    public final void R2(@NotNull dr winkTavCut, @NotNull IPlayer.PlayerListener playerListener, @NotNull ISessionListener renderListener) {
        Intrinsics.checkNotNullParameter(winkTavCut, "winkTavCut");
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        Intrinsics.checkNotNullParameter(renderListener, "renderListener");
        winkTavCut.addPlayerListener(playerListener);
        winkTavCut.F(renderListener);
        n3(winkTavCut.V());
        this.winkTavCutDelegate = winkTavCut;
    }

    public final long T1() {
        long j3;
        long j16;
        Object obj;
        ResourceModel resourceModel;
        Iterator<T> it = this.mCurrentMediaModel.videos.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                ResourceModel resourceModel2 = ((MediaClip) next).resource;
                if (resourceModel2 != null) {
                    j3 = resourceModel2.selectDuration;
                } else {
                    j3 = 0;
                }
                do {
                    Object next2 = it.next();
                    ResourceModel resourceModel3 = ((MediaClip) next2).resource;
                    if (resourceModel3 != null) {
                        j16 = resourceModel3.selectDuration;
                    } else {
                        j16 = 0;
                    }
                    if (j3 > j16) {
                        next = next2;
                        j3 = j16;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        MediaClip mediaClip = (MediaClip) obj;
        if (mediaClip == null || (resourceModel = mediaClip.resource) == null) {
            return 0L;
        }
        return resourceModel.selectDuration;
    }

    public final int T2() {
        List mutableList;
        Object obj;
        ResourceModel resourceModel;
        SelectItem<?> value = this.selectedTimelineLiveData.getValue();
        if (value != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
            if (mutableList.size() >= 35) {
                return 2;
            }
            Iterator it = mutableList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ResourceModel resourceModel2 = ((MediaClip) next).resource;
                if (resourceModel2 != null) {
                    obj = resourceModel2.id;
                }
                if (Intrinsics.areEqual(obj, value.getId())) {
                    obj = next;
                    break;
                }
            }
            MediaClip mediaClip = (MediaClip) obj;
            if (mediaClip == null || (resourceModel = mediaClip.resource) == null) {
                return 1;
            }
            long g26 = g2();
            long j3 = resourceModel.scaleDuration - g26;
            ms.a.a("cliptest", "segHeadDuration: " + g26 + ",  segTailDuration: " + j3);
            if (g26 <= 1000000 || j3 <= 1000000) {
                return 1;
            }
            return 0;
        }
        return 1;
    }

    public final long U1(int index, boolean isStart) {
        int coerceIn;
        Iterable<IndexedValue> withIndex;
        long j3;
        coerceIn = RangesKt___RangesKt.coerceIn(index, 0, this.mCurrentMediaModel.videos.size());
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.mCurrentMediaModel.videos);
        long j16 = 0;
        for (IndexedValue indexedValue : withIndex) {
            if (!isStart || indexedValue.getIndex() < coerceIn) {
                if (isStart || indexedValue.getIndex() <= coerceIn) {
                    ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
                    if (resourceModel != null) {
                        j3 = resourceModel.scaleDuration;
                    } else {
                        j3 = 0;
                    }
                    j16 += j3;
                }
            }
        }
        return j16;
    }

    /* renamed from: U2, reason: from getter */
    public final boolean getIsDraggingSlider() {
        return this.isDraggingSlider;
    }

    /* renamed from: V2, reason: from getter */
    public final boolean getIsDraggingSliderForRenderListener() {
        return this.isDraggingSliderForRenderListener;
    }

    public final boolean W2() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar != null) {
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            if (drVar.isPlaying()) {
                return true;
            }
        }
        return false;
    }

    public final int X1() {
        return this.mCurrentMediaModel.videos.size();
    }

    /* renamed from: Y2, reason: from getter */
    public final boolean getIsPlayingForTimeline() {
        return this.isPlayingForTimeline;
    }

    /* renamed from: Z1, reason: from getter */
    public final int getCounter() {
        return this.counter;
    }

    @Nullable
    public final Bitmap a2(long j3, @NotNull Size size, @NotNull String templateDir, @Nullable List<? extends BaseEffectNode> list) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(templateDir, "templateDir");
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut == null) {
            return null;
        }
        return winkVideoTavCut.g1(j3, size, templateDir, list);
    }

    public final void a3(long j3, boolean z16) {
        if (z16 && !W2()) {
            g3(this, j3, this.isTimelineInUserScroll, false, 4, null);
            this.curSeekTimeUs = j3;
        }
    }

    public final long b2() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        return drVar.getCurrentPlayUs();
    }

    public final void b3() {
        this.isPlayingForTimeline = false;
        if (this.winkTavCutDelegate != null && W2()) {
            dr drVar = this.winkTavCutDelegate;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            drVar.pause();
        }
    }

    /* renamed from: c2, reason: from getter */
    public final long getCurTargetTime() {
        return this.curTargetTime;
    }

    public final void c3() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar != null) {
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            drVar.play();
        }
    }

    public final int d2() {
        String str;
        Iterator<MediaClip> it = this.mCurrentMediaModel.videos.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = it.next().resource;
            String str2 = null;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str2 = value.getId();
            }
            if (!Intrinsics.areEqual(str, str2)) {
                i3++;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final void d3() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            return;
        }
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        drVar.release();
    }

    public final int e2(long playerTime) {
        Iterable<IndexedValue> withIndex;
        int lastIndex;
        long j3;
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.mCurrentMediaModel.videos);
        long j16 = 0;
        for (IndexedValue indexedValue : withIndex) {
            ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
            if (j16 > playerTime) {
                return indexedValue.getIndex();
            }
        }
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.mCurrentMediaModel.videos);
        return lastIndex;
    }

    @Nullable
    public final Float f2() {
        int collectionSizeOrDefault;
        String str;
        String str2;
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str2 = value.getId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                ResourceModel resourceModel2 = mediaClip.resource;
                boolean z16 = false;
                if (resourceModel2 != null && a.b(resourceModel2)) {
                    z16 = true;
                }
                if (z16) {
                    return Float.valueOf(1.0f);
                }
                ResourceModel resourceModel3 = mediaClip.resource;
                if (resourceModel3 == null) {
                    return null;
                }
                return Float.valueOf(((float) resourceModel3.selectDuration) / ((float) resourceModel3.scaleDuration));
            }
            arrayList.add(Unit.INSTANCE);
        }
        return null;
    }

    public final void f3(long targetTimeUs, boolean openInAccurateSeek, boolean needScroll) {
        Object orNull;
        MediaType mediaType;
        boolean z16;
        ResourceModel resourceModel;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mCurrentMediaModel.videos, e2(targetTimeUs));
        MediaClip mediaClip = (MediaClip) orNull;
        dr drVar = null;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            mediaType = resourceModel.type;
        } else {
            mediaType = null;
        }
        if (mediaType == MediaType.VIDEO) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b()) {
            w53.b.a("QQWinkEditViewModel", "seek to " + targetTimeUs + ", isVideo = " + z16 + ", isAccurate = " + openInAccurateSeek);
        }
        this.seekPlayerTimeLiveData.postValue(new WinkTimelineSeekPlayerTimeData(targetTimeUs, needScroll));
        if (openInAccurateSeek && z16) {
            dr drVar2 = this.winkTavCutDelegate;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            } else {
                drVar = drVar2;
            }
            drVar.seek(targetTimeUs, openInAccurateSeek);
            return;
        }
        dr drVar3 = this.winkTavCutDelegate;
        if (drVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
        } else {
            drVar = drVar3;
        }
        drVar.seek(targetTimeUs);
    }

    public final long g2() {
        long j3;
        Long value = this.currentPlayerTimeLiveData.getValue();
        if (value == null) {
            value = 0L;
        }
        long longValue = value.longValue();
        Iterator<T> it = this.mCurrentMediaModel.videos.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            long j17 = j3 + j16;
            if (j17 > longValue) {
                return longValue - j16;
            }
            j16 = j17;
        }
        return 0L;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQWinkEditViewModel";
    }

    @Nullable
    public final MediaType h2() {
        int collectionSizeOrDefault;
        String str;
        String str2;
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str2 = value.getId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 == null) {
                    return null;
                }
                return resourceModel2.type;
            }
            arrayList.add(Unit.INSTANCE);
        }
        return null;
    }

    public final void h3(int i3) {
        this.counter = i3;
    }

    @Nullable
    public final Float i2() {
        Object obj;
        ResourceModel resourceModel;
        String str;
        String str2;
        Iterator<T> it = this.mCurrentMediaModel.videos.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                ResourceModel resourceModel2 = ((MediaClip) obj).resource;
                if (resourceModel2 != null) {
                    str = resourceModel2.id;
                } else {
                    str = null;
                }
                SelectItem<?> value = this.selectedTimelineLiveData.getValue();
                if (value != null) {
                    str2 = value.getId();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(str, str2)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaClip mediaClip = (MediaClip) obj;
        if (mediaClip == null || (resourceModel = mediaClip.resource) == null) {
            return null;
        }
        return Float.valueOf(resourceModel.volume);
    }

    public final void i3(long j3) {
        this.curSeekTimeUs = j3;
    }

    public final long j2() {
        Long value = this.videoSourceDurationLiveData.getValue();
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public final void j3(long j3) {
        this.curTargetTime = j3;
    }

    @Nullable
    public final MediaClip k2() {
        int collectionSizeOrDefault;
        String str;
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                return null;
            }
            MediaClip mediaClip = (MediaClip) it.next();
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str2 = value.getId();
            }
            if (Intrinsics.areEqual(str, str2)) {
                return mediaClip;
            }
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final void k3(boolean z16) {
        this.isDraggingSlider = z16;
    }

    @NotNull
    public final MutableLiveData<IPlayer.PlayerStatus> l2() {
        return this.currentPlayerStatus;
    }

    public final void l3(boolean z16) {
        this.firstEnter = z16;
    }

    @NotNull
    public final MutableLiveData<Long> m2() {
        return this.currentPlayerTimeLiveData;
    }

    public final void m3(boolean z16) {
        this.hasChanged = z16;
    }

    /* renamed from: n2, reason: from getter */
    public final long getCurSeekTimeUs() {
        return this.curSeekTimeUs;
    }

    public final void o3(long startTimeUs, long durationUs) {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        drVar.setPlayTimeRange(startTimeUs, durationUs);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        dr drVar = this.winkTavCutDelegate;
        if (drVar != null) {
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            drVar.release();
        }
    }

    @NotNull
    public final ArrayList<MediaClip> p2() {
        ArrayList<MediaClip> arrayList = new ArrayList<>();
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        arrayList.addAll(drVar.a0());
        return arrayList;
    }

    public final void p3(boolean z16) {
        this.isPlayingForTimeline = z16;
    }

    /* renamed from: q2, reason: from getter */
    public final boolean getFirstEnter() {
        return this.firstEnter;
    }

    public final void q3(boolean z16) {
        this.readyForSeekDraggingClip = z16;
    }

    /* renamed from: r2, reason: from getter */
    public final boolean getHasChanged() {
        return this.hasChanged;
    }

    public final void r3(@Nullable Map<String, AudioModel> audios) {
        boolean z16;
        if (this.winkTavCutDelegate == null) {
            return;
        }
        if (audios != null && !audios.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            dr drVar = this.winkTavCutDelegate;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            dr.b.k(drVar, null, null, 2, null);
            return;
        }
        for (AudioModel audioModel : audios.values()) {
            dr drVar2 = this.winkTavCutDelegate;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar2 = null;
            }
            dr.b.k(drVar2, audioModel, null, 2, null);
        }
    }

    /* renamed from: s2, reason: from getter */
    public final long getInitDuration() {
        return this.initDuration;
    }

    @JvmOverloads
    public final void s3(@NotNull MediaModel mediaModel, boolean z16, long j3, boolean z17) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        t3(mediaModel.videos, z16, j3, z17);
    }

    @NotNull
    public final LiveData<NumChangedData> t2() {
        return this.mediaClipNumChangedLiveData;
    }

    @JvmOverloads
    public final void t3(@NotNull List<? extends MediaClip> mediaClips, boolean needFlushPlayer, long targetTimeUs, boolean forceFlush) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            return;
        }
        dr drVar2 = null;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.m3(mediaClips, needFlushPlayer, targetTimeUs, forceFlush);
            return;
        }
        dr drVar3 = this.winkTavCutDelegate;
        if (drVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
        } else {
            drVar2 = drVar3;
        }
        drVar2.e0(mediaClips);
    }

    @NotNull
    public final List<MediaClip> u2() {
        return this.mCurrentMediaModel.videos;
    }

    @NotNull
    public final LiveData<List<MediaClip>> v2() {
        return this.medialCLipOrderChangedLiveData;
    }

    @NotNull
    public final MutableLiveData<WinkTimelineSeekPlayerTimeData> w2() {
        return this.seekPlayerTimeLiveData;
    }

    public final void w3() {
        K3(this.mCurrentMediaModel.videos, this.selectedTimelineLiveData.getValue(), this.timelineList);
    }

    @NotNull
    public final MutableLiveData<SelectItem<?>> x2() {
        return this.selectedTimelineLiveData;
    }

    public final void x3(@NotNull List<? extends MediaClip> clips, @Nullable BackgroundModel backgroundModel, @NotNull Map<String, AudioModel> audioMap) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(audioMap, "audioMap");
        copy = r1.copy((r39 & 1) != 0 ? r1.id : null, (r39 & 2) != 0 ? r1.name : null, (r39 & 4) != 0 ? r1.version : null, (r39 & 8) != 0 ? r1.createTime : null, (r39 & 16) != 0 ? r1.updateTime : null, (r39 & 32) != 0 ? r1.duration : null, (r39 & 64) != 0 ? r1.videos : clips, (r39 & 128) != 0 ? r1.audios : audioMap, (r39 & 256) != 0 ? r1.stickers : null, (r39 & 512) != 0 ? r1.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? r1.filterModels : null, (r39 & 2048) != 0 ? r1.specialEffects : null, (r39 & 4096) != 0 ? r1.transitions : null, (r39 & 8192) != 0 ? r1.templateModel : null, (r39 & 16384) != 0 ? r1.coverInfo : null, (r39 & 32768) != 0 ? r1.exportSetting : null, (r39 & 65536) != 0 ? r1.openHDR : null, (r39 & 131072) != 0 ? r1.hdrModels : null, (r39 & 262144) != 0 ? r1.smoothModels : null, (r39 & 524288) != 0 ? r1.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
    }

    @Nullable
    public final MediaClip y2() {
        List mutableList;
        Object obj;
        String str;
        SelectItem<?> value = this.selectedTimelineLiveData.getValue();
        if (value != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
            Iterator it = mutableList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    ResourceModel resourceModel = ((MediaClip) obj).resource;
                    if (resourceModel != null) {
                        str = resourceModel.id;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, value.getId())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MediaClip mediaClip = (MediaClip) obj;
            if (mediaClip != null) {
                return MediaClip.copy$default(mediaClip, null, null, null, null, null, null, null, 127, null);
            }
        }
        return null;
    }

    public final void y3(@NotNull List<? extends MediaClip> mediaClips) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : mediaClips, (r39 & 128) != 0 ? r9.audios : null, (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
        v3(this, mediaClips, false, 0L, false, 14, null);
    }

    public final long z2() {
        dr drVar = this.winkTavCutDelegate;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
            drVar = null;
        }
        return drVar.getDurationUs();
    }

    public final void z3(@NotNull List<? extends MediaClip> mediaClips, long targetTimeUs, boolean needFlushPlayer) {
        MediaModel copy;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        copy = r7.copy((r39 & 1) != 0 ? r7.id : null, (r39 & 2) != 0 ? r7.name : null, (r39 & 4) != 0 ? r7.version : null, (r39 & 8) != 0 ? r7.createTime : null, (r39 & 16) != 0 ? r7.updateTime : null, (r39 & 32) != 0 ? r7.duration : null, (r39 & 64) != 0 ? r7.videos : mediaClips, (r39 & 128) != 0 ? r7.audios : null, (r39 & 256) != 0 ? r7.stickers : null, (r39 & 512) != 0 ? r7.backgroundModel : null, (r39 & 1024) != 0 ? r7.filterModels : null, (r39 & 2048) != 0 ? r7.specialEffects : null, (r39 & 4096) != 0 ? r7.transitions : null, (r39 & 8192) != 0 ? r7.templateModel : null, (r39 & 16384) != 0 ? r7.coverInfo : null, (r39 & 32768) != 0 ? r7.exportSetting : null, (r39 & 65536) != 0 ? r7.openHDR : null, (r39 & 131072) != 0 ? r7.hdrModels : null, (r39 & 262144) != 0 ? r7.smoothModels : null, (r39 & 524288) != 0 ? r7.openSuperHDR : null, (r39 & 1048576) != 0 ? this.mCurrentMediaModel.unknownFields() : null);
        n3(copy);
        t3(mediaClips, needFlushPlayer, targetTimeUs, true);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2$c", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ISessionListener {

        /* renamed from: a */
        final /* synthetic */ Function1<LAKRenderModel, Unit> f319097a;

        /* renamed from: b */
        final /* synthetic */ TimelineViewModelV2 f319098b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super LAKRenderModel, Unit> function1, TimelineViewModelV2 timelineViewModelV2) {
            this.f319097a = function1;
            this.f319098b = timelineViewModelV2;
        }

        public static final void b(Function1 action, LAKRenderModel newData, TimelineViewModelV2 this$0, c this$1) {
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            action.invoke(newData);
            dr drVar = this$0.winkTavCutDelegate;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTavCutDelegate");
                drVar = null;
            }
            drVar.Q(this$1);
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<LAKRenderModel, Unit> function1 = this.f319097a;
            final TimelineViewModelV2 timelineViewModelV2 = this.f319098b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.b
                @Override // java.lang.Runnable
                public final void run() {
                    TimelineViewModelV2.c.b(Function1.this, newData, timelineViewModelV2, this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2$d", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements IRenderTimeListener {
        d() {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
            TimelineViewModelV2 timelineViewModelV2 = TimelineViewModelV2.this;
            timelineViewModelV2.h3(timelineViewModelV2.getCounter() + 1);
            if (TimelineViewModelV2.this.getCounter() > 150) {
                TimelineViewModelV2.this.h3(0);
                TimelineViewModelV2.this.e3(frameTimeCostInMs, renderNodeCostInMs, currentRenderTimeInUs);
            }
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
