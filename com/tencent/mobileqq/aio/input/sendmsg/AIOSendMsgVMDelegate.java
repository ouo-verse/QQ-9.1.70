package com.tencent.mobileqq.aio.input.sendmsg;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.FaceBubbleMsgEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.event.PokeMsgEvent;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.aio.event.a;
import com.tencent.mobileqq.aio.input.AIOInputUtil;
import com.tencent.mobileqq.aio.input.at.d;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextUIState;
import com.tencent.mobileqq.aio.input.edit.delegate.o;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.aio.input.reply.a;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgUIState;
import com.tencent.mobileqq.aio.input.sendmsg.a;
import com.tencent.mobileqq.aio.input.sendmsg.robot.ToBotData;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.i;
import com.tencent.mobileqq.aio.utils.l;
import com.tencent.mobileqq.aio.utils.y;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.InputChangeEvent;
import com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.api.IVasAIOSendDataUtilApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AdelieMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.UinInfoAttr;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0006\u00a2\u0001\u00a6\u0001\u00aa\u0001\b\u0007\u0018\u0000 \u00b1\u00012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u00072\u00020\b:\u0002\u0090\u0001B\u0012\u0012\u0007\u0010\u009c\u0001\u001a\u00020\u0005\u00a2\u0006\u0006\b\u00b0\u0001\u0010\u009b\u0001J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0016\u0010 \u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J&\u0010.\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0002J&\u00100\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020&H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u00102\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u00112\u0006\u00102\u001a\u000204H\u0002Jb\u0010?\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\f\u0010:\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u0016\u0010@\u001a\u00020\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001dH\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060\u001dH\u0002J&\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u000108H\u0002J6\u0010G\u001a\u00020\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0Ej\b\u0012\u0004\u0012\u00020\u001e`F2\u0006\u0010,\u001a\u00020\u001bH\u0002J\u0012\u0010H\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J.\u0010I\u001a\u00020\u00112\f\u0010D\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0002J\u0010\u0010J\u001a\u00020!2\u0006\u0010;\u001a\u00020\u001bH\u0002J4\u0010O\u001a\u00020\u00112\u0006\u0010K\u001a\u00020&2\b\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010N\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010&H\u0002J6\u0010U\u001a\u00020\u00112\u0006\u0010K\u001a\u00020&2\u0006\u0010P\u001a\u00020!2\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010S\u001a\u0004\u0018\u00010R2\b\u0010T\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010W\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020VH\u0002J\u0010\u0010Y\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020XH\u0002J\b\u0010Z\u001a\u00020\u001bH\u0002J$\u0010^\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\\0[j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\\`]H\u0002J\u0014\u0010a\u001a\u0004\u0018\u00010`2\b\u0010_\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020bH\u0002J\u0010\u0010f\u001a\u00020\u00112\u0006\u0010e\u001a\u00020dH\u0002J\u001c\u0010g\u001a\u00020\u00112\u0006\u0010/\u001a\u00020&2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010h\u001a\u00020\u00112\u0006\u0010K\u001a\u00020&H\u0002J\u0010\u0010k\u001a\u00020\u00112\u0006\u0010j\u001a\u00020iH\u0002J\u0010\u0010m\u001a\u00020\u00112\u0006\u0010j\u001a\u00020lH\u0002J\u0010\u0010o\u001a\u00020\u00112\u0006\u0010j\u001a\u00020nH\u0002JA\u0010r\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\br\u0010sJA\u0010u\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\bu\u0010sJ\u0012\u0010v\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J9\u0010y\u001a\u00020\u00112\u0006\u0010x\u001a\u00020w2\b\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\by\u0010zJ\u0012\u0010{\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\b\u0010|\u001a\u00020\u0011H\u0002J\"\u0010~\u001a\u00020\u00112\u0006\u0010}\u001a\u00020p2\u0006\u0010x\u001a\u00020w2\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\u001c\u0010\u0081\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020!2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010&H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0002JO\u0010\u0084\u0001\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002JE\u0010\u0085\u0001\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u001bH\u0002J\u0013\u0010\u0087\u0001\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u00020!H\u0002J1\u0010\u008a\u0001\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\\0[j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\\`]2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u001b\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u00042\u0007\u0010\u008c\u0001\u001a\u00020\u001bH\u0016J\u0015\u0010\u0090\u0001\u001a\u00020\u00112\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0002H\u0016J\u0011\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0093\u00010\u0092\u0001H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0011H\u0016R)\u0010\u009c\u0001\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u00a1\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010\u0012R\u0018\u0010\u00a5\u0001\u001a\u00030\u00a2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001c\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u00ae\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/b;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "K", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "N", "event", "", "I", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$EmojiFaceSendEvent;", "V", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$ChainStickerSendEvent;", "U", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PicEmotionSendEvent;", "X", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MediaSendEvent;", "W", "", "t", "", "Lcom/tencent/mobileqq/aio/msg/data/a;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, ReportConstant.COSTREPORT_PREFIX, "", "clearInputStatus", "isSetEssence", "Landroid/os/Bundle;", "G", "", "videoPath", "thumbPath", "Y", "Lcom/tencent/mobileqq/album/media/c;", "data", CustomImageProps.QUALITY, "isFlashPic", BdhLogUtil.LogTag.Tag_Req, "text", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnClickRecallMsgsEvent;", "intent", "P", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$AtMsgSendEvent;", "L", "Lcom/tencent/mobileqq/aio/input/f$e;", "inputElements", "Lcom/tencent/mobileqq/aio/input/d;", "replyData", "selectedMediaList", "fromCamera", "extData", "source", "callbackData", "l0", "Z", "texts", "E", UserInfo.SEX_FEMALE, "mediaList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c0", "y", "v0", "H", "path", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "businessType", "x0", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "originalMd5", "s0", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "u0", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeSendEvent;", "i0", "b0", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "gId", "Lcom/tencent/qqnt/kernel/nativeinterface/AnonymousExtInfo;", "B", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeCancelEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "k0", "z0", "j0", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "t0", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "h0", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "B0", "", "msgUniqueId", "n0", "(Ljava/util/List;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/String;)V", "bundle", "E0", "r", "Lcom/tencent/aio/msgservice/k;", "sendMsgsReq", "a0", "(Lcom/tencent/aio/msgservice/k;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/String;)V", "v", "u", "msgId", "q0", "result", "errMsg", "p0", "T", HippyTKDListViewAdapter.X, "g0", "r0", "e0", "w", "type", "C0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "f0", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "interceptor", "a", "O", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/sendmsg/a;", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "D0", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "e", "Lcom/tencent/aio/api/runtime/a;", "mContext", "f", "aiBusinessFlag", "com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$c", h.F, "Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$c;", "mAction", "com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$d", "i", "Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$d;", "mActionR", "com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$e;", "mFetcher", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "mSendMsgInterceptor", "<init>", "D", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOSendMsgVMDelegate implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, com.tencent.qqnt.aio.interceptor.sendmsg.b, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> E;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.interceptor.sendmsg.a mSendMsgInterceptor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int aiBusinessFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mFetcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$a;", "", "", "enableCheckEmojiLength$delegate", "Lkotlin/Lazy;", "b", "()Z", "enableCheckEmojiLength", "", "AI_BUSINESS_TYPE_DRAW", "I", "AI_BUSINESS_TYPE_NONE", "AI_BUSINESS_TYPE_PROMPT_FUNCTION", "AI_BUSINESS_TYPE_SEARCH", "AI_BUSINESS_TYPE_WRITE", "", "NEED_CLEAR_INPUT_BEFORE_SWITCH", "Ljava/lang/String;", "NEW_LINE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIOSendMsgVMDelegate.E.getValue()).booleanValue();
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$b", "Lcom/tencent/mobileqq/album/ext/b;", "", "Lcom/tencent/mobileqq/album/media/c;", ForwardMiniChooseFriendOption.RESULT_LIST, "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.album.ext.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<com.tencent.mobileqq.album.media.c>> f189853a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f189854b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.i f189855c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOSendMsgVMDelegate f189856d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<f.e> f189857e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.input.d f189858f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Bundle f189859g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f189860h;

        b(Ref.ObjectRef<List<com.tencent.mobileqq.album.media.c>> objectRef, Ref.BooleanRef booleanRef, d.i iVar, AIOSendMsgVMDelegate aIOSendMsgVMDelegate, List<? extends f.e> list, com.tencent.mobileqq.aio.input.d dVar, Bundle bundle, String str) {
            this.f189853a = objectRef;
            this.f189854b = booleanRef;
            this.f189855c = iVar;
            this.f189856d = aIOSendMsgVMDelegate;
            this.f189857e = list;
            this.f189858f = dVar;
            this.f189859g = bundle;
            this.f189860h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, objectRef, booleanRef, iVar, aIOSendMsgVMDelegate, list, dVar, bundle, str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.album.ext.b
        public void a(@NotNull List<com.tencent.mobileqq.album.media.c> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) results);
                return;
            }
            Intrinsics.checkNotNullParameter(results, "results");
            QLog.i("AIOSendMsgVMDelegate", 1, "[combineArgsAndSendMix] onResponse result size:" + results.size());
            if (!(!results.isEmpty())) {
                this.f189856d.g0(this.f189857e, this.f189858f, this.f189853a.element, this.f189854b.element, this.f189859g, this.f189860h);
                return;
            }
            this.f189853a.element = results;
            this.f189854b.element = this.f189855c.a();
            this.f189856d.g0(this.f189857e, this.f189858f, this.f189853a.element, this.f189854b.element, this.f189859g, this.f189860h);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOSendMsgVMDelegate.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            } else {
                Intrinsics.checkNotNullParameter(intent, "intent");
                AIOSendMsgVMDelegate.this.I(intent);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOSendMsgVMDelegate.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return AIOSendMsgVMDelegate.this.K(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate$e", "", "", "d", "", "Lcom/tencent/mobileqq/aio/input/f$e;", "b", "", "memberUid", "memberUin", "nickName", "a", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOSendMsgVMDelegate.this);
            }
        }

        @Nullable
        public final CharSequence a(@NotNull String memberUid, @NotNull String memberUin, @NotNull String nickName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, this, memberUid, memberUin, nickName);
            }
            Intrinsics.checkNotNullParameter(memberUid, "memberUid");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            return AIOSendMsgVMDelegate.this.getMHost().fetchVBState(new d.C7258d(memberUid, memberUin, nickName, false, 8, null)).b().getCharSequence("at_member_span");
        }

        @NotNull
        public final List<f.e> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            o.a aVar = new o.a(null, 1, null);
            AIOSendMsgVMDelegate.this.getMHost().fetchVBState(aVar);
            return aVar.a();
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            String string = AIOSendMsgVMDelegate.this.getMHost().fetchVBState(o.c.f189551a).b().getString("input_callback_data", "");
            Intrinsics.checkNotNullExpressionValue(string, "mHost.fetchVBState(Input\u2026CK_DATA, \"\"\n            )");
            return string;
        }

        @NotNull
        public final CharSequence d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            CharSequence charSequence = AIOSendMsgVMDelegate.this.getMHost().fetchVBState(o.d.f189552a).b().getCharSequence("input_text", "");
            Intrinsics.checkNotNullExpressionValue(charSequence, "mHost.fetchVBState(Input\u2026UT_TEXT, \"\"\n            )");
            return charSequence;
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOSendMsgVMDelegate$Companion$enableCheckEmojiLength$2.INSTANCE);
        E = lazy;
    }

    public AIOSendMsgVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mAction = new c();
        this.mActionR = new d();
        this.mFetcher = new e();
    }

    private final HashMap<Integer, MsgAttributeInfo> A(String callbackData) {
        MsgAttributeInfo a16;
        int i3 = this.aiBusinessFlag;
        if (i3 == 0) {
            return new HashMap<>();
        }
        int i16 = 2;
        if (i3 == 2) {
            AIOInputUtil.f189159a.n(this.mFetcher.c());
        } else {
            i16 = 3;
            if (i3 == 3) {
                AIOInputUtil.f189159a.o(this.mFetcher.c());
            } else {
                i16 = 1;
            }
        }
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        ToBotData toBotData = new ToBotData();
        toBotData.msgScene.set(i16);
        if (callbackData != null) {
            toBotData.callbackData.set(callbackData);
        }
        a16 = com.tencent.qqnt.kernel.util.a.f359256a.a(16, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : null, (i16 & 512) != 0 ? null : null, (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : new AdelieMsgAttr(0L, 1L, toBotData.toByteArray()), (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        hashMap.put(16, a16);
        QLog.i("AIOSendMsgVMDelegate", 1, "[generateMsgAttributeInfo]: toBotData with aiBusinessFlag = " + this.aiBusinessFlag);
        return hashMap;
    }

    static /* synthetic */ void A0(AIOSendMsgVMDelegate aIOSendMsgVMDelegate, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        aIOSendMsgVMDelegate.z0(str, str2);
    }

    private final AnonymousExtInfo B(String gId) {
        GroupAnonymousInfo anonymousInfo;
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null || (anonymousInfo = e16.getAnonymousInfo(gId)) == null || !anonymousInfo.isAnonymousChat) {
            return null;
        }
        return new AnonymousExtInfo(0, anonymousInfo.anonyId, anonymousInfo.anonyNick, anonymousInfo.headPicIndex, anonymousInfo.expiredTime, anonymousInfo.bubbleId, anonymousInfo.rankColor);
    }

    private final void B0(AIOElementType.j item) {
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.f(item), null, null, null, 14, null);
    }

    private final void C0(int type) {
        this.aiBusinessFlag = type;
        QLog.i("AIOSendMsgVMDelegate", 1, "[SetAIBusinessFlag]: type = " + type);
    }

    private final List<com.tencent.mobileqq.aio.msg.data.a> E(List<? extends f.e> texts) {
        ArrayList arrayList = new ArrayList();
        for (f.e eVar : texts) {
            if (!(eVar instanceof f.d)) {
                arrayList.addAll(y.f194180a.b(eVar));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(List<com.tencent.mobileqq.aio.msg.data.a> elements, Bundle bundle, Long msgUniqueId, String callbackData) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.qqnt.aio.interceptor.sendmsg.d dVar = null;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        com.tencent.aio.msgservice.k kVar = new com.tencent.aio.msgservice.k(aVar.g().r(), elements);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (msgUniqueId != null) {
            bundle.putLong("msg_id", msgUniqueId.longValue());
        }
        com.tencent.qqnt.aio.interceptor.sendmsg.a aVar3 = this.mSendMsgInterceptor;
        if (aVar3 != null) {
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar4;
            }
            dVar = aVar3.intercept(new com.tencent.qqnt.aio.interceptor.sendmsg.c(kVar, aVar2, bundle, SendMsgInterceptUtil.f193678a.a(kVar)));
        }
        boolean z16 = false;
        if (dVar != null && dVar.b()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("AIOSendMsgVMDelegate", 1, "sendMsg is intercepted, peer=" + kVar.a().c() + ", element=" + kVar.b());
            if (dVar.a()) {
                r(bundle);
                return;
            }
            return;
        }
        a0(kVar, bundle, msgUniqueId, callbackData);
        r(bundle);
    }

    private final List<com.tencent.mobileqq.aio.msg.data.a> F(List<? extends f.e> texts, com.tencent.mobileqq.aio.input.d replyData) {
        ArrayList arrayList = new ArrayList();
        if (replyData != null) {
            com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(7, 0, 2, null);
            aVar.s(new AIOElementType.g(replyData.a(), replyData.b(), replyData.c(), replyData.d()));
            arrayList.add(aVar);
        }
        int size = texts.size();
        for (int i3 = 0; i3 < size; i3++) {
            f.e eVar = texts.get(i3);
            if (eVar instanceof f.d) {
                f.d dVar = (f.d) eVar;
                arrayList.addAll(com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, dVar.g(), dVar.f(), dVar.h(), 0, null, null, null, false, 248, null));
            } else if ((i3 != texts.size() - 1 || !Intrinsics.areEqual(eVar.d(), "\n") || i3 <= 0 || !(texts.get(i3 - 1) instanceof f.d)) && (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_insert_image_905_116748503", true) || !Intrinsics.areEqual(eVar.d(), "\n") || i3 <= 0 || !(texts.get(i3 - 1) instanceof f.d) || i3 >= texts.size() - 1 || !(texts.get(i3 + 1) instanceof f.d))) {
                arrayList.addAll(y.f194180a.b(eVar));
            }
        }
        return arrayList;
    }

    static /* synthetic */ void F0(AIOSendMsgVMDelegate aIOSendMsgVMDelegate, List list, Bundle bundle, Long l3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        aIOSendMsgVMDelegate.E0(list, bundle, l3, str);
    }

    private final Bundle G(int clearInputStatus, boolean isSetEssence) {
        Bundle bundle = new Bundle();
        bundle.putInt("clearInputStatus", clearInputStatus);
        bundle.putBoolean("key_is_set_essence", isSetEssence);
        bundle.putCharSequence("input_text", new StringBuilder(this.mFetcher.d()));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(MsgIntent event) {
        if (event instanceof AIOMsgSendEvent.InputSendEvent) {
            T();
            return;
        }
        if (event instanceof AIOMsgSendEvent.MediaSendEvent) {
            W((AIOMsgSendEvent.MediaSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.CameraVideoSendEvent) {
            AIOMsgSendEvent.CameraVideoSendEvent cameraVideoSendEvent = (AIOMsgSendEvent.CameraVideoSendEvent) event;
            Y(cameraVideoSendEvent.b(), cameraVideoSendEvent.a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SendAlbumMixEvent) {
            AIOMsgSendEvent.SendAlbumMixEvent sendAlbumMixEvent = (AIOMsgSendEvent.SendAlbumMixEvent) event;
            S(sendAlbumMixEvent.a(), sendAlbumMixEvent.b(), sendAlbumMixEvent.c());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SendAlbumMediaEvent) {
            AIOMsgSendEvent.SendAlbumMediaEvent sendAlbumMediaEvent = (AIOMsgSendEvent.SendAlbumMediaEvent) event;
            R(sendAlbumMediaEvent.a(), sendAlbumMediaEvent.b(), sendAlbumMediaEvent.c());
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttSendEvent) {
            u0((AIOMsgSendEvent.PttSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttFakeSendEvent) {
            i0((AIOMsgSendEvent.PttFakeSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttFakeCancelEvent) {
            q((AIOMsgSendEvent.PttFakeCancelEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.MarketFaceSendEvent) {
            k0(((AIOMsgSendEvent.MarketFaceSendEvent) event).a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.TextSendEvent) {
            A0(this, ((AIOMsgSendEvent.TextSendEvent) event).a(), null, 2, null);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PicEmotionSendEvent) {
            X((AIOMsgSendEvent.PicEmotionSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.EmojiFaceSendEvent) {
            V((AIOMsgSendEvent.EmojiFaceSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.ChainStickerSendEvent) {
            U((AIOMsgSendEvent.ChainStickerSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.MsgOnClickRecallMsgsEvent) {
            P((AIOMsgSendEvent.MsgOnClickRecallMsgsEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.AtMsgSendEvent) {
            L((AIOMsgSendEvent.AtMsgSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.FileSendEvent) {
            j0(((AIOMsgSendEvent.FileSendEvent) event).a());
            return;
        }
        if (event instanceof PokeMsgEvent.PokeSendEvent) {
            t0(((PokeMsgEvent.PokeSendEvent) event).a());
            return;
        }
        if (event instanceof FaceBubbleMsgEvent.FaceBubbleSendEvent) {
            h0(((FaceBubbleMsgEvent.FaceBubbleSendEvent) event).a());
            return;
        }
        if (event instanceof ZPlanMsgEvent.SendActionEvent) {
            B0(((ZPlanMsgEvent.SendActionEvent) event).a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SetAIBusinessFlag) {
            C0(((AIOMsgSendEvent.SetAIBusinessFlag) event).a());
        } else if (event instanceof AIOMsgSendEvent.SendTextWithCallbackData) {
            AIOMsgSendEvent.SendTextWithCallbackData sendTextWithCallbackData = (AIOMsgSendEvent.SendTextWithCallbackData) event;
            z0(sendTextWithCallbackData.b(), sendTextWithCallbackData.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k K(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgSendEvent.GetInterceptResendEvent) {
            return N(((AIOMsgSendEvent.GetInterceptResendEvent) msgIntent).a());
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void L(AIOMsgSendEvent.AtMsgSendEvent intent) {
        boolean z16;
        CharSequence a16 = this.mFetcher.a(intent.c(), intent.d(), intent.b());
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AIOSendMsgVMDelegate", 1, "create null at span with event " + intent);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a16).append((CharSequence) intent.a());
        l lVar = l.f194165a;
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "spannableStringBuilder.toString()");
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "spannableStringBuilder");
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.j(lVar.a(spannableStringBuilder2, spannableStringBuilder), null), null, null, null, 12, null);
    }

    private final k N(com.tencent.aio.data.msglist.a msgItem) {
        boolean z16;
        com.tencent.qqnt.aio.interceptor.sendmsg.a aVar = this.mSendMsgInterceptor;
        if (aVar != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            z16 = aVar.interceptResend(aVar2, msgItem);
        } else {
            z16 = false;
        }
        return new a.C7242a(z16);
    }

    private final void P(AIOMsgSendEvent.MsgOnClickRecallMsgsEvent intent) {
        final MsgRecord a16 = intent.a();
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(a16.chatType, a16.peerUid, ""), a16.msgId, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.input.sendmsg.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                AIOSendMsgVMDelegate.Q(AIOSendMsgVMDelegate.this, a16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AIOSendMsgVMDelegate this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        QLog.i("AIOSendMsgVMDelegate", 1, "handleReeditRecallMsg(res:" + i3 + ", errMsg:" + str);
        com.tencent.aio.api.runtime.a aVar = this$0.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.UpdateReeditRecallMsgListEvent(msgItem));
    }

    private final void R(List<com.tencent.mobileqq.album.media.c> data, boolean quality, boolean isFlashPic) {
        v0(data, quality, false, isFlashPic);
    }

    private final void S(List<com.tencent.mobileqq.album.media.c> data, boolean quality, String text) {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new f.e(text, 0, 0L, 0L, null, 30, null));
        m0(this, listOf, null, data, quality, false, null, "handleSendAlbumMediaMix", null, 128, null);
    }

    private final void T() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOSendMsgVMDelegate", 1, "handleSendBtnClicked");
        }
        if (t()) {
            return;
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.INSTANCE.a(IQQHodorPrefApi.class)).collectTrackInfo("inputSendButton_send_business");
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(AIOMsgSendEvent.SendBeforeEvent.f188472d);
        x();
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new AIOMsgSendEvent.SendAfterEvent(new SpannableString(this.mFetcher.d())));
    }

    private final void U(AIOMsgSendEvent.ChainStickerSendEvent event) {
        List listOf;
        AIOElementType.b a16 = y.f194180a.a(event.a(), true);
        if (QLog.isColorLevel()) {
            QLog.d("AIOSendMsgVMDelegate", 2, "[handleSendChainSticker] serverId=" + a16.e() + ", randomType=" + a16.q());
        }
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
        aVar.m(a16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        o0(this, listOf, null, null, null, 14, null);
    }

    private final void V(AIOMsgSendEvent.EmojiFaceSendEvent event) {
        List listOf;
        AIOElementType.b a16 = y.f194180a.a(event.a(), event.b());
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
        aVar.m(a16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        o0(this, listOf, null, null, null, 14, null);
    }

    private final void W(AIOMsgSendEvent.MediaSendEvent event) {
        a.C7282a c7282a;
        com.tencent.mobileqq.aio.input.d dVar;
        List<f.e> emptyList;
        List<com.tencent.mobileqq.album.media.c> b16 = event.b();
        boolean d16 = event.d();
        boolean c16 = event.c();
        boolean a16 = event.a();
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputReplyMsgIntent.GetReplyData.f189808d);
        if (k3 instanceof a.C7282a) {
            c7282a = (a.C7282a) k3;
        } else {
            c7282a = null;
        }
        if (c7282a != null) {
            dVar = c7282a.a();
        } else {
            dVar = null;
        }
        if (!c16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else if (t()) {
            return;
        } else {
            emptyList = this.mFetcher.b();
        }
        m0(this, emptyList, dVar, b16, d16, a16, G(c16 ? 1 : 0, false), "handleSendMedia", null, 128, null);
    }

    private final void X(AIOMsgSendEvent.PicEmotionSendEvent event) {
        s0(event.b(), event.d(), event.e(), event.c(), event.a());
    }

    private final void Y(String videoPath, String thumbPath) {
        x0(videoPath, null, 1, false, thumbPath);
    }

    private final boolean Z(List<? extends f.e> inputElements) {
        Iterator<T> it = inputElements.iterator();
        while (it.hasNext()) {
            if (((f.e) it.next()) instanceof f.d) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r14 != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a0(com.tencent.aio.msgservice.k sendMsgsReq, Bundle extData, Long msgUniqueId, String callbackData) {
        long j3;
        com.tencent.qqnt.aio.interceptor.sendmsg.a aVar;
        com.tencent.aio.api.runtime.a aVar2;
        com.tencent.aio.api.runtime.a aVar3 = null;
        if (msgUniqueId == null) {
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                com.tencent.aio.api.runtime.a aVar4 = this.mContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar4 = null;
                }
                msgUniqueId = e16.j0(aVar4.g().r().c().e());
            }
            j3 = 0;
            long j16 = j3;
            aVar = this.mSendMsgInterceptor;
            if (aVar != null) {
                aVar.reportBeforeKernelSend(true, j16);
            }
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.x(sendMsgsReq, j16, A(callbackData)), new AIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(this, j16, sendMsgsReq, extData, null)), Dispatchers.getIO()), getMHost().vmScope());
            aVar2 = this.mContext;
            if (aVar2 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar3 = aVar2;
            }
            aVar3.e().h(AIOMsgSendEvent.AfterSendMsg.f188416d);
        }
        j3 = msgUniqueId.longValue();
        long j162 = j3;
        aVar = this.mSendMsgInterceptor;
        if (aVar != null) {
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.x(sendMsgsReq, j162, A(callbackData)), new AIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(this, j162, sendMsgsReq, extData, null)), Dispatchers.getIO()), getMHost().vmScope());
        aVar2 = this.mContext;
        if (aVar2 != null) {
        }
        aVar3.e().h(AIOMsgSendEvent.AfterSendMsg.f188416d);
    }

    private final boolean b0() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("fake_ptt_9035_122327484", true);
    }

    private final boolean c0(List<com.tencent.mobileqq.album.media.c> mediaList, ArrayList<com.tencent.mobileqq.aio.msg.data.a> elements, boolean quality) {
        boolean z16;
        for (com.tencent.mobileqq.album.media.c cVar : mediaList) {
            String a16 = cVar.a();
            if (a16 != null && a16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e("AIOSendMsgVMDelegate", 1, "sendMix|mediaList has null args");
                return false;
            }
            elements.add(com.tencent.mobileqq.aio.msg.data.b.l(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), quality, 0, null, null, 56, null));
        }
        return true;
    }

    private final boolean e0() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_need_clear_input_before_905_117866383", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> mediaList, boolean quality, Bundle extData, String callbackData) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        if (com.tencent.mobileqq.aio.utils.o.a(aVar.g().r()).chatType == 8) {
            r0(inputElements, replyData, mediaList, quality, extData);
            return;
        }
        if (mediaList == null) {
            mediaList = CollectionsKt__CollectionsKt.emptyList();
        }
        l0(inputElements, replyData, mediaList, quality, false, extData, "combineArgsAndSendMix", callbackData);
    }

    private final void h0(FaceBubbleElement item) {
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.h(item), null, null, null, 14, null);
    }

    private final void i0(AIOMsgSendEvent.PttFakeSendEvent event) {
        MsgRecord msgRecord;
        List<com.tencent.mobileqq.aio.msg.data.a> d16 = com.tencent.mobileqq.aio.msg.data.b.f190166a.d(event.e(), event.c(), event.b(), event.a(), event.h(), event.g(), event.f());
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOContact c16 = aVar.g().r().c();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (b0()) {
            msgRecord = new MsgRecord();
            msgRecord.msgId = event.d();
            AIOUtil aIOUtil = AIOUtil.f194084a;
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar3 = null;
            }
            msgRecord.msgSeq = aIOUtil.k(aVar3);
            msgRecord.chatType = c16.e();
            msgRecord.msgType = 6;
            msgRecord.sendType = 1;
            msgRecord.senderUid = peekAppRuntime.getCurrentUid();
            msgRecord.peerUid = c16.j();
            msgRecord.msgTime = System.currentTimeMillis() / 1000;
            msgRecord.sendStatus = 2;
            msgRecord.elements = AIOObjectTransform.m(AIOObjectTransform.f194080a, d16, 0, 2, null);
            msgRecord.peerName = c16.g();
            msgRecord.senderUin = peekAppRuntime.getLongAccountUin();
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar4 = null;
            }
            AIOParam g16 = aVar4.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            msgRecord.peerUin = su3.c.a(g16);
            msgRecord.msgAttrs = z();
            msgRecord.anonymousExtInfo = msgRecord.getAnonymousExtInfo();
        } else {
            long d17 = event.d();
            AIOUtil aIOUtil2 = AIOUtil.f194084a;
            com.tencent.aio.api.runtime.a aVar5 = this.mContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar5 = null;
            }
            long k3 = aIOUtil2.k(aVar5);
            int e16 = c16.e();
            String currentUid = peekAppRuntime.getCurrentUid();
            String j3 = c16.j();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            aVar2 = null;
            ArrayList m3 = AIOObjectTransform.m(AIOObjectTransform.f194080a, d16, 0, 2, null);
            String g17 = c16.g();
            long longAccountUin = peekAppRuntime.getLongAccountUin();
            com.tencent.aio.api.runtime.a aVar6 = this.mContext;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar6 = null;
            }
            AIOParam g18 = aVar6.g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            msgRecord = new MsgRecord(d17, 0L, k3, 0L, e16, 6, 0, 1, currentUid, j3, "", "", 0L, 0L, 0L, currentTimeMillis, null, 2, "", "", "", "", "", m3, null, null, 0L, 0, null, g17, null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, longAccountUin, su3.c.a(g18), z(), B(c16.j()), 0, 0, null, null, 0, null);
        }
        com.tencent.aio.api.runtime.a aVar7 = this.mContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar7;
        }
        aVar2.e().h(new AIOMsgListEvent.OnAddPttFakeMsg(msgRecord));
    }

    private final void j0(String path) {
        long j3;
        Long j06;
        List<com.tencent.mobileqq.aio.msg.data.a> i3 = com.tencent.mobileqq.aio.msg.data.b.f190166a.i(path);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        Contact a16 = com.tencent.mobileqq.aio.utils.o.a(aVar.g().r());
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null && (j06 = e16.j0(a16.chatType)) != null) {
            j3 = j06.longValue();
        } else {
            j3 = 0;
        }
        ((IAIOFileErrHandler) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileErrHandler.class)).registerFileIdListen(j3, a16);
        o0(this, i3, null, Long.valueOf(j3), null, 8, null);
    }

    private final void k0(MarkFaceMessage marketFaceMessage) {
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.a(marketFaceMessage), null, null, null, 12, null);
    }

    private final void l0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> selectedMediaList, boolean quality, boolean fromCamera, Bundle extData, String source, String callbackData) {
        QLog.d("AIOSendMsgVMDelegate", 1, source + " sendMix size:" + selectedMediaList.size() + " inputSize:" + inputElements.size() + " fromCamera:" + fromCamera);
        com.tencent.aio.api.runtime.a aVar = null;
        if (((!inputElements.isEmpty()) && replyData != null) || Z(inputElements)) {
            ArrayList<com.tencent.mobileqq.aio.msg.data.a> arrayList = new ArrayList<>();
            arrayList.addAll(F(inputElements, replyData));
            if (!selectedMediaList.isEmpty()) {
                if (y(selectedMediaList)) {
                    if (c0(selectedMediaList, arrayList, quality)) {
                        n0(arrayList, extData, null, callbackData);
                    }
                } else {
                    n0(arrayList, extData, null, callbackData);
                    v0(selectedMediaList, quality, fromCamera, false);
                }
                com.tencent.aio.api.runtime.a aVar2 = this.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    aVar = aVar2;
                }
                aVar.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
                return;
            }
            n0(arrayList, extData, null, callbackData);
            return;
        }
        ArrayList<com.tencent.mobileqq.aio.msg.data.a> arrayList2 = new ArrayList<>();
        arrayList2.addAll(E(inputElements));
        if ((!arrayList2.isEmpty()) && selectedMediaList.isEmpty()) {
            n0(arrayList2, extData, null, callbackData);
            return;
        }
        if (arrayList2.isEmpty() && (!selectedMediaList.isEmpty())) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
            v0(selectedMediaList, quality, fromCamera, false);
            return;
        }
        if ((!arrayList2.isEmpty()) && (!selectedMediaList.isEmpty())) {
            if (y(selectedMediaList)) {
                if (c0(selectedMediaList, arrayList2, quality)) {
                    com.tencent.aio.api.runtime.a aVar4 = this.mContext;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        aVar4 = null;
                    }
                    aVar4.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
                    n0(arrayList2, extData, null, callbackData);
                    return;
                }
                return;
            }
            com.tencent.aio.api.runtime.a aVar5 = this.mContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar5 = null;
            }
            aVar5.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
            n0(arrayList2, extData, null, callbackData);
            v0(selectedMediaList, quality, fromCamera, false);
        }
    }

    static /* synthetic */ void m0(AIOSendMsgVMDelegate aIOSendMsgVMDelegate, List list, com.tencent.mobileqq.aio.input.d dVar, List list2, boolean z16, boolean z17, Bundle bundle, String str, String str2, int i3, Object obj) {
        Bundle bundle2;
        String str3;
        String str4;
        if ((i3 & 32) != 0) {
            bundle2 = null;
        } else {
            bundle2 = bundle;
        }
        if ((i3 & 64) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 128) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        aIOSendMsgVMDelegate.l0(list, dVar, list2, z16, z17, bundle2, str3, str4);
    }

    private final void n0(List<com.tencent.mobileqq.aio.msg.data.a> elements, Bundle extData, Long msgUniqueId, String callbackData) {
        if (elements.isEmpty()) {
            QLog.i("AIOSendMsgVMDelegate", 1, "[sendMsg] elements is empty");
            return;
        }
        if (s(elements)) {
            QLog.i("AIOSendMsgVMDelegate", 1, "[sendMsg] checkInputEmojiLengthLimit true");
            return;
        }
        w(extData);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            BuildersKt__Builders_commonKt.launch$default(getMHost().vmScope(), Dispatchers.getIO(), null, new AIOSendMsgVMDelegate$sendMsg$1(this, elements, extData, msgUniqueId, callbackData, null), 2, null);
        } else {
            E0(elements, extData, msgUniqueId, callbackData);
        }
    }

    static /* synthetic */ void o0(AIOSendMsgVMDelegate aIOSendMsgVMDelegate, List list, Bundle bundle, Long l3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        aIOSendMsgVMDelegate.n0(list, bundle, l3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int result, String errMsg) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgSendEvent.OnMsgSendFailEvent(result, errMsg));
    }

    private final void q(AIOMsgSendEvent.PttFakeCancelEvent event) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.OnCancelPttFakeMsg(event.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(long msgId, com.tencent.aio.msgservice.k sendMsgsReq, Bundle extData) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        CharSequence charSequence = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        j e16 = aVar.e();
        if (extData != null) {
            charSequence = extData.getCharSequence("input_text");
        }
        e16.h(new AIOMsgSendEvent.OnMsgSendSuccessEvent(msgId, sendMsgsReq, charSequence, extData));
    }

    private final void r(final Bundle extData) {
        if (!e0()) {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(extData) { // from class: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$checkAndClearInputContent$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bundle $extData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$extData = extData;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOSendMsgVMDelegate.this, (Object) extData);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AIOSendMsgVMDelegate.this.v(this.$extData);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private final void r0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> selectedMediaList, boolean quality, Bundle extData) {
        List emptyList;
        boolean z16;
        int collectionSizeOrDefault;
        boolean z17;
        boolean z18;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        m0(this, inputElements, replyData, emptyList, quality, false, extData, "combineArgsAndSendMix", null, 128, null);
        List<com.tencent.mobileqq.album.media.c> list = selectedMediaList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<com.tencent.mobileqq.album.media.c> list2 = selectedMediaList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((com.tencent.mobileqq.album.media.c) obj).d() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                arrayList.add(obj);
            }
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (arrayList.size() >= 4) {
            ArrayList<com.tencent.mobileqq.album.media.c> arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (((com.tencent.mobileqq.album.media.c) obj2).d() != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList2.add(obj2);
                }
            }
            for (com.tencent.mobileqq.album.media.c cVar : arrayList2) {
                QLog.d("AIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar.a());
                IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                com.tencent.aio.api.runtime.a aVar2 = this.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar2 = null;
                }
                String j3 = aVar2.g().r().c().j();
                String a16 = cVar.a();
                Intrinsics.checkNotNull(a16);
                iMyComputerHelpApi.myComputerSendFileFromPhoto(j3, a16);
            }
            QLog.d("AIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendMultiFileFromPhoto: " + selectedMediaList.size());
            IMyComputerHelpApi iMyComputerHelpApi2 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar3 = null;
            }
            String j16 = aVar3.g().r().c().j();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String a17 = ((com.tencent.mobileqq.album.media.c) it.next()).a();
                Intrinsics.checkNotNull(a17);
                arrayList3.add(a17);
            }
            iMyComputerHelpApi2.myComputerSendMultiFileFromPhoto(j16, arrayList3);
        } else {
            for (com.tencent.mobileqq.album.media.c cVar2 : list2) {
                QLog.d("AIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar2.a());
                IMyComputerHelpApi iMyComputerHelpApi3 = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                com.tencent.aio.api.runtime.a aVar4 = this.mContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar4 = null;
                }
                String j17 = aVar4.g().r().c().j();
                String a18 = cVar2.a();
                Intrinsics.checkNotNull(a18);
                iMyComputerHelpApi3.myComputerSendFileFromPhoto(j17, a18);
            }
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar5;
        }
        aVar.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
    }

    private final boolean s(List<com.tencent.mobileqq.aio.msg.data.a> elements) {
        if (!INSTANCE.b()) {
            return false;
        }
        int i3 = 0;
        int i16 = 0;
        for (com.tencent.mobileqq.aio.msg.data.a aVar : elements) {
            if (aVar.a() == 6) {
                i3++;
            } else if (aVar.a() == 1) {
                i16 += aVar.j().f().length();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOSendMsgVMDelegate", 2, "checkInputEmojiLengthLimit emojiCount:" + i3 + ", textLength:" + i16);
        }
        if (i16 + (i3 * 3) <= AIOEditText.INSTANCE.a()) {
            return false;
        }
        H0(AIOSendMsgUIState.ShowInputOverLengthToast.f189843d);
        return true;
    }

    private final void s0(String path, int subType, String textSummary, com.tencent.qqnt.msg.data.g picExtBizInfo, final String originalMd5) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOSendMsgVMDelegate", 2, "[sendPicEmotion] subType=" + subType + " path=" + path + " textSummary=" + textSummary);
        }
        o0(this, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, path, null, true, subType, textSummary, picExtBizInfo, new Function1<AIOElementType.e, Unit>(originalMd5) { // from class: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$sendPicEmotion$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $originalMd5;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$originalMd5 = originalMd5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) originalMd5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOElementType.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOElementType.e getElementFromPic) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getElementFromPic);
                    return;
                }
                Intrinsics.checkNotNullParameter(getElementFromPic, "$this$getElementFromPic");
                String str = this.$originalMd5;
                if (str != null) {
                    getElementFromPic.m(str);
                }
            }
        }, false, 128, null), null, null, null, 12, null);
    }

    private final boolean t() {
        if (this.mFetcher.d().length() > AIOEditText.INSTANCE.a()) {
            H0(AIOSendMsgUIState.ShowInputOverLengthToast.f189843d);
            return true;
        }
        return false;
    }

    private final void t0(AIOElementType.b item) {
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.g(item), null, null, null, 14, null);
    }

    private final void u() {
        String str;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOSendMsgVMDelegate", 1, "[clearEditContent] start");
        }
        H0(InputEditTextUIState.ClearEditTextContentUIState.f189472d);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(InputReplyMsgIntent.ClearReplyData.f189807d);
        SimpleEventBus.getInstance().dispatchEvent(new InputChangeEvent("", str));
    }

    private final void u0(AIOMsgSendEvent.PttSendEvent event) {
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.d(event.e(), event.c(), event.b(), event.a(), event.h(), event.g(), event.f()), null, event.d(), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Bundle extData) {
        int i3;
        if (extData != null) {
            i3 = extData.getInt("clearInputStatus");
        } else {
            i3 = 0;
        }
        if (i3 != 0 && (i3 & 1) == 1) {
            u();
        }
    }

    private final void v0(final List<com.tencent.mobileqq.album.media.c> mediaList, final boolean quality, final boolean fromCamera, final boolean isFlashPic) {
        QLog.d("AIOSendMsgVMDelegate", 1, "sendRichMsgOneByOne size:" + mediaList.size() + " fromCamera:" + fromCamera + " isFlashPic:" + isFlashPic);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.input.sendmsg.e
            @Override // java.lang.Runnable
            public final void run() {
                AIOSendMsgVMDelegate.w0(mediaList, this, fromCamera, quality, isFlashPic);
            }
        }, 64, null, false);
    }

    private final void w(final Bundle extData) {
        if (!e0()) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            v(extData);
        } else {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(extData) { // from class: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$clearInputInMainThread$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bundle $extData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$extData = extData;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOSendMsgVMDelegate.this, (Object) extData);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AIOSendMsgVMDelegate.this.v(this.$extData);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(List mediaList, AIOSendMsgVMDelegate this$0, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        int i3;
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = mediaList.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            final com.tencent.mobileqq.album.media.c cVar = (com.tencent.mobileqq.album.media.c) it.next();
            String a16 = cVar.a();
            if (a16 != null && a16.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                QLog.w("AIOSendMsgVMDelegate", 1, "[sendRichMsgListOneByOne] path is empty");
            } else if (i.b(a16)) {
                QLog.w("AIOSendMsgVMDelegate", 1, "[sendRichMsgListOneByOne] file is 0B");
                i16++;
            } else {
                com.tencent.aio.api.runtime.a aVar = this$0.mContext;
                com.tencent.aio.api.runtime.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                if (aVar.g().r().c().e() == 8) {
                    QLog.d("AIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar.a());
                    IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
                    com.tencent.aio.api.runtime.a aVar3 = this$0.mContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        aVar2 = aVar3;
                    }
                    String j3 = aVar2.g().r().c().j();
                    String a17 = cVar.a();
                    Intrinsics.checkNotNull(a17);
                    iMyComputerHelpApi.myComputerSendFileFromPhoto(j3, a17);
                } else {
                    int d16 = cVar.d();
                    if (d16 != 0) {
                        if (d16 != 1) {
                            F0(this$0, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), z17, 0, null, null, null, false, 248, null), null, null, null, 12, null);
                        } else {
                            this$0.x0(a16, cVar.c(), this$0.H(z16), z17, cVar.e());
                        }
                    } else {
                        if (com.tencent.qqnt.util.bitmap.a.f362978a.b(new File(a16))) {
                            i3 = 11;
                        } else {
                            i3 = 0;
                        }
                        F0(this$0, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), z17, i3, null, null, new Function1<AIOElementType.e, Unit>() { // from class: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$sendRichMsgOneByOne$1$1$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.album.media.c.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AIOElementType.e eVar) {
                                invoke2(eVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull AIOElementType.e getElementFromPic) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getElementFromPic);
                                    return;
                                }
                                Intrinsics.checkNotNullParameter(getElementFromPic, "$this$getElementFromPic");
                                String b16 = com.tencent.mobileqq.album.media.c.this.b();
                                if (b16 == null) {
                                    b16 = "";
                                }
                                getElementFromPic.m(b16);
                            }
                        }, z18, 48, null), null, null, null, 12, null);
                    }
                }
            }
        }
        if (i16 != 0) {
            QLog.d("AIOSendMsgVMDelegate", 1, "invalidNum: " + i16 + " size: " + mediaList.size());
        }
        if (i16 == mediaList.size()) {
            i.d();
        }
    }

    private final void x() {
        a.C7282a c7282a;
        com.tencent.mobileqq.aio.input.d dVar;
        d.i iVar;
        List<f.e> b16 = this.mFetcher.b();
        String c16 = this.mFetcher.c();
        Bundle G = G(1, false);
        G.putBoolean("from_send_btn", true);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputReplyMsgIntent.GetReplyData.f189808d);
        if (k3 instanceof a.C7282a) {
            c7282a = (a.C7282a) k3;
        } else {
            c7282a = null;
        }
        if (c7282a != null) {
            dVar = c7282a.a();
        } else {
            dVar = null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        k k16 = aVar2.e().k(InputEvent.GetSelectMediaInfo.f188576d);
        if (k16 instanceof d.i) {
            iVar = (d.i) k16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            WrapLocalMediaInfoKt.g(iVar.b(), new b(objectRef, booleanRef, iVar, this, b16, dVar, G, c16));
        } else {
            g0(b16, dVar, (List) objectRef.element, booleanRef.element, G, c16);
        }
    }

    private final void x0(final String path, final Uri uri, final int businessType, final boolean quality, final String thumbPath) {
        final Function0<Unit> function0 = new Function0<Unit>(path, uri, businessType, quality, thumbPath, this) { // from class: com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate$sendSingleVideo$doSend$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $businessType;
            final /* synthetic */ String $path;
            final /* synthetic */ boolean $quality;
            final /* synthetic */ String $thumbPath;
            final /* synthetic */ Uri $uri;
            final /* synthetic */ AIOSendMsgVMDelegate this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$path = path;
                this.$uri = uri;
                this.$businessType = businessType;
                this.$quality = quality;
                this.$thumbPath = thumbPath;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, path, uri, Integer.valueOf(businessType), Boolean.valueOf(quality), thumbPath, this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                com.tencent.qqnt.aio.interceptor.sendmsg.a aVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                List<com.tencent.mobileqq.aio.msg.data.a> e16 = com.tencent.mobileqq.aio.msg.data.b.f190166a.e(this.$path, this.$uri, this.$businessType, this.$quality, this.$thumbPath);
                aVar = this.this$0.mContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                com.tencent.aio.msgservice.k kVar = new com.tencent.aio.msgservice.k(aVar.g().r(), e16);
                aVar2 = this.this$0.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar2 = null;
                }
                com.tencent.qqnt.aio.interceptor.sendmsg.c cVar = new com.tencent.qqnt.aio.interceptor.sendmsg.c(kVar, aVar2, null, SendMsgInterceptUtil.f193678a.a(kVar));
                aVar3 = this.this$0.mSendMsgInterceptor;
                com.tencent.qqnt.aio.interceptor.sendmsg.d intercept = aVar3 != null ? aVar3.intercept(cVar) : null;
                boolean z16 = false;
                if (intercept != null && intercept.b()) {
                    z16 = true;
                }
                if (z16) {
                    QLog.i("AIOSendMsgVMDelegate", 1, "sendSingleVideo intercepted, peer=" + kVar.a().c() + ", element=" + kVar.b());
                    return;
                }
                AIOMsgService.f190196a.d(kVar);
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            function0.invoke();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.input.sendmsg.g
                @Override // java.lang.Runnable
                public final void run() {
                    AIOSendMsgVMDelegate.y0(Function0.this);
                }
            }, 16, null, false);
        }
    }

    private final boolean y(List<com.tencent.mobileqq.album.media.c> list) {
        boolean z16;
        List<com.tencent.mobileqq.album.media.c> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((com.tencent.mobileqq.album.media.c) it.next()).d() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function0 doSend) {
        Intrinsics.checkNotNullParameter(doSend, "$doSend");
        doSend.invoke();
    }

    private final HashMap<Integer, MsgAttributeInfo> z() {
        MsgAttributeInfo a16;
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        com.tencent.qqnt.kernel.util.a aVar = com.tencent.qqnt.kernel.util.a.f359256a;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        com.tencent.aio.api.runtime.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        AIOParam g16 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        a16 = aVar.a(7, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : null, (i16 & 512) != 0 ? null : new UinInfoAttr(Long.valueOf(su3.c.a(g16))), (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : null, (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        hashMap.put(7, a16);
        IVasAIOSendDataUtilApi iVasAIOSendDataUtilApi = (IVasAIOSendDataUtilApi) QRoute.api(IVasAIOSendDataUtilApi.class);
        AIOUtil aIOUtil = AIOUtil.f194084a;
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar3 = aVar4;
        }
        iVasAIOSendDataUtilApi.detailVasMsgDataAttrs(hashMap, aIOUtil.h(aVar3.g().r()), 4);
        return hashMap;
    }

    private final void z0(String text, String callbackData) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) text);
        l lVar = l.f194165a;
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "sb.toString()");
        o0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.j(lVar.a(spannableStringBuilder2, spannableStringBuilder), null), null, null, callbackData, 4, null);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void H0(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7284a) {
            T();
        }
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.b
    public void a(@Nullable com.tencent.qqnt.aio.interceptor.sendmsg.a interceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) interceptor);
        } else {
            this.mSendMsgInterceptor = interceptor;
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return a.class;
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.i("AIOSendMsgVMDelegate", 2, "[onCreate]: aioContext=" + context.hashCode());
        }
        this.mContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().l(this, this.mActionR);
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.InputSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MediaSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.CameraVideoSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAlbumMixEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAlbumMediaEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttFakeSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttFakeCancelEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MarketFaceSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.TextSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PicEmotionSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.EmojiFaceSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.ChainStickerSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickRecallMsgsEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AtMsgSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.FileSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.PokeMsgEvent.PokeSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.FaceBubbleMsgEvent.FaceBubbleSendEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ZPlanMsgEvent.SendActionEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SetAIBusinessFlag");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendTextWithCallbackData");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.GetInterceptResendEvent");
        return hashSet;
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().e(this);
    }

    private final int H(boolean fromCamera) {
        return fromCamera ? 1 : 0;
    }
}
