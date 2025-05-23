package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import feedcloud.FeedCloudOfficialaccount$TopUserDetail;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRead$StPrePullOfficialAccountOverlayADRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0005/0123B\u0007\u00a2\u0006\u0004\b-\u0010.J`\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u0011J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J(\u0010\u0018\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u0011JD\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u0011J*\u0010!\u001a\u00020\u00102\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002` J\u001e\u0010$\u001a\u00020\u00102\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`#J\u001c\u0010&\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0014H\u0002J&\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\n*\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0002J\f\u0010)\u001a\u00020\u0004*\u00020\u0019H\u0002J\u0012\u0010,\u001a\u00020+2\b\u0010\u0015\u001a\u0004\u0018\u00010*H\u0002\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "attachInfo", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;", "requestType", "", "enableCacheResult", "", "currentFeedIds", "", "transInfo", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$GetFeedResult;", "", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetFeedCallback;", "callback", "w", "Lfeedcloud/FeedCloudRead$StGetFeedListRsp;", "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ReportConstant.COSTREPORT_PREFIX, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "source", "action", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$b;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetAdMaskInfoCallback;", "I", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$c;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetOfficialTopFollowUsersCallback;", "E", "lastFeedRsp", "p", "Le30/b;", "N", "P", "Lfeedcloud/FeedCloudRead$StPrePullOfficialAccountOverlayADRsp;", "Lorg/json/JSONObject;", "v", "<init>", "()V", "a", "b", "GetFeedResult", "c", "RequestType", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredRepo {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u000e\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u0011\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$GetFeedResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "g", "()Z", "isSucceed", "b", "e", QAdRewardDefine$VideoParams.ISCACHE, "c", "f", "isFinished", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "attachInfo", "", "J", "()J", "code", "msg", "", "Le30/b;", "Ljava/util/List;", "()Ljava/util/List;", "dataList", "<init>", "(ZZZLjava/lang/String;JLjava/lang/String;Ljava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final /* data */ class GetFeedResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSucceed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isCache;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFinished;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String attachInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long code;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<e30.b> dataList;

        public GetFeedResult(boolean z16, boolean z17, boolean z18, @Nullable String str, long j3, @NotNull String msg2, @NotNull List<e30.b> dataList) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.isSucceed = z16;
            this.isCache = z17;
            this.isFinished = z18;
            this.attachInfo = str;
            this.code = j3;
            this.msg = msg2;
            this.dataList = dataList;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getAttachInfo() {
            return this.attachInfo;
        }

        /* renamed from: b, reason: from getter */
        public final long getCode() {
            return this.code;
        }

        @NotNull
        public final List<e30.b> c() {
            return this.dataList;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsCache() {
            return this.isCache;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetFeedResult)) {
                return false;
            }
            GetFeedResult getFeedResult = (GetFeedResult) other;
            if (this.isSucceed == getFeedResult.isSucceed && this.isCache == getFeedResult.isCache && this.isFinished == getFeedResult.isFinished && Intrinsics.areEqual(this.attachInfo, getFeedResult.attachInfo) && this.code == getFeedResult.code && Intrinsics.areEqual(this.msg, getFeedResult.msg) && Intrinsics.areEqual(this.dataList, getFeedResult.dataList)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsFinished() {
            return this.isFinished;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsSucceed() {
            return this.isSucceed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isSucceed;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.isCache;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            boolean z17 = this.isFinished;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i19 = (i18 + i3) * 31;
            String str = this.attachInfo;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((((((i19 + hashCode) * 31) + androidx.fragment.app.a.a(this.code)) * 31) + this.msg.hashCode()) * 31) + this.dataList.hashCode();
        }

        @NotNull
        public String toString() {
            String joinToString$default;
            boolean z16 = this.isSucceed;
            boolean z17 = this.isCache;
            boolean z18 = this.isFinished;
            String str = this.attachInfo;
            long j3 = this.code;
            String str2 = this.msg;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.dataList, null, null, null, 0, null, new Function1<e30.b, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo$GetFeedResult$toString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull e30.b it) {
                    PBStringField pBStringField;
                    Intrinsics.checkNotNullParameter(it, "it");
                    FeedCloudMeta$StFeed g16 = it.g();
                    String str3 = (g16 == null || (pBStringField = g16.f398449id) == null) ? null : pBStringField.get();
                    return str3 == null ? "" : str3;
                }
            }, 31, null);
            return "GetFeedResult(isSucceed=" + z16 + ", isCache=" + z17 + ", isFinished=" + z18 + ", attachInfo=" + str + ", code=" + j3 + ", msg='" + str2 + "', dataList=" + joinToString$default + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "UNKNOWN", "INIT_FETCH_CACHED", "INIT_FETCH", QzoneDataUpdateAction.LOAD_MORE, "REFRESH", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public enum RequestType {
        UNKNOWN,
        INIT_FETCH_CACHED,
        INIT_FETCH,
        LOAD_MORE,
        REFRESH;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000e\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isSucceed", "b", "d", QAdRewardDefine$VideoParams.ISCACHE, "", "c", "J", "()J", "code", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "maskTaskInfo", "<init>", "(ZZJLjava/lang/String;Lorg/json/JSONObject;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo$b, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class GetAdMaskTaskInfoResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSucceed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isCache;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long code;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final JSONObject maskTaskInfo;

        public GetAdMaskTaskInfoResult(boolean z16, boolean z17, long j3, @NotNull String msg2, @NotNull JSONObject maskTaskInfo) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(maskTaskInfo, "maskTaskInfo");
            this.isSucceed = z16;
            this.isCache = z17;
            this.code = j3;
            this.msg = msg2;
            this.maskTaskInfo = maskTaskInfo;
        }

        /* renamed from: a, reason: from getter */
        public final long getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final JSONObject getMaskTaskInfo() {
            return this.maskTaskInfo;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsCache() {
            return this.isCache;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSucceed() {
            return this.isSucceed;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetAdMaskTaskInfoResult)) {
                return false;
            }
            GetAdMaskTaskInfoResult getAdMaskTaskInfoResult = (GetAdMaskTaskInfoResult) other;
            if (this.isSucceed == getAdMaskTaskInfoResult.isSucceed && this.isCache == getAdMaskTaskInfoResult.isCache && this.code == getAdMaskTaskInfoResult.code && Intrinsics.areEqual(this.msg, getAdMaskTaskInfoResult.msg) && Intrinsics.areEqual(this.maskTaskInfo, getAdMaskTaskInfoResult.maskTaskInfo)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            boolean z16 = this.isSucceed;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isCache;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((((((i16 + i3) * 31) + androidx.fragment.app.a.a(this.code)) * 31) + this.msg.hashCode()) * 31) + this.maskTaskInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetAdMaskTaskInfoResult(isSucceed=" + this.isSucceed + ", isCache=" + this.isCache + ", code=" + this.code + ", msg=" + this.msg + ", maskTaskInfo=" + this.maskTaskInfo + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSucceed", "", "b", "J", "()J", "code", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "()Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "rsp", "<init>", "(ZJLjava/lang/String;Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo$c, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class GetOfficialTopFollowUsersResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSucceed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long code;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final FeedCloudOfficialaccount$OfficialTopFollowUsersRsp rsp;

        public GetOfficialTopFollowUsersResult(boolean z16, long j3, @NotNull String msg2, @Nullable FeedCloudOfficialaccount$OfficialTopFollowUsersRsp feedCloudOfficialaccount$OfficialTopFollowUsersRsp) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.isSucceed = z16;
            this.code = j3;
            this.msg = msg2;
            this.rsp = feedCloudOfficialaccount$OfficialTopFollowUsersRsp;
        }

        /* renamed from: a, reason: from getter */
        public final long getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final FeedCloudOfficialaccount$OfficialTopFollowUsersRsp getRsp() {
            return this.rsp;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSucceed() {
            return this.isSucceed;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetOfficialTopFollowUsersResult)) {
                return false;
            }
            GetOfficialTopFollowUsersResult getOfficialTopFollowUsersResult = (GetOfficialTopFollowUsersResult) other;
            if (this.isSucceed == getOfficialTopFollowUsersResult.isSucceed && this.code == getOfficialTopFollowUsersResult.code && Intrinsics.areEqual(this.msg, getOfficialTopFollowUsersResult.msg) && Intrinsics.areEqual(this.rsp, getOfficialTopFollowUsersResult.rsp)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isSucceed;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int a16 = ((((r06 * 31) + androidx.fragment.app.a.a(this.code)) * 31) + this.msg.hashCode()) * 31;
            FeedCloudOfficialaccount$OfficialTopFollowUsersRsp feedCloudOfficialaccount$OfficialTopFollowUsersRsp = this.rsp;
            if (feedCloudOfficialaccount$OfficialTopFollowUsersRsp == null) {
                hashCode = 0;
            } else {
                hashCode = feedCloudOfficialaccount$OfficialTopFollowUsersRsp.hashCode();
            }
            return a16 + hashCode;
        }

        @NotNull
        public String toString() {
            return "GetOfficialTopFollowUsersResult(isSucceed=" + this.isSucceed + ", code=" + this.code + ", msg=" + this.msg + ", rsp=" + this.rsp + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(final QFSPublicAccountStaggeredRepo this$0, final List currentFeedIds, final String logTag, final int i3, final Function1 callback, BaseRequest baseRequest, final boolean z16, final long j3, final String str, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFeedIds, "$currentFeedIds");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.j
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.C(obj, this$0, currentFeedIds, z16, j3, str, logTag, i3, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Object obj, QFSPublicAccountStaggeredRepo this$0, List currentFeedIds, boolean z16, long j3, String errorMsg, String logTag, int i3, final Function1 callback) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp;
        boolean z17;
        int i16;
        boolean z18;
        String str;
        List<FeedCloudMeta$StFeed> list;
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        List<FeedCloudMeta$StFeed> list2;
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField2;
        PBStringField pBStringField;
        PBUInt32Field pBUInt32Field;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentFeedIds, "$currentFeedIds");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Integer num = null;
        if (obj instanceof FeedCloudRead$StGetFeedListRsp) {
            feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj;
        } else {
            feedCloudRead$StGetFeedListRsp = null;
        }
        List<e30.b> N = this$0.N(feedCloudRead$StGetFeedListRsp, currentFeedIds);
        w20.a.j().initOrUpdateGlobalState((List) N, true);
        if (z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
        if (feedCloudRead$StGetFeedListRsp != null && (pBUInt32Field = feedCloudRead$StGetFeedListRsp.isFinish) != null) {
            i16 = pBUInt32Field.get();
        } else {
            i16 = 0;
        }
        if (i16 > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (feedCloudRead$StGetFeedListRsp != null && (pBStringField = feedCloudRead$StGetFeedListRsp.feedAttchInfo) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        final GetFeedResult getFeedResult = new GetFeedResult(z17, isProtocolCache, z18, str, j3, errorMsg, N);
        QCirclePushInfoManager e16 = QCirclePushInfoManager.e();
        if (feedCloudRead$StGetFeedListRsp != null && (pBRepeatMessageField2 = feedCloudRead$StGetFeedListRsp.vecFeed) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        e16.j(list);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.D(Function1.this, getFeedResult);
            }
        });
        if (feedCloudRead$StGetFeedListRsp != null && (pBRepeatMessageField = feedCloudRead$StGetFeedListRsp.vecFeed) != null && (list2 = pBRepeatMessageField.get()) != null) {
            num = Integer.valueOf(list2.size());
        }
        QLog.i(logTag, 1, "requestForceInsert response, source=" + i3 + " rspSize=" + num + " dataSize=" + N.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 callback, GetFeedResult getFeedResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(getFeedResult, "$getFeedResult");
        callback.invoke(getFeedResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final String logTag, final Function1 callback, final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final Object obj) {
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.q
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.G(obj, logTag, z16, j3, str, baseRequest, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Object obj, String logTag, boolean z16, long j3, String errorMsg, BaseRequest baseRequest, final Function1 callback) {
        FeedCloudOfficialaccount$OfficialTopFollowUsersRsp feedCloudOfficialaccount$OfficialTopFollowUsersRsp;
        Integer num;
        PBRepeatMessageField<FeedCloudOfficialaccount$TopUserDetail> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        String str = null;
        if (obj instanceof FeedCloudOfficialaccount$OfficialTopFollowUsersRsp) {
            feedCloudOfficialaccount$OfficialTopFollowUsersRsp = (FeedCloudOfficialaccount$OfficialTopFollowUsersRsp) obj;
        } else {
            feedCloudOfficialaccount$OfficialTopFollowUsersRsp = null;
        }
        if (feedCloudOfficialaccount$OfficialTopFollowUsersRsp != null && (pBRepeatMessageField = feedCloudOfficialaccount$OfficialTopFollowUsersRsp.users_detail) != null) {
            num = Integer.valueOf(pBRepeatMessageField.size());
        } else {
            num = null;
        }
        if (baseRequest != null) {
            str = baseRequest.getTraceId();
        }
        QLog.i(logTag, 1, "requestOfficialTopFollowUsers response, isSucceed=" + z16 + " retCode=" + j3 + " errorMsg=" + errorMsg + " dataSize=" + num + " traceId=" + str);
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        final GetOfficialTopFollowUsersResult getOfficialTopFollowUsersResult = new GetOfficialTopFollowUsersResult(z16, j3, errorMsg, feedCloudOfficialaccount$OfficialTopFollowUsersRsp);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.f
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.H(Function1.this, getOfficialTopFollowUsersResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 callback, GetOfficialTopFollowUsersResult officialTopFollowUsersResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(officialTopFollowUsersResult, "$officialTopFollowUsersResult");
        callback.invoke(officialTopFollowUsersResult);
    }

    public static /* synthetic */ void J(QFSPublicAccountStaggeredRepo qFSPublicAccountStaggeredRepo, byte[] bArr, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = null;
        }
        qFSPublicAccountStaggeredRepo.I(bArr, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final QFSPublicAccountStaggeredRepo this$0, final byte[] bArr, final Function1 callback, final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.L(obj, this$0, z16, j3, str, baseRequest, bArr, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Object obj, QFSPublicAccountStaggeredRepo this$0, boolean z16, long j3, String errorMsg, BaseRequest baseRequest, byte[] bArr, final Function1 callback) {
        FeedCloudRead$StPrePullOfficialAccountOverlayADRsp feedCloudRead$StPrePullOfficialAccountOverlayADRsp;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (obj instanceof FeedCloudRead$StPrePullOfficialAccountOverlayADRsp) {
            feedCloudRead$StPrePullOfficialAccountOverlayADRsp = (FeedCloudRead$StPrePullOfficialAccountOverlayADRsp) obj;
        } else {
            feedCloudRead$StPrePullOfficialAccountOverlayADRsp = null;
        }
        JSONObject v3 = this$0.v(feedCloudRead$StPrePullOfficialAccountOverlayADRsp);
        v3.put("update_time", System.currentTimeMillis());
        if (z16 && j3 == 0 && feedCloudRead$StPrePullOfficialAccountOverlayADRsp != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        final GetAdMaskTaskInfoResult getAdMaskTaskInfoResult = new GetAdMaskTaskInfoResult(z17, isProtocolCache, j3, errorMsg, v3);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.e
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.M(Function1.this, getAdMaskTaskInfoResult);
            }
        });
        QLog.i("QFSPublicAccountStaggeredRepo", 1, "requestXingHuanAdMask response, result=" + getAdMaskTaskInfoResult + ", maskTaskInfoJson=" + v3);
        an.e(baseRequest, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 callback, GetAdMaskTaskInfoResult getMaskTaskInfoResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(getMaskTaskInfoResult, "$getMaskTaskInfoResult");
        callback.invoke(getMaskTaskInfoResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x002b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<e30.b> N(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, List<String> list) {
        List<FeedCloudMeta$StFeed> list2;
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        Object obj;
        PBStringField pBStringField;
        List<e30.b> emptyList;
        if (feedCloudRead$StGetFeedListRsp == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField = feedCloudRead$StGetFeedListRsp.vecFeed;
        if (pBRepeatMessageField != null) {
            list2 = pBRepeatMessageField.get();
        } else {
            list2 = null;
        }
        ArrayList<e30.b> b16 = e30.d.b(list2);
        Intrinsics.checkNotNullExpressionValue(b16, "transFormFeedListToBlockList(this.vecFeed?.get())");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : b16) {
            e30.b bVar = (e30.b) obj2;
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (g16 != null && (pBStringField = g16.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            boolean z19 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            FeedCloudMeta$StFeed sourceData = bVar.g();
            if (sourceData != null) {
                Intrinsics.checkNotNullExpressionValue(sourceData, "sourceData");
                if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.e(sourceData)) {
                    z17 = true;
                    if (!z17) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (Intrinsics.areEqual((String) obj, str)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        if (obj != null) {
                            z18 = true;
                            if (!z16 && !z18) {
                                z19 = true;
                            }
                            if (!z19) {
                                FeedCloudMeta$StFeed g17 = bVar.g();
                                Intrinsics.checkNotNullExpressionValue(g17, "feed.sourceData");
                                QLog.i("QFSPublicAccountStaggeredRepo", 1, "filter an invalid feed, isFeedIdEmpty=" + z16 + " isAdCard=" + z17 + " isFeedDuplicated=" + z18 + " feed=" + P(g17));
                            }
                            if (z19) {
                                arrayList.add(obj2);
                            }
                        }
                    }
                    z18 = false;
                    if (!z16) {
                        z19 = true;
                    }
                    if (!z19) {
                    }
                    if (z19) {
                    }
                }
            }
            z17 = false;
            if (!z17) {
            }
            z18 = false;
            if (!z16) {
            }
            if (!z19) {
            }
            if (z19) {
            }
        }
        ArrayList<FeedCloudMeta$StFeed> arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            FeedCloudMeta$StFeed g18 = ((e30.b) it5.next()).g();
            if (g18 != null) {
                arrayList2.add(g18);
            }
        }
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : arrayList2) {
            int authType = QCirclePluginUtil.getAuthType(feedCloudMeta$StFeed.poster.get());
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("authType");
            feedCloudCommon$Entry.value.set(String.valueOf(authType));
            feedCloudMeta$StFeed.extInfo.add(feedCloudCommon$Entry);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List O(QFSPublicAccountStaggeredRepo qFSPublicAccountStaggeredRepo, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        return qFSPublicAccountStaggeredRepo.N(feedCloudRead$StGetFeedListRsp, list);
    }

    private final String P(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.i(feedCloudMeta$StFeed) + ", sealData=" + com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.a(feedCloudMeta$StFeed) + ", shouldShowLike=" + com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.h(feedCloudMeta$StFeed) + "}";
    }

    private final void p(QCircleInitBean initBean, FeedCloudRead$StGetFeedListRsp lastFeedRsp) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        Object obj;
        PBStringField pBStringField;
        if (lastFeedRsp == null) {
            return;
        }
        String str = null;
        if (initBean != null) {
            feedCloudMeta$StFeed = initBean.getFeed();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        List<FeedCloudMeta$StFeed> list = lastFeedRsp.vecFeed.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.vecFeed.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                FeedCloudMeta$StFeed it5 = (FeedCloudMeta$StFeed) obj;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (!com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.e(it5)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) obj;
        String str2 = feedCloudMeta$StFeed.f398449id.get();
        if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
            str = pBStringField.get();
        }
        QLog.i("QFSPublicAccountStaggeredRepo", 1, "addPreloadFeed preload feed id =" + str2 + " first feed =" + str);
        if (feedCloudMeta$StFeed2 == null || !Intrinsics.areEqual(feedCloudMeta$StFeed2.f398449id.get(), initBean.getFeed().f398449id.get())) {
            List<FeedCloudMeta$StFeed> list2 = lastFeedRsp.vecFeed.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.vecFeed.get()");
            Iterator<FeedCloudMeta$StFeed> it6 = list2.iterator();
            int i3 = 0;
            while (true) {
                if (it6.hasNext()) {
                    FeedCloudMeta$StFeed it7 = it6.next();
                    Intrinsics.checkNotNullExpressionValue(it7, "it");
                    if (!com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.e(it7)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            lastFeedRsp.vecFeed.get().add(Math.max(i3, 0), feedCloudMeta$StFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QCircleInitBean initBean, FeedCloudRead$StGetFeedListRsp rsp) {
        String str;
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        c a16 = c.INSTANCE.a(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.c(initBean));
        FeedCloudMeta$StFeed feed = initBean.getFeed();
        if (feed != null) {
            str = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.c(feed);
        } else {
            str = null;
        }
        a16.c(rsp, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(QCircleInitBean qCircleInitBean, QFSPublicAccountStaggeredRepo this$0, final Function1 callback) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        FeedCloudRead$StGetFeedListRsp d16 = c.INSTANCE.a(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.c(qCircleInitBean)).d();
        this$0.p(qCircleInitBean, d16);
        final String str = null;
        final List O = O(this$0, d16, null, 1, null);
        if (d16 != null && (pBStringField = d16.feedAttchInfo) != null) {
            str = pBStringField.get();
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.p
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.u(str, O, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String str, List dataList, Function1 callback) {
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        GetFeedResult getFeedResult = new GetFeedResult(true, true, false, str, 0L, "", dataList);
        QLog.i("QFSPublicAccountStaggeredRepo", 1, "fetchLastCached response, result=" + getFeedResult + ", size=" + dataList.size());
        callback.invoke(getFeedResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0016 A[Catch: JSONException -> 0x0011, TryCatch #0 {JSONException -> 0x0011, blocks: (B:10:0x0002, B:12:0x0006, B:14:0x000c, B:4:0x0016, B:7:0x001c), top: B:9:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[Catch: JSONException -> 0x0011, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0011, blocks: (B:10:0x0002, B:12:0x0006, B:14:0x000c, B:4:0x0016, B:7:0x001c), top: B:9:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject v(FeedCloudRead$StPrePullOfficialAccountOverlayADRsp rsp) {
        ByteStringMicro byteStringMicro;
        byte[] byteArray;
        if (rsp != null) {
            try {
                PBBytesField pBBytesField = rsp.overLayADBytes;
                if (pBBytesField != null && (byteStringMicro = pBBytesField.get()) != null) {
                    byteArray = byteStringMicro.toByteArray();
                    if (byteArray != null) {
                        return new JSONObject();
                    }
                    return new JSONObject(new String(byteArray, Charsets.UTF_8));
                }
            } catch (JSONException e16) {
                QLog.e("QFSPublicAccountStaggeredRepo", 1, "getOverLayADDataJson parse error, e=" + e16.getMessage() + ", e");
                return new JSONObject();
            }
        }
        byteArray = null;
        if (byteArray != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final QFSPublicAccountStaggeredRepo this$0, final List list, final boolean z16, final int i3, final RequestType requestType, final byte[] bArr, final Function1 callback, final QCircleInitBean initBean, final BaseRequest baseRequest, final boolean z17, final long j3, final String str, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestType, "$requestType");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.y(obj, this$0, list, z17, j3, str, z16, i3, requestType, baseRequest, bArr, callback, initBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Object obj, QFSPublicAccountStaggeredRepo this$0, List list, boolean z16, long j3, String errorMsg, boolean z17, int i3, RequestType requestType, BaseRequest baseRequest, byte[] bArr, final Function1 callback, QCircleInitBean initBean) {
        List list2;
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp;
        StringBuilder appendln;
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        List<FeedCloudMeta$StFeed> list3;
        PBStringField pBStringField;
        PBUInt32Field pBUInt32Field;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestType, "$requestType");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        if (obj instanceof FeedCloudRead$StGetFeedListRsp) {
            feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj;
            list2 = list;
        } else {
            list2 = list;
            feedCloudRead$StGetFeedListRsp = null;
        }
        List<e30.b> N = this$0.N(feedCloudRead$StGetFeedListRsp, list2);
        w20.a.j().initOrUpdateGlobalState((List) N, true);
        int i16 = 0;
        boolean z18 = z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null;
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
        boolean z19 = ((feedCloudRead$StGetFeedListRsp == null || (pBUInt32Field = feedCloudRead$StGetFeedListRsp.isFinish) == null) ? 0 : pBUInt32Field.get()) > 0;
        String str = (feedCloudRead$StGetFeedListRsp == null || (pBStringField = feedCloudRead$StGetFeedListRsp.feedAttchInfo) == null) ? null : pBStringField.get();
        Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
        final GetFeedResult getFeedResult = new GetFeedResult(z18, isProtocolCache, z19, str, j3, errorMsg, N);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.z(Function1.this, getFeedResult);
            }
        });
        if (z17 && (!N.isEmpty()) && feedCloudRead$StGetFeedListRsp != null) {
            this$0.q(feedCloudRead$StGetFeedListRsp, initBean);
        }
        this$0.Q(feedCloudRead$StGetFeedListRsp);
        Integer valueOf = (feedCloudRead$StGetFeedListRsp == null || (pBRepeatMessageField = feedCloudRead$StGetFeedListRsp.vecFeed) == null || (list3 = pBRepeatMessageField.get()) == null) ? null : Integer.valueOf(list3.size());
        QLog.i("QFSPublicAccountStaggeredRepo", 1, "requestFeed(" + i3 + ") <-- requestType=" + requestType + ", result=" + getFeedResult + ", rspSize=" + valueOf + " dataSize=" + N.size());
        an.e(baseRequest, bArr);
        if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = N.iterator();
        while (true) {
            int i17 = i16;
            if (it.hasNext()) {
                Object next = it.next();
                i16 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                FeedCloudMeta$StFeed g16 = ((e30.b) next).g();
                Intrinsics.checkNotNullExpressionValue(g16, "feedBlockData.sourceData");
                String P = this$0.P(g16);
                appendln = StringsKt__StringBuilderJVMKt.appendln(sb5);
                appendln.append(i17 + MsgSummary.STR_COLON);
                appendln.append(P);
            } else {
                QLog.i("QFSPublicAccountStaggeredRepo", 2, "dataList result=" + ((Object) sb5));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 callback, GetFeedResult getFeedResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(getFeedResult, "$getFeedResult");
        callback.invoke(getFeedResult);
    }

    public final void A(@NotNull FeedCloudMeta$StFeed feed, final int source, int action, @NotNull final List<String> currentFeedIds, @NotNull final Function1<? super GetFeedResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(currentFeedIds, "currentFeedIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String str = "QFSPublicAccountPositiveAction_Repo";
        GetForceInsertListReq getForceInsertListReq = new GetForceInsertListReq(source, feed, action);
        QLog.i("QFSPublicAccountPositiveAction_Repo", 1, "requestForceInsert feed=" + feed.f398449id.get() + " source=" + source + " action=" + action);
        VSNetworkHelper.getInstance().sendRequest(getForceInsertListReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QFSPublicAccountStaggeredRepo.B(QFSPublicAccountStaggeredRepo.this, currentFeedIds, str, source, callback, baseRequest, z16, j3, str2, obj);
            }
        });
    }

    public final void E(@NotNull final Function1<? super GetOfficialTopFollowUsersResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GetOfficialTopFollowUsersReq getOfficialTopFollowUsersReq = new GetOfficialTopFollowUsersReq();
        final String str = "QFSPublicAccountStaggeredRepo_Repo";
        QLog.i("QFSPublicAccountStaggeredRepo_Repo", 1, "requestOfficialTopFollowUsers");
        VSNetworkHelper.getInstance().sendRequest(getOfficialTopFollowUsersReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QFSPublicAccountStaggeredRepo.F(str, callback, baseRequest, z16, j3, str2, obj);
            }
        });
    }

    public final void I(@Nullable final byte[] transInfo, @NotNull final Function1<? super GetAdMaskTaskInfoResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GetPreloadXingHuanAdMaskReq getPreloadXingHuanAdMaskReq = new GetPreloadXingHuanAdMaskReq();
        QLog.i("QFSPublicAccountStaggeredRepo_Repo", 1, "requestXingHuanAdMask");
        VSNetworkHelper.getInstance().sendRequest(getPreloadXingHuanAdMaskReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSPublicAccountStaggeredRepo.K(QFSPublicAccountStaggeredRepo.this, transInfo, callback, baseRequest, z16, j3, str, obj);
            }
        });
    }

    public final void Q(@Nullable FeedCloudRead$StGetFeedListRsp rsp) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101455", false) && rsp != null) {
            uq3.c.d7(rsp.user.icon.iconUrl.get());
        }
    }

    public final void q(@NotNull final FeedCloudRead$StGetFeedListRsp rsp, @NotNull final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.r
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.r(QCircleInitBean.this, rsp);
            }
        });
    }

    public final void s(@Nullable final QCircleInitBean initBean, @NotNull final Function1<? super GetFeedResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.k
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredRepo.t(QCircleInitBean.this, this, callback);
            }
        });
    }

    public final void w(@NotNull final QCircleInitBean initBean, @Nullable String attachInfo, @NotNull final RequestType requestType, final boolean enableCacheResult, @Nullable final List<String> currentFeedIds, @Nullable final byte[] transInfo, @NotNull final Function1<? super GetFeedResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GetStaggeredListReq getStaggeredListReq = new GetStaggeredListReq(attachInfo, requestType, initBean, transInfo);
        final int hashCode = getStaggeredListReq.hashCode();
        QLog.i("QFSPublicAccountStaggeredRepo", 1, "requestFeed(" + hashCode + ") --> requestType=" + requestType + " enableCache=" + enableCacheResult + " attachInfo=" + attachInfo);
        VSNetworkHelper.getInstance().sendRequest(getStaggeredListReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.g
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSPublicAccountStaggeredRepo.x(QFSPublicAccountStaggeredRepo.this, currentFeedIds, enableCacheResult, hashCode, requestType, transInfo, callback, initBean, baseRequest, z16, j3, str, obj);
            }
        });
    }
}
