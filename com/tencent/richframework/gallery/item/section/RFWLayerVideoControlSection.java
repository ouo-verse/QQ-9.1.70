package com.tencent.richframework.gallery.item.section;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.inner.INavigationBarImmersiveStrategy;
import com.tencent.richframework.gallery.delegate.inner.IVideoControlSection;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.inner.IVideoUIProvider;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProviderKt;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.InnerErrorInfo;
import com.tencent.richframework.gallery.event.RFWLayerVideoPlayEvent;
import com.tencent.richframework.gallery.video.ILayerVideoListener;
import com.tencent.richframework.gallery.video.RFWLayerVideoPlayPosRecorder;
import com.tencent.richframework.gallery.video.RFWLayerVideoView;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import com.tencent.richframework.video.SwitchUrlType;
import com.tencent.richframework.widget.matrix.OnDoubleTapListener;
import com.tencent.richframework.widget.matrix.OnViewTapListener;
import com.tencent.richframework.widget.matrix.RFWMatrixImageView;
import f11.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00c6\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u00c6\u0001B\t\u00a2\u0006\u0006\b\u00c4\u0001\u0010\u00c5\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0003J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0002J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\r0\"2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\bH\u0002J \u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\rH\u0002J \u00100\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\bH\u0002J\u001c\u00104\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u00020\rH\u0002J\u0012\u00105\u001a\u00020\b2\b\b\u0002\u00103\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002J\b\u00107\u001a\u00020\bH\u0002J\u0010\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u00108\u001a\u00020\rH\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u00108\u001a\u00020\rH\u0002J\u0010\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020\bH\u0002J\b\u0010A\u001a\u00020\bH\u0002J\b\u0010C\u001a\u00020BH\u0014J\u0010\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020DH\u0014J&\u0010I\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u001b2\f\u0010H\u001a\b\u0012\u0002\b\u0003\u0018\u00010GH\u0014J\u0010\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020\b2\u0006\u0010L\u001a\u00020DH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020\bH\u0016J\u0010\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020PH\u0016J\n\u0010T\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010W\u001a\u00020\b2\u0006\u0010V\u001a\u00020UH\u0016J \u0010Z\u001a\u00020\b2\u0006\u0010L\u001a\u00020D2\u0006\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u00020PH\u0016J\b\u0010[\u001a\u00020\bH\u0016J\u0010\u0010^\u001a\u00020\b2\u0006\u0010]\u001a\u00020\\H\u0016J\u0010\u0010a\u001a\u00020\b2\u0006\u0010`\u001a\u00020_H\u0016R\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010nR\u0016\u0010o\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010pR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010mR\u0016\u0010v\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010mR\u0016\u0010w\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010jR\u0016\u0010x\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010jR\u0016\u0010y\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010pR\u0016\u0010{\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R&\u0010\u0082\u0001\u001a\n }*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R%\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\r0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R+\u0010\u0094\u0001\u001a\u0014\u0012\u0004\u0012\u00020D0\u0092\u0001j\t\u0012\u0004\u0012\u00020D`\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u001c\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001c\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u0019\u0010\u00a8\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u008c\u0001R\u0019\u0010\u00a9\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u008c\u0001R\u0019\u0010\u00aa\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u008c\u0001R\u0017\u0010\u00ab\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0017\u0010\u00ad\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ac\u0001R\"\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00ae\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00af\u0001\u0010\u007f\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u0017\u0010\u00b3\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00ac\u0001R\u0019\u0010\u00b4\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u008c\u0001R\u0017\u0010\u00b5\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00ac\u0001R\u0017\u0010\u00b6\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00ac\u0001R\u0017\u0010\u00b7\u0001\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u0017\u0010\u00b9\u0001\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00b9\u0001\u0010\u00b8\u0001R\u0018\u0010\u00bc\u0001\u001a\u00030\u0083\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001a\u0010\u00c0\u0001\u001a\u0005\u0018\u00010\u00bd\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001R\u001a\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u0086\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001\u00a8\u0006\u00c7\u0001"}, d2 = {"Lcom/tencent/richframework/gallery/item/section/RFWLayerVideoControlSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoControlSection;", "Lcom/tencent/richframework/widget/matrix/OnViewTapListener;", "Lcom/tencent/richframework/widget/matrix/OnDoubleTapListener;", "", "initPlayIcon", "data", "Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "errorInfo", "", "handleErrorUI", "initPosAndDuration", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "canPlayMedia", "startPlayWithAutoPlayCheck", "registerProvider", "triggerPlay", "triggerPause", "initListener", "mediaInfo", "bindTotalDuration", "bindCover", "", "errorCode", "showInnerError", "initSeek", "createPlayerOrStartWithCheck", "continuePlay", "startANewPlayer", "Landroidx/core/util/Pair;", "", "getVideoPairKey", "videoKey", "setVideoListener", "getRateText", "doOnVideoPrepare", "Landroid/widget/SeekBar;", "seekBar", "progress", "fromUser", "doOnSeekBarProgressChange", "duration", "position", "doOnProgress", "releasePlayer", "hideLater", "controlBySystem", "showControlLayout", "hideControlLayout", "isControlLayoutVisible", "changeControlLayout", "isVideoPlaying", "updatePlayIconStatus", "updateCenterPlayIconVisibility", "updateBottomSeekContainerVisibility", "dispatchVideoStatusEvent", "Ljava/lang/Runnable;", "runnable", "runInMain", "startPlayer", "pausePlayer", "", "getViewStubLayoutId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "payload", "onBindData", NodeProps.VISIBLE, "onVisibleChanged", "view", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "stop", "", "playRate", "setPlayRate", "Lcom/tencent/richframework/video/IPlayer;", "getPlayer", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ICaptureListener;", "captureListener", "capture", HippyTKDListViewAdapter.X, "y", "onViewTap", "onDoubleTap", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ControlLayoutVisibleState;", "visibleState", "changeOperationLayoutVisible", "Lcom/tencent/richframework/gallery/video/ILayerVideoListener;", "videoListener", "addVideoListener", "Lcom/tencent/richframework/gallery/video/RFWLayerVideoView;", "playView", "Lcom/tencent/richframework/gallery/video/RFWLayerVideoView;", "Lcom/tencent/richframework/widget/matrix/RFWMatrixImageView;", ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "Lcom/tencent/richframework/widget/matrix/RFWMatrixImageView;", "Landroid/widget/ImageView;", "errorImg", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "errorDescTv", "Landroid/widget/TextView;", "Landroid/widget/SeekBar;", "progressLoadingView", "Landroid/view/View;", "bottomControlLayout", "Landroid/widget/FrameLayout;", "seekFrameLayout", "Landroid/widget/FrameLayout;", "progressDuration", "progressPosition", "playIconInCenter", "playIconInProgress", "bottomMask", "Landroid/view/ViewStub;", "rateTipLayoutStub", "Landroid/view/ViewStub;", "kotlin.jvm.PlatformType", "rateTipLayout$delegate", "Lkotlin/Lazy;", "getRateTipLayout", "()Landroid/view/View;", "rateTipLayout", "", "downloadSpeed", "J", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "innerCurrentPlayInfo", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "currentVideoKey", "Landroidx/core/util/Pair;", "autoPlayIgnorePause", "Z", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "userControlVisibleState", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ControlLayoutVisibleState;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "operationLayoutSet", "Ljava/util/ArrayList;", "currentPosition", "I", "currentDuration", "Lcom/tencent/libra/IPicLoader;", "picLoader", "Lcom/tencent/libra/IPicLoader;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "mediaProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "layoutChangeListener", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "videoStrategyProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "mediaShowStrategyProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "isVisible", "isDowningMedia", "isDraggingProgressBar", "startPlayerTask", "Ljava/lang/Runnable;", "pausePlayerTask", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "mLayerOperationInterceptor$delegate", "getMLayerOperationInterceptor", "()Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "mLayerOperationInterceptor", "showErrorToastTask", "issShowingBuffering", "showBufferTipTask", "hideControlLayoutTask", "isVoiceMute", "()Z", "isPlaying", "getDurationMs", "()J", "durationMs", "Landroid/graphics/drawable/Drawable;", "getCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "coverDrawable", "getCurrentPlayInfo", "()Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "currentPlayInfo", "<init>", "()V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoControlSection extends Section<RFWLayerItemMediaInfo> implements View.OnClickListener, IVideoPlayerProvider, IVideoControlSection, OnViewTapListener, OnDoubleTapListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean autoPlayIgnorePause;
    private View bottomControlLayout;
    private View bottomMask;
    private RFWMatrixImageView coverImg;
    private int currentDuration;
    private int currentPosition;
    private Pair<String, Boolean> currentVideoKey;
    private long downloadSpeed;
    private TextView errorDescTv;
    private ImageView errorImg;
    private final Handler handler;
    private final Runnable hideControlLayoutTask;
    private RFWPlayerVideoInfo innerCurrentPlayInfo;
    private boolean isDowningMedia;
    private boolean isDraggingProgressBar;
    private boolean isVisible;
    private boolean issShowingBuffering;
    private IVideoControlLayoutChangeListener layoutChangeListener;

    /* renamed from: mLayerOperationInterceptor$delegate, reason: from kotlin metadata */
    private final Lazy mLayerOperationInterceptor;
    private IMediaProvider mediaProvider;
    private IMediaShowStrategyProvider mediaShowStrategyProvider;
    private ArrayList<View> operationLayoutSet;
    private final Runnable pausePlayerTask;
    private IPicLoader picLoader;
    private ImageView playIconInCenter;
    private ImageView playIconInProgress;
    private RFWLayerVideoView playView;
    private TextView progressDuration;
    private View progressLoadingView;
    private TextView progressPosition;

    /* renamed from: rateTipLayout$delegate, reason: from kotlin metadata */
    private final Lazy rateTipLayout;
    private ViewStub rateTipLayoutStub;
    private SeekBar seekBar;
    private FrameLayout seekFrameLayout;
    private final Runnable showBufferTipTask;
    private final Runnable showErrorToastTask;
    private final Runnable startPlayerTask;
    private IVideoPlayerProvider.ControlLayoutVisibleState userControlVisibleState;
    private IVideoPlayStrategyProvider videoStrategyProvider;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/gallery/item/section/RFWLayerVideoControlSection$Companion;", "", "()V", "BUFFER_DELAY_TIME", "", "TAG", "", "VIDEO_RESTART_DEADLINE", "", "getSocialMinSeconds", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String getSocialMinSeconds(int timeStamp) {
            String valueOf;
            String format;
            int i3 = timeStamp / 1000;
            int i16 = i3 / 60;
            int i17 = i3 % 60;
            if (i16 < 10) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append('0');
                sb5.append(i16);
                valueOf = sb5.toString();
            } else {
                valueOf = String.valueOf(i16);
            }
            if (i17 < 10) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("%s:0%s", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(i17)}, 2));
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                format = String.format("%s:%s", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(i17)}, 2));
            }
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IVideoPlayerProvider.ControlLayoutVisibleState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE_THEN_HIDE.ordinal()] = 1;
            iArr[IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE.ordinal()] = 2;
            iArr[IVideoPlayerProvider.ControlLayoutVisibleState.VISIBLE_LOCK.ordinal()] = 3;
            iArr[IVideoPlayerProvider.ControlLayoutVisibleState.GONE.ordinal()] = 4;
            iArr[IVideoPlayerProvider.ControlLayoutVisibleState.GONE_LOCK.ordinal()] = 5;
        }
    }

    public RFWLayerVideoControlSection() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$rateTipLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return RFWLayerVideoControlSection.access$getRateTipLayoutStub$p(RFWLayerVideoControlSection.this).inflate();
            }
        });
        this.rateTipLayout = lazy;
        this.currentVideoKey = new Pair<>("", Boolean.FALSE);
        this.autoPlayIgnorePause = RFWConfig.getConfigValue("AUTO_PLAY_IGNORE_PAUSE", true);
        this.handler = new Handler(Looper.getMainLooper());
        this.userControlVisibleState = IVideoPlayerProvider.ControlLayoutVisibleState.NONE;
        this.operationLayoutSet = new ArrayList<>();
        this.startPlayerTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$startPlayerTask$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoControlSection.this.createPlayerOrStartWithCheck();
            }
        };
        this.pausePlayerTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$pausePlayerTask$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoControlSection.this.pausePlayer();
            }
        };
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ILayerOperationInterceptor>() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$mLayerOperationInterceptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ILayerOperationInterceptor invoke() {
                View rootView = RFWLayerVideoControlSection.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getLayerOperationInterceptor(rootView);
            }
        });
        this.mLayerOperationInterceptor = lazy2;
        this.showErrorToastTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$showErrorToastTask$1
            @Override // java.lang.Runnable
            public final void run() {
                IMediaShowStrategyProvider iMediaShowStrategyProvider;
                iMediaShowStrategyProvider = RFWLayerVideoControlSection.this.mediaShowStrategyProvider;
                if (iMediaShowStrategyProvider != null) {
                    RFWLayerItemMediaInfo mData = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection.this);
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    iMediaShowStrategyProvider.doOnVisible(mData);
                }
            }
        };
        this.showBufferTipTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$showBufferTipTask$1
            @Override // java.lang.Runnable
            public final void run() {
                View rateTipLayout;
                View rateTipLayout2;
                String rateText;
                RFWLayerVideoControlSection.this.issShowingBuffering = true;
                rateTipLayout = RFWLayerVideoControlSection.this.getRateTipLayout();
                Intrinsics.checkNotNullExpressionValue(rateTipLayout, "rateTipLayout");
                rateTipLayout.setVisibility(0);
                rateTipLayout2 = RFWLayerVideoControlSection.this.getRateTipLayout();
                Intrinsics.checkNotNullExpressionValue(rateTipLayout2, "rateTipLayout");
                TextView textView = (TextView) rateTipLayout2.findViewById(R.id.hvh);
                Intrinsics.checkNotNullExpressionValue(textView, "rateTipLayout.rateText");
                rateText = RFWLayerVideoControlSection.this.getRateText();
                textView.setText(rateText);
            }
        };
        this.hideControlLayoutTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$hideControlLayoutTask$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                boolean isControlLayoutVisible;
                ArrayList arrayList;
                IVideoControlLayoutChangeListener iVideoControlLayoutChangeListener;
                z16 = RFWLayerVideoControlSection.this.isDraggingProgressBar;
                if (!z16) {
                    isControlLayoutVisible = RFWLayerVideoControlSection.this.isControlLayoutVisible();
                    if (isControlLayoutVisible) {
                        arrayList = RFWLayerVideoControlSection.this.operationLayoutSet;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View view = (View) it.next();
                            Intrinsics.checkNotNullExpressionValue(view, "view");
                            view.setVisibility(8);
                        }
                        iVideoControlLayoutChangeListener = RFWLayerVideoControlSection.this.layoutChangeListener;
                        if (iVideoControlLayoutChangeListener != null) {
                            RFWLayerItemMediaInfo mData = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection.this);
                            Intrinsics.checkNotNullExpressionValue(mData, "mData");
                            iVideoControlLayoutChangeListener.onVisibleChange(mData, false);
                        }
                    }
                }
            }
        };
    }

    public static final /* synthetic */ RFWMatrixImageView access$getCoverImg$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        RFWMatrixImageView rFWMatrixImageView = rFWLayerVideoControlSection.coverImg;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        return rFWMatrixImageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RFWLayerItemMediaInfo access$getMData$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        return (RFWLayerItemMediaInfo) rFWLayerVideoControlSection.mData;
    }

    public static final /* synthetic */ RFWLayerVideoView access$getPlayView$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        RFWLayerVideoView rFWLayerVideoView = rFWLayerVideoControlSection.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        return rFWLayerVideoView;
    }

    public static final /* synthetic */ TextView access$getProgressDuration$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        TextView textView = rFWLayerVideoControlSection.progressDuration;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDuration");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getProgressPosition$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        TextView textView = rFWLayerVideoControlSection.progressPosition;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPosition");
        }
        return textView;
    }

    public static final /* synthetic */ ViewStub access$getRateTipLayoutStub$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        ViewStub viewStub = rFWLayerVideoControlSection.rateTipLayoutStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rateTipLayoutStub");
        }
        return viewStub;
    }

    public static final /* synthetic */ SeekBar access$getSeekBar$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        SeekBar seekBar = rFWLayerVideoControlSection.seekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        }
        return seekBar;
    }

    public static final /* synthetic */ FrameLayout access$getSeekFrameLayout$p(RFWLayerVideoControlSection rFWLayerVideoControlSection) {
        FrameLayout frameLayout = rFWLayerVideoControlSection.seekFrameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekFrameLayout");
        }
        return frameLayout;
    }

    private final void bindCover(final RFWLayerItemMediaInfo mediaInfo) {
        String str;
        Option obtain;
        String str2;
        if (mediaInfo.getLayerPicInfo() != null) {
            RFWMatrixImageView rFWMatrixImageView = this.coverImg;
            if (rFWMatrixImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
            }
            obtain = RFWLayerImageLoader.getReqOption(mediaInfo, rFWMatrixImageView, IMediaShowStrategyProviderKt.getPicShowDecodeFormat(this.mediaShowStrategyProvider));
        } else {
            RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
            String str3 = null;
            if (layerVideoInfo != null) {
                str = layerVideoInfo.getLocalPath();
            } else {
                str = null;
            }
            if (RFWFileUtils.fileExists(str)) {
                obtain = Option.obtain();
                RFWLayerVideoInfo layerVideoInfo2 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo2 != null) {
                    str2 = layerVideoInfo2.getLocalPath();
                } else {
                    str2 = null;
                }
                obtain.setUrl(str2);
                RFWLayerVideoInfo layerVideoInfo3 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo3 != null) {
                    str3 = layerVideoInfo3.getLocalPath();
                }
                obtain.setLocalPath(str3);
                RFWMatrixImageView rFWMatrixImageView2 = this.coverImg;
                if (rFWMatrixImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
                }
                obtain.setTargetView(rFWMatrixImageView2);
                obtain.setNeedShowFailedDrawable(false);
                obtain.setPreferDecoder(a.class);
                obtain.setNeedShowLoadingDrawable(false);
                Intrinsics.checkNotNullExpressionValue(obtain, "if (RFWFileUtils.fileExi\u2026         return\n        }");
            } else {
                return;
            }
        }
        IPicLoader iPicLoader = this.picLoader;
        if (iPicLoader != null) {
            iPicLoader.loadImage(obtain, new IPicLoadStateListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$bindCover$1
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(@NotNull LoadState state, @Nullable Option option) {
                    String str4;
                    Intrinsics.checkNotNullParameter(state, "state");
                    RFWLayerPicInfo layerPicInfo = RFWLayerItemMediaInfo.this.getLayerPicInfo();
                    if (layerPicInfo != null) {
                        str4 = layerPicInfo.getPicId();
                    } else {
                        str4 = null;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                        RFWLayerPicInfo layerPicInfo2 = RFWLayerItemMediaInfo.this.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo2);
                        String picId = layerPicInfo2.getPicId();
                        Intrinsics.checkNotNull(picId);
                        RFWLayerPicInfo layerPicInfo3 = RFWLayerItemMediaInfo.this.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo3);
                        rFWLayerDataCenter.initOrUpdateGlobalState((RFWLayerDataCenter) new RFWLayerPicLoadState(picId, layerPicInfo3.getCurrentPicInfo(), state), true);
                    }
                }
            });
        }
    }

    private final void bindTotalDuration(RFWLayerItemMediaInfo mediaInfo) {
        int i3;
        RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
        if (layerVideoInfo != null) {
            i3 = layerVideoInfo.getVideoDurationSec();
        } else {
            i3 = 0;
        }
        TextView textView = this.progressDuration;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDuration");
        }
        textView.setText(INSTANCE.getSocialMinSeconds(i3 * 1000));
    }

    private final boolean canPlayMedia(RFWLayerVideoInfo videoInfo) {
        boolean z16;
        boolean z17;
        if (videoInfo == null) {
            return false;
        }
        if (RFWFileUtils.isLocalPath(videoInfo.getCurrentVideoUrl()) && RFWFileUtils.fileExists(videoInfo.getCurrentVideoUrl())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (RFWFileUtils.isLocalPath(videoInfo.getLocalPath()) && RFWFileUtils.fileExists(videoInfo.getLocalPath())) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isUriPath = RFWFileUtils.isUriPath(videoInfo.getCurrentVideoUrl());
        boolean isValidUrl = RFWUrlUtils.isValidUrl(videoInfo.getCurrentVideoUrl());
        if (!z16 && !z17 && !isValidUrl && !isUriPath) {
            return false;
        }
        return true;
    }

    private final void changeControlLayout() {
        ILayerOperationInterceptor mLayerOperationInterceptor = getMLayerOperationInterceptor();
        if (mLayerOperationInterceptor != null && mLayerOperationInterceptor.canSingleClick()) {
            return;
        }
        if (isControlLayoutVisible()) {
            hideControlLayout$default(this, false, 1, null);
        } else {
            showControlLayout$default(this, false, false, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void createPlayerOrStartWithCheck() {
        boolean z16;
        IVideoPlayStrategyProvider iVideoPlayStrategyProvider = this.videoStrategyProvider;
        if (iVideoPlayStrategyProvider != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            z16 = iVideoPlayStrategyProvider.continuePlay((RFWLayerItemMediaInfo) mData);
        } else {
            z16 = false;
        }
        if (!startANewPlayer(z16)) {
            startPlayWithAutoPlayCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchVideoStatusEvent(boolean isVideoPlaying) {
        if (this.mData == 0) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new RFWLayerVideoPlayEvent(((RFWLayerItemMediaInfo) this.mData).getMediaId(), isVideoPlaying));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnProgress(int duration, int position, String videoKey) {
        if (!TextUtils.isEmpty(videoKey) && position == this.currentPosition && this.currentDuration == duration) {
            return;
        }
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
        if (currentPlayer != null && currentPlayer.isPlaying()) {
            TextView textView = this.progressPosition;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPosition");
            }
            textView.setText(INSTANCE.getSocialMinSeconds(position));
            if (Math.abs(duration - position) <= 2000) {
                position = 0;
            }
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(videoKey, position);
            this.currentPosition = position;
            this.currentDuration = duration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnSeekBarProgressChange(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            TextView textView = this.progressPosition;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPosition");
            }
            textView.setText(INSTANCE.getSocialMinSeconds(progress));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnVideoPrepare() {
        if (this.mData == 0) {
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$doOnVideoPrepare$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLog.d("RFWLayerVideoControlSection", RFWLog.USR, "doOnVideoPrepare start play");
                IPlayer currentPlayer = RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection.this).getCurrentPlayer();
                if (currentPlayer != null) {
                    RFWLayerVideoControlSection.access$getProgressDuration$p(RFWLayerVideoControlSection.this).setText(RFWLayerVideoControlSection.INSTANCE.getSocialMinSeconds((int) currentPlayer.getDurationMs()));
                }
            }
        });
    }

    private final ILayerOperationInterceptor getMLayerOperationInterceptor() {
        return (ILayerOperationInterceptor) this.mLayerOperationInterceptor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRateText() {
        return RFWFileUtils.getOriginSizeStr(this.downloadSpeed * 1024) + "B/s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getRateTipLayout() {
        return (View) this.rateTipLayout.getValue();
    }

    private final Pair<String, Boolean> getVideoPairKey(RFWLayerVideoInfo videoInfo) {
        String currentVideoUrl;
        if (!TextUtils.isEmpty(videoInfo.getFileId())) {
            currentVideoUrl = videoInfo.getFileId();
        } else {
            currentVideoUrl = videoInfo.getCurrentVideoUrl();
        }
        return new Pair<>(currentVideoUrl, Boolean.valueOf(Intrinsics.areEqual(videoInfo.getCurrentVideoUrl(), videoInfo.getVideoOriginUrl())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleErrorUI(RFWLayerItemMediaInfo data, InnerErrorInfo errorInfo) {
        ErrorUIConfig errorUIConfig;
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null) {
            errorUIConfig = iMediaShowStrategyProvider.needShowErrorUI(data, errorInfo);
        } else {
            errorUIConfig = null;
        }
        if (errorUIConfig != null) {
            RFWMatrixImageView rFWMatrixImageView = this.coverImg;
            if (rFWMatrixImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
            }
            rFWMatrixImageView.setVisibility(8);
            ImageView imageView = this.errorImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorImg");
            }
            imageView.setImageDrawable(errorUIConfig.getErrorDrawable());
            ImageView imageView2 = this.errorImg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorImg");
            }
            imageView2.setVisibility(0);
            if (!TextUtils.isEmpty(errorUIConfig.getErrorTip())) {
                TextView textView = this.errorDescTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorDescTv");
                }
                textView.setText(errorUIConfig.getErrorTip());
                TextView textView2 = this.errorDescTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorDescTv");
                }
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.errorDescTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorDescTv");
                }
                textView3.setVisibility(8);
            }
            hideControlLayout$default(this, false, 1, null);
            ImageView imageView3 = this.playIconInCenter;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIconInCenter");
            }
            imageView3.setVisibility(8);
            return true;
        }
        ImageView imageView4 = this.errorImg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorImg");
        }
        imageView4.setVisibility(8);
        TextView textView4 = this.errorDescTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorDescTv");
        }
        textView4.setVisibility(8);
        return false;
    }

    private final void hideControlLayout(boolean controlBySystem) {
        if ((!controlBySystem || !this.userControlVisibleState.getIsLock()) && isControlLayoutVisible()) {
            this.hideControlLayoutTask.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void hideControlLayout$default(RFWLayerVideoControlSection rFWLayerVideoControlSection, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        rFWLayerVideoControlSection.hideControlLayout(z16);
    }

    private final void initListener() {
        ImageView imageView = this.playIconInProgress;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIconInProgress");
        }
        imageView.setOnClickListener(this);
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView.setOnClickListener(this);
        ImageView imageView2 = this.playIconInCenter;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIconInCenter");
        }
        imageView2.setOnClickListener(this);
        RFWMatrixImageView rFWMatrixImageView = this.coverImg;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        rFWMatrixImageView.setOnViewTapListener(this);
        RFWMatrixImageView rFWMatrixImageView2 = this.coverImg;
        if (rFWMatrixImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        rFWMatrixImageView2.setOnDoubleTapListener(this);
        String str = this.currentVideoKey.first;
        Intrinsics.checkNotNullExpressionValue(str, "currentVideoKey.first");
        setVideoListener(str);
    }

    private final void initPlayIcon() {
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        IVideoUIProvider videoUIProvider = RFWLayerIOCUtil.getVideoUIProvider(mRootView);
        if (videoUIProvider != null) {
            Drawable playIconBackground = videoUIProvider.getPlayIconBackground();
            if (playIconBackground != null) {
                ImageView imageView = this.playIconInCenter;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playIconInCenter");
                }
                imageView.setBackground(playIconBackground);
            }
            Drawable playIconDrawable = videoUIProvider.getPlayIconDrawable();
            if (playIconDrawable != null) {
                ImageView imageView2 = this.playIconInCenter;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playIconInCenter");
                }
                imageView2.setImageDrawable(playIconDrawable);
            }
        }
    }

    private final void initPosAndDuration() {
        this.currentDuration = 0;
        this.currentPosition = 0;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initSeek() {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        View view = this.progressLoadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressLoadingView");
        }
        rFWLayerVideoView.setLoadingView(view);
        RFWLayerVideoView rFWLayerVideoView2 = this.playView;
        if (rFWLayerVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        SeekBar seekBar = this.seekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        }
        rFWLayerVideoView2.setProgressBar(seekBar);
        FrameLayout frameLayout = this.seekFrameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekFrameLayout");
        }
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$initSeek$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                RFWLayerVideoControlSection.access$getSeekFrameLayout$p(RFWLayerVideoControlSection.this).requestDisallowInterceptTouchEvent(true);
                RFWLayerVideoControlSection.access$getSeekBar$p(RFWLayerVideoControlSection.this).onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isControlLayoutVisible() {
        View view = this.bottomControlLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControlLayout");
        }
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVoiceMute() {
        View mRootView = this.mRootView;
        if (mRootView != null) {
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            if (mRootView.getContext() instanceof Activity) {
                View mRootView2 = this.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView2, "mRootView");
                Context context = mRootView2.getContext();
                if (context != null) {
                    Intent intent = ((Activity) context).getIntent();
                    if (intent == null) {
                        return false;
                    }
                    return intent.getBooleanExtra(RFWLaunchKey.KEY_IS_VIDEO_MUTE, false);
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pausePlayer() {
        runInMain(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$pausePlayer$1
            @Override // java.lang.Runnable
            public final void run() {
                IPlayer currentPlayer = RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection.this).getCurrentPlayer();
                if (currentPlayer != null && currentPlayer.isPlaying()) {
                    RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection.this).pause();
                    String mediaId = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection.this).getMediaId();
                    if (mediaId != null) {
                        RFWLayerDataCenter.INSTANCE.updateVideoPlayState(mediaId, RFWLayerVideoLoadState.PlayState.PAUSE);
                    }
                    RFWLayerVideoControlSection.this.dispatchVideoStatusEvent(false);
                }
                RFWLayerVideoControlSection.showControlLayout$default(RFWLayerVideoControlSection.this, false, false, 3, null);
                RFWLayerVideoControlSection.this.updatePlayIconStatus(false);
            }
        });
    }

    private final void registerProvider() {
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        RFWLayerIOCUtil.registerVideoControlProvider(mRootView, this);
    }

    private final void releasePlayer() {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView.release();
    }

    private final void runInMain(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    private final void setVideoListener(String videoKey) {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView.addVideoListener(new RFWLayerVideoControlSection$setVideoListener$1(this, videoKey));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showControlLayout(boolean hideLater, boolean controlBySystem) {
        if (controlBySystem && this.userControlVisibleState.getIsLock()) {
            return;
        }
        if (!isControlLayoutVisible()) {
            Iterator<View> it = this.operationLayoutSet.iterator();
            while (it.hasNext()) {
                View view = it.next();
                Intrinsics.checkNotNullExpressionValue(view, "view");
                view.setVisibility(0);
            }
            IVideoControlLayoutChangeListener iVideoControlLayoutChangeListener = this.layoutChangeListener;
            if (iVideoControlLayoutChangeListener != null) {
                T mData = this.mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                iVideoControlLayoutChangeListener.onVisibleChange((RFWLayerItemMediaInfo) mData, true);
            }
        }
        this.handler.removeCallbacks(this.hideControlLayoutTask);
        if (hideLater) {
            this.handler.postDelayed(this.hideControlLayoutTask, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showControlLayout$default(RFWLayerVideoControlSection rFWLayerVideoControlSection, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        rFWLayerVideoControlSection.showControlLayout(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInnerError(final int errorCode) {
        this.handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$showInnerError$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoControlSection rFWLayerVideoControlSection = RFWLayerVideoControlSection.this;
                RFWLayerItemMediaInfo mData = RFWLayerVideoControlSection.access$getMData$p(rFWLayerVideoControlSection);
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                rFWLayerVideoControlSection.handleErrorUI(mData, new InnerErrorInfo(errorCode));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean startANewPlayer(boolean continuePlay) {
        RFWLayerVideoInfo layerVideoInfo = ((RFWLayerItemMediaInfo) this.mData).getLayerVideoInfo();
        boolean z16 = false;
        if (layerVideoInfo != null) {
            Pair<String, Boolean> videoPairKey = getVideoPairKey(layerVideoInfo);
            if (Intrinsics.areEqual(this.currentVideoKey, videoPairKey)) {
                RFWLog.i("RFWLayerVideoControlSection", RFWLog.USR, "not create player same videoKey:" + this.currentVideoKey);
                RFWLayerVideoView rFWLayerVideoView = this.playView;
                if (rFWLayerVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                }
                if (rFWLayerVideoView.getCurrentPlayer() != null) {
                    RFWLayerVideoView rFWLayerVideoView2 = this.playView;
                    if (rFWLayerVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                    }
                    IPlayer currentPlayer = rFWLayerVideoView2.getCurrentPlayer();
                    if (currentPlayer != null && !currentPlayer.isRelease()) {
                        return false;
                    }
                }
                RFWLog.i("RFWLayerVideoControlSection", RFWLog.USR, "pre player is release createNew:" + this.currentVideoKey);
            }
            this.currentVideoKey = videoPairKey;
            RFWLayerVideoPlayPosRecorder rFWLayerVideoPlayPosRecorder = RFWLayerVideoPlayPosRecorder.INSTANCE;
            String str = videoPairKey.first;
            Intrinsics.checkNotNullExpressionValue(str, "currentVideoKey.first");
            long playPosition = rFWLayerVideoPlayPosRecorder.getPlayPosition(str);
            RFWLog.i("RFWLayerVideoControlSection", RFWLog.USR, "startANewPlayer videoKey:" + this.currentVideoKey + " | continuePlay:" + continuePlay + APLogFileUtil.SEPARATOR_LOG + playPosition + APLogFileUtil.SEPARATOR_LOG + hashCode());
            long j3 = 0;
            if (!continuePlay || TextUtils.isEmpty(this.currentVideoKey.first)) {
                playPosition = 0;
            }
            RFWPlayerVideoInfo.RFWVideoInfoBuilder builder = RFWPlayerVideoInfo.RFWVideoInfoBuilder.builder();
            if (RFWFileUtils.isLocalPath(layerVideoInfo.getLocalPath())) {
                builder.setStorePath(layerVideoInfo.getLocalPath());
            }
            RFWPlayerVideoInfo.RFWVideoInfoBuilder vecUrls = builder.setStartOffset(playPosition).setVid(layerVideoInfo.getFileId()).setUrl(layerVideoInfo.getCurrentVideoUrl()).setVecUrls(layerVideoInfo.getVecVideoUrl());
            z16 = true;
            RFWPlayerVideoInfo.RFWVideoInfoBuilder durationInMs = vecUrls.setRequestAudio(true).setWidthAndHeight(layerVideoInfo.getVideoWidth(), layerVideoInfo.getVideoHeight()).setHttpHeader(layerVideoInfo.getHttpHeader()).setDurationInMs(layerVideoInfo.getVideoDurationSec() * 1000);
            IVideoPlayStrategyProvider iVideoPlayStrategyProvider = this.videoStrategyProvider;
            if (iVideoPlayStrategyProvider != null) {
                T mData = this.mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                j3 = iVideoPlayStrategyProvider.getMinBufferingPacketDurationMs((RFWLayerItemMediaInfo) mData);
            }
            RFWPlayerVideoInfo build = durationInMs.setMinBufferingPacketDurationMs(j3).setCookies(layerVideoInfo.getCookies()).build();
            RFWLayerVideoView rFWLayerVideoView3 = this.playView;
            if (rFWLayerVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
            }
            Intrinsics.checkNotNullExpressionValue(build, "this");
            rFWLayerVideoView3.setVideoInfo(build);
            Unit unit = Unit.INSTANCE;
            this.innerCurrentPlayInfo = build;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void startPlayWithAutoPlayCheck() {
        boolean z16;
        Boolean bool;
        IVideoPlayStrategyProvider iVideoPlayStrategyProvider = this.videoStrategyProvider;
        if (iVideoPlayStrategyProvider != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            z16 = iVideoPlayStrategyProvider.isAutoPlayWhenVisible((RFWLayerItemMediaInfo) mData);
        } else {
            z16 = true;
        }
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startPlayWithAutoPlayCheck autoPlay:");
        sb5.append(z16);
        sb5.append(TokenParser.SP);
        sb5.append(" autoPlayIgnorePause:");
        sb5.append(this.autoPlayIgnorePause);
        sb5.append(" playingState:");
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
        if (currentPlayer != null) {
            bool = Boolean.valueOf(currentPlayer.isPausing());
        } else {
            bool = null;
        }
        sb5.append(bool);
        RFWLog.i("RFWLayerVideoControlSection", i3, sb5.toString());
        if (z16) {
            if (this.autoPlayIgnorePause) {
                RFWLayerVideoView rFWLayerVideoView2 = this.playView;
                if (rFWLayerVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                }
                IPlayer currentPlayer2 = rFWLayerVideoView2.getCurrentPlayer();
                if (currentPlayer2 != null && currentPlayer2.isPausing()) {
                    return;
                }
            }
            startPlayer();
            return;
        }
        pausePlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPlayer() {
        runInMain(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$startPlayer$1
            @Override // java.lang.Runnable
            public final void run() {
                IPlayer currentPlayer = RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection.this).getCurrentPlayer();
                if (currentPlayer == null || !currentPlayer.isPlaying()) {
                    RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection.this).start();
                    RFWLayerVideoControlSection.access$getCoverImg$p(RFWLayerVideoControlSection.this).setVisibility(8);
                    String mediaId = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection.this).getMediaId();
                    if (mediaId != null) {
                        RFWLayerDataCenter.INSTANCE.updateVideoPlayState(mediaId, RFWLayerVideoLoadState.PlayState.PLAYING);
                    }
                    RFWLayerVideoControlSection.this.dispatchVideoStatusEvent(true);
                }
                RFWLayerVideoControlSection.showControlLayout$default(RFWLayerVideoControlSection.this, false, false, 3, null);
                RFWLayerVideoControlSection.this.updatePlayIconStatus(true);
            }
        });
    }

    private final void triggerPause() {
        this.handler.removeCallbacks(this.startPlayerTask);
        this.handler.postDelayed(this.pausePlayerTask, 200L);
    }

    private final void triggerPlay() {
        this.handler.removeCallbacks(this.pausePlayerTask);
        this.handler.postDelayed(this.startPlayerTask, 200L);
    }

    private final void updateBottomSeekContainerVisibility(boolean isVideoPlaying) {
        int i3;
        Resources resources;
        Resources resources2;
        ImageView imageView = this.playIconInProgress;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIconInProgress");
        }
        if (isVideoPlaying) {
            i3 = R.drawable.o0c;
        } else {
            i3 = R.drawable.o0b;
        }
        imageView.setImageResource(i3);
        ImageView imageView2 = this.playIconInProgress;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIconInProgress");
        }
        String str = null;
        if (isVideoPlaying) {
            ImageView imageView3 = this.playIconInProgress;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIconInProgress");
            }
            Context context = imageView3.getContext();
            if (context != null && (resources2 = context.getResources()) != null) {
                str = resources2.getString(R.string.f221416ar);
            }
        } else {
            ImageView imageView4 = this.playIconInProgress;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIconInProgress");
            }
            Context context2 = imageView4.getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                str = resources.getString(R.string.f221406aq);
            }
        }
        imageView2.setContentDescription(str);
    }

    private final void updateCenterPlayIconVisibility(boolean isVideoPlaying) {
        int i3;
        ImageView imageView = this.playIconInCenter;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIconInCenter");
        }
        if (isVideoPlaying) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlayIconStatus(boolean isVideoPlaying) {
        updateCenterPlayIconVisibility(isVideoPlaying);
        updateBottomSeekContainerVisibility(isVideoPlaying);
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoControlSection
    public void addVideoListener(@NotNull ILayerVideoListener videoListener) {
        Intrinsics.checkNotNullParameter(videoListener, "videoListener");
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView.addVideoListener(videoListener);
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public void capture(@NotNull IVideoPlayerProvider.ICaptureListener captureListener) {
        Intrinsics.checkNotNullParameter(captureListener, "captureListener");
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView.captureCurFrame(captureListener);
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public void changeOperationLayoutVisible(@NotNull IVideoPlayerProvider.ControlLayoutVisibleState visibleState) {
        Intrinsics.checkNotNullParameter(visibleState, "visibleState");
        this.userControlVisibleState = visibleState;
        int i3 = WhenMappings.$EnumSwitchMapping$0[visibleState.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5) {
                    hideControlLayout(false);
                    return;
                }
                return;
            }
            showControlLayout(false, false);
            return;
        }
        showControlLayout(true, false);
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    @Nullable
    public Drawable getCoverDrawable() {
        RFWMatrixImageView rFWMatrixImageView = this.coverImg;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        return rFWMatrixImageView.getDrawable();
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    @Nullable
    /* renamed from: getCurrentPlayInfo, reason: from getter */
    public RFWPlayerVideoInfo getInnerCurrentPlayInfo() {
        return this.innerCurrentPlayInfo;
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public long getDurationMs() {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
        if (currentPlayer != null) {
            return currentPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    @Nullable
    public IPlayer getPlayer() {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        return rFWLayerVideoView.getCurrentPlayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public boolean isPlaying() {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
        if (currentPlayer != null) {
            return currentPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<?>) list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.f74153vh && view.getId() != R.id.f74033v6) {
            if (view.getId() == R.id.f74143vg || view.getId() == R.id.f73933uw) {
                RFWLayerVideoView rFWLayerVideoView = this.playView;
                if (rFWLayerVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                }
                IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
                if (currentPlayer != null) {
                    if (!currentPlayer.isPausing() && (currentPlayer.isPlaying() || currentPlayer.isBuffering())) {
                        pausePlayer();
                    } else {
                        startPlayer();
                    }
                }
            }
        } else {
            changeControlLayout();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }

    @Override // com.tencent.richframework.widget.matrix.OnDoubleTapListener
    public void onDoubleTap() {
        ILayerOperationInterceptor mLayerOperationInterceptor = getMLayerOperationInterceptor();
        if (mLayerOperationInterceptor != null) {
            mLayerOperationInterceptor.canDoubleClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f74153vh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rfw_video_view)");
        this.playView = (RFWLayerVideoView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f74063v9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rfw_progress_bar)");
        this.seekBar = (SeekBar) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f74133vf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rfw_video_loading_view)");
        this.progressLoadingView = findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f74113vd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026fw_seek_bar_frame_layout)");
        this.seekFrameLayout = (FrameLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f74083va);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_progress_total_duration)");
        this.progressDuration = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f74073v_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026rogress_current_duration)");
        this.progressPosition = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f74123ve);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026rfw_video_control_layout)");
        this.bottomControlLayout = findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f74033v6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.rfw_player_cover)");
        this.coverImg = (RFWMatrixImageView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f73883ur);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.rfw_bottom_mask)");
        this.bottomMask = findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f74053v8);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.rfw_player_error_icon)");
        this.errorImg = (ImageView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.f74043v7);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.rfw_player_error_desc)");
        this.errorDescTv = (TextView) findViewById11;
        View findViewById12 = rootView.findViewById(R.id.f73933uw);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.rfw_fl_play_btn)");
        this.playIconInCenter = (ImageView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.f74143vg);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.id.rfw_video_play)");
        this.playIconInProgress = (ImageView) findViewById13;
        View findViewById14 = rootView.findViewById(R.id.f74093vb);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.id.rfw_rate_tip_vs)");
        this.rateTipLayoutStub = (ViewStub) findViewById14;
        RFWMatrixImageView rFWMatrixImageView = this.coverImg;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        rFWMatrixImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        SeekBar seekBar = this.seekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
        }
        rFWLayerVideoView.setProgressBar(seekBar);
        RFWLayerVideoView rFWLayerVideoView2 = this.playView;
        if (rFWLayerVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        View view = this.progressLoadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressLoadingView");
        }
        rFWLayerVideoView2.setLoadingView(view);
        RFWLayerVideoView rFWLayerVideoView3 = this.playView;
        if (rFWLayerVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        RFWMatrixImageView rFWMatrixImageView2 = this.coverImg;
        if (rFWMatrixImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        }
        rFWLayerVideoView3.setVideoCover(rFWMatrixImageView2);
        this.picLoader = RFWLayerIOCUtil.getPicLoaderFromView(rootView);
        this.mediaProvider = RFWLayerIOCUtil.getMediaProvider(rootView);
        this.videoStrategyProvider = RFWLayerIOCUtil.getPlayStrategyProvider(rootView);
        this.layoutChangeListener = RFWLayerIOCUtil.getControlVisibleChangeListener(rootView);
        this.mediaShowStrategyProvider = RFWLayerIOCUtil.getPicShowStrategy(rootView);
        RFWLayerIOCUtil.registerVideoControlSection(rootView, this);
        initPlayIcon();
        initSeek();
        initListener();
        ArrayList<View> arrayList = this.operationLayoutSet;
        View view2 = this.bottomMask;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomMask");
        }
        arrayList.add(view2);
        ArrayList<View> arrayList2 = this.operationLayoutSet;
        View view3 = this.bottomControlLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControlLayout");
        }
        arrayList2.add(view3);
        INavigationBarImmersiveStrategy navigationBarImmersiveStrategy = RFWLayerIOCUtil.getNavigationBarImmersiveStrategy(rootView);
        if (navigationBarImmersiveStrategy != null && navigationBarImmersiveStrategy.isOpenNavigationBarImmersive()) {
            RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
            View view4 = this.bottomControlLayout;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControlLayout");
            }
            rFWNavigationBarImmersiveHelper.adjustView(view4, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        }
        RFWLayerVideoView rFWLayerVideoView4 = this.playView;
        if (rFWLayerVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        rFWLayerVideoView4.setContentDescription("\u89c6\u9891\u533a\u57df");
    }

    @Override // com.tencent.richframework.widget.matrix.OnViewTapListener
    public void onViewTap(@NotNull View view, float x16, float y16) {
        Intrinsics.checkNotNullParameter(view, "view");
        changeControlLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        this.isVisible = visible;
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mediaShowStrategyProvider;
        ErrorUIConfig errorUIConfig = null;
        if (iMediaShowStrategyProvider != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            errorUIConfig = iMediaShowStrategyProvider.needShowErrorUI((RFWLayerItemMediaInfo) mData, null);
        }
        if (errorUIConfig != null) {
            this.handler.removeCallbacks(this.showErrorToastTask);
            if (visible) {
                this.handler.postDelayed(this.showErrorToastTask, 500L);
                return;
            }
            return;
        }
        if (visible) {
            if (canPlayMedia(((RFWLayerItemMediaInfo) this.mData).getLayerVideoInfo())) {
                triggerPlay();
            } else {
                IMediaProvider iMediaProvider = this.mediaProvider;
                if (iMediaProvider != null) {
                    T mData2 = this.mData;
                    Intrinsics.checkNotNullExpressionValue(mData2, "mData");
                    iMediaProvider.getVideoUrl((RFWLayerItemMediaInfo) mData2);
                }
                this.isDowningMedia = true;
            }
            registerProvider();
            return;
        }
        triggerPause();
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public void setPlayRate(float playRate) {
        RFWLayerVideoView rFWLayerVideoView = this.playView;
        if (rFWLayerVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        }
        IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
        if (currentPlayer != null) {
            currentPlayer.setPlayRate(playRate);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider
    public void stop() {
        pausePlayer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(@NotNull RFWLayerItemMediaInfo data, int position, @Nullable List<?> payload) {
        SwitchUrlType switchUrlType;
        Intrinsics.checkNotNullParameter(data, "data");
        RFWLayerVideoInfo layerVideoInfo = data.getLayerVideoInfo();
        if (layerVideoInfo != null) {
            Pair<String, Boolean> videoPairKey = getVideoPairKey(layerVideoInfo);
            boolean areEqual = Intrinsics.areEqual(this.currentVideoKey.first, videoPairKey.first);
            if (areEqual && Intrinsics.areEqual(this.currentVideoKey.second, videoPairKey.second)) {
                return;
            }
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("is current player playing");
            RFWLayerVideoView rFWLayerVideoView = this.playView;
            if (rFWLayerVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
            }
            IPlayer currentPlayer = rFWLayerVideoView.getCurrentPlayer();
            sb5.append(currentPlayer != null ? Boolean.valueOf(currentPlayer.isPlaying()) : null);
            objArr[0] = sb5.toString();
            RFWLog.d("RFWLayerVideoControlSection", i3, objArr);
            if (areEqual) {
                Boolean bool = videoPairKey.second;
                Intrinsics.checkNotNullExpressionValue(bool, "videoPlayKey.second");
                if (bool.booleanValue()) {
                    RFWLayerVideoView rFWLayerVideoView2 = this.playView;
                    if (rFWLayerVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                    }
                    IPlayer currentPlayer2 = rFWLayerVideoView2.getCurrentPlayer();
                    if (currentPlayer2 != null && currentPlayer2.isPlaying()) {
                        RFWLayerVideoView rFWLayerVideoView3 = this.playView;
                        if (rFWLayerVideoView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("playView");
                        }
                        String currentVideoUrl = layerVideoInfo.getCurrentVideoUrl();
                        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mediaShowStrategyProvider;
                        if (iMediaShowStrategyProvider == null || (switchUrlType = iMediaShowStrategyProvider.getSwitchUrlType()) == null) {
                            switchUrlType = SwitchUrlType.DEFAULT;
                        }
                        rFWLayerVideoView3.switchDefinitionForUrl(currentVideoUrl, switchUrlType);
                        return;
                    }
                    startPlayer();
                    return;
                }
            }
            this.currentVideoKey = new Pair<>("", Boolean.FALSE);
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            if (handleErrorUI((RFWLayerItemMediaInfo) mData, null)) {
                return;
            }
            initPosAndDuration();
            if (this.isVisible && this.isDowningMedia && canPlayMedia(layerVideoInfo)) {
                this.isDowningMedia = false;
                triggerPlay();
                return;
            }
            bindCover(data);
            bindTotalDuration(data);
            IVideoPlayStrategyProvider iVideoPlayStrategyProvider = this.videoStrategyProvider;
            if (iVideoPlayStrategyProvider != null) {
                T mData2 = this.mData;
                Intrinsics.checkNotNullExpressionValue(mData2, "mData");
                if (iVideoPlayStrategyProvider.isAutoPlayWhenVisible((RFWLayerItemMediaInfo) mData2)) {
                    updatePlayIconStatus(true);
                    showControlLayout$default(this, true, false, 2, null);
                }
            }
            updatePlayIconStatus(false);
            showControlLayout$default(this, true, false, 2, null);
        }
    }
}
