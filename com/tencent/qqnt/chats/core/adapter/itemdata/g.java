package com.tencent.qqnt.chats.core.adapter.itemdata;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.qqnt.chats.api.IQQStrangerLIAAdapterApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.j;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.k;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.l;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.m;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.n;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 d2\u00020\u0001:\t\u009f\u0001\u0015\u0013\u0014+\u000e5\u001aB\u00e4\u0001\u0012\u0006\u0010'\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\u001d\u0012\u0006\u00103\u001a\u00020\u0011\u0012\u0006\u0010:\u001a\u000204\u0012\b\b\u0002\u0010A\u001a\u00020;\u0012\b\b\u0002\u0010F\u001a\u00020\u0011\u0012\b\b\u0002\u0010N\u001a\u00020G\u0012\b\b\u0002\u0010U\u001a\u00020O\u0012\b\b\u0002\u0010]\u001a\u00020V\u0012\u0006\u0010c\u001a\u00020\u0007\u0012\u0006\u0010f\u001a\u00020\u0007\u0012\u0006\u0010k\u001a\u00020\u001d\u0012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010x\u001a\u00020\u0007\u0012\u0006\u0010{\u001a\u00020\u000f\u0012\u0006\u0010\u007f\u001a\u00020|\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u000f\u0012\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0007\u0012\u001f\b\u0002\u0010\u0086\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u0003j\u000b\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u0001`\u0005\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J$\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00052\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0000H\u0002J\u0006\u0010\u000e\u001a\u00020\u0000J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0006\u0010\u0016\u001a\u00020\u0007J\u001d\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018J\t\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u00d6\u0003R\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b(\u0010)R\u0017\u0010/\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00103\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000e\u00100\u001a\u0004\b1\u00102R\"\u0010:\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010F\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00100\u001a\u0004\bC\u00102\"\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010^\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR\"\u0010k\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010,\u001a\u0004\bh\u0010.\"\u0004\bi\u0010jR(\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR(\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00000\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010m\u001a\u0004\bt\u0010o\"\u0004\bu\u0010qR\"\u0010x\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010^\u001a\u0004\bx\u0010`\"\u0004\by\u0010bR\u0017\u0010{\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\bz\u0010)R\u0017\u0010\u007f\u001a\u00020|8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b}\u0010~R\u0018\u0010\u0080\u0001\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\bC\u0010\r\u001a\u0004\bW\u0010)R%\u0010\u0083\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bJ\u0010^\u001a\u0005\b\u0081\u0001\u0010`\"\u0005\b\u0082\u0001\u0010bR:\u0010\u0086\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u0003j\u000b\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u0001`\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b=\u0010m\u001a\u0004\bl\u0010o\"\u0005\b\u0085\u0001\u0010qR$\u0010\u0088\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bQ\u0010,\u001a\u0004\bg\u0010.\"\u0005\b\u0087\u0001\u0010jR#\u0010\u0089\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010^\u001a\u0004\b,\u0010`\"\u0004\b\u0017\u0010bR%\u0010\u008c\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0016\u0010^\u001a\u0005\b\u008a\u0001\u0010`\"\u0005\b\u008b\u0001\u0010bR6\u0010\u0092\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u001c\u0010\u008e\u0001\u001a\u0005\bB\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0006\u00a2\u0006\u000e\n\u0005\b\t\u0010\u0094\u0001\u001a\u0005\bs\u0010\u0095\u0001R,\u0010\u009b\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00040\u0097\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u0098\u00018\u0006\u00a2\u0006\u000e\n\u0005\b\u000b\u0010\u0099\u0001\u001a\u0005\bH\u0010\u009a\u0001R0\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010\u009c\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0017\n\u0005\b\n\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R)\u0010\u00a9\u0001\u001a\u00030\u00a4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008a\u0001\u0010\u00a5\u0001\u001a\u0005\bw\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0015\u0010\u00aa\u0001\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010.\u00a8\u0006\u00ad\u0001"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "newItem", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "t", "", "G", "B", "D", BdhLogUtil.LogTag.Tag_Conn, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "J", "f", "", "id", "", "toString", "c", "d", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "T", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "type", tl.h.F, "(Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "hashCode", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "setOriginData", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "originData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "contactId", "e", "I", DomainData.DOMAIN_NAME, "()I", "contactType", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "chatUid", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;", "g", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;", "K", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;)V", "avatarInfo", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;", "w", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;)V", "titleInfo", "i", "u", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/String;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", "j", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", "v", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", BdhLogUtil.LogTag.Tag_Req, "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;)V", "summaryInfo", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;", "setUnreadInfo", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;)V", "unreadInfo", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;", "l", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;", "y", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;", "U", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;)V", "vasInfo", "Z", "H", "()Z", "setTop", "(Z)V", "isTop", UserInfo.SEX_FEMALE, "setDraft", "isDraft", "o", "getSendStatus", "P", "(I)V", "sendStatus", "p", "Ljava/util/ArrayList;", "getNestSort", "()Ljava/util/ArrayList;", "setNestSort", "(Ljava/util/ArrayList;)V", "nestSort", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getNestContactInfo", "setNestContactInfo", "nestContactInfo", "r", "isMsgDisturb", "setMsgDisturb", "getShieldFlag", "shieldFlag", "", "getSpecialCareFlag", "()B", "specialCareFlag", "chatUin", "getNeedAlphaAnim", "setNeedAlphaAnim", "needAlphaAnim", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactExtAttr;", "setExtAttrs", "extAttrs", "N", "dtPageType", "isTroopGuild", "E", "M", "isDiscoveryGuild", "", "Ljava/util/Map;", "()Ljava/util/Map;", "L", "(Ljava/util/Map;)V", "businessMap", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "cachePayloads", "", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "Ljava/util/List;", "a", "()Ljava/util/List;", "O", "(Ljava/util/List;)V", "menuItems", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$d;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$d;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$d;", "setMutualMarkInfo", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$d;)V", "mutualMarkInfo", "itemViewType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;JILjava/lang/String;Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;Ljava/lang/String;Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;ZZILjava/util/ArrayList;Ljava/util/ArrayList;ZJBJZLjava/util/ArrayList;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class g implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private Map<LiteBusinessType, ? extends Object> businessMap;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final Bundle extra;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Object> cachePayloads;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.chats.core.adapter.menu.a> menuItems;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private d mutualMarkInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecentContactInfo originData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long contactId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int contactType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String chatUid;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a avatarInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f titleInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String showTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e summaryInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C9572g unreadInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h vasInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isTop;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isDraft;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int sendStatus;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Long> nestSort;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<g> nestContactInfo;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isMsgDisturb;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final long shieldFlag;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final byte specialCareFlag;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final long chatUin;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean needAlphaAnim;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<RecentContactExtAttr> extAttrs;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int dtPageType;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopGuild;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean isDiscoveryGuild;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$b;", "", "", "IS_FIRST_DATA", "Ljava/lang/String;", "IS_LITE_ACTION_FIRST_CLICK", "IS_LITE_ACTION_FIRST_IMP", "IS_LOCAL_CACHE_DATA", "IS_SNAP_SHOT_DATA", "IS_SUMMARY_NEED_HIGHLIGHT", "KEY_LITE_SUB_TYPE", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.g$b, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "d", "(J)V", "grayUnreadCnt", "", "b", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "e", "(Ljava/lang/CharSequence;)V", "msgSummary", "c", "I", "()I", "f", "(I)V", MessageRoamJsPlugin.USERTYPE, "<init>", "(JLjava/lang/CharSequence;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long grayUnreadCnt;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CharSequence msgSummary;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int userType;

        public c() {
            this(0L, null, 3, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return;
            }
            iPatchRedirector.redirect((short) 15, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.grayUnreadCnt;
        }

        @NotNull
        public final CharSequence b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.msgSummary;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.userType;
        }

        public final void d(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.grayUnreadCnt = j3;
            }
        }

        public final void e(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
            } else {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.msgSummary = charSequence;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.grayUnreadCnt == cVar.grayUnreadCnt && Intrinsics.areEqual(this.msgSummary, cVar.msgSummary)) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.userType = i3;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return (androidx.fragment.app.a.a(this.grayUnreadCnt) * 31) + this.msgSummary.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "GuildSummaryInfoExt(grayUnreadCnt=" + this.grayUnreadCnt + ", msgSummary=" + ((Object) this.msgSummary) + ")";
        }

        public c(long j3, @NotNull CharSequence msgSummary) {
            Intrinsics.checkNotNullParameter(msgSummary, "msgSummary");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), msgSummary);
            } else {
                this.grayUnreadCnt = j3;
                this.msgSummary = msgSummary;
            }
        }

        public /* synthetic */ c(long j3, CharSequence charSequence, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : charSequence);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), charSequence, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012 \b\u0002\u0010\u0011\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R:\u0010\u0011\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getDisplayIcons", "()Ljava/util/ArrayList;", "(Ljava/util/ArrayList;)V", "displayIcons", "<init>", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<Drawable> displayIcons;

        public d() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final void a(@Nullable ArrayList<Drawable> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
            } else {
                this.displayIcons = arrayList;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof d) && Intrinsics.areEqual(this.displayIcons, ((d) other).displayIcons)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            ArrayList<Drawable> arrayList = this.displayIcons;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "MutualMarkInfo(displayIcons=" + this.displayIcons + ")";
        }

        public d(@Nullable ArrayList<Drawable> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.displayIcons = arrayList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList);
            }
        }

        public /* synthetic */ d(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : arrayList);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, arrayList, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0007B\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0000J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00100\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010,\u001a\u0004\b%\u0010-\"\u0004\b.\u0010/R$\u00106\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00102\u001a\u0004\b\u001e\u00103\"\u0004\b4\u00105\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", "", "", "c1", "c2", "", "b", "a", "other", "equals", "", "hashCode", "summary", "", "o", "", "toString", "Ljava/lang/CharSequence;", "f", "()Ljava/lang/CharSequence;", "l", "(Ljava/lang/CharSequence;)V", "msgSummary", "I", tl.h.F, "()I", DomainData.DOMAIN_NAME, "(I)V", "state", "Lcom/tencent/qqnt/chats/biz/summary/msg/a;", "c", "Lcom/tencent/qqnt/chats/biz/summary/msg/a;", "g", "()Lcom/tencent/qqnt/chats/biz/summary/msg/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/chats/biz/summary/msg/a;)V", "originSummary", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "highLightInfo", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "j", "(Ljava/lang/Integer;)V", "highLightColor", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$c;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$c;", "i", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$c;)V", "guildSummaryInfoExt", "<init>", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class e {
        static IPatchRedirector $redirector_;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CharSequence msgSummary;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int state;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.chats.biz.summary.msg.a originSummary;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String highLightInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer highLightColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c guildSummaryInfoExt;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e$a;", "", "", "STATUS_AUDIO_TALK", "I", "STATUS_AVGAME", "STATUS_AV_OTHER_TER_CHATING", "STATUS_DEFAULT", "STATUS_DRAFT", "STATUS_LISTEN_TOGETHER", "STATUS_MULTITALK_JOUIN", "STATUS_MULTITALK_JOUIN_VIDEO", "STATUS_MUTILTALK_NOTJOUIN", "STATUS_MUTILTALK_NOTJOUIN_VIDEO", "STATUS_PLAY_GAME_TOGETHER", "STATUS_SHARE_LOCATION", "STATUS_SING_TOGETHER", "STATUS_STUDY_ROOM", "STATUS_WATCH_TOGETHER", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.g$e$a, reason: from kotlin metadata */
        /* loaded from: classes24.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42510);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 23)) {
                redirector.redirect((short) 23);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public e() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return;
            }
            iPatchRedirector.redirect((short) 22, (Object) this);
        }

        private final boolean b(CharSequence c16, CharSequence c26) {
            if (c16 == c26) {
                return true;
            }
            if (c16.length() != c26.length()) {
                return false;
            }
            int length = c16.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (c16.charAt(i3) != c26.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public final e a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (e) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            e eVar = new e(this.msgSummary);
            eVar.state = this.state;
            eVar.highLightInfo = this.highLightInfo;
            eVar.highLightColor = this.highLightColor;
            eVar.guildSummaryInfoExt = this.guildSummaryInfoExt;
            eVar.originSummary = this.originSummary;
            return eVar;
        }

        @Nullable
        public final c c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (c) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.guildSummaryInfoExt;
        }

        @Nullable
        public final Integer d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Integer) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.highLightColor;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.highLightInfo;
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(e.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem.SummaryInfo");
            e eVar = (e) other;
            if (b(this.msgSummary, eVar.msgSummary) && this.state == eVar.state && Intrinsics.areEqual(this.highLightInfo, eVar.highLightInfo) && Intrinsics.areEqual(this.highLightColor, eVar.highLightColor) && Intrinsics.areEqual(this.guildSummaryInfoExt, eVar.guildSummaryInfoExt)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final CharSequence f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgSummary;
        }

        @Nullable
        public final com.tencent.qqnt.chats.biz.summary.msg.a g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.qqnt.chats.biz.summary.msg.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.originSummary;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.state;
        }

        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            int hashCode = ((this.msgSummary.hashCode() * 31) + this.state) * 31;
            String str = this.highLightInfo;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 31;
            Integer num = this.highLightColor;
            if (num != null) {
                i16 = num.intValue();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            c cVar = this.guildSummaryInfoExt;
            if (cVar != null) {
                i17 = cVar.hashCode();
            }
            return i19 + i17;
        }

        public final void i(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) cVar);
            } else {
                this.guildSummaryInfoExt = cVar;
            }
        }

        public final void j(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) num);
            } else {
                this.highLightColor = num;
            }
        }

        public final void k(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.highLightInfo = str;
            }
        }

        public final void l(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence);
            } else {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.msgSummary = charSequence;
            }
        }

        public final void m(@Nullable com.tencent.qqnt.chats.biz.summary.msg.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            } else {
                this.originSummary = aVar;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.state = i3;
            }
        }

        public final void o(@NotNull CharSequence summary) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) summary);
                return;
            }
            Intrinsics.checkNotNullParameter(summary, "summary");
            this.msgSummary = summary;
            if (this.originSummary == null) {
                this.originSummary = new com.tencent.qqnt.chats.biz.summary.msg.a();
            }
            com.tencent.qqnt.chats.biz.summary.msg.a aVar = this.originSummary;
            if (aVar != null) {
                aVar.f354410d = summary;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (String) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return "SummaryInfo(msgSummary=" + ((Object) this.msgSummary) + ")";
        }

        public e(@NotNull CharSequence msgSummary) {
            Intrinsics.checkNotNullParameter(msgSummary, "msgSummary");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgSummary);
            } else {
                this.msgSummary = msgSummary;
                this.highLightInfo = "";
            }
        }

        public /* synthetic */ e(CharSequence charSequence, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : charSequence);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u000eJ\u0006\u0010\u0002\u001a\u00020\u0000J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$f;", "", "a", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "title", "b", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", "leftIconResId", "d", tl.h.F, "rightIconResId", "f", "extraInfo", "<init>", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer leftIconResId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer rightIconResId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String extraInfo;

        public f() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return;
            }
            iPatchRedirector.redirect((short) 17, (Object) this);
        }

        @NotNull
        public final f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (f) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            f fVar = new f(this.title);
            fVar.leftIconResId = this.leftIconResId;
            fVar.rightIconResId = this.rightIconResId;
            fVar.extraInfo = this.extraInfo;
            return fVar;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.extraInfo;
        }

        @Nullable
        public final Integer c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Integer) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.leftIconResId;
        }

        @Nullable
        public final Integer d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Integer) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.rightIconResId;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(f.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem.TitleInfo");
            f fVar = (f) other;
            if (Intrinsics.areEqual(this.title, fVar.title) && Intrinsics.areEqual(this.leftIconResId, fVar.leftIconResId) && Intrinsics.areEqual(this.extraInfo, fVar.extraInfo)) {
                return true;
            }
            return false;
        }

        public final void f(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            } else {
                this.extraInfo = str;
            }
        }

        public final void g(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) num);
            } else {
                this.leftIconResId = num;
            }
        }

        public final void h(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) num);
            } else {
                this.rightIconResId = num;
            }
        }

        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            int hashCode = this.title.hashCode() * 31;
            Integer num = this.leftIconResId;
            int i17 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 31;
            Integer num2 = this.rightIconResId;
            if (num2 != null) {
                i16 = num2.intValue();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            String str = this.extraInfo;
            if (str != null) {
                i17 = str.hashCode();
            }
            return i19 + i17;
        }

        public final void i(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "TitleInfo(title=" + this.title + ")";
        }

        public f(@NotNull String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.title = title;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) title);
            }
        }

        public /* synthetic */ f(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0002B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "c", "()I", "e", "(I)V", "type", "", "b", "J", "()J", "d", "(J)V", "count", "<init>", "(IJ)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.g$g, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final /* data */ class C9572g {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long count;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g$a;", "", "", "TYPE_DOT_RED", "I", "TYPE_NUM_GARY", "TYPE_NUM_RED", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.g$g$a, reason: from kotlin metadata */
        /* loaded from: classes24.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42522);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 15)) {
                redirector.redirect((short) 15);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public C9572g() {
            this(0, 0L, 3, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this);
        }

        @NotNull
        public final C9572g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C9572g) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new C9572g(this.type, this.count);
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.count;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }

        public final void d(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else {
                this.count = j3;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.type = i3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9572g)) {
                return false;
            }
            C9572g c9572g = (C9572g) other;
            if (this.type == c9572g.type && this.count == c9572g.count) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (this.type * 31) + androidx.fragment.app.a.a(this.count);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "UnreadInfo(type=" + this.type + ", count=" + this.count + ")";
        }

        public C9572g(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                this.type = i3;
                this.count = j3;
            }
        }

        public /* synthetic */ C9572g(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? 0L : j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0000R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\"\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\"\u00100\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\u000f\u00105\"\u0004\b6\u00107R6\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u000202\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010;\u001a\u0004\b!\u0010<\"\u0004\b=\u0010>R0\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u00104\u001a\u0004\b\u001d\u00105\"\u0004\b@\u00107R0\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\bB\u00105\"\u0004\bC\u00107R6\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u000202\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010;\u001a\u0004\b3\u0010<\"\u0004\bE\u0010>\u00a8\u0006I"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$h;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "other", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", "newInfo", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "r", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "y", "(Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;)V", "namePlate", "", "b", "I", "()I", "v", "(I)V", "loveChatId", "c", "getColorNameId", "t", "colorNameId", "d", "Z", "getCanShowRedColorName", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "canShowRedColorName", "i", "D", "vipPendantId", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "themePendantId", "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "unreadBubbleId", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "u", "(Lkotlin/jvm/functions/Function1;)V", "loveChatBackgroundInvoke", "Lkotlin/Function2;", "", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", HippyTKDListViewAdapter.X, "(Lkotlin/jvm/functions/Function2;)V", "loveChatUnreadInvoke", "w", "loveChatPendantInvoke", "getVasPendantInvoke", BdhLogUtil.LogTag.Tag_Conn, "vasPendantInvoke", "B", "unreadBubbleInvoke", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private VASPersonalNamePlate namePlate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int loveChatId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int colorNameId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean canShowRedColorName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int vipPendantId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int themePendantId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int unreadBubbleId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Integer, ? extends Drawable> loveChatBackgroundInvoke;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function2<? super Integer, ? super Long, ? extends Drawable> loveChatUnreadInvoke;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Integer, ? extends Drawable> loveChatPendantInvoke;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<? super Integer, ? extends Drawable> vasPendantInvoke;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function2<? super Integer, ? super Long, ? extends Drawable> unreadBubbleInvoke;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.namePlate = new VASPersonalNamePlate();
                this.canShowRedColorName = true;
            }
        }

        private final boolean m(VASPersonalNamePlate vASPersonalNamePlate, VASPersonalNamePlate vASPersonalNamePlate2) {
            if (Intrinsics.areEqual(vASPersonalNamePlate.isGray, vASPersonalNamePlate2.isGray) && Intrinsics.areEqual(vASPersonalNamePlate.vipType, vASPersonalNamePlate2.vipType) && Intrinsics.areEqual(vASPersonalNamePlate.vipLevel, vASPersonalNamePlate2.vipLevel) && Intrinsics.areEqual(vASPersonalNamePlate.namePlateId, vASPersonalNamePlate2.namePlateId) && vASPersonalNamePlate.carouselNamePlateIds.equals(vASPersonalNamePlate2.carouselNamePlateIds) && Intrinsics.areEqual(vASPersonalNamePlate.diyNamePlateItemId, vASPersonalNamePlate2.diyNamePlateItemId) && vASPersonalNamePlate.diyNamePlateContentIds.equals(vASPersonalNamePlate2.diyNamePlateContentIds) && Intrinsics.areEqual(vASPersonalNamePlate.extendNamePlateId, vASPersonalNamePlate2.extendNamePlateId) && Intrinsics.areEqual(vASPersonalNamePlate.gameNamePlateId, vASPersonalNamePlate2.gameNamePlateId)) {
                return true;
            }
            return false;
        }

        public final void A(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, i3);
            } else {
                this.unreadBubbleId = i3;
            }
        }

        public final void B(@Nullable Function2<? super Integer, ? super Long, ? extends Drawable> function2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, (Object) function2);
            } else {
                this.unreadBubbleInvoke = function2;
            }
        }

        public final void C(@Nullable Function1<? super Integer, ? extends Drawable> function1) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) function1);
            } else {
                this.vasPendantInvoke = function1;
            }
        }

        public final void D(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.vipPendantId = i3;
            }
        }

        @Nullable
        public final Function1<Integer, Drawable> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Function1) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.loveChatBackgroundInvoke;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.loveChatId;
        }

        @Nullable
        public final Function1<Integer, Drawable> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Function1) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return this.loveChatPendantInvoke;
        }

        @Nullable
        public final Function2<Integer, Long, Drawable> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Function2) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return this.loveChatUnreadInvoke;
        }

        @NotNull
        public final VASPersonalNamePlate e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (VASPersonalNamePlate) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.namePlate;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.themePendantId;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.unreadBubbleId;
        }

        @Nullable
        public final Function2<Integer, Long, Drawable> h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (Function2) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return this.unreadBubbleInvoke;
        }

        public final int i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.vipPendantId;
        }

        public final boolean j(@NotNull h newInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) newInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            if (this.colorNameId == newInfo.colorNameId && this.canShowRedColorName == newInfo.canShowRedColorName) {
                return false;
            }
            return true;
        }

        public final boolean k(@NotNull h newInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) newInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            if (this.loveChatId != newInfo.loveChatId) {
                return true;
            }
            return false;
        }

        public final boolean l(@NotNull h newInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) newInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            if (this.vipPendantId == newInfo.vipPendantId && this.themePendantId == newInfo.themePendantId) {
                return false;
            }
            return true;
        }

        public final boolean n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
            }
            if (this.loveChatId > 0) {
                return true;
            }
            return false;
        }

        public final boolean o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
            }
            if (this.vipPendantId <= 0 && this.themePendantId <= 0) {
                return false;
            }
            return true;
        }

        public final boolean p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
            }
            if (this.unreadBubbleId > 0) {
                return true;
            }
            return false;
        }

        public final boolean q(@NotNull h newInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) newInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            if (this.unreadBubbleId != newInfo.unreadBubbleId) {
                return true;
            }
            return false;
        }

        public final boolean r(@NotNull h newInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) newInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            return !m(this.namePlate, newInfo.namePlate);
        }

        public final void s(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.canShowRedColorName = z16;
            }
        }

        public final void t(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.colorNameId = i3;
            }
        }

        public final void u(@Nullable Function1<? super Integer, ? extends Drawable> function1) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) function1);
            } else {
                this.loveChatBackgroundInvoke = function1;
            }
        }

        public final void v(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.loveChatId = i3;
            }
        }

        public final void w(@Nullable Function1<? super Integer, ? extends Drawable> function1) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) function1);
            } else {
                this.loveChatPendantInvoke = function1;
            }
        }

        public final void x(@Nullable Function2<? super Integer, ? super Long, ? extends Drawable> function2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) function2);
            } else {
                this.loveChatUnreadInvoke = function2;
            }
        }

        public final void y(@NotNull VASPersonalNamePlate vASPersonalNamePlate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) vASPersonalNamePlate);
            } else {
                Intrinsics.checkNotNullParameter(vASPersonalNamePlate, "<set-?>");
                this.namePlate = vASPersonalNamePlate;
            }
        }

        public final void z(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, i3);
            } else {
                this.themePendantId = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 90)) {
            redirector.redirect((short) 90);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull RecentContactInfo originData, long j3, int i3, @NotNull String chatUid, @NotNull a avatarInfo, @NotNull f titleInfo, @NotNull String showTime, @NotNull e summaryInfo, @NotNull C9572g unreadInfo, @NotNull h vasInfo, boolean z16, boolean z17, int i16, @NotNull ArrayList<Long> nestSort, @NotNull ArrayList<g> nestContactInfo, boolean z18, long j16, byte b16, long j17, boolean z19, @Nullable ArrayList<RecentContactExtAttr> arrayList) {
        List<com.tencent.qqnt.chats.core.adapter.menu.a> emptyList;
        Intrinsics.checkNotNullParameter(originData, "originData");
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        Intrinsics.checkNotNullParameter(showTime, "showTime");
        Intrinsics.checkNotNullParameter(summaryInfo, "summaryInfo");
        Intrinsics.checkNotNullParameter(unreadInfo, "unreadInfo");
        Intrinsics.checkNotNullParameter(vasInfo, "vasInfo");
        Intrinsics.checkNotNullParameter(nestSort, "nestSort");
        Intrinsics.checkNotNullParameter(nestContactInfo, "nestContactInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, originData, Long.valueOf(j3), Integer.valueOf(i3), chatUid, avatarInfo, titleInfo, showTime, summaryInfo, unreadInfo, vasInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), nestSort, nestContactInfo, Boolean.valueOf(z18), Long.valueOf(j16), Byte.valueOf(b16), Long.valueOf(j17), Boolean.valueOf(z19), arrayList);
            return;
        }
        this.originData = originData;
        this.contactId = j3;
        this.contactType = i3;
        this.chatUid = chatUid;
        this.avatarInfo = avatarInfo;
        this.titleInfo = titleInfo;
        this.showTime = showTime;
        this.summaryInfo = summaryInfo;
        this.unreadInfo = unreadInfo;
        this.vasInfo = vasInfo;
        this.isTop = z16;
        this.isDraft = z17;
        this.sendStatus = i16;
        this.nestSort = nestSort;
        this.nestContactInfo = nestContactInfo;
        this.isMsgDisturb = z18;
        this.shieldFlag = j16;
        this.specialCareFlag = b16;
        this.chatUin = j17;
        this.needAlphaAnim = z19;
        this.extAttrs = arrayList;
        this.dtPageType = -1;
        this.extra = new Bundle();
        this.cachePayloads = new HashSet<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.menuItems = emptyList;
        this.mutualMarkInfo = new d(null, i17, 0 == true ? 1 : 0);
    }

    private final boolean B(g newItem) {
        LiteBusinessType liteBusinessType = LiteBusinessType.KREVEAL;
        com.tencent.qqnt.chats.biz.bean.b bVar = (com.tencent.qqnt.chats.biz.bean.b) h(liteBusinessType);
        com.tencent.qqnt.chats.biz.bean.b bVar2 = (com.tencent.qqnt.chats.biz.bean.b) newItem.h(liteBusinessType);
        if (bVar == null && bVar2 == null) {
            return false;
        }
        if (bVar == null || bVar2 == null) {
            return true;
        }
        if (bVar.b() == bVar2.b() && bVar2.a() == bVar.a() && Intrinsics.areEqual(bVar2.c(), bVar.c())) {
            return false;
        }
        return true;
    }

    private final boolean C(g newItem) {
        LiteBusinessType liteBusinessType = LiteBusinessType.KONLINESTATUS;
        com.tencent.qqnt.chats.biz.bean.a aVar = (com.tencent.qqnt.chats.biz.bean.a) h(liteBusinessType);
        com.tencent.qqnt.chats.biz.bean.a aVar2 = (com.tencent.qqnt.chats.biz.bean.a) newItem.h(liteBusinessType);
        if (aVar == null && aVar2 == null) {
            return false;
        }
        if (aVar != null && aVar2 != null && aVar.a() == aVar2.a()) {
            return false;
        }
        return true;
    }

    private final boolean D(g newItem) {
        LiteBusinessType liteBusinessType = LiteBusinessType.KLIGHTRINGREVEAL;
        com.tencent.qqnt.chats.biz.bean.c cVar = (com.tencent.qqnt.chats.biz.bean.c) h(liteBusinessType);
        com.tencent.qqnt.chats.biz.bean.c cVar2 = (com.tencent.qqnt.chats.biz.bean.c) newItem.h(liteBusinessType);
        if (cVar == null && cVar2 == null) {
            return false;
        }
        if (cVar == null || cVar2 == null) {
            return true;
        }
        if (cVar.c() == cVar2.c() && cVar2.a() == cVar.a() && Intrinsics.areEqual(cVar2.d(), cVar.d()) && Intrinsics.areEqual(cVar2.b(), cVar.b())) {
            return false;
        }
        return true;
    }

    private final boolean G(g newItem) {
        LiteBusinessType liteBusinessType = LiteBusinessType.KLITEACTION;
        if (newItem.A(liteBusinessType) != A(liteBusinessType)) {
            return true;
        }
        return false;
    }

    private final boolean J(g item) {
        int i3 = item.contactType;
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    private final ArrayList<Object> t(g newItem) {
        boolean z16;
        ArrayList<Object> arrayList = new ArrayList<>();
        if (!newItem.cachePayloads.isEmpty()) {
            arrayList.addAll(newItem.cachePayloads);
            newItem.cachePayloads.clear();
        }
        if (!Intrinsics.areEqual(this.showTime, newItem.showTime)) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.i.f354600a);
        }
        boolean z17 = false;
        if (this.unreadInfo.b() == newItem.unreadInfo.b() && this.unreadInfo.c() == newItem.unreadInfo.c() && this.isMsgDisturb == newItem.isMsgDisturb) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!Intrinsics.areEqual(this.summaryInfo, newItem.summaryInfo) || G(newItem) || z16) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.h.f354599a);
        }
        boolean k3 = this.vasInfo.k(newItem.vasInfo);
        if (this.contactType == 16 && ex3.a.k(this.originData) != ex3.a.k(newItem.originData)) {
            z17 = true;
        }
        if (this.unreadInfo.b() != newItem.unreadInfo.b() || this.unreadInfo.c() != newItem.unreadInfo.c() || this.originData.unreadFlag != newItem.originData.unreadFlag || k3 || this.vasInfo.q(newItem.vasInfo) || z17) {
            arrayList.add(m.f354604a);
            if (this.unreadInfo.b() == 0 || newItem.unreadInfo.b() == 0) {
                arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.e.f354596a);
            }
        }
        if (this.isTop != newItem.isTop || k3) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.b.f354593a);
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.e.f354596a);
        }
        if (k3 || this.vasInfo.l(newItem.vasInfo)) {
            newItem.avatarInfo.j(true);
        }
        if (!Intrinsics.areEqual(this.titleInfo, newItem.titleInfo) || !Intrinsics.areEqual(this.titleInfo.d(), newItem.titleInfo.d()) || !Intrinsics.areEqual(this.mutualMarkInfo, newItem.mutualMarkInfo) || this.vasInfo.r(newItem.vasInfo) || this.vasInfo.j(newItem.vasInfo)) {
            arrayList.add(j.f354601a);
        }
        if (!Intrinsics.areEqual(this.avatarInfo, newItem.avatarInfo) || this.chatUin != newItem.chatUin || !Intrinsics.areEqual(this.chatUid, newItem.chatUid) || k3 || this.vasInfo.l(newItem.vasInfo) || newItem.avatarInfo.c() || B(newItem) || D(newItem) || C(newItem)) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.a.f354592a);
        }
        if (J(newItem)) {
            arrayList.add(n.f354605a);
        }
        if (this.isTop != newItem.isTop) {
            arrayList.add(k.f354602a);
        }
        if (newItem.contactType == 104 && this.contactType == 104 && ((IQQStrangerLIAAdapterApi) QRoute.api(IQQStrangerLIAAdapterApi.class)).needAddLIAPayload(newItem, this)) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.g.f354598a);
        }
        GuildContactInfo guildContactInfo = newItem.originData.guildContactInfo;
        GuildContactInfo guildContactInfo2 = this.originData.guildContactInfo;
        if (guildContactInfo != null && guildContactInfo2 != null && !guildContactInfo.hasUnreadModuleIds.equals(guildContactInfo2.hasUnreadModuleIds)) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.d.f354595a);
        }
        return arrayList;
    }

    public final boolean A(@NotNull LiteBusinessType type) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this, (Object) type)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Map<LiteBusinessType, ? extends Object> map = this.businessMap;
        if (map != null) {
            obj = map.get(type);
        } else {
            obj = null;
        }
        if (obj != null && !Intrinsics.areEqual(obj.getClass(), Object.class)) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        return this.isDiscoveryGuild;
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isDraft;
    }

    public final boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.isTop;
    }

    public final boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return this.isTroopGuild;
    }

    public final void K(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.avatarInfo = aVar;
        }
    }

    public final void L(@Nullable Map<LiteBusinessType, ? extends Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) map);
        } else {
            this.businessMap = map;
        }
    }

    public final void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
        } else {
            this.isDiscoveryGuild = z16;
        }
    }

    public final void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.dtPageType = i3;
        }
    }

    public void O(@NotNull List<com.tencent.qqnt.chats.core.adapter.menu.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.menuItems = list;
        }
    }

    public final void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.sendStatus = i3;
        }
    }

    public final void Q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.showTime = str;
        }
    }

    public final void R(@NotNull e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        } else {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.summaryInfo = eVar;
        }
    }

    public final void S(@NotNull f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fVar);
        } else {
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            this.titleInfo = fVar;
        }
    }

    public final void T(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
        } else {
            this.isTroopGuild = z16;
        }
    }

    public final void U(@NotNull h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) hVar);
        } else {
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            this.vasInfo = hVar;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @NotNull
    public List<com.tencent.qqnt.chats.core.adapter.menu.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (List) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.menuItems;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @Nullable
    public Object b(@NotNull b newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return iPatchRedirector.redirect((short) 59, (Object) this, (Object) newItem);
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof g)) {
            return null;
        }
        g gVar = (g) newItem;
        if (gVar.cachePayloads.contains(l.f354603a)) {
            gVar.cachePayloads.clear();
            return null;
        }
        return t(gVar);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean c(@NotNull b newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof g) || this.contactId != ((g) newItem).contactId || this.extra.getBoolean("is_first_data", false) || this.extra.getBoolean("is_local_cache_data", false)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean d(@NotNull b newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof g)) {
            return false;
        }
        g gVar = (g) newItem;
        if (!gVar.cachePayloads.isEmpty()) {
            return false;
        }
        if (this != newItem && !t(gVar).isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return 2;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Boolean) iPatchRedirector.redirect((short) 89, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.originData, gVar.originData) && this.contactId == gVar.contactId && this.contactType == gVar.contactType && Intrinsics.areEqual(this.chatUid, gVar.chatUid) && Intrinsics.areEqual(this.avatarInfo, gVar.avatarInfo) && Intrinsics.areEqual(this.titleInfo, gVar.titleInfo) && Intrinsics.areEqual(this.showTime, gVar.showTime) && Intrinsics.areEqual(this.summaryInfo, gVar.summaryInfo) && Intrinsics.areEqual(this.unreadInfo, gVar.unreadInfo) && Intrinsics.areEqual(this.vasInfo, gVar.vasInfo) && this.isTop == gVar.isTop && this.isDraft == gVar.isDraft && this.sendStatus == gVar.sendStatus && Intrinsics.areEqual(this.nestSort, gVar.nestSort) && Intrinsics.areEqual(this.nestContactInfo, gVar.nestContactInfo) && this.isMsgDisturb == gVar.isMsgDisturb && this.shieldFlag == gVar.shieldFlag && this.specialCareFlag == gVar.specialCareFlag && this.chatUin == gVar.chatUin && this.needAlphaAnim == gVar.needAlphaAnim && Intrinsics.areEqual(this.extAttrs, gVar.extAttrs)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final g f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (g) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        g gVar = new g(this.originData, this.contactId, this.contactType, this.chatUid, this.avatarInfo.a(), this.titleInfo.a(), this.showTime, this.summaryInfo.a(), this.unreadInfo.a(), this.vasInfo, this.isTop, this.isDraft, this.sendStatus, this.nestSort, this.nestContactInfo, this.isMsgDisturb, this.shieldFlag, this.specialCareFlag, this.chatUin, this.needAlphaAnim, this.extAttrs);
        gVar.O(a());
        gVar.mutualMarkInfo = this.mutualMarkInfo;
        gVar.isTroopGuild = this.isTroopGuild;
        gVar.isDiscoveryGuild = this.isDiscoveryGuild;
        gVar.businessMap = this.businessMap;
        gVar.dtPageType = this.dtPageType;
        this.extra.putAll(gVar.extra);
        return gVar;
    }

    @NotNull
    public final a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.avatarInfo;
    }

    @Nullable
    public final <T> T h(@NotNull LiteBusinessType type) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (T) iPatchRedirector.redirect((short) 61, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            Map<LiteBusinessType, ? extends Object> map = this.businessMap;
            if (map != null) {
                obj = map.get(type);
            } else {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            return (T) obj;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Integer) iPatchRedirector.redirect((short) 88, (Object) this)).intValue();
        }
        int hashCode2 = ((((((((((((((((((this.originData.hashCode() * 31) + androidx.fragment.app.a.a(this.contactId)) * 31) + this.contactType) * 31) + this.chatUid.hashCode()) * 31) + this.avatarInfo.hashCode()) * 31) + this.titleInfo.hashCode()) * 31) + this.showTime.hashCode()) * 31) + this.summaryInfo.hashCode()) * 31) + this.unreadInfo.hashCode()) * 31) + this.vasInfo.hashCode()) * 31;
        boolean z16 = this.isTop;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isDraft;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode3 = (((((((i17 + i18) * 31) + this.sendStatus) * 31) + this.nestSort.hashCode()) * 31) + this.nestContactInfo.hashCode()) * 31;
        boolean z18 = this.isMsgDisturb;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int a16 = (((((((hashCode3 + i19) * 31) + androidx.fragment.app.a.a(this.shieldFlag)) * 31) + this.specialCareFlag) * 31) + androidx.fragment.app.a.a(this.chatUin)) * 31;
        boolean z19 = this.needAlphaAnim;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        int i26 = (a16 + i3) * 31;
        ArrayList<RecentContactExtAttr> arrayList = this.extAttrs;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        return i26 + hashCode;
    }

    @Nullable
    public final Map<LiteBusinessType, Object> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (Map) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.businessMap;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public long id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Long) iPatchRedirector.redirect((short) 52, (Object) this)).longValue();
        }
        return this.contactId;
    }

    @NotNull
    public final HashSet<Object> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (HashSet) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.cachePayloads;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.chatUid;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
        }
        return this.chatUin;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.contactId;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.contactType;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return this.dtPageType;
    }

    @Nullable
    public final ArrayList<RecentContactExtAttr> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ArrayList) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.extAttrs;
    }

    @NotNull
    public final Bundle q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Bundle) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.extra;
    }

    @NotNull
    public final d r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (d) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.mutualMarkInfo;
    }

    @NotNull
    public final RecentContactInfo s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.originData;
    }

    @NotNull
    public String toString() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (String) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        String str = this.chatUid;
        String e16 = this.titleInfo.e();
        int i3 = this.contactType;
        C9572g c9572g = this.unreadInfo;
        String str2 = this.showTime;
        CharSequence f16 = this.summaryInfo.f();
        if (f16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Character ch5 = null;
        if (!z16) {
            f16 = null;
        }
        if (f16 != null) {
            ch5 = Character.valueOf(f16.charAt(0));
        }
        return "RecentContactChatItem{ uid=" + str + ", title=" + e16 + ", contactType=" + i3 + ", unreadCount=" + c9572g + ".count , showTime=" + str2 + ", summary=" + ch5 + " , isTop=" + this.isTop + ", isDraft=" + this.isDraft + "}";
    }

    @NotNull
    public final String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.showTime;
    }

    @NotNull
    public final e v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (e) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.summaryInfo;
    }

    @NotNull
    public final f w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.titleInfo;
    }

    @NotNull
    public final C9572g x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (C9572g) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.unreadInfo;
    }

    @NotNull
    public final h y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (h) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.vasInfo;
    }

    public final boolean z() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this)).booleanValue();
        }
        Map<LiteBusinessType, ? extends Object> map = this.businessMap;
        if (map != null && !map.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\u0002B1\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\"\u001a\u0004\b\u0010\u0010#\"\u0004\b$\u0010%R\"\u0010+\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010'\u001a\u0004\b\u0017\u0010(\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a;", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "g", "()I", DomainData.DOMAIN_NAME, "(I)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "path", "c", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "resId", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rightBottomIconResId", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", tl.h.F, "(Landroid/graphics/drawable/Drawable;)V", "drawable", "Z", "()Z", "j", "(Z)V", "forceRefresh", "getDtType", "i", "dtType", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int showType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String path;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer resId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer rightBottomIconResId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable drawable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean forceRefresh;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int dtType;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$a$a;", "", "", "SHOW_TYPE_FACADE", "I", "SHOW_TYPE_PATH", "SHOW_TYPE_RES_ID", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chats.core.adapter.itemdata.g$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes24.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42489);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 26)) {
                redirector.redirect((short) 26);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a(int i3, @NotNull String path, @Nullable Integer num, @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(path, "path");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), path, num, num2);
                return;
            }
            this.showType = i3;
            this.path = path;
            this.resId = num;
            this.rightBottomIconResId = num2;
            this.dtType = 3;
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (a) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            a aVar = new a(this.showType, this.path, this.resId, this.rightBottomIconResId);
            aVar.drawable = this.drawable;
            aVar.dtType = this.dtType;
            return aVar;
        }

        @Nullable
        public final Drawable b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.drawable;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            return this.forceRefresh;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.path;
        }

        @Nullable
        public final Integer e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Integer) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.resId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.showType == aVar.showType && Intrinsics.areEqual(this.path, aVar.path) && Intrinsics.areEqual(this.resId, aVar.resId) && Intrinsics.areEqual(this.rightBottomIconResId, aVar.rightBottomIconResId)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final Integer f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Integer) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.rightBottomIconResId;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.showType;
        }

        public final void h(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) drawable);
            } else {
                this.drawable = drawable;
            }
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
            }
            int hashCode2 = ((this.showType * 31) + this.path.hashCode()) * 31;
            Integer num = this.resId;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            Integer num2 = this.rightBottomIconResId;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return i16 + i3;
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, i3);
            } else {
                this.dtType = i3;
            }
        }

        public final void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, z16);
            } else {
                this.forceRefresh = z16;
            }
        }

        public final void k(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.path = str;
            }
        }

        public final void l(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) num);
            } else {
                this.resId = num;
            }
        }

        public final void m(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) num);
            } else {
                this.rightBottomIconResId = num;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.showType = i3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (String) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            return "AvatarInfo(showType=" + this.showType + ", path=" + this.path + ", resId=" + this.resId + ", rightBottomIconResId=" + this.rightBottomIconResId + ")";
        }

        public /* synthetic */ a(int i3, String str, Integer num, Integer num2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, str, (i16 & 4) != 0 ? null : num, (i16 & 8) == 0 ? num2 : null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, num, num2, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g(RecentContactInfo recentContactInfo, long j3, int i3, String str, a aVar, f fVar, String str2, e eVar, C9572g c9572g, h hVar, boolean z16, boolean z17, int i16, ArrayList arrayList, ArrayList arrayList2, boolean z18, long j16, byte b16, long j17, boolean z19, ArrayList arrayList3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(recentContactInfo, j3, i3, str, aVar, r11, r12, r13, (i17 & 256) != 0 ? new C9572g(0, 0L, 3, null) : c9572g, (i17 & 512) != 0 ? new h() : hVar, z16, z17, i16, arrayList, arrayList2, z18, j16, b16, j17, (524288 & i17) != 0 ? false : z19, (1048576 & i17) != 0 ? null : arrayList3);
        f fVar2;
        e eVar2;
        int i18 = 1;
        String str3 = null;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        if ((i17 & 32) != 0) {
            fVar2 = new f(str3, i18, b19 == true ? 1 : 0);
        } else {
            fVar2 = fVar;
        }
        String str4 = (i17 & 64) != 0 ? "" : str2;
        if ((i17 & 128) != 0) {
            eVar2 = new e(b18 == true ? 1 : 0, i18, b17 == true ? 1 : 0);
        } else {
            eVar2 = eVar;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, recentContactInfo, Long.valueOf(j3), Integer.valueOf(i3), str, aVar, fVar, str2, eVar, c9572g, hVar, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), arrayList, arrayList2, Boolean.valueOf(z18), Long.valueOf(j16), Byte.valueOf(b16), Long.valueOf(j17), Boolean.valueOf(z19), arrayList3, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
