package com.tencent.luggage.wxa.n5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.hn.ae;
import com.tencent.luggage.wxa.hn.fi;
import com.tencent.luggage.wxa.hn.le;
import com.tencent.luggage.wxa.hn.mb;
import com.tencent.luggage.wxa.hn.me;
import com.tencent.luggage.wxa.hn.nb;
import com.tencent.luggage.wxa.hn.ob;
import com.tencent.luggage.wxa.hn.u6;
import com.tencent.luggage.wxa.hn.zd;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.weui.base.preference.IPreferenceScreen;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u008a\u00012\u00020\u0001:\u0006\n !(#'B\u0011\u0012\u0006\u0010K\u001a\u00020I\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J*\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\n\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0019H\u0002J\u0016\u0010\u001c\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J<\u0010\n\u001a\u00020\r2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J*\u0010 \u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J*\u0010!\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010'\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\tH\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0002J\u001e\u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010#\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010'\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010(\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\n\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010 \u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010!\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\t01H\u0002J\u0012\u0010\n\u001a\u00020\u00152\b\b\u0001\u00103\u001a\u00020\u001aH\u0002J1\u0010\n\u001a\u00020\u00152\b\b\u0001\u00103\u001a\u00020\u001a2\u0016\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000104\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b\n\u00106J\n\u00108\u001a\u0004\u0018\u000107H\u0002J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0015J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010:\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0015J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0012\u0010 \u001a\u00020\t2\b\b\u0002\u0010;\u001a\u00020\rH\u0007J\b\u0010<\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\b\u0010=\u001a\u0004\u0018\u00010\u0003J\b\u0010>\u001a\u0004\u0018\u00010\u0003J\u0006\u0010?\u001a\u00020\rJ\u0006\u0010@\u001a\u00020\rJ\b\u0010B\u001a\u0004\u0018\u00010AJ\b\u0010C\u001a\u0004\u0018\u00010\u0005J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001aJ\u0018\u0010\n\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u001aJ\u0006\u0010G\u001a\u00020\u001aJ\u0006\u0010H\u001a\u00020\u001aR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010SR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010SR\u0016\u0010\\\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010]R\u0016\u0010_\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010]R\u0016\u0010a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010bR\u0016\u0010d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010`R\u0016\u0010e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010`R\u0016\u0010f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010`R\u0016\u0010g\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010`R\u0016\u0010h\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010`R\u0016\u0010i\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010`R\u0016\u0010j\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010`R\u0016\u0010k\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010[R\u0018\u0010n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u001e\u0010~\u001a\n {*\u0004\u0018\u00010z0z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R-\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0005\bZ\u0010\u0082\u0001\"\u0005\b8\u0010\u0083\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/n5/b;", "", "", "Lcom/tencent/luggage/wxa/hn/s;", "items", "Lcom/tencent/luggage/wxa/g5/c;", "subscribeMsgSettingData", "Lcom/tencent/luggage/wxa/hn/fi;", "userInfoUsageInfo", "", "a", "Lcom/tencent/luggage/wxa/hn/me;", "response", "", "success", "enable", "Landroid/preference/Preference;", "pref", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "preferenceScreen", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "appId", "Lcom/tencent/luggage/wxa/n5/b$c;", "callback", "Lcom/tencent/luggage/wxa/sb/d;", "", "authItemList", "g", "authItems", "shouldShowLocationBackground", "shouldShowBluetoothBackground", "b", "c", "state", "e", "Lcom/tencent/luggage/wxa/w3/b;", "preference", "authItem", "f", "d", "w", HippyTKDListViewAdapter.X, "v", NodeProps.VISIBLE, "u", com.tencent.mobileqq.msf.core.net.r.a.f248963o, "none", MagicfaceDataPendantJason.BELONG_TO_BOTH, "Lkotlin/Function0;", "block", "resId", "", "formatArgs", "(I[Ljava/lang/Object;)Ljava/lang/String;", "Landroid/content/SharedPreferences;", tl.h.F, "userName", "p", "closeMenu", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "i", ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/tencent/luggage/wxa/g5/b;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "screen", "data", "j", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/luggage/wxa/m5/b;", "Lcom/tencent/luggage/wxa/m5/b;", "mUIAction", "Lcom/tencent/luggage/wxa/w3/b;", "mUserInfoPreference", "Lcom/tencent/luggage/wxa/w3/d;", "Lcom/tencent/luggage/wxa/w3/d;", "mLocationPreference", "mBluetoothPreference", "mFuzzyLocationPreference", "Lcom/tencent/luggage/wxa/hn/s;", "mAuthItemLocation", "mAuthItemFuzzyLocation", "mAuthItemLocationBackground", "mAuthItemBluetooth", "mAuthItemBluetoothBackground", "mUserInfoItem", "l", "I", "mSelectedUserInfoId", "Ljava/lang/String;", "mAppId", "mUsername", "Z", "mFirstRun", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "mScreen", "mKeyChange", "getAuthItemDone", "getSubscribeMsgInfoDone", "mShouldShowLocationBackground", "mShouldShowBluetoothBackground", "mResponseContainLocationBackground", "mResponseContainBluetoothBackground", "mLocationAuthFlag", "y", "Lcom/tencent/luggage/wxa/g5/c;", "mSubscribeMsgSettingData", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/luggage/wxa/g5/b;", "mWxaUserInfoData", "Lcom/tencent/luggage/wxa/n5/b$d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/luggage/wxa/n5/b$d;", "mHandler", "Lcom/tencent/luggage/wxa/g6/a;", "B", "Lcom/tencent/luggage/wxa/g6/a;", "mContainerAction", "Landroid/content/Context;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mOverrideContext", "", "D", "Ljava/util/List;", "()Ljava/util/List;", "(Ljava/util/List;)V", "mAuthItemList", "E", "Lcom/tencent/luggage/wxa/hn/fi;", "mUserInfoUsageInfo", "<init>", "(Lcom/tencent/luggage/wxa/m5/b;)V", UserInfo.SEX_FEMALE, "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: F */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A */
    public d mHandler;

    /* renamed from: B, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.g6.a mContainerAction;

    /* renamed from: C */
    public Context mOverrideContext;

    /* renamed from: D, reason: from kotlin metadata */
    public List mAuthItemList;

    /* renamed from: E, reason: from kotlin metadata */
    public fi mUserInfoUsageInfo;

    /* renamed from: a, reason: from kotlin metadata */
    public final com.tencent.luggage.wxa.m5.b mUIAction;

    /* renamed from: b, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.w3.b mUserInfoPreference;

    /* renamed from: c, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.w3.d mLocationPreference;

    /* renamed from: d, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.w3.d mBluetoothPreference;

    /* renamed from: e, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.w3.d mFuzzyLocationPreference;

    /* renamed from: f, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.hn.s mAuthItemLocation;

    /* renamed from: g, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.hn.s mAuthItemFuzzyLocation;

    /* renamed from: h */
    public com.tencent.luggage.wxa.hn.s mAuthItemLocationBackground;

    /* renamed from: i, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.hn.s mAuthItemBluetooth;

    /* renamed from: j, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.hn.s mAuthItemBluetoothBackground;

    /* renamed from: k, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.hn.s mUserInfoItem;

    /* renamed from: l, reason: from kotlin metadata */
    public int mSelectedUserInfoId;

    /* renamed from: m */
    public String mAppId;

    /* renamed from: n */
    public String mUsername;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean mFirstRun;

    /* renamed from: p, reason: from kotlin metadata */
    public IPreferenceScreen mScreen;

    /* renamed from: q */
    public boolean mKeyChange;

    /* renamed from: r, reason: from kotlin metadata */
    public boolean getAuthItemDone;

    /* renamed from: s */
    public boolean getSubscribeMsgInfoDone;

    /* renamed from: t, reason: from kotlin metadata */
    public boolean mShouldShowLocationBackground;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean mShouldShowBluetoothBackground;

    /* renamed from: v, reason: from kotlin metadata */
    public boolean mResponseContainLocationBackground;

    /* renamed from: w, reason: from kotlin metadata */
    public boolean mResponseContainBluetoothBackground;

    /* renamed from: x */
    public int mLocationAuthFlag;

    /* renamed from: y, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.g5.c mSubscribeMsgSettingData;

    /* renamed from: z */
    public com.tencent.luggage.wxa.g5.b mWxaUserInfoData;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a0 extends Lambda implements Function0 {

        /* renamed from: b */
        public final /* synthetic */ List f135337b;

        /* renamed from: c */
        public final /* synthetic */ com.tencent.luggage.wxa.g5.c f135338c;

        /* renamed from: d */
        public final /* synthetic */ fi f135339d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(List list, com.tencent.luggage.wxa.g5.c cVar, fi fiVar) {
            super(0);
            this.f135337b = list;
            this.f135338c = cVar;
            this.f135339d = fiVar;
        }

        public final void a() {
            b.this.c(this.f135337b, this.f135338c, this.f135339d);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n5.b$b */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(com.tencent.luggage.wxa.wj.c cVar) {
            com.tencent.luggage.wxa.l5.b bVar = (com.tencent.luggage.wxa.l5.b) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.l5.b.class);
            if (bVar != null) {
                return bVar.a(cVar);
            }
            if (cVar == null) {
                com.tencent.luggage.wxa.tn.w.h("Luggage.STANDALONE.WxaMainSettingLogicImpl", "preferUseDialogMode with invalid window, stack=%s", Log.getStackTraceString(new Throwable()));
            } else if (cVar.isLargeScreenWindow() || cVar.shouldInLargeScreenCompatMode() || cVar.getOrientationHandler().a().b()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b0 implements AppBrandSimpleImageLoader.m {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.w3.b f135340a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.tencent.luggage.wxa.w3.b f135341a;

            /* renamed from: b */
            public final /* synthetic */ Bitmap f135342b;

            public a(com.tencent.luggage.wxa.w3.b bVar, Bitmap bitmap) {
                this.f135341a = bVar;
                this.f135342b = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f135341a.a(this.f135342b);
                this.f135341a.c(0);
                this.f135341a.b(0);
            }
        }

        public b0(com.tencent.luggage.wxa.w3.b bVar) {
            this.f135340a = bVar;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return "";
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            com.tencent.luggage.wxa.tn.c0.a(new a(this.f135340a, bitmap));
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c0 implements AppBrandSimpleImageLoader.j {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.w3.b f135343a;

        /* renamed from: b */
        public final /* synthetic */ b f135344b;

        public c0(com.tencent.luggage.wxa.w3.b bVar, b bVar2) {
            this.f135343a = bVar;
            this.f135344b = bVar2;
        }

        @Override // com.tencent.luggage.wxa.pb.a
        public String b() {
            return "setting_wxa_user_info_icon";
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
        public Bitmap b(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ImageView a16 = this.f135343a.a();
            int width = a16 != null ? a16.getWidth() : bitmap.getWidth();
            ImageView a17 = this.f135343a.a();
            Bitmap a18 = com.tencent.luggage.wxa.tn.d.a(bitmap, false, com.tencent.luggage.wxa.kn.a.a(this.f135344b.mOverrideContext, 4), false, new int[]{width, a17 != null ? a17.getHeight() : bitmap.getHeight()});
            Intrinsics.checkNotNullExpressionValue(a18, "getRoundedCornerBitmap(b\u2026rayOf(ivWidth, ivHeight))");
            return a18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Handler {

        /* renamed from: b */
        public static final a f135345b = new a(null);

        /* renamed from: a */
        public WeakReference f135346a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public d(b logic) {
            Intrinsics.checkNotNullParameter(logic, "logic");
            this.f135346a = new WeakReference(logic);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            b bVar;
            String a16;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            int i3 = msg2.what;
            String str = null;
            if (i3 != 1) {
                if (i3 != 2 || (bVar = (b) this.f135346a.get()) == null) {
                    return;
                }
                com.tencent.luggage.wxa.sb.c cVar = (com.tencent.luggage.wxa.sb.c) msg2.obj;
                bVar.f();
                if (cVar != null) {
                    com.tencent.luggage.wxa.g5.c cVar2 = bVar.mSubscribeMsgSettingData;
                    if (cVar2 != null) {
                        cVar2.a(cVar);
                        IPreferenceScreen iPreferenceScreen = bVar.mScreen;
                        if (iPreferenceScreen != null) {
                            if (!cVar2.d()) {
                                IPreferenceScreen iPreferenceScreen2 = bVar.mScreen;
                                Intrinsics.checkNotNull(iPreferenceScreen2);
                                iPreferenceScreen2.removePreference("preference_key_subscribe_msg");
                                IPreferenceScreen iPreferenceScreen3 = bVar.mScreen;
                                Intrinsics.checkNotNull(iPreferenceScreen3);
                                iPreferenceScreen3.notifyDataSetChanged();
                            } else {
                                Preference preference = iPreferenceScreen.findPreference("preference_key_subscribe_msg");
                                if (preference != null) {
                                    Intrinsics.checkNotNullExpressionValue(preference, "preference");
                                    com.tencent.luggage.wxa.g5.c cVar3 = bVar.mSubscribeMsgSettingData;
                                    Intrinsics.checkNotNull(cVar3);
                                    if (cVar3.e()) {
                                        com.tencent.luggage.wxa.g5.c cVar4 = bVar.mSubscribeMsgSettingData;
                                        Intrinsics.checkNotNull(cVar4);
                                        a16 = bVar.a(R.string.z58, Integer.valueOf(cVar4.c().size()));
                                    } else {
                                        a16 = bVar.a(R.string.z59);
                                    }
                                    preference.setSummary(a16);
                                    iPreferenceScreen.notifyDataSetChanged();
                                }
                            }
                        }
                        List mAuthItemList = bVar.getMAuthItemList();
                        com.tencent.luggage.wxa.g5.c cVar5 = bVar.mSubscribeMsgSettingData;
                        String str2 = bVar.mAppId;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
                            str2 = null;
                        }
                        boolean b16 = bVar.b(str2, bVar.getMAuthItemList());
                        String str3 = bVar.mAppId;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
                        } else {
                            str = str3;
                        }
                        bVar.a(mAuthItemList, cVar5, b16, bVar.a(str, bVar.getMAuthItemList()), bVar.mUserInfoUsageInfo);
                        return;
                    }
                    return;
                }
                Toast.makeText(bVar.mOverrideContext, bVar.a(R.string.f170403z52), 1).show();
                return;
            }
            b bVar2 = (b) this.f135346a.get();
            if (bVar2 == null) {
                return;
            }
            com.tencent.luggage.wxa.g5.c cVar6 = (com.tencent.luggage.wxa.g5.c) msg2.obj;
            bVar2.getSubscribeMsgInfoDone = true;
            if (cVar6 == null) {
                bVar2.a(bVar2.getMAuthItemList(), (com.tencent.luggage.wxa.g5.c) null, bVar2.mUserInfoUsageInfo);
            } else {
                bVar2.mSubscribeMsgSettingData = cVar6;
                bVar2.a(bVar2.getMAuthItemList(), cVar6, bVar2.mUserInfoUsageInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(int i3, String str, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {
        public g() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.g5.c cVar) {
            Message.obtain(b.this.mHandler, 1, cVar).sendToTarget();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.g5.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements com.tencent.luggage.wxa.uo.b {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a */
        public final Boolean call(ae aeVar) {
            boolean z16 = false;
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "wxaAppGetAuthInfoResp:%s", aeVar);
            if (aeVar == null) {
                b.this.a(true);
                com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "WxaAppGetAuthInfoReq failed, response is null!");
            } else {
                ob obVar = aeVar.f127299e;
                int i3 = obVar.f128367d;
                String str = obVar.f128368e;
                if (i3 != 0) {
                    b.this.a(true);
                    com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "WxaAppGetAuthInfoReq error %s", str);
                } else {
                    b bVar = b.this;
                    LinkedList linkedList = aeVar.f127300f;
                    Intrinsics.checkNotNullExpressionValue(linkedList, "wxaAppGetAuthInfoResp.authItem");
                    bVar.h(linkedList);
                    b bVar2 = b.this;
                    bVar2.mResponseContainLocationBackground = bVar2.f(bVar2.getMAuthItemList());
                    b bVar3 = b.this;
                    bVar3.mResponseContainBluetoothBackground = bVar3.c(bVar3.getMAuthItemList());
                    b.this.mUserInfoUsageInfo = aeVar.f127301g;
                    com.tencent.luggage.wxa.rk.a aVar = com.tencent.luggage.wxa.rk.a.f139822a;
                    String str2 = b.this.mAppId;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAppId");
                        str2 = null;
                    }
                    aVar.a(str2, b.this.mUserInfoUsageInfo);
                    z16 = true;
                }
            }
            b.this.getAuthItemDone = true;
            b bVar4 = b.this;
            bVar4.a(bVar4.getMAuthItemList(), b.this.mSubscribeMsgSettingData, b.this.mUserInfoUsageInfo);
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements com.tencent.luggage.wxa.uo.b {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a */
        public final Object call(Boolean bool) {
            b.this.f();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements c {

        /* renamed from: b */
        public final /* synthetic */ int f135351b;

        /* renamed from: c */
        public final /* synthetic */ int f135352c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ boolean f135353a;

            /* renamed from: b */
            public final /* synthetic */ b f135354b;

            /* renamed from: c */
            public final /* synthetic */ int f135355c;

            /* renamed from: d */
            public final /* synthetic */ int f135356d;

            public a(boolean z16, b bVar, int i3, int i16) {
                this.f135353a = z16;
                this.f135354b = bVar;
                this.f135355c = i3;
                this.f135356d = i16;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f135353a) {
                    this.f135354b.e(this.f135355c);
                } else {
                    this.f135354b.e(this.f135356d);
                }
                this.f135354b.v();
                IPreferenceScreen iPreferenceScreen = this.f135354b.mScreen;
                Intrinsics.checkNotNull(iPreferenceScreen);
                iPreferenceScreen.notifyDataSetChanged();
            }
        }

        public j(int i3, int i16) {
            this.f135351b = i3;
            this.f135352c = i16;
        }

        @Override // com.tencent.luggage.wxa.n5.b.c
        public void a(boolean z16) {
            com.tencent.luggage.wxa.tn.c0.a(new a(z16, b.this, this.f135351b, this.f135352c));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements c {

        /* renamed from: b */
        public final /* synthetic */ int f135358b;

        /* renamed from: c */
        public final /* synthetic */ int f135359c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ boolean f135360a;

            /* renamed from: b */
            public final /* synthetic */ b f135361b;

            /* renamed from: c */
            public final /* synthetic */ int f135362c;

            /* renamed from: d */
            public final /* synthetic */ int f135363d;

            public a(boolean z16, b bVar, int i3, int i16) {
                this.f135360a = z16;
                this.f135361b = bVar;
                this.f135362c = i3;
                this.f135363d = i16;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f135360a) {
                    this.f135361b.f(this.f135362c);
                } else {
                    this.f135361b.f(this.f135363d);
                }
                this.f135361b.w();
                IPreferenceScreen iPreferenceScreen = this.f135361b.mScreen;
                Intrinsics.checkNotNull(iPreferenceScreen);
                iPreferenceScreen.notifyDataSetChanged();
            }
        }

        public k(int i3, int i16) {
            this.f135358b = i3;
            this.f135359c = i16;
        }

        @Override // com.tencent.luggage.wxa.n5.b.c
        public void a(boolean z16) {
            com.tencent.luggage.wxa.tn.c0.a(new a(z16, b.this, this.f135358b, this.f135359c));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements c {

        /* renamed from: b */
        public final /* synthetic */ int f135365b;

        /* renamed from: c */
        public final /* synthetic */ int f135366c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ boolean f135367a;

            /* renamed from: b */
            public final /* synthetic */ b f135368b;

            /* renamed from: c */
            public final /* synthetic */ int f135369c;

            /* renamed from: d */
            public final /* synthetic */ int f135370d;

            public a(boolean z16, b bVar, int i3, int i16) {
                this.f135367a = z16;
                this.f135368b = bVar;
                this.f135369c = i3;
                this.f135370d = i16;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f135367a) {
                    this.f135368b.g(this.f135369c);
                } else {
                    this.f135368b.g(this.f135370d);
                }
                this.f135368b.x();
                IPreferenceScreen iPreferenceScreen = this.f135368b.mScreen;
                Intrinsics.checkNotNull(iPreferenceScreen);
                iPreferenceScreen.notifyDataSetChanged();
            }
        }

        public l(int i3, int i16) {
            this.f135365b = i3;
            this.f135366c = i16;
        }

        @Override // com.tencent.luggage.wxa.n5.b.c
        public void a(boolean z16) {
            com.tencent.luggage.wxa.tn.c0.a(new a(z16, b.this, this.f135365b, this.f135366c));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function0 {

        /* renamed from: b */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135372b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(com.tencent.luggage.wxa.hn.s sVar) {
            super(0);
            this.f135372b = sVar;
        }

        public final void a() {
            b bVar = b.this;
            com.tencent.luggage.wxa.w3.b bVar2 = bVar.mUserInfoPreference;
            Intrinsics.checkNotNull(bVar2);
            com.tencent.luggage.wxa.hn.s authItem = this.f135372b;
            Intrinsics.checkNotNullExpressionValue(authItem, "authItem");
            bVar.a(bVar2, authItem);
            IPreferenceScreen iPreferenceScreen = b.this.mScreen;
            Intrinsics.checkNotNull(iPreferenceScreen);
            iPreferenceScreen.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n implements c {

        /* renamed from: b */
        public final /* synthetic */ Preference f135374b;

        /* renamed from: c */
        public final /* synthetic */ IPreferenceScreen f135375c;

        /* renamed from: d */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135376d;

        public n(Preference preference, IPreferenceScreen iPreferenceScreen, com.tencent.luggage.wxa.hn.s sVar) {
            this.f135374b = preference;
            this.f135375c = iPreferenceScreen;
            this.f135376d = sVar;
        }

        @Override // com.tencent.luggage.wxa.n5.b.c
        public void a(boolean z16) {
            b bVar = b.this;
            Preference preference = this.f135374b;
            IPreferenceScreen iPreferenceScreen = this.f135375c;
            Intrinsics.checkNotNull(iPreferenceScreen);
            bVar.a(z16, true, preference, iPreferenceScreen, this.f135376d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135377a;

        /* renamed from: b */
        public final /* synthetic */ b f135378b;

        /* renamed from: c */
        public final /* synthetic */ Preference f135379c;

        /* renamed from: d */
        public final /* synthetic */ IPreferenceScreen f135380d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements c {

            /* renamed from: a */
            public final /* synthetic */ b f135381a;

            /* renamed from: b */
            public final /* synthetic */ Preference f135382b;

            /* renamed from: c */
            public final /* synthetic */ IPreferenceScreen f135383c;

            /* renamed from: d */
            public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135384d;

            public a(b bVar, Preference preference, IPreferenceScreen iPreferenceScreen, com.tencent.luggage.wxa.hn.s sVar) {
                this.f135381a = bVar;
                this.f135382b = preference;
                this.f135383c = iPreferenceScreen;
                this.f135384d = sVar;
            }

            @Override // com.tencent.luggage.wxa.n5.b.c
            public void a(boolean z16) {
                b bVar = this.f135381a;
                Preference preference = this.f135382b;
                IPreferenceScreen iPreferenceScreen = this.f135383c;
                Intrinsics.checkNotNull(iPreferenceScreen);
                bVar.a(z16, false, preference, iPreferenceScreen, this.f135384d);
            }
        }

        public o(com.tencent.luggage.wxa.hn.s sVar, b bVar, Preference preference, IPreferenceScreen iPreferenceScreen) {
            this.f135377a = sVar;
            this.f135378b = bVar;
            this.f135379c = preference;
            this.f135380d = iPreferenceScreen;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            this.f135377a.f128645f = 2;
            com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "set authItem.state close");
            b bVar = this.f135378b;
            bVar.a(new a(bVar, this.f135379c, this.f135380d, this.f135377a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135385a;

        /* renamed from: b */
        public final /* synthetic */ Preference f135386b;

        /* renamed from: c */
        public final /* synthetic */ IPreferenceScreen f135387c;

        public p(com.tencent.luggage.wxa.hn.s sVar, Preference preference, IPreferenceScreen iPreferenceScreen) {
            this.f135385a = sVar;
            this.f135386b = preference;
            this.f135387c = iPreferenceScreen;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "set authItem.state open");
            this.f135385a.f128645f = 1;
            Preference preference = this.f135386b;
            Intrinsics.checkNotNull(preference, "null cannot be cast to non-null type com.tencent.luggage.preference.WmpfSwitchPreference");
            ((com.tencent.luggage.wxa.w3.e) preference).setChecked(true);
            IPreferenceScreen iPreferenceScreen = this.f135387c;
            Intrinsics.checkNotNull(iPreferenceScreen);
            iPreferenceScreen.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135388a;

        /* renamed from: b */
        public final /* synthetic */ Preference f135389b;

        /* renamed from: c */
        public final /* synthetic */ IPreferenceScreen f135390c;

        public q(com.tencent.luggage.wxa.hn.s sVar, Preference preference, IPreferenceScreen iPreferenceScreen) {
            this.f135388a = sVar;
            this.f135389b = preference;
            this.f135390c = iPreferenceScreen;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "on cancel click!");
            this.f135388a.f128645f = 1;
            Preference preference = this.f135389b;
            Intrinsics.checkNotNull(preference, "null cannot be cast to non-null type com.tencent.luggage.preference.WmpfSwitchPreference");
            ((com.tencent.luggage.wxa.w3.e) preference).setChecked(true);
            IPreferenceScreen iPreferenceScreen = this.f135390c;
            Intrinsics.checkNotNull(iPreferenceScreen);
            iPreferenceScreen.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements c {

        /* renamed from: b */
        public final /* synthetic */ Preference f135392b;

        /* renamed from: c */
        public final /* synthetic */ IPreferenceScreen f135393c;

        /* renamed from: d */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135394d;

        public r(Preference preference, IPreferenceScreen iPreferenceScreen, com.tencent.luggage.wxa.hn.s sVar) {
            this.f135392b = preference;
            this.f135393c = iPreferenceScreen;
            this.f135394d = sVar;
        }

        @Override // com.tencent.luggage.wxa.n5.b.c
        public void a(boolean z16) {
            b bVar = b.this;
            Preference preference = this.f135392b;
            IPreferenceScreen iPreferenceScreen = this.f135393c;
            Intrinsics.checkNotNull(iPreferenceScreen);
            bVar.a(z16, false, preference, iPreferenceScreen, this.f135394d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class s implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f135395a;

        /* renamed from: b */
        public final /* synthetic */ Preference f135396b;

        /* renamed from: c */
        public final /* synthetic */ boolean f135397c;

        /* renamed from: d */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.s f135398d;

        /* renamed from: e */
        public final /* synthetic */ IPreferenceScreen f135399e;

        public s(boolean z16, Preference preference, boolean z17, com.tencent.luggage.wxa.hn.s sVar, IPreferenceScreen iPreferenceScreen) {
            this.f135395a = z16;
            this.f135396b = preference;
            this.f135397c = z17;
            this.f135398d = sVar;
            this.f135399e = iPreferenceScreen;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3 = 2;
            if (this.f135395a) {
                Preference preference = this.f135396b;
                Intrinsics.checkNotNull(preference, "null cannot be cast to non-null type com.tencent.luggage.preference.WmpfSwitchPreference");
                ((com.tencent.luggage.wxa.w3.e) preference).setChecked(this.f135397c);
                com.tencent.luggage.wxa.hn.s sVar = this.f135398d;
                if (this.f135397c) {
                    i3 = 1;
                }
                sVar.f128645f = i3;
                this.f135399e.notifyDataSetChanged();
                return;
            }
            Preference preference2 = this.f135396b;
            Intrinsics.checkNotNull(preference2, "null cannot be cast to non-null type com.tencent.luggage.preference.WmpfSwitchPreference");
            ((com.tencent.luggage.wxa.w3.e) preference2).setChecked(!this.f135397c);
            com.tencent.luggage.wxa.hn.s sVar2 = this.f135398d;
            if (!this.f135397c) {
                i3 = 1;
            }
            sVar2.f128645f = i3;
            this.f135399e.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ c f135401b;

        public t(c cVar) {
            this.f135401b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.mKeyChange) {
                b.this.mKeyChange = false;
                b.this.u();
                b bVar = b.this;
                String str = bVar.mAppId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppId");
                    str = null;
                }
                bVar.a(str, this.f135401b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Function0 f135402a;

        public u(Function0 function0) {
            this.f135402a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f135402a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class v implements com.tencent.luggage.wxa.uo.b {
        public v() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a */
        public final me call(me meVar) {
            b.this.f();
            return meVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class w implements com.tencent.luggage.wxa.uo.b {
        public w() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a */
        public final Boolean call(me meVar) {
            if (meVar == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "WxaAppModAuthReq failed, response is null!");
            } else {
                ob obVar = meVar.f128207e;
                int i3 = obVar.f128367d;
                String str = obVar.f128368e;
                if (i3 == 0) {
                    b.this.a(meVar);
                    b bVar = b.this;
                    bVar.g(bVar.getMAuthItemList());
                    com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "WxaAppModAuthReq OK!");
                    return Boolean.TRUE;
                }
                com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "WxaAppModAuthReq error %s", str);
            }
            return Boolean.FALSE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class x implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b */
        public final /* synthetic */ c f135405b;

        public x(c cVar) {
            this.f135405b = cVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a */
        public final Void call(Boolean bool) {
            c cVar = this.f135405b;
            if (cVar != null) {
                Intrinsics.checkNotNull(bool);
                cVar.a(bool.booleanValue());
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class y implements e.a {

        /* renamed from: b */
        public final /* synthetic */ c f135407b;

        public y(c cVar) {
            this.f135407b = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "wxaapp_modauth interrupted");
            b.this.f();
            c cVar = this.f135407b;
            if (cVar != null) {
                cVar.a(false);
            }
            Toast.makeText(b.this.mOverrideContext, b.this.a(R.string.f170403z52), 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class z extends Lambda implements Function1 {
        public z() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.sb.c cVar) {
            Message.obtain(b.this.mHandler, 2, cVar).sendToTarget();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.sb.c) obj);
            return Unit.INSTANCE;
        }
    }

    public b(@NotNull com.tencent.luggage.wxa.m5.b mUIAction) {
        Intrinsics.checkNotNullParameter(mUIAction, "mUIAction");
        this.mUIAction = mUIAction;
        this.mFirstRun = true;
        com.tencent.luggage.wxa.g6.a e16 = mUIAction.e();
        this.mContainerAction = e16;
        this.mOverrideContext = e16.getContext();
        this.mAuthItemList = new ArrayList();
        this.mHandler = new d(this);
    }

    public final boolean a(List authItems, com.tencent.luggage.wxa.g5.c subscribeMsgSettingData, boolean shouldShowLocationBackground, boolean shouldShowBluetoothBackground, fi userInfoUsageInfo) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int n() {
        char c16;
        char c17;
        com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemBluetooth;
        if (sVar != null) {
            Intrinsics.checkNotNull(sVar);
            if (sVar.f128645f == 1) {
                c16 = 1;
                if (c16 != 2) {
                    return 0;
                }
                com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemBluetoothBackground;
                if (sVar2 != null) {
                    Intrinsics.checkNotNull(sVar2);
                    if (sVar2.f128645f == 1) {
                        c17 = 1;
                        if (c17 != 2) {
                            return 1;
                        }
                        return 2;
                    }
                }
                c17 = 2;
                if (c17 != 2) {
                }
            }
        }
        c16 = 2;
        if (c16 != 2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int o() {
        char c16;
        char c17;
        com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemLocation;
        if (sVar != null) {
            Intrinsics.checkNotNull(sVar);
            if (sVar.f128645f == 1) {
                c16 = 1;
                if (c16 != 2) {
                    return 0;
                }
                com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemLocationBackground;
                if (sVar2 != null) {
                    Intrinsics.checkNotNull(sVar2);
                    if (sVar2.f128645f == 1) {
                        c17 = 1;
                        if (c17 != 2) {
                            return 1;
                        }
                        return 2;
                    }
                }
                c17 = 2;
                if (c17 != 2) {
                }
            }
        }
        c16 = 2;
        if (c16 != 2) {
        }
    }

    public final void p() {
        zd zdVar = new zd();
        String str = this.mAppId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        zdVar.f129153e = str;
        com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        String str3 = this.mAppId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
        } else {
            str2 = str3;
        }
        cVar.b("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", str2, zdVar, ae.class).b(new h()).a(new i());
    }

    /* renamed from: q, reason: from getter */
    public final com.tencent.luggage.wxa.hn.s getMUserInfoItem() {
        return this.mUserInfoItem;
    }

    /* renamed from: r, reason: from getter */
    public final com.tencent.luggage.wxa.g5.b getMWxaUserInfoData() {
        return this.mWxaUserInfoData;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getMShouldShowBluetoothBackground() {
        return this.mShouldShowBluetoothBackground;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getMShouldShowLocationBackground() {
        return this.mShouldShowLocationBackground;
    }

    public final void u() {
        this.mUIAction.f();
    }

    public final void v() {
        com.tencent.luggage.wxa.w3.d dVar = this.mBluetoothPreference;
        if (dVar == null) {
            return;
        }
        Intrinsics.checkNotNull(dVar);
        int n3 = n();
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    dVar.setSummary(R.string.f170352yx3);
                    return;
                } else {
                    dVar.setSummary(R.string.f170350yx1);
                    return;
                }
            }
            dVar.setSummary(R.string.z__);
            return;
        }
        dVar.setSummary(R.string.f170352yx3);
    }

    public final void w() {
        if (this.mAuthItemFuzzyLocation == null) {
            return;
        }
        com.tencent.luggage.wxa.w3.d dVar = this.mFuzzyLocationPreference;
        Intrinsics.checkNotNull(dVar);
        int j3 = j();
        if (j3 != 1) {
            if (j3 != 2) {
                dVar.setSummary(R.string.z_a);
                return;
            } else {
                dVar.setSummary(R.string.z_a);
                return;
            }
        }
        dVar.setSummary(R.string.z__);
    }

    public final void x() {
        com.tencent.luggage.wxa.w3.d dVar = this.mLocationPreference;
        if (dVar == null) {
            return;
        }
        Intrinsics.checkNotNull(dVar);
        int o16 = o();
        if (o16 != 0) {
            if (o16 != 1) {
                if (o16 != 2) {
                    dVar.setSummary(R.string.z_a);
                    return;
                } else {
                    dVar.setSummary(R.string.z_9);
                    return;
                }
            }
            dVar.setSummary(R.string.z__);
            return;
        }
        dVar.setSummary(R.string.z_a);
    }

    public final void g(List authItemList) {
        Iterator it = authItemList.iterator();
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            String str = sVar.f128643d;
            if (!(str == null || str.length() == 0) && Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_LOCATION)) {
                z16 = sVar.f128645f == 1;
            } else {
                String str2 = sVar.f128643d;
                if (!(str2 == null || str2.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.userLocationBackground")) {
                    z17 = sVar.f128645f == 1;
                } else {
                    String str3 = sVar.f128643d;
                    if (!(str3 == null || str3.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.bluetooth")) {
                        z18 = sVar.f128645f == 1;
                    } else {
                        String str4 = sVar.f128643d;
                        if (!(str4 == null || str4.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.bluetoothBackground")) {
                            z19 = sVar.f128645f == 1;
                        }
                    }
                }
            }
        }
        a aVar = new a(false, false, false, false, 15, null);
        aVar.f135332a = z16;
        aVar.f135333b = z17;
        aVar.f135334c = z18;
        aVar.f135335d = z19;
        String str5 = this.mAppId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str5 = null;
        }
        com.tencent.luggage.wxa.h2.b.a(str5, aVar);
    }

    public final void h(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mAuthItemList = list;
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.luggage.wxa.hn.s getMAuthItemFuzzyLocation() {
        return this.mAuthItemFuzzyLocation;
    }

    public final int j() {
        com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemFuzzyLocation;
        if (sVar != null) {
            return sVar.f128645f;
        }
        return 2;
    }

    /* renamed from: k, reason: from getter */
    public final com.tencent.luggage.wxa.hn.s getMAuthItemLocation() {
        return this.mAuthItemLocation;
    }

    /* renamed from: l, reason: from getter */
    public final List getMAuthItemList() {
        return this.mAuthItemList;
    }

    /* renamed from: m, reason: from getter */
    public final com.tencent.luggage.wxa.g5.c getMSubscribeMsgSettingData() {
        return this.mSubscribeMsgSettingData;
    }

    public final void e(int state) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "updateBluetoothAuthState, state:%d", Integer.valueOf(state));
        b();
        a();
        if (state == 1) {
            com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemBluetooth;
            if (sVar != null) {
                Intrinsics.checkNotNull(sVar);
                sVar.f128645f = 1;
            }
            com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemBluetoothBackground;
            if (sVar2 != null) {
                Intrinsics.checkNotNull(sVar2);
                sVar2.f128645f = 2;
                return;
            }
            return;
        }
        if (state != 2) {
            com.tencent.luggage.wxa.hn.s sVar3 = this.mAuthItemBluetooth;
            if (sVar3 != null) {
                Intrinsics.checkNotNull(sVar3);
                sVar3.f128645f = 2;
            }
            com.tencent.luggage.wxa.hn.s sVar4 = this.mAuthItemBluetoothBackground;
            if (sVar4 != null) {
                Intrinsics.checkNotNull(sVar4);
                sVar4.f128645f = 2;
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.hn.s sVar5 = this.mAuthItemBluetoothBackground;
        if (sVar5 != null) {
            Intrinsics.checkNotNull(sVar5);
            sVar5.f128645f = 1;
        }
        com.tencent.luggage.wxa.hn.s sVar6 = this.mAuthItemBluetooth;
        if (sVar6 != null) {
            Intrinsics.checkNotNull(sVar6);
            sVar6.f128645f = 1;
        }
    }

    public final void f(int state) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "updateFuzzyLocationAuthState, state:%d", Integer.valueOf(state));
        c();
        if (state == 1) {
            com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemFuzzyLocation;
            Intrinsics.checkNotNull(sVar);
            sVar.f128645f = 1;
        } else if (state != 2) {
            com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemFuzzyLocation;
            Intrinsics.checkNotNull(sVar2);
            sVar2.f128645f = 2;
        } else {
            com.tencent.luggage.wxa.hn.s sVar3 = this.mAuthItemFuzzyLocation;
            Intrinsics.checkNotNull(sVar3);
            sVar3.f128645f = 1;
        }
    }

    public final SharedPreferences h() {
        return this.mUIAction.d();
    }

    public final void d(int state) {
        int o16 = o();
        if (state != o16) {
            this.mKeyChange = true;
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "onClickLocationPreference, change location state to:%s", Integer.valueOf(state));
            g(state);
            a(new l(state, o16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6499a();

        /* renamed from: a */
        public boolean f135332a;

        /* renamed from: b */
        public boolean f135333b;

        /* renamed from: c */
        public boolean f135334c;

        /* renamed from: d */
        public boolean f135335d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n5.b$a$a */
        /* loaded from: classes8.dex */
        public static final class C6499a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new a(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f135332a = z16;
            this.f135333b = z17;
            this.f135334c = z18;
            this.f135335d = z19;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.f135332a ? 1 : 0);
            out.writeInt(this.f135333b ? 1 : 0);
            out.writeInt(this.f135334c ? 1 : 0);
            out.writeInt(this.f135335d ? 1 : 0);
        }

        public /* synthetic */ a(boolean z16, boolean z17, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? false : z19);
        }
    }

    public final void c(String userName) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.mUsername = userName;
    }

    public final void c(int state) {
        com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemFuzzyLocation;
        int i3 = sVar != null ? sVar.f128645f : 2;
        if (state != i3) {
            this.mKeyChange = true;
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "onClickFuzzyLocationPreference, change fuzzy location state to:%s", Integer.valueOf(state));
            f(state);
            a(new k(state, i3));
        }
    }

    public final void b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.mAppId = appId;
    }

    public final void b(boolean closeMenu) {
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.luggage.wxa.hn.s sVar : this.mAuthItemList) {
            if (sVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", sVar.f128643d);
                    jSONObject.put("state", sVar.f128645f);
                    jSONObject.put("desc", sVar.f128644e);
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", e16, "", new Object[0]);
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        com.tencent.luggage.wxa.g5.c cVar = this.mSubscribeMsgSettingData;
        if (cVar != null) {
            try {
                jSONObject2.put("mainSwitch", cVar.e());
                JSONArray jSONArray2 = new JSONArray();
                for (com.tencent.luggage.wxa.sb.d dVar : cVar.c()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("title", dVar.i());
                    jSONObject3.put("templateId", dVar.f());
                    jSONObject3.put(WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, dVar.g());
                    jSONObject3.put("status", a(dVar));
                    jSONObject3.put("tid", dVar.h());
                    jSONArray2.mo162put(jSONObject3);
                }
                jSONObject2.put("templatesInfo", jSONArray2);
            } catch (JSONException e17) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", e17, "", new Object[0]);
                Unit unit = Unit.INSTANCE;
            }
        }
        com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "authInfo %s", jSONArray);
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "setResData, subscriptionsSetting:%s", jSONObject2);
        Intent intent = new Intent();
        intent.putExtra("KEY_AUTHORIZE_STR", jSONArray.toString());
        intent.putExtra("KEY_APP_SUBSCRIPTIONS_SETTING", jSONObject2.toString());
        intent.putExtra("KEY_APP_CLOSE_MENU", closeMenu);
        intent.putExtra("KEY_LOCATION_AUTH_FLAG", this.mLocationAuthFlag);
        a(this.mAuthItemList);
        this.mContainerAction.setResult(-1, intent);
    }

    public final void f() {
        this.mUIAction.a();
    }

    public final void d() {
        if (this.mAuthItemLocationBackground == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "create AuthItemLocationBackground");
            com.tencent.luggage.wxa.hn.s sVar = new com.tencent.luggage.wxa.hn.s();
            sVar.f128645f = 2;
            sVar.f128643d = "scope.userLocationBackground";
            sVar.f128644e = a(R.string.z_5);
            this.mAuthItemLocationBackground = sVar;
            List list = this.mAuthItemList;
            Intrinsics.checkNotNull(sVar);
            list.add(sVar);
        }
    }

    public final boolean f(List authItems) {
        Iterator it = authItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            String str = sVar.f128643d;
            if (!(str == null || str.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.userLocationBackground")) {
                return true;
            }
        }
    }

    public final void c(List authItems, com.tencent.luggage.wxa.g5.c subscribeMsgSettingData, fi userInfoUsageInfo) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "updatePreferencesInternal, authItems size = %d", Integer.valueOf(authItems.size()));
        Iterator it = authItems.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            if (sVar != null) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "updatePreferencesInternal, find scope:%s, state:%d", sVar.f128643d, Integer.valueOf(sVar.f128645f));
                String str = sVar.f128643d;
                if (!(str == null || str.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.bluetoothBackground")) {
                    this.mAuthItemBluetoothBackground = sVar;
                } else {
                    String str2 = sVar.f128643d;
                    if (!(str2 == null || str2.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.bluetooth")) {
                        this.mAuthItemBluetooth = sVar;
                        com.tencent.luggage.wxa.w3.d dVar = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
                        dVar.setPersistent(false);
                        dVar.setKey(sVar.f128643d);
                        dVar.setSummary(sVar.f128647h);
                        dVar.setTitle(sVar.f128644e);
                        this.mBluetoothPreference = dVar;
                        IPreferenceScreen iPreferenceScreen = this.mScreen;
                        Intrinsics.checkNotNull(iPreferenceScreen);
                        iPreferenceScreen.addPreference(this.mBluetoothPreference);
                    } else {
                        String str3 = sVar.f128643d;
                        if (!(str3 == null || str3.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.userLocationBackground")) {
                            this.mAuthItemLocationBackground = sVar;
                        } else {
                            String str4 = sVar.f128643d;
                            if (!(str4 == null || str4.length() == 0) && Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_LOCATION)) {
                                this.mAuthItemLocation = sVar;
                                com.tencent.luggage.wxa.w3.d dVar2 = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
                                dVar2.setPersistent(false);
                                dVar2.setKey(sVar.f128643d);
                                dVar2.setSummary(sVar.f128647h);
                                dVar2.setTitle(sVar.f128644e);
                                this.mLocationPreference = dVar2;
                                IPreferenceScreen iPreferenceScreen2 = this.mScreen;
                                Intrinsics.checkNotNull(iPreferenceScreen2);
                                iPreferenceScreen2.addPreference(this.mLocationPreference);
                            } else {
                                String str5 = sVar.f128643d;
                                if (!(str5 == null || str5.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.userFuzzyLocation")) {
                                    this.mAuthItemFuzzyLocation = sVar;
                                    com.tencent.luggage.wxa.w3.d dVar3 = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
                                    dVar3.setPersistent(false);
                                    dVar3.setKey(sVar.f128643d);
                                    dVar3.setSummary(sVar.f128647h);
                                    dVar3.setTitle(sVar.f128644e);
                                    this.mFuzzyLocationPreference = dVar3;
                                    IPreferenceScreen iPreferenceScreen3 = this.mScreen;
                                    Intrinsics.checkNotNull(iPreferenceScreen3);
                                    iPreferenceScreen3.addPreference(this.mFuzzyLocationPreference);
                                } else {
                                    String str6 = sVar.f128643d;
                                    if (!(str6 == null || str6.length() == 0) && Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_INFO)) {
                                        if (this.mUserInfoPreference == null) {
                                            this.mUserInfoPreference = new com.tencent.luggage.wxa.w3.b(this.mOverrideContext);
                                        }
                                        if (sVar.f128646g == null) {
                                            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "scope userinfo's UserAvatarInfo is null, can not be add into Preference");
                                        } else {
                                            com.tencent.luggage.wxa.w3.b bVar = this.mUserInfoPreference;
                                            if (bVar != null) {
                                                bVar.setPersistent(false);
                                                IPreferenceScreen iPreferenceScreen4 = this.mScreen;
                                                Intrinsics.checkNotNull(iPreferenceScreen4);
                                                iPreferenceScreen4.addPreference(bVar);
                                                a(bVar, sVar);
                                            }
                                        }
                                    } else {
                                        com.tencent.luggage.wxa.w3.e eVar = new com.tencent.luggage.wxa.w3.e(this.mOverrideContext);
                                        eVar.setPersistent(false);
                                        eVar.setKey(sVar.f128643d);
                                        eVar.setTitle(sVar.f128644e);
                                        eVar.setChecked(sVar.f128645f == 1);
                                        IPreferenceScreen iPreferenceScreen5 = this.mScreen;
                                        Intrinsics.checkNotNull(iPreferenceScreen5);
                                        iPreferenceScreen5.addPreference(eVar);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        x();
        v();
        if (subscribeMsgSettingData != null && subscribeMsgSettingData.d()) {
            com.tencent.luggage.wxa.w3.d dVar4 = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
            dVar4.setPersistent(false);
            dVar4.setKey("preference_key_subscribe_msg");
            dVar4.setTitle(a(R.string.z57));
            dVar4.setSummary(subscribeMsgSettingData.e() ? a(R.string.z58, Integer.valueOf(subscribeMsgSettingData.c().size())) : a(R.string.z59));
            IPreferenceScreen iPreferenceScreen6 = this.mScreen;
            Intrinsics.checkNotNull(iPreferenceScreen6);
            iPreferenceScreen6.addPreference(dVar4);
        }
        if (com.tencent.luggage.wxa.rk.a.f139822a.a(userInfoUsageInfo)) {
            IPreferenceScreen iPreferenceScreen7 = this.mScreen;
            Intrinsics.checkNotNull(iPreferenceScreen7);
            iPreferenceScreen7.addPreference(new com.tencent.luggage.wxa.nq.b(this.mOverrideContext));
            com.tencent.luggage.wxa.w3.d dVar5 = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
            dVar5.setPersistent(false);
            dVar5.setKey("preference_key_user_info");
            dVar5.setTitle(a(R.string.z2g));
            IPreferenceScreen iPreferenceScreen8 = this.mScreen;
            Intrinsics.checkNotNull(iPreferenceScreen8);
            iPreferenceScreen8.addPreference(dVar5);
        }
        IPreferenceScreen iPreferenceScreen9 = this.mScreen;
        Intrinsics.checkNotNull(iPreferenceScreen9);
        iPreferenceScreen9.addPreference(new com.tencent.luggage.wxa.nq.b(this.mOverrideContext));
        com.tencent.luggage.wxa.w3.d dVar6 = new com.tencent.luggage.wxa.w3.d(this.mOverrideContext);
        dVar6.setPersistent(false);
        dVar6.setKey("preference_key_privacy_use_record");
        dVar6.setTitle(a(R.string.z4u));
        IPreferenceScreen iPreferenceScreen10 = this.mScreen;
        Intrinsics.checkNotNull(iPreferenceScreen10);
        iPreferenceScreen10.addPreference(dVar6);
        IPreferenceScreen iPreferenceScreen11 = this.mScreen;
        Intrinsics.checkNotNull(iPreferenceScreen11);
        iPreferenceScreen11.notifyDataSetChanged();
    }

    public final void a(IPreferenceScreen preferenceScreen) {
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        this.mScreen = preferenceScreen;
    }

    public final void a(List items, com.tencent.luggage.wxa.g5.c subscribeMsgSettingData, fi userInfoUsageInfo) {
        if (this.getAuthItemDone && this.getSubscribeMsgInfoDone) {
            b(items, subscribeMsgSettingData, userInfoUsageInfo);
        }
    }

    public final boolean d(List authItems) {
        boolean equals;
        Iterator it = authItems.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            if (!w0.c(sVar.f128643d)) {
                equals = StringsKt__StringsJVMKt.equals(sVar.f128643d, "scope.userFuzzyLocation", true);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: g, reason: from getter */
    public final com.tencent.luggage.wxa.hn.s getMAuthItemBluetooth() {
        return this.mAuthItemBluetooth;
    }

    public final void e() {
        if (this.mAuthItemLocation == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "create AuthItemLocation");
            com.tencent.luggage.wxa.hn.s sVar = new com.tencent.luggage.wxa.hn.s();
            sVar.f128645f = 2;
            sVar.f128643d = AuthorizeCenter.SCOPE_USER_LOCATION;
            sVar.f128644e = a(R.string.z_5);
            this.mAuthItemLocation = sVar;
            List list = this.mAuthItemList;
            Intrinsics.checkNotNull(sVar);
            list.add(sVar);
        }
    }

    public final void g(int state) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "updateLocationAuthState, state:%d", Integer.valueOf(state));
        e();
        d();
        if (state == 1) {
            com.tencent.luggage.wxa.hn.s sVar = this.mAuthItemLocation;
            if (sVar != null) {
                sVar.f128645f = 1;
            }
            com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemLocationBackground;
            if (sVar2 != null) {
                sVar2.f128645f = 2;
            }
        } else if (state != 2) {
            com.tencent.luggage.wxa.hn.s sVar3 = this.mAuthItemLocation;
            if (sVar3 != null) {
                sVar3.f128645f = 2;
            }
            com.tencent.luggage.wxa.hn.s sVar4 = this.mAuthItemLocationBackground;
            if (sVar4 != null) {
                sVar4.f128645f = 2;
            }
        } else {
            com.tencent.luggage.wxa.hn.s sVar5 = this.mAuthItemLocationBackground;
            if (sVar5 != null) {
                sVar5.f128645f = 1;
            }
            com.tencent.luggage.wxa.hn.s sVar6 = this.mAuthItemLocation;
            if (sVar6 != null) {
                sVar6.f128645f = 1;
            }
        }
        a(state == 1, state == 0, state == 2);
    }

    public final void a(me response) {
        LinkedList linkedList = response.f128208f;
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        Iterator it = response.f128208f.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s authItem = (com.tencent.luggage.wxa.hn.s) it.next();
            if (Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, authItem.f128643d)) {
                int size = this.mAuthItemList.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = -1;
                        break;
                    } else if (Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, ((com.tencent.luggage.wxa.hn.s) this.mAuthItemList.get(i3)).f128643d)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    this.mAuthItemList.remove(i3);
                    List list = this.mAuthItemList;
                    Intrinsics.checkNotNullExpressionValue(authItem, "authItem");
                    list.add(i3, authItem);
                } else {
                    List list2 = this.mAuthItemList;
                    Intrinsics.checkNotNullExpressionValue(authItem, "authItem");
                    list2.add(authItem);
                }
                a(new m(authItem));
                return;
            }
        }
    }

    public final boolean e(List authItems) {
        Iterator it = authItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            String str = sVar.f128643d;
            if (!(str == null || str.length() == 0) && Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_LOCATION)) {
                return true;
            }
        }
    }

    public final void a(String userName) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        com.tencent.luggage.wxa.j5.a aVar = com.tencent.luggage.wxa.j5.a.f130859a;
        String str = this.mAppId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        aVar.a(userName, str, new g());
    }

    public final void a(boolean success, boolean enable, Preference pref, IPreferenceScreen preferenceScreen, com.tencent.luggage.wxa.hn.s r122) {
        com.tencent.luggage.wxa.tn.c0.a(new s(success, pref, enable, r122, preferenceScreen));
    }

    public final void a(c callback) {
        if (!h0.j(com.tencent.luggage.wxa.tn.z.c())) {
            Toast.makeText(this.mOverrideContext, a(R.string.f225736mf), 1).show();
            if (callback != null) {
                callback.a(false);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tn.c0.a(new t(callback));
    }

    public final void a(String appId, c callback) {
        LinkedList linkedList = new LinkedList();
        int o16 = o();
        int n3 = n();
        for (com.tencent.luggage.wxa.hn.s sVar : this.mAuthItemList) {
            if (sVar != null && (this.mResponseContainLocationBackground || !this.mShouldShowLocationBackground || !Intrinsics.areEqual(sVar.f128643d, "scope.userLocationBackground") || o16 == 2)) {
                if (this.mResponseContainBluetoothBackground || !this.mShouldShowBluetoothBackground || !Intrinsics.areEqual(sVar.f128643d, "scope.bluetoothBackground") || n3 == 2) {
                    u6 u6Var = new u6();
                    if (Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_INFO)) {
                        u6Var.f128825f = this.mSelectedUserInfoId;
                    }
                    u6Var.f128823d = sVar.f128643d;
                    u6Var.f128824e = sVar.f128645f;
                    linkedList.add(u6Var);
                }
            }
        }
        le leVar = new le();
        leVar.f128085e = appId;
        leVar.f128086f = linkedList;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp_modauth", appId, leVar, me.class).a(new v()).b(new w()).b(new x(callback)).a(new y(callback));
    }

    public final void b(int state) {
        int n3 = n();
        if (state != n3) {
            this.mKeyChange = true;
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "onClickBluetoothPreference, change bluetooth state to:%s", Integer.valueOf(state));
            e(state);
            a(new j(state, n3));
        }
    }

    public final void b(List authItems, com.tencent.luggage.wxa.g5.c subscribeMsgSettingData, fi userInfoUsageInfo) {
        String str = this.mAppId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        this.mShouldShowLocationBackground = b(str, authItems);
        String str3 = this.mAppId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
        } else {
            str2 = str3;
        }
        boolean a16 = a(str2, authItems);
        this.mShouldShowBluetoothBackground = a16;
        if (a(authItems, subscribeMsgSettingData, this.mShouldShowLocationBackground, a16, this.mUserInfoUsageInfo)) {
            return;
        }
        if (this.mShouldShowLocationBackground && (authItems.isEmpty() || !e(authItems))) {
            e();
            d();
        }
        if (this.mShouldShowBluetoothBackground && (authItems.isEmpty() || !b(authItems))) {
            b();
            a();
        }
        this.mUIAction.a(false);
        a(new a0(authItems, subscribeMsgSettingData, userInfoUsageInfo));
    }

    public static /* synthetic */ void a(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        bVar.b(z16);
    }

    public final int a(com.tencent.luggage.wxa.sb.d r36) {
        if (r36.n()) {
            return -1;
        }
        return (r36.e() != 1 && r36.e() == 0) ? 0 : 1;
    }

    public final void b() {
        if (this.mAuthItemBluetooth == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "create AuthItemBluetooth");
            com.tencent.luggage.wxa.hn.s sVar = new com.tencent.luggage.wxa.hn.s();
            this.mAuthItemBluetooth = sVar;
            Intrinsics.checkNotNull(sVar);
            sVar.f128645f = 2;
            com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemBluetooth;
            Intrinsics.checkNotNull(sVar2);
            sVar2.f128643d = "scope.bluetooth";
            com.tencent.luggage.wxa.hn.s sVar3 = this.mAuthItemBluetooth;
            Intrinsics.checkNotNull(sVar3);
            sVar3.f128644e = a(R.string.f170349yx0);
            List list = this.mAuthItemList;
            com.tencent.luggage.wxa.hn.s sVar4 = this.mAuthItemBluetooth;
            Intrinsics.checkNotNull(sVar4);
            list.add(sVar4);
        }
    }

    public final boolean a(IPreferenceScreen screen, Preference pref) {
        Intrinsics.checkNotNullParameter(pref, "pref");
        com.tencent.luggage.wxa.tn.w.a("Luggage.STANDALONE.WxaMainSettingLogicImpl", "onPreferenceTreeClick.(key : %s)", pref.getKey());
        if (this.mAuthItemList.isEmpty()) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.STANDALONE.WxaMainSettingLogicImpl", "mAuthItem empty");
            return false;
        }
        String key = pref.getKey();
        if (w0.c(key)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.STANDALONE.WxaMainSettingLogicImpl", "key is null");
            return false;
        }
        if (pref instanceof com.tencent.luggage.wxa.w3.e) {
            for (com.tencent.luggage.wxa.hn.s sVar : this.mAuthItemList) {
                if (Intrinsics.areEqual(key, w0.d(sVar.f128643d))) {
                    this.mKeyChange = true;
                    if (((com.tencent.luggage.wxa.w3.e) pref).isChecked()) {
                        sVar.f128645f = 1;
                        a(new n(pref, screen, sVar));
                    } else if (this.mFirstRun) {
                        this.mFirstRun = false;
                        p.a aVar = com.tencent.luggage.wxa.g6.p.f126564o;
                        Context mOverrideContext = this.mOverrideContext;
                        Intrinsics.checkNotNullExpressionValue(mOverrideContext, "mOverrideContext");
                        com.tencent.luggage.wxa.g6.p a16 = aVar.a(mOverrideContext);
                        Context mOverrideContext2 = this.mOverrideContext;
                        Intrinsics.checkNotNullExpressionValue(mOverrideContext2, "mOverrideContext");
                        com.tencent.luggage.wxa.g6.d e16 = a16.e(mOverrideContext2);
                        e16.a(a(R.string.ywr));
                        e16.c(a(R.string.ywq));
                        e16.b(new o(sVar, this, pref, screen));
                        e16.b(a(R.string.f170647xd));
                        e16.a(new p(sVar, pref, screen));
                        e16.a(new q(sVar, pref, screen));
                        e16.b(false);
                        e16.a();
                    } else {
                        this.mFirstRun = false;
                        sVar.f128645f = 2;
                        a(new r(pref, screen, sVar));
                    }
                }
            }
        }
        return false;
    }

    public final boolean b(String appId, List authItems) {
        if (d(authItems)) {
            return false;
        }
        if (com.tencent.luggage.wxa.uc.a.d(appId)) {
            return true;
        }
        return f(authItems);
    }

    public final boolean b(List authItems) {
        boolean equals;
        Iterator it = authItems.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            if (!w0.c(sVar.f128643d)) {
                equals = StringsKt__StringsJVMKt.equals(sVar.f128643d, "scope.bluetooth", true);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c() {
        if (this.mAuthItemFuzzyLocation == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "create AuthItemFuzzyLocation");
            com.tencent.luggage.wxa.hn.s sVar = new com.tencent.luggage.wxa.hn.s();
            sVar.f128645f = 2;
            sVar.f128643d = "scope.userFuzzyLocation";
            sVar.f128644e = a(R.string.z_5);
            this.mAuthItemFuzzyLocation = sVar;
            List list = this.mAuthItemList;
            Intrinsics.checkNotNull(sVar);
            list.add(sVar);
        }
    }

    public final void a(com.tencent.luggage.wxa.g5.c data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.luggage.wxa.j5.a aVar = com.tencent.luggage.wxa.j5.a.f130859a;
        String str = this.mUsername;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsername");
            str = null;
        }
        String str3 = this.mAppId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
        } else {
            str2 = str3;
        }
        aVar.a(str, str2, data, new z());
    }

    public final void a(com.tencent.luggage.wxa.w3.b preference, com.tencent.luggage.wxa.hn.s authItem) {
        mb mbVar;
        this.mUserInfoItem = authItem;
        if (authItem == null || (mbVar = authItem.f128646g) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(mbVar, "info.userAvatarInfo?: return");
        this.mSelectedUserInfoId = authItem.f128646g.f128197g;
        preference.a(com.tencent.luggage.wxa.kn.a.a(this.mOverrideContext, 40), com.tencent.luggage.wxa.kn.a.a(this.mOverrideContext, 40));
        preference.setPersistent(false);
        preference.setKey(authItem.f128643d);
        preference.setTitle(authItem.f128644e);
        mb mbVar2 = authItem.f128646g;
        Intrinsics.checkNotNullExpressionValue(mbVar2, "info.userAvatarInfo");
        this.mWxaUserInfoData = new com.tencent.luggage.wxa.g5.b(mbVar2);
        if (authItem.f128645f == 2) {
            preference.setSummary(R.string.f170352yx3);
            preference.a((Bitmap) null);
            preference.c(8);
            preference.b(8);
            return;
        }
        preference.setSummary("");
        preference.a(R.drawable.ojy);
        preference.c(0);
        preference.b(0);
        com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "userinfo default_avatar_id = " + authItem.f128646g.f128197g);
        Iterator it = authItem.f128646g.f128194d.iterator();
        while (it.hasNext()) {
            nb nbVar = (nb) it.next();
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "userinfo list avatar id = " + nbVar.f128290d);
            if (authItem.f128646g.f128197g == nbVar.f128290d) {
                AppBrandSimpleImageLoader.instance().load(new b0(preference), nbVar.f128292f, new c0(preference, this));
                return;
            }
        }
    }

    public final boolean c(List authItems) {
        boolean equals;
        Iterator it = authItems.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            if (!w0.c(sVar.f128643d)) {
                equals = StringsKt__StringsJVMKt.equals(sVar.f128643d, "scope.bluetoothBackground", true);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a() {
        if (this.mAuthItemBluetoothBackground == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.STANDALONE.WxaMainSettingLogicImpl", "create AuthItemBluetoothBackground");
            com.tencent.luggage.wxa.hn.s sVar = new com.tencent.luggage.wxa.hn.s();
            this.mAuthItemBluetoothBackground = sVar;
            Intrinsics.checkNotNull(sVar);
            sVar.f128645f = 2;
            com.tencent.luggage.wxa.hn.s sVar2 = this.mAuthItemBluetoothBackground;
            Intrinsics.checkNotNull(sVar2);
            sVar2.f128643d = "scope.bluetoothBackground";
            com.tencent.luggage.wxa.hn.s sVar3 = this.mAuthItemBluetoothBackground;
            Intrinsics.checkNotNull(sVar3);
            sVar3.f128644e = a(R.string.f170349yx0);
            List list = this.mAuthItemList;
            com.tencent.luggage.wxa.hn.s sVar4 = this.mAuthItemBluetoothBackground;
            Intrinsics.checkNotNull(sVar4);
            list.add(sVar4);
        }
    }

    public final void a(List authItemList) {
        Iterator it = authItemList.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (it.hasNext()) {
            com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
            String str = sVar.f128643d;
            if (!(str == null || str.length() == 0) && Intrinsics.areEqual(sVar.f128643d, AuthorizeCenter.SCOPE_USER_LOCATION)) {
                z16 = sVar.f128645f == 1;
            } else {
                String str2 = sVar.f128643d;
                if (!(str2 == null || str2.length() == 0) && Intrinsics.areEqual(sVar.f128643d, "scope.userLocationBackground")) {
                    i3 = sVar.f128645f == 1 ? 1 : 0;
                }
            }
        }
        this.mLocationAuthFlag = (z16 ? 2 : 0) | i3;
    }

    public final void a(boolean r26) {
        this.mUIAction.a(r26);
    }

    public final void a(boolean r36, boolean none, boolean r56) {
        SharedPreferences h16 = h();
        if (h16 != null) {
            SharedPreferences.Editor edit = h16.edit();
            edit.putBoolean(com.tencent.mobileqq.msf.core.net.r.a.f248963o, r36);
            edit.putBoolean("none", none);
            edit.putBoolean(MagicfaceDataPendantJason.BELONG_TO_BOTH, r56);
            edit.apply();
        }
    }

    public final boolean a(String appId, List authItems) {
        return com.tencent.luggage.wxa.uc.a.c(appId) || c(authItems);
    }

    public final void a(Function0 block) {
        this.mContainerAction.runOnUiThread(new u(block));
    }

    public final String a(int resId) {
        String string = this.mOverrideContext.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "mOverrideContext.getString(resId)");
        return string;
    }

    public final String a(int resId, Object... formatArgs) {
        String string = this.mOverrideContext.getString(resId, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "mOverrideContext.getString(resId, *formatArgs)");
        return string;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class f implements e {
        public abstract void a(int i3, String str, String str2, int i16, boolean z16);

        @Override // com.tencent.luggage.wxa.n5.b.e
        public void a(int i3, String str, int i16) {
        }
    }
}
