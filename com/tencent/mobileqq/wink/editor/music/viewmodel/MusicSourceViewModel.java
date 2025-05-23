package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.ax;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.MusicListData;
import com.tencent.mobileqq.wink.editor.music.vo.MusicRspResult;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.event.WinkShowBottomDashBoardEvent;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCollectionRsp;
import qqcircle.QQCircleSmartMatchMusic$ModMusicCollectionRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicCategoryInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00cc\u00022\u00020\u0001:\u0004\u00cd\u0002\u00ce\u0002B\t\u00a2\u0006\u0006\b\u00ca\u0002\u0010\u00cb\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J \u0010!\u001a\u00020\u00022\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J*\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\b\u0010+\u001a\u00020\u0002H\u0002J\u0012\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010'H\u0002J\u0018\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020'2\u0006\u0010/\u001a\u00020.H\u0002J\u0018\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020'2\u0006\u0010/\u001a\u00020.H\u0002J$\u00105\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010'2\b\b\u0002\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0002J\u001c\u00107\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010'2\b\b\u0002\u00104\u001a\u00020\u0006H\u0002J \u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020'2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020\u0002H\u0002J\b\u0010<\u001a\u00020\u0002H\u0002J\"\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001e2\b\b\u0002\u00104\u001a\u00020\u0006H\u0002J\b\u0010@\u001a\u00020\u0002H\u0002J\u0010\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020'H\u0002J\u001e\u0010F\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u001e2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020DH\u0002J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020'0&J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\"0&J\b\u0010I\u001a\u0004\u0018\u00010\"J\u0006\u0010J\u001a\u00020\u0002J\u001e\u0010K\u001a\u00020\u00022\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fJ\u000e\u0010L\u001a\u00020\u00022\u0006\u0010,\u001a\u00020'J\u0016\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020M2\u0006\u0010\t\u001a\u00020\bJ$\u0010R\u001a\u00020\u00022\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&J.\u0010V\u001a\u00020\u00022\f\u0010T\u001a\b\u0012\u0004\u0012\u00020S0&2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\b\b\u0002\u0010U\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020\u0002J\u000e\u0010X\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0014\u0010Z\u001a\u00020\u00022\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020'0&J\u0006\u0010[\u001a\u00020\u0002J\u001c\u0010^\u001a\u00020\u00022\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u001e2\b\u0010]\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010`\u001a\u00020\u00022\u0006\u0010_\u001a\u00020\u0006J\u0006\u0010a\u001a\u00020\u0002J\u0006\u0010b\u001a\u00020\u0002J\u000e\u0010c\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.J\u0006\u0010d\u001a\u00020\u0006J\f\u0010e\u001a\b\u0012\u0004\u0012\u00020'0&J\u0014\u0010g\u001a\u00020\u00022\f\u0010f\u001a\b\u0012\u0004\u0012\u00020'0&J\u001e\u0010j\u001a\u00020\u00022\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u0006J\u0006\u0010k\u001a\u00020\u0002J\u0017\u0010l\u001a\u0004\u0018\u00010.2\u0006\u0010]\u001a\u00020\u001e\u00a2\u0006\u0004\bl\u0010mJ\u000e\u0010n\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u0006\u0010o\u001a\u00020\u0002J\u0018\u0010q\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010'2\u0006\u0010/\u001a\u00020.J*\u0010r\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010'2\u0006\u0010/\u001a\u00020.2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u00020\u0006J\u0006\u0010s\u001a\u00020\u0002J\u000e\u0010t\u001a\u00020\u00022\u0006\u0010,\u001a\u00020'J\u0006\u0010u\u001a\u00020\u0002J\u0006\u0010v\u001a\u00020\u0002J\u0010\u0010x\u001a\u00020\u00022\b\b\u0002\u0010w\u001a\u00020\u0006J\u000e\u0010y\u001a\u00020\u00022\u0006\u0010,\u001a\u00020'J \u0010z\u001a\u00020\u00022\u0006\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001e2\b\b\u0002\u00104\u001a\u00020\u0006J\u0006\u0010{\u001a\u00020\u0002J\u0006\u0010|\u001a\u00020\u0002J\u0006\u0010}\u001a\u00020\u0002J\u0006\u0010~\u001a\u00020\u0002J\u0006\u0010\u007f\u001a\u00020\u0002J%\u0010\u0081\u0001\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010.2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010.\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0007\u0010\u0083\u0001\u001a\u00020\u0002J\u0011\u0010\u0086\u0001\u001a\u00020\u00022\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001J\u0007\u0010\u0087\u0001\u001a\u00020\u0002J\u0007\u0010\u0088\u0001\u001a\u00020\u0002J\u0007\u0010\u0089\u0001\u001a\u00020\u0002J\u001c\u0010\u008c\u0001\u001a\u00020\u00022\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0010\u0010\u008f\u0001\u001a\u00020\u00022\u0007\u0010\u008e\u0001\u001a\u00020\u0006J\t\u0010\u0090\u0001\u001a\u00020\u0002H\u0014J\u000f\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R)\u0010\u00a2\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001R#\u0010\u00a5\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a4\u0001\u0010\u00a1\u0001R#\u0010\u00a8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a6\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a1\u0001R)\u0010\u00ab\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001\"\u0006\b\u00ad\u0001\u0010\u00ae\u0001R)\u0010\u00b0\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00af\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00ac\u0001\"\u0006\b\u00b1\u0001\u0010\u00ae\u0001R)\u0010\u00b3\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b2\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00ac\u0001\"\u0006\b\u00b4\u0001\u0010\u00ae\u0001R\u0018\u0010\u00b7\u0001\u001a\u00030\u00b5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u00b6\u0001R\u0019\u0010\u00b9\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00aa\u0001R\u0019\u0010\u00bb\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00aa\u0001R1\u0010\u00bf\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bc\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00ac\u0001\"\u0006\b\u00be\u0001\u0010\u00ae\u0001R#\u0010\u00c2\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c0\u0001\u0010\u009f\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00a1\u0001R)\u0010\u00c6\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c3\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00ac\u0001\"\u0006\b\u00c5\u0001\u0010\u00ae\u0001R*\u0010\u00cd\u0001\u001a\u00030\u0084\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001\"\u0006\b\u00cb\u0001\u0010\u00cc\u0001R#\u0010\u00d0\u0001\u001a\t\u0012\u0004\u0012\u00020'0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ce\u0001\u0010\u009f\u0001\u001a\u0006\b\u00cf\u0001\u0010\u00a1\u0001R)\u0010\u00d6\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0\u00d1\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001\u001a\u0006\b\u00d4\u0001\u0010\u00d5\u0001R)\u0010\u00d9\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0&0\u00d1\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d7\u0001\u0010\u00d3\u0001\u001a\u0006\b\u00d8\u0001\u0010\u00d5\u0001R#\u0010\u00dc\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00da\u0001\u0010\u009f\u0001\u001a\u0006\b\u00db\u0001\u0010\u00a1\u0001R,\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00dd\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00de\u0001\u0010\u00df\u0001\u001a\u0006\b\u00e0\u0001\u0010\u00e1\u0001\"\u0006\b\u00e2\u0001\u0010\u00e3\u0001R*\u0010\u00ea\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e5\u0001\u0010\u0098\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00e7\u0001\"\u0006\b\u00e8\u0001\u0010\u00e9\u0001R5\u0010\u00f1\u0001\u001a\u0004\u0018\u00010'2\b\u0010\u0019\u001a\u0004\u0018\u00010'8\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001\u001a\u0006\b\u00ed\u0001\u0010\u00ee\u0001\"\u0006\b\u00ef\u0001\u0010\u00f0\u0001R9\u0010\u00f7\u0001\u001a\u0012\u0012\r\u0012\u000b \u00f2\u0001*\u0004\u0018\u00010\u00060\u00060\u0091\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f3\u0001\u0010\u009f\u0001\u001a\u0006\b\u00f4\u0001\u0010\u00a1\u0001\"\u0006\b\u00f5\u0001\u0010\u00f6\u0001R2\u0010\u00fa\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010'0\u0091\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00aa\u0001\u0010\u009f\u0001\u001a\u0006\b\u00f8\u0001\u0010\u00a1\u0001\"\u0006\b\u00f9\u0001\u0010\u00f6\u0001R)\u0010\u00fe\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00fb\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00fc\u0001\u0010\u00ac\u0001\"\u0006\b\u00fd\u0001\u0010\u00ae\u0001R,\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u00ff\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R*\u0010h\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R+\u0010\u0080\u0001\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u0088\u0002\u001a\u0006\b\u008e\u0002\u0010\u008a\u0002\"\u0006\b\u008f\u0002\u0010\u008c\u0002R$\u0010\u0093\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020.0\u0090\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R#\u0010\u0096\u0002\u001a\t\u0012\u0004\u0012\u00020.0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0094\u0002\u0010\u009f\u0001\u001a\u0006\b\u0095\u0002\u0010\u00a1\u0001R\u001e\u0010\u0098\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0097\u0002\u0010\u009f\u0001R#\u0010\u009e\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0099\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R%\u0010\u00a1\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010'0\u0091\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009f\u0002\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0002\u0010\u00a1\u0001R<\u0010\u00a5\u0002\u001a'\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u00a2\u0002j\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u00a3\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0002\u0010\u009f\u0001R\u0019\u0010\u00a7\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0002\u0010\u00aa\u0001R\u001f\u0010\u00a9\u0002\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0002\u0010\u009f\u0001R\u001e\u0010\u00ab\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00aa\u0002\u0010\u009f\u0001R#\u0010\u00ae\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u0099\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00ac\u0002\u0010\u009b\u0002\u001a\u0006\b\u00ad\u0002\u0010\u009d\u0002R!\u0010\u00b4\u0002\u001a\u00030\u00af\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b0\u0002\u0010\u00b1\u0002\u001a\u0006\b\u00b2\u0002\u0010\u00b3\u0002R*\u0010\u00b8\u0002\u001a\u00020\u00062\u0007\u0010\u00b5\u0002\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00b6\u0002\u0010\u00aa\u0001\u001a\u0006\b\u00b7\u0002\u0010\u00ac\u0001R\u001f\u0010\u00bb\u0002\u001a\n\u0012\u0005\u0012\u00030\u00b9\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ba\u0002\u0010\u009f\u0001R$\u0010\u00be\u0002\u001a\n\u0012\u0005\u0012\u00030\u00b9\u00020\u0099\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00bc\u0002\u0010\u009b\u0002\u001a\u0006\b\u00bd\u0002\u0010\u009d\u0002R\u001f\u0010\u00c0\u0002\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0002\u0010\u009f\u0001R$\u0010\u00c3\u0002\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0099\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00c1\u0002\u0010\u009b\u0002\u001a\u0006\b\u00c2\u0002\u0010\u009d\u0002R\u0018\u0010\u00c7\u0002\u001a\u00030\u00c4\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0002\u0010\u00c6\u0002R9\u0010\u00c9\u0002\u001a'\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u00a2\u0002j\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u00a3\u00020\u0099\u00028F\u00a2\u0006\b\u001a\u0006\b\u00c8\u0002\u0010\u009d\u0002\u00a8\u0006\u00cf\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "Landroidx/lifecycle/ViewModel;", "", "K4", "Lcom/tencent/mobileqq/wink/editor/music/VsMusicItemInfo;", "vsMusicItemInfo", "", "needSelect", "Landroid/content/Intent;", "intent", "needScroll", "U3", "musicItem", "H3", "F3", "", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "stMusicList", "c3", "isSuccess", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "type", "T4", "key", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult;", "value", "R4", "J2", "e3", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "musicIdList", "S2", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "categoryInfo", Constants.MMCCID, "h3", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "queriedMusicList", "currentMusicList", Constants.BASE_IN_APP_NAME, "P3", "musicInfo", "C4", "", "position", "z3", "t2", "editorMusicInfo", "isFromWeb", "isAutoMusic", "F4", "selectEditorMusicInfo", "C2", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "progress", "Q4", "c4", "x2", "data", "localPath", "S4", NowProxyConstants.AccountInfoKey.A2, "imageMusicInfo", "N4", "callFunctionName", "Lkotlin/Function0;", "playerAction", "B2", "k3", "F2", "L2", "U4", "M4", "J4", "Landroid/content/Context;", "context", "Q3", "musicListInfo", "tongKuanMusic", "x4", "", "bitmaps", "needLyrics", "p3", "E3", "r4", "materialMusicList", ICustomDataEditor.STRING_PARAM_4, "f4", "tabName", "musicMid", "g4", "hasBgm", "w4", "v4", "i4", "l4", "A3", "R2", "list", "m4", "startTimeInMs", "forceUpdate", ICustomDataEditor.STRING_ARRAY_PARAM_4, "Z3", "m3", "(Ljava/lang/String;)Ljava/lang/Integer;", Constants.EMULATOR_INFO, "d4", "selectedMusicInfo", "M3", "N3", "I3", "J3", "T3", "S3", "selectMusic", "u2", "e4", "O4", "L4", "y2", "z2", "X3", "I4", "endTimeInMs", "t4", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "W3", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "newEditMode", "o4", "R3", "Y3", "w2", "", "it", "j4", "(Ljava/lang/Float;)V", HippyControllerProps.BOOLEAN, "B4", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "", "Q2", "i", "Ljava/lang/Float;", "bgmVolume", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "initTime", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData;", "musicListData", "D", "Landroidx/lifecycle/MutableLiveData;", "j3", "()Landroidx/lifecycle/MutableLiveData;", "musicList", "E", "l3", "musicPos", UserInfo.SEX_FEMALE, "u3", "selectTemplateBGM", "G", "Z", "isFromZShow", "()Z", "q4", "(Z)V", "H", "isFromMagicStudio", "setFromMagicStudio", "I", "isFromDailySign", "p4", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "musicLatch", "K", "isNeedWaitMusicJudge", "L", "oriHasBgm", "M", ICustomDataEditor.NUMBER_PARAM_3, "u4", "needAutoMusic", "N", "x3", "videoClearMusicLiveData", "P", "C3", "setVideoClearMusic", "isVideoClearMusic", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "V2", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "setEditMode", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "editMode", BdhLogUtil.LogTag.Tag_Req, "t3", "selectImageBGM", "Landroidx/lifecycle/MediatorLiveData;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/MediatorLiveData;", "N2", "()Landroidx/lifecycle/MediatorLiveData;", "curMusicList", "T", "E2", "categoryList", "U", "M2", "curCategoryLiveData", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "V", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "getWebCallback", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "A4", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;)V", "webCallback", "W", "y3", "()J", "z4", "(J)V", "videoDurationMs", "X", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "O2", "()Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "k4", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;)V", "currentMusic", "kotlin.jvm.PlatformType", "Y", "I2", "setCheckRecommendMusicLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "checkRecommendMusicLiveData", "P2", "setCurrentMusicLiveData", "currentMusicLiveData", "a0", "getEnableMusic", "setEnableMusic", "enableMusic", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/b;", "b0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/b;", "U2", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/b;", ICustomDataEditor.NUMBER_PARAM_4, "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/b;)V", "draftMusic", "c0", "Ljava/lang/Integer;", "w3", "()Ljava/lang/Integer;", "y4", "(Ljava/lang/Integer;)V", "d0", "getEndTimeInMs", "setEndTimeInMs", "", "e0", "Ljava/util/Map;", "musicStartTimeMap", "f0", "W2", "errorLiveData", "g0", "_showLyricMenuDialogLiveData", "Landroidx/lifecycle/LiveData;", "h0", "Landroidx/lifecycle/LiveData;", "v3", "()Landroidx/lifecycle/LiveData;", "showLyricMenuDialogLiveData", "i0", "g3", "musicButtonExposeLiveData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j0", "_rspResultLiveData", "k0", "hasTemplateInVideoMode", "l0", "currentPlayerTimeLiveData", "m0", "_loadingMusicLiveData", "n0", "b3", "loadingMusicLiveData", "Landroid/media/MediaPlayer;", "o0", "Lkotlin/Lazy;", ICustomDataEditor.STRING_ARRAY_PARAM_3, "()Landroid/media/MediaPlayer;", "imageBgmPlayer", "<set-?>", "p0", "Y2", "getCategoryMusicListFail", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "q0", "_bgmSourceLiveData", "r0", Constants.BASE_IN_PLUGIN_VERSION, "bgmSourceLiveData", "s0", "_playerSeek", "t0", "o3", "playerSeek", "Ljava/lang/Runnable;", "u0", "Ljava/lang/Runnable;", "seekRunnable", ICustomDataEditor.STRING_PARAM_3, "rspResultLiveData", "<init>", "()V", "v0", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicSourceViewModel extends ViewModel {

    /* renamed from: v0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: w0 */
    @NotNull
    private static final Object f321160w0 = new Object();

    /* renamed from: x0 */
    @NotNull
    private static final ArrayList<String> f321161x0;

    /* renamed from: C */
    @NotNull
    private final MusicListData musicListData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<WinkEditorMusicInfo>> musicList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> musicPos;

    /* renamed from: F */
    @NotNull
    private final MutableLiveData<Boolean> selectTemplateBGM;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFromZShow;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isFromMagicStudio;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFromDailySign;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final CountDownLatch musicLatch;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isNeedWaitMusicJudge;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean oriHasBgm;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean needAutoMusic;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> videoClearMusicLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isVideoClearMusic;

    /* renamed from: Q */
    @NotNull
    private WinkEditorViewModel.EditMode editMode;

    /* renamed from: R */
    @NotNull
    private final MutableLiveData<WinkEditorMusicInfo> selectImageBGM;

    /* renamed from: S */
    @NotNull
    private final MediatorLiveData<List<WinkEditorMusicInfo>> curMusicList;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<ax>> categoryList;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ax> curCategoryLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private c webCallback;

    /* renamed from: W, reason: from kotlin metadata */
    private long videoDurationMs;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private WinkEditorMusicInfo currentMusic;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> checkRecommendMusicLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<WinkEditorMusicInfo> currentMusicLiveData;

    /* renamed from: a0, reason: from kotlin metadata */
    private boolean enableMusic;

    /* renamed from: b0, reason: from kotlin metadata */
    @Nullable
    private DraftMusic draftMusic;

    /* renamed from: c0, reason: from kotlin metadata */
    @Nullable
    private Integer startTimeInMs;

    /* renamed from: d0, reason: from kotlin metadata */
    @Nullable
    private Integer endTimeInMs;

    /* renamed from: e0, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Integer> musicStartTimeMap;

    /* renamed from: f0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> errorLiveData;

    /* renamed from: g0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showLyricMenuDialogLiveData;

    /* renamed from: h0, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showLyricMenuDialogLiveData;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private Float bgmVolume;

    /* renamed from: i0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkEditorMusicInfo> musicButtonExposeLiveData;

    /* renamed from: j0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<HashMap<WinkMusicListFragment.MusicRequestType, MusicRspResult>> _rspResultLiveData;

    /* renamed from: k0, reason: from kotlin metadata */
    private boolean hasTemplateInVideoMode;

    /* renamed from: l0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> currentPlayerTimeLiveData;

    /* renamed from: m */
    private long initTime;

    /* renamed from: m0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _loadingMusicLiveData;

    /* renamed from: n0, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> loadingMusicLiveData;

    /* renamed from: o0, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageBgmPlayer;

    /* renamed from: p0, reason: from kotlin metadata */
    private boolean getCategoryMusicListFail;

    /* renamed from: q0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MusicInfoWrapper> _bgmSourceLiveData;

    /* renamed from: r0, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MusicInfoWrapper> bgmSourceLiveData;

    /* renamed from: s0, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _playerSeek;

    /* renamed from: t0, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> playerSeek;

    /* renamed from: u0, reason: from kotlin metadata */
    @NotNull
    private final Runnable seekRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$2 */
    /* loaded from: classes21.dex */
    static final class AnonymousClass2 extends Lambda implements Function1<List<? extends WinkEditorMusicInfo>, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkEditorMusicInfo> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(List<? extends WinkEditorMusicInfo> list) {
            w53.b.a("MusicSourceViewModel", "musicList call curMusicList");
            MusicSourceViewModel.this.K4();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ax;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/wink/editor/music/ax;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$3 */
    /* loaded from: classes21.dex */
    static final class AnonymousClass3 extends Lambda implements Function1<ax, Unit> {
        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ax axVar) {
            invoke2(axVar);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(ax axVar) {
            w53.b.a("MusicSourceViewModel", "curCategoryLiveData call curMusicList");
            MusicSourceViewModel.this.K4();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ax;", "kotlin.jvm.PlatformType", "curCategory", "", "invoke", "(Lcom/tencent/mobileqq/wink/editor/music/ax;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$4 */
    /* loaded from: classes21.dex */
    static final class AnonymousClass4 extends Lambda implements Function1<ax, Unit> {
        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ax axVar) {
            invoke2(axVar);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(ax curCategory) {
            Iterable<IndexedValue> withIndex;
            Object orNull;
            Object orNull2;
            w53.b.a("MusicSourceViewModel", "curCategoryLiveData call categoryList");
            withIndex = CollectionsKt___CollectionsKt.withIndex(MusicSourceViewModel.this.F2());
            int i3 = -1;
            for (IndexedValue indexedValue : withIndex) {
                ((ax) indexedValue.getValue()).f320785c = Intrinsics.areEqual(curCategory.f320783a, ((ax) indexedValue.getValue()).f320783a);
                if (((ax) indexedValue.getValue()).f320785c) {
                    i3 = indexedValue.getIndex();
                }
            }
            MusicSourceViewModel musicSourceViewModel = MusicSourceViewModel.this;
            Intrinsics.checkNotNullExpressionValue(curCategory, "curCategory");
            musicSourceViewModel.G2(curCategory);
            orNull = CollectionsKt___CollectionsKt.getOrNull(MusicSourceViewModel.this.F2(), i3 - 1);
            ax axVar = (ax) orNull;
            if (axVar != null) {
                MusicSourceViewModel.this.G2(axVar);
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(MusicSourceViewModel.this.F2(), i3 + 1);
            ax axVar2 = (ax) orNull2;
            if (axVar2 != null) {
                MusicSourceViewModel.this.G2(axVar2);
            }
            MusicSourceViewModel.this.E2().postValue(MusicSourceViewModel.this.F2());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$a", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData$a;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "list", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements MusicListData.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.vo.MusicListData.a
        public void a(@NotNull List<? extends WinkEditorMusicInfo> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            MusicSourceViewModel.this.j3().setValue(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\nR0\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$b;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "moodMIDList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "getMoodMIDList$annotations", "()V", "MUSIC_LOCK", "Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<String> a() {
            return MusicSourceViewModel.f321161x0;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void a(@NotNull WinkEditorMusicInfo musicInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$d", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "value", "", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends MediatorLiveData<List<? extends ax>> {
        d() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c */
        public void postValue(@Nullable List<? extends ax> value) {
            super.postValue(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$e", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicHelper$b;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "editorMusicInfo", "", "progress", "", "b", "", "succeeded", "", "localPath", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements WinkEditorMusicHelper.b {

        /* renamed from: b */
        final /* synthetic */ long f321187b;

        /* renamed from: c */
        final /* synthetic */ boolean f321188c;

        e(long j3, boolean z16) {
            this.f321187b = j3;
            this.f321188c = z16;
        }

        public static final void e(MusicSourceViewModel this$0, WinkEditorMusicInfo editorMusicInfo, boolean z16, String localPath, boolean z17) {
            int i3;
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(editorMusicInfo, "$editorMusicInfo");
            Intrinsics.checkNotNullParameter(localPath, "$localPath");
            if (z16) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            this$0.Q4(editorMusicInfo, i3, 0);
            WinkEditorMusicInfo currentMusic = this$0.getCurrentMusic();
            if (currentMusic != null) {
                str = currentMusic.p();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, editorMusicInfo.p())) {
                if (z16) {
                    this$0.C4(editorMusicInfo);
                    this$0.O4(editorMusicInfo, localPath, z17);
                    return;
                } else {
                    this$0.W2().postValue(Integer.valueOf(R.string.f169662iy));
                    this$0.y2();
                    return;
                }
            }
            if (!z16) {
                QQToast.makeText(com.tencent.mobileqq.wink.b.c(), 1, com.tencent.mobileqq.wink.b.c().getString(R.string.ynb), 0).show();
            }
        }

        public static final void f(MusicSourceViewModel this$0, WinkEditorMusicInfo editorMusicInfo, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(editorMusicInfo, "$editorMusicInfo");
            this$0.Q4(editorMusicInfo, 1, i3);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void a(@NotNull final WinkEditorMusicInfo editorMusicInfo, final boolean succeeded, @NotNull final String localPath) {
            String str;
            Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            long j3 = this.f321187b;
            MusicSourceViewModel musicSourceViewModel = MusicSourceViewModel.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                WinkContext.Companion companion2 = WinkContext.INSTANCE;
                if (companion2.d().u("QCIRCLE")) {
                    WinkPublishQualityReportData.Builder ext2 = new WinkPublishQualityReportData.Builder().eventId("E_DOWNLOAD_MUSIC").traceId(companion2.d().getTraceId()).ext1(String.valueOf(succeeded)).ext2(String.valueOf(System.currentTimeMillis() - j3));
                    if (musicSourceViewModel.getIsVideoClearMusic()) {
                        str = "hasClear";
                    } else {
                        str = "noClear";
                    }
                    WinkPublishQualityReportData reportData = ext2.ext3(str).ext4(editorMusicInfo.p()).ext5("0").getReportData();
                    z93.c f16 = Wink.INSTANCE.f();
                    if (f16 != null) {
                        f16.a(reportData, companion2.d().k().b());
                    }
                }
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final MusicSourceViewModel musicSourceViewModel2 = MusicSourceViewModel.this;
            final boolean z16 = this.f321188c;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.x
                @Override // java.lang.Runnable
                public final void run() {
                    MusicSourceViewModel.e.e(MusicSourceViewModel.this, editorMusicInfo, succeeded, localPath, z16);
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void b(@NotNull final WinkEditorMusicInfo editorMusicInfo, int progress) {
            final int coerceIn;
            Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
            QLog.d("MusicSourceViewModel", 4, "onMusicDownloadUpdate... progress:" + progress);
            coerceIn = RangesKt___RangesKt.coerceIn(progress, 0, 100);
            if (coerceIn % 30 == 0) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final MusicSourceViewModel musicSourceViewModel = MusicSourceViewModel.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        MusicSourceViewModel.e.f(MusicSourceViewModel.this, editorMusicInfo, coerceIn);
                    }
                });
            }
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("0049DggM2Cy6MM", "001qUdxI1wliwP", "003WDRlO13A8ER", "002EKX9d2NwJHL", "0002Mzr04X73MT", "004fUpnL4SoUGo", "004PMzcW1HMSIQ", "001zCeiw2vywup", "001e9zOq2BuJnv", "0003f6pW1hOLKG", "003CRztf2n0n9Y", "003rOYY20RlzkR", "002PjuK03AFvis", "002r4LRv3Ta5IN", "002MLS0D3zqTdU", "003HiAIU3BlhTN", "001l0Tk32R0Cbw", "000qfEGG3kESi3", "000ZMc5Z0Uc47l", "004BIXOB13hzHl", "00075Y8H18mcMc", "002uqdJ90k6BLa", "002aDKoA4Md7NI", "0047oMx71CEcSr", "000L57QL3jrlPf", "003xLw2B03PzF5", "002bfpTn2XF4fR", "000bkODd3Jylmj", "002CuMDr4GlT48");
        f321161x0 = arrayListOf;
    }

    public MusicSourceViewModel() {
        Lazy lazy;
        List listOf;
        MusicListData musicListData = new MusicListData();
        this.musicListData = musicListData;
        MutableLiveData<List<WinkEditorMusicInfo>> mutableLiveData = new MutableLiveData<>();
        this.musicList = mutableLiveData;
        this.musicPos = new MutableLiveData<>();
        this.selectTemplateBGM = new MutableLiveData<>();
        this.musicLatch = new CountDownLatch(1);
        this.videoClearMusicLiveData = new MutableLiveData<>();
        this.editMode = WinkEditorViewModel.EditMode.Video;
        this.selectImageBGM = new MutableLiveData<>();
        MediatorLiveData<List<WinkEditorMusicInfo>> mediatorLiveData = new MediatorLiveData<>();
        this.curMusicList = mediatorLiveData;
        d dVar = new d();
        this.categoryList = dVar;
        MutableLiveData<ax> mutableLiveData2 = new MutableLiveData<>();
        this.curCategoryLiveData = mutableLiveData2;
        this.videoDurationMs = 15000L;
        this.checkRecommendMusicLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.currentMusicLiveData = new MutableLiveData<>();
        this.musicStartTimeMap = new HashMap();
        this.errorLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._showLyricMenuDialogLiveData = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.showLyricMenuDialogLiveData = mutableLiveData3;
        this.musicButtonExposeLiveData = new MutableLiveData<>();
        this._rspResultLiveData = new MutableLiveData<>();
        this.currentPlayerTimeLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._loadingMusicLiveData = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.loadingMusicLiveData = mutableLiveData4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaPlayer>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$imageBgmPlayer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaPlayer invoke() {
                return new ReportMediaPlayer();
            }
        });
        this.imageBgmPlayer = lazy;
        w53.b.a("MusicSourceViewModel", "init...");
        this.initTime = System.currentTimeMillis();
        musicListData.x(new a());
        final AnonymousClass2 anonymousClass2 = new Function1<List<? extends WinkEditorMusicInfo>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.2
            AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends WinkEditorMusicInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(List<? extends WinkEditorMusicInfo> list) {
                w53.b.a("MusicSourceViewModel", "musicList call curMusicList");
                MusicSourceViewModel.this.K4();
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSourceViewModel.d2(Function1.this, obj);
            }
        });
        final AnonymousClass3 anonymousClass3 = new Function1<ax, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.3
            AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ax axVar) {
                invoke2(axVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(ax axVar) {
                w53.b.a("MusicSourceViewModel", "curCategoryLiveData call curMusicList");
                MusicSourceViewModel.this.K4();
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSourceViewModel.e2(Function1.this, obj);
            }
        });
        final AnonymousClass4 anonymousClass4 = new Function1<ax, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.4
            AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ax axVar) {
                invoke2(axVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2(ax curCategory) {
                Iterable<IndexedValue> withIndex;
                Object orNull;
                Object orNull2;
                w53.b.a("MusicSourceViewModel", "curCategoryLiveData call categoryList");
                withIndex = CollectionsKt___CollectionsKt.withIndex(MusicSourceViewModel.this.F2());
                int i3 = -1;
                for (IndexedValue indexedValue : withIndex) {
                    ((ax) indexedValue.getValue()).f320785c = Intrinsics.areEqual(curCategory.f320783a, ((ax) indexedValue.getValue()).f320783a);
                    if (((ax) indexedValue.getValue()).f320785c) {
                        i3 = indexedValue.getIndex();
                    }
                }
                MusicSourceViewModel musicSourceViewModel = MusicSourceViewModel.this;
                Intrinsics.checkNotNullExpressionValue(curCategory, "curCategory");
                musicSourceViewModel.G2(curCategory);
                orNull = CollectionsKt___CollectionsKt.getOrNull(MusicSourceViewModel.this.F2(), i3 - 1);
                ax axVar = (ax) orNull;
                if (axVar != null) {
                    MusicSourceViewModel.this.G2(axVar);
                }
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(MusicSourceViewModel.this.F2(), i3 + 1);
                ax axVar2 = (ax) orNull2;
                if (axVar2 != null) {
                    MusicSourceViewModel.this.G2(axVar2);
                }
                MusicSourceViewModel.this.E2().postValue(MusicSourceViewModel.this.F2());
            }
        };
        dVar.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSourceViewModel.f2(Function1.this, obj);
            }
        });
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ax[]{COLLECTION_CATEGORY_INFO, RECOMM_CATEGORY_INFO});
        dVar.postValue(listOf);
        ax axVar = ax.f320778e;
        axVar.f320785c = true;
        mutableLiveData2.postValue(axVar);
        MutableLiveData<MusicInfoWrapper> mutableLiveData5 = new MutableLiveData<>();
        this._bgmSourceLiveData = mutableLiveData5;
        Intrinsics.checkNotNull(mutableLiveData5, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper>");
        this.bgmSourceLiveData = mutableLiveData5;
        MutableLiveData<Long> mutableLiveData6 = new MutableLiveData<>();
        this._playerSeek = mutableLiveData6;
        Intrinsics.checkNotNull(mutableLiveData6, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.playerSeek = mutableLiveData6;
        this.seekRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.p
            @Override // java.lang.Runnable
            public final void run() {
                MusicSourceViewModel.b4(MusicSourceViewModel.this);
            }
        };
    }

    private final void A2() {
        QLog.d("MusicSourceViewModel", 4, "[clearTavCutBgmData]");
        c4();
        this._bgmSourceLiveData.postValue(new MusicInfoWrapper(null, null, 0, 0, false, 30, null));
    }

    private final void B2(String callFunctionName, Function0<Unit> playerAction) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new MusicSourceViewModel$doPlayerActionAsync$1(playerAction, callFunctionName, null), 3, null);
    }

    private final void C2(WinkEditorMusicInfo selectEditorMusicInfo, boolean isAutoMusic) {
        Integer num = null;
        if (selectEditorMusicInfo != null && selectEditorMusicInfo.f321260f != 1) {
            selectEditorMusicInfo.f321260f = 1;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                w53.b.f("MusicSourceViewModel", "[downloadMusic] peekAppRuntime is null");
                return;
            } else {
                ThreadManagerV2.excute(new WinkEditorMusicHelper.MusicDownloadRunnable(peekAppRuntime, selectEditorMusicInfo, selectEditorMusicInfo.t(), WinkEditorMusicHelper.o(selectEditorMusicInfo), new e(System.currentTimeMillis(), isAutoMusic)), 128, null, true);
                return;
            }
        }
        if (selectEditorMusicInfo != null) {
            num = Integer.valueOf(selectEditorMusicInfo.f321260f);
        }
        w53.b.f("MusicSourceViewModel", "[downloadMusic] status invalid: " + num);
    }

    public final void C4(final WinkEditorMusicInfo musicInfo) {
        boolean z16;
        if (musicInfo != null && !musicInfo.w() && musicInfo.n() <= 0 && musicInfo.f321260f == 2) {
            String o16 = WinkEditorMusicHelper.o(musicInfo);
            Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(musicInfo)");
            if (o16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                musicInfo.B(true);
                musicInfo.A((int) this.videoDurationMs);
                final String o17 = WinkEditorMusicHelper.o(musicInfo);
                Intrinsics.checkNotNullExpressionValue(o17, "getMusicLocalPath(musicInfo)");
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        MusicSourceViewModel.D4(o17, musicInfo, this);
                    }
                }, 16, null, true);
            }
        }
    }

    public final List<WinkEditorMusicInfo> D3(List<? extends WinkEditorMusicInfo> list, List<? extends WinkEditorMusicInfo> list2) {
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        for (WinkEditorMusicInfo winkEditorMusicInfo : list2) {
            if (!winkEditorMusicInfo.y() && winkEditorMusicInfo.f321262i != 0) {
                linkedList.add(winkEditorMusicInfo);
                String p16 = winkEditorMusicInfo.p();
                Intrinsics.checkNotNullExpressionValue(p16, "it.songMid");
                hashMap.put(p16, winkEditorMusicInfo);
            }
        }
        for (WinkEditorMusicInfo winkEditorMusicInfo2 : list) {
            if (!winkEditorMusicInfo2.y() && hashMap.get(winkEditorMusicInfo2.p()) == null) {
                linkedList.add(winkEditorMusicInfo2);
            }
        }
        return linkedList;
    }

    public static final void D4(String localPath, final WinkEditorMusicInfo winkEditorMusicInfo, final MusicSourceViewModel this$0) {
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(localPath);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (extractMetadata != null) {
                Intrinsics.checkNotNullExpressionValue(extractMetadata, "extractMetadata(MediaMet\u2026er.METADATA_KEY_DURATION)");
                winkEditorMusicInfo.A(Integer.parseInt(extractMetadata));
            }
            if (winkEditorMusicInfo.n() <= 0) {
                winkEditorMusicInfo.A((int) this$0.videoDurationMs);
            }
            Result.m476constructorimpl(Boolean.valueOf(ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.k
                @Override // java.lang.Runnable
                public final void run() {
                    MusicSourceViewModel.E4(WinkEditorMusicInfo.this, this$0);
                }
            })));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public static final void E4(WinkEditorMusicInfo winkEditorMusicInfo, MusicSourceViewModel this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String p16 = winkEditorMusicInfo.p();
        WinkEditorMusicInfo winkEditorMusicInfo2 = this$0.currentMusic;
        if (winkEditorMusicInfo2 != null) {
            str = winkEditorMusicInfo2.p();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(p16, str)) {
            this$0.M3(winkEditorMusicInfo, 0);
        }
    }

    private final void F3(final VsMusicItemInfo musicItem) {
        if (musicItem != null && WinkEditorMusicHelper.L(musicItem)) {
            this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCancelCollectMusicFromWeb$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), VsMusicItemInfo.this.mSongMid));
                }
            }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCancelCollectMusicFromWeb$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                    invoke2(winkEditorMusicInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.z(false);
                }
            });
            this.musicListData.q(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCancelCollectMusicFromWeb$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), VsMusicItemInfo.this.mSongMid));
                }
            });
        }
    }

    private final void F4(final WinkEditorMusicInfo editorMusicInfo, boolean isFromWeb, final boolean isAutoMusic) {
        ArrayList arrayListOf;
        String str;
        if (editorMusicInfo != null && this.enableMusic) {
            if (editorMusicInfo.f321262i == 3) {
                w53.b.f("MusicSourceViewModel", "[updateBgmData] music type is TYPE_TEMPLATE_BGM");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String o16 = WinkEditorMusicHelper.o(editorMusicInfo);
            Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(editorMusicInfo)");
            if (WinkEditorMusicHelper.p(o16)) {
                this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$updateBgmData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                    }
                }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$updateBgmData$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                        invoke2(winkEditorMusicInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.f321260f = 2;
                    }
                });
                if (isFromWeb) {
                    e4(editorMusicInfo);
                }
                O4(editorMusicInfo, o16, isAutoMusic);
                C4(editorMusicInfo);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    WinkContext.Companion companion2 = WinkContext.INSTANCE;
                    if (companion2.d().u("QCIRCLE")) {
                        WinkPublishQualityReportData.Builder ext2 = new WinkPublishQualityReportData.Builder().eventId("E_DOWNLOAD_MUSIC").traceId(companion2.d().getTraceId()).ext1("true").ext2(String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (this.isVideoClearMusic) {
                            str = "hasClear";
                        } else {
                            str = "noClear";
                        }
                        WinkPublishQualityReportData reportData = ext2.ext3(str).ext4(editorMusicInfo.p()).ext5("1").getReportData();
                        z93.c f16 = Wink.INSTANCE.f();
                        if (f16 != null) {
                            f16.a(reportData, companion2.d().k().b());
                        }
                    }
                    Result.m476constructorimpl(Unit.INSTANCE);
                    return;
                } catch (Throwable th5) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                    return;
                }
            }
            if (!NetworkUtil.isNetworkAvailable()) {
                w53.b.c("MusicSourceViewModel", "[updateBgmData] network not available");
                QQToast.makeText(com.tencent.mobileqq.wink.b.c(), 1, com.tencent.mobileqq.wink.b.c().getString(R.string.ynb), 0).show();
            }
            if (TextUtils.isEmpty(editorMusicInfo.t())) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(editorMusicInfo.p());
                WinkEditorMusicHelper.D(arrayListOf, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.q
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                        MusicSourceViewModel.H4(WinkEditorMusicInfo.this, this, isAutoMusic, baseRequest, z16, j3, str2, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                    }
                });
                return;
            } else {
                C2(editorMusicInfo, isAutoMusic);
                return;
            }
        }
        w53.b.f("MusicSourceViewModel", "[updateBgmData] no bgm");
        x2();
    }

    public final void G2(final ax axVar) {
        if (!Intrinsics.areEqual(axVar.f320783a, "FAKE_CATEGORY_RECOMMEND_ID") && !axVar.a()) {
            if (Intrinsics.areEqual(axVar.f320783a, "FAKE_CATEGORY_COLLECTION_ID")) {
                J2();
            } else if (Intrinsics.areEqual(axVar.f320783a, "FAKE_CATEGORY_MOOD_ID")) {
                e3();
            } else {
                WinkEditorMusicHelper.z(axVar, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.r
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        MusicSourceViewModel.H2(ax.this, this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp) obj);
                    }
                });
            }
        }
    }

    static /* synthetic */ void G4(MusicSourceViewModel musicSourceViewModel, WinkEditorMusicInfo winkEditorMusicInfo, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        musicSourceViewModel.F4(winkEditorMusicInfo, z16, z17);
    }

    public static final void H2(ax categoryInfo, MusicSourceViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(categoryInfo, "$categoryInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            categoryInfo.e();
            if (qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp.musicInfoList) != null) {
                List<WinkEditorMusicInfo> editorMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(pBRepeatMessageField.get()), categoryInfo.f320783a, categoryInfo.f320784b);
                MusicListData musicListData = this$0.musicListData;
                Intrinsics.checkNotNullExpressionValue(editorMusicList, "editorMusicList");
                musicListData.w(categoryInfo, editorMusicList);
            }
        }
    }

    private final void H3(final VsMusicItemInfo musicItem) {
        if (musicItem != null && WinkEditorMusicHelper.L(musicItem)) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCollectMusicFromWeb$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), VsMusicItemInfo.this.mSongMid));
                }
            }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCollectMusicFromWeb$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                    invoke2(winkEditorMusicInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Ref.BooleanRef.this.element = it.f321259e;
                    it.z(true);
                }
            });
            final WinkEditorMusicInfo winkEditorMusicInfo = new WinkEditorMusicInfo(musicItem, booleanRef.element, 2, "FAKE_CATEGORY_COLLECTION_ID");
            winkEditorMusicInfo.z(true);
            if (this.musicListData.g(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCollectMusicFromWeb$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()) && Intrinsics.areEqual(it.D, "FAKE_CATEGORY_COLLECTION_ID"));
                }
            })) {
                this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCollectMusicFromWeb$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                    }
                }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCollectMusicFromWeb$5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo2) {
                        invoke2(winkEditorMusicInfo2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.z(true);
                    }
                });
            } else {
                this.musicListData.a(winkEditorMusicInfo, 0);
            }
        }
    }

    public static final void H4(WinkEditorMusicInfo winkEditorMusicInfo, MusicSourceViewModel this$0, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        List<QQCircleSmartMatchMusic$MusicInfo> list;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp == null) {
            w53.b.f("MusicSourceViewModel", "[updateBgmData] musicInfoRsp is null");
            return;
        }
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo;
        if (pBRepeatMessageField != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        List<WinkEditorMusicInfo> queriedMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(list), winkEditorMusicInfo.D, winkEditorMusicInfo.E);
        Intrinsics.checkNotNullExpressionValue(queriedMusicList, "queriedMusicList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) queriedMusicList);
        WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) firstOrNull;
        if (winkEditorMusicInfo2 != null) {
            this$0.C2(winkEditorMusicInfo2, z16);
        }
    }

    private final void J2() {
        if (ax.f320779f.a()) {
            w53.b.a("MusicSourceViewModel", "getCollectionMusicList... isLoaded");
        } else {
            w53.b.a("MusicSourceViewModel", "getCollectionMusicList... requestCollectionMusicList");
            WinkEditorMusicHelper.B(new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.v
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    MusicSourceViewModel.K2(MusicSourceViewModel.this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$GetMusicCollectionRsp) obj);
                }
            });
        }
    }

    public static final void K2(MusicSourceViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$GetMusicCollectionRsp qQCircleSmartMatchMusic$GetMusicCollectionRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        String str2;
        WinkEditorMusicInfo winkEditorMusicInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            if (qQCircleSmartMatchMusic$GetMusicCollectionRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$GetMusicCollectionRsp.musicList) != null) {
                ax.f320779f.e();
                List<WinkEditorMusicInfo> editorMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(pBRepeatMessageField.get()), "FAKE_CATEGORY_COLLECTION_ID", "\u6536\u85cf");
                Intrinsics.checkNotNullExpressionValue(editorMusicList, "editorMusicList");
                int i3 = 0;
                for (Object obj : editorMusicList) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String p16 = ((WinkEditorMusicInfo) obj).p();
                    WinkEditorMusicInfo winkEditorMusicInfo2 = this$0.currentMusic;
                    if (winkEditorMusicInfo2 != null) {
                        str2 = winkEditorMusicInfo2.p();
                    } else {
                        str2 = null;
                    }
                    if (Intrinsics.areEqual(p16, str2) && (winkEditorMusicInfo = this$0.currentMusic) != null) {
                        winkEditorMusicInfo.z(true);
                    }
                    i3 = i16;
                }
                this$0.musicListData.t(editorMusicList);
            }
        } else {
            w53.b.g("MusicSourceViewModel", "getCollectionMusicList... requestCollectionMusicList fail");
        }
        this$0.T4(z16, WinkMusicListFragment.MusicRequestType.COLLECTION);
    }

    public static final void K3(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$ModMusicCollectionRsp qQCircleSmartMatchMusic$ModMusicCollectionRsp) {
        if (!z16) {
            w53.b.a("MusicSourceViewModel", "QQWinkModMusicCollectionReq, onReceive, failed");
        }
    }

    public final void K4() {
        List<WinkEditorMusicInfo> emptyList;
        String str;
        ax L2 = L2();
        Unit unit = null;
        if (L2 != null) {
            ArrayList arrayList = new ArrayList();
            for (WinkEditorMusicInfo winkEditorMusicInfo : k3()) {
                if (L2.b(winkEditorMusicInfo)) {
                    String p16 = winkEditorMusicInfo.p();
                    WinkEditorMusicInfo winkEditorMusicInfo2 = this.currentMusic;
                    if (winkEditorMusicInfo2 != null) {
                        str = winkEditorMusicInfo2.p();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(p16, str)) {
                        winkEditorMusicInfo.f321259e = true;
                        k4(winkEditorMusicInfo);
                        this.currentMusicLiveData.setValue(winkEditorMusicInfo);
                    } else {
                        winkEditorMusicInfo.f321259e = false;
                    }
                    arrayList.add(winkEditorMusicInfo);
                }
            }
            w53.b.a("MusicSourceViewModel", "updateCurMusicList... curList size:" + arrayList.size());
            this.curMusicList.postValue(arrayList);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            w53.b.a("MusicSourceViewModel", "updateCurMusicList... curList size:0");
            MediatorLiveData<List<WinkEditorMusicInfo>> mediatorLiveData = this.curMusicList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mediatorLiveData.postValue(emptyList);
        }
    }

    public static final void L3(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$ModMusicCollectionRsp qQCircleSmartMatchMusic$ModMusicCollectionRsp) {
        if (!z16) {
            w53.b.a("MusicSourceViewModel", "QQWinkModMusicCollectionReq, onReceive, failed");
        }
    }

    private final void N4(final WinkEditorMusicInfo imageMusicInfo) {
        final String o16 = WinkEditorMusicHelper.o(imageMusicInfo);
        Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(imageMusicInfo)");
        if (!WinkEditorMusicHelper.p(o16)) {
            return;
        }
        B2("updateImageBgmData", new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$updateImageBgmData$1
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
                MediaPlayer a36;
                MediaPlayer a37;
                MediaPlayer a38;
                MediaPlayer a39;
                MediaPlayer a310;
                MediaPlayer a311;
                MediaPlayer a312;
                MediaPlayer a313;
                MediaPlayer a314;
                a36 = MusicSourceViewModel.this.a3();
                a36.stop();
                a37 = MusicSourceViewModel.this.a3();
                a37.reset();
                a38 = MusicSourceViewModel.this.a3();
                a38.setAudioStreamType(3);
                a39 = MusicSourceViewModel.this.a3();
                a39.setDataSource(o16);
                a310 = MusicSourceViewModel.this.a3();
                a310.setVolume(1.0f, 1.0f);
                a311 = MusicSourceViewModel.this.a3();
                a311.prepare();
                a312 = MusicSourceViewModel.this.a3();
                a312.seekTo(imageMusicInfo.s());
                a313 = MusicSourceViewModel.this.a3();
                a313.setLooping(true);
                a314 = MusicSourceViewModel.this.a3();
                a314.start();
                MusicSourceViewModel.this.t3().postValue(imageMusicInfo);
            }
        });
    }

    public static /* synthetic */ void O3(MusicSourceViewModel musicSourceViewModel, WinkEditorMusicInfo winkEditorMusicInfo, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        musicSourceViewModel.N3(winkEditorMusicInfo, i3, z16, z17);
    }

    private final void P3() {
        QLog.i("MusicSourceViewModel", 1, "[onMusicSelectedFromRecommend]");
        this.checkRecommendMusicLiveData.setValue(Boolean.TRUE);
    }

    public static /* synthetic */ void P4(MusicSourceViewModel musicSourceViewModel, WinkEditorMusicInfo winkEditorMusicInfo, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        musicSourceViewModel.O4(winkEditorMusicInfo, str, z16);
    }

    public final void Q4(final WinkEditorMusicInfo editorMusicInfo, final int r46, final int progress) {
        if (editorMusicInfo.y()) {
            return;
        }
        this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$updateMusicListOnDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(WinkEditorMusicInfo.this.p(), it.p()));
            }
        }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$updateMusicListOnDownload$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                invoke2(winkEditorMusicInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.f321260f = r46;
                it.f321261h = progress;
            }
        });
    }

    private final void R4(WinkMusicListFragment.MusicRequestType key, MusicRspResult value) {
        w53.b.a("MusicSourceViewModel", "updateRspResultLiveData... key:" + key + " value:" + value);
        HashMap<WinkMusicListFragment.MusicRequestType, MusicRspResult> value2 = this._rspResultLiveData.getValue();
        if (value2 == null) {
            value2 = new HashMap<>();
        }
        value2.put(key, value);
        this._rspResultLiveData.setValue(value2);
    }

    private final void S2(ArrayList<String> musicIdList) {
        boolean z16;
        if (!ax.f320782i.a()) {
            if (musicIdList != null && !musicIdList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                WinkEditorMusicHelper.C(musicIdList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.u
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                        MusicSourceViewModel.T2(MusicSourceViewModel.this, baseRequest, z17, j3, str, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                    }
                });
            }
        }
    }

    private final void S4(WinkEditorMusicInfo data, String localPath, boolean isAutoMusic) {
        int s16;
        Unit unit;
        String p16 = data.p();
        Intrinsics.checkNotNullExpressionValue(p16, "data.songMid");
        Integer m3 = m3(p16);
        if (m3 != null) {
            s16 = m3.intValue();
        } else {
            String p17 = data.p();
            Intrinsics.checkNotNullExpressionValue(p17, "data.songMid");
            a4(p17, data.s(), false);
            s16 = data.s();
        }
        this._bgmSourceLiveData.postValue(new MusicInfoWrapper(data, localPath, s16, (int) this.videoDurationMs, isAutoMusic));
        if (isAutoMusic) {
            WinkContext.Companion companion = WinkContext.INSTANCE;
            if (companion.d().u("QCIRCLE")) {
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_EDIT_MUSIC_APPLY").traceId(companion.d().getTraceId()).ext1(data.p()).ext2(String.valueOf(System.currentTimeMillis() - this.initTime)).ext3(String.valueOf(isAutoMusic)).getReportData();
                    z93.c f16 = Wink.INSTANCE.f();
                    if (f16 != null) {
                        f16.a(reportData, companion.d().k().b());
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.m476constructorimpl(unit);
                } catch (Throwable th5) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
        }
    }

    public static final void T2(MusicSourceViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && qQCircleSmartMatchMusic$MusicInfoRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo) != null) {
            ax.f320782i.e();
            List<WinkEditorMusicInfo> editorMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(pBRepeatMessageField.get()), "FAKE_CATEGORY_DAILY_SIGN_ID", "\u968f\u8bb0");
            Intrinsics.checkNotNullExpressionValue(editorMusicList, "editorMusicList");
            if (!editorMusicList.isEmpty()) {
                editorMusicList.add(0, editorMusicList.remove(RandomKt.Random(System.currentTimeMillis()).nextInt(editorMusicList.size())));
            }
            this$0.musicListData.u(editorMusicList);
        }
        this$0.T4(z16, WinkMusicListFragment.MusicRequestType.DAILY_SIGN);
    }

    private final void T4(boolean isSuccess, WinkMusicListFragment.MusicRequestType type) {
        MusicRspResult.Result result;
        if (isSuccess) {
            result = MusicRspResult.Result.SUCCESS;
        } else {
            result = MusicRspResult.Result.NO_NET;
        }
        R4(type, new MusicRspResult(type, result));
    }

    private final void U3(VsMusicItemInfo vsMusicItemInfo, boolean needSelect, Intent intent, boolean needScroll) {
        String str;
        Object obj;
        boolean z16;
        if (!TextUtils.isEmpty(vsMusicItemInfo.mSongMid) && WinkEditorMusicHelper.L(vsMusicItemInfo)) {
            if (this.isFromDailySign) {
                str = "FAKE_CATEGORY_DAILY_SIGN_ID";
            } else {
                str = "FAKE_CATEGORY_RECOMMEND_ID";
            }
            int i3 = 0;
            WinkEditorMusicInfo winkEditorMusicInfo = new WinkEditorMusicInfo(vsMusicItemInfo, false, 2, str);
            winkEditorMusicInfo.F = true;
            Iterator<T> it = this.musicListData.h().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((WinkEditorMusicInfo) obj).p(), winkEditorMusicInfo.p())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            winkEditorMusicInfo.z(z16);
            if (intent.hasExtra("clipStartTime")) {
                this.startTimeInMs = Integer.valueOf(intent.getIntExtra("clipStartTime", 0));
                String p16 = winkEditorMusicInfo.p();
                Intrinsics.checkNotNullExpressionValue(p16, "musicInfo.songMid");
                Integer num = this.startTimeInMs;
                if (num != null) {
                    i3 = num.intValue();
                }
                a4(p16, i3, true);
            }
            if (intent.hasExtra(CacheTable.TABLE_NAME)) {
                try {
                    winkEditorMusicInfo.G = (com.tencent.mobileqq.wink.editor.music.vo.a) new Gson().fromJson(intent.getStringExtra(CacheTable.TABLE_NAME), com.tencent.mobileqq.wink.editor.music.vo.a.class);
                } catch (JsonParseException e16) {
                    w53.b.a("MusicSourceViewModel", "requestDetailedMusicInfoForWeb,  musicInfo.musicH5ReportData = " + e16);
                }
            }
            if (needSelect) {
                O3(this, winkEditorMusicInfo, 0, needScroll, false, 8, null);
            } else {
                WinkEditorMusicHelper.I(winkEditorMusicInfo, null);
            }
        }
    }

    static /* synthetic */ void V3(MusicSourceViewModel musicSourceViewModel, VsMusicItemInfo vsMusicItemInfo, boolean z16, Intent intent, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        musicSourceViewModel.U3(vsMusicItemInfo, z16, intent, z17);
    }

    public final MediaPlayer a3() {
        return (MediaPlayer) this.imageBgmPlayer.getValue();
    }

    public static final void b4(MusicSourceViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._playerSeek.postValue(0L);
    }

    public final void c3(List<QQCircleSmartMatchMusic$MusicInfo> stMusicList) {
        Collection collection;
        if (stMusicList.size() > 0 && !TextUtils.isEmpty(stMusicList.get(0).songInfo.MID.get())) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = stMusicList.iterator();
            while (it.hasNext()) {
                String str = ((QQCircleSmartMatchMusic$MusicInfo) it.next()).songInfo.MID.get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            collection = CollectionsKt___CollectionsKt.toCollection(arrayList, new ArrayList());
            WinkEditorMusicHelper.D((ArrayList) collection, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.m
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    MusicSourceViewModel.d3(MusicSourceViewModel.this, baseRequest, z16, j3, str2, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                }
            });
        }
    }

    private final void c4() {
        ThreadManager.getUIHandler().removeCallbacks(this.seekRunnable);
        ThreadManager.getUIHandler().postDelayed(this.seekRunnable, 30L);
    }

    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void d3(MusicSourceViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        final QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp == null) {
            w53.b.f("MusicSourceViewModel", "[updateBgmData] musicInfoRsp is null");
            return;
        }
        List<QQCircleSmartMatchMusic$MusicInfo> list = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get();
        if (list != null) {
            for (QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo2 : list) {
                if (qQCircleSmartMatchMusic$MusicInfo2 != null && (qQCircleSmartMatchMusic$MusicInfo = qQCircleSmartMatchMusic$MusicInfo2.get()) != null) {
                    Intrinsics.checkNotNullExpressionValue(qQCircleSmartMatchMusic$MusicInfo, "get()");
                    this$0.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$getLyrics$1$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(Intrinsics.areEqual(QQCircleSmartMatchMusic$MusicInfo.this.songInfo.MID.get(), it.p()));
                        }
                    }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$getLyrics$1$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                            invoke2(winkEditorMusicInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            VsMusicItemInfo j16 = it.j();
                            if (j16 != null) {
                                j16.f320652e = QQCircleSmartMatchMusic$MusicInfo.this.lyricInfo.strLyric.get();
                            }
                            VsMusicItemInfo j17 = it.j();
                            if (j17 != null) {
                                j17.f320651d = QQCircleSmartMatchMusic$MusicInfo.this.lyricInfo.strFormat.get();
                            }
                            VsMusicItemInfo j18 = it.j();
                            if (j18 != null) {
                                j18.f320656m = QQCircleSmartMatchMusic$MusicInfo.this.foreignlyric.strLyric.get();
                            }
                            VsMusicItemInfo j19 = it.j();
                            if (j19 == null) {
                                return;
                            }
                            j19.C = QQCircleSmartMatchMusic$MusicInfo.this.foreignlyric.strFormat.get();
                        }
                    });
                }
            }
        }
    }

    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void e3() {
        if (ax.f320780g.a()) {
            return;
        }
        WinkEditorMusicHelper.E(new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.i
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                MusicSourceViewModel.f3(MusicSourceViewModel.this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
            }
        });
    }

    public static final void f2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f3(MusicSourceViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && qQCircleSmartMatchMusic$MusicInfoRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo) != null) {
            ax.f320780g.e();
            List<WinkEditorMusicInfo> editorMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(pBRepeatMessageField.get()), "FAKE_CATEGORY_MOOD_ID", "\u5fc3\u60c5\u65e5\u8bb0");
            Intrinsics.checkNotNullExpressionValue(editorMusicList, "editorMusicList");
            if (!editorMusicList.isEmpty()) {
                editorMusicList.add(0, editorMusicList.remove(RandomKt.Random(System.currentTimeMillis()).nextInt(editorMusicList.size())));
            }
            this$0.musicListData.v(editorMusicList);
        }
    }

    private final void h3() {
        w53.b.a("MusicSourceViewModel", "getMusicCategoryList...");
        final long currentTimeMillis = System.currentTimeMillis();
        ax.f320779f.c();
        ax.f320778e.c();
        this.getCategoryMusicListFail = false;
        WinkEditorMusicHelper.F(new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.s
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                MusicSourceViewModel.i3(MusicSourceViewModel.this, currentTimeMillis, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp) obj);
            }
        });
    }

    public static /* synthetic */ void h4(MusicSourceViewModel musicSourceViewModel, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        musicSourceViewModel.g4(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
    
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void i3(MusicSourceViewModel this$0, long j3, BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp) {
        List emptyList;
        List<ax> mutableList;
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicCategoryInfo> pBRepeatMessageField;
        List<QQCircleSmartMatchMusic$MusicCategoryInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            ax.f320778e.e();
            List<ax> value = this$0.categoryList.getValue();
            if (value == null || mutableList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
            }
            if (qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp.categoryInfo) != null && (list = pBRepeatMessageField.get()) != null) {
                for (QQCircleSmartMatchMusic$MusicCategoryInfo qQCircleSmartMatchMusic$MusicCategoryInfo : list) {
                    mutableList.add(new ax(qQCircleSmartMatchMusic$MusicCategoryInfo.categoryID.get(), qQCircleSmartMatchMusic$MusicCategoryInfo.categoryName.get()));
                }
            }
            this$0.categoryList.postValue(mutableList);
        }
        w53.b.a("MusicSourceViewModel", "getMusicCategoryList... isSuccess:" + z16);
        this$0.getCategoryMusicListFail = z16 ^ true;
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            if (companion2.d().u("QCIRCLE")) {
                WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_RECOMMEND_CATEGORY_LIST").traceId(companion2.d().getTraceId()).ext1(String.valueOf(z16)).ext2(String.valueOf(System.currentTimeMillis() - j3)).retCode(String.valueOf(j16)).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                }
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public static /* synthetic */ void q3(MusicSourceViewModel musicSourceViewModel, List list, List list2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        musicSourceViewModel.p3(list, list2, z16);
    }

    public static final void r3(List list, MusicSourceViewModel this$0, boolean z16, long j3, List bitmaps, BaseRequest baseRequest, boolean z17, long j16, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
        List<QQCircleSmartMatchMusic$MusicInfo> list2;
        Integer num;
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmaps, "$bitmaps");
        if (z17) {
            Integer num2 = null;
            if (qQCircleSmartMatchMusic$SmartMatchMusicRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$SmartMatchMusicRsp.musicListInfo) != null) {
                list2 = pBRepeatMessageField.get();
            } else {
                list2 = null;
            }
            if (list2 != null) {
                num = Integer.valueOf(list2.size());
            } else {
                num = null;
            }
            if (list != null) {
                num2 = Integer.valueOf(list.size());
            }
            w53.b.f("MusicSourceViewModel", "[getRecommendMusicList] stMusicList.size=" + num + ", tongKuanMusic.size=" + num2);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MusicSourceViewModel$getRecommendMusicList$1$1(this$0, list2, z16, list, null), 3, null);
        } else {
            w53.b.f("MusicSourceViewModel", "[getRecommendMusicList] requestRecommendMusicList failed");
            this$0.errorLiveData.postValue(Integer.valueOf(R.string.ynb));
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            if (companion2.d().u("QCIRCLE")) {
                WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_RECOMMEND_MUSIC_LIST").traceId(companion2.d().getTraceId()).ext1(String.valueOf(z17)).ext2(String.valueOf(System.currentTimeMillis() - j3)).ext3(String.valueOf(bitmaps.size())).retCode(String.valueOf(j16)).getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                }
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        this$0.T4(z17, WinkMusicListFragment.MusicRequestType.RECOMMEND);
    }

    private final int t2(WinkEditorMusicInfo musicInfo, int position) {
        Iterator<WinkEditorMusicInfo> it = this.musicListData.p().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().p(), "fakeMid_template_bgm")) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (position <= i3) {
            position = i3 + 1;
        }
        if (position >= this.musicListData.p().size()) {
            int size = this.musicListData.p().size();
            MusicListData.d(this.musicListData, musicInfo, 0, 2, null);
            return size;
        }
        this.musicListData.c(musicInfo, position);
        return position;
    }

    public static /* synthetic */ void v2(MusicSourceViewModel musicSourceViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        musicSourceViewModel.u2(z16);
    }

    private final void x2() {
        w53.b.f("MusicSourceViewModel", "[clearMaterialBgmData]");
        if (this.editMode == WinkEditorViewModel.EditMode.Image) {
            w2();
        } else {
            w2();
            A2();
        }
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, "");
    }

    private final int z3(WinkEditorMusicInfo musicInfo, int position) {
        if (this.isFromDailySign) {
            musicInfo.D = "FAKE_CATEGORY_DAILY_SIGN_ID";
            if (position >= this.musicListData.i().size()) {
                int size = this.musicListData.i().size();
                MusicListData musicListData = this.musicListData;
                ax DAILY_SIGN_CATEGORY_INFO = ax.f320782i;
                Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO, "DAILY_SIGN_CATEGORY_INFO");
                musicListData.b(DAILY_SIGN_CATEGORY_INFO, musicInfo, -1);
                return size;
            }
            MusicListData musicListData2 = this.musicListData;
            ax DAILY_SIGN_CATEGORY_INFO2 = ax.f320782i;
            Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO2, "DAILY_SIGN_CATEGORY_INFO");
            musicListData2.b(DAILY_SIGN_CATEGORY_INFO2, musicInfo, position);
            return position;
        }
        musicInfo.D = "FAKE_CATEGORY_RECOMMEND_ID";
        return t2(musicInfo, position);
    }

    public final boolean A3() {
        return !this.musicListData.p().isEmpty();
    }

    public final void A4(@Nullable c cVar) {
        this.webCallback = cVar;
    }

    public final void B4(boolean r26) {
        this._showLyricMenuDialogLiveData.postValue(Boolean.valueOf(r26));
    }

    /* renamed from: C3, reason: from getter */
    public final boolean getIsVideoClearMusic() {
        return this.isVideoClearMusic;
    }

    @NotNull
    public final LiveData<MusicInfoWrapper> D2() {
        return this.bgmSourceLiveData;
    }

    @NotNull
    public final MediatorLiveData<List<ax>> E2() {
        return this.categoryList;
    }

    public final void E3() {
        J2();
    }

    @NotNull
    public final List<ax> F2() {
        List<ax> emptyList;
        List<ax> value = this.categoryList.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return value;
    }

    public final void G3(@NotNull ax categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        w53.b.a("MusicSourceViewModel", "onCategorySelected... categoryInfo:" + categoryInfo);
        this.curCategoryLiveData.postValue(categoryInfo);
        if (Intrinsics.areEqual(categoryInfo, ax.f320779f)) {
            this.musicListData.q(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCategorySelected$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf((it.x() || it.f321259e) ? false : true);
                }
            });
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> I2() {
        return this.checkRecommendMusicLiveData;
    }

    public final void I3() {
        final WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null) {
            boolean x16 = winkEditorMusicInfo.x();
            for (WinkEditorMusicInfo winkEditorMusicInfo2 : this.musicListData.l()) {
                if (Intrinsics.areEqual(winkEditorMusicInfo2.p(), winkEditorMusicInfo.p())) {
                    winkEditorMusicInfo2.z(!x16);
                }
            }
            if (x16) {
                this.musicListData.q(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                    }
                });
            } else if (this.musicListData.g(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()) && Intrinsics.areEqual(it.D, "FAKE_CATEGORY_COLLECTION_ID"));
                }
            })) {
                this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                    }
                }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$1$5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo3) {
                        invoke2(winkEditorMusicInfo3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.z(true);
                    }
                });
            } else {
                MusicListData musicListData = this.musicListData;
                VsMusicItemInfo j3 = winkEditorMusicInfo.j();
                Intrinsics.checkNotNull(j3);
                musicListData.a(new WinkEditorMusicInfo(j3, winkEditorMusicInfo.f321259e, winkEditorMusicInfo.f321262i, winkEditorMusicInfo.f321263m, winkEditorMusicInfo.C, "FAKE_CATEGORY_COLLECTION_ID", "\u6536\u85cf"), 0);
            }
            WinkEditorMusicHelper.A(winkEditorMusicInfo, x16, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.t
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j16, String str, Object obj) {
                    MusicSourceViewModel.K3(baseRequest, z16, j16, str, (QQCircleSmartMatchMusic$ModMusicCollectionRsp) obj);
                }
            });
        }
    }

    public final void I4() {
        Integer num;
        long coerceAtMost;
        int s16;
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null && (num = this.startTimeInMs) != null) {
            int intValue = num.intValue();
            QLog.d("MusicSourceViewModel", 4, "[updateBgmRange] " + winkEditorMusicInfo.p());
            com.tencent.mobileqq.wink.editor.music.lyric.e a16 = com.tencent.mobileqq.wink.editor.music.lyric.e.a();
            long j3 = (long) intValue;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.videoDurationMs + j3, (long) winkEditorMusicInfo.n());
            a16.d(j3, coerceAtMost);
            c4();
            MutableLiveData<MusicInfoWrapper> mutableLiveData = this._bgmSourceLiveData;
            String o16 = WinkEditorMusicHelper.o(winkEditorMusicInfo);
            Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(music)");
            Integer num2 = this.startTimeInMs;
            if (num2 != null) {
                s16 = num2.intValue();
            } else {
                s16 = winkEditorMusicInfo.s();
            }
            mutableLiveData.postValue(new MusicInfoWrapper(winkEditorMusicInfo, o16, s16, (int) this.videoDurationMs, false, 16, null));
        }
    }

    public final void J3(@NotNull final WinkEditorMusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        boolean x16 = musicInfo.x();
        for (WinkEditorMusicInfo winkEditorMusicInfo : this.musicListData.l()) {
            if (Intrinsics.areEqual(winkEditorMusicInfo.p(), musicInfo.p())) {
                winkEditorMusicInfo.z(!x16);
            }
        }
        if (x16) {
            this.musicListData.q(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                }
            });
        } else if (this.musicListData.g(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()) && Intrinsics.areEqual(it.D, "FAKE_CATEGORY_COLLECTION_ID"));
            }
        })) {
            this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.p(), WinkEditorMusicInfo.this.p()));
                }
            }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicCollected$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo2) {
                    invoke2(winkEditorMusicInfo2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.z(true);
                }
            });
        } else {
            MusicListData musicListData = this.musicListData;
            VsMusicItemInfo j3 = musicInfo.j();
            Intrinsics.checkNotNull(j3);
            musicListData.a(new WinkEditorMusicInfo(j3, musicInfo.f321259e, musicInfo.f321262i, musicInfo.f321263m, musicInfo.C, "FAKE_CATEGORY_COLLECTION_ID", "\u6536\u85cf"), 0);
        }
        WinkEditorMusicHelper.A(musicInfo, x16, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j16, String str, Object obj) {
                MusicSourceViewModel.L3(baseRequest, z16, j16, str, (QQCircleSmartMatchMusic$ModMusicCollectionRsp) obj);
            }
        });
    }

    public final void J4(@NotNull WinkEditorMusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        if (this.musicListData.h().isEmpty()) {
            musicInfo.z(false);
        }
        for (WinkEditorMusicInfo winkEditorMusicInfo : this.musicListData.h()) {
            if (Intrinsics.areEqual(winkEditorMusicInfo.p(), musicInfo.p())) {
                musicInfo.z(winkEditorMusicInfo.x());
            }
        }
    }

    @Nullable
    public final ax L2() {
        return this.curCategoryLiveData.getValue();
    }

    public final void L4() {
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null) {
            String o16 = WinkEditorMusicHelper.o(winkEditorMusicInfo);
            Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(it)");
            P4(this, winkEditorMusicInfo, o16, false, 4, null);
        }
    }

    @NotNull
    public final MutableLiveData<ax> M2() {
        return this.curCategoryLiveData;
    }

    public final void M3(@Nullable WinkEditorMusicInfo selectedMusicInfo, int position) {
        O3(this, selectedMusicInfo, position, true, false, 8, null);
        c4();
    }

    public final void M4(@NotNull ArrayList<String> musicIdList) {
        List<ax> listOf;
        Intrinsics.checkNotNullParameter(musicIdList, "musicIdList");
        w53.b.a("MusicSourceViewModel", "updateDailySignMusicList: " + musicIdList);
        MediatorLiveData<List<ax>> mediatorLiveData = this.categoryList;
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        ax DAILY_SIGN_CATEGORY_INFO = ax.f320782i;
        Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO, "DAILY_SIGN_CATEGORY_INFO");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ax[]{COLLECTION_CATEGORY_INFO, DAILY_SIGN_CATEGORY_INFO});
        mediatorLiveData.postValue(listOf);
        ax.f320782i.c();
        ax axVar = ax.f320782i;
        axVar.f320785c = true;
        this.curCategoryLiveData.postValue(axVar);
        h3();
        J2();
        S2(musicIdList);
    }

    @NotNull
    public final MediatorLiveData<List<WinkEditorMusicInfo>> N2() {
        return this.curMusicList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N3(@Nullable final WinkEditorMusicInfo selectedMusicInfo, int position, boolean needScroll, boolean isAutoMusic) {
        int i3;
        String str;
        ax value;
        boolean z16;
        if (isAutoMusic) {
            this._loadingMusicLiveData.postValue(Boolean.TRUE);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = selectedMusicInfo;
        MutableLiveData<Boolean> mutableLiveData = this.videoClearMusicLiveData;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.postValue(bool);
        this.isVideoClearMusic = false;
        k4((WinkEditorMusicInfo) objectRef.element);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        this.musicListData.e(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicSelected$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                int i16;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!it.y() && ((i16 = it.f321262i) == 2 || i16 == 3));
            }
        }, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onMusicSelected$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                invoke2(winkEditorMusicInfo);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkEditorMusicInfo winkEditorMusicInfo = WinkEditorMusicInfo.this;
                if (Intrinsics.areEqual(winkEditorMusicInfo != null ? winkEditorMusicInfo.p() : null, it.p())) {
                    it.f321259e = true;
                    WinkEditorMusicInfo winkEditorMusicInfo2 = objectRef.element;
                    if (Intrinsics.areEqual(winkEditorMusicInfo2 != null ? winkEditorMusicInfo2.D : null, it.D)) {
                        booleanRef.element = true;
                        objectRef.element = it;
                        this.k4(it);
                        return;
                    }
                    return;
                }
                it.f321259e = false;
            }
        });
        WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) objectRef.element;
        Object obj = null;
        if (winkEditorMusicInfo != null) {
            this.enableMusic = true;
            if (!booleanRef.element) {
                winkEditorMusicInfo.f321259e = true;
                i3 = z3(winkEditorMusicInfo, position);
            } else {
                i3 = position;
            }
            int i16 = i3;
            if (winkEditorMusicInfo.f321262i == 3) {
                this.selectTemplateBGM.postValue(Boolean.TRUE);
                z2();
                S4(winkEditorMusicInfo, "", isAutoMusic);
            } else {
                this.selectTemplateBGM.postValue(bool);
                G4(this, (WinkEditorMusicInfo) objectRef.element, false, isAutoMusic, 2, null);
            }
            if (needScroll) {
                this.musicPos.postValue(Integer.valueOf(i16));
            }
            if (winkEditorMusicInfo.F) {
                str = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_LIBRARY;
            } else if (Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_RECOMMEND_ID")) {
                str = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_RECOMD;
            } else {
                str = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL;
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, str);
            com.tencent.mobileqq.wink.editor.music.vo.a aVar = winkEditorMusicInfo.G;
            if (aVar != null) {
                String xsjQueryText = aVar.getXsjQueryText();
                if (xsjQueryText != null && xsjQueryText.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MUSIC_FROM_SEARCH, 1);
                    WinkDatongCurrentParams.put("xsj_query_text", winkEditorMusicInfo.G.getXsjQueryText());
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SEARCH_QUERY_SOURCE, winkEditorMusicInfo.G.getXsjQuerySource());
                    value = this.curCategoryLiveData.getValue();
                    if (value != null) {
                        obj = value.f320784b;
                    }
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, obj);
                    obj = Unit.INSTANCE;
                }
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MUSIC_FROM_SEARCH, 0);
            WinkDatongCurrentParams.put("xsj_query_text", "");
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SEARCH_QUERY_SOURCE, "");
            value = this.curCategoryLiveData.getValue();
            if (value != null) {
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, obj);
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            x2();
        }
        this.currentMusicLiveData.setValue(this.currentMusic);
    }

    @Nullable
    /* renamed from: O2, reason: from getter */
    public final WinkEditorMusicInfo getCurrentMusic() {
        return this.currentMusic;
    }

    public final void O4(@NotNull WinkEditorMusicInfo data, @NotNull String localPath, boolean isAutoMusic) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        if (this.editMode == WinkEditorViewModel.EditMode.Image) {
            N4(data);
        } else {
            w2();
            S4(data, localPath, isAutoMusic);
        }
    }

    @NotNull
    public final MutableLiveData<WinkEditorMusicInfo> P2() {
        return this.currentMusicLiveData;
    }

    @NotNull
    public final MutableLiveData<Long> Q2() {
        return this.currentPlayerTimeLiveData;
    }

    public final void Q3(@NotNull Context context, @NotNull Intent intent) {
        String str;
        ax axVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!Intrinsics.areEqual(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT, intent.getAction())) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        VsMusicItemInfo y16 = WinkEditorMusicHelper.y(intent);
        if (y16 != null) {
            if (!Intrinsics.areEqual(QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC, stringExtra) && !Intrinsics.areEqual(QQWinkConstants.JS_PLUGIN_EVENT_CLIP_MUSIC, stringExtra)) {
                if (Intrinsics.areEqual(QQWinkConstants.JS_PLUGIN_EVENT_CACHE_MUSIC, stringExtra)) {
                    V3(this, y16, false, intent, false, 8, null);
                    return;
                }
                if (Intrinsics.areEqual(QQWinkConstants.JS_PLUGIN_EVENT_COLLECT_MUSIC, stringExtra)) {
                    if (y16.f320655i == 0) {
                        H3(y16);
                        return;
                    } else {
                        F3(y16);
                        return;
                    }
                }
                w53.b.c("MusicSourceViewModel", "onReceiveWebBroadcast event:" + stringExtra);
                return;
            }
            WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
            if (winkEditorMusicInfo != null) {
                str = winkEditorMusicInfo.p();
            } else {
                str = null;
            }
            boolean z16 = !Intrinsics.areEqual(str, y16.mSongMid);
            U3(y16, true, intent, z16);
            if (z16 && !cx.INSTANCE.f()) {
                MutableLiveData<ax> mutableLiveData = this.curCategoryLiveData;
                if (this.isFromDailySign) {
                    axVar = ax.f320782i;
                } else {
                    axVar = ax.f320778e;
                }
                mutableLiveData.postValue(axVar);
            }
            SimpleEventBus.getInstance().dispatchEvent(new WinkShowBottomDashBoardEvent());
        }
    }

    @NotNull
    public final List<WinkEditorMusicInfo> R2() {
        return this.musicListData.i();
    }

    public final void R3() {
        B2("pauseImageBgm", new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$pauseImageBgm$1
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
                MediaPlayer a36;
                MediaPlayer a37;
                a36 = MusicSourceViewModel.this.a3();
                if (a36.isPlaying()) {
                    a37 = MusicSourceViewModel.this.a3();
                    a37.pause();
                }
            }
        });
    }

    public final void S3() {
        this.musicListData.s(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$removeTemplateHolder$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.f321262i == 3);
            }
        });
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        boolean z16 = false;
        if (winkEditorMusicInfo != null && winkEditorMusicInfo.f321262i == 3) {
            z16 = true;
        }
        if (z16) {
            u4(true);
            f4();
        } else {
            L4();
        }
    }

    public final void T3() {
        boolean z16;
        int indexOf;
        this.musicListData.s(new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$removeTemplateHolderAndClearMusic$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.f321262i == 3);
            }
        });
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null && winkEditorMusicInfo.f321262i == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            k4(null);
            this.currentMusicLiveData.setValue(null);
            this.startTimeInMs = null;
            this.endTimeInMs = null;
            this.enableMusic = false;
        }
        WinkEditorMusicInfo winkEditorMusicInfo2 = this.currentMusic;
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends WinkEditorMusicInfo>) ((List<? extends Object>) k3()), this.currentMusic);
        O3(this, winkEditorMusicInfo2, indexOf, false, false, 8, null);
    }

    @Nullable
    /* renamed from: U2, reason: from getter */
    public final DraftMusic getDraftMusic() {
        return this.draftMusic;
    }

    public final void U4() {
        List<ax> listOf;
        if (!this.isFromZShow) {
            return;
        }
        MediatorLiveData<List<ax>> mediatorLiveData = this.categoryList;
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        ax MOOD_CATEGORY_INFO = ax.f320780g;
        Intrinsics.checkNotNullExpressionValue(MOOD_CATEGORY_INFO, "MOOD_CATEGORY_INFO");
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ax[]{COLLECTION_CATEGORY_INFO, MOOD_CATEGORY_INFO, RECOMM_CATEGORY_INFO});
        mediatorLiveData.postValue(listOf);
        ax.f320780g.c();
        ax axVar = ax.f320780g;
        axVar.f320785c = true;
        this.curCategoryLiveData.postValue(axVar);
        e3();
    }

    @NotNull
    /* renamed from: V2, reason: from getter */
    public final WinkEditorViewModel.EditMode getEditMode() {
        return this.editMode;
    }

    @NotNull
    public final MutableLiveData<Integer> W2() {
        return this.errorLiveData;
    }

    public final void W3() {
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null) {
            t4(Integer.valueOf(winkEditorMusicInfo.s()), Integer.valueOf((int) (winkEditorMusicInfo.s() + this.videoDurationMs)));
            I4();
        }
    }

    public final void X3() {
        int s16;
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null) {
            QLog.d("MusicSourceViewModel", 4, "[restoreCurrentBgm] " + winkEditorMusicInfo.p());
            String p16 = winkEditorMusicInfo.p();
            Intrinsics.checkNotNullExpressionValue(p16, "it.songMid");
            Integer m3 = m3(p16);
            if (m3 != null) {
                s16 = m3.intValue();
            } else {
                s16 = winkEditorMusicInfo.s();
            }
            int i3 = s16;
            t4(Integer.valueOf(i3), Integer.valueOf(((int) this.videoDurationMs) + i3));
            c4();
            MutableLiveData<MusicInfoWrapper> mutableLiveData = this._bgmSourceLiveData;
            String o16 = WinkEditorMusicHelper.o(winkEditorMusicInfo);
            Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(it)");
            mutableLiveData.postValue(new MusicInfoWrapper(winkEditorMusicInfo, o16, i3, (int) this.videoDurationMs, false, 16, null));
        }
    }

    /* renamed from: Y2, reason: from getter */
    public final boolean getGetCategoryMusicListFail() {
        return this.getCategoryMusicListFail;
    }

    public final void Y3() {
        B2("resumeImageBgm", new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$resumeImageBgm$1
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
                MediaPlayer a36;
                MediaPlayer a37;
                a36 = MusicSourceViewModel.this.a3();
                if (a36.isPlaying()) {
                    return;
                }
                a37 = MusicSourceViewModel.this.a3();
                a37.start();
            }
        });
    }

    public final void Z3() {
        Integer num;
        WinkEditorMusicInfo winkEditorMusicInfo = this.currentMusic;
        if (winkEditorMusicInfo != null && (num = this.startTimeInMs) != null) {
            int intValue = num.intValue();
            String p16 = winkEditorMusicInfo.p();
            Intrinsics.checkNotNullExpressionValue(p16, "music.songMid");
            a4(p16, intValue, true);
        }
    }

    public final void a4(@NotNull String musicMid, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(musicMid, "musicMid");
        if (z16) {
            this.musicStartTimeMap.put(musicMid, Integer.valueOf(i3));
        } else if (!this.musicStartTimeMap.containsKey(musicMid)) {
            this.musicStartTimeMap.put(musicMid, Integer.valueOf(i3));
        }
    }

    @NotNull
    public final LiveData<Boolean> b3() {
        return this.loadingMusicLiveData;
    }

    public final void d4() {
        O3(this, WinkEditorMusicInfo.J, 0, false, false, 8, null);
        this.curCategoryLiveData.postValue(ax.f320778e);
    }

    public final void e4(@NotNull WinkEditorMusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        c cVar = this.webCallback;
        if (cVar != null) {
            cVar.a(musicInfo);
        }
    }

    public final void f4() {
        Object orNull;
        Object orNull2;
        Object orNull3;
        if (this.editMode == WinkEditorViewModel.EditMode.Image && this.isVideoClearMusic) {
            u4(true);
        }
        w53.b.f("MusicSourceViewModel", "[setAutoMusic] needAutoMusic=" + this.needAutoMusic);
        if (this.needAutoMusic) {
            boolean f16 = cx.INSTANCE.f();
            if (this.isFromZShow && !f16) {
                orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.k(), 0);
                WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull3;
                if (winkEditorMusicInfo != null) {
                    u4(false);
                    N3(winkEditorMusicInfo, 0, false, true);
                    return;
                }
                return;
            }
            if (!this.isFromMagicStudio || f16) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.p(), 0);
                WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) orNull;
                if (winkEditorMusicInfo2 != null) {
                    u4(false);
                    if (!this.oriHasBgm) {
                        N3(winkEditorMusicInfo2, 0, false, true);
                        P3();
                        return;
                    } else {
                        this.selectTemplateBGM.postValue(Boolean.FALSE);
                        return;
                    }
                }
                return;
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.j(), 0);
            WinkEditorMusicInfo winkEditorMusicInfo3 = (WinkEditorMusicInfo) orNull2;
            if (winkEditorMusicInfo3 != null) {
                u4(false);
                N3(winkEditorMusicInfo3, 0, false, true);
            }
        }
    }

    @NotNull
    public final MutableLiveData<WinkEditorMusicInfo> g3() {
        return this.musicButtonExposeLiveData;
    }

    public final void g4(@Nullable String tabName, @Nullable String musicMid) {
        boolean areEqual;
        Object orNull;
        if (!this.needAutoMusic) {
            return;
        }
        if (Intrinsics.areEqual(tabName, "\u968f\u8bb0")) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.i(), 0);
            WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull;
            if (winkEditorMusicInfo != null) {
                u4(false);
                O3(this, winkEditorMusicInfo, 0, false, false, 8, null);
                return;
            }
            return;
        }
        if (musicMid == null) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(musicMid, "");
        }
        if (areEqual) {
            y2();
            u4(false);
            return;
        }
        if (Intrinsics.areEqual(musicMid, "fakeMid_template_bgm")) {
            N3(WinkEditorMusicInfo.J, 0, false, true);
            u4(false);
            return;
        }
        int i3 = 0;
        for (Object obj : this.musicListData.p()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) obj;
            if (Intrinsics.areEqual(winkEditorMusicInfo2.p(), musicMid)) {
                N3(winkEditorMusicInfo2, i3, false, true);
                u4(false);
            }
            i3 = i16;
        }
    }

    public final void i4() {
        Object orNull;
        Object orNull2;
        Object orNull3;
        w53.b.a("MusicSourceViewModel", "setAutoMusicCurrentTab... curCategory:" + this.curCategoryLiveData.getValue());
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320778e)) {
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.p(), 0);
            WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull3;
            if (winkEditorMusicInfo != null) {
                O3(this, winkEditorMusicInfo, 0, true, false, 8, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320779f)) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.h(), 0);
            WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) orNull2;
            if (winkEditorMusicInfo2 != null) {
                O3(this, winkEditorMusicInfo2, 0, true, false, 8, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320782i)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.i(), 0);
            WinkEditorMusicInfo winkEditorMusicInfo3 = (WinkEditorMusicInfo) orNull;
            if (winkEditorMusicInfo3 != null) {
                O3(this, winkEditorMusicInfo3, 0, true, false, 8, null);
            }
        }
    }

    @NotNull
    public final MutableLiveData<List<WinkEditorMusicInfo>> j3() {
        return this.musicList;
    }

    public final void j4(@Nullable Float it) {
        this.bgmVolume = it;
    }

    @NotNull
    public final List<WinkEditorMusicInfo> k3() {
        return this.musicListData.l();
    }

    public final void k4(@Nullable WinkEditorMusicInfo winkEditorMusicInfo) {
        this.draftMusic = null;
        this.currentMusic = winkEditorMusicInfo;
    }

    @NotNull
    public final MutableLiveData<Integer> l3() {
        return this.musicPos;
    }

    public final void l4(int position) {
        Object orNull;
        Object orNull2;
        Object orNull3;
        w53.b.a("MusicSourceViewModel", "setCurrentTabFirstVisibleMusic... position:" + position);
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320778e)) {
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.p(), position);
            WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull3;
            if (winkEditorMusicInfo != null) {
                O3(this, winkEditorMusicInfo, position, true, false, 8, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320779f)) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.h(), position);
            WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) orNull2;
            if (winkEditorMusicInfo2 != null) {
                O3(this, winkEditorMusicInfo2, position, true, false, 8, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(this.curCategoryLiveData.getValue(), ax.f320782i)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.musicListData.i(), position);
            WinkEditorMusicInfo winkEditorMusicInfo3 = (WinkEditorMusicInfo) orNull;
            if (winkEditorMusicInfo3 != null) {
                O3(this, winkEditorMusicInfo3, position, true, false, 8, null);
            }
        }
    }

    @Nullable
    public final Integer m3(@NotNull String musicMid) {
        Intrinsics.checkNotNullParameter(musicMid, "musicMid");
        return this.musicStartTimeMap.get(musicMid);
    }

    public final void m4(@NotNull List<? extends WinkEditorMusicInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.musicListData.u(list);
    }

    /* renamed from: n3, reason: from getter */
    public final boolean getNeedAutoMusic() {
        return this.needAutoMusic;
    }

    public final void n4(@Nullable DraftMusic draftMusic) {
        this.draftMusic = draftMusic;
    }

    @NotNull
    public final LiveData<Long> o3() {
        return this.playerSeek;
    }

    public final void o4(@NotNull WinkEditorViewModel.EditMode newEditMode) {
        Intrinsics.checkNotNullParameter(newEditMode, "newEditMode");
        WinkEditorViewModel.EditMode editMode = this.editMode;
        if (newEditMode == editMode) {
            return;
        }
        boolean z16 = false;
        if (newEditMode == WinkEditorViewModel.EditMode.Image && editMode == WinkEditorViewModel.EditMode.Video) {
            this.editMode = newEditMode;
            Boolean value = this.selectTemplateBGM.getValue();
            if (value != null) {
                z16 = value.booleanValue();
            }
            this.hasTemplateInVideoMode = z16;
            S3();
            f4();
            return;
        }
        this.editMode = newEditMode;
        if (this.hasTemplateInVideoMode && !this.isFromZShow) {
            v2(this, false, 1, null);
        } else {
            L4();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        B2("onCleared", new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$onCleared$1
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
                MediaPlayer a36;
                a36 = MusicSourceViewModel.this.a3();
                a36.release();
            }
        });
    }

    public final void p3(@NotNull final List<byte[]> bitmaps, @Nullable final List<? extends WinkEditorMusicInfo> tongKuanMusic, final boolean needLyrics) {
        Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        w53.b.a("MusicSourceViewModel", "getRecommendMusicList...");
        final long currentTimeMillis = System.currentTimeMillis();
        h3();
        WinkEditorMusicHelper.H(bitmaps, null, 1, null, 0, "", 4, needLyrics, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                MusicSourceViewModel.r3(tongKuanMusic, this, needLyrics, currentTimeMillis, bitmaps, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$SmartMatchMusicRsp) obj);
            }
        });
    }

    public final void p4(boolean z16) {
        this.isFromDailySign = z16;
    }

    public final void q4(boolean z16) {
        this.isFromZShow = z16;
    }

    public final void r4(@NotNull WinkMusicListFragment.MusicRequestType type) {
        Unit unit;
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap<WinkMusicListFragment.MusicRequestType, MusicRspResult> value = this._rspResultLiveData.getValue();
        if (value == null) {
            value = new HashMap<>();
        }
        w53.b.a("MusicSourceViewModel", "setLoading... rsp:" + value.get(type));
        MusicRspResult musicRspResult = value.get(type);
        if (musicRspResult != null) {
            if (musicRspResult.getResult() != MusicRspResult.Result.SUCCESS) {
                R4(type, new MusicRspResult(type, MusicRspResult.Result.LOADING));
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            R4(type, new MusicRspResult(type, MusicRspResult.Result.LOADING));
        }
    }

    @NotNull
    public final LiveData<HashMap<WinkMusicListFragment.MusicRequestType, MusicRspResult>> s3() {
        return this._rspResultLiveData;
    }

    public final void s4(@NotNull List<? extends WinkEditorMusicInfo> materialMusicList) {
        Intrinsics.checkNotNullParameter(materialMusicList, "materialMusicList");
        List<WinkEditorMusicInfo> p16 = this.musicListData.p();
        if (p16.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        for (WinkEditorMusicInfo winkEditorMusicInfo : materialMusicList) {
            if (!winkEditorMusicInfo.y() && hashMap.get(winkEditorMusicInfo.p()) == null) {
                linkedList.add(winkEditorMusicInfo);
                String p17 = winkEditorMusicInfo.p();
                Intrinsics.checkNotNullExpressionValue(p17, "it.songMid");
                hashMap.put(p17, winkEditorMusicInfo);
            }
        }
        for (WinkEditorMusicInfo winkEditorMusicInfo2 : p16) {
            if (!winkEditorMusicInfo2.y() && winkEditorMusicInfo2.f321262i != 0 && hashMap.get(winkEditorMusicInfo2.p()) == null) {
                linkedList.add(winkEditorMusicInfo2);
                String p18 = winkEditorMusicInfo2.p();
                Intrinsics.checkNotNullExpressionValue(p18, "it.songMid");
                hashMap.put(p18, winkEditorMusicInfo2);
            }
        }
        u4(true);
        this.musicListData.y(linkedList);
    }

    @NotNull
    public final MutableLiveData<WinkEditorMusicInfo> t3() {
        return this.selectImageBGM;
    }

    public final void t4(@Nullable Integer startTimeInMs, @Nullable Integer endTimeInMs) {
        this.startTimeInMs = startTimeInMs;
        this.endTimeInMs = endTimeInMs;
    }

    public final void u2(boolean selectMusic) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.musicListData.p().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((WinkEditorMusicInfo) obj).f321262i == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((WinkEditorMusicInfo) obj) == null) {
            MusicListData musicListData = this.musicListData;
            WinkEditorMusicInfo TEMPLATE_BGM_HOLDER = WinkEditorMusicInfo.J;
            Intrinsics.checkNotNullExpressionValue(TEMPLATE_BGM_HOLDER, "TEMPLATE_BGM_HOLDER");
            musicListData.c(TEMPLATE_BGM_HOLDER, 0);
            Unit unit = Unit.INSTANCE;
        }
        if (selectMusic) {
            M3(WinkEditorMusicInfo.J, 0);
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> u3() {
        return this.selectTemplateBGM;
    }

    public final void u4(boolean z16) {
        if (AppSetting.isPublicVersion()) {
            w53.b.f("MusicSourceViewModel", "setNeedAutoMusic=" + z16);
        } else {
            w53.b.f("MusicSourceViewModel", "setNeedAutoMusic=" + z16 + ", \n" + com.tencent.mobileqq.wink.editor.util.d.f322631a.a());
        }
        this.needAutoMusic = z16;
    }

    @NotNull
    public final LiveData<Boolean> v3() {
        return this.showLyricMenuDialogLiveData;
    }

    public final void v4() {
        this.isNeedWaitMusicJudge = true;
    }

    public final void w2() {
        B2("clearImageBgmData", new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$clearImageBgmData$1
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
                MediaPlayer a36;
                MediaPlayer a37;
                a36 = MusicSourceViewModel.this.a3();
                a36.stop();
                a37 = MusicSourceViewModel.this.a3();
                a37.reset();
            }
        });
        this.selectImageBGM.postValue(null);
    }

    @Nullable
    /* renamed from: w3, reason: from getter */
    public final Integer getStartTimeInMs() {
        return this.startTimeInMs;
    }

    public final void w4(boolean hasBgm) {
        w53.b.f("MusicSourceViewModel", "musicLatch hasOriBgm " + hasBgm);
        this.oriHasBgm = hasBgm;
        this.musicLatch.countDown();
    }

    @NotNull
    public final MutableLiveData<Boolean> x3() {
        return this.videoClearMusicLiveData;
    }

    public final void x4(@NotNull List<QQCircleSmartMatchMusic$MusicInfo> musicListInfo, @Nullable List<? extends WinkEditorMusicInfo> tongKuanMusic) {
        Integer num;
        Intrinsics.checkNotNullParameter(musicListInfo, "musicListInfo");
        int size = musicListInfo.size();
        if (tongKuanMusic != null) {
            num = Integer.valueOf(tongKuanMusic.size());
        } else {
            num = null;
        }
        w53.b.f("MusicSourceViewModel", "[setRecommendMusicList] musicListInfo.size=" + size + ", tongKuanMusic=" + num);
        h3();
        J2();
        if (this.isFromZShow) {
            e3();
        }
        List<WinkEditorMusicInfo> finalMusicList = WinkEditorMusicHelper.x(WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(musicListInfo), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350"), tongKuanMusic);
        List<WinkEditorMusicInfo> p16 = this.musicListData.p();
        if (p16.isEmpty()) {
            p16 = WinkEditorMusicInfo.a("FAKE_CATEGORY_RECOMMEND_ID");
            Intrinsics.checkNotNullExpressionValue(p16, "assembleDefaultList(Wink\u2026KE_CATEGORY_RECOMMEND_ID)");
        }
        Intrinsics.checkNotNullExpressionValue(finalMusicList, "finalMusicList");
        this.musicListData.y(D3(finalMusicList, p16));
    }

    public final void y2() {
        this.videoClearMusicLiveData.postValue(Boolean.TRUE);
        this.isVideoClearMusic = true;
        if (this.currentMusic != null) {
            k4(null);
            this.currentMusicLiveData.setValue(null);
            this.startTimeInMs = null;
            this.endTimeInMs = null;
            this.enableMusic = false;
            MusicListData.f(this.musicListData, null, new Function1<WinkEditorMusicInfo, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$clearMusic$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkEditorMusicInfo winkEditorMusicInfo) {
                    invoke2(winkEditorMusicInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.f321259e = false;
                }
            }, 1, null);
            x2();
        }
        this.selectTemplateBGM.postValue(Boolean.FALSE);
        w53.b.f("MusicSourceViewModel", "clearMusic");
    }

    /* renamed from: y3, reason: from getter */
    public final long getVideoDurationMs() {
        return this.videoDurationMs;
    }

    public final void y4(@Nullable Integer num) {
        this.startTimeInMs = num;
    }

    public final void z2() {
        if (this.currentMusic != null) {
            this.startTimeInMs = null;
            this.endTimeInMs = null;
            x2();
        }
    }

    public final void z4(long j3) {
        this.videoDurationMs = j3;
    }
}
