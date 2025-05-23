package com.tencent.mobileqq.aio.robot.sendmsg;

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
import com.tencent.mobileqq.aio.input.sendmsg.robot.ExtData;
import com.tencent.mobileqq.aio.input.sendmsg.robot.ToBotData;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.i;
import com.tencent.mobileqq.aio.utils.l;
import com.tencent.mobileqq.aio.utils.y;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
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
import com.tencent.qqnt.robot.api.IRobotServiceApi;
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
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@Metadata(d1 = {"\u0000\u00c4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\b*\u0006\u00aa\u0001\u00ae\u0001\u00b2\u0001\b\u0007\u0018\u0000 \u009c\u00012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u00072\u00020\b:\u0002\u0094\u0001B\u0012\u0012\u0007\u0010\u00a0\u0001\u001a\u00020\u0005\u00a2\u0006\u0006\b\u00b8\u0001\u0010\u009f\u0001J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0016\u0010 \u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J&\u0010.\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0002J&\u00100\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020&H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u00102\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u00112\u0006\u00102\u001a\u000204H\u0002Jb\u0010?\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\f\u0010:\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u0016\u0010@\u001a\u00020\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001dH\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060\u001dH\u0002J&\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u000108H\u0002J6\u0010G\u001a\u00020\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0Ej\b\u0012\u0004\u0012\u00020\u001e`F2\u0006\u0010,\u001a\u00020\u001bH\u0002J\b\u0010H\u001a\u00020\u001bH\u0002J\u0012\u0010I\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J.\u0010J\u001a\u00020\u00112\f\u0010D\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0002J\u0010\u0010K\u001a\u00020!2\u0006\u0010;\u001a\u00020\u001bH\u0002J4\u0010P\u001a\u00020\u00112\u0006\u0010L\u001a\u00020&2\b\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010O\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010&H\u0002J6\u0010V\u001a\u00020\u00112\u0006\u0010L\u001a\u00020&2\u0006\u0010Q\u001a\u00020!2\b\u0010R\u001a\u0004\u0018\u00010&2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010U\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010X\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020WH\u0002J\u0010\u0010Z\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020YH\u0002J\b\u0010[\u001a\u00020\u001bH\u0002J$\u0010_\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020]`^H\u0002J\u0014\u0010b\u001a\u0004\u0018\u00010a2\b\u0010`\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020cH\u0002J\u0010\u0010g\u001a\u00020\u00112\u0006\u0010f\u001a\u00020eH\u0002J\u001c\u0010h\u001a\u00020\u00112\u0006\u0010/\u001a\u00020&2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010i\u001a\u00020\u00112\u0006\u0010L\u001a\u00020&H\u0002J\u0010\u0010l\u001a\u00020\u00112\u0006\u0010k\u001a\u00020jH\u0002J\u0010\u0010n\u001a\u00020\u00112\u0006\u0010k\u001a\u00020mH\u0002J\u0010\u0010p\u001a\u00020\u00112\u0006\u0010k\u001a\u00020oH\u0002JA\u0010s\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\bs\u0010tJA\u0010v\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\bv\u0010tJ\u0012\u0010w\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J9\u0010z\u001a\u00020\u00112\u0006\u0010y\u001a\u00020x2\b\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\bz\u0010{J\u0012\u0010|\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\b\u0010}\u001a\u00020\u0011H\u0002J\"\u0010\u007f\u001a\u00020\u00112\u0006\u0010~\u001a\u00020q2\u0006\u0010y\u001a\u00020x2\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\u001d\u0010\u0082\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020!2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010&H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0084\u0001\u001a\u00020\u0011H\u0002JO\u0010\u0085\u0001\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002JE\u0010\u0086\u0001\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u001d2\b\u00109\u001a\u0004\u0018\u0001082\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u001bH\u0002J\u0013\u0010\u0088\u0001\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020\u00112\u0007\u0010\u0089\u0001\u001a\u00020!H\u0002J1\u0010\u008b\u0001\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020]`^2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010\u008d\u0001\u001a\u00020\u00112\u0006\u0010+\u001a\u00020&2\u0007\u0010\u008c\u0001\u001a\u00020\u001bH\u0002J\u0011\u0010\u008e\u0001\u001a\u00020\u00112\u0006\u0010+\u001a\u00020&H\u0002J\u001b\u0010\u0091\u0001\u001a\u00020\u00112\u0007\u0010\u008f\u0001\u001a\u00020\u00042\u0007\u0010\u0090\u0001\u001a\u00020\u001bH\u0016J\u0015\u0010\u0094\u0001\u001a\u00020\u00112\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\u0011\u0010\u0095\u0001\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0002H\u0016J\u0011\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0011H\u0016R)\u0010\u00a0\u0001\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010\u00a3\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a5\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a4\u0001\u0010KR)\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00a6\u00010Ej\t\u0012\u0005\u0012\u00030\u00a6\u0001`F8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0018\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0017\u0010\u00b4\u0001\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bb\u0010\u00b3\u0001R\u001c\u0010\u00b7\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u00a8\u0006\u00b9\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/b;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "L", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "O", "event", "", "K", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$EmojiFaceSendEvent;", "W", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$ChainStickerSendEvent;", "V", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PicEmotionSendEvent;", "Y", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MediaSendEvent;", "X", "", "u", "", "Lcom/tencent/mobileqq/aio/msg/data/a;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "t", "", "clearInputStatus", "isSetEssence", "Landroid/os/Bundle;", "H", "", "videoPath", "thumbPath", "Z", "Lcom/tencent/mobileqq/album/media/c;", "data", CustomImageProps.QUALITY, "isFlashPic", ExifInterface.LATITUDE_SOUTH, "text", "T", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnClickRecallMsgsEvent;", "intent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$AtMsgSendEvent;", "N", "Lcom/tencent/mobileqq/aio/input/f$e;", "inputElements", "Lcom/tencent/mobileqq/aio/input/d;", "replyData", "selectedMediaList", "fromCamera", "extData", "source", "callbackData", "o0", "a0", "texts", UserInfo.SEX_FEMALE, "G", "mediaList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f0", "e0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y0", "I", "path", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "businessType", "A0", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "originalMd5", "v0", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "x0", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeSendEvent;", "l0", "c0", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "gId", "Lcom/tencent/qqnt/kernel/nativeinterface/AnonymousExtInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeCancelEvent;", "r", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "n0", "C0", "m0", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "w0", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "k0", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "E0", "", "msgUniqueId", "q0", "(Ljava/util/List;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/String;)V", "bundle", "H0", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/msgservice/k;", "sendMsgsReq", "b0", "(Lcom/tencent/aio/msgservice/k;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/String;)V", "w", "v", "msgId", "t0", "result", "errMsg", "s0", "U", "y", "i0", "u0", "g0", HippyTKDListViewAdapter.X, "type", "F0", "B", "disposable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j0", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "h0", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "interceptor", "a", "P", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/sendmsg/a;", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "E", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "G0", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "e", "Lcom/tencent/aio/api/runtime/a;", "mContext", "f", "aiBusinessFlag", "Lcom/tencent/mobileqq/aio/input/sendmsg/robot/a;", h.F, "Ljava/util/ArrayList;", "botExtDataList", "com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$c", "i", "Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$c;", "mAction", "com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$d;", "mActionR", "com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$e", "Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$e;", "mFetcher", "D", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "mSendMsgInterceptor", "<init>", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIOSendMsgVMDelegate implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, com.tencent.qqnt.aio.interceptor.sendmsg.b, g {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Boolean> F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final e mFetcher;

    /* renamed from: D, reason: from kotlin metadata */
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
    private final ArrayList<ExtData> botExtDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$a;", "", "", "enableCheckEmojiLength$delegate", "Lkotlin/Lazy;", "b", "()Z", "enableCheckEmojiLength", "", "NEED_CLEAR_INPUT_BEFORE_SWITCH", "Ljava/lang/String;", "NEW_LINE", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) RobotAIOSendMsgVMDelegate.F.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$b", "Lcom/tencent/mobileqq/album/ext/b;", "", "Lcom/tencent/mobileqq/album/media/c;", ForwardMiniChooseFriendOption.RESULT_LIST, "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.album.ext.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<com.tencent.mobileqq.album.media.c>> f193587a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f193588b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.i f193589c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RobotAIOSendMsgVMDelegate f193590d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<f.e> f193591e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.input.d f193592f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Bundle f193593g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f193594h;

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.ObjectRef<List<com.tencent.mobileqq.album.media.c>> objectRef, Ref.BooleanRef booleanRef, d.i iVar, RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, List<? extends f.e> list, com.tencent.mobileqq.aio.input.d dVar, Bundle bundle, String str) {
            this.f193587a = objectRef;
            this.f193588b = booleanRef;
            this.f193589c = iVar;
            this.f193590d = robotAIOSendMsgVMDelegate;
            this.f193591e = list;
            this.f193592f = dVar;
            this.f193593g = bundle;
            this.f193594h = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.album.ext.b
        public void a(@NotNull List<com.tencent.mobileqq.album.media.c> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            QLog.i("RobotAIOSendMsgVMDelegate", 1, "[combineArgsAndSendMix] onResponse result size:" + results.size());
            if (!(!results.isEmpty())) {
                this.f193590d.i0(this.f193591e, this.f193592f, this.f193587a.element, this.f193588b.element, this.f193593g, this.f193594h);
                return;
            }
            this.f193587a.element = results;
            this.f193588b.element = this.f193589c.a();
            this.f193590d.i0(this.f193591e, this.f193592f, this.f193587a.element, this.f193588b.element, this.f193593g, this.f193594h);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            RobotAIOSendMsgVMDelegate.this.K(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        d() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return RobotAIOSendMsgVMDelegate.this.L(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/aio/robot/sendmsg/RobotAIOSendMsgVMDelegate$e", "", "", "d", "", "Lcom/tencent/mobileqq/aio/input/f$e;", "b", "", "memberUid", "memberUin", "nickName", "a", "c", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e {
        e() {
        }

        @Nullable
        public final CharSequence a(@NotNull String memberUid, @NotNull String memberUin, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(memberUid, "memberUid");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            return RobotAIOSendMsgVMDelegate.this.getMHost().fetchVBState(new d.C7258d(memberUid, memberUin, nickName, false, 8, null)).b().getCharSequence("at_member_span");
        }

        @NotNull
        public final List<f.e> b() {
            o.a aVar = new o.a(null, 1, null);
            RobotAIOSendMsgVMDelegate.this.getMHost().fetchVBState(aVar);
            return aVar.a();
        }

        @NotNull
        public final String c() {
            String string = RobotAIOSendMsgVMDelegate.this.getMHost().fetchVBState(o.c.f189551a).b().getString("input_callback_data", "");
            Intrinsics.checkNotNullExpressionValue(string, "mHost.fetchVBState(Input\u2026CK_DATA, \"\"\n            )");
            return string;
        }

        @NotNull
        public final CharSequence d() {
            CharSequence charSequence = RobotAIOSendMsgVMDelegate.this.getMHost().fetchVBState(o.d.f189552a).b().getCharSequence("input_text", "");
            Intrinsics.checkNotNullExpressionValue(charSequence, "mHost.fetchVBState(Input\u2026UT_TEXT, \"\"\n            )");
            return charSequence;
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$Companion$enableCheckEmojiLength$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_check_emoji_length_8898_113609903", true));
            }
        });
        F = lazy;
    }

    public RobotAIOSendMsgVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.botExtDataList = new ArrayList<>();
        this.mAction = new c();
        this.mActionR = new d();
        this.mFetcher = new e();
    }

    private final HashMap<Integer, MsgAttributeInfo> A() {
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

    private final void A0(final String path, final Uri uri, final int businessType, final boolean quality, final String thumbPath) {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$sendSingleVideo$doSend$1
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
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                com.tencent.qqnt.aio.interceptor.sendmsg.a aVar3;
                List<com.tencent.mobileqq.aio.msg.data.a> e16 = com.tencent.mobileqq.aio.msg.data.b.f190166a.e(path, uri, businessType, quality, thumbPath);
                aVar = this.mContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                com.tencent.aio.msgservice.k kVar = new com.tencent.aio.msgservice.k(aVar.g().r(), e16);
                aVar2 = this.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar2 = null;
                }
                com.tencent.qqnt.aio.interceptor.sendmsg.c cVar = new com.tencent.qqnt.aio.interceptor.sendmsg.c(kVar, aVar2, null, SendMsgInterceptUtil.f193678a.a(kVar));
                aVar3 = this.mSendMsgInterceptor;
                com.tencent.qqnt.aio.interceptor.sendmsg.d intercept = aVar3 != null ? aVar3.intercept(cVar) : null;
                boolean z16 = false;
                if (intercept != null && intercept.b()) {
                    z16 = true;
                }
                if (z16) {
                    QLog.i("RobotAIOSendMsgVMDelegate", 1, "sendSingleVideo intercepted, peer=" + kVar.a().c() + ", element=" + kVar.b());
                    return;
                }
                AIOMsgService.f190196a.d(kVar);
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            function0.invoke();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.f
                @Override // java.lang.Runnable
                public final void run() {
                    RobotAIOSendMsgVMDelegate.B0(Function0.this);
                }
            }, 16, null, false);
        }
    }

    private final HashMap<Integer, MsgAttributeInfo> B(String callbackData) {
        int i3;
        MsgAttributeInfo a16;
        String joinToString$default;
        if (this.aiBusinessFlag == 0 && this.botExtDataList.isEmpty()) {
            return new HashMap<>();
        }
        int i16 = this.aiBusinessFlag;
        if (i16 == 1) {
            i3 = 1;
        } else {
            i3 = 2;
            if (i16 == 2) {
                AIOInputUtil.f189159a.n(this.mFetcher.c());
            } else {
                i3 = 3;
                if (i16 == 3) {
                    AIOInputUtil.f189159a.o(this.mFetcher.c());
                } else {
                    i3 = 4;
                    if (i16 != 4) {
                        i3 = 0;
                    }
                }
            }
        }
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        ToBotData toBotData = new ToBotData();
        toBotData.msgScene.set(i3);
        if (callbackData != null) {
            toBotData.callbackData.set(callbackData);
        }
        if (!this.botExtDataList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<ExtData> it = this.botExtDataList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "botExtDataList.iterator()");
            while (it.hasNext()) {
                ExtData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                ExtData extData = next;
                arrayList.add(extData.getData());
                if (extData.getIsDisposable()) {
                    it.remove();
                }
            }
            toBotData.extDatas.set(arrayList);
            int size = arrayList.size();
            List<String> list = toBotData.extDatas.get();
            Intrinsics.checkNotNullExpressionValue(list, "extDatas.get()");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null);
            QLog.d("RobotAIOSendMsgVMDelegate", 1, "[generateMsgAttributeInfo] extData size=" + size + ", extData=" + joinToString$default);
        }
        a16 = com.tencent.qqnt.kernel.util.a.f359256a.a(16, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : null, (i16 & 512) != 0 ? null : null, (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : new AdelieMsgAttr(0L, 1L, toBotData.toByteArray()), (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        hashMap.put(16, a16);
        QLog.i("RobotAIOSendMsgVMDelegate", 1, "[generateMsgAttributeInfo]: toBotData with aiBusinessFlag = " + this.aiBusinessFlag);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(Function0 doSend) {
        Intrinsics.checkNotNullParameter(doSend, "$doSend");
        doSend.invoke();
    }

    private final AnonymousExtInfo C(String gId) {
        GroupAnonymousInfo anonymousInfo;
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null || (anonymousInfo = e16.getAnonymousInfo(gId)) == null || !anonymousInfo.isAnonymousChat) {
            return null;
        }
        return new AnonymousExtInfo(0, anonymousInfo.anonyId, anonymousInfo.anonyNick, anonymousInfo.headPicIndex, anonymousInfo.expiredTime, anonymousInfo.bubbleId, anonymousInfo.rankColor);
    }

    private final void C0(String text, String callbackData) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) text);
        l lVar = l.f194165a;
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "sb.toString()");
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.j(lVar.a(spannableStringBuilder2, spannableStringBuilder), null), null, null, callbackData, 4, null);
    }

    static /* synthetic */ void D0(RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        robotAIOSendMsgVMDelegate.C0(str, str2);
    }

    private final void E0(AIOElementType.j item) {
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.f(item), null, null, null, 14, null);
    }

    private final List<com.tencent.mobileqq.aio.msg.data.a> F(List<? extends f.e> texts) {
        ArrayList arrayList = new ArrayList();
        for (f.e eVar : texts) {
            if (!(eVar instanceof f.d)) {
                arrayList.addAll(y.f194180a.b(eVar));
            }
        }
        return arrayList;
    }

    private final void F0(int type) {
        this.aiBusinessFlag = type;
        QLog.i("RobotAIOSendMsgVMDelegate", 1, "[SetAIBusinessFlag]: type = " + type);
    }

    private final List<com.tencent.mobileqq.aio.msg.data.a> G(List<? extends f.e> texts, com.tencent.mobileqq.aio.input.d replyData) {
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

    private final Bundle H(int clearInputStatus, boolean isSetEssence) {
        Bundle bundle = new Bundle();
        bundle.putInt("clearInputStatus", clearInputStatus);
        bundle.putBoolean("key_is_set_essence", isSetEssence);
        bundle.putCharSequence("input_text", new StringBuilder(this.mFetcher.d()));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(List<com.tencent.mobileqq.aio.msg.data.a> elements, Bundle bundle, Long msgUniqueId, String callbackData) {
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
            QLog.i("RobotAIOSendMsgVMDelegate", 1, "sendMsg is intercepted, peer=" + kVar.a().c() + ", element=" + kVar.b());
            if (dVar.a()) {
                s(bundle);
                return;
            }
            return;
        }
        b0(kVar, bundle, msgUniqueId, callbackData);
        s(bundle);
    }

    static /* synthetic */ void I0(RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, List list, Bundle bundle, Long l3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        robotAIOSendMsgVMDelegate.H0(list, bundle, l3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(MsgIntent event) {
        if (event instanceof AIOMsgSendEvent.InputSendEvent) {
            U();
            return;
        }
        if (event instanceof AIOMsgSendEvent.MediaSendEvent) {
            X((AIOMsgSendEvent.MediaSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.CameraVideoSendEvent) {
            AIOMsgSendEvent.CameraVideoSendEvent cameraVideoSendEvent = (AIOMsgSendEvent.CameraVideoSendEvent) event;
            Z(cameraVideoSendEvent.b(), cameraVideoSendEvent.a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SendAlbumMixEvent) {
            AIOMsgSendEvent.SendAlbumMixEvent sendAlbumMixEvent = (AIOMsgSendEvent.SendAlbumMixEvent) event;
            T(sendAlbumMixEvent.a(), sendAlbumMixEvent.b(), sendAlbumMixEvent.c());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SendAlbumMediaEvent) {
            AIOMsgSendEvent.SendAlbumMediaEvent sendAlbumMediaEvent = (AIOMsgSendEvent.SendAlbumMediaEvent) event;
            S(sendAlbumMediaEvent.a(), sendAlbumMediaEvent.b(), sendAlbumMediaEvent.c());
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttSendEvent) {
            x0((AIOMsgSendEvent.PttSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttFakeSendEvent) {
            l0((AIOMsgSendEvent.PttFakeSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PttFakeCancelEvent) {
            r((AIOMsgSendEvent.PttFakeCancelEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.MarketFaceSendEvent) {
            n0(((AIOMsgSendEvent.MarketFaceSendEvent) event).a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.TextSendEvent) {
            D0(this, ((AIOMsgSendEvent.TextSendEvent) event).a(), null, 2, null);
            return;
        }
        if (event instanceof AIOMsgSendEvent.PicEmotionSendEvent) {
            Y((AIOMsgSendEvent.PicEmotionSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.EmojiFaceSendEvent) {
            W((AIOMsgSendEvent.EmojiFaceSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.ChainStickerSendEvent) {
            V((AIOMsgSendEvent.ChainStickerSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.MsgOnClickRecallMsgsEvent) {
            Q((AIOMsgSendEvent.MsgOnClickRecallMsgsEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.AtMsgSendEvent) {
            N((AIOMsgSendEvent.AtMsgSendEvent) event);
            return;
        }
        if (event instanceof AIOMsgSendEvent.FileSendEvent) {
            m0(((AIOMsgSendEvent.FileSendEvent) event).a());
            return;
        }
        if (event instanceof PokeMsgEvent.PokeSendEvent) {
            w0(((PokeMsgEvent.PokeSendEvent) event).a());
            return;
        }
        if (event instanceof FaceBubbleMsgEvent.FaceBubbleSendEvent) {
            k0(((FaceBubbleMsgEvent.FaceBubbleSendEvent) event).a());
            return;
        }
        if (event instanceof ZPlanMsgEvent.SendActionEvent) {
            E0(((ZPlanMsgEvent.SendActionEvent) event).a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SetAIBusinessFlag) {
            F0(((AIOMsgSendEvent.SetAIBusinessFlag) event).a());
            return;
        }
        if (event instanceof AIOMsgSendEvent.SendTextWithCallbackData) {
            AIOMsgSendEvent.SendTextWithCallbackData sendTextWithCallbackData = (AIOMsgSendEvent.SendTextWithCallbackData) event;
            C0(sendTextWithCallbackData.b(), sendTextWithCallbackData.a());
        } else if (event instanceof AIOMsgSendEvent.AddBotExtData) {
            AIOMsgSendEvent.AddBotExtData addBotExtData = (AIOMsgSendEvent.AddBotExtData) event;
            q(addBotExtData.a(), addBotExtData.b());
        } else if (event instanceof AIOMsgSendEvent.RemoveBotExtData) {
            j0(((AIOMsgSendEvent.RemoveBotExtData) event).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k L(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgSendEvent.GetInterceptResendEvent) {
            return O(((AIOMsgSendEvent.GetInterceptResendEvent) msgIntent).a());
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void N(AIOMsgSendEvent.AtMsgSendEvent intent) {
        boolean z16;
        CharSequence a16 = this.mFetcher.a(intent.c(), intent.d(), intent.b());
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotAIOSendMsgVMDelegate", 1, "create null at span with event " + intent);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a16).append((CharSequence) intent.a());
        l lVar = l.f194165a;
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "spannableStringBuilder.toString()");
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "spannableStringBuilder");
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.j(lVar.a(spannableStringBuilder2, spannableStringBuilder), null), null, null, null, 12, null);
    }

    private final k O(com.tencent.aio.data.msglist.a msgItem) {
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

    private final void Q(AIOMsgSendEvent.MsgOnClickRecallMsgsEvent intent) {
        final MsgRecord a16 = intent.a();
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(a16.chatType, a16.peerUid, ""), a16.msgId, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotAIOSendMsgVMDelegate.R(RobotAIOSendMsgVMDelegate.this, a16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(RobotAIOSendMsgVMDelegate this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        QLog.i("RobotAIOSendMsgVMDelegate", 1, "handleReeditRecallMsg(res:" + i3 + ", errMsg:" + str);
        com.tencent.aio.api.runtime.a aVar = this$0.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.UpdateReeditRecallMsgListEvent(msgItem));
    }

    private final void S(List<com.tencent.mobileqq.album.media.c> data, boolean quality, boolean isFlashPic) {
        y0(data, quality, false, isFlashPic);
    }

    private final void T(List<com.tencent.mobileqq.album.media.c> data, boolean quality, String text) {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new f.e(text, 0, 0L, 0L, null, 30, null));
        p0(this, listOf, null, data, quality, false, null, "handleSendAlbumMediaMix", null, 128, null);
    }

    private final void U() {
        if (QLog.isColorLevel()) {
            QLog.d("RobotAIOSendMsgVMDelegate", 1, "handleSendBtnClicked");
        }
        if (u()) {
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
        y();
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new AIOMsgSendEvent.SendAfterEvent(new SpannableString(this.mFetcher.d())));
    }

    private final void V(AIOMsgSendEvent.ChainStickerSendEvent event) {
        List listOf;
        AIOElementType.b a16 = y.f194180a.a(event.a(), true);
        if (QLog.isColorLevel()) {
            QLog.d("RobotAIOSendMsgVMDelegate", 2, "[handleSendChainSticker] serverId=" + a16.e() + ", randomType=" + a16.q());
        }
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
        aVar.m(a16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        r0(this, listOf, null, null, null, 14, null);
    }

    private final void W(AIOMsgSendEvent.EmojiFaceSendEvent event) {
        List listOf;
        AIOElementType.b a16 = y.f194180a.a(event.a(), event.b());
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
        aVar.m(a16);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        r0(this, listOf, null, null, null, 14, null);
    }

    private final void X(AIOMsgSendEvent.MediaSendEvent event) {
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
        } else if (u()) {
            return;
        } else {
            emptyList = this.mFetcher.b();
        }
        p0(this, emptyList, dVar, b16, d16, a16, H(c16 ? 1 : 0, false), "handleSendMedia", null, 128, null);
    }

    private final void Y(AIOMsgSendEvent.PicEmotionSendEvent event) {
        v0(event.b(), event.d(), event.e(), event.c(), event.a());
    }

    private final void Z(String videoPath, String thumbPath) {
        A0(videoPath, null, 1, false, thumbPath);
    }

    private final boolean a0(List<? extends f.e> inputElements) {
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
    private final void b0(com.tencent.aio.msgservice.k sendMsgsReq, Bundle extData, Long msgUniqueId, String callbackData) {
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
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.x(sendMsgsReq, j16, B(callbackData)), new RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(this, j16, sendMsgsReq, extData, null)), Dispatchers.getIO()), getMHost().vmScope());
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
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.x(sendMsgsReq, j162, B(callbackData)), new RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(this, j162, sendMsgsReq, extData, null)), Dispatchers.getIO()), getMHost().vmScope());
        aVar2 = this.mContext;
        if (aVar2 != null) {
        }
        aVar3.e().h(AIOMsgSendEvent.AfterSendMsg.f188416d);
    }

    private final boolean c0() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("fake_ptt_9035_122327484", true);
    }

    private final boolean e0() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        long a16 = su3.c.a(g16);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(aVar2.g().r().c().e()));
    }

    private final boolean f0(List<com.tencent.mobileqq.album.media.c> mediaList, ArrayList<com.tencent.mobileqq.aio.msg.data.a> elements, boolean quality) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.album.media.c cVar : mediaList) {
            String a16 = cVar.a();
            if (a16 != null && a16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e("RobotAIOSendMsgVMDelegate", 1, "sendMix|mediaList has null args");
                return false;
            }
            arrayList.add(com.tencent.mobileqq.aio.msg.data.b.l(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), quality, 0, null, null, 56, null));
        }
        if (e0()) {
            elements.addAll(0, arrayList);
        } else {
            elements.addAll(arrayList);
        }
        return true;
    }

    private final boolean g0() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_need_clear_input_before_905_117866383", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> mediaList, boolean quality, Bundle extData, String callbackData) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        if (com.tencent.mobileqq.aio.utils.o.a(aVar.g().r()).chatType == 8) {
            u0(inputElements, replyData, mediaList, quality, extData);
            return;
        }
        if (mediaList == null) {
            mediaList = CollectionsKt__CollectionsKt.emptyList();
        }
        o0(inputElements, replyData, mediaList, quality, false, extData, "combineArgsAndSendMix", callbackData);
    }

    private final void j0(String data) {
        Iterator<ExtData> it = this.botExtDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "botExtDataList.iterator()");
        while (it.hasNext()) {
            ExtData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (Intrinsics.areEqual(next.getData(), data)) {
                it.remove();
            }
        }
        QLog.d("RobotAIOSendMsgVMDelegate", 1, "[removeBotExtData] data=" + data);
    }

    private final void k0(FaceBubbleElement item) {
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.h(item), null, null, null, 14, null);
    }

    private final void l0(AIOMsgSendEvent.PttFakeSendEvent event) {
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
        if (c0()) {
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
            msgRecord.msgAttrs = A();
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
            msgRecord = new MsgRecord(d17, 0L, k3, 0L, e16, 6, 0, 1, currentUid, j3, "", "", 0L, 0L, 0L, currentTimeMillis, null, 2, "", "", "", "", "", m3, null, null, 0L, 0, null, g17, null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, longAccountUin, su3.c.a(g18), A(), C(c16.j()), 0, 0, null, null, 0, null);
        }
        com.tencent.aio.api.runtime.a aVar7 = this.mContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar7;
        }
        aVar2.e().h(new AIOMsgListEvent.OnAddPttFakeMsg(msgRecord));
    }

    private final void m0(String path) {
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
        r0(this, i3, null, Long.valueOf(j3), null, 8, null);
    }

    private final void n0(MarkFaceMessage marketFaceMessage) {
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.a(marketFaceMessage), null, null, null, 12, null);
    }

    private final void o0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> selectedMediaList, boolean quality, boolean fromCamera, Bundle extData, String source, String callbackData) {
        QLog.d("RobotAIOSendMsgVMDelegate", 1, source + " sendMix size:" + selectedMediaList.size() + " inputSize:" + inputElements.size() + " fromCamera:" + fromCamera);
        com.tencent.aio.api.runtime.a aVar = null;
        if (((!inputElements.isEmpty()) && replyData != null) || a0(inputElements)) {
            ArrayList<com.tencent.mobileqq.aio.msg.data.a> arrayList = new ArrayList<>();
            arrayList.addAll(G(inputElements, replyData));
            if (!selectedMediaList.isEmpty()) {
                if (z(selectedMediaList)) {
                    if (f0(selectedMediaList, arrayList, quality)) {
                        q0(arrayList, extData, null, callbackData);
                    }
                } else {
                    q0(arrayList, extData, null, callbackData);
                    y0(selectedMediaList, quality, fromCamera, false);
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
            q0(arrayList, extData, null, callbackData);
            return;
        }
        ArrayList<com.tencent.mobileqq.aio.msg.data.a> arrayList2 = new ArrayList<>();
        arrayList2.addAll(F(inputElements));
        if ((!arrayList2.isEmpty()) && selectedMediaList.isEmpty()) {
            q0(arrayList2, extData, null, callbackData);
            return;
        }
        if (!e0() && arrayList2.isEmpty() && (!selectedMediaList.isEmpty())) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
            y0(selectedMediaList, quality, fromCamera, false);
            return;
        }
        if (e0() || ((!arrayList2.isEmpty()) && (!selectedMediaList.isEmpty()))) {
            if (z(selectedMediaList)) {
                if (f0(selectedMediaList, arrayList2, quality)) {
                    com.tencent.aio.api.runtime.a aVar4 = this.mContext;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        aVar4 = null;
                    }
                    aVar4.e().h(PhotoPanelEvent.ClearSelectedMidia.f188679d);
                    q0(arrayList2, extData, null, callbackData);
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
            q0(arrayList2, extData, null, callbackData);
            y0(selectedMediaList, quality, fromCamera, false);
        }
    }

    static /* synthetic */ void p0(RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, List list, com.tencent.mobileqq.aio.input.d dVar, List list2, boolean z16, boolean z17, Bundle bundle, String str, String str2, int i3, Object obj) {
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
        robotAIOSendMsgVMDelegate.o0(list, dVar, list2, z16, z17, bundle2, str3, str4);
    }

    private final void q(String data, boolean disposable) {
        Iterator<ExtData> it = this.botExtDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "botExtDataList.iterator()");
        while (it.hasNext()) {
            ExtData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (Intrinsics.areEqual(next.getData(), data)) {
                it.remove();
            }
        }
        this.botExtDataList.add(new ExtData(data, disposable));
        QLog.d("RobotAIOSendMsgVMDelegate", 1, "[addBotExtData] data=" + data + " disposable=" + disposable);
    }

    private final void q0(List<com.tencent.mobileqq.aio.msg.data.a> elements, Bundle extData, Long msgUniqueId, String callbackData) {
        if (elements.isEmpty()) {
            QLog.i("RobotAIOSendMsgVMDelegate", 1, "[sendMsg] elements is empty");
            return;
        }
        if (t(elements)) {
            QLog.i("RobotAIOSendMsgVMDelegate", 1, "[sendMsg] checkInputEmojiLengthLimit true");
            return;
        }
        x(extData);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            BuildersKt__Builders_commonKt.launch$default(getMHost().vmScope(), Dispatchers.getIO(), null, new RobotAIOSendMsgVMDelegate$sendMsg$1(this, elements, extData, msgUniqueId, callbackData, null), 2, null);
        } else {
            H0(elements, extData, msgUniqueId, callbackData);
        }
    }

    private final void r(AIOMsgSendEvent.PttFakeCancelEvent event) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgListEvent.OnCancelPttFakeMsg(event.a()));
    }

    static /* synthetic */ void r0(RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, List list, Bundle bundle, Long l3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        robotAIOSendMsgVMDelegate.q0(list, bundle, l3, str);
    }

    private final void s(final Bundle extData) {
        if (!g0()) {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$checkAndClearInputContent$1
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
                    RobotAIOSendMsgVMDelegate.this.w(extData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(int result, String errMsg) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new AIOMsgSendEvent.OnMsgSendFailEvent(result, errMsg));
    }

    private final boolean t(List<com.tencent.mobileqq.aio.msg.data.a> elements) {
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
            QLog.i("RobotAIOSendMsgVMDelegate", 2, "checkInputEmojiLengthLimit emojiCount:" + i3 + ", textLength:" + i16);
        }
        if (i16 + (i3 * 3) <= AIOEditText.INSTANCE.a()) {
            return false;
        }
        K0(AIOSendMsgUIState.ShowInputOverLengthToast.f189843d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(long msgId, com.tencent.aio.msgservice.k sendMsgsReq, Bundle extData) {
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

    private final boolean u() {
        if (this.mFetcher.d().length() > AIOEditText.INSTANCE.a()) {
            K0(AIOSendMsgUIState.ShowInputOverLengthToast.f189843d);
            return true;
        }
        return false;
    }

    private final void u0(List<? extends f.e> inputElements, com.tencent.mobileqq.aio.input.d replyData, List<com.tencent.mobileqq.album.media.c> selectedMediaList, boolean quality, Bundle extData) {
        List emptyList;
        boolean z16;
        int collectionSizeOrDefault;
        boolean z17;
        boolean z18;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        p0(this, inputElements, replyData, emptyList, quality, false, extData, "combineArgsAndSendMix", null, 128, null);
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
                QLog.d("RobotAIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar.a());
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
            QLog.d("RobotAIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendMultiFileFromPhoto: " + selectedMediaList.size());
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
                QLog.d("RobotAIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar2.a());
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

    private final void v() {
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
            QLog.i("RobotAIOSendMsgVMDelegate", 1, "[clearEditContent] start");
        }
        K0(InputEditTextUIState.ClearEditTextContentUIState.f189472d);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(InputReplyMsgIntent.ClearReplyData.f189807d);
        SimpleEventBus.getInstance().dispatchEvent(new InputChangeEvent("", str));
    }

    private final void v0(String path, int subType, String textSummary, com.tencent.qqnt.msg.data.g picExtBizInfo, final String originalMd5) {
        if (QLog.isColorLevel()) {
            QLog.d("RobotAIOSendMsgVMDelegate", 2, "[sendPicEmotion] subType=" + subType + " path=" + path + " textSummary=" + textSummary);
        }
        r0(this, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, path, null, true, subType, textSummary, picExtBizInfo, new Function1<AIOElementType.e, Unit>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$sendPicEmotion$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOElementType.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOElementType.e getElementFromPic) {
                Intrinsics.checkNotNullParameter(getElementFromPic, "$this$getElementFromPic");
                String str = originalMd5;
                if (str != null) {
                    getElementFromPic.m(str);
                }
            }
        }, false, 128, null), null, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Bundle extData) {
        int i3;
        if (extData != null) {
            i3 = extData.getInt("clearInputStatus");
        } else {
            i3 = 0;
        }
        if (i3 != 0 && (i3 & 1) == 1) {
            v();
        }
    }

    private final void w0(AIOElementType.b item) {
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.g(item), null, null, null, 14, null);
    }

    private final void x(final Bundle extData) {
        if (!g0()) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            w(extData);
        } else {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$clearInputInMainThread$1
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
                    RobotAIOSendMsgVMDelegate.this.w(extData);
                }
            });
        }
    }

    private final void x0(AIOMsgSendEvent.PttSendEvent event) {
        r0(this, com.tencent.mobileqq.aio.msg.data.b.f190166a.d(event.e(), event.c(), event.b(), event.a(), event.h(), event.g(), event.f()), null, event.d(), null, 8, null);
    }

    private final void y() {
        a.C7282a c7282a;
        com.tencent.mobileqq.aio.input.d dVar;
        d.i iVar;
        d.i iVar2;
        List listOfNotNull;
        d.i iVar3;
        List<f.e> b16 = this.mFetcher.b();
        String c16 = this.mFetcher.c();
        boolean z16 = false;
        Bundle H = H(1, false);
        H.putBoolean("from_send_btn", true);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        Boolean bool = null;
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
        d.i[] iVarArr = new d.i[2];
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
        iVarArr[0] = iVar;
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        k k17 = aVar3.e().k(InputEvent.RobotGetSelectMediaInfo.f188580d);
        if (k17 instanceof d.i) {
            iVar2 = (d.i) k17;
        } else {
            iVar2 = null;
        }
        iVarArr[1] = iVar2;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) iVarArr);
        if (!(true ^ listOfNotNull.isEmpty())) {
            listOfNotNull = null;
        }
        if (listOfNotNull != null) {
            List list = listOfNotNull;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((d.i) it.next()).b());
            }
            Iterator it5 = list.iterator();
            if (it5.hasNext()) {
                bool = Boolean.valueOf(((d.i) it5.next()).a());
            }
            if (bool != null) {
                z16 = bool.booleanValue();
            }
            iVar3 = new d.i(arrayList, z16);
        } else {
            iVar3 = null;
        }
        if (iVar3 != null) {
            WrapLocalMediaInfoKt.g(iVar3.b(), new b(objectRef, booleanRef, iVar3, this, b16, dVar, H, c16));
        } else {
            i0(b16, dVar, (List) objectRef.element, booleanRef.element, H, c16);
        }
    }

    private final void y0(final List<com.tencent.mobileqq.album.media.c> mediaList, final boolean quality, final boolean fromCamera, final boolean isFlashPic) {
        QLog.d("RobotAIOSendMsgVMDelegate", 1, "sendRichMsgOneByOne size:" + mediaList.size() + " fromCamera:" + fromCamera + " isFlashPic:" + isFlashPic);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.e
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOSendMsgVMDelegate.z0(mediaList, this, fromCamera, quality, isFlashPic);
            }
        }, 64, null, false);
    }

    private final boolean z(List<com.tencent.mobileqq.album.media.c> list) {
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
    public static final void z0(List mediaList, RobotAIOSendMsgVMDelegate this$0, boolean z16, boolean z17, boolean z18) {
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
                QLog.w("RobotAIOSendMsgVMDelegate", 1, "[sendRichMsgListOneByOne] path is empty");
            } else if (i.b(a16)) {
                QLog.w("RobotAIOSendMsgVMDelegate", 1, "[sendRichMsgListOneByOne] file is 0B");
                i16++;
            } else {
                com.tencent.aio.api.runtime.a aVar = this$0.mContext;
                com.tencent.aio.api.runtime.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    aVar = null;
                }
                if (aVar.g().r().c().e() == 8) {
                    QLog.d("RobotAIOSendMsgVMDelegate", 1, "sendSelectMediaInfo myComputerSendFileFromPhoto: " + cVar.a());
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
                            I0(this$0, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), z17, 0, null, null, null, false, 248, null), null, null, null, 12, null);
                        } else {
                            this$0.A0(a16, cVar.c(), this$0.I(z16), z17, cVar.e());
                        }
                    } else {
                        if (com.tencent.qqnt.util.bitmap.a.f362978a.b(new File(a16))) {
                            i3 = 11;
                        } else {
                            i3 = 0;
                        }
                        I0(this$0, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, a16, cVar.c(), z17, i3, null, null, new Function1<AIOElementType.e, Unit>() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$sendRichMsgOneByOne$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AIOElementType.e eVar) {
                                invoke2(eVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull AIOElementType.e getElementFromPic) {
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
            QLog.d("RobotAIOSendMsgVMDelegate", 1, "invalidNum: " + i16 + " size: " + mediaList.size());
        }
        if (i16 == mediaList.size()) {
            i.d();
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: E, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void K0(@NotNull InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7284a) {
            U();
        }
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.b
    public void a(@Nullable com.tencent.qqnt.aio.interceptor.sendmsg.a interceptor) {
        this.mSendMsgInterceptor = interceptor;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        return com.tencent.mobileqq.aio.input.sendmsg.a.class;
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
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
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AddBotExtData");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.RemoveBotExtData");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.GetInterceptResendEvent");
        return hashSet;
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.i("RobotAIOSendMsgVMDelegate", 2, "[onCreate]: aioContext=" + context.hashCode());
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

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
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

    private final int I(boolean fromCamera) {
        return fromCamera ? 1 : 0;
    }
}
