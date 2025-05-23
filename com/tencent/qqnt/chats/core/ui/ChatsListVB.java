package com.tencent.qqnt.chats.core.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.api.IChatsFreControlHelper;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator;
import com.tencent.qqnt.chats.core.bizEvent.ChatBizEventManager;
import com.tencent.qqnt.chats.core.mvi.BaseFakeVB;
import com.tencent.qqnt.chats.core.report.DTChatsReportManager;
import com.tencent.qqnt.chats.core.ui.ChatsDataLoadHelper;
import com.tencent.qqnt.chats.core.ui.highlight.HighLightManager;
import com.tencent.qqnt.chats.core.ui.n;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.view.AnimRefreshHeaderView;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.theme.SkinEngine;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 G2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0003\u00d8\u00011B'\u0012\u0014\u0010\u00d5\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00d4\u0001\u0012\u0006\u0010g\u001a\u00020=\u00a2\u0006\u0006\b\u00d6\u0001\u0010\u00d7\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\u0006\u0010)\u001a\u00020\u0006J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0006\u00102\u001a\u00020\u0006J\u0018\u00103\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u00104\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u00105\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u00108\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0016J\u000e\u00109\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010<\u001a\u00020;J\u0010\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020=H\u0016J\u0006\u0010A\u001a\u00020?J!\u0010D\u001a\u00020\u00062\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040B\"\u00020\u0004\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u001e\u0010H\u001a\u00020\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0017062\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u0018\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u001e\u0010K\u001a\u00020\u00062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0017062\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u0016\u0010L\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010M\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010N\u001a\u00020\u000bJ\u0010\u0010Q\u001a\u00020\u00062\b\u0010P\u001a\u0004\u0018\u00010OJ\u0006\u0010R\u001a\u00020\u0006J\u0006\u0010S\u001a\u00020\u0006J\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U2\u0006\u0010T\u001a\u00020\u000eJ\u0010\u0010X\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010Y\u001a\u00020\u000bH\u0016J\u0006\u0010Z\u001a\u00020\u000bJ\u000e\u0010]\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020[J\u0010\u0010_\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010[J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\"\u0010g\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010n\u001a\u00020;8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010v\u001a\u00020o8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010}\u001a\u0004\u0018\u00010w8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\br\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010\u007fR\u0017\u0010\u0081\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010GR\u001b\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u0083\u0001R\u0019\u0010\u0085\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010iR\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010iR\u001e\u0010\u008b\u0001\u001a\u00020?8\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bW\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R+\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0016\u0010\u008d\u0001\u001a\u0006\b\u0086\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001b\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u009b\u0001R\u0019\u0010\u009f\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b.\u0010\u009e\u0001R)\u0010\u00a6\u0001\u001a\u00030\u00a0\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b\t\u0010\u00a1\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001\"\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0019\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\b\u0010\u00a7\u0001R+\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00a8\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0007\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u001b\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0013\u0010\u00b0\u0001R,\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b2\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001\"\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u001f\u0010\u00bd\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\n\u0010\u00ba\u0001\u001a\u0006\b\u00bb\u0001\u0010\u00bc\u0001R#\u0010\u00c0\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00be\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bN\u0010\u00bf\u0001R+\u0010\u00c7\u0001\u001a\u0005\u0018\u00010\u00c1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bY\u0010\u00c2\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001\"\u0006\b\u00c5\u0001\u0010\u00c6\u0001R+\u0010\u00ce\u0001\u001a\u0005\u0018\u00010\u00c8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bZ\u0010\u00c9\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001\"\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u001c\u0010\u00d3\u0001\u001a\u00030\u00cf\u00018\u0006\u00a2\u0006\u000f\n\u0005\bD\u0010\u00d0\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001\u00a8\u0006\u00d9\u0001"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/core/mvi/BaseFakeVB;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "", "Lcom/tencent/qqnt/chats/core/ui/n;", "", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "U", "", ViewStickEventHelper.IS_SHOW, "w0", "", "type", "Landroid/view/View;", "view", "o", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "uiState", "J", "", "chatUid", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$c;", "cb", "E", "Lcom/tencent/qqnt/chats/core/uievent/a$l;", "event", "M", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "v0", "m0", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "viewParams", "d0", "p", "onResume", "f0", DKHippyEvent.EVENT_STOP, "e0", "N", "Lcom/tencent/qqnt/chats/core/uievent/b;", "uiEvent", "b", "z0", DomainData.DOMAIN_NAME, "i0", "x0", "", "views", "y0", "s0", "r0", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/data/a;", "builder", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", "payload", "Y", "([Ljava/lang/Object;)V", "uin", "Z", "b0", "uid", "a0", "c0", "p0", "j0", "V", "Lcom/tencent/qqnt/chats/core/ui/listener/a;", "chatsListListener", "o0", "O", "n0", "diff", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "I", "l0", "W", "X", "Landroid/os/Bundle;", "outState", "h0", Constants.FILE_INSTANCE_STATE, "g0", "r", tl.h.F, "Lcom/tencent/qqnt/chats/core/data/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/chats/core/data/a;", "setMBuilder", "(Lcom/tencent/qqnt/chats/core/data/a;)V", "mBuilder", "i", "Landroidx/recyclerview/widget/RecyclerView;", "D", "()Landroidx/recyclerview/widget/RecyclerView;", "u0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/content/Context;", "t0", "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/qqnt/chats/core/ui/third/e;", "Lcom/tencent/qqnt/chats/core/ui/third/e;", "G", "()Lcom/tencent/qqnt/chats/core/ui/third/e;", "setThirdContainer", "(Lcom/tencent/qqnt/chats/core/ui/third/e;)V", "thirdContainer", "Lcom/tencent/qqnt/chats/core/adapter/g;", "Lcom/tencent/qqnt/chats/core/adapter/g;", "mChatsListSkAdapter", "isSkViewInit", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mSkView", "mChatsListSkRecyclerView", "H", "mChatsListSkRecyclerViewWrap", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "B", "()Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "mChatsAdapter", "Lcom/tencent/qqnt/chats/core/ui/o;", "Lcom/tencent/qqnt/chats/core/ui/o;", "()Lcom/tencent/qqnt/chats/core/ui/o;", "setUpdateControlHelper", "(Lcom/tencent/qqnt/chats/core/ui/o;)V", "updateControlHelper", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "K", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragFrameLayout", "Landroid/view/ViewGroup;", "L", "Landroid/view/ViewGroup;", "refreshList", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "thirdContainerView", "Lcom/tencent/qqnt/chats/core/ui/e;", "Lcom/tencent/qqnt/chats/core/ui/e;", "bubbleMenu", "Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "w", "()Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "q0", "(Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;)V", "highLightManager", "Lcom/tencent/qqnt/chats/core/ui/listener/a;", "Lq3/f;", "Lq3/f;", HippyTKDListViewAdapter.X, "()Lq3/f;", "setListScrollView", "(Lq3/f;)V", "listScrollView", "Lcom/tencent/qqnt/chats/core/ui/l;", "Lcom/tencent/qqnt/chats/core/ui/l;", "chatsLockHelper", "Landroid/os/Parcelable;", "T", "Landroid/os/Parcelable;", "getCurSavePos", "()Landroid/os/Parcelable;", "setCurSavePos", "(Landroid/os/Parcelable;)V", "curSavePos", "Lkotlin/Lazy;", "t", "()I", "curHashCode", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "clickItemRef", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "y", "()Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "setLoadHelper", "(Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;)V", "loadHelper", "Lcom/tencent/qqnt/chats/api/b;", "Lcom/tencent/qqnt/chats/api/b;", "v", "()Lcom/tencent/qqnt/chats/api/b;", "setDtReport", "(Lcom/tencent/qqnt/chats/api/b;)V", "dtReport", "Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "u", "()Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "dtListOpProvider", "Lcom/tencent/qqnt/chats/core/mvi/a;", "mViewModel", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class ChatsListVB extends BaseFakeVB<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.ui.third.e thirdContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.adapter.g mChatsListSkAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isSkViewInit;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mSkView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mChatsListSkRecyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mChatsListSkRecyclerViewWrap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ChatsListAdapter mChatsAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private o updateControlHelper;

    /* renamed from: K, reason: from kotlin metadata */
    private QUIBadgeDragLayout dragFrameLayout;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ViewGroup refreshList;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout thirdContainerView;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.core.ui.e bubbleMenu;

    /* renamed from: P, reason: from kotlin metadata */
    public HighLightManager highLightManager;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.ui.listener.a chatsListListener;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private q3.f listScrollView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private l chatsLockHelper;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Parcelable curSavePos;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy curHashCode;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private WeakReference<View> clickItemRef;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ChatsDataLoadHelper loadHelper;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.api.b dtReport;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final DTChatsReportManager.b dtListOpProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.data.a mBuilder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView mRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$a;", "", "", "SAVE_STATE_FOR_LIST", "Ljava/lang/String;", "TAG", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.ChatsListVB$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$c", "Lcom/tencent/qqnt/chats/core/report/DTChatsReportManager$b;", "", "d", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "last", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "Lkotlin/Pair;", "c", "Lkotlin/Function1;", "", "op", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements DTChatsReportManager.b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$c$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "chats_view_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes24.dex */
        public static final class a extends RecyclerView.OnScrollListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function1<Integer, Unit> f354910d;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super Integer, Unit> function1) {
                this.f354910d = function1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                } else {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    this.f354910d.invoke(Integer.valueOf(newState));
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
            }
        }

        private final boolean d() {
            return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("chats_9035_121901685", true);
        }

        @Override // com.tencent.qqnt.chats.core.report.DTChatsReportManager.b
        public void a(@NotNull Function1<? super Integer, Unit> op5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) op5);
            } else {
                Intrinsics.checkNotNullParameter(op5, "op");
                ChatsListVB.this.D().addOnScrollListener(new a(op5));
            }
        }

        @Override // com.tencent.qqnt.chats.core.report.DTChatsReportManager.b
        @Nullable
        public List<com.tencent.qqnt.chats.core.adapter.itemdata.b> b(int first, int last) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(first), Integer.valueOf(last));
            }
            if (ChatsListVB.this.B().getCurrentList().isEmpty()) {
                return null;
            }
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = ChatsListVB.this.B().getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "mChatsAdapter.currentList");
            if (d()) {
                if (first < 0 || last < 0 || first > last || last >= currentList.size()) {
                    return null;
                }
                return currentList.subList(first, last + 1);
            }
            if (first < 0 || last < 0 || first > last || last > currentList.size()) {
                return null;
            }
            return currentList.subList(first, last);
        }

        @Override // com.tencent.qqnt.chats.core.report.DTChatsReportManager.b
        @Nullable
        public Pair<Integer, Integer> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Pair) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (ChatsListVB.this.B().getCurrentList().isEmpty()) {
                return null;
            }
            RecyclerView.LayoutManager layoutManager = ChatsListVB.this.D().getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
                return null;
            }
            return new Pair<>(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(findLastVisibleItemPosition));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
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
            com.tencent.qqnt.chats.core.ui.listener.a aVar = ChatsListVB.this.chatsListListener;
            if (aVar != null) {
                aVar.d(recyclerView, newState);
            }
            ChatsDataLoadHelper y16 = ChatsListVB.this.y();
            if (y16 != null) {
                y16.i(recyclerView, newState);
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
            com.tencent.qqnt.chats.core.ui.listener.a aVar = ChatsListVB.this.chatsListListener;
            if (aVar != null) {
                aVar.b(recyclerView, dx5, dy5);
            }
            ChatsDataLoadHelper y16 = ChatsListVB.this.y();
            if (y16 != null) {
                ChatsDataLoadHelper.h(y16, recyclerView, dy5, false, 4, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$e", "Lcom/tencent/qqnt/chats/core/adapter/h;", "", "position", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "", "a", "", "b", "clickId", "c", "dragType", "f", "Lpw3/c;", "searchBar", "g", "d", "e", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e extends com.tencent.qqnt.chats.core.adapter.h {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void a(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemBinding binding) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), item, binding);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(binding, "binding");
            ChatsListVB.this.e(new a.f(position, item, binding.i()));
            if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                ChatsListVB.this.clickItemRef = new WeakReference(binding.i());
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public boolean b(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemBinding binding) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), item, binding)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(binding, "binding");
            ChatsListVB.this.e(new a.g(position, item, binding.i()));
            return true;
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void c(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemBinding binding, int clickId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), item, binding, Integer.valueOf(clickId));
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(binding, "binding");
            ChatsListVB.this.e(new a.i(position, item, clickId));
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void d(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) item, position);
            } else {
                Intrinsics.checkNotNullParameter(item, "item");
                ChatsListVB.this.e(new a.j(position, item));
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) item, position);
            } else {
                Intrinsics.checkNotNullParameter(item, "item");
                ChatsListVB.this.e(new a.k(position, item));
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void f(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int dragType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), item, Integer.valueOf(dragType));
            } else {
                Intrinsics.checkNotNullParameter(item, "item");
                ChatsListVB.this.e(new a.h(position, item, dragType));
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void g(@NotNull pw3.c searchBar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) searchBar);
            } else {
                Intrinsics.checkNotNullParameter(searchBar, "searchBar");
                ChatsListVB.this.e(new a.l(searchBar));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$f", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$b;", "", "fetchOld", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "preLoadEnabled", "lastLoadEnabled", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class f implements ChatsDataLoadHelper.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.ui.ChatsDataLoadHelper.b
        public void a(boolean fetchOld, int pos, @Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(fetchOld), Integer.valueOf(pos), item);
            } else if (ChatsListVB.this.W()) {
                ChatsListVB.this.a().o(new a.c(pos, item, fetchOld));
            }
        }

        @Override // com.tencent.qqnt.chats.core.ui.ChatsDataLoadHelper.b
        public void b(boolean preLoadEnabled, boolean lastLoadEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(preLoadEnabled), Boolean.valueOf(lastLoadEnabled));
                return;
            }
            if (ChatsListVB.this.W()) {
                q3.f x16 = ChatsListVB.this.x();
                if (x16 != null) {
                    x16.a(!preLoadEnabled);
                }
                if (ChatsListVB.this.A().e() == 1) {
                    com.tencent.qqnt.chats.main.utils.a.f355281a.a(!preLoadEnabled, !lastLoadEnabled);
                }
            }
            ChatsListVB.this.B().X0(!preLoadEnabled);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$g", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class g implements ViewTreeObserver.OnPreDrawListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.qqnt.chats.core.ui.listener.a aVar = ChatsListVB.this.chatsListListener;
                if (aVar != null) {
                    aVar.c();
                }
                ChatsListVB.this.D().getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$h", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "supportsPredictiveItemAnimations", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class h extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        h(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean supportsPredictiveItemAnimations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (ChatsListConfig.f354433a.f() && super.supportsPredictiveItemAnimations()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class i extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        i(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/chats/core/ui/ChatsListVB$j", "Lcom/tencent/qqnt/chats/core/ui/third/a;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "", "", "extra", "", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class j implements com.tencent.qqnt.chats.core.ui.third.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.ui.third.a
        public void a(@NotNull View view, @NotNull ThirdViewEnum viewType, @Nullable Map<String, ? extends Object> extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, viewType, extra);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            ChatsListVB.this.e(new a.m(view, viewType, extra));
            view.sendAccessibilityEvent(8);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 63)) {
            redirector.redirect((short) 63);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatsListVB(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel, (Object) mBuilder);
            return;
        }
        this.mBuilder = mBuilder;
        this.mChatsListSkAdapter = new com.tencent.qqnt.chats.core.adapter.g(false, i3, null);
        this.mChatsAdapter = q(this.mBuilder);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Integer>() { // from class: com.tencent.qqnt.chats.core.ui.ChatsListVB$curHashCode$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(ChatsListVB.this.hashCode()) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.curHashCode = lazy;
        this.dtListOpProvider = new c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        if (r1 != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E(String chatUid, GuildLayoutManager.c cb5) {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        boolean z16;
        if (!TextUtils.isEmpty(chatUid)) {
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = this.mChatsAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "mChatsAdapter.currentList");
            Iterator<com.tencent.qqnt.chats.core.adapter.itemdata.b> it = currentList.iterator();
            boolean z17 = false;
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.b next = it.next();
                    if ((next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && Intrinsics.areEqual(((com.tencent.qqnt.chats.core.adapter.itemdata.g) next).k(), chatUid)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            int i16 = i3 + 1;
            if (i16 < this.mChatsAdapter.getCurrentList().size()) {
                com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = this.mChatsAdapter.getCurrentList().get(i16);
                if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
                } else {
                    gVar = null;
                }
                if (gVar != null && gVar.E()) {
                    z17 = true;
                }
            }
            i16 = i3 - 1;
            if (i16 >= 0 && i16 < this.mChatsAdapter.getCurrentList().size() && (this.mChatsAdapter.getCurrentList().get(i16) instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
                com.tencent.qqnt.chats.core.adapter.itemdata.b bVar2 = this.mChatsAdapter.getCurrentList().get(i16);
                Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
                cb5.onResult(((com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar2).k());
                return;
            }
            cb5.onResult(null);
        }
    }

    private final void J(final a.b uiState) {
        boolean z16;
        Object valueOf;
        List<com.tencent.qqnt.chats.core.ui.third.f> emptyList;
        ChatsDataLoadHelper chatsDataLoadHelper;
        ChatsDataLoadHelper chatsDataLoadHelper2 = this.loadHelper;
        if (chatsDataLoadHelper2 != null) {
            z16 = chatsDataLoadHelper2.a(uiState.d(), !uiState.f());
        } else {
            z16 = true;
        }
        String z17 = z();
        int t16 = t();
        int size = uiState.d().size();
        int g16 = uiState.g();
        boolean f16 = uiState.f();
        boolean h16 = uiState.h();
        if (uiState.d().isEmpty()) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(uiState.d().get(0).hashCode());
        }
        QLog.d(z17, 1, "[handleChatListState]: hashCode=" + t16 + ", size=" + size + ", serverCount=" + g16 + ",partUpdate=" + f16 + ", enableUpdate=" + z16 + ", guild=" + h16 + ", firstChange.hash=" + valueOf);
        ChatsDataLoadHelper chatsDataLoadHelper3 = this.loadHelper;
        if (chatsDataLoadHelper3 != null) {
            chatsDataLoadHelper3.s(uiState.d(), uiState.g(), uiState.f(), uiState.c());
        }
        if (!z16) {
            return;
        }
        com.tencent.qqnt.chats.perf.a aVar = com.tencent.qqnt.chats.perf.a.f355516a;
        aVar.e(uiState.d().isEmpty());
        if (uiState.d().isEmpty() && (chatsDataLoadHelper = this.loadHelper) != null) {
            chatsDataLoadHelper.p();
        }
        if (D().getAdapter() == null && uiState.d().isEmpty()) {
            if (com.tencent.qqnt.chats.data.persistent.c.f355136a.m().isEmpty()) {
                this.mChatsAdapter.submitList(this.mBuilder.g() ? CollectionsKt__CollectionsJVMKt.listOf(com.tencent.qqnt.chats.core.adapter.itemdata.d.f354526c) : CollectionsKt__CollectionsKt.emptyList());
            }
        } else {
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> d16 = uiState.d();
            if (d16.isEmpty()) {
                d16 = this.mBuilder.g() ? CollectionsKt__CollectionsJVMKt.listOf(com.tencent.qqnt.chats.core.adapter.itemdata.d.f354526c) : CollectionsKt__CollectionsKt.emptyList();
            }
            aVar.d(true, D());
            this.mChatsAdapter.c1(d16, uiState.h(), new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.i
                @Override // java.lang.Runnable
                public final void run() {
                    ChatsListVB.K(a.b.this, this);
                }
            });
        }
        if (!Intrinsics.areEqual(D().getAdapter(), this.mChatsAdapter)) {
            D().setAdapter(this.mChatsAdapter);
        }
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            com.tencent.qqnt.chats.core.ui.third.g gVar = com.tencent.qqnt.chats.core.ui.third.g.f354998a;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            eVar.o(gVar.a(emptyList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final a.b uiState, final ChatsListVB this$0) {
        ChatsDataLoadHelper chatsDataLoadHelper;
        Intrinsics.checkNotNullParameter(uiState, "$uiState");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!uiState.f() && (chatsDataLoadHelper = this$0.loadHelper) != null) {
            chatsDataLoadHelper.e(this$0.w().d(), this$0.w().e());
        }
        com.tencent.qqnt.chats.core.ui.listener.a aVar = this$0.chatsListListener;
        if (aVar != null) {
            aVar.a();
        }
        com.tencent.qqnt.chats.api.b bVar = this$0.dtReport;
        if (bVar != null) {
            bVar.g();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this$0.D().post(new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                ChatsListVB.L(a.b.this, this$0, currentTimeMillis);
            }
        });
        Parcelable parcelable = this$0.curSavePos;
        if (parcelable != null) {
            QLog.i(this$0.z(), 1, "recyclerview do recovery");
            LinearLayoutManager linearLayoutManager = null;
            this$0.curSavePos = null;
            RecyclerView.LayoutManager layoutManager = this$0.D().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.onRestoreInstanceState(parcelable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(a.b uiState, ChatsListVB this$0, long j3) {
        Intrinsics.checkNotNullParameter(uiState, "$uiState");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!uiState.f()) {
            ChatsDataLoadHelper chatsDataLoadHelper = this$0.loadHelper;
            if (chatsDataLoadHelper != null) {
                chatsDataLoadHelper.f(this$0.w().c());
            }
        } else {
            this$0.r(uiState);
        }
        com.tencent.qqnt.chats.perf.a.f355516a.d(false, this$0.D());
        QLog.i(this$0.z(), 1, "recyclerview draw cost: " + (System.currentTimeMillis() - j3));
    }

    private final void M(a.l event) {
        String str;
        ChatsDataLoadHelper chatsDataLoadHelper;
        String z16 = z();
        int a16 = event.a();
        RecentContactInfo b16 = event.b();
        Integer num = null;
        if (b16 != null) {
            str = b16.peerUid;
        } else {
            str = null;
        }
        RecentContactInfo b17 = event.b();
        if (b17 != null) {
            num = Integer.valueOf(b17.chatType);
        }
        QLog.d(z16, 1, "handleScrollToCallback: err=" + a16 + ", info.uid=" + str + ", info.chatType=" + num);
        if (event.a() != 0) {
            ChatsDataLoadHelper chatsDataLoadHelper2 = this.loadHelper;
            if (chatsDataLoadHelper2 != null) {
                chatsDataLoadHelper2.o();
                return;
            }
            return;
        }
        if (w().h() && (chatsDataLoadHelper = this.loadHelper) != null) {
            chatsDataLoadHelper.q(event.b());
        }
        if (event.b() == null && w().h()) {
            ChatsDataLoadHelper chatsDataLoadHelper3 = this.loadHelper;
            if (chatsDataLoadHelper3 != null) {
                chatsDataLoadHelper3.o();
            }
            ChatsDataLoadHelper chatsDataLoadHelper4 = this.loadHelper;
            if (chatsDataLoadHelper4 != null) {
                chatsDataLoadHelper4.k();
                return;
            }
            return;
        }
        if (event.b() == null) {
            ChatsDataLoadHelper chatsDataLoadHelper5 = this.loadHelper;
            if (chatsDataLoadHelper5 != null) {
                chatsDataLoadHelper5.o();
                return;
            }
            return;
        }
        ChatsDataLoadHelper chatsDataLoadHelper6 = this.loadHelper;
        if (chatsDataLoadHelper6 != null) {
            chatsDataLoadHelper6.f(event.b());
        }
    }

    private final void P() {
        ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
        if (chatsDataLoadHelper != null) {
            k.f354958a.c(chatsDataLoadHelper);
        }
    }

    private final void Q() {
        this.dtReport = new DTChatsReportManager(this.dtListOpProvider, com.tencent.qqnt.chats.core.report.a.f354861a.b(this.mBuilder.e()), null, 0, 12, null);
        ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).updateChatsListReport(this.mBuilder.e(), this.dtReport);
        a().p(this.dtReport);
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.v(this.dtReport);
        }
    }

    private final void R() {
        if (!this.mBuilder.i()) {
            return;
        }
        l lVar = new l(D(), null, 2, 0 == true ? 1 : 0);
        this.chatsLockHelper = lVar;
        lVar.b("init");
    }

    private final void S() {
        ChatsListAdapter chatsListAdapter = this.mChatsAdapter;
        QUIBadgeDragLayout qUIBadgeDragLayout = this.dragFrameLayout;
        if (qUIBadgeDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
            qUIBadgeDragLayout = null;
        }
        chatsListAdapter.U0(qUIBadgeDragLayout);
        this.mChatsAdapter.setHasStableIds(true);
        D().setItemAnimator(null);
        RecyclerView D = D();
        Context context = D().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRecyclerView.context");
        D.setLayoutManager(new com.tencent.qqnt.chats.core.ui.widget.a(context));
        if (D() instanceof SkinnableRecycleView) {
            D().setClipToPadding(false);
            RecyclerView D2 = D();
            Intrinsics.checkNotNull(D2, "null cannot be cast to non-null type com.tencent.qqnt.chats.view.SkinnableRecycleView");
            ((SkinnableRecycleView) D2).setClipToTopPadding(true);
        } else {
            D().setClipToPadding(true);
        }
        RecyclerView D3 = D();
        D3.addOnScrollListener(new d());
        ChatBizEventManager.INSTANCE.a().j(a().h(), ViewKt.findViewTreeLifecycleOwner(D()));
        D3.setChildDrawingOrderCallback(new RecyclerView.ChildDrawingOrderCallback() { // from class: com.tencent.qqnt.chats.core.ui.h
            @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
            public final int onGetChildDrawingOrder(int i3, int i16) {
                int T;
                T = ChatsListVB.T(i3, i16);
                return T;
            }
        });
        com.tencent.qqnt.chats.core.adapter.h b16 = this.mBuilder.b();
        if (b16 == null) {
            this.mChatsAdapter.Y0(new e(), D());
        } else {
            this.mChatsAdapter.Y0(b16, D());
        }
        this.mChatsAdapter.b1(com.tencent.qqnt.chats.core.itempart.e.f354799a.a());
        r0(this.mBuilder.f());
        s0(this.mBuilder.h());
        if (W()) {
            this.loadHelper = new ChatsDataLoadHelper(D(), this.mChatsAdapter, w(), new f());
        }
        D().getViewTreeObserver().addOnPreDrawListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int T(int i3, int i16) {
        return (i3 - i16) - 1;
    }

    private final void U() {
        View view;
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        ViewParent parent = D().getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewStub viewStub = (ViewStub) ((ViewGroup) parent).findViewById(R.id.f85754pt);
        RecyclerView recyclerView2 = null;
        if (viewStub != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = null;
        }
        this.mSkView = linearLayout;
        if (linearLayout != null) {
            recyclerView = (RecyclerView) linearLayout.findViewById(R.id.f85734pr);
        } else {
            recyclerView = null;
        }
        this.mChatsListSkRecyclerView = recyclerView;
        LinearLayout linearLayout2 = this.mSkView;
        if (linearLayout2 != null) {
            recyclerView2 = (RecyclerView) linearLayout2.findViewById(R.id.f85744ps);
        }
        this.mChatsListSkRecyclerViewWrap = recyclerView2;
        RecyclerView recyclerView3 = this.mChatsListSkRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.mChatsListSkAdapter);
        }
        RecyclerView recyclerView4 = this.mChatsListSkRecyclerView;
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(new h(C()));
        }
        RecyclerView recyclerView5 = this.mChatsListSkRecyclerViewWrap;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(new com.tencent.qqnt.chats.core.adapter.g(true));
        }
        RecyclerView recyclerView6 = this.mChatsListSkRecyclerViewWrap;
        if (recyclerView6 != null) {
            recyclerView6.setLayoutManager(new i(C()));
        }
    }

    private final void k0(final RecentContactInfo item) {
        if (W()) {
            ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
            boolean z16 = false;
            if (chatsDataLoadHelper != null && chatsDataLoadHelper.d(item)) {
                z16 = true;
            }
            if (z16) {
                e(new a.b(item, 1));
                return;
            }
            return;
        }
        int u06 = this.mChatsAdapter.u0(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>() { // from class: com.tencent.qqnt.chats.core.ui.ChatsListVB$scrollToChatItem$index$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.m() == RecentContactInfo.this.contactId);
            }
        });
        if (u06 >= 0) {
            com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(D(), u06);
        }
    }

    private final void m0() {
        boolean z16;
        RecentContactInfo recentContactInfo;
        RecentContactInfo b16;
        int i3 = 0;
        if (W()) {
            ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
            if (chatsDataLoadHelper != null && chatsDataLoadHelper.j()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ChatsDataLoadHelper chatsDataLoadHelper2 = this.loadHelper;
                String str = null;
                if (chatsDataLoadHelper2 != null) {
                    recentContactInfo = chatsDataLoadHelper2.b();
                } else {
                    recentContactInfo = null;
                }
                String z17 = z();
                ChatsDataLoadHelper chatsDataLoadHelper3 = this.loadHelper;
                if (chatsDataLoadHelper3 != null && (b16 = chatsDataLoadHelper3.b()) != null) {
                    str = b16.peerUid;
                }
                QLog.d(z17, 1, "[scrollToNextUnread] curUnreadInfo=" + str);
                e(new a.b(recentContactInfo, 0));
                return;
            }
            return;
        }
        RecyclerView.LayoutManager layoutManager = D().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        int size = this.mChatsAdapter.getCurrentList().size();
        int i16 = 0;
        while (true) {
            if (i16 >= size) {
                break;
            }
            com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = this.mChatsAdapter.getCurrentList().get(i16);
            if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
                if (gVar.x().b() > 0 && i16 > findFirstVisibleItemPosition && gVar.x().c() == 1) {
                    i3 = i16;
                    break;
                }
            }
            i16++;
        }
        QLog.i(z(), 1, "scrollToNextUnread firstUnread=" + i3);
        com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(D(), i3);
    }

    private final void o(int type, View view) {
        ViewGroup viewGroup;
        if (type == -1) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            LinearLayout linearLayout = this.mSkView;
            if (linearLayout != null) {
                linearLayout.addView(view, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    private final int t() {
        return ((Number) this.curHashCode.getValue()).intValue();
    }

    private final void v0(com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        View view;
        boolean areEqual;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = this.mChatsAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mChatsAdapter.currentList");
        Iterator<com.tencent.qqnt.chats.core.adapter.itemdata.b> it = currentList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.qqnt.chats.core.adapter.itemdata.b next = it.next();
                if ((item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
                    if (((com.tencent.qqnt.chats.core.adapter.itemdata.g) item).m() == ((com.tencent.qqnt.chats.core.adapter.itemdata.g) next).m()) {
                        areEqual = true;
                    } else {
                        areEqual = false;
                    }
                } else {
                    areEqual = Intrinsics.areEqual(item, next);
                }
                if (areEqual) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = D().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            com.tencent.qqnt.chats.core.ui.e eVar = this.bubbleMenu;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMenu");
                eVar = null;
            }
            eVar.k(item, i3, view);
            if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                e(new a.k(i3, (com.tencent.qqnt.chats.core.adapter.itemdata.g) item));
            }
        }
    }

    private final void w0(boolean isShow) {
        if (!this.isSkViewInit) {
            U();
            this.isSkViewInit = true;
        }
        if (isShow) {
            LinearLayout linearLayout = this.mSkView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.mSkView;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.data.a A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ChatsListAdapter B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ChatsListAdapter) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mChatsAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Context C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RecyclerView D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @NotNull
    public final RecyclerView F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.qqnt.chats.core.ui.third.e G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.chats.core.ui.third.e) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.thirdContainer;
    }

    @Nullable
    public final o H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (o) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.updateControlHelper;
    }

    @NotNull
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> I(int diff) {
        int coerceAtLeast;
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (List) iPatchRedirector.redirect((short) 54, (Object) this, diff);
        }
        ArrayList arrayList = new ArrayList();
        RecyclerView.LayoutManager layoutManager = D().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, findFirstVisibleItemPosition - diff);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mChatsAdapter.getNUM_BACKGOURND_ICON() - 1, findLastVisibleItemPosition + diff);
        if (coerceAtLeast <= coerceAtMost) {
            while (true) {
                com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = this.mChatsAdapter.getCurrentList().get(coerceAtLeast);
                if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    arrayList.add(bVar);
                }
                if (coerceAtLeast == coerceAtMost) {
                    break;
                }
                coerceAtLeast++;
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.qqnt.chats.core.uistate.b uiState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) uiState);
            return;
        }
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (uiState instanceof a.b) {
            J((a.b) uiState);
            return;
        }
        if (uiState instanceof a.C9591a) {
            a.C9591a c9591a = (a.C9591a) uiState;
            QLog.d(z(), 1, "[ChatListGetFail] err=" + c9591a.a() + ", msg=" + c9591a.b());
            ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
            if (chatsDataLoadHelper != null) {
                chatsDataLoadHelper.o();
            }
        }
    }

    public final void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.core.ui.e eVar = this.bubbleMenu;
        com.tencent.qqnt.chats.core.ui.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMenu");
            eVar = null;
        }
        if (eVar.j()) {
            com.tencent.qqnt.chats.core.ui.e eVar3 = this.bubbleMenu;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMenu");
            } else {
                eVar2 = eVar3;
            }
            eVar2.g();
            com.tencent.qqnt.chats.core.adapter.itemdata.b i3 = eVar2.i();
            if (i3 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                e(new a.j(eVar2.h(), (com.tencent.qqnt.chats.core.adapter.itemdata.g) i3));
            }
        }
    }

    public final boolean V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.mChatsAdapter.B0();
    }

    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return false;
    }

    public final boolean X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
        if (chatsDataLoadHelper != null) {
            return chatsDataLoadHelper.m();
        }
        return false;
    }

    public final void Y(@NotNull Object... payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) payload);
            return;
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.f(payload);
        }
    }

    public final void Z(@NotNull String uin, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) uin, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.a(uin, payload);
        }
    }

    public final void a0(@NotNull String uid, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) uid, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.c(uid, payload);
        }
    }

    @Override // com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        ViewGroup viewGroup;
        q3.d dVar;
        TwoLevelHeader twoLevelHeader;
        q3.a aVar;
        AnimRefreshHeaderView animRefreshHeaderView;
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) uiEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (QLog.isColorLevel()) {
            QLog.d(z(), 2, "handleUiEvent: " + uiEvent);
        }
        if (uiEvent instanceof a.s) {
            v0(((a.s) uiEvent).a());
            return;
        }
        if (uiEvent instanceof a.o) {
            n0();
            return;
        }
        if (uiEvent instanceof a.C9590a) {
            a.C9590a c9590a = (a.C9590a) uiEvent;
            if (c9590a.d()) {
                x0(c9590a.b(), c9590a.a());
                return;
            } else if (c9590a.c()) {
                n(c9590a.b(), c9590a.a());
                return;
            } else {
                i0(c9590a.b(), c9590a.a());
                return;
            }
        }
        if (uiEvent instanceof a.n) {
            m0();
            com.tencent.qqnt.chats.api.b bVar = this.dtReport;
            if (bVar != null) {
                bVar.e();
                return;
            }
            return;
        }
        if (uiEvent instanceof a.k) {
            k0(((a.k) uiEvent).a());
            return;
        }
        if (uiEvent instanceof a.l) {
            M((a.l) uiEvent);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = null;
        if (uiEvent instanceof a.f) {
            String z16 = z();
            ChatsListConfig chatsListConfig = ChatsListConfig.f354433a;
            QLog.d(z16, 1, "EnableListAnim: config.enableAnim = " + chatsListConfig.b());
            if (this.mBuilder.e() != 1) {
                return;
            }
            if (chatsListConfig.b() && !com.tencent.qqnt.util.b.f362976b.isSplitViewMode(C())) {
                if (!(D().getItemAnimator() instanceof DefaultScaleInAnimator)) {
                    D().setItemAnimator(new DefaultScaleInAnimator());
                    return;
                }
                return;
            } else {
                if (D().getItemAnimator() != null) {
                    D().setItemAnimator(null);
                    return;
                }
                return;
            }
        }
        if (uiEvent instanceof a.e) {
            QLog.d(z(), 1, "DisableListAnim");
            D().setItemAnimator(null);
            return;
        }
        if (uiEvent instanceof a.j) {
            QLog.d(z(), 1, "OverrideListAnim");
            if (ChatsListConfig.f354433a.b() && !com.tencent.qqnt.util.b.f362976b.isSplitViewMode(C())) {
                D().setItemAnimator(((a.j) uiEvent).a());
                return;
            }
            return;
        }
        if (uiEvent instanceof a.b) {
            a.b bVar2 = (a.b) uiEvent;
            QLog.d(z(), 1, "set sk list view show: " + bVar2.a());
            w0(bVar2.a());
            return;
        }
        if (uiEvent instanceof a.r) {
            a.r rVar = (a.r) uiEvent;
            QLog.d(z(), 1, "setTopPadding: " + rVar.a());
            D().setPadding(D().getPaddingLeft(), rVar.a(), D().getPaddingRight(), D().getPaddingBottom());
            q3.f fVar = this.listScrollView;
            if (fVar != null) {
                dVar = fVar.e();
            } else {
                dVar = null;
            }
            if (dVar instanceof TwoLevelHeader) {
                twoLevelHeader = (TwoLevelHeader) dVar;
            } else {
                twoLevelHeader = null;
            }
            if (twoLevelHeader != null) {
                aVar = twoLevelHeader.h();
            } else {
                aVar = null;
            }
            ConstraintLayout constraintLayout = this.thirdContainerView;
            if (constraintLayout != null) {
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), rVar.a(), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
            }
            if (aVar instanceof AnimRefreshHeaderView) {
                animRefreshHeaderView = (AnimRefreshHeaderView) aVar;
            } else {
                animRefreshHeaderView = null;
            }
            if (animRefreshHeaderView != null) {
                animRefreshHeaderView.setTopPadding(rVar.a());
            }
            LinearLayout linearLayout = this.mSkView;
            if (linearLayout != null) {
                int a16 = rVar.a();
                ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams2 = layoutParams3;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = a16;
                    layoutParams = marginLayoutParams;
                } else {
                    ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
                    if (layoutParams4 != null) {
                        i3 = layoutParams4.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams5 = linearLayout.getLayoutParams();
                    if (layoutParams5 != null) {
                        i16 = layoutParams5.height;
                    } else {
                        i16 = 0;
                    }
                    Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance).topMargin = a16;
                        layoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                linearLayout.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (uiEvent instanceof a.i) {
            ChatsColorCache.f355526a.q(C());
            SkinEngine.invalidateAll(D());
            ((IChatsFreControlHelper) QRoute.api(IChatsFreControlHelper.class)).notifyRefreshAll(12);
            this.mChatsAdapter.notifyDataSetChanged();
            return;
        }
        if (uiEvent instanceof a.q) {
            a.q qVar = (a.q) uiEvent;
            QLog.i(z(), 1, "SetRefreshEnable: " + qVar.a() + ", src: " + qVar.b());
            q3.f fVar2 = this.listScrollView;
            if (fVar2 != null) {
                fVar2.a(qVar.a());
                return;
            }
            return;
        }
        if (uiEvent instanceof a.m) {
            l0(((a.m) uiEvent).a());
            return;
        }
        if (uiEvent instanceof a.g) {
            a.g gVar = (a.g) uiEvent;
            E(gVar.b(), gVar.a());
            return;
        }
        if (uiEvent instanceof a.x) {
            a.x xVar = (a.x) uiEvent;
            a0(xVar.b(), xVar.a());
            return;
        }
        if (uiEvent instanceof a.w) {
            Y(((a.w) uiEvent).a());
            return;
        }
        if (uiEvent instanceof a.c) {
            QLog.d(z(), 1, "CheckRVHasPendingUpdate: " + D().hasPendingAdapterUpdates());
            if (D().hasPendingAdapterUpdates()) {
                D().requestLayout();
                return;
            }
            return;
        }
        if (uiEvent instanceof a.v) {
            b(a.f.f355010a);
            l lVar = this.chatsLockHelper;
            if (lVar != null) {
                lVar.b(((a.v) uiEvent).a());
                return;
            }
            return;
        }
        if (uiEvent instanceof a.h) {
            D().setItemAnimator(null);
            l lVar2 = this.chatsLockHelper;
            if (lVar2 != null) {
                lVar2.a(((a.h) uiEvent).a());
                return;
            }
            return;
        }
        if ((uiEvent instanceof a.y) && (viewGroup = this.refreshList) != null) {
            viewGroup.setBackground(((a.y) uiEvent).a());
        }
    }

    public final void b0(@NotNull List<String> uin, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) uin, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.e(uin, payload);
        }
    }

    public final void c0(@NotNull List<String> uid, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) uid, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.d(uid, payload);
        }
    }

    public void d0(@NotNull b viewParams) {
        com.tencent.qqnt.chats.core.ui.third.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) viewParams);
            return;
        }
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        QLog.d(z(), 1, "onCreateView");
        u0(viewParams.a());
        this.dragFrameLayout = viewParams.c();
        this.thirdContainerView = viewParams.h();
        this.refreshList = viewParams.g();
        com.tencent.qqnt.chats.core.ui.third.e eVar2 = this.thirdContainer;
        if (eVar2 != null) {
            eVar2.k();
        }
        ConstraintLayout constraintLayout = this.thirdContainerView;
        if (constraintLayout != null) {
            eVar = new com.tencent.qqnt.chats.core.ui.third.e(constraintLayout, D(), this.mChatsAdapter, new j());
        } else {
            eVar = null;
        }
        this.thirdContainer = eVar;
        this.listScrollView = viewParams.f();
        t0(viewParams.b());
        this.bubbleMenu = new com.tencent.qqnt.chats.core.ui.e(C(), new Function3<Integer, com.tencent.qqnt.chats.core.adapter.itemdata.b, Integer, Unit>() { // from class: com.tencent.qqnt.chats.core.ui.ChatsListVB$onCreateView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatsListVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.tencent.qqnt.chats.core.adapter.itemdata.b bVar, Integer num2) {
                invoke(num.intValue(), bVar, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), item, Integer.valueOf(i16));
                    return;
                }
                Intrinsics.checkNotNullParameter(item, "item");
                if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    ChatsListVB.this.e(new a.i(i3, (com.tencent.qqnt.chats.core.adapter.itemdata.g) item, i16));
                }
            }
        });
        q0(new HighLightManager(D(), this.mChatsAdapter));
        ChatsVBUpdateControlHelper chatsVBUpdateControlHelper = new ChatsVBUpdateControlHelper(this.mChatsAdapter, D());
        this.updateControlHelper = chatsVBUpdateControlHelper;
        this.mChatsAdapter.T0(chatsVBUpdateControlHelper);
        for (Map.Entry<Integer, View> entry : viewParams.d().entrySet()) {
            this.mChatsAdapter.V0(entry.getKey().intValue(), entry.getValue(), false);
        }
        S();
        R();
        Q();
        QLog.d(z(), 1, "onCreateView finish");
        f();
        P();
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        QLog.d(z(), 1, "onDestroyView");
        com.tencent.qqnt.chats.api.b bVar = this.dtReport;
        if (bVar != null) {
            bVar.onClear();
        }
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.k();
        }
        ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).updateChatsListReport(this.mBuilder.e(), null);
        g();
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.onBackground();
        }
    }

    public final void g0(@Nullable Bundle savedInstanceState) {
        Parcelable parcelable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) savedInstanceState);
            return;
        }
        if (!ChatsListConfig.f354433a.h()) {
            return;
        }
        if (savedInstanceState != null) {
            parcelable = savedInstanceState.getParcelable("chats_list_state");
        } else {
            parcelable = null;
        }
        if (parcelable == null) {
            return;
        }
        this.curSavePos = parcelable;
        QLog.d(z(), 1, "[onRestoreInstanceState] is call. has data!");
    }

    public final void h0(@NotNull Bundle outState) {
        LinearLayoutManager linearLayoutManager;
        Parcelable onSaveInstanceState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) outState);
            return;
        }
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (!ChatsListConfig.f354433a.h()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = D().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null && (onSaveInstanceState = linearLayoutManager.onSaveInstanceState()) != null) {
            QLog.d(z(), 1, "[onSaveInstanceState] is call. need to store!");
            outState.putParcelable("chats_list_state", onSaveInstanceState);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.n
    public boolean handleBackPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return n.a.a(this);
    }

    public void i0(@NotNull View view, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view, type);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        this.mChatsAdapter.R0(view, type);
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.w();
        }
    }

    public final void j0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, type);
        } else {
            this.mChatsAdapter.Q0(type);
        }
    }

    public final void l0(@Nullable String chatUid) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) chatUid);
            return;
        }
        if (!TextUtils.isEmpty(chatUid)) {
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = this.mChatsAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "mChatsAdapter.currentList");
            Iterator<com.tencent.qqnt.chats.core.adapter.itemdata.b> it = currentList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.b next = it.next();
                    if ((next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && Intrinsics.areEqual(((com.tencent.qqnt.chats.core.adapter.itemdata.g) next).k(), chatUid)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                D().smoothScrollToPosition(i3);
            }
        }
    }

    public void n(@NotNull View view, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) view, type);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        this.mChatsAdapter.q0(view, type);
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.w();
        }
    }

    public final void n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        if (W()) {
            ChatsDataLoadHelper chatsDataLoadHelper = this.loadHelper;
            if (chatsDataLoadHelper != null) {
                chatsDataLoadHelper.k();
                return;
            }
            return;
        }
        com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(D(), 0);
    }

    public final void o0(@Nullable com.tencent.qqnt.chats.core.ui.listener.a chatsListListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) chatsListListener);
        } else {
            this.chatsListListener = chatsListListener;
        }
    }

    public void onResume() {
        KeyEvent.Callback callback;
        final View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        o oVar = this.updateControlHelper;
        if (oVar != null) {
            oVar.onForeground();
        }
        WeakReference<View> weakReference = this.clickItemRef;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            callback = (View) weakReference.get();
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup = (ViewGroup) callback;
        }
        if (viewGroup != null && (childAt = viewGroup.getChildAt(0)) != null) {
            com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(childAt, this) { // from class: com.tencent.qqnt.chats.core.ui.ChatsListVB$onResume$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $it;
                final /* synthetic */ ChatsListVB this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$it = childAt;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) childAt, (Object) this);
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
                        this.$it.sendAccessibilityEvent(8);
                        this.this$0.clickItemRef = null;
                    }
                }
            });
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (this.mRecyclerView != null) {
            RecyclerView.RecycledViewPool recycledViewPool = D().getRecycledViewPool();
            int recycledViewCount = recycledViewPool.getRecycledViewCount(-2);
            recycledViewPool.setMaxRecycledViews(-2, 0);
            recycledViewPool.setMaxRecycledViews(-2, recycledViewCount);
        }
    }

    public final void p0(int type, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, type, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        ChatsListAdapter.W0(this.mChatsAdapter, type, view, false, 4, null);
        o(type, view);
    }

    @NotNull
    public ChatsListAdapter q(@NotNull com.tencent.qqnt.chats.core.data.a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (ChatsListAdapter) iPatchRedirector.redirect((short) 41, (Object) this, (Object) builder);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new ChatsListAdapter(builder);
    }

    public final void q0(@NotNull HighLightManager highLightManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) highLightManager);
        } else {
            Intrinsics.checkNotNullParameter(highLightManager, "<set-?>");
            this.highLightManager = highLightManager;
        }
    }

    public void r(@NotNull a.b uiState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) uiState);
        } else {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
        }
    }

    public final void r0(boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, isShow);
            return;
        }
        this.mChatsAdapter.D0(isShow);
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.w();
        }
    }

    @NotNull
    public final ChatsListAdapter s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (ChatsListAdapter) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mChatsAdapter;
    }

    public final void s0(boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, isShow);
            return;
        }
        this.mChatsAdapter.E0(isShow);
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.w();
        }
    }

    protected final void t0(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    @NotNull
    public final DTChatsReportManager.b u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (DTChatsReportManager.b) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.dtListOpProvider;
    }

    protected final void u0(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.mRecyclerView = recyclerView;
        }
    }

    @Nullable
    public final com.tencent.qqnt.chats.api.b v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.qqnt.chats.api.b) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.dtReport;
    }

    @NotNull
    public final HighLightManager w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HighLightManager) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HighLightManager highLightManager = this.highLightManager;
        if (highLightManager != null) {
            return highLightManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("highLightManager");
        return null;
    }

    @Nullable
    protected final q3.f x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (q3.f) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.listScrollView;
    }

    public void x0(@NotNull View view, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view, type);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mChatsAdapter.h1(view, type);
        }
    }

    @Nullable
    public final ChatsDataLoadHelper y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ChatsDataLoadHelper) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.loadHelper;
    }

    public void y0(@NotNull List<? extends View> views) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) views);
        } else {
            Intrinsics.checkNotNullParameter(views, "views");
            this.mChatsAdapter.g1(views);
        }
    }

    @NotNull
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "ChatsListVB";
    }

    public final void z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.core.ui.third.e eVar = this.thirdContainer;
        if (eVar != null) {
            eVar.w();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010)\u0012$\b\u0002\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.`/\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u000f\u0010\u001cR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010(\u001a\u0004\u0018\u00010$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u0019\u0010,\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b!\u0010*\u001a\u0004\b\u001f\u0010+R3\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.`/8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b\u001a\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "chatsList", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "b", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "c", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", tl.h.F, "()Landroidx/constraintlayout/widget/ConstraintLayout;", "thirdContainer", "Landroid/content/Context;", "d", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "g", "()Landroid/view/ViewGroup;", "refreshList", "Lq3/f;", "f", "Lq3/f;", "()Lq3/f;", "recyclerScroll", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "lightInteractionView", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "fixedHeaderView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/content/Context;Landroid/view/ViewGroup;Lq3/f;Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;Ljava/util/HashMap;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView chatsList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QUIBadgeDragLayout dragArea;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ConstraintLayout thirdContainer;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ViewGroup refreshList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final q3.f recyclerScroll;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final LIAAnimView lightInteractionView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<Integer, View> fixedHeaderView;

        public b(@NotNull RecyclerView chatsList, @NotNull QUIBadgeDragLayout dragArea, @Nullable ConstraintLayout constraintLayout, @NotNull Context context, @Nullable ViewGroup viewGroup, @Nullable q3.f fVar, @Nullable LIAAnimView lIAAnimView, @NotNull HashMap<Integer, View> fixedHeaderView) {
            Intrinsics.checkNotNullParameter(chatsList, "chatsList");
            Intrinsics.checkNotNullParameter(dragArea, "dragArea");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fixedHeaderView, "fixedHeaderView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, chatsList, dragArea, constraintLayout, context, viewGroup, fVar, lIAAnimView, fixedHeaderView);
                return;
            }
            this.chatsList = chatsList;
            this.dragArea = dragArea;
            this.thirdContainer = constraintLayout;
            this.context = context;
            this.refreshList = viewGroup;
            this.recyclerScroll = fVar;
            this.lightInteractionView = lIAAnimView;
            this.fixedHeaderView = fixedHeaderView;
        }

        @NotNull
        public final RecyclerView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RecyclerView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.chatsList;
        }

        @NotNull
        public final Context b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.context;
        }

        @NotNull
        public final QUIBadgeDragLayout c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (QUIBadgeDragLayout) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.dragArea;
        }

        @NotNull
        public final HashMap<Integer, View> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.fixedHeaderView;
        }

        @Nullable
        public final LIAAnimView e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (LIAAnimView) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.lightInteractionView;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.chatsList, bVar.chatsList) && Intrinsics.areEqual(this.dragArea, bVar.dragArea) && Intrinsics.areEqual(this.thirdContainer, bVar.thirdContainer) && Intrinsics.areEqual(this.context, bVar.context) && Intrinsics.areEqual(this.refreshList, bVar.refreshList) && Intrinsics.areEqual(this.recyclerScroll, bVar.recyclerScroll) && Intrinsics.areEqual(this.lightInteractionView, bVar.lightInteractionView) && Intrinsics.areEqual(this.fixedHeaderView, bVar.fixedHeaderView)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final q3.f f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (q3.f) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.recyclerScroll;
        }

        @Nullable
        public final ViewGroup g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ViewGroup) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.refreshList;
        }

        @Nullable
        public final ConstraintLayout h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ConstraintLayout) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.thirdContainer;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
            }
            int hashCode4 = ((this.chatsList.hashCode() * 31) + this.dragArea.hashCode()) * 31;
            ConstraintLayout constraintLayout = this.thirdContainer;
            int i3 = 0;
            if (constraintLayout == null) {
                hashCode = 0;
            } else {
                hashCode = constraintLayout.hashCode();
            }
            int hashCode5 = (((hashCode4 + hashCode) * 31) + this.context.hashCode()) * 31;
            ViewGroup viewGroup = this.refreshList;
            if (viewGroup == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = viewGroup.hashCode();
            }
            int i16 = (hashCode5 + hashCode2) * 31;
            q3.f fVar = this.recyclerScroll;
            if (fVar == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = fVar.hashCode();
            }
            int i17 = (i16 + hashCode3) * 31;
            LIAAnimView lIAAnimView = this.lightInteractionView;
            if (lIAAnimView != null) {
                i3 = lIAAnimView.hashCode();
            }
            return ((i17 + i3) * 31) + this.fixedHeaderView.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "ViewParams(chatsList=" + this.chatsList + ", dragArea=" + this.dragArea + ", thirdContainer=" + this.thirdContainer + ", context=" + this.context + ", refreshList=" + this.refreshList + ", recyclerScroll=" + this.recyclerScroll + ", lightInteractionView=" + this.lightInteractionView + ", fixedHeaderView=" + this.fixedHeaderView + ")";
        }

        public /* synthetic */ b(RecyclerView recyclerView, QUIBadgeDragLayout qUIBadgeDragLayout, ConstraintLayout constraintLayout, Context context, ViewGroup viewGroup, q3.f fVar, LIAAnimView lIAAnimView, HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(recyclerView, qUIBadgeDragLayout, constraintLayout, context, (i3 & 16) != 0 ? null : viewGroup, (i3 & 32) != 0 ? null : fVar, (i3 & 64) != 0 ? null : lIAAnimView, (i3 & 128) != 0 ? new HashMap() : hashMap);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, recyclerView, qUIBadgeDragLayout, constraintLayout, context, viewGroup, fVar, lIAAnimView, hashMap, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }
}
