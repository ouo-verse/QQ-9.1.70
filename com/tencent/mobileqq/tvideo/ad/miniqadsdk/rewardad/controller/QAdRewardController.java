package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.ams.xsad.rewarded.f;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.QAdRewardSwitchStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.RewardVrReportData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardUpdateModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.QAdExtraParamsType;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdExtraInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import com.tencent.tvideo.protocol.pb.RewardAdReportInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportType;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import com.tencent.tvideo.protocol.pb.RewardSwitchType;
import ex2.a;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pw2.i;
import pw2.n;
import pw2.w;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00c1\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001RB\u0015\u0012\n\u0010\u00be\u0001\u001a\u0005\u0018\u00010\u00bb\u0001\u00a2\u0006\u0006\b\u00bf\u0001\u0010\u00c0\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00101\u001a\u000200H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001032\u0006\u00102\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\tH\u0002J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020\tH\u0002J\b\u0010>\u001a\u00020\tH\u0002J\b\u0010?\u001a\u00020\u0016H\u0002J\n\u0010A\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010B\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010C\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010D\u001a\u00020&H\u0002J6\u0010J\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u00162\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010G2\u0006\u0010I\u001a\u00020\u0016H\u0002J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010K\u001a\u00020&H\u0002J\n\u0010N\u001a\u0004\u0018\u00010MH\u0002J\u0018\u0010Q\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010P\u001a\u00020@H\u0016J\u0012\u0010R\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010S\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010T\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010U\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010V\u001a\u00020\tH\u0016J\u0012\u0010W\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010Z\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010\\\u001a\u00020\t2\u0006\u0010[\u001a\u000200H\u0016J\b\u0010]\u001a\u00020\tH\u0016J\u0012\u0010`\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010^H\u0016J\u001a\u0010b\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010a\u001a\u00020\u0016H\u0016J\u001a\u0010e\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0010\u0010f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010g\u001a\u00020\tH\u0016J\b\u0010h\u001a\u00020\tH\u0016J\b\u0010i\u001a\u00020\tH\u0016J\b\u0010j\u001a\u00020\tH\u0016J\u0010\u0010l\u001a\u00020\t2\u0006\u0010k\u001a\u00020&H\u0016J\u0010\u0010n\u001a\u00020\t2\u0006\u0010m\u001a\u00020\u0016H\u0016J\n\u0010p\u001a\u0004\u0018\u00010oH\u0016J\n\u0010q\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010r\u001a\u0004\u0018\u000103H\u0016J\n\u0010s\u001a\u0004\u0018\u00010MH\u0016J\u0006\u0010t\u001a\u00020\tJ\b\u0010u\u001a\u00020\tH\u0016R\u0018\u0010x\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u001e\u0010{\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bt\u0010\u0087\u0001R\"\u0010\u008c\u0001\u001a\f\u0012\u0005\u0012\u00030\u008a\u0001\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b!\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\"\u0010\u008d\u0001R\u001b\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b%\u0010\u0090\u0001R\u001a\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001a\u0010\u0092\u0001R\u0017\u0010\u0094\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010=R\u0017\u0010\u0095\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010=R\u0017\u0010\u0096\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010=R\u0017\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010=R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b8\u0010\u008d\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b?\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bQ\u0010\u009c\u0001R\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0010\u0010\u009e\u0001R\u0019\u0010\u00a2\u0001\u001a\u00030\u00a0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b>\u0010\u00a1\u0001R\u001a\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b7\u0010\u008d\u0001R\u0017\u0010\u00a6\u0001\u001a\u00030\u00a4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b<\u0010\u00a5\u0001R\u0017\u0010\u00a7\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010=R\u0018\u0010\u00a8\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b*\u0010\u008d\u0001R\u001a\u0010\u00aa\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b+\u0010\u00a9\u0001R\u0016\u0010\u00ab\u0001\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bB\u0010\u008d\u0001R\u001a\u0010\u00ac\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\n\u0010\u008d\u0001R\u0017\u0010\u00ad\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0015R\u0019\u0010\u00b0\u0001\u001a\u00030\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u00af\u0001R\u001a\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b=\u0010\u00b1\u0001R\u001a\u0010\u00b3\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b,\u0010\u00b1\u0001R6\u0010\u00b8\u0001\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u00b5\u00010\u00b4\u0001j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u00b5\u0001`\u00b6\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0014\u0010\u00b7\u0001R\u0018\u0010\u00ba\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b9\u0001\u0010=R\u001c\u0010\u00be\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001\u00a8\u0006\u00c2\u0001"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController;", "", "Lfx2/b;", "Lcom/tencent/ams/xsad/rewarded/f;", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "Lgw2/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/g;", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "rewardAd", "", "W", "", "v", "u", "Lcom/tencent/ams/xsad/rewarded/RewardedAdError;", "errorInfo", "N", "H", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "b0", "I", "", "isUnlock", "Lcom/tencent/ams/xsad/rewarded/b;", "rewardItem", UserInfo.SEX_FEMALE, "J", "G", "Lcom/tencent/ams/xsad/rewarded/event/ModuleEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "D", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "", "switchType", "X", "l", "T", "U", "a0", "Lcom/tencent/tvideo/protocol/pb/RewardSwitchType;", DomainData.DOMAIN_NAME, "y", "", "t", "rewardedAd", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "w", ExifInterface.LATITUDE_SOUTH, "isRequestError", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "Y", "Lcom/tencent/tvideo/protocol/pb/AdAction;", "adAction", BdhLogUtil.LogTag.Tag_Req, "Z", "P", "L", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/a;", HippyTKDListViewAdapter.X, "V", "O", ReportConstant.COSTREPORT_PREFIX, "eid", "isMuskArea", "", QQBrowserActivity.APP_PARAM, "isPopUpWindow", "o", "clickField", "p", "Landroid/view/View;", "r", "adLoadInfo", "listener", "M", "a", "c", "b", "K6", "we", "L7", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$ClickInfo;", "clickInfo", "Ab", "playedDuration", "jb", ICustomDataEditor.STRING_ARRAY_PARAM_5, "Lcom/tencent/ams/xsad/rewarded/view/a;", "dialog", "S7", "isExistClick", "gb", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$b;", "switchCallBack", "m6", "yg", "onAdPlayStart", "onAdPlayPause", "onAdPlayResume", "onAdPlayComplete", "position", "Od", "isMute", "J1", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "f", "getRequestId", "g", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, RewardAdMethodHandler.RewardAdEvent.ON_ORIGINAL_EXPOSURE, "d", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/a;", "mRewardListener", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mRewardListenerRef", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/f;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/f;", "mVrHelper", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/c;", h.F, "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/c;", "mQAdRewardPlayerEventHandler", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/d;", "i", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/d;", "mQAdRewardPlayerReport", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "mRewardAdInfo", "", "Lcom/tencent/tvideo/protocol/pb/RewardAdReportInfo;", "Ljava/util/List;", "mRewardAdReportInfos", "Ljava/lang/String;", "mRequestId", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/a;", "mQAdRewardPlayHandler", "Lfx2/b;", "mRewardAdLoadInfo", "isAdClosed", "isCurrAdReachUnlockCondition", "isPlayCompleted", "isPopWindowShow", "mEncryData", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "mRewardedAd", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/a;", "mQAdRewardLoadManager", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", "mCurrAdUnlockInfo", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardUpdateModel;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardUpdateModel;", "mAdRewardUpdateModel", "mErrorMsg", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", "mQAdRewardDynamicVRHelper", "mVrInitialized", "mIsOverlay", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$b;", "mSwitchCallBack", "mSpecialId", "mCurrPenetrateInfo", "mOriginProcessNum", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/QAdRewardSwitchStatus;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/QAdRewardSwitchStatus;", "mQAdRewardSwitchStatus", "Ljava/lang/Boolean;", "mForbidClick", "mForbidReport", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mRewardAdDataInfoMap", "c0", "isTryUnlockWhenClose", "Landroid/app/Activity;", "d0", "Landroid/app/Activity;", "mContext", "<init>", "(Landroid/app/Activity;)V", "e0", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardController implements f, RewardedAdListener, gw2.a, g {

    /* renamed from: C, reason: from kotlin metadata */
    private List<RewardAdReportInfo> mRewardAdReportInfos;

    /* renamed from: D, reason: from kotlin metadata */
    private String mRequestId;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.a mQAdRewardPlayHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private fx2.b mRewardAdLoadInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isAdClosed;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isCurrAdReachUnlockCondition;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isPlayCompleted;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isPopWindowShow;

    /* renamed from: K, reason: from kotlin metadata */
    private String mEncryData;

    /* renamed from: L, reason: from kotlin metadata */
    private RewardedAd mRewardedAd;

    /* renamed from: M, reason: from kotlin metadata */
    private a mQAdRewardLoadManager;

    /* renamed from: N, reason: from kotlin metadata */
    private RewardAdNewUnlockInfo mCurrAdUnlockInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private QAdRewardUpdateModel mAdRewardUpdateModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private String mErrorMsg;

    /* renamed from: R, reason: from kotlin metadata */
    private final com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a mQAdRewardDynamicVRHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mVrInitialized;

    /* renamed from: U, reason: from kotlin metadata */
    private RewardedAdListener.b mSwitchCallBack;

    /* renamed from: W, reason: from kotlin metadata */
    private String mCurrPenetrateInfo;

    /* renamed from: X, reason: from kotlin metadata */
    private int mOriginProcessNum;

    /* renamed from: Z, reason: from kotlin metadata */
    private Boolean mForbidClick;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Boolean mForbidReport;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a> mRewardAdDataInfoMap;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isTryUnlockWhenClose;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a mRewardListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Activity mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a> mRewardListenerRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f mVrHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.c mQAdRewardPlayerEventHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d mQAdRewardPlayerReport;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RewardAdInfo mRewardAdInfo;

    /* renamed from: T, reason: from kotlin metadata */
    private String mIsOverlay = "0";

    /* renamed from: V, reason: from kotlin metadata */
    private final String mSpecialId = String.valueOf(hashCode());

    /* renamed from: Y, reason: from kotlin metadata */
    private QAdRewardSwitchStatus mQAdRewardSwitchStatus = QAdRewardSwitchStatus.NORMAL;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController$b", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$c;", "", "isUnlock", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "Lcom/tencent/tvideo/protocol/pb/AdExtraInfo;", "c", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    public static final class b extends QAdRewardPlayModel.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f304199d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef objectRef, String str, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar) {
            super(str, aVar);
            this.f304199d = objectRef;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        public void b(boolean isUnlock, @Nullable RewardAdNewUnlockInfo unlockInfo) {
            super.b(isUnlock, unlockInfo);
            n.e("[RewardAd]QAdRewardController", "onUnlockLoadSuccess, isUnlock = " + isUnlock + ", unlockInfo = " + unlockInfo);
            com.tencent.ams.xsad.rewarded.b bVar = new com.tencent.ams.xsad.rewarded.b();
            bVar.f71729a = getMPenetrateInfo();
            QAdRewardController.this.F(isUnlock, unlockInfo, bVar);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        @Nullable
        public AdExtraInfo c() {
            Map<String, String> a16;
            String str;
            Map<String, String> a17;
            Map<String, String> hashMap;
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a mRewardAdDataInfo = getMRewardAdDataInfo();
            if (mRewardAdDataInfo != null && (a17 = mRewardAdDataInfo.a()) != null) {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = QAdRewardController.this.mVrHelper;
                if (fVar == null || (hashMap = fVar.A(QAdRewardController.this.v(), QAdRewardController.this.mRewardAdLoadInfo)) == null) {
                    hashMap = new HashMap<>();
                }
                a17.putAll(hashMap);
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a mRewardAdDataInfo2 = getMRewardAdDataInfo();
            if (mRewardAdDataInfo2 != null && (a16 = mRewardAdDataInfo2.a()) != null && (str = a16.get(QAdVrReportParams.ParamKey.MEDIA)) != null && Intrinsics.areEqual(str, QAdVrReportParams.MediaValue.PIAN_DUO_DUO)) {
                getMRewardAdDataInfo().a().put("is_overlay", QAdRewardController.this.mIsOverlay);
            }
            return super.c();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController$c", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$c;", "", "isUnlock", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "c", "Z", "hasRetryBefore", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    public static final class c extends QAdRewardPlayModel.c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean hasRetryBefore;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.xsad.rewarded.b f304202e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b f304203f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.tencent.ams.xsad.rewarded.b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar2, String str, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar) {
            super(str, aVar);
            this.f304202e = bVar;
            this.f304203f = bVar2;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        public void b(boolean isUnlock, @Nullable RewardAdNewUnlockInfo unlockInfo) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar;
            super.b(isUnlock, unlockInfo);
            n.e("[RewardAd]QAdRewardController", "onUnlockLoadSuccess, isUnlock = " + isUnlock + ", hasRetryBefore = " + this.hasRetryBefore + ", unlockInfo = " + unlockInfo);
            QAdRewardController.this.F(isUnlock, unlockInfo, this.f304202e);
            if (!isUnlock && !this.hasRetryBefore && (bVar = this.f304203f) != null) {
                hx2.a.f406569a.a(this, bVar);
                this.hasRetryBefore = true;
            }
        }
    }

    public QAdRewardController(@Nullable Activity activity) {
        this.mContext = activity;
        this.mAdRewardUpdateModel = new QAdRewardUpdateModel(Integer.valueOf(com.tencent.ams.xsad.rewarded.dynamic.b.d(this.mContext)));
        Boolean bool = Boolean.FALSE;
        this.mForbidClick = bool;
        this.mForbidReport = bool;
        this.mRewardAdDataInfoMap = new HashMap<>();
        com.tencent.ams.xsad.rewarded.c f16 = com.tencent.ams.xsad.rewarded.c.f();
        Intrinsics.checkNotNullExpressionValue(f16, "RewardedAdConfig.getInstance()");
        f16.l(QAdRewardPlayer.class);
        com.tencent.ams.xsad.rewarded.c f17 = com.tencent.ams.xsad.rewarded.c.f();
        Intrinsics.checkNotNullExpressionValue(f17, "RewardedAdConfig.getInstance()");
        f17.n(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.b());
        com.tencent.ams.xsad.rewarded.c f18 = com.tencent.ams.xsad.rewarded.c.f();
        Intrinsics.checkNotNullExpressionValue(f18, "RewardedAdConfig.getInstance()");
        f18.k(this.mAdRewardUpdateModel);
        com.tencent.ams.xsad.rewarded.c f19 = com.tencent.ams.xsad.rewarded.c.f();
        Intrinsics.checkNotNullExpressionValue(f19, "RewardedAdConfig.getInstance()");
        hx2.b bVar = hx2.b.f406570a;
        f19.m(bVar.a());
        com.tencent.ams.xsad.rewarded.dynamic.a e16 = com.tencent.ams.xsad.rewarded.dynamic.a.e();
        Intrinsics.checkNotNullExpressionValue(e16, "DKRewardedAdConfig.getInstance()");
        e16.i(bVar.c());
        com.tencent.ams.xsad.rewarded.dynamic.a e17 = com.tencent.ams.xsad.rewarded.dynamic.a.e();
        Intrinsics.checkNotNullExpressionValue(e17, "DKRewardedAdConfig.getInstance()");
        e17.h(ev2.f.a());
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a aVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a(this);
        this.mQAdRewardDynamicVRHelper = aVar;
        com.tencent.ams.xsad.rewarded.dynamic.a e18 = com.tencent.ams.xsad.rewarded.dynamic.a.e();
        Intrinsics.checkNotNullExpressionValue(e18, "DKRewardedAdConfig.getInstance()");
        e18.g(new gx2.a(aVar));
    }

    private final void A(ModuleEvent event) {
        String str;
        Map<String, String> map = event.f71811b;
        if (map != null) {
            str = map.get("eid");
        } else {
            str = null;
        }
        if (str != null) {
            o(str, this.isPlayCompleted, event.f71811b, true);
        }
    }

    private final void B(ModuleEvent event) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar;
        Map<String, String> a16;
        Map<String, String> map = event.f71811b;
        if (map != null && (aVar = this.mRewardAdDataInfoMap.get(this.mCurrPenetrateInfo)) != null && (a16 = aVar.a()) != null) {
            a16.putAll(map);
        }
    }

    private final void C(ModuleEvent event) {
        String str;
        Map<String, String> map = event.f71811b;
        if (map != null) {
            str = map.get("eid");
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            Map<? extends String, ? extends Object> map2 = event.f71811b;
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            hashMap.putAll(map2);
            hashMap.put("is_overlay", this.mIsOverlay);
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
            if (fVar != null) {
                fVar.q(r(), str2, this.isPopWindowShow, hashMap, this.isPlayCompleted);
            }
        }
    }

    private final void D(ModuleEvent event) {
        String str;
        Map<String, String> map = event.f71811b;
        if (map != null) {
            str = map.get("eid");
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            Map<? extends String, ? extends Object> map2 = event.f71811b;
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            hashMap.putAll(map2);
            hashMap.put("is_overlay", this.mIsOverlay);
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
            if (fVar != null) {
                fVar.o(r(), str2, this.isPopWindowShow, hashMap, this.isPlayCompleted);
            }
        }
    }

    private final void E() {
        Integer num;
        ex2.a mSwitchAdInnerInfo;
        ex2.a mSwitchAdInnerInfo2;
        int s16 = s();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleMultiAdUnlockResult, adUnlockedNum = ");
        sb5.append(s16);
        sb5.append(", total = ");
        fx2.b bVar = this.mRewardAdLoadInfo;
        String str = null;
        if (bVar != null && (mSwitchAdInnerInfo2 = bVar.getMSwitchAdInnerInfo()) != null) {
            num = Integer.valueOf(mSwitchAdInnerInfo2.getTotal());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", unlockMap size = ");
        sb5.append(this.mRewardAdDataInfoMap.size());
        n.e("[RewardAd]QAdRewardController", sb5.toString());
        fx2.b bVar2 = this.mRewardAdLoadInfo;
        if (bVar2 != null && (mSwitchAdInnerInfo = bVar2.getMSwitchAdInnerInfo()) != null && s16 == mSwitchAdInnerInfo.getTotal()) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
            if (x16 != null) {
                Object[] objArr = new Object[1];
                RewardAdNewUnlockInfo rewardAdNewUnlockInfo = this.mCurrAdUnlockInfo;
                if (rewardAdNewUnlockInfo != null) {
                    str = rewardAdNewUnlockInfo.unlock_tips;
                }
                objArr[0] = str;
                x16.a(11, objArr);
                return;
            }
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x17 = x();
        if (x17 != null) {
            x17.a(12, Integer.valueOf(s16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(boolean isUnlock, RewardAdNewUnlockInfo unlockInfo, com.tencent.ams.xsad.rewarded.b rewardItem) {
        n.e("[RewardAd]QAdRewardController", "onUnlockLoadSuccess isUnlock = " + isUnlock + ", penetrateInfo = " + rewardItem.f71729a + ", currentPenetrateInfo = " + this.mCurrPenetrateInfo);
        O(isUnlock, rewardItem);
        if (rewardItem.f71731c == 0 && !(!Intrinsics.areEqual(rewardItem.f71729a, this.mCurrPenetrateInfo))) {
            if (isUnlock) {
                b0(unlockInfo);
            }
            S();
            if (this.isTryUnlockWhenClose) {
                this.isTryUnlockWhenClose = false;
                E();
            }
        }
    }

    private final void H(RewardedAd rewardAd) {
        RewardAdInfo rewardAdInfo;
        String str;
        String str2;
        Object obj;
        List<RewardAdReportInfo> list;
        Object obj2;
        Map<Integer, AdAction> map;
        AdOrderItem adOrderItem;
        Map<String, String> map2;
        List<RewardAdInfo> list2;
        Object orNull;
        this.mRewardedAd = rewardAd;
        RewardedAdData g16 = rewardAd.g();
        Intrinsics.checkNotNullExpressionValue(g16, "rewardAd.adData");
        Object obj3 = g16.f71687a;
        AdAction adAction = null;
        if (!(obj3 instanceof RewardAdNewUpdateResponse)) {
            obj3 = null;
        }
        RewardAdNewUpdateResponse rewardAdNewUpdateResponse = (RewardAdNewUpdateResponse) obj3;
        if (rewardAdNewUpdateResponse != null && (list2 = rewardAdNewUpdateResponse.reward_info_list) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
            rewardAdInfo = (RewardAdInfo) orNull;
        } else {
            rewardAdInfo = null;
        }
        this.mRewardAdInfo = rewardAdInfo;
        if (rewardAdInfo == null || (map2 = rewardAdInfo.ad_extra_dict) == null || (str = map2.get("is_overlay")) == null) {
            str = "0";
        }
        this.mIsOverlay = str;
        d a16 = d.INSTANCE.a();
        String str3 = this.mSpecialId;
        RewardAdInfo rewardAdInfo2 = this.mRewardAdInfo;
        if (rewardAdInfo2 != null && (adOrderItem = rewardAdInfo2.order_item) != null) {
            str2 = adOrderItem.order_id;
        } else {
            str2 = null;
        }
        a16.c(str3, str2);
        Map<String, Object> map3 = g16.f71702p;
        if (map3 != null) {
            obj = map3.get(QAdRewardDefine$SecurityData.PENETRATE_INFO);
        } else {
            obj = null;
        }
        n.e("[RewardAd]QAdRewardController", "initData, penetrateInfo = " + obj);
        if (obj instanceof String) {
            String str4 = (String) obj;
            this.mCurrPenetrateInfo = str4;
            AbstractMap abstractMap = this.mRewardAdDataInfoMap;
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a();
            aVar.f(str4);
            Unit unit = Unit.INSTANCE;
            abstractMap.put(obj, aVar);
        }
        if (rewardAdNewUpdateResponse != null) {
            list = rewardAdNewUpdateResponse.report_info_list;
        } else {
            list = null;
        }
        this.mRewardAdReportInfos = list;
        Map<String, Object> map4 = g16.f71702p;
        if (map4 != null) {
            obj2 = map4.get(QAdRewardDefine$VideoParams.UNLOCK_INFO);
        } else {
            obj2 = null;
        }
        b0((RewardAdNewUnlockInfo) obj2);
        com.tencent.ams.xsad.rewarded.c f16 = com.tencent.ams.xsad.rewarded.c.f();
        Intrinsics.checkNotNullExpressionValue(f16, "RewardedAdConfig.getInstance()");
        f16.q(g16.f71700n);
        if (!Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            this.mVrHelper = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f(this, rewardAd);
        }
        G();
        RewardAdInfo rewardAdInfo3 = this.mRewardAdInfo;
        if (rewardAdInfo3 != null && (map = rewardAdInfo3.action_dict) != null) {
            adAction = map.get(Integer.valueOf(AdActionField.AD_ACTION_FIELD_ACTION_BTN.getValue()));
        }
        if (adAction != null) {
            R(adAction);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a, T] */
    private final void I() {
        RewardAdSceneType rewardAdSceneType;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar;
        RewardedAdData rewardedAdData;
        this.mQAdRewardPlayerReport = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d(this.mRewardAdInfo, hx2.c.f406571a.e(this.mRewardAdLoadInfo), this.mRewardedAd);
        this.mQAdRewardPlayerEventHandler = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.c();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.h.a().c(this.mRewardAdInfo, this.mQAdRewardPlayerEventHandler);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar = this.mQAdRewardPlayerReport;
        if (dVar != null) {
            dVar.c(f());
        }
        dx2.c cVar = dx2.c.f395159a;
        fx2.b bVar2 = this.mRewardAdLoadInfo;
        if (bVar2 != null) {
            rewardAdSceneType = bVar2.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        dx2.a a16 = cVar.a(rewardAdSceneType);
        if (a16 != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null) {
                rewardedAdData = rewardedAd.g();
            } else {
                rewardedAdData = null;
            }
            bVar = a16.a(rewardedAdData, this.mRewardAdLoadInfo);
        } else {
            bVar = null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String str = this.mCurrPenetrateInfo;
        if (str != null) {
            objectRef.element = this.mRewardAdDataInfoMap.get(str);
        }
        this.mQAdRewardPlayHandler = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.a(this.mRewardAdReportInfos, f(), bVar, new b(objectRef, this.mCurrPenetrateInfo, (com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a) objectRef.element));
    }

    private final synchronized void J() {
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        if (!this.mVrInitialized) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
            if (fVar != null) {
                fVar.l(null);
            }
            this.mVrInitialized = true;
        }
    }

    private final boolean K() {
        ex2.a mSwitchAdInnerInfo;
        int s16 = s();
        fx2.b bVar = this.mRewardAdLoadInfo;
        if (bVar != null && (mSwitchAdInnerInfo = bVar.getMSwitchAdInnerInfo()) != null && s16 == mSwitchAdInnerInfo.getTotal()) {
            return true;
        }
        return false;
    }

    private final boolean L() {
        return false;
    }

    private final void N(RewardedAdError errorInfo) {
        ex2.a mSwitchAdInnerInfo;
        fx2.b bVar = this.mRewardAdLoadInfo;
        if (bVar != null && (mSwitchAdInnerInfo = bVar.getMSwitchAdInnerInfo()) != null) {
            mSwitchAdInnerInfo.e(mSwitchAdInnerInfo.getProcess() - 1);
        }
        RewardedAdListener.a aVar = new RewardedAdListener.a();
        aVar.f71723a = errorInfo;
        RewardedAdListener.b bVar2 = this.mSwitchCallBack;
        if (bVar2 != null) {
            bVar2.a(aVar);
        }
    }

    private final void O(boolean isUnlock, com.tencent.ams.xsad.rewarded.b rewardItem) {
        RewardedAdController h16;
        com.tencent.ams.xsad.rewarded.a aVar = new com.tencent.ams.xsad.rewarded.a();
        aVar.f71726b = isUnlock;
        aVar.f71727c = rewardItem.f71731c;
        aVar.f71725a = rewardItem.f71729a;
        aVar.f71728d = rewardItem.f71732d;
        n.e("[RewardAd]QAdRewardController", "notifyUnlockResultToHippy, unlockMsg = " + i.s(aVar));
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            h16.d(aVar);
        }
    }

    private final void Q(boolean isRequestError) {
        int i3;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
        if (x16 != null) {
            if (K()) {
                x16.a(6, this.mCurrAdUnlockInfo);
            } else {
                if (isRequestError) {
                    i3 = 3;
                } else {
                    i3 = 7;
                }
                x16.a(i3, this.mErrorMsg);
            }
            d.INSTANCE.a().b(this.mSpecialId);
            m();
        }
    }

    private final void S() {
        n.e("[RewardAd]QAdRewardController", "notifyUnlockStatus, isCloseClick = " + this.isAdClosed);
        if (!this.isAdClosed) {
            return;
        }
        Q(false);
    }

    private final void T(int switchType) {
        boolean z16;
        String str;
        if (11 == switchType) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = QAdVrReport.ElementID.AD_POPUP_REWARD_BANNER;
        } else {
            str = QAdVrReport.ElementID.AD_REWARD_BANNER;
        }
        o(str, this.isPlayCompleted, null, z16);
    }

    private final void U() {
        RewardAdSceneType rewardAdSceneType;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar;
        Map<String, String> hashMap;
        n.e("[RewardAd]QAdRewardController", "retryUnlockSwitchAd");
        dx2.c cVar = dx2.c.f395159a;
        fx2.b bVar = this.mRewardAdLoadInfo;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar2 = null;
        RewardedAdData rewardedAdData = null;
        if (bVar != null) {
            rewardAdSceneType = bVar.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        dx2.a a16 = cVar.a(rewardAdSceneType);
        if (a16 != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null) {
                rewardedAdData = rewardedAd.g();
            }
            bVar2 = a16.a(rewardedAdData, this.mRewardAdLoadInfo);
        }
        String str = this.mCurrPenetrateInfo;
        if (str != null && (aVar = this.mRewardAdDataInfoMap.get(str)) != null) {
            Intrinsics.checkNotNullExpressionValue(aVar, "mRewardAdDataInfoMap[it] ?: return");
            if (aVar.getMIsReachUnlockCondition() && !aVar.getMIsRealUnlock() && bVar2 != null) {
                Map<String, String> a17 = aVar.a();
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
                if (fVar == null || (hashMap = fVar.A(v(), this.mRewardAdLoadInfo)) == null) {
                    hashMap = new HashMap<>();
                }
                a17.putAll(hashMap);
                hx2.a.f406569a.a(new QAdRewardPlayModel.c(this.mCurrPenetrateInfo, aVar), bVar2);
            }
        }
    }

    private final void V(com.tencent.ams.xsad.rewarded.b rewardItem) {
        boolean z16;
        RewardAdSceneType rewardAdSceneType;
        Map<String, String> a16;
        Map<String, String> hashMap;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar = this.mRewardAdDataInfoMap.get(rewardItem.f71729a);
        if (aVar != null) {
            z16 = aVar.getMIsRealUnlock();
        } else {
            z16 = false;
        }
        n.e("[RewardAd]QAdRewardController", "sendDirectUnlockRequest, penetrateInfo = " + rewardItem.f71729a + ", isRealUnlock = " + z16);
        if (z16 && rewardItem.f71731c == 0) {
            O(true, rewardItem);
            return;
        }
        fx2.b bVar = this.mRewardAdLoadInfo;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar2 = null;
        RewardedAdData rewardedAdData = null;
        if (bVar != null) {
            rewardAdSceneType = bVar.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        dx2.a a17 = dx2.c.f395159a.a(rewardAdSceneType);
        if (a17 != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null) {
                rewardedAdData = rewardedAd.g();
            }
            bVar2 = a17.a(rewardedAdData, this.mRewardAdLoadInfo);
        }
        if (bVar2 != null) {
            bVar2.k(3L);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar2 = this.mRewardAdDataInfoMap.get(rewardItem.f71729a);
        if (aVar2 != null && (a16 = aVar2.a()) != null) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
            if (fVar == null || (hashMap = fVar.A(v(), this.mRewardAdLoadInfo)) == null) {
                hashMap = new HashMap<>();
            }
            a16.putAll(hashMap);
        }
        String str = rewardItem.f71729a;
        c cVar = new c(rewardItem, bVar2, str, this.mRewardAdDataInfoMap.get(str));
        if (bVar2 != null) {
            hx2.a.f406569a.a(cVar, bVar2);
        }
    }

    private final void W(RewardedAd rewardAd) {
        a aVar;
        HashMap<String, String> hashMap;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a aVar2 = this.mRewardListener;
        if (aVar2 != null) {
            aVar2.a(2, w(rewardAd));
        }
        H(rewardAd);
        I();
        Activity activity = this.mContext;
        if (activity != null && (aVar = this.mQAdRewardLoadManager) != null) {
            float f16 = rewardAd.g().f71693g / 1000.0f;
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
            if (fVar != null) {
                hashMap = fVar.z(this.mRewardAdLoadInfo);
            } else {
                hashMap = null;
            }
            aVar.j(activity, this, f16, hashMap, this.mRewardAdInfo, v());
        }
    }

    private final void X(int switchType) {
        n.e("[RewardAd]QAdRewardController", "switchRewardAd");
        this.mVrInitialized = false;
        this.isCurrAdReachUnlockCondition = false;
        this.isPlayCompleted = false;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
        if (x16 != null) {
            x16.a(1, new Object[0]);
        }
        this.mRequestId = pw2.b.a();
        a0(switchType);
        this.mAdRewardUpdateModel.r(this.mRewardAdLoadInfo);
        a aVar = this.mQAdRewardLoadManager;
        if (aVar != null) {
            aVar.g(this, this.mRequestId, false);
        }
        this.mEncryData = nv2.a.a(this.mRequestId);
        Z();
    }

    private final void Z() {
        QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.QAdRewardController$updateAdVideoCacheFiles$1
            @Override // java.lang.Runnable
            public final void run() {
                hx2.b bVar = hx2.b.f406570a;
                ku2.b.a(bVar.d(), bVar.e());
            }
        });
    }

    private final void a0(int switchType) {
        RewardAdSceneType rewardAdSceneType;
        ex2.a mSwitchAdInnerInfo;
        a.Companion companion = ex2.a.INSTANCE;
        fx2.b bVar = this.mRewardAdLoadInfo;
        if (bVar != null) {
            rewardAdSceneType = bVar.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        if (companion.a(rewardAdSceneType)) {
            fx2.b bVar2 = this.mRewardAdLoadInfo;
            if (bVar2 != null && (mSwitchAdInnerInfo = bVar2.getMSwitchAdInnerInfo()) != null) {
                mSwitchAdInnerInfo.e(mSwitchAdInnerInfo.getProcess() + 1);
                return;
            }
            return;
        }
        fx2.b bVar3 = this.mRewardAdLoadInfo;
        if (bVar3 != null) {
            bVar3.i(RewardAdSceneType.REWARD_AD_SCENE_TYPE_SWITCH);
        }
        fx2.b bVar4 = this.mRewardAdLoadInfo;
        if (bVar4 != null) {
            bVar4.h(n(switchType));
        }
    }

    private final synchronized void b0(RewardAdNewUnlockInfo unlockInfo) {
        if (unlockInfo != null) {
            boolean z16 = true;
            if (unlockInfo.lockStatus != 1) {
                z16 = false;
            }
            n.e("[RewardAd]QAdRewardController", "updateUnlockInfo, specialId = " + this.mSpecialId + " , unlocked = " + z16);
            if (z16) {
                d.INSTANCE.a().d(this.mSpecialId);
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
            if (x16 != null) {
                x16.c(unlockInfo, this.mSpecialId);
            }
            this.mCurrAdUnlockInfo = unlockInfo;
        }
    }

    private final RewardSwitchType n(int switchType) {
        RewardSwitchType fromValue = RewardSwitchType.fromValue(switchType);
        if (fromValue == null) {
            return RewardSwitchType.REWARD_SWITCH_TYPE_UNKNOWN;
        }
        return fromValue;
    }

    private final void o(String eid, boolean isMuskArea, Map<String, ? extends Object> extraParams, boolean isPopUpWindow) {
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            fVar.t(r(), eid, extraParams, isMuskArea, isPopUpWindow);
        }
    }

    private final boolean p(int clickField) {
        if (Intrinsics.areEqual(this.mForbidClick, Boolean.TRUE)) {
            return false;
        }
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            fVar.s(r(), clickField);
            return true;
        }
        return true;
    }

    private final boolean q() {
        String str;
        RewardedAdData g16;
        Map<String, String> map;
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && (g16 = rewardedAd.g()) != null && (map = g16.f71704r) != null) {
            str = map.get("enableFullScreenClickDownload");
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "1")) {
            return false;
        }
        t();
        RewardedAd rewardedAd2 = this.mRewardedAd;
        if (rewardedAd2 != null) {
            rewardedAd2.g();
        }
        return false;
    }

    private final View r() {
        RewardedAdController h16;
        Activity a16 = ev2.a.a();
        View view = null;
        if (a16 == null) {
            return null;
        }
        View view2 = new View(a16);
        e eVar = e.f304313a;
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            view = h16.getView();
        }
        eVar.e(view2, view);
        return view2;
    }

    private final int s() {
        int i3 = this.mOriginProcessNum;
        Iterator<Map.Entry<String, com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a>> it = this.mRewardAdDataInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a value = it.next().getValue();
            n.e("[RewardAd]QAdRewardController", "getAdUnlockedNum, dataInfo = " + value + ", isRealUnlock = " + value.getMIsRealUnlock());
            if (value.getMIsRealUnlock()) {
                i3++;
            }
        }
        return i3;
    }

    private final long t() {
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            return rewardedAd.j();
        }
        return 0L;
    }

    private final String u() {
        Integer num;
        RewardAdSceneType mSceneType;
        if (L()) {
            fx2.b bVar = this.mRewardAdLoadInfo;
            if (bVar != null && (mSceneType = bVar.getMSceneType()) != null) {
                num = Integer.valueOf(mSceneType.getValue());
            } else {
                num = null;
            }
            return String.valueOf(num);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v() {
        RewardVrReportData mVrReportData;
        Map<String, Object> b16;
        Object obj;
        String obj2;
        fx2.b bVar = this.mRewardAdLoadInfo;
        if (bVar == null || (mVrReportData = bVar.getMVrReportData()) == null || (b16 = mVrReportData.b()) == null || (obj = b16.get("eid")) == null || (obj2 = obj.toString()) == null) {
            return QAdVrReport.ElementID.AD_WATCH;
        }
        return obj2;
    }

    private final RewardAdInfo w(RewardedAd rewardedAd) {
        Object obj;
        List<RewardAdInfo> list;
        Object orNull;
        RewardedAdData g16 = rewardedAd.g();
        if (g16 != null) {
            obj = g16.f71687a;
        } else {
            obj = null;
        }
        if (!(obj instanceof RewardAdNewUpdateResponse)) {
            obj = null;
        }
        RewardAdNewUpdateResponse rewardAdNewUpdateResponse = (RewardAdNewUpdateResponse) obj;
        if (rewardAdNewUpdateResponse != null && (list = rewardAdNewUpdateResponse.reward_info_list) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            return (RewardAdInfo) orNull;
        }
        return null;
    }

    private final com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a aVar = this.mRewardListener;
        if (aVar != null) {
            return aVar;
        }
        WeakReference<com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a> weakReference = this.mRewardListenerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final int y() {
        RewardedAdData g16;
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && (g16 = rewardedAd.g()) != null) {
            return g16.f71690d;
        }
        return 0;
    }

    private final void z(ModuleEvent event) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
        if (x16 != null) {
            x16.a(15, new Object[0]);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public /* synthetic */ void A1(com.tencent.ams.xsad.rewarded.view.a aVar, JSONObject jSONObject) {
        com.tencent.ams.xsad.rewarded.e.b(this, aVar, jSONObject);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void Ab(@Nullable RewardedAdListener.ClickInfo clickInfo) {
        int i3;
        int i16;
        ew2.a aVar;
        n.a("[RewardAd]QAdRewardController", "onAdClicked, clickInfo: " + clickInfo);
        int i17 = 0;
        if (clickInfo != null) {
            i3 = clickInfo.f71716a;
        } else {
            i3 = 0;
        }
        if (!p(i3)) {
            return;
        }
        hx2.c cVar = hx2.c.f406571a;
        if (clickInfo != null) {
            i16 = clickInfo.f71716a;
        } else {
            i16 = 0;
        }
        if (cVar.g(i16)) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            if (clickInfo != null) {
                i17 = clickInfo.f71716a;
            }
            aVar = fVar.e(i17);
        } else {
            aVar = null;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b c16 = dx2.g.f395163a.c(ev2.a.a(), this.mRewardAdInfo, clickInfo, aVar, this.mRequestId, q());
        n.e("[RewardAd]QAdRewardController", "onAdClicked downloadState=" + c16.z());
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.a.a(c16);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public /* synthetic */ void D2() {
        com.tencent.ams.xsad.rewarded.e.a(this);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void J1(boolean isMute) {
        n.a("[RewardAd]QAdRewardController", "onUserSetMute, isMute: " + isMute);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("status", Integer.valueOf(isMute ? 1 : 0));
        o(QAdVrReport.ElementID.AD_SOUND, this.isPlayCompleted, linkedHashMap, false);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d.INSTANCE.a(isMute);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void K6(@Nullable ModuleEvent event) {
        if (event == null) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onModuleEvent, event = " + i.s(event));
        J();
        int i3 = event.f71810a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            z(event);
                            return;
                        }
                        return;
                    }
                    B(event);
                    return;
                }
                D(event);
                return;
            }
            C(event);
            return;
        }
        A(event);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void L7(@Nullable RewardedAdError errorInfo) {
        Integer num;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onAdShowFailed, errorCode = ");
        if (errorInfo != null) {
            num = Integer.valueOf(errorInfo.a());
        } else {
            num = null;
        }
        sb5.append(num);
        n.e("[RewardAd]QAdRewardController", sb5.toString());
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.FALSE) && errorInfo != null && errorInfo.a() == 205 && (dVar = this.mQAdRewardPlayerReport) != null) {
            dVar.f(y(), errorInfo.c());
        }
    }

    public void M(@NotNull fx2.b adLoadInfo, @NotNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a listener) {
        RewardAdSceneType rewardAdSceneType;
        fx2.b bVar;
        Intrinsics.checkNotNullParameter(adLoadInfo, "adLoadInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        n.e("[RewardAd]QAdRewardController", "loadRewardAd");
        this.mRewardListener = listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
        int i3 = 0;
        if (x16 != null) {
            x16.a(1, new Object[0]);
        }
        this.mRequestId = pw2.b.a();
        this.mRewardAdLoadInfo = adLoadInfo;
        RewardAdSceneType rewardAdSceneType2 = null;
        if (adLoadInfo != null) {
            rewardAdSceneType = adLoadInfo.getMRewardAdOriginSceneType();
        } else {
            rewardAdSceneType = null;
        }
        if (rewardAdSceneType == null && (bVar = this.mRewardAdLoadInfo) != null) {
            if (bVar != null) {
                rewardAdSceneType2 = bVar.getMSceneType();
            }
            bVar.g(rewardAdSceneType2);
        }
        ex2.a mSwitchAdInnerInfo = adLoadInfo.getMSwitchAdInnerInfo();
        if (mSwitchAdInnerInfo != null) {
            i3 = mSwitchAdInnerInfo.getProcess();
        }
        this.mOriginProcessNum = i3;
        this.mAdRewardUpdateModel.r(this.mRewardAdLoadInfo);
        a aVar = new a();
        this.mQAdRewardLoadManager = aVar;
        aVar.g(this, this.mRequestId, true);
        this.mEncryData = nv2.a.a(this.mRequestId);
        Z();
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void Od(int position) {
        if (position == 0) {
            this.mQAdRewardSwitchStatus = QAdRewardSwitchStatus.NORMAL;
        }
        if (this.mQAdRewardSwitchStatus == QAdRewardSwitchStatus.SWITCHING) {
            n.e("[RewardAd]QAdRewardController", "onAdTick, switching, ignore tick");
            return;
        }
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.a aVar = this.mQAdRewardPlayHandler;
        if (aVar != null) {
            aVar.i(position);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void S7(@Nullable com.tencent.ams.xsad.rewarded.view.a dialog) {
        View view;
        View view2;
        Window window;
        View view3;
        Window window2;
        RewardedAdController h16;
        RewardedAdController h17;
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onAdCloseDialogShowed");
        this.isPopWindowShow = true;
        J();
        e eVar = e.f304313a;
        RewardedAd rewardedAd = this.mRewardedAd;
        View view4 = null;
        if (rewardedAd != null && (h17 = rewardedAd.h()) != null) {
            view = h17.getView();
        } else {
            view = null;
        }
        eVar.d(dialog, view);
        RewardedAd rewardedAd2 = this.mRewardedAd;
        if (rewardedAd2 != null && (h16 = rewardedAd2.h()) != null) {
            view2 = h16.getView();
        } else {
            view2 = null;
        }
        eVar.d(dialog, view2);
        HashMap<String, Object> c16 = eVar.c(QAdExtraParamsType.POP_UP, Boolean.valueOf(this.isCurrAdReachUnlockCondition));
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            if (dialog != null && (window2 = dialog.getWindow()) != null) {
                view3 = window2.getDecorView();
            } else {
                view3 = null;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f.r(fVar, view3, QAdVrReport.ElementID.AD_POPUP, true, c16, false, 16, null);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar2 = this.mVrHelper;
        if (fVar2 != null) {
            if (dialog != null && (window = dialog.getWindow()) != null) {
                view4 = window.getDecorView();
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f.p(fVar2, view4, QAdVrReport.ElementID.AD_POPUP, true, c16, false, 16, null);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void a(@Nullable RewardedAd rewardAd) {
        n.a("[RewardAd]QAdRewardController", "onAdStartLoad");
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void a5() {
        n.a("[RewardAd]QAdRewardController", "onAdCloseClicked");
        o("close", this.isPlayCompleted, null, false);
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void b(@Nullable RewardedAd rewardAd, @Nullable RewardedAdError errorInfo) {
        String u16;
        n.e("[RewardAd]QAdRewardController", "onAdFailedToLoad, errorInfo = " + errorInfo);
        if (errorInfo != null && 1005 == errorInfo.a()) {
            u16 = errorInfo.b();
        } else {
            u16 = u();
        }
        this.mErrorMsg = u16;
        Q(true);
        N(errorInfo);
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void c(@Nullable RewardedAd rewardAd) {
        RewardedAdData rewardedAdData;
        ex2.a mSwitchAdInnerInfo;
        n.e("[RewardAd]QAdRewardController", "onAdLoaded");
        if (rewardAd != null) {
            rewardedAdData = rewardAd.g();
        } else {
            rewardedAdData = null;
        }
        if (rewardedAdData == null) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
            if (x16 != null) {
                x16.a(3, new Object[0]);
            }
            d.INSTANCE.a().b(this.mSpecialId);
            m();
            fx2.b bVar = this.mRewardAdLoadInfo;
            if (bVar != null && (mSwitchAdInnerInfo = bVar.getMSwitchAdInnerInfo()) != null) {
                mSwitchAdInnerInfo.e(mSwitchAdInnerInfo.getProcess() - 1);
                return;
            }
            return;
        }
        this.mRewardedAd = rewardAd;
        W(rewardAd);
    }

    @Override // gw2.a
    @Nullable
    public View e() {
        RewardedAdController h16;
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            return h16.getView();
        }
        return null;
    }

    @Override // gw2.a
    @Nullable
    public AdOrderItem f() {
        return hx2.c.f406571a.a(this.mRewardAdInfo);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.g
    @Nullable
    /* renamed from: g, reason: from getter */
    public RewardAdInfo getMRewardAdInfo() {
        return this.mRewardAdInfo;
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void gb(@Nullable com.tencent.ams.xsad.rewarded.view.a dialog, boolean isExistClick) {
        String str;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16;
        n.a("[RewardAd]QAdRewardController", "onAdCloseDialogClicked, isExistClick: " + isExistClick);
        if (isExistClick && (x16 = x()) != null) {
            x16.a(16, new Object[0]);
        }
        if (isExistClick) {
            str = QAdVrReport.ElementID.AD_POPUP_CLOSE;
        } else {
            str = QAdVrReport.ElementID.AD_POPUP_CONTINUE;
        }
        o(str, this.isPlayCompleted, e.f304313a.c(QAdExtraParamsType.POP_UP, Boolean.valueOf(this.isCurrAdReachUnlockCondition)), true);
        if (!isExistClick) {
            this.isPopWindowShow = false;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.g
    @Nullable
    /* renamed from: getRequestId, reason: from getter */
    public String getMRequestId() {
        return this.mRequestId;
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void jb(long playedDuration) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar;
        n.e("[RewardAd]QAdRewardController", "onAdClosed, duration = " + playedDuration);
        J();
        if (playedDuration < y() && (!Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) && (dVar = this.mQAdRewardPlayerReport) != null) {
            dVar.g(playedDuration);
        }
        this.isAdClosed = true;
        Y();
        if (!this.isCurrAdReachUnlockCondition) {
            n.e("[RewardAd]QAdRewardController", "onAdClosed, should not send unlock request");
            P();
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
            if (x16 != null) {
                x16.a(8, new Object[0]);
            }
            m();
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x17 = x();
        if (x17 != null) {
            if (x17.b()) {
                P();
                x17.a(9, Long.valueOf(playedDuration));
                x17.a(8, new Object[0]);
                m();
                return;
            }
            if (K()) {
                d.INSTANCE.a().b(this.mSpecialId);
                x17.a(6, this.mCurrAdUnlockInfo);
                x17.a(8, new Object[0]);
                E();
                m();
                return;
            }
            P();
            x17.a(5, new Object[0]);
            x17.a(8, new Object[0]);
        }
        this.isTryUnlockWhenClose = true;
        RewardAdReportInfo rewardAdReportInfo = new RewardAdReportInfo(playedDuration, RewardAdReportType.REWARD_AD_REPORT_TYPE_UNLOCK);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.a aVar = this.mQAdRewardPlayHandler;
        if (aVar != null) {
            aVar.n(rewardAdReportInfo);
        }
        m();
    }

    public final void m() {
        RewardAdSceneType rewardAdSceneType;
        a.Companion companion = ex2.a.INSTANCE;
        fx2.b bVar = this.mRewardAdLoadInfo;
        if (bVar != null) {
            rewardAdSceneType = bVar.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        if (companion.a(rewardAdSceneType)) {
            n.e("[RewardAd]QAdRewardController", "SwitchAd, can not close resources");
            return;
        }
        if (!L()) {
            this.mRewardListener = null;
        }
        this.mQAdRewardLoadManager = null;
        this.mContext = null;
        this.mSwitchCallBack = null;
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void m6(int switchType, @Nullable RewardedAdListener.b switchCallBack) {
        T(switchType);
        U();
        this.mSwitchCallBack = switchCallBack;
        this.mQAdRewardSwitchStatus = QAdRewardSwitchStatus.SWITCHING;
        l();
        X(switchType);
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayComplete() {
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onAdPlayComplete");
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar = this.mQAdRewardPlayerReport;
        if (dVar != null) {
            dVar.d(t());
        }
        this.isPlayCompleted = true;
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayPause() {
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onAdPlayPause");
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar = this.mQAdRewardPlayerReport;
        if (dVar != null) {
            dVar.h(t());
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayResume() {
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onAdPlayResume");
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar = this.mQAdRewardPlayerReport;
        if (dVar != null) {
            dVar.i(t());
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onAdPlayStart() {
        View view;
        RewardedAdController h16;
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", "onAdPlayStart");
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.b.f304304a.a(f(), 1000, 0, this.mEncryData, 1);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d dVar = this.mQAdRewardPlayerReport;
        if (dVar != null) {
            dVar.j();
        }
        HashMap<String, Object> c16 = e.f304313a.c(QAdExtraParamsType.MULTI_AD, this.mRewardAdLoadInfo, Integer.valueOf(this.mOriginProcessNum));
        c16.put("is_overlay", this.mIsOverlay);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
                view = h16.getView();
            } else {
                view = null;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f.r(fVar, view, QAdVrReport.ElementID.WHOLE_AD, false, c16, false, 16, null);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void onOriginalExposure() {
        View view;
        RewardedAdController h16;
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        n.a("[RewardAd]QAdRewardController", RewardAdMethodHandler.RewardAdEvent.ON_ORIGINAL_EXPOSURE);
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.b.f304304a.a(f(), 1000, 0, this.mEncryData, 1);
        HashMap<String, Object> c16 = e.f304313a.c(QAdExtraParamsType.MULTI_AD, this.mRewardAdLoadInfo, Integer.valueOf(this.mOriginProcessNum));
        c16.put("is_overlay", this.mIsOverlay);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
                view = h16.getView();
            } else {
                view = null;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f.r(fVar, view, QAdVrReport.ElementID.WHOLE_AD, false, c16, false, 16, null);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void we() {
        View view;
        RewardedAdController h16;
        n.a("[RewardAd]QAdRewardController", "onAdShowed");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a x16 = x();
        if (x16 != null) {
            x16.a(4, new Object[0]);
        }
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        J();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.b.f304304a.a(f(), 1001, 0, this.mEncryData, 0);
        HashMap<String, Object> c16 = e.f304313a.c(QAdExtraParamsType.MULTI_AD, this.mRewardAdLoadInfo, Integer.valueOf(this.mOriginProcessNum));
        c16.put("is_overlay", this.mIsOverlay);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            RewardedAd rewardedAd = this.mRewardedAd;
            if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
                view = h16.getView();
            } else {
                view = null;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f.p(fVar, view, QAdVrReport.ElementID.WHOLE_AD, false, c16, false, 16, null);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
    public void yg(@NotNull com.tencent.ams.xsad.rewarded.b rewardItem) {
        Map<String, Object> map;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar;
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        n.e("[RewardAd]QAdRewardController", "onUserEarnedReward, mCurrPenetrateInfo = " + this.mCurrPenetrateInfo);
        J();
        this.isCurrAdReachUnlockCondition = true;
        String str = this.mCurrPenetrateInfo;
        if (str != null && (aVar = this.mRewardAdDataInfoMap.get(str)) != null) {
            aVar.d(true);
        }
        if (rewardItem.f71730b) {
            if (TextUtils.isEmpty(rewardItem.f71729a)) {
                rewardItem.f71729a = this.mCurrPenetrateInfo;
            }
            V(rewardItem);
        }
        if (Intrinsics.areEqual(this.mForbidReport, Boolean.TRUE)) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.f fVar = this.mVrHelper;
        if (fVar != null) {
            map = fVar.u();
        } else {
            map = null;
        }
        w.i(QAdVrReport.ReportEvent.AD_REWARD_PLAY_CROSS_THRESHOLD, map);
    }

    private final void G() {
    }

    private final void P() {
    }

    private final void Y() {
    }

    private final void l() {
    }

    private final void R(AdAction adAction) {
    }
}
