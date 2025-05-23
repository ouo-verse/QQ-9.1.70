package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.event.GuildChannelLabelEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.DeleteFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.FeedSquareViewModeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.InsertFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgsV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import ij1.GuildFeedsHeaderData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u00052\u00020\u00062\u00020\u0007:\u0002\u0085\u0001B/\u0012\u001a\b\u0002\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/0.\u0012\b\b\u0002\u0010f\u001a\u00020c\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J!\u0010\u000f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\t\u001a\u00020\u000eH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u00aa\u0001\u0010)\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00162h\u0010(\u001ad\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 j\u0004\u0018\u0001`'H\u0016J\u00a2\u0001\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00162h\u0010(\u001ad\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 j\u0004\u0018\u0001`'H\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0014J\u0010\u0010-\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/0.H\u0016J\u0014\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020302H\u0016J\b\u00105\u001a\u00020\u0018H\u0016J9\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/0.2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010306\"\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\n2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010306\"\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0018H\u0016J\u0016\u0010=\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0/\u0018\u00010.H\u0016J\u00a0\u0001\u0010A\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00162j\b\u0002\u0010(\u001ad\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 j\u0004\u0018\u0001`'2\b\b\u0002\u0010@\u001a\u00020\u0016H\u0002J.\u0010G\u001a\u00020\n2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010F\u001a\u00020E2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0018\u0010I\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0018H\u0002J\u0018\u0010J\u001a\u00020\n2\u0006\u0010F\u001a\u00020E2\u0006\u0010&\u001a\u00020\u0016H\u0002J6\u0010L\u001a\u00020\n2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010F\u001a\u00020E2\u0006\u0010K\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\\\u0010R\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u0004002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010K\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u001a2\u001a\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020O\u0018\u00010Nj\n\u0012\u0004\u0012\u00020O\u0018\u0001`PH\u0002Jj\u0010T\u001a\u00020\n2\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00040Nj\b\u0012\u0004\u0012\u00020\u0004`P2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010K\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u001a2\u001a\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020O\u0018\u00010Nj\n\u0012\u0004\u0012\u00020O\u0018\u0001`PH\u0002J\u0010\u0010U\u001a\u00020\u00162\u0006\u0010F\u001a\u00020EH\u0002J\u0016\u0010W\u001a\u00020\n2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J(\u0010[\u001a\u00020\n2\u0012\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010YH\u0002JT\u0010]\u001a\u00020\n2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010&\u001a\u00020\u00162\u0012\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/2\u0006\u0010\\\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u0004002\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010YH\u0002J2\u0010^\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u0004002\u0012\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/H\u0002J\u0018\u0010_\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0018H\u0002R&\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\"\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0/0.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010aR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010tR\u0016\u0010x\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00040y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u001e\u0010\u0081\u0001\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000f\u00a2\u0006\r\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSectionFeedListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "Lco1/f;", "Lij1/g;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Lco1/j;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/n;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/b;", "args", "", "J0", "", "newFeedList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "J1", "modifyFeed", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/p;", "x1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/q;", "argsV2", "i1", "", "enableUseCache", "", "refreshMode", "", "topFeedId", "topChannelId", MiniChatConstants.MINI_APP_TOP_TYPE, "topBusinessId", "forceScrollTop", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "P0", "C1", tl.h.F, "onCleared", DomainData.DOMAIN_NAME, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "j", "", "", "getExtra", "getDisplaySurfaceType", "", "getDisplaySurfaceData", "([Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "loadMoreForDisplaySurface", "([Ljava/lang/Object;)V", "p", "Lij1/d;", "X", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "sortMode", "delayShowFeedData", "g2", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsReq;", "reqParam", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;", "rsp", "W1", "isCacheRsp", "Z1", "b2", "isFinish", "d2", "refreshToast", "Ljava/util/ArrayList;", "Lij1/h;", "Lkotlin/collections/ArrayList;", "topFeedsDataList", "i2", "validBlockDataList", "S1", "c2", "dataList", "U1", "data", "Ljava/lang/Runnable;", "extraTask", "f2", "usePreData", "e2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "T1", "i", "Landroidx/lifecycle/MutableLiveData;", "feedsListData", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "initBean", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "feedListDataRepo", UserInfo.SEX_FEMALE, "I", "mSortMode", "G", "mFeedsHeaderData", "Lsj1/a;", "H", "Lsj1/a;", "tempDelayShowFeedListData", "Z", "blockFirstDataShowOnScreen", "J", "Ljava/lang/String;", "mAttachInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "K", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "publishFeedHelper", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", IECDtReport.ACTION_IDENTIFIER, "<init>", "(Landroidx/lifecycle/MutableLiveData;Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;)V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSectionFeedListViewModel extends ViewModel implements k, co1.f<ij1.g>, IDataDisplaySurface<ij1.g>, co1.j, n {
    private final /* synthetic */ co1.i C;
    private final /* synthetic */ UIStateDataUtils.DefaultUIStateDataOperateImpl D;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedListDataRepo feedListDataRepo;

    /* renamed from: F, reason: from kotlin metadata */
    private int mSortMode;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<UIStateData<GuildFeedsHeaderData>> mFeedsHeaderData;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private sj1.a tempDelayShowFeedListData;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean blockFirstDataShowOnScreen;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String mAttachInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.feed.feedsquare.utils.k<ij1.g> publishFeedHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<ij1.g>>> feedsListData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedMainInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSectionFeedListViewModel$b", "Lqx1/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/a;", "rsp", "", "f", "", "result", "", "errMsg", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4<Boolean, String, Integer, Boolean, Unit> f219371a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedSectionFeedListViewModel f219372b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> f219373c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f219374d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f219375e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f219376f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> function4, GuildFeedSectionFeedListViewModel guildFeedSectionFeedListViewModel, GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar, boolean z16, int i3, boolean z17) {
            this.f219371a = function4;
            this.f219372b = guildFeedSectionFeedListViewModel;
            this.f219373c = bVar;
            this.f219374d = z16;
            this.f219375e = i3;
            this.f219376f = z17;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int result, @Nullable String errMsg, @Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.a rsp) {
            List arrayList;
            String str;
            boolean z16;
            Function4<Boolean, String, Integer, Boolean, Unit> function4 = this.f219371a;
            if (function4 != null) {
                Boolean bool = Boolean.FALSE;
                if (errMsg == null) {
                    str = "";
                } else {
                    str = errMsg;
                }
                Integer valueOf = Integer.valueOf(result);
                if (rsp != null) {
                    z16 = rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String();
                } else {
                    z16 = false;
                }
                function4.invoke(bool, str, valueOf, Boolean.valueOf(z16));
            }
            if (this.f219372b.blockFirstDataShowOnScreen) {
                this.f219372b.blockFirstDataShowOnScreen = false;
            }
            MutableLiveData mutableLiveData = this.f219372b.feedsListData;
            UIStateData loadMore = UIStateData.obtainError(errMsg).setRetCode(result).setType(this.f219375e).setLoadMore(this.f219376f);
            UIStateData uIStateData = (UIStateData) this.f219372b.feedsListData.getValue();
            if (uIStateData == null || (arrayList = (List) uIStateData.getData()) == null) {
                arrayList = new ArrayList();
            }
            mutableLiveData.setValue(loadMore.setDataList(arrayList));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.a rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Function4<Boolean, String, Integer, Boolean, Unit> function4 = this.f219371a;
            if (function4 != null) {
                function4.invoke(Boolean.TRUE, "", 0, Boolean.valueOf(rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String()));
            }
            this.f219372b.W1(this.f219373c, rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), rsp.getGProGetChannelFeedsRsp(), this.f219374d);
        }
    }

    public GuildFeedSectionFeedListViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final void S1(ArrayList<ij1.g> validBlockDataList, GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam, boolean isFinish, boolean isCache, boolean forceScrollTop, String refreshToast, ArrayList<ij1.h> topFeedsDataList) {
        sj1.a aVar = new sj1.a(validBlockDataList, reqParam, isFinish, isCache, forceScrollTop, refreshToast, topFeedsDataList);
        this.tempDelayShowFeedListData = aVar;
        QLog.d("GuildFeedSectionFeedListViewModel", 4, "buildDelayShowFeedListData:" + aVar);
    }

    private final boolean T1(boolean isLoadMore, int sortMode) {
        if (this.feedsListData.getValue() != null) {
            UIStateData<List<ij1.g>> value = this.feedsListData.getValue();
            Intrinsics.checkNotNull(value);
            if (value.isLoading()) {
                QLog.d("GuildFeedSectionFeedListViewModel", 1, "requestNet is loading");
                return true;
            }
            return false;
        }
        return false;
    }

    private final void U1(List<? extends ij1.g> dataList) {
        if (!dataList.isEmpty()) {
            GProStChannelInfo gProStChannelInfo = dataList.get(0).b().channelInfo;
            String valueOf = String.valueOf(gProStChannelInfo.sign.guildId);
            String str = gProStChannelInfo.hotIcon;
            int i3 = gProStChannelInfo.hotIndex;
            QLog.d("GuildFeedSectionFeedListViewModel", 1, "guildId:" + valueOf + ", hotIcon: " + str + ", index:" + i3);
            if (!TextUtils.isEmpty(str)) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildChannelLabelEvent(valueOf, str, i3), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(final GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam, final boolean isCache, final GProStGetChannelFeedsRsp rsp, final boolean forceScrollTop) {
        Integer num;
        if (Z1(isCache, reqParam.getSortMode())) {
            return;
        }
        String p16 = reqParam.p();
        String str = rsp.feedAttchInfo;
        if (str != null) {
            num = Integer.valueOf(str.hashCode());
        } else {
            num = null;
        }
        QLog.d("GuildFeedSectionFeedListViewModel", 1, "[handleGetFeedListRsp] reqParam=" + p16 + ", isCache=" + isCache + ", feedAttchInfo=" + num + ", isFinish=" + rsp.isFinish);
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSectionFeedListViewModel.X1(GuildFeedSectionFeedListViewModel.this, rsp, isCache, reqParam, forceScrollTop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(GuildFeedSectionFeedListViewModel this$0, GProStGetChannelFeedsRsp rsp, boolean z16, GuildFeedListDataRepo.b reqParam, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(reqParam, "$reqParam");
        this$0.b2(rsp, z16);
        this$0.d2(reqParam, z16, rsp, this$0.c2(rsp), z17);
    }

    private final boolean Z1(boolean isCacheRsp, int sortMode) {
        boolean z16;
        List<ij1.g> data;
        if (isCacheRsp) {
            UIStateData<List<ij1.g>> value = this.feedsListData.getValue();
            if (value != null && (data = value.getData()) != null && (!data.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(boolean usePreData, List<ij1.g> newFeedList, UIStateData<List<ij1.g>> data) {
        List<ij1.g> list;
        boolean z16;
        UIStateData<List<ij1.g>> value = this.feedsListData.getValue();
        if (value != null) {
            list = value.getData();
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (usePreData) {
            FeedSquareViewModeUtils.f219276a.a(list, newFeedList);
            List<ij1.g> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList.addAll(list2);
            }
        }
        List<ij1.g> list3 = newFeedList;
        if (!list3.isEmpty()) {
            arrayList.addAll(list3);
        }
        data.setDataList(arrayList);
        if (arrayList.size() == 0) {
            data.setState(0);
        }
        this.feedsListData.setValue(data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0010, code lost:
    
        if (r3 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b2(GProStGetChannelFeedsRsp rsp, boolean isCache) {
        boolean z16;
        synchronized (this.mAttachInfo) {
            if (isCache) {
                if (this.mAttachInfo.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            String str = rsp.feedAttchInfo;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.feedAttchInfo");
            this.mAttachInfo = str;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean c2(GProStGetChannelFeedsRsp rsp) {
        if (rsp.isFinish > 0) {
            return true;
        }
        return false;
    }

    private final void d2(GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam, boolean isCache, GProStGetChannelFeedsRsp rsp, boolean isFinish, boolean forceScrollTop) {
        String str;
        String str2;
        int collectionSizeOrDefault;
        ArrayList<ij1.h> arrayList;
        ArrayList<ij1.g> validBlockDataList = ij1.c.c(rsp.vecFeedList, rsp.traceId);
        com.tencent.mobileqq.guild.feed.feedsquare.utils.k<ij1.g> kVar = this.publishFeedHelper;
        String guildId = this.initBean.getGuildId();
        if (guildId == null) {
            str = "";
        } else {
            str = guildId;
        }
        String channelId = this.initBean.getChannelId();
        if (channelId == null) {
            str2 = "";
        } else {
            str2 = channelId;
        }
        Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
        kVar.j(new com.tencent.mobileqq.guild.feed.feedsquare.utils.d<>(str, str2, false, validBlockDataList, isFinish, reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), reqParam.getSortMode(), isCache));
        if (!reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            U1(validBlockDataList);
        }
        jj1.b c16 = jj1.b.c();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(validBlockDataList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = validBlockDataList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ij1.g) it.next()).b());
        }
        c16.initOrUpdateGlobalState((List) arrayList2, true);
        if (!reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            arrayList = ij1.c.d(rsp.topFeeds);
        } else {
            arrayList = null;
        }
        ArrayList<ij1.h> arrayList3 = arrayList;
        if (this.blockFirstDataShowOnScreen) {
            String str3 = rsp.refreshToast.text;
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.refreshToast.text");
            S1(validBlockDataList, reqParam, isFinish, isCache, forceScrollTop, str3, arrayList3);
        } else {
            String str4 = rsp.refreshToast.text;
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.refreshToast.text");
            i2(validBlockDataList, reqParam, isFinish, isCache, forceScrollTop, str4, arrayList3);
        }
    }

    private final void e2(final GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam, final boolean isCache, final UIStateData<List<ij1.g>> data, final boolean usePreData, final List<ij1.g> newFeedList, final Runnable extraTask) {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!isCache) {
                reqParam.o(true);
            } else if (reqParam.getHasNotCacheFeedHandle()) {
                Logger.f235387a.d().w("GuildFeedSectionFeedListViewModel", 1, "postFeedInMain hasNotCacheFeedHandle");
                return;
            }
            Logger.f235387a.d().i("GuildFeedSectionFeedListViewModel", 1, "postFeedInMain reqParam=" + reqParam.p() + " isCache=" + isCache);
            if (extraTask != null) {
                extraTask.run();
            }
            a2(usePreData, newFeedList, data);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$postFeedInMain$$inlined$ensureUiThread$2
            @Override // java.lang.Runnable
            public final void run() {
                if (!isCache) {
                    reqParam.o(true);
                } else if (reqParam.getHasNotCacheFeedHandle()) {
                    Logger.f235387a.d().w("GuildFeedSectionFeedListViewModel", 1, "postFeedInMain hasNotCacheFeedHandle");
                    return;
                }
                Logger.f235387a.d().i("GuildFeedSectionFeedListViewModel", 1, "postFeedInMain reqParam=" + reqParam.p() + " isCache=" + isCache);
                Runnable runnable = extraTask;
                if (runnable != null) {
                    runnable.run();
                }
                this.a2(usePreData, newFeedList, data);
            }
        });
    }

    private final void f2(final UIStateData<List<ij1.g>> data, final Runnable extraTask) {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (extraTask != null) {
                extraTask.run();
            }
            this.feedsListData.setValue(data);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$postFeedInMain$$inlined$ensureUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable = extraTask;
                if (runnable != null) {
                    runnable.run();
                }
                this.feedsListData.setValue(data);
            }
        });
    }

    private final boolean g2(boolean isLoadMore, boolean enableUseCache, int sortMode, boolean forceScrollTop, Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback, boolean delayShowFeedData) {
        String str;
        String str2;
        String str3;
        if (T1(isLoadMore, sortMode)) {
            return false;
        }
        this.blockFirstDataShowOnScreen = delayShowFeedData;
        String guildId = this.initBean.getGuildId();
        if (guildId == null) {
            str = "";
        } else {
            str = guildId;
        }
        String channelId = this.initBean.getChannelId();
        if (channelId == null) {
            str2 = "";
        } else {
            str2 = channelId;
        }
        if (!isLoadMore) {
            str3 = "";
        } else {
            str3 = this.mAttachInfo;
        }
        GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar = new GuildFeedListDataRepo.b<>(str, str2, "", sortMode, isLoadMore, enableUseCache, str3, "", null, 0, null, 0L, null, 7936, null);
        QLog.i("GuildFeedSectionFeedListViewModel", 1, "requestNet reqParam=" + bVar);
        this.feedListDataRepo.k(bVar, new b(callback, this, bVar, forceScrollTop, sortMode, isLoadMore));
        return true;
    }

    static /* synthetic */ boolean h2(GuildFeedSectionFeedListViewModel guildFeedSectionFeedListViewModel, boolean z16, boolean z17, int i3, boolean z18, Function4 function4, boolean z19, int i16, Object obj) {
        boolean z26;
        Function4 function42;
        boolean z27;
        if ((i16 & 8) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        if ((i16 & 16) != 0) {
            function42 = null;
        } else {
            function42 = function4;
        }
        if ((i16 & 32) != 0) {
            z27 = false;
        } else {
            z27 = z19;
        }
        return guildFeedSectionFeedListViewModel.g2(z16, z17, i3, z26, function42, z27);
    }

    private final void i2(List<ij1.g> list, GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar, final boolean z16, final boolean z17, boolean z18, String str, final ArrayList<ij1.h> arrayList) {
        Runnable runnable;
        if (arrayList != null) {
            runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSectionFeedListViewModel.j2(GuildFeedSectionFeedListViewModel.this, z17, arrayList, z16);
                }
            };
        } else {
            runnable = null;
        }
        Runnable runnable2 = runnable;
        int i3 = 0;
        if (list.isEmpty() && !bVar.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            UIStateData<List<ij1.g>> finish = UIStateData.obtainEmpty().setData(false, new ArrayList()).setType(this.mSortMode).setFinish(z16);
            Intrinsics.checkNotNullExpressionValue(finish, "obtainEmpty<MutableList<\u2026     .setFinish(isFinish)");
            f2(finish, runnable2);
        } else {
            UIStateData type = UIStateData.obtainSuccess(z17).setData(bVar.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), list).setType(this.mSortMode);
            if (!z18) {
                i3 = -1;
            }
            UIStateData<List<ij1.g>> msg2 = type.setPos(i3).setFinish(z16).setMsg(str);
            Intrinsics.checkNotNullExpressionValue(msg2, "obtainSuccess<MutableLis\u2026    .setMsg(refreshToast)");
            e2(bVar, z17, msg2, bVar.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), list, runnable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(GuildFeedSectionFeedListViewModel this$0, boolean z16, ArrayList arrayList, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFeedsHeaderData.setValue(UIStateData.obtainSuccess(z16).setData(false, new GuildFeedsHeaderData(arrayList, null, null, false, 8, null)).setFinish(z17));
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void C1(boolean enableUseCache, int refreshMode, @NotNull String topChannelId, int topType, @NotNull String topBusinessId, boolean forceScrollTop, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
        Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
        this.mSortMode = refreshMode;
        g2(false, enableUseCache, refreshMode, forceScrollTop, callback, true);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void J0(@NotNull DeleteFeedArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.J0(args);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void J1(@NotNull List<? extends ij1.g> newFeedList, @NotNull InsertFeedArgs args) {
        Intrinsics.checkNotNullParameter(newFeedList, "newFeedList");
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.J1(newFeedList, args);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void P0(boolean enableUseCache, int refreshMode, @NotNull String topFeedId, @NotNull String topChannelId, int topType, @NotNull String topBusinessId, boolean forceScrollTop, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(topFeedId, "topFeedId");
        Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
        Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
        this.mSortMode = refreshMode;
        h2(this, false, enableUseCache, refreshMode, forceScrollTop, callback, false, 32, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    @Nullable
    public MutableLiveData<UIStateData<GuildFeedsHeaderData>> X() {
        return this.mFeedsHeaderData;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    @NotNull
    public MutableLiveData<UIStateData<List<ij1.g>>> getDisplaySurfaceData(@NotNull Object... args) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(args, "args");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
        if (Intrinsics.areEqual(firstOrNull, "data_type_feed_list")) {
            return this.feedsListData;
        }
        return new MutableLiveData<>();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 3;
    }

    @Override // co1.f
    @NotNull
    public Map<String, Object> getExtra() {
        HashMap hashMap = new HashMap();
        String str = this.mAttachInfo;
        if (str == null) {
            str = "";
        }
        hashMap.put("attachInfo", str);
        return hashMap;
    }

    @Override // co1.h
    @NotNull
    /* renamed from: getIdentifier */
    public String getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String() {
        return this.C.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void h() {
        if (!this.blockFirstDataShowOnScreen) {
            return;
        }
        this.blockFirstDataShowOnScreen = false;
        sj1.a aVar = this.tempDelayShowFeedListData;
        if (aVar == null) {
            return;
        }
        Intrinsics.checkNotNull(aVar);
        i2(aVar.d(), aVar.c(), aVar.getIsFinish(), aVar.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), aVar.getForceScrollTop(), aVar.getRefreshToast(), aVar.e());
        QLog.d("GuildFeedSectionFeedListViewModel", 4, "[delayPostFeedInMain]-delay post feed data:" + this.tempDelayShowFeedListData);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void i1(@NotNull ModifyFeedArgsV2 argsV2) {
        Intrinsics.checkNotNullParameter(argsV2, "argsV2");
        this.D.i1(argsV2);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    @NotNull
    public MutableLiveData<UIStateData<List<ij1.g>>> j() {
        return this.feedsListData;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        n(this.mSortMode);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void n(int refreshMode) {
        UIStateData<List<ij1.g>> value;
        UIStateData<List<ij1.g>> value2 = this.feedsListData.getValue();
        boolean z16 = false;
        if (value2 != null && value2.isLoading()) {
            z16 = true;
        }
        if (z16) {
            QLog.e("GuildFeedSectionFeedListViewModel", 1, "isLoading Ignore");
        } else if (h2(this, true, false, refreshMode, false, null, false, 56, null) && (value = this.feedsListData.getValue()) != null) {
            value.setLoadingState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    /* renamed from: p, reason: from getter */
    public int getMSortMode() {
        return this.mSortMode;
    }

    @Override // co1.j
    public void setIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.C.setIdentifier(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void x1(@NotNull ij1.g modifyFeed, @NotNull ModifyFeedArgs args) {
        Intrinsics.checkNotNullParameter(modifyFeed, "modifyFeed");
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.x1(modifyFeed, args);
    }

    public /* synthetic */ GuildFeedSectionFeedListViewModel(MutableLiveData mutableLiveData, GuildFeedMainInitBean guildFeedMainInitBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i3 & 2) != 0 ? new GuildFeedMainInitBean() : guildFeedMainInitBean);
    }

    public GuildFeedSectionFeedListViewModel(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> feedsListData, @NotNull GuildFeedMainInitBean initBean) {
        Intrinsics.checkNotNullParameter(feedsListData, "feedsListData");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.feedsListData = feedsListData;
        this.initBean = initBean;
        this.C = new co1.i();
        this.D = new UIStateDataUtils.DefaultUIStateDataOperateImpl(feedsListData);
        this.feedListDataRepo = new GuildFeedListDataRepo("GuildFeedSectionFeedListViewModel", -1);
        this.mSortMode = 3;
        this.mFeedsHeaderData = new MutableLiveData<>();
        this.mAttachInfo = "";
        this.publishFeedHelper = new com.tencent.mobileqq.guild.feed.feedsquare.utils.k<>(new Function1<ij1.g, GProStFeed>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$publishFeedHelper$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final GProStFeed invoke(@NotNull ij1.g $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return $receiver.b();
            }
        }, new Function2<ij1.g, GuildTaskProgressState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$publishFeedHelper$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ij1.g gVar, GuildTaskProgressState guildTaskProgressState) {
                invoke2(gVar, guildTaskProgressState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ij1.g $receiver, @NotNull GuildTaskProgressState it) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(it, "it");
                $receiver.z(it);
            }
        }, new Function1<GProStFeed, ij1.g>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$publishFeedHelper$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final ij1.g invoke(@NotNull GProStFeed it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new ij1.g(it);
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g>, List<? extends a.FeedPublishFinish>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$publishFeedHelper$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<a.FeedPublishFinish> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).finishedFeedPublishState(it.getGuildId(), it.getChannelId());
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g>, List<? extends FeedPublishStateV2>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel$publishFeedHelper$5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<FeedPublishStateV2> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).syncQueryFailPublishStateV2s(it.getGuildId(), it.getChannelId());
            }
        });
        if (ch.j0(initBean.getGuildId())) {
            return;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getSimpleProfile(initBean.getGuildId(), ch.f(), 100);
    }
}
