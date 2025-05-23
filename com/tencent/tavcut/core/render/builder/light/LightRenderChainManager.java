package com.tencent.tavcut.core.render.builder.light;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.render.EffectDispatcher;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.LightAiManager;
import com.tencent.tavcut.core.render.LightAssetDataHolder;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.builder.light.model.TextPlaceInfo;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import com.tencent.tavcut.core.render.font.FontCacheManager;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.render.rendernode.LightRenderNode;
import com.tencent.tavcut.core.render.rendernode.NodeOrderUtils;
import com.tencent.tavcut.core.render.rendernode.audio.LightAudioNode;
import com.tencent.tavcut.core.render.util.CMTimeUtil;
import com.tencent.tavcut.core.session.IRenderCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.LightContextReadyCallback;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.videocut.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MaterialConfig;
import org.light.MovieConfig;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TextAsset;
import org.light.TextPlaceHolder;
import org.light.TimeLine;
import org.light.TimeRange;
import org.light.VideoOutputConfig;
import org.light.callback.ExternalRenderCallback;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetDataType;
import org.light.lightAssetKit.components.Camera;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.FilterGroup;
import org.light.lightAssetKit.components.LUTFilter;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.Transition;
import org.light.lightAssetKit.components.TransitionTrigger;
import org.light.lightAssetKit.enums.BackgroundFillMode;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;
import rd4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00f2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00ec\u00012\u00020\u0001:\u0004\u00ec\u0001\u00ed\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0016J4\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020A2\"\u0010D\u001a\u001e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0Ej\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A`FH\u0016J \u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0016J\u001a\u0010N\u001a\u00020\u00142\u0006\u0010@\u001a\u00020A2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\u0014H\u0002J\u0006\u0010X\u001a\u00020MJ\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\fJ\u0010\u0010\\\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020`2\u0006\u0010[\u001a\u00020\fH\u0002J\b\u0010a\u001a\u00020KH\u0002J\u0010\u0010b\u001a\u00020`2\u0006\u0010[\u001a\u00020\fH\u0002J\b\u0010c\u001a\u00020\u0014H\u0016J\u0010\u0010d\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020KH\u0016J0\u0010f\u001a\b\u0012\u0004\u0012\u00020K0\u000e\"\b\b\u0000\u0010g*\u00020^2\b\u0010e\u001a\u0004\u0018\u00010K2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002Hg0iH\u0016J\n\u0010j\u001a\u0004\u0018\u00010KH\u0002J\n\u0010k\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010l\u001a\u00020\u00142\u0006\u0010m\u001a\u00020nH\u0002J\u0012\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010A2\u0006\u0010t\u001a\u00020uH\u0002J\u0016\u0010v\u001a\u00020A2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010y\u001a\u00020\fH\u0016J0\u0010z\u001a\"\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0018\u00010Ej\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0018\u0001`F2\u0006\u0010C\u001a\u00020AH\u0016J\u0018\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010\u000e2\u0006\u0010}\u001a\u00020MH\u0016J\u001b\u0010~\u001a\u0004\u0018\u00010|2\u0006\u0010\u007f\u001a\u00020p2\u0007\u0010\u0080\u0001\u001a\u00020pH\u0016J,\u0010\u0081\u0001\u001a\u0014\u0012\u0004\u0012\u00020M0\u0082\u0001j\t\u0012\u0004\u0012\u00020M`\u0083\u00012\u0006\u0010\u007f\u001a\u00020p2\u0007\u0010\u0080\u0001\u001a\u00020pH\u0016J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010 H\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\"H\u0016J\u001b\u0010\u0087\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u0001H\u0016\u00a2\u0006\u0003\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020M2\u0006\u0010e\u001a\u00020KH\u0002J\t\u0010\u008c\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001eH\u0016\u00a2\u0006\u0003\u0010\u008e\u0001J\f\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\t\u0010\u0091\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020p2\u0007\u0010\u0093\u0001\u001a\u00020pH\u0016J\t\u0010\u0094\u0001\u001a\u00020\fH\u0016J\u000b\u0010\u0095\u0001\u001a\u0004\u0018\u00010KH\u0016J)\u0010\u0096\u0001\u001a\u00020\u00142\u000f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0088\u00012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\f\u00a2\u0006\u0003\u0010\u009a\u0001J,\u0010\u009b\u0001\u001a\u00020\u00142\u0006\u0010m\u001a\u00020n2\u0007\u0010\u009c\u0001\u001a\u00020A2\u0007\u0010\u009d\u0001\u001a\u00020M2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u001eJ\u0010\u0010\u009f\u0001\u001a\u00020\u00142\u0007\u0010\u009c\u0001\u001a\u00020AJ#\u0010\u009f\u0001\u001a\u00020\u00142\u0007\u0010\u009c\u0001\u001a\u00020A2\u0006\u0010m\u001a\u00020n2\t\b\u0002\u0010\u00a0\u0001\u001a\u00020\u001eJ\u0007\u0010\u00a1\u0001\u001a\u00020\u0014J\"\u0010\u00a2\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020A2\u0006\u0010m\u001a\u00020n2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u001eJ\u0012\u0010\u00a3\u0001\u001a\u00020\u001e2\u0007\u0010\u00a4\u0001\u001a\u00020?H\u0016J\u001f\u0010\u00a5\u0001\u001a\u00020\u001e2\t\u0010\u00a6\u0001\u001a\u0004\u0018\u00010r2\t\u0010\u00a7\u0001\u001a\u0004\u0018\u00010rH\u0002J\t\u0010\u00a8\u0001\u001a\u00020\u0014H\u0002J\u001e\u0010\u00a9\u0001\u001a\u00020\u00142\t\u0010\u00aa\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0002J\u001a\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u00ae\u0001\u001a\u00020AH\u0016\u00a2\u0006\u0003\u0010\u00af\u0001J\t\u0010\u00b0\u0001\u001a\u00020\u0014H\u0016J$\u0010\u00b1\u0001\u001a\u00020\u00142\u0019\u0010\u00b2\u0001\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J$\u0010\u00b3\u0001\u001a\u00020\u00142\u0019\u0010\u00b2\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u000e\u0012\u0004\u0012\u00020\u001406H\u0016J\t\u0010\u00b4\u0001\u001a\u00020\u0014H\u0016J%\u0010\u00b5\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020A2\t\u0010\u00b6\u0001\u001a\u0004\u0018\u00010n2\u0007\u0010\u0099\u0001\u001a\u00020\fH\u0016J\t\u0010\u00b7\u0001\u001a\u00020\u0014H\u0002J\u0011\u0010\u00b8\u0001\u001a\u00020\u00142\u0006\u0010e\u001a\u00020KH\u0016J\u0011\u0010\u00b9\u0001\u001a\u00020\u00142\u0006\u0010@\u001a\u00020AH\u0016J\u0011\u0010\u00ba\u0001\u001a\u00020\u00142\u0006\u0010R\u001a\u00020SH\u0016J\u0011\u0010\u00bb\u0001\u001a\u00020\u00142\u0006\u0010U\u001a\u00020VH\u0016J\u0018\u0010\u00bc\u0001\u001a\u00020\u00142\r\u0010\u00bd\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\t\u0010\u00be\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u00be\u0001\u001a\u00020\u00142\u0007\u0010\u00bf\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00c0\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u00c0\u0001\u001a\u00020\u00142\u0007\u0010\u00bf\u0001\u001a\u00020\u0005H\u0016J1\u0010\u00c1\u0001\u001a\u00020\u00142&\u0010D\u001a\"\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0018\u00010Ej\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0018\u0001`FH\u0016J\u0014\u0010\u00c2\u0001\u001a\u00020\u00142\t\u0010\u00c3\u0001\u001a\u0004\u0018\u00010\nH\u0016J)\u0010\u00c4\u0001\u001a\u00020\u00142\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\t\u0010\u00c5\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ)\u0010\u00c7\u0001\u001a\u00020\u00142\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\t\u0010\u00c5\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010\u00c6\u0001\u001a\u00020\u001eJ\u0013\u0010\u00c8\u0001\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0011\u0010\u00c9\u0001\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u00ca\u0001\u001a\u00020\u00142\u0007\u0010\u00cb\u0001\u001a\u00020\u001eH\u0016J\u001b\u0010\u00cc\u0001\u001a\u00020\u00142\u0007\u0010\u00cd\u0001\u001a\u00020A2\u0007\u0010\u00ce\u0001\u001a\u00020AH\u0016J\u0013\u0010\u00cf\u0001\u001a\u00020\u00142\b\u0010\u00c3\u0001\u001a\u00030\u00d0\u0001H\u0016J\u0012\u0010\u00d1\u0001\u001a\u00020\u00142\u0007\u0010\u00d2\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010\u00d3\u0001\u001a\u00020\u00142\u0007\u0010\u00d4\u0001\u001a\u00020pH\u0016J\u001a\u0010\u00d5\u0001\u001a\u00020\u00142\u0006\u0010L\u001a\u00020M2\u0007\u0010\u00d4\u0001\u001a\u00020pH\u0016J\u0011\u0010\u00d6\u0001\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\fH\u0016J\u001b\u0010\u00d7\u0001\u001a\u00020\u00142\u0007\u0010\u00d8\u0001\u001a\u00020\u001e2\u0007\u0010\u00d9\u0001\u001a\u00020MH\u0016J\u0012\u0010\u00da\u0001\u001a\u00020\u00142\u0007\u0010\u00c3\u0001\u001a\u000204H\u0016J\u0015\u0010\u00db\u0001\u001a\u00020\u00142\n\u0010\u00dc\u0001\u001a\u0005\u0018\u00010\u00dd\u0001H\u0016J\u0010\u0010\u00de\u0001\u001a\u00020\u00142\u0007\u0010\u00df\u0001\u001a\u00020AJ\u001b\u0010\u00e0\u0001\u001a\u00020\u00142\u0010\u0010\u00e1\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00e2\u0001\u0018\u00010\u000eH\u0016J\u001c\u0010\u00e3\u0001\u001a\u00020\u00142\b\u0010\u00ab\u0001\u001a\u00030\u00e4\u00012\u0007\u0010\u00d8\u0001\u001a\u00020\u001eH\u0016J\u0019\u0010\u00e5\u0001\u001a\u00020\u00142\u0006\u0010}\u001a\u00020M2\u0006\u0010]\u001a\u00020^H\u0016J\u0010\u0010\u00e6\u0001\u001a\u00020\u00142\u0007\u0010\u00e7\u0001\u001a\u00020\fJ\u0012\u0010\u00e8\u0001\u001a\u00020\u00142\u0007\u0010\u00e9\u0001\u001a\u00020rH\u0016J\u0012\u0010\u00ea\u0001\u001a\u00020\u00142\u0007\u0010\u00e9\u0001\u001a\u00020rH\u0016J\u0012\u0010\u00eb\u0001\u001a\u00020\u00142\u0007\u0010\u00a4\u0001\u001a\u00020?H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u000e\u0012\u0004\u0012\u00020\u001406X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00ee\u0001"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager;", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "()V", "afterEventQueue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "assetDataHolder", "Lcom/tencent/tavcut/core/render/LightAssetDataHolder;", "beforeEventQueue", "clipAssetListener", "Lorg/light/listener/OnClipAssetListener;", "clipAssetsDuration", "", "curClipAssets", "", "Lorg/light/ClipAsset;", "customRenderConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "durationObserver", "Lkotlin/Function2;", "", "getDurationObserver", "()Lkotlin/jvm/functions/Function2;", "setDurationObserver", "(Lkotlin/jvm/functions/Function2;)V", "effectDispatcher", "Lcom/tencent/tavcut/core/render/EffectDispatcher;", "gson", "Lcom/google/gson/Gson;", "isUseMovieControllerDuration", "", "lightAsset", "Lorg/light/LightAsset;", "lightAssetDataContext", "Lorg/light/lightAssetKit/LightAssetDataContext;", "lightAudioNode", "Lcom/tencent/tavcut/core/render/rendernode/audio/LightAudioNode;", "lightEngine", "Lorg/light/LightEngine;", "lightRenderNode", "Lcom/tencent/tavcut/core/render/rendernode/LightRenderNode;", "movieConfig", "Lorg/light/MovieConfig;", "movieController", "Lorg/light/MovieController;", "getMovieController", "()Lorg/light/MovieController;", "setMovieController", "(Lorg/light/MovieController;)V", "movieControllerDuration", "playerDuration", "renderTimeListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "timelineObserver", "Lkotlin/Function1;", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "getTimelineObserver", "()Lkotlin/jvm/functions/Function1;", "setTimelineObserver", "(Lkotlin/jvm/functions/Function1;)V", "voiceChangerWrapper", "Lcom/tencent/tavcut/core/render/builder/light/VoiceChangerWrapper;", "accessInputSource", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "key", "", "addAssetDataToHolder", "templateDir", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addEntity", "entityNodeType", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityToAdd", "Lorg/light/lightAssetKit/Entity;", "index", "", "addExternalRenderCallback", "externalRenderCallback", "Lorg/light/callback/ExternalRenderCallback;", "addRenderCallback", "callback", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "addRenderNode", "effectNode", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "afterAllNodeRelease", "authLightSdk", "buildComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "duration", "componentSupportDynamicModify", HippyQQConstants.URL_COMPONENT_NAME, "Lorg/light/lightAssetKit/components/Component;", "createAudioClip", "Lcom/tencent/tavkit/composition/TAVClip;", "createFilterGroupEntity", "createVideoClip", "emit", "entitySupportDynamicAdd", "entity", "findEntitiesByComponent", "T", "componentClass", "Lkotlin/reflect/KClass;", "findFirstFilterGroup", "findMultiMediaEntity", "flushRenderSize", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getBackgroundFillScale", "", "renderSize", "Lorg/light/lightAssetKit/components/Size;", "getBackgroundPagPath", "backGround", "Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "getClipAssetLogInfo", "clipAssets", "getClipAssets", "getClipAssetsDuration", "getCurrentAssetData", "getEditableTextByEntityId", "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", TemplateParser.KEY_ENTITY_ID, "getEditableTextUnderPoint", HippyTKDListViewAdapter.X, "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGson", "getLightAsset", "getLightAssetContext", "getMaterialConfig", "", "Lorg/light/MaterialConfig;", "()[Lorg/light/MaterialConfig;", "getMaxLutIndex", "getMediaDuration", "getMediasTotalDurationLimitationFlag", "()Ljava/lang/Boolean;", "getMovieConfig", "Lorg/light/TemplateConfig;", "getMovieControllerDuration", "getOriginVolume", "defaultVolume", "getPlayerDuration", "getRootEntity", "initDuration", "timelines", "Lorg/light/TimeLine;", "targetTime", "([Lorg/light/TimeLine;J)V", "initEngine", "templatePath", "seekTolerance", "isUE4Template", "initLightAsset", "loadFromJson", "initLightAudioNode", "initLightNode", "isInputSourceAdded", "inputSource", "isRenderSizeEqual", "originSize", "updateSize", "lightAssetDataContextBindController", "makeLightAssetDataContext", "asset", "type", "Lorg/light/lightAssetKit/LightAssetDataType;", "needRenderAbility", "aiType", "(Ljava/lang/String;)Ljava/lang/Boolean;", "notifyDurationChange", "registerDurationObserver", "observer", "registerTimelineObserver", "release", "reloadAsset", "lakRenderModel", "reloadLightAsset", "removeEntity", "removeExternalRenderCallback", "removeRenderCallback", "removeRenderNode", "runAll", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "runOnAfterApply", "runnable", "runOnBeforeApply", "setAssetData", "setClipAssetListener", "listener", "setClipAssets", "backgroundPagPath", "modifyClipsDuration", "setClipAssetsWithCallback", "setCustomRenderConfig", "setEffectDispatcher", "setIsUseTemplateTime", "isUseTemplateTime", "setLightAIModelPath", "agentName", "bundlePath", "setLoadAssetListener", "Lorg/light/listener/OnLoadAssetListener;", "setMediasTotalDurationLimitationFlag", "isLimited", "setOriginVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setOriginVolumeForClip", "setRenderNodeDuration", "setRenderSyncMode", "enable", "frameRate", "setRenderTimeListener", "setRenderTimeRange", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "setTextAsset", "value", "setVoiceChangerConfig", DownloadInfo.spKey_Config, "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", "switchPicEnhanceAbility", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "updateComponent", "updatePlayerDuration", "newDuration", "updatePropertyLayout", "size", "updateRenderSize", "updateResource", "Companion", "EffectDispatchListener", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightRenderChainManager implements IRenderChainManager {
    public static final int AUDIO_CHANNEL_MONO = 1;
    public static final int AUDIO_SAMPLE_COUNT = 2646;
    public static final int AUDIO_SAMPLE_RATE_IN_HZ = 44100;
    private static final float DEFAULT_FRAME_RATE = 30.0f;
    private static final String LIGHT_VIDEO_SOURCE_TYPE = "VideoSource";
    private static final String TAG = "LightRenderChainManager";
    private static final int TEMPLATE_JSON_EMPTY = -400;
    private static final int TEMPLATE_JSON_NO_ROOT = -1400;
    private LightAssetDataHolder assetDataHolder;
    private OnClipAssetListener clipAssetListener;
    private long clipAssetsDuration;
    private List<? extends ClipAsset> curClipAssets;
    private CustomRenderConfig customRenderConfig;
    private EffectDispatcher effectDispatcher;
    private Gson gson;
    private boolean isUseMovieControllerDuration;
    private LightAsset lightAsset;
    private LightAssetDataContext lightAssetDataContext;
    private LightAudioNode lightAudioNode;
    private LightEngine lightEngine;
    private LightRenderNode lightRenderNode;
    private MovieConfig movieConfig;

    @Nullable
    private MovieController movieController;
    private long movieControllerDuration;
    private long playerDuration;
    private IRenderTimeListener renderTimeListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CopyOnWriteArraySet<MovieController> voiceProcessorRef = new CopyOnWriteArraySet<>();
    private static final LightRenderChainManager$Companion$ASSET_LISTENER_DEFAULT$1 ASSET_LISTENER_DEFAULT = new OnLoadAssetListener() { // from class: com.tencent.tavcut.core.render.builder.light.LightRenderChainManager$Companion$ASSET_LISTENER_DEFAULT$1
        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long p06) {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(@Nullable HashMap<String, String> p06) {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int p06) {
        }
    };
    private final VoiceChangerWrapper voiceChangerWrapper = new VoiceChangerWrapper();

    @NotNull
    private Function1<? super List<Timeline>, Unit> timelineObserver = new Function1<List<? extends Timeline>, Unit>() { // from class: com.tencent.tavcut.core.render.builder.light.LightRenderChainManager$timelineObserver$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<Timeline> it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Timeline> list) {
            invoke2((List<Timeline>) list);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    private Function2<? super Long, ? super Long, Unit> durationObserver = new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.core.render.builder.light.LightRenderChainManager$durationObserver$1
        public final void invoke(long j3, long j16) {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16) {
            invoke(l3.longValue(), l16.longValue());
            return Unit.INSTANCE;
        }
    };
    private final Queue<Runnable> afterEventQueue = new LinkedList();
    private final Queue<Runnable> beforeEventQueue = new LinkedList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager$Companion;", "", "()V", "ASSET_LISTENER_DEFAULT", "com/tencent/tavcut/core/render/builder/light/LightRenderChainManager$Companion$ASSET_LISTENER_DEFAULT$1", "Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager$Companion$ASSET_LISTENER_DEFAULT$1;", "AUDIO_CHANNEL_MONO", "", "AUDIO_SAMPLE_COUNT", "AUDIO_SAMPLE_RATE_IN_HZ", "DEFAULT_FRAME_RATE", "", "LIGHT_VIDEO_SOURCE_TYPE", "", "TAG", "TEMPLATE_JSON_EMPTY", "TEMPLATE_JSON_NO_ROOT", "voiceProcessorRef", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lorg/light/MovieController;", "voiceProcessorRef$annotations", "getVoiceProcessorRef", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "setLightLogLevel", "", "level", "convertToInfo", "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", "Lorg/light/TextPlaceHolder;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextPlaceInfo convertToInfo(@NotNull TextPlaceHolder textPlaceHolder) {
            int i3 = textPlaceHolder.entityId;
            return new TextPlaceInfo(textPlaceHolder.key, textPlaceHolder.text, textPlaceHolder.fillColor, textPlaceHolder.maxLength, textPlaceHolder.layerWidth, textPlaceHolder.layerHeight, textPlaceHolder.replaceIndex, i3);
        }

        @NotNull
        public final CopyOnWriteArraySet<MovieController> getVoiceProcessorRef() {
            return LightRenderChainManager.voiceProcessorRef;
        }

        @JvmStatic
        public final void setLightLogLevel(int level) {
            LightLogUtil.setMinPriority(level);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void voiceProcessorRef$annotations() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager$EffectDispatchListener;", "Lcom/tencent/tavcut/core/render/EffectDispatcher$EffectDispatchListener;", "renderManager", "Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager;", "(Lcom/tencent/tavcut/core/render/builder/light/LightRenderChainManager;)V", "reference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getReference", "()Ljava/lang/ref/WeakReference;", "onAfterApply", "", "onBeforeApply", "releaseAfterAllNode", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class EffectDispatchListener implements EffectDispatcher.EffectDispatchListener {

        @NotNull
        private final WeakReference<LightRenderChainManager> reference;

        public EffectDispatchListener(@NotNull LightRenderChainManager renderManager) {
            Intrinsics.checkParameterIsNotNull(renderManager, "renderManager");
            this.reference = new WeakReference<>(renderManager);
        }

        @NotNull
        public final WeakReference<LightRenderChainManager> getReference() {
            return this.reference;
        }

        @Override // com.tencent.tavcut.core.render.EffectDispatcher.EffectDispatchListener
        public void onAfterApply() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.runOnAfterApply();
            }
        }

        @Override // com.tencent.tavcut.core.render.EffectDispatcher.EffectDispatchListener
        public void onBeforeApply() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.runOnBeforeApply();
            }
        }

        @Override // com.tencent.tavcut.core.render.EffectDispatcher.EffectDispatchListener
        public void releaseAfterAllNode() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.afterAllNodeRelease();
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EntityNodeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EntityNodeType.ROOT_ENTITY.ordinal()] = 1;
            iArr[EntityNodeType.CAMERA_ENTITY.ordinal()] = 2;
            iArr[EntityNodeType.MULTI_MEDIA.ordinal()] = 3;
            iArr[EntityNodeType.MULTI_MEDIA_AFTER_LUT.ordinal()] = 4;
            iArr[EntityNodeType.FILTER_GROUP.ordinal()] = 5;
            iArr[EntityNodeType.TRANSITION_TRIGGER.ordinal()] = 6;
            int[] iArr2 = new int[Constants.ENHANCE_TYPE.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Constants.ENHANCE_TYPE.BLUR.ordinal()] = 1;
            iArr2[Constants.ENHANCE_TYPE.WATERMARK.ordinal()] = 2;
            iArr2[Constants.ENHANCE_TYPE.HDR.ordinal()] = 3;
            iArr2[Constants.ENHANCE_TYPE.FACEENHANCE.ordinal()] = 4;
        }
    }

    public LightRenderChainManager() {
        boolean z16;
        if (RenderConfig.INSTANCE.getRenderAssetDir().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (LightSDKUtils.INSTANCE.isSoLoaded()) {
                LightLogUtil.init();
                LightLogUtil.setMinPriority(TavLogger.INSTANCE.getLevel() + 1);
                FontCacheManager.INSTANCE.clearCache();
                return;
            }
            throw new IllegalStateException("so still not install, please load V8Jni and lightsdk so first");
        }
        throw new IllegalStateException("light_assets still not install, Use TavCut must install light_assets first !!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterAllNodeRelease() {
        TavLogger.d(TAG, "afterAllNodeRelease");
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.resetAsset();
        }
        this.voiceChangerWrapper.clearVoiceChangers(this.movieController);
        this.movieController = null;
        LightEngine lightEngine = this.lightEngine;
        if (lightEngine != null) {
            lightEngine.release();
        }
        this.lightEngine = null;
        this.lightAsset = null;
        EffectDispatcher effectDispatcher = this.effectDispatcher;
        if (effectDispatcher != null) {
            effectDispatcher.setEffectDispatchListener(null);
        }
        this.effectDispatcher = null;
    }

    private final TAVClip createAudioClip(long duration) {
        List<TAVAudioProcessorNode> listOf;
        TAVClip tAVClip = new TAVClip(new TAVEmptyResource(CMTimeUtil.INSTANCE.genCMTimeFromUs(duration)));
        TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.lightAudioNode);
        tAVAudioConfiguration.setAudioProcessorNodes(listOf);
        tAVClip.setAudioConfiguration(tAVAudioConfiguration);
        return tAVClip;
    }

    private final Entity createFilterGroupEntity() {
        FilterGroup d16 = c.f431135f.o().d();
        Entity entity = new Entity();
        entity.reset();
        entity.addComponent(d16);
        return entity;
    }

    private final TAVClip createVideoClip(long duration) {
        return new TAVClip(new TAVEmptyResource(CMTimeUtil.INSTANCE.genCMTimeFromUs(duration)));
    }

    private final Entity findFirstFilterGroup() {
        List<Entity> list;
        Object firstOrNull;
        Entity rootEntity;
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null && (rootEntity = lightAssetDataContext.getRootEntity()) != null) {
            list = rootEntity.getEntitiesWithComponent(FilterGroup.class);
        } else {
            list = null;
        }
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            return (Entity) firstOrNull;
        }
        return null;
    }

    private final void flushRenderSize(LAKRenderModel renderModel) {
        List<Entity> list;
        Integer num;
        Collection<Component> components;
        boolean z16;
        float backgroundFillScale;
        String str;
        Entity rootEntity = getRootEntity();
        Integer num2 = null;
        if (rootEntity != null) {
            list = rootEntity.getEntitiesWithComponent(MultiMedia.class);
        } else {
            list = null;
        }
        Painting painting = renderModel.getPainting();
        if (list != null) {
            for (Entity entity : list) {
                if (entity != null && (components = entity.getComponents()) != null) {
                    for (Component component : components) {
                        if (component instanceof MultiMedia) {
                            MultiMedia multiMedia = (MultiMedia) component;
                            if (!isRenderSizeEqual(multiMedia.getSize(), painting.getRenderSize())) {
                                Size renderSize = painting.getRenderSize();
                                if (renderSize != null) {
                                    updatePropertyLayout(renderSize);
                                }
                                multiMedia.setSize(painting.getRenderSize());
                                String backgroundPagPath = getBackgroundPagPath(painting);
                                if (painting.getBackgroundFillMode() != null) {
                                    multiMedia.setBackgroundFillMode(painting.getBackgroundFillMode());
                                }
                                boolean z17 = true;
                                if (painting.getBackgroundColor().length() > 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    if (backgroundPagPath != null && backgroundPagPath.length() != 0) {
                                        z17 = false;
                                    }
                                    if (z17) {
                                        str = painting.getBackgroundColor();
                                    } else {
                                        str = "";
                                    }
                                    multiMedia.setBackgroundColor(str);
                                }
                                Float fillScale = painting.getFillScale();
                                if (fillScale != null) {
                                    backgroundFillScale = fillScale.floatValue();
                                } else {
                                    backgroundFillScale = getBackgroundFillScale(painting.getRenderSize());
                                }
                                multiMedia.setFillScale(backgroundFillScale);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("modify multiMedia size ........width: ");
        Size renderSize2 = painting.getRenderSize();
        if (renderSize2 != null) {
            num = Integer.valueOf(renderSize2.width);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(" height: ");
        Size renderSize3 = painting.getRenderSize();
        if (renderSize3 != null) {
            num2 = Integer.valueOf(renderSize3.height);
        }
        sb5.append(num2);
        TavLogger.e(TAG, sb5.toString());
        emit();
    }

    private final float getBackgroundFillScale(Size renderSize) {
        if (renderSize != null && renderSize.width > renderSize.height) {
            return 1000.0f;
        }
        return 0.0f;
    }

    private final String getBackgroundPagPath(Painting backGround) {
        if (backGround.getBackgroundFillMode() == BackgroundFillMode.GaussianBlur) {
            return backGround.getPagPath();
        }
        return null;
    }

    private final String getClipAssetLogInfo(List<? extends ClipAsset> clipAssets) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clipAssets size: " + clipAssets.size() + ", duration: ");
        for (ClipAsset clipAsset : clipAssets) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(clipAsset.duration);
            sb6.append(',');
            sb5.append(sb6.toString());
        }
        String sb7 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb7, "logInfo.toString()");
        return sb7;
    }

    private final Gson getGson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder().create();
        }
        return this.gson;
    }

    private final int getMaxLutIndex(Entity entity) {
        List<Entity> children = entity.getChildren();
        Intrinsics.checkExpressionValueIsNotNull(children, "entity.children");
        int i3 = -1;
        int i16 = -1;
        for (Entity childEntity : children) {
            i16++;
            Intrinsics.checkExpressionValueIsNotNull(childEntity, "childEntity");
            Collection<Component> components = childEntity.getComponents();
            Intrinsics.checkExpressionValueIsNotNull(components, "childEntity.components");
            Iterator<T> it = components.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((Component) it.next()).getClass()), Reflection.getOrCreateKotlinClass(LUTFilter.class))) {
                    z16 = true;
                }
            }
            if (z16) {
                i3 = i16;
            }
        }
        return i3;
    }

    private final long getMediaDuration() {
        ClipInfo[][] clipInfos;
        Object lastOrNull;
        Object lastOrNull2;
        TimeRange timeRange;
        MovieController movieController = this.movieController;
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

    @NotNull
    public static final CopyOnWriteArraySet<MovieController> getVoiceProcessorRef() {
        return voiceProcessorRef;
    }

    public static /* synthetic */ void initDuration$default(LightRenderChainManager lightRenderChainManager, TimeLine[] timeLineArr, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        lightRenderChainManager.initDuration(timeLineArr, j3);
    }

    public static /* synthetic */ void initEngine$default(LightRenderChainManager lightRenderChainManager, LAKRenderModel lAKRenderModel, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        lightRenderChainManager.initEngine(lAKRenderModel, str, i3, z16);
    }

    public static /* synthetic */ void initLightAsset$default(LightRenderChainManager lightRenderChainManager, String str, LAKRenderModel lAKRenderModel, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        lightRenderChainManager.initLightAsset(str, lAKRenderModel, z16);
    }

    public static /* synthetic */ void initLightNode$default(LightRenderChainManager lightRenderChainManager, String str, LAKRenderModel lAKRenderModel, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        lightRenderChainManager.initLightNode(str, lAKRenderModel, z16);
    }

    private final boolean isRenderSizeEqual(Size originSize, Size updateSize) {
        Integer num;
        Integer num2;
        Integer num3;
        if (originSize == null && updateSize == null) {
            return true;
        }
        Integer num4 = null;
        if (originSize != null) {
            num = Integer.valueOf(originSize.width);
        } else {
            num = null;
        }
        if (updateSize != null) {
            num2 = Integer.valueOf(updateSize.width);
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (originSize != null) {
                num3 = Integer.valueOf(originSize.height);
            } else {
                num3 = null;
            }
            if (updateSize != null) {
                num4 = Integer.valueOf(updateSize.height);
            }
            if (Intrinsics.areEqual(num3, num4)) {
                return true;
            }
        }
        return false;
    }

    private final void lightAssetDataContextBindController() {
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null && lightAssetDataContext != null) {
            lightAssetDataContext.bindController(null);
        }
        LightAssetDataContext lightAssetDataContext2 = this.lightAssetDataContext;
        if (lightAssetDataContext2 != null) {
            lightAssetDataContext2.bindController(this.movieController);
        }
    }

    private final void makeLightAssetDataContext(LightAsset asset, LightAssetDataType type) {
        this.lightAssetDataContext = LightAssetDataContext.make(asset, type);
    }

    private final void reloadLightAsset() {
        LightAsset lightAsset;
        LightAsset lightAsset2 = this.lightAsset;
        if (lightAsset2 != null) {
            lightAsset2.performFinalize();
        }
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null) {
            lightAsset = lightAssetDataContext.exportLightAsset();
        } else {
            lightAsset = null;
        }
        this.lightAsset = lightAsset;
    }

    private final void runAll(Queue<Runnable> queue) {
        if (queue.isEmpty()) {
            return;
        }
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void setEffectDispatcher(EffectDispatcher effectDispatcher) {
        this.effectDispatcher = effectDispatcher;
        effectDispatcher.setEffectDispatchListener(new EffectDispatchListener(this));
    }

    @JvmStatic
    public static final void setLightLogLevel(int i3) {
        INSTANCE.setLightLogLevel(i3);
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public InputSource accessInputSource(@NotNull String key) {
        JsonObject inputSources;
        JsonObject jsonObject;
        JsonObject inputSources2;
        JsonElement jsonElement;
        Intrinsics.checkParameterIsNotNull(key, "key");
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext == null || (inputSources = lightAssetDataContext.getInputSources()) == null || !inputSources.has(key)) {
            return null;
        }
        try {
            LightAssetDataContext lightAssetDataContext2 = this.lightAssetDataContext;
            if (lightAssetDataContext2 != null && (inputSources2 = lightAssetDataContext2.getInputSources()) != null && (jsonElement = inputSources2.get(key)) != null) {
                jsonObject = jsonElement.getAsJsonObject();
            } else {
                jsonObject = null;
            }
            Gson gson = getGson();
            if (gson == null) {
                return null;
            }
            return (InputSource) gson.fromJson(String.valueOf(jsonObject), InputSource.class);
        } catch (Exception e16) {
            TavLogger.e(TAG, "accessInputSource error: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void addAssetDataToHolder(@NotNull String templateDir, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        if (this.assetDataHolder == null) {
            this.assetDataHolder = new LightAssetDataHolder();
        }
        LightAssetDataHolder lightAssetDataHolder = this.assetDataHolder;
        if (lightAssetDataHolder != null) {
            lightAssetDataHolder.setAssetData(templateDir, assetData);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0144  */
    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addEntity(@NotNull EntityNodeType entityNodeType, @NotNull Entity entityToAdd, int index) {
        Entity rootEntity;
        List<Entity> list;
        Object firstOrNull;
        Entity rootEntity2;
        Entity rootEntity3;
        List<Entity> list2;
        List<Entity> list3;
        String str;
        Collection<Component> components;
        Object firstOrNull2;
        Entity rootEntity4;
        Integer num;
        Intrinsics.checkParameterIsNotNull(entityNodeType, "entityNodeType");
        Intrinsics.checkParameterIsNotNull(entityToAdd, "entityToAdd");
        Entity entity = null;
        switch (WhenMappings.$EnumSwitchMapping$0[entityNodeType.ordinal()]) {
            case 1:
                LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
                if (lightAssetDataContext != null) {
                    rootEntity = lightAssetDataContext.getRootEntity();
                    entityToAdd.detach();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("add entity type: ");
                    sb5.append(entityNodeType);
                    sb5.append(" parentId: ");
                    if (rootEntity != null) {
                        num = Integer.valueOf(rootEntity.getId());
                    } else {
                        num = null;
                    }
                    sb5.append(num);
                    sb5.append(" entityToAdd: ");
                    sb5.append(entityToAdd.toJson());
                    sb5.append(" index: ");
                    sb5.append(index);
                    TavLogger.i(TAG, sb5.toString());
                    if (rootEntity == null) {
                        LightAssetDataContext lightAssetDataContext2 = this.lightAssetDataContext;
                        if (lightAssetDataContext2 != null) {
                            entity = lightAssetDataContext2.getRootEntity();
                        }
                        rootEntity = entity;
                    }
                    if (rootEntity != null) {
                        rootEntity.addChild(index, entityToAdd);
                        return;
                    }
                    return;
                }
                rootEntity = null;
                entityToAdd.detach();
                StringBuilder sb52 = new StringBuilder();
                sb52.append("add entity type: ");
                sb52.append(entityNodeType);
                sb52.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb52.append(num);
                sb52.append(" entityToAdd: ");
                sb52.append(entityToAdd.toJson());
                sb52.append(" index: ");
                sb52.append(index);
                TavLogger.i(TAG, sb52.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
            case 2:
                LightAssetDataContext lightAssetDataContext3 = this.lightAssetDataContext;
                if (lightAssetDataContext3 != null && (rootEntity2 = lightAssetDataContext3.getRootEntity()) != null) {
                    list = rootEntity2.getEntitiesWithComponent(Camera.class);
                } else {
                    list = null;
                }
                if (list != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    rootEntity = (Entity) firstOrNull;
                    entityToAdd.detach();
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append("add entity type: ");
                    sb522.append(entityNodeType);
                    sb522.append(" parentId: ");
                    if (rootEntity != null) {
                    }
                    sb522.append(num);
                    sb522.append(" entityToAdd: ");
                    sb522.append(entityToAdd.toJson());
                    sb522.append(" index: ");
                    sb522.append(index);
                    TavLogger.i(TAG, sb522.toString());
                    if (rootEntity == null) {
                    }
                    if (rootEntity != null) {
                    }
                }
                rootEntity = null;
                entityToAdd.detach();
                StringBuilder sb5222 = new StringBuilder();
                sb5222.append("add entity type: ");
                sb5222.append(entityNodeType);
                sb5222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb5222.append(num);
                sb5222.append(" entityToAdd: ");
                sb5222.append(entityToAdd.toJson());
                sb5222.append(" index: ");
                sb5222.append(index);
                TavLogger.i(TAG, sb5222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
            case 3:
                rootEntity = findMultiMediaEntity();
                entityToAdd.detach();
                StringBuilder sb52222 = new StringBuilder();
                sb52222.append("add entity type: ");
                sb52222.append(entityNodeType);
                sb52222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb52222.append(num);
                sb52222.append(" entityToAdd: ");
                sb52222.append(entityToAdd.toJson());
                sb52222.append(" index: ");
                sb52222.append(index);
                TavLogger.i(TAG, sb52222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
            case 4:
                rootEntity = findMultiMediaEntity();
                if (rootEntity != null) {
                    index = getMaxLutIndex(rootEntity) + 1;
                }
                entityToAdd.detach();
                StringBuilder sb522222 = new StringBuilder();
                sb522222.append("add entity type: ");
                sb522222.append(entityNodeType);
                sb522222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb522222.append(num);
                sb522222.append(" entityToAdd: ");
                sb522222.append(entityToAdd.toJson());
                sb522222.append(" index: ");
                sb522222.append(index);
                TavLogger.i(TAG, sb522222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
            case 5:
                rootEntity = findFirstFilterGroup();
                if (rootEntity == null) {
                    rootEntity = createFilterGroupEntity();
                    LightAssetDataContext lightAssetDataContext4 = this.lightAssetDataContext;
                    if (lightAssetDataContext4 != null && (rootEntity3 = lightAssetDataContext4.getRootEntity()) != null) {
                        rootEntity3.addChild(rootEntity);
                    }
                }
                entityToAdd.detach();
                StringBuilder sb5222222 = new StringBuilder();
                sb5222222.append("add entity type: ");
                sb5222222.append(entityNodeType);
                sb5222222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb5222222.append(num);
                sb5222222.append(" entityToAdd: ");
                sb5222222.append(entityToAdd.toJson());
                sb5222222.append(" index: ");
                sb5222222.append(index);
                TavLogger.i(TAG, sb5222222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
            case 6:
                LightAssetDataContext lightAssetDataContext5 = this.lightAssetDataContext;
                if (lightAssetDataContext5 != null && (rootEntity4 = lightAssetDataContext5.getRootEntity()) != null) {
                    list2 = rootEntity4.getEntitiesWithComponent(TransitionTrigger.class);
                } else {
                    list2 = null;
                }
                if (list2 != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    rootEntity = (Entity) firstOrNull2;
                } else {
                    rootEntity = null;
                }
                if (index >= 0) {
                    if (rootEntity != null) {
                        list3 = rootEntity.getChildren();
                    } else {
                        list3 = null;
                    }
                    if (list3 != null && index < rootEntity.getChildren().size()) {
                        List<Entity> children = rootEntity.getChildren();
                        if (children != null) {
                            entity = children.get(index);
                        }
                        Collection<Component> components2 = entityToAdd.getComponents();
                        Intrinsics.checkExpressionValueIsNotNull(components2, "entityToAdd.components");
                        Iterator<T> it = components2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Component component = (Component) it.next();
                                if (component instanceof Transition) {
                                    str = ((Transition) component).getSrc();
                                    Intrinsics.checkExpressionValueIsNotNull(str, "addComponent.src");
                                }
                            } else {
                                str = "";
                            }
                        }
                        if (entity != null && (components = entity.getComponents()) != null) {
                            for (Component component2 : components) {
                                if (component2 instanceof Transition) {
                                    ((Transition) component2).setSrc(str);
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                entityToAdd.detach();
                StringBuilder sb52222222 = new StringBuilder();
                sb52222222.append("add entity type: ");
                sb52222222.append(entityNodeType);
                sb52222222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb52222222.append(num);
                sb52222222.append(" entityToAdd: ");
                sb52222222.append(entityToAdd.toJson());
                sb52222222.append(" index: ");
                sb52222222.append(index);
                TavLogger.i(TAG, sb52222222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
            default:
                rootEntity = null;
                entityToAdd.detach();
                StringBuilder sb522222222 = new StringBuilder();
                sb522222222.append("add entity type: ");
                sb522222222.append(entityNodeType);
                sb522222222.append(" parentId: ");
                if (rootEntity != null) {
                }
                sb522222222.append(num);
                sb522222222.append(" entityToAdd: ");
                sb522222222.append(entityToAdd.toJson());
                sb522222222.append(" index: ");
                sb522222222.append(index);
                TavLogger.i(TAG, sb522222222.toString());
                if (rootEntity == null) {
                }
                if (rootEntity != null) {
                }
                break;
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void addExternalRenderCallback(@NotNull String key, @Nullable ExternalRenderCallback externalRenderCallback) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig != null) {
            movieConfig.addExternalRenderCallback(key, externalRenderCallback);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void addRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null) {
            lightRenderNode.addRenderCallback(callback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void addRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        NodeOrderUtils.INSTANCE.configNodeOrder(effectNode.getClass());
        EffectDispatcher effectDispatcher = this.effectDispatcher;
        if (effectDispatcher != null) {
            effectDispatcher.addNode$lib_tavcut_debug(effectNode);
        }
    }

    public final int authLightSdk() {
        LightSDKUtils lightSDKUtils = LightSDKUtils.INSTANCE;
        c cVar = c.f431135f;
        return lightSDKUtils.authLightSdk(cVar.p(), cVar.s(), cVar.m(), cVar.l());
    }

    @NotNull
    public final TAVComposition buildComposition(long duration) {
        List listOf;
        List listOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(createVideoClip(duration));
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(createAudioClip(duration));
        TAVComposition tAVComposition = new TAVComposition(listOf, listOf2);
        EffectDispatcher effectDispatcher = new EffectDispatcher();
        tAVComposition.setVideoMixEffect(effectDispatcher);
        tAVComposition.setAudioInfo(new AudioInfo(44100, 1, 2, AUDIO_SAMPLE_COUNT));
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode == null) {
            Intrinsics.throwNpe();
        }
        effectDispatcher.addNode$lib_tavcut_debug(lightRenderNode);
        setEffectDispatcher(effectDispatcher);
        return tAVComposition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public boolean componentSupportDynamicModify(@NotNull Component component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != 0 && lightAssetDataContext.componentSupportDynamicallyUpdate(component.getClass())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void emit() {
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null) {
            lightAssetDataContext.beforeReadSample();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public boolean entitySupportDynamicAdd(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkExpressionValueIsNotNull(components, "entity.components");
        for (Component component : components) {
            LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
            if (lightAssetDataContext != 0 && !lightAssetDataContext.componentSupportDynamicallyUpdate(component.getClass())) {
                TavLogger.w(TAG, "addEntity do not support dynamic add entity id: " + entity.getId());
                return false;
            }
        }
        if (entity.getChildren().size() > 0) {
            List<Entity> children = entity.getChildren();
            Intrinsics.checkExpressionValueIsNotNull(children, "entity.children");
            for (Entity it : children) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (!entitySupportDynamicAdd(it)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @NotNull
    public <T extends Component> List<Entity> findEntitiesByComponent(@Nullable Entity entity, @NotNull KClass<T> componentClass) {
        List<Entity> children;
        Collection<Component> components;
        Intrinsics.checkParameterIsNotNull(componentClass, "componentClass");
        ArrayList arrayList = new ArrayList();
        if (entity != null && (components = entity.getComponents()) != null) {
            Iterator<T> it = components.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(JvmClassMappingKt.getKotlinClass(((Component) it.next()).getClass()), componentClass)) {
                    arrayList.add(entity);
                }
            }
        }
        if (entity != null && (children = entity.getChildren()) != null) {
            Iterator<T> it5 = children.iterator();
            while (it5.hasNext()) {
                arrayList.addAll(findEntitiesByComponent((Entity) it5.next(), componentClass));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public Entity findMultiMediaEntity() {
        List<Entity> list;
        Entity entity;
        Object firstOrNull;
        Entity rootEntity;
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null && (rootEntity = lightAssetDataContext.getRootEntity()) != null) {
            list = rootEntity.getEntitiesWithComponent(MultiMedia.class);
        } else {
            list = null;
        }
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            entity = (Entity) firstOrNull;
        } else {
            entity = null;
        }
        if (entity != null) {
            return entity;
        }
        LightAssetDataContext lightAssetDataContext2 = this.lightAssetDataContext;
        if (lightAssetDataContext2 == null) {
            return null;
        }
        return lightAssetDataContext2.getRootEntity();
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @NotNull
    public List<ClipAsset> getClipAssets() {
        List list = this.curClipAssets;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curClipAssets");
        }
        return list;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public long getClipAssetsDuration() {
        return this.clipAssetsDuration;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public HashMap<String, String> getCurrentAssetData(@NotNull String templateDir) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        LightAssetDataHolder lightAssetDataHolder = this.assetDataHolder;
        if (lightAssetDataHolder != null) {
            return lightAssetDataHolder.getAssetData(templateDir);
        }
        return null;
    }

    @NotNull
    public final Function2<Long, Long, Unit> getDurationObserver() {
        return this.durationObserver;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public List<TextPlaceInfo> getEditableTextByEntityId(int entityId) {
        TextPlaceHolder[] textPlaceHolderArr;
        MovieController movieController = this.movieController;
        ArrayList arrayList = null;
        if (movieController != null) {
            textPlaceHolderArr = movieController.getTextPlaceHolderByEntityId(entityId);
        } else {
            textPlaceHolderArr = null;
        }
        if (textPlaceHolderArr != null) {
            arrayList = new ArrayList(textPlaceHolderArr.length);
            for (TextPlaceHolder it : textPlaceHolderArr) {
                Companion companion = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList.add(companion.convertToInfo(it));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public TextPlaceInfo getEditableTextUnderPoint(float x16, float y16) {
        TextPlaceHolder textPlaceHolder;
        MovieController movieController = this.movieController;
        if (movieController != null) {
            textPlaceHolder = movieController.getEditableTextUnderPoint(x16, y16);
        } else {
            textPlaceHolder = null;
        }
        if (textPlaceHolder != null) {
            return INSTANCE.convertToInfo(textPlaceHolder);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r2);
     */
    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16) {
        List emptyList;
        MovieController movieController = this.movieController;
        if (movieController == null || (r2 = movieController.getEntitiesUnderPoint(x16, y16)) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArrayList<>(emptyList);
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public LightAsset getLightAsset() {
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null) {
            return lightAssetDataContext.exportLightAsset();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    /* renamed from: getLightAssetContext, reason: from getter */
    public LightAssetDataContext getLightAssetDataContext() {
        return this.lightAssetDataContext;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public MaterialConfig[] getMaterialConfig() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            return lightAsset.getMaterialConfigs();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public Boolean getMediasTotalDurationLimitationFlag() {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            return Boolean.valueOf(movieController.getMediasTotalDurationLimitationStatus());
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public org.light.TemplateConfig getMovieConfig() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            return lightAsset.getMovieConfig();
        }
        return null;
    }

    @Nullable
    public final MovieController getMovieController() {
        return this.movieController;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public long getMovieControllerDuration() {
        return this.movieControllerDuration;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public float getOriginVolume(float defaultVolume) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            return movieController.getOriginVolume();
        }
        return defaultVolume;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public long getPlayerDuration() {
        return this.playerDuration;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public Entity getRootEntity() {
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null) {
            return lightAssetDataContext.getRootEntity();
        }
        return null;
    }

    @NotNull
    public final Function1<List<Timeline>, Unit> getTimelineObserver() {
        return this.timelineObserver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        if (r3 > 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initDuration(@NotNull TimeLine[] timelines, long targetTime) {
        long j3;
        Long valueOf;
        int lastIndex;
        long j16;
        long mediaDuration;
        Intrinsics.checkParameterIsNotNull(timelines, "timelines");
        MovieController movieController = this.movieController;
        if (movieController != null) {
            j3 = movieController.duration();
        } else {
            j3 = 0;
        }
        this.movieControllerDuration = j3;
        ArrayList arrayList = new ArrayList();
        for (TimeLine timeLine : timelines) {
            if (Intrinsics.areEqual(timeLine.type, LIGHT_VIDEO_SOURCE_TYPE)) {
                arrayList.add(timeLine);
            }
        }
        if (arrayList.isEmpty()) {
            valueOf = null;
        } else {
            TimeRange timeRange = ((TimeLine) arrayList.get(0)).range;
            valueOf = Long.valueOf(timeRange.startTime + timeRange.duration);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    TimeRange timeRange2 = ((TimeLine) arrayList.get(i3)).range;
                    Long valueOf2 = Long.valueOf(timeRange2.startTime + timeRange2.duration);
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        Long l3 = valueOf;
        if (l3 != null) {
            j16 = l3.longValue();
        } else {
            j16 = 0;
        }
        this.clipAssetsDuration = j16;
        if (this.isUseMovieControllerDuration) {
            mediaDuration = this.movieControllerDuration;
        }
        mediaDuration = getMediaDuration();
        this.playerDuration = mediaDuration;
        this.durationObserver.invoke(Long.valueOf(mediaDuration), Long.valueOf(targetTime));
        TavLogger.i(TAG, "initDuration:" + this.playerDuration);
    }

    public final void initEngine(@NotNull LAKRenderModel renderModel, @NotNull String templatePath, int seekTolerance, boolean isUE4Template) {
        MovieController assetForMovie;
        MovieController movieController;
        MovieConfig movieConfig;
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        VideoOutputConfig videoOutputConfig = new VideoOutputConfig(30.0f, seekTolerance);
        AudioOutputConfig audioOutputConfig = new AudioOutputConfig();
        audioOutputConfig.sampleRate = 44100;
        audioOutputConfig.sampleCount = AUDIO_SAMPLE_COUNT;
        boolean z16 = true;
        audioOutputConfig.channels = 1;
        RendererConfig rendererConfig = new RendererConfig(RenderConfig.INSTANCE.getRenderAssetDir());
        rendererConfig.exportMode = renderModel.getExportMode();
        Log.i(TAG, "cfg.exportMode " + rendererConfig.exportMode);
        if (TavLogger.INSTANCE.getLevel() > 3) {
            z16 = false;
        }
        rendererConfig.enablePerfReport = z16;
        CustomRenderConfig customRenderConfig = this.customRenderConfig;
        if (customRenderConfig != null) {
            rendererConfig.enableFastSoftDecode = customRenderConfig.getEnableFastSoftDecode();
            if (customRenderConfig.getSoftDecodeThreadCount() > 0) {
                rendererConfig.softDecodeThreadCount = customRenderConfig.getSoftDecodeThreadCount();
            }
        }
        LightEngine make = LightEngine.make(videoOutputConfig, audioOutputConfig, rendererConfig);
        if (make != null) {
            this.lightEngine = make;
            MovieConfig make2 = MovieConfig.make();
            this.movieConfig = make2;
            LightEngine lightEngine = this.lightEngine;
            if (lightEngine != null) {
                lightEngine.setConfig(make2);
            }
            OnClipAssetListener onClipAssetListener = this.clipAssetListener;
            if (onClipAssetListener != null && (movieConfig = this.movieConfig) != null) {
                movieConfig.setClipAssetListener(onClipAssetListener);
            }
            LightAiManager lightAiManager = LightAiManager.INSTANCE;
            MovieConfig movieConfig2 = this.movieConfig;
            if (movieConfig2 == null) {
                Intrinsics.throwNpe();
            }
            lightAiManager.setupMovieConfig(movieConfig2);
            lightAiManager.setup3DAgentPath(this.movieConfig);
            MovieConfig movieConfig3 = this.movieConfig;
            if (movieConfig3 != null) {
                movieConfig3.setWatermarkConfig(renderModel.getWatermarkConfig());
            }
            HashMap<String, String> hashMap = null;
            if (!isUE4Template) {
                LightEngine lightEngine2 = this.lightEngine;
                if (lightEngine2 != null) {
                    assetForMovie = lightEngine2.setAssetForMovie(this.lightAsset);
                }
                assetForMovie = null;
            } else {
                initLightAsset(templatePath);
                LightEngine lightEngine3 = this.lightEngine;
                if (lightEngine3 != null) {
                    assetForMovie = lightEngine3.setAssetForMovie(this.lightAsset);
                }
                assetForMovie = null;
            }
            this.movieController = assetForMovie;
            LightAssetDataHolder lightAssetDataHolder = this.assetDataHolder;
            if (lightAssetDataHolder != null) {
                hashMap = lightAssetDataHolder.getAssetData(templatePath);
            }
            setAssetData(hashMap);
            c cVar = c.f431135f;
            if (cVar.w() && (movieController = this.movieController) != null) {
                movieController.setupMediasTotalDurationLimitationStatus(cVar.w());
            }
            lightAssetDataContextBindController();
            flushRenderSize(renderModel);
            return;
        }
        throw new IllegalStateException("make lightEngine failed ");
    }

    public final void initLightAsset(@NotNull String templatePath, @NotNull LAKRenderModel renderModel, boolean loadFromJson) {
        LightAsset Load;
        LightAsset lightAsset;
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("templatePath: ");
        sb5.append(templatePath);
        sb5.append(", renderModel json length: ");
        String jsonData = renderModel.getJsonData();
        sb5.append(jsonData != null ? jsonData.length() : -1);
        TavLogger.e(TAG, sb5.toString());
        LightAsset lightAsset2 = this.lightAsset;
        if (lightAsset2 != null) {
            lightAsset2.performFinalize();
        }
        if (loadFromJson && !TextUtils.isEmpty(renderModel.getJsonData())) {
            Load = LightAsset.LoadFromString(templatePath, renderModel.getJsonData(), 0);
        } else {
            Load = LightAsset.Load(LightSDKUtils.INSTANCE.getTemplateJsonPath(templatePath), 0);
        }
        this.lightAsset = Load;
        if ((Load != null && Load.getErrorCode() == TEMPLATE_JSON_NO_ROOT) || ((lightAsset = this.lightAsset) != null && lightAsset.getErrorCode() == -400)) {
            TavLogger.e(TAG, "template parse error\uff0c delete file");
            g.f384239a.g(templatePath);
        }
        makeLightAssetDataContext(this.lightAsset, LightAssetDataType.EntityTree);
    }

    public final void initLightAudioNode() {
        LightEngine lightEngine = this.lightEngine;
        if (lightEngine != null) {
            this.lightAudioNode = new LightAudioNode(lightEngine);
        }
    }

    public final void initLightNode(@NotNull final String templateDir, @NotNull final LAKRenderModel renderModel, boolean isUE4Template) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.lightRenderNode = new LightRenderNode(this.lightEngine, this.movieConfig, new LightContextReadyCallback() { // from class: com.tencent.tavcut.core.render.builder.light.LightRenderChainManager$initLightNode$1
            @Override // com.tencent.tavcut.core.session.LightContextReadyCallback
            public void lightContextReady() {
                IRenderChainManager.DefaultImpls.reloadAsset$default(LightRenderChainManager.this, templateDir, renderModel, 0L, 4, null);
            }
        }, isUE4Template);
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public boolean isInputSourceAdded(@NotNull InputSource inputSource) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonObject inputSources;
        JsonObject asJsonObject;
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        try {
            Gson gson = getGson();
            String str = null;
            if (gson != null) {
                jsonElement = gson.toJsonTree(inputSource);
            } else {
                jsonElement = null;
            }
            if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                jsonElement2 = asJsonObject.get("key");
            } else {
                jsonElement2 = null;
            }
            LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
            if (lightAssetDataContext == null || (inputSources = lightAssetDataContext.getInputSources()) == null) {
                return false;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
            return inputSources.has(str);
        } catch (Exception e16) {
            TavLogger.e(TAG, e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    @Nullable
    public Boolean needRenderAbility(@NotNull String aiType) {
        Intrinsics.checkParameterIsNotNull(aiType, "aiType");
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            return Boolean.valueOf(lightAsset.needRenderAbility(aiType));
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void notifyDurationChange() {
        long mediaDuration;
        if (this.isUseMovieControllerDuration) {
            mediaDuration = this.movieControllerDuration;
        } else {
            mediaDuration = getMediaDuration();
        }
        long max = Math.max(mediaDuration, this.clipAssetsDuration);
        if (max == this.playerDuration) {
            return;
        }
        this.playerDuration = max;
        TavLogger.d(TAG, "notifyDurationChange:" + this.playerDuration);
        this.durationObserver.invoke(Long.valueOf(max), -1L);
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void registerDurationObserver(@NotNull Function2<? super Long, ? super Long, Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        this.durationObserver = observer;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void registerTimelineObserver(@NotNull Function1<? super List<Timeline>, Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        this.timelineObserver = observer;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void release() {
        setLoadAssetListener(ASSET_LISTENER_DEFAULT);
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null) {
            lightRenderNode.release();
        }
        this.lightRenderNode = null;
        FontCacheManager.INSTANCE.clearCache();
        LightAssetDataHolder lightAssetDataHolder = this.assetDataHolder;
        if (lightAssetDataHolder != null) {
            lightAssetDataHolder.clearAssetData();
        }
        this.gson = null;
        this.lightAssetDataContext = null;
        this.clipAssetListener = null;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void reloadAsset(@NotNull String templateDir, @Nullable LAKRenderModel lakRenderModel, long targetTime) {
        MovieController movieController;
        HashMap<String, String> hashMap;
        TimeLine[] timeLineArr;
        List<ClipSource> clipsAssets;
        MovieController movieController2;
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        if (lakRenderModel == null) {
            TavLogger.e(TAG, "reloadAsset while renderModel is null.");
        }
        reloadLightAsset();
        CopyOnWriteArraySet<MovieController> copyOnWriteArraySet = voiceProcessorRef;
        copyOnWriteArraySet.remove(this.movieController);
        LightAiManager lightAiManager = LightAiManager.INSTANCE;
        lightAiManager.setup3DAgentPath(this.movieConfig);
        LightEngine lightEngine = this.lightEngine;
        List<ClipAsset> list = null;
        if (lightEngine != null) {
            movieController = lightEngine.setAssetForMovie(this.lightAsset);
        } else {
            movieController = null;
        }
        this.movieController = movieController;
        LightAssetDataHolder lightAssetDataHolder = this.assetDataHolder;
        if (lightAssetDataHolder != null) {
            hashMap = lightAssetDataHolder.getAssetData(templateDir);
        } else {
            hashMap = null;
        }
        setAssetData(hashMap);
        c cVar = c.f431135f;
        if (cVar.w() && (movieController2 = this.movieController) != null) {
            movieController2.setupMediasTotalDurationLimitationStatus(cVar.w());
        }
        lightAssetDataContextBindController();
        MovieController movieController3 = this.movieController;
        if (movieController3 != null) {
            copyOnWriteArraySet.add(movieController3);
        }
        if (lakRenderModel != null && (clipsAssets = lakRenderModel.getClipsAssets()) != null) {
            list = LightEntityTransHelper.transClipSourcesToClipAssets(clipsAssets);
        }
        if (list != null) {
            setClipAssets(list, lakRenderModel.getPainting().getPagPath(), lakRenderModel.getModifyClipsDuration());
        }
        MovieController movieController4 = this.movieController;
        if (movieController4 == null || (timeLineArr = movieController4.getTimeLines()) == null) {
            timeLineArr = new TimeLine[0];
        }
        initDuration(timeLineArr, targetTime);
        lightAiManager.setupAgentPath(this.movieConfig);
        this.timelineObserver.invoke(LightEntityTransHelper.transLightTimeLineToTimeline(timeLineArr));
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void removeEntity(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        TavLogger.i(TAG, "remove entity id: " + entity.getId());
        entity.detach();
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void removeExternalRenderCallback(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig != null) {
            movieConfig.removeExternalRenderCallback(key);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void removeRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null) {
            lightRenderNode.removeRenderCallback(callback);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void removeRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        EffectDispatcher effectDispatcher = this.effectDispatcher;
        if (effectDispatcher != null) {
            effectDispatcher.removeNode$lib_tavcut_debug(effectNode);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void runOnAfterApply(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.afterEventQueue) {
            this.afterEventQueue.add(runnable);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void runOnBeforeApply(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.beforeEventQueue) {
            this.beforeEventQueue.add(runnable);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setAssetData(@Nullable HashMap<String, String> assetData) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setAssetData(assetData);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setClipAssetListener(@Nullable OnClipAssetListener listener) {
        this.clipAssetListener = listener;
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig != null) {
            movieConfig.setClipAssetListener(listener);
        }
    }

    public final void setClipAssets(@NotNull List<? extends ClipAsset> clipAssets, @Nullable String backgroundPagPath, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        this.curClipAssets = clipAssets;
        TavLogger.e(TAG, "setClipAssets " + getClipAssetLogInfo(clipAssets));
        MovieController movieController = this.movieController;
        if (movieController != null) {
            Object[] array = clipAssets.toArray(new ClipAsset[0]);
            if (array != null) {
                movieController.setClipAssets((ClipAsset[]) array, backgroundPagPath, modifyClipsDuration);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public final void setClipAssetsWithCallback(@NotNull List<? extends ClipAsset> clipAssets, @Nullable String backgroundPagPath, boolean modifyClipsDuration) {
        TimeLine[] timeLineArr;
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        TavLogger.d(TAG, "setClipAssetsWithCallback " + getClipAssetLogInfo(clipAssets));
        setClipAssets(clipAssets, backgroundPagPath, modifyClipsDuration);
        MovieController movieController = this.movieController;
        if (movieController == null || (timeLineArr = movieController.getTimeLines()) == null) {
            timeLineArr = new TimeLine[0];
        }
        initDuration$default(this, timeLineArr, 0L, 2, null);
        this.timelineObserver.invoke(LightEntityTransHelper.transLightTimeLineToTimeline(timeLineArr));
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setCustomRenderConfig(@Nullable CustomRenderConfig customRenderConfig) {
        this.customRenderConfig = customRenderConfig;
    }

    public final void setDurationObserver(@NotNull Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "<set-?>");
        this.durationObserver = function2;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setIsUseTemplateTime(boolean isUseTemplateTime) {
        this.isUseMovieControllerDuration = isUseTemplateTime;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setLightAIModelPath(@NotNull String agentName, @NotNull String bundlePath) {
        Intrinsics.checkParameterIsNotNull(agentName, "agentName");
        Intrinsics.checkParameterIsNotNull(bundlePath, "bundlePath");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig != null) {
            movieConfig.setLightAIModelPath(bundlePath, agentName);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setLoadAssetListener(@NotNull OnLoadAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig == null) {
            TavLogger.e(TAG, "setLoadAssetListener when movieConfig is null.");
        } else if (movieConfig != null) {
            movieConfig.setLoadAssetListener(listener);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setMediasTotalDurationLimitationFlag(boolean isLimited) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setupMediasTotalDurationLimitationStatus(isLimited);
        }
    }

    public final void setMovieController(@Nullable MovieController movieController) {
        this.movieController = movieController;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setOriginVolume(float volume) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setOriginVolume(volume);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setOriginVolumeForClip(int index, float volume) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setOriginVolumeForClip(volume, index);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setRenderNodeDuration(long duration) {
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null) {
            lightRenderNode.setTotalDuration(duration);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setRenderSyncMode(boolean enable, int frameRate) {
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null) {
            lightRenderNode.setRenderSyncMode(enable, frameRate);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setRenderTimeListener(@NotNull IRenderTimeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.renderTimeListener = listener;
        LightRenderNode lightRenderNode = this.lightRenderNode;
        if (lightRenderNode != null && listener != null) {
            lightRenderNode.setRenderTimeListener(listener);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setRenderTimeRange(@Nullable CMTimeRange renderTimeRange) {
        EffectDispatcher effectDispatcher = this.effectDispatcher;
        if (effectDispatcher != null) {
            effectDispatcher.setRenderTimeRange$lib_tavcut_debug(renderTimeRange);
        }
    }

    public final void setTextAsset(@NotNull String value) {
        TextPlaceHolder[] textPlaceHolderArr;
        String str;
        Integer num;
        Intrinsics.checkParameterIsNotNull(value, "value");
        MovieController movieController = this.movieController;
        if (movieController != null) {
            textPlaceHolderArr = movieController.getTextPlaceHolders();
        } else {
            textPlaceHolderArr = null;
        }
        if (textPlaceHolderArr != null) {
            for (TextPlaceHolder textPlaceHolder : textPlaceHolderArr) {
                if (textPlaceHolder == null || (str = textPlaceHolder.key) == null) {
                    str = "";
                }
                if (textPlaceHolder != null) {
                    num = Integer.valueOf(textPlaceHolder.fillColor);
                } else {
                    num = null;
                }
                if (num != null) {
                    num.intValue();
                    TavLogger.d(TAG, "setTextAsset :" + str + TokenParser.SP + value);
                    TextAsset textAsset = new TextAsset(value, num.intValue());
                    MovieController movieController2 = this.movieController;
                    if (movieController2 != null) {
                        movieController2.setTextAsset(str, textAsset);
                    }
                }
            }
        }
    }

    public final void setTimelineObserver(@NotNull Function1<? super List<Timeline>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.timelineObserver = function1;
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void setVoiceChangerConfig(@Nullable List<? extends VoiceEnum> config) {
        this.voiceChangerWrapper.setVoiceChangerConfig(this.movieController, config);
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable) {
        String str;
        String str2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        int i3 = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        str = Constants.PIC_ENHANCE_KEY_DE_FACE;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = Constants.PIC_ENHANCE_KEY_DE_HDR;
                }
            } else {
                str = Constants.PIC_ENHANCE_KEY_DE_WATERMARK;
            }
        } else {
            str = Constants.PIC_ENHANCE_KEY_DE_BLUE;
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            Log.e(TAG, "pic enhance key empty.");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (enable) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        hashMap.put(str, str2);
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setAssetData(hashMap);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void updateComponent(int entityId, @NotNull Component component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
    }

    public final void updatePlayerDuration(long newDuration) {
        if (newDuration != this.playerDuration) {
            this.playerDuration = newDuration;
            this.durationObserver.invoke(Long.valueOf(newDuration), -1L);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void updatePropertyLayout(@NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("width", Integer.valueOf(size.width));
        jsonObject.addProperty("height", Integer.valueOf(size.height));
        LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
        if (lightAssetDataContext != null) {
            lightAssetDataContext.updateProperty(TtmlNode.TAG_LAYOUT, jsonObject);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void updateRenderSize(@NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig != null) {
            movieConfig.setRenderSize(size.width, size.height);
        }
    }

    @Override // com.tencent.tavcut.core.render.IRenderChainManager
    public void updateResource(@NotNull InputSource inputSource) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        try {
            TavLogger.e(TAG, "update input source.........");
            Gson gson = getGson();
            String str = null;
            if (gson != null) {
                jsonElement = gson.toJsonTree(inputSource);
            } else {
                jsonElement = null;
            }
            if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                jsonElement2 = asJsonObject.get("key");
            } else {
                jsonElement2 = null;
            }
            LightAssetDataContext lightAssetDataContext = this.lightAssetDataContext;
            if (lightAssetDataContext != null) {
                if (jsonElement2 != null) {
                    str = jsonElement2.getAsString();
                }
                lightAssetDataContext.updateInputSource(str, jsonElement);
            }
            LightAssetDataContext lightAssetDataContext2 = this.lightAssetDataContext;
            if (lightAssetDataContext2 != null) {
                lightAssetDataContext2.beforeReadSample();
            }
        } catch (IllegalStateException e16) {
            TavLogger.e(TAG, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnAfterApply() {
        runAll(this.afterEventQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnBeforeApply() {
        runAll(this.beforeEventQueue);
    }

    public final void initLightAsset(@NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        TavLogger.e(TAG, "templatePath: " + templatePath + " default");
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            lightAsset.performFinalize();
        }
        LightAsset LoadFromString = LightAsset.LoadFromString(templatePath, c.f431135f.x(), 0);
        if (LoadFromString == null) {
            throw new IllegalStateException("load lightAsset failed");
        }
        this.lightAsset = LoadFromString;
    }
}
