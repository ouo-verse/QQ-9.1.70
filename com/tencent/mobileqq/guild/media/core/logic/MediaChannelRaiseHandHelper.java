package com.tencent.mobileqq.guild.media.core.logic;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.MediaBusinessType;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.es;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0006\u00a7\u0001\u00ab\u0001\u00af\u0001\u0018\u0000 \u00b9\u00012\u00020\u0001:\u0006\u00ba\u0001\u00bb\u0001\u00bc\u0001B\u0013\u0012\b\u0010\u0094\u0001\u001a\u00030\u0091\u0001\u00a2\u0006\u0006\b\u00b7\u0001\u0010\u00b8\u0001J,\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J:\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u001c\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0002J \u0010\u001c\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0006H\u0002J\u0016\u0010\u001e\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010#\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\bH\u0002J \u0010)\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'H\u0002J0\u0010+\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0002J \u0010,\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0002J \u0010-\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0002J(\u00100\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0006H\u0002J@\u00107\u001a\u00020\b26\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01H\u0002J\b\u00108\u001a\u00020\bH\u0002J \u00109\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020.H\u0002J0\u0010=\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0015H\u0002J0\u0010>\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0015H\u0002J8\u0010B\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J8\u0010C\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J8\u0010D\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J0\u0010F\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J8\u0010G\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J8\u0010H\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J\u0012\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010M\u001a\u00020\b2\u0006\u0010L\u001a\u00020KH\u0002J\b\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020\u0006H\u0002J\b\u0010P\u001a\u00020\u0006H\u0002J\u001c\u0010Q\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u0014H\u0002J8\u0010R\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00142\b\u0010;\u001a\u0004\u0018\u00010\u00142\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`@H\u0002J\b\u0010S\u001a\u00020\u0006H\u0002J\b\u0010U\u001a\u00020TH\u0002J\u0010\u0010W\u001a\u00020V2\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u0010;\u001a\u00020\u0014H\u0002J\b\u0010Y\u001a\u00020VH\u0002J\u0012\u0010[\u001a\u00020Z2\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0002J\u0012\u0010]\u001a\u00020\\2\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0002J\u001e\u0010_\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010a\u001a\u00020\b2\u0006\u0010`\u001a\u00020\u0006H\u0002J\u001e\u0010b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0002J \u0010c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010d\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010e\u001a\u00020\bH\u0002J\n\u0010g\u001a\u0004\u0018\u00010fH\u0002J\u0010\u0010h\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0014H\u0002J\b\u0010i\u001a\u00020\bH\u0002J\u0010\u0010l\u001a\u00020\b2\u0006\u0010k\u001a\u00020jH\u0002J\u0010\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020jH\u0002J\b\u0010o\u001a\u00020\bH\u0002J(\u0010t\u001a\u00020\b2\u0006\u0010p\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u00142\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\b0rH\u0002J\u0006\u0010u\u001a\u00020\u001fJ\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010x\u001a\u00020\bH\u0016J\b\u0010y\u001a\u00020\bH\u0016J\b\u0010z\u001a\u00020\bH\u0016J\b\u0010{\u001a\u00020\bH\u0016J\b\u0010|\u001a\u00020\bH\u0016J\b\u0010}\u001a\u00020\bH\u0016J\u0006\u0010~\u001a\u00020!J\u0006\u0010\u007f\u001a\u00020\u0006J\u0007\u0010\u0080\u0001\u001a\u00020\u0006JO\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u000626\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01JG\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001426\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01JG\u0010\u0083\u0001\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001426\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01JX\u0010\u0086\u0001\u001a\u00020\b2O\b\u0002\u00106\u001aI\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0014\u0012\u00120\u0006\u00a2\u0006\r\b2\u0012\t\b3\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00020\b0\u0084\u0001JH\u0010\u0088\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\u000626\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01JH\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\u000626\u00106\u001a2\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b01J)\u0010\u008c\u0001\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0007\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u008b\u0001\u001a\u00020VJ\u001f\u0010\u008d\u0001\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u0007\u0010\u008e\u0001\u001a\u00020\u0006J\u0007\u0010\u008f\u0001\u001a\u00020\bJ\u0007\u0010\u0090\u0001\u001a\u00020\bR\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0097\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0099\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u0019\u0010\u00a4\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u009e\u0001R\u0019\u0010\u00a6\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u009e\u0001R\u0018\u0010\u00aa\u0001\u001a\u00030\u00a7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u0018\u0010\u00ae\u0001\u001a\u00030\u00ab\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0018\u0010\u00b2\u0001\u001a\u00030\u00af\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u0018\u0010\u00b6\u0001\u001a\u00030\u00b3\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "Lcom/tencent/mobileqq/guild/media/core/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "waitList", "handledList", "", "forceRefresh", "", "E2", "sort", "updateList", "", "operateList", "filterList", Constants.BASE_IN_PLUGIN_VERSION, ITVKPlayerEventListener.KEY_USER_INFO, "userInfoList", "j2", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/es;", "R1", "tinyId", "Q1", "removeList", "i2", "notifyData", "g2", "changeList", "T1", "", UserInfo.USERSTATE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$RaiseHandState;", "forceState", "B2", ICustomDataEditor.NUMBER_PARAM_2, "result", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAudioLiveUserListRsp;", "rspInfo", ICustomDataEditor.STRING_ARRAY_PARAM_2, "accept", "Y1", "Z1", "U1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserAVRspInfo;", "isNotClicked", "c2", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "retCode", "retMsg", "callback", "O1", "M1", "b2", "guildId", "channelId", "userCtlInfo", "F1", "E1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "userList", "H1", "K1", Constants.APK_CERTIFICATE, "nickName", Constants.BASE_IN_PLUGIN_ID, "J1", "I1", "channelUin", "B1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "C1", "P1", "W0", "h1", "Y0", "d1", "g1", "Luh2/b;", "t1", "", "e2", "d2", "w1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fc;", "y1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/o;", "r1", "checkList", ICustomDataEditor.STRING_ARRAY_PARAM_1, "hasRight", NowProxyConstants.AccountInfoKey.A2, "c1", "b1", "z2", "S1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", ICustomDataEditor.STRING_PARAM_1, "w2", "r2", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$ShowDialogEventType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "L1", "type", "p2", "q2", "resCode", "reason", "Lkotlin/Function0;", "onConfirm", "t2", "x1", "v1", "u1", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "f2", "y2", "E0", "u", "f1", "e1", "X0", "l1", ICustomDataEditor.NUMBER_PARAM_1, "j1", "Lkotlin/Function3;", "needToast", "k2", "invite", "p1", "q1", "bAllow", "source", "A1", "i1", "Z0", "W1", "V1", "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$ShowDialogEventType;", "lastShowDialogEvent", "i", "Ljava/util/List;", "waitingRequestList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "handledRequestList", BdhLogUtil.LogTag.Tag_Conn, "Z", "selfHasRaiseHandRight", "D", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$RaiseHandState;", "selfRaiseHandState", "E", "mediaActivityActive", com.heytap.databaseengine.model.UserInfo.SEX_FEMALE, "selfHasRequestRaiseHand", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$g", "G", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$g;", "talkPermissionUpdateObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$f", "H", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$f;", "speakModeChangeObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$e", "I", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$e;", "observer", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "O", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "J", "a", "RaiseHandState", "ShowDialogEventType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelRaiseHandHelper extends com.tencent.mobileqq.guild.media.core.d {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    private boolean selfHasRaiseHandRight;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private RaiseHandState selfRaiseHandState;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mediaActivityActive;

    /* renamed from: F */
    private boolean selfHasRequestRaiseHand;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final g talkPermissionUpdateObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final f speakModeChangeObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e observer;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: h */
    @NotNull
    private ShowDialogEventType lastShowDialogEvent;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final List<IGProUserInfo> waitingRequestList;

    /* renamed from: m */
    @NotNull
    private final List<IGProUserInfo> handledRequestList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$RaiseHandState;", "", "(Ljava/lang/String;I)V", "MANAGER", "PLAIN_USER_NOT_CLICK", "PLAIN_USER_CLICKED", "PLAIN_USER_HAS_RIGHT", "NONE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum RaiseHandState {
        MANAGER,
        PLAIN_USER_NOT_CLICK,
        PLAIN_USER_CLICKED,
        PLAIN_USER_HAS_RIGHT,
        NONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$ShowDialogEventType;", "", "(Ljava/lang/String;I)V", "MANAGER_INVITE_RAISE_HAND", "MANAGER_AGREE_RAISE_HAND", "MANAGER_INVITE_OPEN_MIC_IN_QUEUE", "MANAGER_INVITE_OPEN_MIC_IN_FREE", "NONE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ShowDialogEventType {
        MANAGER_INVITE_RAISE_HAND,
        MANAGER_AGREE_RAISE_HAND,
        MANAGER_INVITE_OPEN_MIC_IN_QUEUE,
        MANAGER_INVITE_OPEN_MIC_IN_FREE,
        NONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$a;", "", "", "state", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int state) {
            if (state == 2) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f228216a;

        static {
            int[] iArr = new int[ShowDialogEventType.values().length];
            try {
                iArr[ShowDialogEventType.MANAGER_AGREE_RAISE_HAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShowDialogEventType.MANAGER_INVITE_RAISE_HAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShowDialogEventType.MANAGER_INVITE_OPEN_MIC_IN_QUEUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShowDialogEventType.MANAGER_INVITE_OPEN_MIC_IN_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f228216a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: a */
        final /* synthetic */ boolean f228217a;

        /* renamed from: b */
        final /* synthetic */ MediaChannelRaiseHandHelper f228218b;

        /* renamed from: c */
        final /* synthetic */ RaiseHandState f228219c;

        /* renamed from: d */
        final /* synthetic */ Function2<Integer, String, Unit> f228220d;

        /* JADX WARN: Multi-variable type inference failed */
        c(boolean z16, MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, RaiseHandState raiseHandState, Function2<? super Integer, ? super String, Unit> function2) {
            this.f228217a = z16;
            this.f228218b = mediaChannelRaiseHandHelper;
            this.f228219c = raiseHandState;
            this.f228220d = function2;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger logger = Logger.f235387a;
            boolean z16 = this.f228217a;
            MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper = this.f228218b;
            boolean z17 = true;
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserAcceptInvitation: invite[" + z16 + "] channelId[" + mediaChannelRaiseHandHelper.mediaChannelCore.E() + "] result[" + result + "] errMsg[" + errMsg + "]");
            if (result != 0 && this.f228217a) {
                MediaChannelRaiseHandHelper.C2(this.f228218b, 0, this.f228219c, 1, null);
            }
            com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
            if (result != 0) {
                z17 = false;
            }
            d16.i(new com.tencent.mobileqq.guild.media.core.notify.ac(z17));
            this.f228220d.invoke(Integer.valueOf(result), errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$d", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.i {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnPushCanceledSpeak: result[" + result + "] errMsg[" + errMsg + "]");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016JB\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014JB\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014JB\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014JB\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J0\u0010\u0016\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0014JB\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J4\u0010\u001f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH\u0014J\"\u0010\"\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dH\u0014J\u001c\u0010%\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0014\u00a8\u0006&"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "", "onPushUserHandUpResult", "onPushAVUserStateChange", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "userList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "onUserHandUpRequestNotifyForAll", "onUserWaitingToSpeakNotifyForAll", "onUserSpeakingNotifyForAll", "onUserAVStateResetNotifyForAll", "tinyId", "nickName", "onPushInvitationRefused", "onUserLeaveListNotifyForAll", "channelUin", "onChannelInfoUpdated", "onPushCanceledSpeak", "", "changeType", "", "tinyIdList", "onChannelAdminChange", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProRoleMemberChange;", "changeList", "onChangeRoleMember", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeRoleMember(@Nullable String guildId, @Nullable List<IGProRoleMemberChange> changeList) {
            if (TextUtils.equals(guildId, MediaChannelRaiseHandHelper.this.mediaChannelCore.getGuildID())) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onChangeRoleMember: guildId[" + guildId + "]");
                MediaChannelRaiseHandHelper.C2(MediaChannelRaiseHandHelper.this, 0, null, 3, null);
                MediaChannelRaiseHandHelper.this.P1();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(@Nullable String guildId, @Nullable String channelId, int changeType, @Nullable List<String> tinyIdList) {
            if (TextUtils.equals(guildId, MediaChannelRaiseHandHelper.this.mediaChannelCore.getGuildID()) && TextUtils.equals(channelId, MediaChannelRaiseHandHelper.this.mediaChannelCore.E())) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onChannelAdminChange: channelId[" + channelId + "]");
                MediaChannelRaiseHandHelper.C2(MediaChannelRaiseHandHelper.this, 0, null, 3, null);
                MediaChannelRaiseHandHelper.this.P1();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            MediaChannelRaiseHandHelper.this.B1(channelUin);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx r46) {
            if (TextUtils.equals(guildId, MediaChannelRaiseHandHelper.this.mediaChannelCore.getGuildID())) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onGuildPermissionChanged: guildId[" + guildId + "]");
                MediaChannelRaiseHandHelper.C2(MediaChannelRaiseHandHelper.this, 0, null, 3, null);
                MediaChannelRaiseHandHelper.this.P1();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushAVUserStateChange(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            if (userStateInfo != null) {
                MediaChannelRaiseHandHelper.this.E1(userStateInfo.getGuildId(), userStateInfo.getChannelId(), String.valueOf(userStateInfo.getTinyId()), userStateInfo.getUserCtlInfo());
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushCanceledSpeak(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            if (userStateInfo != null) {
                MediaChannelRaiseHandHelper.this.C1(userStateInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushInvitationRefused(@Nullable String guildId, @Nullable String channelId, @Nullable String tinyId, @Nullable String nickName) {
            MediaChannelRaiseHandHelper.this.D1(guildId, channelId, tinyId, nickName);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushUserHandUpResult(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            if (userStateInfo != null) {
                MediaChannelRaiseHandHelper.this.F1(userStateInfo.getGuildId(), userStateInfo.getChannelId(), String.valueOf(userStateInfo.getTinyId()), userStateInfo.getUserCtlInfo());
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserAVStateResetNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            MediaChannelRaiseHandHelper.this.G1(guildId, channelId, userList);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserHandUpRequestNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            MediaChannelRaiseHandHelper.this.H1(guildId, channelId, userList);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserLeaveListNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            MediaChannelRaiseHandHelper.this.I1(guildId, channelId, userList);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserSpeakingNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            MediaChannelRaiseHandHelper.this.J1(guildId, channelId, userList);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserWaitingToSpeakNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            MediaChannelRaiseHandHelper.this.K1(guildId, channelId, userList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/z;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.z> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.z event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onEventReceive[MediaChannelSpeakModelChanged], oldMode: " + event.getOldSpeakModel() + ", newMode: " + event.getNewSpeakModel());
            if (MediaChannelRaiseHandHelper.this.selfRaiseHandState == RaiseHandState.MANAGER) {
                MediaChannelRaiseHandHelper.this.n2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bi> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getChangeType() == MediaChannelPermissionHelper.PermissionChangeType.RAISE_HAND) {
                return;
            }
            if (event.getHasTalkPermission()) {
                MediaChannelRaiseHandHelper.C2(MediaChannelRaiseHandHelper.this, 0, RaiseHandState.NONE, 1, null);
            } else {
                MediaChannelRaiseHandHelper.C2(MediaChannelRaiseHandHelper.this, 0, null, 3, null);
            }
        }
    }

    public MediaChannelRaiseHandHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.lastShowDialogEvent = ShowDialogEventType.NONE;
        this.waitingRequestList = new ArrayList();
        this.handledRequestList = new ArrayList();
        this.selfRaiseHandState = RaiseHandState.NONE;
        this.mediaActivityActive = true;
        this.talkPermissionUpdateObserver = new g();
        this.speakModeChangeObserver = new f();
        this.observer = new e();
    }

    private final void A2(boolean z16) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "updateSelfRaiseHandRight: hasRight[" + z16 + "]");
        this.selfHasRaiseHandRight = z16;
    }

    public final void B1(String channelUin) {
        if (!Y0(this.mediaChannelCore.getGuildID(), channelUin)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserLeaveListNotifyForAll: channelId[" + channelUin + "]");
        IGProChannelInfo s16 = s1();
        if (s16 != null && s16.getAllowOtherRaiseHand() == 0) {
            A2(false);
        }
        RaiseHandState raiseHandState = this.selfRaiseHandState;
        C2(this, 0, null, 3, null);
        RaiseHandState raiseHandState2 = this.selfRaiseHandState;
        if (raiseHandState != raiseHandState2) {
            if (raiseHandState2 == RaiseHandState.MANAGER) {
                n2();
            } else {
                this.waitingRequestList.clear();
                this.handledRequestList.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B2(int r46, RaiseHandState forceState) {
        RaiseHandState raiseHandState;
        RaiseHandState raiseHandState2 = RaiseHandState.MANAGER;
        if (g1()) {
            if (W0()) {
                raiseHandState = RaiseHandState.MANAGER;
            } else if (h1()) {
                raiseHandState = RaiseHandState.PLAIN_USER_NOT_CLICK;
            } else {
                raiseHandState = RaiseHandState.NONE;
            }
        } else {
            raiseHandState = RaiseHandState.NONE;
        }
        RaiseHandState raiseHandState3 = RaiseHandState.NONE;
        if (raiseHandState == RaiseHandState.PLAIN_USER_NOT_CLICK) {
            if (forceState == raiseHandState3) {
                if (this.selfHasRaiseHandRight) {
                    forceState = RaiseHandState.PLAIN_USER_HAS_RIGHT;
                } else if (r46 != 2) {
                    if (r46 == 3 || r46 == 4) {
                        forceState = RaiseHandState.PLAIN_USER_HAS_RIGHT;
                    }
                } else {
                    forceState = RaiseHandState.PLAIN_USER_CLICKED;
                }
            }
            if (forceState != raiseHandState3) {
                raiseHandState = forceState;
            }
            Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "updateSelfRaiseHandState: curState[" + this.selfRaiseHandState + "] tempState[" + raiseHandState + "]");
            if (raiseHandState == this.selfRaiseHandState) {
                this.selfRaiseHandState = raiseHandState;
                this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ap(raiseHandState));
                this.mediaChannelCore.C().S0(MediaChannelPermissionHelper.PermissionChangeType.RAISE_HAND);
                return;
            }
            return;
        }
        forceState = raiseHandState3;
        if (forceState != raiseHandState3) {
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "updateSelfRaiseHandState: curState[" + this.selfRaiseHandState + "] tempState[" + raiseHandState + "]");
        if (raiseHandState == this.selfRaiseHandState) {
        }
    }

    public final void C1(IGProAVUserStateChangeInfo userStateInfo) {
        if (Y0(userStateInfo.getGuildId(), userStateInfo.getChannelId()) && Q() && TextUtils.equals(this.mediaChannelCore.getSelfUserInfo().f228093a, String.valueOf(userStateInfo.getTinyId()))) {
            Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnPushCanceledSpeak: channelId[" + userStateInfo.getChannelId() + "]");
            this.mediaChannelCore.J().i(false, new d());
            A2(false);
            C2(this, 0, RaiseHandState.PLAIN_USER_NOT_CLICK, 1, null);
        }
    }

    static /* synthetic */ void C2(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, int i3, RaiseHandState raiseHandState, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            raiseHandState = RaiseHandState.NONE;
        }
        mediaChannelRaiseHandHelper.B2(i3, raiseHandState);
    }

    public final void D1(String str, String str2, String str3, String str4) {
        if (!Y0(str, str2)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnPushInvitationRefused: guildId[" + str + "] channelId[" + str2 + "] tinyId[" + str3 + "]");
        if (str4 == null) {
            str4 = "";
        }
        w2(str4);
    }

    private final void D2(boolean z16, List<? extends IGProUserInfo> list, List<IGProUserInfo> list2, List<? extends IGProUserInfo> list3) {
        ArrayList arrayList = new ArrayList();
        for (IGProUserInfo iGProUserInfo : list) {
            if (a1(iGProUserInfo, list2)) {
                j2(iGProUserInfo, list2);
            } else {
                arrayList.add(iGProUserInfo);
            }
        }
        if (!z16) {
            arrayList.addAll(0, list2);
        } else {
            arrayList.addAll(list2);
        }
        list2.clear();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!a1((IGProUserInfo) obj, list3)) {
                arrayList2.add(obj);
            }
        }
        list2.addAll(arrayList2);
    }

    public final void E1(String guildId, String channelId, String tinyId, es userCtlInfo) {
        Integer num;
        if (!Y0(guildId, channelId) || !TextUtils.equals(tinyId, ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).getSelfTinyId())) {
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        if (userCtlInfo != null) {
            num = Integer.valueOf(userCtlInfo.b());
        } else {
            num = null;
        }
        d16.i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleRaiseHandInInviteCome: guildId[" + guildId + "] channelId[" + channelId + "] nextAVState " + num);
        if (userCtlInfo == null) {
            return;
        }
        Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (value != null && value.intValue() == 6) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleRaiseHandRequestResult: third APP mode return");
            return;
        }
        if (userCtlInfo.b() == 7) {
            if (MediaChannelUtils.o(MediaChannelUtils.f228046a, null, 1, null) == 4) {
                L1(ShowDialogEventType.MANAGER_INVITE_RAISE_HAND);
                return;
            } else {
                L1(ShowDialogEventType.MANAGER_INVITE_OPEN_MIC_IN_FREE);
                return;
            }
        }
        if (userCtlInfo.b() == 9) {
            L1(ShowDialogEventType.MANAGER_INVITE_OPEN_MIC_IN_QUEUE);
        }
    }

    private final void E2(List<? extends IGProUserInfo> waitList, List<? extends IGProUserInfo> handledList, boolean forceRefresh) {
        QLog.d("QGMC.Core.MediaChannelRaiseHandHelper", 1, "waitList " + waitList.size() + ", handledList " + handledList.size());
        QLog.d("QGMC.Core.MediaChannelRaiseHandHelper", 1, "waitingRequestList " + this.waitingRequestList.size() + ", handledRequestList " + this.handledRequestList.size());
        if (!forceRefresh) {
            D2(false, waitList, this.waitingRequestList, handledList);
            D2(true, handledList, this.handledRequestList, waitList);
        } else {
            this.waitingRequestList.clear();
            this.waitingRequestList.addAll(waitList);
            this.handledRequestList.clear();
            this.handledRequestList.addAll(handledList);
        }
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ak(this.waitingRequestList.size()));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(waitList);
        arrayList.addAll(handledList);
        z2(arrayList);
        S1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
    }

    public final void F1(String guildId, String channelId, String tinyId, es userCtlInfo) {
        Integer num;
        boolean z16;
        Map<String, ? extends es> mapOf;
        boolean z17;
        boolean z18;
        List<String> listOf;
        if (!Y0(guildId, channelId) || TextUtils.isEmpty(tinyId) || MediaChannelUtils.f228046a.n(com.tencent.mobileqq.guild.media.core.j.c().e()) != 4) {
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        Integer num2 = null;
        if (userCtlInfo != null) {
            num = Integer.valueOf(userCtlInfo.b());
        } else {
            num = null;
        }
        d16.i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleRaiseHandRequestResult: guildId[" + guildId + "] channelId[" + channelId + "] tinyId[" + tinyId + "] state[" + num + "]");
        boolean z19 = false;
        if (userCtlInfo != null && userCtlInfo.b() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (userCtlInfo != null && userCtlInfo.b() == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (userCtlInfo != null && userCtlInfo.b() == 5) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (userCtlInfo != null && userCtlInfo.b() == 6) {
                        z19 = true;
                    }
                    if (!z19) {
                        Logger.a d17 = logger.d();
                        if (userCtlInfo != null) {
                            num2 = Integer.valueOf(userCtlInfo.b());
                        }
                        d17.i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleRaiseHandRequestResult: cant handle state[" + num2 + "]");
                        return;
                    }
                }
                Intrinsics.checkNotNull(tinyId);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(tinyId);
                i2(listOf);
                if (TextUtils.equals(this.mediaChannelCore.getSelfUserInfo().f228093a, tinyId)) {
                    r2();
                    C2(this, userCtlInfo.b(), null, 2, null);
                    return;
                }
                return;
            }
        }
        Intrinsics.checkNotNull(tinyId);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(tinyId, userCtlInfo));
        R1(mapOf);
        if (TextUtils.equals(this.mediaChannelCore.getSelfUserInfo().f228093a, tinyId)) {
            if (this.selfRaiseHandState != RaiseHandState.PLAIN_USER_HAS_RIGHT) {
                L1(ShowDialogEventType.MANAGER_AGREE_RAISE_HAND);
            }
            A2(true);
            C2(this, userCtlInfo.b(), null, 2, null);
        }
    }

    public final void G1(String str, String str2, ArrayList<IGProUserInfo> arrayList) {
        if (!d1(str, str2, arrayList)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserAVStateResetNotifyForAll: guildId[" + str + "] channelId[" + str2 + "]");
        if (W0()) {
            Intrinsics.checkNotNull(arrayList);
            g2(arrayList, true);
        } else {
            Intrinsics.checkNotNull(arrayList);
            T1(arrayList);
        }
    }

    public final void H1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        Integer num;
        List<? extends IGProUserInfo> emptyList;
        if (!d1(guildId, channelId, userList)) {
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        if (userList != null) {
            num = Integer.valueOf(userList.size());
        } else {
            num = null;
        }
        d16.i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserHandUpRequestNotifyForAll: guildId[" + guildId + "] channelId[" + channelId + "] userList " + num);
        if (W0()) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "checkCanManageUserRaiseHandRequest ");
            Intrinsics.checkNotNull(userList);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            E2(userList, emptyList, false);
        } else {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "check Cant ManageUserRaiseHandRequest ");
            Intrinsics.checkNotNull(userList);
            T1(userList);
        }
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bf(userList));
    }

    public final void I1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        if (!Y0(guildId, channelId)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserLeaveListNotifyForAll: guildId[" + guildId + "] channelId[" + channelId + "]");
        if (W0()) {
            Intrinsics.checkNotNull(userList);
            h2(this, userList, false, 2, null);
        } else {
            Intrinsics.checkNotNull(userList);
            T1(userList);
        }
    }

    public final void J1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        List<? extends IGProUserInfo> emptyList;
        if (!Y0(guildId, channelId)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserSpeakingNotifyForAll: guildId[" + guildId + "] channelId[" + channelId + "]");
        if (W0()) {
            Intrinsics.checkNotNull(userList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : userList) {
                if (((IGProUserInfo) obj).getBusinessInfo().getUserAVInfo().isUserHandUp()) {
                    arrayList.add(obj);
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            E2(emptyList, arrayList, false);
        }
    }

    public final void K1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        List<? extends IGProUserInfo> emptyList;
        if (!d1(guildId, channelId, userList)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnUserWaitingToSpeakNotifyForAll: guildId[" + guildId + "] channelId[" + channelId + "]");
        if (W0()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            Intrinsics.checkNotNull(userList);
            E2(emptyList, userList, false);
        } else if (userList != null) {
            z2(userList);
        }
    }

    private final void L1(ShowDialogEventType r56) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleShowPushEventDialog: showType[" + r56 + "] lastShowDialogEvent[" + this.lastShowDialogEvent + "] ");
        if (!getMediaActivityActive()) {
            p2(r56);
            return;
        }
        p2(ShowDialogEventType.NONE);
        int i3 = b.f228216a[r56.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bh("MANAGER_INVITE_OPEN_MIC_FREE_MODE"));
                        return;
                    }
                    return;
                }
                this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bh("MANAGER_INVITE_JOIN_QUEUE"));
                return;
            }
            com.tencent.mobileqq.guild.performance.report.aa.f230980i.E();
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bh("INVITE"));
            return;
        }
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bh("MANAGER_AGREE_OPEN_MIC"));
    }

    private final void M1() {
        fc z16 = z1(this, null, 1, null);
        z16.b().e(11);
        t1().userDealSpeakInvitation(z16, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.bb
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                MediaChannelRaiseHandHelper.N1(MediaChannelRaiseHandHelper.this, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    public static final void N1(MediaChannelRaiseHandHelper this$0, int i3, String errMsg, IGProUserAVRspInfo rspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rspInfo, "rspInfo");
        this$0.b2(i3, errMsg, rspInfo);
    }

    private final void O1(Function2<? super Integer, ? super String, Unit> callback) {
        bi.W(this.mediaChannelCore.p0(), 1, 0, 0, false, 14, null);
    }

    public final void P1() {
        if (this.selfRaiseHandState == RaiseHandState.MANAGER) {
            n2();
        }
    }

    private final void Q1(final String tinyId) {
        Object obj;
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "moveUserRaiseHandRequestList: tinyId[" + tinyId + "].");
        Iterator<T> it = this.waitingRequestList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (TextUtils.equals(((IGProUserInfo) obj).getTinyId(), tinyId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
        if (iGProUserInfo == null) {
            Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "moveUserRaiseHandRequestList: can not find waiting user info.");
            return;
        }
        iGProUserInfo.getBusinessInfo().getUserAVInfo().setUserAVState(3);
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.handledRequestList, (Function1) new Function1<IGProUserInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$moveUserRaiseHandRequestList$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProUserInfo it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(TextUtils.equals(it5.getTinyId(), tinyId));
            }
        });
        this.handledRequestList.add(iGProUserInfo);
        this.waitingRequestList.remove(iGProUserInfo);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ak(this.waitingRequestList.size()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(iGProUserInfo);
        z2(arrayList);
        S1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
    }

    private final void R1(Map<String, ? extends es> handledList) {
        List<String> list;
        list = CollectionsKt___CollectionsKt.toList(handledList.keySet());
        List<IGProUserInfo> list2 = this.waitingRequestList;
        ArrayList<IGProUserInfo> arrayList = new ArrayList();
        for (Object obj : list2) {
            String tinyId = ((IGProUserInfo) obj).getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            if (c1(tinyId, list)) {
                arrayList.add(obj);
            }
        }
        for (IGProUserInfo iGProUserInfo : arrayList) {
            if (handledList.get(iGProUserInfo.getTinyId()) != null) {
                IGProUserAVData userAVInfo = iGProUserInfo.getBusinessInfo().getUserAVInfo();
                es esVar = handledList.get(iGProUserInfo.getTinyId());
                Intrinsics.checkNotNull(esVar);
                userAVInfo.setUserAVState(esVar.b());
            }
        }
        this.waitingRequestList.removeAll(arrayList);
        List<IGProUserInfo> list3 = this.handledRequestList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list3) {
            Intrinsics.checkNotNullExpressionValue(((IGProUserInfo) obj2).getTinyId(), "it.tinyId");
            if (!c1(r5, list)) {
                arrayList2.add(obj2);
            }
        }
        this.handledRequestList.clear();
        this.handledRequestList.addAll(arrayList);
        this.handledRequestList.addAll(arrayList2);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ak(this.waitingRequestList.size()));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        z2(arrayList3);
        S1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
    }

    private final void S1() {
        this.mediaChannelCore.l0().m("onRaiseHandInfoUpdate", this.mediaChannelCore.o0().getSelfUserInfo());
    }

    private final void T1(List<? extends IGProUserInfo> changeList) {
        z2(changeList);
        S1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
    }

    private final void U1(int result, String errMsg, String rspInfo) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onCancelUserHandUpForAdmin: result[" + result + "] errMsg[" + errMsg + "]");
        if (result == 0) {
            MediaChannelUtils.V(MediaChannelUtils.f228046a, result, errMsg, R.string.f1498213b, 0, 8, null);
        } else {
            MediaChannelUtils.V(MediaChannelUtils.f228046a, result, errMsg, 0, R.string.f1498113a, 4, null);
        }
    }

    private final boolean W0() {
        if (!com.tencent.mobileqq.guild.util.ch.m0(this.mediaChannelCore.getGuildID()) && !com.tencent.mobileqq.guild.util.ch.h0(this.mediaChannelCore.E())) {
            return false;
        }
        return true;
    }

    public static final void X1(MediaChannelRaiseHandHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q2();
    }

    private final boolean Y0(String guildId, String channelId) {
        if (!TextUtils.equals(guildId, this.mediaChannelCore.getGuildID()) || !TextUtils.equals(channelId, this.mediaChannelCore.E())) {
            return false;
        }
        return true;
    }

    private final void Y1(String tinyId, boolean accept, int result, String errMsg, String rspInfo) {
        List<String> listOf;
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onHandleRaiseHandRequest: result[" + result + "] errMsg[" + errMsg + "] accept[" + accept + "]");
        if (result == 0) {
            if (!accept) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(tinyId);
                i2(listOf);
                return;
            } else {
                Q1(tinyId);
                return;
            }
        }
        MediaChannelUtils.T(MediaChannelUtils.f228046a, result, errMsg, null, null, 12, null);
    }

    private final void Z1(int result, String errMsg, String rspInfo) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onInviteUserHandUpForAdmin: result[" + result + "] errMsg[" + errMsg + "]");
        if (result == 0) {
            MediaChannelUtils.V(MediaChannelUtils.f228046a, result, errMsg, R.string.f14979139, 0, 8, null);
        } else {
            MediaChannelUtils.V(MediaChannelUtils.f228046a, result, errMsg, 0, 0, 12, null);
        }
    }

    public final boolean a1(IGProUserInfo iGProUserInfo, List<? extends IGProUserInfo> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (TextUtils.equals(iGProUserInfo.getTinyId(), ((IGProUserInfo) obj).getTinyId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((IGProUserInfo) obj) != null) {
            return true;
        }
        return false;
    }

    private final void a2(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onRequestRaiseHandRequestList: result[" + i3 + "] errMsg[" + str + "]");
        if (i3 != 0) {
            return;
        }
        if (this.selfRaiseHandState != RaiseHandState.MANAGER) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onRequestRaiseHandRequestList: self not a manager!");
            return;
        }
        List<IGProUserInfo> userList = iGProAudioLiveUserListRsp.getChannelMemberInfo().getUserList();
        if (userList == null) {
            userList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (IGProUserInfo userInfo : userList) {
            if (INSTANCE.a(userInfo.getBusinessInfo().getUserAVInfo().getUserAVState())) {
                Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
                arrayList.add(userInfo);
            } else {
                Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
                arrayList2.add(userInfo);
            }
        }
        E2(arrayList, arrayList2, true);
    }

    private final IGProUserInfo b1(String tinyId, List<? extends IGProUserInfo> checkList) {
        Object obj;
        Iterator<T> it = checkList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (TextUtils.equals(tinyId, ((IGProUserInfo) obj).getTinyId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (IGProUserInfo) obj;
    }

    private final void b2(int result, String errMsg, IGProUserAVRspInfo rspInfo) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onUserHandleInvitation: result[" + result + "] errMsg[" + errMsg + "]");
    }

    private final boolean c1(String tinyId, List<String> checkList) {
        Object obj;
        Iterator<T> it = checkList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (TextUtils.equals(tinyId, (String) obj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((String) obj) != null) {
            return true;
        }
        return false;
    }

    private final void c2(int result, String errMsg, IGProUserAVRspInfo rspInfo, boolean isNotClicked) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onUserRequestRaiseHand: result[" + result + "] errMsg[" + errMsg + "] isNotClicked[" + isNotClicked + "]");
        if (result == 0) {
            if (isNotClicked) {
                QQToast.makeText(BaseApplication.context, 2, QQGuildUIUtil.r(R.string.f14978138), 0).show();
            }
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onUserRequestRaiseHand: suc. user state[" + rspInfo.getUserState() + "]");
            C2(this, rspInfo.getUserState(), null, 2, null);
        } else {
            MediaChannelUtils.T(MediaChannelUtils.f228046a, result, errMsg, null, null, 12, null);
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.C(result, errMsg, rspInfo.getUserState());
    }

    private final boolean d1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        if (!Y0(guildId, channelId) || userList == null || userList.isEmpty()) {
            return false;
        }
        return true;
    }

    private final long d2(String channelId) {
        try {
            return Long.parseLong(channelId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseChannelId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final long e2(String guildId) {
        try {
            return Long.parseLong(guildId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseGuildId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final boolean g1() {
        boolean z16;
        boolean z17;
        IGProChannelInfo s16 = s1();
        if (s16 == null) {
            return false;
        }
        if (s16.getAllowOtherRaiseHand() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (s16.getTalkPermission() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    private final void g2(final List<? extends IGProUserInfo> removeList, boolean notifyData) {
        boolean removeAll;
        boolean removeAll2;
        removeAll = CollectionsKt__MutableCollectionsKt.removeAll((List) this.waitingRequestList, (Function1) new Function1<IGProUserInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$removeUserFromRaiseHandList$removeWaitResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProUserInfo it) {
                boolean a16;
                Intrinsics.checkNotNullParameter(it, "it");
                a16 = MediaChannelRaiseHandHelper.this.a1(it, removeList);
                return Boolean.valueOf(a16);
            }
        });
        removeAll2 = CollectionsKt__MutableCollectionsKt.removeAll((List) this.handledRequestList, (Function1) new Function1<IGProUserInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$removeUserFromRaiseHandList$removeHandleResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProUserInfo it) {
                boolean a16;
                Intrinsics.checkNotNullParameter(it, "it");
                a16 = MediaChannelRaiseHandHelper.this.a1(it, removeList);
                return Boolean.valueOf(a16);
            }
        });
        if (removeAll) {
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ak(this.waitingRequestList.size()));
        }
        z2(removeList);
        if (removeAll || removeAll2) {
            if (notifyData) {
                S1();
            }
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
        }
    }

    private final boolean h1() {
        boolean f06 = this.mediaChannelCore.C().f0();
        boolean c06 = this.mediaChannelCore.C().c0();
        boolean d06 = this.mediaChannelCore.C().d0();
        boolean i06 = this.mediaChannelCore.C().i0();
        boolean H0 = this.mediaChannelCore.C().H0();
        if (!f06 && !c06 && !d06 && !i06 && H0) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void h2(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        mediaChannelRaiseHandHelper.g2(list, z16);
    }

    private final void i2(List<String> removeList) {
        List<IGProUserInfo> list = this.waitingRequestList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String tinyId = ((IGProUserInfo) obj).getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            if (c1(tinyId, removeList)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((IGProUserInfo) it.next()).getBusinessInfo().getUserAVInfo().setUserAVState(0);
        }
        this.waitingRequestList.removeAll(arrayList);
        this.handledRequestList.removeAll(arrayList);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ak(this.waitingRequestList.size()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        z2(arrayList2);
        S1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bg());
    }

    private final void j2(IGProUserInfo r65, List<IGProUserInfo> userInfoList) {
        Iterator<IGProUserInfo> it = userInfoList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(it.next().getTinyId(), r65.getTinyId())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            userInfoList.set(i3, r65);
        }
    }

    public static final void k1(String tinyId, MediaChannelRaiseHandHelper this$0, Function2 callback, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, String rspInfo) {
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.i(tinyId, i3, errMsg);
        Intrinsics.checkNotNullExpressionValue(rspInfo, "rspInfo");
        this$0.U1(i3, errMsg, rspInfo);
        callback.invoke(Integer.valueOf(i3), errMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l2(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function3 = new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$requestRaiseHand$1
                public final void invoke(int i16, @NotNull String str, boolean z16) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool) {
                    invoke(num.intValue(), str, bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        mediaChannelRaiseHandHelper.k2(function3);
    }

    public static final void m1(MediaChannelRaiseHandHelper this$0, String tinyId, boolean z16, Function2 callback, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, String rspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rspInfo, "rspInfo");
        this$0.Y1(tinyId, z16, i3, errMsg, rspInfo);
        callback.invoke(Integer.valueOf(i3), errMsg);
    }

    public static final void m2(MediaChannelRaiseHandHelper this$0, boolean z16, Function3 callback, int i3, String errMsg, IGProUserAVRspInfo rspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rspInfo, "rspInfo");
        this$0.c2(i3, errMsg, rspInfo, z16);
        C2(this$0, 2, null, 2, null);
        if (i3 == 0) {
            this$0.selfHasRequestRaiseHand = true;
        }
        callback.invoke(Integer.valueOf(i3), errMsg, Boolean.FALSE);
    }

    public final void n2() {
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface()\n         \u2026va, ProcessConstant.MAIN)");
        com.tencent.mobileqq.qqguildsdk.data.genc.q qVar = new com.tencent.mobileqq.qqguildsdk.data.genc.q();
        qVar.j(e2(this.mediaChannelCore.getGuildID()));
        qVar.i(d2(this.mediaChannelCore.E()));
        qVar.n(0);
        qVar.o(true);
        qVar.k(false);
        ((IGPSService) runtimeService).fetchAudioLiveChannelUserList(qVar, new wh2.ad() { // from class: com.tencent.mobileqq.guild.media.core.logic.av
            @Override // wh2.ad
            public final void a(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
                MediaChannelRaiseHandHelper.o2(MediaChannelRaiseHandHelper.this, i3, str, iGProAudioLiveUserListRsp);
            }
        });
    }

    public static final void o1(String tinyId, MediaChannelRaiseHandHelper this$0, Function2 callback, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, String rspInfo) {
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.l(tinyId, i3, errMsg);
        Intrinsics.checkNotNullExpressionValue(rspInfo, "rspInfo");
        this$0.Z1(i3, errMsg, rspInfo);
        callback.invoke(Integer.valueOf(i3), errMsg);
    }

    public static final void o2(MediaChannelRaiseHandHelper this$0, int i3, String errMsg, IGProAudioLiveUserListRsp userListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(userListRsp, "userListRsp");
        this$0.a2(i3, errMsg, userListRsp);
    }

    private final void p2(ShowDialogEventType type) {
        this.lastShowDialogEvent = type;
    }

    private final void q2() {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "showLastDialogEvent: lastShowDialogEvent[" + this.lastShowDialogEvent + "] ");
        L1(this.lastShowDialogEvent);
    }

    private final com.tencent.mobileqq.qqguildsdk.data.genc.o r1(String tinyId) {
        long parseLong;
        com.tencent.mobileqq.qqguildsdk.data.genc.o oVar = new com.tencent.mobileqq.qqguildsdk.data.genc.o();
        oVar.b().e(e2(this.mediaChannelCore.getGuildID()));
        oVar.b().d(d2(this.mediaChannelCore.E()));
        try {
            if (TextUtils.isEmpty(tinyId)) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(tinyId);
            }
            oVar.d(parseLong);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getAdminAVReqInfo: parse long error! [" + tinyId + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
        }
        return oVar;
    }

    private final void r2() {
        QBaseActivity qBaseActivity;
        if (GuildFloatWindowUtils.m() || (qBaseActivity = QBaseActivity.sTopActivity) == null) {
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
        String string = qBaseActivity.getString(R.string.f1496312t);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026media_manager_reject_tip)");
        String string2 = qBaseActivity.getString(R.string.f146610un);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.guild_i_know)");
        DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, string, (String) null, string2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.aw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MediaChannelRaiseHandHelper.s2(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    private final IGProChannelInfo s1() {
        String guildID = this.mediaChannelCore.getGuildID();
        String E = this.mediaChannelCore.E();
        if (!TextUtils.isEmpty(guildID) && !TextUtils.isEmpty(E)) {
            AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
            Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
            return com.tencent.mobileqq.guild.util.ch.C(l3, guildID, E);
        }
        return null;
    }

    public static final void s2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final uh2.b t1() {
        AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (uh2.b) runtimeService;
    }

    private final void t2(int resCode, String reason, final Function0<Unit> onConfirm) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, reason, (String) null, qBaseActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.bd
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelRaiseHandHelper.v2(Function0.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void u2(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, int i3, String str, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper$showOneBtnDialog$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        mediaChannelRaiseHandHelper.t2(i3, str, function0);
    }

    public static final void v2(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    private final long w1() {
        try {
            String selfTinyId = ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).getSelfTinyId();
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "gpsService.selfTinyId");
            return Long.parseLong(selfTinyId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getSelfTinyId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final void w2(String nickName) {
        QBaseActivity qBaseActivity;
        if (GuildFloatWindowUtils.m() || (qBaseActivity = QBaseActivity.sTopActivity) == null) {
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
        String r16 = QQGuildUIUtil.r(R.string.f1495512l);
        DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, nickName + r16, (String) null, QQGuildUIUtil.r(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.ax
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MediaChannelRaiseHandHelper.x2(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    public static final void x2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final fc y1(String tinyId) {
        long parseLong;
        fc fcVar = new fc();
        fcVar.a().e(e2(this.mediaChannelCore.getGuildID()));
        fcVar.a().d(d2(this.mediaChannelCore.E()));
        if (TextUtils.isEmpty(tinyId)) {
            parseLong = w1();
        } else {
            parseLong = Long.parseLong(tinyId);
        }
        fcVar.g(parseLong);
        return fcVar;
    }

    static /* synthetic */ fc z1(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return mediaChannelRaiseHandHelper.y1(str);
    }

    private final void z2(List<? extends IGProUserInfo> changeList) {
        if (!this.mediaChannelCore.isInChannel()) {
            QLog.w("QGMC.Core.MediaChannelRaiseHandHelper", 1, "updateChannelUserInfoList: not in room! ");
            return;
        }
        ArrayList<com.tencent.mobileqq.guild.media.core.data.p> arrayList = new ArrayList();
        List<com.tencent.mobileqq.guild.media.core.data.p> list = this.mediaChannelCore.o0().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "mediaChannelCore.getData\u2026el().userInfoList.anchors");
        arrayList.addAll(list);
        arrayList.add(this.mediaChannelCore.o0().getSelfUserInfo());
        for (com.tencent.mobileqq.guild.media.core.data.p pVar : arrayList) {
            String str = pVar.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "it.id");
            IGProUserInfo b16 = b1(str, changeList);
            if (b16 != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("QGMC.Core.MediaChannelRaiseHandHelper", "updateChannelUserInfoList: item[" + pVar.f228094b + ", " + pVar.f228093a + ", " + b16.getBusinessInfo().getUserAVInfo().getUserAVState() + "]");
                }
                pVar.C.getUserAVInfo().f(b16.getBusinessInfo().getUserAVInfo().getUserAVState());
                pVar.C.i(b16.getBusinessInfo().getSortKey());
            }
        }
    }

    public final void A1(@NotNull String guildId, @NotNull String tinyId, boolean bAllow, long source) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "handleOnBanByManager: guildId[" + guildId + "] allow[" + bAllow + "] source[" + source + "]");
        if (W0()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(tinyId);
            i2(listOf);
        }
        if (TextUtils.equals(this.mediaChannelCore.getSelfUserInfo().f228093a, tinyId)) {
            C2(this, 0, null, 3, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        C2(this, 0, null, 3, null);
        n2();
        f2();
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    @NotNull
    public MediaBusinessType O() {
        return MediaBusinessType.MEDIA_RAISE_HAND;
    }

    public final void V1() {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onChannelActivityPause: channelId[" + this.mediaChannelCore.E() + "]");
        this.mediaActivityActive = false;
    }

    public final void W1() {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "onChannelActivityResume: channelId[" + this.mediaChannelCore.E() + "]");
        this.mediaActivityActive = true;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.ba
            @Override // java.lang.Runnable
            public final void run() {
                MediaChannelRaiseHandHelper.X1(MediaChannelRaiseHandHelper.this);
            }
        }, 2000L);
    }

    public final boolean X0() {
        RaiseHandState raiseHandState = this.selfRaiseHandState;
        if ((raiseHandState == RaiseHandState.PLAIN_USER_CLICKED || raiseHandState == RaiseHandState.PLAIN_USER_NOT_CLICK) && !com.tencent.mobileqq.guild.media.core.j.a().d0().m1()) {
            return true;
        }
        return false;
    }

    /* renamed from: Z0, reason: from getter */
    public final boolean getMediaActivityActive() {
        return this.mediaActivityActive;
    }

    /* renamed from: e1, reason: from getter */
    public final boolean getSelfHasRequestRaiseHand() {
        return this.selfHasRequestRaiseHand;
    }

    @NotNull
    /* renamed from: f1, reason: from getter */
    public final RaiseHandState getSelfRaiseHandState() {
        return this.selfRaiseHandState;
    }

    public void f2() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelRaiseHandHelper", "registerObserver:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.talkPermissionUpdateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.z.class, this.speakModeChangeObserver);
    }

    public final boolean i1(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId) {
        IGProUserInfo iGProUserInfo;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (!Y0(guildId, channelId)) {
            return false;
        }
        List<IGProUserInfo> list = this.handledRequestList;
        ListIterator<IGProUserInfo> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                iGProUserInfo = listIterator.previous();
                if (TextUtils.equals(iGProUserInfo.getTinyId(), tinyId)) {
                    break;
                }
            } else {
                iGProUserInfo = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo2 = iGProUserInfo;
        if (iGProUserInfo2 == null) {
            return false;
        }
        int userAVState = iGProUserInfo2.getBusinessInfo().getUserAVInfo().getUserAVState();
        if (userAVState != 3 && userAVState != 4) {
            return false;
        }
        return true;
    }

    public final void j1(@NotNull final String tinyId, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.qqguildsdk.data.genc.o r16 = r1(tinyId);
        r16.a().e(11);
        t1().cancelUserHandUpForAdmin(r16, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.az
            @Override // wh2.c
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelRaiseHandHelper.k1(tinyId, this, callback, i3, str, iGProSecurityResult, str2);
            }
        });
    }

    public final void k2(@NotNull final Function3<? super Integer, ? super String, ? super Boolean, Unit> callback) {
        final boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "requestRaiseHand: channelId[" + this.mediaChannelCore.E() + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
        }
        fc z17 = z1(this, null, 1, null);
        z17.b().e(12);
        if (this.selfRaiseHandState != RaiseHandState.PLAIN_USER_NOT_CLICK) {
            z16 = false;
        }
        t1().userHandUp(z17, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.au
            @Override // wh2.er
            public final void a(int i3, String str2, IGProUserAVRspInfo iGProUserAVRspInfo) {
                MediaChannelRaiseHandHelper.m2(MediaChannelRaiseHandHelper.this, z16, callback, i3, str2, iGProUserAVRspInfo);
            }
        });
    }

    public final void l1(@NotNull final String tinyId, final boolean accept, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        int i3;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.qqguildsdk.data.genc.o r16 = r1(tinyId);
        com.tencent.mobileqq.qqguildsdk.data.genc.l a16 = r16.a();
        if (accept) {
            i3 = 12;
        } else {
            i3 = 11;
        }
        a16.e(i3);
        t1().dealHandUpRequestForAdmin(r16, accept, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.bc
            @Override // wh2.c
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelRaiseHandHelper.m1(MediaChannelRaiseHandHelper.this, tinyId, accept, callback, i16, str, iGProSecurityResult, str2);
            }
        });
    }

    public final void n1(@NotNull final String tinyId, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.qqguildsdk.data.genc.o r16 = r1(tinyId);
        r16.a().e(12);
        t1().inviteUserHandUpForAdmin(r16, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.ay
            @Override // wh2.c
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelRaiseHandHelper.o1(tinyId, this, callback, i3, str, iGProSecurityResult, str2);
            }
        });
    }

    public final void p1(boolean invite, @NotNull Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserAcceptInvitation: invite[" + invite + "] channelId[" + this.mediaChannelCore.E() + "]");
        if (com.tencent.mobileqq.guild.util.ch.s(this.mediaChannelCore.getGuildID())) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserAcceptInvitation: error, has not permission with visitor limit.");
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                com.tencent.mobileqq.guild.util.ch.h1(qBaseActivity, this.mediaChannelCore.getGuildID());
                return;
            }
            return;
        }
        if (this.mediaChannelCore.C().i0()) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserAcceptInvitation: error, has not permission with speak threshold limit.");
            QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
            if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
                sz1.c.d(qBaseActivity2, this.mediaChannelCore.getGuildID());
                return;
            }
            return;
        }
        String w3 = com.tencent.mobileqq.guild.setting.mute.c.w(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E());
        if (!TextUtils.isEmpty(w3)) {
            logger.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserAcceptInvitation: error, has not permission with mute.");
            u2(this, 0, w3, null, 4, null);
            return;
        }
        RaiseHandState raiseHandState = this.selfRaiseHandState;
        if (invite) {
            A2(true);
            C2(this, 0, RaiseHandState.PLAIN_USER_HAS_RIGHT, 1, null);
        }
        this.mediaChannelCore.J().i(true, new c(invite, this, raiseHandState, callback));
    }

    public final void q1(boolean invite, @NotNull Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger.f235387a.d().i("QGMC.Core.MediaChannelRaiseHandHelper", 1, "doUserRejectInvitation: invite[" + invite + "]");
        if (!invite) {
            O1(callback);
        } else {
            M1();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        y2();
        this.selfHasRaiseHandRight = false;
        this.selfRaiseHandState = RaiseHandState.NONE;
        this.lastShowDialogEvent = ShowDialogEventType.NONE;
        this.waitingRequestList.clear();
        this.handledRequestList.clear();
        this.selfHasRequestRaiseHand = false;
    }

    @NotNull
    public final List<IGProUserInfo> u1() {
        return this.handledRequestList;
    }

    @NotNull
    public final List<IGProUserInfo> v1() {
        return this.waitingRequestList;
    }

    public final int x1() {
        return this.waitingRequestList.size();
    }

    public void y2() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelRaiseHandHelper", "unRegisterObserver:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.talkPermissionUpdateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.z.class, this.speakModeChangeObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void R() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void S() {
    }
}
