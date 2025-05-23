package com.tencent.mobileqq.vas.kuikly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.api.IUnitedData;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.kuikly.ProxyFragment;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.Card;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.EcommerceImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.FileImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.FriendsImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.LoginImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.Reader;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.RechargeImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.SecretImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.VasAudioImpl;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.ab;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.ac;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.ah;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.aj;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.ak;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.al;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.am;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.an;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.ao;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.as;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.at;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.av;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.u;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.x;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.z;
import com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QzoneIPCModule;
import e23.MonthlyPayData;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u0002:\u0002z{B\u0007\u00a2\u0006\u0004\bx\u0010yJI\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J?\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0015\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002JH\u0010\u001a\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001cH\u0096\u0001J>\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J\u0011\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0096\u0001J@\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u00112+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001JH\u0010#\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J\t\u0010$\u001a\u00020\nH\u0096\u0001J\u0011\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010/\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u00100\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0003H\u0096\u0001J\u0011\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0003H\u0096\u0001J\u0011\u00103\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u00104\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u00105\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u00106\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u00107\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u00108\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J>\u00109\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J>\u0010:\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J\u0011\u0010;\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010<\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010=\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010@\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010A\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010B\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003H\u0096\u0001J\t\u0010C\u001a\u00020\nH\u0096\u0001J@\u0010D\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J@\u0010E\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J@\u0010F\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J@\u0010G\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001J@\u0010H\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0096\u0001JI\u0010I\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016J\b\u0010J\u001a\u00020\nH\u0016R\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010LR;\u0010O\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010NR\u0014\u0010S\u001a\u00020P8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010w\u001a\u00020t8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bu\u0010v\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasKuiklyModule;", "Li01/e;", "", "", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", ExifInterface.LATITUDE_SOUTH, "", "invokerId", "M", "Landroid/app/Activity;", "I", "uin", "V", "X", "data", "c0", "kuiklyActivity", "jsonString", "U", "D", "", "P", "url", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "w", "g0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "path", "o", ark.ARKMETADATA_JSON, "t", "token", "v", HippyTKDListViewAdapter.X, "", "K", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "T", "bookId", "W", "Y", "Z", "a0", "e0", "f0", "h0", "i0", "j0", "k0", "l0", "n0", "isDisplay", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "O", "b0", "m0", "p", "L", "g", "i", "j", "d0", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/al;", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/al;", "tianxuanPayImpl", "Lkotlin/jvm/functions/Function1;", "payCallBack", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", "reader", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/d;", "y", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/d;", "file", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/s;", "B", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/s;", "gxh", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ab;", "G", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ab;", "recharge", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ah;", "H", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ah;", "secret", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/w;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/w;", "login", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/f;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/f;", "friends", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/am;", "J", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/am;", "updateSystem", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "E", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "photo", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Card;", "u", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "()V", "a", "VasKuiklyResultRecevicer", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyModule extends i01.e {

    @NotNull
    private static final byte[] S = new byte[0];

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private al tianxuanPayImpl;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> payCallBack;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ EcommerceImpl f309670d = new EcommerceImpl();

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ ak f309671e = new ak();

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.vas.kuikly.moduleimpl.c f309672f = new com.tencent.mobileqq.vas.kuikly.moduleimpl.c();

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ at f309673h = new at();

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ FileImpl f309674i = new FileImpl();

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ VasAudioImpl f309675m = new VasAudioImpl();
    private final /* synthetic */ ao C = new ao();
    private final /* synthetic */ av D = new av();
    private final /* synthetic */ com.tencent.mobileqq.vas.kuikly.moduleimpl.a E = new com.tencent.mobileqq.vas.kuikly.moduleimpl.a();
    private final /* synthetic */ com.tencent.mobileqq.vas.kuikly.moduleimpl.t F = new com.tencent.mobileqq.vas.kuikly.moduleimpl.t();
    private final /* synthetic */ RechargeImpl G = new RechargeImpl();
    private final /* synthetic */ SecretImpl H = new SecretImpl();
    private final /* synthetic */ LoginImpl I = new LoginImpl();
    private final /* synthetic */ FriendsImpl J = new FriendsImpl();
    private final /* synthetic */ com.tencent.mobileqq.vas.kuikly.moduleimpl.y K = new com.tencent.mobileqq.vas.kuikly.moduleimpl.y();
    private final /* synthetic */ an L = new an();
    private final /* synthetic */ z M = new z();
    private final /* synthetic */ com.tencent.mobileqq.vas.kuikly.moduleimpl.b N = new com.tencent.mobileqq.vas.kuikly.moduleimpl.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasKuiklyModule$VasKuiklyResultRecevicer;", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/kuikly/VasKuiklyModule;", "d", "Ljava/lang/ref/WeakReference;", "moduleRef", "Landroid/os/Handler;", "handler", "<init>", "(Ljava/lang/ref/WeakReference;Landroid/os/Handler;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class VasKuiklyResultRecevicer extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<VasKuiklyModule> moduleRef;

        public VasKuiklyResultRecevicer(@Nullable WeakReference<VasKuiklyModule> weakReference, @Nullable Handler handler) {
            super(handler);
            this.moduleRef = weakReference;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            Function1 function1;
            VasKuiklyModule vasKuiklyModule;
            super.onReceiveResult(resultCode, resultData);
            if (QLog.isColorLevel()) {
                QLog.i("VasKuiklyModule", 2, "VasHippyResultReceiver receive = " + this);
                QLog.i("VasKuiklyModule", 2, "resultCode = " + resultCode + " resultData = " + resultData);
            }
            WeakReference<VasKuiklyModule> weakReference = this.moduleRef;
            if (weakReference != null && (vasKuiklyModule = weakReference.get()) != null) {
                function1 = vasKuiklyModule.payCallBack;
            } else {
                function1 = null;
            }
            if (function1 != null && resultData != null) {
                if (resultCode == 7 || resultCode == 14) {
                    String string = resultData.getString("callbackSn");
                    String string2 = resultData.getString("result");
                    if (!TextUtils.isEmpty(string)) {
                        int hashCode = function1.hashCode();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(hashCode);
                        if (Intrinsics.areEqual(string, sb5.toString())) {
                            function1.invoke(string2);
                            return;
                        }
                    }
                    QLog.e("VasKuiklyModule", 1, "callbackSn wrong, callbackSn= " + string);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, -1);
                    jSONObject.put("resultMsg", "callbackSn wrong");
                    function1.invoke(jSONObject.toString());
                    return;
                }
                return;
            }
            QLog.e("VasKuiklyModule", 1, "handle result error, callback = " + function1 + " resultData = " + resultData);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309677a;

        static {
            int[] iArr = new int[ABTest.values().length];
            try {
                iArr[ABTest.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ABTest.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f309677a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasKuiklyModule$c", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.vip.api.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f309678a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f309679b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309680c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasKuiklyModule$c$a", "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "", "type", "", NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements PayTypeSelectedDialog.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f309681a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f309682b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f309683c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f309684d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f309685e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f309686f;

            a(String str, Activity activity, String str2, int i3, String str3, String str4) {
                this.f309681a = str;
                this.f309682b = activity;
                this.f309683c = str2;
                this.f309684d = i3;
                this.f309685e = str3;
                this.f309686f = str4;
            }

            @Override // com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog.b
            public void onClick(int type) {
                String str;
                QLog.i("VasKuiklyModule", 1, "user selected pay type: " + type);
                JSONObject jSONObject = new JSONObject(this.f309681a);
                String offerId = jSONObject.optString("app_id");
                String optString = jSONObject.optString("productid");
                String serviceType = jSONObject.optString("serviceType");
                int optInt = jSONObject.optInt("month");
                String reportData = jSONObject.optString("reportData");
                Activity topActivity = this.f309682b;
                Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
                e23.c cVar = new e23.c(topActivity);
                Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                Intrinsics.checkNotNullExpressionValue(serviceType, "serviceType");
                String userId = this.f309683c;
                Intrinsics.checkNotNullExpressionValue(userId, "userId");
                int i3 = this.f309684d;
                JSONObject jSONObject2 = new JSONObject();
                String str2 = this.f309686f;
                jSONObject2.put("apf", "2");
                jSONObject2.put("preorder_bill", str2);
                Unit unit = Unit.INSTANCE;
                String encode = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(JSONObject().appl\u2026   }.toString(), \"utf-8\")");
                String str3 = this.f309685e;
                String str4 = this.f309686f;
                if (optInt != 1) {
                    str = optInt + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
                cVar.a(new e23.a(offerId, serviceType, serviceType, userId, i3, encode, null, null, null, null, null, null, null, null, null, null, optString, str3, str4, str, null, reportData, 1114048, null), type);
            }
        }

        c(String str, int i3, Function1<Object, Unit> function1) {
            this.f309678a = str;
            this.f309679b = i3;
            this.f309680c = function1;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            Function1<Object, Unit> function1 = this.f309680c;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", code);
                jSONObject.put("msg", "");
                function1.invoke(jSONObject.toString());
            }
        }

        @Override // com.tencent.mobileqq.vip.api.h
        public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
            Intrinsics.checkNotNullParameter(vipMa, "vipMa");
            Intrinsics.checkNotNullParameter(billno, "billno");
            Intrinsics.checkNotNullParameter(payStr, "payStr");
            Activity topActivity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
            PayTypeSelectedDialog payTypeSelectedDialog = new PayTypeSelectedDialog(topActivity);
            payTypeSelectedDialog.O(new a(payStr, topActivity, this.f309678a, this.f309679b, vipMa, billno));
            payTypeSelectedDialog.show();
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Function1<Object, Unit> function1 = this.f309680c;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", code);
                jSONObject.put("msg", msg2);
                function1.invoke(jSONObject.toString());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasKuiklyModule$d", "Lcom/tencent/mobileqq/vip/api/k;", "", "code", "", "a", "", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.mobileqq.vip.api.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f309687a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super Integer, ? super String, Unit> function2) {
            this.f309687a = function2;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            this.f309687a.invoke(Integer.valueOf(code), "");
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f309687a.invoke(Integer.valueOf(code), msg2);
        }
    }

    private final Activity I() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing()) {
            return topActivity;
        }
        QLog.e("VasKuiklyModule", 1, topActivity + " is null or finishing");
        return null;
    }

    private final void M(String params, final Function1<Object, Unit> callback, int invokerId) {
        Integer num;
        if (TextUtils.isEmpty(params)) {
            QLog.e("VasKuiklyModule", 1, "invokeKuiklyPay params is empty!!");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("payJsonString");
        long currentTimeMillis = System.currentTimeMillis();
        String appInfoFromHistory = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(null);
        Bundle bundle = new Bundle();
        if (callback != null) {
            num = Integer.valueOf(callback.hashCode());
        } else {
            num = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(num);
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, sb5.toString());
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, optString2);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, currentTimeMillis);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, appInfoFromHistory);
        bundle.putString("payparmas_h5_url", optString);
        this.payCallBack = callback;
        Activity activity = getActivity();
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        final Bundle newPay = PayBridgeActivity.newPay((AppInterface) peekAppRuntime, activity, new VasKuiklyResultRecevicer(new WeakReference(this), new Handler()), invokerId, bundle);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.r
            @Override // java.lang.Runnable
            public final void run() {
                VasKuiklyModule.N(newPay, callback);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Bundle bundle, Function1 function1) {
        int i3 = bundle.getInt("retCode", -1);
        if (i3 != 0) {
            String string = bundle.getString("retJson");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (function1 != null) {
                        function1.invoke(jSONObject.toString());
                    }
                } catch (Exception unused) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(QzoneIPCModule.RESULT_CODE, i3);
                    jSONObject2.put("resultMsg", "");
                    if (function1 != null) {
                        function1.invoke(jSONObject2.toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    private final Object S(String method, String params, Function1<Object, Unit> callback) {
        switch (method.hashCode()) {
            case -2128301851:
                if (method.equals("volumeKey")) {
                    Reader F = F();
                    if (params == null) {
                        params = "";
                    }
                    F.b(params, getActivity(), callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2120220310:
                if (method.equals("getUpdateSystemFile")) {
                    am J = J();
                    Intrinsics.checkNotNull(params);
                    return J.b(params);
                }
                return super.call(method, params, callback);
            case -2065118275:
                if (method.equals("availableSpace")) {
                    y().f(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2035569423:
                if (method.equals("photoOpenCameraWithEdit")) {
                    E().h(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1996287759:
                if (method.equals("audioSetOnErrorListener")) {
                    if (params == null) {
                        params = "";
                    }
                    i0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1977593542:
                if (method.equals("isUpdateSystemFileExists")) {
                    am J2 = J();
                    Intrinsics.checkNotNull(params);
                    return J2.c(params);
                }
                return super.call(method, params, callback);
            case -1723885120:
                if (method.equals("aioPanelSetFontBubble")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1719803002:
                if (method.equals("loginByNt")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.w C = C();
                    Intrinsics.checkNotNull(callback);
                    C.e(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1719657070:
                if (method.equals("loginGuid")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.w C2 = C();
                    Intrinsics.checkNotNull(callback);
                    C2.b(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1484342652:
                if (method.equals("loginAccount")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.w C3 = C();
                    Activity activity = getActivity();
                    Intrinsics.checkNotNull(activity);
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    C3.c(activity, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1469358797:
                if (method.equals("gxhGetCustomBgList")) {
                    B().q(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1377539494:
                if (method.equals("gxhFontSetMagicFontType")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B = B();
                    if (params == null) {
                        params = "";
                    }
                    B.K(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1325709908:
                if (method.equals("fileUnZip")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.d y16 = y();
                    if (params == null) {
                        params = "";
                    }
                    y16.k(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1323728957:
                if (method.equals("fileWrite")) {
                    y().l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1300135556:
                if (method.equals("okhttpReqeuest")) {
                    d0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1271796117:
                if (method.equals("gxhQueryDownloadStatus")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B2 = B();
                    if (params == null) {
                        params = "";
                    }
                    B2.z(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1225502206:
                if (method.equals("audioGetCurrentPosition")) {
                    if (params == null) {
                        params = "";
                    }
                    return v(params);
                }
                return super.call(method, params, callback);
            case -1150717068:
                if (method.equals("openEcommerceGetAddress")) {
                    Activity activity2 = getActivity();
                    if (params == null) {
                        params = "";
                    }
                    U(activity2, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -907825454:
                if (method.equals("secretDecryptAes")) {
                    ah H = H();
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    H.e(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -855023558:
                if (method.equals("fileGet")) {
                    if (params == null) {
                        params = "";
                    }
                    return z(params);
                }
                return super.call(method, params, callback);
            case -848458642:
                if (method.equals("audioIsPlaying")) {
                    if (params == null) {
                        params = "";
                    }
                    return R(params);
                }
                return super.call(method, params, callback);
            case -799674276:
                if (method.equals("secretHmacSha1")) {
                    ah H2 = H();
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    H2.n(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -750725698:
                if (method.equals("fileDownloadCancel")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.d y17 = y();
                    if (params == null) {
                        params = "";
                    }
                    y17.b(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -735926472:
                if (method.equals("fileGet2")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.d y18 = y();
                    if (params == null) {
                        params = "";
                    }
                    return y18.g(params);
                }
                return super.call(method, params, callback);
            case -735773638:
                if (method.equals("fileList")) {
                    y().h(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -735599310:
                if (method.equals("fileRead")) {
                    y().i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -735564899:
                if (method.equals("fileSize")) {
                    y().j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -684191255:
                if (method.equals("isDarkTheme")) {
                    return Boolean.valueOf(P());
                }
                return super.call(method, params, callback);
            case -681035739:
                if (method.equals("gxhAppIconSetClientId")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B3 = B();
                    if (params == null) {
                        params = "";
                    }
                    B3.E(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -592455911:
                if (method.equals("gxhAppIconGetClientId")) {
                    B().o(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -528053509:
                if (method.equals("audioSetSpeed")) {
                    if (params == null) {
                        params = "";
                    }
                    k0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -495761583:
                if (method.equals("audioRelease")) {
                    if (params == null) {
                        params = "";
                    }
                    a0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -277394518:
                if (method.equals("readUpdateSystemFile")) {
                    am J3 = J();
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    J3.d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -191559942:
                if (method.equals("secretEncryptAes")) {
                    ah H3 = H();
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    H3.h(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -191543189:
                if (method.equals("secretEncryptRsa")) {
                    ah H4 = H();
                    Intrinsics.checkNotNull(params);
                    Intrinsics.checkNotNull(callback);
                    H4.l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -75324903:
                if (method.equals("getMode")) {
                    return Integer.valueOf(D());
                }
                return super.call(method, params, callback);
            case -17993614:
                if (method.equals("audioCreate")) {
                    if (params == null) {
                        params = "";
                    }
                    return o(params);
                }
                return super.call(method, params, callback);
            case -4957442:
                if (method.equals("audioIsLooping")) {
                    if (params == null) {
                        params = "";
                    }
                    return Q(params);
                }
                return super.call(method, params, callback);
            case 47768139:
                if (method.equals("vasColorNoteClose")) {
                    if (params == null) {
                        params = "";
                    }
                    b0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 49966952:
                if (method.equals("vasColorNoteExits")) {
                    if (params == null) {
                        params = "";
                    }
                    return Boolean.valueOf(O(params));
                }
                return super.call(method, params, callback);
            case 100347820:
                if (method.equals("friendsGetName")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.f A = A();
                    if (params == null) {
                        params = "";
                    }
                    A.b(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 130372133:
                if (method.equals("gxhAppIconCheck")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B4 = B();
                    if (params == null) {
                        params = "";
                    }
                    B4.m(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 159770148:
                if (method.equals("fileDownload")) {
                    if (params == null) {
                        params = "";
                    }
                    r(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 188006377:
                if (method.equals("audioNext")) {
                    if (params == null) {
                        params = "";
                    }
                    T(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 188071978:
                if (method.equals("audioPlay")) {
                    if (params == null) {
                        params = "";
                    }
                    Z(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 188154734:
                if (method.equals("audioSeek")) {
                    if (params == null) {
                        params = "";
                    }
                    f0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 188169464:
                if (method.equals("audioStop")) {
                    if (params == null) {
                        params = "";
                    }
                    n0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 243563807:
                if (method.equals("openImagePicker")) {
                    B().x(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 275284074:
                if (method.equals("friendsOpenSelectFriendsPanel")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.f A2 = A();
                    if (params == null) {
                        params = "";
                    }
                    A2.c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 398398832:
                if (method.equals("audioSetLoop")) {
                    if (params == null) {
                        params = "";
                    }
                    h0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 399873955:
                if (method.equals("audioResume")) {
                    if (params == null) {
                        params = "";
                    }
                    e0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 438152522:
                if (method.equals("photoOpenQAlbumWithEdit")) {
                    E().j(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 502358597:
                if (method.equals("audioSetPlayStateListener")) {
                    if (params == null) {
                        params = "";
                    }
                    j0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 565882825:
                if (method.equals("setDeviceBrightness")) {
                    Activity activity3 = getActivity();
                    if (params == null) {
                        params = "";
                    }
                    g0(activity3, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 597180604:
                if (method.equals("audioCloseLogic")) {
                    m();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 657907342:
                if (method.equals("fileDownload2")) {
                    y().d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 664954523:
                if (method.equals("vasDisplayColorNote")) {
                    if (params == null) {
                        params = "";
                    }
                    q(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 840761465:
                if (method.equals("aioPanelSendMsgEndEditing")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 875644874:
                if (method.equals("audioGetAudioDuration")) {
                    if (params == null) {
                        params = "";
                    }
                    return t(params);
                }
                return super.call(method, params, callback);
            case 895398630:
                if (method.equals("audioSetVolume")) {
                    if (params == null) {
                        params = "";
                    }
                    l0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 915728084:
                if (method.equals("gxhWallpaperSetChatBg")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B5 = B();
                    Activity activity4 = getActivity();
                    if (params == null) {
                        params = "";
                    }
                    B5.M(activity4, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1109967734:
                if (method.equals("getMemberTitleInfo")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B6 = B();
                    if (params == null) {
                        params = "";
                    }
                    B6.u(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1110015706:
                if (method.equals("audioGetVolume")) {
                    if (params == null) {
                        params = "";
                    }
                    return Float.valueOf(K(params));
                }
                return super.call(method, params, callback);
            case 1164814127:
                if (method.equals("setLocalToggleStatus")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B7 = B();
                    if (params == null) {
                        params = "";
                    }
                    B7.G(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1303409927:
                if (method.equals("cardUploadBgToUps")) {
                    Card u16 = u();
                    Activity activity5 = getActivity();
                    if (params == null) {
                        params = "";
                    }
                    u16.d(activity5, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1358191175:
                if (method.equals("fileDelete")) {
                    y().c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1376249600:
                if (method.equals("gxhFontSetMagicFont")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B8 = B();
                    if (params == null) {
                        params = "";
                    }
                    B8.I(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1420132083:
                if (method.equals("rechargeOpenPanel")) {
                    ab G = G();
                    if (params == null) {
                        params = "";
                    }
                    G.b(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1431803834:
                if (method.equals("gxhQuickSwitchDefaultMode")) {
                    B().B(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1450964308:
                if (method.equals("audioGetDuration")) {
                    if (params == null) {
                        params = "";
                    }
                    return x(params);
                }
                return super.call(method, params, callback);
            case 1534955456:
                if (method.equals("audioPause")) {
                    if (params == null) {
                        params = "";
                    }
                    Y(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1644840896:
                if (method.equals("gxhNotify")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B9 = B();
                    if (params == null) {
                        params = "";
                    }
                    B9.v(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1657908480:
                if (method.equals("downloadUpdateSystem")) {
                    am J4 = J();
                    Intrinsics.checkNotNull(params);
                    J4.a(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1664581706:
                if (method.equals("vasColorNoteShow")) {
                    if (params == null) {
                        params = "";
                    }
                    m0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1753525246:
                if (method.equals("audioOpenLogic")) {
                    if (params == null) {
                        params = "";
                    }
                    W(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1755607266:
                if (method.equals("setBackgroundPhoto")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B10 = B();
                    if (params == null) {
                        params = "";
                    }
                    B10.D(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1775737531:
                if (method.equals("getLocalToggleStatus")) {
                    com.tencent.mobileqq.vas.kuikly.moduleimpl.s B11 = B();
                    if (params == null) {
                        params = "";
                    }
                    B11.s(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1796950964:
                if (method.equals("aioPanelGetFontBubble")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1809095191:
                if (method.equals("cardSetDiyCardBg")) {
                    Card u17 = u();
                    Activity activity6 = getActivity();
                    if (params == null) {
                        params = "";
                    }
                    u17.c(activity6, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1924866042:
                if (method.equals("getQzoneDataWnsCgi")) {
                    L(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1932727067:
                if (method.equals("readerMeasure")) {
                    Reader F2 = F();
                    if (params == null) {
                        params = "";
                    }
                    return F2.a(params);
                }
                return super.call(method, params, callback);
            case 2109610685:
                if (method.equals("getDeviceBrightness")) {
                    w(getActivity(), callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    private final void V(final String uin, final Function1<Object, Unit> callback) {
        boolean z16;
        AppInterface appInterface;
        IFriendNameService iFriendNameService;
        final String str;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iFriendNameService = (IFriendNameService) appInterface.getRuntimeService(IFriendNameService.class, "");
        } else {
            iFriendNameService = null;
        }
        if (iFriendNameService != null) {
            str2 = iFriendNameService.getFriendName(uin);
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        if (callback == null) {
            ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(getActivity(), uin, 0, str, new Bundle(), 3);
            return;
        }
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasKuiklyModule$openHalfAio$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_square_aio_start_activity_for_result", true);
                ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask((Activity) activity, uin, 0, str, bundle, 3);
            }
        });
        companion.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasKuiklyModule$openHalfAio$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity fragmentActivity, int i3, int i16, @Nullable Intent intent) {
                Intrinsics.checkNotNullParameter(fragmentActivity, "<anonymous parameter 0>");
                if (i3 == 1001 && i16 == 0) {
                    callback.invoke(null);
                }
            }
        });
        Context activity = getActivity();
        if (activity == null) {
            activity = BaseApplication.getContext();
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void X(String params, final Function1<Object, Unit> callback) {
        final int i3;
        Integer intOrNull;
        if (params != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            if (callback != null) {
                callback.invoke(null);
                return;
            }
            return;
        }
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        final int i16 = 999;
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasKuiklyModule$openSelectFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intent intent = new Intent();
                int i17 = i3;
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i17);
                RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_SELECTMEMBER, i16);
            }
        });
        companion.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasKuiklyModule$openSelectFriend$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity fragmentActivity, int i17, int i18, @Nullable Intent intent) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(fragmentActivity, "<anonymous parameter 0>");
                if (i17 == i16 && i18 == -1) {
                    ArrayList<ResultRecord> parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET) : null;
                    if (parcelableArrayListExtra != null) {
                        Function1<Object, Unit> function1 = callback;
                        ArrayList arrayList = new ArrayList();
                        for (ResultRecord resultRecord : parcelableArrayListExtra) {
                            String str = resultRecord.uin;
                            Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                            if ((str.length() > 0) && !Intrinsics.areEqual(resultRecord.uin, "0")) {
                                arrayList.add(resultRecord.uin);
                            }
                        }
                        if (function1 != null) {
                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList));
                            function1.invoke(mapOf);
                        }
                    }
                    Function1<Object, Unit> function12 = callback;
                    if (function12 != null) {
                        function12.invoke(null);
                        return;
                    }
                    return;
                }
                Function1<Object, Unit> function13 = callback;
                if (function13 != null) {
                    function13.invoke(null);
                }
            }
        });
        Context activity = getActivity();
        if (activity == null) {
            activity = BaseApplication.getContext();
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    private final void c0(String data) {
        JSONObject jSONObject = new JSONObject(data);
        String optString = jSONObject.optString(AdMetricTag.Report.TYPE, "");
        if (Intrinsics.areEqual(optString, "vasTech")) {
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonData.keys()");
            while (keys.hasNext()) {
                String it = (String) keys.next();
                if (!Intrinsics.areEqual(it, AdMetricTag.Report.TYPE)) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String string = jSONObject.getString(it);
                    Intrinsics.checkNotNullExpressionValue(string, "jsonData.getString(it)");
                    hashMap.put(it, string);
                }
            }
            hashMap.put("useNewEventCode", "1");
            ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).reportCommonReal(hashMap);
            return;
        }
        if (Intrinsics.areEqual(optString, "DC04586")) {
            if (QLog.isDebugVersion()) {
                QLog.i("VasKuiklyModule", 1, "reportVasCommon " + jSONObject);
            }
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(jSONObject.optString("appid"), jSONObject.optString("page_id"), jSONObject.optString("module_id"), jSONObject.optString("sub_module_id"), jSONObject.optString("item_id"), "", jSONObject.optString("item_type"), jSONObject.optInt("action_id"), jSONObject.optInt("action_value"), jSONObject.optInt("action_attr"), jSONObject.optString("str_ruleid"), jSONObject.optString("busi_info"), jSONObject.optString(QCircleLpReportDc05507.KEY_POSITION_ID));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(JSONObject result, Function1 function1, TroopMemberInfo troopMemberInfo) {
        String str;
        Intrinsics.checkNotNullParameter(result, "$result");
        if (troopMemberInfo != null) {
            str = troopMemberInfo.friendnick;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        result.put("nickName", str);
        if (function1 != null) {
            function1.invoke(result);
        }
    }

    @NotNull
    public com.tencent.mobileqq.vas.kuikly.moduleimpl.f A() {
        return this.J.a();
    }

    @NotNull
    public com.tencent.mobileqq.vas.kuikly.moduleimpl.s B() {
        return this.F.getGxh();
    }

    @NotNull
    public com.tencent.mobileqq.vas.kuikly.moduleimpl.w C() {
        return this.I.a();
    }

    public int D() {
        return this.f309671e.a();
    }

    @NotNull
    public Photo E() {
        return this.M.getPhoto();
    }

    @NotNull
    public Reader F() {
        return this.f309673h.getReader();
    }

    @NotNull
    public ab G() {
        return this.G.a();
    }

    @NotNull
    public ah H() {
        return this.H.a();
    }

    @NotNull
    public am J() {
        return this.L.getUpdateSystem();
    }

    public float K(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return this.f309675m.f(token);
    }

    public void L(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        this.D.f(params, callback);
    }

    public boolean O(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return this.C.b(json);
    }

    public boolean P() {
        return this.f309671e.b();
    }

    @NotNull
    public String Q(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return this.f309675m.g(token);
    }

    @NotNull
    public String R(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return this.f309675m.h(token);
    }

    public void T(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f309675m.i(path);
    }

    public void U(@Nullable Activity kuiklyActivity, @NotNull String jsonString, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        this.f309670d.a(kuiklyActivity, jsonString, callback);
    }

    public void W(@NotNull String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.f309675m.j(bookId);
    }

    public void Y(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.k(token);
    }

    public void Z(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f309675m.l(json);
    }

    public void a0(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.m(token);
    }

    public void b0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.C.c(json);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable final Function1<Object, Unit> callback) {
        boolean z16;
        Object mapOf;
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(method, "method");
        boolean z17 = false;
        String str2 = "";
        switch (method.hashCode()) {
            case -2147329532:
                if (method.equals("getNickName")) {
                    if (params != null && params.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        QLog.e("VasKuiklyModule", 1, "params is null");
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(params);
                    String optString = jSONObject.optString("uin");
                    String optString2 = jSONObject.optString("groupCode");
                    final JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("nickName", optString);
                    if (optString2 == null || optString2.length() == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(optString);
                        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        String remarkWithUid = iFriendsInfoService.getRemarkWithUid(uid, "VasKuiklyModule");
                        if (!TextUtils.isEmpty(remarkWithUid)) {
                            remarkWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uid, "VasKuiklyModule");
                        }
                        if (!TextUtils.isEmpty(remarkWithUid)) {
                            jSONObject2.put("nickName", remarkWithUid);
                        }
                        if (callback == null) {
                            return null;
                        }
                        callback.invoke(jSONObject2);
                        return Unit.INSTANCE;
                    }
                    ((ITroopMemberInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(optString2, optString, "VasKuiklyModule", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.vas.kuikly.q
                        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                        public final void a(TroopMemberInfo troopMemberInfo) {
                            VasKuiklyModule.l(JSONObject.this, callback, troopMemberInfo);
                        }
                    });
                    return Unit.INSTANCE;
                }
                break;
            case -2038214558:
                if (method.equals("isWhiteStatusBar")) {
                    double b16 = xy2.b.b(BaseApplication.getContext().getColor(R.color.qui_common_text_nav_secondary));
                    double b17 = xy2.b.b(-1);
                    if (callback == null) {
                        return null;
                    }
                    if (Math.abs(b16 - b17) < 0.5d) {
                        z17 = true;
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isWhiteStatusBar", Boolean.valueOf(z17)));
                    callback.invoke(mapOf);
                    return Unit.INSTANCE;
                }
                break;
            case -1962878879:
                if (method.equals("getMqqData")) {
                    x.Companion companion = com.tencent.mobileqq.vas.kuikly.moduleimpl.x.INSTANCE;
                    if (params != null) {
                        str2 = params;
                    }
                    companion.a(str2, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1848944796:
                if (method.equals("preloadWebProcess")) {
                    ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(35, null);
                    return Unit.INSTANCE;
                }
                break;
            case -1808499524:
                if (method.equals("shareImage")) {
                    return Boolean.valueOf(new aj().e(this, params, callback, getActivity()));
                }
                break;
            case -1134524510:
                if (method.equals(IH5DataCacheApi.METHOD_DELETE_H5_DATA)) {
                    as asVar = new as();
                    if (params != null) {
                        str2 = params;
                    }
                    asVar.g(str2, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1006416784:
                if (method.equals(IVipPayApi.METHOD_BUYGOODS)) {
                    if (params != null) {
                        str2 = params;
                    }
                    M(str2, callback, 7);
                    return Unit.INSTANCE;
                }
                break;
            case -874676403:
                if (method.equals(IH5DataCacheApi.METHOD_READ_H5_DATA)) {
                    as asVar2 = new as();
                    if (params != null) {
                        str2 = params;
                    }
                    asVar2.o(str2, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -795799969:
                if (method.equals("resumeAnimTimeLine")) {
                    com.tencent.cachedrawable.dynamicdrawable.api.b bVar = com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a;
                    Intrinsics.checkNotNull(params);
                    com.tencent.cachedrawable.dynamicdrawable.api.b.e(bVar, params, null, 2, null);
                    return Unit.INSTANCE;
                }
                break;
            case -717715070:
                if (method.equals(IVipPayApi.METHOD_PAY_SUBSCRIBE)) {
                    if (params != null) {
                        str2 = params;
                    }
                    M(str2, callback, 14);
                    return Unit.INSTANCE;
                }
                break;
            case -534180608:
                if (method.equals("unitedIsSwitchOn")) {
                    Intrinsics.checkNotNull(params);
                    split$default = StringsKt__StringsKt.split$default((CharSequence) params, new String[]{"|"}, false, 0, 6, (Object) null);
                    return String.valueOf(((IUnitedData) QRoute.api(IUnitedData.class)).isSwitchOn((String) split$default.get(0), Boolean.parseBoolean((String) split$default.get(1))));
                }
                break;
            case -504772615:
                if (method.equals(IndividuationPlugin.Method_OpenPage)) {
                    IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                    BaseApplication context = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                    Intrinsics.checkNotNull(params);
                    iVasHybridRoute.openBrowser(context, params);
                    return Unit.INSTANCE;
                }
                break;
            case -504586225:
                if (method.equals("openView")) {
                    u.Companion companion2 = com.tencent.mobileqq.vas.kuikly.moduleimpl.u.INSTANCE;
                    if (params != null) {
                        str2 = params;
                    }
                    u.Companion.b(companion2, str2, null, 2, null);
                    return Unit.INSTANCE;
                }
                break;
            case -63273477:
                if (method.equals("fetchAbTestInfo")) {
                    if (params == null || TextUtils.isEmpty(params)) {
                        return "";
                    }
                    Pair<ABTest, Map<String, String>> a16 = new com.tencent.mobileqq.vas.ab.b(params).a();
                    ABTest first = a16.getFirst();
                    Map<String, String> second = a16.getSecond();
                    int i3 = b.f309677a[first.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            str = "MISS";
                        } else {
                            str = "B";
                        }
                    } else {
                        str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", str);
                    for (Map.Entry<String, String> entry : second.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    return jSONObject3.toString();
                }
                break;
            case -1414346:
                if (method.equals("reportDubheVASPublicAccount")) {
                    ac acVar = ac.f309760a;
                    if (params != null) {
                        str2 = params;
                    }
                    acVar.a(str2);
                    return Unit.INSTANCE;
                }
                break;
            case 236584513:
                if (method.equals("normalPay")) {
                    Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasKuiklyModule$call$invokeCallback$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str3) {
                            invoke(num.intValue(), str3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i16, @NotNull String msg2) {
                            Intrinsics.checkNotNullParameter(msg2, "msg");
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("code", i16);
                            jSONObject4.put("msg", msg2);
                            Function1<Object, Unit> function1 = callback;
                            if (function1 != null) {
                                function1.invoke(jSONObject4.toString());
                            }
                        }
                    };
                    Activity I = I();
                    if (I == null) {
                        return null;
                    }
                    Intrinsics.checkNotNull(params);
                    JSONObject jSONObject4 = new JSONObject(params);
                    String offerId = jSONObject4.optString("offerId");
                    int optInt = jSONObject4.optInt("month", 0);
                    String uin = jSONObject4.optString("uin");
                    String serviceType = jSONObject4.optString("serviceType");
                    String qqProductName = jSONObject4.optString("qqProductName");
                    String aid = jSONObject4.optString("aid");
                    String optString3 = jSONObject4.optString("productId");
                    e23.c cVar = new e23.c(I);
                    Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    Intrinsics.checkNotNullExpressionValue(serviceType, "serviceType");
                    Intrinsics.checkNotNullExpressionValue(qqProductName, "qqProductName");
                    Intrinsics.checkNotNullExpressionValue(aid, "aid");
                    cVar.c(new MonthlyPayData(offerId, optInt, uin, serviceType, qqProductName, aid, null, false, null, null, false, null, optString3, 4032, null), new d(function2));
                    return Unit.INSTANCE;
                }
                break;
            case 327984316:
                if (method.equals("tianxuanPay")) {
                    if (ar.INSTANCE.b("shouyouye", "2024-01-29", "vas_bug_120024201").isEnable(true)) {
                        if (this.tianxuanPayImpl == null) {
                            this.tianxuanPayImpl = new al();
                        }
                        al alVar = this.tianxuanPayImpl;
                        if (alVar == null) {
                            return null;
                        }
                        alVar.b(params, callback);
                        return Unit.INSTANCE;
                    }
                    Intrinsics.checkNotNull(params);
                    JSONObject jSONObject5 = new JSONObject(params);
                    String optString4 = jSONObject5.optString("userId");
                    int optInt2 = jSONObject5.optInt("businessType");
                    String optString5 = jSONObject5.optString("aid");
                    String optString6 = jSONObject5.optString("itemId");
                    jSONObject5.optString("itemSubId");
                    jSONObject5.optInt("product_type");
                    int optInt3 = jSONObject5.optInt("buyNum");
                    jSONObject5.optString(AdParam.PF);
                    VasInjectApi.getInstance().itemLyPay(optString4, optString5, optInt2, optInt3, optString6, Foreground.getTopActivity(), new c(optString4, optInt3, callback));
                    return Unit.INSTANCE;
                }
                break;
            case 379125832:
                if (method.equals("updateCurrentChatBgId")) {
                    Intrinsics.checkNotNull(params);
                    JSONObject jSONObject6 = new JSONObject(params);
                    VasIpcTempData.Companion companion3 = VasIpcTempData.INSTANCE;
                    VasIpcTempData kuikly2 = companion3.getKuikly();
                    String optString7 = jSONObject6.optString("chat_uin", "");
                    Intrinsics.checkNotNullExpressionValue(optString7, "data.optString(\"chat_uin\", \"\")");
                    kuikly2.setString("chat_uin", optString7);
                    VasIpcTempData kuikly3 = companion3.getKuikly();
                    String optString8 = jSONObject6.optString("chat_type", "");
                    Intrinsics.checkNotNullExpressionValue(optString8, "data.optString(\"chat_type\", \"\")");
                    return kuikly3.setString("chat_type", optString8);
                }
                break;
            case 494148202:
                if (method.equals("openHalfAio")) {
                    V(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 606853668:
                if (method.equals("openSelectFriend")) {
                    X(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 647083236:
                if (method.equals("unitedLoadStringData")) {
                    Intrinsics.checkNotNull(params);
                    byte[] loadRawConfig = ((IUnitedData) QRoute.api(IUnitedData.class)).loadRawConfig(params, S);
                    if (loadRawConfig.length == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        return "";
                    }
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    return new String(loadRawConfig, UTF_8);
                }
                break;
            case 769132200:
                if (method.equals("pauseAnimTimeLine")) {
                    com.tencent.cachedrawable.dynamicdrawable.api.b bVar2 = com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a;
                    Intrinsics.checkNotNull(params);
                    com.tencent.cachedrawable.dynamicdrawable.api.b.c(bVar2, params, null, 2, null);
                    return Unit.INSTANCE;
                }
                break;
            case 906904671:
                if (method.equals("reportVasCommon")) {
                    Intrinsics.checkNotNull(params);
                    c0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1037755094:
                if (method.equals(IH5DataCacheApi.METHOD_WRITE_H5_DATA)) {
                    as asVar3 = new as();
                    if (params != null) {
                        str2 = params;
                    }
                    asVar3.r(str2, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1773763742:
                if (method.equals("getMainClientVersion")) {
                    return AppSetting.f99551k;
                }
                break;
            case 1782090947:
                if (method.equals("getPlatformType")) {
                    return "1";
                }
                break;
        }
        return S(method, params, callback);
    }

    public void d0(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        this.K.j(params, callback);
    }

    public void e0(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.n(token);
    }

    public void f0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f309675m.o(json);
    }

    public void g(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        this.E.a(params, callback);
    }

    public void g0(@Nullable Activity activity, @NotNull String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.f309673h.c(activity, params, callback);
    }

    public void h0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f309675m.p(json);
    }

    public void i(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        this.E.b(params, callback);
    }

    public void i0(@NotNull String token, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.q(token, callback);
    }

    public void j(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        this.E.c(params, callback);
    }

    public void j0(@NotNull String token, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.r(token, callback);
    }

    public void k0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f309675m.s(json);
    }

    public void l0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f309675m.t(json);
    }

    public void m() {
        this.f309675m.a();
    }

    public void m0(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.C.d(json);
    }

    public void n0(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f309675m.u(token);
    }

    @NotNull
    public String o(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.f309675m.b(path);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        al alVar = this.tianxuanPayImpl;
        if (alVar != null) {
            alVar.a();
        }
        this.payCallBack = null;
        p();
    }

    public void p() {
        this.D.e();
    }

    public void q(@NotNull String isDisplay) {
        Intrinsics.checkNotNullParameter(isDisplay, "isDisplay");
        this.C.a(isDisplay);
    }

    public void r(@NotNull String url, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f309672f.a(url, callback);
    }

    @NotNull
    public String t(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return this.f309675m.c(json);
    }

    @NotNull
    public Card u() {
        return this.N.getCom.tencent.mobileqq.vas.IndividuationUrlHelper.UrlId.CARD_HOME java.lang.String();
    }

    @NotNull
    public String v(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return this.f309675m.d(token);
    }

    public void w(@Nullable Activity activity, @Nullable Function1<Object, Unit> callback) {
        this.f309673h.a(activity, callback);
    }

    @NotNull
    public String x(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return this.f309675m.e(token);
    }

    @NotNull
    public com.tencent.mobileqq.vas.kuikly.moduleimpl.d y() {
        return this.f309674i.a();
    }

    @NotNull
    public String z(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.f309672f.b(url);
    }
}
