package com.tencent.qqnt.aio.helper.gamecenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.os.HandlerCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMsgNotifyDataEvent;
import com.tencent.mobileqq.gamecenter.nt.aio.title.GameMsgTipsEvent;
import com.tencent.mobileqq.gamecenter.nt.aio.title.GameMsgTitleEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.helper.gamecenter.GameMsgAIOHelper;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p03.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0006\u00f6\u0001\u00f9\u0001\u00fc\u0001\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0084\u0002\u0085\u0002B\u001d\u0012\b\u0010\u0098\u0001\u001a\u00030\u0093\u0001\u0012\b\u0010\u009e\u0001\u001a\u00030\u0099\u0001\u00a2\u0006\u0006\b\u0082\u0002\u0010\u0083\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0012\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010'\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010(\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010$H\u0002J\u0012\u00100\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010/H\u0002J\u0012\u00101\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010/H\u0002J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010$H\u0002J\u0012\u00104\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010$H\u0002J\u0012\u00107\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u00108\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010;\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\b\u0010<\u001a\u00020\u0002H\u0002J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0014H\u0003J\u001a\u0010D\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\u00142\u0006\u0010C\u001a\u00020\u0014H\u0002J\u0018\u0010G\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00142\u0006\u0010F\u001a\u00020EH\u0002J\u0012\u0010I\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010K\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010/H\u0002J\b\u0010L\u001a\u00020\u0002H\u0002J\b\u0010M\u001a\u00020=H\u0002J\u001c\u0010P\u001a\u00020=2\b\u0010N\u001a\u0004\u0018\u00010\u00142\b\u0010O\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010R\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010$H\u0002J\b\u0010S\u001a\u00020\u0012H\u0002J\n\u0010U\u001a\u0004\u0018\u00010TH\u0002J0\u0010Z\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00142\b\u0010V\u001a\u0004\u0018\u00010\u00142\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010WH\u0002J\b\u0010[\u001a\u00020\u0012H\u0002J\u0012\u0010]\u001a\u00020\u00022\b\u0010\\\u001a\u0004\u0018\u00010WH\u0002J\u0012\u0010_\u001a\u00020\u00022\b\u0010^\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010a\u001a\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010b\u001a\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010c\u001a\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010e\u001a\u00020\u00022\b\u0010d\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010h\u001a\u00020\u00022\u0006\u0010g\u001a\u00020fH\u0002J\u001c\u0010l\u001a\u0004\u0018\u00010f2\b\u0010i\u001a\u0004\u0018\u00010/2\u0006\u0010k\u001a\u00020jH\u0002J\u0010\u0010m\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0002J \u0010q\u001a\u00020\u00022\u0006\u0010n\u001a\u00020\u00142\u0006\u0010p\u001a\u00020o2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010s\u001a\u00020\u00122\u0006\u0010r\u001a\u00020\u0014H\u0002J\b\u0010t\u001a\u00020\u0002H\u0002J\"\u0010y\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u001c2\b\u0010w\u001a\u0004\u0018\u00010v2\u0006\u0010x\u001a\u00020\u0014H\u0002J\b\u0010z\u001a\u00020\u0012H\u0002J\b\u0010{\u001a\u00020\u0014H\u0002J\b\u0010|\u001a\u00020\u0014H\u0002J\b\u0010}\u001a\u00020\u0002H\u0002J\b\u0010~\u001a\u00020\u0002H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020\u00022\u0006\u0010\u007f\u001a\u00020\u0012H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0002H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0002H\u0002J\t\u0010\u0083\u0001\u001a\u00020jH\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0014H\u0016J\n\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0016J\u0013\u0010\u0089\u0001\u001a\u00020\u00022\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020\u00022\u0007\u0010\u008a\u0001\u001a\u00020jH\u0016J\t\u0010\u008c\u0001\u001a\u0004\u0018\u000109J\u0007\u0010\u008d\u0001\u001a\u00020\u0002J\u0007\u0010\u008e\u0001\u001a\u00020\u0002J\u0007\u0010\u008f\u0001\u001a\u00020\u0002J\u001b\u0010\u0090\u0001\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u00010\u00142\b\u0010N\u001a\u0004\u0018\u00010\u0014J\u0007\u0010\u0091\u0001\u001a\u00020\u0002J\u0007\u0010\u0092\u0001\u001a\u00020\u0002R\u001d\u0010\u0098\u0001\u001a\u00030\u0093\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010\u009e\u0001\u001a\u00030\u0099\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010\u00a2\u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u001a\u0010\u00a6\u0001\u001a\u00030\u00a3\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001a\u0010\u00aa\u0001\u001a\u00030\u00a7\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0019\u0010\u00b0\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u0019\u0010\u00b2\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00ac\u0001R\u0019\u0010\u00b4\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00af\u0001R\u001c\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001c\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001c\u0010\u00c0\u0001\u001a\u0005\u0018\u00010\u00bd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00bf\u0001R\u001c\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00c1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00c2\u0001R\u001b\u0010\u00c6\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u001b\u0010\u00c8\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c7\u0001\u0010\u00c5\u0001R\u0018\u0010\u00ca\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c9\u0001\u0010\u0016R\u0018\u0010\u00cc\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00cb\u0001\u0010\u0016R\u001b\u0010\u00ce\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00af\u0001R\u001b\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00af\u0001R\u001b\u0010\u00d2\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u00af\u0001R\u001b\u0010\u00d4\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u00af\u0001R\u0019\u0010\u00d6\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00ac\u0001R*\u0010\u00db\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u00d7\u00010\u000ej\n\u0012\u0005\u0012\u00030\u00d7\u0001`\u00d8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u00da\u0001R\u0018\u0010\u00dd\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00dc\u0001\u0010\u0016R\u0019\u0010\u00df\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00de\u0001\u0010\u00af\u0001R\u0018\u0010\u00e3\u0001\u001a\u00030\u00e0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u0017\u0010\u00e6\u0001\u001a\u00030\u00e4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001a\u0010\u00e5\u0001R\u0017\u0010\u00e9\u0001\u001a\u00030\u00e7\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001f\u0010\u00e8\u0001R\u0017\u0010\u00ea\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0016R\u0017\u0010\u00eb\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u001b\u0010\u00ed\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ec\u0001\u0010\u00af\u0001R\u0018\u0010\u00ee\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\n\u0010\u00ac\u0001R\u001c\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00ef\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f0\u0001\u0010\u00f1\u0001R\u0017\u0010\u00f5\u0001\u001a\u00030\u00f3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bm\u0010\u00f4\u0001R\u0017\u0010\u00f8\u0001\u001a\u00030\u00f6\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bl\u0010\u00f7\u0001R\u0017\u0010\u00fb\u0001\u001a\u00030\u00f9\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b]\u0010\u00fa\u0001R\u0017\u0010\u00fe\u0001\u001a\u00030\u00fc\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u00fd\u0001R\u0017\u0010\u0081\u0002\u001a\u00030\u00ff\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0006\u0010\u0080\u0002\u00a8\u0006\u0086\u0002"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "l1", "L1", "h0", "i0", "l0", "k0", "Q0", "c0", "O0", "R0", "m1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "a0", "", "isShield", "", "u0", "Z", PreloadTRTCPlayerParams.KEY_SIG, "from", "i1", "X", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mobileqq/app/QQAppInterface;", "o0", "N0", "Y", "D0", "y1", IProfileProtocolConst.PARAM_IS_FRIEND, "F0", "", "data", "x0", "M0", "C0", "detailInfos", "y0", "sigValue", "I0", ark.ARKMETADATA_JSON, "G0", "Lorg/json/JSONObject;", "A0", "H0", "tips", "L0", "J1", "root", "K0", "E0", "B0", "Lgd1/a;", "detailInfo", "z1", "r1", "", "title", "v1", QQWinkConstants.TAB_SUBTITLE, "t1", "appId", "onlineType", "o1", "Landroid/graphics/drawable/Drawable;", "rightIcon", "u1", "iconUrl", "p1", "dataObj", "w1", "q1", "p0", "nickName", "levelPic", "r0", "popInfo", "z0", "T0", "Landroidx/fragment/app/FragmentActivity;", "n0", "content", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$a;", "leftButton", "rightButton", Constants.BASE_IN_PLUGIN_ID, "V0", "buttonInfo", "g0", "aioPopInfo", "f1", "battleArkJson", "A1", "c1", "H1", "arkJson", "e1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "arkElement", "S0", "arkContent", "", "type", "f0", "e0", "peerUid", "", "sigBytes", "j1", "tag", "U0", "Y0", "app", "Landroid/content/Context;", "context", "roleId", "v0", "I1", "s0", "t0", "Z0", "W0", "showRedDot", ICustomDataEditor.STRING_PARAM_1, "j0", "x1", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "q0", "K1", "g1", "w0", "m0", "X0", "P0", "Lcom/tencent/qqnt/aio/helper/gamecenter/u;", "d", "Lcom/tencent/qqnt/aio/helper/gamecenter/u;", "getMPartnerHelper", "()Lcom/tencent/qqnt/aio/helper/gamecenter/u;", "mPartnerHelper", "Lcom/tencent/qqnt/aio/helper/gamecenter/ai;", "e", "Lcom/tencent/qqnt/aio/helper/gamecenter/ai;", "getMTopBarHelper", "()Lcom/tencent/qqnt/aio/helper/gamecenter/ai;", "mTopBarHelper", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "mGameSession", "Landroid/os/Bundle;", "i", "Landroid/os/Bundle;", "mCustomParam", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mHashCode", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGameAppId", "D", "mOpenFrom", "E", "mPeerUid", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mAioPopDialog", "Landroid/app/Dialog;", "G", "Landroid/app/Dialog;", "mProfileGuideDialog", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "H", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "mGameMsgManager", "Lnd1/a;", "Lnd1/a;", "mStrangerRecomInfo", "J", "Lgd1/a;", "mFriendGameInfo", "K", "mMyGameInfo", "L", "mShieldValue", "M", "mIsShowCouponRedPackEntry", "N", "mCouponRedPackJumpUrl", "P", "mMyServerInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mGamePackageName", BdhLogUtil.LogTag.Tag_Req, "mGameTicket", ExifInterface.LATITUDE_SOUTH, "mOpenSwitch", "Lcom/tencent/mobileqq/gamecenter/data/g;", "Lkotlin/collections/ArrayList;", "T", "Ljava/util/ArrayList;", "mGameProrityList", "U", "mReportGameIcon", "V", "mDisplayName", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgUnissoHandlerApi;", "W", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgUnissoHandlerApi;", "mSsoApi", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "mMsgApi", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi;", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi;", "mMsgAioApi", "mHasSetSwitch", "mIsMetaDream", "b0", "mZoneUrl", "mGameType", "Landroid/widget/PopupWindow;", "d0", "Landroid/widget/PopupWindow;", "mOnlineStatusPopupWindow", "Landroid/os/Handler;", "Landroid/os/Handler;", "mSubHandler", "com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$g", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$g;", "mMsgSendListener", "com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$f", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$f;", "mMsgListener", "com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$h", "Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$h;", "mSsoObserver", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "(Lcom/tencent/qqnt/aio/helper/gamecenter/u;Lcom/tencent/qqnt/aio/helper/gamecenter/ai;)V", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GameMsgAIOHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: k0, reason: collision with root package name */
    private static final Object f350888k0 = new Object();

    /* renamed from: C, reason: from kotlin metadata */
    private String mGameAppId;

    /* renamed from: D, reason: from kotlin metadata */
    private int mOpenFrom;

    /* renamed from: E, reason: from kotlin metadata */
    private String mPeerUid;

    /* renamed from: F, reason: from kotlin metadata */
    private QQCustomDialog mAioPopDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private Dialog mProfileGuideDialog;

    /* renamed from: H, reason: from kotlin metadata */
    private IGameMsgManagerService mGameMsgManager;

    /* renamed from: I, reason: from kotlin metadata */
    private nd1.a mStrangerRecomInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private gd1.a mFriendGameInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private gd1.a mMyGameInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mShieldValue;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsShowCouponRedPackEntry;

    /* renamed from: N, reason: from kotlin metadata */
    private String mCouponRedPackJumpUrl;

    /* renamed from: P, reason: from kotlin metadata */
    private String mMyServerInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private String mGamePackageName;

    /* renamed from: R, reason: from kotlin metadata */
    private String mGameTicket;

    /* renamed from: S, reason: from kotlin metadata */
    private int mOpenSwitch;

    /* renamed from: T, reason: from kotlin metadata */
    private final ArrayList<com.tencent.mobileqq.gamecenter.data.g> mGameProrityList;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mReportGameIcon;

    /* renamed from: V, reason: from kotlin metadata */
    private String mDisplayName;

    /* renamed from: W, reason: from kotlin metadata */
    private final IGameMsgUnissoHandlerApi mSsoApi;

    /* renamed from: X, reason: from kotlin metadata */
    private final IGameMsgNtApi mMsgApi;

    /* renamed from: Y, reason: from kotlin metadata */
    private final IGameMsgAioNtApi mMsgAioApi;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean mHasSetSwitch;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMetaDream;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String mZoneUrl;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int mGameType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final u mPartnerHelper;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private PopupWindow mOnlineStatusPopupWindow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ai mTopBarHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Handler mSubHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final g mMsgSendListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final f mMsgListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TempChatGameSession mGameSession;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final h mSsoObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Bundle mCustomParam;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mHashCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$a;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "url", "b", "d", "text", "", "I", "()I", "e", "(I)V", "type", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String text;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final void d(String str) {
            this.text = str;
        }

        public final void e(int i3) {
            this.type = i3;
        }

        public final void f(String str) {
            this.url = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$c", "Lcom/tencent/mobileqq/transfile/URLDrawableHelper$Adapter;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends URLDrawableHelper.Adapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<CharSequence> f350909e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f350910f;

        c(Ref.ObjectRef<CharSequence> objectRef, URLDrawable uRLDrawable) {
            this.f350909e = objectRef;
            this.f350910f = uRLDrawable;
        }

        @Override // com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            GameMsgAIOHelper.this.v1(this.f350909e.element);
            this.f350910f.setURLDrawableListener(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$d", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements IGameMsgNtApi.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MsgElement f350912b;

        d(MsgElement msgElement) {
            this.f350912b = msgElement;
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
        public void onSuccess(ArrayList<MsgRecord> msgList) {
            ArkElement arkElement;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            if (!msgList.isEmpty()) {
                Iterator<MsgRecord> it = msgList.iterator();
                while (it.hasNext()) {
                    Iterator<MsgElement> it5 = it.next().elements.iterator();
                    while (it5.hasNext()) {
                        MsgElement next = it5.next();
                        Integer num = (next == null || (arkElement = next.arkElement) == null) ? null : arkElement.subElementType;
                        if ((num == null ? 0 : num.intValue()) == 1000) {
                            QLog.i("GameMsgAIOHelper", 2, "[insertIceBreakArkWhenNotInserted] alReady exist");
                            return;
                        }
                    }
                }
            }
            ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).insertLocalArkRecord(GameMsgAIOHelper.this.mPeerUid, this.f350912b, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$e", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mvi.base.route.a {
        e() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            QLog.i("GameMsgAIOHelper", 2, "[mAction1] call:" + i3);
            if (GameMsgAIOHelper.this.U0(String.valueOf(i3.hashCode()))) {
                return;
            }
            if (i3 instanceof AIOTitleEvent.Right1IvClickEvent ? true : Intrinsics.areEqual(i3, GameMsgTitleEvent.JumpSettingEvent.f212236d)) {
                GameMsgAIOHelper.this.w0();
                return;
            }
            if (i3 instanceof AIOTitleEvent.SubTitleClickEvent) {
                GameMsgAIOHelper.this.g1();
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.MainTitleClickEvent) {
                GameMsgAIOHelper.this.Y0();
                return;
            }
            if (i3 instanceof GameMsgTitleEvent.KingIconClick) {
                GameMsgAIOHelper.this.X0();
            } else if (i3 instanceof GameMsgTitleEvent.JumpAddFriendEvent) {
                GameMsgAIOHelper.this.W0();
            } else if (i3 instanceof GameMsgTitleEvent.MetaDreamAddFriendIconClick) {
                GameMsgAIOHelper.this.Z0();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$f", "Lcom/tencent/qqnt/msg/i;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errorCode", "", "errorMsg", "", "onSendMsgError", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "onRecvMsg", "msgRecord", "onAddSendMsg", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends com.tencent.qqnt.msg.i {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String str) {
            QQToast.makeText(MobileQQ.sMobileQQ, str, 1).show();
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            super.onAddSendMsg(msgRecord);
            if (msgRecord.chatType == 105 && GameMsgAIOHelper.this.mOpenFrom == 5) {
                GameMsgAIOHelper gameMsgAIOHelper = GameMsgAIOHelper.this;
                ArrayList arrayList = new ArrayList();
                arrayList.add(msgRecord);
                gameMsgAIOHelper.a0(arrayList);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(ArrayList<MsgRecord> msgList) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            super.onRecvMsg(msgList);
            GameMsgAIOHelper.this.a0(msgList);
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, Contact peer, int errorCode, final String errorMsg) {
            super.onSendMsgError(msgId, peer, errorCode, errorMsg);
            if (Intrinsics.areEqual(peer != null ? peer.peerUid : null, GameMsgAIOHelper.this.mPeerUid)) {
                if (errorCode == 10012) {
                    ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).addGrayTipForGameAIO(GameMsgAIOHelper.this.u0(true), GameMsgAIOHelper.this.mPeerUid);
                } else {
                    if (TextUtils.isEmpty(errorMsg)) {
                        return;
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameMsgAIOHelper.f.b(errorMsg);
                        }
                    });
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$h", "Lie1/b;", "", "data", "", "i", "detailInfos", "d", tl.h.F, "e", "l", "root", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "tips", "r", "j", "t", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "o", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sigString", "p", "c", ReportConstant.COSTREPORT_PREFIX, "k", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h extends ie1.b {
        h(int i3) {
            super(i3);
        }

        @Override // ie1.b
        public void c(Object data) {
            GameMsgAIOHelper.this.x0(data);
        }

        @Override // ie1.b
        public void d(Object detailInfos) {
            GameMsgAIOHelper.this.y0(detailInfos);
        }

        @Override // ie1.b
        public void e(Object data) {
            GameMsgAIOHelper.this.z0(data);
        }

        @Override // ie1.b
        public void f(JSONObject json) {
            GameMsgAIOHelper.this.A0(json);
        }

        @Override // ie1.b
        public void h(Object data) {
            GameMsgAIOHelper.this.B0(data);
        }

        @Override // ie1.b
        public void i(Object data) {
            GameMsgAIOHelper.this.C0(data);
        }

        @Override // ie1.b
        public void j() {
            GameMsgAIOHelper.this.D0();
        }

        @Override // ie1.b
        public void k(Object data) {
            try {
                QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "[onGetGameType], data:" + data);
                GameMsgAIOHelper gameMsgAIOHelper = GameMsgAIOHelper.this;
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Int");
                gameMsgAIOHelper.mGameType = ((Integer) data).intValue();
                com.tencent.aio.api.runtime.a aVar = GameMsgAIOHelper.this.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                com.tencent.mvi.base.route.j e16 = aVar.e();
                if (e16 != null) {
                    e16.h(new GameMsgNotifyDataEvent.GameTypeReceived(GameMsgAIOHelper.this.mGameType));
                }
            } catch (Throwable th5) {
                QLog.w("GameCenterMsg.GameCenterUnissoObserver", 1, th5.getMessage());
            }
        }

        @Override // ie1.b
        public void l(Object data) {
            GameMsgAIOHelper.this.E0(data);
        }

        @Override // ie1.b
        public void m(Object json) {
            GameMsgAIOHelper.this.G0(json);
        }

        @Override // ie1.b
        public void o(JSONObject json) {
            GameMsgAIOHelper.this.H0(json);
        }

        @Override // ie1.b
        public void p(Object sigString) {
            GameMsgAIOHelper.this.I0(sigString);
        }

        @Override // ie1.b
        public void q(Object root) {
            GameMsgAIOHelper.this.K0(root);
        }

        @Override // ie1.b
        public void r(Object tips) {
            GameMsgAIOHelper.this.L0(tips);
        }

        @Override // ie1.b
        public void s(Object data) {
            GameMsgAIOHelper.this.M0(data);
        }

        @Override // ie1.b
        public void t() {
            GameMsgAIOHelper.this.N0();
        }
    }

    public GameMsgAIOHelper(u mPartnerHelper, ai mTopBarHelper) {
        Intrinsics.checkNotNullParameter(mPartnerHelper, "mPartnerHelper");
        Intrinsics.checkNotNullParameter(mTopBarHelper, "mTopBarHelper");
        this.mPartnerHelper = mPartnerHelper;
        this.mTopBarHelper = mTopBarHelper;
        this.mHashCode = hashCode();
        this.mGameAppId = "";
        this.mOpenFrom = -1;
        this.mPeerUid = "";
        this.mGameProrityList = new ArrayList<>();
        this.mDisplayName = "";
        QRouteApi api = QRoute.api(IGameMsgUnissoHandlerApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgUnissoHandlerApi::class.java)");
        this.mSsoApi = (IGameMsgUnissoHandlerApi) api;
        QRouteApi api2 = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGameMsgNtApi::class.java)");
        this.mMsgApi = (IGameMsgNtApi) api2;
        QRouteApi api3 = QRoute.api(IGameMsgAioNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api3, "api(IGameMsgAioNtApi::class.java)");
        this.mMsgAioApi = (IGameMsgAioNtApi) api3;
        this.mSubHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.mMsgSendListener = new g();
        this.mMsgListener = new f();
        this.mSsoObserver = new h(this.mHashCode);
        this.mAction1 = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(JSONObject json) {
        QLog.d("GameMsgAIOHelper", 2, "[handleGetArkMessageRsp], mGameType:" + this.mGameType);
        e1(json != null ? json.optJSONObject("sgamebattle") : null);
    }

    private final void A1(final JSONObject battleArkJson) {
        if (T0() || battleArkJson == null) {
            return;
        }
        FragmentActivity n06 = n0();
        Intrinsics.checkNotNull(n06);
        DialogUtil.createCustomDialog(n06, 230, n06.getString(R.string.f168242f4), n06.getString(R.string.f168222f2), n06.getString(R.string.f168232f3), n06.getString(R.string.f168212f1), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgAIOHelper.B1(GameMsgAIOHelper.this, battleArkJson, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgAIOHelper.C1(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x001f, code lost:
    
        if (r5 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B0(Object data) {
        String obj;
        QLog.i("GameMsgAIOHelper", 1, "[handleGetFriendExtInfo], data:" + data);
        if (data != null) {
            try {
                obj = data.toString();
            } catch (Throwable th5) {
                QLog.e("GameMsgAIOHelper", 1, th5, new Object[0]);
                return;
            }
        }
        obj = "";
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            TempChatGameSession tempChatGameSession = this.mGameSession;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            iGameMsgManagerService.updateRedDotConfig(tempChatGameSession.peerRoleId, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(GameMsgAIOHelper this$0, JSONObject jSONObject, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c1(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        if (this.mHasSetSwitch) {
            return;
        }
        y1();
    }

    private final void D1(String title, String content, final a leftButton, final a rightButton) {
        if (T0()) {
            return;
        }
        if ((leftButton == null && rightButton == null) || V0()) {
            return;
        }
        if (leftButton != null && rightButton != null) {
            this.mAioPopDialog = DialogUtil.createCustomDialog(n0(), 230, title, content, leftButton.getText(), rightButton.getText(), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GameMsgAIOHelper.E1(GameMsgAIOHelper.this, rightButton, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GameMsgAIOHelper.F1(GameMsgAIOHelper.this, leftButton, dialogInterface, i3);
                }
            });
        } else if (leftButton != null) {
            this.mAioPopDialog = DialogUtil.createCustomDialog(n0(), 230, title, content, leftButton.getText(), "", (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GameMsgAIOHelper.G1(GameMsgAIOHelper.this, leftButton, dialogInterface, i3);
                }
            });
        }
        QQCustomDialog qQCustomDialog = this.mAioPopDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(Object data) {
        QLog.i("GameMsgAIOHelper", 1, "[handleGetGrayTipsRsp] data:" + data);
        nd1.a aVar = this.mStrangerRecomInfo;
        TempChatGameSession tempChatGameSession = null;
        String uin = aVar != null ? aVar.getUin() : null;
        if (uin == null) {
            uin = "";
        }
        String str = uin;
        QQAppInterface o06 = o0();
        if (o06 != null) {
            com.tencent.mobileqq.gamecenter.data.e eVar = com.tencent.mobileqq.gamecenter.data.e.f212007a;
            TempChatGameSession tempChatGameSession2 = this.mGameSession;
            if (tempChatGameSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession2 = null;
            }
            String valueOf = String.valueOf(tempChatGameSession2.peerTinyId);
            TempChatGameSession tempChatGameSession3 = this.mGameSession;
            if (tempChatGameSession3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            } else {
                tempChatGameSession = tempChatGameSession3;
            }
            eVar.f(data, o06, valueOf, String.valueOf(tempChatGameSession.selfTinyId), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(GameMsgAIOHelper this$0, a aVar, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g0(aVar);
    }

    private final void F0(boolean isFriend) {
        QLog.i("GameMsgAIOHelper", 1, "[handleGetIsMetaDreamGameFriend] isFriend:" + isFriend);
        if (isFriend) {
            return;
        }
        r1();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("1112198072", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "915686", "", "", "8", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(GameMsgAIOHelper this$0, a aVar, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(Object json) {
        QLog.d("GameMsgAIOHelper", 2, "[handleGetKingBattleMomentArkMsgRsp], mGameType:" + this.mGameType);
        if (this.mGameType == 1) {
            return;
        }
        f1(json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(GameMsgAIOHelper this$0, a aVar, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g0(aVar);
    }

    private final void H1(JSONObject battleArkJson) {
        QLog.i("GameMsgAIOHelper", 2, "[showKingBattleMomentAndPackEntry], battleArkJson:" + battleArkJson);
        if (battleArkJson == null) {
            return;
        }
        e1(battleArkJson);
    }

    private final boolean I1() {
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgAIOHelper", 2, "[showStartGame]");
        }
        gd1.a mFriendGameInfo = getMFriendGameInfo();
        if (mFriendGameInfo == null) {
            return false;
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).startGame(n0(), this.mZoneUrl, mFriendGameInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(Object obj, GameMsgAIOHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            byte[] sigBytes = Base64.decode((String) obj);
            String str = this$0.mPeerUid;
            Intrinsics.checkNotNullExpressionValue(sigBytes, "sigBytes");
            this$0.j1(str, sigBytes, "rsp");
        } catch (Exception e16) {
            QLog.e("GameMsgAIOHelper", 1, "[onGetSessionSig], e:" + e16);
        }
    }

    private final void J1(String tips) {
        if (TextUtils.isEmpty(tips)) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            Intrinsics.checkNotNull(tips);
            e16.h(new GameMsgTipsEvent.ShowTips(tips));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(Object tips) {
        Intent intent;
        QLog.d("GameMsgAIOHelper", 2, "[handleGetTopGrayTipsRsp], tips:" + tips);
        FragmentActivity n06 = n0();
        String stringExtra = (n06 == null || (intent = n06.getIntent()) == null) ? null : intent.getStringExtra(AppConstants.Key.KEY_GAME_MSG_TOP_GRAY_TEXT);
        if (TextUtils.isEmpty(stringExtra) && (tips instanceof String)) {
            stringExtra = (String) tips;
        }
        this.mMyServerInfo = stringExtra;
        nd1.a aVar = this.mStrangerRecomInfo;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.getAddFriendType() == 0) {
                J1(stringExtra);
            }
        }
    }

    private final void L1() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right1IvClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        aVar4.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MainTitleClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        aVar5.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingIconClick.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar6 = null;
        }
        aVar6.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.JumpSettingEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar7 = this.mAIOContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar7 = null;
        }
        aVar7.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.JumpAddFriendEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar8 = this.mAIOContext;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar8;
        }
        aVar2.e().b(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MetaDreamAddFriendIconClick.class)), this.mAction1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(Object data) {
        try {
            QLog.i("GameMsgAIOHelper", 1, "[handleGetZoneUrl], data:" + data);
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
            this.mZoneUrl = (String) data;
        } catch (Throwable th5) {
            QLog.w("GameMsgAIOHelper", 1, th5.getMessage());
        }
    }

    private final void O0() {
        Bundle bundle = this.mCustomParam;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle = null;
        }
        String sign = bundle.getString(AppConstants.Key.KEY_GAME_MSG_SIG, "");
        if (sign == null || sign.length() == 0) {
            ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).getGameSign(t0(), new Function1<String, Unit>() { // from class: com.tencent.qqnt.aio.helper.gamecenter.GameMsgAIOHelper$handleSignEnter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String t06;
                    QQAppInterface o06;
                    if (!(str == null || str.length() == 0)) {
                        GameMsgAIOHelper.this.i1(str, "getUserSign");
                        return;
                    }
                    ITempApi iTempApi = (ITempApi) QRoute.api(ITempApi.class);
                    t06 = GameMsgAIOHelper.this.t0();
                    o06 = GameMsgAIOHelper.this.o0();
                    byte[] tinySessionKey = iTempApi.getTinySessionKey(t06, o06 != null ? o06.getCurrentAccountUin() : null);
                    GameMsgAIOHelper gameMsgAIOHelper = GameMsgAIOHelper.this;
                    String str2 = gameMsgAIOHelper.mPeerUid;
                    if (tinySessionKey == null) {
                        tinySessionKey = new byte[0];
                    }
                    gameMsgAIOHelper.j1(str2, tinySessionKey, "cache");
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue(sign, "sign");
            i1(sign, "init");
        }
    }

    private final void Q0() {
        IGameMsgManagerService iGameMsgManagerService;
        Bundle bundle = this.mCustomParam;
        TempChatGameSession tempChatGameSession = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle = null;
        }
        this.mOpenFrom = bundle.getInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, -1);
        Bundle bundle2 = this.mCustomParam;
        if (bundle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle2 = null;
        }
        String string = bundle2.getString("key_peerId", "");
        Intrinsics.checkNotNullExpressionValue(string, "mCustomParam.getString(C\u2026Constants.KEY_PEERID, \"\")");
        this.mPeerUid = string;
        IGameMsgNtApi iGameMsgNtApi = this.mMsgApi;
        Bundle bundle3 = this.mCustomParam;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle3 = null;
        }
        TempChatGameSession gameSessionFromPeerUidOrJson = iGameMsgNtApi.getGameSessionFromPeerUidOrJson(string, bundle3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
        this.mGameSession = gameSessionFromPeerUidOrJson;
        if (gameSessionFromPeerUidOrJson == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            gameSessionFromPeerUidOrJson = null;
        }
        this.mIsMetaDream = Intrinsics.areEqual("1112198072", String.valueOf(gameSessionFromPeerUidOrJson.gameAppId));
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession2 = null;
        }
        String str = tempChatGameSession2.peerRoleId;
        if (str == null || str.length() == 0) {
            QLog.i("GameMsgAIOHelper", 1, "open aio error");
            FragmentActivity n06 = n0();
            if (n06 != null) {
                n06.finish();
                return;
            }
            return;
        }
        Z();
        O0();
        QQAppInterface o06 = o0();
        if (o06 == null || (iGameMsgManagerService = (IGameMsgManagerService) o06.getRuntimeService(IGameMsgManagerService.class, "")) == null) {
            iGameMsgManagerService = null;
        } else {
            iGameMsgManagerService.addUserInfoChangedObserver(this.mSsoObserver);
            TempChatGameSession tempChatGameSession3 = this.mGameSession;
            if (tempChatGameSession3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession3 = null;
            }
            gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(tempChatGameSession3.peerRoleId);
            if (singleGameDetail != null) {
                Intrinsics.checkNotNullExpressionValue(singleGameDetail, "getSingleGameDetail(mGameSession.peerRoleId)");
                String mAppId = singleGameDetail.f401939c;
                Intrinsics.checkNotNullExpressionValue(mAppId, "mAppId");
                this.mGameAppId = mAppId;
                this.mSsoApi.getGameStartPriority(this.mHashCode, mAppId);
            } else {
                singleGameDetail = null;
            }
            this.mFriendGameInfo = singleGameDetail;
            TempChatGameSession tempChatGameSession4 = this.mGameSession;
            if (tempChatGameSession4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession4 = null;
            }
            this.mMyGameInfo = iGameMsgManagerService.getSingleGameDetail(tempChatGameSession4.selfRoleId);
        }
        this.mGameMsgManager = iGameMsgManagerService;
        IGameMsgUnissoHandlerApi iGameMsgUnissoHandlerApi = this.mSsoApi;
        int i3 = this.mHashCode;
        int i16 = this.mOpenFrom == 5 ? 1 : 0;
        TempChatGameSession tempChatGameSession5 = this.mGameSession;
        if (tempChatGameSession5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession5 = null;
        }
        String str2 = tempChatGameSession5.selfRoleId;
        TempChatGameSession tempChatGameSession6 = this.mGameSession;
        if (tempChatGameSession6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession6 = null;
        }
        iGameMsgUnissoHandlerApi.getAioPopInfo(i3, i16, str2, tempChatGameSession6.peerRoleId);
        this.mSsoApi.getGameSwitch(this.mHashCode);
        if (this.mIsMetaDream) {
            c0();
        }
        TempChatGameSession tempChatGameSession7 = this.mGameSession;
        if (tempChatGameSession7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession7 = null;
        }
        String str3 = tempChatGameSession7.peerRoleId;
        TempChatGameSession tempChatGameSession8 = this.mGameSession;
        if (tempChatGameSession8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
        } else {
            tempChatGameSession = tempChatGameSession8;
        }
        QLog.i("GameMsgAIOHelper", 2, "[doOnCreate] friendRoleId:" + str3 + ",myRoleId:" + tempChatGameSession.selfRoleId + ",openFrom:" + this.mOpenFrom + ",mIsMetaDream:" + this.mIsMetaDream);
    }

    private final void R0() {
        this.mMsgApi.addMsgListener(this.mMsgListener);
        this.mMsgAioApi.setMsgInterceptListener(this.mMsgSendListener);
    }

    private final boolean T0() {
        if (n0() == null) {
            return true;
        }
        FragmentActivity n06 = n0();
        return n06 != null && n06.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0(String tag) {
        return ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isFastClick(tag);
    }

    private final boolean V0() {
        QQCustomDialog qQCustomDialog = this.mAioPopDialog;
        if (qQCustomDialog != null) {
            Intrinsics.checkNotNull(qQCustomDialog);
            if (qQCustomDialog.isShowing()) {
                return true;
            }
        }
        return false;
    }

    private final void X() {
        QQAppInterface o06 = o0();
        if (o06 != null) {
            o06.addObserver(this.mSsoObserver);
        }
    }

    private final void Y() {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 1);
            jSONObject.put("title", "\u5982\u6e38\u620f\u597d\u53cb\u6d88\u606f\u5bf9\u4f60\u4ea7\u751f\u9a9a\u6270\uff0c\u53ef");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 2);
            jSONObject2.put("title", "\u8bbe\u7f6e\u5c4f\u853d");
            jSONObject2.put("url", IGameMsgHelperApi.SESSION_SETTING_URL);
            jSONArray.mo162put(jSONObject);
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("content", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.mo162put(jSONObject3);
            com.tencent.mobileqq.gamecenter.data.e eVar = com.tencent.mobileqq.gamecenter.data.e.f212007a;
            QQAppInterface o06 = o0();
            Intrinsics.checkNotNull(o06);
            TempChatGameSession tempChatGameSession = this.mGameSession;
            TempChatGameSession tempChatGameSession2 = null;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            String valueOf = String.valueOf(tempChatGameSession.peerTinyId);
            TempChatGameSession tempChatGameSession3 = this.mGameSession;
            if (tempChatGameSession3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            } else {
                tempChatGameSession2 = tempChatGameSession3;
            }
            eVar.f(jSONArray2, o06, valueOf, String.valueOf(tempChatGameSession2.selfTinyId), "");
        } catch (Throwable th5) {
            QLog.e("GameMsgAIOHelper", 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0() {
        String str;
        gd1.a aVar = this.mFriendGameInfo;
        if (aVar != null) {
            QQAppInterface o06 = o0();
            Intrinsics.checkNotNull(o06);
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            TempChatGameSession tempChatGameSession = this.mGameSession;
            TempChatGameSession tempChatGameSession2 = null;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            String str2 = tempChatGameSession.peerRoleId;
            Intrinsics.checkNotNullExpressionValue(str2, "mGameSession.peerRoleId");
            if (v0(o06, mobileQQ, str2)) {
                IGameCenterCommonApi iGameCenterCommonApi = (IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class);
                TempChatGameSession tempChatGameSession3 = this.mGameSession;
                if (tempChatGameSession3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                } else {
                    tempChatGameSession2 = tempChatGameSession3;
                }
                if (iGameCenterCommonApi.isApplyPartnerContact(tempChatGameSession2)) {
                    str = "92050";
                } else {
                    str = "92005";
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str, "208403", String.valueOf(aVar.f401946j), null, "20", null);
            }
        }
    }

    private final void Z() {
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(t0(), this.mPeerUid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        QQAppInterface o06 = o0();
        Intrinsics.checkNotNull(o06);
        IRuntimeService runtimeService = o06.getRuntimeService(IMetaDreamService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp()!!.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        final IMetaDreamService iMetaDreamService = (IMetaDreamService) runtimeService;
        TempChatGameSession tempChatGameSession = this.mGameSession;
        TempChatGameSession tempChatGameSession2 = null;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        String str = tempChatGameSession.peerOpenId;
        TempChatGameSession tempChatGameSession3 = this.mGameSession;
        if (tempChatGameSession3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
        } else {
            tempChatGameSession2 = tempChatGameSession3;
        }
        iMetaDreamService.addMetaDreamGameFriend(str, tempChatGameSession2.peerRoleId, new sd1.b() { // from class: com.tencent.qqnt.aio.helper.gamecenter.i
            @Override // sd1.b
            public final void onAddMetaDreamGameFriend(boolean z16, long j3) {
                GameMsgAIOHelper.a1(IMetaDreamService.this, z16, j3);
            }
        });
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("1112198072", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92044", "915687", "", "", "20", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(ArrayList<MsgRecord> msgList) {
        Object obj;
        final FragmentActivity n06 = n0();
        Iterator<T> it = msgList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord.chatType == 105 && msgRecord.msgType != 5) {
                break;
            }
        }
        final MsgRecord msgRecord2 = (MsgRecord) obj;
        if (this.mOpenFrom != 5 || msgRecord2 == null || n06 == null) {
            return;
        }
        Handler handler = this.mSubHandler;
        Object obj2 = f350888k0;
        handler.removeCallbacksAndMessages(obj2);
        HandlerCompat.postDelayed(this.mSubHandler, new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.a
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgAIOHelper.b0(GameMsgAIOHelper.this, n06, msgRecord2);
            }
        }, obj2, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(IMetaDreamService metaDreamService, final boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(metaDreamService, "$metaDreamService");
        QLog.i("GameMsgAIOHelper", 1, "addMetaDreamGameFriend success:" + z16 + " errorCode:" + j3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.b
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgAIOHelper.b1(z16);
            }
        });
        metaDreamService.removeMetaDreamAddFriendCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(GameMsgAIOHelper this$0, FragmentActivity fragmentActivity, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            AIOParam g16 = aVar.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
            new com.tencent.mobileqq.activity.aio.rebuild.b(su3.b.a(g16), this$0.mMyGameInfo, this$0.mFriendGameInfo, this$0.o0(), fragmentActivity, msgRecord).b(this$0.mPeerUid);
        } catch (Throwable th5) {
            QLog.e("GameMsgAIOHelper", 1, th5, new Object[0]);
        }
    }

    private final void c0() {
        QQAppInterface o06 = o0();
        TempChatGameSession tempChatGameSession = null;
        final IMetaDreamService iMetaDreamService = o06 != null ? (IMetaDreamService) o06.getRuntimeService(IMetaDreamService.class, "") : null;
        if (iMetaDreamService != null) {
            TempChatGameSession tempChatGameSession2 = this.mGameSession;
            if (tempChatGameSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            } else {
                tempChatGameSession = tempChatGameSession2;
            }
            iMetaDreamService.getIsMetaDreamFriendFromServer(tempChatGameSession.peerRoleId, new sd1.d() { // from class: com.tencent.qqnt.aio.helper.gamecenter.c
                @Override // sd1.d
                public final void a(boolean z16, long j3, boolean z17) {
                    GameMsgAIOHelper.d0(GameMsgAIOHelper.this, iMetaDreamService, z16, j3, z17);
                }
            });
        }
    }

    private final void c1(JSONObject battleArkJson) {
        H1(battleArkJson);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.m
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgAIOHelper.d1(GameMsgAIOHelper.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(GameMsgAIOHelper this$0, IMetaDreamService iMetaDreamService, boolean z16, long j3, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GameMsgAIOHelper", 1, "getIsMetaDreamFriendFromServer success:" + z16 + ", errorCode:" + j3 + ", isFriend:" + z17);
        if (z16) {
            this$0.F0(z17);
        }
        iMetaDreamService.removeMetaDreamIsGameFriendCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(GameMsgAIOHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getGameAuthHelper(this$0.n0(), this$0.mGameAppId, null).e();
    }

    private final int e0(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    return 0;
                }
                return 1002;
            }
            return 1001;
        }
        return 1000;
    }

    private final MsgElement f0(JSONObject arkContent, int type) {
        QLog.i("GameMsgAIOHelper", 1, "[createArkMessage], type:" + type);
        if (arkContent == null) {
            QLog.e("GameMsgAIOHelper", 1, "createArkMessage parameters is null");
            return null;
        }
        String optString = arkContent.optString("app");
        String optString2 = arkContent.optString("view");
        String optString3 = arkContent.optString(PublicAccountMessageUtilImpl.META_NAME);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
            if (type == 1) {
                arkContent.put("prompt", " ");
            }
            arkContent.put(DownloadInfo.spKey_Config, "{\"forward\":0,\"autosize\":1,\"type\":\"normal\",\"showSender\":0, \"showTime\":0, \"menuMode\":0}");
            MsgElement createArkElement = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createArkElement(arkContent.toString());
            ArkElement arkElement = createArkElement != null ? createArkElement.arkElement : null;
            if (arkElement != null) {
                createArkElement.arkElement = new ArkElement(arkElement.bytesData, arkElement.linkInfo, Integer.valueOf(e0(type)));
            }
            return createArkElement;
        }
        QLog.e("GameMsgAIOHelper", 1, "createArkMessage one of name, view, meta is null");
        return null;
    }

    private final void g0(a buttonInfo) {
        QQCustomDialog qQCustomDialog;
        FragmentActivity n06 = n0();
        if (buttonInfo != null && n06 != null) {
            if (buttonInfo.getType() == 1) {
                String url = buttonInfo.getUrl();
                Intent intent = new Intent(n06, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", url);
                n06.startActivity(intent);
            } else if (buttonInfo.getType() == 3 && (n06 instanceof ChatActivity)) {
                ((ChatActivity) n06).doOnBackPressed();
            }
            if (!V0() || (qQCustomDialog = this.mAioPopDialog) == null) {
                return;
            }
            qQCustomDialog.dismiss();
            return;
        }
        QLog.i("GameMsgAIOHelper", 1, "[doOnButtonClick] buttonInfo is null.");
    }

    private final void h0() {
        Q0();
        X();
        l1();
        R0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(boolean z16, GameMsgAIOHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.K1();
        } else {
            this$0.I1();
        }
        PopupWindow popupWindow = this$0.mOnlineStatusPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this$0.mOnlineStatusPopupWindow = null;
        if (this$0.mFriendGameInfo != null) {
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            gd1.a aVar = this$0.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar);
            String str = aVar.f401939c;
            gd1.a aVar2 = this$0.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar2);
            iGameMsgHelperApi.reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208987", "1", "", "20", String.valueOf(aVar2.f401946j));
        }
    }

    private final void i0() {
        ((IGameCenterArkMsgSenderApi) QRoute.api(IGameCenterArkMsgSenderApi.class)).registerArkNotify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(String sig, String from) {
        try {
            String str = this.mPeerUid;
            byte[] decode = Base64.decode(sig);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(sig)");
            j1(str, decode, from);
        } catch (Exception e16) {
            QLog.e("GameMsgAIOHelper", 1, e16, new Object[0]);
        }
    }

    private final void j0() {
        x1();
        n1();
        L1();
        m1();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).destroyGamePriorityView();
        ((IGameCenterArkMsgSenderApi) QRoute.api(IGameCenterArkMsgSenderApi.class)).unRegisterArkNotify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(String peerUid, byte[] sigBytes, String from) {
        TempChatGameSession tempChatGameSession;
        IKernelService iKernelService;
        QLog.d("GameMsgAIOHelper", 1, "prepareTempChatSignature,from:" + from + ",sigLen:" + sigBytes.length);
        if (sigBytes.length == 0) {
            return;
        }
        ITempApi iTempApi = (ITempApi) QRoute.api(ITempApi.class);
        String t06 = t0();
        QQAppInterface o06 = o0();
        iTempApi.addTinySessionKey(t06, o06 != null ? o06.getCurrentAccountUin() : null, sigBytes);
        QQAppInterface o07 = o0();
        com.tencent.qqnt.kernel.api.w msgService = (o07 == null || (iKernelService = (IKernelService) o07.getRuntimeService(IKernelService.class, "")) == null) ? null : iKernelService.getMsgService();
        if (msgService == null) {
            QLog.d("GameMsgAIOHelper", 1, "prepareTempChatSignature fail, IMsgService is null");
            return;
        }
        QQAppInterface o08 = o0();
        Intrinsics.checkNotNull(o08);
        String currentUid = o08.getCurrentUid();
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        } else {
            tempChatGameSession = tempChatGameSession2;
        }
        msgService.prepareTempChat(new TempChatPrepareInfo(105, peerUid, "", "", sigBytes, currentUid, "", tempChatGameSession), new IOperateCallback() { // from class: com.tencent.qqnt.aio.helper.gamecenter.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GameMsgAIOHelper.k1(i3, str);
            }
        });
    }

    private final void k0() {
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgAIOHelper", 2, "prepareTempChatSignature, result=" + i3 + ", errMsg=" + errMsg);
        }
    }

    private final void l0() {
        x1();
    }

    private final void l1() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.d(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right1IvClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        aVar3.e().d(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        aVar4.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MainTitleClickEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        aVar5.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.KingIconClick.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar6 = null;
        }
        aVar6.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.JumpSettingEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar7 = this.mAIOContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar7 = null;
        }
        aVar7.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.JumpAddFriendEvent.class)), this.mAction1);
        com.tencent.aio.api.runtime.a aVar8 = this.mAIOContext;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar8;
        }
        aVar2.e().d(jVar.a(Reflection.getOrCreateKotlinClass(GameMsgTitleEvent.MetaDreamAddFriendIconClick.class)), this.mAction1);
    }

    private final void m1() {
        this.mMsgApi.removeMsgListener(this.mMsgListener);
        this.mMsgAioApi.setMsgInterceptListener(null);
    }

    private final FragmentActivity n0() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 != null) {
            return c16.getActivity();
        }
        return null;
    }

    private final void n1() {
        QQAppInterface o06 = o0();
        if (o06 != null) {
            o06.removeObserver(this.mSsoObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface o0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void o1(String appId, String onlineType) {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(appId, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208983", "", "", "8", onlineType);
    }

    private final void q1() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(GameMsgTitleEvent.KingOrWeeklyIconRedDotUpdate.f212239d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f9, code lost:
    
        if ((r1 != null && r1.getRelation() == 0) != false) goto L66;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, T] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, android.text.SpannableString] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CharSequence r0(String nickName, String levelPic) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = p0();
        nd1.a aVar = this.mStrangerRecomInfo;
        if (aVar != null && 1 == aVar.getRelation()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append(nickName);
            QQAppInterface o06 = o0();
            nd1.a aVar2 = this.mStrangerRecomInfo;
            Intrinsics.checkNotNull(aVar2);
            String displayName = com.tencent.mobileqq.utils.ac.z(o06, aVar2.getUin());
            if (!TextUtils.isEmpty(displayName)) {
                Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
                int length = displayName.length() - 1;
                int i3 = 0;
                boolean z16 = false;
                while (i3 <= length) {
                    boolean z17 = Intrinsics.compare((int) displayName.charAt(!z16 ? i3 : length), 32) <= 0;
                    if (z16) {
                        if (!z17) {
                            break;
                        }
                        length--;
                    } else if (z17) {
                        i3++;
                    } else {
                        z16 = true;
                    }
                }
                if (!TextUtils.isEmpty(displayName.subSequence(i3, length + 1).toString())) {
                    sb5.append("(");
                }
            }
            sb5.append(displayName);
            if (!TextUtils.isEmpty(displayName)) {
                Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
                int length2 = displayName.length() - 1;
                int i16 = 0;
                boolean z18 = false;
                while (i16 <= length2) {
                    boolean z19 = Intrinsics.compare((int) displayName.charAt(!z18 ? i16 : length2), 32) <= 0;
                    if (z18) {
                        if (!z19) {
                            break;
                        }
                        length2--;
                    } else if (z19) {
                        i16++;
                    } else {
                        z18 = true;
                    }
                }
                if (!TextUtils.isEmpty(displayName.subSequence(i16, length2 + 1).toString())) {
                    sb5.append(")");
                }
            }
            ?? sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            objectRef.element = sb6;
        } else {
            nd1.a aVar3 = this.mStrangerRecomInfo;
            if (!(aVar3 != null && 2 == aVar3.getRelation())) {
                nd1.a aVar4 = this.mStrangerRecomInfo;
            }
            if (!TextUtils.isEmpty(nickName)) {
                Intrinsics.checkNotNull(nickName);
                objectRef.element = nickName;
            }
        }
        GameGlobalData a16 = GameGlobalData.INSTANCE.a();
        T t16 = objectRef.element;
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type kotlin.String");
        a16.m((String) t16);
        if (!TextUtils.isEmpty(levelPic)) {
            int dpToPx = ViewUtils.dpToPx(16.0f);
            URLDrawable drawable = URLDrawable.getDrawable(levelPic);
            drawable.setBounds(0, 0, dpToPx, dpToPx);
            VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
            verticalCenterImageSpan.setPadding(ViewUtils.dpToPx(2.0f), 0);
            ?? spannableString = new SpannableString(objectRef.element + GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
            spannableString.setSpan(verticalCenterImageSpan, ((CharSequence) objectRef.element).length(), ((CharSequence) objectRef.element).length() + 4, 17);
            objectRef.element = spannableString;
            if (drawable.getStatus() != 1) {
                drawable.setURLDrawableListener(new c(objectRef, drawable));
            }
        }
        return (CharSequence) objectRef.element;
    }

    private final void r1() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(GameMsgTitleEvent.MetaDreamAddFriendEvent.f212241d);
        }
    }

    private final String s0() {
        if (!TextUtils.isEmpty(this.mDisplayName)) {
            return this.mDisplayName;
        }
        IGameMsgAioNtApi iGameMsgAioNtApi = (IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class);
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        return iGameMsgAioNtApi.getFriendNickName(tempChatGameSession);
    }

    private final void s1(boolean showRedDot) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.UpdateRight2IvEvent(showRedDot, true, null, 0, "3"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t0() {
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        return this.mMsgApi.createConvertUinFromTinyId(tempChatGameSession.selfTinyId, tempChatGameSession.peerTinyId);
    }

    private final void t1(String subTitle) {
        Resources resources = MobileQQ.sMobileQQ.getResources();
        Intrinsics.checkNotNull(resources);
        Drawable drawable = resources.getDrawable(R.drawable.arrow_conversation_status);
        Intrinsics.checkNotNullExpressionValue(drawable, "sMobileQQ.resources!!.ge\u2026rrow_conversation_status)");
        int dip2px = ViewUtils.dip2px(9.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        u1(subTitle, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u0(boolean isShield) {
        gd1.a aVar = this.mFriendGameInfo;
        String str = aVar != null ? aVar.f401941e : null;
        if (str == null) {
            str = "";
        }
        if (isShield) {
            return "\u4f60\u5df2\u5c4f\u853d" + str + "\u7684\u4e34\u65f6\u4f1a\u8bdd";
        }
        return "\u4f60\u5df2\u5141\u8bb8\u63a5\u6536" + str + "\u7684\u4e34\u65f6\u4f1a\u8bdd";
    }

    private final void u1(String title, Drawable rightIcon) {
        com.tencent.mobileqq.aio.title.ai aiVar = new com.tencent.mobileqq.aio.title.ai(null, null, rightIcon, title, "5");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.SubTitleResponseEvent(aiVar));
        }
    }

    private final boolean v0(QQAppInterface app, Context context, String roleId) {
        boolean contains$default;
        String str;
        if (this.mIsMetaDream) {
            return com.tencent.mobileqq.gamecenter.qa.util.l.f212717a.b(context, roleId);
        }
        try {
            IRuntimeService runtimeService = app.getRuntimeService(IGameMsgManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
            String fullUrl = ((IGameMsgManagerService) runtimeService).getPlayerInfoUrl();
            if (!TextUtils.isEmpty(fullUrl) && context != null && !TextUtils.isEmpty(roleId)) {
                Intrinsics.checkNotNullExpressionValue(fullUrl, "fullUrl");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) fullUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (contains$default) {
                    str = fullUrl + "&roleId=" + URLEncoder.encode(roleId, "utf-8");
                } else {
                    str = fullUrl + "?roleId=" + URLEncoder.encode(roleId, "utf-8");
                }
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgAIOHelper", 1, th5, new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(CharSequence title) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new AIOTitleEvent.TitleResponseEvent(4, title));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Object data) {
        try {
            QLog.i("GameMsgAIOHelper", 1, "[onAddOrShiledFriendCallback], data:" + data);
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type org.json.JSONObject");
            int optInt = ((JSONObject) data).optInt("op_type");
            if (optInt == 2) {
                this.mShieldValue = true;
            } else if (optInt == 4) {
                this.mShieldValue = false;
            }
        } catch (Throwable th5) {
            QLog.w("GameMsgAIOHelper", 1, th5.getMessage());
        }
    }

    private final void x1() {
        IGameMsgManagerService iGameMsgManagerService;
        QQAppInterface o06 = o0();
        if (o06 == null || (iGameMsgManagerService = (IGameMsgManagerService) o06.getRuntimeService(IGameMsgManagerService.class)) == null) {
            return;
        }
        iGameMsgManagerService.cleanSessionUnread(t0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(Object detailInfos) {
        QLog.i("GameMsgAIOHelper", 1, "[handleGameUsrInfoChangedNotifyRsp]");
        try {
            if (detailInfos instanceof ArrayList) {
                Iterator it = ((ArrayList) detailInfos).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof gd1.a) {
                        TempChatGameSession tempChatGameSession = null;
                        if (!TextUtils.isEmpty(((gd1.a) next).f401937a)) {
                            String str = ((gd1.a) next).f401937a;
                            TempChatGameSession tempChatGameSession2 = this.mGameSession;
                            if (tempChatGameSession2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                                tempChatGameSession2 = null;
                            }
                            if (Intrinsics.areEqual(str, tempChatGameSession2.peerRoleId)) {
                                gd1.a aVar = (gd1.a) next;
                                this.mFriendGameInfo = aVar;
                                z1(aVar);
                                if (this.mFriendGameInfo != null) {
                                    IGameMsgUnissoHandlerApi iGameMsgUnissoHandlerApi = (IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class);
                                    int i3 = this.mHashCode;
                                    gd1.a aVar2 = this.mFriendGameInfo;
                                    Intrinsics.checkNotNull(aVar2);
                                    iGameMsgUnissoHandlerApi.getGameStartPriority(i3, aVar2.f401939c);
                                    gd1.a aVar3 = this.mFriendGameInfo;
                                    Intrinsics.checkNotNull(aVar3);
                                    String str2 = aVar3.f401939c;
                                    Intrinsics.checkNotNullExpressionValue(str2, "mFriendGameInfo!!.mAppId");
                                    this.mGameAppId = str2;
                                }
                                QLog.i("GameMsgAIOHelper", 1, "update friend info.");
                            }
                        }
                        if (!TextUtils.isEmpty(((gd1.a) next).f401937a)) {
                            String str3 = ((gd1.a) next).f401937a;
                            TempChatGameSession tempChatGameSession3 = this.mGameSession;
                            if (tempChatGameSession3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                            } else {
                                tempChatGameSession = tempChatGameSession3;
                            }
                            if (Intrinsics.areEqual(str3, tempChatGameSession.selfRoleId)) {
                                this.mMyGameInfo = (gd1.a) next;
                                QLog.i("GameMsgAIOHelper", 1, "update my info.");
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgAIOHelper", 1, th5.getMessage());
        }
    }

    private final void y1() {
        if (this.mFriendGameInfo != null) {
            IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
            Intrinsics.checkNotNull(iGameMsgManagerService);
            gd1.a aVar = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar);
            boolean isGameMsgSync = iGameMsgManagerService.isGameMsgSync(aVar.f401939c);
            if (QLog.isColorLevel()) {
                QLog.d("GameMsgAIOHelper", 2, "isMsgSync:" + isGameMsgSync);
            }
            if (!isGameMsgSync && ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isShowMsg(o0(), t0())) {
                IGameMsgUnissoHandlerApi iGameMsgUnissoHandlerApi = (IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class);
                int i3 = this.mHashCode;
                gd1.a aVar2 = this.mFriendGameInfo;
                Intrinsics.checkNotNull(aVar2);
                iGameMsgUnissoHandlerApi.setGameSwitch(i3, aVar2.f401939c, 1, 0, null);
                this.mHasSetSwitch = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Object popInfo) {
        QLog.i("GameMsgAIOHelper", 1, "[onGetAioPopInfo] data:" + popInfo);
        if (popInfo instanceof JSONObject) {
            try {
                String optString = ((JSONObject) popInfo).optString("title");
                String optString2 = ((JSONObject) popInfo).optString("content");
                JSONArray optJSONArray = ((JSONObject) popInfo).optJSONArray("buttons");
                if (!TextUtils.isEmpty(optString2) && optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = optJSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject = (JSONObject) obj;
                        a aVar = new a();
                        aVar.d(jSONObject.optString("title"));
                        if (!TextUtils.isEmpty(aVar.getText())) {
                            aVar.f(jSONObject.optString("url"));
                            aVar.e(jSONObject.optInt("type"));
                            arrayList.add(aVar);
                        }
                    }
                    if (arrayList.size() == 1) {
                        D1(optString, optString2, (a) arrayList.get(0), null);
                    } else if (arrayList.size() >= 2) {
                        D1(optString, optString2, (a) arrayList.get(0), (a) arrayList.get(1));
                    } else {
                        QLog.i("GameMsgAIOHelper", 1, "[onGetAioPopInfo] no button.");
                    }
                }
            } catch (JSONException e16) {
                QLog.e("GameMsgAIOHelper", 1, e16, new Object[0]);
            }
        }
    }

    private final void z1(gd1.a detailInfo) {
        QLog.d("GameMsgAIOHelper", 2, "[setTitleInfo]:" + detailInfo);
        if (T0()) {
            return;
        }
        if (detailInfo != null) {
            try {
                if (this.mStrangerRecomInfo != null) {
                    v1(r0(detailInfo.f401941e, detailInfo.f401943g));
                    String subTitle = detailInfo.a();
                    if (!TextUtils.isEmpty(subTitle)) {
                        Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
                        t1(subTitle);
                        o1(detailInfo.f401939c, String.valueOf(detailInfo.f401946j));
                    }
                    if (this.mIsMetaDream) {
                        return;
                    }
                    p1(detailInfo.f401948l);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("GameMsgAIOHelper", 1, th5.getMessage());
                return;
            }
        }
        QLog.w("GameMsgAIOHelper", 1, "detail or strangerRecom info is null. detail:" + detailInfo + ",strangerRecom:" + this.mStrangerRecomInfo);
        GameGlobalData a16 = GameGlobalData.INSTANCE.a();
        CharSequence p06 = p0();
        Intrinsics.checkNotNull(p06, "null cannot be cast to non-null type kotlin.String");
        a16.m((String) p06);
        v1(p0());
    }

    public final void K1() {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).showGamePriorityView(this.mFriendGameInfo, n0(), this.mGameProrityList, this.mGamePackageName, this.mGameTicket);
    }

    public final void P0() {
        GameGlobalData.Companion companion = GameGlobalData.INSTANCE;
        if (companion.a().getMRedDotShow()) {
            s1(false);
            if (o0() != null && this.mFriendGameInfo != null) {
                a.Companion companion2 = p03.a.INSTANCE;
                QQAppInterface o06 = o0();
                p03.a a16 = companion2.a(o06 != null ? o06.getCurrentUin() : null);
                gd1.a aVar = this.mFriendGameInfo;
                Intrinsics.checkNotNull(aVar);
                a16.h("game_msg_chatpie_reddot_click_" + aVar.f401939c, true);
            }
            companion.a().n(false);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.Z;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgAIOHelper";
    }

    public final String m0(String appId, String nickName) {
        StringBuilder sb5 = new StringBuilder();
        if (appId != null) {
            switch (appId.hashCode()) {
                case -1263386105:
                    if (appId.equals("1104294055")) {
                        sb5.append("\u5730\u4e0b\u57ce\u4e0e\u52c7\u58eb");
                        break;
                    }
                    break;
                case -1208831194:
                    if (appId.equals(QZoneShareManager.GLORY_OF_KINGS)) {
                        sb5.append("\u738b\u8005\u8363\u8000");
                        break;
                    }
                    break;
                case -957280425:
                    if (appId.equals("1109807272")) {
                        sb5.append("\u68a6\u60f3\u65b0\u5927\u9646");
                        break;
                    }
                    break;
                case -349185747:
                    if (appId.equals("1105371489")) {
                        sb5.append("\u4e71\u4e16\u738b\u8005");
                        break;
                    }
                    break;
                case 449633718:
                    if (appId.equals("1106040804")) {
                        sb5.append("\u82f1\u96c4\u8054\u76df\u624b\u6e38");
                        break;
                    }
                    break;
                case 566198426:
                    if (appId.equals("1106467070")) {
                        sb5.append("\u548c\u5e73\u7cbe\u82f1");
                        break;
                    }
                    break;
                case 677978945:
                    if (appId.equals("1106838536")) {
                        sb5.append("\u4f7f\u547d\u53ec\u5524");
                        break;
                    }
                    break;
            }
        }
        return sb5.toString() + nickName;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mCustomParam = a16.g().l();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgAIOHelper", 2, "[onMoveToState] state:" + state);
        }
        if (state == 0) {
            h0();
            return;
        }
        if (state == 8) {
            k0();
            return;
        }
        if (state == 12) {
            j0();
        } else if (state == 3) {
            l0();
        } else {
            if (state != 4) {
                return;
            }
            i0();
        }
    }

    /* renamed from: q0, reason: from getter */
    public final gd1.a getMFriendGameInfo() {
        return this.mFriendGameInfo;
    }

    public final void w0() {
        String str;
        String str2;
        String str3;
        String m06;
        String s06;
        Intent intent = new Intent();
        TempChatGameSession tempChatGameSession = this.mGameSession;
        TempChatGameSession tempChatGameSession2 = null;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        String str4 = tempChatGameSession.peerOpenId;
        if (str4 == null) {
            str4 = "";
        }
        gd1.a aVar = this.mFriendGameInfo;
        if (aVar == null) {
            str = "";
            str2 = str;
        } else {
            Intrinsics.checkNotNull(aVar);
            str = aVar.f401939c;
            Intrinsics.checkNotNullExpressionValue(str, "mFriendGameInfo!!.mAppId");
            gd1.a aVar2 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar2);
            if (aVar2.f401941e != null) {
                gd1.a aVar3 = this.mFriendGameInfo;
                Intrinsics.checkNotNull(aVar3);
                str2 = aVar3.f401941e;
                Intrinsics.checkNotNullExpressionValue(str2, "mFriendGameInfo!!.mNickInGame");
            } else {
                str2 = s0();
            }
            gd1.a aVar4 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar4);
            intent.putExtra("appid", aVar4.f401939c);
            gd1.a aVar5 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar5);
            intent.putExtra("account", aVar5.f401938b);
        }
        gd1.a aVar6 = this.mMyGameInfo;
        if (aVar6 == null || this.mOpenFrom == 5) {
            str3 = "";
        } else {
            Intrinsics.checkNotNull(aVar6);
            if (aVar6.f401941e != null) {
                gd1.a aVar7 = this.mMyGameInfo;
                Intrinsics.checkNotNull(aVar7);
                s06 = aVar7.f401941e;
            } else {
                s06 = s0();
            }
            str3 = "\u6211\u662f" + m0(str, s06);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG, str3);
        }
        if (this.mOpenFrom == 5) {
            m06 = s0();
        } else {
            m06 = m0(str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgAIOHelper", 2, "onClick: ivTitleBtnRightImage mAppId = " + str + " uinName = " + m06 + "\n message = " + str3 + " openId = " + str4 + " mShieldValue = " + this.mShieldValue);
        }
        intent.putExtra("openid", str4);
        intent.putExtra("uinname", m06);
        intent.putExtra("uintype", 10007);
        intent.putExtra("uin", t0());
        TempChatGameSession tempChatGameSession3 = this.mGameSession;
        if (tempChatGameSession3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession3 = null;
        }
        String str5 = tempChatGameSession3.peerRoleId;
        if (str5 == null) {
            str5 = "";
        }
        intent.putExtra(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, str5);
        TempChatGameSession tempChatGameSession4 = this.mGameSession;
        if (tempChatGameSession4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
        } else {
            tempChatGameSession2 = tempChatGameSession4;
        }
        String str6 = tempChatGameSession2.selfRoleId;
        intent.putExtra(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, str6 != null ? str6 : "");
        intent.putExtra(AppConstants.Key.KEY_GAME_CHATPIE_HASHCODE, hashCode());
        intent.putExtra(AppConstants.Key.KEY_GAME_IS_SHILED, this.mShieldValue);
        intent.putExtra("KEY_UID", this.mPeerUid);
        FragmentActivity n06 = n0();
        if (n06 != null) {
            QPublicFragmentActivity.startForResult(n06, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
        }
        if (this.mFriendGameInfo != null) {
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            gd1.a aVar8 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar8);
            iGameMsgHelperApi.reportForGameMsg(aVar8.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208985", "", "", "20", "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/GameMsgAIOHelper$g", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$b;", "", "text", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements IGameMsgAioNtApi.b {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.f13750071, 1).show();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(CharSequence text) {
            String str;
            Integer num;
            gd1.a aVar = GameMsgAIOHelper.this.mFriendGameInfo;
            TempChatGameSession tempChatGameSession = null;
            String obj = text != null ? text.toString() : null;
            if (QLog.isColorLevel()) {
                if (obj != null) {
                    byte[] bytes = obj.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    if (bytes != null) {
                        num = Integer.valueOf(bytes.length);
                        QLog.i("GameMsgAIOHelper", 2, "[onIntercept] textLen:" + num + ",msgMaxLen:" + (aVar == null ? Integer.valueOf(aVar.f401952p) : null));
                    }
                }
                num = null;
                if (aVar == null) {
                }
                QLog.i("GameMsgAIOHelper", 2, "[onIntercept] textLen:" + num + ",msgMaxLen:" + (aVar == null ? Integer.valueOf(aVar.f401952p) : null));
            }
            if (GameMsgAIOHelper.this.mFriendGameInfo != null) {
                IGameCenterCommonApi iGameCenterCommonApi = (IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class);
                TempChatGameSession tempChatGameSession2 = GameMsgAIOHelper.this.mGameSession;
                if (tempChatGameSession2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                } else {
                    tempChatGameSession = tempChatGameSession2;
                }
                if (iGameCenterCommonApi.isApplyPartnerContact(tempChatGameSession)) {
                    str = "92050";
                } else {
                    str = "92005";
                }
                String str2 = str;
                IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
                gd1.a aVar2 = GameMsgAIOHelper.this.mFriendGameInfo;
                Intrinsics.checkNotNull(aVar2);
                iGameMsgHelperApi.reportForGameMsgInSubThread(aVar2.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str2, "206356", null, null, "20", null);
            }
            if (!(obj == null || obj.length() == 0) && aVar != null && aVar.f401952p > 0) {
                byte[] bytes2 = obj.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                if (bytes2.length > aVar.f401952p) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameMsgAIOHelper.g.c();
                        }
                    });
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(final Object sigValue) {
        QLog.i("GameMsgAIOHelper", 2, "[handleGetSessionSigRsp]");
        if ((sigValue instanceof String) && !TextUtils.isEmpty((CharSequence) sigValue)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.e
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgAIOHelper.J0(sigValue, this);
                }
            }, 16, null, true);
        } else {
            QLog.i("GameMsgAIOHelper", 1, "[handleGetSessionSigRsp] sig is Empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0() {
        QLog.i("GameMsgAIOHelper", 1, "[handleSetSwitchCallback]");
        Y();
    }

    public final void g1() {
        String str;
        QLog.i("GameMsgAIOHelper", 2, "[onSubTitleClick]");
        gd1.a aVar = this.mFriendGameInfo;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (TextUtils.isEmpty(aVar.f401938b)) {
                return;
            }
            final boolean z16 = getMFriendGameInfo() != null && this.mOpenSwitch == 1 && com.tencent.mobileqq.cooperation.a.d(this.mGamePackageName, BaseApplicationImpl.getApplication()) && !this.mGameProrityList.isEmpty();
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameMsgAIOHelper.h1(z16, this, view);
                }
            };
            Bundle bundle = new Bundle();
            bundle.putInt("from", 1);
            if (z16) {
                str = "\u7acb\u5373\u542f\u52a8\u83b7\u5f97\u7279\u6743";
            } else {
                str = "\u7acb\u5373\u4e0b\u8f7d";
            }
            bundle.putString("startBtnText", str);
            gd1.a aVar2 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar2);
            bundle.putString("onlineText", aVar2.a());
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            int size = this.mGameProrityList.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.mGameProrityList.get(i3).getMIconUrl());
                arrayList2.add(this.mGameProrityList.get(i3).getMDetailInfo());
            }
            bundle.putStringArrayList("priorityIconList", arrayList);
            bundle.putStringArrayList("priorityDetailList", arrayList2);
            QQAppInterface o06 = o0();
            Intrinsics.checkNotNull(o06);
            IRuntimeService runtimeService = o06.getRuntimeService(IGameMsgManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp()!!.getRuntimeSer\u2026ssConstant.MAIN\n        )");
            this.mOnlineStatusPopupWindow = ((IGameMsgManagerService) runtimeService).showGameAIOStatusPopupWindow(this.mFriendGameInfo, n0(), bundle, onClickListener);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 4, 3, 8, 12};
    }

    private final void S0(MsgElement arkElement) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MsgTypeFilter(11, new ArrayList()));
        this.mMsgApi.queryMsgsWithFilter(0L, 0L, new QueryMsgsParams(new ChatInfo(105, this.mPeerUid), arrayList, new ArrayList(), 0L, 0L, Integer.MAX_VALUE, true, true), new d(arkElement));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0() {
        IGameMsgBoxManager iGameMsgBoxManager;
        String str;
        String str2;
        try {
            QQAppInterface o06 = o0();
            if (o06 == null || (iGameMsgBoxManager = (IGameMsgBoxManager) o06.getRuntimeService(IGameMsgBoxManager.class, "")) == null) {
                return;
            }
            gd1.a aVar = this.mFriendGameInfo;
            TempChatGameSession tempChatGameSession = null;
            String str3 = aVar != null ? aVar.f401941e : null;
            if (str3 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "mFriendGameInfo?.mNickInGame ?: \"\"");
                str = str3;
            }
            gd1.a aVar2 = this.mMyGameInfo;
            String str4 = aVar2 != null ? aVar2.f401941e : null;
            if (str4 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "mMyGameInfo?.mNickInGame ?: \"\"");
                str2 = str4;
            }
            FragmentActivity n06 = n0();
            TempChatGameSession tempChatGameSession2 = this.mGameSession;
            if (tempChatGameSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession2 = null;
            }
            String str5 = tempChatGameSession2.peerOpenId;
            TempChatGameSession tempChatGameSession3 = this.mGameSession;
            if (tempChatGameSession3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            } else {
                tempChatGameSession = tempChatGameSession3;
            }
            iGameMsgBoxManager.startAddFriend(n06, str5, String.valueOf(tempChatGameSession.gameAppId), str, str2);
            ReportController.n(o0(), "P_CliOper", "dc00898", t0(), "0X800BF35", "0X800BF35", 0, 1, 0, "", "", "", "");
        } catch (Throwable th5) {
            QLog.e("GameMsgAIOHelper", 1, th5, new Object[0]);
        }
    }

    public final void X0() {
        String str;
        P0();
        boolean d16 = com.tencent.mobileqq.cooperation.a.d(this.mGamePackageName, BaseApplicationImpl.getApplication());
        QLog.i("GameMsgAIOHelper", 1, "mGamePackageName:" + this.mGamePackageName + " isInstall:" + d16);
        gd1.a aVar = this.mFriendGameInfo;
        if (aVar == null) {
            QLog.i("GameMsgAIOHelper", 1, "friendGameInfo is null");
            return;
        }
        if (GameGlobalData.INSTANCE.a().getMRedDotShow()) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207563", "", "", "20", "0");
        }
        IGameCenterCommonApi iGameCenterCommonApi = (IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class);
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        if (iGameCenterCommonApi.isApplyPartnerContact(tempChatGameSession)) {
            str = "92050";
        } else {
            str = "92005";
        }
        String str2 = str;
        if (this.mOpenSwitch == 1 && d16 && (!this.mGameProrityList.isEmpty())) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str2, "206357", "1", "1", "20", "0");
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207565", "", "", "20", "0");
            K1();
        } else {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(aVar.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str2, "206357", "0", "1", "20", "0");
            I1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(boolean z16) {
        if (z16) {
            QQToast.makeText(MobileQQ.sMobileQQ, R.string.f13751072, 0).show();
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u7533\u8bf7\u6dfb\u52a0\u6e38\u620f\u597d\u53cb\u5931\u8d25", 0).show();
        }
    }

    private final void e1(JSONObject arkJson) {
        MsgElement f06;
        if (arkJson == null) {
            return;
        }
        QLog.i("GameMsgAIOHelper", 2, "[onShowArkMessage] arkJson:" + arkJson);
        int optInt = arkJson.optInt("type");
        if (optInt != 1 && optInt != 2 && optInt != 3) {
            QLog.e("GameMsgAIOHelper", 1, "[onShowArkMessage] unKnow type:" + optInt);
            return;
        }
        if (arkJson.has("content") && (f06 = f0(arkJson.optJSONObject("content"), optInt)) != null) {
            if (optInt == 1) {
                S0(f06);
            } else if (optInt == 2 || optInt == 3) {
                ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).insertLocalArkRecord(this.mPeerUid, f06, false);
            }
        }
    }

    private final void f1(Object aioPopInfo) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (aioPopInfo == null || (optJSONObject = (jSONObject = (JSONObject) aioPopInfo).optJSONObject("new_page_info")) == null || optJSONObject.optInt("new_page_gray_switch") == 0) {
            return;
        }
        this.mIsShowCouponRedPackEntry = true;
        this.mCouponRedPackJumpUrl = optJSONObject.optString("sgame_red_envelope_url");
        if (1 == jSONObject.optInt("qq_privacy_switch")) {
            A1(optJSONObject.optJSONObject("sgame_aio_ark"));
        } else {
            H1(optJSONObject.optJSONObject("sgame_aio_ark"));
        }
    }

    private final CharSequence p0() {
        String qqStr = HardCodeUtil.qqStr(R.string.f1374506w);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.game_msg_from_nickname_default)");
        return qqStr;
    }

    private final void p1(String iconUrl) {
        if (iconUrl == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new GameMsgTitleEvent.KingIconUpdate(iconUrl));
        }
    }

    private final void w1(JSONObject dataObj) {
        if (dataObj == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new GameMsgTitleEvent.WeeklyIconUpdate(dataObj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(Object data) {
        String str;
        boolean z16 = false;
        if (data != null && (data instanceof JSONObject)) {
            QLog.i("GameMsgAIOHelper", 1, "[onGetGameStartPriority] data:" + data);
            try {
                if (((JSONObject) data).optString("ret_code") != null) {
                    JSONObject optJSONObject = ((JSONObject) data).optJSONObject("download_info");
                    if (optJSONObject != null) {
                        this.mGamePackageName = optJSONObject.optString("pkg_name");
                        this.mGameTicket = optJSONObject.optString("ticket");
                    }
                    this.mOpenSwitch = ((JSONObject) data).optInt("open_switch");
                    JSONArray optJSONArray = ((JSONObject) data).optJSONArray("start_priority_list");
                    this.mGameProrityList.clear();
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            com.tencent.mobileqq.gamecenter.data.g gVar = new com.tencent.mobileqq.gamecenter.data.g();
                            gVar.c(optJSONObject2.optString("content"));
                            gVar.d(optJSONObject2.optString("icon_url"));
                            this.mGameProrityList.add(gVar);
                        }
                    }
                    w1(((JSONObject) data).optJSONObject("weekly_paper_info"));
                }
            } catch (Exception e16) {
                QLog.e("GameMsgAIOHelper", 1, e16, new Object[0]);
            }
        }
        if (!this.mReportGameIcon && this.mFriendGameInfo != null) {
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            gd1.a aVar = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar);
            String str2 = aVar.f401939c;
            if (this.mOpenSwitch == 1) {
                str = "1";
            } else {
                str = "0";
            }
            iGameMsgHelperApi.reportForGameMsg(str2, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207561", str, "", "8", "0");
            this.mReportGameIcon = true;
        }
        if (o0() != null && this.mFriendGameInfo != null) {
            a.Companion companion = p03.a.INSTANCE;
            QQAppInterface o06 = o0();
            p03.a a16 = companion.a(o06 != null ? o06.getCurrentUin() : null);
            gd1.a aVar2 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar2);
            z16 = a16.c("game_msg_chatpie_reddot_click_" + aVar2.f401939c, false);
        }
        if (this.mOpenSwitch != 1 || z16) {
            return;
        }
        IGameMsgHelperApi iGameMsgHelperApi2 = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        gd1.a aVar3 = this.mFriendGameInfo;
        Intrinsics.checkNotNull(aVar3);
        iGameMsgHelperApi2.reportForGameMsg(aVar3.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207562", "", "", "8", "0");
        GameGlobalData.INSTANCE.a().n(true);
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(Object root) {
        gd1.a aVar;
        QLog.d("GameMsgAIOHelper", 2, "[handleGetStrangerRecomInfoRsp], data:" + root);
        if (root instanceof JSONObject) {
            try {
                String optString = ((JSONObject) root).optString("uin");
                int optInt = ((JSONObject) root).optInt("relationship");
                int optInt2 = ((JSONObject) root).optInt("add_friend_type");
                int optInt3 = ((JSONObject) root).optInt("is_shield");
                boolean optBoolean = ((JSONObject) root).optBoolean("is_show_partner_ui");
                QLog.i("GameMsgAIOHelper", 1, "relation:" + optInt + ",addFriendType:" + optInt2 + ",isShield:" + optInt3);
                nd1.a aVar2 = new nd1.a();
                aVar2.e(optInt);
                aVar2.d(optInt2);
                aVar2.f(optInt3);
                aVar2.g(optString);
                this.mStrangerRecomInfo = aVar2;
                this.mShieldValue = optInt3 == 1;
                z1(this.mFriendGameInfo);
                String displayName = com.tencent.mobileqq.utils.ac.z(o0(), optString);
                if (TextUtils.isEmpty(displayName) && (aVar = this.mFriendGameInfo) != null) {
                    Intrinsics.checkNotNull(aVar);
                    displayName = aVar.f401941e;
                }
                Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
                this.mDisplayName = displayName;
                this.mPartnerHelper.B(optBoolean);
                this.mTopBarHelper.z(optInt);
                if (this.mFriendGameInfo != null) {
                    IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
                    gd1.a aVar3 = this.mFriendGameInfo;
                    Intrinsics.checkNotNull(aVar3);
                    String str = aVar3.f401939c;
                    QQAppInterface o06 = o0();
                    iGameMsgHelperApi.reportForGameMsg(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92015", "207856", optString, o06 != null ? o06.getCurrentAccountUin() : null, "8", "");
                }
            } catch (Throwable th5) {
                QLog.e("GameMsgAIOHelper", 1, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(JSONObject json) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        QLog.d("GameMsgAIOHelper", 2, "[handleGetProfileGuideRsp]");
        if (json == null) {
            return;
        }
        gd1.a aVar = this.mFriendGameInfo;
        String str5 = "";
        if (aVar == null) {
            str = "";
        } else {
            Intrinsics.checkNotNull(aVar);
            str = aVar.f401939c;
        }
        if (this.mFriendGameInfo == null) {
            str2 = "GameMsgAIOHelper";
            i3 = 1;
        } else {
            if (json.has("tianji_id")) {
                str5 = String.valueOf(json.optInt("tianji_id"));
            }
            String str6 = str5;
            int i16 = this.mOpenFrom;
            String str7 = "1";
            if (i16 != 5) {
                if (i16 == 1 || i16 != 4) {
                }
                str3 = "1";
            } else {
                str3 = "3";
            }
            IGameCenterCommonApi iGameCenterCommonApi = (IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class);
            TempChatGameSession tempChatGameSession = this.mGameSession;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            if (iGameCenterCommonApi.isApplyPartnerContact(tempChatGameSession)) {
                str4 = "92050";
            } else {
                str4 = "92005";
            }
            String str8 = str4;
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            gd1.a aVar2 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar2);
            String valueOf = String.valueOf(aVar2.f401946j);
            gd1.a aVar3 = this.mFriendGameInfo;
            Intrinsics.checkNotNull(aVar3);
            if (aVar3.f401949m != 0) {
                str7 = "0";
            }
            str2 = "GameMsgAIOHelper";
            i3 = 1;
            iGameMsgHelperApi.reportForGameMsg865WithTianJi(str, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", str8, "206350", valueOf, str7, "8", str3, String.valueOf(this.mOpenFrom), "", str6);
        }
        if ((json.optInt("qcard_switch", 0) == i3 ? i3 : 0) == 0 || T0()) {
            return;
        }
        Dialog dialog = this.mProfileGuideDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                return;
            }
        }
        try {
            Dialog createProfileGuideDailg = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).createProfileGuideDailg(n0(), str);
            this.mProfileGuideDialog = createProfileGuideDailg;
            Intrinsics.checkNotNull(createProfileGuideDailg);
            createProfileGuideDailg.show();
        } catch (Throwable th5) {
            QLog.e(str2, i3, "show ProfileGuideDialog e:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(DialogInterface dialogInterface, int i3) {
    }
}
