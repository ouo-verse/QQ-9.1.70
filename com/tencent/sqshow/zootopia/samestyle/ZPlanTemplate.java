package com.tencent.sqshow.zootopia.samestyle;

import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b-\b\u0086\b\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u00bf\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010*\u001a\u00020\n\u00a2\u0006\u0004\bW\u0010XJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\fH\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\nH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J\u00c1\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010%\u001a\u00020\f2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010*\u001a\u00020\nH\u00c6\u0001J\t\u0010,\u001a\u00020\u0004H\u00d6\u0001J\t\u0010-\u001a\u00020\u0002H\u00d6\u0001J\u0013\u00100\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.H\u00d6\u0003R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b7\u00106R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b8\u00106R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b9\u00106R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b:\u00103R\u0017\u0010 \u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b \u0010;\u001a\u0004\b \u0010<R\u0017\u0010!\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u00104\u001a\u0004\b@\u00106R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\bA\u00106R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010%\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010=\u001a\u0004\bE\u0010?R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bF\u0010DR\u0017\u0010'\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b'\u0010;\u001a\u0004\b'\u0010<R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u00104\u001a\u0004\bG\u00106R$\u0010)\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0017\u0010*\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b*\u0010;\u001a\u0004\b*\u0010<R\u0011\u0010M\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bM\u0010<R\u0011\u0010N\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010<R\u0011\u0010O\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bO\u0010<R\u0011\u0010P\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010<R\u0011\u0010R\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bQ\u00103R\u0011\u0010T\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010?R\u0011\u0010V\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010<\u00a8\u0006["}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "", "component7", "", "component8", "component9", "component10", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoClipInfo;", "component11", "component12", "component13", "component14", "component15", "Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;", "component16", "component17", "id", "name", CommonConstant.KEY_DISPLAY_NAME, "desc", "coverUrl", "contentType", "isNew", "count", "previewUrl", "downloadUrl", "videoClips", "timestamp", "playerGender", "isDowngrade", "templateId", "entranceInfo", "isWatermark", "copy", "toString", "hashCode", "", "other", "equals", "I", "getId", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getDisplayName", "getDesc", "getCoverUrl", "getContentType", "Z", "()Z", "J", "getCount", "()J", "getPreviewUrl", "getDownloadUrl", "Ljava/util/List;", "getVideoClips", "()Ljava/util/List;", "getTimestamp", "getPlayerGender", "getTemplateId", "Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;", "getEntranceInfo", "()Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;", "setEntranceInfo", "(Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "isAR", "isMixAR", "isMixWithVideo", "getClipCount", "clipCount", "getLength", "length", "getShowVideo", "showVideo", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/util/List;ZLjava/lang/String;Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;Z)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ZPlanTemplate implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final ZPlanTemplate f372824d = new ZPlanTemplate(0, null, null, null, null, 0, false, 0, null, null, null, 0, null, false, null, null, false, 131071, null);
    private final int contentType;
    private final long count;
    private final String coverUrl;
    private final String desc;
    private final String displayName;
    private final String downloadUrl;
    private ZplanEntranceInfo entranceInfo;
    private final int id;
    private final boolean isDowngrade;
    private final boolean isNew;
    private final boolean isWatermark;
    private final String name;
    private final List<Integer> playerGender;
    private final String previewUrl;
    private final String templateId;
    private final long timestamp;
    private final List<ZPlanVideoClipInfo> videoClips;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\b\u001a\u00020\u0007*\u00020\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate$a;", "", "Lnv4/g;", "rsp", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "a", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ZPlanTemplate> a(nv4.g rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            nv4.m[] mVarArr = rsp.f421403e;
            int length = mVarArr != null ? mVarArr.length : 0;
            QLog.i("ZPlanTemplate", 1, "template size = " + length);
            for (int i3 = 0; i3 < length; i3++) {
                nv4.m[] mVarArr2 = rsp.f421403e;
                nv4.m mVar = mVarArr2 != null ? mVarArr2[i3] : null;
                if (mVar != null) {
                    arrayList.add(rb4.a.a(mVar));
                }
            }
            return arrayList;
        }

        public final void b(ZPlanTemplate zPlanTemplate) {
            Intrinsics.checkNotNullParameter(zPlanTemplate, "<this>");
            nv4.j jVar = new nv4.j();
            jVar.f421408a = zPlanTemplate.getId();
            QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
            IZootopiaProxyServlet iZootopiaProxyServlet = (IZootopiaProxyServlet) api;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            byte[] byteArray = MessageNano.toByteArray(jVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(body)");
            IZootopiaProxyServlet.b.b(iZootopiaProxyServlet, (AppInterface) peekAppRuntime, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "ReportTemplate", byteArray, new LinkedHashMap(), new C9840a(), 0, 0, 192, null);
        }

        Companion() {
        }

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplate$a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9840a implements td3.a {
            C9840a() {
            }

            @Override // td3.a
            public void onReceive(byte[] data) {
            }

            @Override // td3.a
            public void a(Integer errCode, String errMsg) {
            }
        }
    }

    public ZPlanTemplate() {
        this(0, null, null, null, null, 0, false, 0L, null, null, null, 0L, null, false, null, null, false, 131071, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final List<ZPlanVideoClipInfo> component11() {
        return this.videoClips;
    }

    /* renamed from: component12, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final List<Integer> component13() {
        return this.playerGender;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsDowngrade() {
        return this.isDowngrade;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    /* renamed from: component16, reason: from getter */
    public final ZplanEntranceInfo getEntranceInfo() {
        return this.entranceInfo;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsWatermark() {
        return this.isWatermark;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCount() {
        return this.count;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final ZPlanTemplate copy(int id5, String name, String displayName, String desc, String coverUrl, int contentType, boolean isNew, long count, String previewUrl, String downloadUrl, List<ZPlanVideoClipInfo> videoClips, long timestamp, List<Integer> playerGender, boolean isDowngrade, String templateId, ZplanEntranceInfo entranceInfo, boolean isWatermark) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(previewUrl, "previewUrl");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(videoClips, "videoClips");
        Intrinsics.checkNotNullParameter(playerGender, "playerGender");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        return new ZPlanTemplate(id5, name, displayName, desc, coverUrl, contentType, isNew, count, previewUrl, downloadUrl, videoClips, timestamp, playerGender, isDowngrade, templateId, entranceInfo, isWatermark);
    }

    public final int getClipCount() {
        return this.videoClips.size();
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final long getCount() {
        return this.count;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final ZplanEntranceInfo getEntranceInfo() {
        return this.entranceInfo;
    }

    public final int getId() {
        return this.id;
    }

    public final long getLength() {
        int collectionSizeOrDefault;
        long sumOfLong;
        List<ZPlanVideoClipInfo> list = this.videoClips;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ZPlanVideoClipInfo) it.next()).getDuration()));
        }
        sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
        return sumOfLong;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getPlayerGender() {
        return this.playerGender;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final boolean getShowVideo() {
        return isVideo() || isAR() || this.contentType == 5;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final List<ZPlanVideoClipInfo> getVideoClips() {
        return this.videoClips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.contentType) * 31;
        boolean z16 = this.isNew;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int a16 = (((((((((((((hashCode + i3) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.count)) * 31) + this.previewUrl.hashCode()) * 31) + this.downloadUrl.hashCode()) * 31) + this.videoClips.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.timestamp)) * 31) + this.playerGender.hashCode()) * 31;
        boolean z17 = this.isDowngrade;
        int i16 = z17;
        if (z17 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((a16 + i16) * 31) + this.templateId.hashCode()) * 31;
        ZplanEntranceInfo zplanEntranceInfo = this.entranceInfo;
        int hashCode3 = (hashCode2 + (zplanEntranceInfo == null ? 0 : zplanEntranceInfo.hashCode())) * 31;
        boolean z18 = this.isWatermark;
        return hashCode3 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public final boolean isAR() {
        return this.contentType == 3;
    }

    public final boolean isDowngrade() {
        return this.isDowngrade;
    }

    public final boolean isMixAR() {
        int i3 = this.contentType;
        return (i3 == 5 || i3 == 4) && this.entranceInfo != null;
    }

    public final boolean isMixWithVideo() {
        return this.contentType == 5 && this.entranceInfo != null;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isVideo() {
        return this.contentType == 1;
    }

    public final boolean isWatermark() {
        return this.isWatermark;
    }

    public final void setEntranceInfo(ZplanEntranceInfo zplanEntranceInfo) {
        this.entranceInfo = zplanEntranceInfo;
    }

    public ZPlanTemplate(int i3, String name, String displayName, String desc, String coverUrl, int i16, boolean z16, long j3, String previewUrl, String downloadUrl, List<ZPlanVideoClipInfo> videoClips, long j16, List<Integer> playerGender, boolean z17, String templateId, ZplanEntranceInfo zplanEntranceInfo, boolean z18) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(previewUrl, "previewUrl");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(videoClips, "videoClips");
        Intrinsics.checkNotNullParameter(playerGender, "playerGender");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        this.id = i3;
        this.name = name;
        this.displayName = displayName;
        this.desc = desc;
        this.coverUrl = coverUrl;
        this.contentType = i16;
        this.isNew = z16;
        this.count = j3;
        this.previewUrl = previewUrl;
        this.downloadUrl = downloadUrl;
        this.videoClips = videoClips;
        this.timestamp = j16;
        this.playerGender = playerGender;
        this.isDowngrade = z17;
        this.templateId = templateId;
        this.entranceInfo = zplanEntranceInfo;
        this.isWatermark = z18;
    }

    public String toString() {
        return "ZPlanTemplate(id=" + this.id + ", name=" + this.name + ", displayName=" + this.displayName + ", desc=" + this.desc + ", coverUrl=" + this.coverUrl + ", contentType=" + this.contentType + ", isNew=" + this.isNew + ", count=" + this.count + ", previewUrl=" + this.previewUrl + ", downloadUrl=" + this.downloadUrl + ", videoClips=" + this.videoClips + ", timestamp=" + this.timestamp + ", playerGender=" + this.playerGender + ", isDowngrade=" + this.isDowngrade + ", templateId=" + this.templateId + ", entranceInfo=" + this.entranceInfo + ", isWatermark=" + this.isWatermark + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTemplate)) {
            return false;
        }
        ZPlanTemplate zPlanTemplate = (ZPlanTemplate) other;
        return this.id == zPlanTemplate.id && Intrinsics.areEqual(this.name, zPlanTemplate.name) && Intrinsics.areEqual(this.displayName, zPlanTemplate.displayName) && Intrinsics.areEqual(this.desc, zPlanTemplate.desc) && Intrinsics.areEqual(this.coverUrl, zPlanTemplate.coverUrl) && this.contentType == zPlanTemplate.contentType && this.isNew == zPlanTemplate.isNew && this.count == zPlanTemplate.count && Intrinsics.areEqual(this.previewUrl, zPlanTemplate.previewUrl) && Intrinsics.areEqual(this.downloadUrl, zPlanTemplate.downloadUrl) && Intrinsics.areEqual(this.videoClips, zPlanTemplate.videoClips) && this.timestamp == zPlanTemplate.timestamp && Intrinsics.areEqual(this.playerGender, zPlanTemplate.playerGender) && this.isDowngrade == zPlanTemplate.isDowngrade && Intrinsics.areEqual(this.templateId, zPlanTemplate.templateId) && Intrinsics.areEqual(this.entranceInfo, zPlanTemplate.entranceInfo) && this.isWatermark == zPlanTemplate.isWatermark;
    }

    public /* synthetic */ ZPlanTemplate(int i3, String str, String str2, String str3, String str4, int i16, boolean z16, long j3, String str5, String str6, List list, long j16, List list2, boolean z17, String str7, ZplanEntranceInfo zplanEntranceInfo, boolean z18, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? "" : str4, (i17 & 32) != 0 ? 0 : i16, (i17 & 64) != 0 ? false : z16, (i17 & 128) != 0 ? 0L : j3, (i17 & 256) != 0 ? "" : str5, (i17 & 512) != 0 ? "" : str6, (i17 & 1024) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 2048) != 0 ? 0L : j16, (i17 & 4096) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i17 & 8192) != 0 ? false : z17, (i17 & 16384) != 0 ? "" : str7, (i17 & 32768) != 0 ? null : zplanEntranceInfo, (i17 & 65536) != 0 ? false : z18);
    }
}
