package com.tencent.mobileqq.wink.editor.sticker.control;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.RenderModelThumbnailProviderImpl;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.ds;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart;
import com.tencent.mobileqq.wink.editor.tts.WinkTTSWaveView;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioItem;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.widget.HorizontalListView;
import com.tenpay.sdk.util.UinConfigManager;
import g63.CommonConfig;
import g63.LayoutConfig;
import g63.ScrollConfig;
import g63.TimeBarConfig;
import g63.VideoTrackConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\n\u00f2\u0001\u00f3\u0001\u00f4\u0001\u00f5\u0001\u00f6\u0001B\u0013\u0012\b\b\u0002\u0010`\u001a\u00020\u0014\u00a2\u0006\u0006\b\u00f0\u0001\u0010\u00f1\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0015J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\n\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0003J\b\u0010.\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0003H\u0002J\u001a\u00106\u001a\u00020\u00072\u0006\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020\u0014H\u0002J\u0018\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020\u0014H\u0002J\u001e\u0010?\u001a\u00020\u00072\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0002J\u0012\u0010@\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0003H\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0003H\u0002J\b\u0010D\u001a\u00020\u0014H\u0002J\b\u0010E\u001a\u00020\u0007H\u0003J\b\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020#H\u0002J\b\u0010L\u001a\u00020\u0007H\u0002J\u0019\u0010N\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\bN\u0010OJ\u001a\u0010T\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010S\u001a\u00020RH\u0002J\u0012\u0010U\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0003H\u0002J\b\u0010X\u001a\u00020\u0007H\u0002J\u0010\u0010[\u001a\u00020Z2\u0006\u0010Y\u001a\u00020/H\u0002J\u0010\u0010\\\u001a\u00020\u00072\u0006\u00107\u001a\u00020/H\u0002J\b\u0010]\u001a\u00020\u0007H\u0002R\u0014\u0010`\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020/8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010eR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b_\u0010\u0086\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001b\u0010\u00a1\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u009a\u0001R\u001c\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u009e\u0001R\u001b\u0010\u00a5\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u009a\u0001R\u001b\u0010\u00a7\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u009a\u0001R\u001c\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u009e\u0001R\u001c\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u009e\u0001R\u001b\u0010\u00b1\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u009a\u0001R\u0018\u0010\u00b3\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b2\u0001\u0010bR\u0018\u0010\u00b5\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b4\u0001\u0010_R\u0018\u0010\u00b7\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b6\u0001\u0010_R\u0018\u0010\u00b9\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b8\u0001\u0010_R\u0018\u0010\u00bb\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ba\u0001\u0010eR\u001c\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00bc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001c\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00c0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u0018\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001R#\u0010\u00ca\u0001\u001a\f\u0012\u0005\u0012\u00030\u00c7\u0001\u0018\u00010\u00c6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001R(\u0010\u00ce\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0003\u0012\u0005\u0012\u00030\u00cb\u0001\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001R(\u0010\u00d1\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=\u0018\u00010\u00cf\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00cd\u0001R&\u0010\u00d3\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00cf\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00cd\u0001R\u0018\u0010\u00d5\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d4\u0001\u0010_R\u001c\u0010\u00d9\u0001\u001a\u0005\u0018\u00010\u00d6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u001c\u0010\u00db\u0001\u001a\u0005\u0018\u00010\u00d6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00d8\u0001R,\u0010\u00e3\u0001\u001a\u0005\u0018\u00010\u00dc\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00dd\u0001\u0010\u00de\u0001\u001a\u0006\b\u00df\u0001\u0010\u00e0\u0001\"\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u0018\u0010\u00e5\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e4\u0001\u0010_R\u0018\u0010\u00e7\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e6\u0001\u0010_R\u0018\u0010\u00eb\u0001\u001a\u00030\u00e8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001R\u0018\u0010\u00ef\u0001\u001a\u00030\u00ec\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ed\u0001\u0010\u00ee\u0001\u00a8\u0006\u00f7\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/h;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initAfterInflation", "pa", "Landroid/os/Bundle;", "args", "L9", "action", "", "handleBroadcastMessage", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "event", "Jc", "onDismiss", "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartResume", "Kb", "onPartDestroy", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "K9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "B9", "Hb", "initViewModel", "xb", "nb", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "ob", "Fb", "ic", "pb", UinConfigManager.KEY_HB, "", "endTime", "bb", "curStickerModelId", com.tencent.mobileqq.search.model.ac.f283467k0, "currentPlayingTime", "isLast", "gc", "startTime", "Rb", "Mb", "Ab", "Ya", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", com.tencent.luggage.wxa.c8.c.B, "dc", "Wb", "type", "Tb", "Sb", "Lb", "tb", "yb", "Eb", "ub", "vb", "position", "Vb", "cb", "enable", "Za", "(Ljava/lang/Boolean;)V", "Landroid/widget/TextView;", "view", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$BottomBarStatus;", "status", "Yb", "Zb", "stickerUid", "bc", "Pb", "curTime", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$a;", "ab", "ec", "Qb", "M", "Z", "isFromZShow", "N", "J", "DEFAULT_BOTTOM_BAR_BUTTON_SEC", "P", "I", "BOTTOM_BAR_BUTTON_BG_SELECT_DRAWABLE", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "BOTTOM_BAR_BUTTON_BG_DAFAULT_DRAWABLE", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "panelController", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "videoTrackController", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl;", "T", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl;", "provider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "U", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "timeBarViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView;", "V", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView;", "reorderContainerView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "W", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "timelinePanel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "X", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "videoTrack", "Lcom/tencent/widget/HorizontalListView;", "Y", "Lcom/tencent/widget/HorizontalListView;", "stickerListView", "stickerListViewV2", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$c;", "a0", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$c;", "stickerListViewAdapter", "Lcom/tencent/mobileqq/wink/editor/sticker/control/c;", "b0", "Lcom/tencent/mobileqq/wink/editor/sticker/control/c;", "cursorHandler", "Landroid/widget/ImageView;", "c0", "Landroid/widget/ImageView;", "cancelBtn", "d0", "confirmBtn", "e0", "playerStatusBtn", "f0", "Landroid/widget/TextView;", "threeSecButton", "Landroid/widget/LinearLayout;", "g0", "Landroid/widget/LinearLayout;", "threeSecLayout", "h0", "currentClipButton", "i0", "currentClipLayout", "j0", "allEndButton", "k0", "timeText", "Landroid/widget/RelativeLayout;", "l0", "Landroid/widget/RelativeLayout;", "bottomContainer", "m0", "addStickerBtn", "n0", "addStickerMask", "o0", "addStickerBtnText", "p0", "nowTimeProgress", "q0", "needReplay", "r0", "needRefreshVideoTrack", "s0", "needRefreshSourceDuration", "t0", "timelineMenuHeight", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "u0", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Lcom/tencent/mobileqq/wink/editor/template/x;", "v0", "Lcom/tencent/mobileqq/wink/editor/template/x;", "templateViewModel", "w0", "Ljava/lang/String;", "", "Lcom/tencent/videocut/model/MediaClip;", "x0", "Ljava/util/List;", "mediaClipsBackup", "Lcom/tencent/videocut/model/TransitionModel;", "y0", "Ljava/util/Map;", "transformModelsBackup", "", "z0", "stickerModelBackup", "A0", "stickerTimeType", "B0", "isFirstInto", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "C0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "showGlobalLayoutListener", "D0", "hideGlobalLayoutListener", "Lcom/tencent/mobileqq/wink/editor/tts/WinkTTSWaveView;", "E0", "Lcom/tencent/mobileqq/wink/editor/tts/WinkTTSWaveView;", "getMTTSWaveView", "()Lcom/tencent/mobileqq/wink/editor/tts/WinkTTSWaveView;", "setMTTSWaveView", "(Lcom/tencent/mobileqq/wink/editor/tts/WinkTTSWaveView;)V", "mTTSWaveView", "F0", "isShowTTSPopWindow", "G0", "showStickerMenuPart", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "H0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "I0", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "<init>", "(Z)V", "BottomBarStatus", "a", "b", "c", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorStickerTimelinePart extends WinkEditorMenuPart implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h {

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean isFirstInto;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener showGlobalLayoutListener;

    /* renamed from: D0, reason: from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener hideGlobalLayoutListener;

    /* renamed from: E0, reason: from kotlin metadata */
    @Nullable
    private WinkTTSWaveView mTTSWaveView;

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean isShowTTSPopWindow;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean showStickerMenuPart;

    /* renamed from: M, reason: from kotlin metadata */
    private final boolean isFromZShow;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TimelinePanelViewController panelController;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l videoTrackController;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a timeBarViewController;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ReorderContainerView reorderContainerView;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TimelinePanel timelinePanel;

    /* renamed from: X, reason: from kotlin metadata */
    private VideoTrackContainerView videoTrack;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private HorizontalListView stickerListView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private HorizontalListView stickerListViewV2;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c stickerListViewAdapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.sticker.control.c cursorHandler;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView cancelBtn;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView confirmBtn;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView playerStatusBtn;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView threeSecButton;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout threeSecLayout;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView currentClipButton;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout currentClipLayout;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView allEndButton;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView timeText;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout bottomContainer;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout addStickerBtn;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout addStickerMask;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView addStickerBtnText;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private long nowTimeProgress;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean needReplay;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshVideoTrack;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshSourceDuration;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int timelineMenuHeight;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelineViewModelV2 timelineViewModel;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.template.x templateViewModel;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends MediaClip> mediaClipsBackup;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, TransitionModel> transformModelsBackup;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, WinkStickerModel> stickerModelBackup;

    /* renamed from: N, reason: from kotlin metadata */
    private final long DEFAULT_BOTTOM_BAR_BUTTON_SEC = 3000000;

    /* renamed from: P, reason: from kotlin metadata */
    private final int BOTTOM_BAR_BUTTON_BG_SELECT_DRAWABLE = R.drawable.l5d;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int BOTTOM_BAR_BUTTON_BG_DAFAULT_DRAWABLE = R.drawable.l5e;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private RenderModelThumbnailProviderImpl provider = new RenderModelThumbnailProviderImpl();

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curStickerModelId = "";

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> stickerTimeType = new HashMap();

    /* renamed from: H0, reason: from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener = new e();

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener = new f();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$BottomBarStatus;", "", "(Ljava/lang/String;I)V", "ENABLE", "DEFAULT", "SELECT", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum BottomBarStatus {
        ENABLE,
        DEFAULT,
        SELECT
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "setStartTime", "(J)V", "startTime", "setEndTime", "endTime", "<init>", "(JJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ClipTime {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long startTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long endTime;

        public ClipTime(long j3, long j16) {
            this.startTime = j3;
            this.endTime = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getEndTime() {
            return this.endTime;
        }

        /* renamed from: b, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClipTime)) {
                return false;
            }
            ClipTime clipTime = (ClipTime) other;
            if (this.startTime == clipTime.startTime && this.endTime == clipTime.endTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.startTime) * 31) + androidx.fragment.app.a.a(this.endTime);
        }

        @NotNull
        public String toString() {
            return "ClipTime(startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\r\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b \u0010\u001c\"\u0004\b#\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "stickerUid", "b", "setContent", "content", "c", "e", "setThumbUrl", "thumbUrl", "", "J", "()J", "j", "(J)V", "startTime", tl.h.F, "endTime", "", "f", "Z", "()Z", "i", "(Z)V", "isSelect", "g", "isFrammeSticker", "setFrammeSticker", "setTextSticker", "isTextSticker", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "<init>", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String stickerUid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String content;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String thumbUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long endTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isSelect;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean isFrammeSticker;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean isTextSticker;

        public b(@NotNull WinkStickerModel stickerModel) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
            MetaMaterial material = stickerModel.getMaterial();
            if (material != null) {
                str = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
            } else {
                str = null;
            }
            this.content = str;
            MetaMaterial material2 = stickerModel.getMaterial();
            this.thumbUrl = material2 != null ? material2.thumbUrl : null;
            long j3 = stickerModel.startTime;
            this.startTime = j3;
            this.endTime = j3 + stickerModel.duration;
            MetaMaterial material3 = stickerModel.getMaterial();
            if (material3 != null && com.tencent.mobileqq.wink.editor.sticker.m.Q(material3)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isFrammeSticker = z16;
            MetaMaterial material4 = stickerModel.getMaterial();
            this.isTextSticker = material4 != null && com.tencent.mobileqq.wink.editor.sticker.m.X(material4);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final long getEndTime() {
            return this.endTime;
        }

        /* renamed from: c, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        @NotNull
        public final String d() {
            String str = this.stickerUid;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stickerUid");
            return null;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsSelect() {
            return this.isSelect;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsTextSticker() {
            return this.isTextSticker;
        }

        public final void h(long j3) {
            this.endTime = j3;
        }

        public final void i(boolean z16) {
            this.isSelect = z16;
        }

        public final void j(long j3) {
            this.startTime = j3;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.stickerUid = str;
        }
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101J4\u0010\f\u001a\u00020\u000b2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\tJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019J$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$c;", "Landroid/widget/BaseAdapter;", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "data", "selectStickerUid", "", "isFirstInto", "", "maxDuration", "", "i", "", "Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$b;", "c", "", "b", "position", "f", "e", "startTime", tl.h.F, "endTime", "g", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "getItem", "getItemId", "getCount", "", "Ljava/util/List;", com.tencent.luggage.wxa.c8.c.B, "I", "curIndex", "Landroidx/lifecycle/MutableLiveData;", "selectClipSticker", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "mInflater", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<b> stickers;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int curIndex;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<b> selectClipSticker;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private LayoutInflater mInflater;

        /* renamed from: m, reason: collision with root package name */
        private static final int f321641m = ViewUtils.dpToPx(6.0f);
        private static final int C = ViewUtils.dpToPx(6.0f);
        private static final int D = ViewUtils.dpToPx(16.0f);
        private static final int E = ViewUtils.dpToPx(24.0f);

        public c(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.stickers = new ArrayList();
            this.selectClipSticker = new MutableLiveData<>();
            LayoutInflater from = LayoutInflater.from(context);
            Intrinsics.checkNotNullExpressionValue(from, "from(context)");
            this.mInflater = from;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(c this$0, Ref.ObjectRef selectSticker) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(selectSticker, "$selectSticker");
            this$0.selectClipSticker.postValue(selectSticker.element);
        }

        /* renamed from: b, reason: from getter */
        public final int getCurIndex() {
            return this.curIndex;
        }

        @NotNull
        public final List<b> c() {
            return this.stickers;
        }

        @NotNull
        public final MutableLiveData<b> d() {
            return this.selectClipSticker;
        }

        @NotNull
        public final String e(int position) {
            if (position >= 0 && position < this.stickers.size()) {
                return this.stickers.get(position).d();
            }
            return "";
        }

        public final void f(int position) {
            this.curIndex = position;
            Iterator<T> it = this.stickers.iterator();
            while (it.hasNext()) {
                ((b) it.next()).i(false);
            }
            if (position >= 0 && position < this.stickers.size()) {
                this.stickers.get(position).i(true);
                this.selectClipSticker.postValue(this.stickers.get(position));
                notifyDataSetChanged();
                return;
            }
            notifyDataSetChanged();
        }

        public final void g(long endTime) {
            for (b bVar : this.stickers) {
                if (bVar.getIsSelect()) {
                    bVar.h(endTime);
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.stickers.size();
        }

        @Override // android.widget.Adapter
        @NotNull
        public Object getItem(int position) {
            return this.stickers.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        @NotNull
        public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
            d dVar;
            View view;
            b bVar = this.stickers.get(position);
            if (convertView == null) {
                dVar = new d();
                view = this.mInflater.inflate(R.layout.heh, parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "mInflater.inflate(R.layo\u2026line_item, parent, false)");
                View findViewById = view.findViewById(R.id.f88454x4);
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.wink.view.RoundCornerImageView");
                dVar.e((RoundCornerImageView) findViewById);
                View findViewById2 = view.findViewById(R.id.f88464x5);
                Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                dVar.f((TextView) findViewById2);
                View findViewById3 = view.findViewById(R.id.f88444x3);
                Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
                dVar.d((RelativeLayout) findViewById3);
                view.setTag(dVar);
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart.ViewHolder");
                dVar = (d) tag;
                view = convertView;
            }
            if (bVar.getIsSelect()) {
                RelativeLayout container = dVar.getContainer();
                if (container != null) {
                    container.setBackgroundResource(R.drawable.l5b);
                }
            } else {
                RelativeLayout container2 = dVar.getContainer();
                if (container2 != null) {
                    container2.setBackgroundResource(R.drawable.l5a);
                }
            }
            if (!TextUtils.isEmpty(bVar.getContent()) && bVar.getIsTextSticker()) {
                TextView title = dVar.getTitle();
                if (title != null) {
                    title.setText(bVar.getContent());
                }
                TextView title2 = dVar.getTitle();
                if (title2 != null) {
                    title2.setVisibility(0);
                }
            } else {
                TextView title3 = dVar.getTitle();
                if (title3 != null) {
                    title3.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(bVar.getThumbUrl()) && !bVar.getIsTextSticker()) {
                ViewUtilsKt.j(dVar.getImg(), bVar.getThumbUrl());
                RoundCornerImageView img = dVar.getImg();
                if (img != null) {
                    img.setVisibility(0);
                }
                w53.b.a("WinkEditorStickerTimeLinePart", "stickerItem.stickerModel.material.thumbUrl = " + bVar.getThumbUrl());
            } else {
                RoundCornerImageView img2 = dVar.getImg();
                if (img2 != null) {
                    img2.setVisibility(8);
                }
            }
            if (bVar.getIsSelect()) {
                RoundCornerImageView img3 = dVar.getImg();
                if (img3 != null) {
                    img3.setAlpha(1.0f);
                }
            } else {
                RoundCornerImageView img4 = dVar.getImg();
                if (img4 != null) {
                    img4.setAlpha(0.6f);
                }
            }
            ViewGroup.LayoutParams layoutParams = null;
            if (position == 0) {
                RelativeLayout container3 = dVar.getContainer();
                if (container3 != null) {
                    layoutParams = container3.getLayoutParams();
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = D;
                layoutParams2.rightMargin = C;
                RelativeLayout container4 = dVar.getContainer();
                if (container4 != null) {
                    container4.setLayoutParams(layoutParams2);
                }
                RelativeLayout container5 = dVar.getContainer();
                if (container5 != null) {
                    container5.invalidate();
                }
            } else if (position == this.stickers.size() - 1) {
                RelativeLayout container6 = dVar.getContainer();
                if (container6 != null) {
                    layoutParams = container6.getLayoutParams();
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.leftMargin = f321641m;
                layoutParams3.rightMargin = E;
                RelativeLayout container7 = dVar.getContainer();
                if (container7 != null) {
                    container7.setLayoutParams(layoutParams3);
                }
                RelativeLayout container8 = dVar.getContainer();
                if (container8 != null) {
                    container8.invalidate();
                }
            } else {
                RelativeLayout container9 = dVar.getContainer();
                if (container9 != null) {
                    layoutParams = container9.getLayoutParams();
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams4.leftMargin = f321641m;
                layoutParams4.rightMargin = C;
                RelativeLayout container10 = dVar.getContainer();
                if (container10 != null) {
                    container10.setLayoutParams(layoutParams4);
                }
                RelativeLayout container11 = dVar.getContainer();
                if (container11 != null) {
                    container11.invalidate();
                }
            }
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view;
        }

        public final void h(long startTime) {
            for (b bVar : this.stickers) {
                if (bVar.getIsSelect()) {
                    bVar.j(startTime);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v19, types: [T, com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart$b, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v15, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v21, types: [T, java.lang.Object] */
        public final void i(@Nullable Map<String, ? extends WinkStickerModel> data, @NotNull String selectStickerUid, boolean isFirstInto, long maxDuration) {
            StickerModel.Type type;
            Object last;
            ?? last2;
            Intrinsics.checkNotNullParameter(selectStickerUid, "selectStickerUid");
            if (data == null) {
                return;
            }
            WinkStickerModel winkStickerModel = data.get(selectStickerUid);
            if (winkStickerModel != null) {
                type = winkStickerModel.type;
            } else {
                type = null;
            }
            if (type == StickerModel.Type.BOTTOM_FRAME) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.stickers.clear();
            boolean z16 = false;
            for (Map.Entry<String, ? extends WinkStickerModel> entry : data.entrySet()) {
                if (entry.getValue().type != StickerModel.Type.BOTTOM_FRAME && !entry.getValue().isSubtitleSticker() && !entry.getValue().isLyricSticker() && !entry.getValue().isTemplateTextSticker() && !entry.getValue().isBackgroundTextSticker() && entry.getValue().startTime < maxDuration) {
                    ?? bVar = new b(entry.getValue());
                    bVar.k(entry.getKey());
                    if (Intrinsics.areEqual(bVar.d(), selectStickerUid)) {
                        bVar.i(true);
                        objectRef.element = bVar;
                        this.curIndex = this.stickers.size();
                        z16 = true;
                    } else {
                        bVar.i(false);
                    }
                    this.stickers.add(bVar);
                }
            }
            if (!z16 && this.stickers.size() > 0) {
                if (Intrinsics.areEqual(selectStickerUid, "ARGS_LAST_STICKER")) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.stickers);
                    ((b) last).i(true);
                    last2 = CollectionsKt___CollectionsKt.last((List<? extends ??>) this.stickers);
                    objectRef.element = last2;
                    this.curIndex = this.stickers.size() - 1;
                } else if (Intrinsics.areEqual(selectStickerUid, "ARGS_NONE_STICKER")) {
                    objectRef.element = null;
                    this.curIndex = -1;
                } else {
                    this.stickers.get(0).i(true);
                    objectRef.element = this.stickers.get(0);
                    this.curIndex = 0;
                }
            }
            T t16 = objectRef.element;
            if (((b) t16) != null) {
                if (isFirstInto) {
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.az
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkEditorStickerTimelinePart.c.j(WinkEditorStickerTimelinePart.c.this, objectRef);
                        }
                    }, 500L);
                } else {
                    this.selectClipSticker.postValue(t16);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$d;", "", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "a", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "b", "()Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "e", "(Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;)V", "img", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "f", "(Landroid/widget/TextView;)V", "title", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "d", "(Landroid/widget/RelativeLayout;)V", ParseCommon.CONTAINER, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RoundCornerImageView img;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RelativeLayout container;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final RelativeLayout getContainer() {
            return this.container;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final RoundCornerImageView getImg() {
            return this.img;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }

        public final void d(@Nullable RelativeLayout relativeLayout) {
            this.container = relativeLayout;
        }

        public final void e(@Nullable RoundCornerImageView roundCornerImageView) {
            this.img = roundCornerImageView;
        }

        public final void f(@Nullable TextView textView) {
            this.title = textView;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$e", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "l", "l1", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements IPlayer.PlayerListener {
        e() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long l3, long l16) {
            MutableLiveData<Long> m26;
            TimelineViewModelV2 timelineViewModelV2 = WinkEditorStickerTimelinePart.this.timelineViewModel;
            if (timelineViewModelV2 != null && (m26 = timelineViewModelV2.m2()) != null) {
                m26.postValue(Long.valueOf(l3));
            }
            WinkEditorStickerTimelinePart.this.nowTimeProgress = l3;
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            ImageView imageView;
            MutableLiveData<IPlayer.PlayerStatus> l26;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
                ImageView imageView2 = WinkEditorStickerTimelinePart.this.playerStatusBtn;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.oqq);
                }
            } else if (playerStatus == IPlayer.PlayerStatus.PAUSED && (imageView = WinkEditorStickerTimelinePart.this.playerStatusBtn) != null) {
                imageView.setImageResource(R.drawable.oqs);
            }
            TimelineViewModelV2 timelineViewModelV2 = WinkEditorStickerTimelinePart.this.timelineViewModel;
            if (timelineViewModelV2 != null && (l26 = timelineViewModelV2.l2()) != null) {
                l26.postValue(playerStatus);
            }
        }
    }

    public WinkEditorStickerTimelinePart(boolean z16) {
        this.isFromZShow = z16;
    }

    private final void Ab() {
        ImageView imageView = this.cancelBtn;
        if (imageView != null && imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorStickerTimelinePart.Bb(WinkEditorStickerTimelinePart.this, view);
                }
            });
        }
        ImageView imageView2 = this.confirmBtn;
        if (imageView2 != null && imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorStickerTimelinePart.Cb(WinkEditorStickerTimelinePart.this, view);
                }
            });
        }
        ImageView imageView3 = this.playerStatusBtn;
        if (imageView3 != null && imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorStickerTimelinePart.Db(WinkEditorStickerTimelinePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(WinkEditorStickerTimelinePart this$0, View view) {
        Map<String, WinkStickerModel> map;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Lb()) {
            this$0.Hb();
        } else {
            this$0.x9();
            dr H9 = this$0.H9();
            if (H9 != null) {
                map = H9.m();
            } else {
                map = null;
            }
            this$0.dc(map);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cb(WinkEditorStickerTimelinePart this$0, View it) {
        Map<String, WinkStickerModel> map;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        boolean Ya = this$0.Ya();
        dr H9 = this$0.H9();
        if (H9 != null) {
            map = H9.m();
        } else {
            map = null;
        }
        this$0.dc(map);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.editor.sticker.f.h(it, this$0.stickerListViewAdapter, this$0.stickerTimeType, this$0.Mb());
        if (Ya) {
            SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(4, 100));
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Db(WinkEditorStickerTimelinePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
        boolean z16 = false;
        if (timelineViewModelV2 != null && timelineViewModelV2.W2()) {
            z16 = true;
        }
        if (z16) {
            TimelineViewModelV2 timelineViewModelV22 = this$0.timelineViewModel;
            if (timelineViewModelV22 != null) {
                timelineViewModelV22.b3();
            }
        } else {
            TimelineViewModelV2 timelineViewModelV23 = this$0.timelineViewModel;
            if (timelineViewModelV23 != null) {
                timelineViewModelV23.c3();
            }
            SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(15, 100));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eb() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(context, null, 0, 0, 14, null);
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
        if (lVar != null) {
            lVar.x(videoTrackContainerView);
        }
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(56.0f));
        layoutParams.topMargin = eVar.a(6.0f);
        videoTrackContainerView.setLayoutParams(layoutParams);
        videoTrackContainerView.setSticker(true);
        videoTrackContainerView.p();
        this.videoTrack = videoTrackContainerView;
    }

    @RequiresApi(21)
    private final void Fb(View rootView) {
        com.tencent.mobileqq.wink.editor.sticker.control.c cVar;
        this.reorderContainerView = (ReorderContainerView) rootView.findViewById(R.id.f72993sc);
        TimelinePanel timelinePanel = (TimelinePanel) rootView.findViewById(R.id.f1189275g);
        this.timelinePanel = timelinePanel;
        if (timelinePanel != null) {
            cVar = g.b(timelinePanel, 0.0f, 0.0f, 2, 3, null);
        } else {
            cVar = null;
        }
        this.cursorHandler = cVar;
        if (cVar != null) {
            cVar.g(new Function2<Float, Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart$initView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Float f16, Boolean bool) {
                    invoke(f16.floatValue(), bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f16, boolean z16) {
                    TimelinePanelViewController timelinePanelViewController;
                    i63.b scaleCalculator;
                    timelinePanelViewController = WinkEditorStickerTimelinePart.this.panelController;
                    if (timelinePanelViewController == null || (scaleCalculator = timelinePanelViewController.getScaleCalculator()) == null) {
                        return;
                    }
                    long x16 = scaleCalculator.x(f16);
                    WinkEditorStickerTimelinePart winkEditorStickerTimelinePart = WinkEditorStickerTimelinePart.this;
                    TimelineViewModelV2 timelineViewModelV2 = winkEditorStickerTimelinePart.timelineViewModel;
                    if (timelineViewModelV2 != null) {
                        timelineViewModelV2.b3();
                    }
                    winkEditorStickerTimelinePart.gc(x16, z16);
                }
            });
        }
        this.cancelBtn = (ImageView) rootView.findViewById(R.id.xyi);
        this.confirmBtn = (ImageView) rootView.findViewById(R.id.xyk);
        this.playerStatusBtn = (ImageView) rootView.findViewById(R.id.xyv);
        this.timeText = (TextView) rootView.findViewById(R.id.kbp);
        this.stickerListView = (HorizontalListView) rootView.findViewById(R.id.ymv);
        this.stickerListViewV2 = (HorizontalListView) rootView.findViewById(R.id.ymw);
        this.threeSecButton = (TextView) rootView.findViewById(R.id.f96835ir);
        this.threeSecLayout = (LinearLayout) rootView.findViewById(R.id.f96845is);
        this.currentClipButton = (TextView) rootView.findViewById(R.id.tyj);
        this.currentClipLayout = (LinearLayout) rootView.findViewById(R.id.tyk);
        this.allEndButton = (TextView) rootView.findViewById(R.id.slr);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f75173y9);
        this.bottomContainer = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ar
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Gb;
                    Gb = WinkEditorStickerTimelinePart.Gb(view, motionEvent);
                    return Gb;
                }
            });
        }
        this.mTTSWaveView = (WinkTTSWaveView) rootView.findViewById(R.id.f124697k2);
        this.addStickerMask = (LinearLayout) rootView.findViewById(R.id.f166088yn4);
        this.addStickerBtn = (LinearLayout) rootView.findViewById(R.id.f166087yn3);
        this.addStickerBtnText = (TextView) rootView.findViewById(R.id.f10585675);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.stickerListViewAdapter = new c(context);
        Ab();
        tb();
        Eb();
        yb();
        ub();
        cb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Gb(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ib(WinkEditorStickerTimelinePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        this$0.Qb();
    }

    private final boolean Lb() {
        List<b> c16;
        WinkStickerModel winkStickerModel;
        boolean z16;
        c cVar = this.stickerListViewAdapter;
        if (cVar != null && (c16 = cVar.c()) != null) {
            for (b bVar : c16) {
                Map<String, WinkStickerModel> map = this.stickerModelBackup;
                if (map != null) {
                    winkStickerModel = map.get(bVar.d());
                } else {
                    winkStickerModel = null;
                }
                if (winkStickerModel != null && bVar.getStartTime() == winkStickerModel.startTime) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 || bVar.getEndTime() - bVar.getStartTime() != winkStickerModel.duration) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean Mb() {
        return H9() instanceof WinkVideoTavCut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nb(WinkVideoTavCut it, WinkEditorStickerTimelinePart this$0) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(2, 100));
        FrameLayout currentPlayerViewContainer = it.getCurrentPlayerViewContainer();
        if (currentPlayerViewContainer != null && (viewTreeObserver = currentPlayerViewContainer.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this$0.hideGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ob(WinkVideoTavCut it, WinkEditorStickerTimelinePart this$0) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(1, 100));
        FrameLayout currentPlayerViewContainer = it.getCurrentPlayerViewContainer();
        if (currentPlayerViewContainer != null && (viewTreeObserver = currentPlayerViewContainer.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this$0.showGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pb() {
        Set<String> set;
        Set<String> set2;
        Set minus;
        Set minus2;
        Object first;
        Map<String, WinkStickerModel> m3;
        dr H9 = H9();
        WinkVideoTavCut winkVideoTavCut = null;
        if (H9 != null && (m3 = H9.m()) != null) {
            set = m3.keySet();
        } else {
            set = null;
        }
        if (this.stickerModelBackup == null) {
            this.stickerModelBackup = new LinkedHashMap();
        }
        Map<String, WinkStickerModel> map = this.stickerModelBackup;
        if (map != null) {
            set2 = map.keySet();
        } else {
            set2 = null;
        }
        if (set != null && set2 != null) {
            minus = SetsKt___SetsKt.minus((Set) set, (Iterable) set2);
            if (!(!minus.isEmpty())) {
                minus2 = SetsKt___SetsKt.minus((Set) set2, (Iterable) set);
                if (!minus2.isEmpty()) {
                    Map<String, WinkStickerModel> map2 = this.stickerModelBackup;
                    if (map2 != null) {
                        first = CollectionsKt___CollectionsKt.first(minus2);
                        map2.remove(first);
                    }
                    bc("ARGS_NONE_STICKER");
                    dr H92 = H9();
                    if (H92 != null) {
                        H92.pause();
                        return;
                    }
                    return;
                }
                return;
            }
            dr H93 = H9();
            if (H93 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H93;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.R(this.timelineMenuHeight);
            }
            Iterator it = minus.iterator();
            while (it.hasNext()) {
                bc((String) it.next());
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.pause();
            }
        }
    }

    private final void Qb() {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        VideoTrackContainerView videoTrackContainerView;
        Map<String, WinkStickerModel> m16;
        int mapCapacity;
        WinkStickerModel winkStickerModel2;
        Long l3;
        Long l16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        dr H9 = H9();
        if (H9 != null && (m16 = H9.m()) != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(m16.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
            Iterator<T> it = m16.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                long j3 = ((WinkStickerModel) entry.getValue()).startTime;
                long j16 = ((WinkStickerModel) entry.getValue()).duration;
                Map<String, WinkStickerModel> map = this.stickerModelBackup;
                if (map != null) {
                    winkStickerModel2 = map.get(entry.getKey());
                } else {
                    winkStickerModel2 = null;
                }
                if (winkStickerModel2 != null) {
                    l3 = Long.valueOf(winkStickerModel2.startTime);
                } else {
                    l3 = null;
                }
                if (winkStickerModel2 != null) {
                    l16 = Long.valueOf(winkStickerModel2.duration);
                } else {
                    l16 = null;
                }
                WinkStickerModel winkStickerModel3 = (WinkStickerModel) entry.getValue();
                if ((l3 != null && l16 != null && j3 != l3.longValue()) || l16 == null || j16 != l16.longValue()) {
                    WinkStickerModel winkStickerModel4 = (WinkStickerModel) entry.getValue();
                    Intrinsics.checkNotNull(l3);
                    long longValue = l3.longValue();
                    Intrinsics.checkNotNull(l16);
                    winkStickerModel3 = WinkStickerModel.copyAndUpdate$default(winkStickerModel4, null, null, longValue, l16.longValue(), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -13, 1048575, null);
                }
                linkedHashMap.put(entry.getKey(), winkStickerModel3);
                linkedHashMap2.put(key, Unit.INSTANCE);
            }
        }
        dc(linkedHashMap);
        dr H92 = H9();
        if (H92 != null && (m3 = H92.m()) != null && (winkStickerModel = m3.get(this.curStickerModelId)) != null) {
            VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
            if (videoTrackContainerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            } else {
                videoTrackContainerView = videoTrackContainerView2;
            }
            long j17 = winkStickerModel.startTime;
            videoTrackContainerView.Z(j17, j17 + winkStickerModel.duration, false);
            long j18 = winkStickerModel.startTime;
            Rb(j18, winkStickerModel.duration + j18);
        }
    }

    private final void Rb(long startTime, long endTime) {
        if (endTime - startTime == this.DEFAULT_BOTTOM_BAR_BUTTON_SEC) {
            TextView textView = this.threeSecButton;
            if (textView != null) {
                Zb(textView);
                return;
            }
            return;
        }
        long j3 = 0;
        if (startTime == 0) {
            dr H9 = H9();
            if (H9 != null) {
                j3 = H9.getDurationUs();
            }
            if (Math.abs(endTime - j3) < 10000) {
                TextView textView2 = this.allEndButton;
                if (textView2 != null) {
                    Zb(textView2);
                    return;
                }
                return;
            }
        }
        ClipTime ab5 = ab(startTime);
        if (ab5.getStartTime() == startTime && ab5.getEndTime() == endTime) {
            TextView textView3 = this.currentClipButton;
            if (textView3 != null) {
                Zb(textView3);
                return;
            }
            return;
        }
        Zb(null);
    }

    private final void Sb(String type) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CONTINUE_ADD_BUTTON);
        if (Intrinsics.areEqual(type, "ARGS_ADD_BTN_TYPE_STICKER")) {
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, "paste");
        } else {
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
        }
        VideoReport.setElementId(this.addStickerBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CONTINUE_ADD_BUTTON);
        VideoReport.reportEvent("dt_clck", this.addStickerBtn, extParams);
    }

    private final void Tb(String type) {
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CONTINUE_ADD_BUTTON);
        if (Intrinsics.areEqual(type, "ARGS_ADD_BTN_TYPE_STICKER")) {
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, "paste");
        } else {
            extParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
        }
        VideoReport.setElementId(this.addStickerBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CONTINUE_ADD_BUTTON);
        VideoReport.reportEvent("dt_imp", this.addStickerBtn, extParams);
    }

    private final void Vb(int position) {
        c cVar = this.stickerListViewAdapter;
        if (cVar != null) {
            cVar.f(position);
        }
        if (position != -1) {
            TextView textView = this.threeSecButton;
            BottomBarStatus bottomBarStatus = BottomBarStatus.DEFAULT;
            Yb(textView, bottomBarStatus);
            Yb(this.currentClipButton, bottomBarStatus);
            Yb(this.allEndButton, bottomBarStatus);
            Za(Boolean.TRUE);
            return;
        }
        Za(Boolean.FALSE);
    }

    private final void Wb(Bundle args) {
        if (args == null) {
            LinearLayout linearLayout = this.addStickerBtn;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.addStickerMask;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        final String string = args.getString("ARGS_ADD_BTN_TYPE");
        Unit unit = null;
        if (string != null) {
            if (string.hashCode() == -193088849 && string.equals("ARGS_ADD_BTN_TYPE_TEXT")) {
                TextView textView = this.addStickerBtnText;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.f215555vx));
                }
            } else {
                TextView textView2 = this.addStickerBtnText;
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R.string.f215545vw));
                }
            }
            LinearLayout linearLayout3 = this.addStickerBtn;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = this.addStickerMask;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            Tb(string);
            LinearLayout linearLayout5 = this.addStickerBtn;
            if (linearLayout5 != null) {
                linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ay
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WinkEditorStickerTimelinePart.Xb(WinkEditorStickerTimelinePart.this, string, view);
                    }
                });
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            LinearLayout linearLayout6 = this.addStickerBtn;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
            LinearLayout linearLayout7 = this.addStickerMask;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xb(WinkEditorStickerTimelinePart this$0, String btnType, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(btnType, "$btnType");
        this$0.showStickerMenuPart = true;
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_BACK_TO_MENU_TYPE", MenuType.STICKER_TIMELINE.name());
        if (btnType.hashCode() == -1821042597 && btnType.equals("ARGS_ADD_BTN_TYPE_STICKER")) {
            dr H9 = this$0.H9();
            if (H9 != null) {
                H9.pause();
            }
            this$0.G9().u5(MenuType.STICKER, bundle);
        } else {
            this$0.G9().u5(MenuType.TEXT, bundle);
        }
        this$0.Sb(btnType);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean Ya() {
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        WinkStickerModel winkStickerModel;
        Long l3;
        Long l16;
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null && (values = m3.values()) != null) {
            for (WinkStickerModel winkStickerModel2 : values) {
                Map<String, WinkStickerModel> map = this.stickerModelBackup;
                if (map != null) {
                    winkStickerModel = map.get(winkStickerModel2.id);
                } else {
                    winkStickerModel = null;
                }
                long j3 = winkStickerModel2.startTime + winkStickerModel2.duration;
                if (winkStickerModel != null) {
                    l3 = Long.valueOf(winkStickerModel.startTime + winkStickerModel.duration);
                } else {
                    l3 = null;
                }
                long j16 = winkStickerModel2.startTime;
                if (winkStickerModel != null) {
                    l16 = Long.valueOf(winkStickerModel.startTime);
                } else {
                    l16 = null;
                }
                Intrinsics.checkNotNull(l16);
                if (j16 >= l16.longValue()) {
                    Intrinsics.checkNotNull(l3);
                    if (j3 > l3.longValue()) {
                    }
                }
                winkStickerModel2.setTraceSticker(false);
                winkStickerModel2.setStickerTrackerResult(null);
                winkStickerModel2.setEntityName(null);
                return true;
            }
        }
        return false;
    }

    private final void Yb(TextView view, BottomBarStatus status) {
        Drawable drawable;
        Context context;
        Resources resources;
        Drawable drawable2;
        Context context2;
        Resources resources2;
        Drawable drawable3 = null;
        if (view == null || (context2 = view.getContext()) == null || (resources2 = context2.getResources()) == null || (drawable = resources2.getDrawable(this.BOTTOM_BAR_BUTTON_BG_DAFAULT_DRAWABLE)) == null) {
            drawable = null;
        }
        if (view != null && (context = view.getContext()) != null && (resources = context.getResources()) != null && (drawable2 = resources.getDrawable(this.BOTTOM_BAR_BUTTON_BG_SELECT_DRAWABLE)) != null) {
            drawable3 = drawable2;
        }
        if (status == BottomBarStatus.ENABLE) {
            if (view != null) {
                view.setTextColor(getContext().getResources().getColor(R.color.d06));
            }
            if (view != null) {
                view.setBackgroundDrawable(drawable);
            }
            if (view != null) {
                view.setClickable(false);
                return;
            }
            return;
        }
        if (status == BottomBarStatus.DEFAULT) {
            if (view != null) {
                view.setTextColor(getContext().getResources().getColor(R.color.f158028d05));
            }
            if (view != null) {
                view.setBackgroundDrawable(drawable);
            }
            if (view != null) {
                view.setClickable(true);
                return;
            }
            return;
        }
        if (status == BottomBarStatus.SELECT) {
            if (view != null) {
                view.setTextColor(getContext().getResources().getColor(R.color.d07));
            }
            if (view != null) {
                view.setBackgroundDrawable(drawable3);
            }
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    private final void Za(Boolean enable) {
        VideoTrackContainerView videoTrackContainerView;
        long j3;
        if (this.videoTrack == null) {
            return;
        }
        VideoTrackContainerView videoTrackContainerView2 = null;
        if (enable != null && enable.booleanValue()) {
            TextView textView = this.threeSecButton;
            BottomBarStatus bottomBarStatus = BottomBarStatus.DEFAULT;
            Yb(textView, bottomBarStatus);
            Yb(this.currentClipButton, bottomBarStatus);
            Yb(this.allEndButton, bottomBarStatus);
            VideoTrackContainerView videoTrackContainerView3 = this.videoTrack;
            if (videoTrackContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            } else {
                videoTrackContainerView2 = videoTrackContainerView3;
            }
            videoTrackContainerView2.setFreedomSliderViewVisible(0);
            return;
        }
        TextView textView2 = this.threeSecButton;
        BottomBarStatus bottomBarStatus2 = BottomBarStatus.ENABLE;
        Yb(textView2, bottomBarStatus2);
        Yb(this.currentClipButton, bottomBarStatus2);
        Yb(this.allEndButton, bottomBarStatus2);
        VideoTrackContainerView videoTrackContainerView4 = this.videoTrack;
        if (videoTrackContainerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView4 = null;
        }
        videoTrackContainerView4.setFreedomSliderViewVisible(4);
        VideoTrackContainerView videoTrackContainerView5 = this.videoTrack;
        if (videoTrackContainerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        } else {
            videoTrackContainerView = videoTrackContainerView5;
        }
        dr H9 = H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = 0;
        }
        videoTrackContainerView.Z(0L, j3, false);
    }

    private final void Zb(View view) {
        String str;
        Integer num;
        Integer num2;
        Integer num3;
        MutableLiveData<b> d16;
        b value;
        c cVar = this.stickerListViewAdapter;
        Integer num4 = null;
        if (cVar != null && (d16 = cVar.d()) != null && (value = d16.getValue()) != null) {
            str = value.d();
        } else {
            str = null;
        }
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        TextView textView = this.threeSecButton;
        if (textView != null) {
            num2 = Integer.valueOf(textView.getId());
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            Yb(this.threeSecButton, BottomBarStatus.SELECT);
            TextView textView2 = this.currentClipButton;
            BottomBarStatus bottomBarStatus = BottomBarStatus.DEFAULT;
            Yb(textView2, bottomBarStatus);
            Yb(this.allEndButton, bottomBarStatus);
            this.stickerTimeType.put(str, "3s");
            return;
        }
        TextView textView3 = this.currentClipButton;
        if (textView3 != null) {
            num3 = Integer.valueOf(textView3.getId());
        } else {
            num3 = null;
        }
        if (Intrinsics.areEqual(num, num3)) {
            TextView textView4 = this.threeSecButton;
            BottomBarStatus bottomBarStatus2 = BottomBarStatus.DEFAULT;
            Yb(textView4, bottomBarStatus2);
            Yb(this.currentClipButton, BottomBarStatus.SELECT);
            Yb(this.allEndButton, bottomBarStatus2);
            this.stickerTimeType.put(str, "current");
            return;
        }
        TextView textView5 = this.allEndButton;
        if (textView5 != null) {
            num4 = Integer.valueOf(textView5.getId());
        }
        if (Intrinsics.areEqual(num, num4)) {
            TextView textView6 = this.threeSecButton;
            BottomBarStatus bottomBarStatus3 = BottomBarStatus.DEFAULT;
            Yb(textView6, bottomBarStatus3);
            Yb(this.currentClipButton, bottomBarStatus3);
            Yb(this.allEndButton, BottomBarStatus.SELECT);
            this.stickerTimeType.put(str, "original");
            return;
        }
        TextView textView7 = this.threeSecButton;
        BottomBarStatus bottomBarStatus4 = BottomBarStatus.DEFAULT;
        Yb(textView7, bottomBarStatus4);
        Yb(this.currentClipButton, bottomBarStatus4);
        Yb(this.allEndButton, bottomBarStatus4);
        this.stickerTimeType.put(str, "custom");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if ((!r0.isEmpty()) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ClipTime ab(long curTime) {
        boolean z16;
        dr H9;
        List<WinkEditData> n3;
        dr H92 = H9();
        if (H92 != null && (r0 = H92.n()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (H9 = H9()) != null && (n3 = H9.n()) != null) {
            Iterator<T> it = com.tencent.mobileqq.wink.editor.draft.c.t(n3.get(0)).iterator();
            long j3 = 0;
            while (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null) {
                    long j16 = resourceModel.scaleDuration;
                    j3 += j16;
                    if (j3 > curTime) {
                        return new ClipTime(j3 - j16, j3);
                    }
                }
            }
        }
        return new ClipTime(0L, 0L);
    }

    private final void ac(String curStickerModelId) {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        boolean z16;
        WinkStickerModel winkStickerModel2;
        Map<String, WinkStickerModel> m16;
        Collection<WinkStickerModel> values;
        Object obj;
        String str;
        boolean z17;
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(curStickerModelId)) != null) {
            MetaMaterial material = winkStickerModel.getMaterial();
            if (material != null && com.tencent.mobileqq.wink.editor.sticker.m.Q(material)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                dr H92 = H9();
                if (H92 != null && (m16 = H92.m()) != null && (values = m16.values()) != null) {
                    Iterator<T> it = values.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            WinkStickerModel winkStickerModel3 = (WinkStickerModel) obj;
                            MetaMaterial material2 = winkStickerModel3.getMaterial();
                            if (material2 != null) {
                                str = com.tencent.mobileqq.wink.editor.sticker.m.u(material2);
                            } else {
                                str = null;
                            }
                            if (Intrinsics.areEqual(str, com.tencent.mobileqq.wink.editor.sticker.m.u(winkStickerModel.getMaterial())) && !Intrinsics.areEqual(winkStickerModel3.id, curStickerModelId)) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    winkStickerModel2 = (WinkStickerModel) obj;
                } else {
                    winkStickerModel2 = null;
                }
                if (winkStickerModel2 != null) {
                    WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, winkStickerModel.startTime, winkStickerModel.duration, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -13, 1048575, null);
                    dr H93 = H9();
                    Intrinsics.checkNotNull(H93);
                    dr.b.n(H93, copyAndUpdate$default, false, 2, null);
                }
            }
        }
    }

    private final long bb(long endTime) {
        WinkVideoTavCut winkVideoTavCut;
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            endTime = com.tencent.mobileqq.wink.editor.sticker.b.f321561a.b(winkVideoTavCut, endTime);
        }
        if (endTime < 0) {
            return 0L;
        }
        return endTime;
    }

    private final void bc(final String stickerUid) {
        long j3;
        Map<String, WinkStickerModel> map;
        Integer num;
        boolean z16;
        List<b> c16;
        WinkStickerModel winkStickerModel;
        Map<String, WinkStickerModel> map2;
        HorizontalListView horizontalListView;
        Map<String, WinkStickerModel> m3;
        int mapCapacity;
        Map<String, WinkStickerModel> mutableMap;
        WinkStickerModel winkStickerModel2;
        long j16;
        dr H9 = H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = Long.MAX_VALUE;
        }
        long j17 = j3;
        dr H92 = H9();
        Boolean bool = null;
        if (H92 != null && (m3 = H92.m()) != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(m3.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = m3.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                if (((WinkStickerModel) entry.getValue()).startTime + ((WinkStickerModel) entry.getValue()).duration > j17) {
                    if (j17 > ((WinkStickerModel) entry.getValue()).startTime) {
                        j16 = j17 - ((WinkStickerModel) entry.getValue()).startTime;
                    } else {
                        j16 = 0;
                    }
                    winkStickerModel2 = WinkStickerModel.copyAndUpdate$default((WinkStickerModel) entry.getValue(), null, null, 0L, j16, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -9, 1048575, null);
                } else {
                    winkStickerModel2 = (WinkStickerModel) entry.getValue();
                }
                linkedHashMap.put(key, winkStickerModel2);
            }
            mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
            map = mutableMap;
        } else {
            map = null;
        }
        c cVar = this.stickerListViewAdapter;
        if (cVar != null) {
            cVar.i(map, stickerUid, this.isFirstInto, j17);
        }
        c cVar2 = this.stickerListViewAdapter;
        if (cVar2 != null) {
            cVar2.notifyDataSetChanged();
        }
        c cVar3 = this.stickerListViewAdapter;
        if (cVar3 != null) {
            num = Integer.valueOf(cVar3.getCurIndex());
        } else {
            num = null;
        }
        boolean z17 = false;
        if (num != null && num.intValue() != -1 && (horizontalListView = this.stickerListViewV2) != null) {
            horizontalListView.smoothScrollToPosition(num.intValue(), 0, 0);
        }
        if (this.isFirstInto) {
            this.stickerModelBackup = map;
        }
        if (stickerUid.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && map != null && (winkStickerModel = map.get(stickerUid)) != null && (map2 = this.stickerModelBackup) != null) {
            map2.put(stickerUid, winkStickerModel);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.an
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorStickerTimelinePart.cc(WinkEditorStickerTimelinePart.this, stickerUid);
            }
        }, 300L);
        c cVar4 = this.stickerListViewAdapter;
        if (cVar4 != null && (c16 = cVar4.c()) != null) {
            bool = Boolean.valueOf(!c16.isEmpty());
        }
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue() && !Intrinsics.areEqual(stickerUid, "ARGS_NONE_STICKER")) {
            z17 = true;
        }
        Za(Boolean.valueOf(z17));
    }

    private final void cb() {
        ViewGroup.LayoutParams layoutParams;
        TextView textView = this.threeSecButton;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.av
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorStickerTimelinePart.eb(WinkEditorStickerTimelinePart.this, view);
                }
            });
        }
        if (G9().getIsFromTemplateColl()) {
            LinearLayout linearLayout = this.threeSecLayout;
            if (linearLayout != null) {
                layoutParams = linearLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.setMarginEnd(ViewUtils.dpToPx(75.0f));
            }
            LinearLayout linearLayout2 = this.threeSecLayout;
            if (linearLayout2 != null) {
                linearLayout2.setLayoutParams(layoutParams2);
            }
            LinearLayout linearLayout3 = this.currentClipLayout;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        } else {
            TextView textView2 = this.currentClipButton;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.aw
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WinkEditorStickerTimelinePart.fb(WinkEditorStickerTimelinePart.this, view);
                    }
                });
            }
        }
        TextView textView3 = this.allEndButton;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ax
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorStickerTimelinePart.gb(WinkEditorStickerTimelinePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cc(WinkEditorStickerTimelinePart this$0, String stickerUid) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerUid, "$stickerUid");
        this$0.broadcastMessage("ARGS_SWITCH_STICKER_IN_TIMELINE_SETTING", stickerUid);
    }

    private final void dc(Map<String, ? extends WinkStickerModel> stickers) {
        Map<String, WinkStickerModel> mutableMap;
        if (!(H9() instanceof WinkVideoTavCut)) {
            return;
        }
        dr H9 = H9();
        Intrinsics.checkNotNull(H9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9;
        List<? extends MediaClip> list = this.mediaClipsBackup;
        if (list != null) {
            Map<String, TransitionModel> map = this.transformModelsBackup;
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            winkVideoTavCut.f3(list, map);
        }
        if (stickers != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(stickers);
            winkVideoTavCut.B(mutableMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(WinkEditorStickerTimelinePart this$0, View it) {
        Long l3;
        MutableLiveData<Long> m26;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
        long j3 = 0;
        if (timelineViewModelV2 == null || (m26 = timelineViewModelV2.m2()) == null || (l3 = m26.getValue()) == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        dr H9 = this$0.H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        }
        long j16 = this$0.DEFAULT_BOTTOM_BAR_BUTTON_SEC;
        if (longValue + j16 < j3) {
            j3 = longValue + j16;
        }
        VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        videoTrackContainerView.Y(longValue, j3);
        this$0.Zb(it);
        this$0.ec(longValue);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.editor.sticker.f.q(it, WinkDaTongReportConstant.ElementId.EM_XSJ_DEFAULT_2S_BUTTON);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void ec(long startTime) {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        WinkTTSWaveView winkTTSWaveView = this.mTTSWaveView;
        VideoTrackContainerView videoTrackContainerView = null;
        if (winkTTSWaveView != null) {
            layoutParams = winkTTSWaveView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
        } else {
            videoTrackContainerView = videoTrackContainerView2;
        }
        int P = (int) videoTrackContainerView.P();
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
        if (lVar != null) {
            i3 = lVar.J(startTime);
        } else {
            i3 = 0;
        }
        layoutParams2.setMargins(P + i3, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        WinkTTSWaveView winkTTSWaveView2 = this.mTTSWaveView;
        if (winkTTSWaveView2 != null) {
            winkTTSWaveView2.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(WinkEditorStickerTimelinePart this$0, View it) {
        Long l3;
        MutableLiveData<Long> m26;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
        if (timelineViewModelV2 == null || (m26 = timelineViewModelV2.m2()) == null || (l3 = m26.getValue()) == null) {
            l3 = 0L;
        }
        ClipTime ab5 = this$0.ab(l3.longValue());
        VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        videoTrackContainerView.Z(ab5.getStartTime(), ab5.getEndTime(), false);
        this$0.Zb(it);
        this$0.ec(ab5.getStartTime());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.editor.sticker.f.q(it, WinkDaTongReportConstant.ElementId.EM_XSJ_DEFAULT_END_BUTTON);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gb(WinkEditorStickerTimelinePart this$0, View it) {
        long j3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        VideoTrackContainerView videoTrackContainerView2 = videoTrackContainerView;
        dr H9 = this$0.H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = 0;
        }
        videoTrackContainerView2.Z(0L, j3, false);
        this$0.Zb(it);
        this$0.ec(0L);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.editor.sticker.f.q(it, WinkDaTongReportConstant.ElementId.EM_XSJ_DEFAULT_ALLEND_BUTTON);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gc(long currentPlayingTime, boolean isLast) {
        float f16;
        i63.b scaleCalculator;
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null) {
            TimelineViewModelV2.g3(timelineViewModelV2, currentPlayingTime, !isLast, false, 4, null);
        }
        com.tencent.mobileqq.wink.editor.sticker.control.c cVar = this.cursorHandler;
        if (cVar != null) {
            TimelinePanelViewController timelinePanelViewController = this.panelController;
            if (timelinePanelViewController != null && (scaleCalculator = timelinePanelViewController.getScaleCalculator()) != null) {
                f16 = scaleCalculator.y(currentPlayingTime);
            } else {
                f16 = 0.0f;
            }
            cVar.e(f16);
        }
        this.nowTimeProgress = currentPlayingTime;
    }

    private final void hb() {
        MutableLiveData<b> d16;
        VideoTrackContainerView videoTrackContainerView = this.videoTrack;
        VideoTrackContainerView videoTrackContainerView2 = null;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        videoTrackContainerView.F().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerTimelinePart.ib(WinkEditorStickerTimelinePart.this, (Pair) obj);
            }
        });
        VideoTrackContainerView videoTrackContainerView3 = this.videoTrack;
        if (videoTrackContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView3 = null;
        }
        videoTrackContainerView3.K().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerTimelinePart.jb(WinkEditorStickerTimelinePart.this, (Pair) obj);
            }
        });
        VideoTrackContainerView videoTrackContainerView4 = this.videoTrack;
        if (videoTrackContainerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView4 = null;
        }
        videoTrackContainerView4.E().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerTimelinePart.kb(WinkEditorStickerTimelinePart.this, (Long) obj);
            }
        });
        VideoTrackContainerView videoTrackContainerView5 = this.videoTrack;
        if (videoTrackContainerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
        } else {
            videoTrackContainerView2 = videoTrackContainerView5;
        }
        videoTrackContainerView2.L().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorStickerTimelinePart.lb(WinkEditorStickerTimelinePart.this, (Pair) obj);
            }
        });
        c cVar = this.stickerListViewAdapter;
        if (cVar != null && (d16 = cVar.d()) != null) {
            d16.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ai
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorStickerTimelinePart.mb(WinkEditorStickerTimelinePart.this, (WinkEditorStickerTimelinePart.b) obj);
                }
            });
        }
    }

    static /* synthetic */ void hc(WinkEditorStickerTimelinePart winkEditorStickerTimelinePart, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        winkEditorStickerTimelinePart.gc(j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ib(WinkEditorStickerTimelinePart this$0, Pair pair) {
        long longValue;
        long j3;
        boolean z16;
        VideoTrackContainerView videoTrackContainerView;
        VideoTrackContainerView videoTrackContainerView2;
        boolean z17;
        long j16;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        long j17;
        long j18;
        WinkEditorFragment F9;
        String ok5;
        WinkEditorFragment F92;
        dr drVar;
        WinkVideoTavCut winkVideoTavCut;
        TTSAudioItem[] audioItems;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.TAG, "initClipObserver, clipStartTime = " + pair);
        if (((Number) pair.getFirst()).longValue() < 0) {
            longValue = 0;
        } else {
            longValue = ((Number) pair.getFirst()).longValue();
        }
        dr H9 = this$0.H9();
        if (H9 != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(this$0.curStickerModelId)) != null) {
            long j19 = (winkStickerModel.startTime - longValue) + winkStickerModel.duration;
            dr H92 = this$0.H9();
            Intrinsics.checkNotNull(H92);
            IPlayer currentPlayer = H92.getCurrentPlayer();
            if (currentPlayer != null) {
                j17 = currentPlayer.getDurationUs();
            } else {
                j17 = 0;
            }
            if (longValue + j19 > j17 && j17 > 0) {
                j18 = j17 - longValue;
            } else {
                j18 = j19;
            }
            long j26 = longValue;
            long j27 = longValue;
            z16 = false;
            videoTrackContainerView = null;
            WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, j26, j18, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -13, 1048575, null);
            copyAndUpdate$default.setTimeRangeChangedByUser(true);
            copyAndUpdate$default.setStickerTrackerResult(winkStickerModel.getStickerTrackerResult());
            copyAndUpdate$default.setTraceSticker(winkStickerModel.getIsTraceSticker());
            copyAndUpdate$default.setEntityName(winkStickerModel.getEntityName());
            dr H93 = this$0.H9();
            Intrinsics.checkNotNull(H93);
            dr.b.n(H93, copyAndUpdate$default, false, 2, null);
            this$0.ac(this$0.curStickerModelId);
            TTSAudioInfo ttsAudioInfo = winkStickerModel.getTtsAudioInfo();
            if (ttsAudioInfo != null && (audioItems = ttsAudioInfo.getAudioItems()) != null) {
                Intrinsics.checkNotNullExpressionValue(audioItems, "audioItems");
                if (audioItems.length == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    j3 = j27;
                    audioItems[0].setStartTime(j3);
                    F9 = this$0.F9();
                    if (F9 != null && (ok5 = F9.ok()) != null) {
                        F92 = this$0.F9();
                        if (F92 == null) {
                            drVar = F92.getCurTavCut();
                        } else {
                            drVar = null;
                        }
                        Intrinsics.checkNotNull(drVar, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                        winkVideoTavCut = (WinkVideoTavCut) drVar;
                        if (winkVideoTavCut != null) {
                            winkVideoTavCut.w3(ok5, j3);
                        }
                    }
                }
            }
            j3 = j27;
            F9 = this$0.F9();
            if (F9 != null) {
                F92 = this$0.F9();
                if (F92 == null) {
                }
                Intrinsics.checkNotNull(drVar, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                winkVideoTavCut = (WinkVideoTavCut) drVar;
                if (winkVideoTavCut != null) {
                }
            }
        } else {
            j3 = longValue;
            z16 = false;
            videoTrackContainerView = null;
        }
        c cVar = this$0.stickerListViewAdapter;
        if (cVar != null) {
            cVar.h(j3);
        }
        if (((Boolean) pair.getSecond()).booleanValue()) {
            videoTrackContainerView2 = videoTrackContainerView;
            j16 = j3;
            z17 = z16;
            hc(this$0, j16, false, 2, null);
        } else {
            videoTrackContainerView2 = videoTrackContainerView;
            z17 = z16;
            j16 = j3;
        }
        VideoTrackContainerView videoTrackContainerView3 = this$0.videoTrack;
        if (videoTrackContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView3 = videoTrackContainerView2;
        }
        if (videoTrackContainerView3.getIsClipTimeAdjust()) {
            VideoTrackContainerView videoTrackContainerView4 = this$0.videoTrack;
            if (videoTrackContainerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView4 = videoTrackContainerView2;
            }
            Pair<Long, Boolean> value = videoTrackContainerView4.K().getValue();
            if (value != null) {
                this$0.Rb(j16, value.getFirst().longValue());
            }
            VideoTrackContainerView videoTrackContainerView5 = this$0.videoTrack;
            if (videoTrackContainerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView5 = videoTrackContainerView2;
            }
            videoTrackContainerView5.setClipTimeAdjust(z17);
            VideoTrackContainerView videoTrackContainerView6 = this$0.videoTrack;
            if (videoTrackContainerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView6 = videoTrackContainerView2;
            }
            com.tencent.mobileqq.wink.editor.sticker.f.q(videoTrackContainerView6.C(), WinkDaTongReportConstant.ElementId.EM_XSJ_LENGTH_ADJUST_BUTTON);
        }
    }

    private final void ic() {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        TTSAudioInfo ttsAudioInfo;
        TTSAudioItem[] audioItems;
        boolean z16;
        ViewGroup.LayoutParams layoutParams;
        dr curTavCut;
        WinkTTSWaveView winkTTSWaveView = this.mTTSWaveView;
        if (winkTTSWaveView != null) {
            winkTTSWaveView.setVisibility(8);
        }
        dr H9 = H9();
        if (H9 != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(this.curStickerModelId)) != null && (ttsAudioInfo = winkStickerModel.getTtsAudioInfo()) != null && (audioItems = ttsAudioInfo.getAudioItems()) != null) {
            Intrinsics.checkNotNullExpressionValue(audioItems, "audioItems");
            int i3 = 0;
            if (audioItems.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                w53.b.c(this.TAG, "updateWaveView");
                WinkTTSWaveView winkTTSWaveView2 = this.mTTSWaveView;
                if (winkTTSWaveView2 != null) {
                    winkTTSWaveView2.setVisibility(0);
                }
                TTSAudioItem tTSAudioItem = audioItems[0];
                WinkTTSWaveView winkTTSWaveView3 = this.mTTSWaveView;
                Integer num = null;
                if (winkTTSWaveView3 != null) {
                    layoutParams = winkTTSWaveView3.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                VideoTrackContainerView videoTrackContainerView = this.videoTrack;
                if (videoTrackContainerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                    videoTrackContainerView = null;
                }
                int P = (int) videoTrackContainerView.P();
                if (layoutParams2 != null) {
                    com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
                    if (lVar != null) {
                        i3 = lVar.J(winkStickerModel.startTime);
                    }
                    layoutParams2.leftMargin = i3 + P;
                }
                if (layoutParams2 != null) {
                    layoutParams2.rightMargin = P;
                }
                WinkTTSWaveView winkTTSWaveView4 = this.mTTSWaveView;
                if (winkTTSWaveView4 != null) {
                    winkTTSWaveView4.setLayoutParams(layoutParams2);
                }
                float screenWidth = ViewUtils.getScreenWidth();
                VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
                if (videoTrackContainerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                    videoTrackContainerView2 = null;
                }
                int P2 = (int) (screenWidth - (videoTrackContainerView2.P() * 2));
                WinkTTSWaveView winkTTSWaveView5 = this.mTTSWaveView;
                if (winkTTSWaveView5 != null) {
                    long j3 = 1000;
                    int duration = (int) (tTSAudioItem.getDuration() / j3);
                    WinkEditorFragment F9 = F9();
                    if (F9 != null && (curTavCut = F9.getCurTavCut()) != null) {
                        num = Integer.valueOf((int) (curTavCut.getDurationUs() / j3));
                    }
                    Intrinsics.checkNotNull(num);
                    winkTTSWaveView5.a(duration, num.intValue(), P2, ViewUtils.dpToPx(56.0f));
                }
            }
        }
    }

    private final void initViewModel() {
        if (this.timelineViewModel == null) {
            this.timelineViewModel = (TimelineViewModelV2) new ViewModelProvider(getHostFragment()).get(TimelineViewModelV2.class);
        }
        this.templateViewModel = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(WinkEditorStickerTimelinePart this$0, Pair pair) {
        long j3;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = 0;
        }
        if (((Number) pair.getFirst()).longValue() <= j3) {
            j3 = ((Number) pair.getFirst()).longValue();
        }
        long j16 = j3;
        dr H92 = this$0.H9();
        VideoTrackContainerView videoTrackContainerView = null;
        if (H92 != null && (m3 = H92.m()) != null && (winkStickerModel = m3.get(this$0.curStickerModelId)) != null) {
            WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, j16 - winkStickerModel.startTime, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -9, 1048575, null);
            copyAndUpdate$default.setTimeRangeChangedByUser(true);
            copyAndUpdate$default.setStickerTrackerResult(winkStickerModel.getStickerTrackerResult());
            copyAndUpdate$default.setTraceSticker(winkStickerModel.getIsTraceSticker());
            copyAndUpdate$default.setEntityName(winkStickerModel.getEntityName());
            dr H93 = this$0.H9();
            Intrinsics.checkNotNull(H93);
            dr.b.n(H93, copyAndUpdate$default, false, 2, null);
            this$0.ac(this$0.curStickerModelId);
        }
        c cVar = this$0.stickerListViewAdapter;
        if (cVar != null) {
            cVar.g(j16);
        }
        if (((Boolean) pair.getSecond()).booleanValue()) {
            hc(this$0, this$0.bb(j16), false, 2, null);
        }
        VideoTrackContainerView videoTrackContainerView2 = this$0.videoTrack;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView2 = null;
        }
        if (videoTrackContainerView2.getIsClipTimeAdjust()) {
            VideoTrackContainerView videoTrackContainerView3 = this$0.videoTrack;
            if (videoTrackContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView3 = null;
            }
            Pair<Long, Boolean> value = videoTrackContainerView3.F().getValue();
            if (value != null) {
                this$0.Rb(value.getFirst().longValue(), j16);
            }
            VideoTrackContainerView videoTrackContainerView4 = this$0.videoTrack;
            if (videoTrackContainerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView4 = null;
            }
            videoTrackContainerView4.setClipTimeAdjust(false);
            VideoTrackContainerView videoTrackContainerView5 = this$0.videoTrack;
            if (videoTrackContainerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            } else {
                videoTrackContainerView = videoTrackContainerView5;
            }
            com.tencent.mobileqq.wink.editor.sticker.f.q(videoTrackContainerView.I(), WinkDaTongReportConstant.ElementId.EM_XSJ_LENGTH_ADJUST_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(WinkEditorStickerTimelinePart this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ec(it.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(WinkEditorStickerTimelinePart this$0, Pair pair) {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        TTSAudioInfo ttsAudioInfo;
        TTSAudioItem[] audioItems;
        boolean z16;
        boolean z17;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(this$0.curStickerModelId)) != null && (ttsAudioInfo = winkStickerModel.getTtsAudioInfo()) != null && (audioItems = ttsAudioInfo.getAudioItems()) != null) {
            if (audioItems.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                WinkTTSWaveView winkTTSWaveView = this$0.mTTSWaveView;
                if (winkTTSWaveView != null && winkTTSWaveView.getVisibility() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    TTSAudioItem tTSAudioItem = audioItems[0];
                    if (tTSAudioItem != null) {
                        j3 = tTSAudioItem.getDuration();
                    } else {
                        j3 = 0;
                    }
                    if (Math.abs((((Number) pair.getFirst()).longValue() - ((Number) pair.getSecond()).longValue()) - j3) <= 30000) {
                        com.tencent.videocut.utils.s sVar = com.tencent.videocut.utils.s.f384267a;
                        WinkTTSWaveView winkTTSWaveView2 = this$0.mTTSWaveView;
                        Intrinsics.checkNotNull(winkTTSWaveView2);
                        sVar.a(winkTTSWaveView2);
                        if (!this$0.isShowTTSPopWindow) {
                            this$0.isShowTTSPopWindow = true;
                            com.tencent.mobileqq.widget.tip.a m06 = QUIDefaultBubbleTip.r(this$0.getContext()).o0(this$0.getContext().getString(R.string.f239867nm)).S(this$0.mTTSWaveView).R(1).k0(0).m0(3);
                            m06.s0();
                            View v3 = m06.v();
                            Intrinsics.checkNotNullExpressionValue(v3, "popupWindow.contentView");
                            com.tencent.mobileqq.wink.editor.sticker.f.p(v3);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(WinkEditorStickerTimelinePart this$0, b bVar) {
        boolean z16;
        VideoTrackContainerView videoTrackContainerView;
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.curStickerModelId = bVar.d();
        w53.b.a(this$0.TAG, "initClipObserver, clipStickerUid = " + bVar.d());
        dr H9 = this$0.H9();
        if (H9 != null && (m3 = H9.m()) != null && (winkStickerModel = m3.get(this$0.curStickerModelId)) != null) {
            WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, true, 0.0f, 0.0f, null, false, -1, 1015807, null);
            copyAndUpdate$default.setTimeRangeChangedByUser(true);
            copyAndUpdate$default.setStickerTrackerResult(winkStickerModel.getStickerTrackerResult());
            copyAndUpdate$default.setTraceSticker(winkStickerModel.getIsTraceSticker());
            copyAndUpdate$default.setEntityName(winkStickerModel.getEntityName());
            dr H92 = this$0.H9();
            if (H92 != null) {
                dr.b.n(H92, copyAndUpdate$default, false, 2, null);
            }
        }
        if (this$0.nowTimeProgress > bVar.getStartTime() && this$0.nowTimeProgress < bVar.getEndTime()) {
            z16 = false;
        } else {
            z16 = true;
        }
        VideoTrackContainerView videoTrackContainerView2 = this$0.videoTrack;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        } else {
            videoTrackContainerView = videoTrackContainerView2;
        }
        videoTrackContainerView.Z(bVar.getStartTime(), bVar.getEndTime(), z16);
        this$0.broadcastMessage("ARGS_SWITCH_STICKER_IN_TIMELINE_SETTING", bVar.d());
        this$0.Rb(bVar.getStartTime(), bVar.getEndTime());
        this$0.ic();
    }

    private final void nb() {
        this.panelController = new TimelinePanelViewController();
        this.timeBarViewController = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a();
        boolean c16 = uq3.k.b().c(QQWinkConstants.MMKV_TEMPLATE_RENDER_MODEL_THUMBNAIL_KEY, true);
        if (G9().getIsFromTemplateColl() && c16) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l ob5 = ob();
            this.videoTrackController = ob5;
            if (ob5 == null) {
                this.videoTrackController = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
            }
        } else {
            this.videoTrackController = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
        }
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
            Intrinsics.checkNotNull(lVar);
            timelinePanelViewController.h(lVar);
        }
    }

    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l ob() {
        try {
            dr H9 = H9();
            Intrinsics.checkNotNull(H9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
            WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9;
            String D = WinkExportUtils.D(winkVideoTavCut.getTemplatePath());
            LAKRenderModel u16 = winkVideoTavCut.u1();
            if (u16 != null && !TextUtils.isEmpty(D)) {
                RenderModelThumbnailProviderImpl renderModelThumbnailProviderImpl = this.provider;
                long durationUs = winkVideoTavCut.getDurationUs();
                Intrinsics.checkNotNull(D);
                RenderModelThumbnailProviderImpl.l(renderModelThumbnailProviderImpl, u16, durationUs, D, null, null, 24, null);
                return new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(this.provider);
            }
            return null;
        } catch (Exception e16) {
            ms.a.c(this.TAG, "init videoTrackController exception " + e16);
            return null;
        }
    }

    @RequiresApi(17)
    private final void pb() {
        MutableLiveData<Long> m26;
        MutableLiveData<VideoTrackData> B2;
        MutableLiveData<Long> A2;
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null && (A2 = timelineViewModelV2.A2()) != null) {
            A2.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.as
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorStickerTimelinePart.qb(WinkEditorStickerTimelinePart.this, ((Long) obj).longValue());
                }
            });
        }
        TimelineViewModelV2 timelineViewModelV22 = this.timelineViewModel;
        if (timelineViewModelV22 != null && (B2 = timelineViewModelV22.B2()) != null) {
            B2.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.at
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorStickerTimelinePart.rb(WinkEditorStickerTimelinePart.this, (VideoTrackData) obj);
                }
            });
        }
        TimelineViewModelV2 timelineViewModelV23 = this.timelineViewModel;
        if (timelineViewModelV23 != null && (m26 = timelineViewModelV23.m2()) != null) {
            m26.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.au
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorStickerTimelinePart.sb(WinkEditorStickerTimelinePart.this, ((Long) obj).longValue());
                }
            });
        }
        hb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qb(WinkEditorStickerTimelinePart this$0, long j3) {
        long j16;
        List<b> c16;
        int y16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
        if (timelineViewModelV2 != null) {
            long T1 = timelineViewModelV2.T1();
            TimelinePanelViewController timelinePanelViewController = this$0.panelController;
            if (timelinePanelViewController != null) {
                timelinePanelViewController.y(T1);
            }
        }
        TimelinePanelViewController timelinePanelViewController2 = this$0.panelController;
        if (timelinePanelViewController2 != null) {
            timelinePanelViewController2.C(j3);
        }
        dr H9 = this$0.H9();
        if (H9 != null) {
            j16 = H9.getCurrentPlayUs();
        } else {
            j16 = 0;
        }
        QLog.i("Sticker TAG", 1, "video source duration changed, current player time = " + j16);
        TextView textView = this$0.timeText;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            long j17 = 1000;
            String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(j16 / j17), com.tencent.mobileqq.wink.editor.music.a.c(j3 / j17)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
        TimelinePanel timelinePanel = this$0.timelinePanel;
        if (timelinePanel != null) {
            timelinePanel.setEnableScale(false);
        }
        TimelinePanelViewController timelinePanelViewController3 = this$0.panelController;
        if (timelinePanelViewController3 != null && (y16 = timelinePanelViewController3.getScaleCalculator().y(j3)) != 0) {
            timelinePanelViewController3.u((com.tencent.videocut.utils.o.g() - (com.tencent.videocut.utils.e.f384236a.a(40.0f) * 2)) / y16);
        }
        hc(this$0, j16, false, 2, null);
        c cVar = this$0.stickerListViewAdapter;
        if (cVar != null && (c16 = cVar.c()) != null) {
            int i3 = 0;
            for (Object obj : c16) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                b bVar = (b) obj;
                if (bVar.getEndTime() > j3) {
                    bVar.h(j3);
                }
                i3 = i16;
            }
        }
        if (this$0.needRefreshSourceDuration) {
            VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
            if (videoTrackContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            }
            videoTrackContainerView.e0(0L, j3);
            this$0.needRefreshSourceDuration = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(WinkEditorStickerTimelinePart this$0, VideoTrackData videoTrackData) {
        long j3;
        long j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ClipModel> a16 = videoTrackData.a();
        List<Object> b16 = videoTrackData.b();
        if (this$0.G9().getIsFromTemplateColl()) {
            if (!a16.isEmpty()) {
                ClipModel clipModel = a16.get(0);
                TimeData timeData = a16.get(0).getTimeData();
                TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
                Intrinsics.checkNotNull(timelineViewModelV2);
                long z26 = timelineViewModelV2.z2();
                TimelineViewModelV2 timelineViewModelV22 = this$0.timelineViewModel;
                Intrinsics.checkNotNull(timelineViewModelV22);
                long z27 = timelineViewModelV22.z2();
                TimelineViewModelV2 timelineViewModelV23 = this$0.timelineViewModel;
                Intrinsics.checkNotNull(timelineViewModelV23);
                ClipModel b17 = ClipModel.b(clipModel, null, 0, null, TimeData.d(timeData, 0L, timelineViewModelV23.z2(), z27, z26, 0L, 0L, 0L, 113, null), null, 23, null);
                ArrayList arrayList = new ArrayList();
                arrayList.add(b17);
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this$0.videoTrackController;
                if (lVar != null) {
                    lVar.K(arrayList, b16);
                }
            }
        } else {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar2 = this$0.videoTrackController;
            if (lVar2 != null) {
                lVar2.K(a16, b16);
            }
        }
        ReorderContainerView reorderContainerView = this$0.reorderContainerView;
        if (reorderContainerView != null) {
            reorderContainerView.T(a16);
        }
        if (this$0.needRefreshVideoTrack) {
            VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
            VideoTrackContainerView videoTrackContainerView2 = null;
            if (videoTrackContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            }
            dr H9 = this$0.H9();
            long j17 = 0;
            if (H9 != null) {
                j3 = H9.getDurationUs();
            } else {
                j3 = 0;
            }
            videoTrackContainerView.setRecordControlWidth(j3);
            VideoTrackContainerView videoTrackContainerView3 = this$0.videoTrack;
            if (videoTrackContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView3 = null;
            }
            VideoTrackContainerView videoTrackContainerView4 = this$0.videoTrack;
            if (videoTrackContainerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView4 = null;
            }
            Pair<Long, Boolean> value = videoTrackContainerView4.F().getValue();
            if (value != null) {
                j16 = value.getFirst().longValue();
            } else {
                j16 = 0;
            }
            VideoTrackContainerView videoTrackContainerView5 = this$0.videoTrack;
            if (videoTrackContainerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            } else {
                videoTrackContainerView2 = videoTrackContainerView5;
            }
            Pair<Long, Boolean> value2 = videoTrackContainerView2.K().getValue();
            if (value2 != null) {
                j17 = value2.getFirst().longValue();
            }
            videoTrackContainerView3.e0(j16, j17);
            this$0.needRefreshVideoTrack = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(WinkEditorStickerTimelinePart this$0, long j3) {
        com.tencent.mobileqq.wink.editor.sticker.control.c cVar;
        float f16;
        i63.b scaleCalculator;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("Sticker TAG", 1, "current player time = " + j3);
        TextView textView = this$0.timeText;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            long j16 = 1000;
            TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
            Intrinsics.checkNotNull(timelineViewModelV2);
            String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(j3 / j16), com.tencent.mobileqq.wink.editor.music.a.c(timelineViewModelV2.j2() / j16)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
        TimelineViewModelV2 timelineViewModelV22 = this$0.timelineViewModel;
        if (timelineViewModelV22 == null || !timelineViewModelV22.W2()) {
            z16 = false;
        }
        if (z16 && (cVar = this$0.cursorHandler) != null) {
            TimelinePanelViewController timelinePanelViewController = this$0.panelController;
            if (timelinePanelViewController != null && (scaleCalculator = timelinePanelViewController.getScaleCalculator()) != null) {
                f16 = scaleCalculator.y(j3);
            } else {
                f16 = 0.0f;
            }
            cVar.e(f16);
        }
    }

    @RequiresApi(21)
    private final void tb() {
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null) {
            if (timelinePanelViewController != null) {
                TimelinePanel timelinePanel = this.timelinePanel;
                Intrinsics.checkNotNull(timelinePanel);
                timelinePanelViewController.j(timelinePanel);
            }
            CommonConfig commonConfig = new CommonConfig(new ScrollConfig(0.0f, 1, null), new LayoutConfig(com.tencent.videocut.utils.e.f384236a.a(40.0f), 0.0f, 0.0f, 0.0f, 0.0f, 0, 62, null), VideoTrackConfig.f(new VideoTrackConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 511, null), 0.0f, 58.0f, 35.6f, 0.0f, 0.0f, 0.0f, false, false, false, 433, null), new TimeBarConfig(0.0f, 0.0f, 3, null));
            TimelinePanelViewController timelinePanelViewController2 = this.panelController;
            if (timelinePanelViewController2 != null) {
                timelinePanelViewController2.w(commonConfig);
            }
            TimelinePanelViewController timelinePanelViewController3 = this.panelController;
            if (timelinePanelViewController3 != null) {
                timelinePanelViewController3.r();
            }
        }
    }

    private final void ub() {
        ReorderContainerView reorderContainerView = this.reorderContainerView;
        Intrinsics.checkNotNull(reorderContainerView);
        reorderContainerView.P(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
    }

    private final void vb() {
        HorizontalListView horizontalListView = this.stickerListViewV2;
        if (horizontalListView != null) {
            horizontalListView.setOverScrollMode(2);
        }
        HorizontalListView horizontalListView2 = this.stickerListViewV2;
        if (horizontalListView2 != null) {
            horizontalListView2.setVisibility(0);
        }
        HorizontalListView horizontalListView3 = this.stickerListView;
        if (horizontalListView3 != null) {
            horizontalListView3.setVisibility(4);
        }
        HorizontalListView horizontalListView4 = this.stickerListViewV2;
        if (horizontalListView4 != null) {
            horizontalListView4.setAdapter((ListAdapter) this.stickerListViewAdapter);
        }
        HorizontalListView horizontalListView5 = this.stickerListViewV2;
        if (horizontalListView5 != null) {
            horizontalListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.am
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                    WinkEditorStickerTimelinePart.wb(WinkEditorStickerTimelinePart.this, adapterView, view, i3, j3);
                }
            });
        }
        c cVar = this.stickerListViewAdapter;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(WinkEditorStickerTimelinePart this$0, AdapterView adapterView, View view, int i3, long j3) {
        WinkStickerModel winkStickerModel;
        Map<String, WinkStickerModel> m3;
        String str;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vb(i3);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        dr H9 = this$0.H9();
        if (H9 != null && (m3 = H9.m()) != null) {
            c cVar = this$0.stickerListViewAdapter;
            if (cVar == null || (str = cVar.e(i3)) == null) {
                str = "";
            }
            winkStickerModel = m3.get(str);
        } else {
            winkStickerModel = null;
        }
        com.tencent.mobileqq.wink.editor.sticker.f.g(view, winkStickerModel);
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    private final void xb() {
        WinkEditData winkEditData;
        List<WinkEditData> n3;
        Object orNull;
        dr H9 = H9();
        if (H9 != null && (n3 = H9.n()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(n3, 0);
            winkEditData = (WinkEditData) orNull;
        } else {
            winkEditData = null;
        }
        if (H9 != null && winkEditData != null) {
            this.mediaClipsBackup = com.tencent.mobileqq.wink.editor.draft.c.t(winkEditData);
            this.transformModelsBackup = com.tencent.mobileqq.wink.editor.draft.c.s(winkEditData);
            if (!H9.G()) {
                ds.e((WinkVideoTavCut) H9, G9().getEnableImageTransition());
            }
            TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
            if (timelineViewModelV2 != null) {
                timelineViewModelV2.R2(H9, this.playerListener, this.renderListener);
            }
        }
        TimelineViewModelV2 timelineViewModelV22 = this.timelineViewModel;
        if (timelineViewModelV22 != null) {
            dr H92 = H9();
            Intrinsics.checkNotNull(H92, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
            timelineViewModelV22.D3(((WinkVideoTavCut) H92).F1());
        }
        dr H93 = H9();
        if (H93 != null) {
            hc(this, H93.getCurrentPlayUs(), false, 2, null);
        }
    }

    private final void yb() {
        TimeBarView timeBarView = new TimeBarView(getContext(), null, 0, 6, null);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(20.0f));
        layoutParams.topMargin = eVar.a(12.0f);
        timeBarView.setLayoutParams(layoutParams);
        timeBarView.setMaxDurationLimit(WinkConfig.f317649a.b());
        Activity activity = getActivity();
        if (activity != null) {
            String string = activity.getString(R.string.f215355vd);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ink_cut_max_duration_tip)");
            timeBarView.setMaxDurationLimitTip(string);
        }
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.a aVar = this.timeBarViewController;
        if (aVar != null) {
            aVar.g(timeBarView);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f88434x2;
    }

    public final boolean Hb() {
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getContext().getString(R.string.f216455yc)).setPositiveButton(getContext().getString(R.string.f216445yb), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorStickerTimelinePart.Ib(WinkEditorStickerTimelinePart.this, dialogInterface, i3);
            }
        }).setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.aq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorStickerTimelinePart.Jb(dialogInterface, i3);
            }
        });
        if (negativeButton != null) {
            try {
                if (!negativeButton.isShowing()) {
                    negativeButton.show();
                    return true;
                }
                return true;
            } catch (Throwable th5) {
                ms.a.e("WinkEditorFragment", th5);
                return true;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h
    public void Jc(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g event) {
        TimelineViewModelV2 timelineViewModelV2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) {
            TimelineViewModelV2 timelineViewModelV22 = this.timelineViewModel;
            if (timelineViewModelV22 != null) {
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i iVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) event;
                timelineViewModelV22.a3(iVar.getData(), iVar.getIsOutCalled());
                return;
            }
            return;
        }
        if (!(event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.m)) {
            if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) {
                TimelineViewModelV2 timelineViewModelV23 = this.timelineViewModel;
                if (timelineViewModelV23 != null) {
                    View partRootView = getPartRootView();
                    Intrinsics.checkNotNull(partRootView);
                    timelineViewModelV23.P2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) event, false, partRootView);
                    return;
                }
                return;
            }
            if (!(event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.b) && !(event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.o) && !(event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j)) {
                if ((event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l) && (timelineViewModelV2 = this.timelineViewModel) != null) {
                    timelineViewModelV2.b3();
                    return;
                }
                return;
            }
            TimelineViewModelV2 timelineViewModelV24 = this.timelineViewModel;
            if (timelineViewModelV24 != null) {
                timelineViewModelV24.J2();
            }
        }
    }

    public final boolean Kb() {
        if (this.timelineViewModel == null || !this.visible) {
            return true;
        }
        return this.needReplay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        final WinkVideoTavCut winkVideoTavCut;
        String str;
        PanelEventHandler panelEventHandler;
        ViewTreeObserver viewTreeObserver;
        super.L9(args);
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            if (this.showGlobalLayoutListener == null) {
                this.showGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ad
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        WinkEditorStickerTimelinePart.Ob(WinkVideoTavCut.this, this);
                    }
                };
            }
            FrameLayout currentPlayerViewContainer = winkVideoTavCut.getCurrentPlayerViewContainer();
            if (currentPlayerViewContainer != null && (viewTreeObserver = currentPlayerViewContainer.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(this.showGlobalLayoutListener);
            }
            WinkEditorMenuPart.sa(this, this.timelineMenuHeight, 0, 2, null);
        }
        xb();
        this.isFirstInto = true;
        Wb(args);
        vb();
        if (args == null || (str = args.getString("ARGS_STICKER_ID")) == null) {
            str = "";
        }
        bc(str);
        this.isFirstInto = false;
        this.needRefreshVideoTrack = true;
        this.needRefreshSourceDuration = true;
        this.isShowTTSPopWindow = false;
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null && (panelEventHandler = timelinePanelViewController.getPanelEventHandler()) != null) {
            panelEventHandler.b(this, new Function1<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerTimelinePart$onShow$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g gVar) {
                    return Boolean.valueOf((gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.f) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l));
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.STICKER_TIMELINE;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        List<b> c16;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "ARGS_STICKER_ID") && (args instanceof String)) {
            c cVar = this.stickerListViewAdapter;
            int i3 = -1;
            if (cVar != null && (c16 = cVar.c()) != null) {
                int i16 = 0;
                for (Object obj : c16) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((b) obj).d(), args)) {
                        i3 = i16;
                    }
                    i16 = i17;
                }
            }
            Vb(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @RequiresApi(api = 21)
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        initViewModel();
        nb();
        Fb(rootView);
        pb();
        this.timelineMenuHeight = getContext().getResources().getDimensionPixelSize(R.dimen.djq);
        this.isFirstInto = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            ImageView imageView = this.cancelBtn;
            if (imageView != null) {
                imageView.performClick();
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.visible) {
            Qb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver;
        PanelEventHandler panelEventHandler;
        if (this.showStickerMenuPart) {
            this.showStickerMenuPart = false;
            return;
        }
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null && (panelEventHandler = timelinePanelViewController.getPanelEventHandler()) != null) {
            panelEventHandler.c(this);
        }
        dr H9 = H9();
        Intrinsics.checkNotNull(H9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
        final WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9;
        if (this.hideGlobalLayoutListener == null) {
            this.hideGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ao
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    WinkEditorStickerTimelinePart.Nb(WinkVideoTavCut.this, this);
                }
            };
        }
        FrameLayout currentPlayerViewContainer = winkVideoTavCut.getCurrentPlayerViewContainer();
        if (currentPlayerViewContainer != null && (viewTreeObserver = currentPlayerViewContainer.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this.hideGlobalLayoutListener);
        }
        qa();
        super.onDismiss();
        dr H92 = H9();
        if (H92 != null) {
            H92.removePlayerListener(this.playerListener);
        }
        dr H93 = H9();
        if (H93 != null) {
            H93.Q(this.renderListener);
        }
        dr H94 = H9();
        if (H94 != null) {
            H94.play();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
        if (lVar != null) {
            lVar.F();
        }
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(2, 100));
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null) {
            timelineViewModelV2.d3();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null && timelineViewModelV2.W2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.needReplay = true;
            TimelineViewModelV2 timelineViewModelV22 = this.timelineViewModel;
            if (timelineViewModelV22 != null) {
                timelineViewModelV22.b3();
                return;
            }
            return;
        }
        this.needReplay = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        TimelineViewModelV2 timelineViewModelV2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (this.needReplay && (timelineViewModelV2 = this.timelineViewModel) != null) {
            timelineViewModelV2.c3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void pa() {
        dr H9;
        super.pa();
        if (H9() != null && (H9 = H9()) != null) {
            H9.flush(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/control/WinkEditorStickerTimelinePart$f", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ISessionListener {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        
            if (r3.q2() == true) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void b(WinkEditorStickerTimelinePart this$0, LAKRenderModel newData) {
            boolean z16;
            TimelineViewModelV2 timelineViewModelV2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            this$0.Pb();
            TimelineViewModelV2 timelineViewModelV22 = this$0.timelineViewModel;
            if (timelineViewModelV22 != null) {
                timelineViewModelV22.D3(newData.getTimeLines());
            }
            TimelineViewModelV2 timelineViewModelV23 = this$0.timelineViewModel;
            if (timelineViewModelV23 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16 && (timelineViewModelV2 = this$0.timelineViewModel) != null) {
                timelineViewModelV2.l3(false);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorStickerTimelinePart winkEditorStickerTimelinePart = WinkEditorStickerTimelinePart.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.ba
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorStickerTimelinePart.f.b(WinkEditorStickerTimelinePart.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jb(DialogInterface dialogInterface, int i3) {
    }
}
