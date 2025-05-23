package com.tencent.tavcut.core.session;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.JsonObject;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher;
import com.tencent.tavcut.core.dataprocessor.a;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.operator.ClipSourceOperator;
import com.tencent.tavcut.core.operator.IClipSourceOperator;
import com.tencent.tavcut.core.operator.d;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.RenderNodeConfigurator;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.LightEntityTransHelper;
import com.tencent.tavcut.core.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.builder.light.model.TextPlaceInfo;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.properties.Layout;
import com.tencent.tavcut.core.render.builder.light.model.properties.Properties;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import com.tencent.tavcut.core.render.font.FontCacheManager;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.player.CutWrapperPlayer;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.tavcut.core.utils.CutSessionThreadUtils;
import com.tencent.tavcut.core.utils.DelayTimer;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.LightAsset;
import org.light.MaterialConfig;
import org.light.MovieController;
import org.light.TemplateConfig;
import org.light.TimeRange;
import org.light.WatermarkConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetUtils;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.FilterGroup;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.Vec3;
import org.light.lightAssetKit.enums.AudioSourceType;
import org.light.lightAssetKit.enums.BackgroundFillMode;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnLoadAssetListener;
import rd4.c;
import sd4.b;
import td4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0002\u0093\u0002\u0018\u0000 \u0099\u00022\u00020\u00012\u00020\u0002:\u0006\u0099\u0002\u009a\u0002\u009b\u0002B\u0017\b\u0016\u0012\n\u0010\u00f5\u0001\u001a\u0005\u0018\u00010\u00f4\u0001\u00a2\u0006\u0006\b\u0096\u0002\u0010\u0097\u0002B\u000b\b\u0016\u00a2\u0006\u0006\b\u0096\u0002\u0010\u0098\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J(\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J*\u0010\u001e\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u001f\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J*\u0010 \u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010!\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0002J\u0016\u0010%\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J0\u00100\u001a\u00020\t2\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0+0\u001a2\u0006\u0010/\u001a\u00020\tH\u0002JB\u0010;\u001a\u00020\u00072\u0006\u00101\u001a\u00020,2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00112\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`72\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\b\u0010=\u001a\u00020\"H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>H\u0016J\u0012\u0010A\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010B\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0016J\u0012\u0010C\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020DH\u0016J\u0018\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0013H\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J\b\u0010I\u001a\u00020DH\u0016J\b\u0010J\u001a\u00020DH\u0016J\b\u0010K\u001a\u00020\u0011H\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J\u0018\u0010P\u001a\u00020\u00072\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020\u0013H\u0016J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016J\n\u0010T\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010V\u001a\u0004\u0018\u00010M2\u0006\u0010U\u001a\u00020,H\u0016J\u0012\u0010W\u001a\u0004\u0018\u00010M2\u0006\u0010U\u001a\u00020,H\u0016J\u0018\u0010Y\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010X\u001a\u00020\tH\u0016J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010X\u001a\u00020\tH\u0016J \u0010[\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010]\u001a\u00020\\2\u0006\u0010X\u001a\u00020\tH\u0016J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010X\u001a\u00020\tH\u0016J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010a\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010X\u001a\u00020\tH\u0016J\u0018\u0010b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010X\u001a\u00020\tH\u0016J\u0018\u0010d\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010c\u001a\u00020\u0013H\u0016J\u0018\u0010e\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010c\u001a\u00020\u0013H\u0016J&\u0010j\u001a\b\u0012\u0004\u0012\u00020\"0\u001a\"\b\b\u0000\u0010g*\u00020f2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000hH\u0016J\u0010\u0010k\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010l\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010p\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020,2\b\u0010o\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010r\u001a\u00020\u00072\u0006\u0010:\u001a\u00020qH\u0016J\u0010\u0010s\u001a\u00020\u00072\u0006\u0010:\u001a\u00020qH\u0016J\u0010\u0010u\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\tH\u0016J\u0018\u0010l\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010w\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u0005H\u0016J\u001a\u0010w\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00052\b\u0010y\u001a\u0004\u0018\u00010xH\u0016J\u0010\u0010|\u001a\u00020\u00072\u0006\u0010{\u001a\u00020zH\u0016J\u0010\u0010}\u001a\u00020\u00072\u0006\u0010{\u001a\u00020zH\u0016J\b\u0010\u007f\u001a\u00020~H\u0016J\u0013\u0010\u0082\u0001\u001a\u00020\u00072\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020\u00072\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0016J+\u0010\u0086\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t05j\b\u0012\u0004\u0012\u00020\t`72\u0007\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0085\u0001\u001a\u00020\u0005H\u0016J\u001e\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0085\u0001\u001a\u00020\u0005H\u0016J\u001b\u0010\u008a\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010\u001a2\u0007\u0010\u0089\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u00010>H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0016J+\u0010\u0091\u0001\u001a\u00020\u00072\u000e\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010\u001a2\u0007\u0010\u008f\u0001\u001a\u00020\u00132\u0007\u0010\u0090\u0001\u001a\u00020\u0013H\u0016J\"\u0010\u0092\u0001\u001a\u00020\u00072\u000e\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010\u001a2\u0007\u0010\u008f\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0007H\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J$\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020,2\u0007\u0010\u0096\u0001\u001a\u00020,H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0007H\u0016J\u0019\u0010\u0099\u0001\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0011H\u0016J\u0010\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u0013J\u001b\u0010\u00a2\u0001\u001a\u00020\u00072\u0010\u0010\u00a1\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00a0\u0001\u0018\u00010\u001aH\u0016J\n\u0010\u00a4\u0001\u001a\u00030\u00a3\u0001H\u0016J\u001a\u0010\u00a6\u0001\u001a\u00020\u00072\u0007\u0010y\u001a\u00030\u00a5\u00012\u0006\u0010c\u001a\u00020\u0013H\u0016J9\u0010\u00ab\u0001\u001a\u00020\u00072\u0007\u0010\u00a7\u0001\u001a\u00020,2%\u0010\u00aa\u0001\u001a \u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0\u00a8\u0001j\u000f\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,`\u00a9\u0001H\u0016J\u001d\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u00ac\u0001\u001a\u00020,H\u0016\u00a2\u0006\u0006\b\u00ad\u0001\u0010\u00ae\u0001J\u001e\u0010\u00b1\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u00b0\u0001\u0018\u00010\u00af\u0001H\u0016\u00a2\u0006\u0006\b\u00b1\u0001\u0010\u00b2\u0001J\u0012\u0010\u00b4\u0001\u001a\u00020\u00072\u0007\u0010\u00b3\u0001\u001a\u00020,H\u0016J\u0012\u0010\u00b6\u0001\u001a\u00020\u00072\u0007\u0010{\u001a\u00030\u00b5\u0001H\u0016J\u001d\u0010\u00bb\u0001\u001a\u00020\t2\b\u0010\u00b8\u0001\u001a\u00030\u00b7\u00012\b\u0010\u00ba\u0001\u001a\u00030\u00b9\u0001H\u0016J?\u0010\u00bc\u0001\u001a\u00020\u00132\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u000206\u0018\u000105j\n\u0012\u0004\u0012\u000206\u0018\u0001`72\u0006\u00101\u001a\u00020,2\u0006\u0010#\u001a\u00020\"2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u001a\u0010\u00bf\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\t\u0010\u00be\u0001\u001a\u0004\u0018\u00010\"H\u0016J\u000f\u0010\u00c0\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u001aH\u0016J\u0012\u0010\u00c2\u0001\u001a\u00020\u00072\u0007\u0010{\u001a\u00030\u00c1\u0001H\u0016J\u0013\u0010\u00c3\u0001\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0011\u0010\u00c4\u0001\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u0005H\u0016J\u0012\u0010\u00c6\u0001\u001a\u00020\u00052\u0007\u0010\u00c5\u0001\u001a\u00020\u0005H\u0016J\u0019\u0010\u00c7\u0001\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\t2\u0006\u0010v\u001a\u00020\u0005H\u0016J\u0012\u0010\u00c9\u0001\u001a\u00020\u00072\u0007\u0010\u00c8\u0001\u001a\u00020\u0013H\u0016J\u0014\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0006\b\u00ca\u0001\u0010\u00cb\u0001J\f\u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00cc\u0001H\u0016J\u0012\u0010\u00cf\u0001\u001a\u00020\u00132\u0007\u0010\u00ce\u0001\u001a\u00020fH\u0016J\u000b\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010\u00d1\u0001\u001a\u00020\u0007H\u0016J\f\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00d2\u0001H\u0016J\u0010\u0010\u00d5\u0001\u001a\u00020\u00072\u0007\u0010\u00d4\u0001\u001a\u00020\u0013J\u0010\u0010\u00d7\u0001\u001a\u00020\u00072\u0007\u0010{\u001a\u00030\u00d6\u0001J\u0018\u0010\u00d9\u0001\u001a\u00020\u00072\r\u0010\u00d8\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070-H\u0016J%\u0010\u00dc\u0001\u001a\u00020\u00072\u001a\u0010\u00d8\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00da\u0001\u00a2\u0006\u0003\b\u00db\u0001H\u0016J%\u0010\u00dd\u0001\u001a\u00020\u00072\u001a\u0010\u00d8\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u00da\u0001\u00a2\u0006\u0003\b\u00db\u0001H\u0016J\u0015\u0010\u00df\u0001\u001a\u00020\u00072\n\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00de\u0001H\u0016R+\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\n\u001a\u0004\u0018\u00010>8\u0002@BX\u0082\u000e\u00a2\u0006\u000f\n\u0005\b?\u0010\u00e0\u0001\"\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u001c\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e4\u0001\u0010\u00e5\u0001R\u001c\u0010\u00e6\u0001\u001a\u0005\u0018\u00010\u00c1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u00e7\u0001R\u001b\u0010\u00e8\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001R\u001a\u0010\u00eb\u0001\u001a\u00030\u00ea\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001R\u001e\u0010\u00ee\u0001\u001a\t\u0012\u0004\u0012\u00020z0\u00ed\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u0017\u0010\u00f0\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f0\u0001\u0010\u00f1\u0001R\u0018\u0010\u00f2\u0001\u001a\u00030\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f2\u0001\u0010\u00f3\u0001R\u001c\u0010\u00f5\u0001\u001a\u0005\u0018\u00010\u00f4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001R\u001c\u0010\u00f7\u0001\u001a\u0005\u0018\u00010\u00d6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f7\u0001\u0010\u00f8\u0001R\u0018\u0010\u00fa\u0001\u001a\u00030\u00f9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00fa\u0001\u0010\u00fb\u0001R0\u0010\u00fd\u0001\u001a\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0+0\u00fc\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00fe\u0001R\u0018\u0010\u0080\u0002\u001a\u00030\u00ff\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R%\u0010\u0087\u0002\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0086\u00020\u0085\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0019\u0010\u0089\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001e\u0010\u008b\u0002\u001a\t\u0012\u0005\u0012\u00030\u00a0\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001a\u0010\u008e\u0002\u001a\u00030\u008d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u0017\u0010\u0090\u0002\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0019\u0010\u0092\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0002\u0010\u008a\u0002R\u0018\u0010\u0094\u0002\u001a\u00030\u0093\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0002\u0010\u0095\u0002\u00a8\u0006\u009c\u0002"}, d2 = {"Lcom/tencent/tavcut/core/session/LAKCutSession;", "Lcom/tencent/tavcut/core/session/ICutSession;", "Lcom/tencent/tavcut/core/dataprocessor/a;", "Lorg/light/lightAssetKit/components/Size;", "renderSize", "", "fillScale", "", "updateRenderModelSize", "", "value", "Lorg/light/lightAssetKit/enums/BackgroundFillMode;", "fromValue", "Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "backGround", "updatePainting", "getMultiMediaSize", "", "targetTime", "", "isInit", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "cutStatusCallback", "updatePlayer", "notifyRenderDataChanged", "getMediaDuration", "", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "commands", "needFlushPlayer", "splitCommandAndFlush", "printFlushedCommands", "internalFlush", "checkReload", "Lorg/light/lightAssetKit/Entity;", "entity", "checkEntityModifyNeedReload", "flushCommand", "reloadAssets", "clearFlags", "registerRenderRunnable", "notifyRenderDataApplied", "runUpdatePlayerEvents", "Lkotlin/Pair;", "", "Lkotlin/Function0;", TtmlNode.ATTR_TTS_ORIGIN, "startIndex", "consumeEvent", "stickerName", "Lorg/light/lightAssetKit/components/ScreenTransform;", "stickerTransform", "time", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "callback", "updateStickerPosition", "createFilterGroupEntity", "createEmptyEntity", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "player", "bindPlayer", "unbindPlayer", "bindCutPlayer", "unbindCutPlayer", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "LAKRenderModel", "setRenderModel", "needInitTemplate", "setDedaultRenderModel", "getRenderModel", "getAllInputSourceRenderModel", "getTotalDurationUs", "getClipAssetsDurationUs", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "needReloadAsset", "addInputSource", "Lorg/light/lightAssetKit/LightAssetDataContext;", "getLightAssetDataContext", "Lcom/google/gson/JsonObject;", "getInputSources", "sourceKey", "accessInputSource", "removeInputSource", "index", "addVideoSourceEntity", "addVideoSourceEntityAfterLutFilter", "addEffect", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityType", "addClipEffect", "setTransition", "addBgm", "addHDR", "addRenderTarget", "enable", "switchEntity", "switchEntitySync", "Lorg/light/lightAssetKit/components/Component;", "T", "Lkotlin/reflect/KClass;", "clazz", "queryEntityByComponent", "removeEntity", "updateRenderSize", "backgroundFillMode", "backColor", Constants.PAG_FILE_PATH, "updateBackground", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "addRenderCallback", "removeRenderCallback", "bgColor", "setBgColor", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "updateVolume", "Lorg/light/lightAssetKit/enums/AudioSourceType;", "type", "Lcom/tencent/tavcut/core/session/ISessionListener;", "listener", "addSessionListener", "removeSessionListener", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "getClipSourceOperator", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "effectNode", "addRenderNode", "removeRenderNode", HippyTKDListViewAdapter.X, "y", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", "getEditableTextUnderPoint", TemplateParser.KEY_ENTITY_ID, "getEditableTextByEntityId", "getPlayer", "onInitSource", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clips", "modifyClipsDuration", "runInDefaultThread", "setClipAssets", "setClipAssetsWithCallback", "release", "fontFamily", "fontStyle", "fontPath", "registerFont", HippyQQPagView.FunctionName.FLUSH, "flushWithoutDelay", "emit", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "getFrameDuration", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "setSwitchReloadAsset", "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", DownloadInfo.spKey_Config, "onVoiceChangerUpdate", "Lcom/tencent/tavcut/core/operator/d;", "getComponentOperator", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "switchPicEnhanceAbility", "templatePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "setAssetData", "aiType", "needRenderAbility", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "Lorg/light/MaterialConfig;", "getMaterialConfig", "()[Lorg/light/MaterialConfig;", "path", "setTemplateDir", "Lorg/light/listener/OnLoadAssetListener;", "setLoadAssetListener", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Lsd4/b;", "stickerTrackerConfig", "createStickerTrackerManager", "updateTrackedStickerPosition", "queryEntityByEntityId", "rootEntity", "getAllTextEntity", "getAllImageStickerEntitys", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "setRenderTimeListener", "setCutStatusListener", "setOriginVolume", "defaultVolume", "getOriginVolume", "setOriginVolumeForClip", "isLimited", "setMediasTotalDurationLimitationFlag", "getMediasTotalDurationLimitationFlag", "()Ljava/lang/Boolean;", "Lorg/light/LightAsset;", "getLightAsset", HippyQQConstants.URL_COMPONENT_NAME, "componentSupportDynamicModify", "getRootEntity", "notifyReloadAsset", "Lorg/light/TemplateConfig;", "getMovieConfig", "isUseTemplateTime", "setIsUseTemplateTime", "Lorg/light/listener/OnClipAssetListener;", "setClipAssetListener", "runnable", "runOnPlayerThread", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "pushCustomCommand", "pushCustomCommandSync", "Lorg/light/WatermarkConfig;", "setWatermarkConfig", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "setPlayer", "(Lcom/tencent/tavcut/core/render/player/IPlayer;)V", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "playerRenderChainManager", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "renderTimeListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "cutStatusListener", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "dataDispatcher", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sessionListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "iClipSourceOperator", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "iComponentOperator", "Lcom/tencent/tavcut/core/operator/d;", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "customRenderConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "clipAssetListener", "Lorg/light/listener/OnClipAssetListener;", "Lcom/tencent/tavcut/core/render/RenderNodeConfigurator;", "renderNodeConfigurator", "Lcom/tencent/tavcut/core/render/RenderNodeConfigurator;", "Ljava/util/LinkedList;", "lazyUpdatePlayerEvents", "Ljava/util/LinkedList;", "Lcom/tencent/tavcut/core/utils/CutSessionThreadUtils;", "cutSessionThreader", "Lcom/tencent/tavcut/core/utils/CutSessionThreadUtils;", "Lcom/tencent/tavcut/core/utils/DelayTimer;", "renderDelayTimer", "Lcom/tencent/tavcut/core/utils/DelayTimer;", "", "Lcom/tencent/tavcut/core/session/LAKCutSession$StickerTrackedResult;", "trackedStickerResultMap", "Ljava/util/Map;", "isUseMovieControllerDuration", "Z", "voiceConfig", "Ljava/util/List;", "Lcom/tencent/tavcut/core/session/LAKCutSession$RenderChainManagerInitInfo;", "renderChainManagerInitInfo", "Lcom/tencent/tavcut/core/session/LAKCutSession$RenderChainManagerInitInfo;", "MAX_RELOAD_ASSET_TIME", "J", "switchReloadAsset", "com/tencent/tavcut/core/session/LAKCutSession$syncCutSession$1", "syncCutSession", "Lcom/tencent/tavcut/core/session/LAKCutSession$syncCutSession$1;", "<init>", "(Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;)V", "()V", "Companion", "RenderChainManagerInitInfo", "StickerTrackedResult", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class LAKCutSession implements ICutSession, a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long FLUSH_EVENT_DELAY_DURATION_MS = 5;
    public static final float LANDSCAPE_FILL_SCALE_LETTERBOX = 1000.0f;
    public static final float PORTRAIT_FILL_SCALE_LETTERBOX = 0.0f;
    private final long MAX_RELOAD_ASSET_TIME;
    private OnClipAssetListener clipAssetListener;
    private CustomRenderConfig customRenderConfig;
    private final CutSessionThreadUtils cutSessionThreader;
    private ICutStatusCallback cutStatusListener;
    private RenderDataDispatcher dataDispatcher;
    private final IClipSourceOperator iClipSourceOperator;
    private final d iComponentOperator;
    private boolean isUseMovieControllerDuration;
    private final LinkedList<Pair<String, Function0<Unit>>> lazyUpdatePlayerEvents;
    private IPlayer player;
    private IRenderChainManager playerRenderChainManager;
    private RenderChainManagerInitInfo renderChainManagerInitInfo;
    private final DelayTimer renderDelayTimer;
    private final RenderNodeConfigurator renderNodeConfigurator;
    private IRenderTimeListener renderTimeListener;
    private final CopyOnWriteArrayList<ISessionListener> sessionListenerList;
    private boolean switchReloadAsset;
    private final LAKCutSession$syncCutSession$1 syncCutSession;
    private final Map<String, StickerTrackedResult> trackedStickerResultMap;
    private final List<VoiceEnum> voiceConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "runnable", "invoke"}, k = 3, mv = {1, 1, 16})
    /* renamed from: com.tencent.tavcut.core.session.LAKCutSession$1 */
    /* loaded from: classes26.dex */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<Function0<? extends Unit>, Unit> {
        AnonymousClass1(CutSessionThreadUtils cutSessionThreadUtils) {
            super(1, cutSessionThreadUtils);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "runInBackground";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(CutSessionThreadUtils.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "runInBackground(Lkotlin/jvm/functions/Function0;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
            invoke2((Function0<Unit>) function0);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(@NotNull Function0<Unit> p16) {
            Intrinsics.checkParameterIsNotNull(p16, "p1");
            ((CutSessionThreadUtils) this.receiver).e(p16);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/core/session/LAKCutSession$Companion;", "", "()V", "FLUSH_EVENT_DELAY_DURATION_MS", "", "LANDSCAPE_FILL_SCALE_LETTERBOX", "", "PORTRAIT_FILL_SCALE_LETTERBOX", "createLAKCutSession", "Lcom/tencent/tavcut/core/session/ICutSession;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ICutSession createLAKCutSession() {
            return new LAKCutSession();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00122\b\u0002\u0010\u0014\u001a,\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\r\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0006\u00a2\u0006\u0004\b2\u00103J\u0019\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u00c6\u0003J3\u0010\n\u001a,\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\t\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u001f\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\rH\u00c6\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0006H\u00c6\u0003J\u009d\u0001\u0010\u0018\u001a\u00020\u00002\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u000422\b\u0002\u0010\u0014\u001a,\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\t\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\r2\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 RL\u0010\u0014\u001a,\u0012\u0004\u0012\u00020\u0007\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\t\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R8\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%\u00a8\u00064"}, d2 = {"Lcom/tencent/tavcut/core/session/LAKCutSession$RenderChainManagerInitInfo;", "", "Ljava/util/ArrayList;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "Lkotlin/collections/ArrayList;", "component1", "Lkotlin/Pair;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component2", "Lorg/light/listener/OnLoadAssetListener;", "component3", "Lkotlin/Triple;", "", "component4", "Lorg/light/lightAssetKit/components/Size;", "", "component5", "waitRenderCommands", "assetData", "onLoadAssetListener", "background", "renderSize", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "getWaitRenderCommands", "()Ljava/util/ArrayList;", "Lkotlin/Pair;", "getAssetData", "()Lkotlin/Pair;", "setAssetData", "(Lkotlin/Pair;)V", "Lorg/light/listener/OnLoadAssetListener;", "getOnLoadAssetListener", "()Lorg/light/listener/OnLoadAssetListener;", "setOnLoadAssetListener", "(Lorg/light/listener/OnLoadAssetListener;)V", "Lkotlin/Triple;", "getBackground", "()Lkotlin/Triple;", "setBackground", "(Lkotlin/Triple;)V", "getRenderSize", "setRenderSize", "<init>", "(Ljava/util/ArrayList;Lkotlin/Pair;Lorg/light/listener/OnLoadAssetListener;Lkotlin/Triple;Lkotlin/Pair;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final /* data */ class RenderChainManagerInitInfo {

        @Nullable
        private Pair<String, ? extends HashMap<String, String>> assetData;

        @Nullable
        private Triple<Integer, String, String> background;

        @Nullable
        private OnLoadAssetListener onLoadAssetListener;

        @Nullable
        private Pair<? extends Size, Float> renderSize;

        @NotNull
        private final ArrayList<RenderDataDispatcher.c> waitRenderCommands;

        public RenderChainManagerInitInfo() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ RenderChainManagerInitInfo copy$default(RenderChainManagerInitInfo renderChainManagerInitInfo, ArrayList arrayList, Pair pair, OnLoadAssetListener onLoadAssetListener, Triple triple, Pair pair2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                arrayList = renderChainManagerInitInfo.waitRenderCommands;
            }
            if ((i3 & 2) != 0) {
                pair = renderChainManagerInitInfo.assetData;
            }
            Pair pair3 = pair;
            if ((i3 & 4) != 0) {
                onLoadAssetListener = renderChainManagerInitInfo.onLoadAssetListener;
            }
            OnLoadAssetListener onLoadAssetListener2 = onLoadAssetListener;
            if ((i3 & 8) != 0) {
                triple = renderChainManagerInitInfo.background;
            }
            Triple triple2 = triple;
            if ((i3 & 16) != 0) {
                pair2 = renderChainManagerInitInfo.renderSize;
            }
            return renderChainManagerInitInfo.copy(arrayList, pair3, onLoadAssetListener2, triple2, pair2);
        }

        @NotNull
        public final ArrayList<RenderDataDispatcher.c> component1() {
            return this.waitRenderCommands;
        }

        @Nullable
        public final Pair<String, HashMap<String, String>> component2() {
            return this.assetData;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final OnLoadAssetListener getOnLoadAssetListener() {
            return this.onLoadAssetListener;
        }

        @Nullable
        public final Triple<Integer, String, String> component4() {
            return this.background;
        }

        @Nullable
        public final Pair<Size, Float> component5() {
            return this.renderSize;
        }

        @NotNull
        public final RenderChainManagerInitInfo copy(@NotNull ArrayList<RenderDataDispatcher.c> waitRenderCommands, @Nullable Pair<String, ? extends HashMap<String, String>> assetData, @Nullable OnLoadAssetListener onLoadAssetListener, @Nullable Triple<Integer, String, String> background, @Nullable Pair<? extends Size, Float> renderSize) {
            Intrinsics.checkParameterIsNotNull(waitRenderCommands, "waitRenderCommands");
            return new RenderChainManagerInitInfo(waitRenderCommands, assetData, onLoadAssetListener, background, renderSize);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof RenderChainManagerInitInfo) {
                    RenderChainManagerInitInfo renderChainManagerInitInfo = (RenderChainManagerInitInfo) other;
                    if (!Intrinsics.areEqual(this.waitRenderCommands, renderChainManagerInitInfo.waitRenderCommands) || !Intrinsics.areEqual(this.assetData, renderChainManagerInitInfo.assetData) || !Intrinsics.areEqual(this.onLoadAssetListener, renderChainManagerInitInfo.onLoadAssetListener) || !Intrinsics.areEqual(this.background, renderChainManagerInitInfo.background) || !Intrinsics.areEqual(this.renderSize, renderChainManagerInitInfo.renderSize)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final Pair<String, HashMap<String, String>> getAssetData() {
            return this.assetData;
        }

        @Nullable
        public final Triple<Integer, String, String> getBackground() {
            return this.background;
        }

        @Nullable
        public final OnLoadAssetListener getOnLoadAssetListener() {
            return this.onLoadAssetListener;
        }

        @Nullable
        public final Pair<Size, Float> getRenderSize() {
            return this.renderSize;
        }

        @NotNull
        public final ArrayList<RenderDataDispatcher.c> getWaitRenderCommands() {
            return this.waitRenderCommands;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            int i18;
            ArrayList<RenderDataDispatcher.c> arrayList = this.waitRenderCommands;
            int i19 = 0;
            if (arrayList != null) {
                i3 = arrayList.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = i3 * 31;
            Pair<String, ? extends HashMap<String, String>> pair = this.assetData;
            if (pair != null) {
                i16 = pair.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 31;
            OnLoadAssetListener onLoadAssetListener = this.onLoadAssetListener;
            if (onLoadAssetListener != null) {
                i17 = onLoadAssetListener.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 31;
            Triple<Integer, String, String> triple = this.background;
            if (triple != null) {
                i18 = triple.hashCode();
            } else {
                i18 = 0;
            }
            int i29 = (i28 + i18) * 31;
            Pair<? extends Size, Float> pair2 = this.renderSize;
            if (pair2 != null) {
                i19 = pair2.hashCode();
            }
            return i29 + i19;
        }

        public final void setAssetData(@Nullable Pair<String, ? extends HashMap<String, String>> pair) {
            this.assetData = pair;
        }

        public final void setBackground(@Nullable Triple<Integer, String, String> triple) {
            this.background = triple;
        }

        public final void setOnLoadAssetListener(@Nullable OnLoadAssetListener onLoadAssetListener) {
            this.onLoadAssetListener = onLoadAssetListener;
        }

        public final void setRenderSize(@Nullable Pair<? extends Size, Float> pair) {
            this.renderSize = pair;
        }

        @NotNull
        public String toString() {
            return "RenderChainManagerInitInfo(waitRenderCommands=" + this.waitRenderCommands + ", assetData=" + this.assetData + ", onLoadAssetListener=" + this.onLoadAssetListener + ", background=" + this.background + ", renderSize=" + this.renderSize + ")";
        }

        public RenderChainManagerInitInfo(@NotNull ArrayList<RenderDataDispatcher.c> waitRenderCommands, @Nullable Pair<String, ? extends HashMap<String, String>> pair, @Nullable OnLoadAssetListener onLoadAssetListener, @Nullable Triple<Integer, String, String> triple, @Nullable Pair<? extends Size, Float> pair2) {
            Intrinsics.checkParameterIsNotNull(waitRenderCommands, "waitRenderCommands");
            this.waitRenderCommands = waitRenderCommands;
            this.assetData = pair;
            this.onLoadAssetListener = onLoadAssetListener;
            this.background = triple;
            this.renderSize = pair2;
        }

        public /* synthetic */ RenderChainManagerInitInfo(ArrayList arrayList, Pair pair, OnLoadAssetListener onLoadAssetListener, Triple triple, Pair pair2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : arrayList, (i3 & 2) != 0 ? null : pair, (i3 & 4) != 0 ? null : onLoadAssetListener, (i3 & 8) != 0 ? null : triple, (i3 & 16) == 0 ? pair2 : null);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/tavcut/core/session/LAKCutSession$StickerTrackedResult;", "", "entity", "Lorg/light/lightAssetKit/Entity;", "stickerTrackerResult", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "callback", "Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "(Lorg/light/lightAssetKit/Entity;Ljava/util/ArrayList;Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;)V", "getCallback", "()Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;)V", "getEntity", "()Lorg/light/lightAssetKit/Entity;", "setEntity", "(Lorg/light/lightAssetKit/Entity;)V", "result", "getResult", "()Ljava/util/ArrayList;", "setResult", "(Ljava/util/ArrayList;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class StickerTrackedResult {

        @Nullable
        private IStickerUpdateCallback callback;

        @NotNull
        private Entity entity;

        @Nullable
        private ArrayList<GYTrackStickerInfo> result;

        public StickerTrackedResult(@NotNull Entity entity, @NotNull ArrayList<GYTrackStickerInfo> stickerTrackerResult, @Nullable IStickerUpdateCallback iStickerUpdateCallback) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            Intrinsics.checkParameterIsNotNull(stickerTrackerResult, "stickerTrackerResult");
            this.entity = entity;
            this.result = stickerTrackerResult;
            this.callback = iStickerUpdateCallback;
        }

        @Nullable
        public final IStickerUpdateCallback getCallback() {
            return this.callback;
        }

        @NotNull
        public final Entity getEntity() {
            return this.entity;
        }

        @Nullable
        public final ArrayList<GYTrackStickerInfo> getResult() {
            return this.result;
        }

        public final void setCallback(@Nullable IStickerUpdateCallback iStickerUpdateCallback) {
            this.callback = iStickerUpdateCallback;
        }

        public final void setEntity(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "<set-?>");
            this.entity = entity;
        }

        public final void setResult(@Nullable ArrayList<GYTrackStickerInfo> arrayList) {
            this.result = arrayList;
        }
    }

    public LAKCutSession(@Nullable CustomRenderConfig customRenderConfig) {
        this();
        this.customRenderConfig = customRenderConfig;
    }

    private final boolean checkEntityModifyNeedReload(Entity entity) {
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
        for (Component component : components) {
            if (!(component instanceof EntityIdentifier)) {
                Intrinsics.checkExpressionValueIsNotNull(component, "component");
                if (!componentSupportDynamicModify(component)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void checkReload(List<? extends RenderDataDispatcher.c> commands, boolean needFlushPlayer, long targetTime) {
        boolean z16 = false;
        for (RenderDataDispatcher.c cVar : commands) {
            if (cVar instanceof RenderDataDispatcher.c.RemoveEntity) {
                z16 = checkEntityModifyNeedReload(((RenderDataDispatcher.c.RemoveEntity) cVar).getEntity());
            } else if (cVar instanceof RenderDataDispatcher.c.AddEntity) {
                z16 = checkEntityModifyNeedReload(((RenderDataDispatcher.c.AddEntity) cVar).getEntity());
            }
        }
        if (z16) {
            TavLogger.e(LAKTavCutSessionKt.TAG, "need reload asset.");
            reloadAssets(needFlushPlayer, targetTime);
        }
    }

    public final void clearFlags() {
        TavLogger.e(LAKTavCutSessionKt.TAG, "++++++++++clearFlags++++++++++");
        this.dataDispatcher.E();
    }

    public final int consumeEvent(List<? extends Pair<String, ? extends Function0<Unit>>> r56, int startIndex) {
        int size = r56.size();
        if (startIndex < 0 || size <= startIndex) {
            return -1;
        }
        int size2 = r56.size();
        ArrayList arrayList = new ArrayList(r56.subList(startIndex, r56.size()));
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Function0) ((Pair) it.next()).getSecond()).invoke();
            }
        }
        if (r56.size() <= size2) {
            return -1;
        }
        return size2;
    }

    private final Entity createEmptyEntity() {
        ArrayList arrayListOf;
        c cVar = c.f431135f;
        EntityIdentifier a16 = cVar.o().a("2D\u7a7a\u5bf9\u8c61");
        f q16 = cVar.q();
        String name = a16.getName();
        if (name == null) {
            name = "";
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(a16);
        return q16.a(name, arrayListOf);
    }

    private final Entity createFilterGroupEntity() {
        ArrayList arrayListOf;
        c cVar = c.f431135f;
        FilterGroup d16 = cVar.o().d();
        EntityIdentifier a16 = cVar.o().a("\u6548\u679c\u7ec4");
        f q16 = cVar.q();
        String name = a16.getName();
        if (name == null) {
            name = "";
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d16, a16);
        return q16.a(name, arrayListOf);
    }

    private final void flushCommand(List<? extends RenderDataDispatcher.c> commands) {
        synchronized (this.renderChainManagerInitInfo) {
            if (this.playerRenderChainManager == null) {
                this.renderChainManagerInitInfo.getWaitRenderCommands().addAll(commands);
                TavLogger.w(LAKTavCutSessionKt.TAG, "commands stored.");
            } else {
                this.dataDispatcher.l(commands);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final BackgroundFillMode fromValue(int value) {
        if (value != 0) {
            if (value != 1) {
                return null;
            }
            return BackgroundFillMode.SolidColorFill;
        }
        return BackgroundFillMode.GaussianBlur;
    }

    private final long getMediaDuration() {
        ClipInfo[][] clipInfos;
        Object lastOrNull;
        Object lastOrNull2;
        TimeRange timeRange;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (!(iRenderChainManager instanceof LightRenderChainManager)) {
            return 0L;
        }
        if (iRenderChainManager != null) {
            MovieController movieController = ((LightRenderChainManager) iRenderChainManager).getMovieController();
            if (movieController != null && (clipInfos = movieController.getClipInfos()) != null) {
                lastOrNull = ArraysKt___ArraysKt.lastOrNull(clipInfos);
                ClipInfo[] clipInfoArr = (ClipInfo[]) lastOrNull;
                if (clipInfoArr != null) {
                    lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(clipInfoArr);
                    ClipInfo clipInfo = (ClipInfo) lastOrNull2;
                    if (clipInfo == null || (timeRange = clipInfo.targetTimeRange) == null) {
                        return 0L;
                    }
                    return timeRange.startTime + timeRange.duration;
                }
                return 0L;
            }
            return 0L;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.core.render.builder.light.LightRenderChainManager");
    }

    private final Size getMultiMediaSize() {
        List<Entity> list;
        Collection<Component> components;
        Entity rootEntity;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null && (rootEntity = iRenderChainManager.getRootEntity()) != null) {
            list = rootEntity.getEntitiesWithComponent(MultiMedia.class);
        } else {
            list = null;
        }
        if (list != null) {
            for (Entity entity : list) {
                if (entity != null && (components = entity.getComponents()) != null) {
                    for (Component component : components) {
                        if (component instanceof MultiMedia) {
                            return ((MultiMedia) component).getSize();
                        }
                    }
                }
            }
        }
        return null;
    }

    private final void internalFlush(List<? extends RenderDataDispatcher.c> commands, boolean needFlushPlayer, long targetTime) {
        IPlayer iPlayer;
        printFlushedCommands(commands);
        try {
            registerRenderRunnable();
            long currentTimeMillis = System.currentTimeMillis();
            TavLogger.d(LAKTavCutSessionKt.TAG, "internalFlush begin.");
            if (this.dataDispatcher.w(commands)) {
                TavLogger.d(LAKTavCutSessionKt.TAG, "internalFlush updatePlayer.");
                clearFlags();
                flushCommand(commands);
                updatePlayer(targetTime, this.dataDispatcher.t(commands), this.cutStatusListener);
                LAKRenderModel allInputSourceRenderModel = getAllInputSourceRenderModel();
                IPlayer iPlayer2 = this.player;
                if (iPlayer2 != null) {
                    iPlayer2.setClipAssets(allInputSourceRenderModel.getClipsAssets());
                }
                notifyRenderDataChanged();
            } else if (this.dataDispatcher.v(commands)) {
                TavLogger.d(LAKTavCutSessionKt.TAG, "internalFlush reloadAsset.");
                flushCommand(commands);
                reloadAssets(needFlushPlayer, targetTime);
            } else if (!commands.isEmpty()) {
                TavLogger.d(LAKTavCutSessionKt.TAG, "internalFlush updateComponent.");
                flushCommand(commands);
                if (needFlushPlayer && (iPlayer = this.player) != null) {
                    iPlayer.requestRender();
                }
                checkReload(commands, needFlushPlayer, targetTime);
                notifyRenderDataChanged();
            } else {
                emit();
                IPlayer iPlayer3 = this.player;
                if (iPlayer3 != null) {
                    iPlayer3.requestRender();
                }
                notifyRenderDataChanged();
            }
            TavLogger.d(LAKTavCutSessionKt.TAG, "internalFlush cost: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th5) {
            TavLogger.e(LAKTavCutSessionKt.TAG, "internalFlush Throwable " + th5.getMessage());
            th5.printStackTrace();
        }
    }

    static /* synthetic */ void internalFlush$default(LAKCutSession lAKCutSession, List list, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        lAKCutSession.internalFlush(list, z16, j3);
    }

    public final void notifyRenderDataApplied() {
        ud4.a.f438857c.a("apply_end");
        synchronized (this.sessionListenerList) {
            Iterator<T> it = this.sessionListenerList.iterator();
            while (it.hasNext()) {
                ((ISessionListener) it.next()).onRenderDataApplied();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyRenderDataChanged() {
        long j3;
        LAKRenderModel lakRenderModel = this.dataDispatcher.getLakRenderModel();
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            j3 = iRenderChainManager.getMovieControllerDuration();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        long mediaDuration = getMediaDuration();
        TavLogger.d(LAKTavCutSessionKt.TAG, "onRenderDataChanged duration: " + j16 + ", mediaDuration: " + mediaDuration);
        synchronized (this.sessionListenerList) {
            Iterator<T> it = this.sessionListenerList.iterator();
            while (it.hasNext()) {
                ((ISessionListener) it.next()).onRenderDataChanged(lakRenderModel, j16, mediaDuration);
            }
            Unit unit = Unit.INSTANCE;
        }
        IRenderChainManager iRenderChainManager2 = this.playerRenderChainManager;
        if (iRenderChainManager2 != null) {
            iRenderChainManager2.setRenderNodeDuration(j16);
        }
    }

    private final void printFlushedCommands(List<? extends RenderDataDispatcher.c> commands) {
        Entity entity;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("printFlushedCommands begin ");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        Entity entity2 = null;
        if (iRenderChainManager != null) {
            entity = iRenderChainManager.getRootEntity();
        } else {
            entity = null;
        }
        sb5.append(entity);
        TavLogger.d(LAKTavCutSessionKt.TAG, sb5.toString());
        Iterator<? extends RenderDataDispatcher.c> it = commands.iterator();
        while (it.hasNext()) {
            TavLogger.d(LAKTavCutSessionKt.TAG, "printFlushedCommands " + it.next().getClass().getSimpleName());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("printFlushedCommands end  ");
        IRenderChainManager iRenderChainManager2 = this.playerRenderChainManager;
        if (iRenderChainManager2 != null) {
            entity2 = iRenderChainManager2.getRootEntity();
        }
        sb6.append(entity2);
        TavLogger.d(LAKTavCutSessionKt.TAG, sb6.toString());
    }

    private final void registerRenderRunnable() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.runOnAfterApply(new Runnable() { // from class: com.tencent.tavcut.core.session.LAKCutSession$registerRenderRunnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    LAKCutSession.this.notifyRenderDataApplied();
                }
            });
        }
    }

    private final void reloadAssets(final boolean needFlushPlayer, final long targetTime) {
        TavLogger.d(LAKTavCutSessionKt.TAG, "out reloadAssets needFlushPlayer " + needFlushPlayer);
        new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$reloadAssets$runnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
            
                r1 = r5.this$0.player;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                IRenderChainManager iRenderChainManager;
                IRenderChainManager iRenderChainManager2;
                ICutStatusCallback iCutStatusCallback;
                IPlayer iPlayer;
                RenderDataDispatcher renderDataDispatcher2;
                TavLogger.d(LAKTavCutSessionKt.TAG, "in reloadAssets<<<<");
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                LAKRenderModel lakRenderModel = renderDataDispatcher.getLakRenderModel();
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                if (iRenderChainManager != null) {
                    renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                    iRenderChainManager.reloadAsset(renderDataDispatcher2.getTemplateDir(), lakRenderModel, targetTime);
                }
                if (needFlushPlayer && iPlayer != null) {
                    iPlayer.requestRender();
                }
                iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                lakRenderModel.setRoot(iRenderChainManager2 != null ? iRenderChainManager2.getRootEntity() : null);
                LAKCutSession.this.clearFlags();
                LAKCutSession.this.notifyRenderDataChanged();
                iCutStatusCallback = LAKCutSession.this.cutStatusListener;
                if (iCutStatusCallback != null) {
                    iCutStatusCallback.onLightEntityReload(LAKCutSession.this.getRootEntity());
                }
            }
        }.invoke();
    }

    private final void runUpdatePlayerEvents() {
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$runUpdatePlayerEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedList linkedList;
                LinkedList linkedList2;
                LinkedList linkedList3;
                LinkedList linkedList4;
                LinkedList linkedList5;
                linkedList = LAKCutSession.this.lazyUpdatePlayerEvents;
                synchronized (linkedList) {
                    int i3 = 0;
                    int i16 = 3;
                    while (true) {
                        LAKCutSession lAKCutSession = LAKCutSession.this;
                        linkedList2 = lAKCutSession.lazyUpdatePlayerEvents;
                        i3 = lAKCutSession.consumeEvent(linkedList2, i3);
                        i16--;
                        if (i3 == -1) {
                            break;
                        }
                        TavLogger.e(LAKTavCutSessionKt.TAG, "add new player event in runUpdatePlayerEvents");
                        linkedList4 = LAKCutSession.this.lazyUpdatePlayerEvents;
                        int size = linkedList4.size();
                        for (int i17 = i3; i17 < size; i17++) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("add new player event in runUpdatePlayerEvents \n ");
                            linkedList5 = LAKCutSession.this.lazyUpdatePlayerEvents;
                            sb5.append((String) ((Pair) linkedList5.get(i17)).getFirst());
                            TavLogger.e(LAKTavCutSessionKt.TAG, sb5.toString());
                        }
                        if (i16 == 0) {
                            TavLogger.e(LAKTavCutSessionKt.TAG, "runUpdatePlayerEvents loop 3 times, but still add new player event in player event " + i3);
                            break;
                        }
                    }
                    linkedList3 = LAKCutSession.this.lazyUpdatePlayerEvents;
                    linkedList3.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    public final void setPlayer(IPlayer iPlayer) {
        if (iPlayer != null) {
            iPlayer.setPlayerThread(this.cutSessionThreader.b());
        }
        this.player = iPlayer;
    }

    public final void splitCommandAndFlush(List<? extends RenderDataDispatcher.c> commands, boolean needFlushPlayer, long targetTime) {
        LightAssetDataContext lightAssetDataContext;
        Entity entity;
        LightAssetDataContext lightAssetDataContext2;
        if (commands.isEmpty()) {
            internalFlush(commands, needFlushPlayer, targetTime);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RenderDataDispatcher.c cVar : commands) {
            if (cVar instanceof RenderDataDispatcher.c.CustomCommand) {
                arrayList.add(RenderDataDispatcher.c.e.f374279a);
                internalFlush(arrayList, needFlushPlayer, targetTime);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("printFlushedCommands");
                sb5.append(cVar.getClass().getSimpleName());
                sb5.append(this.playerRenderChainManager);
                sb5.append(TokenParser.SP);
                IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
                Entity entity2 = null;
                if (iRenderChainManager != null) {
                    lightAssetDataContext = iRenderChainManager.getLightAssetDataContext();
                } else {
                    lightAssetDataContext = null;
                }
                sb5.append(lightAssetDataContext);
                IRenderChainManager iRenderChainManager2 = this.playerRenderChainManager;
                if (iRenderChainManager2 != null && (lightAssetDataContext2 = iRenderChainManager2.getLightAssetDataContext()) != null) {
                    entity = lightAssetDataContext2.getRootEntity();
                } else {
                    entity = null;
                }
                sb5.append(entity);
                sb5.append(TokenParser.SP);
                IRenderChainManager iRenderChainManager3 = this.playerRenderChainManager;
                if (iRenderChainManager3 != null) {
                    entity2 = iRenderChainManager3.getRootEntity();
                }
                sb5.append(entity2);
                TavLogger.d(LAKTavCutSessionKt.TAG, sb5.toString());
                ((RenderDataDispatcher.c.CustomCommand) cVar).a().invoke();
                arrayList.clear();
                if (this.dataDispatcher.i() > 0) {
                    arrayList.addAll(this.dataDispatcher.j());
                }
            } else {
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            internalFlush(arrayList, needFlushPlayer, targetTime);
        }
    }

    public static /* synthetic */ void splitCommandAndFlush$default(LAKCutSession lAKCutSession, List list, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        lAKCutSession.splitCommandAndFlush(list, z16, j3);
    }

    private final void updatePainting(Painting backGround) {
        boolean z16;
        if (!this.dataDispatcher.u(getMultiMediaSize(), backGround.getRenderSize())) {
            CustomRenderConfig customRenderConfig = this.customRenderConfig;
            if (customRenderConfig != null && !customRenderConfig.getEnableNeedPaintingFlush() && getMultiMediaSize() == null) {
                RenderDataDispatcher renderDataDispatcher = this.dataDispatcher;
                if (renderDataDispatcher.u(renderDataDispatcher.getLakRenderModel().getPainting().getRenderSize(), backGround.getRenderSize())) {
                    z16 = false;
                    TavLogger.d(LAKTavCutSessionKt.TAG, "updatePainting" + z16);
                    this.dataDispatcher.O(backGround, z16);
                }
            }
            z16 = true;
            TavLogger.d(LAKTavCutSessionKt.TAG, "updatePainting" + z16);
            this.dataDispatcher.O(backGround, z16);
        }
    }

    public static /* synthetic */ void updatePlayer$default(LAKCutSession lAKCutSession, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        lAKCutSession.updatePlayer(j3, z16);
    }

    private final void updateRenderModelSize(Size renderSize, float fillScale) {
        LAKRenderModel lakRenderModel = this.dataDispatcher.getLakRenderModel();
        Painting painting = lakRenderModel.getPainting();
        lakRenderModel.setPainting(Painting.copy$default(painting, null, null, renderSize, Float.valueOf(fillScale), null, 19, null));
        Size renderSize2 = painting.getRenderSize();
        if (renderSize2 != null) {
            if (lakRenderModel.getProperties() == null) {
                lakRenderModel.setProperties(new Properties(null, null, null, null, null, null, null, 127, null));
            }
            Properties properties = lakRenderModel.getProperties();
            if (properties != null) {
                properties.setLayout(new Layout(Integer.valueOf(renderSize2.width), Integer.valueOf(renderSize2.height)));
            }
        }
        TavLogger.e(LAKTavCutSessionKt.TAG, "updateRenderModelSize width: " + renderSize.width + " height: " + renderSize.height);
        this.dataDispatcher.getLakRenderModel().setPainting(Painting.copy$default(painting, null, null, renderSize, null, null, 27, null));
    }

    public final void updateStickerPosition(String stickerName, ScreenTransform stickerTransform, long time, ArrayList<GYTrackStickerInfo> stickerTrackerResult, IStickerUpdateCallback callback) {
        GYTrackStickerInfo e16 = com.tencent.tavcut.core.utils.c.e(stickerTrackerResult, time);
        if (e16 != null) {
            if (callback != null) {
                callback.onUpdate(stickerName, e16);
            }
            stickerTransform.setAnchor(com.tencent.tavcut.core.utils.c.b(e16));
            stickerTransform.setScale(new Vec3(1.0f, 1.0f, 1.0f));
            stickerTransform.setOffset(com.tencent.tavcut.core.utils.c.a(e16));
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public InputSource accessInputSource(@NotNull String sourceKey) {
        Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
        return this.dataDispatcher.c(sourceKey);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addBgm(@NotNull final Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addBgm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                TavLogger.d(LAKTavCutSessionKt.TAG, "add BGM Entity id: " + entity.getId());
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher, entity, EntityNodeType.ROOT_ENTITY, 0, 4, null);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addClipEffect(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.iClipSourceOperator.addClipEffect(entity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addEffect(@NotNull final Entity entity, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addEffect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher, entity, EntityNodeType.FILTER_GROUP, 0, 4, null);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addHDR(@NotNull final Entity entity, final int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addHDR$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.d(entity, EntityNodeType.CAMERA_ENTITY, index);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addInputSource(@NotNull final InputSource inputSource, final boolean needReloadAsset) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addInputSource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.f(inputSource);
                if (needReloadAsset) {
                    LAKCutSession.this.notifyReloadAsset();
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.addRenderCallback(callback);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        this.renderNodeConfigurator.addRenderNode(effectNode);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderTarget(@NotNull final Entity entity, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addRenderTarget$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher, entity, EntityNodeType.ROOT_ENTITY, 0, 4, null);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addSessionListener(@NotNull ISessionListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (this.sessionListenerList) {
            CopyOnWriteArrayList<ISessionListener> copyOnWriteArrayList = this.sessionListenerList;
            if (!(!copyOnWriteArrayList.contains(listener))) {
                copyOnWriteArrayList = null;
            }
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.add(listener);
            }
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addVideoSourceEntity(@NotNull final Entity entity, final int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addVideoSourceEntity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.d(entity, EntityNodeType.MULTI_MEDIA, index);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addVideoSourceEntityAfterLutFilter(@NotNull final Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addVideoSourceEntityAfterLutFilter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher, entity, EntityNodeType.MULTI_MEDIA_AFTER_LUT, 0, 4, null);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public IPlayer bindCutPlayer(@NotNull IPlayer player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        if (this.player == null) {
            setPlayer(new CutWrapperPlayer(player));
            runUpdatePlayerEvents();
            IPlayer iPlayer = this.player;
            if (iPlayer != null) {
                return (CutWrapperPlayer) iPlayer;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.core.render.player.CutWrapperPlayer");
        }
        TavLogger.e(LAKTavCutSessionKt.TAG, "bindCutPlayer player exits.");
        throw new IllegalStateException("player exist, need unbindCutPlayer.");
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void bindPlayer(@NotNull IPlayer player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        setPlayer(player);
        runUpdatePlayerEvents();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public boolean componentSupportDynamicModify(@NotNull Component r26) {
        Intrinsics.checkParameterIsNotNull(r26, "component");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.componentSupportDynamicModify(r26);
        }
        return false;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public int createStickerTrackerManager(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull b stickerTrackerConfig) {
        Intrinsics.checkParameterIsNotNull(stickerTrackerManager, "stickerTrackerManager");
        Intrinsics.checkParameterIsNotNull(stickerTrackerConfig, "stickerTrackerConfig");
        int b06 = stickerTrackerManager.b0(this.player, this.playerRenderChainManager, this.dataDispatcher, stickerTrackerConfig);
        TavLogger.i(LAKTavCutSessionKt.TAG, "createStickerTrackerManager code " + b06);
        return b06;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void emit() {
        runOnPlayerThread(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$emit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IRenderChainManager iRenderChainManager;
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                if (iRenderChainManager != null) {
                    iRenderChainManager.emit();
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flush() {
        flushWithoutDelay();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flushWithoutDelay() {
        runOnPlayerThread(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$flushWithoutDelay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                LAKCutSession.splitCommandAndFlush$default(LAKCutSession.this, renderDataDispatcher.j(), true, 0L, 4, null);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public List<Entity> getAllImageStickerEntitys() {
        RenderDataDispatcher renderDataDispatcher = this.dataDispatcher;
        if (renderDataDispatcher != null) {
            return renderDataDispatcher.m();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public LAKRenderModel getAllInputSourceRenderModel() {
        return this.dataDispatcher.getLakRenderModel();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public List<Entity> getAllTextEntity(@Nullable Entity rootEntity) {
        return this.dataDispatcher.o(rootEntity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getClipAssetsDurationUs() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getClipAssetsDuration();
        }
        return -1L;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    /* renamed from: getClipSourceOperator, reason: from getter */
    public IClipSourceOperator getIClipSourceOperator() {
        return this.iClipSourceOperator;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    /* renamed from: getComponentOperator, reason: from getter */
    public d getIComponentOperator() {
        return this.iComponentOperator;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public List<TextPlaceInfo> getEditableTextByEntityId(int r26) {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getEditableTextByEntityId(r26);
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public TextPlaceInfo getEditableTextUnderPoint(float r26, float y16) {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getEditableTextUnderPoint(r26, y16);
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public ArrayList<Integer> getEntitiesUnderPoint(float r26, float y16) {
        ArrayList<Integer> entitiesUnderPoint;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null && (entitiesUnderPoint = iRenderChainManager.getEntitiesUnderPoint(r26, y16)) != null) {
            return entitiesUnderPoint;
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getFrameDuration() {
        return 33000L;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public JsonObject getInputSources() {
        LightAssetDataContext lightAssetDataContext;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null && (lightAssetDataContext = iRenderChainManager.getLightAssetDataContext()) != null) {
            return lightAssetDataContext.getInputSources();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LightAsset getLightAsset() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getLightAsset();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LightAssetDataContext getLightAssetDataContext() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getLightAssetDataContext();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public MaterialConfig[] getMaterialConfig() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getMaterialConfig();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Boolean getMediasTotalDurationLimitationFlag() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getMediasTotalDurationLimitationFlag();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public TemplateConfig getMovieConfig() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getMovieConfig();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public float getOriginVolume(float defaultVolume) {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getOriginVolume(defaultVolume);
        }
        return defaultVolume;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public LAKRenderModel getRenderModel() {
        return this.dataDispatcher.p();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Entity getRootEntity() {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.getRootEntity();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getTotalDurationUs() {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            return iPlayer.getTotalDurationUs();
        }
        return 0L;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Boolean needRenderAbility(@NotNull String aiType) {
        Intrinsics.checkParameterIsNotNull(aiType, "aiType");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            return iRenderChainManager.needRenderAbility(aiType);
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void notifyReloadAsset() {
        this.dataDispatcher.z();
    }

    public void onInitSource() {
        clearFlags();
        updatePlayer$default(this, 0L, false, 3, null);
    }

    public void onVoiceChangerUpdate(@Nullable List<? extends VoiceEnum> r26) {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setVoiceChangerConfig(r26);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void pushCustomCommand(@NotNull final Function1<? super ICutSession, Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$pushCustomCommand$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LAKCutSession.this.pushCustomCommandSync(runnable);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void pushCustomCommandSync(@NotNull final Function1<? super ICutSession, Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        this.dataDispatcher.A(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$pushCustomCommandSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LAKCutSession$syncCutSession$1 lAKCutSession$syncCutSession$1;
                Function1 function1 = runnable;
                lAKCutSession$syncCutSession$1 = LAKCutSession.this.syncCutSession;
                function1.invoke(lAKCutSession$syncCutSession$1);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public <T extends Component> List<Entity> queryEntityByComponent(@NotNull KClass<T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return this.dataDispatcher.B(clazz);
    }

    @Nullable
    public final Entity queryEntityByEntityId(int r46) {
        for (Entity entity : queryEntityByComponent(Reflection.getOrCreateKotlinClass(ScreenTransform.class))) {
            if (entity.getId() == r46) {
                return entity;
            }
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
        Intrinsics.checkParameterIsNotNull(fontFamily, "fontFamily");
        Intrinsics.checkParameterIsNotNull(fontStyle, "fontStyle");
        Intrinsics.checkParameterIsNotNull(fontPath, "fontPath");
        FontCacheManager.INSTANCE.registerFont(fontFamily, fontStyle, fontPath);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void release() {
        this.renderChainManagerInitInfo.setOnLoadAssetListener(null);
        this.cutSessionThreader.d();
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.release();
        }
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.release();
        }
        this.cutStatusListener = null;
        this.clipAssetListener = null;
        synchronized (this.sessionListenerList) {
            this.sessionListenerList.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.lazyUpdatePlayerEvents) {
            this.lazyUpdatePlayerEvents.clear();
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeEntity(@NotNull final Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$removeEntity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                TavLogger.d(LAKTavCutSessionKt.TAG, "remove entity id: " + entity.getId());
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.C(entity);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public InputSource removeInputSource(@NotNull String sourceKey) {
        Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
        return this.dataDispatcher.D(sourceKey);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.removeRenderCallback(callback);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        this.renderNodeConfigurator.removeRenderNode(effectNode);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeSessionListener(@NotNull ISessionListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (this.sessionListenerList) {
            CopyOnWriteArrayList<ISessionListener> copyOnWriteArrayList = this.sessionListenerList;
            if (!copyOnWriteArrayList.contains(listener)) {
                copyOnWriteArrayList = null;
            }
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(listener);
            }
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void runOnPlayerThread(@NotNull Function0<Unit> runnable) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (this.player == null) {
            synchronized (this.lazyUpdatePlayerEvents) {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement[] stackTrace = currentThread.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace, "Thread.currentThread().stackTrace");
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(stackTrace, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                this.lazyUpdatePlayerEvents.add(TuplesKt.to(joinToString$default, runnable));
            }
            return;
        }
        this.cutSessionThreader.e(runnable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void seek(final long j3) {
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$seek$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPlayer iPlayer;
                iPlayer = LAKCutSession.this.player;
                if (iPlayer != null) {
                    iPlayer.seek(j3);
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        synchronized (this.renderChainManagerInitInfo) {
            IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
            if (iRenderChainManager == null) {
                this.renderChainManagerInitInfo.setAssetData(TuplesKt.to(templatePath, assetData));
                Unit unit = Unit.INSTANCE;
            } else {
                if (iRenderChainManager != null) {
                    iRenderChainManager.addAssetDataToHolder(templatePath, assetData);
                }
                IRenderChainManager iRenderChainManager2 = this.playerRenderChainManager;
                if (iRenderChainManager2 != null) {
                    iRenderChainManager2.setAssetData(assetData);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setBgColor(int bgColor) {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.setBgColor(bgColor);
        }
    }

    public final void setClipAssetListener(@NotNull OnClipAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.clipAssetListener = listener;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setClipAssetListener(listener);
        }
    }

    public void setClipAssets(@NotNull final List<ClipSource> clips, final boolean modifyClipsDuration, boolean runInDefaultThread) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$setClipAssets$runnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IRenderChainManager iRenderChainManager;
                IRenderChainManager iRenderChainManager2;
                Painting painting;
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                if (iRenderChainManager instanceof LightRenderChainManager) {
                    LAKRenderModel allInputSourceRenderModel = LAKCutSession.this.getAllInputSourceRenderModel();
                    List<ClipAsset> transClipSourcesToClipAssets = LightEntityTransHelper.transClipSourcesToClipAssets(clips);
                    iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                    if (iRenderChainManager2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.core.render.builder.light.LightRenderChainManager");
                    }
                    ((LightRenderChainManager) iRenderChainManager2).setClipAssets(transClipSourcesToClipAssets, (allInputSourceRenderModel == null || (painting = allInputSourceRenderModel.getPainting()) == null) ? null : painting.getPagPath(), modifyClipsDuration);
                }
            }
        };
        if (runInDefaultThread) {
            this.cutSessionThreader.e(function0);
        } else {
            function0.invoke();
        }
    }

    @Override // com.tencent.tavcut.core.dataprocessor.a
    public void setClipAssetsWithCallback(@NotNull final List<ClipSource> clips, final boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$setClipAssetsWithCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IRenderChainManager iRenderChainManager;
                IRenderChainManager iRenderChainManager2;
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                if (iRenderChainManager instanceof LightRenderChainManager) {
                    LAKRenderModel allInputSourceRenderModel = LAKCutSession.this.getAllInputSourceRenderModel();
                    List<ClipAsset> transClipSourcesToClipAssets = LightEntityTransHelper.transClipSourcesToClipAssets(clips);
                    iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                    if (iRenderChainManager2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.core.render.builder.light.LightRenderChainManager");
                    }
                    ((LightRenderChainManager) iRenderChainManager2).setClipAssetsWithCallback(transClipSourcesToClipAssets, allInputSourceRenderModel.getPainting().getPagPath(), modifyClipsDuration);
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setCutStatusListener(@Nullable ICutStatusCallback cutStatusCallback) {
        this.cutStatusListener = cutStatusCallback;
    }

    public final void setIsUseTemplateTime(boolean isUseTemplateTime) {
        this.isUseMovieControllerDuration = isUseTemplateTime;
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setIsUseTemplateTime(isUseTemplateTime);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setLoadAssetListener(@NotNull OnLoadAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (this.renderChainManagerInitInfo) {
            this.renderChainManagerInitInfo.setOnLoadAssetListener(listener);
            IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
            if (iRenderChainManager != null && iRenderChainManager != null) {
                iRenderChainManager.setLoadAssetListener(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setMediasTotalDurationLimitationFlag(boolean isLimited) {
        c.f431135f.C(isLimited);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setOriginVolume(float r26) {
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setOriginVolume(r26);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setOriginVolumeForClip(final int index, final float r46) {
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$setOriginVolumeForClip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IClipSourceOperator iClipSourceOperator;
                iClipSourceOperator = LAKCutSession.this.iClipSourceOperator;
                iClipSourceOperator.setOriginVolumeForClip(index, r46);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel) {
        Intrinsics.checkParameterIsNotNull(LAKRenderModel, "LAKRenderModel");
        setRenderModel(LAKRenderModel, true);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderTimeListener(@NotNull IRenderTimeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.renderTimeListener = listener;
    }

    public final void setSwitchReloadAsset(boolean r16) {
        this.switchReloadAsset = r16;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setTemplateDir(@NotNull String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        this.dataDispatcher.L(path);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setTransition(@NotNull final Entity entity, final int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$setTransition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                RenderDataDispatcher renderDataDispatcher2;
                TavLogger.d(LAKTavCutSessionKt.TAG, "add transition in setTransition index: " + index);
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.d(entity, EntityNodeType.TRANSITION_TRIGGER, index);
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.z();
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setWatermarkConfig(@Nullable WatermarkConfig r26) {
        this.dataDispatcher.N(r26);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchEntity(@NotNull final Entity entity, final boolean enable) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$switchEntity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Collection<Component> components = Entity.this.getComponents();
                Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
                for (Component component : components) {
                    if (component instanceof ScreenTransform) {
                        ((ScreenTransform) component).setObjectEnabled(enable);
                    }
                }
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchEntitySync(@NotNull Entity entity, boolean enable) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
        for (Component component : components) {
            if (component instanceof ScreenTransform) {
                ((ScreenTransform) component).setObjectEnabled(enable);
            }
        }
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.emit();
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.switchPicEnhanceAbility(type, enable);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void unbindCutPlayer(@Nullable IPlayer player) {
        if (player == null || Intrinsics.areEqual(this.player, player)) {
            setPlayer(null);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void unbindPlayer(@Nullable IPlayer player) {
        if (player == null || Intrinsics.areEqual(this.player, player)) {
            setPlayer(null);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String r132) {
        Intrinsics.checkParameterIsNotNull(backColor, "backColor");
        synchronized (this.renderChainManagerInitInfo) {
            if (this.playerRenderChainManager == null) {
                this.renderChainManagerInitInfo.setBackground(new Triple<>(Integer.valueOf(backgroundFillMode), backColor, r132));
            } else {
                Painting painting = this.dataDispatcher.getLakRenderModel().getPainting();
                BackgroundFillMode fromValue = fromValue(backgroundFillMode);
                if (fromValue == null) {
                    Intrinsics.throwNpe();
                }
                if (r132 == null) {
                    r132 = "";
                }
                updatePainting(Painting.copy$default(painting, fromValue, backColor, null, null, r132, 12, null));
                flushWithoutDelay();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void updatePlayer(long targetTime, boolean isInit) {
        updatePlayer(targetTime, isInit, this.cutStatusListener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateRenderSize(@NotNull Size renderSize) {
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        float f16 = renderSize.width > renderSize.height ? 1000.0f : 0.0f;
        updateRenderModelSize(renderSize, f16);
        synchronized (this.renderChainManagerInitInfo) {
            if (this.playerRenderChainManager == null) {
                this.renderChainManagerInitInfo.setRenderSize(TuplesKt.to(renderSize, null));
            } else {
                updatePainting(Painting.copy$default(this.dataDispatcher.getLakRenderModel().getPainting(), null, null, renderSize, Float.valueOf(f16), null, 19, null));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity, @Nullable final IStickerUpdateCallback callback) {
        Intrinsics.checkParameterIsNotNull(stickerName, "stickerName");
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.addRenderCallback(new IRenderCallback() { // from class: com.tencent.tavcut.core.session.LAKCutSession$updateTrackedStickerPosition$1
                @Override // com.tencent.tavcut.core.session.IRenderCallback
                public void onBeforeRender(long timeStamp) {
                    Map map;
                    Map map2;
                    IRenderChainManager iRenderChainManager2;
                    IRenderChainManager iRenderChainManager3;
                    map = LAKCutSession.this.trackedStickerResultMap;
                    if (map.isEmpty()) {
                        iRenderChainManager3 = LAKCutSession.this.playerRenderChainManager;
                        if (iRenderChainManager3 != null) {
                            iRenderChainManager3.removeRenderCallback(this);
                            return;
                        }
                        return;
                    }
                    map2 = LAKCutSession.this.trackedStickerResultMap;
                    for (Map.Entry entry : map2.entrySet()) {
                        ScreenTransform g16 = com.tencent.tavcut.core.utils.c.g(((LAKCutSession.StickerTrackedResult) entry.getValue()).getEntity());
                        if (g16 != null) {
                            LAKCutSession lAKCutSession = LAKCutSession.this;
                            String str = (String) entry.getKey();
                            ArrayList<GYTrackStickerInfo> result = ((LAKCutSession.StickerTrackedResult) entry.getValue()).getResult();
                            if (result == null) {
                                Intrinsics.throwNpe();
                            }
                            lAKCutSession.updateStickerPosition(str, g16, timeStamp, result, callback);
                        }
                    }
                    iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                    if (iRenderChainManager2 != null) {
                        iRenderChainManager2.emit();
                    }
                }

                @Override // com.tencent.tavcut.core.session.IRenderCallback
                public void onRender(long timeStamp, @NotNull TextureInfo textureInfo) {
                    Intrinsics.checkParameterIsNotNull(textureInfo, "textureInfo");
                }
            });
        }
        if (stickerTrackerResult != null && !stickerTrackerResult.isEmpty()) {
            this.trackedStickerResultMap.put(stickerName, new StickerTrackedResult(entity, stickerTrackerResult, callback));
            return true;
        }
        if (this.trackedStickerResultMap.containsKey(stickerName)) {
            this.trackedStickerResultMap.remove(stickerName);
            return true;
        }
        return true;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateVolume(float r26) {
        updateVolume(r26, null);
    }

    private final void updatePlayer(long targetTime, boolean isInit, ICutStatusCallback cutStatusCallback) {
        CustomRenderConfig customRenderConfig;
        LAKRenderModel lakRenderModel = this.dataDispatcher.getLakRenderModel();
        RenderChainManagerInitInfo renderChainManagerInitInfo = this.renderChainManagerInitInfo;
        if (renderChainManagerInitInfo.getRenderSize() != null && (customRenderConfig = this.customRenderConfig) != null && !customRenderConfig.getEnableNeedPaintingFlush() && this.playerRenderChainManager != null) {
            Pair<Size, Float> renderSize = renderChainManagerInitInfo.getRenderSize();
            if (renderSize == null) {
                Intrinsics.throwNpe();
            }
            if (renderSize.getSecond() != null) {
                Pair<Size, Float> renderSize2 = renderChainManagerInitInfo.getRenderSize();
                if (renderSize2 == null) {
                    Intrinsics.throwNpe();
                }
                Size first = renderSize2.getFirst();
                Pair<Size, Float> renderSize3 = renderChainManagerInitInfo.getRenderSize();
                if (renderSize3 == null) {
                    Intrinsics.throwNpe();
                }
                Float second = renderSize3.getSecond();
                if (second == null) {
                    Intrinsics.throwNpe();
                }
                updateRenderSize(first, second.floatValue());
            } else {
                Pair<Size, Float> renderSize4 = renderChainManagerInitInfo.getRenderSize();
                if (renderSize4 == null) {
                    Intrinsics.throwNpe();
                }
                updateRenderSize(renderSize4.getFirst());
            }
        }
        lakRenderModel.setCustomRenderConfig(this.customRenderConfig);
        IRenderChainManager iRenderChainManager = this.playerRenderChainManager;
        HashMap<String, String> currentAssetData = iRenderChainManager != null ? iRenderChainManager.getCurrentAssetData(this.dataDispatcher.getTemplateDir()) : null;
        if (!isInit) {
            IRenderChainManager iRenderChainManager2 = this.playerRenderChainManager;
            lakRenderModel.setJsonData(LightAssetUtils.getAssetJsonString(iRenderChainManager2 != null ? iRenderChainManager2.getLightAsset() : null));
        }
        IPlayer iPlayer = this.player;
        Pair<IRenderChainManager, LAKRenderModel> updatePlayer = iPlayer != null ? iPlayer.updatePlayer(this.dataDispatcher.getTemplateDir(), lakRenderModel, targetTime, this.clipAssetListener) : null;
        if (updatePlayer == null) {
            TavLogger.e(LAKTavCutSessionKt.TAG, "updatePlayer fail");
            return;
        }
        IRenderChainManager component1 = updatePlayer.component1();
        LAKRenderModel component2 = updatePlayer.component2();
        lakRenderModel.setRoot(component1.getRootEntity());
        this.playerRenderChainManager = component1;
        OnClipAssetListener onClipAssetListener = this.clipAssetListener;
        if (onClipAssetListener != null) {
            component1.setClipAssetListener(onClipAssetListener);
        }
        this.dataDispatcher.K(component1);
        IRenderChainManager iRenderChainManager3 = this.playerRenderChainManager;
        if (iRenderChainManager3 != null) {
            iRenderChainManager3.setIsUseTemplateTime(this.isUseMovieControllerDuration);
            IRenderTimeListener iRenderTimeListener = this.renderTimeListener;
            if (iRenderTimeListener != null) {
                iRenderChainManager3.setRenderTimeListener(iRenderTimeListener);
            }
            if (currentAssetData != null) {
                String templateDir = this.dataDispatcher.getTemplateDir();
                iRenderChainManager3.addAssetDataToHolder(templateDir, currentAssetData);
                setAssetData(templateDir, currentAssetData);
            }
        }
        if (this.playerRenderChainManager != null) {
            for (Map.Entry<String, StickerTrackedResult> entry : this.trackedStickerResultMap.entrySet()) {
                updateTrackedStickerPosition(entry.getValue().getResult(), entry.getKey(), entry.getValue().getEntity(), entry.getValue().getCallback());
            }
        }
        RenderChainManagerInitInfo renderChainManagerInitInfo2 = this.renderChainManagerInitInfo;
        if (renderChainManagerInitInfo2.getOnLoadAssetListener() != null) {
            OnLoadAssetListener onLoadAssetListener = renderChainManagerInitInfo2.getOnLoadAssetListener();
            if (onLoadAssetListener == null) {
                Intrinsics.throwNpe();
            }
            setLoadAssetListener(onLoadAssetListener);
        }
        if (renderChainManagerInitInfo2.getAssetData() != null) {
            Pair<String, HashMap<String, String>> assetData = renderChainManagerInitInfo2.getAssetData();
            if (assetData == null) {
                Intrinsics.throwNpe();
            }
            String first2 = assetData.getFirst();
            Pair<String, HashMap<String, String>> assetData2 = renderChainManagerInitInfo2.getAssetData();
            if (assetData2 == null) {
                Intrinsics.throwNpe();
            }
            setAssetData(first2, assetData2.getSecond());
            renderChainManagerInitInfo2.setAssetData(null);
        }
        if (renderChainManagerInitInfo2.getBackground() != null) {
            Triple<Integer, String, String> background = renderChainManagerInitInfo2.getBackground();
            if (background == null) {
                Intrinsics.throwNpe();
            }
            int intValue = background.getFirst().intValue();
            Triple<Integer, String, String> background2 = renderChainManagerInitInfo2.getBackground();
            if (background2 == null) {
                Intrinsics.throwNpe();
            }
            String second2 = background2.getSecond();
            Triple<Integer, String, String> background3 = renderChainManagerInitInfo2.getBackground();
            if (background3 == null) {
                Intrinsics.throwNpe();
            }
            updateBackground(intValue, second2, background3.getThird());
            renderChainManagerInitInfo2.setBackground(null);
        }
        if (renderChainManagerInitInfo2.getRenderSize() != null) {
            Pair<Size, Float> renderSize5 = renderChainManagerInitInfo2.getRenderSize();
            if (renderSize5 == null) {
                Intrinsics.throwNpe();
            }
            if (renderSize5.getSecond() != null) {
                Pair<Size, Float> renderSize6 = renderChainManagerInitInfo2.getRenderSize();
                if (renderSize6 == null) {
                    Intrinsics.throwNpe();
                }
                Size first3 = renderSize6.getFirst();
                Pair<Size, Float> renderSize7 = renderChainManagerInitInfo2.getRenderSize();
                if (renderSize7 == null) {
                    Intrinsics.throwNpe();
                }
                Float second3 = renderSize7.getSecond();
                if (second3 == null) {
                    Intrinsics.throwNpe();
                }
                updateRenderSize(first3, second3.floatValue());
            } else {
                Pair<Size, Float> renderSize8 = renderChainManagerInitInfo2.getRenderSize();
                if (renderSize8 == null) {
                    Intrinsics.throwNpe();
                }
                updateRenderSize(renderSize8.getFirst());
            }
            renderChainManagerInitInfo2.setRenderSize(null);
        }
        if (!this.renderChainManagerInitInfo.getWaitRenderCommands().isEmpty()) {
            flushCommand(new ArrayList(this.renderChainManagerInitInfo.getWaitRenderCommands()));
            this.renderChainManagerInitInfo.getWaitRenderCommands().clear();
        }
        this.renderNodeConfigurator.configRenderChainManager(component1);
        this.dataDispatcher.P(component2.getTimeLines());
        component1.registerTimelineObserver(new Function1<List<? extends Timeline>, Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$updatePlayer$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Timeline> list) {
                invoke2((List<Timeline>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<Timeline> it) {
                RenderDataDispatcher renderDataDispatcher;
                Intrinsics.checkParameterIsNotNull(it, "it");
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.P(it);
            }
        });
        notifyRenderDataChanged();
        notifyRenderDataApplied();
        if (cutStatusCallback != null) {
            cutStatusCallback.onRenderChainReady();
        }
        if (cutStatusCallback != null) {
            cutStatusCallback.onLightEntityReload(getRootEntity());
        }
    }

    static /* synthetic */ void updatePlayer$default(LAKCutSession lAKCutSession, long j3, boolean z16, ICutStatusCallback iCutStatusCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            iCutStatusCallback = null;
        }
        lAKCutSession.updatePlayer(j3, z16, iCutStatusCallback);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addEffect(@NotNull final Entity entity, @NotNull final EntityNodeType entityType, final int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(entityType, "entityType");
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$addEffect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher.d(entity, entityType, index);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flushWithoutDelay(final boolean needFlushPlayer, final long targetTime) {
        runOnPlayerThread(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$flushWithoutDelay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderDataDispatcher renderDataDispatcher;
                renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                LAKCutSession.this.splitCommandAndFlush(renderDataDispatcher.j(), needFlushPlayer, targetTime);
            }
        });
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel, boolean needInitTemplate) {
        Intrinsics.checkParameterIsNotNull(LAKRenderModel, "LAKRenderModel");
        TavLogger.e(LAKTavCutSessionKt.TAG, ">>>setRenderModel<<<");
        this.dataDispatcher.r(LAKRenderModel, needInitTemplate);
        if (rd4.b.f431129b.a()) {
            this.dataDispatcher.M(this.voiceConfig);
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateVolume(final float r36, @Nullable final AudioSourceType type) {
        this.cutSessionThreader.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$updateVolume$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IRenderChainManager iRenderChainManager;
                IRenderChainManager iRenderChainManager2;
                RenderDataDispatcher renderDataDispatcher;
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                Entity rootEntity = iRenderChainManager != null ? iRenderChainManager.getRootEntity() : null;
                List<Entity> entitiesWithComponent = rootEntity != null ? rootEntity.getEntitiesWithComponent(AudioSource.class) : null;
                if (entitiesWithComponent != null) {
                    for (Entity entity : entitiesWithComponent) {
                        Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
                        Collection<Component> components = entity.getComponents();
                        Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
                        for (Component component : components) {
                            if (component instanceof AudioSource) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("updateVolume:");
                                sb5.append(r36);
                                sb5.append(", componentType: ");
                                AudioSource audioSource = (AudioSource) component;
                                sb5.append(audioSource.getAudioSourceType());
                                sb5.append(", type: ");
                                sb5.append(type);
                                TavLogger.i(LAKTavCutSessionKt.TAG, sb5.toString());
                                AudioSourceType audioSourceType = type;
                                if (audioSourceType == null || audioSourceType == audioSource.getAudioSourceType()) {
                                    audioSource.setVolume(r36);
                                }
                            }
                            iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                            if (iRenderChainManager2 != null) {
                                Intrinsics.checkExpressionValueIsNotNull(component, "component");
                                if (!iRenderChainManager2.componentSupportDynamicModify(component)) {
                                    renderDataDispatcher = LAKCutSession.this.dataDispatcher;
                                    renderDataDispatcher.z();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.tavcut.core.session.LAKCutSession$syncCutSession$1] */
    public LAKCutSession() {
        List<VoiceEnum> listOf;
        this.sessionListenerList = new CopyOnWriteArrayList<>();
        this.renderNodeConfigurator = new RenderNodeConfigurator();
        this.lazyUpdatePlayerEvents = new LinkedList<>();
        CutSessionThreadUtils cutSessionThreadUtils = new CutSessionThreadUtils();
        this.cutSessionThreader = cutSessionThreadUtils;
        this.renderDelayTimer = new DelayTimer(5L, new Function1<List<? extends RenderDataDispatcher.c>, Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$renderDelayTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RenderDataDispatcher.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final List<? extends RenderDataDispatcher.c> it) {
                CutSessionThreadUtils cutSessionThreadUtils2;
                Intrinsics.checkParameterIsNotNull(it, "it");
                cutSessionThreadUtils2 = LAKCutSession.this.cutSessionThreader;
                cutSessionThreadUtils2.e(new Function0<Unit>() { // from class: com.tencent.tavcut.core.session.LAKCutSession$renderDelayTimer$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LAKCutSession.splitCommandAndFlush$default(LAKCutSession.this, it, false, 0L, 6, null);
                    }
                });
            }
        });
        this.trackedStickerResultMap = new LinkedHashMap();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VoiceEnum[]{VoiceEnum.UNCLE, VoiceEnum.LOLI, VoiceEnum.NAUGHTY_KID, VoiceEnum.HEAVY_METAL, VoiceEnum.ETHEREAL});
        this.voiceConfig = listOf;
        RenderConfig.INSTANCE.setRenderType(0);
        RenderDataDispatcher renderDataDispatcher = new RenderDataDispatcher(new AnonymousClass1(cutSessionThreadUtils));
        this.dataDispatcher = renderDataDispatcher;
        renderDataDispatcher.g(this);
        this.iClipSourceOperator = new ClipSourceOperator(this.dataDispatcher);
        this.iComponentOperator = new com.tencent.tavcut.core.operator.a(this.dataDispatcher);
        this.renderChainManagerInitInfo = new RenderChainManagerInitInfo(null, null, null, null, null, 31, null);
        this.MAX_RELOAD_ASSET_TIME = 3000000000L;
        this.syncCutSession = new ICutSession() { // from class: com.tencent.tavcut.core.session.LAKCutSession$syncCutSession$1
            private final /* synthetic */ LAKCutSession $$delegate_0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$$delegate_0 = LAKCutSession.this;
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public InputSource accessInputSource(@NotNull String sourceKey) {
                Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
                return this.$$delegate_0.accessInputSource(sourceKey);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addBgm(@NotNull Entity entity) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                TavLogger.d(LAKTavCutSessionKt.TAG, "add BGM Entity id: " + entity.getId());
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher2, entity, EntityNodeType.ROOT_ENTITY, 0, 4, null);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addClipEffect(@NotNull Entity entity) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                this.$$delegate_0.addClipEffect(entity);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addEffect(@NotNull Entity entity, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher2, entity, EntityNodeType.FILTER_GROUP, 0, 4, null);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addHDR(@NotNull Entity entity, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.d(entity, EntityNodeType.CAMERA_ENTITY, index);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addInputSource(@NotNull InputSource inputSource, boolean needReloadAsset) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.f(inputSource);
                if (needReloadAsset) {
                    notifyReloadAsset();
                }
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addRenderCallback(@NotNull IRenderCallback callback) {
                Intrinsics.checkParameterIsNotNull(callback, "callback");
                this.$$delegate_0.addRenderCallback(callback);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addRenderNode(@NotNull BaseEffectNode effectNode) {
                Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
                this.$$delegate_0.addRenderNode(effectNode);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addRenderTarget(@NotNull Entity entity, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher2, entity, EntityNodeType.ROOT_ENTITY, 0, 4, null);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addSessionListener(@NotNull ISessionListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                this.$$delegate_0.addSessionListener(listener);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addVideoSourceEntity(@NotNull Entity entity, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.d(entity, EntityNodeType.MULTI_MEDIA, index);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addVideoSourceEntityAfterLutFilter(@NotNull Entity entity) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                RenderDataDispatcher.e(renderDataDispatcher2, entity, EntityNodeType.MULTI_MEDIA_AFTER_LUT, 0, 4, null);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            public IPlayer bindCutPlayer(@NotNull IPlayer player) {
                Intrinsics.checkParameterIsNotNull(player, "player");
                return this.$$delegate_0.bindCutPlayer(player);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void bindPlayer(@NotNull IPlayer player) {
                Intrinsics.checkParameterIsNotNull(player, "player");
                this.$$delegate_0.bindPlayer(player);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public boolean componentSupportDynamicModify(@NotNull Component component) {
                Intrinsics.checkParameterIsNotNull(component, "component");
                return this.$$delegate_0.componentSupportDynamicModify(component);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public int createStickerTrackerManager(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull b stickerTrackerConfig) {
                Intrinsics.checkParameterIsNotNull(stickerTrackerManager, "stickerTrackerManager");
                Intrinsics.checkParameterIsNotNull(stickerTrackerConfig, "stickerTrackerConfig");
                return this.$$delegate_0.createStickerTrackerManager(stickerTrackerManager, stickerTrackerConfig);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void emit() {
                this.$$delegate_0.emit();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void flush() {
                this.$$delegate_0.flush();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void flushWithoutDelay() {
                this.$$delegate_0.flushWithoutDelay();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            public List<Entity> getAllImageStickerEntitys() {
                return this.$$delegate_0.getAllImageStickerEntitys();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public LAKRenderModel getAllInputSourceRenderModel() {
                return this.$$delegate_0.getAllInputSourceRenderModel();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            public List<Entity> getAllTextEntity(@Nullable Entity rootEntity) {
                return this.$$delegate_0.getAllTextEntity(rootEntity);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public long getClipAssetsDurationUs() {
                return this.$$delegate_0.getClipAssetsDurationUs();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            /* renamed from: getClipSourceOperator */
            public IClipSourceOperator getIClipSourceOperator() {
                return this.$$delegate_0.getIClipSourceOperator();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            /* renamed from: getComponentOperator */
            public d getIComponentOperator() {
                return this.$$delegate_0.getIComponentOperator();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public List<TextPlaceInfo> getEditableTextByEntityId(int entityId) {
                return this.$$delegate_0.getEditableTextByEntityId(entityId);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public TextPlaceInfo getEditableTextUnderPoint(float x16, float y16) {
                return this.$$delegate_0.getEditableTextUnderPoint(x16, y16);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            public ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16) {
                return this.$$delegate_0.getEntitiesUnderPoint(x16, y16);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public long getFrameDuration() {
                return this.$$delegate_0.getFrameDuration();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public JsonObject getInputSources() {
                return this.$$delegate_0.getInputSources();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public LightAsset getLightAsset() {
                return this.$$delegate_0.getLightAsset();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public LightAssetDataContext getLightAssetDataContext() {
                return this.$$delegate_0.getLightAssetDataContext();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public MaterialConfig[] getMaterialConfig() {
                return this.$$delegate_0.getMaterialConfig();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public Boolean getMediasTotalDurationLimitationFlag() {
                return this.$$delegate_0.getMediasTotalDurationLimitationFlag();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public TemplateConfig getMovieConfig() {
                return this.$$delegate_0.getMovieConfig();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public float getOriginVolume(float defaultVolume) {
                return this.$$delegate_0.getOriginVolume(defaultVolume);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public IPlayer getPlayer() {
                return this.$$delegate_0.getPlayer();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public LAKRenderModel getRenderModel() {
                return this.$$delegate_0.getRenderModel();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public Entity getRootEntity() {
                return this.$$delegate_0.getRootEntity();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public long getTotalDurationUs() {
                return this.$$delegate_0.getTotalDurationUs();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public Boolean needRenderAbility(@NotNull String aiType) {
                Intrinsics.checkParameterIsNotNull(aiType, "aiType");
                return this.$$delegate_0.needRenderAbility(aiType);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void notifyReloadAsset() {
                this.$$delegate_0.notifyReloadAsset();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void pushCustomCommand(@NotNull Function1<? super ICutSession, Unit> runnable) {
                Intrinsics.checkParameterIsNotNull(runnable, "runnable");
                this.$$delegate_0.pushCustomCommand(runnable);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void pushCustomCommandSync(@NotNull Function1<? super ICutSession, Unit> runnable) {
                Intrinsics.checkParameterIsNotNull(runnable, "runnable");
                this.$$delegate_0.pushCustomCommandSync(runnable);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @NotNull
            public <T extends Component> List<Entity> queryEntityByComponent(@NotNull KClass<T> clazz) {
                Intrinsics.checkParameterIsNotNull(clazz, "clazz");
                return this.$$delegate_0.queryEntityByComponent(clazz);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
                Intrinsics.checkParameterIsNotNull(fontFamily, "fontFamily");
                Intrinsics.checkParameterIsNotNull(fontStyle, "fontStyle");
                Intrinsics.checkParameterIsNotNull(fontPath, "fontPath");
                this.$$delegate_0.registerFont(fontFamily, fontStyle, fontPath);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void release() {
                this.$$delegate_0.release();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void removeEntity(@NotNull Entity entity) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                TavLogger.d(LAKTavCutSessionKt.TAG, "remove entity id: " + entity.getId());
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.C(entity);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            @Nullable
            public InputSource removeInputSource(@NotNull String sourceKey) {
                Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
                return this.$$delegate_0.removeInputSource(sourceKey);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void removeRenderCallback(@NotNull IRenderCallback callback) {
                Intrinsics.checkParameterIsNotNull(callback, "callback");
                this.$$delegate_0.removeRenderCallback(callback);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void removeRenderNode(@NotNull BaseEffectNode effectNode) {
                Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
                this.$$delegate_0.removeRenderNode(effectNode);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void removeSessionListener(@NotNull ISessionListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                this.$$delegate_0.removeSessionListener(listener);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void runOnPlayerThread(@NotNull Function0<Unit> runnable) {
                Intrinsics.checkParameterIsNotNull(runnable, "runnable");
                this.$$delegate_0.runOnPlayerThread(runnable);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void seek(long timeUs) {
                this.$$delegate_0.seek(timeUs);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
                Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
                Intrinsics.checkParameterIsNotNull(assetData, "assetData");
                this.$$delegate_0.setAssetData(templatePath, assetData);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setBgColor(int bgColor) {
                this.$$delegate_0.setBgColor(bgColor);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setCutStatusListener(@Nullable ICutStatusCallback listener) {
                this.$$delegate_0.setCutStatusListener(listener);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setDedaultRenderModel() {
                this.$$delegate_0.setDedaultRenderModel();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setLoadAssetListener(@NotNull OnLoadAssetListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                this.$$delegate_0.setLoadAssetListener(listener);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setMediasTotalDurationLimitationFlag(boolean isLimited) {
                this.$$delegate_0.setMediasTotalDurationLimitationFlag(isLimited);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setOriginVolume(float volume) {
                this.$$delegate_0.setOriginVolume(volume);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setOriginVolumeForClip(int index, float volume) {
                this.$$delegate_0.setOriginVolumeForClip(index, volume);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel) {
                Intrinsics.checkParameterIsNotNull(LAKRenderModel, "LAKRenderModel");
                this.$$delegate_0.setRenderModel(LAKRenderModel);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setRenderTimeListener(@NotNull IRenderTimeListener listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                this.$$delegate_0.setRenderTimeListener(listener);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setTemplateDir(@NotNull String path) {
                Intrinsics.checkParameterIsNotNull(path, "path");
                this.$$delegate_0.setTemplateDir(path);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setTransition(@NotNull Entity entity, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                RenderDataDispatcher renderDataDispatcher3;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                TavLogger.d(LAKTavCutSessionKt.TAG, "add transition in setTransition index: " + index);
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.d(entity, EntityNodeType.TRANSITION_TRIGGER, index);
                renderDataDispatcher3 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher3.z();
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setWatermarkConfig(@Nullable WatermarkConfig config) {
                this.$$delegate_0.setWatermarkConfig(config);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void switchEntity(@NotNull Entity entity, boolean enable) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                Collection<Component> components = entity.getComponents();
                Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
                for (Component component : components) {
                    if (component instanceof ScreenTransform) {
                        ((ScreenTransform) component).setObjectEnabled(enable);
                    }
                }
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void switchEntitySync(@NotNull Entity entity, boolean enable) {
                IRenderChainManager iRenderChainManager;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                Collection<Component> components = entity.getComponents();
                Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
                for (Component component : components) {
                    if (component instanceof ScreenTransform) {
                        ((ScreenTransform) component).setObjectEnabled(enable);
                    }
                }
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                if (iRenderChainManager != null) {
                    iRenderChainManager.emit();
                }
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable) {
                Intrinsics.checkParameterIsNotNull(type, "type");
                this.$$delegate_0.switchPicEnhanceAbility(type, enable);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void unbindCutPlayer(@Nullable IPlayer player) {
                this.$$delegate_0.unbindCutPlayer(player);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void unbindPlayer(@Nullable IPlayer player) {
                this.$$delegate_0.unbindPlayer(player);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String pagFilePath) {
                Intrinsics.checkParameterIsNotNull(backColor, "backColor");
                this.$$delegate_0.updateBackground(backgroundFillMode, backColor, pagFilePath);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void updateRenderSize(@NotNull Size renderSize) {
                Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
                this.$$delegate_0.updateRenderSize(renderSize);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity, @Nullable IStickerUpdateCallback callback) {
                Intrinsics.checkParameterIsNotNull(stickerName, "stickerName");
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                return this.$$delegate_0.updateTrackedStickerPosition(stickerTrackerResult, stickerName, entity, callback);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void updateVolume(float volume) {
                this.$$delegate_0.updateVolume(volume);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void addEffect(@NotNull Entity entity, @NotNull EntityNodeType entityType, int index) {
                RenderDataDispatcher renderDataDispatcher2;
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                Intrinsics.checkParameterIsNotNull(entityType, "entityType");
                renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                renderDataDispatcher2.d(entity, entityType, index);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void flushWithoutDelay(boolean needFlushPlayer, long targetTime) {
                this.$$delegate_0.flushWithoutDelay(needFlushPlayer, targetTime);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel, boolean needInitTemplate) {
                Intrinsics.checkParameterIsNotNull(LAKRenderModel, "LAKRenderModel");
                this.$$delegate_0.setRenderModel(LAKRenderModel, needInitTemplate);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void updateRenderSize(@NotNull Size renderSize, float fillScale) {
                Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
                this.$$delegate_0.updateRenderSize(renderSize, fillScale);
            }

            @Override // com.tencent.tavcut.core.session.ICutSession
            public void updateVolume(float volume, @Nullable AudioSourceType type) {
                IRenderChainManager iRenderChainManager;
                IRenderChainManager iRenderChainManager2;
                RenderDataDispatcher renderDataDispatcher2;
                iRenderChainManager = LAKCutSession.this.playerRenderChainManager;
                Entity rootEntity = iRenderChainManager != null ? iRenderChainManager.getRootEntity() : null;
                List<Entity> entitiesWithComponent = rootEntity != null ? rootEntity.getEntitiesWithComponent(AudioSource.class) : null;
                if (entitiesWithComponent != null) {
                    for (Entity entity : entitiesWithComponent) {
                        Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
                        Collection<Component> components = entity.getComponents();
                        Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
                        for (Component component : components) {
                            if (component instanceof AudioSource) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("updateVolume:");
                                sb5.append(volume);
                                sb5.append(", componentType: ");
                                AudioSource audioSource = (AudioSource) component;
                                sb5.append(audioSource.getAudioSourceType());
                                sb5.append(", type: ");
                                sb5.append(type);
                                TavLogger.i(LAKTavCutSessionKt.TAG, sb5.toString());
                                if (type == null || type == audioSource.getAudioSourceType()) {
                                    audioSource.setVolume(volume);
                                }
                            }
                            iRenderChainManager2 = LAKCutSession.this.playerRenderChainManager;
                            if (iRenderChainManager2 != null) {
                                Intrinsics.checkExpressionValueIsNotNull(component, "component");
                                if (!iRenderChainManager2.componentSupportDynamicModify(component)) {
                                    renderDataDispatcher2 = LAKCutSession.this.dataDispatcher;
                                    renderDataDispatcher2.z();
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateRenderSize(@NotNull Size renderSize, float fillScale) {
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        updateRenderModelSize(renderSize, fillScale);
        synchronized (this.renderChainManagerInitInfo) {
            if (this.playerRenderChainManager == null) {
                this.renderChainManagerInitInfo.setRenderSize(TuplesKt.to(renderSize, Float.valueOf(fillScale)));
            } else {
                updatePainting(Painting.copy$default(this.dataDispatcher.getLakRenderModel().getPainting(), null, null, renderSize, Float.valueOf(fillScale), null, 19, null));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setDedaultRenderModel() {
    }
}
