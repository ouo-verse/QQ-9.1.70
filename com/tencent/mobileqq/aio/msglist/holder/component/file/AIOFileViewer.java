package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.at;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.aio.widget.PicProgressView;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0003}\u0081\u0001B\u0081\u0001\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0007\u0010\u0084\u0001\u001a\u00020\u000e\u0012M\u0010Y\u001aI\u0012\u0013\u0012\u00110T\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00040S\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b5\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H\u0002J \u0010.\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u0018\u0010/\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0002J\b\u00106\u001a\u00020\u0004H\u0002J\u0010\u00109\u001a\u0002082\u0006\u00107\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u00020\u0004H\u0002J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;H\u0002J\u0012\u0010>\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0002J\b\u0010?\u001a\u00020\u0004H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0002J\b\u0010F\u001a\u00020\u0004H\u0002J\u0012\u0010G\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0002J\u0012\u0010I\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010HH\u0002J\b\u0010J\u001a\u00020\u0004H\u0002J\b\u0010K\u001a\u00020\u0004H\u0002J\b\u0010L\u001a\u00020\u000eH\u0002J\u0012\u0010N\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010O\u001a\u00020\u000eH\u0002Jo\u0010Z\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00152\u0006\u0010R\u001a\u00020Q2\u0006\u0010\u0007\u001a\u00020\u00062M\u0010Y\u001aI\u0012\u0013\u0012\u00110T\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00040SH\u0002J \u0010[\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00152\u0006\u0010R\u001a\u00020Q2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010^\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\u00022\u0006\u0010]\u001a\u00020\u0002H\u0002J\u0010\u0010_\u001a\u00020\u00042\u0006\u0010R\u001a\u00020QH\u0002J\u0018\u0010`\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020Q2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010h\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020'2\u0006\u0010b\u001a\u00020\u00022\u0006\u0010c\u001a\u00020\u00022\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u0002H\u0002J\u0018\u0010i\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020\u00022\u0006\u0010c\u001a\u00020\u0002H\u0002J\u001c\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020j2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010l\u001a\u00020\u0002H\u0002J\b\u0010o\u001a\u00020\u000eH\u0002J\b\u0010p\u001a\u00020\u000eH\u0002J\u0016\u0010s\u001a\u00020\u00042\u0006\u0010R\u001a\u00020Q2\u0006\u0010r\u001a\u00020qJ\u0006\u0010t\u001a\u00020\u0004J\b\u0010u\u001a\u0004\u0018\u00010\u0015J\u000e\u0010w\u001a\u00020\u00042\u0006\u0010R\u001a\u00020vJ\u0018\u0010y\u001a\u00020\u00042\u0006\u0010x\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0001H\u0007J\u0006\u0010z\u001a\u00020\u000eJ\u000f\u0010{\u001a\u00020\u001fH\u0000\u00a2\u0006\u0004\b{\u0010|R\u0018\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010[R]\u0010Y\u001aI\u0012\u0013\u0012\u00110T\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00040S8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0087\u0001\u00109\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u0091\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0097\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u009a\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0099\u0001R\u0018\u0010\u009e\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b!\u0010\u009d\u0001R\u0019\u0010\u00a1\u0001\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u0019\u0010\u00a4\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b6\u0010\u00a3\u0001R\u001f\u0010\u00a7\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b5\u0010\u008e\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0019\u0010\u00aa\u0001\u001a\u00030\u00a8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b:\u0010\u00a9\u0001R\u0019\u0010\u00ad\u0001\u001a\u00030\u00ab\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bp\u0010\u00ac\u0001R\u0019\u0010\u00ae\u0001\u001a\u00030\u00ab\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bo\u0010\u00ac\u0001R \u0010\u00b1\u0001\u001a\u00030\u00ab\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\bZ\u0010\u008e\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0018\u0010\u00b3\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b2\u0001\u00109\u00a8\u0006\u00b6\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer;", "", "", "viewType", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "g0", TagName.FILE_TYPE, BdhLogUtil.LogTag.Tag_Req, "Landroid/view/ViewGroup;", "contentView", "u", "", "show", "progress", "V", "n0", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "f0", "t", "j0", HippyTKDListViewAdapter.X, "w", "Landroid/widget/RelativeLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "Landroid/widget/Button;", "k", "transferStatus", "x0", "v0", "statusType", "y0", "", "P", "A0", "s0", "K", "O", "entity", "J", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "C0", "B0", "B", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSetBottomMargin", "Landroid/view/ViewGroup$LayoutParams;", "I", "o", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "k0", "o0", "e0", "r0", "q0", "p0", "Lcom/tencent/mobileqq/aio/msglist/payload/a$ay;", "payload", "Y", "X", "W", "Lcom/tencent/mobileqq/aio/msglist/payload/a$p;", "c0", "b0", "a0", "h0", "v", "U", "d0", "picView", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "msgItem", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lkotlin/ParameterName;", "name", "aioMsgItem", "clickedView", "listener", "r", "Z", "viewWidth", "viewHeight", "l0", "T", "m0", "path", "width", "height", "Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$LoadingImage;", "loadingImage", "originWidth", "originHeight", "i0", "y", "Lkotlin/Pair;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "id", "Landroid/graphics/drawable/Drawable;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "u0", "w0", "N", "Lcom/tencent/aio/data/msglist/a;", "z0", "msg", "t0", ExifInterface.LATITUDE_SOUTH, "D", "()Landroid/view/View;", "a", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "()Landroid/view/ViewGroup;", "b", "Landroid/content/Context;", "c", "rightSide", "d", "Lkotlin/jvm/functions/Function3;", "e", "getViewType", "()I", "setViewType", "(I)V", "Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer$a;", "f", "Lkotlin/Lazy;", "E", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer$a;", "binding", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, tl.h.F, "Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "currentMsgItem", "i", "Ljava/lang/String;", "tvDescText", "j", "loadThumbPath", "Landroid/view/View;", "videoPlayButton", "l", "Landroid/widget/Button;", "fileStateView", "Lcom/tencent/qqnt/aio/widget/PicProgressView;", "Lcom/tencent/qqnt/aio/widget/PicProgressView;", "picProgressView", "M", "()Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "picFileView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "fileNameAndSizeContentLl", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "picFileNameView", "picFileSizeView", "L", "()Landroid/widget/TextView;", "picFileTipsView", ReportConstant.COSTREPORT_PREFIX, "userSetTransferStatus", "<init>", "(Lcom/tencent/mobileqq/aio/msg/FileMsgItem;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;Landroid/view/ViewGroup;Landroid/content/Context;ZLkotlin/jvm/functions/Function3;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFileViewer {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: u, reason: collision with root package name */
    private static final int f190800u;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup contentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean rightSide;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<AIOMsgItem, FileElement, View, Unit> listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int viewType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private MsgElement element;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FileMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tvDescText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String loadThumbPath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private View videoPlayButton;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Button fileStateView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PicProgressView picProgressView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picFileView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private LinearLayout fileNameAndSizeContentLl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView picFileNameView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView picFileSizeView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picFileTipsView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int userSetTransferStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0003\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0015\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer$a;", "", "Landroid/widget/RelativeLayout;", "a", "Landroid/widget/RelativeLayout;", "e", "()Landroid/widget/RelativeLayout;", "l", "(Landroid/widget/RelativeLayout;)V", "root", "Landroidx/constraintlayout/widget/ConstraintLayout;", "b", "Landroidx/constraintlayout/widget/ConstraintLayout;", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "i", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "msgFile", "c", "j", "msgVideo", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "(Landroid/widget/TextView;)V", "tvTitle", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvDesc", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", tl.h.F, "(Landroid/widget/ImageView;)V", "ivFileIcon", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "()Landroid/widget/ProgressBar;", "k", "(Landroid/widget/ProgressBar;)V", "pbLoading", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public RelativeLayout root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public ConstraintLayout msgFile;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public RelativeLayout msgVideo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public TextView tvTitle;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public TextView tvDesc;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public ImageView ivFileIcon;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public ProgressBar pbLoading;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final ImageView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (ImageView) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            ImageView imageView = this.ivFileIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ivFileIcon");
            return null;
        }

        @NotNull
        public final ConstraintLayout b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ConstraintLayout) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ConstraintLayout constraintLayout = this.msgFile;
            if (constraintLayout != null) {
                return constraintLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgFile");
            return null;
        }

        @NotNull
        public final RelativeLayout c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (RelativeLayout) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            RelativeLayout relativeLayout = this.msgVideo;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgVideo");
            return null;
        }

        @NotNull
        public final ProgressBar d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (ProgressBar) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            ProgressBar progressBar = this.pbLoading;
            if (progressBar != null) {
                return progressBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
            return null;
        }

        @NotNull
        public final RelativeLayout e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            RelativeLayout relativeLayout = this.root;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        @NotNull
        public final TextView f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            TextView textView = this.tvDesc;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
            return null;
        }

        @NotNull
        public final TextView g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            TextView textView = this.tvTitle;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            return null;
        }

        public final void h(@NotNull ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) imageView);
            } else {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.ivFileIcon = imageView;
            }
        }

        public final void i(@NotNull ConstraintLayout constraintLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) constraintLayout);
            } else {
                Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
                this.msgFile = constraintLayout;
            }
        }

        public final void j(@NotNull RelativeLayout relativeLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) relativeLayout);
            } else {
                Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
                this.msgVideo = relativeLayout;
            }
        }

        public final void k(@NotNull ProgressBar progressBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) progressBar);
            } else {
                Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
                this.pbLoading = progressBar;
            }
        }

        public final void l(@NotNull RelativeLayout relativeLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) relativeLayout);
            } else {
                Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
                this.root = relativeLayout;
            }
        }

        public final void m(@NotNull TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
            } else {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.tvDesc = textView;
            }
        }

        public final void n(@NotNull TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
            } else {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.tvTitle = textView;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer$b;", "", "", "CONTENT_MARGIN_DP", "I", "DEFAULT_PIC_SIZE_DP", "DOWNLOAD_ICON_MARGIN_DP", "DOWNLOAD_ICON_SIZE", "", "PIC_VIEW_ROUND_RADIUS", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "TYPE_NO_SHOW_DOWNLOAD_UPLOAD", "TYPE_SHOW_DOWNLOAD_PAUSE", "TYPE_SHOW_DOWNLOAD_READY", "TYPE_SHOW_DOWNLOAD_RESUME", "TYPE_SHOW_UPLOAD_PAUSE", "TYPE_SHOW_UPLOAD_RESUME", "fileBubbleMaxWidth", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$b, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            f190800u = ((a.C7329a.f192417a.b() - x.a(18.0f)) - (p.c(21) / 2)) - p.c(6);
        }
    }

    public AIOFileViewer(@NotNull FileMsgItem msgItem, @NotNull MsgElement msgElement, @NotNull ViewGroup contentView, @NotNull Context context, boolean z16, @NotNull Function3<? super AIOMsgItem, ? super FileElement, ? super View, Unit> listener) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItem, msgElement, contentView, context, Boolean.valueOf(z16), listener);
            return;
        }
        this.contentView = contentView;
        this.context = context;
        this.rightSide = z16;
        this.listener = listener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$binding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFileViewer.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOFileViewer.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOFileViewer.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOFileViewer.a aVar = new AIOFileViewer.a();
                Context context2 = AIOFileViewer.this.F().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "contentView.context");
                AioFileDefaultLayout aioFileDefaultLayout = new AioFileDefaultLayout(context2, null, null, false, 14, null);
                aioFileDefaultLayout.e().setReferencedIds(new int[]{aioFileDefaultLayout.f().getId(), aioFileDefaultLayout.k().getId()});
                View mContainer = aioFileDefaultLayout.getMContainer();
                Intrinsics.checkNotNull(mContainer, "null cannot be cast to non-null type android.widget.RelativeLayout");
                aVar.l((RelativeLayout) mContainer);
                aVar.i(aioFileDefaultLayout.g());
                aVar.n(aioFileDefaultLayout.l());
                aVar.h(aioFileDefaultLayout.f());
                aVar.m(aioFileDefaultLayout.k());
                aVar.k(aioFileDefaultLayout.i());
                aVar.j(aioFileDefaultLayout.h());
                return aVar;
            }
        });
        this.binding = lazy;
        this.tvDescText = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RoundBubbleImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$picFileView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFileViewer.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundBubbleImageView invoke() {
                Context context2;
                RoundBubbleImageView z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RoundBubbleImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOFileViewer aIOFileViewer = AIOFileViewer.this;
                context2 = aIOFileViewer.context;
                z17 = aIOFileViewer.z(context2);
                return z17;
            }
        });
        this.picFileView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$picFileTipsView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFileViewer.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFileViewer.this.context;
                TextView textView = new TextView(context2, null);
                textView.setId(R.id.shp);
                textView.setTextSize(2, 12.0f);
                textView.setTextColor(Color.parseColor("#B0B3BF"));
                textView.setText(R.string.yqz);
                textView.setGravity(1);
                int a16 = x.a(28.0f);
                Drawable i3 = PicUtil.f191410a.i(a16, a16);
                i3.setBounds(0, 0, a16, a16);
                textView.setCompoundDrawables(null, i3, null, null);
                textView.setVisibility(8);
                return textView;
            }
        });
        this.picFileTipsView = lazy3;
        u0(msgItem, msgElement);
    }

    private final void A() {
        a E = E();
        E.b().setVisibility(0);
        ImageView a16 = E.a();
        if (a16 != null) {
            a16.setImportantForAccessibility(2);
        }
        E.c().setVisibility(8);
        FileMsgItem fileMsgItem = this.currentMsgItem;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        AIOBubbleSkinInfo x06 = fileMsgItem.x0();
        Intrinsics.checkNotNull(x06);
        k0(x06);
    }

    private final void A0(int statusType) {
        int i3;
        Button button = this.fileStateView;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button = null;
        }
        if (statusType == 6) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        button.setVisibility(i3);
        Drawable G = G(O(statusType));
        Button button3 = this.fileStateView;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button3 = null;
        }
        button3.setBackground(G);
        if (G == null) {
            Button button4 = this.fileStateView;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            } else {
                button2 = button4;
            }
            button2.setVisibility(8);
        }
    }

    private final void B() {
        if (E().c().getChildCount() > 0) {
            E().c().removeAllViews();
        }
        E().b().setVisibility(8);
        RelativeLayout c16 = E().c();
        c16.setVisibility(0);
        M().setId(R.id.shl);
        ViewCompat.setImportantForAccessibility(M(), 2);
        M().setScaleType(ImageView.ScaleType.CENTER_CROP);
        c16.addView(M(), new RelativeLayout.LayoutParams(-2, -2));
        m();
        n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r1.getMsgRecord().chatType == 8) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B0(int transferStatus) {
        MsgElement msgElement = this.element;
        FileMsgItem fileMsgItem = null;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            int d16 = com.tencent.qqnt.aio.element.file.util.a.d(fileElement);
            if (d16 == 2) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem2;
                }
            }
            if (d16 != 0) {
                QLog.d("AIOFileViewer", 1, "it = " + fileElement + ", transferStatus = " + transferStatus);
                x0(fileElement, transferStatus);
                return;
            }
            A0(s0(transferStatus));
        }
    }

    private final void C(int viewType) {
        if (this.contentView.getChildCount() > 0) {
            this.contentView.removeAllViews();
        }
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType == 3) {
                    A();
                    k(E().e(), E().b());
                    return;
                }
                return;
            }
            B();
            o();
            k(E().e(), E().c());
            return;
        }
        B();
        k(E().e(), E().c());
    }

    private final void C0(FileTransNotifyInfo fileInfo) {
        B0(fileInfo.trasferStatus);
    }

    private final a E() {
        return (a) this.binding.getValue();
    }

    private final Drawable G(int id5) {
        if (id5 != -1 && id5 != 0) {
            return ContextCompat.getDrawable(this.context, id5);
        }
        return null;
    }

    private final String H(FileElement entity, Context context) {
        Long l3 = entity.expireTime;
        if (l3 == null || l3.longValue() != 0) {
            FileMsgItem fileMsgItem = this.currentMsgItem;
            if (fileMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem = null;
            }
            if (fileMsgItem.getMsgRecord().chatType != 8) {
                if (com.tencent.qqnt.aio.element.file.util.a.f(entity)) {
                    String string = context.getString(R.string.yqs);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026_file_overtime)\n        }");
                    return string;
                }
                Long l16 = entity.expireTime;
                Intrinsics.checkNotNullExpressionValue(l16, "entity.expireTime");
                return com.tencent.qqnt.aio.element.file.util.a.a(l16.longValue());
            }
        }
        return "";
    }

    private final ViewGroup.LayoutParams I(boolean isSetBottomMargin) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = p.c(7);
        layoutParams.rightMargin = p.c(7);
        if (isSetBottomMargin) {
            layoutParams.bottomMargin = p.c(7);
        }
        return layoutParams;
    }

    private final String J(Context context, FileElement entity, int transferStatus) {
        Integer num = entity.invalidState;
        if (num == null || num.intValue() != 0) {
            String string = this.contentView.getContext().getString(R.string.yqr);
            Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getS\u2026.string.aio_file_invalid)");
            return string;
        }
        FileMsgItem fileMsgItem = null;
        if (transferStatus == 5) {
            FileMsgItem fileMsgItem2 = this.currentMsgItem;
            if (fileMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem = fileMsgItem2;
            }
            if (fileMsgItem.getMsgRecord().sendStatus != 2) {
                String string2 = context.getString(R.string.yqp);
                Intrinsics.checkNotNullExpressionValue(string2, "{\n                contex\u2026_file_fail)\n            }");
                return string2;
            }
            String string3 = context.getString(R.string.yqo);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                contex\u2026nload_fail)\n            }");
            return string3;
        }
        if (transferStatus == 6) {
            FileMsgItem fileMsgItem3 = this.currentMsgItem;
            if (fileMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem = fileMsgItem3;
            }
            if (o81.a.c(fileMsgItem)) {
                String string4 = context.getString(R.string.yqm);
                Intrinsics.checkNotNullExpressionValue(string4, "{\n                contex\u2026ile_cancel)\n            }");
                return string4;
            }
            String string5 = context.getString(R.string.ioo);
            Intrinsics.checkNotNullExpressionValue(string5, "{\n                contex\u2026atus_pause)\n            }");
            return string5;
        }
        if (transferStatus == 4) {
            MsgElement msgElement = this.element;
            if (msgElement == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                msgElement = null;
            }
            boolean g16 = c81.a.g(msgElement.fileElement.filePath);
            FileMsgItem fileMsgItem4 = this.currentMsgItem;
            if (fileMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem = fileMsgItem4;
            }
            if (o81.a.c(fileMsgItem) && g16) {
                String string6 = context.getString(R.string.yqt);
                Intrinsics.checkNotNullExpressionValue(string6, "{\n                contex\u2026_file_send)\n            }");
                return string6;
            }
            if (g16) {
                String string7 = context.getString(R.string.yqn);
                Intrinsics.checkNotNullExpressionValue(string7, "{\n                contex\u2026e_download)\n            }");
                return string7;
            }
            return H(entity, context);
        }
        if (transferStatus == 0 || transferStatus == 1 || transferStatus == 3) {
            FileMsgItem fileMsgItem5 = this.currentMsgItem;
            if (fileMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem = fileMsgItem5;
            }
            if (!o81.a.c(fileMsgItem)) {
                return H(entity, context);
            }
            return "";
        }
        return "";
    }

    private final int K(int statusType) {
        switch (statusType) {
            case 1:
                return R.drawable.gxn;
            case 2:
                return R.drawable.m86;
            case 3:
            case 5:
                return R.drawable.m85;
            case 4:
                return R.drawable.m87;
            case 6:
                return 0;
            default:
                return -1;
        }
    }

    private final TextView L() {
        return (TextView) this.picFileTipsView.getValue();
    }

    private final RoundBubbleImageView M() {
        return (RoundBubbleImageView) this.picFileView.getValue();
    }

    private final int O(int statusType) {
        if (statusType != 1) {
            if (statusType != 2) {
                if (statusType != 6) {
                    return -1;
                }
                return 0;
            }
            return R.drawable.m86;
        }
        return R.drawable.gxn;
    }

    private final String P(int statusType) {
        if (statusType != 1) {
            if (statusType != 2) {
                if (statusType != 3) {
                    if (statusType != 4) {
                        if (statusType != 5) {
                            return "";
                        }
                        String string = this.context.getString(R.string.yqx);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026cription_resume_download)");
                        return string;
                    }
                    String string2 = this.context.getString(R.string.yqv);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026scription_pause_download)");
                    return string2;
                }
                String string3 = this.context.getString(R.string.yqu);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026scription_download_ready)");
                return string3;
            }
            String string4 = this.context.getString(R.string.yqy);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026escription_resume_upload)");
            return string4;
        }
        String string5 = this.context.getString(R.string.yqw);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026description_pause_upload)");
        return string5;
    }

    private final Pair<Integer, Integer> Q(FileElement fileElement) {
        Integer num = fileElement.picWidth;
        Intrinsics.checkNotNullExpressionValue(num, "fileElement.picWidth");
        FileMsgItem fileMsgItem = null;
        if (num.intValue() > 0) {
            Integer num2 = fileElement.picHeight;
            Intrinsics.checkNotNullExpressionValue(num2, "fileElement.picHeight");
            if (num2.intValue() > 0) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem2 = null;
                }
                int y26 = fileMsgItem2.y2();
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem3 = null;
                }
                int v26 = fileMsgItem3.v2();
                if (y26 > 0 && v26 > 0) {
                    PicUtil picUtil = PicUtil.f191410a;
                    Integer num3 = fileElement.picWidth;
                    Intrinsics.checkNotNullExpressionValue(num3, "fileElement.picWidth");
                    int intValue = num3.intValue();
                    Integer num4 = fileElement.picHeight;
                    Intrinsics.checkNotNullExpressionValue(num4, "fileElement.picHeight");
                    return picUtil.b(intValue, num4.intValue(), y26, v26);
                }
                FileMsgItem fileMsgItem4 = this.currentMsgItem;
                if (fileMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem4;
                }
                QLog.i("AIOFileViewer", 1, "[getThumbSizePx] invalid pic size, msgId=" + fileMsgItem.getMsgId() + ", size=" + y26 + "," + v26);
                return new Pair<>(fileElement.picWidth, fileElement.picHeight);
            }
        }
        FileMsgItem fileMsgItem5 = this.currentMsgItem;
        if (fileMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem = fileMsgItem5;
        }
        QLog.i("AIOFileViewer", 1, "[getThumbSizePx] invalid pic size, msgId=" + fileMsgItem.getMsgId() + ", size=" + fileElement.picWidth + "," + fileElement.picHeight);
        return new Pair<>(0, 0);
    }

    private final int R(int fileType) {
        if (fileType != 0) {
            if (fileType == 2) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    private final void T(FileMsgItem msgItem) {
        RichMediaElementGetReq l26 = msgItem.l2();
        l26.downSourceType = 1;
        l26.triggerType = 1;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AIOFileViewer$handleDownloadThumb$1(l26, null), 3, null);
    }

    private final void U(View v3) {
        FileMsgItem fileMsgItem = this.currentMsgItem;
        MsgElement msgElement = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        QLog.i("AIOFileViewer", 1, "click file content, msgId=" + fileMsgItem.getMsgId());
        Function3<AIOMsgItem, FileElement, View, Unit> function3 = this.listener;
        FileMsgItem fileMsgItem2 = this.currentMsgItem;
        if (fileMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem2 = null;
        }
        MsgElement msgElement2 = this.element;
        if (msgElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
        } else {
            msgElement = msgElement2;
        }
        FileElement fileElement = msgElement.fileElement;
        Intrinsics.checkNotNull(v3);
        function3.invoke(fileMsgItem2, fileElement, v3);
    }

    private final void V(boolean show, int progress) {
        PicProgressView picProgressView = this.picProgressView;
        if (picProgressView == null) {
            return;
        }
        PicProgressView picProgressView2 = null;
        if (!show) {
            if (picProgressView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
                picProgressView = null;
            }
            FileMsgItem fileMsgItem = this.currentMsgItem;
            if (fileMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem = null;
            }
            picProgressView.q(fileMsgItem.t2());
            PicProgressView picProgressView3 = this.picProgressView;
            if (picProgressView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
                picProgressView3 = null;
            }
            FileMsgItem fileMsgItem2 = this.currentMsgItem;
            if (fileMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem2 = null;
            }
            if (!picProgressView3.o(fileMsgItem2.t2())) {
                PicProgressView picProgressView4 = this.picProgressView;
                if (picProgressView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
                } else {
                    picProgressView2 = picProgressView4;
                }
                picProgressView2.setVisibility(8);
                return;
            }
            PicProgressView picProgressView5 = this.picProgressView;
            if (picProgressView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
            } else {
                picProgressView2 = picProgressView5;
            }
            picProgressView2.setProgress(100);
            return;
        }
        if (picProgressView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
            picProgressView = null;
        }
        picProgressView.setVisibility(0);
        PicProgressView picProgressView6 = this.picProgressView;
        if (picProgressView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
            picProgressView6 = null;
        }
        FileMsgItem fileMsgItem3 = this.currentMsgItem;
        if (fileMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem3 = null;
        }
        picProgressView6.setProgressKey(fileMsgItem3.t2());
        PicProgressView picProgressView7 = this.picProgressView;
        if (picProgressView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
        } else {
            picProgressView2 = picProgressView7;
        }
        picProgressView2.setProgress(progress);
    }

    private final void W(FileTransNotifyInfo fileInfo) {
        Integer num;
        int intValue;
        int intValue2;
        FileElement fileElement;
        if (fileInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileViewer", 2, "handleRichMediaUI, msgId=" + fileInfo.msgId + ", status=" + fileInfo.trasferStatus + ", progress=" + fileInfo.fileProgress + ", fileInfo=" + fileInfo);
            }
            int i3 = fileInfo.trasferStatus;
            if (i3 != 2) {
                if (i3 != 3) {
                    MsgElement msgElement = null;
                    FileMsgItem fileMsgItem = null;
                    Integer num2 = null;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                                if (fileMsgItem2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                } else {
                                    fileMsgItem = fileMsgItem2;
                                }
                                if (fileMsgItem.G2() && fileInfo.fileDownType != 2) {
                                    q0(fileInfo);
                                    return;
                                }
                                return;
                            }
                            q.d("AIOFileViewer", "cancel downloading, fileInfo=" + fileInfo);
                            if (p()) {
                                e0();
                                C0(fileInfo);
                                return;
                            }
                            return;
                        }
                        q.d("AIOFileViewer", "download fail, fileInfo=" + fileInfo);
                        e0();
                        if (h0() || fileInfo.fileDownType != 2) {
                            o0(fileInfo);
                            return;
                        }
                        return;
                    }
                    boolean z16 = true;
                    if (fileInfo.fileDownType == 2) {
                        if (QLog.isColorLevel()) {
                            FileMsgItem fileMsgItem3 = this.currentMsgItem;
                            if (fileMsgItem3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                fileMsgItem3 = null;
                            }
                            int y26 = fileMsgItem3.y2();
                            FileMsgItem fileMsgItem4 = this.currentMsgItem;
                            if (fileMsgItem4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                fileMsgItem4 = null;
                            }
                            QLog.i("AIOFileViewer", 2, "thumb downloaded, viewWidth:" + y26 + ", viewHeight:" + fileMsgItem4.v2() + ", msgId=" + fileInfo.msgId);
                        }
                        String str = fileInfo.filePath;
                        Intrinsics.checkNotNullExpressionValue(str, "it.filePath");
                        if (str.length() <= 0) {
                            z16 = false;
                        }
                        if (z16) {
                            FileMsgItem fileMsgItem5 = this.currentMsgItem;
                            if (fileMsgItem5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                fileMsgItem5 = null;
                            }
                            String str2 = fileInfo.filePath;
                            Intrinsics.checkNotNullExpressionValue(str2, "it.filePath");
                            fileMsgItem5.I2(str2);
                            FileMsgItem fileMsgItem6 = this.currentMsgItem;
                            if (fileMsgItem6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                fileMsgItem6 = null;
                            }
                            MsgElement q26 = fileMsgItem6.q2();
                            if (q26 != null) {
                                fileElement = q26.fileElement;
                            } else {
                                fileElement = null;
                            }
                            if (fileElement != null) {
                                HashMap<Integer, String> hashMap = new HashMap<>();
                                hashMap.put(750, fileInfo.filePath);
                                fileElement.picThumbPath = hashMap;
                            }
                        }
                        FileMsgItem fileMsgItem7 = this.currentMsgItem;
                        if (fileMsgItem7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem7 = null;
                        }
                        fileMsgItem7.D2();
                        FileMsgItem fileMsgItem8 = this.currentMsgItem;
                        if (fileMsgItem8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem8 = null;
                        }
                        FileElement n26 = fileMsgItem8.n2();
                        Intrinsics.checkNotNull(n26);
                        Pair<Integer, Integer> Q = Q(n26);
                        int intValue3 = Q.component1().intValue();
                        int intValue4 = Q.component2().intValue();
                        RoundBubbleImageView M = M();
                        FileMsgItem fileMsgItem9 = this.currentMsgItem;
                        if (fileMsgItem9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem9 = null;
                        }
                        int y27 = fileMsgItem9.y2();
                        FileMsgItem fileMsgItem10 = this.currentMsgItem;
                        if (fileMsgItem10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem10 = null;
                        }
                        l0(M, y27, fileMsgItem10.v2());
                        FileMsgItem fileMsgItem11 = this.currentMsgItem;
                        if (fileMsgItem11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem11 = null;
                        }
                        FileElement n27 = fileMsgItem11.n2();
                        if (n27 != null) {
                            num = n27.picWidth;
                        } else {
                            num = null;
                        }
                        if (num == null) {
                            intValue = 0;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(num, "currentMsgItem.getFileElement()?.picWidth ?: 0");
                            intValue = num.intValue();
                        }
                        FileMsgItem fileMsgItem12 = this.currentMsgItem;
                        if (fileMsgItem12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem12 = null;
                        }
                        FileElement n28 = fileMsgItem12.n2();
                        if (n28 != null) {
                            num2 = n28.picHeight;
                        }
                        if (num2 == null) {
                            intValue2 = 0;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(num2, "currentMsgItem.getFileElement()?.picHeight ?: 0");
                            intValue2 = num2.intValue();
                        }
                        String str3 = fileInfo.filePath;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.filePath");
                        i0(str3, intValue3, intValue4, PicContentViewUtil.LoadingImage.Original, intValue, intValue2);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOFileViewer", 2, "download success, fileInfo=" + fileInfo.msgId);
                    }
                    if (fileInfo.fileDownType == 1) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AIOFileViewer", 2, "download success, fileDownType=" + fileInfo.fileDownType + ", filePath=" + fileInfo.filePath);
                        }
                        String str4 = fileInfo.filePath;
                        Intrinsics.checkNotNullExpressionValue(str4, "it.filePath");
                        if (str4.length() <= 0) {
                            z16 = false;
                        }
                        if (z16) {
                            if (QLog.isColorLevel()) {
                                QLog.i("AIOFileViewer", 2, "download success, fileInfo=" + fileInfo.msgId);
                            }
                            MsgElement msgElement2 = this.element;
                            if (msgElement2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                                msgElement2 = null;
                            }
                            msgElement2.fileElement.filePath = fileInfo.filePath;
                            MsgElement msgElement3 = this.element;
                            if (msgElement3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                            } else {
                                msgElement = msgElement3;
                            }
                            boolean g16 = c81.a.g(msgElement.fileElement.filePath);
                            if (QLog.isColorLevel()) {
                                QLog.i("AIOFileViewer", 2, "download success, fileExist=" + g16);
                            }
                        }
                    }
                    e0();
                    C0(fileInfo);
                    return;
                }
                if (fileInfo.fileDownType != 2 && q()) {
                    q0(fileInfo);
                    C0(fileInfo);
                    return;
                }
                return;
            }
            if (fileInfo.fileDownType != 2 && q()) {
                q0(fileInfo);
                C0(fileInfo);
            }
        }
    }

    private final void X() {
        int i3 = this.viewType;
        if (i3 == 1 || i3 == 2) {
            FileMsgItem fileMsgItem = null;
            if (QLog.isColorLevel()) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem2 = null;
                }
                QLog.i("AIOFileViewer", 2, "handleSendStatusSuc, msgId=" + fileMsgItem2.getMsgId() + ", loadThumbPath=" + this.loadThumbPath);
            }
            if (TextUtils.isEmpty(this.loadThumbPath)) {
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem3;
                }
                T(fileMsgItem);
            }
        }
    }

    private final void Y(a.ay payload) {
        if (QLog.isColorLevel()) {
            FileMsgItem fileMsgItem = this.currentMsgItem;
            if (fileMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem = null;
            }
            long msgId = fileMsgItem.getMsgId();
            FileMsgItem fileMsgItem2 = this.currentMsgItem;
            if (fileMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem2 = null;
            }
            QLog.i("AIOFileViewer", 2, "handleSendStatusUI, msgId=" + msgId + ", sendStatus:" + fileMsgItem2.getMsgRecord().sendStatus);
        }
        if (payload != null) {
            int a16 = payload.a();
            if (a16 != 0) {
                if (a16 == 2) {
                    X();
                    return;
                }
                return;
            }
            o0(null);
        }
    }

    private final void Z(RoundBubbleImageView picView, FileMsgItem msgItem, FileElement fileElement) {
        int y26 = msgItem.y2();
        int v26 = msgItem.v2();
        if (QLog.isColorLevel()) {
            QLog.i("AIOFileViewer", 2, "handleThumb viewWidth:" + y26 + ", viewHeight:" + v26 + ", msgId: " + msgItem.getMsgId() + ", thumb path: " + msgItem.w2());
        }
        l0(picView, y26, v26);
        Pair<Integer, Integer> Q = Q(fileElement);
        int intValue = Q.component1().intValue();
        int intValue2 = Q.component2().intValue();
        String w26 = msgItem.w2();
        PicContentViewUtil.LoadingImage loadingImage = PicContentViewUtil.LoadingImage.LoadingIcon;
        Integer num = fileElement.picWidth;
        Intrinsics.checkNotNullExpressionValue(num, "fileElement.picWidth");
        int intValue3 = num.intValue();
        Integer num2 = fileElement.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "fileElement.picHeight");
        if (!i0(w26, intValue, intValue2, loadingImage, intValue3, num2.intValue())) {
            if (!m0(msgItem, fileElement)) {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOFileViewer", 2, "[handleThumb] no need to download, show error, msgItem=" + msgItem);
                }
                picView.setImageDrawable(PicUtil.f191410a.h(y26, v26));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileViewer", 2, "[handleThumb] set loading drawable and consider download thumb, msgItem=" + msgItem);
            }
            picView.setImageDrawable(PicUtil.f191410a.g(y26, v26));
            if (msgItem.getMsgRecord().sendStatus == 2) {
                T(msgItem);
                return;
            }
            QLog.i("AIOFileViewer", 1, "[handleThumb] not send successful yet, msgItem=" + msgItem);
        }
    }

    private final void a0() {
        FileMsgItem fileMsgItem = this.currentMsgItem;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        int A2 = fileMsgItem.A2();
        QLog.i("AIOFileViewer", 1, "[handleTransferEnd]: uiTransferState is " + A2);
        if (A2 != 3 && A2 != 2) {
            e0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        if (r7 != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b0() {
        boolean z16;
        boolean z17;
        Integer num;
        Integer num2;
        Integer num3;
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        if (fileMsgItem.A2() == 3) {
            FileMsgItem fileMsgItem3 = this.currentMsgItem;
            if (fileMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem3 = null;
            }
            int z26 = fileMsgItem3.z2();
            if (z26 >= 100) {
                FileMsgItem fileMsgItem4 = this.currentMsgItem;
                if (fileMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem2 = fileMsgItem4;
                }
                fileMsgItem2.K2(4);
                e0();
                B0(4);
                return;
            }
            MsgElement msgElement = this.element;
            if (msgElement == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                msgElement = null;
            }
            FileElement fileElement = msgElement.fileElement;
            boolean z18 = false;
            if (fileElement != null && (num3 = fileElement.transferStatus) != null && 3 == num3.intValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                MsgElement msgElement2 = this.element;
                if (msgElement2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                    msgElement2 = null;
                }
                FileElement fileElement2 = msgElement2.fileElement;
                if (fileElement2 != null && (num2 = fileElement2.transferStatus) != null && 6 == num2.intValue()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    MsgElement msgElement3 = this.element;
                    if (msgElement3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                        msgElement3 = null;
                    }
                    FileElement fileElement3 = msgElement3.fileElement;
                    if (fileElement3 != null && (num = fileElement3.transferStatus) != null && 5 == num.intValue()) {
                        z18 = true;
                    }
                }
            }
            if (z26 == 0) {
                FileMsgItem fileMsgItem5 = this.currentMsgItem;
                if (fileMsgItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem2 = fileMsgItem5;
                }
                QLog.i("AIOFileViewer", 1, "handleTransferProgressStatus, msgId=" + fileMsgItem2.getMsgId() + ", do not show progress");
                return;
            }
            p0(z26);
        }
    }

    private final void c0(a.p payload) {
        if (this.viewType != 3) {
            return;
        }
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        if (fileMsgItem.getFileTransNotifyInfo().fileDownType == 1 && payload != null) {
            FileMsgItem fileMsgItem3 = this.currentMsgItem;
            if (fileMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem3 = null;
            }
            QLog.i("AIOFileViewer", 1, "handleTransferStatusUI, msgId=" + fileMsgItem3.getMsgId() + ", status=" + payload.a());
            if (c81.a.n(payload.a())) {
                if (q()) {
                    r0();
                    FileMsgItem fileMsgItem4 = this.currentMsgItem;
                    if (fileMsgItem4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        fileMsgItem4 = null;
                    }
                    QLog.i("AIOFileViewer", 1, "handleTransferStatusUI1111, msgId=" + fileMsgItem4.getMsgId() + ", status=" + payload.a());
                    FileMsgItem fileMsgItem5 = this.currentMsgItem;
                    if (fileMsgItem5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        fileMsgItem5 = null;
                    }
                    FileElement n26 = fileMsgItem5.n2();
                    Intrinsics.checkNotNull(n26);
                    x0(n26, payload.a());
                    FileMsgItem fileMsgItem6 = this.currentMsgItem;
                    if (fileMsgItem6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        fileMsgItem2 = fileMsgItem6;
                    }
                    fileMsgItem2.K2(payload.a());
                    return;
                }
                return;
            }
            if (p()) {
                e0();
                FileMsgItem fileMsgItem7 = this.currentMsgItem;
                if (fileMsgItem7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem7 = null;
                }
                long msgId = fileMsgItem7.getMsgId();
                int a16 = payload.a();
                FileMsgItem fileMsgItem8 = this.currentMsgItem;
                if (fileMsgItem8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem8 = null;
                }
                QLog.i("AIOFileViewer", 1, "handleTransferStatusUI22222, msgId=" + msgId + ", status=" + a16 + ", currentMsgItem.getFileElement()=" + fileMsgItem8.n2());
                FileMsgItem fileMsgItem9 = this.currentMsgItem;
                if (fileMsgItem9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem9 = null;
                }
                FileElement n27 = fileMsgItem9.n2();
                Intrinsics.checkNotNull(n27);
                x0(n27, payload.a());
                FileMsgItem fileMsgItem10 = this.currentMsgItem;
                if (fileMsgItem10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem2 = fileMsgItem10;
                }
                fileMsgItem2.K2(payload.a());
            }
        }
    }

    private final boolean d0() {
        Activity activity;
        MsgElement msgElement = this.element;
        FileMsgItem fileMsgItem = null;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            if (com.tencent.qqnt.aio.element.file.util.a.f(fileElement) && !c81.a.g(fileElement.filePath)) {
                String string = this.context.getString(R.string.yqs);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.aio_file_overtime)");
                QQToast.makeText(this.context, 1, string, 1).show();
                return true;
            }
            Integer num = fileElement.invalidState;
            if (num == null || num.intValue() != 0) {
                String string2 = this.context.getString(R.string.yqr);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.aio_file_invalid)");
                QQToast.makeText(this.context, 1, string2, 1).show();
                return true;
            }
            Integer num2 = fileElement.transferStatus;
            if (num2 == null || num2.intValue() != 4) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem2 = null;
                }
                QLog.i("AIOFileViewer", 1, "resend uploading message, msgId=" + fileMsgItem2.getMsgId());
                IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
                Context context = this.context;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem3;
                }
                iAIOFileManagerApi.reSendFile(activity, fileMsgItem, new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$handleUploadFile$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFileViewer.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FileMsgItem fileMsgItem4;
                        MsgElement msgElement2;
                        FileMsgItem fileMsgItem5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        AIOFileViewer.this.userSetTransferStatus = 1;
                        fileMsgItem4 = AIOFileViewer.this.currentMsgItem;
                        FileMsgItem fileMsgItem6 = null;
                        if (fileMsgItem4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem4 = null;
                        }
                        fileMsgItem4.K2(2);
                        AIOFileViewer aIOFileViewer = AIOFileViewer.this;
                        msgElement2 = aIOFileViewer.element;
                        if (msgElement2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                            msgElement2 = null;
                        }
                        FileElement fileElement2 = msgElement2.fileElement;
                        Intrinsics.checkNotNullExpressionValue(fileElement2, "element.fileElement");
                        aIOFileViewer.x0(fileElement2, 2);
                        AIOFileViewer aIOFileViewer2 = AIOFileViewer.this;
                        fileMsgItem5 = aIOFileViewer2.currentMsgItem;
                        if (fileMsgItem5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        } else {
                            fileMsgItem6 = fileMsgItem5;
                        }
                        aIOFileViewer2.q0(fileMsgItem6.getFileTransNotifyInfo());
                    }
                });
                return true;
            }
            return false;
        }
        return false;
    }

    private final void e0() {
        E().d().setVisibility(4);
        if (this.viewType == 2) {
            View view = this.videoPlayButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoPlayButton");
                view = null;
            }
            view.setVisibility(0);
        }
        V(false, 0);
    }

    private final void f0(FileElement fileElement) {
        String a16 = com.tencent.qqnt.aio.element.file.util.b.a(fileElement.fileSize);
        Intrinsics.checkNotNullExpressionValue(a16, "formatFileSizeNotSync(fileElement.fileSize)");
        this.tvDescText = a16;
        E().g().setText(fileElement.fileName);
        E().a().setImageResource(c81.a.i(com.tencent.qqnt.aio.element.file.util.a.d(fileElement)));
        FileMsgItem fileMsgItem = this.currentMsgItem;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        int A2 = fileMsgItem.A2();
        if (c81.a.n(A2)) {
            r0();
        } else {
            e0();
        }
        x0(fileElement, A2);
        t();
    }

    private final void g0(FileElement fileElement) {
        int i3 = this.viewType;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                f0(fileElement);
                return;
            }
            return;
        }
        RoundBubbleImageView M = M();
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        r(M, fileMsgItem, fileElement, this.listener);
        e0();
        t();
        FileMsgItem fileMsgItem3 = this.currentMsgItem;
        if (fileMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem2 = fileMsgItem3;
        }
        A0(s0(fileMsgItem2.A2()));
    }

    private final boolean h0() {
        MsgElement msgElement = this.element;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement == null || com.tencent.qqnt.aio.element.file.util.a.d(fileElement) != 0) {
            return false;
        }
        return true;
    }

    private final boolean i0(String path, int width, int height, PicContentViewUtil.LoadingImage loadingImage, int originWidth, int originHeight) {
        FileElement fileElement;
        int i3;
        int i16;
        FileMsgItem fileMsgItem = null;
        if (TextUtils.isEmpty(path)) {
            if (QLog.isColorLevel()) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem2 = null;
                }
                QLog.i("AIOFileViewer", 2, "load thumb, thumb path is empty, msgId:" + fileMsgItem2.getMsgId());
            }
            this.loadThumbPath = null;
            if (originWidth <= 0) {
                i3 = width;
            } else {
                i3 = originWidth;
            }
            if (originHeight <= 0) {
                i16 = height;
            } else {
                i16 = originHeight;
            }
            if (y(i3, i16)) {
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem3;
                }
                QLog.i("AIOFileViewer", 1, "[loadThumb] file thumb is large, msgId:" + fileMsgItem.getMsgId());
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(this.loadThumbPath, path)) {
            String str = this.loadThumbPath;
            FileMsgItem fileMsgItem4 = this.currentMsgItem;
            if (fileMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem = fileMsgItem4;
            }
            QLog.i("AIOFileViewer", 1, "[loadThumb] same thumb path loadThumbPath:" + str + ", path: " + path + " , msgId:" + fileMsgItem.getMsgId());
            return true;
        }
        this.loadThumbPath = path;
        if (path != null) {
            FileMsgItem fileMsgItem5 = this.currentMsgItem;
            if (fileMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem5 = null;
            }
            MsgElement q26 = fileMsgItem5.q2();
            if (q26 != null) {
                fileElement = q26.fileElement;
            } else {
                fileElement = null;
            }
            if (fileElement != null) {
                HashMap<Integer, String> hashMap = new HashMap<>();
                hashMap.put(750, path);
                fileElement.picThumbPath = hashMap;
            }
        }
        PicContentViewUtil picContentViewUtil = PicContentViewUtil.f190621a;
        RoundBubbleImageView M = M();
        PicSize picSize = PicSize.PIC_DOWNLOAD_THUMB;
        MsgElement msgElement = this.element;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileMsgItem fileMsgItem6 = this.currentMsgItem;
        if (fileMsgItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem6 = null;
        }
        PicContentViewUtil.i(picContentViewUtil, M, path, picSize, width, height, msgElement, fileMsgItem6, loadingImage, null, 256, null);
        L().setVisibility(8);
        return true;
    }

    private final void j0() {
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        if (fileMsgItem.G2()) {
            if (QLog.isColorLevel()) {
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem3 = null;
                }
                QLog.i("AIOFileViewer", 2, "[onClickFileStateView] pause, msgId=" + fileMsgItem3.getMsgId());
            }
            FileMsgItem fileMsgItem4 = this.currentMsgItem;
            if (fileMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem2 = fileMsgItem4;
            }
            if (o81.a.c(fileMsgItem2)) {
                x();
            } else {
                w();
            }
            this.userSetTransferStatus = 2;
            return;
        }
        if (QLog.isColorLevel()) {
            FileMsgItem fileMsgItem5 = this.currentMsgItem;
            if (fileMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem5 = null;
            }
            QLog.i("AIOFileViewer", 2, "[onClickFileStateView] resume, msgId=" + fileMsgItem5.getMsgId());
        }
        FileMsgItem fileMsgItem6 = this.currentMsgItem;
        if (fileMsgItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem6 = null;
        }
        if (o81.a.d(fileMsgItem6)) {
            FileMsgItem fileMsgItem7 = this.currentMsgItem;
            if (fileMsgItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem7 = null;
            }
            if (fileMsgItem7.getMsgRecord().sendStatus == 0) {
                if (!d0() && QLog.isColorLevel()) {
                    FileMsgItem fileMsgItem8 = this.currentMsgItem;
                    if (fileMsgItem8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        fileMsgItem2 = fileMsgItem8;
                    }
                    QLog.i("AIOFileViewer", 2, "[onClickFileStateView] resume upload, do nothing, msgId=" + fileMsgItem2.getMsgId());
                    return;
                }
                return;
            }
        }
        if (!S() && QLog.isColorLevel()) {
            FileMsgItem fileMsgItem9 = this.currentMsgItem;
            if (fileMsgItem9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem2 = fileMsgItem9;
            }
            QLog.i("AIOFileViewer", 2, "[onClickFileStateView] resume downloading, do nothing, msgId=" + fileMsgItem2.getMsgId());
        }
    }

    private final Button k(RelativeLayout parent, View contentView) {
        Button button = new Button(this.context);
        button.setId(R.id.lcq);
        button.setContentDescription(button.getContext().getString(R.string.b7b));
        this.fileStateView = button;
        if (this.rightSide) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Button button2 = this.fileStateView;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
                button2 = null;
            }
            layoutParams2.addRule(1, button2.getId());
            contentView.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(p.c(21), p.c(21));
            layoutParams3.addRule(8, contentView.getId());
            layoutParams3.rightMargin = p.c(6);
            Button button3 = this.fileStateView;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
                button3 = null;
            }
            button3.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(p.c(21), p.c(21));
            layoutParams4.addRule(1, contentView.getId());
            layoutParams4.addRule(8, contentView.getId());
            layoutParams4.leftMargin = p.c(6);
            Button button4 = this.fileStateView;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
                button4 = null;
            }
            button4.setLayoutParams(layoutParams4);
        }
        Button button5 = this.fileStateView;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button5 = null;
        }
        parent.addView(button5);
        Button button6 = this.fileStateView;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button6 = null;
        }
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOFileViewer.l(AIOFileViewer.this, view);
            }
        });
        Button button7 = this.fileStateView;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            return null;
        }
        return button7;
    }

    private final void k0(AIOBubbleSkinInfo bubbleSkin) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.b bVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.b) {
            bVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.b) b16;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            ViewGroup.LayoutParams layoutParams = E().b().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = Math.min(bVar.k(), f190800u);
            layoutParams2.height = -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AIOFileViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l0(RoundBubbleImageView picView, int viewWidth, int viewHeight) {
        if (picView.getLayoutParams() == null) {
            picView.setLayoutParams(new RelativeLayout.LayoutParams(viewWidth, viewHeight));
            return;
        }
        ViewGroup.LayoutParams layoutParams = picView.getLayoutParams();
        layoutParams.width = viewWidth;
        layoutParams.height = viewHeight;
    }

    private final void m() {
        int i3;
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setId(R.id.v55);
        relativeLayout.setBackgroundResource(R.drawable.guild_aio_filepic_bottombar_bg);
        relativeLayout.setFocusableInTouchMode(true);
        RelativeLayout c16 = E().c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p.c(55));
        layoutParams.addRule(8, R.id.shl);
        layoutParams.addRule(5, R.id.shl);
        layoutParams.addRule(7, R.id.shl);
        Unit unit = Unit.INSTANCE;
        c16.addView(relativeLayout, layoutParams);
        int h16 = c81.a.h(M().getLayoutParams().width, M().getLayoutParams().height);
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.fileNameAndSizeContentLl = linearLayout;
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setId(R.id.sho);
        if (h16 == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        linearLayout.setOrientation(i3);
        RelativeLayout c17 = E().c();
        LinearLayout linearLayout2 = this.fileNameAndSizeContentLl;
        TextView textView = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
            linearLayout2 = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(8, R.id.shl);
        layoutParams2.addRule(5, R.id.shl);
        layoutParams2.addRule(7, R.id.shl);
        c17.addView(linearLayout2, layoutParams2);
        TextView textView2 = new TextView(this.context, null);
        textView2.setId(R.id.shn);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(-1);
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setImportantForAccessibility(2);
        this.picFileNameView = textView2;
        TextView textView3 = new TextView(this.context);
        this.picFileSizeView = textView3;
        textView3.setId(R.id.shk);
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(-1);
        textView3.setImportantForAccessibility(2);
        if (h16 == 1) {
            LinearLayout linearLayout3 = this.fileNameAndSizeContentLl;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
                linearLayout3 = null;
            }
            TextView textView4 = this.picFileNameView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
                textView4 = null;
            }
            linearLayout3.addView(textView4, I(false));
            LinearLayout linearLayout4 = this.fileNameAndSizeContentLl;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
                linearLayout4 = null;
            }
            TextView textView5 = this.picFileSizeView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picFileSizeView");
                textView5 = null;
            }
            linearLayout4.addView(textView5, I(true));
        } else {
            LinearLayout linearLayout5 = this.fileNameAndSizeContentLl;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
                linearLayout5 = null;
            }
            TextView textView6 = this.picFileSizeView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picFileSizeView");
                textView6 = null;
            }
            linearLayout5.addView(textView6, I(true));
            LinearLayout linearLayout6 = this.fileNameAndSizeContentLl;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
                linearLayout6 = null;
            }
            TextView textView7 = this.picFileNameView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
                textView7 = null;
            }
            linearLayout6.addView(textView7, I(false));
        }
        RelativeLayout c18 = E().c();
        TextView L = L();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        c18.addView(L, layoutParams3);
        if (h16 != 1) {
            if (h16 == 2) {
                TextView textView8 = this.picFileNameView;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
                    textView8 = null;
                }
                textView8.setMaxLines(1);
                TextView textView9 = this.picFileNameView;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
                } else {
                    textView = textView9;
                }
                textView.setGravity(5);
                return;
            }
            return;
        }
        TextView textView10 = this.picFileNameView;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
            textView10 = null;
        }
        textView10.setMaxLines(2);
        TextView textView11 = this.picFileSizeView;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picFileSizeView");
        } else {
            textView = textView11;
        }
        textView.setGravity(3);
    }

    private final boolean m0(FileMsgItem msgItem, FileElement fileElement) {
        if (com.tencent.qqnt.aio.element.file.util.a.f(fileElement)) {
            QLog.i("AIOFileViewer", 1, "[handleThumb] file expired, msgItem=" + msgItem);
            return false;
        }
        Integer num = fileElement.invalidState;
        if (num == null || num.intValue() != 0) {
            QLog.i("AIOFileViewer", 1, "[handleThumb] file status is invalid, msgItem=" + msgItem);
            return false;
        }
        if (msgItem.A2() != 5) {
            return true;
        }
        QLog.i("AIOFileViewer", 1, "[handleThumb] file download failed, msgItem=" + msgItem);
        return false;
    }

    private final void n() {
        PicProgressView picProgressView = new PicProgressView(this.context);
        picProgressView.setId(R.id.shm);
        picProgressView.setVisibility(8);
        picProgressView.setRadius(8.0f, true);
        picProgressView.setShowCorner(false);
        PicProgressView picProgressView2 = null;
        picProgressView.setDrawFinishDrawable(null);
        picProgressView.setProgressBackgroudColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        this.picProgressView = picProgressView;
        RelativeLayout c16 = E().c();
        PicProgressView picProgressView3 = this.picProgressView;
        if (picProgressView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
        } else {
            picProgressView2 = picProgressView3;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(6, M().getId());
        layoutParams.addRule(5, M().getId());
        layoutParams.addRule(7, M().getId());
        layoutParams.addRule(8, M().getId());
        Unit unit = Unit.INSTANCE;
        c16.addView(picProgressView2, layoutParams);
    }

    private final boolean n0() {
        FileMsgItem fileMsgItem = this.currentMsgItem;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        return fileMsgItem.G2();
    }

    private final void o() {
        ImageView imageView = new ImageView(this.contentView.getContext());
        imageView.setImageResource(R.drawable.mye);
        this.videoPlayButton = imageView;
        RelativeLayout c16 = E().c();
        View view = this.videoPlayButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoPlayButton");
            view = null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        Unit unit = Unit.INSTANCE;
        c16.addView(view, layoutParams);
    }

    private final void o0(FileTransNotifyInfo fileInfo) {
        Integer num;
        MsgElement msgElement = this.element;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            String b16 = com.tencent.qqnt.aio.element.file.util.b.b(fileElement.fileSize, a.C7329a.f192417a.c());
            Intrinsics.checkNotNullExpressionValue(b16, "formatFileSizeNotSync(it.fileSize, dpi)");
            this.tvDescText = b16;
            e0();
            if (fileInfo != null) {
                num = Integer.valueOf(fileInfo.trasferStatus);
            } else {
                num = fileElement.transferStatus;
            }
            Intrinsics.checkNotNullExpressionValue(num, "fileInfo?.trasferStatus ?: it.transferStatus");
            B0(num.intValue());
        }
    }

    private final boolean p() {
        if (this.viewType != 3) {
            return true;
        }
        int i3 = this.userSetTransferStatus;
        if (i3 == 1) {
            QLog.i("AIOFileViewer", 1, "allowCancelStatusUpdate intercept");
            return false;
        }
        if (i3 == 2) {
            this.userSetTransferStatus = 0;
            QLog.i("AIOFileViewer", 1, "allowCancelStatusUpdate reset");
        }
        return true;
    }

    private final void p0(int progress) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOFileViewer", 4, "[showProgress]: progress is " + progress);
        }
        E().d().setProgress(progress);
        r0();
        V(n0(), progress);
        if (this.viewType == 2) {
            View view = this.videoPlayButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoPlayButton");
                view = null;
            }
            view.setVisibility(4);
        }
    }

    private final boolean q() {
        if (this.viewType != 3) {
            return true;
        }
        int i3 = this.userSetTransferStatus;
        if (i3 == 2) {
            QLog.i("AIOFileViewer", 1, "allowTransferringStatusUpdate intercept");
            return false;
        }
        if (i3 == 1) {
            this.userSetTransferStatus = 0;
            QLog.i("AIOFileViewer", 1, "allowTransferringStatusUpdate reset");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(FileTransNotifyInfo fileInfo) {
        MsgElement msgElement = this.element;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        p0(at.f194116a.b(msgElement, 3, fileInfo));
    }

    private final void r(final RoundBubbleImageView picView, FileMsgItem msgItem, FileElement fileElement, final Function3<? super AIOMsgItem, ? super FileElement, ? super View, Unit> listener) {
        TextView textView = this.picFileNameView;
        FileMsgItem fileMsgItem = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picFileNameView");
            textView = null;
        }
        textView.setText(fileElement.fileName);
        TextView textView2 = this.picFileSizeView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picFileSizeView");
            textView2 = null;
        }
        textView2.setText(com.tencent.qqnt.aio.element.file.util.b.b(fileElement.fileSize, 0));
        if (h0()) {
            LinearLayout linearLayout = this.fileNameAndSizeContentLl;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameAndSizeContentLl");
                linearLayout = null;
            }
            linearLayout.setContentDescription(fileElement.fileName + com.tencent.qqnt.aio.element.file.util.b.b(fileElement.fileSize, 0));
        }
        picView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOFileViewer.s(Function3.this, this, picView, view);
            }
        });
        Z(picView, msgItem, fileElement);
        PicProgressView picProgressView = this.picProgressView;
        if (picProgressView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picProgressView");
            picProgressView = null;
        }
        FileMsgItem fileMsgItem2 = this.currentMsgItem;
        if (fileMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem = fileMsgItem2;
        }
        picProgressView.setProgressProvider(fileMsgItem.s2());
    }

    private final void r0() {
        E().d().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function3 listener, AIOFileViewer this$0, RoundBubbleImageView picView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(picView, "$picView");
        FileMsgItem fileMsgItem = this$0.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        FileMsgItem fileMsgItem3 = this$0.currentMsgItem;
        if (fileMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem2 = fileMsgItem3;
        }
        listener.invoke(fileMsgItem, fileMsgItem2.n2(), picView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int s0(int transferStatus) {
        MsgElement msgElement = null;
        FileMsgItem fileMsgItem = null;
        switch (transferStatus) {
            case 0:
            case 1:
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "transferStatusToUIState transferStatus " + transferStatus);
                return 3;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                MsgElement msgElement2 = this.element;
                if (msgElement2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                } else {
                    msgElement = msgElement2;
                }
                if (c81.a.g(msgElement.fileElement.filePath)) {
                    return 6;
                }
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "transferStatusToUIState fileExistsAndNotEmpty " + transferStatus);
                return 3;
            case 5:
            case 6:
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem2 = null;
                }
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "transferStatusToUIState Cancel or Fail\uff0c transfer status:" + transferStatus + ", sendStatus: " + fileMsgItem2.getMsgRecord().sendStatus + " ");
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem3 = null;
                }
                if (fileMsgItem3.getMsgRecord().sendStatus != 2) {
                    FileMsgItem fileMsgItem4 = this.currentMsgItem;
                    if (fileMsgItem4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        fileMsgItem = fileMsgItem4;
                    }
                    if (fileMsgItem.K0()) {
                        return 2;
                    }
                }
                return 5;
            default:
                return 6;
        }
    }

    private final void t() {
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        if (fileMsgItem.G2()) {
            FileMsgItem fileMsgItem3 = this.currentMsgItem;
            if (fileMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                fileMsgItem2 = fileMsgItem3;
            }
            W(fileMsgItem2.getFileTransNotifyInfo());
        }
    }

    private final void u(ViewGroup contentView) {
        ViewGroup viewGroup;
        ViewParent parent = E().e().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(E().e());
        }
        contentView.setPadding(p.c(7), p.c(7), p.c(7), p.c(7));
        View e16 = E().e();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        Unit unit = Unit.INSTANCE;
        contentView.addView(e16, layoutParams);
        E().b().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOFileViewer.v(AIOFileViewer.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AIOFileViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v0(FileElement fileElement, int transferStatus) {
        String str;
        String J = J(this.context, fileElement, transferStatus);
        TextView f16 = E().f();
        String str2 = this.tvDescText;
        if (TextUtils.isEmpty(J)) {
            str = "";
        } else {
            str = " / " + J;
        }
        f16.setText(str2 + str);
    }

    private final void w() {
        IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
        FileMsgItem fileMsgItem = this.currentMsgItem;
        MsgElement msgElement = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        iAIOFileManagerApi.cancelDownloadFile(fileMsgItem);
        FileMsgItem fileMsgItem2 = this.currentMsgItem;
        if (fileMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem2 = null;
        }
        fileMsgItem2.K2(6);
        e0();
        MsgElement msgElement2 = this.element;
        if (msgElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
        } else {
            msgElement = msgElement2;
        }
        FileElement fileElement = msgElement.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "element.fileElement");
        x0(fileElement, 6);
    }

    private final void x() {
        IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        iAIOFileManagerApi.cancelSendFile(fileMsgItem);
        FileMsgItem fileMsgItem3 = this.currentMsgItem;
        if (fileMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem2 = fileMsgItem3;
        }
        fileMsgItem2.K2(6);
        e0();
        B0(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(FileElement fileElement, int transferStatus) {
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "updateFileStatus fileElement " + fileElement + ", transferStatus " + transferStatus);
        v0(fileElement, transferStatus);
        y0(s0(transferStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (com.tencent.qqnt.kernel.nativeinterface.bj.N(r3, r12, r13) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean y(int width, int height) {
        long j3;
        int i3 = 0;
        boolean z16 = true;
        if (this.viewType == 1) {
            FileMsgItem fileMsgItem = this.currentMsgItem;
            if (fileMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem = null;
            }
            FileElement n26 = fileMsgItem.n2();
            if (n26 != null) {
                j3 = n26.fileSize;
            } else {
                j3 = 0;
            }
        }
        z16 = false;
        TextView L = L();
        if (!z16) {
            i3 = 8;
        }
        L.setVisibility(i3);
        return z16;
    }

    private final void y0(int statusType) {
        int i3;
        Button button = this.fileStateView;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button = null;
        }
        if (statusType == 6) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        button.setVisibility(i3);
        Button button3 = this.fileStateView;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
            button3 = null;
        }
        button3.setBackground(G(K(statusType)));
        Button button4 = this.fileStateView;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileStateView");
        } else {
            button2 = button4;
        }
        button2.setContentDescription(P(statusType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoundBubbleImageView z(Context context) {
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context);
        roundBubbleImageView.setRadiusDP(8.0f);
        return roundBubbleImageView;
    }

    @NotNull
    public final View D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return E().g();
    }

    @NotNull
    public final ViewGroup F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contentView;
    }

    @Nullable
    public final RoundBubbleImageView N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RoundBubbleImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.viewType;
        if (i3 != 1 && i3 != 2) {
            return null;
        }
        return M();
    }

    public final boolean S() {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        MsgElement msgElement = this.element;
        MsgElement msgElement2 = null;
        FileMsgItem fileMsgItem = null;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            if (com.tencent.qqnt.aio.element.file.util.a.f(fileElement) && !c81.a.g(fileElement.filePath)) {
                String string = this.context.getString(R.string.yqs);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.aio_file_overtime)");
                QQToast.makeText(this.context, 1, string, 1).show();
                return true;
            }
            Integer num = fileElement.invalidState;
            if (num == null || num.intValue() != 0) {
                String string2 = this.context.getString(R.string.yqr);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.aio_file_invalid)");
                QQToast.makeText(this.context, 1, string2, 1).show();
                return true;
            }
            FileMsgItem fileMsgItem2 = this.currentMsgItem;
            if (fileMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem2 = null;
            }
            if (com.tencent.qqnt.aio.element.file.util.a.b(fileMsgItem2)) {
                a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
                IAIOFileErrHandler iAIOFileErrHandler = (IAIOFileErrHandler) companion.a(IAIOFileErrHandler.class);
                FileMsgItem fileMsgItem3 = this.currentMsgItem;
                if (fileMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem3 = null;
                }
                long j3 = fileMsgItem3.getMsgRecord().msgId;
                FileMsgItem fileMsgItem4 = this.currentMsgItem;
                if (fileMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem4 = null;
                }
                int i3 = fileMsgItem4.getMsgRecord().chatType;
                FileMsgItem fileMsgItem5 = this.currentMsgItem;
                if (fileMsgItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem5 = null;
                }
                String str = fileMsgItem5.getMsgRecord().peerUid;
                FileMsgItem fileMsgItem6 = this.currentMsgItem;
                if (fileMsgItem6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem6 = null;
                }
                iAIOFileErrHandler.registerFileIdListen(j3, new Contact(i3, str, fileMsgItem6.getMsgRecord().guildId));
                IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) companion.a(IAIOFileManagerApi.class);
                Context context = this.context;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                FileMsgItem fileMsgItem7 = this.currentMsgItem;
                if (fileMsgItem7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem7;
                }
                iAIOFileManagerApi.downloadFile(activity, fileMsgItem, new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileViewer$handleDownloadFile$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFileViewer.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FileMsgItem fileMsgItem8;
                        MsgElement msgElement3;
                        FileMsgItem fileMsgItem9;
                        FileMsgItem fileMsgItem10;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AIOFileViewer.this.userSetTransferStatus = 1;
                        fileMsgItem8 = AIOFileViewer.this.currentMsgItem;
                        FileMsgItem fileMsgItem11 = null;
                        if (fileMsgItem8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            fileMsgItem8 = null;
                        }
                        if (fileMsgItem8.getMsgRecord().chatType == 2) {
                            fileMsgItem10 = AIOFileViewer.this.currentMsgItem;
                            if (fileMsgItem10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                                fileMsgItem10 = null;
                            }
                            fileMsgItem10.K2(3);
                        }
                        AIOFileViewer aIOFileViewer = AIOFileViewer.this;
                        msgElement3 = aIOFileViewer.element;
                        if (msgElement3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                            msgElement3 = null;
                        }
                        FileElement fileElement2 = msgElement3.fileElement;
                        Intrinsics.checkNotNullExpressionValue(fileElement2, "element.fileElement");
                        aIOFileViewer.x0(fileElement2, 3);
                        AIOFileViewer aIOFileViewer2 = AIOFileViewer.this;
                        fileMsgItem9 = aIOFileViewer2.currentMsgItem;
                        if (fileMsgItem9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        } else {
                            fileMsgItem11 = fileMsgItem9;
                        }
                        aIOFileViewer2.q0(fileMsgItem11.getFileTransNotifyInfo());
                    }
                });
                return true;
            }
            FileMsgItem fileMsgItem8 = this.currentMsgItem;
            if (fileMsgItem8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem8 = null;
            }
            int B2 = fileMsgItem8.B2();
            FileMsgItem fileMsgItem9 = this.currentMsgItem;
            if (fileMsgItem9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem9 = null;
            }
            QLog.d("AIOFileViewer", 1, "handleDownloadFile currentMsgItem.uiFileStatus:" + B2 + ", currentMsgItem.fileTransNotifyInfo.trasferStatus:" + fileMsgItem9.getFileTransNotifyInfo().trasferStatus + ", fileElement transferStatus: " + fileElement.transferStatus);
            FileMsgItem fileMsgItem10 = this.currentMsgItem;
            if (fileMsgItem10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                fileMsgItem10 = null;
            }
            if (fileMsgItem10.A2() == 4) {
                FileMsgItem fileMsgItem11 = this.currentMsgItem;
                if (fileMsgItem11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    fileMsgItem11 = null;
                }
                MsgElement msgElement3 = this.element;
                if (msgElement3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
                } else {
                    msgElement2 = msgElement3;
                }
                u0(fileMsgItem11, msgElement2);
                return false;
            }
            return false;
        }
        return false;
    }

    @MainThread
    public final void t0(@NotNull String msg2, @NotNull Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(payload, "payload");
        a.p pVar = null;
        FileTransNotifyInfo fileTransNotifyInfo = null;
        a.ay ayVar = null;
        switch (msg2.hashCode()) {
            case -975146884:
                if (msg2.equals("file_transfer_end_state")) {
                    a0();
                    return;
                }
                return;
            case -709614427:
                if (msg2.equals("file_transfer_progress_status_state")) {
                    b0();
                    return;
                }
                return;
            case -293432491:
                if (msg2.equals("file_transfer_status_state")) {
                    if (payload instanceof a.p) {
                        pVar = (a.p) payload;
                    }
                    c0(pVar);
                    return;
                }
                return;
            case 1110107165:
                if (msg2.equals("msg_send_status_state")) {
                    if (payload instanceof a.ay) {
                        ayVar = (a.ay) payload;
                    }
                    Y(ayVar);
                    return;
                }
                return;
            case 1731426707:
                if (msg2.equals("rich_media_state")) {
                    if (payload instanceof FileTransNotifyInfo) {
                        fileTransNotifyInfo = (FileTransNotifyInfo) payload;
                    }
                    W(fileTransNotifyInfo);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u0(@NotNull FileMsgItem msgItem, @NotNull MsgElement msgElement) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem, (Object) msgElement);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        this.element = msgElement;
        this.currentMsgItem = msgItem;
        this.userSetTransferStatus = 0;
        FileMsgItem fileMsgItem = null;
        if (msgElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            msgElement = null;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            int R = R(com.tencent.qqnt.aio.element.file.util.a.d(fileElement));
            if (R == 2) {
                FileMsgItem fileMsgItem2 = this.currentMsgItem;
                if (fileMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    fileMsgItem = fileMsgItem2;
                }
                if (fileMsgItem.getMsgRecord().chatType == 8) {
                    a16 = 3;
                    if (this.viewType != a16) {
                        this.viewType = a16;
                        C(a16);
                    }
                    g0(fileElement);
                    u(this.contentView);
                }
            }
            a16 = c.a(R, fileElement);
            if (this.viewType != a16) {
            }
            g0(fileElement);
            u(this.contentView);
        }
    }

    public final void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.viewType != 3) {
            QLog.i("AIOFileViewer", 1, "not file type, do not update file status!");
            return;
        }
        FileMsgItem fileMsgItem = this.currentMsgItem;
        FileMsgItem fileMsgItem2 = null;
        if (fileMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem = null;
        }
        int A2 = fileMsgItem.A2();
        if (A2 != 4) {
            return;
        }
        FileMsgItem fileMsgItem3 = this.currentMsgItem;
        if (fileMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            fileMsgItem3 = null;
        }
        QLog.d("AIOFileViewer", 1, "updateFileState currentMsgItem.getFileElement()!! is " + fileMsgItem3.n2() + ", transferStatus is " + A2);
        FileMsgItem fileMsgItem4 = this.currentMsgItem;
        if (fileMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            fileMsgItem2 = fileMsgItem4;
        }
        FileElement n26 = fileMsgItem2.n2();
        Intrinsics.checkNotNull(n26);
        x0(n26, A2);
    }

    public final void z0(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        int d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        FileMsgItem fileMsgItem = (FileMsgItem) msgItem;
        this.currentMsgItem = fileMsgItem;
        MsgElement firstTypeElement = fileMsgItem.getFirstTypeElement(3);
        Intrinsics.checkNotNull(firstTypeElement);
        this.element = firstTypeElement;
        if (firstTypeElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DTConstants.TAG.ELEMENT);
            firstTypeElement = null;
        }
        FileElement fileElement = firstTypeElement.fileElement;
        if (fileElement != null && (d16 = com.tencent.qqnt.aio.element.file.util.a.d(fileElement)) != 2 && d16 != 0) {
            E().b().setBackground(G(R.drawable.j6w));
        }
    }
}
