package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.common.app.AppInterface;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.flock.api.JoinFlockAndTroopResult;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.data.login.nano.LoginBusinessData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.minigame.api.impl.MiniGameHippyApiImpl;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchEnumJumpType;
import com.tencent.mobileqq.search.searchdetail.eventbus.ChangeTabEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.util.LoadingUtil;
import com.tencent.util.NumberUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001aZ\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a6\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001a\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\u001a(\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00172\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001aB\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001a6\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001aT\u0010\"\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00072:\b\u0002\u0010!\u001a4\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001cH\u0002\u001aH\u0010#\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001aH\u0010$\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001a4\u0010%\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001ah\u0010/\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070&2\u0006\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u0007H\u0002\u001a(\u00100\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001a\u0018\u00103\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002\u001a\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0000H\u0002\u001a:\u00105\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001a*\u00109\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001a0\u0010:\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001a.\u0010;\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002\u001a4\u0010<\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001a<\u0010=\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u001a(\u0010A\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0002\u001a\u0014\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u001a(\u0010F\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0007H\u0002\u001a0\u0010I\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0017H\u0002\u001a\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0007H\u0002\u00a8\u0006K"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jump", "", "i", "Landroid/content/Context;", "context", "moreJumpInfo", "", "keyword", "traceId", "", "tabMask", "", "extensionMap", "Lcom/tencent/mobileqq/search/searchdetail/d;", "dtReportIoc", "", "g", LayoutAttrDefine.CLICK_URI, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "ctx", "url", "o", "", "p", "y", HippyTKDListViewAdapter.X, "feed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", "j", "f", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "", "feedPbTokens", "pageToken", "playIndex", "playPosition", "sourceType", "subSourceType", "useOneDragN", "pageName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "B", "E", "l", "Lcom/tencent/mobileqq/troop/troopjoin/a;", "joinTroopParam", "troopUin", "G", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "H", "tagName", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "t", "Landroid/app/Activity;", tl.h.F, "hostScene", "sceneNote", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "appId", "path", "u", "r", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchDetailUtilKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284941a;

        static {
            int[] iArr = new int[QSearchEnumJumpType.values().length];
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GUILD_OPENCHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GUILD_TOPIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GUILD_AGGREGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_H5.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_TAB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GUILD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GUILD_ARTICLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_QEVENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_PYMK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_USER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_CIRCLE_FEED_DETAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_CIRCLE_USER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_CIRCLE_HOT_TAG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GROUP_JOIN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_GROUP_INFO_CARD.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_JOIN_GUILD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_QQ_SEARCH_TOPIC.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_LIKE_FEED_CLICK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_SHARE_FEED_CLICK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[QSearchEnumJumpType.JUMP_TYPE_MINI_APP.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            f284941a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/util/QSearchDetailUtilKt$b", "Lcom/tencent/mobileqq/flock/api/a;", "Lcom/tencent/mobileqq/flock/api/JoinFlockAndTroopResult;", "result", "", "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.flock.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f284942a;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f284943a;

            static {
                int[] iArr = new int[JoinFlockAndTroopResult.values().length];
                try {
                    iArr[JoinFlockAndTroopResult.SYS_ERROR.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[JoinFlockAndTroopResult.PARAMS_ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f284943a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super String, Unit> function2) {
            this.f284942a = function2;
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void a(@NotNull JoinFlockAndTroopResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Function2<Integer, String, Unit> function2 = this.f284942a;
            if (function2 != null) {
                function2.invoke(0, "");
            }
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void b(@NotNull JoinFlockAndTroopResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = a.f284943a[result.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    Function2<Integer, String, Unit> function2 = this.f284942a;
                    if (function2 != null) {
                        function2.invoke(3, "\u5176\u4ed6\u5f02\u5e38");
                        return;
                    }
                    return;
                }
                Function2<Integer, String, Unit> function22 = this.f284942a;
                if (function22 != null) {
                    function22.invoke(2, "\u53c2\u6570\u5f02\u5e38");
                    return;
                }
                return;
            }
            Function2<Integer, String, Unit> function23 = this.f284942a;
            if (function23 != null) {
                function23.invoke(1, "\u7cfb\u7edf\u5f02\u5e38");
            }
        }
    }

    private static final void A(String str, Context context, long j3, Map<String, String> map) {
        boolean startsWith$default;
        String str2;
        boolean isBlank;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", str);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonMethodArgs.toString()");
        if (((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isLaunchByMiniApp(context)) {
            ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).openUrl(context, jSONObject2);
            return;
        }
        String url = new JSONObject(jSONObject2).optString("url");
        if (((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).checkIfOpenFloatInCurProcess(url)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, MiniGameHippyApiImpl.MQQ_GUILD_GUILD_OPEN_FEEDD_ETAIL, false, 2, null);
        if (startsWith$default) {
            if (map == null || (str2 = map.get("sgrp_channel_extension_info")) == null) {
                str2 = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                String jSONObject3 = new JSONObject().put("tabMask", j3).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().put(\"tabMask\", tabMask).toString()");
                Uri.Builder buildUpon = Uri.parse(url).buildUpon();
                buildUpon.appendQueryParameter("sgrp_channel_extension_info", str2);
                buildUpon.appendQueryParameter("param_key_search_extension_info", jSONObject3);
                buildUpon.appendQueryParameter("businessType", "29");
                url = buildUpon.build().toString();
            }
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        o(context, url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(feedCloudMeta$StFeed.poster.f398463id.get());
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void C(Context context, String str, long j3, Map<String, String> map, com.tencent.mobileqq.search.searchdetail.d dVar) {
        int i3;
        String str2;
        String str3;
        int i16;
        String str4;
        int parseInt;
        int e16;
        Activity h16;
        String str5;
        String str6;
        String str7;
        if (dVar != null) {
            i3 = dVar.getUserSource();
        } else {
            i3 = -1;
        }
        String str8 = "";
        if (map == null || (str7 = map.get("uin")) == null) {
            str2 = "";
        } else {
            str2 = str7;
        }
        if (map == null || (str6 = map.get(AuthDevOpenUgActivity.KEY_PHONE_NUM)) == null) {
            str3 = "";
        } else {
            str3 = str6;
        }
        if (map != null) {
            try {
                str4 = map.get("user_type");
            } catch (Exception unused) {
                i16 = 2;
            }
            if (str4 != null) {
                parseInt = Integer.parseInt(str4);
                i16 = parseInt;
                if (map != null && (str5 = map.get("name")) != null) {
                    str8 = str5;
                }
                e16 = s.f285072a.e(i3, false, j3, str);
                if (e16 <= -1) {
                    e16 = 3;
                }
                SearchResultItem searchResultItem = new SearchResultItem();
                searchResultItem.G = 84;
                searchResultItem.f283460d = NumberUtil.stringToLong(str2);
                searchResultItem.f283462f = str8;
                searchResultItem.H = i16;
                if (i16 == 2) {
                    searchResultItem.f283460d = 0L;
                    searchResultItem.f283463h = str3;
                }
                if (i16 == 3) {
                    searchResultItem.F = 1;
                }
                h16 = h(context);
                if (h16 == null) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                    ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity(h16, searchResultItem, (AppInterface) peekAppRuntime, true, e16);
                    return;
                }
                return;
            }
        }
        parseInt = 2;
        i16 = parseInt;
        if (map != null) {
            str8 = str5;
        }
        e16 = s.f285072a.e(i3, false, j3, str);
        if (e16 <= -1) {
        }
        SearchResultItem searchResultItem2 = new SearchResultItem();
        searchResultItem2.G = 84;
        searchResultItem2.f283460d = NumberUtil.stringToLong(str2);
        searchResultItem2.f283462f = str8;
        searchResultItem2.H = i16;
        if (i16 == 2) {
        }
        if (i16 == 3) {
        }
        h16 = h(context);
        if (h16 == null) {
        }
    }

    private static final void D(final Context context, Map<String, String> map) {
        String str;
        boolean z16;
        if (map == null || (str = map.get("feedPb")) == null) {
            str = "";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aj.f284996a.a(str, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.mobileqq.search.util.QSearchDetailUtilKt$openQCirclePersonalDetailPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MessageMicro<?> pb5) {
                    Intrinsics.checkNotNullParameter(pb5, "pb");
                    if (pb5 instanceof FeedCloudMeta$StFeed) {
                        QSearchDetailUtilKt.B(context, (FeedCloudMeta$StFeed) pb5);
                    }
                }
            });
            return;
        }
        QLog.e("QSearchDetailUtil", 2, "openQCirclePersonalDetailPage error", "pbToken=" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void E(Context context, SearchJump searchJump) {
        String str;
        String str2;
        boolean z16;
        String str3 = "";
        boolean z17 = true;
        try {
            JSONObject jSONObject = new JSONObject(searchJump.getStringExtension());
            str2 = jSONObject.optString("tag_name", "");
            Intrinsics.checkNotNullExpressionValue(str2, "extension.optString(\"tag_name\", \"\")");
            try {
                str = jSONObject.optString("tag_id", "");
                Intrinsics.checkNotNullExpressionValue(str, "extension.optString(\"tag_id\", \"\")");
                try {
                    QLog.i("QSearchDetailUtil", 1, "openQFSHotTagPage:  extension:" + searchJump.getStringExtension() + "  hotTagName:" + str2 + "    hotTagId:" + str);
                } catch (Exception e16) {
                    e = e16;
                    str3 = str2;
                    QLog.i("QSearchDetailUtil", 1, "openQFSHotTagPage:    exception:" + e);
                    str2 = str3;
                    if (str2.length() != 0) {
                    }
                    if (z16) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
        } catch (Exception e18) {
            e = e18;
            str = "";
        }
        if (str2.length() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (str.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
                feedCloudMeta$StTagInfo.tagName.set(str2);
                qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
                qCirclePolymerizationBean.setPolymerizationType(7);
                com.tencent.biz.qqcircle.launcher.c.j0(context, qCirclePolymerizationBean);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void F(Context context, Map<String, String> map, com.tencent.mobileqq.search.searchdetail.d dVar) {
        ArrayList arrayList;
        String str;
        String str2;
        boolean z16;
        try {
            arrayList = new ArrayList();
            if (map != null && (str = map.get("feedPbTokens")) != null) {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        str2 = optJSONObject.optString("feedPb");
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Exception unused) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        Context context2 = dVar;
        if (dVar == 0) {
            context2 = context;
        }
        String valueOf = String.valueOf(context2.hashCode());
        long j3 = 0;
        if (map != null) {
            try {
                String str3 = map.get("playPosition");
                if (str3 != null) {
                    j3 = Long.parseLong(str3);
                }
            } catch (Exception unused2) {
            }
        }
        q(context, arrayList2, valueOf, 0, j3, 70, 0, false, "", "qsearch_detail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Context context, com.tencent.mobileqq.troop.troopjoin.a aVar, final String str, final com.tencent.mobileqq.search.searchdetail.d dVar) {
        ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).tryLaunchJoinTroop(context, aVar, false, new Function2<TryJoinTroopResult, Integer, Unit>() { // from class: com.tencent.mobileqq.search.util.QSearchDetailUtilKt$originJoinTroop$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes18.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f284944a;

                static {
                    int[] iArr = new int[TryJoinTroopResult.values().length];
                    try {
                        iArr[TryJoinTroopResult.HAS_JOINED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TryJoinTroopResult.HAS_LAUNCH.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[TryJoinTroopResult.PARAMS_ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f284944a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult, Integer num) {
                invoke(tryJoinTroopResult, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TryJoinTroopResult result, int i3) {
                Integer num;
                Intrinsics.checkNotNullParameter(result, "result");
                int i16 = a.f284944a[result.ordinal()];
                if (i16 == 1) {
                    num = 0;
                } else if (i16 != 2) {
                    num = i16 != 3 ? null : 1;
                } else {
                    num = 2;
                }
                if (num != null) {
                    String str2 = str;
                    com.tencent.mobileqq.search.searchdetail.d dVar2 = dVar;
                    num.intValue();
                    com.tencent.mobileqq.search.searchdetail.content.template.d.f284208a.a(str2, num.intValue(), dVar2);
                }
            }
        });
    }

    private static final void H(SearchJump searchJump, Context context, Map<String, String> map, com.tencent.mobileqq.search.searchdetail.d dVar) {
        Object m476constructorimpl;
        CoroutineScope coroutineScope;
        String str = searchJump.stringExtension;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("feed_id", "");
            jSONObject.optString("guild_id", "0");
            jSONObject.optString("channel_id", "0");
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
            if (dVar != null && (coroutineScope = dVar.getCoroutineScope()) != null) {
                bVar = CorountineFunKt.e(coroutineScope, "request do vote", null, null, null, new QSearchDetailUtilKt$shareFeedClick$1$1(context, optString, null), 14, null);
            }
            m476constructorimpl = Result.m476constructorimpl(bVar);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("QSearchDetailUtil", 1, "error " + m479exceptionOrNullimpl.getCause() + "\nshareFeedClick param = [" + searchJump + "]");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void f(Context context, String str, long j3, Map<String, String> map, com.tencent.mobileqq.search.searchdetail.d dVar) {
        int i3;
        String str2;
        String str3;
        int i16;
        String str4;
        int parseInt;
        String str5;
        int d16;
        int i17;
        int e16;
        int i18;
        int i19;
        String str6;
        String str7;
        String str8;
        String str9;
        if (dVar != null) {
            i3 = dVar.getUserSource();
        } else {
            i3 = -1;
        }
        if (map == null || (str9 = map.get("uin")) == null) {
            str2 = "";
        } else {
            str2 = str9;
        }
        if (map == null || (str8 = map.get(AuthDevOpenUgActivity.KEY_PHONE_NUM)) == null) {
            str3 = "";
        } else {
            str3 = str8;
        }
        if (map != null) {
            try {
                str4 = map.get("user_type");
            } catch (Exception unused) {
                i16 = 2;
            }
            if (str4 != null) {
                parseInt = Integer.parseInt(str4);
                i16 = parseInt;
                if (map != null || (str7 = map.get("name")) == null) {
                    str5 = "";
                } else {
                    str5 = str7;
                }
                s sVar = s.f285072a;
                d16 = sVar.d(str);
                if (d16 <= -1) {
                    i17 = d16;
                } else {
                    i17 = 3020;
                }
                e16 = sVar.e(i3, true, j3, str);
                if (e16 <= -1) {
                    i18 = e16;
                } else {
                    i18 = 3;
                }
                if (i16 != 2) {
                    str6 = str3;
                    i19 = 2;
                } else {
                    i19 = 1;
                    str6 = str2;
                }
                QLog.i("QSearchDetailUtil", 4, "addFriendWithParams     keyword:" + str + "   tabMask:" + j3 + "   sourceId:" + i17 + "   paramId:" + d16 + "   paramSubId:" + e16 + "   subSourceId:" + i18);
                Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, i19, str6, null, i17, i18, str5, null, null, context.getString(R.string.f170028dd), null);
                Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(IAddFriendApi::class\u2026.add),\n        null\n    )");
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend);
            }
        }
        parseInt = 2;
        i16 = parseInt;
        if (map != null) {
        }
        str5 = "";
        s sVar2 = s.f285072a;
        d16 = sVar2.d(str);
        if (d16 <= -1) {
        }
        e16 = sVar2.e(i3, true, j3, str);
        if (e16 <= -1) {
        }
        if (i16 != 2) {
        }
        QLog.i("QSearchDetailUtil", 4, "addFriendWithParams     keyword:" + str + "   tabMask:" + j3 + "   sourceId:" + i17 + "   paramId:" + d16 + "   paramSubId:" + e16 + "   subSourceId:" + i18);
        Intent startAddFriend2 = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, i19, str6, null, i17, i18, str5, null, null, context.getString(R.string.f170028dd), null);
        Intrinsics.checkNotNullExpressionValue(startAddFriend2, "api(IAddFriendApi::class\u2026.add),\n        null\n    )");
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(@Nullable Context context, @Nullable SearchJump searchJump, @NotNull String keyword, @NotNull String traceId, long j3, @Nullable Map<String, String> map, @Nullable com.tencent.mobileqq.search.searchdetail.d dVar) {
        boolean z16;
        boolean z17;
        Integer num;
        Integer num2;
        int i3;
        String str;
        int i16;
        int i17;
        String str2;
        int i18;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (searchJump == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (context == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (searchJump != null) {
            num = Integer.valueOf(searchJump.type);
        } else {
            num = null;
        }
        if (map != null) {
            num2 = Integer.valueOf(map.size());
        } else {
            num2 = null;
        }
        QLog.i("QSearchDetailUtil", 1, "allInOneJump:    moreJumpInfo == null:" + z16 + "   context == null:" + z17 + "   moreJumpInfo.type:" + num + "  tabMask:" + j3 + "  extensionMap length:" + num2);
        if (searchJump != null && context != null) {
            QSearchEnumJumpType a16 = QSearchEnumJumpType.INSTANCE.a(searchJump.type);
            if (a16 == null) {
                i3 = -1;
            } else {
                i3 = a.f284941a[a16.ordinal()];
            }
            String str5 = "";
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                    String str6 = searchJump.jumpLink;
                    Intrinsics.checkNotNullExpressionValue(str6, "moreJumpInfo.jumpLink");
                    A(str6, context, j3, map);
                    return;
                case 5:
                    p(searchJump.tabMask, map);
                    return;
                case 6:
                    y(context, searchJump, keyword, traceId, map);
                    return;
                case 7:
                    x(context, searchJump, j3, map);
                    return;
                case 8:
                    String str7 = searchJump.jumpLink;
                    Intrinsics.checkNotNullExpressionValue(str7, "moreJumpInfo.jumpLink");
                    k(context, str7, null, 4, null);
                    return;
                case 9:
                    f(context, keyword, j3, map, dVar);
                    return;
                case 10:
                    C(context, keyword, j3, map, dVar);
                    return;
                case 11:
                    F(context, map, dVar);
                    return;
                case 12:
                    D(context, map);
                    return;
                case 13:
                    E(context, searchJump);
                    return;
                case 14:
                    l(context, searchJump, map, dVar);
                    return;
                case 15:
                    w(context, searchJump, map);
                    return;
                case 16:
                    m(context, searchJump, map);
                    return;
                case 17:
                    String str8 = searchJump.stringExtension;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        str = Result.m476constructorimpl("#" + new JSONObject(str8).optString("tag_name", ""));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        str = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m479exceptionOrNullimpl(str) == null) {
                        str5 = str;
                    }
                    String str9 = str5;
                    if (dVar != null) {
                        i16 = dVar.getQuerySource();
                    } else {
                        i16 = 0;
                    }
                    if (dVar != null) {
                        i17 = dVar.getUserSource();
                    } else {
                        i17 = 0;
                    }
                    t(context, str9, i16, i17);
                    return;
                case 18:
                    v(searchJump, map, dVar);
                    return;
                case 19:
                    H(searchJump, context, map, dVar);
                    return;
                case 20:
                    if (map == null || (str4 = map.get("host_scene")) == null) {
                        str2 = "";
                    } else {
                        str2 = str4;
                    }
                    try {
                        i18 = RFWStringsKt.toIntOrDefault$default(str2, 0, 0, 2, null);
                    } catch (Exception e16) {
                        com.tencent.mobileqq.guild.util.s.e("QSearchDetailUtil", "error hostScene:" + str2 + " " + searchJump, e16);
                        i18 = 0;
                    }
                    if (map != null && (str3 = map.get(StartupReportKey.SCENE_NOTE)) != null) {
                        str5 = str3;
                    }
                    z(context, searchJump, i18, str5);
                    return;
                default:
                    QLog.w("QSearchDetailUtil", 1, "can not found jump type " + searchJump.type);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity h(Context context) {
        if (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return h(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static final boolean i(@Nullable SearchJump searchJump) {
        boolean z16;
        if (searchJump == null) {
            return false;
        }
        if (searchJump.type == 0) {
            String str = searchJump.jumpLink;
            Intrinsics.checkNotNullExpressionValue(str, "jump.jumpLink");
            if (str.length() > 0) {
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

    private static final void j(Context context, String str, Function2<? super Integer, ? super String, Unit> function2) {
        Long longOrNull;
        long j3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            y45.b bVar = new y45.b();
            String troopUin = jSONObject.optString("troopUin");
            String authSig = jSONObject.optString("authSig");
            int optInt = jSONObject.optInt("hasJoined");
            String optString = jSONObject.optString("feedId");
            String optString2 = jSONObject.optString("userId");
            long optLong = jSONObject.optLong(WadlProxyConsts.CREATE_TIME);
            QLog.d("QSearchDetailUtil", 1, "#joinDaZi: troopUin=" + troopUin + ", hasJoined=" + optInt + ", feedId=" + optString);
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            bVar.f449367b = j3;
            Intrinsics.checkNotNullExpressionValue(authSig, "authSig");
            byte[] bytes = authSig.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bVar.f449381p = bytes;
            bVar.f449373h = optLong;
            bVar.f449366a = optString;
            y45.o oVar = new y45.o();
            oVar.f449449a = optString2;
            bVar.f449369d = oVar;
            y45.k kVar = new y45.k();
            kVar.f449418d = optInt;
            bVar.f449379n = kVar;
            ((IFlockLauncher) QRoute.api(IFlockLauncher.class)).addFlockAndJoinTroop(context, bVar, new b(function2), 1089);
        } catch (JSONException e16) {
            QLog.w("QSearchDetailUtil", 1, e16.getMessage(), e16);
        }
    }

    static /* synthetic */ void k(Context context, String str, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        j(context, str, function2);
    }

    private static final void l(final Context context, SearchJump searchJump, Map<String, String> map, final com.tencent.mobileqq.search.searchdetail.d dVar) {
        String str;
        Object m476constructorimpl;
        QLog.i("QSearchDetailUtil", 1, "joinGroup:    extension:" + searchJump.getStringExtension());
        try {
            JSONObject jSONObject = new JSONObject(searchJump.getStringExtension());
            String authSign = jSONObject.optString("join_group_auth");
            final String troopUin = jSONObject.optString("group_code");
            if (map == null || (str = map.get("subSourceId")) == null) {
                str = "1020";
            }
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            Intrinsics.checkNotNullExpressionValue(authSign, "authSign");
            final com.tencent.mobileqq.troop.troopjoin.a aVar = new com.tencent.mobileqq.troop.troopjoin.a(troopUin, authSign, Integer.parseInt(str), false, null, true, 24, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                final Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(context, 2, true);
                showOnlyLoadingImageDialog.show();
                ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).needShowSubTroopWithTroopId(troopUin, false, new Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>() { // from class: com.tencent.mobileqq.search.util.QSearchDetailUtilKt$joinGroup$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                        invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
                        Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
                        showOnlyLoadingImageDialog.dismiss();
                        if (z16) {
                            com.tencent.mobileqq.search.searchdetail.content.template.d dVar2 = com.tencent.mobileqq.search.searchdetail.content.template.d.f284208a;
                            String troopUin2 = troopUin;
                            Intrinsics.checkNotNullExpressionValue(troopUin2, "troopUin");
                            dVar2.a(troopUin2, 1, dVar);
                            ITroopJoinApi iTroopJoinApi = (ITroopJoinApi) QRoute.api(ITroopJoinApi.class);
                            Context context2 = context;
                            String troopUin3 = troopUin;
                            Intrinsics.checkNotNullExpressionValue(troopUin3, "troopUin");
                            iTroopJoinApi.showSwitchSubTroop(context2, troopUin3, subTroopInfo, 1002, "pg_qq_network_search_result_level2_page");
                            return;
                        }
                        Context context3 = context;
                        com.tencent.mobileqq.troop.troopjoin.a aVar2 = aVar;
                        String troopUin4 = troopUin;
                        Intrinsics.checkNotNullExpressionValue(troopUin4, "troopUin");
                        QSearchDetailUtilKt.G(context3, aVar2, troopUin4, dVar);
                    }
                });
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.i("QSearchDetailUtil", 1, "joinGroup:  onFailure  exception:" + m479exceptionOrNullimpl);
                G(context, aVar, troopUin, dVar);
            }
        } catch (Exception e16) {
            QLog.i("QSearchDetailUtil", 1, "joinGroup:    exception:" + e16);
        }
    }

    private static final void m(Context context, SearchJump searchJump, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        SearchGuildJump searchGuildJump = searchJump.guildJump;
        final String valueOf = String.valueOf(searchGuildJump.guildId);
        String str4 = searchGuildJump.joinGuildSig;
        String str5 = "";
        if (map == null || (str3 = map.get("guild_sub_source")) == null) {
            str = "";
        } else {
            str = str3;
        }
        QLog.d("QSearchDetailUtil", 1, "#joinChannel guildId=" + valueOf + ", mainSource=search, subSource=" + str);
        JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf, "", str4, "search", str);
        Bundle bundle = jumpGuildParam.extras;
        if (map != null && (str2 = map.get("sgrp_channel_extension_info")) != null) {
            str5 = str2;
        }
        bundle.putString("sgrp_channel_extension_info", str5);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByParam(context, jumpGuildParam, "QSearchDetailUtil", new Runnable() { // from class: com.tencent.mobileqq.search.util.q
            @Override // java.lang.Runnable
            public final void run() {
                QSearchDetailUtilKt.n(valueOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("guildId", guildId);
        jSONObject.put("status", 1);
        SimpleEventBus.getInstance().dispatchEvent(new QSearchPostEvent("update_guild_join_status", jSONObject));
    }

    private static final void o(Context context, String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https", false, 2, null);
            if (!startsWith$default2) {
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
                return;
            }
        }
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(context, str, null);
    }

    private static final void p(int i3, Map<String, String> map) {
        SimpleEventBus.getInstance().dispatchEvent(new ChangeTabEvent(new SearchDetailTabListViewModel.TabInfo(null, i3, 1, null), map));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void q(Context context, List<String> list, String str, int i3, long j3, int i16, int i17, boolean z16, String str2, String str3) {
        boolean z17;
        boolean z18;
        boolean isBlank;
        int size = list.size();
        ArrayList<MessageMicro> arrayList = new ArrayList();
        int i18 = 0;
        for (int i19 = 0; i19 < size; i19++) {
            MessageMicro<?> b16 = aj.f284996a.b(list.get(i19));
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        QLog.d("QSearchDetailUtil", 1, "#launchQCircleFeed: multiFeeds begin");
        ArrayList arrayList2 = new ArrayList();
        for (MessageMicro messageMicro : arrayList) {
            if (messageMicro instanceof FeedCloudMeta$StFeed) {
                arrayList2.add(messageMicro);
            }
        }
        if (arrayList2.isEmpty()) {
            QLog.w("QSearchDetailUtil", 1, "#launchQCircleFeed: no data");
            return;
        }
        QLog.d("QSearchDetailUtil", 1, "#launchQCircleFeed: feed size=" + arrayList2.size());
        if (z16) {
            if (str2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    z18 = false;
                    if (z18) {
                        QLog.w("QSearchDetailUtil", 1, "#launchQCircleFeed: useOneDragN=true, keyword=" + str2);
                        z17 = false;
                        if (i3 < arrayList2.size()) {
                            i18 = i3;
                        }
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) arrayList2.get(i18);
                        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                        HashMap<String, String> hashMap = new HashMap<>(2);
                        String str4 = feedCloudMeta$StFeed.f398449id.get();
                        Intrinsics.checkNotNullExpressionValue(str4, "feedPb.id.get()");
                        hashMap.put("feedid", str4);
                        hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(j3));
                        qCircleLayerBean.setSchemeAttrs(hashMap);
                        qCircleLayerBean.setSourceType(i16);
                        qCircleLayerBean.getExtraTypeInfo().subSource = i17;
                        QCircleInitBean qCircleInitBean = new QCircleInitBean();
                        qCircleInitBean.setSourceType(i16);
                        qCircleInitBean.getExtraTypeInfo().subSource = i17;
                        qCircleLayerBean.setTransInitBean(qCircleInitBean);
                        yp2.c a16 = yp2.d.f450780a.a(str);
                        a16.i2(z17);
                        a16.h2(str2);
                        a16.f2(arrayList2);
                        qCircleLayerBean.setDataPosInList(i18);
                        if (Intrinsics.areEqual(str3, "qsearch_detail")) {
                            qCircleLayerBean.setLayerBizAssemblerType("biz_qq_search");
                        }
                        qCircleLayerBean.setGlobalViewModelKey(a16.U1());
                        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
                        com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean);
                    }
                }
            }
            z18 = true;
            if (z18) {
            }
        }
        z17 = z16;
        if (i3 < arrayList2.size()) {
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) arrayList2.get(i18);
        QCircleLayerBean qCircleLayerBean2 = new QCircleLayerBean();
        HashMap<String, String> hashMap2 = new HashMap<>(2);
        String str42 = feedCloudMeta$StFeed2.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str42, "feedPb.id.get()");
        hashMap2.put("feedid", str42);
        hashMap2.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(j3));
        qCircleLayerBean2.setSchemeAttrs(hashMap2);
        qCircleLayerBean2.setSourceType(i16);
        qCircleLayerBean2.getExtraTypeInfo().subSource = i17;
        QCircleInitBean qCircleInitBean2 = new QCircleInitBean();
        qCircleInitBean2.setSourceType(i16);
        qCircleInitBean2.getExtraTypeInfo().subSource = i17;
        qCircleLayerBean2.setTransInitBean(qCircleInitBean2);
        yp2.c a162 = yp2.d.f450780a.a(str);
        a162.i2(z17);
        a162.h2(str2);
        a162.f2(arrayList2);
        qCircleLayerBean2.setDataPosInList(i18);
        if (Intrinsics.areEqual(str3, "qsearch_detail")) {
        }
        qCircleLayerBean2.setGlobalViewModelKey(a162.U1());
        qCircleLayerBean2.setFeed(feedCloudMeta$StFeed2);
        com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean2);
    }

    private static final void r(Context context, final String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, str, null, null, null, null, 1005, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.search.util.r
            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public final void onLaunchResult(boolean z16, Bundle bundle) {
                QSearchDetailUtilKt.s(str, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String appId, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        if (z16) {
            ah.f284994a.k(appId);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mini_app_id", appId);
            Unit unit = Unit.INSTANCE;
            simpleEventBus.dispatchEvent(new QSearchPostEvent("update_open_mini_app", jSONObject));
        }
        QLog.d("QSearchDetailUtil", 1, "#openMiniApp QQMiniApp  success:" + z16 + "  data:" + bundle);
    }

    private static final void t(Context context, String str, int i3, int i16) {
        QLog.d("QSearchDetailUtil", 1, "launchTopicSearch context = [" + context + "]");
        SearchDetailFragment.Companion.e(SearchDetailFragment.INSTANCE, context, new SearchDetailFragment.Companion.NetSearchPageParam(str, null, i3, i16, false, 0L, null, 0L, null, null, null, 0, LoginBusinessData.MiddlePlatformError, null), null, 4, null);
    }

    private static final void u(String str, Context context, String str2, String str3, int i3) {
        if (WXShareHelper.b0().e0()) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(StartupReportKey.SCENE_NOTE, str);
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, str2, str3, i3, 0, Uri.EMPTY, hashMap);
            ah.f284994a.k(str2);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mini_app_id", str2);
            Unit unit = Unit.INSTANCE;
            simpleEventBus.dispatchEvent(new QSearchPostEvent("update_open_mini_app", jSONObject));
            return;
        }
        QQToast.makeText(context, "\u8bf7\u5b89\u88c5\u5fae\u4fe1", 0).show();
    }

    private static final void v(SearchJump searchJump, Map<String, String> map, com.tencent.mobileqq.search.searchdetail.d dVar) {
        Object m476constructorimpl;
        CoroutineScope coroutineScope;
        String str;
        String str2 = searchJump.stringExtension;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("feed_id", "");
            long optLong = jSONObject.optLong("guild_id", 0L);
            long optLong2 = jSONObject.optLong("channel_id", 0L);
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
            int i3 = 0;
            if (map != null && (str = map.get("key_current_button_status")) != null) {
                i3 = RFWStringsKt.toIntOrDefault$default(str, 0, 0, 2, null);
            }
            int i16 = i3;
            if (dVar != null && (coroutineScope = dVar.getCoroutineScope()) != null) {
                bVar = CorountineFunKt.e(coroutineScope, "request do vote", null, null, null, new QSearchDetailUtilKt$likeFeedClick$1$1(optString, optLong, optLong2, i16, map, null), 14, null);
            }
            m476constructorimpl = Result.m476constructorimpl(bVar);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            QLog.e("QSearchDetailUtil", 1, "error likeFeedClick param = [" + searchJump + "]");
        }
    }

    private static final void w(Context context, SearchJump searchJump, Map<String, String> map) {
        String str;
        String str2;
        Integer intOrNull;
        int i3;
        JSONObject jSONObject = new JSONObject(searchJump.getStringExtension());
        String optString = jSONObject.optString("group_code");
        String optString2 = jSONObject.optString("group_name");
        String optString3 = jSONObject.optString("join_group_auth");
        if (map == null || (str = map.get("open_group_detail_transInfo")) == null) {
            str = "";
        }
        JSONObject jSONObject2 = new JSONObject(str);
        jSONObject2.put("group_name", optString2);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "transInfoMap.toString()");
        String optString4 = jSONObject2.optString("search_query_text");
        if (map == null || (str2 = map.get("subSourceId")) == null) {
            str2 = "1020";
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        QLog.d("QSearchDetailUtil", 1, "#openTroopPage: troopUin=" + optString + ", troopName=" + optString2 + ", keyword=" + optString4);
        Bundle b16 = com.tencent.mobileqq.troop.utils.aq.b(optString, i3);
        b16.putInt("exposureSource", 3);
        b16.putString("keyword", optString4);
        b16.putBoolean("isFromNative", true);
        b16.putInt("t_s_f", 1000);
        b16.putString("authSig", optString3);
        b16.putString("trans_info", jSONObject3);
        b16.putString(AppConstants.Key.TROOP_INFO_NAME, optString2);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(context, b16, 2);
    }

    private static final void x(Context context, SearchJump searchJump, long j3, Map<String, String> map) {
        String str;
        if (map != null) {
            str = map.get("sgrp_channel_extension_info");
        } else {
            str = null;
        }
        String str2 = searchJump.jumpLink;
        String jSONObject = new JSONObject().put("tabMask", j3).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().put(\"tabMask\", tabMask).toString()");
        if (str != null) {
            Uri.Builder buildUpon = Uri.parse(searchJump.jumpLink).buildUpon();
            buildUpon.appendQueryParameter("sgrp_channel_extension_info", str);
            buildUpon.appendQueryParameter("param_key_search_extension_info", jSONObject);
            buildUpon.appendQueryParameter("businessType", "29");
            str2 = buildUpon.build().toString();
        }
        QLog.d("QSearchDetailUtil", 1, "openGuildArticlePage: jumpLink:" + ((Object) str2));
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(context, str2, null);
    }

    private static final void y(Context context, SearchJump searchJump, String str, String str2, Map<String, String> map) {
        String str3;
        boolean z16;
        long j3;
        String str4;
        String str5 = null;
        if (map != null) {
            str3 = map.get("guild_sub_source");
        } else {
            str3 = null;
        }
        int i3 = 0;
        if (str3 != null && str3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str3 = "qq_network_search_post";
        }
        SearchGuildJump searchGuildJump = searchJump.guildJump;
        if (searchGuildJump != null) {
            j3 = searchGuildJump.guildId;
        } else {
            j3 = 0;
        }
        if (searchGuildJump != null) {
            str5 = searchGuildJump.joinGuildSig;
        }
        if (str5 == null) {
            str5 = "";
        }
        if (searchGuildJump != null) {
            i3 = searchGuildJump.joinStatus;
        }
        QLog.d("QSearchDetailUtil", 1, "#openChannelPage guildId=" + j3 + ", traceId=" + str2 + ", mainSource=search, subSource=" + str3);
        Bundle bundle = new Bundle();
        bundle.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, str2);
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str);
        bundle.putString("sgrp_stream_pgin_source", "20");
        bundle.putString("sgrp_stream_pgin_source_name", "functional_qq_search");
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, "1");
        bundle.putString("sgrp_search_source", "qq_search");
        if (i3 == 0) {
            bundle.putString("sgrp_join_channel_state", "0");
        } else {
            bundle.putString("sgrp_join_channel_state", "1");
        }
        if (map == null || (str4 = map.get("sgrp_channel_extension_info")) == null) {
            str4 = "";
        }
        bundle.putString("sgrp_channel_extension_info", str4);
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(j3), "");
        jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(str5, "search", str3));
        jumpGuildParam.extras = bundle;
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(context, jumpGuildParam);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void z(Context context, SearchJump searchJump, int i3, String str) {
        String str2;
        int i16;
        JSONObject jSONObject;
        String str3 = "";
        boolean z16 = false;
        try {
            jSONObject = new JSONObject(searchJump.getStringExtension());
            str2 = jSONObject.optString("appid");
            Intrinsics.checkNotNullExpressionValue(str2, "paramJson.optString(\"appid\")");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            i16 = jSONObject.optInt("miniapp_type");
        } catch (Exception unused2) {
            i16 = 0;
            QLog.e("QSearchDetailUtil", 1, "openMiniApp parse extension error");
            if (str2.length() == 0) {
            }
            if (z16) {
            }
        }
        try {
            String optString = jSONObject.optString("miniapp_path");
            Intrinsics.checkNotNullExpressionValue(optString, "paramJson.optString(\"miniapp_path\")");
            str3 = optString;
        } catch (Exception unused3) {
            QLog.e("QSearchDetailUtil", 1, "openMiniApp parse extension error");
            if (str2.length() == 0) {
            }
            if (z16) {
            }
        }
        if (str2.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.w("QSearchDetailUtil", 1, "#openMiniApp appId is empty");
            return;
        }
        QLog.d("QSearchDetailUtil", 1, "#openMiniApp appId=" + str2 + ", type=" + i16 + ", path=" + str3 + ", hostScene=" + i3 + ", sceneNote=" + str);
        if (i16 != 0) {
            if (i16 != 1) {
                QLog.w("QSearchDetailUtil", 1, "#openMiniApp unknown miniApp type:" + i16);
                return;
            }
            u(str, context, str2, str3, i3);
            return;
        }
        r(context, str2);
    }
}
