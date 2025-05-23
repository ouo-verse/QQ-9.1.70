package com.tencent.mobileqq.aio.msglist;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.g;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgViewRect;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgListMviIntent;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB$onAIODispatchDrawListener$2;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB$onTracerDispatchDrawListener$2;
import com.tencent.mobileqq.aio.msglist.helper.d;
import com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVB;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.anisticker.AIOAniStickerContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOOnlineFileContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.CommonGrayTipsComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.RevokeGrayTipsComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.video.VideoViewModel;
import com.tencent.mobileqq.aio.msglist.preLoad.AIOPatchingPreLoadStrategy;
import com.tencent.mobileqq.aio.msglist.preLoad.viewholder.ViewHolderAsyncCreator;
import com.tencent.mobileqq.aio.msglist.scrollers.b;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.aio.widget.AIOMsgAvatarAreaGroup;
import com.tencent.mobileqq.aio.widget.AIOMsgListGroup;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import com.tencent.qqnt.aio.utils.AIOOptConfigKt;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u001a\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\t*\u0006\u00d5\u0001\u00ef\u0001\u0088\u0002\b\u0016\u0018\u0000 \u008e\u00022\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u008f\u0002B\t\u00a2\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00060\u0005H\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,H\u0017J\u001a\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0/0\u0005H\u0016J\u001a\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0/0\u0005H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u0014H\u0002J%\u0010<\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u000f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120:H\u0002\u00a2\u0006\u0004\b<\u0010=J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020\u0014H\u0002J\b\u0010A\u001a\u00020\u0014H\u0002J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020\u0014H\u0002J\u0010\u0010G\u001a\u00020\u00142\u0006\u0010F\u001a\u00020EH\u0002J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020EH\u0002J*\u0010O\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010T\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`S2\u0006\u0010P\u001a\u00020\u000fH\u0002J\u0018\u0010W\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020U2\u0006\u0010V\u001a\u00020\fH\u0002J\u0012\u0010Y\u001a\u00020E2\b\u0010X\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010Z\u001a\u00020E2\b\u0010X\u001a\u0004\u0018\u00010!H\u0002J \u0010]\u001a\u00020\u000f2\u0006\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u0002042\u0006\u0010\u001d\u001a\u00020UH\u0002J\u0018\u0010_\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020^2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010a\u001a\u00020\u00142\u0006\u0010`\u001a\u00020EH\u0002J\b\u0010b\u001a\u00020\u000fH\u0002J\u000e\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u0005H\u0002J\u000e\u0010e\u001a\b\u0012\u0004\u0012\u00020c0\u0005H\u0002J\u0016\u0010g\u001a\u00020\u00142\f\u0010f\u001a\b\u0012\u0004\u0012\u00020c0\u0005H\u0002J\b\u0010h\u001a\u00020\u0014H\u0002J\b\u0010i\u001a\u00020\u0014H\u0002J\u0018\u0010k\u001a\u00020E2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0002J \u0010l\u001a\u00020E2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0002J\u0016\u0010n\u001a\u00020\u00142\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0002J\u0010\u0010o\u001a\u00020\u00142\u0006\u0010j\u001a\u00020\u000fH\u0002J\"\u0010s\u001a\u00020\u00142\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0002\u0010r\u001a\u0004\u0018\u00010qH\u0002J\b\u0010t\u001a\u00020\u0014H\u0002J\u0010\u0010w\u001a\u00020v2\u0006\u0010u\u001a\u00020\nH\u0002J\u0010\u0010y\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u000fH\u0002J\b\u0010z\u001a\u00020\u000fH\u0002J\u0010\u0010|\u001a\u00020\u00142\u0006\u0010{\u001a\u00020\u000fH\u0002J\u0018\u0010\u007f\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020EH\u0002J\u001b\u0010\u0082\u0001\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020E2\u0007\u0010\u0081\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u00142\u0007\u0010\u001d\u001a\u00030\u0083\u0001H\u0002J\u001b\u0010\u0085\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0/0\u0005H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0014H\u0002J\r\u0010\u0087\u0001\u001a\u00020\u0014*\u00020\fH\u0002J\u0011\u0010\u0088\u0001\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020UH\u0002J\t\u0010\u0089\u0001\u001a\u00020EH\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0014H\u0002R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0096\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u0019\u0010\u0098\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u0019\u0010\u009b\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009a\u0001R\u0019\u0010\u00a0\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u009f\u0001R*\u0010\u00aa\u0001\u001a\u00030\u00a3\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001\"\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001a\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001a\u0010\u00b4\u0001\u001a\u00030\u00b2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u00b3\u0001R\u001a\u0010\u00b8\u0001\u001a\u00030\u00b5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001c\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R*\u0010\u00c1\u0001\u001a\u00020\f2\u0007\u0010\u00bd\u0001\u001a\u00020\f8\u0004@BX\u0084.\u00a2\u0006\u0010\n\u0006\b\u00be\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R \u0010\u00c6\u0001\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00c3\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R \u0010\u00c9\u0001\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00c3\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00c5\u0001R\u001c\u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00ca\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001R\u001b\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u0019\u0010\u00d2\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u0093\u0001R\u0019\u0010\u00d4\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u0093\u0001R!\u0010\u00d9\u0001\u001a\u00030\u00d5\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d6\u0001\u0010\u00c3\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u0019\u0010\u00db\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u0093\u0001R\u001c\u0010\u00de\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001R\u0019\u0010\u00e0\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u0093\u0001R\u0019\u0010\u00e2\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u0093\u0001R\u0019\u0010\u00e4\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u009f\u0001R\u0019\u0010\u00e6\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u009f\u0001R\u0018\u0010\u00e7\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b(\u0010\u0093\u0001R\u0019\u0010\u00e9\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u009f\u0001R\u0019\u0010\u00eb\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ea\u0001\u0010\u0093\u0001R\u0019\u0010\u00ed\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ec\u0001\u0010\u009f\u0001R\u0018\u0010\u00ee\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u0093\u0001R!\u0010\u00f3\u0001\u001a\u00030\u00ef\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f0\u0001\u0010\u00c3\u0001\u001a\u0006\b\u00f1\u0001\u0010\u00f2\u0001R)\u0010\u00fa\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f4\u0001\u0010\u00f5\u0001\u001a\u0006\b\u00f6\u0001\u0010\u00f7\u0001\"\u0006\b\u00f8\u0001\u0010\u00f9\u0001R(\u0010\u00fd\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b&\u0010\u00f5\u0001\u001a\u0006\b\u00fb\u0001\u0010\u00f7\u0001\"\u0006\b\u00fc\u0001\u0010\u00f9\u0001R!\u0010\u0082\u0002\u001a\u00030\u00fe\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ff\u0001\u0010\u00c3\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0019\u0010\u0084\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0002\u0010\u009f\u0001R\u001f\u0010\u0087\u0002\u001a\u00020\u000f8\u0016X\u0096D\u00a2\u0006\u0010\n\u0006\b\u0085\u0002\u0010\u009f\u0001\u001a\u0006\b\u0086\u0002\u0010\u00c5\u0001R\u0018\u0010\u008b\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002\u00a8\u0006\u0090\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/mobileqq/aio/msglist/w;", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "", "moveType", "moveDistance", "", "totalDistance", "", "v3", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", NowProxyConstants.AccountInfoKey.A2, "S0", "p", "state", "u0", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "specificHeight", "x0", "componentKey", "q0", "Landroidx/recyclerview/widget/RecyclerView;", "K0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "context", "Q2", "Lkotlin/Pair;", tl.h.F, "e", "Lcom/tencent/aio/api/refreshLoad/a;", "B2", "", "getCurrentFocus", "Landroid/view/View$AccessibilityDelegate;", "U0", "r3", "position", "", "drawSize", "K3", "(I[Ljava/lang/Float;)V", "avatarAreaView", "Z2", "g3", "d3", "Lcom/tencent/mobileqq/aio/msglist/uistate/AIOMsgListViewState$AddStickerBottomFooterView;", ICustomDataEditor.STRING_ARRAY_PARAM_3, "J3", "", "show", "h3", "toSet", FileReaderHelper.OPEN_FILE_FROM_FORCE, "L3", "startPos", "itemCount", "", "payload", "Y2", WadlProxyConsts.FLAGS, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/event/AIOMsgViewRect;", "Lkotlin/collections/ArrayList;", "H2", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "helper", "c3", "bundle", "j3", "i3", "msgSeq", "msgId", "R2", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListDataState;", "f3", "isLongShotMode", "e3", "S2", "Lcom/tencent/aio/data/msglist/a;", "K2", "N2", "list", "x3", "w2", "w3", "index", "I3", "y2", "indexList", ICustomDataEditor.NUMBER_PARAM_3, "k3", "viewList", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/a;", "viewHolder", "l3", "C2", "view", "Landroid/animation/AnimatorSet;", "P2", NodeProps.PADDING_TOP, Constants.BASE_IN_APP_NAME, "V2", "increment", "y3", "top", "withAnim", "E3", "clip", "bottomPadding", "A3", "Lcom/tencent/mobileqq/aio/msglist/uistate/AIOMsgListViewState$InputBarHeightChangeState;", "C3", "F2", "b3", "z2", "v2", "p3", "o3", "M", "Landroid/animation/AnimatorSet;", "highlightAnimator", "Landroid/animation/ValueAnimator;", "N", "Landroid/animation/ValueAnimator;", "transparentAnimator", "P", "Z", "couldTriggerDismissPanel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "couldTriggerShowKeyboard", BdhLogUtil.LogTag.Tag_Req, "mFirstDraw", ExifInterface.LATITUDE_SOUTH, "J", "mLockTime", "T", "mUnlockTime", "U", "I", "mBounceState", "V", "mScrollState", "Landroidx/recyclerview/widget/AIORecycleView;", "W", "Landroidx/recyclerview/widget/AIORecycleView;", "M2", "()Landroidx/recyclerview/widget/AIORecycleView;", "B3", "(Landroidx/recyclerview/widget/AIORecycleView;)V", "mRecyclerView", "X", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "mUiHelper", "Lcom/tencent/mobileqq/aio/msglist/helper/d;", "Y", "Lcom/tencent/mobileqq/aio/msglist/helper/d;", "msgListLockLayoutHelper", "Lcom/tencent/aio/api/list/n;", "Lcom/tencent/aio/api/list/n;", "screenShot", "Lcom/tencent/mobileqq/aio/msglist/scrollers/a;", "a0", "Lcom/tencent/mobileqq/aio/msglist/scrollers/a;", "focusBottomHandler", "Lcom/tencent/mobileqq/aio/widget/AIOMsgAvatarAreaGroup;", "b0", "Lcom/tencent/mobileqq/aio/widget/AIOMsgAvatarAreaGroup;", "aioMsgAvatarAreaGroup", "<set-?>", "c0", "I2", "()Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "d0", "Lkotlin/Lazy;", "J2", "()I", "longShotMaskColor", "e0", "L2", "longShotRangeColor", "Landroid/view/ViewGroup;", "f0", "Landroid/view/ViewGroup;", "footerLayout", "g0", "Landroid/view/View;", "footerView", "h0", "aioCompleteEnter", "i0", "setMsgListRenderEffect", "com/tencent/mobileqq/aio/msglist/AIOMsgListVB$onAIODispatchDrawListener$2$a", "j0", "T2", "()Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB$onAIODispatchDrawListener$2$a;", "onAIODispatchDrawListener", "k0", "mIsAddAvatarView", "l0", "Lcom/tencent/mobileqq/aio/msglist/uistate/AIOMsgListViewState$InputBarHeightChangeState;", "mLastInputChangeState", "m0", "showFlingOverScrollLoading", "n0", "mSetBottomStart", "o0", "extendBottomPadding", "p0", "normalRecyclerViewPadding", "stopPaddingAnim", "r0", "originalRecyclerViewPaddingBottom", "s0", "isIncrementState", "t0", "bottomPaddingIncrement", "isApiScroll", "com/tencent/mobileqq/aio/msglist/AIOMsgListVB$onTracerDispatchDrawListener$2$a", "v0", "U2", "()Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB$onTracerDispatchDrawListener$2$a;", "onTracerDispatchDrawListener", "w0", UserInfo.SEX_FEMALE, "W2", "()F", Constants.EMULATOR_INFO, "(F)V", "touchDownX", "X2", "H3", "touchDownY", "Lcom/tencent/mobileqq/aio/widget/AIOMsgListGroup;", "y0", Constants.MMCCID, "()Lcom/tencent/mobileqq/aio/widget/AIOMsgListGroup;", TtmlNode.TAG_LAYOUT, "z0", "titleBottomLocation", "A0", Constants.BASE_IN_PLUGIN_VERSION, "arrangeMode", "com/tencent/mobileqq/aio/msglist/AIOMsgListVB$g", "B0", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB$g;", "msgListLockLayoutHelperListener", "<init>", "()V", "C0", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOMsgListVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> implements w {
    static IPatchRedirector $redirector_;

    /* renamed from: C0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A0, reason: from kotlin metadata */
    private final int arrangeMode;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private final g msgListLockLayoutHelperListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet highlightAnimator;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator transparentAnimator;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean couldTriggerDismissPanel;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean couldTriggerShowKeyboard;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean mFirstDraw;

    /* renamed from: S, reason: from kotlin metadata */
    private long mLockTime;

    /* renamed from: T, reason: from kotlin metadata */
    private long mUnlockTime;

    /* renamed from: U, reason: from kotlin metadata */
    private int mBounceState;

    /* renamed from: V, reason: from kotlin metadata */
    private int mScrollState;

    /* renamed from: W, reason: from kotlin metadata */
    protected AIORecycleView mRecyclerView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private IListUIOperationApi mUiHelper;

    /* renamed from: Y, reason: from kotlin metadata */
    private com.tencent.mobileqq.aio.msglist.helper.d msgListLockLayoutHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    private com.tencent.aio.api.list.n screenShot;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.msglist.scrollers.a focusBottomHandler;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgAvatarAreaGroup aioMsgAvatarAreaGroup;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longShotMaskColor;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longShotRangeColor;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup footerLayout;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View footerView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean aioCompleteEnter;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean setMsgListRenderEffect;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy onAIODispatchDrawListener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAddAvatarView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgListViewState.InputBarHeightChangeState mLastInputChangeState;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean showFlingOverScrollLoading;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean mSetBottomStart;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private int extendBottomPadding;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private int normalRecyclerViewPadding;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean stopPaddingAnim;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private int originalRecyclerViewPaddingBottom;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean isIncrementState;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int bottomPaddingIncrement;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private boolean isApiScroll;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy onTracerDispatchDrawListener;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private float touchDownX;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private float touchDownY;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy layout;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private int titleBottomLocation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB$a;", "", "", "FOOTER_SHOW_DURATION", "I", "PRE_LOAD_NUM", "", "REFRESH_LOADING_TIMEOUT", "J", "SHOW_KEYBOARD_DISTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements AbsMsgListVB.b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$b$a", "Lkotlin/Function0;", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes11.dex */
        public static final class a implements Function0<Unit> {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AIOMsgListVB f190397d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MsgListState f190398e;

            a(AIOMsgListVB aIOMsgListVB, MsgListState msgListState) {
                this.f190397d = aIOMsgListVB;
                this.f190398e = msgListState;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgListVB, (Object) msgListState);
                }
            }

            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    aa.d(this.f190397d, this.f190398e.getExtra(), "AIOMsgListVB");
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$b$b", "Lxs/a$b;", "Landroid/view/View;", "targetView", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$b$b, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C7293b implements a.b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AIOMsgListVB f190399a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AIORecycleView f190400b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f190401c;

            C7293b(AIOMsgListVB aIOMsgListVB, AIORecycleView aIORecycleView, Ref.IntRef intRef) {
                this.f190399a = aIOMsgListVB;
                this.f190400b = aIORecycleView;
                this.f190401c = intRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, aIOMsgListVB, aIORecycleView, intRef);
                }
            }

            @Override // xs.a.b
            public void b(@Nullable View targetView) {
                ArrayList arrayListOf;
                com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetView);
                    return;
                }
                if (targetView != null) {
                    AIOMsgListVB aIOMsgListVB = this.f190399a;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(targetView);
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f190400b.findViewHolderForAdapterPosition(this.f190401c.element);
                    if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                        aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
                    } else {
                        aVar = null;
                    }
                    aIOMsgListVB.l3(arrayListOf, aVar);
                    return;
                }
                QLog.i("AIOMsgListVB", 1, "[createFocus]: scrollComplete targetView is null");
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
        public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
            long j3;
            long j16;
            long j17;
            AIORecycleView aIORecycleView;
            long j18;
            int i3;
            AIOMsgItem aIOMsgItem;
            boolean z16;
            MsgRecord msgRecord;
            boolean z17;
            boolean z18;
            boolean z19;
            C7293b c7293b;
            boolean z26;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) helper);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(helper, "helper");
            if (AIOMsgListVB.this.j3(state.getExtra())) {
                AIORecycleView i16 = helper.i();
                Bundle extra = state.getExtra();
                if (extra != null) {
                    j3 = extra.getLong("navigate_seq", 0L);
                } else {
                    j3 = 0;
                }
                Bundle extra2 = state.getExtra();
                if (extra2 != null) {
                    j16 = extra2.getLong("navigate_id", 0L);
                } else {
                    j16 = 0;
                }
                Bundle extra3 = state.getExtra();
                if (extra3 != null) {
                    j17 = extra3.getLong("navigate_time", 0L);
                } else {
                    j17 = 0;
                }
                Ref.IntRef intRef = new Ref.IntRef();
                int i17 = -1;
                intRef.element = -1;
                if (j3 > 0) {
                    long j19 = j16;
                    aIORecycleView = i16;
                    j18 = j17;
                    intRef.element = AIOMsgListVB.this.R2(j3, j19, state);
                    j16 = j19;
                } else {
                    aIORecycleView = i16;
                    j18 = j17;
                    if (j16 > 0) {
                        Iterator<com.tencent.aio.data.msglist.a> it = state.iterator();
                        int i18 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().getMsgId() == j16) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                i17 = i18;
                                break;
                            }
                            i18++;
                        }
                        intRef.element = i17;
                    } else if (j18 > 0) {
                        Iterator<com.tencent.aio.data.msglist.a> it5 = state.iterator();
                        int i19 = 0;
                        while (true) {
                            if (it5.hasNext()) {
                                com.tencent.aio.data.msglist.a next = it5.next();
                                if (next instanceof AIOMsgItem) {
                                    aIOMsgItem = (AIOMsgItem) next;
                                } else {
                                    aIOMsgItem = null;
                                }
                                if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null && msgRecord.msgTime == j18) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    i3 = i19;
                                    break;
                                }
                                i19++;
                            } else {
                                i3 = -1;
                                break;
                            }
                        }
                        intRef.element = i3;
                    }
                }
                QLog.i("AIOMsgListVB", 1, "[createFocusIndex]: navigationSeq is " + j3 + ", navigationId is " + j16 + ", navigationTime is " + j18 + " index is " + intRef.element + ", focusIndex is " + state.getFocusIndex());
                if (intRef.element < 0) {
                    return;
                }
                Bundle extra4 = state.getExtra();
                if (extra4 != null) {
                    z18 = extra4.getBoolean(HippyQQPagView.FunctionName.FLUSH, false);
                } else {
                    z18 = false;
                }
                if (j3 > 0) {
                    if (state.get(intRef.element).getMsgSeq() != j3) {
                        QLog.i("AIOMsgListVB", 1, "[createFocusIndex]: not flush navigationSeq is " + j3 + ", find msgItem seq is " + state.get(intRef.element).getMsgSeq());
                        z19 = false;
                    }
                    z19 = z18;
                } else {
                    if (j16 > 0 && state.get(intRef.element).getMsgId() != j16) {
                        QLog.i("AIOMsgListVB", 1, "[createFocusIndex]: not flush navigationId is " + j16 + ", find msgItem id is " + state.get(intRef.element).getMsgId());
                        z19 = false;
                    }
                    z19 = z18;
                }
                if (z19) {
                    c7293b = new C7293b(AIOMsgListVB.this, aIORecycleView, intRef);
                } else {
                    c7293b = null;
                }
                Bundle extra5 = state.getExtra();
                if (extra5 != null) {
                    z26 = extra5.getBoolean("navigate_order_down", false);
                } else {
                    z26 = false;
                }
                if (!z26) {
                    int S2 = AIOMsgListVB.this.S2();
                    a aVar = new a(AIOMsgListVB.this, state);
                    AIOMsgListVB aIOMsgListVB = AIOMsgListVB.this;
                    AIORecycleView M2 = aIOMsgListVB.M2();
                    com.tencent.aio.data.msglist.a aVar2 = state.get(intRef.element);
                    Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                    if (!aa.a(aIOMsgListVB, M2, (AIOMsgItem) aVar2, AIOMsgListVB.this.titleBottomLocation + S2, aVar)) {
                        QLog.i("AIOMsgListVB", 1, "[createFocusIndex]: item is not in currentScreen index:" + intRef.element + " height:" + S2);
                        a.C11562a.b(helper, intRef.element, false, S2, c7293b, 2, null);
                        return;
                    }
                    QLog.i("AIOMsgListVB", 1, "[createFocusIndex]: item is in currentScreen");
                    if (z19) {
                        AIOMsgListVB.this.k3(intRef.element);
                        return;
                    }
                    return;
                }
                helper.p(intRef.element, true, c7293b);
                return;
            }
            if (AIOMsgListVB.this.i3(state.getExtra())) {
                AIOMsgListVB.this.c3(state, helper);
                AIOMsgListVB.this.y3(0);
            }
            AIOMsgListVB.this.v2(state);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f190402d;

        public c(View view) {
            this.f190402d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f190402d.setTag(R.id.siv, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$d", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "dx", "calculateTimeForScrolling", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends LinearSmoothScroller {
        static IPatchRedirector $redirector_;

        d(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, dx5)).intValue();
            }
            return super.calculateTimeForScrolling(dx5) * 3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$e", "Lcom/tencent/mobileqq/aio/msglist/scrollers/b;", "", "onScrollStart", "Landroid/view/View;", "targetView", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e implements com.tencent.mobileqq.aio.msglist.scrollers.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // xs.a.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                b.a.a(this);
            }
        }

        @Override // xs.a.b
        public void b(@Nullable View targetView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AIOMsgListVB.this.mSetBottomStart = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) targetView);
            }
        }

        @Override // xs.a.c
        public void onScrollStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOMsgListVB.this.mSetBottomStart = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$f", "Lxs/a$b;", "Landroid/view/View;", "targetView", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f190405a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOMsgListVB f190406b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AIORecycleView f190407c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f190408d;

        f(boolean z16, AIOMsgListVB aIOMsgListVB, AIORecycleView aIORecycleView, int i3) {
            this.f190405a = z16;
            this.f190406b = aIOMsgListVB;
            this.f190407c = aIORecycleView;
            this.f190408d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), aIOMsgListVB, aIORecycleView, Integer.valueOf(i3));
            }
        }

        @Override // xs.a.b
        public void b(@Nullable View targetView) {
            ArrayList arrayListOf;
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetView);
                return;
            }
            if (this.f190405a && targetView != null) {
                AIOMsgListVB aIOMsgListVB = this.f190406b;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(targetView);
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f190407c.findViewHolderForAdapterPosition(this.f190408d);
                if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                    aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
                } else {
                    aVar = null;
                }
                aIOMsgListVB.l3(arrayListOf, aVar);
            }
            this.f190406b.mSetBottomStart = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$g", "Lcom/tencent/mobileqq/aio/msglist/helper/d$b;", "", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class g implements d.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.helper.d.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AIOMsgListVB.this.mLockTime = System.currentTimeMillis();
            com.tencent.qqnt.trace.a.f362326a.d("lock " + AIOMsgListVB.this.mLockTime);
            AIOMsgListVB.this.sendIntent(AIOMsgListMviIntent.o.f190366d);
        }

        @Override // com.tencent.mobileqq.aio.msglist.helper.d.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AIOMsgListVB.this.sendIntent(AIOMsgListMviIntent.p.f190367d);
            AIOMsgListVB.this.mUnlockTime = System.currentTimeMillis();
            com.tencent.qqnt.trace.a.f362326a.d("unlock " + AIOMsgListVB.this.mUnlockTime);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$h", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class h implements c.b {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i("AIOMsgListVB", 1, "onCreateView, onRefresh");
                AIOMsgListVB.this.sendIntent(new a.c("AIOMsgListVB"));
            }
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("AIOMsgListVB", 1, "onCreateView, onLoadMore");
                AIOMsgListVB.this.sendIntent(new a.C0640a("AIOMsgListVB"));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$i", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class i extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            AIOMsgListVB.this.couldTriggerDismissPanel = true;
            AIOMsgListVB.this.couldTriggerShowKeyboard = true;
            AIOMsgListVB aIOMsgListVB = AIOMsgListVB.this;
            aIOMsgListVB.sendIntent(new AIOMsgListMviIntent.m(newState, aIOMsgListVB.isApiScroll));
            AIOMsgListVB.this.mScrollState = newState;
            if (newState == 1) {
                AIOMsgListVB.this.isApiScroll = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            AIOMsgListVB.this.sendIntent(new AIOMsgListMviIntent.n(dx5, dy5));
            if (recyclerView.getScrollState() == 1 && AIOMsgListVB.this.couldTriggerDismissPanel) {
                AIOMsgListVB.this.couldTriggerDismissPanel = false;
                AIOMsgListVB.this.sendIntent(AIOMsgListMviIntent.a.f190346d);
            }
            AIOMsgListVB aIOMsgListVB = AIOMsgListVB.this;
            aIOMsgListVB.sendIntent(new AIOMsgListMviIntent.l(dx5, dy5, aIOMsgListVB.focusBottomHandler.k()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$j", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class j implements OnAIOTouchListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) event)).booleanValue();
            }
            boolean z18 = true;
            if (event != null && event.getAction() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && AIOMsgListVB.this.mScrollState != 0) {
                AIOMsgListVB.this.G3(0.0f);
                AIOMsgListVB.this.H3(0.0f);
                return false;
            }
            if (event != null && event.getAction() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                AIOMsgListVB.this.G3(event.getX());
                AIOMsgListVB.this.H3(event.getY());
            } else {
                if (event == null || event.getAction() != 1) {
                    z18 = false;
                }
                if (z18 && Math.abs(AIOMsgListVB.this.W2() - event.getX()) < 15.0f && Math.abs(AIOMsgListVB.this.X2() - event.getY()) < 15.0f) {
                    AIOMsgListVB.this.sendIntent(AIOMsgListMviIntent.c.f190348d);
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$k", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class k implements IBounceScrollApi.b {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
            }
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(moveType), Integer.valueOf(moveDistance), Float.valueOf(totalDistance));
                return;
            }
            AIOMsgListVB.this.sendIntent(new AIOMsgListMviIntent.j(moveType, moveDistance, totalDistance));
            if (totalDistance == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (AIOMsgListVB.this.mBounceState == 1) {
                    AIOMsgListVB.this.mBounceState = 0;
                    AIOMsgListVB aIOMsgListVB = AIOMsgListVB.this;
                    aIOMsgListVB.sendIntent(new AIOMsgListMviIntent.d(aIOMsgListVB.mBounceState));
                }
            } else if (AIOMsgListVB.this.mBounceState == 0) {
                AIOMsgListVB.this.mBounceState = 1;
                AIOMsgListVB aIOMsgListVB2 = AIOMsgListVB.this;
                aIOMsgListVB2.sendIntent(new AIOMsgListMviIntent.d(aIOMsgListVB2.mBounceState));
            }
            AIOMsgListVB.this.v3(moveType, moveDistance, totalDistance);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class l<T> implements Comparator {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f190414d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f190415e;

        public l(List list, Ref.BooleanRef booleanRef) {
            this.f190414d = list;
            this.f190415e = booleanRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, (Object) booleanRef);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int i3;
            int i16;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) t16;
            if (this.f190414d.contains(Long.valueOf(aVar.getMsgId()))) {
                i3 = Integer.valueOf(this.f190414d.indexOf(Long.valueOf(aVar.getMsgId())));
            } else {
                this.f190415e.element = false;
                i3 = Integer.MAX_VALUE;
            }
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) t17;
            if (this.f190414d.contains(Long.valueOf(aVar2.getMsgId()))) {
                i16 = Integer.valueOf(this.f190414d.indexOf(Long.valueOf(aVar2.getMsgId())));
            } else {
                this.f190415e.element = false;
                i16 = Integer.MAX_VALUE;
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(i3, i16);
            return compareValues;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMsgListVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.couldTriggerDismissPanel = true;
        this.couldTriggerShowKeyboard = true;
        this.mFirstDraw = true;
        this.focusBottomHandler = new com.tencent.mobileqq.aio.msglist.scrollers.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$longShotMaskColor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(AIOMsgListVB.this.getMContext().getColor(R.color.b4x)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.longShotMaskColor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$longShotRangeColor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(AIOMsgListVB.this.getMContext().getColor(R.color.b4y)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.longShotRangeColor = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<AIOMsgListVB$onAIODispatchDrawListener$2.a>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$onAIODispatchDrawListener$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$onAIODispatchDrawListener$2$a", "Lcom/tencent/aio/api/list/p;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "dispatchDraw", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements com.tencent.aio.api.list.p {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AIOMsgListVB f190416a;

                a(AIOMsgListVB aIOMsgListVB) {
                    this.f190416a = aIOMsgListVB;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgListVB);
                    }
                }

                @Override // com.tencent.aio.api.list.p
                public void dispatchDraw(@Nullable Canvas canvas) {
                    int J2;
                    int L2;
                    List<? extends com.tencent.aio.data.msglist.a> K2;
                    List<? extends com.tencent.aio.data.msglist.a> N2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                        return;
                    }
                    if (canvas == null) {
                        return;
                    }
                    am amVar = am.f194110a;
                    J2 = this.f190416a.J2();
                    L2 = this.f190416a.L2();
                    AIORecycleView M2 = this.f190416a.M2();
                    K2 = this.f190416a.K2();
                    N2 = this.f190416a.N2();
                    amVar.l(J2, L2, M2, canvas, K2, N2);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(AIOMsgListVB.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.onAIODispatchDrawListener = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AIOMsgListVB$onTracerDispatchDrawListener$2.a>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$onTracerDispatchDrawListener$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$onTracerDispatchDrawListener$2$a", "Lcom/tencent/aio/api/list/p;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "dispatchDraw", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements com.tencent.aio.api.list.p {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AIOMsgListVB f190417a;

                a(AIOMsgListVB aIOMsgListVB) {
                    this.f190417a = aIOMsgListVB;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgListVB);
                    }
                }

                @Override // com.tencent.aio.api.list.p
                public void dispatchDraw(@Nullable Canvas canvas) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                        return;
                    }
                    int childCount = this.f190417a.M2().getChildCount();
                    z16 = this.f190417a.mFirstDraw;
                    if (z16 && childCount > 0) {
                        this.f190417a.mFirstDraw = false;
                        this.f190417a.M2().removeOnDispatchDrawListener(this);
                        this.f190417a.r3();
                        com.tencent.qqnt.trace.d.f362331a.e(System.currentTimeMillis());
                        long nodeTime = com.tencent.qqnt.trace.r.f362387a.findStream("AIO_PAGE").nodeTime("NOTIFY_DATA");
                        if (nodeTime == 0) {
                            com.tencent.qqnt.trace.a.f362326a.c("firstDraw=true, child=" + childCount + ", notifyTime=0");
                            return;
                        }
                        if (this.f190417a.mLockTime == 0) {
                            com.tencent.qqnt.trace.a aVar = com.tencent.qqnt.trace.a.f362326a;
                            aVar.c("firstDraw=true, child=" + childCount + ", lockTime == 0L");
                            aVar.e("SHOW_LIST");
                            return;
                        }
                        if (this.f190417a.mUnlockTime == 0) {
                            com.tencent.qqnt.trace.a aVar2 = com.tencent.qqnt.trace.a.f362326a;
                            aVar2.c("firstDraw=true, child=" + childCount + ", unlockTime == 0L");
                            aVar2.e("SHOW_LIST");
                            return;
                        }
                        if (nodeTime >= this.f190417a.mUnlockTime) {
                            com.tencent.qqnt.trace.a aVar3 = com.tencent.qqnt.trace.a.f362326a;
                            aVar3.c("firstDraw=true, child=" + childCount + ", notifyTime >= unlockTime");
                            aVar3.e("SHOW_LIST");
                            return;
                        }
                        long j3 = this.f190417a.mUnlockTime - nodeTime;
                        com.tencent.qqnt.trace.a aVar4 = com.tencent.qqnt.trace.a.f362326a;
                        aVar4.c("firstDraw=true, child=" + childCount + ", delay=" + j3 + " ms");
                        aVar4.f("SHOW_LIST", System.currentTimeMillis() - j3);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(AIOMsgListVB.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.onTracerDispatchDrawListener = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AIOMsgListGroup>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$layout$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgListGroup invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOMsgListGroup) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOMsgListGroup aIOMsgListGroup = new AIOMsgListGroup(AIOMsgListVB.this.getMContext(), null, 0, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$layout$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                        }
                    }

                    public final void invoke(int i3) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i3);
                        } else if (i3 < 0) {
                            AIOMsgListVB.this.sendIntent(AIOMsgListMviIntent.a.f190346d);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }
                }, 6, null);
                aIOMsgListGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return aIOMsgListGroup;
            }
        });
        this.layout = lazy5;
        this.arrangeMode = 1;
        this.msgListLockLayoutHelperListener = new g();
    }

    private final void A3(boolean clip, int bottomPadding) {
        AIORecycleView M2 = M2();
        M2.setClipToPadding(clip);
        M2.setClipChildren(clip);
        this.extendBottomPadding = bottomPadding;
    }

    private final void C2() {
        AnimatorSet animatorSet = this.highlightAnimator;
        if (animatorSet != null && animatorSet.isStarted()) {
            animatorSet.end();
        }
    }

    private final void C3(AIOMsgListViewState.InputBarHeightChangeState state) {
        if (state.b()) {
            int max = Math.max(G2().getPaddingBottom() + this.normalRecyclerViewPadding, state.a());
            AIOMsgListGroup G2 = G2();
            G2.setPadding(G2.getPaddingLeft(), G2.getPaddingTop(), G2.getPaddingRight(), 0);
            AIORecycleView M2 = M2();
            M2.setPadding(M2.getPaddingLeft(), M2.getPaddingTop(), M2.getPaddingRight(), max);
            this.stopPaddingAnim = true;
            this.normalRecyclerViewPadding = M2().getPaddingBottom();
            return;
        }
        AIOMsgListGroup G22 = G2();
        G22.setPadding(G22.getPaddingLeft(), G22.getPaddingTop(), G22.getPaddingRight(), state.a());
        if (!this.mIsAddAvatarView) {
            AIORecycleView M22 = M2();
            M22.setPadding(M22.getPaddingLeft(), M22.getPaddingTop(), M22.getPaddingRight(), com.tencent.aio.view_dsl.dsl.c.b(8) + this.extendBottomPadding);
        }
        this.normalRecyclerViewPadding = M2().getPaddingBottom();
        this.stopPaddingAnim = false;
    }

    private final void D3(int paddingTop) {
        QLog.i("AIOMsgListVB", 1, "setTopPadding paddingTop=" + paddingTop);
        AIOMsgListGroup G2 = G2();
        G2.setPadding(G2.getPaddingLeft(), paddingTop, G2.getPaddingRight(), G2.getPaddingBottom());
    }

    private final void E3(int top, boolean withAnim) {
        int intValue = G2().w().getFirst().intValue();
        ValueAnimator valueAnimator = this.transparentAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.transparentAnimator = null;
        if (top == intValue) {
            return;
        }
        QLog.i("AIOMsgListVB", 1, "setTopTransparent top=" + top + " oldTop=" + intValue + " withAnim=" + withAnim);
        if (withAnim) {
            ValueAnimator ofInt = ValueAnimator.ofInt(intValue, top);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    AIOMsgListVB.F3(AIOMsgListVB.this, valueAnimator2);
                }
            });
            ofInt.start();
            this.transparentAnimator = ofInt;
            return;
        }
        G2().setTransparentArea(top, G2().w().getSecond().intValue());
    }

    private final List<Pair<Integer, Integer>> F2() {
        return com.tencent.mobileqq.aio.msglist.b.f190447a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F3(AIOMsgListVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOMsgListGroup G2 = this$0.G2();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        G2.setTransparentArea(((Integer) animatedValue).intValue(), this$0.G2().w().getSecond().intValue());
    }

    private final AIOMsgListGroup G2() {
        return (AIOMsgListGroup) this.layout.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        if (r9.intValue() != 24) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<AIOMsgViewRect> H2(int flags) {
        int i3;
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        com.tencent.aio.base.mvvm.a<?, ?> aVar2;
        BaseContentComponent<? extends AIOMsgItem> n16;
        MsgRecord msgRecord;
        int i16;
        boolean z16;
        ArrayList<AIOMsgViewRect> arrayList = new ArrayList<>();
        AIORecycleView M2 = M2();
        int findLastCompletelyVisibleItemPosition = M2.getLayoutManager().findLastCompletelyVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = M2.getLayoutManager().findFirstCompletelyVisibleItemPosition();
        if ((flags & 2) != 0) {
            i3 = RangesKt___RangesKt.coerceAtLeast(0, findFirstCompletelyVisibleItemPosition - 1);
        } else {
            i3 = findFirstCompletelyVisibleItemPosition;
        }
        Rect rect = new Rect();
        M2.getGlobalVisibleRect(rect);
        if (i3 <= findLastCompletelyVisibleItemPosition) {
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = M2.findViewHolderForAdapterPosition(i3);
                Integer num = null;
                if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                    aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar2 = aVar.m();
                } else {
                    aVar2 = null;
                }
                if (aVar2 instanceof AIOBubbleMsgItemVB) {
                    com.tencent.aio.base.mvvm.a<?, ?> m3 = aVar.m();
                    Intrinsics.checkNotNull(m3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVB");
                    AIOBubbleMsgItemVB aIOBubbleMsgItemVB = (AIOBubbleMsgItemVB) m3;
                    AIOMsgItem p16 = aIOBubbleMsgItemVB.p1();
                    if (p16 != null && (n16 = aIOBubbleMsgItemVB.n1()) != null && n16.w1()) {
                        AIOMsgItem D1 = n16.D1();
                        if (D1 != null) {
                            msgRecord = D1.getMsgRecord();
                        } else {
                            msgRecord = null;
                        }
                        if (msgRecord != null) {
                            num = Integer.valueOf(msgRecord.msgType);
                        }
                        boolean z17 = true;
                        if ((flags & 16) != 0) {
                            if (msgRecord != null && MsgExtKt.O(msgRecord)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                if (num != null) {
                                }
                            }
                        }
                        if (((flags & 1) == 0 || (!(n16 instanceof CommonGrayTipsComponent) && !(n16 instanceof RevokeGrayTipsComponent))) && (((flags & 4) == 0 || !(n16 instanceof AIOAniStickerContentComponent)) && (((i16 = flags & 8) == 0 || !(n16 instanceof AIOFileContentComponent)) && (i16 == 0 || !(n16 instanceof AIOOnlineFileContentComponent))))) {
                            Rect rect2 = new Rect();
                            n16.c1().getGlobalVisibleRect(rect2);
                            rect2.offset(-rect.left, 0);
                            long msgId = p16.getMsgId();
                            if (i3 < findFirstCompletelyVisibleItemPosition) {
                                z17 = false;
                            }
                            arrayList.add(new AIOMsgViewRect(msgId, rect2, z17));
                        }
                    }
                }
                if (i3 == findLastCompletelyVisibleItemPosition) {
                    break;
                }
                i3++;
            }
        }
        return arrayList;
    }

    private final boolean I3(int index, int specificHeight) {
        int[] iArr = new int[2];
        M2().getChildAt(index).getLocationInWindow(iArr);
        if (iArr[1] < specificHeight) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int J2() {
        return ((Number) this.longShotMaskColor.getValue()).intValue();
    }

    private final void J3() {
        com.tencent.mobileqq.aio.msglist.helper.d dVar = this.msgListLockLayoutHelper;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
            dVar = null;
        }
        dVar.k("animation end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.aio.data.msglist.a> K2() {
        AIOMsgListMviIntent.g gVar = new AIOMsgListMviIntent.g(null, 1, null);
        sendIntent(gVar);
        return gVar.a();
    }

    private final void K3(int position, Float[] drawSize) {
        G2().setImmersiveArea(position, drawSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L2() {
        return ((Number) this.longShotRangeColor.getValue()).intValue();
    }

    private final void L3(boolean toSet, boolean force) {
        RenderEffect createBlurEffect;
        RenderEffect createBlurEffect2;
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (force) {
            if (toSet) {
                AIOMsgListGroup G2 = G2();
                createBlurEffect2 = RenderEffect.createBlurEffect(50.0f, 50.0f, Shader.TileMode.CLAMP);
                G2.setRenderEffect(createBlurEffect2);
                this.setMsgListRenderEffect = true;
                return;
            }
            G2().setRenderEffect(null);
            this.setMsgListRenderEffect = false;
            return;
        }
        if (toSet && !this.setMsgListRenderEffect) {
            AIOMsgListGroup G22 = G2();
            createBlurEffect = RenderEffect.createBlurEffect(50.0f, 50.0f, Shader.TileMode.CLAMP);
            G22.setRenderEffect(createBlurEffect);
            this.setMsgListRenderEffect = true;
            return;
        }
        if (!toSet && this.setMsgListRenderEffect) {
            G2().setRenderEffect(null);
            this.setMsgListRenderEffect = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.aio.data.msglist.a> N2() {
        AIOMsgListMviIntent.f fVar = new AIOMsgListMviIntent.f(null, 1, null);
        sendIntent(fVar);
        return fVar.a();
    }

    private final AnimatorSet P2(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int Q2 = Q2(context);
        ObjectAnimator duration = ObjectAnimator.ofInt(view, "backgroundColor", 16643300, Q2).setDuration(16L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofInt(view, \"backgroundC\u2026inkColor).setDuration(16)");
        duration.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration2 = ObjectAnimator.ofInt(view, "backgroundColor", Q2, Q2).setDuration(1000L);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofInt(view, \"backgroundC\u2026kColor).setDuration(1000)");
        duration2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration3 = ObjectAnimator.ofInt(view, "backgroundColor", Q2, 16643300).setDuration(100L);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofInt(view, \"backgroundC\u2026inColor).setDuration(100)");
        duration3.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2, duration3);
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_msg_flush_reuse_9015", true)) {
            view.setTag(R.id.siv, animatorSet);
            animatorSet.addListener(new c(view));
        }
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R2(long msgSeq, long msgId, MsgListState state) {
        boolean z16;
        int i3 = -1;
        if (msgId <= 0) {
            Iterator<com.tencent.aio.data.msglist.a> it = state.iterator();
            int i16 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getMsgSeq() == msgSeq) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
            QLog.i("AIOMsgListVB", 1, "[getNavigationIndexOfMsg]: msgId is invalid, msgSeq is " + msgSeq + ", getIndexOfFirst " + i3);
            return i3;
        }
        ArrayList<Pair> arrayList = new ArrayList();
        int i17 = 0;
        for (com.tencent.aio.data.msglist.a aVar : state) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar2 = aVar;
            if ((aVar2 instanceof AIOMsgItem) && aVar2.getMsgSeq() == msgSeq) {
                arrayList.add(new Pair(Integer.valueOf(i17), aVar2));
            }
            i17 = i18;
        }
        int size = arrayList.size();
        if (size == 1) {
            i3 = ((Number) ((Pair) arrayList.get(0)).getFirst()).intValue();
        } else if (size > 1) {
            for (Pair pair : arrayList) {
                if (((AIOMsgItem) pair.getSecond()).getMsgId() == msgId) {
                    i3 = ((Number) pair.getFirst()).intValue();
                }
            }
        }
        QLog.i("AIOMsgListVB", 1, "[getNavigationIndexOfMsg]: msgSeq is " + msgSeq + ", msgId is " + msgId + ", matchSize is " + size + ", index is " + i3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S2() {
        AIOMsgListMviIntent.h hVar = new AIOMsgListMviIntent.h(0, 1, null);
        sendIntent(hVar);
        return hVar.a();
    }

    private final AIOMsgListVB$onAIODispatchDrawListener$2.a T2() {
        return (AIOMsgListVB$onAIODispatchDrawListener$2.a) this.onAIODispatchDrawListener.getValue();
    }

    private final AIOMsgListVB$onTracerDispatchDrawListener$2.a U2() {
        return (AIOMsgListVB$onTracerDispatchDrawListener$2.a) this.onTracerDispatchDrawListener.getValue();
    }

    private final int V2() {
        return (M2().computeVerticalScrollRange() - M2().computeVerticalScrollOffset()) - M2().computeVerticalScrollExtent();
    }

    private final void Y2(int startPos, int itemCount, Object payload, IListUIOperationApi uiHelper) {
        if (startPos >= 0) {
            uiHelper.u(startPos, itemCount, payload);
        }
    }

    private final void Z2(View avatarAreaView, IListUIOperationApi uiHelper) {
        if (this.aioMsgAvatarAreaGroup != null) {
            g3();
        }
        AIOMsgAvatarAreaGroup aIOMsgAvatarAreaGroup = new AIOMsgAvatarAreaGroup(getMContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        aIOMsgAvatarAreaGroup.addView(avatarAreaView, layoutParams);
        aIOMsgAvatarAreaGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.aioMsgAvatarAreaGroup = aIOMsgAvatarAreaGroup;
        AIOMsgListGroup G2 = G2();
        AIOMsgAvatarAreaGroup aIOMsgAvatarAreaGroup2 = this.aioMsgAvatarAreaGroup;
        Intrinsics.checkNotNull(aIOMsgAvatarAreaGroup2);
        G2.p(aIOMsgAvatarAreaGroup2);
        G2().setAvatarCoincideHeight(com.tencent.aio.view_dsl.dsl.c.b(30));
        G2().setAvatarTransitionHeight(com.tencent.aio.view_dsl.dsl.c.b(30));
        G2().setDrawDebug(false);
        this.mIsAddAvatarView = true;
        AIOMsgListViewState.InputBarHeightChangeState inputBarHeightChangeState = this.mLastInputChangeState;
        if (inputBarHeightChangeState != null) {
            C3(inputBarHeightChangeState);
        }
        View view = this.footerView;
        if (view != null) {
            uiHelper.K(view);
        }
    }

    private final void a3(IListUIOperationApi uiHelper, AIOMsgListViewState.AddStickerBottomFooterView state) {
        ViewGroup viewGroup;
        if (this.mIsAddAvatarView) {
            QLog.i("AIOMsgListVB", 1, "[handleAddStickerFooterView]: avtarView is already add, not allow add footer");
            return;
        }
        uiHelper.B(state.b(), state.a());
        this.footerView = state.b();
        ViewParent parent = state.b().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        this.footerLayout = viewGroup;
        d dVar = new d(getMContext());
        dVar.setTargetPosition(uiHelper.t().size());
        uiHelper.i().getLayoutManager().startSmoothScroll(dVar);
    }

    private final void b3() {
        QLog.i("AIOMsgListVB", 1, "handleCompleteAIOStartAnimal");
        this.aioCompleteEnter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c3(MsgListState state, IListUIOperationApi helper) {
        boolean z16;
        boolean z17;
        int i3;
        Bundle extra = state.getExtra();
        if (extra != null) {
            z16 = extra.getBoolean("check_current_focus", true);
        } else {
            z16 = true;
        }
        Long f16 = helper.f();
        if ((!z16 || ((f16 != null && f16.longValue() == -1) || this.focusBottomHandler.k())) && (!helper.t().isEmpty())) {
            Bundle extra2 = state.getExtra();
            boolean z18 = false;
            if (extra2 != null) {
                z17 = extra2.getBoolean("scroll_animation", false);
            } else {
                z17 = false;
            }
            ViewGroup viewGroup = this.footerLayout;
            if (viewGroup != null) {
                i3 = viewGroup.getChildCount();
            } else {
                i3 = 0;
            }
            if (z17) {
                this.focusBottomHandler.o(state, helper, i3, new e());
                return;
            }
            Bundle extra3 = state.getExtra();
            if (extra3 != null) {
                z18 = extra3.getBoolean(HippyQQPagView.FunctionName.FLUSH, false);
            }
            int size = (state.size() - 1) + i3;
            f fVar = new f(z18, this, helper.i(), size);
            this.mSetBottomStart = true;
            helper.p(size, true, fVar);
        }
    }

    private final void d3() {
        sendIntent(AIOMsgListMviIntent.a.f190346d);
    }

    private final void e3(boolean isLongShotMode) {
        if (isLongShotMode) {
            M2().addOnDispatchDrawListener(T2());
        } else {
            M2().removeOnDispatchDrawListener(T2());
        }
        M2().invalidate();
    }

    private final void f3(final AIOMsgListDataState state, final IListUIOperationApi uiHelper) {
        if (state.getForceUpdate()) {
            RecyclerView.Adapter adapter = uiHelper.i().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        super.u0(state, uiHelper);
        AIOOptConfigKt.o(new Function0<Unit>(state, uiHelper) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$handleMsgListDataState$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOMsgListDataState $state;
            final /* synthetic */ IListUIOperationApi $uiHelper;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$state = state;
                this.$uiHelper = uiHelper;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AIOMsgListVB.this, state, uiHelper);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                z16 = AIOMsgListVB.this.showFlingOverScrollLoading;
                if (z16 && MsgListState.Companion.UpdateType.INSTANCE.a(4, this.$state.getUpdateType())) {
                    AIOMsgListVB.this.showFlingOverScrollLoading = false;
                    this.$uiHelper.q();
                    z17 = AIOMsgListVB.this.showFlingOverScrollLoading;
                    QLog.d("AIOMsgListVB", 1, "close showFlingOverScrollLoading " + z17);
                }
            }
        });
    }

    private final void g3() {
        if (this.aioMsgAvatarAreaGroup != null) {
            AIOMsgListGroup G2 = G2();
            AIOMsgAvatarAreaGroup aIOMsgAvatarAreaGroup = this.aioMsgAvatarAreaGroup;
            Intrinsics.checkNotNull(aIOMsgAvatarAreaGroup);
            G2.A(aIOMsgAvatarAreaGroup);
            this.aioMsgAvatarAreaGroup = null;
        }
        this.mIsAddAvatarView = false;
        AIOMsgListViewState.InputBarHeightChangeState inputBarHeightChangeState = this.mLastInputChangeState;
        if (inputBarHeightChangeState != null) {
            C3(inputBarHeightChangeState);
        }
    }

    private final void h3(boolean show) {
        L3(show, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i3(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("set_bottom", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j3(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        if (!bundle.containsKey("navigate_seq") && !bundle.containsKey("navigate_id") && !bundle.containsKey("navigate_time")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k3(int index) {
        View view;
        ArrayList arrayListOf;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = M2().findViewHolderForAdapterPosition(index);
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar = null;
        if (findViewHolderForAdapterPosition != null) {
            view = findViewHolderForAdapterPosition.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(view);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = M2().findViewHolderForAdapterPosition(index);
            if (findViewHolderForAdapterPosition2 instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition2;
            }
            l3(arrayListOf, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l3(List<? extends View> viewList, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a viewHolder) {
        Object first;
        AIOBubbleMsgItemVB aIOBubbleMsgItemVB;
        BaseContentComponent<? extends AIOMsgItem> n16;
        if (viewList.isEmpty()) {
            QLog.i("AIOMsgListVB", 1, "[highlightItemView]: viewList is empty");
            return;
        }
        C2();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = viewList.iterator();
        while (it.hasNext()) {
            arrayList.add(P2((View) it.next()));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        QLog.i("AIOMsgListVB", 1, "[highlightItemView]: start animator");
        this.highlightAnimator = animatorSet;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) viewList);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && viewHolder != null) {
            com.tencent.aio.base.mvvm.a<?, ?> m3 = viewHolder.m();
            View view = null;
            if (m3 instanceof AIOBubbleMsgItemVB) {
                aIOBubbleMsgItemVB = (AIOBubbleMsgItemVB) m3;
            } else {
                aIOBubbleMsgItemVB = null;
            }
            if (aIOBubbleMsgItemVB != null && (n16 = aIOBubbleMsgItemVB.n1()) != null) {
                view = n16.e1();
            }
            AccessibilityUtil.m(view);
        }
    }

    private final void n3(List<Integer> indexList) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = indexList.iterator();
        int i3 = -1;
        while (true) {
            aVar = null;
            View view = null;
            aVar = null;
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Number) it.next()).intValue();
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = M2().findViewHolderForAdapterPosition(intValue);
            if (findViewHolderForAdapterPosition != null) {
                view = findViewHolderForAdapterPosition.itemView;
            }
            if (view != null) {
                arrayList.add(view);
                i3 = intValue;
            }
        }
        if (i3 >= 0) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = M2().findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition2;
            }
        }
        l3(arrayList, aVar);
    }

    private final void o3() {
        AIOMsgListMviIntent.e eVar = new AIOMsgListMviIntent.e(0, 1, null);
        sendIntent(eVar);
        if (eVar.a() > 0) {
            AIOMsgListGroup G2 = G2();
            G2.setPadding(G2.getPaddingLeft(), G2.getPaddingTop(), G2.getPaddingRight(), eVar.a());
        }
    }

    private final boolean p3() {
        return !M2().canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3() {
        sendIntent(AIOMsgListMviIntent.o.f190366d);
        com.tencent.mobileqq.aio.msglist.helper.d dVar = this.msgListLockLayoutHelper;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
            dVar = null;
        }
        dVar.i("first draw");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s3(AIOMsgListVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i18 - i16;
        if (i29 != i28 - i26) {
            this$0.sendIntent(new AIOMsgListMviIntent.k(i29));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t3(AIOMsgListVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == i19 && i16 == i26 && i17 == i27 && i18 == i28) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this$0.sendIntent(AIOMsgListMviIntent.i.f190354d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3(AIOMsgListVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(AIOMsgListMviIntent.c.f190348d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(MsgListState state) {
        boolean z16;
        long j3;
        boolean z17;
        if (state.size() <= 120 || this.mScrollState != 0) {
            return;
        }
        Bundle extra = state.getExtra();
        if (extra != null && extra.getBoolean("check_eliminate_msg", false)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Bundle extra2 = state.getExtra();
        if (extra2 != null) {
            j3 = extra2.getLong("location_req_time", 0L);
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        boolean p36 = p3();
        boolean k3 = this.focusBottomHandler.k();
        Bundle extra3 = state.getExtra();
        if (extra3 != null) {
            z17 = extra3.getBoolean("eliminate_top_msg", false);
        } else {
            z17 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgListVB", 4, "[checkAndEliminateMsg]: listSize=" + state.size() + ", atBottom=" + p36 + ", isAnimation=" + k3 + ", setBottomStart= " + this.mSetBottomStart + ", eliminateTopMsg=" + z17);
        }
        if (!p36 && !this.mSetBottomStart && !k3 && !z17) {
            sendIntent(new AIOMsgListMviIntent.CheckEliminateMsg(false, j3));
        } else {
            sendIntent(new AIOMsgListMviIntent.CheckEliminateMsg(true, j3));
        }
    }

    private final void w2() {
        if (I2() == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        I2().b();
        w3();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.j
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgListVB.x2();
            }
        }, 16, null, false);
        ((IAIOAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAvatarApi.class)).clearAIOCache();
        QLog.d("AIOMsgListVB", 1, "clearMemory, cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private final void w3() {
        Fragment a16;
        LifecycleCoroutineScope lifecycleScope;
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b bVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b) getMStrategyService().b(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b.class);
        if (bVar != null && (a16 = bVar.a()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(a16)) != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOMsgListVB", 2, "reCreateViewHolder");
            }
            ViewHolderAsyncCreator.f192687a.c(I2().i(), lifecycleScope, F2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2() {
        try {
            com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.a();
        } catch (Exception e16) {
            QLog.e("AIOMsgListVB", 1, "DynamicDrawableManager.clearLruCache()", e16);
        }
    }

    private final void x3(List<? extends com.tencent.aio.data.msglist.a> list) {
        int collectionSizeOrDefault;
        List<? extends com.tencent.aio.data.msglist.a> sortedWith;
        List<? extends com.tencent.aio.data.msglist.a> list2 = list;
        for (com.tencent.aio.data.msglist.a aVar : list2) {
            if (aVar instanceof ShortVideoMsgItem) {
                ((ShortVideoMsgItem) aVar).a3(VideoViewModel.Shot);
            }
        }
        RecyclerView recyclerView = new RecyclerView(getMContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getMContext()));
        this.screenShot = v1(recyclerView);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(M2().getWidth(), M2().getHeight()));
        List<com.tencent.aio.data.msglist.a> N2 = N2();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(N2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = N2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((com.tencent.aio.data.msglist.a) it.next()).getMsgId()));
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new l(arrayList, booleanRef));
        com.tencent.aio.api.list.n nVar = null;
        if (booleanRef.element) {
            com.tencent.aio.api.list.n nVar2 = this.screenShot;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShot");
            } else {
                nVar = nVar2;
            }
            nVar.a(sortedWith);
            if (QLog.isColorLevel()) {
                QLog.i("AIOMsgListVB", 1, "sort with displayList, size: " + sortedWith.size());
            }
        } else {
            com.tencent.aio.api.list.n nVar3 = this.screenShot;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShot");
            } else {
                nVar = nVar3;
            }
            nVar.a(list);
            if (QLog.isColorLevel()) {
                QLog.i("AIOMsgListVB", 1, "sort with msgSeq seq, size: " + sortedWith.size());
            }
        }
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        ((ViewGroup) ((Activity) mContext).getWindow().getDecorView().findViewById(R.id.tua)).addView(recyclerView, 0);
        sendIntent(new AIOMsgListMviIntent.r(recyclerView));
    }

    private final boolean y2(int index, int specificHeight, int componentKey) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        com.tencent.aio.base.mvvm.a<?, ?> aVar2;
        AIOBubbleMsgItemVB aIOBubbleMsgItemVB;
        int i3;
        com.tencent.mobileqq.aio.msglist.holder.g m16;
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray;
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = M2().findViewHolderForAdapterPosition(index);
        View view = null;
        if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
            aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar2 = aVar.m();
        } else {
            aVar2 = null;
        }
        if (aVar2 instanceof AIOBubbleMsgItemVB) {
            aIOBubbleMsgItemVB = (AIOBubbleMsgItemVB) aVar2;
        } else {
            aIOBubbleMsgItemVB = null;
        }
        if (aIOBubbleMsgItemVB != null && (m16 = aIOBubbleMsgItemVB.m1()) != null && (sparseArray = m16.get()) != null && (cVar = sparseArray.get(componentKey)) != null) {
            view = cVar.c1();
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationInWindow(iArr);
        }
        int i16 = iArr[1];
        if (view != null) {
            i3 = view.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        if (i16 + i3 > specificHeight) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y3(int increment) {
        int i3;
        int paddingBottom = M2().getPaddingBottom();
        QLog.i("AIOMsgListVB", 1, "setBottomPaddingIncrement increment=" + increment + ", current:" + paddingBottom + ", original:" + this.originalRecyclerViewPaddingBottom);
        boolean z16 = this.isIncrementState;
        if (!z16 && increment == 0) {
            return;
        }
        if (z16 && increment != 0) {
            QLog.i("AIOMsgListVB", 1, "setBottomPaddingIncrement increment:" + increment);
            return;
        }
        if (increment > 0) {
            int V2 = V2();
            int i16 = increment - V2;
            this.isApiScroll = true;
            QLog.i("AIOMsgListVB", 1, "setBottomPaddingIncrement increment:" + increment + "  remainDistanceToBottom:" + V2 + "  incrementAfterScroll:" + i16);
            if (V2 > 0) {
                if (i16 <= 0) {
                    M2().smoothScrollBy(0, increment);
                    return;
                }
                M2().smoothScrollBy(0, V2);
            }
            this.isIncrementState = true;
            this.bottomPaddingIncrement = i16;
            int paddingBottom2 = M2().getPaddingBottom();
            this.originalRecyclerViewPaddingBottom = paddingBottom2;
            i3 = paddingBottom2 + i16;
        } else {
            this.isIncrementState = false;
            this.bottomPaddingIncrement = 0;
            i3 = this.originalRecyclerViewPaddingBottom;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(paddingBottom, i3);
        ofInt.setDuration(250L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIOMsgListVB.z3(AIOMsgListVB.this, valueAnimator);
            }
        });
        ofInt.start();
    }

    private final void z2(final IListUIOperationApi iListUIOperationApi) {
        AIOOptConfigKt.o(new Function0<Unit>(iListUIOperationApi) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$configOverScrollStrategy$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IListUIOperationApi $this_configOverScrollStrategy;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVB$configOverScrollStrategy$1$a", "Lcom/tencent/aio/api/list/IBounceScrollApi$a;", "", "dy", "type", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements IBounceScrollApi.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AIOMsgListVB f190403a;

                a(AIOMsgListVB aIOMsgListVB) {
                    this.f190403a = aIOMsgListVB;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgListVB);
                    }
                }

                @Override // com.tencent.aio.api.list.IBounceScrollApi.a
                public boolean a(int dy5, int type) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(dy5), Integer.valueOf(type))).booleanValue();
                    }
                    QLog.d("AIOMsgListVB", 1, "canOverScrollerMove " + dy5 + " " + type);
                    if (dy5 < 0 && type == 1) {
                        z16 = this.f190403a.showFlingOverScrollLoading;
                        if (z16) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_configOverScrollStrategy = iListUIOperationApi;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this, (Object) iListUIOperationApi);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AIOMsgListVB.this.showFlingOverScrollLoading = true;
                z16 = AIOMsgListVB.this.showFlingOverScrollLoading;
                QLog.d("AIOMsgListVB", 1, "configOverScrollStrategy " + z16);
                this.$this_configOverScrollStrategy.setOverScrollStrategy(new a(AIOMsgListVB.this));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z3(AIOMsgListVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.stopPaddingAnim) {
            valueAnimator.cancel();
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        AIORecycleView M2 = this$0.M2();
        M2.setPadding(M2.getPaddingLeft(), M2.getPaddingTop(), M2.getPaddingRight(), intValue);
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    /* renamed from: A2, reason: merged with bridge method [inline-methods] */
    public AIOMsgListVM F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AIOMsgListVM) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new AIOMsgListVM(this);
    }

    @NotNull
    public com.tencent.aio.api.refreshLoad.a B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.aio.api.refreshLoad.a) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return new AIOPatchingPreLoadStrategy(I2(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$createPreLoadStrategy$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                z16 = AIOMsgListVB.this.aioCompleteEnter;
                return Boolean.valueOf(z16);
            }
        });
    }

    protected final void B3(@NotNull AIORecycleView aIORecycleView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aIORecycleView);
        } else {
            Intrinsics.checkNotNullParameter(aIORecycleView, "<set-?>");
            this.mRecyclerView = aIORecycleView;
        }
    }

    public int D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.arrangeMode;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (AbsMsgListVB.b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return new b();
    }

    public final void G3(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.touchDownX = f16;
        }
    }

    public final void H3(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.touchDownY = f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IListUIOperationApi I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IListUIOperationApi) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        if (iListUIOperationApi != null) {
            return iListUIOperationApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.w
    @NotNull
    public RecyclerView K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return M2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AIORecycleView M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIORecycleView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AIORecycleView aIORecycleView = this.mRecyclerView;
        if (aIORecycleView != null) {
            return aIORecycleView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @ColorInt
    public int Q2(@NotNull Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int color = context.getColor(R.color.qui_common_brand_standard);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 51;
        } else {
            i3 = 25;
        }
        return ColorUtils.setAlphaComponent(color, i3);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.S0();
        com.tencent.qqnt.trace.a.f362326a.e("LIST_VB_LOAD_FIRST_PAGE");
        sendIntent(new a.b("AIOMsgListVB"));
        this.mFirstDraw = true;
        this.mLockTime = 0L;
        this.mUnlockTime = 0L;
        M2().addOnDispatchDrawListener(U2());
        o3();
        if (M2().getHeight() > 0) {
            sendIntent(new AIOMsgListMviIntent.k(M2().getHeight()));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, createViewParams, childView, uiHelper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        G2().r(childView);
        this.listUIOperationApi = uiHelper;
        G2().setUiHelper(uiHelper);
        QLog.i("AIOMsgListVB", 1, "onCreateView " + hashCode());
        uiHelper.i0(D2());
        uiHelper.l(new h());
        uiHelper.D(20);
        uiHelper.E(20);
        uiHelper.y(B2());
        uiHelper.F(15000L);
        uiHelper.c(15000L);
        QLog.i("AIOMsgListVB", 1, "auto finish Refresh 15000");
        B3(uiHelper.i());
        this.mUiHelper = uiHelper;
        com.tencent.mobileqq.aio.msglist.helper.d dVar = null;
        M2().setItemAnimator(null);
        AIORecycleView M2 = M2();
        this.msgListLockLayoutHelper = new com.tencent.mobileqq.aio.msglist.helper.d(M2(), this.msgListLockLayoutHelperListener);
        M2.addOnScrollListener(new com.tencent.mobileqq.aio.msglist.d());
        M2.addOnScrollListener(new i());
        M2.addOnTouchListener(new j());
        M2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.msglist.g
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                AIOMsgListVB.s3(AIOMsgListVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        com.tencent.mobileqq.aio.msglist.helper.d dVar2 = this.msgListLockLayoutHelper;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
        } else {
            dVar = dVar2;
        }
        dVar.g();
        M2.setClipToPadding(false);
        M2.setClipChildren(false);
        L3(false, true);
        uiHelper.C(new k());
        M2().getLayoutManager().setNeedAnsyAnchor(true);
        G2().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.msglist.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                AIOMsgListVB.t3(AIOMsgListVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        G2().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOMsgListVB.u3(AIOMsgListVB.this, view);
            }
        });
        com.tencent.qqnt.trace.a.f362326a.e("LIST_VB_ON_CREATE");
        z2(uiHelper);
        return G2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.w
    @NotNull
    public View.AccessibilityDelegate U0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (View.AccessibilityDelegate) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return aa.c(this, M2());
    }

    public final float W2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.touchDownX;
    }

    public final float X2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.touchDownY;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, et.a
    @NotNull
    public List<Pair<Integer, Integer>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.b.f190447a.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        com.tencent.aio.base.mvvm.a<?, ?> aVar2;
        AIOBubbleMsgItemVB aIOBubbleMsgItemVB;
        com.tencent.mobileqq.aio.msglist.holder.g m16;
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray;
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Bundle) iPatchRedirector.redirect((short) 18, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof com.tencent.mobileqq.aio.msglist.k) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ITEM_RECT_LIST", H2(((com.tencent.mobileqq.aio.msglist.k) stateCmd).a()));
            return bundle;
        }
        if (stateCmd instanceof com.tencent.mobileqq.aio.msglist.l) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = M2().findViewHolderForAdapterPosition(((com.tencent.mobileqq.aio.msglist.l) stateCmd).a());
            View view = null;
            if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar2 = aVar.m();
            } else {
                aVar2 = null;
            }
            if (aVar2 instanceof AIOBubbleMsgItemVB) {
                aIOBubbleMsgItemVB = (AIOBubbleMsgItemVB) aVar2;
            } else {
                aIOBubbleMsgItemVB = null;
            }
            if (aIOBubbleMsgItemVB != null && (m16 = aIOBubbleMsgItemVB.m1()) != null && (sparseArray = m16.get()) != null && (cVar = sparseArray.get(2)) != null) {
                view = cVar.c1();
            }
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i3 = iArr[0];
                int i16 = iArr[1];
                Bundle bundle2 = new Bundle();
                bundle2.putInt("top", i16);
                bundle2.putInt("left", i3);
                bundle2.putInt("width", view.getMeasuredWidth());
                bundle2.putInt("height", view.getMeasuredHeight());
                return bundle2;
            }
            return new Bundle();
        }
        return new Bundle();
    }

    @Override // com.tencent.mobileqq.aio.msglist.w
    public long getCurrentFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        IListUIOperationApi iListUIOperationApi = this.mUiHelper;
        if (iListUIOperationApi == null) {
            return -1L;
        }
        Long f16 = iListUIOperationApi.f();
        if (((f16 == null || f16.longValue() != -1) && this.focusBottomHandler.k()) || f16 == null) {
            return -1L;
        }
        return f16.longValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListUiState>> getObserverStates() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AIOMsgListViewState.AIOMsgItemChangedState.class, AIOMsgListDataState.class, AIOMsgListViewState.ImmersiveAreaUiState.class, AIOMsgListViewState.SetTopPadding.class, AIOMsgListViewState.SetTopTransparent.class, AIOMsgListViewState.AddAIOBackgroundView.class, AIOMsgListViewState.RemoveAIOBackgroundView.class, AIOMsgListViewState.SetBottomPaddingIncrement.class, AIOMsgListViewState.GetBottomPaddingIncrement.class);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, et.a
    @NotNull
    public List<Pair<Integer, Integer>> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.b.f190447a.c();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.onDestroy();
        QLog.i("AIOMsgListVB", 1, "onDestroy " + hashCode());
        C2();
        w2();
        ValueAnimator valueAnimator = this.transparentAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.transparentAnimator = null;
        M2().removeOnDispatchDrawListener(T2());
        M2().removeOnDispatchDrawListener(U2());
        ViewGroup viewGroup = this.footerLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        com.tencent.mobileqq.aio.msglist.helper.d dVar = this.msgListLockLayoutHelper;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
            dVar = null;
        }
        dVar.j();
        this.aioCompleteEnter = false;
        G2().B();
        g3();
        this.mLastInputChangeState = null;
        this.focusBottomHandler.n();
        this.titleBottomLocation = 0;
        AIOOptConfigKt.o(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVB$onDestroy$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AIOMsgListVB.this.I2().q();
                    AIOMsgListVB.this.showFlingOverScrollLoading = false;
                }
            }
        });
        this.stopPaddingAnim = false;
        this.normalRecyclerViewPadding = 0;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        QLog.i("AIOMsgListVB", 1, "onReuseView " + hashCode());
        com.tencent.mobileqq.aio.msglist.helper.d dVar = this.msgListLockLayoutHelper;
        com.tencent.mobileqq.aio.msglist.helper.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
            dVar = null;
        }
        dVar.j();
        com.tencent.mobileqq.aio.msglist.helper.d dVar3 = this.msgListLockLayoutHelper;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
        } else {
            dVar2 = dVar3;
        }
        dVar2.g();
        com.tencent.qqnt.trace.a.f362326a.e("LIST_VB_ON_CREATE");
        L3(false, true);
        z2(I2());
        E3(0, false);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void p(@NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        uiHelper.n(new g.b(null, null, false, null, 15, null));
        uiHelper.i().swapAdapter(uiHelper.i().getAdapter(), true);
    }

    @Override // com.tencent.mobileqq.aio.msglist.w
    public int q0(int specificHeight, int componentKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(specificHeight), Integer.valueOf(componentKey))).intValue();
        }
        if (this.mRecyclerView != null) {
            int findFirstVisibleItemPosition = M2().getLayoutManager().findFirstVisibleItemPosition();
            int childCount = M2().getLayoutManager().getChildCount() - 1;
            for (int i3 = 0; i3 < childCount; i3++) {
                int i16 = i3 + findFirstVisibleItemPosition;
                if (y2(i16, specificHeight, componentKey)) {
                    return i16;
                }
            }
        }
        return -1;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof AIOMsgListDataState) {
            f3((AIOMsgListDataState) state, uiHelper);
            return;
        }
        if (state instanceof AIOMsgListViewState.InputBarHeightChangeState) {
            AIOMsgListViewState.InputBarHeightChangeState inputBarHeightChangeState = (AIOMsgListViewState.InputBarHeightChangeState) state;
            C3(inputBarHeightChangeState);
            L3(false, true);
            this.mLastInputChangeState = inputBarHeightChangeState;
            return;
        }
        if (state instanceof AIOMsgListViewState.AIOMsgItemChangedState) {
            AIOMsgListViewState.AIOMsgItemChangedState aIOMsgItemChangedState = (AIOMsgListViewState.AIOMsgItemChangedState) state;
            Y2(aIOMsgItemChangedState.c(), aIOMsgItemChangedState.a(), aIOMsgItemChangedState.b(), uiHelper);
            return;
        }
        if (state instanceof AIOMsgListViewState.ShotMsgItemState) {
            x3(((AIOMsgListViewState.ShotMsgItemState) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.UpdateMsgListBlurView) {
            h3(((AIOMsgListViewState.UpdateMsgListBlurView) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.NeedPreLoadMsg) {
            uiHelper.H(((AIOMsgListViewState.NeedPreLoadMsg) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.DelayLockUpdate) {
            com.tencent.mobileqq.aio.msglist.helper.d dVar = this.msgListLockLayoutHelper;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgListLockLayoutHelper");
                dVar = null;
            }
            dVar.d();
            return;
        }
        if (state instanceof AIOMsgListViewState.UnlockUpdate) {
            J3();
            return;
        }
        if (state instanceof AIOMsgListViewState.SetLongShotMode) {
            e3(((AIOMsgListViewState.SetLongShotMode) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.RefreshLongShotView) {
            M2().invalidate();
            return;
        }
        if (state instanceof AIOMsgListViewState.AddStickerBottomFooterView) {
            a3(uiHelper, (AIOMsgListViewState.AddStickerBottomFooterView) state);
            return;
        }
        if (state instanceof AIOMsgListViewState.RemoveStickerBottomFooterView) {
            uiHelper.K(((AIOMsgListViewState.RemoveStickerBottomFooterView) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.CompleteAIOStartAnimal) {
            b3();
            return;
        }
        if (state instanceof AIOMsgListViewState.AddAIOBackgroundView) {
            G2().q(((AIOMsgListViewState.AddAIOBackgroundView) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.RemoveAIOBackgroundView) {
            G2().B();
            return;
        }
        if (state instanceof AIOMsgListViewState.AddAvatarAreaView) {
            Z2(((AIOMsgListViewState.AddAvatarAreaView) state).a(), uiHelper);
            return;
        }
        if (state instanceof AIOMsgListViewState.RemoveAvatarAreaView) {
            g3();
            return;
        }
        if (state instanceof AIOMsgListViewState.ImmersiveAreaUiState) {
            AIOMsgListViewState.ImmersiveAreaUiState immersiveAreaUiState = (AIOMsgListViewState.ImmersiveAreaUiState) state;
            K3(immersiveAreaUiState.b(), immersiveAreaUiState.a());
            return;
        }
        if (state instanceof AIOMsgListViewState.HideKeyBoardAndPanel) {
            d3();
            return;
        }
        if (state instanceof AIOMsgListViewState.UpdateTitleHeight) {
            AIOMsgListViewState.UpdateTitleHeight updateTitleHeight = (AIOMsgListViewState.UpdateTitleHeight) state;
            this.titleBottomLocation = updateTitleHeight.b() + updateTitleHeight.a()[1];
            return;
        }
        if (state instanceof AIOMsgListViewState.HighLightMsgView) {
            n3(((AIOMsgListViewState.HighLightMsgView) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.SetTopPadding) {
            D3(((AIOMsgListViewState.SetTopPadding) state).a());
            return;
        }
        if (state instanceof AIOMsgListViewState.SetTopTransparent) {
            AIOMsgListViewState.SetTopTransparent setTopTransparent = (AIOMsgListViewState.SetTopTransparent) state;
            E3(setTopTransparent.a(), setTopTransparent.b());
        } else if (state instanceof AIOMsgListViewState.SetClipMode) {
            AIOMsgListViewState.SetClipMode setClipMode = (AIOMsgListViewState.SetClipMode) state;
            A3(setClipMode.b(), setClipMode.a());
        } else if (state instanceof AIOMsgListViewState.SetBottomPaddingIncrement) {
            y3(((AIOMsgListViewState.SetBottomPaddingIncrement) state).a());
        } else if (state instanceof AIOMsgListViewState.GetBottomPaddingIncrement) {
            ((AIOMsgListViewState.GetBottomPaddingIncrement) state).b(this.bottomPaddingIncrement);
        }
    }

    protected void v3(int moveType, int moveDistance, float totalDistance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(moveType), Integer.valueOf(moveDistance), Float.valueOf(totalDistance));
            return;
        }
        if (moveType == 1 && moveDistance < 0 && totalDistance < 0.0f && Math.abs(totalDistance) > 400.0f && this.couldTriggerShowKeyboard) {
            sendIntent(AIOMsgListMviIntent.b.f190347d);
            this.couldTriggerShowKeyboard = false;
            this.couldTriggerDismissPanel = false;
        } else if (moveType == 1 && moveDistance > 0 && this.couldTriggerDismissPanel) {
            sendIntent(AIOMsgListMviIntent.a.f190346d);
            this.couldTriggerDismissPanel = false;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.w
    public int x0(int specificHeight) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, specificHeight)).intValue();
        }
        if (this.mRecyclerView == null) {
            return -1;
        }
        int findFirstVisibleItemPosition = M2().getLayoutManager().findFirstVisibleItemPosition();
        int childCount = M2().getLayoutManager().getChildCount();
        ViewGroup viewGroup = this.footerLayout;
        if (viewGroup != null) {
            i3 = viewGroup.getChildCount();
        } else {
            i3 = 0;
        }
        for (int i16 = (childCount - i3) - 1; -1 < i16; i16--) {
            if (I3(i16, specificHeight)) {
                return i16 + findFirstVisibleItemPosition;
            }
        }
        return -1;
    }
}
