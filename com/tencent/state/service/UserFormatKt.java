package com.tencent.state.service;

import android.app.Application;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Size;
import at4.f;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.state.data.Gender;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.AnchorBubble;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.EntranceBubble;
import com.tencent.state.square.data.FilamentCoverResourceKt;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.MultiDefault;
import com.tencent.state.square.data.MultiMotionUser;
import com.tencent.state.square.data.MultiResourceInfo;
import com.tencent.state.square.data.NewInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.PanelCategoryInfo;
import com.tencent.state.square.data.PanelInfo;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.square.data.SingleResourceInfo;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAnchorEntrance;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareBuildingInfo;
import com.tencent.state.square.data.SquareEmptyData;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareIntimateData;
import com.tencent.state.square.data.SquareIntimateInfo;
import com.tencent.state.square.data.SquareJudgeRecordData;
import com.tencent.state.square.data.SquareMayKnowItem;
import com.tencent.state.square.data.SquareMutualMark;
import com.tencent.state.square.data.SquarePosterInfo;
import com.tencent.state.square.data.SquareRecommendUserItem;
import com.tencent.state.square.data.SquareStrangerInfo;
import com.tencent.state.square.data.SquareStyleInfo;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.data.SquareUserInfo;
import com.tencent.state.square.data.SquareWhiteListDialogInfo;
import com.tencent.state.square.data.SquareWhitelist;
import com.tencent.state.square.data.StatusActionInfo;
import com.tencent.state.square.data.StatusLockInfo;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.flower.data.FlowerDataConvertersKt;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.square.mayknow.MayKnowServiceKt;
import com.tencent.state.square.mayknow.MayKnowUser;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.pickfriend.service.FriendData;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.status.BannerInfo;
import com.tencent.state.status.FinishStatusInfo;
import com.tencent.state.status.NewStatusInfo;
import com.tencent.state.status.PanelStatusTaskInfo;
import com.tencent.state.status.PanelStatusTaskPrizeStatus;
import com.tencent.state.status.PanelTaskBannerLinkType;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.utils.SquareSwitchUtils;
import hs4.b;
import hs4.d;
import hs4.e;
import hs4.g;
import hs4.j;
import hs4.k;
import hs4.m;
import hs4.n;
import hs4.o;
import hs4.q;
import hs4.r;
import hs4.s;
import hs4.u;
import it4.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import ns4.c;
import org.json.JSONObject;
import rt4.i;
import rt4.l;
import rt4.v;
import rt4.w;
import xt4.ab;
import xt4.ae;
import xt4.ag;
import xt4.ah;
import xt4.h;
import xt4.p;
import xt4.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004\u001a\f\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0000\u001a\f\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\n\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0013*\u00020\u0012\u001a\u0014\u0010\u0018\u001a\u00020\u0017*\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019\u001a<\u0010$\u001a\u00020#*\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u0004\u001a\u0012\u0010\u0011\u001a\u00020&*\u00020%2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0012\u0010\u0011\u001a\u00020&*\u00020'2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\n\u0010*\u001a\u00020)*\u00020(\u001a\u0012\u0010\u0011\u001a\u00020\u0013*\u00020+2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0001\u001a\u0012\u0010\u0011\u001a\u00020&*\u0002012\u0006\u0010\u000f\u001a\u00020\u000e\u001a\n\u00104\u001a\u000203*\u000202\u001a\n\u00104\u001a\u000206*\u000205\u001a\u0012\u0010\u0011\u001a\u000208*\u0002072\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u001c\u0010:\u001a\u000209*\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020\u0004\u001a\u0012\u0010>\u001a\u00020=*\u00020\u001d2\u0006\u0010<\u001a\u00020;\u001a\u0012\u0010@\u001a\u00020=*\u00020?2\u0006\u0010<\u001a\u00020;\u001a\u001a\u0010D\u001a\u00020C*\u0002072\u0006\u0010B\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0010\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u0001*\u00020\u001d\u001a0\u0010N\u001a\u00020M*\u00020G2\b\u0010I\u001a\u0004\u0018\u00010H2\b\u0010J\u001a\u0004\u0018\u00010H2\b\b\u0002\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020;\u001a\u0016\u0010Q\u001a\u00020M*\u00020G2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u001a1\u0010V\u001a\u00020M*\u00020G2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010R2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010R\u00a2\u0006\u0004\bV\u0010W\u001a$\u0010Z\u001a\u00020G2\u0006\u0010Y\u001a\u00020X2\b\b\u0002\u0010K\u001a\u00020\u00042\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u001a\u0012\u0010^\u001a\u00020]*\u00020[2\u0006\u0010\\\u001a\u00020G\u001a\u0014\u0010`\u001a\u00020\u000e*\u00020A2\b\b\u0002\u0010_\u001a\u00020\u0004\u001a\u0010\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u0001*\u00020X\u001a\n\u0010c\u001a\u00020b*\u00020a\u001a\n\u0010f\u001a\u00020e*\u00020d\u001a\u001a\u0010k\u001a\u00020j*\u00020g2\u0006\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u0017\u001a\n\u0010l\u001a\u00020M*\u00020j\u001a\u001a\u0010p\u001a\u00020o*\u00020m2\u0006\u0010n\u001a\u00020e2\u0006\u0010h\u001a\u00020\u0017\u001a\n\u0010s\u001a\u00020r*\u00020q\u001a\u0010\u0010v\u001a\u0004\u0018\u00010u2\u0006\u0010t\u001a\u00020\u0017\u001a\u0014\u0010y\u001a\u00020x*\u00020w2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\u000e\u0010}\u001a\u00020|2\u0006\u0010{\u001a\u00020z\u001a\u000b\u0010\u0080\u0001\u001a\u00020\u007f*\u00020~\u001a\r\u0010\u0083\u0001\u001a\u00030\u0082\u0001*\u00030\u0081\u0001\u001a\r\u0010\u0086\u0001\u001a\u00030\u0085\u0001*\u00030\u0084\u0001\u001a\u000f\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001*\u00030\u0087\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lxt4/p;", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "unreadList", "", "isFromCache", "Lcom/tencent/state/map/MapItem;", "formatSquareItemList", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "formatAdaptiveBkg", "Lxt4/f;", "Lxt4/a;", "background", "Lxt4/w;", "Landroid/util/Size;", "mapSize", "Lcom/tencent/state/square/data/SquareMayKnowItem;", "formatSquareItem", "Lht4/b;", "Lcom/tencent/state/square/data/SquareTroopItem;", "", "", "uin", "", "toNickName", "Lhs4/j;", "statusLoc", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "formatLocationInfo", "Lxt4/ag;", "message", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "myInteractionUnReadInfo", "flowerBubbleText", "needShieldTeenager", "Lcom/tencent/state/square/data/SquareAvatarItem;", "formatUserInfo", "Lxt4/ah;", "Lcom/tencent/state/square/data/SquareEntranceItem;", "Lxt4/r;", "Lhs4/q;", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "formatQZoneFeedInfo", "Lxt4/q;", "Lxt4/d;", "entranceList", "", "Lcom/tencent/state/square/data/SquareAnchorEntrance;", "formatAnchorEntrance", "Lxt4/h;", "Lit4/a;", "Lcom/tencent/state/square/data/SquareBuildingInfo;", "formatBuildInfo", "Lit4/f;", "Lcom/tencent/state/square/data/SquareStyleInfo;", "Lhs4/i;", "Lcom/tencent/state/square/data/SquareEmptyData;", "Lcom/tencent/state/square/data/SquareAvatarExtra;", "formatAvatarExtra", "", "type", "Lcom/tencent/state/square/data/RelationType;", "covertRelationType", "Lcom/tencent/state/square/data/RelationType$Companion;", "parse", "Lhs4/b;", "showDpi", "Lcom/tencent/state/map/Location;", "formatSquareLocation", "Lcom/tencent/state/square/data/AvatarAction;", "formatActions", "Lcom/tencent/state/square/data/Resource;", "Lhs4/n;", "static", TabPreloadItem.TAB_NAME_DYNAMIC, "isDressKeySame", "actionType", "", CanvasView.CUSTOM_ACTION_FILL, "Lhs4/s;", "filamentResource", "filamentFill", "", "Lhs4/m;", "dynamicMultiDefaultInfo", "staticMultiDefaultInfo", "fillMultiDefaultResource", "(Lcom/tencent/state/square/data/Resource;[Lhs4/m;[Lhs4/m;)V", "Lhs4/r;", "resourceInfo", "formatActionResource", "Lxt4/t;", "reqResource", "Lcom/tencent/state/square/data/SquareJudgeRecordData;", "format", "needCalPx", "formatSize", "Lrt4/k;", "Lcom/tencent/state/square/data/PanelInfo;", "formatPanelInfo", "Lhs4/t;", "Lcom/tencent/state/square/data/OnlineStatus;", "formatOnlineStatus", "Lrt4/u;", "dressKey", "pickIcon", "Lcom/tencent/state/square/data/StatusActionInfo;", "formatStatusActionInfo", "revisePickedAction", "Lrt4/l;", "status", "Lcom/tencent/state/square/data/BaseResourceInfo;", "formatResourceInfo", "Lrt4/n;", "Lcom/tencent/state/square/data/StatusLockInfo;", "formatLockInfo", "jsonString", "Lcom/tencent/state/square/data/SpecialStatus;", "formatSpecialStatus", "Lat4/a;", "Lcom/tencent/state/square/data/SquareRecommendUserItem;", "formatSquareRecommendUserItem", "Lrt4/w;", "taskInfo", "Lcom/tencent/state/status/PanelStatusTaskInfo;", "formatStatusTaskInfo", "Lrt4/e;", "Lcom/tencent/state/status/FinishStatusInfo;", "formatFinishStatusTask", "Lns4/c;", "Lcom/tencent/state/square/data/SquareUserInfo;", "formatSquareUserInfo", "Lrt4/i;", "Lcom/tencent/state/status/NewStatusInfo;", "formatNewStatusRedDot", "Lzt4/d;", "Lcom/tencent/state/square/data/SquareWhitelist;", "formatWhitelistStatus", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class UserFormatKt {
    public static final RelationType covertRelationType(ag covertRelationType, int i3) {
        Intrinsics.checkNotNullParameter(covertRelationType, "$this$covertRelationType");
        return parse(RelationType.INSTANCE, i3);
    }

    public static final void filamentFill(Resource filamentFill, s sVar) {
        d[] dVarArr;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(filamentFill, "$this$filamentFill");
        ResourceIdentify resourceIdentify = new ResourceIdentify(null, null, null, null, 0, 31, null);
        DressKeys dressKeys = null;
        if (sVar != null) {
            e eVar = sVar.f406202b;
            if (eVar != null && (dVarArr = eVar.f406135a) != null) {
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(dVarArr);
                d dVar = (d) firstOrNull;
                if (dVar != null) {
                    String str = dVar.f406133a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.url");
                    String str2 = dVar.f406134b;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.md5");
                    resourceIdentify = new ResourceIdentify(str, str2, null, null, 0, 28, null);
                }
            }
            o oVar = sVar.f406206f;
            MultiMotionUser multiMotionUser = oVar != null ? new MultiMotionUser(String.valueOf(oVar.f406176a), String.valueOf(oVar.f406177b), null, 4, null) : null;
            u uVar = sVar.f406207g;
            if (uVar != null) {
                String otherDressKey = uVar.f406220b;
                if (sVar.f406206f == null) {
                    otherDressKey = "";
                }
                String str3 = uVar.f406219a;
                Intrinsics.checkNotNullExpressionValue(str3, "it.owner");
                Intrinsics.checkNotNullExpressionValue(otherDressKey, "otherDressKey");
                dressKeys = new DressKeys(str3, otherDressKey);
            }
            filamentFill.setFilament(new FilamentResource(resourceIdentify, multiMotionUser, dressKeys, FilamentCoverResourceKt.parse(sVar.f406208h)));
            return;
        }
        filamentFill.setFilament(new FilamentResource(resourceIdentify, null, null, null));
    }

    public static final void fill(Resource fill, n nVar, n nVar2, boolean z16, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        m mVar = nVar != null ? nVar.f406172a : null;
        m mVar2 = nVar2 != null ? nVar2.f406172a : null;
        m mVar3 = nVar2 != null ? nVar2.f406173b : null;
        m mVar4 = nVar != null ? nVar.f406173b : null;
        boolean z17 = (SquareMedia.INSTANCE.getEnabledUseUrl() && (TextUtils.isEmpty(mVar2 != null ? mVar2.f406169a : null) ^ true)) ? false : true;
        if (z17) {
            if (mVar3 != null) {
                str = mVar3.f406169a;
            }
            str = null;
        } else {
            if (mVar2 != null) {
                str = mVar2.f406169a;
            }
            str = null;
        }
        String str13 = "";
        if (str == null) {
            str = "";
        }
        if (z17) {
            if (mVar3 != null) {
                str2 = mVar3.f406170b;
            }
            str2 = null;
        } else {
            if (mVar2 != null) {
                str2 = mVar2.f406170b;
            }
            str2 = null;
        }
        if (z17) {
            if (mVar4 != null) {
                str3 = mVar4.f406169a;
            }
            str3 = null;
        } else {
            if (mVar != null) {
                str3 = mVar.f406169a;
            }
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (z17) {
            if (mVar4 != null) {
                str4 = mVar4.f406170b;
            }
            str4 = null;
        } else {
            if (mVar != null) {
                str4 = mVar.f406170b;
            }
            str4 = null;
        }
        fill.setDynamic(new ResourceIdentify(null, null, (mVar3 == null || (str12 = mVar3.f406169a) == null) ? "" : str12, (mVar3 == null || (str11 = mVar3.f406170b) == null) ? "" : str11, 0, 19, null));
        fill.setStatic(new ResourceIdentify(null, null, (mVar4 == null || (str10 = mVar4.f406169a) == null) ? "" : str10, (mVar4 == null || (str9 = mVar4.f406170b) == null) ? "" : str9, 0, 19, null));
        if (z16) {
            fill.getDynamic().setUrl(str);
            ResourceIdentify dynamic = fill.getDynamic();
            if (TextUtils.isEmpty(str2)) {
                str2 = com.tencent.zplan.common.utils.d.c(str);
                Intrinsics.checkNotNullExpressionValue(str2, "MD5.toMD5(dynamicUrl)");
            } else {
                Intrinsics.checkNotNull(str2);
            }
            dynamic.setMd5(str2);
            fill.getStatic().setUrl(str3);
            ResourceIdentify resourceIdentify = fill.getStatic();
            if (TextUtils.isEmpty(str4)) {
                str4 = com.tencent.zplan.common.utils.d.c(str3);
                Intrinsics.checkNotNullExpressionValue(str4, "MD5.toMD5(staticUrl)");
            } else {
                Intrinsics.checkNotNull(str4);
            }
            resourceIdentify.setMd5(str4);
            fill.setDefault(z17);
        } else {
            ResourceIdentify dynamic2 = fill.getDynamic();
            if (mVar3 == null || (str5 = mVar3.f406169a) == null) {
                str5 = "";
            }
            dynamic2.setUrl(str5);
            ResourceIdentify dynamic3 = fill.getDynamic();
            if (mVar3 == null || (str6 = mVar3.f406170b) == null) {
                str6 = "";
            }
            dynamic3.setMd5(str6);
            ResourceIdentify resourceIdentify2 = fill.getStatic();
            if (mVar4 == null || (str7 = mVar4.f406169a) == null) {
                str7 = "";
            }
            resourceIdentify2.setUrl(str7);
            ResourceIdentify resourceIdentify3 = fill.getStatic();
            if (mVar4 != null && (str8 = mVar4.f406170b) != null) {
                str13 = str8;
            }
            resourceIdentify3.setMd5(str13);
            fill.setDefault(true);
        }
        fillMultiDefaultResource(fill, nVar2 != null ? nVar2.f406175d : null, nVar != null ? nVar.f406175d : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void fillMultiDefaultResource(Resource fillMultiDefaultResource, m[] mVarArr, m[] mVarArr2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isBlank;
        boolean z19;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(fillMultiDefaultResource, "$this$fillMultiDefaultResource");
        if (fillMultiDefaultResource.getActionType() != 1) {
            return;
        }
        if (mVarArr != null) {
            if (!(mVarArr.length == 0)) {
                z16 = false;
                if (!z16) {
                    MultiDefault multiDefault = new MultiDefault(null, null, null, null, 15, null);
                    if (mVarArr != null) {
                        for (m mVar : mVarArr) {
                            String str = mVar.f406169a;
                            if (str != null) {
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                                if (!isBlank2) {
                                    z19 = false;
                                    if (!(!z19)) {
                                        int i3 = mVar.f406171c;
                                        if (i3 == Gender.MALE.ordinal()) {
                                            String str2 = mVar.f406169a;
                                            Intrinsics.checkNotNullExpressionValue(str2, "motionInfo.url");
                                            multiDefault.setWithMaleUrl(str2);
                                            String str3 = mVar.f406170b;
                                            Intrinsics.checkNotNullExpressionValue(str3, "motionInfo.md5");
                                            multiDefault.setWithMaleMd5(str3);
                                        } else if (i3 == Gender.FEMALE.ordinal()) {
                                            String str4 = mVar.f406169a;
                                            Intrinsics.checkNotNullExpressionValue(str4, "motionInfo.url");
                                            multiDefault.setWithFemaleUrl(str4);
                                            String str5 = mVar.f406170b;
                                            Intrinsics.checkNotNullExpressionValue(str5, "motionInfo.md5");
                                            multiDefault.setWithFemaleMd5(str5);
                                        }
                                    } else {
                                        SquareBaseKt.getSquareLog().w("UserFormat", "fill dynamic Resource but url invalid");
                                    }
                                }
                            }
                            z19 = true;
                            if (!(!z19)) {
                            }
                        }
                    }
                    fillMultiDefaultResource.getDynamic().setMultiExtra(multiDefault);
                }
                if (mVarArr2 != null) {
                    if (!(mVarArr2.length == 0)) {
                        z17 = false;
                        if (z17) {
                            return;
                        }
                        MultiDefault multiDefault2 = new MultiDefault(null, null, null, null, 15, null);
                        if (mVarArr2 != null) {
                            for (m mVar2 : mVarArr2) {
                                String str6 = mVar2.f406169a;
                                if (str6 != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str6);
                                    if (!isBlank) {
                                        z18 = false;
                                        if (!(!z18)) {
                                            int i16 = mVar2.f406171c;
                                            if (i16 == Gender.MALE.ordinal()) {
                                                String str7 = mVar2.f406169a;
                                                Intrinsics.checkNotNullExpressionValue(str7, "motionInfo.url");
                                                multiDefault2.setWithMaleUrl(str7);
                                                String str8 = mVar2.f406170b;
                                                Intrinsics.checkNotNullExpressionValue(str8, "motionInfo.md5");
                                                multiDefault2.setWithMaleMd5(str8);
                                            } else if (i16 == Gender.FEMALE.ordinal()) {
                                                String str9 = mVar2.f406169a;
                                                Intrinsics.checkNotNullExpressionValue(str9, "motionInfo.url");
                                                multiDefault2.setWithFemaleUrl(str9);
                                                String str10 = mVar2.f406170b;
                                                Intrinsics.checkNotNullExpressionValue(str10, "motionInfo.md5");
                                                multiDefault2.setWithFemaleMd5(str10);
                                            }
                                        } else {
                                            SquareBaseKt.getSquareLog().w("UserFormat", "fill static Resource but url invalid");
                                        }
                                    }
                                }
                                z18 = true;
                                if (!(!z18)) {
                                }
                            }
                        }
                        fillMultiDefaultResource.getStatic().setMultiExtra(multiDefault2);
                        return;
                    }
                }
                z17 = true;
                if (z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (mVarArr2 != null) {
        }
        z17 = true;
        if (z17) {
        }
    }

    public static final SquareJudgeRecordData format(t format, Resource reqResource) {
        Intrinsics.checkNotNullParameter(format, "$this$format");
        Intrinsics.checkNotNullParameter(reqResource, "reqResource");
        boolean z16 = format.f448647a;
        if (z16) {
            reqResource.setActionId(format.f448648b);
            fill$default(reqResource, format.f448649c, format.f448650d, false, 1, 4, null);
            return new SquareJudgeRecordData(format.f448647a, reqResource);
        }
        return new SquareJudgeRecordData(z16, null, 2, 0 == true ? 1 : 0);
    }

    public static final List<AvatarAction> formatActions(ag formatActions) {
        r rVar;
        Resource formatActionResource$default;
        Intrinsics.checkNotNullParameter(formatActions, "$this$formatActions");
        r statusResource = formatActions.f448542f;
        Intrinsics.checkNotNullExpressionValue(statusResource, "statusResource");
        Resource formatActionResource$default2 = formatActionResource$default(statusResource, false, formatActions.f448556t, 2, null);
        r unreadResource = formatActions.f448543g;
        Intrinsics.checkNotNullExpressionValue(unreadResource, "unreadResource");
        Resource formatActionResource$default3 = formatActionResource$default(unreadResource, false, formatActions.f448558v, 2, null);
        q qVar = formatActions.f448548l;
        Resource resource = (qVar == null || (rVar = qVar.f406186c) == null || (formatActionResource$default = formatActionResource$default(rVar, false, formatActions.f448556t, 2, null)) == null) ? formatActionResource$default2 : formatActionResource$default;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AvatarAction(formatActionResource$default2, formatActionResource$default3, resource, null, 8, null));
        return arrayList;
    }

    public static final SquarePageBackgroundInfo formatAdaptiveBkg(p formatAdaptiveBkg) {
        Intrinsics.checkNotNullParameter(formatAdaptiveBkg, "$this$formatAdaptiveBkg");
        return formatAdaptiveBkg(formatAdaptiveBkg.f448625m);
    }

    public static final SquareBuildingInfo formatBuildInfo(a formatBuildInfo) {
        Intrinsics.checkNotNullParameter(formatBuildInfo, "$this$formatBuildInfo");
        return new SquareBuildingInfo(formatBuildInfo.f408741a, formatBuildInfo.f408742b);
    }

    public static final FinishStatusInfo formatFinishStatusTask(rt4.e formatFinishStatusTask) {
        Intrinsics.checkNotNullParameter(formatFinishStatusTask, "$this$formatFinishStatusTask");
        FinishStatusInfo finishStatusInfo = new FinishStatusInfo(false, null, 3, null);
        finishStatusInfo.setFinish(formatFinishStatusTask.f432403b);
        w taskInfo = formatFinishStatusTask.f432404c;
        Intrinsics.checkNotNullExpressionValue(taskInfo, "taskInfo");
        finishStatusInfo.setTaskInfo(formatStatusTaskInfo(taskInfo));
        return finishStatusInfo;
    }

    public static final AvatarLocationInfo formatLocationInfo(j statusLoc) {
        Intrinsics.checkNotNullParameter(statusLoc, "statusLoc");
        double d16 = statusLoc.f406153a;
        double d17 = statusLoc.f406154b;
        String str = statusLoc.f406155c;
        Intrinsics.checkNotNullExpressionValue(str, "statusLoc.poi");
        String str2 = statusLoc.f406156d;
        Intrinsics.checkNotNullExpressionValue(str2, "statusLoc.poiId");
        String str3 = statusLoc.f406157e;
        Intrinsics.checkNotNullExpressionValue(str3, "statusLoc.poiAddress");
        return new AvatarLocationInfo(d16, d17, str, str2, str3);
    }

    public static final StatusLockInfo formatLockInfo(rt4.n formatLockInfo) {
        Intrinsics.checkNotNullParameter(formatLockInfo, "$this$formatLockInfo");
        int i3 = formatLockInfo.f432432a;
        String str = formatLockInfo.f432433b;
        Intrinsics.checkNotNullExpressionValue(str, "this.tips");
        String str2 = formatLockInfo.f432434c;
        Intrinsics.checkNotNullExpressionValue(str2, "this.buttonText");
        String str3 = formatLockInfo.f432435d;
        Intrinsics.checkNotNullExpressionValue(str3, "this.linkUrl");
        return new StatusLockInfo(i3, str, str2, str3);
    }

    public static final NewStatusInfo formatNewStatusRedDot(i formatNewStatusRedDot) {
        Intrinsics.checkNotNullParameter(formatNewStatusRedDot, "$this$formatNewStatusRedDot");
        long j3 = formatNewStatusRedDot.f432408a;
        String reddotImg = formatNewStatusRedDot.f432409b;
        Intrinsics.checkNotNullExpressionValue(reddotImg, "reddotImg");
        String categoryId = formatNewStatusRedDot.f432410c;
        Intrinsics.checkNotNullExpressionValue(categoryId, "categoryId");
        return new NewStatusInfo(j3, reddotImg, categoryId, formatNewStatusRedDot.f432411d, formatNewStatusRedDot.f432412e, Integer.valueOf(formatNewStatusRedDot.f432413f));
    }

    public static final OnlineStatus formatOnlineStatus(hs4.t formatOnlineStatus) {
        String str;
        Intrinsics.checkNotNullParameter(formatOnlineStatus, "$this$formatOnlineStatus");
        int i3 = formatOnlineStatus.f406210b;
        int i16 = i3 == 0 ? formatOnlineStatus.f406209a : i3;
        int i17 = formatOnlineStatus.f406209a;
        String title = formatOnlineStatus.f406211c;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String icon = formatOnlineStatus.f406212d;
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        String bigIcon = formatOnlineStatus.f406213e;
        Intrinsics.checkNotNullExpressionValue(bigIcon, "bigIcon");
        String extData = formatOnlineStatus.f406214f;
        Intrinsics.checkNotNullExpressionValue(extData, "extData");
        SpecialStatus formatSpecialStatus = formatSpecialStatus(extData);
        byte[] customText = formatOnlineStatus.f406215g;
        Intrinsics.checkNotNullExpressionValue(customText, "customText");
        if (customText.length == 0) {
            str = "";
        } else {
            byte[] customText2 = formatOnlineStatus.f406215g;
            Intrinsics.checkNotNullExpressionValue(customText2, "customText");
            str = new String(customText2, Charsets.UTF_8);
        }
        String str2 = formatOnlineStatus.f406216h;
        String motionIcon = formatOnlineStatus.f406217i;
        Intrinsics.checkNotNullExpressionValue(motionIcon, "motionIcon");
        return new OnlineStatus(i16, i17, i3, title, icon, bigIcon, formatSpecialStatus, str, str2, motionIcon);
    }

    public static final QZoneFeedsInfo formatQZoneFeedInfo(q formatQZoneFeedInfo) {
        Intrinsics.checkNotNullParameter(formatQZoneFeedInfo, "$this$formatQZoneFeedInfo");
        String feedsId = formatQZoneFeedInfo.f406184a;
        Intrinsics.checkNotNullExpressionValue(feedsId, "feedsId");
        int i3 = formatQZoneFeedInfo.f406185b;
        String text = formatQZoneFeedInfo.f406187d;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        String imageUrl = formatQZoneFeedInfo.f406188e;
        Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
        String jumpUrl = formatQZoneFeedInfo.f406189f;
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        return new QZoneFeedsInfo(feedsId, i3, text, imageUrl, jumpUrl, false, 32, null);
    }

    public static final Size formatSize(b formatSize, boolean z16) {
        Intrinsics.checkNotNullParameter(formatSize, "$this$formatSize");
        Application application = Square.INSTANCE.getApplication();
        int i3 = formatSize.f406127a;
        if (z16) {
            i3 = ViewExtensionsKt.calPx(application, i3);
        }
        int i16 = formatSize.f406128b;
        if (z16) {
            i16 = ViewExtensionsKt.calPx(application, i16);
        }
        return new Size(i3, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SquareMayKnowItem formatSquareItem(xt4.w formatSquareItem, Size size) {
        Location location;
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Application application = Square.INSTANCE.getApplication();
        if (size != null) {
            hs4.i iVar = formatSquareItem.f448659a;
            if (iVar != null) {
                b showDpi = formatSquareItem.f448669k;
                Intrinsics.checkNotNullExpressionValue(showDpi, "showDpi");
                location = formatSquareLocation(iVar, showDpi, size);
            } else {
                location = null;
            }
        }
        location = new Location(0, 0, ViewExtensionsKt.calPx(application, formatSquareItem.f448669k.f406127a), ViewExtensionsKt.calPx(application, formatSquareItem.f448669k.f406128b), 0, 0, 48, null);
        Location location2 = location;
        int i3 = formatSquareItem.f448660b;
        int i16 = formatSquareItem.f448661c;
        String str = formatSquareItem.f448662d;
        String str2 = formatSquareItem.f448663e;
        String str3 = formatSquareItem.f448664f;
        String str4 = formatSquareItem.f448665g;
        ArrayList arrayList = new ArrayList();
        es4.b[] bVarArr = formatSquareItem.f448666h;
        if (bVarArr != null) {
            for (es4.b it : bVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(MayKnowServiceKt.formatMayKnowLabel(it));
            }
        }
        Unit unit = Unit.INSTANCE;
        String maleUrl = formatSquareItem.f448667i;
        Intrinsics.checkNotNullExpressionValue(maleUrl, "maleUrl");
        String femaleUrl = formatSquareItem.f448668j;
        Intrinsics.checkNotNullExpressionValue(femaleUrl, "femaleUrl");
        return new SquareMayKnowItem(location2, i3, i16, str, str2, str3, str4, arrayList, maleUrl, femaleUrl);
    }

    public static final List<MapItem> formatSquareItemList(p formatSquareItemList, List<? extends SquareBaseMessageRecord> unreadList, boolean z16) {
        Object obj;
        Intrinsics.checkNotNullParameter(formatSquareItemList, "$this$formatSquareItemList");
        Intrinsics.checkNotNullParameter(unreadList, "unreadList");
        ArrayList arrayList = new ArrayList();
        Size size = new Size(formatSquareItemList.f448616d, formatSquareItemList.f448615c);
        ag[] infos = formatSquareItemList.f448613a;
        Intrinsics.checkNotNullExpressionValue(infos, "infos");
        for (ag userInfo : infos) {
            Iterator<T> it = unreadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((SquareBaseMessageRecord) obj).getUin(), String.valueOf(userInfo.f448537a))) {
                    break;
                }
            }
            Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
            arrayList.add(formatUserInfo(userInfo, (SquareBaseMessageRecord) obj, size, InteractionManager.INSTANCE.getSquareInteractionUnread(), formatSquareItemList.f448626n, formatSquareItemList.f448627o));
        }
        ah[] woInfos = formatSquareItemList.f448618f;
        Intrinsics.checkNotNullExpressionValue(woInfos, "woInfos");
        for (ah it5 : woInfos) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList.add(formatSquareItem(it5, size));
        }
        xt4.r[] guildInfos = formatSquareItemList.f448619g;
        Intrinsics.checkNotNullExpressionValue(guildInfos, "guildInfos");
        for (xt4.r it6 : guildInfos) {
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            arrayList.add(formatSquareItem(it6, size));
        }
        hs4.i[] availableLocations = formatSquareItemList.f448620h;
        Intrinsics.checkNotNullExpressionValue(availableLocations, "availableLocations");
        for (hs4.i it7 : availableLocations) {
            Intrinsics.checkNotNullExpressionValue(it7, "it");
            arrayList.add(formatSquareItem(it7, size));
        }
        xt4.q[] groupInfos = formatSquareItemList.f448621i;
        Intrinsics.checkNotNullExpressionValue(groupInfos, "groupInfos");
        for (xt4.q it8 : groupInfos) {
            Intrinsics.checkNotNullExpressionValue(it8, "it");
            arrayList.add(formatSquareItem(it8, size));
        }
        h[] baseEntryInfo = formatSquareItemList.f448622j;
        Intrinsics.checkNotNullExpressionValue(baseEntryInfo, "baseEntryInfo");
        for (h it9 : baseEntryInfo) {
            Intrinsics.checkNotNullExpressionValue(it9, "it");
            arrayList.add(formatSquareItem(it9, size));
        }
        xt4.w[] users = formatSquareItemList.f448623k;
        Intrinsics.checkNotNullExpressionValue(users, "users");
        for (xt4.w it10 : users) {
            Intrinsics.checkNotNullExpressionValue(it10, "it");
            arrayList.add(formatSquareItem(it10, size));
        }
        Iterator it11 = arrayList.iterator();
        while (it11.hasNext()) {
            ((MapItem) it11.next()).setFromCache(z16);
        }
        return arrayList;
    }

    public static final Location formatSquareLocation(hs4.i formatSquareLocation, b showDpi, Size mapSize) {
        Intrinsics.checkNotNullParameter(formatSquareLocation, "$this$formatSquareLocation");
        Intrinsics.checkNotNullParameter(showDpi, "showDpi");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Application application = Square.INSTANCE.getApplication();
        int calPx = ViewExtensionsKt.calPx(application, mapSize.getWidth());
        int calPx2 = ViewExtensionsKt.calPx(application, mapSize.getHeight());
        int calPx3 = ViewExtensionsKt.calPx(application, showDpi.f406127a);
        int calPx4 = ViewExtensionsKt.calPx(application, showDpi.f406128b);
        return new Location((ViewExtensionsKt.calPx(application, formatSquareLocation.f406149a) + (calPx / 2)) - (calPx3 / 2), ((-ViewExtensionsKt.calPx(application, formatSquareLocation.f406150b)) + (calPx2 / 2)) - (calPx4 / 2), calPx3, calPx4, formatSquareLocation.f406151c, formatSquareLocation.f406152d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (r14 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SquareRecommendUserItem formatSquareRecommendUserItem(at4.a formatSquareRecommendUserItem, Size size) {
        Location location;
        Intrinsics.checkNotNullParameter(formatSquareRecommendUserItem, "$this$formatSquareRecommendUserItem");
        b dpi = formatSquareRecommendUserItem.f26923b.f406194d.f406167b;
        Application app = SquareBase.INSTANCE.getApp();
        f user = formatSquareRecommendUserItem.f26922a;
        Intrinsics.checkNotNullExpressionValue(user, "user");
        MayKnowUser formatMayKnowUser = MayKnowServiceKt.formatMayKnowUser(user);
        if (size != null) {
            hs4.i iVar = formatSquareRecommendUserItem.f26924c;
            if (iVar != null) {
                Intrinsics.checkNotNullExpressionValue(dpi, "dpi");
                location = formatSquareLocation(iVar, dpi, size);
            } else {
                location = null;
            }
        }
        location = new Location(0, 0, ViewExtensionsKt.calPx(app, dpi.f406127a), ViewExtensionsKt.calPx(app, dpi.f406128b), 0, 0, 48, null);
        r resource = formatSquareRecommendUserItem.f26923b;
        Intrinsics.checkNotNullExpressionValue(resource, "resource");
        return new SquareRecommendUserItem(formatMayKnowUser, location, formatActionResource$default(resource, false, null, 6, null), formatSquareRecommendUserItem.f26925d);
    }

    public static final SquareUserInfo formatSquareUserInfo(c formatSquareUserInfo) {
        Intrinsics.checkNotNullParameter(formatSquareUserInfo, "$this$formatSquareUserInfo");
        String valueOf = String.valueOf(formatSquareUserInfo.f421250a);
        String str = formatSquareUserInfo.f421251b;
        Intrinsics.checkNotNullExpressionValue(str, "this.nick");
        String str2 = formatSquareUserInfo.f421252c;
        Intrinsics.checkNotNullExpressionValue(str2, "this.avatar");
        return new SquareUserInfo(valueOf, str, str2);
    }

    public static final PanelStatusTaskInfo formatStatusTaskInfo(w taskInfo) {
        PanelTaskBannerLinkType panelTaskBannerLinkType;
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        String str = taskInfo.f432468c.f432456a;
        Intrinsics.checkNotNullExpressionValue(str, "taskInfo.bannerInfo.title");
        String str2 = taskInfo.f432468c.f432457b;
        Intrinsics.checkNotNullExpressionValue(str2, "taskInfo.bannerInfo.desc");
        String str3 = taskInfo.f432468c.f432458c;
        Intrinsics.checkNotNullExpressionValue(str3, "taskInfo.bannerInfo.btnName");
        v vVar = taskInfo.f432468c;
        if (vVar.f432459d == 1) {
            panelTaskBannerLinkType = PanelTaskBannerLinkType.LINK_TYPE_H5;
        } else {
            panelTaskBannerLinkType = PanelTaskBannerLinkType.LINK_TYPE_SCHEMA;
        }
        String str4 = vVar.f432460e;
        Intrinsics.checkNotNullExpressionValue(str4, "taskInfo.bannerInfo.linkUrl");
        String str5 = taskInfo.f432468c.f432461f;
        Intrinsics.checkNotNullExpressionValue(str5, "taskInfo.bannerInfo.sucTitle");
        String str6 = taskInfo.f432468c.f432462g;
        Intrinsics.checkNotNullExpressionValue(str6, "taskInfo.bannerInfo.sucDesc");
        String str7 = taskInfo.f432468c.f432464i;
        Intrinsics.checkNotNullExpressionValue(str7, "taskInfo.bannerInfo.sucCancelBtnName");
        String str8 = taskInfo.f432468c.f432465j;
        Intrinsics.checkNotNullExpressionValue(str8, "taskInfo.bannerInfo.sucConfirmBtnName");
        String str9 = taskInfo.f432468c.f432463h;
        Intrinsics.checkNotNullExpressionValue(str9, "taskInfo.bannerInfo.sucMotionUrl");
        BannerInfo bannerInfo = new BannerInfo(str, str2, str3, panelTaskBannerLinkType, str4, str5, str6, str7, str8, str9);
        PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus = PanelStatusTaskPrizeStatus.PRIZE_STATUS_NIL;
        int i3 = taskInfo.f432470e;
        if (i3 != 0) {
            if (i3 == 1) {
                panelStatusTaskPrizeStatus = PanelStatusTaskPrizeStatus.PRIZE_PENDING;
            } else if (i3 == 2) {
                panelStatusTaskPrizeStatus = PanelStatusTaskPrizeStatus.PRIZE_VALID;
            } else if (i3 == 3) {
                panelStatusTaskPrizeStatus = PanelStatusTaskPrizeStatus.PRIZE_INVALID;
            }
        }
        return new PanelStatusTaskInfo(taskInfo.f432466a, taskInfo.f432467b, bannerInfo, panelStatusTaskPrizeStatus, taskInfo.f432472g);
    }

    public static final SquareWhitelist formatWhitelistStatus(zt4.d formatWhitelistStatus) {
        Intrinsics.checkNotNullParameter(formatWhitelistStatus, "$this$formatWhitelistStatus");
        zt4.e eVar = formatWhitelistStatus.f453412c;
        if (eVar == null) {
            return null;
        }
        boolean z16 = formatWhitelistStatus.f453410a;
        boolean z17 = formatWhitelistStatus.f453411b;
        String str = eVar.f453413a;
        Intrinsics.checkNotNullExpressionValue(str, "dialog.text");
        String str2 = formatWhitelistStatus.f453412c.f453414b;
        Intrinsics.checkNotNullExpressionValue(str2, "dialog.leftButtonText");
        String str3 = formatWhitelistStatus.f453412c.f453415c;
        Intrinsics.checkNotNullExpressionValue(str3, "dialog.rightButtonText");
        return new SquareWhitelist(z16, z17, new SquareWhiteListDialogInfo(str, str2, str3));
    }

    public static final RelationType parse(RelationType.Companion parse, int i3) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        if (i3 == 1) {
            return RelationType.SELF;
        }
        if (i3 != 2) {
            return RelationType.FRIEND;
        }
        return RelationType.STRANGER;
    }

    public static final void revisePickedAction(StatusActionInfo revisePickedAction) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(revisePickedAction, "$this$revisePickedAction");
        Iterator<T> it = revisePickedAction.getActionList().iterator();
        while (it.hasNext()) {
            if (((BaseResourceInfo) it.next()).getHasPick()) {
                return;
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) revisePickedAction.getActionList());
        BaseResourceInfo baseResourceInfo = (BaseResourceInfo) firstOrNull;
        if (baseResourceInfo != null) {
            baseResourceInfo.setPick(true);
        }
    }

    public static final SquarePageBackgroundInfo formatAdaptiveBkg(xt4.f formatAdaptiveBkg) {
        Intrinsics.checkNotNullParameter(formatAdaptiveBkg, "$this$formatAdaptiveBkg");
        return formatAdaptiveBkg(formatAdaptiveBkg.f448582b);
    }

    public static final SquareStyleInfo formatBuildInfo(it4.f formatBuildInfo) {
        Intrinsics.checkNotNullParameter(formatBuildInfo, "$this$formatBuildInfo");
        int i3 = formatBuildInfo.f408746a;
        String str = formatBuildInfo.f408747b;
        Intrinsics.checkNotNullExpressionValue(str, "this.picUrl");
        return new SquareStyleInfo(i3, str);
    }

    public static final SquarePageBackgroundInfo formatAdaptiveBkg(xt4.a aVar) {
        List<String> asList;
        if (aVar == null) {
            return null;
        }
        SquarePageBackgroundInfo squarePageBackgroundInfo = new SquarePageBackgroundInfo(null, null, null, 7, null);
        xt4.b bVar = aVar.f448515c;
        if (bVar != null) {
            String str = bVar.f448561a;
            Intrinsics.checkNotNullExpressionValue(str, "it.imgUrl");
            squarePageBackgroundInfo.setTopUrl(str);
        }
        xt4.b bVar2 = aVar.f448516d;
        if (bVar2 != null) {
            String str2 = bVar2.f448561a;
            Intrinsics.checkNotNullExpressionValue(str2, "it.imgUrl");
            squarePageBackgroundInfo.setBackgroundUrl(str2);
        }
        String[] strArr = aVar.f448514b;
        if (strArr != null) {
            asList = ArraysKt___ArraysJvmKt.asList(strArr);
            squarePageBackgroundInfo.setGradientArr(asList);
        }
        return squarePageBackgroundInfo;
    }

    public static final List<SquareAnchorEntrance> formatAnchorEntrance(List<xt4.d> entranceList) {
        AnchorBubble anchorBubble;
        Iterator it;
        Intrinsics.checkNotNullParameter(entranceList, "entranceList");
        ArrayList arrayList = new ArrayList();
        Iterator it5 = entranceList.iterator();
        while (it5.hasNext()) {
            xt4.d dVar = (xt4.d) it5.next();
            float f16 = dVar.f448570c;
            float f17 = dVar.f448568a;
            float f18 = dVar.f448571d;
            float f19 = dVar.f448569b;
            String str = dVar.f448572e;
            Intrinsics.checkNotNullExpressionValue(str, "it.link");
            EntranceLink entranceLink = new EntranceLink(str, dVar.f448573f != 1 ? 2 : 1);
            int i3 = dVar.f448574g;
            int i16 = dVar.f448575h;
            boolean z16 = dVar.f448576i;
            xt4.c cVar = dVar.f448577j;
            if (cVar == null) {
                it = it5;
                anchorBubble = null;
            } else {
                String str2 = cVar.f448564a;
                Intrinsics.checkNotNullExpressionValue(str2, "it.bubbleInfo.textBefore");
                String str3 = dVar.f448577j.f448565b;
                Intrinsics.checkNotNullExpressionValue(str3, "it.bubbleInfo.textAfter");
                hs4.a aVar = dVar.f448577j.f448566c;
                it = it5;
                anchorBubble = new AnchorBubble(str2, str3, new Point(aVar.f406125a, aVar.f406126b));
            }
            arrayList.add(new SquareAnchorEntrance(f16, f17, f18, f19, entranceLink, i3, i16, z16, anchorBubble));
            it5 = it;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SquareAvatarExtra formatAvatarExtra(ag formatAvatarExtra, SquareBaseMessageRecord squareBaseMessageRecord, boolean z16) {
        String str;
        OnlineStatus onlineStatus;
        SquareStrangerInfo squareStrangerInfo;
        SquareIntimateInfo squareIntimateInfo;
        k kVar;
        hs4.p[] pVarArr;
        Object first;
        Intrinsics.checkNotNullParameter(formatAvatarExtra, "$this$formatAvatarExtra");
        hs4.t tVar = formatAvatarExtra.f448540d;
        if (tVar == null) {
            onlineStatus = null;
        } else {
            int i3 = tVar.f406210b;
            int i16 = i3 == 0 ? tVar.f406209a : i3;
            int i17 = tVar.f406209a;
            String str2 = tVar.f406211c;
            Intrinsics.checkNotNullExpressionValue(str2, "statusInfo.title");
            String str3 = formatAvatarExtra.f448540d.f406212d;
            Intrinsics.checkNotNullExpressionValue(str3, "statusInfo.icon");
            String str4 = formatAvatarExtra.f448540d.f406213e;
            Intrinsics.checkNotNullExpressionValue(str4, "statusInfo.bigIcon");
            String str5 = formatAvatarExtra.f448540d.f406214f;
            Intrinsics.checkNotNullExpressionValue(str5, "statusInfo.extData");
            SpecialStatus formatSpecialStatus = formatSpecialStatus(str5);
            byte[] bArr = formatAvatarExtra.f448540d.f406215g;
            Intrinsics.checkNotNullExpressionValue(bArr, "statusInfo.customText");
            if (bArr.length == 0) {
                str = "";
            } else {
                byte[] bArr2 = formatAvatarExtra.f448540d.f406215g;
                Intrinsics.checkNotNullExpressionValue(bArr2, "statusInfo.customText");
                str = new String(bArr2, Charsets.UTF_8);
            }
            hs4.t tVar2 = formatAvatarExtra.f448540d;
            String str6 = tVar2.f406216h;
            String str7 = tVar2.f406217i;
            Intrinsics.checkNotNullExpressionValue(str7, "statusInfo.motionIcon");
            onlineStatus = new OnlineStatus(i16, i17, i3, str2, str3, str4, formatSpecialStatus, str, str6, str7);
        }
        if (formatAvatarExtra.f448553q == null || covertRelationType(formatAvatarExtra, formatAvatarExtra.f448550n) != RelationType.STRANGER) {
            squareStrangerInfo = null;
        } else {
            ae aeVar = formatAvatarExtra.f448553q;
            int i18 = aeVar.f448531a;
            String str8 = aeVar.f448532b;
            squareStrangerInfo = new SquareStrangerInfo(i18, str8 != null ? str8 : "");
        }
        hs4.h hVar = formatAvatarExtra.f448557u;
        if (hVar != null && (pVarArr = hVar.f406145a) != null && hVar.f406146b != null && hVar.f406147c != null) {
            Intrinsics.checkNotNullExpressionValue(pVarArr, "intimateInfo.mutualMarks");
            if (!(pVarArr.length == 0)) {
                g[] gVarArr = formatAvatarExtra.f448557u.f406146b;
                Intrinsics.checkNotNullExpressionValue(gVarArr, "intimateInfo.intimateDatas");
                if (!(gVarArr.length == 0)) {
                    hs4.p[] pVarArr2 = formatAvatarExtra.f448557u.f406145a;
                    Intrinsics.checkNotNullExpressionValue(pVarArr2, "intimateInfo.mutualMarks");
                    ArrayList arrayList = new ArrayList(pVarArr2.length);
                    for (hs4.p pVar : pVarArr2) {
                        String str9 = pVar.f406180b;
                        Intrinsics.checkNotNullExpressionValue(str9, "it.iconUrl");
                        arrayList.add(new SquareMutualMark(str9, pVar.f406179a));
                    }
                    g[] gVarArr2 = formatAvatarExtra.f448557u.f406146b;
                    Intrinsics.checkNotNullExpressionValue(gVarArr2, "intimateInfo.intimateDatas");
                    ArrayList arrayList2 = new ArrayList(gVarArr2.length);
                    for (g gVar : gVarArr2) {
                        int i19 = gVar.f406141a;
                        long j3 = gVar.f406142b;
                        String str10 = gVar.f406143c;
                        Intrinsics.checkNotNullExpressionValue(str10, "it.prefixText");
                        String str11 = gVar.f406144d;
                        Intrinsics.checkNotNullExpressionValue(str11, "it.suffixText");
                        arrayList2.add(new SquareIntimateData(i19, j3, str10, str11));
                    }
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                    String iconUrl = ((SquareMutualMark) first).getIconUrl();
                    String[] strArr = formatAvatarExtra.f448557u.f406147c;
                    Intrinsics.checkNotNullExpressionValue(strArr, "intimateInfo.animUrls");
                    ArrayList arrayList3 = new ArrayList(strArr.length);
                    for (String str12 : strArr) {
                        arrayList3.add(str12);
                    }
                    squareIntimateInfo = new SquareIntimateInfo(arrayList, iconUrl, arrayList3, arrayList2);
                    boolean z17 = !z16 && SquareBaseKt.getSquareCommon().getStudyMode() && formatAvatarExtra.f448550n == 2;
                    String str13 = null;
                    String str14 = null;
                    String str15 = null;
                    PlayState playState = null;
                    boolean z18 = formatAvatarExtra.f448546j;
                    boolean z19 = false;
                    LikeListInfo likeListInfo = null;
                    boolean z26 = false;
                    int i26 = 0;
                    CommonFootLabel commonFootLabel = null;
                    SquareBaseMessageRecord squareBaseMessageRecord2 = !z17 ? null : squareBaseMessageRecord;
                    SquarePosterInfo squarePosterInfo = null;
                    boolean z27 = !formatAvatarExtra.f448551o;
                    RelationType covertRelationType = covertRelationType(formatAvatarExtra, formatAvatarExtra.f448550n);
                    SquarePageBackgroundInfo squarePageBackgroundInfo = null;
                    String str16 = null;
                    ab abVar = formatAvatarExtra.f448552p;
                    int i27 = abVar != null ? abVar.f448520b : 0;
                    MedalData parse = (abVar != null || (kVar = abVar.f448521c) == null) ? null : FlowerDataConvertersKt.parse(kVar);
                    SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo = null;
                    boolean z28 = false;
                    Boolean bool = null;
                    fs4.o oVar = formatAvatarExtra.f448555s;
                    return new SquareAvatarExtra(str13, str14, str15, onlineStatus, playState, z18, z19, likeListInfo, z26, i26, commonFootLabel, squareBaseMessageRecord2, squarePosterInfo, z27, covertRelationType, squarePageBackgroundInfo, str16, i27, parse, squareStrangerInfo, squareBlindBoxEntranceInfo, z28, oVar == null ? SquareBubbleSkinKt.parse(oVar) : null, bool, squareIntimateInfo, false, 45193175, null);
                }
            }
        }
        squareIntimateInfo = null;
        if (z16) {
        }
        String str132 = null;
        String str142 = null;
        String str152 = null;
        PlayState playState2 = null;
        boolean z182 = formatAvatarExtra.f448546j;
        boolean z192 = false;
        LikeListInfo likeListInfo2 = null;
        boolean z262 = false;
        int i262 = 0;
        CommonFootLabel commonFootLabel2 = null;
        if (!z17) {
        }
        SquarePosterInfo squarePosterInfo2 = null;
        boolean z272 = !formatAvatarExtra.f448551o;
        RelationType covertRelationType2 = covertRelationType(formatAvatarExtra, formatAvatarExtra.f448550n);
        SquarePageBackgroundInfo squarePageBackgroundInfo2 = null;
        String str162 = null;
        ab abVar2 = formatAvatarExtra.f448552p;
        int i272 = abVar2 != null ? abVar2.f448520b : 0;
        if (abVar2 != null) {
        }
        SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo2 = null;
        boolean z282 = false;
        Boolean bool2 = null;
        fs4.o oVar2 = formatAvatarExtra.f448555s;
        return new SquareAvatarExtra(str132, str142, str152, onlineStatus, playState2, z182, z192, likeListInfo2, z262, i262, commonFootLabel2, squareBaseMessageRecord2, squarePosterInfo2, z272, covertRelationType2, squarePageBackgroundInfo2, str162, i272, parse, squareStrangerInfo, squareBlindBoxEntranceInfo2, z282, oVar2 == null ? SquareBubbleSkinKt.parse(oVar2) : null, bool2, squareIntimateInfo, false, 45193175, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006e A[LOOP:3: B:27:0x0055->B:37:0x006e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PanelInfo formatPanelInfo(rt4.k formatPanelInfo) {
        List list;
        int i3;
        boolean z16;
        boolean z17;
        List list2;
        Intrinsics.checkNotNullParameter(formatPanelInfo, "$this$formatPanelInfo");
        rt4.b[] categorys = formatPanelInfo.f432418a;
        Intrinsics.checkNotNullExpressionValue(categorys, "categorys");
        boolean z18 = true;
        if (categorys.length == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            rt4.b[] categorys2 = formatPanelInfo.f432418a;
            Intrinsics.checkNotNullExpressionValue(categorys2, "categorys");
            ArrayList arrayList = new ArrayList(categorys2.length);
            int length = categorys2.length;
            int i16 = 0;
            while (i16 < length) {
                rt4.b bVar = categorys2[i16];
                boolean enableFilamentDetail = SquareSwitchUtils.INSTANCE.enableFilamentDetail();
                rt4.u[] filamentGrid = bVar.f432395c;
                if (enableFilamentDetail) {
                    Intrinsics.checkNotNullExpressionValue(filamentGrid, "category.grids");
                    ArrayList arrayList2 = new ArrayList();
                    for (rt4.u uVar : filamentGrid) {
                        l[] lVarArr = uVar.f432451b;
                        Intrinsics.checkNotNullExpressionValue(lVarArr, "status.motionGroups");
                        int length2 = lVarArr.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 >= length2) {
                                z16 = false;
                                break;
                            }
                            s[] sVarArr = lVarArr[i17].f432429g;
                            if (sVarArr != null) {
                                if (!(sVarArr.length == 0 ? z18 : false)) {
                                    z17 = false;
                                    if (!(z17 ^ z18)) {
                                        z16 = z18;
                                        break;
                                    }
                                    i17++;
                                }
                            }
                            z17 = z18;
                            if (!(z17 ^ z18)) {
                            }
                        }
                        if (z16) {
                            arrayList2.add(uVar);
                        }
                    }
                    i3 = 0;
                    Object[] array = arrayList2.toArray(new rt4.u[0]);
                    if (array != null) {
                        filamentGrid = (rt4.u[]) array;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    i3 = 0;
                }
                String str = bVar.f432393a;
                Intrinsics.checkNotNullExpressionValue(str, "category.id");
                String str2 = bVar.f432394b;
                Intrinsics.checkNotNullExpressionValue(str2, "category.name");
                Intrinsics.checkNotNullExpressionValue(filamentGrid, "filamentGrid");
                ArrayList arrayList3 = new ArrayList(filamentGrid.length);
                int length3 = filamentGrid.length;
                for (int i18 = i3; i18 < length3; i18++) {
                    rt4.u grid = filamentGrid[i18];
                    Intrinsics.checkNotNullExpressionValue(grid, "grid");
                    String dressKey = formatPanelInfo.f432419b;
                    Intrinsics.checkNotNullExpressionValue(dressKey, "dressKey");
                    String pickIcon = formatPanelInfo.f432420c;
                    Intrinsics.checkNotNullExpressionValue(pickIcon, "pickIcon");
                    arrayList3.add(formatStatusActionInfo(grid, dressKey, pickIcon));
                }
                String dressKey2 = formatPanelInfo.f432419b;
                Intrinsics.checkNotNullExpressionValue(dressKey2, "dressKey");
                String str3 = bVar.f432396d;
                Intrinsics.checkNotNullExpressionValue(str3, "category.tip");
                arrayList.add(new PanelCategoryInfo(str, str2, arrayList3, dressKey2, str3));
                i16++;
                z18 = true;
            }
            list = arrayList;
        }
        rt4.q[] recomUsers = formatPanelInfo.f432421d;
        Intrinsics.checkNotNullExpressionValue(recomUsers, "recomUsers");
        if (recomUsers.length == 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            rt4.q[] recomUsers2 = formatPanelInfo.f432421d;
            Intrinsics.checkNotNullExpressionValue(recomUsers2, "recomUsers");
            ArrayList arrayList4 = new ArrayList(recomUsers2.length);
            for (rt4.q qVar : recomUsers2) {
                String valueOf = String.valueOf(qVar.f432444a);
                String str4 = qVar.f432445b;
                Intrinsics.checkNotNullExpressionValue(str4, "it.avatar");
                arrayList4.add(new FriendData(valueOf, str4, toNickName(qVar.f432446c, qVar.f432444a)));
            }
            list2 = arrayList4;
        }
        return new PanelInfo(list, list2);
    }

    public static final SpecialStatus formatSpecialStatus(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            if (jsonString.length() == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(jsonString);
            return new SpecialStatus(jSONObject.has("battery_level") ? Integer.valueOf(jSONObject.optInt("battery_level")) : null, jSONObject.has("desc") ? jSONObject.optString("desc") : null, jSONObject.has("uface_index") ? Integer.valueOf(jSONObject.optInt("uface_index")) : null, jSONObject.has("uface_type") ? Integer.valueOf(jSONObject.optInt("uface_type")) : null, new SongInfo(jSONObject.has("song_id") ? jSONObject.optString("song_id") : null, jSONObject.has("song_name") ? jSONObject.optString("song_name") : null, jSONObject.has("singer_name") ? jSONObject.optString("singer_name") : null));
        } catch (Exception unused) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "formatSpecialStatus", "json parse error " + jsonString, null, 4, null);
            return null;
        }
    }

    public static final String toNickName(byte[] bArr, long j3) {
        String str;
        if (bArr != null) {
            if (bArr.length == 0) {
                str = String.valueOf(j3);
            } else {
                str = new String(bArr, Charsets.UTF_8);
            }
        } else {
            str = null;
        }
        return str != null ? str : "";
    }

    public static final Resource formatActionResource(r resourceInfo, boolean z16, s sVar) {
        b bVar;
        Size size;
        b bVar2;
        hs4.l lVar;
        b bVar3;
        Size formatSize$default;
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        if (resourceInfo.f406199i != 1) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "UserFormat", "formatActionResource styleType != 1, " + resourceInfo.f406191a + ", " + resourceInfo.f406199i, null, 4, null);
        }
        Size size2 = null;
        if (sVar == null || (lVar = sVar.f406203c) == null || (bVar3 = lVar.f406167b) == null || (formatSize$default = formatSize$default(bVar3, false, 1, null)) == null) {
            hs4.l lVar2 = resourceInfo.f406194d;
            if (lVar2 != null && (bVar = lVar2.f406167b) != null) {
                size2 = formatSize$default(bVar, false, 1, null);
            }
        } else {
            size2 = formatSize$default;
        }
        if (size2 == null) {
            size2 = new Size(0, 0);
        }
        Size size3 = size2;
        int i3 = resourceInfo.f406191a;
        hs4.l lVar3 = resourceInfo.f406194d;
        if (lVar3 == null || (bVar2 = lVar3.f406166a) == null || (size = formatSize(bVar2, false)) == null) {
            size = new Size(0, 0);
        }
        Size size4 = size;
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        hs4.a aVar = resourceInfo.f406195e;
        int calPx = ViewExtensionsKt.calPx(app, aVar != null ? aVar.f406125a : 0);
        Application app2 = squareBase.getApp();
        hs4.a aVar2 = resourceInfo.f406195e;
        Resource resource = new Resource(i3, null, null, size3, size4, false, new Point(calPx, ViewExtensionsKt.calPx(app2, aVar2 != null ? aVar2.f406126b : 0)), resourceInfo.f406196f, resourceInfo.f406199i, null, 550, null);
        fill(resource, resourceInfo.f406192b, resourceInfo.f406193c, z16, resourceInfo.f406196f);
        filamentFill(resource, sVar);
        return resource;
    }

    public static final BaseResourceInfo formatResourceInfo(l formatResourceInfo, OnlineStatus status, String dressKey) {
        String str;
        String str2;
        s sVar;
        boolean z16;
        m mVar;
        b bVar;
        b bVar2;
        Object firstOrNull;
        RecordResourceInfo recordResourceInfo;
        String str3;
        String str4;
        s sVar2;
        boolean z17;
        m mVar2;
        b bVar3;
        b bVar4;
        Intrinsics.checkNotNullParameter(formatResourceInfo, "$this$formatResourceInfo");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        boolean areEqual = Intrinsics.areEqual(dressKey, SquareRecordManager.INSTANCE.getDressKey());
        if (formatResourceInfo.f432424b == 0) {
            r[] resources = formatResourceInfo.f432423a;
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(resources);
            r rVar = (r) firstOrNull;
            if (rVar != null) {
                s[] sVarArr = formatResourceInfo.f432429g;
                if (sVarArr != null) {
                    int length = sVarArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        sVar2 = sVarArr[i3];
                        if (sVar2.f406201a == rVar.f406191a) {
                            break;
                        }
                    }
                }
                sVar2 = null;
                Resource formatActionResource = formatActionResource(rVar, areEqual, sVar2);
                hs4.l lVar = rVar.f406194d;
                int i16 = (lVar == null || (bVar4 = lVar.f406166a) == null) ? 0 : bVar4.f406127a;
                int i17 = (lVar == null || (bVar3 = lVar.f406166a) == null) ? 0 : bVar3.f406128b;
                if (SquareMedia.INSTANCE.getEnabledUseUrl()) {
                    n nVar = rVar.f406193c;
                    String str5 = (nVar == null || (mVar2 = nVar.f406172a) == null) ? null : mVar2.f406169a;
                    if (!(str5 == null || str5.length() == 0)) {
                        z17 = true;
                        recordResourceInfo = new RecordResourceInfo(formatActionResource, i16, i17, z17);
                    }
                }
                z17 = false;
                recordResourceInfo = new RecordResourceInfo(formatActionResource, i16, i17, z17);
            } else {
                recordResourceInfo = null;
            }
            rt4.r rVar2 = formatResourceInfo.f432427e;
            String str6 = rVar2 != null ? rVar2.f432447a : null;
            rt4.m mVar3 = formatResourceInfo.f432425c;
            String str7 = (mVar3 == null || (str4 = mVar3.f432430a) == null) ? "" : str4;
            if (mVar3 == null || (str3 = mVar3.f432431b) == null) {
                str3 = "";
            }
            rt4.n nVar2 = formatResourceInfo.f432428f;
            SingleResourceInfo singleResourceInfo = new SingleResourceInfo(status, recordResourceInfo, str6, str7, str3, nVar2 != null ? formatLockInfo(nVar2) : null);
            singleResourceInfo.setPick(formatResourceInfo.f432426d);
            return singleResourceInfo;
        }
        r[] resources2 = formatResourceInfo.f432423a;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        ArrayList arrayList = new ArrayList(resources2.length);
        for (r it : resources2) {
            s[] sVarArr2 = formatResourceInfo.f432429g;
            if (sVarArr2 != null) {
                int length2 = sVarArr2.length;
                for (int i18 = 0; i18 < length2; i18++) {
                    sVar = sVarArr2[i18];
                    if (sVar.f406201a == it.f406191a) {
                        break;
                    }
                }
            }
            sVar = null;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Resource formatActionResource2 = formatActionResource(it, areEqual, sVar);
            hs4.l lVar2 = it.f406194d;
            int i19 = (lVar2 == null || (bVar2 = lVar2.f406166a) == null) ? 0 : bVar2.f406127a;
            int i26 = (lVar2 == null || (bVar = lVar2.f406166a) == null) ? 0 : bVar.f406128b;
            if (SquareMedia.INSTANCE.getEnabledUseUrl()) {
                n nVar3 = it.f406193c;
                String str8 = (nVar3 == null || (mVar = nVar3.f406172a) == null) ? null : mVar.f406169a;
                if (!(str8 == null || str8.length() == 0)) {
                    z16 = true;
                    arrayList.add(new RecordResourceInfo(formatActionResource2, i19, i26, z16));
                }
            }
            z16 = false;
            arrayList.add(new RecordResourceInfo(formatActionResource2, i19, i26, z16));
        }
        rt4.r rVar3 = formatResourceInfo.f432427e;
        String str9 = rVar3 != null ? rVar3.f432447a : null;
        rt4.m mVar4 = formatResourceInfo.f432425c;
        String str10 = (mVar4 == null || (str2 = mVar4.f432430a) == null) ? "" : str2;
        String str11 = (mVar4 == null || (str = mVar4.f432431b) == null) ? "" : str;
        rt4.n nVar4 = formatResourceInfo.f432428f;
        MultiResourceInfo multiResourceInfo = new MultiResourceInfo(status, arrayList, str9, str10, str11, nVar4 != null ? formatLockInfo(nVar4) : null);
        multiResourceInfo.setPick(formatResourceInfo.f432426d);
        return multiResourceInfo;
    }

    public static final StatusActionInfo formatStatusActionInfo(rt4.u formatStatusActionInfo, String dressKey, String pickIcon) {
        PanelStatusTaskInfo panelStatusTaskInfo;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(formatStatusActionInfo, "$this$formatStatusActionInfo");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(pickIcon, "pickIcon");
        hs4.t statusInfo = formatStatusActionInfo.f432450a;
        if (statusInfo == null) {
            return new StatusActionInfo(null, null, null, null, false, null, null, 127, null);
        }
        Intrinsics.checkNotNullExpressionValue(statusInfo, "statusInfo");
        OnlineStatus formatOnlineStatus = formatOnlineStatus(statusInfo);
        l[] motionGroups = formatStatusActionInfo.f432451b;
        Intrinsics.checkNotNullExpressionValue(motionGroups, "motionGroups");
        ArrayList arrayList = new ArrayList(motionGroups.length);
        for (l it : motionGroups) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(formatResourceInfo(it, formatOnlineStatus, dressKey));
        }
        rt4.c cVar = formatStatusActionInfo.f432453d;
        String str3 = (cVar == null || (str2 = cVar.f432398b) == null) ? "" : str2;
        String str4 = (cVar == null || (str = cVar.f432397a) == null) ? "" : str;
        boolean z16 = formatStatusActionInfo.f432454e;
        w statusTaskInfo = formatStatusActionInfo.f432455f;
        if (statusTaskInfo != null) {
            Intrinsics.checkNotNullExpressionValue(statusTaskInfo, "statusTaskInfo");
            panelStatusTaskInfo = formatStatusTaskInfo(statusTaskInfo);
        } else {
            panelStatusTaskInfo = new PanelStatusTaskInfo(0, 0, null, null, 0, 31, null);
        }
        StatusActionInfo statusActionInfo = new StatusActionInfo(formatOnlineStatus, arrayList, str3, str4, z16, pickIcon, panelStatusTaskInfo);
        revisePickedAction(statusActionInfo);
        return statusActionInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
    
        if (r1 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SquareAvatarItem formatUserInfo(ag formatUserInfo, SquareBaseMessageRecord squareBaseMessageRecord, Size size, InteractionUnreadInfo interactionUnreadInfo, String str, boolean z16) {
        List emptyList;
        Location location;
        List emptyList2;
        List list;
        QZoneFeedsInfo qZoneFeedsInfo;
        AvatarLocationInfo formatLocationInfo;
        InteractionUnreadInfo interactionUnreadInfo2;
        InteractionUnreadInfo interactionUnreadInfo3;
        Intrinsics.checkNotNullParameter(formatUserInfo, "$this$formatUserInfo");
        boolean isCurrentAccount = Square.INSTANCE.getConfig().getCommonUtils().isCurrentAccount(String.valueOf(formatUserInfo.f448537a));
        if (isCurrentAccount) {
            s sVar = formatUserInfo.f448556t;
            SquareBaseKt.getSquareLog().i("UserInfo.formatUserInfo: filament", String.valueOf(sVar != null ? Integer.valueOf(sVar.f406201a) : null));
        }
        String nickName = toNickName(formatUserInfo.f448538b, formatUserInfo.f448537a);
        b dpi = formatUserInfo.f448542f.f406194d.f406167b;
        Application app = SquareBase.INSTANCE.getApp();
        List<AvatarAction> formatActions = formatActions(formatUserInfo);
        String valueOf = String.valueOf(formatUserInfo.f448537a);
        boolean z17 = formatUserInfo.f448539c == Gender.MALE.ordinal();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        String dressKey = formatUserInfo.f448544h;
        Intrinsics.checkNotNullExpressionValue(dressKey, "dressKey");
        SquareAvatarExtra formatAvatarExtra = formatAvatarExtra(formatUserInfo, squareBaseMessageRecord, z16);
        formatAvatarExtra.setFlowerBubbleText(str);
        Unit unit = Unit.INSTANCE;
        if (size != null) {
            hs4.i iVar = formatUserInfo.f448541e;
            if (iVar != null) {
                Intrinsics.checkNotNullExpressionValue(dpi, "dpi");
                location = formatSquareLocation(iVar, dpi, size);
            } else {
                location = null;
            }
        }
        location = new Location(0, 0, ViewExtensionsKt.calPx(app, dpi.f406127a), ViewExtensionsKt.calPx(app, dpi.f406128b), 0, 0, 48, null);
        xt4.v[] vVarArr = formatUserInfo.f448547k;
        if (vVarArr == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList2;
        } else {
            ArrayList arrayList = new ArrayList(vVarArr.length);
            int length = vVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                xt4.v vVar = vVarArr[i3];
                int i16 = vVar.f448655a;
                xt4.v[] vVarArr2 = vVarArr;
                boolean z18 = vVar.f448656b;
                String str2 = vVar.f448657c;
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(new NewInfo(i16, z18, str2));
                i3++;
                vVarArr = vVarArr2;
            }
            list = arrayList;
        }
        q qVar = formatUserInfo.f448548l;
        if (qVar == null || (qZoneFeedsInfo = formatQZoneFeedInfo(qVar)) == null) {
            qZoneFeedsInfo = new QZoneFeedsInfo(null, 0, null, null, null, false, 31, null);
        }
        j statusLoc = formatUserInfo.f448549m;
        if (statusLoc == null) {
            formatLocationInfo = new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null);
        } else {
            Intrinsics.checkNotNullExpressionValue(statusLoc, "statusLoc");
            formatLocationInfo = formatLocationInfo(statusLoc);
        }
        if (!isCurrentAccount) {
            interactionUnreadInfo2 = new InteractionUnreadInfo(0, null, 3, null);
        } else if (interactionUnreadInfo == null) {
            interactionUnreadInfo2 = new InteractionUnreadInfo(0, null, 3, null);
        } else {
            interactionUnreadInfo3 = interactionUnreadInfo;
            return new SquareAvatarItem(valueOf, z17, nickName, isCurrentAccount, formatActions, formatActions, null, formatAvatarExtra, location, dressKey, list, emptyList, qZoneFeedsInfo, formatLocationInfo, interactionUnreadInfo3, Stickers.INSTANCE.parse(formatUserInfo.f448554r), 64, null);
        }
        interactionUnreadInfo3 = interactionUnreadInfo2;
        return new SquareAvatarItem(valueOf, z17, nickName, isCurrentAccount, formatActions, formatActions, null, formatAvatarExtra, location, dressKey, list, emptyList, qZoneFeedsInfo, formatLocationInfo, interactionUnreadInfo3, Stickers.INSTANCE.parse(formatUserInfo.f448554r), 64, null);
    }

    public static /* synthetic */ void filamentFill$default(Resource resource, s sVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            sVar = null;
        }
        filamentFill(resource, sVar);
    }

    public static /* synthetic */ void fill$default(Resource resource, n nVar, n nVar2, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        fill(resource, nVar, nVar2, z16, i3);
    }

    public static /* synthetic */ Size formatSize$default(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return formatSize(bVar, z16);
    }

    public static final List<AvatarAction> formatActions(r formatActions) {
        Intrinsics.checkNotNullParameter(formatActions, "$this$formatActions");
        Resource formatActionResource$default = formatActionResource$default(formatActions, false, null, 6, null);
        hs4.l lVar = formatActions.f406194d;
        b bVar = lVar.f406167b;
        b bVar2 = lVar.f406166a;
        Application application = Square.INSTANCE.getApplication();
        formatActionResource$default.setShowSize(new Size(ViewExtensionsKt.calPx(application, bVar.f406127a), ViewExtensionsKt.calPx(application, bVar.f406128b)));
        formatActionResource$default.setRecordSize(new Size(ViewExtensionsKt.calPx(application, bVar2.f406127a), ViewExtensionsKt.calPx(application, bVar2.f406128b)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AvatarAction(formatActionResource$default, formatActionResource$default, null, null, 12, null));
        return arrayList;
    }

    public static /* synthetic */ Resource formatActionResource$default(r rVar, boolean z16, s sVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            sVar = null;
        }
        return formatActionResource(rVar, z16, sVar);
    }

    public static /* synthetic */ SquareAvatarItem formatUserInfo$default(ag agVar, SquareBaseMessageRecord squareBaseMessageRecord, Size size, InteractionUnreadInfo interactionUnreadInfo, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        return formatUserInfo(agVar, squareBaseMessageRecord, size, interactionUnreadInfo, str, z16);
    }

    public static final SquareTroopItem formatSquareItem(ht4.b formatSquareItem) {
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        ht4.c[] cVarArr = formatSquareItem.f406259a;
        if (cVarArr.length != 1) {
            return null;
        }
        ht4.c cVar = cVarArr[0];
        Application application = Square.INSTANCE.getApplication();
        Location location = new Location(0, 0, ViewExtensionsKt.calPx(application, cVar.f406267g.f406127a), ViewExtensionsKt.calPx(application, cVar.f406267g.f406128b), 0, 0, 48, null);
        byte[] bArr = cVar.f406262b;
        Intrinsics.checkNotNullExpressionValue(bArr, "groupInfo.name");
        String str = new String(bArr, Charsets.UTF_8);
        String str2 = cVar.f406263c;
        Intrinsics.checkNotNullExpressionValue(str2, "groupInfo.icon");
        String valueOf = String.valueOf(cVar.f406268h);
        r rVar = cVar.f406264d;
        Intrinsics.checkNotNullExpressionValue(rVar, "groupInfo.ownerResource");
        Resource formatActionResource$default = formatActionResource$default(rVar, false, cVar.f406269i, 2, null);
        String str3 = cVar.f406266f;
        Intrinsics.checkNotNullExpressionValue(str3, "groupInfo.tentDynamic");
        String str4 = cVar.f406265e;
        Intrinsics.checkNotNullExpressionValue(str4, "groupInfo.tentStatic");
        return new SquareTroopItem(String.valueOf(cVar.f406261a), false, location, str, str2, null, valueOf, formatActionResource$default, str3, str4, false, null, 3104, null);
    }

    public static final SquareEntranceItem formatSquareItem(ah formatSquareItem, Size mapSize) {
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        h woInfo = formatSquareItem.f448560a;
        Intrinsics.checkNotNullExpressionValue(woInfo, "woInfo");
        return formatSquareItem(woInfo, mapSize);
    }

    public static final SquareEntranceItem formatSquareItem(xt4.r formatSquareItem, Size mapSize) {
        String str;
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        h baseInfo = formatSquareItem.f448642a;
        Intrinsics.checkNotNullExpressionValue(baseInfo, "baseInfo");
        SquareEntranceItem formatSquareItem2 = formatSquareItem(baseInfo, mapSize);
        if (formatSquareItem.f448643b) {
            str = formatSquareItem.f448642a.f448590c;
            Intrinsics.checkNotNullExpressionValue(str, "baseInfo.name");
        } else {
            str = formatSquareItem.f448642a.f448590c + "(\u672a\u52a0\u5165)";
        }
        formatSquareItem2.setName(str);
        return formatSquareItem2;
    }

    public static final SquareTroopItem formatSquareItem(xt4.q formatSquareItem, Size mapSize) {
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        String valueOf = String.valueOf(formatSquareItem.f448630a);
        boolean z16 = false;
        hs4.i location = formatSquareItem.f448637h;
        Intrinsics.checkNotNullExpressionValue(location, "location");
        b showDpi = formatSquareItem.f448639j;
        Intrinsics.checkNotNullExpressionValue(showDpi, "showDpi");
        Location formatSquareLocation = formatSquareLocation(location, showDpi, mapSize);
        byte[] name = formatSquareItem.f448631b;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String str = new String(name, Charsets.UTF_8);
        String icon = formatSquareItem.f448632c;
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        SquareTroopMessageRecord squareTroopMessageRecord = null;
        String valueOf2 = String.valueOf(formatSquareItem.f448634e);
        r ownerResource = formatSquareItem.f448633d;
        Intrinsics.checkNotNullExpressionValue(ownerResource, "ownerResource");
        Resource formatActionResource$default = formatActionResource$default(ownerResource, false, formatSquareItem.f448640k, 2, null);
        String tentDynamic = formatSquareItem.f448636g;
        Intrinsics.checkNotNullExpressionValue(tentDynamic, "tentDynamic");
        String tentStatic = formatSquareItem.f448635f;
        Intrinsics.checkNotNullExpressionValue(tentStatic, "tentStatic");
        return new SquareTroopItem(valueOf, z16, formatSquareLocation, str, icon, squareTroopMessageRecord, valueOf2, formatActionResource$default, tentDynamic, tentStatic, formatSquareItem.f448638i == 1, null, 2080, null);
    }

    public static final SquareEntranceItem formatSquareItem(h formatSquareItem, Size mapSize) {
        List formatAnchorEntrance;
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        String valueOf = String.valueOf(formatSquareItem.f448599l);
        String name = formatSquareItem.f448590c;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String url = formatSquareItem.f448589b;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        String link = formatSquareItem.f448588a;
        Intrinsics.checkNotNullExpressionValue(link, "link");
        EntranceLink entranceLink = new EntranceLink(link, formatSquareItem.f448595h);
        hs4.i location = formatSquareItem.f448591d;
        Intrinsics.checkNotNullExpressionValue(location, "location");
        b showDpi = formatSquareItem.f448592e;
        Intrinsics.checkNotNullExpressionValue(showDpi, "showDpi");
        Location formatSquareLocation = formatSquareLocation(location, showDpi, mapSize);
        String title = formatSquareItem.f448593f;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String titleIcon = formatSquareItem.f448594g;
        Intrinsics.checkNotNullExpressionValue(titleIcon, "titleIcon");
        EntranceBubble entranceBubble = new EntranceBubble(title, titleIcon);
        int i3 = formatSquareItem.f448596i;
        int i16 = formatSquareItem.f448599l;
        int i17 = formatSquareItem.f448598k;
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        hs4.a aVar = formatSquareItem.f448600m;
        int calPx = ViewExtensionsKt.calPx(app, aVar != null ? aVar.f406125a : 0);
        Application app2 = squareBase.getApp();
        hs4.a aVar2 = formatSquareItem.f448600m;
        Point point = new Point(calPx, ViewExtensionsKt.calPx(app2, aVar2 != null ? aVar2.f406126b : 0));
        xt4.d[] dVarArr = formatSquareItem.f448597j;
        if (dVarArr == null) {
            formatAnchorEntrance = new ArrayList();
        } else {
            List asList = Arrays.asList((xt4.d[]) Arrays.copyOf(dVarArr, dVarArr.length));
            Intrinsics.checkNotNullExpressionValue(asList, "Arrays.asList(*anchorEntryInfo)");
            formatAnchorEntrance = formatAnchorEntrance(asList);
        }
        return new SquareEntranceItem(valueOf, name, url, entranceLink, formatSquareLocation, entranceBubble, i3, i16, i17, point, null, formatAnchorEntrance, null, formatSquareItem.f448601n, MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE, null);
    }

    public static final SquareEmptyData formatSquareItem(hs4.i formatSquareItem, Size mapSize) {
        Intrinsics.checkNotNullParameter(formatSquareItem, "$this$formatSquareItem");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        b bVar = new b();
        bVar.f406127a = 10;
        bVar.f406128b = 10;
        Unit unit = Unit.INSTANCE;
        return new SquareEmptyData(formatSquareLocation(formatSquareItem, bVar, mapSize));
    }
}
